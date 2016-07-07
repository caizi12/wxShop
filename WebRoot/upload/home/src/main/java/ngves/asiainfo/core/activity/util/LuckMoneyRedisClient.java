package ngves.asiainfo.core.activity.util;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import ngves.asiainfo.util.CommonParaUtil;

import com.asiainfo.redis.clients.RedisObjectClientUserDefined;

/**
 * 
 * 红包专用
 * 
 * Redis客户端 读取memached参数 参数用完后删除
 * 
 * 2015年3月6号结束
 * 
 * @author 宋鲁振
 *
 */
@Deprecated
public class LuckMoneyRedisClient {
	private static RedisObjectClientUserDefined client = null;
	private static Boolean isInit = Boolean.FALSE;
	private static final String LUCKY_MONEY_ACTIVITY_REDIS_MAX_ACTIVE = "LUCKY_MONEY_ACTIVITY_REDIS_MAX_ACTIVE";
	private static final String LUCKY_MONEY_ACTIVITY_REDIS_MAX_IDLE = "LUCKY_MONEY_ACTIVITY_REDIS_MAX_IDLE";
	private static final String LUCKY_MONEY_ACTIVITY_REDIS_MAX_WAIT = "LUCKY_MONEY_ACTIVITY_REDIS_MAX_WAIT";
	private static final String LUCKY_MONEY_ACTIVITY_REDIS_HOST = "LUCKY_MONEY_ACTIVITY_REDIS_HOST";
	private static final String LUCKY_MONEY_ACTIVITY_REDIS_PORT = "LUCKY_MONEY_ACTIVITY_REDIS_PORT";
	private static final String LUCKY_MONEY_ACTIVITY_REDIS_TIMEOUT = "LUCKY_MONEY_ACTIVITY_REDIS_TIMEOUT";
	
	public static RedisObjectClientUserDefined getClientInstance() throws NumberFormatException, Exception {
		if (client == null) {
			synchronized (isInit) {
				if (isInit.equals(Boolean.FALSE)) {
					JedisPoolConfig config = new JedisPoolConfig();
					config.setMaxActive(Integer.parseInt(CommonParaUtil.getPara(LUCKY_MONEY_ACTIVITY_REDIS_MAX_ACTIVE)));
					config.setMaxIdle(Integer.parseInt(CommonParaUtil.getPara(LUCKY_MONEY_ACTIVITY_REDIS_MAX_IDLE)));
					config.setMaxWait(Integer.parseInt(CommonParaUtil.getPara(LUCKY_MONEY_ACTIVITY_REDIS_MAX_WAIT)));
					config.setTestOnBorrow(false);
					int timeout = Integer.parseInt(CommonParaUtil.getPara(LUCKY_MONEY_ACTIVITY_REDIS_TIMEOUT));
					String host = CommonParaUtil.getPara(LUCKY_MONEY_ACTIVITY_REDIS_HOST);
					int port = Integer.parseInt(CommonParaUtil.getPara(LUCKY_MONEY_ACTIVITY_REDIS_PORT));
					JedisPool pool = new JedisPool(config, host, port, timeout);
					client = new RedisObjectClientUserDefined(pool);
					isInit = Boolean.TRUE;
				}
			}
		}
		return client;
	}
	
}
