package ngves.asiainfo.core.rechargepoints.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.common.bo.BusiInfoEngine;
import ngves.asiainfo.core.common.service.interfaces.ISysBusiLockInfoSrv;
import ngves.asiainfo.core.common.util.BusiInfoUtil;
import ngves.asiainfo.core.order.OrderConstant;
import ngves.asiainfo.core.rechargepoints.bo.BusiRechargeFileBean;
import ngves.asiainfo.core.rechargepoints.bo.BusiRechargePointsTaskBean;
import ngves.asiainfo.core.rechargepoints.bo.BusiRechargePointsTaskEngine;
import ngves.asiainfo.core.rechargepoints.bo.BusiRechargeTaskAuditBean;
import ngves.asiainfo.core.rechargepoints.bo.BusiRechargeTaskAuditEngine;
import ngves.asiainfo.core.rechargepoints.bo.RechargeFileBean;
import ngves.asiainfo.core.rechargepoints.bo.RechargePointsTaskBean;
import ngves.asiainfo.core.rechargepoints.bo.RechargePointsTaskEngine;
import ngves.asiainfo.core.rechargepoints.dao.interfaces.IRechargePointsTaskDAO;
import ngves.asiainfo.core.rechargepoints.ivalues.IBusiRechargeFileValue;
import ngves.asiainfo.core.rechargepoints.ivalues.IBusiRechargePointsTaskValue;
import ngves.asiainfo.core.rechargepoints.ivalues.IBusiRechargeTaskAuditValue;
import ngves.asiainfo.core.rechargepoints.ivalues.IQBORechargeFileValue;
import ngves.asiainfo.core.rechargepoints.ivalues.IRechargeFileValue;
import ngves.asiainfo.core.rechargepoints.ivalues.IRechargePointsTaskValue;
import ngves.asiainfo.core.rechargepoints.model.RechargePointModel;
import ngves.asiainfo.core.rechargepoints.service.interfaces.IRechargePointsTaskSrv;
import ngves.asiainfo.interfaces.hp.bean.rechargeTaskCancelNotice.in.RechargeTaskCancelNoticeInBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.rechargeTaskCancelNotice.in.RechargeTaskCancelNoticeInRollbackList;
import ngves.asiainfo.interfaces.hp.bean.rechargeTaskCancelNotice.out.RechargeTaskCancelNoticeOutBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.rechargeTaskCancelNotice.out.RechargeTaskCancelNoticeOutTaskList;
import ngves.asiainfo.interfaces.hp.realtime.RechargeTaskCancelNoticeInter;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.JDBCUtils;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.secframe.ivalues.orgmodel.ISysStaffValue;

/**
 * 积分返赠任务管理服务层实现
 * @author yeqh
 * 2014-08-29
 */

public class RechargePointsTaskSrvImpl implements IRechargePointsTaskSrv {
	
	private static Log logger = LogFactory.getLog(RechargePointsTaskSrvImpl.class);
	
	private IRechargePointsTaskDAO rechargePointsTaskDAO;

	public void setRechargePointsTaskDAO(IRechargePointsTaskDAO rechargePointsTaskDAO) {
		this.rechargePointsTaskDAO = rechargePointsTaskDAO;
	}
	
	/**
	 * 根据 rechargeTaskId 查询任务详情
	 * @param rechargeTaskId
	 * @return
	 * @throws Exception
	 */
	public IBusiRechargeTaskAuditValue[] queryRechargePointsTaskInfo(String rechargeTaskId)throws Exception {
		return rechargePointsTaskDAO.queryRechargePointsTaskInfo(rechargeTaskId);
	}
	
	/**
	 * 根据 rechargeTaskId 查询处理详情
	 * @param rechargeTaskId
	 * @return
	 * @throws Exception
	 */
	public IRechargeFileValue[] queryRechargePointsTaskDetail(String rechargeTaskId)throws Exception {
		return setTaskDetailBakCol1(rechargePointsTaskDAO.queryRechargePointsTaskDetail(rechargeTaskId));
	}
	
	/**
	 * 根据 rechargeFileId 查询任务结果
	 * @param rechargeTaskId
	 * @return
	 * @throws Exception
	 */
	public IRechargeFileValue[] queryRechargePointsTaskResult(String rechargeFileId)throws Exception {
		return setTaskResultBakCol1(rechargePointsTaskDAO.queryRechargePointsTaskResult(rechargeFileId));
	}
	
	/**
	 * 积分反赠管理页、初审页、复审页查询
	 * @param taskStatus
	 * @param taskName
	 * @param jspStatus
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public IRechargePointsTaskValue[] queryRechargePointsTaskList(String taskStatus,String taskName,String jspStatus,int startNum, int endNum)throws Exception{
		return setTaskListBakCol1(rechargePointsTaskDAO.queryRechargePointsTaskList(taskStatus,taskName,jspStatus,startNum,endNum),jspStatus);
		
	}
	
	/**
	 * 积分反赠管理页、初审页、复审页查询数量
	 * @param taskStatus
	 * @param taskName
	 * @param jspStatus
	 * @return
	 * @throws Exception
	 */
	public int queryRechargePointsTaskListCount (String taskStatus,String taskName,String jspStatus)throws Exception{
		return rechargePointsTaskDAO.queryRechargePointsTaskListCount(taskStatus,taskName,jspStatus);
	}
	
