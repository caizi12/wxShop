/**
 * 
 */
package ngves.asiainfo.core.ware.service.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.ware.WareMonitorConstant;
import ngves.asiainfo.core.ware.bo.JobObjectRltBean;
import ngves.asiainfo.core.ware.dao.interfaces.IWareInfoDAO;
import ngves.asiainfo.core.ware.dao.interfaces.IWareMonitorDAO;
import ngves.asiainfo.core.ware.ivalues.IJobObjectRltValue;
import ngves.asiainfo.core.ware.ivalues.IQBOAllMonitorValue;
import ngves.asiainfo.core.ware.ivalues.IQBOJobDateValue;
import ngves.asiainfo.core.ware.ivalues.IQBOMonitorWareValue;
import ngves.asiainfo.core.ware.ivalues.IQBOQueryMonitorValue;
import ngves.asiainfo.core.ware.service.interfaces.IWareMonitorSrv;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.AIException;

public class WareMonitorSrvImpl implements IWareMonitorSrv {

	private static transient Log log = LogFactory.getLog(WareMonitorSrvImpl.class);
	
	private IWareMonitorDAO wareMonitorDAO;
	@SuppressWarnings("unused")
	private IWareInfoDAO wareInfoDAO;
	
	public void setWareMonitorDAO(IWareMonitorDAO wareMonitorDAO) throws Exception {
		this.wareMonitorDAO = wareMonitorDAO;
	}

	public void wareMonitorSave(String taskId, String queryTime,String warmingtype, 
			String monitorstatus, long operatorId)throws Exception {
		wareMonitorDAO.wareMonitorSave(taskId, queryTime, warmingtype,monitorstatus, operatorId);
	}

	public void setWareInfoDAO(IWareInfoDAO wareInfoDAO) throws Exception {
		this.wareInfoDAO = wareInfoDAO;
	}

	public IQBOQueryMonitorValue[] getAllMonitorValue(String wareCode, String firstKindId, String parentKindId,
			String kindId, String warningType, String initiateMode, int startNum, int endNum) throws Exception {
		log.info("getMonitor condition wareCode :=" + wareCode + " firstKindId := " + firstKindId + " parentKindId :="
				+ parentKindId + " kindId := " + kindId + " warningType := " + warningType + " initiateMode := "
				+ initiateMode);
		Map<String, String> parameter = new HashMap<String, String>();
		IQBOQueryMonitorValue[] allMonitorValues = wareMonitorDAO.getQueryMonitorValue(processAllMonitorCondition(wareCode,
				firstKindId, parentKindId, kindId, warningType, initiateMode, parameter), parameter, startNum, endNum);
		// step 1 设置超链接
		fillHTMLOperationField(allMonitorValues);
		// step 2 转换MonitorType字段
		dealForMonitorType(allMonitorValues);
		// step 3 转换WarningType字段
		dealForWarningType(allMonitorValues);
		// step 4 设置启用状态
		dealForInitiateMode(allMonitorValues);
		return allMonitorValues;
	}

	/**
	 * 设置停启用状态
	 * 
	 * @param allMonitorValues
	 *            2012-11-6
	 */
	private void dealForInitiateMode(IQBOQueryMonitorValue[] allMonitorValues) {
		for (IQBOQueryMonitorValue allMonitorValue : allMonitorValues) {
			if (null != allMonitorValue && !"".equals(allMonitorValue.getInitiateMode())
					&& null != allMonitorValue.getInitiateMode()) {
				if (WareMonitorConstant.JOB_TASK_STATUS_ENABLE.equals(allMonitorValue.getInitiateMode())) {
					allMonitorValue.setInitiateMode(WareMonitorConstant.JOB_TASK_STATUS_ENABLE_NAME);
				} else if (WareMonitorConstant.JOB_TASK_STATUS_UNENABLE.equals(allMonitorValue.getInitiateMode())) {
					allMonitorValue.setInitiateMode(WareMonitorConstant.JOB_TASK_STATUS_UNENABLE_NAME);
				} else {
					log.error("error date for initiateMode :=" + allMonitorValue.getInitiateMode());
				}
			}
		}
	}

	/**
	 * 设置超链接
	 * 
	 * @param allMonitorValues
	 *            2012-11-6
	 */
	private void fillHTMLOperationField(IQBOQueryMonitorValue[] allMonitorValues) {
		for (IQBOQueryMonitorValue allMonitorValue : allMonitorValues) {
			allMonitorValue
					.setOperate("&nbsp;&nbsp;<a href=\"#\" onclick=\"javascript:configuration('"
							+ allMonitorValue.getJobTaskId()
							+ "')\">配置</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"#\" onclick=\"javascript:bindObject('"
							+ allMonitorValue.getJobTaskId()
							+ "')\">绑定对象</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"#\" onclick=\"javascript:wareDetail('"
							+ allMonitorValue.getJobTaskId()
							+ "', '"
							+ (allMonitorValue.getMonitorType().contains(WareMonitorConstant.MONITOR_TYPE_WARE) ? WareMonitorConstant.MONITOR_TYPE_WARE
									: allMonitorValue.getMonitorType()) + "')\">查看礼品监控详情</a>");
		}
	}

