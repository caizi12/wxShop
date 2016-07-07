/**
 * Copyright (c) 2011 asiainfo-linkage.com
 */
package ngves.asiainfo.core.csvc.dao.impl;

import ngves.asiainfo.core.common.bo.BusiAllegeHandlingAcceptEngine;
import ngves.asiainfo.core.common.ivalues.IBusiAllegeHandlingAcceptValue;
import ngves.asiainfo.core.csvc.dao.interfaces.IBusiAllegeHandlingAcceptDAO;

/**
 * 投诉归档流水表DAO层默认实现类
 * 
 * @author zhangzy
 * 
 */
public class BusiAllegeHandlingAcceptDAOImpl implements IBusiAllegeHandlingAcceptDAO {

	/**
	 * 保存投诉归档到接受流水表
	 * 
	 * @param busiAllegeRhandleAcceptValue
	 * @throws Exception
	 */
	public void saveBusiAllegeHandlingAccept(IBusiAllegeHandlingAcceptValue busiAllegeHandlingAcceptValue)
			throws Exception {
		if (busiAllegeHandlingAcceptValue.isNew()) {
			busiAllegeHandlingAcceptValue.setBusiId(BusiAllegeHandlingAcceptEngine.getNewId().longValue());
		}
		BusiAllegeHandlingAcceptEngine.save(busiAllegeHandlingAcceptValue);

	}

	/**
	 * 查询投诉归档详细信息
	 * 
	 * @param busiId
	 * @throws Exception
	 */
	public IBusiAllegeHandlingAcceptValue getBusiAllegeHandlingAcceptById(long busiId) throws Exception {
		return BusiAllegeHandlingAcceptEngine.getBean(busiId);
	}

}
