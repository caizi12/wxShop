/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.dao.impl;

import ngves.asiainfo.core.common.bo.BusiAllegeRejectSendEngine;
import ngves.asiainfo.core.common.ivalues.IBusiAllegeRejectSendValue;
import ngves.asiainfo.core.csvc.dao.interfaces.IBusiAllegeRejectSendDAO;

/**
 * 投诉退回发送流水表DAO层的默认实现类
 * @author sxl
 *
 */
public class BusiAllegeRejectSendDAOImpl implements IBusiAllegeRejectSendDAO {

	public void saveBusiAllegeRejectSend(IBusiAllegeRejectSendValue busiAllegeRejectSendValue) throws Exception {
	
		if(busiAllegeRejectSendValue.isNew()){
			busiAllegeRejectSendValue.setBusiId(BusiAllegeRejectSendEngine.getNewId().longValue());
		}
		BusiAllegeRejectSendEngine.save(busiAllegeRejectSendValue);
	}

	public IBusiAllegeRejectSendValue getBusiAllegeRejectSendById(long busiId) throws Exception {
		return BusiAllegeRejectSendEngine.getBean(busiId);
	}

}
