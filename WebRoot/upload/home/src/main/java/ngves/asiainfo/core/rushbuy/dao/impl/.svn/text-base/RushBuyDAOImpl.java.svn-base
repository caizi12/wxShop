package ngves.asiainfo.core.rushbuy.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.common.bo.BusiInfoEngine;
import ngves.asiainfo.core.common.util.BusiInfoUtil;
import ngves.asiainfo.core.rushbuy.RushBuyConstant;
import ngves.asiainfo.core.rushbuy.bo.ActivityBindRelationEngine;
import ngves.asiainfo.core.rushbuy.bo.ActivityLimitBean;
import ngves.asiainfo.core.rushbuy.bo.ActivityLimitEngine;
import ngves.asiainfo.core.rushbuy.bo.ActivityUserLogEngine;
import ngves.asiainfo.core.rushbuy.bo.QBOActivityWareInfoEngine;
import ngves.asiainfo.core.rushbuy.dao.interfaces.IRushBuyDAO;
import ngves.asiainfo.core.rushbuy.ivalues.IActivityBindRelationValue;
import ngves.asiainfo.core.rushbuy.ivalues.IActivityLimitValue;
import ngves.asiainfo.core.rushbuy.ivalues.IActivityUserLogValue;
import ngves.asiainfo.core.rushbuy.ivalues.IQBOActivityWareInfoValue;
import ngves.asiainfo.util.StringUtil;

public class RushBuyDAOImpl implements IRushBuyDAO {

	/**
	 * 获取处于开始抢兑的活动ID列表
	 */
	private static final String GETSTARTACTIVITYIDS_SQL = IActivityLimitValue.S_ActivityStartTime + " <= SYSDATE AND "
			+ IActivityLimitValue.S_ActivityEndTime + " >= SYSDATE AND " + IActivityLimitValue.S_ActivityState + " = :"
			+ IActivityLimitValue.S_ActivityState;

	/**
	 * 查询当天的抢兑活动sql
	 */
	private static final String	GETINDEX_ACTIVITYS_SQL="SELECT  MAX(ACTIVITY_NAME) ACTIVITY_NAME , ACTIVITY_ID, " +
		"   MAX(ACTIVITY_START_TIME) ACTIVITY_START_TIME  FROM ("+
		"	    SELECT  A.ACTIVITY_NAME,A.ACTIVITY_ID ,A.ACTIVITY_START_TIME "+
		"	    FROM   ACTIVITY_LIMIT A,ACTIVITY_BIND_RELATION AR,WARE_INFO WI"+
		"	    WHERE A.ACTIVITY_ID=AR.ACTIVITY_ID AND AR.WARE_ID=WI.WARE_ID "+
		"	    AND A.ACTIVITY_END_TIME >= SYSDATE AND WI.WARE_STATUS='"+CommnConstant.VALID_FLAG_ENBALE+"'"+
		"	    AND A.ACTIVITY_START_TIME BETWEEN TRUNC(SYSDATE) AND TRUNC(SYSDATE + 1)"+
		"	    AND A.ACTIVITY_STATE = :"+IActivityLimitValue.S_ActivityState+"  AND (:provinceCodeSql)"+
		"       AND A.IS_VIEW = '"+CommnConstant.VALID_FLAG_ENBALE+"'"+
		"	)  AL GROUP BY AL.ACTIVITY_ID "+
		"	ORDER  BY max(AL.ACTIVITY_START_TIME)";
	
