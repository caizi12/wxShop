/**
 * 
 */
package ngves.asiainfo.core.ware.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import ngves.asiainfo.core.ware.WareMonitorConstant;
import ngves.asiainfo.core.ware.bo.JobDateRltBean;
import ngves.asiainfo.core.ware.bo.JobDateRltEngine;
import ngves.asiainfo.core.ware.bo.JobObjectRltEngine;
import ngves.asiainfo.core.ware.bo.JobTaskBean;
import ngves.asiainfo.core.ware.bo.JobTaskEngine;
import ngves.asiainfo.core.ware.bo.QBOAllMonitorEngine;
import ngves.asiainfo.core.ware.bo.QBOJobDateEngine;
import ngves.asiainfo.core.ware.bo.QBOMonitorWareEngine;
import ngves.asiainfo.core.ware.bo.QBOQueryMonitorEngine;
import ngves.asiainfo.core.ware.bo.StaffJobRltBean;
import ngves.asiainfo.core.ware.bo.StaffJobRltEngine;
import ngves.asiainfo.core.ware.bo.WareMonitorRecordBean;
import ngves.asiainfo.core.ware.bo.WareMonitorRecordEngine;
import ngves.asiainfo.core.ware.dao.interfaces.IWareMonitorDAO;
import ngves.asiainfo.core.ware.ivalues.IJobDateRltValue;
import ngves.asiainfo.core.ware.ivalues.IJobObjectRltValue;
import ngves.asiainfo.core.ware.ivalues.IJobTaskValue;
import ngves.asiainfo.core.ware.ivalues.IQBOAllMonitorValue;
import ngves.asiainfo.core.ware.ivalues.IQBOJobDateValue;
import ngves.asiainfo.core.ware.ivalues.IQBOMonitorWareValue;
import ngves.asiainfo.core.ware.ivalues.IQBOQueryMonitorValue;
import ngves.asiainfo.core.ware.ivalues.IStaffJobRltValue;
import ngves.asiainfo.util.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ai.appframe2.common.ServiceManager;


