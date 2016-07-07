/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.dao.interfaces;

import ngves.asiainfo.core.common.ivalues.IBusiAllegeReplySendValue;

/**
 * 投诉回复发送流水表DAO层
 * 
 * @author ggs
 */
public interface IBusiAllegeReplySendDAO {

	/**
	 * 保存投诉回复发送对象
	 * @param busiCustomCommunionValue
	 * @throws Exception
	 */
	public void saveBusiAllegeReplySend(IBusiAllegeReplySendValue busiAllegeReplySendValue) throws Exception;
	
	/**
	 * 查询投诉回复详细信息
	 * @param busiId
	 * @throws Exception
	 */
	public IBusiAllegeReplySendValue getBusiAllegeReplySendValueById(long busiId) throws Exception;
	
}