	/**
	 * 获取当前用户星级当前渠道下的抢兑活动礼品 
	 */
	private static final String GET_ACTIVITY_WARE_INFO="select wi.ware_id, wi.ware_code,wi.ware_name,wi.alias,wi.ware_status,wi.ware_storage_type,wi.warehouse_id,wi.deliver_type,wi.province_code,wi.packing_list, " +
                                                        "wi.safe_guard, wi.pay_type,wdi.is_online_pay,wdi.is_offline_pay,wdi.pay_desc,al.pay_time,ai.star_level,ai.ori_integral,ai.cur_integral,ai.ori_pay_integral, " +
                                                        "ai.ori_pay_cash, ai.cur_pay_integral, ai.cur_pay_cash, abr.ware_pay_type " +
                                                        "from " +
                                                        "ware_info wi, " +
                                                        "(select d.ware_id, max(decode(d.desc_define_id,999999999999939,d.ware_desc_value)) is_online_pay, max(decode(d.desc_define_id,999999999999938,d.ware_desc_value)) is_offline_pay, max(decode(d.desc_define_id,999999999999937,d.ware_desc_value)) pay_desc " + 
                                                        " from ware_desc_info d where d.desc_define_id in (999999999999939,999999999999938,999999999999937) group by d.ware_id ) wdi, " +
                                                        "activity_bind_relation abr , activity_integral ai, ACTIVITY_LIMIT al " +
                                                        "where abr.ware_id = wi.ware_id and wi.ware_id=wdi.ware_id(+) " +
                                                        "and al.activity_id=abr.activity_id " +
                                                        "and abr.ware_id = :wareId and abr.activity_id = :activityId " +
                                                        "and abr.ware_id = ai.ware_id " +
                                                        "and ai.activity_type='01' and ai.activity_id=abr.activity_id " +
                                                        "and ai.channel = :channel "+
                                                        "and ai.star_level = :starLevel";
	
	
	

	public IActivityLimitValue[] getIndexActivitys(HashMap<String,String> paramMap) throws Exception {
		Map<String, String> param = new HashMap<String, String>();
		param.put(IActivityLimitValue.S_ActivityState, RushBuyConstant.ACTIVITY_LIMIT_STATUS_PUBLIC);
		
		//未登录时查询全网的抢兑活动 
		String provinceCodeSql="WI.PROVINCE_CODE='"+CommnConstant.WARE_TYPE_GLOBLE+"' ";
		//用户登录查询全网，省网的抢兑活动
		if(paramMap!=null&&!StringUtil.isBlank(paramMap.get("provinceCode"))){
			provinceCodeSql+=" or WI.PROVINCE_CODE='"+paramMap.get("provinceCode")+"'";
		}
 
		String querySql=GETINDEX_ACTIVITYS_SQL;
		querySql=querySql.replace(":provinceCodeSql", provinceCodeSql);
		return ActivityLimitEngine.getBeansFromSql(querySql, param);
	}

	/**
	 * 得到开始的活动,用于内存刷新
	 */
	public IActivityLimitValue[] getStartActivityIds() throws Exception {
		Map<String, String> param = new HashMap<String, String>();
		param.put(IActivityLimitValue.S_ActivityState, RushBuyConstant.ACTIVITY_LIMIT_STATUS_PUBLIC);
		return ActivityLimitEngine.getBeans(new String[] { IActivityLimitValue.S_ActivityId }, GETSTARTACTIVITYIDS_SQL,
				param, -1, -1, false);
	}

	/**
	 * 取得活动信息，用于内存加载
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 */
	public IActivityLimitValue[] getActivityLimit() throws Exception {
		return ActivityLimitEngine.getBeans(null, null);
	}

	/**
	 * 根据活动编号取得绑定礼品信息
	 * 
	 * @param activityId
	 * @return
	 * @throws Exception
	 */
	public IActivityBindRelationValue[] getAcBindReInfos(String activityId) throws Exception {
		String condition = IActivityBindRelationValue.S_ActivityId + " = :" + IActivityBindRelationValue.S_ActivityId;
		Map<String, String> param = new HashMap<String, String>();
		param.put(IActivityBindRelationValue.S_ActivityId, activityId);
		return ActivityBindRelationEngine.getBeans(condition, param);
	}

	/**
	 * 取得要显示抢兑的礼品信息 礼品基本信息从ware_info表取出 
	 * 
	 * 礼品积分信息从activity_bind_relationq取出
	 * 
	 * 不区分星级
	 * 
	 * @param wareId
	 * @return
	 * @throws Exception
	 */
	public IQBOActivityWareInfoValue getActivityWareInfo(String wareId, String activityId, String channel) throws Exception {
		Map<String, String> param = new HashMap<String, String>();
		param.put("wareId", wareId);
		param.put("activityId", activityId);
		param.put("channel", channel);
        
		IQBOActivityWareInfoValue[] acWareInfos = QBOActivityWareInfoEngine.getBeans(null, param);
		return acWareInfos.length > 0 ? acWareInfos[0] : null;
	}
	
