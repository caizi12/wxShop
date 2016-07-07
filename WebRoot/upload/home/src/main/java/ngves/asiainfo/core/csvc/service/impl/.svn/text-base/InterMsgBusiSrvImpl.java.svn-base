/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.service.impl;

import ngves.asiainfo.core.common.model.BusiInterMsg;
import ngves.asiainfo.core.csvc.dao.interfaces.IBusiInterMsgDAO;
import ngves.asiainfo.core.csvc.service.interfaces.IInterMsgBusiSrv;

/**
 * @author wzg
 *
 */
public class InterMsgBusiSrvImpl implements IInterMsgBusiSrv {
	private IBusiInterMsgDAO busiInterMsgDAO;
	
	public IBusiInterMsgDAO getBusiInterMsgDAO() {
		return busiInterMsgDAO;
	}

	public void setBusiInterMsgDAO(IBusiInterMsgDAO busiInterMsgDAO) {
		this.busiInterMsgDAO = busiInterMsgDAO;
	}

	public long addInterMsgBusiInfo(BusiInterMsg busiInterMsg) throws Exception {
		return getBusiInterMsgDAO().saveBusiInterMsg(busiInterMsg);
	}

}
