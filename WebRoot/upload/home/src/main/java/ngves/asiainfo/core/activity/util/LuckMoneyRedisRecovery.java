package ngves.asiainfo.core.activity.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.activity.ivalues.ILuckyMoneyActivityInfoValue;
import ngves.asiainfo.core.activity.service.interfaces.ILuckyMoneyActivitySrv;

import com.ai.appframe2.service.ServiceFactory;

/**
 * 2015年红包需求
 * 
 * Redis容灾 数据恢复类
 * 
 * 2015年3月6号结束
 * 
 * @author 宋鲁振
 *
 */
@Deprecated
public class LuckMoneyRedisRecovery {
	private static final ILuckyMoneyActivitySrv luckyMoneyActivityService = (ILuckyMoneyActivitySrv) ServiceFactory
			.getService("ngves.asiainfo.service.luckyMoneyActivitySrv");
	private static final SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
	private static final int QUERY_NUM = 1000;
	private static final String LOGIN_CODE = "A010";
	private static final String ORDER_CODE = "A011";

	/**
	 * 加载数据到redis
	 * @throws Exception 
	 */
	public static void recovery() throws Exception {
		//加载登录红包
		recoverLoginMoney(LOGIN_CODE);
		//加载下单红包
		recoverLoginMoney(ORDER_CODE);
		//加载今日登录红包领取数
		recoverLoginCount();
	}

	/**
	 * 加载已领取记录到redis
	 * @param codeType
	 * @throws Exception 
	 */
	private static void recoverLoginMoney(String codeType) throws Exception {
		Map<String, Object> parameter = new HashMap<String, Object>();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		condition.append(" AND ").append(ILuckyMoneyActivityInfoValue.S_LuckyType).append(" = :").append(
				ILuckyMoneyActivityInfoValue.S_LuckyType);
		parameter.put(ILuckyMoneyActivityInfoValue.S_LuckyType, codeType);
		int countLoginMoneyRecord = luckyMoneyActivityService.queryLuckyMoneyInfoCount(condition.toString(), parameter);
		if (LOGIN_CODE.equals(codeType)) {
			// 登录红包
			for (int i = 0; i < countLoginMoneyRecord;) {
				int startIndex = i;
				int endIndex = (i + QUERY_NUM > countLoginMoneyRecord) ? countLoginMoneyRecord : i + QUERY_NUM;
				ILuckyMoneyActivityInfoValue[] values = null;
				try {
					values = luckyMoneyActivityService.queryLuckyMoneyInfo(condition.toString(), parameter, startIndex, endIndex);
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (values != null && values.length > 0) {
					for (int j = 0; j < values.length; j++) {
						LuckyMoneyRedisUtil.setLoginLuckyMoneyToRedis(values[j].getMobile(), String.valueOf(values[j].getLuckyScore()));
					}
				}
				i = endIndex;
			}
		} else {
			// 下单红包
			for (int i = 0; i < countLoginMoneyRecord;) {
				int startIndex = i;
				int endIndex = (i + QUERY_NUM > countLoginMoneyRecord) ? countLoginMoneyRecord : i + QUERY_NUM;
				ILuckyMoneyActivityInfoValue[] values = luckyMoneyActivityService.queryLuckyMoneyInfo(condition.toString(), parameter, startIndex, endIndex);

				if (values != null && values.length > 0) {
					for (int j = 0; j < values.length; j++) {
						LuckyMoneyRedisUtil.setOrderLuckyMoneyToRedis(values[j].getMobile(), String.valueOf(values[j].getLuckyScore()));
					}
				}
				i = endIndex;
			}
		}

	}

	/**
	 * 加载今日登录红包已领取数量到redis
	 * @throws Exception 
	 */
	private static void recoverLoginCount() throws Exception {
		Map<String, Object> parameter = new HashMap<String, Object>();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		condition.append(" AND ").append(ILuckyMoneyActivityInfoValue.S_LuckyType).append(" = :").append(
				ILuckyMoneyActivityInfoValue.S_LuckyType);
		condition.append(" AND ").append(ILuckyMoneyActivityInfoValue.S_CreateTime).append(" > :").append(
				ILuckyMoneyActivityInfoValue.S_CreateTime+"_01");
		condition.append(" AND ").append(ILuckyMoneyActivityInfoValue.S_CreateTime).append(" < :").append(
				ILuckyMoneyActivityInfoValue.S_CreateTime+"_02");
		parameter.put(ILuckyMoneyActivityInfoValue.S_LuckyType, LOGIN_CODE);
		
		String date = df.format(new Date());
		long todayStart = df.parse(date).getTime();
		long todayEnd = df.parse(date).getTime()+24*60*60*1000;
		parameter.put(ILuckyMoneyActivityInfoValue.S_CreateTime+"_01", new Timestamp(todayStart));
		parameter.put(ILuckyMoneyActivityInfoValue.S_CreateTime+"_02", new Timestamp(todayEnd));
		int countLoginMoenyRecord = luckyMoneyActivityService.queryLuckyMoneyInfoCount(condition.toString(), parameter);
		LuckyMoneyRedisUtil.updateLoginMoneyCountsToRedis(countLoginMoenyRecord);	
	}

}
