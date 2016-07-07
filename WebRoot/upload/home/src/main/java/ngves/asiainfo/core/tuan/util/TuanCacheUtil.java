package ngves.asiainfo.core.tuan.util;

import com.ai.appframe2.service.ServiceFactory;
import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.common.cache.ICacheLoader;
import ngves.asiainfo.core.common.util.KeyUtil;
import ngves.asiainfo.util.MemcachedClientUtil;
import ngves.asiainfo.core.tuan.service.interfaces.IPreOrderInfoSrv;
import ngves.asiainfo.core.tuan.service.interfaces.ITuanUserLogSrv;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 团购cache
 * @author shenfl
 */
public class TuanCacheUtil {

    private static transient Log log = LogFactory.getLog(TuanCacheUtil.class);


	/**
	 * 如果不是规范的key前缀返回null
	 *
	 * @param keyPrefix
	 * @return
	 */
	public static ICacheLoader<?> getAcCacheLoader(String keyPrefix) {
        // 团购成团人数
		if (CommnConstant.MEMCACHE_TUAN_SUCCESS_RECORD.equals(keyPrefix)) {
			return new TuanCacheLoader();
		} else if (CommnConstant.MEMCACHE_TUAN_SUCCESS_COUNT.equals(keyPrefix)){
            // 从HP读取数据
            return new PreOrderInfoCacheLoader();
		}else{
            return null;
        }
	}
	/**
	 * 活动ID对应活动信息<br/>
	 * {tuan_success_record:tuanId=当前团购成功人数}
	 *
	 * @author shenfl
	 */
	public static class TuanCacheLoader implements ICacheLoader<String> {

        /**
         * 从memcache中取得对应的兑换成功的个数
         * @param key
         * @return
         * @throws Exception
         */
		public String findBeansByKey(String key) throws Exception {
             //keys[0]=tuan_success_record:tuanId,keys[1]=tuanId
			String keys[] = KeyUtil.decomposeKey(key);
			if (keys != null && keys.length == 2) {
                ITuanUserLogSrv tuanUserLogSrv = (ITuanUserLogSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_TUANUSERLOG_SRV);
                String tuan_success_count = tuanUserLogSrv.getSuccessCount(keys[1]);
                return tuan_success_count ;
			}
			log.warn("TuanCacheLoader tuan_success_record:tuanId  is null by key := " + key);
			return null;
		}
	}

    /**
     * 从HP表中读取对应的数量
     * at 2011-08-30
     * SELECT SUM(ITEMCOUNT) FROM PRE_ORDER_INFO WHERE ACTIONID='团兑ID'  AND ORDTYPE = '02'
     */
	public static  class PreOrderInfoCacheLoader implements ICacheLoader<Long> {

		public Long findBeansByKey(String key) throws Exception {
			//keys[0]=tuan_success_count,keys[1]=tuanId
            long sumOrderNum = 0L;
            String keys[] = KeyUtil.decomposeKey(key);
			if (keys != null && keys.length == 2) {

                //1. 获取服务
               IPreOrderInfoSrv preOrderInfoSrv = (IPreOrderInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_PREORDERINFO_SRV);

                //调用HP表中数据
                sumOrderNum = preOrderInfoSrv.getSumItemCounts(new Long(keys[1]));
                return sumOrderNum;
			}
			log.warn("PreOrderInfoCacheLoader loader IPreOrderInfoValue[] is null by key := " + key);
			return sumOrderNum;
		}
	}

    /**
	 * 下单成功后增加pre_order_info
	 * @param tuanId
	 * @throws Exception
	 */
	public static void updatePreoOrderInfoToCache(String tuanId) throws Exception{
        // key=tuan_success_count:tuanId,value=当前tuanId对应的成功兑换的数量
		String tuanSuccessCountKey = KeyUtil.composeKey(CommnConstant.MEMCACHE_TUAN_SUCCESS_COUNT,
				tuanId + "");
         IPreOrderInfoSrv preOrderInfoSrv = (IPreOrderInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_PREORDERINFO_SRV);
         //调用HP表中数据
         int tuanSuccessSumOrderNum = preOrderInfoSrv.getSumItemCounts(new Long(tuanId));
        // 定时扫描结果：key=tuan_success_count:tuanId,value=tuanSuccessSumOrderNum
		MemcachedClientUtil.setObject(tuanSuccessCountKey, new Long(tuanSuccessSumOrderNum));
	}


   /**
	 * 下单成功后增加
	 * @param tuanId
	 * @throws Exception
	 */
	public  static void updatePreOrderInfo(String tuanId) throws Exception {
        //合作key操作-用来唯一标记当前团购对应的团购成功兑换人数的key
        //tuan_success_record:tuanId
        String tuanSuccessRecordKey = KeyUtil.composeKey(CommnConstant.MEMCACHE_TUAN_SUCCESS_RECORD,
				tuanId + "");
        //从HP数据库查兑换人数的数量
          IPreOrderInfoSrv preOrderInfoSrv = (IPreOrderInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_PREORDERINFO_SRV);
         //调用HP表中数据
         int sumOrderNum = preOrderInfoSrv.getSumItemCounts(new Long(tuanId));
         log.info("call hp table pre_order_info: sumOrderNum = " + sumOrderNum);
         //定时扫描结果： tuan_success_record:tuanId=兑换成功人数
         MemcachedClientUtil.setObject(tuanSuccessRecordKey,sumOrderNum+"");
    }

	
}