package ngves.asiainfo.core.rushbuy.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ai.appframe2.service.ServiceFactory;
import ngves.asiainfo.core.rushbuy.ivalues.*;
import ngves.asiainfo.core.rushbuy.service.interfaces.IActivityLimitGroupSrv;
import ngves.asiainfo.core.rushbuy.service.interfaces.IRushBuySrv;
import ngves.asiainfo.util.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.Gson;
import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.common.cache.CacheLoaderTemplate;
import ngves.asiainfo.core.rushbuy.RushBuyConstant;
import ngves.asiainfo.core.rushbuy.ivalues.IActivityBindRelationValue;
import ngves.asiainfo.core.rushbuy.ivalues.IActivityLimitValue;
import ngves.asiainfo.core.rushbuy.ivalues.IQBOActivityWareInfoValue;
import ngves.asiainfo.core.rushbuy.model.ActivityWareInfo;

/**
 *
 * <p>
 * 抢兑活动前台展示
 * </p>
 *
 * @author zhengxk@asiainfo.com
 *
 */
public class ActivityViewUtil {

	private static transient Log log = LogFactory.getLog(ActivityViewUtil.class);
	
	/**
	 * 获取首页要展示限时抢兑活动,当天开始的且截止到当前时间还没有结束
	 * @return
	 */
	public static IActivityLimitValue[] getIndexActivitys(HashMap<String,String> paramMap) {
		try {
			return ((IRushBuySrv) ServiceFactory.getService(RushBuyConstant.RUSH_BUY_PORTAL_SERVICE))
					.getIndexActivitys(paramMap);
		} catch (Exception e) {
			log.warn(" getIndexActivitys is excep ...", e);
			return null;
		}
	}
    /**
         * 根据活动ID得到活动的问题描述,出现异常返回null
         * @param activityId
         * @return
         */
        public static String getActivityQuestion(long activityId) {
            try {
                return ((IRushBuySrv) ServiceFactory.getService(RushBuyConstant.RUSH_BUY_PORTAL_SERVICE))
                        .getActivityQuestion(activityId);
            } catch (Exception e) {
                log.warn(" getActivityQuestion is excep by aId := " + activityId, e);
                return null;
            }
        }

	/**
	 * <P>
	 * 通过活动编号查看活动信息
	 * </p>
	 *
	 * @param activityId
	 * @return
	 */
	public static IActivityLimitValue getAcLimitInfo(String activityId) {
		IActivityLimitValue value = null;
		// 从Memcache获取活动信息
		try {
			value = (IActivityLimitValue) CacheLoaderTemplate.getEntity(CommnConstant.MEMCACHE_ACTIVITY_LIMIT_INFO,
					activityId, ActivityCacheUtil.getAcCacheLoader(CommnConstant.MEMCACHE_ACTIVITY_LIMIT_INFO));
		} catch (Exception e) {
			log.error("getAcLimitInfo is excep by acId := " + activityId, e);
		}
		return value;
	}

	/**
	 * <p>
	 * 通过礼品,活动编号获取抢兑礼品信息
	 * </p>
	 * 不需要星級
	 * @param wareAndActivityId
	 * @return
	 */
	public static IQBOActivityWareInfoValue getAcWareInfo(String wareAndActivityId, String channel) {
		String key = CommnConstant.MEMCACHE_WARE_INFO;
		key = key+":"+wareAndActivityId;
		key = key + ":" + channel;
		return getAcWareInfo(key);
	}
	
	private static IQBOActivityWareInfoValue getAcWareInfo(String key){
	    IQBOActivityWareInfoValue value = null;
	    // 从Memcache获取活动关联的礼品基本信息(礼品名称,礼品编码,礼品状态等)
        try {
            CacheLoaderTemplate.refreshEntity(key, ActivityCacheUtil.getAcCacheLoader(CommnConstant.MEMCACHE_WARE_INFO));
            value = (IQBOActivityWareInfoValue) CacheLoaderTemplate.getEntity(key, ActivityCacheUtil.getAcCacheLoader(CommnConstant.MEMCACHE_WARE_INFO));
        } catch (Exception e) {
            log.error("getAcWareInfo is excep by wareAndActivityId := " + key, e);
        }
        return value;
	}
	
