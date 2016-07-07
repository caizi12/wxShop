package ngves.asiainfo.core.gateway.service.interfaces;

import ngves.asiainfo.core.gateway.dao.interfaces.IGatewayDAO;
import ngves.asiainfo.core.gateway.ivalues.IWapGatewayWhiteListValue;

/**
 * 创建WAP商城安全登录网关管理接口
 * @author zhaoyujie
 * @CreateDate 2011-11-02
 */
public interface IGatewaySrv {
	public void setGatewayDAO(IGatewayDAO gatewayDAO);
	/**
	 * 获取WAP网关白名单列表
	 * @return
	 * @throws Exception 
	 */
	public IWapGatewayWhiteListValue[] queryWapGatewayWhiteList() throws Exception;
}
