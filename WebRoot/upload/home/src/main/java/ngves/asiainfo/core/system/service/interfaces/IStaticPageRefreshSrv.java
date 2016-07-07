package ngves.asiainfo.core.system.service.interfaces;

import ngves.asiainfo.core.system.dao.interfaces.IPageRefreshShowInfoDAO;
import ngves.asiainfo.core.system.ivalues.IPageRefreshShowValue;


public interface IStaticPageRefreshSrv {

	/**
	 * 需要刷新的静态页面信息
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IPageRefreshShowValue[] queryPageRefreshShow(int startIndex, int endIndex) throws Exception;
	
	public int queryPageRefreshShowCount() throws Exception;
	
	public void setPageRefreshShowInfoDAO(IPageRefreshShowInfoDAO pageRefreshShowInfoDAO) throws Exception;
	
	/**
	 * 根据脚本地址，调用脚本刷新静态页面
	 * @param shUrl
	 * @throws Exception
	 */
	public void pageRefresh(String shUrl) throws Exception;
	
	/**
	 * 根据礼品codes 批量刷新 礼品详情页
	 * @param wareCodes
	 */
	public IPageRefreshShowValue[] wareDetailPageRefresh(String wareCodes) throws Exception;
}
