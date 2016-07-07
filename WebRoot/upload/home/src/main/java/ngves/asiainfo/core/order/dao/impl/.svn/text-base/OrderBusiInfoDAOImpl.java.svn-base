package ngves.asiainfo.core.order.dao.impl;

import ngves.asiainfo.core.order.bo.BusiUnfinishedOrderInfoEngine;
import ngves.asiainfo.core.order.dao.interfaces.IOrderBusiInfoDAO;
import ngves.asiainfo.core.order.ivalues.IBusiUnfinishedOrderInfoValue;

public class OrderBusiInfoDAOImpl implements IOrderBusiInfoDAO {

	public void saveOrderUnfinishedTaskBusiInfo(IBusiUnfinishedOrderInfoValue value)
			throws Exception {
		if (value.isNew()) {
			value.setBusiId(BusiUnfinishedOrderInfoEngine.getNewId().longValue());
		}
		BusiUnfinishedOrderInfoEngine.save(value);
		
	}

}
