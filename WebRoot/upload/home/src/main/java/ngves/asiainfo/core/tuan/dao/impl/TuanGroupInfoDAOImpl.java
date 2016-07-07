package ngves.asiainfo.core.tuan.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.CommnException;
import ngves.asiainfo.core.tuan.bo.TuanGroupInfoEngine;
import ngves.asiainfo.core.tuan.dao.interfaces.ITuanGroupInfoDAO;
import ngves.asiainfo.core.tuan.ivalues.ITuanGroupInfoValue;
import ngves.asiainfo.util.StringUtil;

/**
 *
 */
public class TuanGroupInfoDAOImpl implements ITuanGroupInfoDAO {

	//添加
	public long addTuanGroup(ITuanGroupInfoValue tuanGroupValue) throws Exception {
		if(isTitleConflict(tuanGroupValue.getGroupName())){
            throw new CommnException("已经有同名的限时抢兑活动分组存在！");
        }
		tuanGroupValue.setStsToNew();
        long newId = TuanGroupInfoEngine.getNewId().longValue();
        tuanGroupValue.setTuanGroupId(newId);
        tuanGroupValue.setGroupCode("");
        tuanGroupValue.setIsIndexDisplay("1");
        
        TuanGroupInfoEngine.save(tuanGroupValue);
        return newId;
	}

	public int countByTitle(String groupType, String groupName) throws Exception {
		StringBuffer sql = new StringBuffer();
		Map<String, String> params = new HashMap<String, String>();

		// 分组类别
		sql.append(ITuanGroupInfoValue.S_GroupType).append(" = :").append(ITuanGroupInfoValue.S_GroupType).append(" ");
		params.put(ITuanGroupInfoValue.S_GroupType, groupType.trim());
		// 分组名称
		if (!StringUtil.isBlank(groupName)) {
			groupName = groupName.trim();
			sql.append(" and " + ITuanGroupInfoValue.S_GroupName).append(" LIKE :").append(
					ITuanGroupInfoValue.S_GroupName).append(" ");
			params.put(ITuanGroupInfoValue.S_GroupName, "%" + groupName + "%");
		}
		return TuanGroupInfoEngine.getBeansCount(sql.toString(), params);
	}

	public ITuanGroupInfoValue[] findAllByTitle(String groupType, String groupName, int startIndex, int endIndex)
			throws Exception {
		StringBuffer sql = new StringBuffer();
		Map<String, String> params = new HashMap<String, String>();
		// 分组类别
		sql.append(ITuanGroupInfoValue.S_GroupType).append(" = :").append(ITuanGroupInfoValue.S_GroupType).append(" ");
		params.put(ITuanGroupInfoValue.S_GroupType, groupType.trim());
		// 分组名称
		if (!StringUtil.isBlank(groupName)) {
			groupName = groupName.trim();
			sql.append(" and " + ITuanGroupInfoValue.S_GroupName).append(" LIKE :").append(ITuanGroupInfoValue.S_GroupName)
					.append(" ");
			params.put(ITuanGroupInfoValue.S_GroupName, "%" + groupName + "%");
		}
		return TuanGroupInfoEngine.getBeans(null, sql.toString(), params, startIndex, endIndex, false);
	}

	public ITuanGroupInfoValue[] findAlltuanGroup() throws Exception {
		
		return TuanGroupInfoEngine.getBeans(null,null);
	}

	public ITuanGroupInfoValue findById(Long tuanGroupId) throws Exception {
		
		return TuanGroupInfoEngine.getBean(tuanGroupId);
	}
	
	

	@SuppressWarnings("unchecked")
	public ITuanGroupInfoValue[] queryTuanGroupInfo(String condition, Map params, int startIndex, int endIndex)
			throws Exception {
		
		return TuanGroupInfoEngine.getBeans(null, condition, params, startIndex, endIndex, false);
	}

	//删除
	public boolean removeTuanGruop(long tuanGroupId) throws Exception {
        StringBuffer condition = new StringBuffer();
        Map<String, Object> params = new HashMap<String, Object>();
        condition.append(ITuanGroupInfoValue.S_TuanGroupId).
                append(" = :").
                append(ITuanGroupInfoValue.S_TuanGroupId);
        params.put(ITuanGroupInfoValue.S_TuanGroupId, tuanGroupId+"");

        int activityCount = TuanGroupInfoEngine.getBeansCount(condition.toString(), params);
        if(activityCount > 0){
              return false;
        }

        ITuanGroupInfoValue group = TuanGroupInfoEngine.getBean(tuanGroupId);
        group.delete();
        TuanGroupInfoEngine.save(group);
        return true;
	}

	//更新对象
	public long updateTuanGroup(ITuanGroupInfoValue tuanGroupValue) throws Exception {
		
//		if(isTitleConflict(tuanGroupValue.getGroupName(), tuanGroupValue.getTuanGroupId())){
//            throw new CommnException("已经有同名的团购活动分组存在！");
//        }
		TuanGroupInfoEngine.save(tuanGroupValue);
        return tuanGroupValue.getTuanGroupId();
	}

    private boolean isTitleConflict(String groupName)throws Exception{
        Map<String, String> params = new HashMap<String, String>();
        StringBuffer sql = new StringBuffer();
        sql.append(ITuanGroupInfoValue.S_GroupName+ " = :" + ITuanGroupInfoValue.S_GroupName);
        params.put(ITuanGroupInfoValue.S_GroupName, groupName);

        ITuanGroupInfoValue[] values = TuanGroupInfoEngine.getBeans(sql.toString(), params);
        return values.length > 0;
    }
    
    //当列新对象时判断是否有重名
   /* private boolean isTitleConflict(String groupName, long excludeGroupId)throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        sql.append(ITuanGroupInfoValue.S_GroupName+ " = :" + ITuanGroupInfoValue.S_GroupName);
        params.put(ITuanGroupInfoValue.S_GroupName, groupName);
        sql.append(" AND ").
                append(ITuanGroupInfoValue.S_TuanGroupId).append(" != :").
                append(ITuanGroupInfoValue.S_TuanGroupId);
        params.put(ITuanGroupInfoValue.S_TuanGroupId, excludeGroupId);
        ITuanGroupInfoValue[] values = TuanGroupInfoEngine.getBeans(sql.toString(), params);
        return values.length > 0;
    }*/

    public ITuanGroupInfoValue findTuanGroup(String groupCode ,String groupType) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        ITuanGroupInfoValue value = null;
        sql.append(ITuanGroupInfoValue.S_GroupCode + " = :" + ITuanGroupInfoValue.S_GroupCode);
        params.put(ITuanGroupInfoValue.S_GroupCode, groupCode);
        sql.append(" AND "+ITuanGroupInfoValue.S_GroupType + " = :" + ITuanGroupInfoValue.S_GroupType);
        params.put(ITuanGroupInfoValue.S_GroupType, groupType);
        
        ITuanGroupInfoValue[] values = TuanGroupInfoEngine.getBeans(sql.toString(), params);
        if(null != values && 0< values.length){
        	value = values[0];
        }
		
		return value;
	}

	public ITuanGroupInfoValue[] findTuanGroupType(String groupType) throws Exception {
	       Map<String, Object> params = new HashMap<String, Object>();
	        StringBuffer sql = new StringBuffer();
	        sql.append(ITuanGroupInfoValue.S_GroupType + " = :" + ITuanGroupInfoValue.S_GroupType);
	        params.put(ITuanGroupInfoValue.S_GroupType, groupType);
	        
	        return TuanGroupInfoEngine.getBeans(sql.toString(), params);
	}

}