	private IRechargePointsTaskValue[] setTaskListBakCol1(IRechargePointsTaskValue[] queryRechargePointsTaskList,String jspStatus) {
		for(IRechargePointsTaskValue value:queryRechargePointsTaskList){
			StringBuffer bak_col = new StringBuffer();
			//不管任何状态都有任务详情操作
			bak_col.append(String.format("<a href=\'#\' onclick=\'javascript:TaskInfo(%s)'>&nbsp;任务详情&nbsp;</a>", value.getRechargeTaskId()));
			//管理页
			if((CoreConstant.RECHARGE_POINTS_TASK_JSP_MANAGER).equals(jspStatus)){
				//任务状态：起草、初审不通过、审核不通过的可以有修改、删除操作
				if((CoreConstant.RECHARGE_POINTS_TASK_STATUS_DRAFT+","+CoreConstant.RECHARGE_POINTS_TASK_STATUS_NOTFIRSTVERIFY+","+CoreConstant.RECHARGE_POINTS_TASK_STATUS_NOTSECONDVERIFY).indexOf(value.getTaskStatus())>=0){
					bak_col.append(String.format("<a href=\'#\' onclick=\'javascript:modifyTask(%s)'>&nbsp;修改&nbsp;</a>", value.getRechargeTaskId()));
					bak_col.append(String.format("<a href=\'#\' onclick=\'javascript:deleteTask(%s)'>&nbsp;删除&nbsp;</a>", value.getRechargeTaskId()));
				}
				//任务状态：待审核、初审通过的可以有撤回操作
				if((CoreConstant.RECHARGE_POINTS_TASK_STATUS_NOTVERIFY+","+CoreConstant.RECHARGE_POINTS_TASK_STATUS_FIRSTVERIFY).indexOf(value.getTaskStatus())>=0){
					bak_col.append(String.format("<a href=\'#\' onclick=\'javascript:withdraw(%s)'>&nbsp;撤回&nbsp;</a>", value.getRechargeTaskId()));
				}
				//任务状态：审核通过的可以有处理详情操作
				if((CoreConstant.RECHARGE_POINTS_TASK_STATUS_SECONDVERIFY).equals(value.getTaskStatus())){
					bak_col.append(String.format("<a href=\'#\' onclick=\'javascript:TaskDetail(%s)'>&nbsp;处理详情&nbsp;</a>", value.getRechargeTaskId()));
				}
				//任务状态：废止的可以有修改操作
				if((CoreConstant.RECHARGE_POINTS_TASK_STATUS_ABOLISH).equals(value.getTaskStatus())){
					bak_col.append(String.format("<a href=\'#\' onclick=\'javascript:modifyTask(%s)'>&nbsp;修改&nbsp;</a>", value.getRechargeTaskId()));
				}
			}
			//初审页
			if((CoreConstant.RECHARGE_POINTS_TASK_JSP_FIRST_TRIAL).equals(jspStatus)){
				//任务状态：待审核的可以有审核操作
				if((CoreConstant.RECHARGE_POINTS_TASK_STATUS_NOTVERIFY).equals(value.getTaskStatus())){
					bak_col.append(String.format("<a href=\'#\' onclick=\'javascript:Taskaudit(%s)'>&nbsp;审核&nbsp;</a>", value.getRechargeTaskId()));
				}
			}
			//复审页
			if((CoreConstant.RECHARGE_POINTS_TASK_JSP_REPEAT_TRIAL).equals(jspStatus)){
				//任务状态：初审通过的可以有审核操作
				if((CoreConstant.RECHARGE_POINTS_TASK_STATUS_FIRSTVERIFY).equals(value.getTaskStatus())){
					bak_col.append(String.format("<a href=\'#\' onclick=\'javascript:Taskaudit(%s)'>&nbsp;审核&nbsp;</a>", value.getRechargeTaskId()));
				}
				//任务状态：审核不通过的可以有处理详情操作
				if((CoreConstant.RECHARGE_POINTS_TASK_STATUS_SECONDVERIFY).equals(value.getTaskStatus())){
					bak_col.append(String.format("<a href=\'#\' onclick=\'javascript:TaskDetail(%s)'>&nbsp;处理详情&nbsp;</a>", value.getRechargeTaskId()));
				}
			}
			value.setBakCol1(bak_col.toString());
			StringBuffer bak_col2 = new StringBuffer();
			bak_col2.append(String.format("<a href=\'#\' onclick=\'javascript:FileList(%s)'>&nbsp;文件列表&nbsp;</a>", value.getRechargeTaskId()));
			value.setBakCol2(bak_col2.toString());
			if(CoreConstant.RECHARGE_POINTS_TASK_TYPE_NOW.equals(value.getTaskType())){
				value.setTaskType(CoreConstant.RECHARGE_POINTS_TASK_NAME_NOW);
			}
			if(CoreConstant.RECHARGE_POINTS_TASK_TYPE_TIMING.equals(value.getTaskType())){
				value.setTaskType(CoreConstant.RECHARGE_POINTS_TASK_NAME_TIMING);
			}
		}
		return queryRechargePointsTaskList;
	}
	

	/**
	 * 在bak_col1列中添加操作具体连接（处理详情）
	 * @param queryRechargePointsTaskDetail
	 * @return
	 */
	private IRechargeFileValue[] setTaskDetailBakCol1(IRechargeFileValue[] queryRechargePointsTaskDetail) throws Exception {
		//添加操作列
		for(IRechargeFileValue value:queryRechargePointsTaskDetail){
			StringBuffer bak_col = new StringBuffer();
			//J903未处理、J905文件获取中、J908开始导入数据、J911等待充值、J912开始充值时，操作列展示“撤销”以及“任务结果”的链接，其余返回码仅展示“任务结果”的链接。
				if( !StringUtil.isBlank(value.getFileStatus())&&CoreConstant.RECHARGE_POINTS_FILE_STATUS_REPEAL.indexOf(value.getFileStatus())>=0){
					bak_col.append(String.format("<a href=\'#\' onclick=\'javascript:repeal(\"%s\")'>&nbsp;撤销&nbsp;</a>",value.getRechargeFileId()));
				}
				bak_col.append(String.format("<a href=\'#\' onclick=\'javascript:taskResult(\"%s\")'>&nbsp;任务结果&nbsp;</a>",value.getRechargeFileId()));
				value.setBakCol1(bak_col.toString());
		}
		return queryRechargePointsTaskDetail;
	}
	
