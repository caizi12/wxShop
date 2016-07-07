package ngves.asiainfo.core.tuan.service.interfaces;

import ngves.asiainfo.core.tuan.dao.interfaces.ICategoryShowControlDAO;
import ngves.asiainfo.core.tuan.ivalues.ICategoryShowControlValue;

public interface ICategoryShowControlSrv {

	public void setCategoryShowControlDAO(ICategoryShowControlDAO categoryShowControlDAO) throws Exception;

	/**
	 * 团购分类显示信息
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
	 * 对页面操作做出回应
	 * @param showId
	 * @return
	 * @throws Exception
	 */
	public ICategoryShowControlValue getControlShowByIdAndModify(String showId) throws Exception;

	/**
	 * 保存页面更改后的信息
	 * @param value
	 * @throws Exception
	 */
	public void saveOrUpdate(ICategoryShowControlValue value) throws Exception;

}
