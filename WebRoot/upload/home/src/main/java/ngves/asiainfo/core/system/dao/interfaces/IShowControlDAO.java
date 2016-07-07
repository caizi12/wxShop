/**
 * Copyright (c) 2011 asiainfo.com
 */
package ngves.asiainfo.core.system.dao.interfaces;

import ngves.asiainfo.core.system.ivalues.IShowControlValue;

/**
 * 置灰状态控制
 * @author ggs
 */
public interface IShowControlDAO {

	/**
	 * 页面显示置灰信息
	 * @param showName
	 * @param isGrey
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IShowControlValue[] queryShowControl(String showName, String isGrey, int startIndex, int endIndex)
			throws Exception;

	/**
	 * 根据主键ID查询信息
	 * @param showId
	 * @return
	 * @throws Exception
	 */
	public IShowControlValue getControlShowById(String showId) throws Exception;

	/**
	 * 保存活更新信息
	 * @param value
	 * @throws Exception
	 */
	public void saveOrUpdate(IShowControlValue value) throws Exception;
}
