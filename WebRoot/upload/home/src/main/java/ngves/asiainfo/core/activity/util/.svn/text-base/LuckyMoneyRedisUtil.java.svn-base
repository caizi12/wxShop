package ngves.asiainfo.core.activity.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.redis.clients.RedisObjectClientUserDefined;
/**
 * 2015年红包需求 仅用于该需求
 * 
 * 2015年3月6号结束
 * 
 * @author 宋鲁振
 *
 */
@Deprecated
public class LuckyMoneyRedisUtil {
	private static transient Log log = LogFactory.getLog(LuckyMoneyRedisUtil.class); 
	private static RedisObjectClientUserDefined redisClient = null;
	private static final SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
	private static final int countLoginMoneyLimit = 500000;
	static {
		try {
			redisClient = LuckMoneyRedisClient.getClientInstance();
		} catch (Exception e) {
			log.error("Exception when init Redis Pool, Please check the configuration parameters, Lucky Money Activity, 2015.", e);
		}
	}
	
	

	/**
	 * 是否能领取登录红包 若今日红包领取数量<上限返回true, 否则返回false
	 * 
	 * @return boolean
	 * @throws Exception
	 */
	public static boolean canGetLoginMoneyToday() {
		String key = "LuckyMoneyActivity_" + df.format(new Date());
		long count;
		try {
			if(redisClient.get(key)==null){
				return true;
			}
			count = Long.parseLong(redisClient.get(key));
		} catch (Exception e) {
			log.error("Exception when read redis, Luck Money Activity 2015 Spring.",e);
			return false;
		}
		if (count < countLoginMoneyLimit) {
			return true;
		}
		return false;
	}

	/**
	 * 更新今日领取登录红包计数
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Long updateLoginMoneyCountsToRedis() {
		String key = "LuckyMoneyActivity_" + df.format(new Date());
		try {
			long count = redisClient.incr(key);
			return count;
		} catch (Exception e) {
			log.error("Exception when read redis, increase the count parameter in redis, Luck Money Activity 2015 Spring.",e);
			return 0l;
		}
	}
	
	/**
	 * 更新今日领取登录红包计数
	 * 
	 * @return
	 * @throws Exception
	 */
	public static void updateLoginMoneyCountsToRedis(int count) {
		String key = "LuckyMoneyActivity_" + df.format(new Date());
		try {
			redisClient.set(key, String.valueOf(count));
		} catch (Exception e) {
			log.error("Exception when read redis, increase the count parameter in redis, Luck Money Activity 2015 Spring.",e);
		}
	}

	/**
	 * 查看今日是否已领取登录红包
	 * 
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
	public static boolean hasGotLoginLuckyMoney(String mobile) {
		String key = mobile + "_A010";
		return hasGotLuckyMoney(key);
	}

	/**
	 * 查看今日是否已领取下单红包
	 * 
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
	public static boolean hasGotOrderLuckyMoney(String mobile) {
		String key = mobile + "_A011";
		return hasGotLuckyMoney(key);
	}

	private static boolean hasGotLuckyMoney(String key) {
		String value;
		try {
			value = (String) redisClient.get(key);
		} catch (Exception e) {
			log.error("Exception when read redis, Luck Money Activity 2015 Spring.",e);
			return true;
		}
		if (value != null) {
			return true;
		}
		return false;
	}

	/**
	 * 存储已领取登录红包信息
	 * 
	 * @param mobile
	 * @param value
	 * @throws Exception
	 */
	public static void setLoginLuckyMoneyToRedis(String mobile, String value) {
		String key = mobile + "_A010";
		try {
			redisClient.set(key, value);
		} catch (Exception e) {
			log.error("Exception when write redis, Luck Money Activity 2015 Spring.",e);
		}
	}

	/**
	 * 存储已领取下单红包信息
	 * 
	 * @param mobile
	 * @param points
	 * @throws Exception
	 */
	public static void setOrderLuckyMoneyToRedis(String mobile, String points) {
		String key = mobile + "_A011";
		try {
			redisClient.set(key, points);
		} catch (Exception e) {
			log.error("Exception when write redis, Luck Money Activity 2015 Spring.",e);
		}
	}
}
