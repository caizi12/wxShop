package ngves.asiainfo.core.order.dao.impl;

import java.util.Map;

import ngves.asiainfo.core.order.bo.BusiUnfinishedOrderAuditEngine;
import ngves.asiainfo.core.order.dao.interfaces.IOrderAuditBusiInfoDAO;
import ngves.asiainfo.core.order.ivalues.IBusiUnfinishedOrderAuditValue;

public class OrderAuditBusiInfoDAOImpl implements IOrderAuditBusiInfoDAO {

	public void saveBusiUnfinishedOrderAuditValue(IBusiUnfinishedOrderAuditValue value)
			throws Exception {
		if (value.isNew()) {
			value.setBusiId(BusiUnfinishedOrderAuditEngine.getNewId().longValue());
		}
		BusiUnfinishedOrderAuditEngine.save(value);
	}

	@SuppressWarnings("unchecked")
	public IBusiUnfinishedOrderAuditValue[] queryTaskAuditBusiList(String condition, Map parameter) throws Exception {
		IBusiUnfinishedOrderAuditValue[] values =BusiUnfinishedOrderAuditEngine.getBeans(condition, parameter);
		return values;
	}
}
