package ngves.asiainfo.core.ua.service.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.ua.dao.interfaces.IUserAgentDAO;
import ngves.asiainfo.core.ua.ivalues.IUserAgentAdapterValue;
import ngves.asiainfo.core.ua.ivalues.IUserAgentValue;
import ngves.asiainfo.core.ua.service.interfaces.IUserAgentSrv;
import ngves.asiainfo.util.StringUtil;

public class UserAgentSrvImpl implements IUserAgentSrv {
	private IUserAgentDAO userAgentDAO;

	public void setUserAgentDAO(IUserAgentDAO userAgentDAO) {
		this.userAgentDAO = userAgentDAO;
	}

	public void saveUserAgent(IUserAgentValue userAgentValue) throws Exception {
		userAgentDAO.saveUserAgent(userAgentValue);
	}

	public IUserAgentValue getUserAgentByUaStr(String uaStr) throws Exception {
		StringBuilder condition = new StringBuilder();
		Map<String, Object> param = new HashMap<String, Object>();

		if (StringUtil.isBlank(uaStr)) {
			uaStr = "";
		}

		condition.append(IUserAgentValue.S_UaStr + " =:" + IUserAgentValue.S_UaStr);
		param.put(IUserAgentValue.S_UaStr, uaStr);

		IUserAgentValue[] userAgentValues = userAgentDAO.getUserAgentsByCondition(condition.toString(), param);
		if (userAgentValues != null && userAgentValues.length > 0) {
			return userAgentValues[0];
		} else {
			return null;
		}
	}

	public IUserAgentAdapterValue[] queryUserAgentAdapterList() {
		StringBuilder condition = new StringBuilder();
		condition.append(" order by "+IUserAgentAdapterValue.S_Priority);
		IUserAgentAdapterValue[] userAgentAdapterValues = null;
		try {
			userAgentAdapterValues = userAgentDAO.queryUserAgentAdapterList(condition.toString(),null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userAgentAdapterValues;
	}
}
