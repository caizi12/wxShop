/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.dao.interfaces;

import ngves.asiainfo.core.common.ivalues.IBusiAllegeHandlingAcceptValue;

/**
 * 投诉归档接收流水表DAO层
 * 
 * @author ggs
 */
public interface IBusiAllegeHandlingAcceptDAO {

	/**
	 * 保存投诉归档到接受流水表
	 * @param busiAllegeRhandleAcceptValue
	 * @throws Exception
	 */
	public void saveBusiAllegeHandlingAccept(IBusiAllegeHandlingAcceptValue busiAllegeHandlingAcceptValue) throws Exception;
	
	/**
	 * 查询投诉归档详细信息
	 * @param busiId
	 * @throws Exception
	 */
	public IBusiAllegeHandlingAcceptValue getBusiAllegeHandlingAcceptById(long busiId) throws Exception;
	
}
