/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.common.cache;


import com.enterprisedt.util.debug.Logger;

import ngves.asiainfo.core.common.cache.KeyLockerFactory.Locker;
import ngves.asiainfo.core.common.util.KeyUtil;
import ngves.asiainfo.util.MemcachedClientUtil;

/**
 * 缓存加载模板类
 * 
 * @author wzg
 * 
 */
public final class CacheLoaderTemplate {

	private static Logger log = Logger.getLogger(CacheLoaderTemplate.class);
	
	/**
	 * 根据key前缀和实体ID,以及回调接口获取存放在缓存的实体内容,不过期
	 * @param <V>
	 * @param keyPrefix
	 * @param entityId
	 * @param cacheLoader
	 * @return
	 * @throws Exception
	 */
	public static <V> V getEntity(String keyPrefix ,String entityId, ICacheLoader<V> cacheLoader)
			throws Exception {
		return getEntity(KeyUtil.composeKey(keyPrefix, entityId), cacheLoader);
	}
	
	/**
	 * 根据key前缀和实体ID,以及回调接口获取存放在缓存的实体内容,可以过期
	 * @param <V>
	 * @param keyPrefix
	 * @param entityId
	 * @param cacheLoader
	 * @param expireTime
	 * @return
	 * @throws Exception
	 */
	public static <V> V getEntity(String keyPrefix ,String entityId, ICacheLoader<V> cacheLoader,long expireTime)
			throws Exception {
		return getEntity(KeyUtil.composeKey(keyPrefix, entityId), cacheLoader , expireTime);
	}

	/**
	 * 根据key,以及回调接口获取存放在缓存的实体内容,不过期
	 * @param <V>
	 * @param key
	 * @param cacheLoader
	 * @return
	 * @throws Exception
	 */
	public static <V> V getEntity(String key, ICacheLoader<V> cacheLoader)
			throws Exception {
		return getEntity(key, cacheLoader, 0);
	}
	
	/**
	 * 通过传递过期时间获取缓存内容,并提供回调的加载类
	 * @param <V>
	 * @param key
	 * @param cacheLoader
	 * @param expireTime
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static <V> V getEntity(String key, ICacheLoader<V> cacheLoader,long expireTime)
			throws Exception {
		V entity = null;
		// 从缓存获取数据
		entity = (V)MemcachedClientUtil.getObject(key);
		if (entity != null) {
			return entity;
		}
		Locker locker = KeyLockerFactory.getInstance().acquire(key);
		locker.getLock().lock();
		try {
			entity = getEntityByKey(key, cacheLoader,expireTime);
		} catch (Exception e) {
			log.error("getEnttity accord lock and getValue is excep by key := " + key ,e);
		} finally {
			locker.getLock().unlock();
		}
		return entity;
	}
	
	/**
	 * 根据双重判断的结果,调用回调接口方法获取实体并写入缓存
	 * @param <V>
	 * @param key
	 * @param cacheLoader
	 * @param expireTime
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private static <V> V getEntityByKey(String key, ICacheLoader<V> cacheLoader,long expireTime)
			throws Exception {
		V entity = null;
		// 从缓存获取内容,双重判断,效果并不能保证完美
		entity = (V)MemcachedClientUtil.getObject(key);
		if (entity == null) {
			entity = cacheLoader.findBeansByKey(key);
			// 写到缓存中
			MemcachedClientUtil.setObject(key,entity,expireTime);
		}
		return entity;
	}
	
	/**
	 * 根据加载接口设置刷新缓存,如果存放的是列表模式比较适合
	 * @param <V>
	 * @param key
	 * @param cacheLoader
	 * @throws Exception
	 */
	public static <V> void refreshEntity(String key , ICacheLoader<V> cacheLoader) throws Exception {
		MemcachedClientUtil.setObject(key, cacheLoader.findBeansByKey(key));
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new Runnable() {
				public void run() {
					try {
						CacheLoaderTemplate.getEntity("ssss", null);
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			});
			t.start();
		}
	}
}
