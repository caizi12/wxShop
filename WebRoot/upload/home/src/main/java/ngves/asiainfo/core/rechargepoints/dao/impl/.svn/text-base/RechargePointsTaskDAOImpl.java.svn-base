package ngves.asiainfo.core.rechargepoints.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.rechargepoints.bo.BusiRechargeFileEngine;
import ngves.asiainfo.core.rechargepoints.bo.BusiRechargePointsTaskEngine;
import ngves.asiainfo.core.rechargepoints.bo.BusiRechargeTaskAuditEngine;
import ngves.asiainfo.core.rechargepoints.bo.QBORechargeFileEngine;
import ngves.asiainfo.core.rechargepoints.bo.RechargeFileEngine;
import ngves.asiainfo.core.rechargepoints.bo.RechargePointsTaskEngine;
import ngves.asiainfo.core.rechargepoints.dao.interfaces.IRechargePointsTaskDAO;
import ngves.asiainfo.core.rechargepoints.ivalues.IBusiRechargeFileValue;
import ngves.asiainfo.core.rechargepoints.ivalues.IBusiRechargePointsTaskValue;
import ngves.asiainfo.core.rechargepoints.ivalues.IBusiRechargeTaskAuditValue;
import ngves.asiainfo.core.rechargepoints.ivalues.IQBORechargeFileValue;
import ngves.asiainfo.core.rechargepoints.ivalues.IRechargeFileValue;
import ngves.asiainfo.core.rechargepoints.ivalues.IRechargePointsTaskValue;
import ngves.asiainfo.util.StringUtil;

import com.ai.secframe.bo.orgmodel.SysStaffEngine;
import com.ai.secframe.ivalues.orgmodel.ISysStaffValue;

/**
 * 积分返赠任务管理DAO层实现
 * @author yeqh
 * 2014-08-29
 */

public class RechargePointsTaskDAOImpl implements IRechargePointsTaskDAO {

	public IBusiRechargeTaskAuditValue[] queryRechargePointsTaskInfo(String rechargeTaskId)throws Exception{
		StringBuffer condition = new StringBuffer();
		Map<String, String> parameter = new HashMap<String, String>();
		condition.append(IBusiRechargeTaskAuditValue.S_RechargeTaskId).append(" =:").append(IBusiRechargeTaskAuditValue.S_RechargeTaskId);
		parameter.put(IBusiRechargeTaskAuditValue.S_RechargeTaskId, rechargeTaskId);
		condition.append(" order by "+IBusiRechargeTaskAuditValue.S_AuditTime+" desc ");
		return BusiRechargeTaskAuditEngine.getBeans(condition.toString(), parameter);
	}
	
	public IRechargeFileValue[] queryRechargePointsTaskDetail(String rechargeTaskId)throws Exception{
		StringBuffer condition = new StringBuffer();
		Map<String, String> parameter = new HashMap<String, String>();
		condition.append(IRechargeFileValue.S_RechargeTaskId).append(" =:").append(IRechargeFileValue.S_RechargeTaskId);
		parameter.put(IRechargeFileValue.S_RechargeTaskId, rechargeTaskId);
		condition.append(" AND ").append(IRechargeFileValue.S_IsDeleted).append(" =:").append(IRechargeFileValue.S_IsDeleted);
		parameter.put(IRechargeFileValue.S_IsDeleted,"0");
		return RechargeFileEngine.getBeans(condition.toString(), parameter);
	}
	