	/**
	 * 转换warningType字段
	 * 
	 * @param allMonitorValues
	 *            2012-11-6
	 */
	private void dealForWarningType(IQBOQueryMonitorValue[] allMonitorValues) {
		for (IQBOQueryMonitorValue allMonitorValue : allMonitorValues) {
			if (null != allMonitorValue && !"".equals(allMonitorValue.getWarningType()) && null != allMonitorValue.getWarningType()) {
				allMonitorValue.setWarningType(allMonitorValue.getWarningType().replaceAll(
						WareMonitorConstant.ALARM_TYPE_MSG, WareMonitorConstant.ALARM_TYPE_MSG_NAME).replaceAll(
								WareMonitorConstant.ALARM_TYPE_EMAIL, WareMonitorConstant.ALARM_TYPE_EMAIL_NAME).replaceAll(
										WareMonitorConstant.SEMICOLON, WareMonitorConstant.SLIGHT_PAUSE_SERIES));
			}
		}
	}

	/**
	 * 转换monitorType字段
	 * @param allMonitorValues
	 * 2012-11-6
	 */
	private void dealForMonitorType(IQBOQueryMonitorValue[] allMonitorValues) {
		for (IQBOQueryMonitorValue allMonitorValue : allMonitorValues) {
			if (null != allMonitorValue && !"".equals(allMonitorValue.getMonitorType()) && null != allMonitorValue.getMonitorType()) {
				if (allMonitorValue.getMonitorType().contains(WareMonitorConstant.MONITOR_TYPE_WARE)) {
					allMonitorValue.setMonitorType(WareMonitorConstant.MONITOR_TYPE_WARE_NAME);
				} else if (WareMonitorConstant.MONITOR_TYPE_BIG_KIND.equals(allMonitorValue.getMonitorType())
						|| WareMonitorConstant.MONITOR_TYPE_MIDDLE_KIND.equals(allMonitorValue.getMonitorType())
						|| WareMonitorConstant.MONITOR_TYPE_SMALL_KIND.equals(allMonitorValue.getMonitorType())) {
					allMonitorValue.setMonitorType(WareMonitorConstant.MONITOR_TYPE_KIND_NAME);
				} else {
					log.error("error date for monitorObject :=" + allMonitorValue.getMonitorType());
				}
			}
		}
	}

	public int getAllMonitorValueCount(String wareCode, String firstKindId, String parentKindId, String kindId,
			String warningType, String initiateMode) throws Exception {
		// 由于查询关联了JOB_TASK表与JOB_OBJECT_RLT表的信息，一个JOB_TASK_ID可能关联两个或多个JOB_OBJECT_RLT表信息
		// 但是只能展示算一次，所以不能使用COUNT方法
		Map<String, String> parameter = new HashMap<String, String>();
		
//		IQBOAllMonitorValue[] allMonitorValues = wareMonitorDAO.getAllMonitorValue(processAllMonitorCondition(wareName,
//				firstKindId, parentKindId, kindId, warningType, initiateMode, parameter), parameter);
//		allMonitorValues = dealForAllMonitorValue(allMonitorValues);
//		return allMonitorValues.length;
		return wareMonitorDAO.getQueryMonitorCount(processAllMonitorCondition(wareCode,
				firstKindId, parentKindId, kindId, warningType, initiateMode, parameter), parameter);
	}

