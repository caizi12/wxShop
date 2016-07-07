package ngves.asiainfo.core.rushbuy.dao.impl;

import ngves.asiainfo.CommnException;
import ngves.asiainfo.core.rushbuy.RushBuyConstant;
import ngves.asiainfo.core.rushbuy.bo.ActivityLimitEngine;
import ngves.asiainfo.core.rushbuy.bo.ActivityLimitGroupEngine;
import ngves.asiainfo.core.rushbuy.bo.QBOFinishedActivityLimitGroupEngine;
import ngves.asiainfo.core.rushbuy.dao.interfaces.IActivityLimitGroupDAO;
import ngves.asiainfo.core.rushbuy.ivalues.IActivityLimitGroupValue;
import ngves.asiainfo.core.rushbuy.ivalues.IActivityLimitValue;
import ngves.asiainfo.core.rushbuy.ivalues.IQBOFinishedActivityLimitGroupValue;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

public class ActivityLimitGroupDAOImpl implements IActivityLimitGroupDAO {
    public IActivityLimitGroupValue findById(Long id) throws Exception {
        return ActivityLimitGroupEngine.getBean(id);
    }

    public long create(IActivityLimitGroupValue activityLimitGroupValue) throws Exception {
        if(isTitleConflict(activityLimitGroupValue.getAlGroupTitle())){
            throw new CommnException("已经有同名的限时抢兑活动分组存在！");
        }
        activityLimitGroupValue.setStsToNew();
        long newId = ActivityLimitGroupEngine.getNewId().longValue();
        activityLimitGroupValue.setAlGroupId(newId);
        activityLimitGroupValue.setAlGroupCreate(DateTimeUtil.getNowTimeStamp());
        ActivityLimitGroupEngine.save(activityLimitGroupValue);
        return newId;
    }

    public long update(IActivityLimitGroupValue activityLimitGroupValue) throws Exception {
        if(isTitleConflict(activityLimitGroupValue.getAlGroupTitle(), activityLimitGroupValue.getAlGroupId())){
            throw new CommnException("已经有同名的限时抢兑活动分组存在！");
        }
        ActivityLimitGroupEngine.save(activityLimitGroupValue);
        return activityLimitGroupValue.getAlGroupId();
    }

    public boolean remove(long groupId) throws Exception {
        StringBuffer condition = new StringBuffer();
        Map<String, Object> params = new HashMap<String, Object>();
        condition.append(IActivityLimitValue.S_AlGroupId).
                append(" = :").
                append(IActivityLimitValue.S_AlGroupId);
        params.put("AL_GROUP_ID", groupId + "");

        int activityCount = ActivityLimitEngine.getBeansCount(condition.toString(), params);

        if(activityCount > 0){
              return false;
        }

        IActivityLimitGroupValue group = ActivityLimitGroupEngine.getBean(groupId);

        group.delete();
        ActivityLimitGroupEngine.save(group);
        return true;
    }

    @SuppressWarnings("unchecked")
    public IActivityLimitGroupValue[] query(String condition, Map params, int startIndex, int endIndex) throws Exception {
        return ActivityLimitGroupEngine.getBeans(null, condition, params, startIndex, endIndex, false);
    }

    public IActivityLimitGroupValue[] findAllByTitle(String title, int startIndex, int endIndex) throws Exception {
        StringBuffer sql = new StringBuffer();
        Map<String, String> params = new HashMap<String, String>();

        if (!StringUtil.isBlank(title)) {
            title = title.trim();
            sql.append(IActivityLimitGroupValue.S_AlGroupTitle)
                    .append(" LIKE :")
                    .append(IActivityLimitGroupValue.S_AlGroupTitle)
                    .append(" ");
            params.put(IActivityLimitGroupValue.S_AlGroupTitle, "%" + title + "%");
        }
        return ActivityLimitGroupEngine.getBeans(null, sql.toString(), params, startIndex, endIndex, false);
    }

