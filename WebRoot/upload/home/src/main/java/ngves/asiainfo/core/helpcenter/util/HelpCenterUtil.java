package ngves.asiainfo.core.helpcenter.util;

import java.util.ArrayList;
import java.util.List;
import ngves.asiainfo.util.MemcachedClientUtil;
import ngves.asiainfo.core.helpcenter.HelpCenterConstant;
import ngves.asiainfo.core.helpcenter.ivalues.IHelpCenterinfoValue;
import ngves.asiainfo.core.helpcenter.service.interfaces.IHelpCenterInfoSrv;


import com.ai.appframe2.service.ServiceFactory;

/**
 * 帮助中心缓存管理
 * @author xj
 *
 */
public class HelpCenterUtil {

	
	

	/***
	 * 加载帮助信息到缓存中
	 * @throws Exception
	 */
	public static void loadHelpCenterinfos() throws Exception {
		MemcachedClientUtil.clearObject(HelpCenterConstant.MEMCACHED_KEY);
		List<IHelpCenterinfoValue> valueList = new ArrayList<IHelpCenterinfoValue>();
		IHelpCenterInfoSrv helpCenterInfoSrv = (IHelpCenterInfoSrv) ServiceFactory.getService(HelpCenterConstant.SERVICE_MGT_HELP_CENTER);
		valueList = helpCenterInfoSrv.queryHelpCenterinfoForPortal();
		MemcachedClientUtil.setObject(HelpCenterConstant.MEMCACHED_KEY, valueList);
		
	}
	
}
