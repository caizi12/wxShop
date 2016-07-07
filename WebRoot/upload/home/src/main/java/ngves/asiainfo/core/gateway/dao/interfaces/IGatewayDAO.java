package ngves.asiainfo.core.gateway.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.gateway.ivalues.IWapGatewayWhiteListValue;
/**
 * WAP安全登录网关管理
 * @author Administrator
 *
 */
public interface IGatewayDAO {
	/**
	 * 获取WAP网关白名单列表
	 * @param condition
	 * @param param
	 * @return
	 * @throws Exception 
	 */
	public IWapGatewayWhiteListValue[] queryWapGatewayWhiteList(String condition,Map<String, Object> param) throws Exception;
}