	public IRechargeFileValue[] queryRechargePointsTaskResult(String rechargeFileId)throws Exception{
		StringBuffer condition = new StringBuffer();
		Map<String, String> parameter = new HashMap<String, String>();
		condition.append(IRechargeFileValue.S_RechargeFileId).append(" =:").append(IRechargeFileValue.S_RechargeFileId);
		parameter.put(IRechargeFileValue.S_RechargeFileId, rechargeFileId);
		condition.append(" AND ").append(IRechargeFileValue.S_IsDeleted).append(" =:").append(IRechargeFileValue.S_IsDeleted);
		parameter.put(IRechargeFileValue.S_IsDeleted,"0");
		return RechargeFileEngine.getBeans(condition.toString(), parameter);
	}
	public IRechargePointsTaskValue[] queryRechargePointsTaskList(String taskStatus,String taskName,String jspStatus,int startNum, int endNum)throws Exception{
		StringBuffer condition = new StringBuffer();
		Map<String, String> parameter = new HashMap<String, String>();
		condition.append(" 1=1 ");
		if (!StringUtil.isBlank(taskStatus)&&!("-1").equals(taskStatus)) {
			condition.append(" AND ").append(IRechargePointsTaskValue.S_TaskStatus).append(" =:").append(IRechargePointsTaskValue.S_TaskStatus);
			parameter.put(IRechargePointsTaskValue.S_TaskStatus, taskStatus);
		}
		if (!StringUtil.isBlank(taskName)) {
			condition.append(" AND ").append(IRechargePointsTaskValue.S_TaskName).append(" like  '%").append(taskName).append("%'");
		}
		if((CoreConstant.RECHARGE_POINTS_TASK_JSP_FIRST_TRIAL).equals(jspStatus)){
			//初审选项值为待审核、初审不通过、初审通过
			condition.append(" AND ").append(IRechargePointsTaskValue.S_TaskStatus).append(" in("+CoreConstant.RECHARGE_POINTS_TASK_STATUS_NOTVERIFY+","+CoreConstant.RECHARGE_POINTS_TASK_STATUS_FIRSTVERIFY+","+CoreConstant.RECHARGE_POINTS_TASK_STATUS_NOTFIRSTVERIFY+")");
		}
		if((CoreConstant.RECHARGE_POINTS_TASK_JSP_REPEAT_TRIAL).equals(jspStatus)){
			//复审选项值为初审通过、审核通过、审核不通过
			condition.append(" AND ").append(IRechargePointsTaskValue.S_TaskStatus).append(" in("+CoreConstant.RECHARGE_POINTS_TASK_STATUS_FIRSTVERIFY+","+CoreConstant.RECHARGE_POINTS_TASK_STATUS_SECONDVERIFY+","+CoreConstant.RECHARGE_POINTS_TASK_STATUS_NOTSECONDVERIFY+")");
		}
		condition.append(" AND ").append(IRechargePointsTaskValue.S_IsDeleted).append(" =:").append(IRechargePointsTaskValue.S_IsDeleted);
		parameter.put(IRechargePointsTaskValue.S_IsDeleted,"0");
		if((CoreConstant.RECHARGE_POINTS_TASK_JSP_REPEAT_TRIAL).equals(jspStatus)){
			condition.append(" ORDER BY FIRST_TIME DESC ");
		}else{
			condition.append(" ORDER BY CREATE_TIME DESC ");
		}
		return RechargePointsTaskEngine.getBeans(null, condition.toString(), parameter,startNum, endNum, false);
	}
	public int queryRechargePointsTaskListCount (String taskStatus,String taskName,String jspStatus)throws Exception{
		StringBuffer condition = new StringBuffer();
		Map<String, String> parameter = new HashMap<String, String>();
		condition.append(" 1=1 ");
		if (!StringUtil.isBlank(taskStatus)&&!("-1").equals(taskStatus)) {
			condition.append(" AND ").append(IRechargePointsTaskValue.S_TaskStatus).append(" =:").append(IRechargePointsTaskValue.S_TaskStatus);
			parameter.put(IRechargePointsTaskValue.S_TaskStatus, taskStatus);
		}
		if (!StringUtil.isBlank(taskName)) {
			condition.append(" AND ").append(IRechargePointsTaskValue.S_TaskName).append(" like  '%").append(taskName).append("%'");
		}
		if((CoreConstant.RECHARGE_POINTS_TASK_JSP_FIRST_TRIAL).equals(jspStatus)){
			//初审选项值为待审核、初审不通过、初审通过
			condition.append(" AND ").append(IRechargePointsTaskValue.S_TaskStatus).append(" in("+CoreConstant.RECHARGE_POINTS_TASK_STATUS_NOTVERIFY+","+CoreConstant.RECHARGE_POINTS_TASK_STATUS_FIRSTVERIFY+","+CoreConstant.RECHARGE_POINTS_TASK_STATUS_NOTFIRSTVERIFY+")");
		}
		if((CoreConstant.RECHARGE_POINTS_TASK_JSP_REPEAT_TRIAL).equals(jspStatus)){
			//复审选项值为初审通过、审核通过、审核不通过
			condition.append(" AND ").append(IRechargePointsTaskValue.S_TaskStatus).append(" in("+CoreConstant.RECHARGE_POINTS_TASK_STATUS_FIRSTVERIFY+","+CoreConstant.RECHARGE_POINTS_TASK_STATUS_SECONDVERIFY+","+CoreConstant.RECHARGE_POINTS_TASK_STATUS_NOTSECONDVERIFY+")");
		}
		condition.append(" AND ").append(IRechargePointsTaskValue.S_IsDeleted).append(" =:").append(IRechargePointsTaskValue.S_IsDeleted);
		parameter.put(IRechargePointsTaskValue.S_IsDeleted,"0");
		return RechargePointsTaskEngine.getBeansCount(condition.toString(),parameter);
	}