	/**
	 * 根据条件拼装查询SQL
	 * 
	 * @param wareCode
	 *            礼品编码
	 * @param firstKindId
	 *            业务类型
	 * @param parentKindId
	 *            中类
	 * @param kindId
	 *            小类
	 * @param warningType
	 *            告警类型
	 * @param initiateMode
	 *            监控启用状态
	 * @param parameter
	 * @return 2012-11-6
	 * @throws Exception
	 */
	private String processAllMonitorCondition(String wareCode, String firstKindId, String parentKindId,
			String kindId, String warningType, String initiateMode, Map<String, String> parameter) throws Exception {
		StringBuffer queryCondition = new StringBuffer(" 1=1 ");
//		// 礼品名称
//		if (!StringUtil.isBlank(wareCode)) {
//			StringBuffer queryCondition1 = new StringBuffer(" 1=1 ");
//			HashMap<String, String> parameter1 = new HashMap<String, String>();
//			parameter1.put(IWareInfoValue.S_WareName, "%" + wareName.trim() + "%");
//			IWareInfoValue[] wareInfoValues = wareInfoDAO.getInfoValue(queryCondition1.append(" AND ").append(
//					"UPPER(" + IWareInfoValue.S_WareName + ")").append(" LIKE ").append(
//					"UPPER( :" + IWareInfoValue.S_WareName + " )").toString(), parameter1);
//			if (wareInfoValues.length > 0) {
//				StringBuffer wareCodeCondition = new StringBuffer();
//				for (IWareInfoValue wareInfoValue : wareInfoValues) {
//					wareCodeCondition.append(wareInfoValue.getWareCode()).append(",");
//				}
//				log.info("query ware condition := " + wareCodeCondition);
//				if (wareCodeCondition.length() > 0) {
//					queryCondition.append(" AND ").append(IQBOAllMonitorValue.S_MonitorType).append("=:").append(
//							IQBOAllMonitorValue.S_MonitorType);
//					parameter.put(IQBOAllMonitorValue.S_MonitorType, WareMonitorConstant.MONITOR_TYPE_WARE);
//					queryCondition.append(" AND ").append(IQBOAllMonitorValue.S_MonitorObjectId).append(" in (")
//							.append(wareCodeCondition.substring(0, wareCodeCondition.length() - 1)).append(")");
//				} else {
//					// can not
//					log.error("we can get date := " + wareInfoValues.length + " but no length :=" + wareCodeCondition);
//				}
//			} else {
//				// 如果数据库中没有该礼品，则直接返回空
//				queryCondition.append(" AND 1 != 1");
//			}
//		}
		

		// 礼品编码
		if (!StringUtil.isBlank(wareCode)) {
			queryCondition.append(" AND ").append(IQBOAllMonitorValue.S_MonitorType).append(" like :").append(
					IQBOAllMonitorValue.S_MonitorType);
			parameter.put(IQBOAllMonitorValue.S_MonitorType, "%" + WareMonitorConstant.MONITOR_TYPE_WARE + "%");
			queryCondition.append(" AND ").append(IQBOAllMonitorValue.S_MonitorObjectId).append(" like :").append(
					IQBOAllMonitorValue.S_MonitorObjectId);
			parameter.put(IQBOAllMonitorValue.S_MonitorObjectId, "%" + wareCode + "%");
		}
		// 业务类型
		if (!StringUtil.isBlank(firstKindId) && !CommnConstant.QRY_OPTION_ALL.equals(firstKindId)) {
			queryCondition.append(" AND ").append(IQBOAllMonitorValue.S_MonitorType).append("=:").append(
					IQBOAllMonitorValue.S_MonitorType);
			parameter.put(IQBOAllMonitorValue.S_MonitorType, WareMonitorConstant.MONITOR_TYPE_BIG_KIND);
			queryCondition.append(" AND ").append(IQBOAllMonitorValue.S_MonitorObjectId).append("=:").append(
					IQBOAllMonitorValue.S_MonitorObjectId);
			parameter.put(IQBOAllMonitorValue.S_MonitorObjectId, firstKindId);
		}
		// 中类
		if (!StringUtil.isBlank(parentKindId) && !CommnConstant.QRY_OPTION_ALL.equals(parentKindId)) {
			queryCondition.append(" AND ").append(IQBOAllMonitorValue.S_MonitorType).append("=:").append(
					IQBOAllMonitorValue.S_MonitorType);
			parameter.put(IQBOAllMonitorValue.S_MonitorType, WareMonitorConstant.MONITOR_TYPE_MIDDLE_KIND);
			queryCondition.append(" AND ").append(IQBOAllMonitorValue.S_MonitorObjectId).append("=:").append(
					IQBOAllMonitorValue.S_MonitorObjectId);
			parameter.put(IQBOAllMonitorValue.S_MonitorObjectId, parentKindId);
		}
		// 小类
		if (!StringUtil.isBlank(kindId) && !CommnConstant.QRY_OPTION_ALL.equals(kindId)) {
			queryCondition.append(" AND ").append(IQBOAllMonitorValue.S_MonitorType).append("=:").append(
					IQBOAllMonitorValue.S_MonitorType);
			parameter.put(IQBOAllMonitorValue.S_MonitorType, WareMonitorConstant.MONITOR_TYPE_SMALL_KIND);
			queryCondition.append(" AND ").append(IQBOAllMonitorValue.S_MonitorObjectId).append("=:").append(
					IQBOAllMonitorValue.S_MonitorObjectId);
			parameter.put(IQBOAllMonitorValue.S_MonitorObjectId, kindId);
		}
		// 告警类型
		if (!StringUtil.isBlank(warningType) && !CommnConstant.QRY_OPTION_ALL.equals(warningType)) {
			queryCondition.append(" AND ").append(IQBOAllMonitorValue.S_WarningType).append(" like :").append(
					IQBOAllMonitorValue.S_WarningType);
			parameter.put(IQBOAllMonitorValue.S_WarningType, "%" + warningType + "%");
		}
		// 监控启用状态
		if (!StringUtil.isBlank(initiateMode) && !CommnConstant.QRY_OPTION_ALL.equals(initiateMode)) {
			queryCondition.append(" AND ").append(IQBOAllMonitorValue.S_InitiateMode).append("=:").append(
					IQBOAllMonitorValue.S_InitiateMode);
			parameter.put(IQBOAllMonitorValue.S_InitiateMode, initiateMode);
		}
		queryCondition.append(" ORDER BY " + IQBOAllMonitorValue.S_CreateTime + " DESC ");

		return queryCondition.toString();
	}

