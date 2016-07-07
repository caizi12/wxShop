package ngves.asiainfo.core.ua.service.interfaces;

import ngves.asiainfo.core.ua.dao.interfaces.IUserAgentDAO;
import ngves.asiainfo.core.ua.ivalues.IUserAgentAdapterValue;
import ngves.asiainfo.core.ua.ivalues.IUserAgentValue;

/**
 * 创建UA（User-Agent）管理接口
 * @author zhaoyujie
 *@CreateDate 2011-05-24 18:47
 */
public interface IUserAgentSrv {
	public void setUserAgentDAO(IUserAgentDAO userAgentDAO);
	/**
	 * 保存UA对象
	 * @author zhaoyujie
	 * @CreateDate 2011-05-25 14:00
	 * @param userAgentValue
	 * @throws Exception
	 */
	public void saveUserAgent(IUserAgentValue userAgentValue) throws Exception;
	/**
	 * 根据UaStr查询UA
	 * @author zhaoyujie
	 * @CreateDate 2011-05-25 14:20
	 * @param uaStr
	 * @return
	 * @throws Exception
	 */
	public IUserAgentValue getUserAgentByUaStr(String uaStr) throws Exception;
	/**
	 * 查询按照优先级排序的UA适配列表
	 * @return
	 */
	public IUserAgentAdapterValue[] queryUserAgentAdapterList();
	
}
