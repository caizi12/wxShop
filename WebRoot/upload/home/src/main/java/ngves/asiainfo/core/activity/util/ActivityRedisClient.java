package ngves.asiainfo.core.activity.util;

import ngves.asiainfo.util.CommonParaUtil;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.asiainfo.redis.clients.RedisObjectClientUserDefined;

/**
 * 
 * 活动Redis客户端 活动专用 使用单独的Redis环境
 * 
 * Memcached参数列表
 * ACTIVITY_REDIS_MAX_ACTIVE
 * ACTIVITY_REDIS_MAX_IDLE
 * ACTIVITY_REDIS_MAX_WAIT
 * ACTIVITY_REDIS_HOST
 * ACTIVITY_REDIS_PORT
 * ACTIVITY_REDIS_TIMEOUT
 * 
 * @author 宋鲁振
 *
 */
public class ActivityRedisClient {
	private static RedisObjectClientUserDefined client = null;
	private static Boolean isInit = Boolean.FALSE;
	private static final String ACTIVITY_REDIS_MAX_ACTIVE = "ACTIVITY_REDIS_MAX_ACTIVE";
	private static final String ACTIVITY_REDIS_MAX_IDLE = "ACTIVITY_REDIS_MAX_IDLE";
	private static final String ACTIVITY_REDIS_MAX_WAIT = "ACTIVITY_REDIS_MAX_WAIT";
	private static final String ACTIVITY_REDIS_HOST = "ACTIVITY_REDIS_HOST";
	private static final String ACTIVITY_REDIS_PORT = "ACTIVITY_REDIS_PORT";
	private static final String ACTIVITY_REDIS_TIMEOUT = "ACTIVITY_REDIS_TIMEOUT";
	
	public static RedisObjectClientUserDefined getClientInstance() throws NumberFormatException, Exception {
		if (client == null) {
			synchronized (isInit) {
				if (isInit.equals(Boolean.FALSE)) {
					JedisPoolConfig config = new JedisPoolConfig();
					config.setMaxActive(Integer.parseInt(CommonParaUtil.getPara(ACTIVITY_REDIS_MAX_ACTIVE)));
					config.setMaxIdle(Integer.parseInt(CommonParaUtil.getPara(ACTIVITY_REDIS_MAX_IDLE)));
					config.setMaxWait(Integer.parseInt(CommonParaUtil.getPara(ACTIVITY_REDIS_MAX_WAIT)));
					config.setTestOnBorrow(false);
					int timeout = Integer.parseInt(CommonParaUtil.getPara(ACTIVITY_REDIS_TIMEOUT));
					String host = CommonParaUtil.getPara(ACTIVITY_REDIS_HOST);
					int port = Integer.parseInt(CommonParaUtil.getPara(ACTIVITY_REDIS_PORT));
					JedisPool pool = new JedisPool(config, host, port, timeout);
					client = new RedisObjectClientUserDefined(pool);
					isInit = Boolean.TRUE;
				}
			}
		}
		return client;
	}
}