	public ISysStaffValue getUserInfo(long staffId) throws Exception {
		return SysStaffEngine.getBean(staffId);
	}
	public void saveTaskInfo(IRechargePointsTaskValue value)throws Exception{
		RechargePointsTaskEngine.save(value);
	}
	public void saveFileInfo(IRechargeFileValue[] value)throws Exception{
		RechargeFileEngine.saveBatch(value);
	}
	
	
	/**
	 * 将充值文件正式表中的对象作为参数，用于文件记录流水信息
	 * @param busiRechargeFile
	 * @throws Exception
	 */
	public void saveBusiRechargeFile(IBusiRechargeFileValue busiRechargeFile)throws Exception{
		BusiRechargeFileEngine.save(busiRechargeFile);
	}
	
	/**
	 * 将充值任务正式表中的对象作为参数，用于任务记录流水信息
	 * @param busiRechargePointsTask
	 * @throws Exception
	 */
	public void saveBusiRechargePointsTask(IBusiRechargePointsTaskValue busiRechargePointsTask) throws Exception{
		BusiRechargePointsTaskEngine.save(busiRechargePointsTask);
	}
	public IRechargePointsTaskValue getTaskId(String taskId) throws Exception{
		return RechargePointsTaskEngine.getBean(Long.parseLong(taskId));
	}
	public IRechargeFileValue[] getTaskFileId(String taskId) throws Exception{
		StringBuffer condition = new StringBuffer();
		Map<String, String> parameter = new HashMap<String, String>();
		condition.append(" 1=1 ");
		condition.append(" AND ").append(IRechargeFileValue.S_RechargeTaskId).append(" =:").append(IRechargeFileValue.S_RechargeTaskId);
		parameter.put(IRechargeFileValue.S_RechargeTaskId, taskId);
		condition.append(" AND ").append(IRechargeFileValue.S_IsDeleted).append("=:").append(IRechargeFileValue.S_IsDeleted);
		parameter.put(IRechargeFileValue.S_IsDeleted, "0");
		return RechargeFileEngine.getBeans(condition.toString(), parameter);
	}
	public void saveTaskAudit(IBusiRechargeTaskAuditValue value)throws Exception{
		BusiRechargeTaskAuditEngine.save(value);
	}

	public IQBORechargeFileValue[] queryRechargePointsTaskFileList(String rechargeTaskId) throws Exception {
		StringBuffer condition = new StringBuffer();
		Map<String, String> parameter = new HashMap<String, String>();
		condition.append(" 1=1 ");
		condition.append(" AND ").append(IRechargeFileValue.S_RechargeTaskId).append(" =:").append(IRechargeFileValue.S_RechargeTaskId);
		parameter.put(IRechargeFileValue.S_RechargeTaskId, rechargeTaskId);
		condition.append(" AND ").append(IRechargeFileValue.S_IsDeleted).append(" =:").append(IRechargeFileValue.S_IsDeleted);
		parameter.put(IRechargeFileValue.S_IsDeleted,"0");
		return QBORechargeFileEngine.getBeans(condition.toString(), parameter);
	}
	public IRechargeFileValue queryRechargeFile(String rechargeFileId)throws Exception {
		return RechargeFileEngine.getBean(rechargeFileId);
	}
	