	/**
	 * 在bak_col1列中添加操作具体连接（任务结果）
	 * @param queryRechargePointsTaskDetail
	 * @return
	 */
	private IRechargeFileValue[] setTaskResultBakCol1(IRechargeFileValue[] queryRechargePointsTaskResult) {
		//添加操作列
		for(IRechargeFileValue value:queryRechargePointsTaskResult){
			StringBuffer bak_col = new StringBuffer();
			bak_col.append(String.format("<a href=\'#\' onclick=\'javascript:downLoadFile(\"%s\")'>&nbsp;成功文件&nbsp;</a>", value.getSuccFilePath()));
			bak_col.append(String.format("<a href=\'#\' onclick=\'javascript:downLoadFile(\"%s\")'>&nbsp;失败文件&nbsp;</a>", value.getFailFilePath()));
			value.setBakCol1(bak_col.toString());
		}
		return queryRechargePointsTaskResult;
	}
	
	/**
	 * 根据 staffId 用户信息
	 * @param staffId
	 * @return
	 * @throws Exception
	 */
	public ISysStaffValue getUserInfo(long staffId) throws Exception {
		return rechargePointsTaskDAO.getUserInfo(staffId);
	}
	
	/**
	 * 保存任务、文件信息
	 * @param map
	 * @param rpm
	 * @throws Exception
	 */
	public void saveTaskInfo(Map<String, String> map ,RechargePointModel[] rpm)throws Exception{
		//保存任务表信息
		IRechargePointsTaskValue value=new RechargePointsTaskBean();
		value.setRechargeTaskId(Long.parseLong(RechargePointsTaskEngine.getNewId()+""));
		value.setTaskName(map.get("taskName"));
		value.setTaskType(map.get("taskType"));
		value.setExecutionTime(DateTimeUtil.stringToTimestamp(map.get("executionTime"),CommnConstant.DATETIME_JAVA_FORMAT));
		value.setTaskStatus(map.get("type"));
		value.setCreateTime(DateTimeUtil.getNowTimeStamp());
		value.setTaskChannel(map.get("taskChannel"));
		value.setActivityType(map.get("activityType"));
		value.setIsDeleted("0");
		value.setTaskManageStatus("00");
		value.setRequestSeq(JDBCUtils.getValueNewId());
		value.setAddpointActionId(value.getRechargeTaskId()+"");
		value.setChannelName(map.get("taskChannelName"));
		value.setActivityName(map.get("activityTypeName"));
		value.setTaskTitile(value.getChannelName()+value.getActivityName()+value.getTaskName());
		value.setUserRole("08");
		value.setUserId(map.get("code"));
		value.setMobile(map.get("billId"));
		//保存任务信息
		rechargePointsTaskDAO.saveTaskInfo(value);
		//保存流水任务信息
		recordBusiRechargePointsTask(value);
		IRechargeFileValue[] rfvs=new IRechargeFileValue[rpm.length];
		int i=0;
		for(RechargePointModel rf:rpm){
			IRechargeFileValue rfv=new RechargeFileBean();
			rfv.setRechargeFileId(rf.getTaskId());
			rfv.setRechargeFileName(rf.getFileName());
			rfv.setRechargeFileNickname("ADDPOINT_"+rf.getTaskId()+".xls");
			rfv.setRechargeTaskId(value.getRechargeTaskId());
			if(StringUtil.isBlank(rf.getContent())){
				rfv.setIsSendSms("0");
			}else{
				rfv.setIsSendSms("1");
				rfv.setSmsMessage(rf.getContent());
			}
			rfv.setIsDeleted("0");
			rfv.setFileManageStatus("00");
			rfv.setSuccCounts(0);
			rfv.setFailCounts(0);
			rfv.setNotRechargeCounts(0);
			rfvs[i] = rfv;
			i++;
			//保存流水文件信息
			recordBusiRechargeFile(rfv);
		}
		//保存文件信息
		rechargePointsTaskDAO.saveFileInfo(rfvs);
		//保存操作信息
		IBusiRechargeTaskAuditValue brta=new BusiRechargeTaskAuditBean();
		brta.setBusiId(Long.parseLong(BusiRechargeTaskAuditEngine.getNewId()+""));
		brta.setRechargeTaskId(value.getRechargeTaskId());
		brta.setOperatorCode(value.getUserId());
		brta.setAuditTime(DateTimeUtil.getNowTimeStamp());
		brta.setStatus(value.getTaskStatus());
		rechargePointsTaskDAO.saveTaskAudit(brta);
	}
	
	
	