	/*
	 * 需要星級
	 */
	public static IQBOActivityWareInfoValue getAcWareInfo(String wareAndActivityId, String starLevel, String channel) {
        String key = CommnConstant.MEMCACHE_WARE_INFO;
        key = key+":"+wareAndActivityId;
        if(starLevel!=null){
            key = key + ":" +starLevel;
        } 
        key = key + ":" + channel;
        return getAcWareInfo(key);
    }

	/**
	 * <p>
	 * 通过活动编号获取活动礼品绑定信息
	 * </p>
	 *
	 * @param activityId
	 * @return
	 */
	public static IActivityBindRelationValue[] getWareIdsByLimitId(String activityId) {

		IActivityBindRelationValue[] values = null;

		// 从Memcache获取活动关联的礼品的抢兑信息(抢兑积分值-抢兑库存值,排序号等)
		try {
			values = (IActivityBindRelationValue[]) CacheLoaderTemplate.getEntity(
					CommnConstant.MEMCACHE_ACTIVITY_LIMIT_BIND_WARE_INFO, activityId, ActivityCacheUtil
							.getAcCacheLoader(CommnConstant.MEMCACHE_ACTIVITY_LIMIT_BIND_WARE_INFO));
		} catch (Exception e) {
			log.error("getAcWareInfo is excep by activityId := " + activityId, e);
		}
		return values; 
	}

	/**
	 * <p>
	 * 通过礼品编号获取礼品主图片信息
	 * </p>
	 *
	 * @param wareId
	 * @return
	 */
	public static String getWareMainImage(String wareId) {

		String value = null;

		// 从Memcache获取礼品对应主图片信息
		try {
			value = (String) CacheLoaderTemplate.getEntity(CommnConstant.MEMCACHE_WARE_IMAGE_INFO, wareId,
					ActivityCacheUtil.getAcCacheLoader(CommnConstant.MEMCACHE_WARE_IMAGE_INFO));
		} catch (Exception e) {
			log.error("getAcWareInfo is excep by wareId := " + wareId, e);
		}
		return value;
	}

	/**
	 * <p>
	 * 获取距离活动的开始时间,结束时间,活动剩余开始时间
	 * </p>
	 *
	 * @return
	 */
	public static Map<String, Object> getActivityLeftTime(String activityId) {

		// 活动距离当前时间(秒)
		long leftTime = 0;
		// 活动状态
		String activityViewStatus = "";
		// 活动开始时间
		String activityStartTime = "";
		// 活动结束时间
		String activityEndTime = "";

		// 获取当前时间
		long timeAsNow = (new Date().getTime());
		// log.info("==>>timeAsNow==" + timeAsNow);
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 获取活动信息
		IActivityLimitValue info = getAcLimitInfo(activityId);
		if (info != null) {
			activityStartTime = dateformat.format(info.getActivityStartTime());
			activityEndTime = dateformat.format(info.getActivityEndTime());
			leftTime = (info.getActivityStartTime().getTime() - timeAsNow) / 1000;

			// 活动尚未开始
			if (info.getActivityStartTime().getTime() > timeAsNow) {
				activityViewStatus = RushBuyConstant.ACTIVITY_LIMIT_VIEW_STATUS_WAIT;

				// 活动已经结束
			} else if (info.getActivityEndTime().getTime() < timeAsNow
					|| info.getActivityState().equals(RushBuyConstant.ACTIVITY_LIMIT_STATUS_STOP)) {

				activityViewStatus = RushBuyConstant.ACTIVITY_LIMIT_VIEW_STATUS_END;

				// 活动正在进行中
			} else {

				activityViewStatus = RushBuyConstant.ACTIVITY_LIMIT_VIEW_STATUS_START;

			}
		}
		// 提取活动信息转化为JSON格式数据
		Map<String, Object> infos = new HashMap<String, Object>();
		infos.put(RushBuyConstant.ACTIVITY_LIMIT_VIEW_START_TIME, activityStartTime);
		infos.put(RushBuyConstant.ACTIVITY_LIMIT_VIEW_END_TIME, activityEndTime);
		infos.put(RushBuyConstant.ACTIVITY_LIMIT_VIEW_STATUS, activityViewStatus);
		infos.put(RushBuyConstant.ACTIVITY_LIMIT_VIEW_LEFT_TIME, leftTime);
		IActivityLimitValue nextLimitValue = getNextLimitInfos(activityId);
		if (nextLimitValue != null) {
			infos.put(RushBuyConstant.ACTIVITY_LIMIT_VIEW_NEXT_LEFT_TIME, (nextLimitValue.getActivityStartTime()
					.getTime() - timeAsNow) / 1000);
			infos.put(RushBuyConstant.ACTIVITY_LIMIT_VIEW_NEXT_NAME, nextLimitValue.getActivityName());
			infos.put(RushBuyConstant.ACTIVITY_LIMIT_VIEW_NEXT_URL, nextLimitValue.getActivityUrl());
		} else {
			infos.put(RushBuyConstant.ACTIVITY_LIMIT_VIEW_NEXT_NAME, "");
		}

        return infos;
	}

