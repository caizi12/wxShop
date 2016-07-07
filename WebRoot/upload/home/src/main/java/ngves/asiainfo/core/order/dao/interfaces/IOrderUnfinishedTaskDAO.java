package ngves.asiainfo.core.order.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.order.ivalues.IOrderUnfinishedTaskValue;

public interface IOrderUnfinishedTaskDAO {
	/**
	 * 未完结订单任务信息保存
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public void saveTaskInfo(IOrderUnfinishedTaskValue value) throws Exception;
	
	/**
	 * 根据taskId获取未完结订单任务
	 * 
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public IOrderUnfinishedTaskValue getOrderTaskById(String taskId) throws Exception;
	
	/**
	 * 未完结订单任务列表获取
	 * 
	 * @param condition
	 * @param parameter
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public IOrderUnfinishedTaskValue[] getOrderUnfininshedTaskInfo(String condition,Map parameter,int startIndex, int endIndex) throws Exception;

	/**
	 * 未完结订单任务列表数量
	 * 
	 * @param condition
	 * @param parameter
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public int getOrderUnfininshedTaskInfoCount(String condition,Map parameter) throws Exception;

}
