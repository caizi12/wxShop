package ngves.asiainfo.core.system.dao.interfaces;

import ngves.asiainfo.core.system.ivalues.IPageRefreshShowValue;

public interface IPageRefreshShowInfoDAO {
	/**
	 * 静态页面显示信息
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IPageRefreshShowValue[] queryPageRefreshShow(int startIndex, int endIndex)
			throws Exception;
	
	public int queryPageRefreshShowCount() throws Exception;
	
	/**
	 * 根据静态页面类型，查询相应的执行脚本路径
	 * @param pageType
	 * @return
	 * @throws Exception
	 */
	public IPageRefreshShowValue[] queryPageRefreshShowByType(String pageType) 
			throws Exception;
}
