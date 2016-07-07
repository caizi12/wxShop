package ngves.asiainfo.core.rechargepoints.service.interfaces;

import java.util.Map;

import ngves.asiainfo.core.rechargepoints.dao.interfaces.IRechargePointsTaskDAO;
import ngves.asiainfo.core.rechargepoints.ivalues.IBusiRechargeTaskAuditValue;
import ngves.asiainfo.core.rechargepoints.ivalues.IQBORechargeFileValue;
import ngves.asiainfo.core.rechargepoints.ivalues.IRechargeFileValue;
import ngves.asiainfo.core.rechargepoints.ivalues.IRechargePointsTaskValue;
import ngves.asiainfo.core.rechargepoints.model.RechargePointModel;

import com.ai.secframe.ivalues.orgmodel.ISysStaffValue;

/**
 * 积分返赠任务管理服务层定义
 * @author yeqh
 * 2014-08-29
 */

public interface IRechargePointsTaskSrv {

	public void setRechargePointsTaskDAO(IRechargePointsTaskDAO rechargePointsTaskDAO) throws Exception ;
	
	/**
	 * 根据 rechargeTaskId 查询任务详情
	 * @param rechargeTaskId
	 * @return
	 * @throws Exception
	 */
	public IBusiRechargeTaskAuditValue[] queryRechargePointsTaskInfo(String rechargeTaskId)throws Exception ;
	
	/**
	 * 根据 rechargeTaskId 查询处理详情
	 * @param rechargeTaskId
	 * @return
	 * @throws Exception
	 */
	public IRechargeFileValue[] queryRechargePointsTaskDetail(String rechargeTaskId)throws Exception;
	
	/**
	 * 根据 rechargeFileId 查询任务结果
	 * @param rechargeTaskId
	 * @return
	 * @throws Exception
	 */
	public IRechargeFileValue[] queryRechargePointsTaskResult(String rechargeFileId)throws Exception;
	
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
	public IRechargePointsTaskValue[] queryRechargePointsTaskList(String taskStatus,String taskName,String jspStatus,int startNum, int endNum)throws Exception;
	
	/**
	 * 积分反赠管理页、初审页、复审页查询数量
	 * @param taskStatus
	 * @param taskName
	 * @param jspStatus
	 * @return
	 * @throws Exception
	 */
	public int queryRechargePointsTaskListCount(String taskStatus,String taskName,String jspStatus)throws Exception;
	
	/**
	 * 根据 staffId 用户信息
	 * @param staffId
	 * @return
	 * @throws Exception
	 */
	public ISysStaffValue getUserInfo(long staffId)throws Exception;
	
	/**
	 * 保存任务、文件信息
	 * @param map
	 * @param rpm
	 * @throws Exception
	 */
	public void saveTaskInfo(Map<String, String> map, RechargePointModel[] rpm)throws Exception;
	
	/**
	 * 将充值文件正式表中的对象作为参数，用于文件记录流水信息
	 * @param rechargeFile
	 * @throws Exception
	 */
	public void recordBusiRechargeFile(IRechargeFileValue rechargeFile)throws Exception;
	
	
	/**
	 * 将充值任务正式表中的对象作为参数，用于任务记录流水信息
	 * @param rechargePointsTask
	 * @throws Exception
	 */
	public void recordBusiRechargePointsTask(IRechargePointsTaskValue rechargePointsTask) throws Exception;
	
	/**
	 * 删除任务、文件信息
	 * @param taskId
	 * @throws Exception
	 */
	public void deleteTaskInfo(String taskId ,long staffId,String comType,long orgId) throws Exception;
	
	/**
	 * 查询文件列表页信息
	 * @param rechargeTaskId
	 * @return
	 * @throws Exception
	 */
	public IQBORechargeFileValue[] queryRechargePointsTaskFileList(String rechargeTaskId)throws Exception;
	
	/**
	 * 撤回
	 * @param map
	 * @throws Exception
	 */
	public void backTask(Map<String, String> map) throws Exception;
	
	/**
	 * 撤销
	 * @param map
	 * @throws Exception
	 */
	public void repeal(String rechargeFileId)throws Exception;
	
	/**
	 * 根据任务id查询任务详细信息
	 * @param rechargeTaskId
	 * @return
	 * @throws Exception
	 */
	public IRechargePointsTaskValue queryRechargePointsTask(String rechargeTaskId) throws Exception;
	
	/**
	 * 根据任务id，审核状态查询充值任务
	 * @param rechargeTaskId
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public IRechargePointsTaskValue queryRechargePointsTask(String rechargeTaskId, String status) throws Exception;
	
	/**
	 *  保存审核页审核通过信息
	 * @param value
	 * @throws Exception
	 */
	public void saveAuditTask(IBusiRechargeTaskAuditValue value)throws Exception;
	
	/**
	 * 保存充值任务信息
	 * @param taskValue
	 * @throws Exception
	 */
	public void saveTaskInfo(IRechargePointsTaskValue taskValue)throws Exception;
	
	/**
	 * 根据rechargeTaskId查询任务信息
	 * @param rechargeTaskId
	 * @return
	 * @throws Exception
	 */
	public IRechargePointsTaskValue queryRechargePointsTaskById(String rechargeTaskId) throws Exception;
	
	/**
	 * 根据rechargeTaskId查询文件列表信息
	 * @param rechargeTaskId
	 * @return
	 * @throws Exception
	 */
	public IRechargeFileValue[] getFileList(String rechargeTaskId)throws Exception;
	
	/**
	 * 修改
	 * @param map
	 * @param rpm
	 * @throws Exception
	 */
	public void updateTaskInfo(Map<String, String> map, RechargePointModel[] rpm)throws Exception;
	
	/**
	 * 查询文件列表页信息
	 * @param rechargeTaskId
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public IQBORechargeFileValue[] queryRechargePointsTaskFileList(String rechargeTaskId, int startNum, int endNum) throws Exception;
	
	/**
	 * 查询文件数量 用于分页
	 * @param rechargeTaskId
	 * @return
	 * @throws Exception
	 */
	public int queryRechargePointsTaskFileListCount(String rechargeTaskId) throws Exception;
}
