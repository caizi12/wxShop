package ngves.asiainfo.core.ware.util;

import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.common.service.interfaces.ISysBusiLockInfoSrv;
import ngves.asiainfo.core.ware.WareConstant;
import ngves.asiainfo.core.common.util.SynUtil;
import ngves.asiainfo.core.ware.ivalues.IWareInfoValue;
import ngves.asiainfo.core.ware.ivalues.IWareUpDownPlanValue;
import ngves.asiainfo.core.ware.ivalues.IWareUpDownVersionValue;
import ngves.asiainfo.core.ware.service.interfaces.IWareInfoSrv;
import ngves.asiainfo.core.ware.service.interfaces.IWarePCInfoSrv;
import ngves.asiainfo.core.ware.service.interfaces.IWareStatusSrv;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;

public class WareStatusUtil {
	private static transient Log log = LogFactory.getLog(WareStatusUtil.class);

	
	/**
	 * 更新礼品的上下线状态
	 * @param wareId 礼品Id
	 * @param targetState 目标状态
	 * @param statusCause 上下线状态原因
	 * @param operType 操作类型
	 * @param staffId 操作
	 * @throws Exception
	 */
	public static boolean updateWareState(WareStatusTask task)throws Exception{
		//是否更新礼品上下线成功
		boolean isUpdateStateSucc = false;
		
		String wareId =task.getWareId();
		String targetState = task.getTargetState();
		String statusCause = task.getWareStatusCause();
		String operType = task.getOperType();
		long staffId = task.getStaffId();
		String note = task.getNote();
		String cause = task.getCause();
		String operater=task.getOperater();
		//ruleId 自动上下线时，设置该参数，保存在BAK_CAL字段
		String ruleId = task.getRuleId();
		
		String wareUpDownPlanId = task.getWareUpDownPlanId();
		//业务锁服务
		ISysBusiLockInfoSrv busiLockInfoSrv = (ISysBusiLockInfoSrv)ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_SYS_BUSI_LOCK_SRV);	
		//礼品基本信息服务
		IWareInfoSrv wareInfoSrv = (IWareInfoSrv)ServiceFactory.getService(CoreSrvContstant.SERVICE_WARE_INFO);
		//礼品上下线服务
		IWareStatusSrv wareStatusSrv = (IWareStatusSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_SYS_WARE_STATUS_SRV);
		//父子礼品的状态服务
		IWarePCInfoSrv warePCInfoSrv = (IWarePCInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_WARE_PARENT_CHILDREN_INFO_SRV);
		
		
		if(StringUtil.isBlank(wareId)){
			throw new Exception("when update ware status ,wareId is blank...");
		}
		
		IWareUpDownVersionValue wareUpDownVersion = null;
		IWareUpDownPlanValue wareUpDownPlan = null;
		final String WARE_STATUS_TYPE ="04";
		//获得业务锁
		boolean locked = busiLockInfoSrv.gainBusiLock(wareId, WARE_STATUS_TYPE,staffId);
		