public class WareMonitorDAOImpl implements IWareMonitorDAO {

	
	@SuppressWarnings("unchecked")
	public void wareMonitorSave(String taskId, String queryTme,
			String warmingtype, String monitorstatus,long operatorId) throws Exception {
		if(!StringUtil.isBlank(taskId)&&!StringUtil.isBlank(queryTme)&&!StringUtil.isBlank(warmingtype)
				&&!StringUtil.isBlank(monitorstatus)&&operatorId!=0L){
		//获取监控配置信息
			List startTimeList = new ArrayList<String>();
			List endTimeList = new ArrayList<String>();
			List sortIdList = new ArrayList<String>();
			List jobDateIDList = new ArrayList<String>();
			JSONArray timeJSonArray = JSONArray.fromObject(queryTme);
		for (int i = 0; i < timeJSonArray.size(); i++) {
			JSONObject timeJsonObject = JSONObject.fromObject(timeJSonArray.get(i).toString());
			jobDateIDList.add(timeJsonObject.get("jobDateRltID"));
			startTimeList.add(timeJsonObject.get("startTime"));
			endTimeList.add(timeJsonObject.get("endTime"));
			sortIdList.add(timeJsonObject.get("sortId"));
		}
		IJobTaskValue value = JobTaskEngine.getBean(Long.parseLong(taskId));
		value.setBakCol1(warmingtype);
		value.setBakCol2(monitorstatus);
		JobTaskEngine.save(value);
		//判断启用状态，启用状态修改记录
		if(WareMonitorConstant.JOB_TASK_STATUS_ENABLE.equals(monitorstatus)){
			saveWareMonitorRecord(WareMonitorConstant.OPERATE_TYPE_TASK_STATUS, String.valueOf(operatorId), taskId, "", WareMonitorConstant.JOB_TASK_STATUS_ENABLE_NAME);
		}else if(WareMonitorConstant.JOB_TASK_STATUS_UNENABLE.equals(monitorstatus)){
			saveWareMonitorRecord(WareMonitorConstant.OPERATE_TYPE_TASK_STATUS, String.valueOf(operatorId), taskId, "", WareMonitorConstant.JOB_TASK_STATUS_UNENABLE_NAME);
		}else{
			throw new Exception("the monitor status of jobtask is invalid...");
		}
		
		for (int j = 0; j < jobDateIDList.size(); j++) {
			IJobDateRltValue jobDateValue = JobDateRltEngine.getBean(Long.parseLong(jobDateIDList.get(j).toString()));
			//判断时间段是否已存在，存在则修改，不存在则新增
			if (!jobDateValue.isNew()) {
				log.info(" the job date is exist , update...............");
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss");
				Date timeDate = dateFormat.parse(startTimeList.get(j)
						.toString());
				Timestamp dateTime = new Timestamp(timeDate.getTime());
				jobDateValue.setStartDate(dateTime);
				timeDate = dateFormat.parse(endTimeList.get(j).toString());
				dateTime = new Timestamp(timeDate.getTime());
				jobDateValue.setEndDate(dateTime);
				JobDateRltEngine.save(jobDateValue);
			} else {
				log.info(" the job date is not exist , insert into ...............");
				IJobDateRltValue bean = new JobDateRltBean();
				bean.setJobDateRltId(Long.parseLong(jobDateIDList.get(j).toString()));
				bean.setJobTaskId(Long.parseLong(taskId));
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				Date timeDate = dateFormat.parse(startTimeList.get(j).toString());
				Timestamp dateTime = new Timestamp(timeDate.getTime());
				bean.setStartDate(dateTime);
				timeDate = dateFormat.parse(endTimeList.get(j).toString());
				dateTime = new Timestamp(timeDate.getTime());
				bean.setEndDate(dateTime);
				bean.setSortId(Long.parseLong(sortIdList.get(j).toString()));
				JobDateRltEngine.save(bean);
			}
			log.info(" the ware monitor save Successe ...............");
		}
		}else{
			log.error("ware monitor config has null ： taskId="+taskId+"queryTme="+queryTme
					+"warmingtype="+warmingtype+"monitorstatus="+monitorstatus+"operatorId="+operatorId);	
		}
	}
	public IQBOAllMonitorValue[] queryMonitorDetail(String jobTaskId,String monitorType) throws Exception {
		log.info("Dao JOB_TASK_ID :="+jobTaskId+" MONITOR_TYPE :="+monitorType);
		String sql = new String();
		sql="";
		if(WareMonitorConstant.MONITOR_TYPE_BIG_KIND.equals(monitorType)){
			sql="select wfk.f_name COMMON_NAME,wfk.f_code MONITOR_OBJECT_ID from job_object_rlt jbr ,ware_first_kind wfk where jbr.monitor_object_id=wfk.f_code and jbr.job_task_id='" +
					jobTaskId +
					"'";
		}else
		if(WareMonitorConstant.MONITOR_TYPE_MIDDLE_KIND.equals(monitorType)){
			sql="select wkp.big_kind_name COMMON_NAME,wkp.big_kind_code MONITOR_OBJECT_ID from job_object_rlt jbr ,ware_kind_Parent wkp where jbr.monitor_object_id=wkp.big_kind_code and jbr.job_task_id='" +
					jobTaskId +
					"'";
		}else
		if(WareMonitorConstant.MONITOR_TYPE_SMALL_KIND.equals(monitorType)){
			sql="select wk.kind_name COMMON_NAME,wk.kind_code MONITOR_OBJECT_ID from job_object_rlt jbr ,ware_kind wk where jbr.monitor_object_id=wk.kind_code and jbr.job_task_id='" +
					jobTaskId +
					"'";
		}else
		if(WareMonitorConstant.MONITOR_TYPE_WARE.equals(monitorType)){
			sql="select wi.ware_name COMMON_NAME,wi.ware_code MONITOR_OBJECT_ID from job_object_rlt jbr ,ware_info wi where jbr.monitor_object_id=wi.ware_code and jbr.job_task_id='" +
					jobTaskId +
					"'";
		}else
		{
			log.error("No this MONITOR_TYPE");
			throw new Exception("Dao No this MONITOR_TYPE");
		}
		
		return QBOAllMonitorEngine.getBeansFromSql(sql, null);
	}
	private static transient Log log = LogFactory.getLog(WareMonitorDAOImpl.class);

