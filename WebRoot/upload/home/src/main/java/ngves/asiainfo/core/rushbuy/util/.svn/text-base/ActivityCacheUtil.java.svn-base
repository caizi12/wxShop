/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.rushbuy.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.common.cache.ICacheLoader;
import ngves.asiainfo.core.common.util.KeyUtil;
import ngves.asiainfo.util.MemcachedClientUtil;
import ngves.asiainfo.core.rushbuy.RushBuyConstant;
import ngves.asiainfo.core.rushbuy.ivalues.IActivityBindRelationValue;
import ngves.asiainfo.core.rushbuy.ivalues.IActivityLimitValue;
import ngves.asiainfo.core.rushbuy.ivalues.IQBOActivityWareInfoValue;
import ngves.asiainfo.core.rushbuy.ivalues.IQBOMainImageInfoValue;
import ngves.asiainfo.core.rushbuy.service.interfaces.IRushBuySrv;
import ngves.asiainfo.core.rushbuy.service.interfaces.IRushWareDetailSrv;

/**
 * 限时抢兑换货加载工具类,通过静态内部类实现缓存接口类<br/>
 * 并提供可以加载限时抢兑活动以及关联的礼品信息,图片信息到缓存的操作
 * 
 * @author wzg
 * 
 */
public class ActivityCacheUtil {

	private static transient Log log = LogFactory.getLog(ActivityCacheUtil.class);
	
	/**
	 * 单独刷新限时抢兑活动信息
	 * @param activityId
	 * @return
	 * @throws Exception
	 */
	public static boolean refreshActivityInfoToCache(long activityId) throws Exception {
		// 加载活动信息
		String activityKey = KeyUtil.composeKey(CommnConstant.MEMCACHE_ACTIVITY_LIMIT_INFO, activityId + "");
		IActivityLimitValue acInfo = new ActivityCacheLoader().findBeansByKey(activityKey);
		if (acInfo == null) {
			return false;
		}
		MemcachedClientUtil.setObject(activityKey, acInfo);
		return true;
	}
	
	/**
	 * 刷新活动关联的礼品的抢兑信息(抢兑积分值-抢兑库存值,排序号等)
	 * @param activityId
	 * @return
	 * @throws Exception
	 */
	public static IActivityBindRelationValue[] refreshActivityBindRelationCache(long activityId) throws Exception{
		// 加载活动关联的礼品的抢兑信息(抢兑积分值-抢兑库存值,排序号等)
		String activityBindRelationKey = KeyUtil.composeKey(CommnConstant.MEMCACHE_ACTIVITY_LIMIT_BIND_WARE_INFO,
				activityId + "");
		IActivityBindRelationValue[] actBindrelas = new ActivityBindRelationCacheLoader()
				.findBeansByKey(activityBindRelationKey);
		if (actBindrelas != null && actBindrelas.length > 0 ){
			MemcachedClientUtil.setObject(activityBindRelationKey, actBindrelas);
		}
		return actBindrelas;
	}

	/**
	 * 如果该活动发布时,刷新
	 * 
	 * @param activityId
	 * @throws Exception
	 */
	public static void loaderActivityToCache(long activityId) throws Exception {
		long s1 = System.currentTimeMillis();
		if (log.isInfoEnabled()) {
			log.info("loaderActivityToCache is start by activityId := " + activityId);
		}
		// 加载活动信息-如果没有成功就返回了
		if (!refreshActivityInfoToCache(activityId)) {
			log.warn("loaderActivityInfo is null or fail by activityId := " + activityId);
			return;
		}
		// 加载活动关联的礼品的抢兑信息
		IActivityBindRelationValue[] actBindrelas = refreshActivityBindRelationCache(activityId);
		if (actBindrelas == null || actBindrelas.length == 0) {
			log.warn("loaderIActivityBindRelationValue is null or length=0 by activityId := " + activityId);
			return;
		}
		String acWareImageKey = null;
		String acWareKey = null;
		AcWareImageCacheLoader acWareImageCacheLoader = new AcWareImageCacheLoader();
		QBOActivityWareInfoCacheLoader qboActivityWareInfoCacheLoader = new QBOActivityWareInfoCacheLoader();
		// 礼品和图片信息应该是必须有的就不进行null判断了
		for (IActivityBindRelationValue b : actBindrelas) {
			// 加载主图片
			acWareImageKey = KeyUtil.composeKey(CommnConstant.MEMCACHE_WARE_IMAGE_INFO, b.getWareId() + "");
			MemcachedClientUtil.setObject(acWareImageKey, acWareImageCacheLoader.findBeansByKey(acWareImageKey));
			// 加载礼品基本信息(礼品名称,礼品编码,礼品状态等)
			acWareKey = KeyUtil.composeKey(CommnConstant.MEMCACHE_WARE_INFO, b.getWareId() + "," + b.getActivityId());
			acWareKey = KeyUtil.composeKey(acWareKey, CommnConstant.EXGCHANNEL_WEB);
			MemcachedClientUtil.setObject(acWareKey, qboActivityWareInfoCacheLoader.findBeansByKey(acWareKey));
			acWareImageKey = null;
			acWareKey = null;
		}
		if (log.isInfoEnabled()) {
			log.info("loaderActivityToCache is end by activityId := " + activityId + " and cost := "
					+ (System.currentTimeMillis() - s1));
		}
	}