	public IQBOAllMonitorValue[] queryMonitorDetail(String jobTaskId,String monitorType) throws Exception{
		log.info("Srv JOB_TASK_ID :="+jobTaskId+" MONITOR_TYPE :="+monitorType);
		return wareMonitorDAO.queryMonitorDetail(jobTaskId, monitorType);
	}

	public IQBOMonitorWareValue[] queryMonitorWare(String jobtaskid) throws Exception{
		return wareMonitorDAO.queryMonitorWare(jobtaskid);
	}
	


	public boolean staffJobIsBind(String staffIds, String taskId, boolean flag,long operatorId)
			throws Exception {

		String[] ids = staffIds.split(",");
		for(String staffId : ids){
			wareMonitorDAO.staffJobIsBind(staffId, taskId, flag,operatorId);
		}
		return true;

	}

	public IQBOJobDateValue[] queryWareMonitor(String taskId) throws Exception {
		StringBuffer sb = new StringBuffer();
		Map<String, String> parameter = new HashMap<String, String>();
		sb.append(IQBOJobDateValue.S_JobTaskId).append("=:").append(
				IQBOJobDateValue.S_JobTaskId);
		parameter.put(IQBOJobDateValue.S_JobTaskId, taskId);
		sb.append(" order by " + IQBOJobDateValue.S_SortId);
		return wareMonitorDAO.queryWareMonitor(sb.toString(), parameter);
	}
	
	
	public boolean saveWareMonitorRecord(String operateType, String operatorId,
			String taskId, String sendObjId, String descOfStatus) throws Exception {
		log.info("Start OperateType :="+operateType+" OperatorId :="+operatorId+"DescOfId := "+
				 "DescOfStatus := "+descOfStatus);
		
		return wareMonitorDAO.saveWareMonitorRecord(operateType,operatorId,taskId,sendObjId,descOfStatus);
	}

	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.ware.service.interfaces.IWareMonitorSrv#saveMonitorObject(java.lang.String, java.lang.String)
	 */
	public void saveMonitorObject(String monitorType, String monitorObjectId) throws Exception {
		
		long jobTaskId=wareMonitorDAO.addJobTask();
		
		IJobObjectRltValue[] jobObjectRltValues = createJobObjectRlt(monitorType,monitorObjectId);
		wareMonitorDAO.saveMonitorObject(jobObjectRltValues,jobTaskId);
	}
	
	private IJobObjectRltValue[] createJobObjectRlt(String monitorType,String monitorObjectId) throws AIException {
		
		if(WareMonitorConstant.MONITOR_TYPE_WARE.equals(monitorType)){
			String[] monitorObjectIds = monitorObjectId.split(",");
			IJobObjectRltValue[] jobObjectRltValues = new JobObjectRltBean[monitorObjectIds.length];
			for(int i=0;i<monitorObjectIds.length;i++){
				IJobObjectRltValue jobObjectRltValue = new JobObjectRltBean();
				jobObjectRltValue.setMonitorType(monitorType);
				jobObjectRltValue.setMonitorObjectId(monitorObjectIds[i]);
				
				jobObjectRltValues[i] = jobObjectRltValue;
			}
			return jobObjectRltValues;
		}else{
			IJobObjectRltValue jobObjectRltValue = new JobObjectRltBean();
			jobObjectRltValue.setMonitorType(monitorType);
			jobObjectRltValue.setMonitorObjectId(monitorObjectId);
			IJobObjectRltValue[] jobObjectRltValues = new JobObjectRltBean[1];
			jobObjectRltValues[0] = jobObjectRltValue;
			return jobObjectRltValues;
		}
	}
	public boolean wareMonitorTimeDel(String jobDateRltID) throws Exception {
		return wareMonitorDAO.wareMonitorTimeDel(jobDateRltID);
	}

	public String getMaxSort() throws Exception {
		// TODO Auto-generated method stub
	return wareMonitorDAO.getMaxSort();
	}

}