	public IQBOAllMonitorValue[] getAllMonitorValue(String condition, Map<String, String> parameter, int startNum,
			int endNum) throws Exception {
		log.info("search condition := " + condition);
		return QBOAllMonitorEngine.getBeans(null, condition, parameter, startNum, endNum, false);
	}
	
	public IQBOAllMonitorValue[] getAllMonitorValue(String condition, Map<String, String> parameter) throws Exception {
		log.info("search condition := " + condition);
		return QBOAllMonitorEngine.getBeans(condition, parameter);
	}

	public IQBOQueryMonitorValue[] getQueryMonitorValue(String condition, Map<String, String> parameter, int startNum,
			int endNum) throws Exception {
		log.info("search condition := " + condition);
		return QBOQueryMonitorEngine.getBeans(null, condition, parameter, startNum, endNum, false);
	}
	
	public int getQueryMonitorCount(String condition, Map<String, String> parameter) throws Exception {
		log.info("search condition := " + condition);
		return QBOQueryMonitorEngine.getBeansCount(condition, parameter);
	}
	
	public int getAllMonitorCount(String condition, Map<String, String> parameter) throws Exception {
		log.info("search condition := " + condition);
		return QBOAllMonitorEngine.getBeansCount(condition, parameter);
	}

	
	public IQBOMonitorWareValue[] queryMonitorWare(String jobtaskid) throws Exception{
		
		String condition = IQBOMonitorWareValue.S_JobTaskId + " = :" + IQBOMonitorWareValue.S_JobTaskId;
		Map<String, String> parameter = new HashMap<String, String>();
		parameter.put(IQBOMonitorWareValue.S_JobTaskId, jobtaskid);
		
		return QBOMonitorWareEngine.getBeans(condition, parameter);
	}
	public boolean staffJobIsBind(String staffId, String taskId, boolean flag,long operatorId)throws Exception {
		boolean f = false;
		StringBuffer sb = new StringBuffer();
		Map<String, Long> parameter = new HashMap<String, Long>();
		sb.append(IStaffJobRltValue.S_StaffId).append("=:").append(
				IStaffJobRltValue.S_StaffId);
		parameter.put(IStaffJobRltValue.S_StaffId, Long.parseLong(staffId));
		sb.append(" AND " + IStaffJobRltValue.S_JobTaskId).append("=:").append(
				IStaffJobRltValue.S_JobTaskId);
		parameter.put(IStaffJobRltValue.S_JobTaskId, Long.parseLong(taskId));
		IStaffJobRltValue[] staffJobRltValue = StaffJobRltEngine.getBeans(sb
				.toString(), parameter);
		//判断绑定表中是否已有记录，已有进行修改，没有进行新增
		if (staffJobRltValue == null || staffJobRltValue.length == 0) {
			IStaffJobRltValue bean = new StaffJobRltBean();
			bean.setStaffJobRltId(StaffJobRltEngine.getNewId().longValue());
			bean.setStaffId(Long.parseLong(staffId));
			bean.setJobTaskId(Long.parseLong(taskId));
			bean.setIsBind(1);
			StaffJobRltEngine.save(bean);
			saveWareMonitorRecord(WareMonitorConstant.OPERATE_TYPE_BIND_STATUS, String.valueOf(operatorId), 
					taskId, staffId, WareMonitorConstant.OPERATE_TYPE_BIND_NAME);
			f = true;
		} else {
			//对已有记录进行修改，判断绑定与取消绑定操作进行历史记录
			for (IStaffJobRltValue value : staffJobRltValue) {
				if (flag == true) {
					value.setIsBind(1);
					saveWareMonitorRecord(WareMonitorConstant.OPERATE_TYPE_BIND_STATUS, String.valueOf(operatorId), 
							taskId, staffId, WareMonitorConstant.OPERATE_TYPE_BIND_NAME);
				} else {
					value.setIsBind(0);
					saveWareMonitorRecord(WareMonitorConstant.OPERATE_TYPE_BIND_STATUS, String.valueOf(operatorId), 
							taskId, staffId, WareMonitorConstant.OPERATE_TYPE_UNBIND_NAME);
				}
				StaffJobRltEngine.save(value);
			}
			f = true;
		}
		return f;
	}
	public IQBOJobDateValue[] queryWareMonitor(String condition,Map<String, String> parameter) throws Exception {
		IQBOJobDateValue[] values = QBOJobDateEngine.getBeans(condition, parameter);
		return values;
	}
	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.ware.dao.interfaces.IWareMonitorDAO#addJobTask()
	 */
	public long addJobTask() throws Exception {
		IJobTaskValue jobTaskValue = new JobTaskBean();
		long jobTaskId = JobTaskEngine.getNewId().longValue();
		jobTaskValue.setJobTaskId(jobTaskId);
		jobTaskValue.setJobTaskName("礼品订单量统计监控");
		jobTaskValue.setJobTaskType(WareMonitorConstant.JOB_TASK_TYPE_MONITOR);
		jobTaskValue.setCreateTime(JobTaskEngine.getSysDate());
		JobTaskEngine.save(jobTaskValue);
		return jobTaskId;
	}
	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.ware.dao.interfaces.IWareMonitorDAO#saveMonitorObject(ngves.asiainfo.core.ware.ivalues.IJobObjectRltValue[], long)
	 */
	public void saveMonitorObject(IJobObjectRltValue[] jobObjectRltValues, long jobTaskId) throws Exception {
		for (int i = 0; i < jobObjectRltValues.length; i++) {
			jobObjectRltValues[i].setJobTaskId(jobTaskId);
			jobObjectRltValues[i].setJobObjectRltId(JobObjectRltEngine.getNewId().longValue());
		}
		JobObjectRltEngine.save(jobObjectRltValues);
		
	}
	/**
	 * @param WareMonitorRecordBean 礼品监控操作记录
	 * @return
	 */
	private boolean saveWareMonitorRecord(WareMonitorRecordBean wareMonitorRecord)throws Exception{
		if(wareMonitorRecord!=null){
			wareMonitorRecord.setWareMonitorRecordId(WareMonitorRecordEngine.getNewId().longValue());
			WareMonitorRecordEngine.save(wareMonitorRecord);
			return true;
		}else{
			log.error("WareMonitorRecordBean is Null");
			return false;
		}
		
	}

