package ngves.asiainfo.core.helpcenter.util;

import java.util.List;


import ngves.asiainfo.core.common.cache.ICacheLoader;
import ngves.asiainfo.core.helpcenter.HelpCenterConstant;
import ngves.asiainfo.core.helpcenter.ivalues.IHelpCenterinfoValue;
import ngves.asiainfo.core.helpcenter.service.interfaces.IHelpCenterInfoSrv;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;

public class HelpCenterCacheUtil {

	private static transient Log logger = LogFactory.getLog(HelpCenterCacheUtil.class);

	/**
	 * 获取帮助中心信息
	 * 
	 */
	public static class HelpCenterCacheLoader implements ICacheLoader<List<IHelpCenterinfoValue>> {

		public List<IHelpCenterinfoValue> findBeansByKey(String key) throws Exception {

			List<IHelpCenterinfoValue> values = null;
			logger.info("get helpcenter's data from database, key=" +  key);
		
			IHelpCenterInfoSrv helpCenterInfoSrv = (IHelpCenterInfoSrv) ServiceFactory.getService(HelpCenterConstant.SERVICE_MGT_HELP_CENTER);
			values=helpCenterInfoSrv.queryHelpCenterinfoForMgt();
			return  values;
		}
	}
}
