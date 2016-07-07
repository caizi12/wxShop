package ngves.asiainfo.core.system.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.common.bo.RequisitionRcvStateEngine;
import ngves.asiainfo.core.common.ivalues.IRequisitionRcvStateValue;
import ngves.asiainfo.core.system.dao.interfaces.IRequisitionRcvStateDAO;

public class RequisitionRcvStateDAOImpl implements IRequisitionRcvStateDAO {
	public IRequisitionRcvStateValue get(long requisitionRcvId)
			throws Exception {
		return RequisitionRcvStateEngine.getBean(requisitionRcvId);
	}

	public void update(IRequisitionRcvStateValue value) throws Exception {
		RequisitionRcvStateEngine.save(value);
	}

	public IRequisitionRcvStateValue[] queryByRequisitionId(long requisitionId)
			throws Exception {
		String cond = IRequisitionRcvStateValue.S_RequisitionId
				+ " = :requisitionId";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("requisitionId", Long.valueOf(requisitionId));
		cond += " order by " + IRequisitionRcvStateValue.S_RequisitionStatus;

		return RequisitionRcvStateEngine.getBeans(cond, map);
	}

	public int count(long requisitionId, String status) throws Exception {

		String cond = IRequisitionRcvStateValue.S_RequisitionId
				+ " = :requisitionId";
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("requisitionId", Long.valueOf(requisitionId));
		if (null != status && 0 < status.length()) {
			cond += " and " + IRequisitionRcvStateValue.S_RequisitionStatus
					+ " = :status";
			map.put("status", status);
		}
		return RequisitionRcvStateEngine.getBeansCount(cond, map);
	}

	public void add(IRequisitionRcvStateValue value) throws Exception {
		value.setRequisitionRcvId(RequisitionRcvStateEngine.getNewId()
				.longValue());
		RequisitionRcvStateEngine.save(value);

	}
}