	/**
	 * 将充值文件正式表中的对象作为参数，用于文件记录流水信息(由于短信内容较大，且流水无需关心这个，因此未对短信内容进行保存)
	 * @param rechargeFile
	 * @throws Exception
	 */
	public void recordBusiRechargeFile(IRechargeFileValue rechargeFile)throws Exception{
		IBusiRechargeFileValue busiRechargeFile = new BusiRechargeFileBean();
		//获取流水id
		busiRechargeFile.setRechargeFileId(rechargeFile.getRechargeFileId());
		busiRechargeFile.setBusiRechargeFileId(JDBCUtils.getValueNewId());
		busiRechargeFile.setBakCol1(rechargeFile.getBakCol1());
		busiRechargeFile.setBakCol2(rechargeFile.getBakCol2());
		busiRechargeFile.setFailCounts(rechargeFile.getFailCounts());
		busiRechargeFile.setFailFilePath(rechargeFile.getFailFilePath());
		busiRechargeFile.setFileManageStatus(rechargeFile.getFileManageStatus());
		busiRechargeFile.setFileStatus(rechargeFile.getFileStatus());
		busiRechargeFile.setIsDeleted(rechargeFile.getIsDeleted());
		busiRechargeFile.setIsSendSms(rechargeFile.getIsSendSms());
		busiRechargeFile.setNotRechargeCounts(rechargeFile.getNotRechargeCounts());
		busiRechargeFile.setRechargeFileName(rechargeFile.getRechargeFileName());
		busiRechargeFile.setRechargeFileNickname(rechargeFile.getRechargeFileNickname());
		busiRechargeFile.setRechargeTaskId(rechargeFile.getRechargeTaskId());
		busiRechargeFile.setSuccCounts(rechargeFile.getSuccCounts());
		busiRechargeFile.setSuccFilePath(rechargeFile.getSuccFilePath());
		
		this.rechargePointsTaskDAO.saveBusiRechargeFile(busiRechargeFile);
	}
	
	/**
	 * 将充值任务正式表中的对象作为参数，用于任务记录流水信息
	 * @param rechargePointsTask
	 * @throws Exception
	 */
	public void recordBusiRechargePointsTask(IRechargePointsTaskValue rechargePointsTask) throws Exception{
		IBusiRechargePointsTaskValue busiRechargePointsTask = new BusiRechargePointsTaskBean();
		
		busiRechargePointsTask.setBusiRechargeTaskId(BusiRechargePointsTaskEngine.getNewId().longValue());
		busiRechargePointsTask.setActivityName(rechargePointsTask.getActivityName());
		busiRechargePointsTask.setActivityType(rechargePointsTask.getActivityType());
		busiRechargePointsTask.setAddpointActionId(rechargePointsTask.getAddpointActionId());
		busiRechargePointsTask.setBakCol1(rechargePointsTask.getBakCol1());
		busiRechargePointsTask.setBakCol2(rechargePointsTask.getBakCol2());
		busiRechargePointsTask.setBakCol3(rechargePointsTask.getBakCol3());
		busiRechargePointsTask.setCancelCause(rechargePointsTask.getCancelCause());
		busiRechargePointsTask.setChannelName(rechargePointsTask.getChannelName());
		busiRechargePointsTask.setCreateTime(rechargePointsTask.getCreateTime());
		busiRechargePointsTask.setExecutionTime(rechargePointsTask.getExecutionTime());
		busiRechargePointsTask.setFirstTime(rechargePointsTask.getFirstTime());
		busiRechargePointsTask.setFirstTrialCode(rechargePointsTask.getFirstTrialCode());
		busiRechargePointsTask.setIsDeleted(rechargePointsTask.getIsDeleted());
		busiRechargePointsTask.setIsSendSms(rechargePointsTask.getIsSendSms());
		busiRechargePointsTask.setMobile(rechargePointsTask.getMobile());
		busiRechargePointsTask.setRechargeTaskId(rechargePointsTask.getRechargeTaskId());
		busiRechargePointsTask.setActivityName(rechargePointsTask.getActivityName());
		busiRechargePointsTask.setRequestSeq(rechargePointsTask.getRequestSeq());
		busiRechargePointsTask.setReTrialCode(rechargePointsTask.getReTrialCode());
		busiRechargePointsTask.setSecondTime(rechargePointsTask.getSecondTime());
		busiRechargePointsTask.setTaskChannel(rechargePointsTask.getTaskChannel());
		busiRechargePointsTask.setTaskManageStatus(rechargePointsTask.getTaskManageStatus());
		busiRechargePointsTask.setTaskName(rechargePointsTask.getTaskName());
		busiRechargePointsTask.setTaskStatus(rechargePointsTask.getTaskStatus());
		busiRechargePointsTask.setTaskTitile(rechargePointsTask.getTaskTitile());
		busiRechargePointsTask.setTaskType(rechargePointsTask.getTaskType());
		busiRechargePointsTask.setUserId(rechargePointsTask.getUserId());
		busiRechargePointsTask.setUserRole(rechargePointsTask.getUserRole());
		
		this.rechargePointsTaskDAO.saveBusiRechargePointsTask(busiRechargePointsTask);
	}