	/**
	 * <p>
	 * 获取抢兑礼品的抢兑数量信息
	 * </p>
	 *
	 * @param activityId
     * @param mobileNumber 如果不为空，则附带查询该手机号的订单信息，用以展示“抢兑”还是“重新下单”
     * note: 放在一个ajax请求里，是为了避免多次ajax请求，以及其执行顺序的依赖。
	 */
	public static String getActivityWareInfoAsJson(String activityId, String mobileNumber)throws Exception{
        IActivityLimitValue activity = getAcLimitInfo(activityId);
        boolean isValidActivity = activity != null &&
                RushBuyConstant.ACTIVITY_LIMIT_STATUS_PUBLIC.equals(activity.getActivityState()) &&
                activity.getActivityEndTime().after(new Date());

        IActivityUserLogValue[] userLogs = null;

        if(!StringUtil.isBlank(mobileNumber)){
            IRushBuySrv rushBuySrv = (IRushBuySrv) ServiceFactory.getService(RushBuyConstant.RUSH_BUY_SERVICE);
            userLogs = rushBuySrv.getUserLogInfo(mobileNumber, activityId);
        }

		String wareJsonData = "";
		IActivityBindRelationValue[] wareInfos = getWareIdsByLimitId(activityId);
		ActivityWareInfo[] infos = null;
		if (wareInfos != null && wareInfos.length > 0) {
			infos = new ActivityWareInfo[wareInfos.length];
			for (int i = 0; i < wareInfos.length; i++) {
				infos[i] = new ActivityWareInfo();
				infos[i].setWareId(wareInfos[i].getWareId() + "");
                if(!isValidActivity){
                    infos[i].setWareNowAmount("0");
                }else{
				    infos[i].setWareNowAmount(wareInfos[i].getGrantMaxAmount() + "");   
                }
                
                if(userLogs != null && userLogs.length > 0){
                    IActivityUserLogValue theUserLog = null;
                    //用于记录某一活动中的某一礼品用户非撤销的记录条数
                    int sum = 0;
                    //扫一遍用户抢兑记录表，若存在为完成订单记录（awardState=0）返回wait, 前台显示完成订单按钮
                    for(IActivityUserLogValue userLog: userLogs){
                        if(userLog.getWareId() == wareInfos[i].getWareId() && !RushBuyConstant.AWARD_STATE_ORDER_CANCEL.equals(userLog.getAwardState())){
                            theUserLog = userLog;
                            if(theUserLog != null){
                                if(RushBuyConstant.AWARD_STATE_ORDER_WAIT.equals(theUserLog.getAwardState())){
                                    infos[i].setActivityUserLogId("wait," + theUserLog.getActivityAwardUserId());
                                    break;
                                }else{
                                    infos[i].setActivityUserLogId("complete," + theUserLog.getActivityAwardUserId());
                                }
                            }
                            ++sum;
                        }
                    }
                    //用于校验某个活动的某个礼品用户是否超过单人购买上限，超过返回false,未超返回true，前台根据这个字段判断是否将“立即抢兑”置灰
                    infos[i].setIsCanBuy("true");
                    if(sum >= wareInfos[i].getOneMaxAmount()){
                    	infos[i].setIsCanBuy("false");
                    }
                }
			}
			Gson gson = new Gson();
			wareJsonData = gson.toJson(infos);
		}
		// log.info("==>>wareJsonData" + wareJsonData);
		return wareJsonData;

	}

	/**
	 *
	 * <p>
	 * 返回按结束时间倒序排列的往期回顾列表
	 * </p>
	 *
	 * @author wzg
	 *         <p>
	 *         修改原因：统一通过memcache获取活动信息
	 *         </p>
	 * @author zhengxk@asiainfo.com
	 * @return
	 * @deprecated 以后展现往期的活动分组列表
	 */
	public static List<IActivityLimitValue> getValidAcLimitInfos() {
		// 缓存调整后,该方法以前的代码错误的,删除了
		return new ArrayList<IActivityLimitValue>();
	}

