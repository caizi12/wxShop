package ngves.asiainfo.core.gateway.dao.impl;

import java.util.Map;

import ngves.asiainfo.core.gateway.bo.WapGatewayWhiteListEngine;
import ngves.asiainfo.core.gateway.dao.interfaces.IGatewayDAO;
import ngves.asiainfo.core.gateway.ivalues.IWapGatewayWhiteListValue;

public class GatewayDAOImpl implements IGatewayDAO {

	public IWapGatewayWhiteListValue[] queryWapGatewayWhiteList(
			String condition, Map<String, Object> param) throws Exception {
		return WapGatewayWhiteListEngine.getBeans(condition, param);
	}
	
}