	/**
	 * 删除任务、文件信息
	 * @param taskId
	 * @throws Exception
	 */
	public void deleteTaskInfo(String taskId,long staffId,String comType,long orgId) throws Exception {
		IRechargePointsTaskValue rpt = rechargePointsTaskDAO.getTaskId(taskId);
		IRechargeFileValue[] rf=rechargePointsTaskDAO.getTaskFileId(taskId);
		//状态不是起草、初审不通过、审核不通过的不能进行删除
		if(!CoreConstant.RECHARGE_POINTS_TASK_STATUS_DRAFT.equals(rpt.getTaskStatus())&&
				!CoreConstant.RECHARGE_POINTS_TASK_STATUS_NOTFIRSTVERIFY.equals(rpt.getTaskStatus())&&
				!CoreConstant.RECHARGE_POINTS_TASK_STATUS_NOTSECONDVERIFY.equals(rpt.getTaskStatus())){
			throw new Exception("can not delete the rechargePointsTask!");
		}
		//已删除的不能进行删除
		if("1".equals(rpt.getIsDeleted())){
			throw new Exception("can not delete the RechargePointsTask, this's deleted!");
		}
		rpt.setIsDeleted("1");
		//保存删除信息（注意删除没有记日志）
		for (IRechargeFileValue value:rf) {
			if("0".equals(value.getIsDeleted())){
				value.setIsDeleted("1");
			}
			recordBusiRechargeFile(value);
		}
		//记录操作日志
		
		BusiInfoUtil.recordBusiInfo(BusiInfoEngine.getNewId().longValue()+ "",CoreConstant.SYS_PARA_BUSI_TYPE_DELETE_RECHARGE_TASK, staffId , "删除积分返赠任务",
				CoreConstant.BUSI_INFO_OPT_TYPE_DELETE, "任务名称:"+rpt.getTaskName()+",任务Id："+rpt.getRechargeTaskId(),staffId, comType, orgId);
		rechargePointsTaskDAO.saveFileInfo(rf);
		recordBusiRechargePointsTask(rpt);
		rechargePointsTaskDAO.saveTaskInfo(rpt);
	}

	/**
	 * 查询文件列表页信息
	 * @param rechargeTaskId
	 * @return
	 * @throws Exception
	 */
	public IQBORechargeFileValue[] queryRechargePointsTaskFileList(String rechargeTaskId) throws Exception {
		IQBORechargeFileValue[] rf=rechargePointsTaskDAO.queryRechargePointsTaskFileList(rechargeTaskId);
		//添加操作列
		for(IQBORechargeFileValue value:rf){
			//0：不发送短信      1：发送短信
			if(CoreConstant.RECHARGE_POINTS_TASK_IS_SEND_SMS_NO.equals(value.getIsSendSms())){
				value.setIsSendSms("否");
			}
			if(CoreConstant.RECHARGE_POINTS_TASK_IS_SEND_SMS_YES.equals(value.getIsSendSms())){
				value.setIsSendSms("是");
			}
			StringBuffer rechargeFileName = new StringBuffer();
			rechargeFileName.append(String.format("<a href=\'#\' onclick=\'javascript:downLoadFile(\"%s\")'>"+value.getRechargeFileName()+"</a>", value.getRechargeFileNickname()));
			value.setRechargeFileName(rechargeFileName.toString());
		}
		return rf;
	}
	
	

