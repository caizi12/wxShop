package ngves.asiainfo.core.ware.service.interfaces;

import ngves.asiainfo.core.ware.util.WareStatusTask;

public interface IWareStatus {

	/**
	 * 上线礼品
	 * @param task 礼品上下线任务
	 * @throws Exception
	 */
	public void operatorUpLineWare(WareStatusTask task)throws Exception;
	
	/**
	 * 下线礼品
	 * @param task 礼品上下线任务
	 * @throws Exception
	 */
	public void operatorDownLineWare(WareStatusTask task) throws Exception;

}
