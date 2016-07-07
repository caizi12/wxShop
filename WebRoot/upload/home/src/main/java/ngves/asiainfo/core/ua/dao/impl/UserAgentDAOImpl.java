package ngves.asiainfo.core.ua.dao.impl;

import java.util.Map;

import ngves.asiainfo.core.ua.bo.UserAgentAdapterEngine;
import ngves.asiainfo.core.ua.bo.UserAgentEngine;
import ngves.asiainfo.core.ua.dao.interfaces.IUserAgentDAO;
import ngves.asiainfo.core.ua.ivalues.IUserAgentAdapterValue;
import ngves.asiainfo.core.ua.ivalues.IUserAgentValue;

public class UserAgentDAOImpl implements IUserAgentDAO {
	public void saveUserAgent(IUserAgentValue userAgentValue) throws Exception{
		if(userAgentValue.isNew()){
			userAgentValue.setId(UserAgentEngine.getNewId().longValue());
		}
		UserAgentEngine.save(userAgentValue);
	}

	public IUserAgentValue[] getUserAgentsByCondition(String condition,Map<String, Object> param) throws Exception {
		return UserAgentEngine.getBeans(condition, param);
	}

	public IUserAgentAdapterValue[] queryUserAgentAdapterList(String condition,
			Map<String, Object> param) throws Exception {
		return UserAgentAdapterEngine.getBeans(condition, param);
	}
}