	/**
	 * 如果不是规范的key前缀返回null
	 * 
	 * @param keyPrefix
	 * @return
	 */
	public static ICacheLoader<?> getAcCacheLoader(String keyPrefix) {
		if (CommnConstant.MEMCACHE_ACTIVITY_LIMIT_INFO.equals(keyPrefix)) {
			return new ActivityCacheLoader();
		} else if (CommnConstant.MEMCACHE_ACTIVITY_LIMIT_BIND_WARE_INFO.equals(keyPrefix)) {
			return new ActivityBindRelationCacheLoader();
		} else if (CommnConstant.MEMCACHE_WARE_IMAGE_INFO.equals(keyPrefix)) {
			return new AcWareImageCacheLoader();
		} else if (CommnConstant.MEMCACHE_WARE_INFO.equals(keyPrefix)) {
			return new QBOActivityWareInfoCacheLoader();
		} else {
			return null;
		}
	}

	/**
	 * 活动ID对应活动信息<br/>
	 * {activityId:IActivityLimitValue}
	 * 
	 * @author wzg
	 */
	public static class ActivityCacheLoader implements ICacheLoader<IActivityLimitValue> {

		public IActivityLimitValue findBeansByKey(String key) throws Exception {
			String keys[] = KeyUtil.decomposeKey(key);
			if (keys != null && keys.length == 2) {
				return ((IRushBuySrv) ServiceFactory.getService(RushBuyConstant.RUSH_BUY_SERVICE))
						.getActivityInfo(Long.parseLong(keys[1]));
			}
			log.warn("ActivityCacheLoader loader IActivityLimitValue is null by key := " + key);
			return null;
		}
	}

	/**
	 * 礼品ID,活动ID为key对应礼品和活动的绑定信息 {wareId,activityId:IQBOActivityWareInfoValue}
	 * 
	 * @author wzg
	 */
	public static class QBOActivityWareInfoCacheLoader implements ICacheLoader<IQBOActivityWareInfoValue> {

	public IQBOActivityWareInfoValue findBeansByKey(String key) throws Exception {
            String keys[] = KeyUtil.decomposeKey(key);
            // 星级体系
            String starLevel = null;
            String channel = null;
            if (keys.length > 3) {
                starLevel = keys[2];
                channel = keys[3];
            } else {
                channel = keys[2];
            }
            if (keys != null) {
                IRushBuySrv service = (IRushBuySrv) ServiceFactory.getService(RushBuyConstant.RUSH_BUY_SERVICE);
                IQBOActivityWareInfoValue value;
                if(starLevel==null){
                    value = service.getAcWareInfo(keys[1], channel);
                }else{
                    value = service.getAcWareInfo(keys[1], starLevel, channel);
                }
                return value;
            }
            log.warn("QBOActivityWareInfoCacheLoader loader IQBOActivityWareInfoValue is null by key := " + key);
            return null;
        }
    }

	/**
	 * 活动ID对应活动对应的绑定礼品的信息 {activityId:IQBOActivityWareInfoValue}
	 * 
	 * @author wzg
	 */
	public static class ActivityBindRelationCacheLoader implements ICacheLoader<IActivityBindRelationValue[]> {

		public IActivityBindRelationValue[] findBeansByKey(String key) throws Exception {
			String keys[] = KeyUtil.decomposeKey(key);
			if (keys != null && keys.length == 2) {
				return ((IRushBuySrv) ServiceFactory.getService(RushBuyConstant.RUSH_BUY_SERVICE))
						.getWareIdsByActivityId(keys[1]);
			}
			log.warn("ActivityBindRelationCacheLoader loader IActivityBindRelationValue[] is null by key := " + key);
			return null;
		}
	}

	/**
	 * 礼品ID对应活动对应的主图片的地址 {wareId:String}
	 * 
	 * @author wzg
	 */
	public static class AcWareImageCacheLoader implements ICacheLoader<String> {

		public String findBeansByKey(String key) throws Exception {
			String keys[] = KeyUtil.decomposeKey(key);
			if (keys != null && keys.length == 2) {
				IQBOMainImageInfoValue wareImage = ((IRushWareDetailSrv) ServiceFactory
						.getService(RushBuyConstant.RUSH_BUY_WARE_SERVICE)).getWareMainImgById(Long.parseLong(keys[1]));
				if (wareImage != null) {
					return wareImage.getFileName();
				}
			}
			log.warn("AcWareImageCacheLoader loader mainImage is null by key := " + key);
			return null;
		}
	}
}
