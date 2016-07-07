package ngves.asiainfo.core.order.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.order.ivalues.IBusiUnfinishedOrderAuditValue;

public interface IOrderAuditBusiInfoDAO {
	
	/**
	 * 保存未完结订单任务的审核流水信息
	 * @param busiUnfinishedOrderAuditValue
	 * @throws Exception
	 */
	public void saveBusiUnfinishedOrderAuditValue(IBusiUnfinishedOrderAuditValue busiUnfinishedOrderAuditValue) throws Exception;

	/**
	 * 获取流水信息
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public IBusiUnfinishedOrderAuditValue[] queryTaskAuditBusiList(String condition, Map parameter) throws Exception;
}
