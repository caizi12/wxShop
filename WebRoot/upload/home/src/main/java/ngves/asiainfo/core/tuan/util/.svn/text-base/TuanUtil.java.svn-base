package ngves.asiainfo.core.tuan.util;


import com.ai.appframe2.service.ServiceFactory;
import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.util.MemcachedClientUtil;
import ngves.asiainfo.core.tuan.ivalues.ITuanInfoValue;
import ngves.asiainfo.core.tuan.service.interfaces.ITuanInfoSrv;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 *
 *<p>在定时程序中每隔1分钟执行任务，首先查询出正在进行的团购活动列表，对每一个团购活动查询出其团购成功兑换数量，然后更新到缓存(memcached)中</p>
 *<p>页面显示已有多少人兑换成功，每0.5分钟通过ajax刷新一次,每一分钟通过定时来处理,页面兑换成功人数从对应memcache中获取</p>
 *@data: at 2011-07-26
 *@author :shenfl@asiainfo-linkage.com
 */
public class TuanUtil {

	private static Log logger = LogFactory.getLog(TuanUtil.class);
	/**
	 * <p>活动开始后,每隔60*2秒进行团购成功数量加载</p>
	 */
	public static void updateTuanInfoToMemcache() {
		try {
             // 1. 取得正在进行的团购活动列表
            ITuanInfoSrv tuanInfoSrv = (ITuanInfoSrv) ServiceFactory
                .getService(CoreSrvContstant.SERVICE_CORE_TUAN_INFO);
            // 取得所有的团购活动，对所有的团购活动进行定时扫描处理
            ITuanInfoValue[] tuanInfos = tuanInfoSrv.getStartTuanIds();
            logger.info("starting tuanList of tuanInfos.length=" + tuanInfos.length);
            // 2. 从活动列表中取得当前团购成功兑换数量
            for(ITuanInfoValue value:tuanInfos){
                //每分钟定时扫描处理当前团购活动对应的团购成功的数量
                //tuan_success_count:tuanId=团购成功数量
                //TuanCacheUtil.refreshTuanUserLogInfoToCache(value.getTuanId());
                TuanCacheUtil.updatePreOrderInfo(value.getTuanId()+"");
                logger.info(CommnConstant.MEMCACHE_TUAN_SUCCESS_COUNT + ":"+value.getTuanId() + "=" +(Long) MemcachedClientUtil.getObject(CommnConstant.MEMCACHE_TUAN_SUCCESS_COUNT + ":" + value.getTuanId()));
                //每分钟定时扫描处理当前团购活动对应的团购人数，活动页面需要30s获取当前团购成功兑换人数
                //tuan_success_record:tuanId=兑换成功人数
                //TuanCacheUtil.refreshTuanUserLogInfoRecords(value.getTuanId());
                TuanCacheUtil.updatePreoOrderInfoToCache(value.getTuanId()+"");
                logger.info(CommnConstant.MEMCACHE_TUAN_SUCCESS_RECORD + ":"+value.getTuanId() + "=" +(String) MemcachedClientUtil.getObject(CommnConstant.MEMCACHE_TUAN_SUCCESS_RECORD + ":" + value.getTuanId()));
            }


		} catch (Exception e) {
			logger.error("refresh tuan-updateTuanInfoToMemcache is excep ...", e);
		}
	}
}