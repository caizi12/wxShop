/**
 * 
 */
package ngves.asiainfo.core.theatre.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;

import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.common.cache.ICacheLoader;
import ngves.asiainfo.core.common.util.KeyUtil;
import ngves.asiainfo.core.theatre.service.interfaces.ITheatreInfoSrv;

/**
 * @author zhaoyujie
 *
 */
public class TheatreCacheUtil {
	
	private static transient Log log = LogFactory.getLog(TheatreCacheUtil.class);
	
	public static class TheatreCacheLoader implements ICacheLoader<String>{

		public String findBeansByKey(String key) throws Exception {
			String theatreInventory = "0";
			String keys[] = KeyUtil.decomposeKey(key);
			if (keys != null && keys.length == 2){
				//查询数据库
				ITheatreInfoSrv theatreInfoSrv = (ITheatreInfoSrv)ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_THEATREINFO_SRV);
				//从HP中间表中取数据
				theatreInventory = theatreInfoSrv.getTheatreSurplusCount(keys[1]);
				return theatreInventory;
			}
			log.warn("TheatreCacheLoader loader theatreInventory is null by key := " + key);
			return theatreInventory;
		}
		
	}
}
