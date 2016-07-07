/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.dao.interfaces;

import ngves.asiainfo.core.common.ivalues.IBusiAllegeRejectSendValue;


/**
 * 投诉退回发送流水表DAO层
 * @author sxl
 *
 */
public interface IBusiAllegeRejectSendDAO {

	/**
	 * 保存投诉退回发送对象
	 * @param busiAllegeRejectSendValue
	 * @throws Exception
	 */
	public void saveBusiAllegeRejectSend(IBusiAllegeRejectSendValue busiAllegeRejectSendValue) throws Exception;
	
	/**
	 * 查询投诉退回发送对象详细信息
	 * @param busiAllegeRejectSendValue
	 * @throws Exception
	 */
	public IBusiAllegeRejectSendValue getBusiAllegeRejectSendById(long busiId) throws Exception;
	
}
