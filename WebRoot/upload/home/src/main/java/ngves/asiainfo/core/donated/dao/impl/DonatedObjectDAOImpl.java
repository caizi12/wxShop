package ngves.asiainfo.core.donated.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.donated.DonatedConstant;
import ngves.asiainfo.core.donated.bo.ActivityObjectsRltBean;
import ngves.asiainfo.core.donated.bo.ActivityObjectsRltEngine;
import ngves.asiainfo.core.donated.bo.DistributionInfoEngine;
import ngves.asiainfo.core.donated.bo.DonatedActivityBean;
import ngves.asiainfo.core.donated.bo.DonatedActivityEngine;
import ngves.asiainfo.core.donated.bo.DonatedObjectsEngine;
import ngves.asiainfo.core.donated.bo.QBODonatedObjectRltEngine;
import ngves.asiainfo.core.donated.dao.interfaces.IDonatedObjectDAO;
import ngves.asiainfo.core.donated.ivalues.IDistributionInfoValue;
import ngves.asiainfo.core.donated.ivalues.IDonatedActivityValue;
import ngves.asiainfo.core.donated.ivalues.IDonatedObjectsValue;
import ngves.asiainfo.core.donated.ivalues.IQBODonatedObjectRltValue;
import ngves.asiainfo.util.StringUtil;

public class DonatedObjectDAOImpl implements IDonatedObjectDAO {

	public IDonatedObjectsValue[] queryObjectInfo(String objectName,
			int startIndex, int endIndex) throws Exception {
		
		StringBuffer sql = new StringBuffer();
		Map<String, String> params = new HashMap<String, String>();

		if (!StringUtil.isBlank(objectName)) {
			objectName = objectName.trim();
			sql.append(IDonatedObjectsValue.S_ObjectName).append(" LIKE :").append(IDonatedObjectsValue.S_ObjectName).append(" ");
			params.put(IDonatedObjectsValue.S_ObjectName, "%" + objectName + "%");
		}
		try {
			sql.append(" order by CREATE_DATE DESC");
			return DonatedObjectsEngine.getBeans(null, sql.toString(), params, startIndex, endIndex, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int queryObjectInfoCount(String objectName) throws Exception {
		StringBuffer sql = new StringBuffer();
		Map<String, String> params = new HashMap<String, String>();

		if (!StringUtil.isBlank(objectName)) {
			objectName = objectName.trim();
			sql.append(IDonatedObjectsValue.S_ObjectName).append(" LIKE :").append(IDonatedObjectsValue.S_ObjectName).append(" ");
			params.put(IDonatedObjectsValue.S_ObjectName, "%" + objectName + "%");
		}
		try {
			return DonatedObjectsEngine.getBeansCount(sql.toString(), params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}


	public IDonatedObjectsValue[] queryObjects(String condition,
			Map<String, String> parameter) throws Exception {
		
		return DonatedObjectsEngine.getBeans(condition, parameter);
	}

	public void updateObject(IDonatedObjectsValue donatedObjectInfoTemp)throws Exception {
		DonatedObjectsEngine.save(donatedObjectInfoTemp);	
	}

	public IDonatedActivityValue queryActives(String condition,
			Map<String, String> parameter) throws Exception {
		ActivityObjectsRltBean[] activityObjectsRltBeans = ActivityObjectsRltEngine
				.getBeans(condition, parameter);
		if (activityObjectsRltBeans.length != 0) {
			String activityId = activityObjectsRltBeans[0].getActivityId() + "";
			StringBuffer sql = new StringBuffer();
			Map<String, String> map = new HashMap<String, String>();
			if (!StringUtil.isBlank(activityId)) {
				sql.append(DonatedActivityBean.S_DonatedId)
						.append("=:")
						.append(DonatedActivityBean.S_DonatedId).append(" ");
				map
						.put(DonatedActivityBean.S_DonatedId,  activityId
								);
				IDonatedActivityValue[] activityValues = DonatedActivityEngine
						.getBeans(sql.toString(), map);
				if (activityValues.length != 0) {
					return activityValues[0];
				} 
			}
		}
		return null;
	}


	public String saveDistrictInfo(IDistributionInfoValue distributionInfoValue) throws Exception {
		String id = "";
		if(distributionInfoValue.isNew()){
			id = DistributionInfoEngine.getNewId().toString();
			distributionInfoValue.setDistributionId(Long.parseLong(id));
		}
		DistributionInfoEngine.save(distributionInfoValue);
		return id;
	}

	public String saveDonatedObject(IDonatedObjectsValue donatedObjectsValue) throws Exception {
		String id = "";
		if(donatedObjectsValue.isNew()){
			id = DonatedObjectsEngine.getNewId().toString();
			donatedObjectsValue.setObjectId(Long.parseLong(id));
			donatedObjectsValue.setCreateDate(DonatedObjectsEngine.getSysDate());
			donatedObjectsValue.setStatus(Long.valueOf(DonatedConstant.DONATED_OBJECT_STATUS_ABLE));
		}
		DonatedObjectsEngine.save(donatedObjectsValue);
		return id;
	}

	public IDonatedObjectsValue[] getAllIDonatedObjectsValue() throws Exception {
		return DonatedObjectsEngine.getBeans(null, null);
	}

	public IDonatedObjectsValue queryObjectInfoById(long id) throws Exception {
		return DonatedObjectsEngine.getBean(id);
	}
	public IQBODonatedObjectRltValue[] getDonatedObjectRltInfo(String conditon, Map<String, String> parameter)
			throws Exception {
		IQBODonatedObjectRltValue[] value = QBODonatedObjectRltEngine.getBeans(conditon,parameter);
		return value;
	}
}
