package ngves.asiainfo.core.donated.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.donated.bo.ActivityObjectsRltEngine;
import ngves.asiainfo.core.donated.bo.ActivityWareRltEngine;
import ngves.asiainfo.core.donated.bo.DonatedActivityEngine;
import ngves.asiainfo.core.donated.bo.DonatedPicEngine;
import ngves.asiainfo.core.donated.bo.QBODonatedObjectRltEngine;
import ngves.asiainfo.core.donated.bo.QBODonatedWareBindEngine;
import ngves.asiainfo.core.donated.bo.QBODonatedWareInfoEngine;
import ngves.asiainfo.core.donated.bo.QBOWareObjectRltEngine;
import ngves.asiainfo.core.donated.dao.interfaces.IDonatedActivityDAO;
import ngves.asiainfo.core.donated.ivalues.IActivityObjectsRltValue;
import ngves.asiainfo.core.donated.ivalues.IActivityWareRltValue;
import ngves.asiainfo.core.donated.ivalues.IDonatedActivityValue;
import ngves.asiainfo.core.donated.ivalues.IDonatedPicValue;
import ngves.asiainfo.core.donated.ivalues.IQBODonatedObjectRltValue;
import ngves.asiainfo.core.donated.ivalues.IQBODonatedWareBindValue;
import ngves.asiainfo.core.donated.ivalues.IQBODonatedWareInfoValue;
import ngves.asiainfo.core.donated.ivalues.IQBOWareObjectRltValue;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DonatedActivityDAOImpl implements IDonatedActivityDAO {

	private Log log = LogFactory.getLog(DonatedActivityDAOImpl.class);

	public long saveDonatedActivity(IDonatedActivityValue value) throws Exception {
		DonatedActivityEngine.save(value);
		return value.getDonatedId();
	}
	
	public void saveDonatedActivity(IDonatedActivityValue []value) throws Exception {
		DonatedActivityEngine.save(value);
	}

	/**
	 * 捐赠活动信息列表
	 * 
	 * @param donotedActivityName
	 *            捐赠活动名
	 * @param startIndex
	 *            开始索引
	 * @param endIndex
	 *            结束索引
	 * @return
	 * @author luohuan
	 */
	public IDonatedActivityValue[] queryDonotedActivity(String donotedActivityName, int startIndex, int endIndex)
			throws Exception {

		StringBuffer sql = new StringBuffer();
		Map<String, String> params = new HashMap<String, String>();

		if (!StringUtil.isBlank(donotedActivityName)) {
			donotedActivityName = donotedActivityName.trim();
			sql.append(IDonatedActivityValue.S_DonatedName).append(" LIKE :").append(
					IDonatedActivityValue.S_DonatedName).append(" ");
			params.put(IDonatedActivityValue.S_DonatedName, "%" + donotedActivityName + "%");
		}
		try {
			sql.append(" order by CREATE_DATE DESC");
			return DonatedActivityEngine.getBeans(null, sql.toString(), params, startIndex, endIndex, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @author luohuaa
	 * @return 信息总条数
	 */
	public int queryDonotedActCount(String donotedActivityName) {
		StringBuffer sql = new StringBuffer();
		Map<String, String> params = new HashMap<String, String>();

		if (!StringUtil.isBlank(donotedActivityName)) {
			donotedActivityName = donotedActivityName.trim();
			sql.append(IDonatedActivityValue.S_DonatedName).append(" LIKE :").append(
					IDonatedActivityValue.S_DonatedName).append(" ");
			params.put(IDonatedActivityValue.S_DonatedName, "%" + donotedActivityName + "%");
		}
		try {
			return DonatedActivityEngine.getBeansCount(sql.toString(), params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}


	public long saveDonatedPic(IDonatedPicValue value) throws Exception {
	
		DonatedPicEngine.save(value);
		return value.getActivityPicId();
	}

	public IDonatedActivityValue getDonatedActivityById(long donatedActivityId) throws Exception {
		IDonatedActivityValue value = DonatedActivityEngine.getBean(donatedActivityId);
		return value;
	}

	public IDonatedActivityValue[] getDonatedActivityValue(String condition,Map<String,String> parameter) throws Exception{ 
		return DonatedActivityEngine.getBeans(condition, parameter);
	}

	public IDonatedPicValue getDonatedPicValueById(long donatedPicId) throws Exception {
		log.debug("donatedPicId is ====>>>" + donatedPicId);
		IDonatedPicValue value = DonatedPicEngine.getBean(donatedPicId);
		return value;
	}

	public IQBODonatedObjectRltValue[] getDonatedObjectRltValue(String condition, Map<String, String> parameter)
			throws Exception {
		log.debug("getDonatedObjectRltValue"+condition);
		IQBODonatedObjectRltValue [] value = QBODonatedObjectRltEngine.getBeans(condition, parameter);
		return value;
	}

	public long saveDonatedObjectRltValue(IActivityObjectsRltValue value) throws Exception {
		log.debug("saveDonatedObjectRltValue "+value.getRltId() +":"+value.getAppVersion());
		ActivityObjectsRltEngine.save(value);
		return value.getRltId();
	}
	
	
	public void saveDonatedObjectRltValue(IActivityObjectsRltValue[] value) throws Exception {
		ActivityObjectsRltEngine.save(value);
	}

	public IActivityObjectsRltValue[] getActivityObjectsRltValue(String condition, Map<String, String> parameter)
			throws Exception {
		log.debug("getActivityObjectsRltValue"+condition);
		IActivityObjectsRltValue [] value = ActivityObjectsRltEngine.getBeans(condition, parameter);
		return value;
	}

	public int getDonatedWareInfoCount(String condition, Map<String, String> parameter) throws Exception {
		log.debug("getDonatedWareInfoCount the condition is "+condition +", the map is "+parameter);
		int count = QBODonatedWareInfoEngine.getBeansCount(condition, parameter);
		log.debug("count is ===>>"+count);
		return count;
	}

	public IQBODonatedWareInfoValue[] getDonatedWareInfoValue(String condition, Map<String, String> parameter,
			int startNum, int endNum) throws Exception {
		
		IQBODonatedWareInfoValue [] value  = QBODonatedWareInfoEngine.getBeans(null,condition, parameter,startNum,endNum, false, null);
		if(null !=value){
			log.debug("value.length is "+value.length);
		}else{
			log.debug("the value is null");
		}
		return value;
	}

	public IQBODonatedWareBindValue[] getDonatedWareBindValue(String condition, Map<String, String> parameter)
			throws Exception {
		IQBODonatedWareBindValue[] value = null;
		//Map<String, String> para = new HashMap<String,String>();
		//para.put("ACITVITY_ID","100000000000004");
		value = QBODonatedWareBindEngine.getBeans(null, parameter);
		if(null !=value){
			log.debug("value.length is "+value.length);
		}else{
			log.debug("the value is null");
		}
		return value;
	}

	public IActivityWareRltValue[] getActivityWareRltValue(String condition, Map<String, String> parameter)
			throws Exception {
		IActivityWareRltValue[] value = ActivityWareRltEngine.getBeans(condition, parameter);
		if(null !=value){
			log.debug("value.length is "+value.length);
		}else{
			log.debug("the value is null");
		}
		return value;
	}

	public IQBOWareObjectRltValue[] getWareObjectRltValue(String condition, Map<String, String> parameter)
			throws Exception {
		IQBOWareObjectRltValue[] value = QBOWareObjectRltEngine.getBeans(condition, parameter);
		if(null !=value){
			log.debug("value.length is "+value.length);
		}else{
			log.debug("the value is null");
		}
		return value;
	}

	public long saveActivityWareRltValue(IActivityWareRltValue value) throws Exception {
		ActivityWareRltEngine.save(value);
		return value.getRltId();
	}

	public void saveActivityWareRltValue(IActivityWareRltValue[] value) throws Exception {
		ActivityWareRltEngine.save(value);
	}

}