	/**
     * 取得要显示抢兑的礼品信息 礼品基本信息从ware_info表取出 礼品积分信息从activity_bind_relationq取出
     * 
     * 取当前星级
     * 
     * @param wareId
     * @return
     * @throws Exception
     */
    public IQBOActivityWareInfoValue getActivityWareInfo(String wareId, String activityId, String starLevel, String channel) throws Exception {
        Map<String, String> param = new HashMap<String, String>();
        param.put("wareId", wareId);
        param.put("activityId", activityId);
        param.put("channel", channel);
        param.put("starLevel", starLevel);
        
        IQBOActivityWareInfoValue[] acWareInfos = QBOActivityWareInfoEngine.getBeansFromSql(GET_ACTIVITY_WARE_INFO, param);
        return acWareInfos.length > 0 ? acWareInfos[0] : null;
    }

	public IActivityLimitValue getActivityLimitById(long activityId) throws Exception {
		return ActivityLimitEngine.getBean(activityId);
	}

	public void changeIsView(long activityId, boolean isView) throws Exception {
		IActivityLimitValue activity = ActivityLimitEngine.getBean(activityId);
		activity.setStsToOld();
		String isViewDB = isView ? RushBuyConstant.ACTIVITY_LIMIT_IS_VIEW_YES
				: RushBuyConstant.ACTIVITY_LIMIT_IS_VIEW_NO;
		activity.setIsView(isViewDB);
		ActivityLimitEngine.save(activity);
	}
	//修改活动显示状态 时增加日志记录
	public void changeIsView(long activityId, boolean isView,long staffId, String comType, long orgId) throws Exception {
        IActivityLimitValue activity = ActivityLimitEngine.getBean(activityId);
        activity.setStsToOld();
        IActivityLimitValue oldBean = new ActivityLimitBean();
        oldBean.copy(activity);
        String isViewDB = isView ? RushBuyConstant.ACTIVITY_LIMIT_IS_VIEW_YES
                : RushBuyConstant.ACTIVITY_LIMIT_IS_VIEW_NO;
        activity.setIsView(isViewDB);
        ActivityLimitEngine.save(activity);
        long busiInfoId = BusiInfoEngine.getNewId().longValue();
        BusiInfoUtil.recordBusiInfo(busiInfoId + "", CoreConstant.SYS_PARA_BUSI_TYPE_ACTIVITYLIMIT_MODIFY, -1,
                "是否显示抢兑活动",CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY,"抢兑ID："+activity.getActivityId()+";抢兑名称："+oldBean.getActivityName(),staffId,comType,orgId);
        BusiInfoUtil.recordBusiDetail(busiInfoId + "", new Object[]{oldBean}, new Object[]{activity}, "ActivityId");
    }

	/**
	* 根据手机号和活动号得到用户抢中记录，用以在界面中显示”立即抢兑“还是”重新下单“。
	* @param mobileNumber
	* @param activityId
	* @return
	* @throws Exception
	*/
	public IActivityUserLogValue[] getUserLogInfo(String mobileNumber, String activityId) throws Exception {
		Map<String, String> param = new HashMap<String, String>();
		StringBuffer condition = new StringBuffer();
		condition.append(IActivityUserLogValue.S_MobileNumber).append(" = :").append(
				IActivityUserLogValue.S_MobileNumber);
		condition.append(" and ").append(IActivityUserLogValue.S_ActivityId).append(" = :").append(
				IActivityUserLogValue.S_ActivityId);
		param.put(IActivityUserLogValue.S_MobileNumber, mobileNumber);
		param.put(IActivityUserLogValue.S_ActivityId, activityId);
		return ActivityUserLogEngine.getBeans(condition.toString(), param);
	}

}
