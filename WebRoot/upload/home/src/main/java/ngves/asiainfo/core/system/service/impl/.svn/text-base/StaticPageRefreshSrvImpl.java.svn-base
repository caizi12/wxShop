package ngves.asiainfo.core.system.service.impl;

import ngves.asiainfo.core.system.SystemSrvConstant;
import ngves.asiainfo.core.system.dao.interfaces.IPageRefreshShowInfoDAO;
import ngves.asiainfo.core.system.ivalues.IPageRefreshShowValue;
import ngves.asiainfo.core.system.service.interfaces.IStaticPageRefreshSrv;

public class StaticPageRefreshSrvImpl implements IStaticPageRefreshSrv {
		
	public IPageRefreshShowInfoDAO pageRefreshShowInfoDAO;

	public IPageRefreshShowValue[] queryPageRefreshShow(int startIndex, int endIndex) throws Exception {
		IPageRefreshShowValue[] values = pageRefreshShowInfoDAO.queryPageRefreshShow(startIndex, endIndex);
		int row = 0;
		for(IPageRefreshShowValue value : values){
			value.setBakCol1("<a href=\"#\" onclick=\"javascript:refreshProcess('"+row+"','" + value.getShUrl() + "')\">刷新</a>");
			row++;
		}
		return values;
	}
	
	public int queryPageRefreshShowCount() throws Exception {
		return pageRefreshShowInfoDAO.queryPageRefreshShowCount();
	}
	
	public void pageRefresh(String shUrl) throws Exception {
	}
	public IPageRefreshShowValue[] wareDetailPageRefresh(String wareCodes) throws Exception {
		String pageType = SystemSrvConstant.SERVICE_MGT_STATIC_PAGE_BATCH_WARE_DETAIL_TYPE;//批量刷新礼品详情页的脚本类型;
		IPageRefreshShowValue[] values = pageRefreshShowInfoDAO.queryPageRefreshShowByType(pageType);
		return values;
	}
	public IPageRefreshShowInfoDAO getPageRefreshShowInfoDAO() {
		return pageRefreshShowInfoDAO;
	}

	public void setPageRefreshShowInfoDAO(IPageRefreshShowInfoDAO pageRefreshShowInfoDAO) {
		this.pageRefreshShowInfoDAO = pageRefreshShowInfoDAO;
	}


}
