package ngves.asiainfo.core.system.dao.interfaces;

import ngves.asiainfo.core.common.ivalues.IRequisitionRcvStateValue;

/**
 * TODO 如果修改通知模块是，要删除mgt的这个DAO和实现和BEAN文件进行合并
 * @author wzg
 *
 */
public interface IRequisitionRcvStateDAO {
	public IRequisitionRcvStateValue get(long requisitionRcvId)
			throws Exception;

	/**
	 * 更新通知单接收信息
	 * 
	 * @param value
	 * @throws Exception
	 */
	public void update(IRequisitionRcvStateValue value) throws Exception;

	/**
	 * 根据通知单ID得到通知单接收信息
	 * 
	 * @param requisitionId
	 * @return
	 * @throws Exception
	 */
	public IRequisitionRcvStateValue[] queryByRequisitionId(long requisitionId)
			throws Exception;

	/**
	 * 根据通知单ID得到通知单接收信息数量
	 * 
	 * @param requisitionId
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public int count(long requisitionId, String status) throws Exception;

	/**
	 * 插入通知单接收信息
	 * 
	 * @param value
	 * @throws Exception
	 */
	public void add(IRequisitionRcvStateValue value) throws Exception;
}
