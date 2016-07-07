/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.dao.impl;

import ngves.asiainfo.core.common.bo.BusiAllegeReplySendEngine;
import ngves.asiainfo.core.common.ivalues.IBusiAllegeReplySendValue;
import ngves.asiainfo.core.csvc.dao.interfaces.IBusiAllegeReplySendDAO;
import ngves.asiainfo.util.DateTimeUtil;

/**
 * 投诉回复发送流水表DAO层的默认实现类
 * 
 * @author ggs
 */
public class BusiAllegeReplySendDAOImpl implements IBusiAllegeReplySendDAO {

	public void saveBusiAllegeReplySend(IBusiAllegeReplySendValue busiAllegeReplySendValue) throws Exception {
		
		if(busiAllegeReplySendValue.isNew()){
            busiAllegeReplySendValue.setCreateDate(DateTimeUtil.getDefaultSysDate());
			busiAllegeReplySendValue.setBusiId(BusiAllegeReplySendEngine.getNewId().longValue());
		}
		BusiAllegeReplySendEngine.save(busiAllegeReplySendValue);
		
	}

	public IBusiAllegeReplySendValue getBusiAllegeReplySendValueById(long busiId) throws Exception {
		
		return BusiAllegeReplySendEngine.getBean(busiId);
	}

}
