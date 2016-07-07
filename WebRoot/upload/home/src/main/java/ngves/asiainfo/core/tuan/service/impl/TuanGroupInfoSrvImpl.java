package ngves.asiainfo.core.tuan.service.impl;

import java.util.Map;

import ngves.asiainfo.core.rushbuy.RushBuyConstant;
import ngves.asiainfo.core.tuan.dao.interfaces.ITuanGroupInfoDAO;
import ngves.asiainfo.core.tuan.ivalues.ITuanGroupInfoValue;
import ngves.asiainfo.core.tuan.service.interfaces.ITuanGroupInfoSrv;


public class TuanGroupInfoSrvImpl implements ITuanGroupInfoSrv {
	
	
	private ITuanGroupInfoDAO tuanGroupInfoDAO;
	public void setTuanGroupInfoDAO(ITuanGroupInfoDAO tuanGroupInfoDAO) {
		this.tuanGroupInfoDAO = tuanGroupInfoDAO;
	}

	public long addTuanGroup(ITuanGroupInfoValue tuanGroupValue) throws Exception {
		
		return tuanGroupInfoDAO.addTuanGroup(tuanGroupValue);
	}

	public int countByTitle(String groupType,String groupName) throws Exception {
		
		return tuanGroupInfoDAO.countByTitle(groupType,groupName);
	}

	public ITuanGroupInfoValue[] findAllByTitle(String groupType,String groupName, int startIndex, int endIndex) throws Exception {
		
		ITuanGroupInfoValue[] groups = tuanGroupInfoDAO.findAllByTitle(groupType,groupName, startIndex, endIndex);
		fillHTMLOperationField(groups);
	    return groups;
	}

	public ITuanGroupInfoValue[] findAlltuanGroup() throws Exception {
		
		return tuanGroupInfoDAO.findAlltuanGroup();
	}

	public ITuanGroupInfoValue findById(Long tuanGroupId) throws Exception {
		
		return tuanGroupInfoDAO.findById(tuanGroupId);
	}

	@SuppressWarnings("unchecked")
	public ITuanGroupInfoValue[] queryTuanGroupInfo(String condition, Map params, int startIndex, int endIndex)
			throws Exception {
		ITuanGroupInfoValue[] groups = tuanGroupInfoDAO.queryTuanGroupInfo(condition, params, startIndex, endIndex);
        fillHTMLOperationField(groups);
        return groups;
	}

	public boolean removeTuanGruop(long tuanGroupId) throws Exception {
		
		return tuanGroupInfoDAO.removeTuanGruop(tuanGroupId);
	}

	public long updateTuanGroup(ITuanGroupInfoValue tuanGroupValue) throws Exception {
		
		return tuanGroupInfoDAO.updateTuanGroup(tuanGroupValue);
	}
	
	
    private ITuanGroupInfoValue[] fillHTMLOperationField(ITuanGroupInfoValue[] groups){
        for(ITuanGroupInfoValue group: groups){
            StringBuffer sb = new StringBuffer();
            sb.append(String.format(RushBuyConstant.MODIFY_GROUP_LINK_TUAN, group.getTuanGroupId(),group.getGroupType()));
            group.setBakCol(sb.toString());
        }
        return groups;
    }

	public ITuanGroupInfoValue findTuanGroup(String groupCode,String groupType) throws Exception {
		
		return tuanGroupInfoDAO.findTuanGroup(groupCode,groupType);
	}

	public ITuanGroupInfoValue[] findTuanGroupType(String groupType) throws Exception {
		
		return tuanGroupInfoDAO.findTuanGroupType(groupType);
	}
    
}
