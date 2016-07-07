/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.system.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.common.cache.CacheLoaderTemplate;
import ngves.asiainfo.core.common.cache.ICacheLoader;
import ngves.asiainfo.core.system.SystemSrvConstant;
import ngves.asiainfo.core.system.ivalues.IMetaInfoValue;
import ngves.asiainfo.core.system.ivalues.INavigationInfoValue;
import ngves.asiainfo.core.system.ivalues.IShowControlValue;
import ngves.asiainfo.core.system.service.interfaces.IMetaInfoSrv;
import ngves.asiainfo.core.system.service.interfaces.INavigationInfoSrv;
import ngves.asiainfo.core.system.service.interfaces.IShowControlSrv;

/**
 * 首页的导航页签,首页的META和首页是否置灰操作工具类
 * @author wzg
 * 
 */
public class IndexNavUtil {
	
	private static transient Log log = LogFactory.getLog(IndexNavUtil.class);
	
	/**
	 * 必须保证数据库就一条记录,目前正常情况下也是一条,出错或异常返回""
	 * @return
	 */
	public static String getIndexMetaKeyWords(){
		try {
			IMetaInfoValue[] queryMetaInfoByMetaDesc = ((IMetaInfoSrv) ServiceFactory
			.getService(SystemSrvConstant.META_INFO_SERVICE)).queryMetaInfoByMetaDesc("", -1, -1);
			if(queryMetaInfoByMetaDesc != null && queryMetaInfoByMetaDesc.length == 1) {
				return queryMetaInfoByMetaDesc[0].getMetaDesc();
			}
		} catch (Exception e) {
			log.warn(" queryMetaInfoByMetaDesc method is occur excep ... ", e);
		}
		return "";
	}
	
	/**
	 * 必须保证数据库就一条记录,目前正常情况下也是一条,出错或异常返回"0"<br/>
	 * 如果是置灰返回"1"
	 * @return
	 */
	public static String getIndexGrayStatus() {
		try {
			IShowControlValue[] queryShowControl = ((IShowControlSrv) ServiceFactory
			.getService(SystemSrvConstant.SERVICE_MGT_SHOW_ENABLE)).queryShowControl("", "", -1, -1);
			if(queryShowControl != null && queryShowControl.length == 1){
				return queryShowControl[0].getIsGrey();
			}
		} catch (Exception e) {
			log.warn(" queryShowControl method is occur excep ... ", e);
		}
		return CommnConstant.VALID_FLAG_DISABALE;
	}
	
	/**
	 * 如果没有内容返回空数组(长度为0),如果发生异常返回null
	 * @return
	 */
	public static INavigationInfoValue[] getNavInfos() {
		try {
			return CacheLoaderTemplate.getEntity(CoreConstant.NAVIGATION_MEM_KEY, new NavInfosLoader());
		} catch (Exception e) {
			log.warn(" cache-opt or loader is occur excep ...", e);
			return null;
		}
	}
	
	/**
	 * 加载所有配置的导航页签
	 * @author wzg
	 *
	 */
	public static class NavInfosLoader implements ICacheLoader<INavigationInfoValue[]> {

		public INavigationInfoValue[] findBeansByKey(String key) throws Exception {
			return ((INavigationInfoSrv) ServiceFactory
            .getService(SystemSrvConstant.NAVIGATION_INFO_SERVICE)).findAllNavInfosByNavDesc("", -1, -1);
		}
		
	}
	
}