	/**
	 * 根据任务id查询任务详细信息
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public IRechargePointsTaskValue queryRechargePointsTask(String taskId) throws Exception{
		//任务必须为非删除状态(1表示删除状态)
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		Map<String, String> parameter = new HashMap<String, String>();
		
		condition.append(" AND ").append(IRechargePointsTaskValue.S_RechargeTaskId).append("=:").append(IRechargePointsTaskValue.S_RechargeTaskId);
		condition.append(" AND ").append(IRechargePointsTaskValue.S_IsDeleted).append("=:").append(IRechargePointsTaskValue.S_IsDeleted);
		parameter.put(IRechargePointsTaskValue.S_RechargeTaskId, taskId);
		parameter.put(IRechargePointsTaskValue.S_IsDeleted, "0");
		return RechargePointsTaskEngine.getBeans(condition.toString(), parameter)[0] ;
	}
	
	
	/**
	 * 根据任务id，审核状态查询充值任务
	 * @param rechargeTaskId
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public IRechargePointsTaskValue queryRechargePointsTask(String rechargeTaskId, String status) throws Exception{
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String, String> parameter = new HashMap<String, String>();
		if(!StringUtil.isBlank(rechargeTaskId)){
			condition.append(" AND ").append(IBusiRechargeTaskAuditValue.S_RechargeTaskId).append("=:").append(IBusiRechargeTaskAuditValue.S_RechargeTaskId);
			parameter.put(IBusiRechargeTaskAuditValue.S_RechargeTaskId, rechargeTaskId);
		}
		if(!StringUtil.isBlank(status)){
			condition.append(" AND ").append(IBusiRechargeTaskAuditValue.S_Status).append("=:").append(IBusiRechargeTaskAuditValue.S_Status);
			parameter.put(IBusiRechargeTaskAuditValue.S_Status, status);
		}
		condition.append(" AND ").append(IRechargePointsTaskValue.S_IsDeleted).append("=:").append(IRechargePointsTaskValue.S_IsDeleted);
		parameter.put(IRechargePointsTaskValue.S_IsDeleted, "0");
		return RechargePointsTaskEngine.getBeans(condition.toString(), parameter)[0];
	}
	
	/**
	 *  保存审核页审核通过信息
	 * @param value
	 * @throws Exception
	 */
	public void saveAuditTask(IBusiRechargeTaskAuditValue value)throws Exception{
		BusiRechargeTaskAuditEngine.save(value);
	}
	
	
	/**
	 * 查询文件列表页信息 用于分页
	 * @param rechargeTaskId
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public IQBORechargeFileValue[] queryRechargePointsTaskFileList(String rechargeTaskId, int startNum, int endNum) throws Exception{
		StringBuffer condition = new StringBuffer();
		Map<String, String> parameter = new HashMap<String, String>();
		condition.append(" 1=1 ");
		condition.append(" AND ").append(IRechargeFileValue.S_RechargeTaskId).append(" =:").append(IRechargeFileValue.S_RechargeTaskId);
		parameter.put(IRechargeFileValue.S_RechargeTaskId, rechargeTaskId);
		
		condition.append(" AND ").append(IRechargeFileValue.S_IsDeleted).append(" =:").append(IRechargeFileValue.S_IsDeleted);
		parameter.put(IRechargeFileValue.S_IsDeleted,"0");
		return QBORechargeFileEngine.getBeans(null, condition.toString(), parameter, startNum, endNum, false);
	}
	
	/**
	 * 查询文件数量 用于分页
	 * @param rechargeTaskId
	 * @return
	 * @throws Exception
	 */
	public int queryRechargePointsTaskFileListCount(String rechargeTaskId) throws Exception {
		StringBuffer condition = new StringBuffer();
		Map<String, String> parameter = new HashMap<String, String>();
		condition.append(" 1=1 ");
		condition.append(" AND ").append(IRechargeFileValue.S_RechargeTaskId).append(" =:").append(IRechargeFileValue.S_RechargeTaskId);
		parameter.put(IRechargeFileValue.S_RechargeTaskId, rechargeTaskId);
		
		condition.append(" AND ").append(IRechargeFileValue.S_IsDeleted).append(" =:").append(IRechargeFileValue.S_IsDeleted);
		parameter.put(IRechargeFileValue.S_IsDeleted,"0");
		return QBORechargeFileEngine.getBeansCount(condition.toString(), parameter);
	}

	
}
