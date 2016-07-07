/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.common.util;

import ngves.asiainfo.util.StringUtil;

/**
 * 合成MEMCACHE的key与分解
 * @author wzg
 *
 */
public abstract class KeyUtil {
	
	public static final String KEY_SPLIT = ":";
	
	/**
	 * 合成格式keyPrefix:entityId
	 * @param keyPrefix
	 * @param entityId
	 * @return
	 */
	public static String composeKey(String keyPrefix ,String entityId) {
		return keyPrefix + KEY_SPLIT + entityId;
	}
	
	/**
	 * 分解key为长度为2的字符串数组,[0]为key的前缀,[1]为实例ID<br/>
	 * 如果key为null/''/'  '时操作返回null,要求对返回的数组要进行空判断和长度限定.
	 * @param key
	 * @return
	 */
	public static String[] decomposeKey(String key) {
		if(StringUtil.isBlank(key)) {
			return null;
		}
		return key.split(KEY_SPLIT);
	}
}
