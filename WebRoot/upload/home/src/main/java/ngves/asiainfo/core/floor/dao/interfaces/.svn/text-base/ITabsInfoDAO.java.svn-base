package ngves.asiainfo.core.floor.dao.interfaces;

import ngves.asiainfo.core.floor.ivalues.ITabsInfoValue;

/**
 * 维护楼层页签基本能信息
 * @author lzq
 *
 */
public interface ITabsInfoDAO {

	/**
	 * 保存楼层页签基本信息
	 * @param tabsInfoValue
	 * @return
	 * @throws Exception
	 */
	public void saveTabsInfo(ITabsInfoValue tabsInfoValue) throws Exception;

	/**
	 * 批量保存
	 * @param tabsInfoValues
	 * @throws Exception
	 */
	public void saveTabsInfos(ITabsInfoValue[] tabsInfoValues) throws Exception;

	/**
	 * 根据标识查询页签信息
	 * @param tabsInfoId
	 * @return
	 * @throws Exception
	 */
	public ITabsInfoValue queryTabsInfoById(long tabsInfoId) throws Exception;

	/**
	 * 根据id查页签基本能信息
	 */
	public ITabsInfoValue[] queryTabsById(long tabsInfoId) throws Exception;
	/**
	 * 根据推荐名称模糊查询楼层默认推荐（页签表）
	 */
	public ITabsInfoValue[] queryTabsByName(String tabsName, int satarNum, int endNum) throws Exception;

	/**
	* 根据推荐名称模糊查询楼层默认推荐总数（页签表）
	*/
	public int queryTabsByNameCount(String tabsName) throws Exception;
	/***
	 * 获取新标识
	 * @return
	 * @throws Exception
	 */
	public long getNewId() throws Exception;
}
