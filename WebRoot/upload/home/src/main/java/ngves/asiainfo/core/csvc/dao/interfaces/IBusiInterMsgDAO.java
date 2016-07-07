/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.dao.interfaces;

import ngves.asiainfo.core.common.model.BusiInterMsg;

/**
 * 报文流水表操作接口
 * 
 * @author ggs
 */
public interface IBusiInterMsgDAO {
	
	/**
	 * 保存报文流水的内容,Clob字段操作
	 * @param busiInterMsg
	 * @return
	 * @throws Exception
	 */
	public long saveBusiInterMsg(BusiInterMsg busiInterMsg) throws Exception;
}
