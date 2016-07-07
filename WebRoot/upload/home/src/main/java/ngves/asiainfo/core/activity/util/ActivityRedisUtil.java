package ngves.asiainfo.core.activity.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.redis.clients.RedisObjectClientUserDefined;

/**
 * 活动Redis公共类
 * 
 * @author 宋鲁振
 * 
 */
public class ActivityRedisUtil {
	private static transient Log log = LogFactory.getLog(ActivityRedisUtil.class); 
	private static RedisObjectClientUserDefined redisClient = null;
	static {
		try {
			redisClient = ActivityRedisClient.getClientInstance();
		} catch (Exception e) {
			log.error("Exception when init Redis Pool, Please check the configuration parameters.", e);
		}
	}
	
	/**
	 * 获取计数值
	 * @param key
	 * @return
	 */
	public static long getCount(String key){
		long count;
		try {
			if(redisClient.get(key)==null){
				return 0l;
			}
			count = Long.parseLong(redisClient.get(key));
			return count;
		} catch (Exception e) {
			log.error("Exception when read count from redis.",e);
			return 0l;
		}
	}
	
	/**
	 * 计数值+1, 返回+1后的值
	 * @param key
	 * @return
	 */
	public static long increaseCount(String key){
		try {
			long count = redisClient.incr(key);
			return count;
		} catch (Exception e) {
			log.error("Exception when increase count in redis.",e);
			return 0l;
		}
	}

	/**
	 * 设置value
	 * 
	 */
	public static void set(String key, Object value) {
		try {
			redisClient.set(key, String.valueOf(value));
		} catch (Exception e) {
			log.error("Exception when set value to redis.",e);
		}
	}

	/**
	 * 获取value值
	 * 
	 */
	public static String get(String key) {
		try {
			return redisClient.get(key);
		} catch (Exception e) {
			log.error("Exception when read redis.",e);
		}
		return null;
	}
}
