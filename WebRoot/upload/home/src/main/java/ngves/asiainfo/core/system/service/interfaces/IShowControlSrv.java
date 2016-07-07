/**
 * Copyright (c) 2011 asiainfo.com
 */
package ngves.asiainfo.core.system.service.interfaces;

import ngves.asiainfo.core.system.dao.interfaces.IShowControlDAO;
import ngves.asiainfo.core.system.ivalues.IShowControlValue;

/**
 * 置灰状态控制
 * @author ggs
 */
public interface IShowControlSrv {

	public void setControlDao(IShowControlDAO controlDao) throws Exception;

	/**
	 * 页面显示置灰信息
	 * @param showName
	 * @param is_grey
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IShowControlValue[] queryShowControl(String showName, String is_grey, int startIndex, int endIndex)
			throws Exception;

	/**
	 * 对页面操作做出回应
	 * @param showId
	 * @return
	 * @throws Exception
	 */
	public IShowControlValue getControlShowByIdAndModify(String showId) throws Exception;

	/**
	 * 保存页面更改后的信息
	 * @param value
	 * @throws Exception
	 */
	public void saveOrUpdate(IShowControlValue value) throws Exception;

}