	/**
	 * 撤回
	 * @param map
	 * @throws Exception
	 */
	public void backTask(Map<String, String> map) throws Exception {
		//业务锁服务
		ISysBusiLockInfoSrv busiLockInfoSrv = (ISysBusiLockInfoSrv)ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_SYS_BUSI_LOCK_SRV);
		boolean locked = busiLockInfoSrv.gainBusiLock(map.get("taskId"), "001",-1);//taskId 与 001 作为唯一主键   形成业务锁。
		 try {
  		   String code=map.get("code");
		   String taskId=map.get("taskId");
		   String content=map.get("content");
		   String operTime=map.get("operTime");
	       if(locked) {
	    	   IRechargePointsTaskValue rpt = rechargePointsTaskDAO.getTaskId(taskId);
	    	   if(null != rpt){
	    		   //状态判断
	    		   if(!isAllowOperate(rpt.getTaskStatus(),CoreConstant.RECHARGE_POINTS_TASK_STATUS_DRAFT)){
 					   throw new Exception("操作失败,请稍后重试!");
 					}
	    		   if(StringUtil.isBlank(operTime)){
	    			   operTime = DateTimeUtil.dateToString(DateTimeUtil.getNowDate(), CommnConstant.DATETIME_JAVA_FORMAT);
   					}
	    		   if(rpt.getTaskStatus() != null && !"null".equals(rpt.getTaskStatus())){//表示存在任务
	    			   if("1".equals(rpt.getIsDeleted())){//此任务已被删除，不能在进行操作
              			 throw new Exception("操作失败,请稍后重试!");
	    			   } 
	    			   rpt.setTaskStatus(CoreConstant.RECHARGE_POINTS_TASK_STATUS_DRAFT);
	    			   rpt.setFirstTime(null);
	    			   rpt.setCancelCause(content);
	    			   rpt.setFirstTime(null);
	    			   //保存任务信息
	    			   rechargePointsTaskDAO.saveTaskInfo(rpt);
	    			   //保存流水任务信息
	    			   recordBusiRechargePointsTask(rpt);
	    			   IBusiRechargeTaskAuditValue brta=new BusiRechargeTaskAuditBean();
						brta.setBusiId(Long.parseLong(BusiRechargeTaskAuditEngine.getNewId()+""));
						brta.setRechargeTaskId(Long.parseLong(taskId));
						brta.setOperatorCode(code);
						brta.setAuditTime(DateTimeUtil.getNowTimeStamp());
						brta.setStatus(CoreConstant.RECHARGE_POINTS_TASK_STATUS_DRAFT);
						brta.setAuditContent(content);
						//保存操作信息
						rechargePointsTaskDAO.saveTaskAudit(brta);
	    		   	}
	    	   }
	       }
		 }catch (Exception e ) {
            logger.warn("The system is busy, please try again later!", e);
			throw new Exception("操作失败,请稍后重试!", e);
        } finally {
           	if (locked) {
           		busiLockInfoSrv.releaseBusiLock(map.get("taskId"), "001");
           	}
           	logger.info("SysBusiLockInfo  unlocked successfully ");
		}
	}
	
	/**
	 * 这里做系统的状态判断，防止多人同时操作，对单一对象操作，造成不必要的修改
	 * @param oldStatus 旧状态
	 * @param newStatus 新状态
	 * @throws Exception
	 */
	private boolean isAllowOperate(String oldStatus,String newStatus)  throws Exception {
		if(( oldStatus == null || "null".equals(oldStatus) ) && (CoreConstant.RECHARGE_POINTS_TASK_STATUS_NOTVERIFY.equals(newStatus) ||CoreConstant.RECHARGE_POINTS_TASK_STATUS_DRAFT.equals(newStatus))
	    ){//新增的 -->起草，待审核
			return true;
		}else if(CoreConstant.RECHARGE_POINTS_TASK_STATUS_DRAFT.equals(oldStatus) && (CoreConstant.RECHARGE_POINTS_TASK_STATUS_NOTVERIFY.equals(newStatus) ||CoreConstant.RECHARGE_POINTS_TASK_STATUS_DRAFT.equals(newStatus))
	    ){ // 起草-->起草，带审核
	    	return true;
	    }else if(CoreConstant.RECHARGE_POINTS_TASK_STATUS_NOTVERIFY.equals(oldStatus) && 
				(CoreConstant.RECHARGE_POINTS_TASK_STATUS_DRAFT.equals(newStatus) || CoreConstant.RECHARGE_POINTS_TASK_STATUS_FIRSTVERIFY.equals(newStatus)
						|| CoreConstant.RECHARGE_POINTS_TASK_STATUS_NOTFIRSTVERIFY.equals(newStatus))
			){// 待审核-->撤回到起草,初审通过,初审不通过
			return true;
		}else if(CoreConstant.RECHARGE_POINTS_TASK_STATUS_NOTFIRSTVERIFY.equals(oldStatus) &&(CoreConstant.RECHARGE_POINTS_TASK_STATUS_NOTVERIFY.equals(newStatus)||CoreConstant.RECHARGE_POINTS_TASK_STATUS_DRAFT.equals(newStatus))
			){// 初审不通过-->待审核（修改后）,起草
			return true;
		}else if(CoreConstant.RECHARGE_POINTS_TASK_STATUS_FIRSTVERIFY.equals(oldStatus) &&(CoreConstant.RECHARGE_POINTS_TASK_STATUS_DRAFT.equals(newStatus)||
						CoreConstant.RECHARGE_POINTS_TASK_STATUS_SECONDVERIFY.equals(newStatus) ||CoreConstant.RECHARGE_POINTS_TASK_STATUS_NOTSECONDVERIFY.equals(newStatus))
			){//初审通过-->撤回到起草,审核通过,审核不通过
			return true;
		}else if(CoreConstant.RECHARGE_POINTS_TASK_STATUS_NOTSECONDVERIFY.equals(oldStatus) && 
				(CoreConstant.RECHARGE_POINTS_TASK_STATUS_NOTVERIFY.equals(newStatus)||CoreConstant.RECHARGE_POINTS_TASK_STATUS_DRAFT.equals(newStatus))
			){//审核不通过--> 待审核（修改后）,起草
			return true;
		}else if(CoreConstant.RECHARGE_POINTS_TASK_STATUS_ABOLISH.equals(oldStatus) && (CoreConstant.RECHARGE_POINTS_TASK_STATUS_NOTVERIFY.equals(newStatus) ||CoreConstant.RECHARGE_POINTS_TASK_STATUS_DRAFT.equals(newStatus))
	    ){ // 废止-->起草，带审核
	    	return true;
	    }else{
			return false;
		}
	}
	
	/**
	 * 撤销
	 * @param map
	 * @throws Exception
	 */
	public void repeal(String rechargeFileId)throws Exception{
		ISysBusiLockInfoSrv busiLockInfoSrv = (ISysBusiLockInfoSrv)ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_SYS_BUSI_LOCK_SRV);
		boolean locked = busiLockInfoSrv.gainBusiLock(rechargeFileId, "002",-1);//taskId 与 002 作为唯一主键   形成业务锁。
		try{
			if(locked) {
				IRechargeFileValue rf=rechargePointsTaskDAO.queryRechargeFile(rechargeFileId);
				if(rf!=null){
					if( CoreConstant.RECHARGE_POINTS_FILE_STATUS_REPEAL.indexOf(rf.getFileStatus())>=0){
						//状态判断
		    		   if(StringUtil.isBlank(rf.getFileStatus())&&CoreConstant.RECHARGE_POINTS_FILE_STATUS_REPEAL.indexOf(rf.getFileStatus())<0){
	 					   throw new Exception("操作失败,请稍后重试!");
	 					}
						//不是删除的文件
						if("1".equals(rf.getIsDeleted())){
							throw new Exception("操作失败,请稍后重试!");
						}
						//拼接报文
						RechargeTaskCancelNoticeInBizRegReq in=RechargeTaskCancelNoticeInter.RechargeTaskCancelNoticeInBean();
						RechargeTaskCancelNoticeInRollbackList list=in.addNewRollbackList();
						list.setTaskID(rechargeFileId);
						//发送报文
						RechargeTaskCancelNoticeOutBizRegReq out=RechargeTaskCancelNoticeInter.doBusi(in);
						logger.info("out.getRejectReason():"+out.getRejectReason());
						//对报文继续验证
						if("0000".equals(out.getRejectReason())){
							RechargeTaskCancelNoticeOutTaskList[] results =(out.getResultList()).getTaskListArray();
							for(RechargeTaskCancelNoticeOutTaskList result:results){
								logger.info("result.getTaskID():"+result.getTaskID());
								logger.info("result.getTaskID():"+rechargeFileId);
								if(result.getTaskID().equals(rechargeFileId)){
									if(!"JA01".equals(result.getStatus())){
										throw new Exception(result.getStatusMsg());
									}else{
										IRechargeFileValue[] rfvs=new IRechargeFileValue[1];
										rf.setFileStatus("J915");
										rfvs[0]=rf;
										rechargePointsTaskDAO.saveFileInfo(rfvs);
										return;
									}
								}
							}
						}
					}
				}
			}
		throw new Exception("撤销记录不存在!");
	} catch (Exception e ) {
        logger.warn("The system is busy, please try again later!", e);
		throw new Exception(OrderConstant.RET_VALUE_Exception1, e);
    } finally {
       	if (locked) {
       		busiLockInfoSrv.releaseBusiLock(rechargeFileId, "002");
       	}
       	logger.info("SysBusiLockInfo  unlocked successfully ");
	}
	}
	
	/**
	 * 根据任务id查询任务详细信息
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public IRechargePointsTaskValue queryRechargePointsTask(String rechargeTaskId) throws Exception{
		IRechargePointsTaskValue value = rechargePointsTaskDAO.queryRechargePointsTask(rechargeTaskId);
		return value;
	}
	
	
	/**
	 * 根据任务id，审核状态查询充值任务
	 * @param rechargeTaskId
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public IRechargePointsTaskValue queryRechargePointsTask(String rechargeTaskId, String status) throws Exception{
		if(StringUtil.isBlank(rechargeTaskId) || StringUtil.isBlank(status)){
			logger.error(" in RechargePointsTaskSrvImpl-queryRechargePointsTaskAudit rechargeTaskId="+rechargeTaskId+"  status="+status);
			throw new Exception(" in RechargePointsTaskSrvImpl-queryRechargePointsTaskAudit rechargeTaskId or status is null ");
		}
		return rechargePointsTaskDAO.queryRechargePointsTask(rechargeTaskId, status);
	}
	
	/**
	 *  保存审核页审核通过信息
	 * @param value
	 * @throws Exception
	 */
	public void saveAuditTask(IBusiRechargeTaskAuditValue value)throws Exception{
		String taskId = value.getRechargeTaskId()+"";
		//业务锁服务
		ISysBusiLockInfoSrv busiLockInfoSrv = (ISysBusiLockInfoSrv)ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_SYS_BUSI_LOCK_SRV);
		//充值任务id 与 004 作为唯一主键   形成业务锁。004暂为积分返赠的业务码
		boolean locked = busiLockInfoSrv.gainBusiLock(value.getRechargeTaskId()+"", "004",-1);
		try{
			 if(locked) {
				 // 生成新的审核记录
				 value.setBusiId(BusiRechargeTaskAuditEngine.getNewId().longValue());
				 // 设置审核时间
				 value.setAuditTime(DateTimeUtil.getNowTimeStamp());
				 rechargePointsTaskDAO.saveAuditTask(value);
			 }
		} catch (Exception e ) {
            logger.warn("The system is busy, please try again later!", e);
			throw new Exception(OrderConstant.RET_VALUE_Exception1, e);
        } finally {
           	if (locked) {
           		busiLockInfoSrv.releaseBusiLock(taskId, "004");
           	}
           	logger.info("SysBusiLockInfo  unlocked successfully ");
		}
	}
	
	/**
	 * 保存充值任务信息
	 * @param taskValue
	 * @throws Exception
	 */
	public void saveTaskInfo(IRechargePointsTaskValue taskValue)throws Exception{
		//记录任务流水
		recordBusiRechargePointsTask(taskValue);
		rechargePointsTaskDAO.saveTaskInfo(taskValue);
	}
	
	/**
	 * 根据rechargeTaskId查询任务信息
	 * @param rechargeTaskId
	 * @return
	 * @throws Exception
	 */
	public IRechargePointsTaskValue queryRechargePointsTaskById(String rechargeTaskId) throws Exception{
		return rechargePointsTaskDAO.getTaskId(rechargeTaskId);
	}
	
	/**
	 * 根据rechargeTaskId查询文件列表信息
	 * @param rechargeTaskId
	 * @return
	 * @throws Exception
	 */
	public IRechargeFileValue[] getFileList(String rechargeTaskId)throws Exception{
		return rechargePointsTaskDAO.getTaskFileId(rechargeTaskId);
	}
	
	/**
	 * 修改
	 * @param map
	 * @param rpm
	 * @throws Exception
	 */
	public void updateTaskInfo(Map<String, String> map ,RechargePointModel[] rpm)throws Exception{
		ISysBusiLockInfoSrv busiLockInfoSrv = (ISysBusiLockInfoSrv)ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_SYS_BUSI_LOCK_SRV);
		boolean locked = busiLockInfoSrv.gainBusiLock(map.get("taskId"), "003",-1);//taskId 与 003 作为唯一主键   形成业务锁。
		try{
			if(locked) {
				//保存任务表信息
				IRechargePointsTaskValue value=rechargePointsTaskDAO.getTaskId(map.get("taskId"));
				//状态判断
				if(StringUtil.isBlank(value.getTaskStatus())&&!isAllowOperate(value.getTaskStatus(),map.get("type"))){
					throw new Exception("操作失败,请稍后重试!");
				}
				value.setTaskName(map.get("taskName"));
				value.setTaskType(map.get("taskType"));
				value.setExecutionTime(DateTimeUtil.stringToTimestamp(map.get("executionTime"),CommnConstant.DATETIME_JAVA_FORMAT));
				value.setTaskStatus(map.get("type"));
				value.setTaskChannel(map.get("taskChannel"));
				value.setActivityType(map.get("activityType"));
				value.setChannelName(map.get("taskChannelName"));
				value.setActivityName(map.get("activityTypeName"));
				value.setTaskTitile(value.getChannelName()+value.getActivityName()+value.getTaskName());
				value.setFirstTime(null);
				value.setFirstTrialCode(null);
				value.setSecondTime(null);
				value.setReTrialCode(null);
				//保存任务信息
				rechargePointsTaskDAO.saveTaskInfo(value);
				//保存流水任务信息
				recordBusiRechargePointsTask(value);
				
				IRechargeFileValue[] rechargeFileValue=rechargePointsTaskDAO.getTaskFileId(map.get("taskId"));		
				List<IRechargeFileValue> list = new ArrayList<IRechargeFileValue>();
				Map<String,Integer> rfMap=new HashMap<String,Integer>();
				for(IRechargeFileValue fileValue:rechargeFileValue){
					//删除
					fileValue.setIsDeleted("1");
					//保存文件流水
					recordBusiRechargeFile(fileValue);
				}
				for(RechargePointModel rf:rpm){
					//标记新增
					rfMap.put(rf.getTaskId(),0);
					for(IRechargeFileValue fileValue:rechargeFileValue){
						if (rf.getTaskId().equals(fileValue.getRechargeFileId())) {
							//标记修改
							rfMap.put(rf.getTaskId(),1);
							//修改内容
							fileValue.setIsDeleted("0");
							if(StringUtil.isBlank(rf.getContent())){
								fileValue.setIsSendSms("0");
							}else{
								fileValue.setIsSendSms("1");
								fileValue.setSmsMessage(rf.getContent());
							}
							//保存文件流水
							recordBusiRechargeFile(fileValue);
							logger.info("updateTaskInfo  update file ,Fileid="+fileValue.getRechargeFileId());
						}
		
					}
					//新增文件
					if(rfMap.get(rf.getTaskId())!=1){
						IRechargeFileValue rfv=new RechargeFileBean();
						rfv.setRechargeFileId(rf.getTaskId());
						rfv.setRechargeFileName(rf.getFileName());
						rfv.setRechargeFileNickname("ADDPOINT_"+rf.getTaskId()+".xls");
						rfv.setRechargeTaskId(value.getRechargeTaskId());
						if(StringUtil.isBlank(rf.getContent())){
							rfv.setIsSendSms("0");
						}else{
							rfv.setIsSendSms("1");
							rfv.setSmsMessage(rf.getContent());
						}
						rfv.setIsDeleted("0");
						rfv.setFileManageStatus("00");
						rfv.setSuccCounts(0);
						rfv.setFailCounts(0);
						rfv.setNotRechargeCounts(0);
						list.add(rfv);
						//文件流水保存
						recordBusiRechargeFile(rfv);
						logger.info("updateTaskInfo add file ,Fileid="+rfv.getRechargeFileId());
					}
				}
				rechargePointsTaskDAO.saveFileInfo(rechargeFileValue);
				
				IRechargeFileValue[] rfvs=new IRechargeFileValue[list.size()];
				rfvs = list.toArray(rfvs);
				if(rfvs != null && rfvs.length > 0){
					//新增文件信息
					rechargePointsTaskDAO.saveFileInfo(rfvs);
				}
				
				//保存操作流水表信息
				IBusiRechargeTaskAuditValue brta=new BusiRechargeTaskAuditBean();
				brta.setBusiId(Long.parseLong(BusiRechargeTaskAuditEngine.getNewId()+""));
				brta.setRechargeTaskId(value.getRechargeTaskId());
				//获取当前操作人code
				brta.setOperatorCode(map.get("code"));
				brta.setAuditTime(DateTimeUtil.getNowTimeStamp());
				brta.setStatus(value.getTaskStatus());
				rechargePointsTaskDAO.saveTaskAudit(brta);
			}
		}
		catch (Exception e ) {
            logger.warn("The system is busy, please try again later!", e);
			throw new Exception("操作失败,请稍后重试!", e);
        } finally {
           	if (locked) {
           		busiLockInfoSrv.releaseBusiLock(map.get("taskId"), "003");
           	}
           	logger.info("SysBusiLockInfo  unlocked successfully ");
		}
	}
	
	
	/**
	 * 查询文件列表页信息
	 * @param rechargeTaskId
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public IQBORechargeFileValue[] queryRechargePointsTaskFileList(String rechargeTaskId, int startNum, int endNum) throws Exception {
		IQBORechargeFileValue[] rf=rechargePointsTaskDAO.queryRechargePointsTaskFileList(rechargeTaskId, startNum, endNum);
		//添加操作列
		for(IQBORechargeFileValue value:rf){
			//0：不发送短信      1：发送短信
			if(CoreConstant.RECHARGE_POINTS_TASK_IS_SEND_SMS_NO.equals(value.getIsSendSms())){
				value.setIsSendSms("否");
			}
			if(CoreConstant.RECHARGE_POINTS_TASK_IS_SEND_SMS_YES.equals(value.getIsSendSms())){
				value.setIsSendSms("是");
			}
			StringBuffer rechargeFileName = new StringBuffer();
			rechargeFileName.append(String.format("<a href=\'#\' onclick=\'javascript:downLoadFile(\"%s\")'>"+value.getRechargeFileName()+"</a>", value.getRechargeFileNickname()));
			value.setRechargeFileName(rechargeFileName.toString());
		}
		return rf;
	}
	
	
	/**
	 * 查询文件数量 用于分页
	 * @param rechargeTaskId
	 * @return
	 * @throws Exception
	 */
	public int queryRechargePointsTaskFileListCount(String rechargeTaskId) throws Exception{
		int num = rechargePointsTaskDAO.queryRechargePointsTaskFileListCount(rechargeTaskId);
		return num;
	}
	
}
