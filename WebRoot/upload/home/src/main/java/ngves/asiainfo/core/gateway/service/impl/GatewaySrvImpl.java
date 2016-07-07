package ngves.asiainfo.core.gateway.service.impl;

import ngves.asiainfo.core.gateway.dao.interfaces.IGatewayDAO;
import ngves.asiainfo.core.gateway.ivalues.IWapGatewayWhiteListValue;
import ngves.asiainfo.core.gateway.service.interfaces.IGatewaySrv;

public class GatewaySrvImpl implements IGatewaySrv {

	private IGatewayDAO gatewayDAO;
	
	public void setGatewayDAO(IGatewayDAO gatewayDAO) {
		this.gatewayDAO = gatewayDAO;
	}

	public IWapGatewayWhiteListValue[] queryWapGatewayWhiteList() throws Exception {
		return gatewayDAO.queryWapGatewayWhiteList(null,null);
	}

}
