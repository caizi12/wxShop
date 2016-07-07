package ngves.asiainfo.core.donated.service.impl;


import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.common.dao.interfaces.IClobInfoDAO;
import ngves.asiainfo.core.donated.DonatedConstant;
import ngves.asiainfo.core.donated.dao.interfaces.IDonatedObjectDAO;
import ngves.asiainfo.core.donated.ivalues.IActivityObjectsRltValue;
import ngves.asiainfo.core.donated.ivalues.IDistributionInfoValue;
import ngves.asiainfo.core.donated.ivalues.IDonatedActivityValue;
import ngves.asiainfo.core.donated.ivalues.IDonatedObjectsValue;
import ngves.asiainfo.core.donated.ivalues.IQBODonatedObjectRltValue;
import ngves.asiainfo.core.donated.service.interfaces.IDonatedObjectSrv;
import ngves.asiainfo.util.StringUtil;

import com.ai.appframe2.service.ServiceFactory;

public class DonatedObjectSrvImpl implements IDonatedObjectSrv {
	
	private IDonatedObjectDAO donatedObjectDAO;
	
	public void setDonatedObjectDAO(IDonatedObjectDAO donatedObjectDAO) throws Exception {
		this.donatedObjectDAO = donatedObjectDAO;
	}
	

	public IDonatedObjectsValue[] queryObjectInfo(String objectName,
			int startIndex, int endIndex) throws Exception {
		return donatedObjectDAO.queryObjectInfo( objectName,
				startIndex, endIndex);
	}

	public int queryObjectInfoCount(String objectName) throws Exception {
		return donatedObjectDAO.queryObjectInfoCount(objectName);
	}
	public void setObject(String objectId) throws Exception{
		StringBuffer condition = new StringBuffer();
		Map<String, String> parameter = new HashMap<String, String>();
		IDonatedObjectsValue[] donatedObjectInfoList = null;
		IDonatedObjectsValue donatedObjectInfoTemp = null;
		condition.append("1=1");
		// 设置捐赠对象的ObjectId
		if (!StringUtil.isBlank(objectId)) {
			condition.append(" AND ").append(IDonatedObjectsValue.S_ObjectId)
					.append("=:").append(IDonatedObjectsValue.S_ObjectId);
			parameter.put(IDonatedObjectsValue.S_ObjectId, objectId);
		}
		donatedObjectInfoList = donatedObjectDAO.queryObjects(condition
				.toString(), parameter);
		if (donatedObjectInfoList != null && donatedObjectInfoList.length > 0) {


			donatedObjectInfoTemp = donatedObjectInfoList[0];

			// 如果捐赠对象处于启用状态，进行停用操作
			if (String.valueOf(donatedObjectInfoTemp.getStatus()).equals(
					DonatedConstant.DONATED_OBJECT_STATUS_ABLE)) {

				donatedObjectInfoTemp
						.setStatus(Long
								.parseLong(DonatedConstant.DONATED_OBJECT_STATUS_DISABLE));

				// 否则，进行启用操作
			} else {
				donatedObjectInfoTemp.setStatus(Long
						.parseLong(DonatedConstant.DONATED_OBJECT_STATUS_ABLE));

			}

			// 更新捐赠对象状态
			donatedObjectDAO.updateObject(donatedObjectInfoTemp);
		}
	}


	public IDonatedActivityValue queryActiveObjectRlt(String objectId)
			throws Exception {
		StringBuffer condition = new StringBuffer();
		Map<String, String> parameter = new HashMap<String, String>();
		IDonatedActivityValue  donatedActivityValue =null;
		condition.append("1=1");
		// 设置捐赠对象的ObjectId
		if (!StringUtil.isBlank(objectId)) {
			condition.append(" AND ").append(IActivityObjectsRltValue.S_ObjectId)
					.append("=:").append(IActivityObjectsRltValue.S_ObjectId);
			parameter.put(IActivityObjectsRltValue.S_ObjectId, objectId);
		}
		donatedActivityValue = donatedObjectDAO.queryActives(condition
				.toString(), parameter);
		if(donatedActivityValue!=null){
			return donatedActivityValue;
		}
		return null;
	}


	public String saveDonatedObject(IDonatedObjectsValue donatedObjectsValue) throws Exception {
		return donatedObjectDAO.saveDonatedObject(donatedObjectsValue);
	}


	public String saveDistrictInfo(IDistributionInfoValue distributionInfoValue) throws Exception {
		return donatedObjectDAO.saveDistrictInfo(distributionInfoValue);
	}


	public boolean saveDonatedObjDesc(String objId, String tableName, String desc) throws Exception {
		IClobInfoDAO clobInfoDAO = (IClobInfoDAO)ServiceFactory.getService("ngves.asiainfo.core.clobInfoDAO");
		return clobInfoDAO.saveClobInfo(Long.parseLong(objId), tableName, desc);
	}
	
	public IDonatedObjectsValue[] getAllIDonatedObjectsValue()throws Exception{
		return donatedObjectDAO.getAllIDonatedObjectsValue();
	}


	public IDonatedObjectsValue queryObjectInfoById(long id) throws Exception {
		return donatedObjectDAO.queryObjectInfoById(id);
	}


	public IQBODonatedObjectRltValue[] queryAllObjectInfo(String donatedActivityId) throws Exception {
		IQBODonatedObjectRltValue[] value = null;
		StringBuffer condition  = new StringBuffer(" 1=1 ");
		Map<String,String> parameter = new HashMap<String,String>();
		if(!StringUtil.isBlank(donatedActivityId)){
			condition.append(" and ").append(IQBODonatedObjectRltValue.S_ActivityId).append("=:").append(IQBODonatedObjectRltValue.S_ActivityId);
			parameter.put(IQBODonatedObjectRltValue.S_ActivityId, donatedActivityId);
		}
		value = donatedObjectDAO.getDonatedObjectRltInfo(condition.toString(), parameter);
		return value;
	}
	
	public String getDonatedDesc(long objId) throws Exception{
		IClobInfoDAO clobInfoDAO = (IClobInfoDAO)ServiceFactory.getService("ngves.asiainfo.core.clobInfoDAO");
		return clobInfoDAO.getContent(objId, DonatedConstant.TABLE_DONATED_OBJECTS);
	}

}