	/**
	 * 得到往期限时抢兑活动分组列表 TODO: 放到memcached中？
	 *
	 * @return
	 * @throws Exception
	 */
	public static IQBOFinishedActivityLimitGroupValue[] findAllFinishedActivityLimitGroups() throws Exception {
		IActivityLimitGroupSrv groupSrv = (IActivityLimitGroupSrv) ServiceFactory
				.getService(RushBuyConstant.ACTIVITY_LIMIT_GROUP_SERVICE);
		return groupSrv.findAllFinishedActivityLimitGroups();
	}

	/**
	 * 得到指定分组下的已结束的抢兑活动列表
	 */
	public static IActivityLimitValue[] findAllFinishedActivityInGroup(long groupId) throws Exception {
		IActivityLimitGroupSrv groupSrv = (IActivityLimitGroupSrv) ServiceFactory
				.getService(RushBuyConstant.ACTIVITY_LIMIT_GROUP_SERVICE);
		return groupSrv.findAllFinishedActivityInGroup(groupId);
	}

	/**
	 * 根据id得到相应的GroupLimitGroup
	 */
	public static IActivityLimitGroupValue getActivityLimitGroupById(long groupId) throws Exception {
		IActivityLimitGroupSrv groupSrv = (IActivityLimitGroupSrv) ServiceFactory
				.getService(RushBuyConstant.ACTIVITY_LIMIT_GROUP_SERVICE);
		return groupSrv.findById(groupId);
	}

	/**
     *
     */

	/**
	 * <p>
	 * 判断一个活动状态是否有效
	 * </p>
	 *
	 * @param activityStatus
	 * @return
	 */
	public static boolean isValidActivity(String activityStatus) {

		boolean validFlag = false;
		// 活动信息是发布或终止
		if (activityStatus.equals(RushBuyConstant.ACTIVITY_LIMIT_STATUS_PUBLIC)
				|| activityStatus.equals(RushBuyConstant.ACTIVITY_LIMIT_STATUS_STOP)) {
			validFlag = true;
		}
		return validFlag;

	}

	/**
	 * <p>
	 * 判断一个活动是否在修改的有效期内
	 * </p>
	 * <p>
	 * 用于管理平台
	 * </p>
	 *
	 * @param
	 * @return
	 */
	public static boolean isValidActivityForModify(String activityId) {
		boolean validFlag = true;
		IActivityLimitValue value = getAcLimitInfo(activityId);
		if (null != value) {
			// 如果活动已经发布，并且活动已经开始
			if (value.getActivityState().equals(RushBuyConstant.ACTIVITY_LIMIT_STATUS_PUBLIC)
					&& value.getActivityStartTime().before(new Date())) {
				validFlag = false;
			}
			// 如果活动已经终止
			if (value.getActivityState().equals(RushBuyConstant.ACTIVITY_LIMIT_STATUS_STOP)) {
				validFlag = false;
			}
		}
		return validFlag;

	}

	/**
	 * 0 不能修改,1可以全部修改,2部分修改(名称,分组,描述,结束时间,图片信息)
	 *
	 * @param activityId
	 * @return
	 */
	public static int canModifyActivityForModify(String activityId) {
		// 默认是不能修改的
		int validFlag = 0;
		IActivityLimitValue value = getAcLimitInfo(activityId);
		if (null != value) {
			// 如果活动已经终止
			if (value.getActivityState().equals(RushBuyConstant.ACTIVITY_LIMIT_STATUS_STOP)) {
				validFlag = 0;
			} else if (value.getActivityStartTime().after(new Date())) {
				// 如果活动还没有开始,都可以修改
				validFlag = 1;
			} else {
				// 如果活动已经开始，只能进行部分修改
				validFlag = 2;
			}
		}
		return validFlag;
	}

	/**
	 *
	 * <p>
	 * 返回离当前活动最近的下起预告
	 * </p>
	 *
	 * @author zhengxk@asiainfo.com
	 * @return
	 */
	public static IActivityLimitValue getNextLimitInfos(String activityId) {
		// 缓存调整后,该方法以前的代码错误的,删除了
		return null;
	}
	
	

}