	public boolean saveWareMonitorRecord(String operateType, String operatorId,
			String taskId, String sendObjId, String descOfStatus) throws Exception{
		WareMonitorRecordBean wareMonitorRcord =new WareMonitorRecordBean();
		String operateDesc="";
		if(operateType.equals(WareMonitorConstant.OPERATE_TYPE_TASK_STATUS)){
			operateDesc="任务id ：="+taskId+"的任务被"+descOfStatus;
		}else if(operateType.equals(WareMonitorConstant.OPERATE_TYPE_BIND_STATUS)){
		   operateDesc="任务id ：="+taskId+descOfStatus+"工作人员id ：="+sendObjId;
		}else{
			log.error("礼品监控操作记录失败");
			throw new Exception("礼品监控操作记录失败");
		}
		
		wareMonitorRcord.setOperateType(operateType);
		wareMonitorRcord.setOperatorId(Long.parseLong(operatorId));
		wareMonitorRcord.setOperateTime(new Timestamp(new Date().getTime()));
		wareMonitorRcord.setOperateDesc(operateDesc);
		return saveWareMonitorRecord(wareMonitorRcord);
	}

	public boolean wareMonitorTimeDel(String jobDateRltID) throws Exception {
		// TODO Auto-generated method stub
		JobDateRltBean bean=JobDateRltEngine.getBean(Long.parseLong(jobDateRltID)); 
		//判断是否有时间段记录，有进行删除
		if(!bean.isNew()){
		bean.delete();
		JobDateRltEngine.save(bean);
		}
		return true;
	}
	public String getMaxSort() throws Exception {
		// TODO Auto-generated method stub
		String sql="select max(j.sort_id) from job_date_rlt j";
		Connection conn = null;
		PreparedStatement pstmt = null;
		String maxSort = null;
		ResultSet ruslt =null;
		try {
			conn = ServiceManager.getSession().getConnection();
			pstmt = conn.prepareStatement(sql);
			if (log.isDebugEnabled()) {
				log.debug(" Select sql :=" + sql);
			}
			 ruslt = pstmt.executeQuery();
			if (ruslt.next()) {
				maxSort = ruslt.getString(1);
			}
			return maxSort;
		} catch (Exception e) {
			throw e;
		} finally {
			if(ruslt!=null){
				ruslt.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}
}
