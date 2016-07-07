/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.service.interfaces;

import ngves.asiainfo.core.common.model.BusiInterMsg;
import ngves.asiainfo.core.csvc.dao.interfaces.IBusiInterMsgDAO;

/**
 * 对外报文交换流水业务服务接口
 * @author wzg
 *
 */
public interface IInterMsgBusiSrv {
	
	public void setBusiInterMsgDAO(IBusiInterMsgDAO busiInterMsgDAO);
	
	/**
	 * 记录报文内容到报文流水表中
	 * @return
	 */
	public long addInterMsgBusiInfo(BusiInterMsg busiInterMsg) throws Exception;
}
