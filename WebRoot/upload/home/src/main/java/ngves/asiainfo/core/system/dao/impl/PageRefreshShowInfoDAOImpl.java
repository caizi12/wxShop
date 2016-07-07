package ngves.asiainfo.core.system.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.system.SystemSrvConstant;
import ngves.asiainfo.core.system.bo.PageRefreshShowEngine;
import ngves.asiainfo.core.system.dao.interfaces.IPageRefreshShowInfoDAO;
import ngves.asiainfo.core.system.ivalues.IPageRefreshShowValue;
import ngves.asiainfo.util.StringUtil;

public class PageRefreshShowInfoDAOImpl implements IPageRefreshShowInfoDAO {

	public IPageRefreshShowValue[] queryPageRefreshShow(int startIndex, int endIndex) throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String, String> parameter = new HashMap<String, String>();
		condition.append(" and " + IPageRefreshShowValue.S_PageType + " != :pageType ");
		//类型为3的页面需要支持批量刷新功能，因此需要单独处理
		parameter.put("pageType", SystemSrvConstant.SERVICE_MGT_STATIC_PAGE_BATCH_WARE_DETAIL_TYPE);
		condition.append(" order by " + IPageRefreshShowValue.S_PageId);
		return PageRefreshShowEngine.getBeans(null, condition.toString(), parameter,
				startIndex, endIndex, false);
	}

	public int queryPageRefreshShowCount() throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String, String> parameter = new HashMap<String, String>();
		condition.append(" and " + IPageRefreshShowValue.S_PageType + " != :pageType");
		//类型为3的页面需要支持批量刷新功能，因此需要单独处理
		parameter.put("pageType", SystemSrvConstant.SERVICE_MGT_STATIC_PAGE_BATCH_WARE_DETAIL_TYPE);
		return PageRefreshShowEngine.getBeansCount(condition.toString(), parameter);
	}
	
	public IPageRefreshShowValue[] queryPageRefreshShowByType(String pageType) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuffer condition = new StringBuffer(" 1=1 ");
		if(!StringUtil.isBlank(pageType)){
			condition.append(" and " + IPageRefreshShowValue.S_PageType + " = :pageType");
			map.put("pageType", pageType);
		}
		return PageRefreshShowEngine.getBeans(condition.toString(), map);
	}

}