		if(locked){
			//加锁成功
			log.info("update status of ware. lock successed...");
			try {

				IWareInfoValue  wareInfoValue = wareInfoSrv.getBean(Long.parseLong(wareId));
				// 1、利用wareId获得礼品信息
				//1.1 、根据礼品当前状况和礼品目标状态，判断是否可以执行上下线。
				boolean isAccess = WareStatusAccessMap.getAccessValue(wareInfoValue.getWareStatus(), targetState, operType);
				if(isAccess){
					//状态的路径为可达的路径
					
					//1.1.2根据wareId查询ware_updown_version表数据。
					wareUpDownVersion = wareStatusSrv.getWareUpDownVersion(wareId);
					
					if(null == wareUpDownVersion){
						//没有数据，向表中插入数据
						wareStatusSrv.saveWareUpDownVersion(wareId, targetState);
					}else{
						//存在数据，更新一下 //更新成为目标状态
						wareUpDownVersion.setWareStatus(targetState);
						wareStatusSrv.updateWareUpDownVersion(wareUpDownVersion);
					}
					// 礼品上线还是下线
					String statusOperate = null;
					if(WareConstant.SYS_CORE_WARE_STATUS_ONLINE.equals(targetState)){
						//目标状态为上线
						statusOperate = WareConstant.SYS_UP_OPERATE;
					}else if(WareConstant.SYS_CORE_WARE_STATUS_OFFLINE.equals(targetState)){
						//目标状态为下线
						statusOperate = WareConstant.SYS_DOWN_OPERATE;
					}
					//================================================================
					//记录礼品上下线日志
					//我还是把保存的信息扔给别人吧！！！
					wareStatusSrv.saveWareUpDownHis(wareId, statusOperate, cause, note,ruleId,operater,statusCause);
				
					//如果存在上下线任务，将任务状态设置为已经完成
					if(!StringUtil.isBlank(wareUpDownPlanId)){
						//存在数据[ 任务状态已经被更新为正在执行  ]
						wareUpDownPlan = wareStatusSrv.getWareUpDownPlanValueById(wareUpDownPlanId);
						//将任务状态设置为已经执行
						if(WareConstant.SYS_CORE_WARE_UP_DOWN_PLAN_STATUS_DOING.equals(wareUpDownPlan.getOpState())){
							wareUpDownPlan.setOpState(WareConstant.SYS_CORE_WARE_UP_DOWN_PLAN_STATUS_SUCCESS);
							wareStatusSrv.saveWareUpDownPlan(wareUpDownPlan);
						}else{
							log.info("the state of fixed time job  is changed by other process. this instructions cann't update state.please check the databases.");
						}
						
					}
					
					//2、更新礼品状态为指定状态wareStatus
					wareInfoValue.setStsToOld();
					//更新礼品状态
					wareInfoValue.setWareStatus(targetState);
					//更新礼品上下线原因
					wareInfoValue.setStatusCause(statusCause);
					//更新礼品备注
					wareInfoValue.setNote(note);
					//更新礼品最后更新时间
					wareInfoValue.setLastUpdateDate(DateTimeUtil.getNowTimeStamp());
					if (WareConstant.SYS_UP_OPERATE.equals(statusOperate)) {
						//上线时间
						wareInfoValue.setOpenDate(DateTimeUtil.getNowTimeStamp());
					}else if(WareConstant.SYS_DOWN_OPERATE.equals(statusOperate)) {
						//下线时间
						wareInfoValue.setCloseDate(DateTimeUtil.getNowTimeStamp());
					}
					//更新最后操作人
					wareInfoValue.setLastUpdateStaffId(staffId);
					//保存礼品信息
					wareInfoSrv.saveWareInfo(wareInfoValue);
					
					//===父子礼品状态更新===
					IWareInfoValue[] arrayValues = new IWareInfoValue[1];
					arrayValues[0] = wareInfoValue;
					
					warePCInfoSrv.upDownLineWareInfoParent(arrayValues, statusOperate);
					//===父子礼品状态更新结束===
					
					// 保存同步HP的信号量
					SynUtil.addSynInfo(CoreConstant.SYS_PARA_SYN_TYPE_WARE, Long.parseLong(wareId),
							CoreConstant.SYS_PARA_SYN_INFO_STATE_MODIFY);
					isUpdateStateSucc = true;
				}else{
					// 操作不可达到，请记录日志
					if(log.isDebugEnabled()){
						log.debug("curren operType is "+operType +" cannot change ware status from "+wareInfoValue.getWareStatus()+" to "+targetState +".please check it!");
					}
					
					// 如果存在上下线任务，将任务状态设置为处理失败
					if(!StringUtil.isBlank(wareUpDownPlanId)){
						wareUpDownPlan = wareStatusSrv.getWareUpDownPlanValueById(wareUpDownPlanId);
						//将任务状态设置为处理失败
						if(WareConstant.SYS_CORE_WARE_UP_DOWN_PLAN_STATUS_DOING.equals(wareUpDownPlan.getOpState())){
							wareUpDownPlan.setOpState(WareConstant.SYS_CORE_WARE_UP_DOWN_PLAN_STATUS_ERROR);
							wareStatusSrv.saveWareUpDownPlan(wareUpDownPlan);

						}
					}
					isUpdateStateSucc = false;
				}
			} catch (Exception e) {
				//记录异常信息
				log.error("update ware state error,ware_id is "+wareId, e);
				
				//如果存在上下线任务，将任务状态设置为处理失败
				if(!StringUtil.isBlank(wareUpDownPlanId)){
					wareUpDownPlan = wareStatusSrv.getWareUpDownPlanValueById(wareUpDownPlanId);
					//将任务状态设置为处理失败
					if(WareConstant.SYS_CORE_WARE_UP_DOWN_PLAN_STATUS_DOING.equals(wareUpDownPlan.getOpState())){
						wareUpDownPlan.setOpState(WareConstant.SYS_CORE_WARE_UP_DOWN_PLAN_STATUS_ERROR);
						wareStatusSrv.saveWareUpDownPlan(wareUpDownPlan);

					}
				}
				isUpdateStateSucc = false;
				
			} finally {
				// 解锁
				if (locked) {
					busiLockInfoSrv.releaseBusiLock(wareId, WARE_STATUS_TYPE);
	                log.info("update status of ware.  unlocked successfully ");
				}
			}
		}else{
			//记录没有抢到业务锁的日志
			//抢夺资源失败，记录异常信息
			log.info("there occors concurrent operation, this job can not access the critical section whose semaphore is occupied by other progress.. ");
			//抛出异常，让本事务回滚。
			isUpdateStateSucc = false;

		}
		return isUpdateStateSucc;
 
	}
	
	/**
	 * 获取取消定时模板内容
	 * 
	 * @param wareName
	 *            礼品名称
	 * @param operType
	 *            操作类型
	 * @param operName
	 *            操作人
	 * @return 2012-6-19
	 */
	public static String getPreSMSContent(String wareName, String operType, String operName) throws Exception {
		String SMSContent = WareConstant.CANCEL_PREOPERLINE_SMS_CONTENT.replaceAll("%s", wareName).replaceAll("%t",
				operType).replaceAll("%u", operName);
		return SMSContent;
	}

	/**
	 * 获取执行定时模板内容
	 * 
	 * @param wareName
	 *            礼品名称
	 * @param operType
	 *            操作类型
	 * @param isSuccess
	 *            执行是否成功
	 * @return 2012-6-19
	 */
	public static String getPreSMSContent(String wareName, String operType, boolean isSuccess) throws Exception {
		String isSuccessString = "失败";
		if (isSuccess) {
			isSuccessString = "成功";
		}
		String SMSContent = WareConstant.RUN_PREOPERLINE_SMS_CONTENT.replaceAll("%s", wareName).replaceAll("%t",
				operType).replaceAll("%u", isSuccessString);
		return SMSContent;
	}
	public static String getPreSMSContent(String staffName, String operType,int length,String[] 
	          arrayWareNames,String arrayPreStatus,String[] arrayWareStatus,String createTime,String opTime,
	          String[] arrayStatusCause,String[] arrayPreStatusCause, boolean isSuccess) throws Exception {
		String wareName="";
		for(int i=0;i<arrayWareNames.length&&i<3;i++){
			wareName+=arrayWareNames[i]+"、";
		}
		wareName = wareName.substring(0, wareName.length() - 1);
		if(arrayWareNames.length>3){
			wareName+="等";	
		}
		String isSuccessString = "失败";
		if (isSuccess) {
			isSuccessString = "成功";
		}
		StringBuffer SMSContent = new StringBuffer("");
		SMSContent.append(staffName).append("于").append(createTime).append("设置的")
	        	  .append(opTime).append("的").append(wareName).append("的")
			      .append(operType).append("任务于").append(opTime).append("执行")
			      .append(isSuccessString).append("，");
		if (length == 1) {
			SMSContent.append("该礼品的状态由").append(arrayWareStatus[0]).append("更改为")
			         .append(arrayPreStatus).append("，礼品上下线原因由").append(arrayStatusCause[0])
			         .append("更新为").append(arrayPreStatusCause[0]).append("，详情请登录管理平台查看。");
		} else {
			for (int i = 0; i < length&&i<3; i++) {
				SMSContent.append(arrayWareNames[i]).append("礼品的状态由").append(arrayWareStatus[i])
				.append("更新为").append(arrayPreStatus).append("，");
			}
			if(length>3){
				SMSContent.append("...，");
			}
			SMSContent.append("详情请登录管理平台查看。");
		}
		return SMSContent.toString();
	}
}
