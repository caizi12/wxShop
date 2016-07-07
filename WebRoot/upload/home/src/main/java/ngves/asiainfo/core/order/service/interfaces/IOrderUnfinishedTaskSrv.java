package ngves.asiainfo.core.order.service.interfaces;

import ngves.asiainfo.core.order.dao.interfaces.IOrderAuditBusiInfoDAO;
import ngves.asiainfo.core.order.dao.interfaces.IOrderBusiInfoDAO;
import ngves.asiainfo.core.order.dao.interfaces.IOrderUnfinishedTaskDAO;
import ngves.asiainfo.core.order.ivalues.IBusiUnfinishedOrderAuditValue;
import ngves.asiainfo.core.order.ivalues.IOrderUnfinishedTaskValue;

public interface IOrderUnfinishedTaskSrv {
	/**
	 * 查询超时未完结订单任务列表
	 * @param taskStatus 任务状态
	 * @param managerStatus 任务处理状态
	 * @param auditStatus 哪个审核状态页面 00,处理页面; 01,初审页面; 02,复审页面
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public IOrderUnfinishedTaskValue[] queryTaskList(String taskStatus,String managerStatus,String auditStatus,int startNum, int endNum) throws Exception;
	
	
	/**
	 * 查询超时未完结订单任务列表数量
	 * @param taskStatus 任务状态
	 * @param managerStatus 任务处理状态
	 * @param auditStatus 哪个审核状态页面 00,处理页面; 01,初审页面; 02,复审页面
	 * @return
	 * @throws Exception
	 */
	public int queryTaskListCount(String taskStatus,String managerStatus,String auditStatus) throws Exception;
	
	/**
	 * 新增未完结订单任务
	 * @param smsTemplateValue
	 * @throws Exception
	 *
	 */
	public void saveTaskInfo(IOrderUnfinishedTaskValue orderUnfinishedTaskValue) throws Exception;
	
	/**
	 * 整体业务操作: 保存审核信息
	 * @param taskId 未完结订单任务
	 * @param status 更改的状态
	 * @param content 审核意见
	 * @param operer 操作人
	 * @param dateTime 时间
	 * @param type 特殊类型操作
	 * @throws Exception
	 */
	public void saveTrialTaskInfo(String taskId, String status, String content, String operer , String dateTime) throws Exception;
	/**
	 * 查询任务流水信息
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public IBusiUnfinishedOrderAuditValue[] queryTaskAuditBusiList(String taskId) throws Exception;
	
	/**
	 * 根据任务id查询超时未完成订单任务信息
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public IOrderUnfinishedTaskValue queryUnfinishedOrderTaskById(String taskId) throws Exception;
	
	/**
	 * 根据任务id删除任务信息
	 * @param taskId
	 * @throws Exception
	 */
	public void deleteTaskInfo(String taskId) throws Exception;
	
	/**
	 * 查询未完成订单状态更新结果
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public IOrderUnfinishedTaskValue queryTaskResultDetail(String taskId) throws Exception;
	
	public void setOrderBusiInfoDAO(IOrderBusiInfoDAO orderBusiInfoDAO);

	public void setOrderUnfinishedTaskDAO(IOrderUnfinishedTaskDAO orderUnfinishedTaskDAO) ;

	public void setOrderAuditBusiInfoDAO(IOrderAuditBusiInfoDAO orderAuditBusiInfoDAO);

}
