package ngves.asiainfo.core.rushbuy.service.impl;

import ngves.asiainfo.core.rushbuy.RushBuyConstant;
import ngves.asiainfo.core.rushbuy.dao.interfaces.IActivityLimitGroupDAO;
import ngves.asiainfo.core.rushbuy.ivalues.IActivityLimitGroupValue;
import ngves.asiainfo.core.rushbuy.ivalues.IActivityLimitValue;
import ngves.asiainfo.core.rushbuy.ivalues.IQBOFinishedActivityLimitGroupValue;
import ngves.asiainfo.core.rushbuy.service.interfaces.IActivityLimitGroupSrv;

import java.util.Map;

public class ActivityLimitGroupSrvImpl implements IActivityLimitGroupSrv {
    private IActivityLimitGroupDAO activityLimitGroupDAO;

    public void setActivityLimitGroupDAO(IActivityLimitGroupDAO activityLimitGroupDAO) {
        this.activityLimitGroupDAO = activityLimitGroupDAO;
    }

    public IActivityLimitGroupValue findById(Long id) throws Exception {
        return activityLimitGroupDAO.findById(id);
    }

    public long create(IActivityLimitGroupValue activityLimitGroupValue) throws Exception {
        return activityLimitGroupDAO.create(activityLimitGroupValue);
    }

    public long update(IActivityLimitGroupValue activityLimitGroupValue) throws Exception {
        return activityLimitGroupDAO.update(activityLimitGroupValue);
    }

    public boolean remove(long groupId) throws Exception {
        return activityLimitGroupDAO.remove(groupId);
    }

    @SuppressWarnings("unchecked")
	public IActivityLimitGroupValue[] query(String condition, Map params, int startIndex, int endIndex) throws Exception {
        IActivityLimitGroupValue[] groups = activityLimitGroupDAO.query(condition, params, startIndex, endIndex);
        fillHTMLOperationField(groups);
        return groups;
    }

    public IActivityLimitGroupValue[] findAllByTitle(String title, int startIndex, int endIndex) throws Exception {
        IActivityLimitGroupValue[] groups = activityLimitGroupDAO.findAllByTitle(title, startIndex, endIndex);
         fillHTMLOperationField(groups);
        return groups;
    }

    public int countByTitle(String title) throws Exception {
        return activityLimitGroupDAO.countByTitle(title);
    }

    public IQBOFinishedActivityLimitGroupValue[] findAllFinishedActivityLimitGroups() throws Exception {
        IQBOFinishedActivityLimitGroupValue[] groups = activityLimitGroupDAO.findAllFinishedActivityLimitGroups();
        return groups;
    }

    /**
     * 得到指定分组下的已结束的抢兑活动列表
     */
    public IActivityLimitValue[] findAllFinishedActivityInGroup(long groupId) throws Exception {
        return activityLimitGroupDAO.findAllFinishedActivityInGroup(groupId);
    }
    
    public IActivityLimitGroupValue[] findAllActivityGroup() throws Exception {
    	return activityLimitGroupDAO.findAllActivityGroup();
    }

    private IActivityLimitGroupValue[] fillHTMLOperationField(IActivityLimitGroupValue[] groups){
        for(IActivityLimitGroupValue group: groups){
            StringBuffer sb = new StringBuffer();
            sb.append(String.format(RushBuyConstant.MODIFY_GROUP_LINK, group.getAlGroupId())).
                    append(" ").
                    append(String.format(RushBuyConstant.DELETE_GROUP_LINK, group.getAlGroupId()));
            group.setBakCol(sb.toString());
        }
        return groups;
    }
}
