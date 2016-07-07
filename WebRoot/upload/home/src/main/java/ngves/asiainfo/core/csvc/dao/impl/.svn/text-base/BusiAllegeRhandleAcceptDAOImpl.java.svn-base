/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.common.bo.BusiAllegeRHandleAcceptEngine;
import ngves.asiainfo.core.common.ivalues.IBusiAllegeRHandleAcceptValue;
import ngves.asiainfo.core.csvc.dao.interfaces.IBusiAllegeRhandleAcceptDAO;

/**
 * 投诉再处理接收流水表DAO层默认实现类
 * @author sxl
 *
 */
public class BusiAllegeRhandleAcceptDAOImpl implements IBusiAllegeRhandleAcceptDAO {

	/**
	 * 查询投诉再处理流水表状态为"附件接收完成"的投诉记录
	 */
	private static final String RE_HANDLE_SQL = IBusiAllegeRHandleAcceptValue.S_BusiStatus + " = :"
			+ IBusiAllegeRHandleAcceptValue.S_BusiStatus;

	public void saveBusiAllegeRhandleAccept(IBusiAllegeRHandleAcceptValue busiAllegeRhandleAcceptValue)
			throws Exception {

		if (busiAllegeRhandleAcceptValue.isNew()) {
			busiAllegeRhandleAcceptValue.setBusiId(BusiAllegeRHandleAcceptEngine.getNewId().longValue());
		}
		BusiAllegeRHandleAcceptEngine.save(busiAllegeRhandleAcceptValue);
	}

	public IBusiAllegeRHandleAcceptValue[] getFinishRehandleAllege(String busiStatus) throws Exception {

		Map<String, String> param = new HashMap<String, String>();
		param.put(IBusiAllegeRHandleAcceptValue.S_BusiStatus, busiStatus);

		return BusiAllegeRHandleAcceptEngine.getBeans(RE_HANDLE_SQL, param);
	}

	public IBusiAllegeRHandleAcceptValue get(long busiAllegeRhandleAcceptId) throws Exception {
		return BusiAllegeRHandleAcceptEngine.getBean(busiAllegeRhandleAcceptId);
	}
	
	
}