    public int countByTitle(String title) throws Exception {
        StringBuffer sql = new StringBuffer();
        Map<String, String> params = new HashMap<String, String>();

        if (!StringUtil.isBlank(title)) {
            title = title.trim();
            sql.append(IActivityLimitGroupValue.S_AlGroupTitle)
                    .append(" LIKE :")
                    .append(IActivityLimitGroupValue.S_AlGroupTitle)
                    .append(" ");
            params.put(IActivityLimitGroupValue.S_AlGroupTitle, "%" + title + "%");
        }
        return ActivityLimitGroupEngine.getBeansCount(sql.toString(), params);
    }

    @SuppressWarnings("unchecked")
    public IQBOFinishedActivityLimitGroupValue[] findAllFinishedActivityLimitGroups() throws Exception {
        return QBOFinishedActivityLimitGroupEngine.getBeans("", new HashMap());
    }

    public IActivityLimitValue[] findAllFinishedActivityInGroup(long groupId) throws Exception {
        StringBuffer condition = new StringBuffer();
        Map<String, Object> params = new HashMap<String, Object>();
        condition.append(IActivityLimitValue.S_AlGroupId).
                append(" = :").
                append(IActivityLimitValue.S_AlGroupId);
        params.put("AL_GROUP_ID", groupId + "");

        condition.append(" AND (").
                append(IActivityLimitValue.S_ActivityState).
                append(" = '").append(RushBuyConstant.ACTIVITY_LIMIT_STATUS_PUBLIC).
                append("' OR ").
                append(IActivityLimitValue.S_ActivityState).
                append(" = '").
                append(RushBuyConstant.ACTIVITY_LIMIT_STATUS_STOP).
                append("' )");
        condition.append(" AND (").
                append(IActivityLimitValue.S_IsView).
                append(" IS NULL OR ").
                append(IActivityLimitValue.S_IsView).
                append(" != :").
                append(ngves.asiainfo.core.rushbuy.ivalues.IActivityLimitValue.S_IsView).
                append(")");
        params.put(IActivityLimitValue.S_IsView, RushBuyConstant.ACTIVITY_LIMIT_IS_VIEW_NO);

        condition.append(" AND ").
                append(IActivityLimitValue.S_ActivityEndTime).
                append(" < SYSDATE");

        condition.append(" order by ").append(IActivityLimitValue.S_ActivityEndTime).append(" DESC");

        String[] cols = new String[]{IActivityLimitValue.S_ActivityId,
                IActivityLimitValue.S_ActivityName,
                IActivityLimitValue.S_ActivityStartTime,
                IActivityLimitValue.S_ActivityEndTime,
                IActivityLimitValue.S_ActivityState,
                IActivityLimitValue.S_ActivityUrl
        };

        return ActivityLimitEngine.getBeans(cols, condition.toString(), params, -1, -1, false);
    }
    
    public IActivityLimitGroupValue[] findAllActivityGroup() throws Exception {
    	return ActivityLimitGroupEngine.getBeans(null, null);
    }

    private boolean isTitleConflict(String title)throws Exception{
        Map<String, String> params = new HashMap<String, String>();
        StringBuffer sql = new StringBuffer();
        sql.append(IActivityLimitGroupValue.S_AlGroupTitle + " = :" + IActivityLimitGroupValue.S_AlGroupTitle);
        params.put(IActivityLimitGroupValue.S_AlGroupTitle, title);

        IActivityLimitGroupValue[] values = ActivityLimitGroupEngine.getBeans(sql.toString(), params);
        return values.length > 0;
    }

    private boolean isTitleConflict(String title, long excludeGroupId)throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        sql.append(IActivityLimitGroupValue.S_AlGroupTitle + " = :" + IActivityLimitGroupValue.S_AlGroupTitle);
        params.put(IActivityLimitGroupValue.S_AlGroupTitle, title);
        sql.append(" AND ").
                append(IActivityLimitGroupValue.S_AlGroupId).append(" != :").
                append(IActivityLimitGroupValue.S_AlGroupId);
        params.put(IActivityLimitGroupValue.S_AlGroupId, excludeGroupId);
        IActivityLimitGroupValue[] values = ActivityLimitGroupEngine.getBeans(sql.toString(), params);
        return values.length > 0;
    }
}
