package ngves.asiainfo.core.comment.util;

import com.ai.appframe2.service.ServiceFactory;
import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.comment.CommentConstant;
import ngves.asiainfo.core.comment.ivalues.IFilterWordsInfoValue;
import ngves.asiainfo.core.comment.service.interfaces.IFilterWordsInfoSrv;
import ngves.asiainfo.core.common.cache.ICacheLoader;
import ngves.asiainfo.util.MemcachedClientUtil;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 礼品评论cache
 * @author luohuan
 */
public class FilterCacheUtil {

    private static transient Log log = LogFactory.getLog(FilterCacheUtil.class);


	/**
	 * 如果不是规范的key前缀返回null
	 *
	 * @param keyPrefix
	 * @return
	 */
	public static ICacheLoader<?> getAcCacheLoader(String keyPrefix) {
        // 取得过滤词
		if (CommnConstant.MEMCACHE_FILTER_WORDS_INFO.equals(keyPrefix)) {
			return new FilterWordsCacheLoader();
		}else{
            return null;
        }
	}
	/**
	 * 过滤词信息<br/>
	 *
	 * @author luohuan
	 */
	public static class FilterWordsCacheLoader implements ICacheLoader<IFilterWordsInfoValue[]> {

        /**
         * 从数据库中取得过滤词到memcache（当memcache中无值时会走此方法）
         * @param key
         * @return
         * @throws Exception
         */
		public  IFilterWordsInfoValue[] findBeansByKey(String key) throws Exception {
			if(StringUtil.isBlank(key)) {
				log.warn("findBeansByKey filter_words_info is null by key := " + key);
				return null;
			}else{
				log.info("findBeansByKey methods: key="+CommnConstant.MEMCACHE_FILTER_WORDS_INFO+"  from DB to Memcache start...");
				
				IFilterWordsInfoSrv service = (IFilterWordsInfoSrv) ServiceFactory.getService(CommentConstant.FILTER_WRODS_INFO_SERVICE);
	            IFilterWordsInfoValue[] filter_words_info = service.getFilterWordsInfo();
	            
	            log.info("findBeansByKey methods: key="+CommnConstant.MEMCACHE_FILTER_WORDS_INFO+"  from DB to Memcache end...");
	            return filter_words_info;
			}
		}
	}
	
	/**
	 * 单独刷新过滤词信息
	 * @return
	 * @throws Exception
	 */
	public static boolean refreshFilterWordsToCache() throws Exception{
		
		String  filterKey = CommnConstant.MEMCACHE_FILTER_WORDS_INFO;
	
		IFilterWordsInfoValue[] filterWordsInfo = new FilterWordsCacheLoader().findBeansByKey(filterKey);
		if(filterWordsInfo == null){
			return false;
		}
		MemcachedClientUtil.setObject(filterKey, filterWordsInfo);
		return true;
		
	} 
	
	/**
	 * 重新从数据库中读取数据到Mamcache中
	 * @throws Exception
	 */
	public static void reLoadFilterWordsToCache()throws Exception{
		
		if(!refreshFilterWordsToCache()){
			log.warn("reLoadFilterWordsToCache is null or fail");
			return;
		}
	}
	
}