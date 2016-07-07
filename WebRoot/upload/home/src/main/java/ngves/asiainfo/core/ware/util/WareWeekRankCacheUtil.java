package ngves.asiainfo.core.ware.util;

import com.ai.appframe2.service.ServiceFactory;
import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.common.cache.ICacheLoader;
import ngves.asiainfo.util.MemcachedClientUtil;
import ngves.asiainfo.core.ware.ivalues.IwareWeekRankValue;
import ngves.asiainfo.core.ware.service.interfaces.IWareInfoSrv;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 礼品前七天兑换榜cache
 * @author luohuan
 */
public class WareWeekRankCacheUtil {

    private static transient Log log = LogFactory.getLog(WareWeekRankCacheUtil.class);


	/**
	 * 如果不是规范的key前缀返回null
	 *
	 * @param keyPrefix
	 * @return
	 */
	public static ICacheLoader<?> getAcCacheLoader(String keyPrefix) {
        // 取得一周榜单信息
		if (CommnConstant.MEMCACHE_WARE_WEEK_RANK.equals(keyPrefix)) {
			return new WareWeekRankCacheLoader();
		}else{
            return null;
        }
	}
	/**
	 * 前一周礼品兑换信息<br/>
	 *
	 * @author luohuan
	 */
	public static class WareWeekRankCacheLoader implements ICacheLoader<IwareWeekRankValue[]> {

        /**
         * 从数据库中取得信息到memcache（当memcache中无值时会走此方法）
         * @param key
         * @return
         * @throws Exception
         */
		public  IwareWeekRankValue[] findBeansByKey(String key) throws Exception {
			if(StringUtil.isBlank(key)) {
				log.warn("findBeansByKey ware_week_rank is null by key := " + key);
				return null;
			}else{
				log.info("findBeansByKey methods: key="+CommnConstant.MEMCACHE_WARE_WEEK_RANK+"  from DB to Memcache start...");
				
				IWareInfoSrv wareInfoSrv = (IWareInfoSrv)ServiceFactory.getService(CoreSrvContstant.SERVICE_WARE_INFO);
				IwareWeekRankValue[] ware_week_rank = wareInfoSrv.getWareWeekRankValue();
	            
	            log.info("findBeansByKey methods: key="+CommnConstant.MEMCACHE_WARE_WEEK_RANK+"  from DB to Memcache end...");
	            return ware_week_rank;
			}
		}
	}
	
	/**
	 * 单独刷新信息
	 * @return
	 * @throws Exception
	 */
	public static boolean refreshWareWeekRankToCache() throws Exception{
		
		String  filterKey = CommnConstant.MEMCACHE_WARE_WEEK_RANK;
	
		IwareWeekRankValue[] wareWeekRankInfo = new WareWeekRankCacheLoader().findBeansByKey(filterKey);
		if(wareWeekRankInfo == null){
			return false;
		}
		MemcachedClientUtil.setObject(filterKey, wareWeekRankInfo);
		return true;
		
	} 
	
	/**
	 * 重新从数据库中读取数据到Mamcache中
	 * @throws Exception
	 */
	public static void reLoadWareWeekRankToCache()throws Exception{
		
		if(!refreshWareWeekRankToCache()){
			log.warn("reLoadWareWeekRankToCache is null or fail");
			return;
		}
	}
	
}