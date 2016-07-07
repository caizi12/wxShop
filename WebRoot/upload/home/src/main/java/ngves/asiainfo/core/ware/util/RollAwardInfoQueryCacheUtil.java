package ngves.asiainfo.core.ware.util;

import com.ai.appframe2.service.ServiceFactory;
import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.award.model.RoolAwardInfosViewModel;
import ngves.asiainfo.core.award.service.interfaces.IAwardInfoSrv;
import ngves.asiainfo.core.common.cache.ICacheLoader;
import ngves.asiainfo.util.MemcachedClientUtil;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 积分大转盘中奖公告滚屏信息cache
 * @author luohuan
 */
public class RollAwardInfoQueryCacheUtil {

    private static transient Log log = LogFactory.getLog(RollAwardInfoQueryCacheUtil.class);


	/**
	 * 如果不是规范的key前缀返回null
	 *
	 * @param keyPrefix
	 * @return
	 */
	public static ICacheLoader<?> getAcCacheLoader(String keyPrefix) {
        // 取信息
		if (CommnConstant.MEMCACHE_ROLL_AWARD_INFO_QUERY.equals(keyPrefix)) {
			return new RollAwardInfoQueryCacheLoader();
		}else{
            return null;
        }
	}
	/**
	 * 前一周礼品兑换信息<br/>
	 *
	 * @author luohuan
	 */
	public static class RollAwardInfoQueryCacheLoader implements ICacheLoader<RoolAwardInfosViewModel[]> {

        /**
         * 从HP中取得信息到memcache（当memcache中无值时会走此方法）
         * @param key
         * @return
         * @throws Exception
         */
		public  RoolAwardInfosViewModel[] findBeansByKey(String key) throws Exception {
			if(StringUtil.isBlank(key)) {
				log.warn("findBeansByKey roll_award_info_query is null by key := " + key);
				return null;
			}else{
				log.info("findBeansByKey methods: key="+CommnConstant.MEMCACHE_ROLL_AWARD_INFO_QUERY+"  from HP to Memcache start...");
				
				IAwardInfoSrv AwardInfoSrv = (IAwardInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_AWARD_INFO);
				RoolAwardInfosViewModel[] roll_award_info_query = AwardInfoSrv.getRollAwardInfo();
	            
	            log.info("findBeansByKey methods: key="+CommnConstant.MEMCACHE_ROLL_AWARD_INFO_QUERY+"  from HP to Memcache end...");
	            return roll_award_info_query;
			}
		}
	}
	
	/**
	 * 单独刷新信息
	 * @return
	 * @throws Exception
	 */
	public static boolean refreshRollAwardInfosViewToCache() throws Exception{
		
		String  filterKey = CommnConstant.MEMCACHE_ROLL_AWARD_INFO_QUERY;
	
		RoolAwardInfosViewModel[] rollAwardInfos = new RollAwardInfoQueryCacheLoader().findBeansByKey(filterKey);
		if(rollAwardInfos == null){
			return false;
		}
		MemcachedClientUtil.setObject(filterKey, rollAwardInfos);
		return true;
		
	} 
	
	/**
	 * 重新从HP中读取数据到Mamcache中
	 * @throws Exception
	 */
	public static void reLoadWareWeekRankToCache()throws Exception{
		
		if(!refreshRollAwardInfosViewToCache()){
			log.warn("refreshRollAwardInfosViewToCache is null or fail");
			return;
		}
	}
	
}