package ngves.asiainfo.core.activity.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONObject;
import ngves.asiainfo.core.activity.bo.LuckyMoneyActivityInfoBean;
import ngves.asiainfo.core.activity.dao.interfaces.ILuckyMoneyActivityInfoDAO;
import ngves.asiainfo.core.activity.ivalues.ILuckyMoneyActivityInfoValue;
import ngves.asiainfo.core.activity.service.interfaces.ILuckyMoneyActivitySrv;
import ngves.asiainfo.core.activity.util.LuckyMoneyRedisUtil;
import ngves.asiainfo.interfaces.hp.bean.luckyMoneyActivity.in.LuckyMoneyActivityInBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.luckyMoneyActivity.out.LuckyMoneyActivityOutBizRegReq;
import ngves.asiainfo.interfaces.hp.realtime.LuckMoneyActivityInter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
* 2015年3月6号结束
* 
* @author 宋鲁振
*
*/
@Deprecated
public class LuckyMoneyActivitySrvImpl implements ILuckyMoneyActivitySrv {
	private static transient Log log = LogFactory.getLog(LuckyMoneyActivitySrvImpl.class);
	private ILuckyMoneyActivityInfoDAO luckyMoneyActivityInfoDAO;
	private static final List<String> HP_STSTUS_CODE = new ArrayList<String>();

	static {
		HP_STSTUS_CODE.add("0000");
		HP_STSTUS_CODE.add("N301");
		HP_STSTUS_CODE.add("N302");
		HP_STSTUS_CODE.add("N303");
		HP_STSTUS_CODE.add("N304");
		HP_STSTUS_CODE.add("N305");
		HP_STSTUS_CODE.add("N306");
		HP_STSTUS_CODE.add("N307");
	}

	public void setLuckyMoneyActivityDAO(ILuckyMoneyActivityInfoDAO luckyMoneyActivityInfoDAO) {
		this.luckyMoneyActivityInfoDAO = luckyMoneyActivityInfoDAO;
	}

	public ILuckyMoneyActivityInfoValue[] queryLuckyMoneyInfo(String condition, Map<String, Object> parameter)
			throws Exception {
		return this.luckyMoneyActivityInfoDAO.queryLuckyMoneyInfo(condition, parameter);
	}

	public ILuckyMoneyActivityInfoValue[] queryLuckyMoneyInfo(String condition, Map<String, Object> parameter,
			int startIndex, int endIndex) throws Exception {
		return this.luckyMoneyActivityInfoDAO.queryLuckyMoneyInfo(condition, parameter, startIndex, endIndex);
	}

	public int queryLuckyMoneyInfoCount(String condition, Map<String, Object> parameter) throws Exception {
		return this.luckyMoneyActivityInfoDAO.queryLuckyMoneyInfoCount(condition, parameter);
	}

	public void saveLuckyMoneyInfo(LuckyMoneyActivityInfoBean luckyMoneyInfo) throws Exception {
		this.luckyMoneyActivityInfoDAO.saveLuckyMoneyInfo(luckyMoneyInfo);
	}

	public JSONObject getLuckyMoney(String activityType, String orgId, String mobile, String comments) throws Exception {
		LuckyMoneyActivityInBizRegReq in = LuckMoneyActivityInter.LuckyMoneyActivityInBean();
		in.setActionType(activityType);
		in.setComments(comments);
		in.setMobile(mobile);
		in.setOrgID(orgId);
		LuckyMoneyActivityOutBizRegReq out = LuckMoneyActivityInter.doBusi(in);
		String rejectReason = out.getRejectReason();
		String errorMsg = out.getErrorMsg();
		long score = out.getPoints();

		if ("N301".equals(rejectReason)) {
			log.error("Response of Get Lucky Money Inter from HP, N301, " + rejectReason + "==" + errorMsg);
		} else if ("N302".equals(rejectReason)) {
			log.error("Response of Get Lucky Money Inter from HP, N302, " + rejectReason + "==" + errorMsg);
		} else if ("N307".equals(rejectReason)) {
			log.error("Response of Get Lucky Money Inter from HP, N306, " + rejectReason + "==" + errorMsg);
		} else if (!(HP_STSTUS_CODE.contains(rejectReason)))
			log.error("Response of Get Lucky Money Inter from HP, Unknown code, " + rejectReason + "==" + errorMsg);
		else {
			log.info("Response of Get Lucky Money Inter from HP, " + rejectReason + "==" + errorMsg);
		}

		boolean getSuccess = "0000".equals(rejectReason);
		if (getSuccess) {
			LuckyMoneyActivityInfoBean luckyMoneyInfo = new LuckyMoneyActivityInfoBean();
			luckyMoneyInfo.setLuckyId(0L);
			luckyMoneyInfo.setMobile(mobile);
			luckyMoneyInfo.setLuckyType(activityType);
			luckyMoneyInfo.setLuckyScore(score);
			luckyMoneyInfo.setOrderId(comments);
			luckyMoneyInfo.setCreateTime(new Timestamp(System.currentTimeMillis()));
			this.luckyMoneyActivityInfoDAO.saveLuckyMoneyInfo(luckyMoneyInfo);

			if ("A010".equals(activityType)) {
				LuckyMoneyRedisUtil.updateLoginMoneyCountsToRedis();
				LuckyMoneyRedisUtil.setLoginLuckyMoneyToRedis(mobile, String.valueOf(score));
			} else {
				LuckyMoneyRedisUtil.setOrderLuckyMoneyToRedis(mobile, String.valueOf(score));
			}
		} else if ("N303".equals(rejectReason)) {
			if ("A010".equals(activityType))
				LuckyMoneyRedisUtil.setLoginLuckyMoneyToRedis(mobile, String.valueOf(score));
			else {
				LuckyMoneyRedisUtil.setOrderLuckyMoneyToRedis(mobile, String.valueOf(score));
			}
		} else if("N304".equals(rejectReason)){
			//红包已领取完
			LuckyMoneyRedisUtil.updateLoginMoneyCountsToRedis(500000);
		}
		JSONObject hpResult = new JSONObject();
		hpResult.put("rejectReason", rejectReason);
		hpResult.put("score", Long.valueOf(score));
		return hpResult;
	}
}