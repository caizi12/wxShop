package ngves.asiainfo.core.rushbuy.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import ngves.asiainfo.core.rushbuy.RushBuyConstant;
import ngves.asiainfo.core.rushbuy.ivalues.IActivityLimitValue;
import ngves.asiainfo.core.rushbuy.service.interfaces.IRushBuySrv;

/**
 * <p>加载抢兑礼品信息</p>
 * <p>重构日期：2010-07-16</p>
 * <p>重构原因：将内容存储转移至<code>Memcache</code></p>
 * <p> 删除不再使用的代码和方法,修改了刷新抢兑礼品库存方法逻辑
 * @author zhulin
 * @modify zhengxk@asiainfo.com 
 * @modify wzg  2011-02-11
 */
public class ActivityUtil {

	private static Log logger = LogFactory.getLog(ActivityUtil.class);

	/**
	 * <p>活动开始后,每隔10秒进行礼品限定数量的加载</p>
	 * <p>只更新活动礼品绑定信息表</p>
	 */
	public static void updateActivityWareInfoToMemcache() {
		try {
			for (IActivityLimitValue a : ((IRushBuySrv) ServiceFactory.getService(RushBuyConstant.RUSH_BUY_SERVICE))
					.getStartActivityIds()) {
				ActivityCacheUtil.refreshActivityBindRelationCache(a.getActivityId());
			}
		} catch (Exception e) {
			logger.error("refresh rushbuy-storeValue is excep ...", e);
		}

	}

}
