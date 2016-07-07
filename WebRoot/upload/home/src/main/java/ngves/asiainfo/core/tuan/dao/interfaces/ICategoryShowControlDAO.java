/**
 * Copyright (c) 2011 asiainfo.com
 */
package ngves.asiainfo.core.tuan.dao.interfaces;

import ngves.asiainfo.core.tuan.ivalues.ICategoryShowControlValue;

public interface ICategoryShowControlDAO {

	/**
	 * 页面显示
	 * @param showName
	 * @param is_show
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public ICategoryShowControlValue[] queryCategoryShowControl(String showName, String is_show, int startIndex, int endIndex)
			throws Exception;

	/**
	 * 根据主键ID查询信息
	 * @param showId
	 * @return
	 * @throws Exception
	 */
	public ICategoryShowControlValue getControlShowById(String showId) throws Exception;

	/**
	 * 保存活更新信息
	 * @param value
	 * @throws Exception
	 */
	public void saveOrUpdate(ICategoryShowControlValue value) throws Exception;
}
