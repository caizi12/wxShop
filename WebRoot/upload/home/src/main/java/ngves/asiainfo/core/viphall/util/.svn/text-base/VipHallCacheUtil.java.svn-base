package ngves.asiainfo.core.viphall.util;

import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.common.cache.ICacheLoader;
import ngves.asiainfo.core.viphall.ivalues.IQBOVipHallTopicInfoValue;
import ngves.asiainfo.core.viphall.service.interfaces.IVipHallTopicSrv;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;

public class VipHallCacheUtil {

	private static transient Log logger = LogFactory.getLog(VipHallCacheUtil.class);

	/**
	 * 获取专题信息
	 * 
	 */
	public static class VipHallTopicCacheLoader implements ICacheLoader<IQBOVipHallTopicInfoValue[]> {

		public IQBOVipHallTopicInfoValue[] findBeansByKey(String key) throws Exception {

			IQBOVipHallTopicInfoValue[] values = null;
			logger.info("get vipHallTopic's data from database, key=" +  key);
			IVipHallTopicSrv service = (IVipHallTopicSrv) ServiceFactory
					.getService(CoreSrvContstant.VIP_HALL_TOPIC_SERVICE);
			values = service.queryVipHallTopicInfo();
			return values;
		}
	}
}
