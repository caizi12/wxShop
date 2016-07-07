package ngves.asiainfo.core.tuan.dao.impl;

import ngves.asiainfo.core.tuan.bo.TuanUserLogEngine;
import ngves.asiainfo.core.tuan.dao.interfaces.ITuanUserLogDAO;
import ngves.asiainfo.core.tuan.ivalues.ITuanUserLogValue;
import ngves.asiainfo.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class TuanUserLogDAOImpl implements ITuanUserLogDAO {

	// 单个用户已经兑换成功的数量
	// select max(count(*)) from tuan_user_log where tuan_id='100102' group by
	// mobile_number
	private static final String TUAN_USER_Log_SQL = "  SELECT MAX(sum(order_num)) FROM TUAN_USER_LOG WHERE  "
			+ ITuanUserLogValue.S_TuanId + " =:" + ITuanUserLogValue.S_TuanId + " GROUP BY MOBILE_NUMBER ";

	// 最大数值
	public int getMaxPerCount(String tuanId) throws Exception {
		Map<String, String> parameter = new HashMap<String, String>();
		parameter.put(ITuanUserLogValue.S_TuanId, tuanId);
		return TuanUserLogEngine.getBeansCount(TUAN_USER_Log_SQL, parameter);
	}

	public ITuanUserLogValue[] getTuanUserLogList(String tuanId) throws Exception {
		StringBuffer condition = new StringBuffer("1=1");
		Map<String, String> parameter = new HashMap<String, String>();
		if (!StringUtil.isBlank(tuanId)) {
			condition.append(" and ").append(ITuanUserLogValue.S_TuanId).append(" = :").append(
					ITuanUserLogValue.S_TuanId);
			parameter.put(ITuanUserLogValue.S_TuanId, tuanId);
		}
		return TuanUserLogEngine.getBeans(condition.toString(), parameter);
	}

	public int getTuanSuccessCountByTuanId(String tuanId) throws Exception {

		StringBuffer condition = new StringBuffer("1=1");
		Map<String, String> parameter = new HashMap<String, String>();
		if (!StringUtil.isBlank(tuanId)) {
			condition.append(" and ").append(ITuanUserLogValue.S_TuanId).append(" = :").append(
					ITuanUserLogValue.S_TuanId);
			parameter.put(ITuanUserLogValue.S_TuanId, tuanId);
		}
		// 每天记录中对应order_num之和
		ITuanUserLogValue[] tuanUserlogValues = TuanUserLogEngine.getBeans(condition.toString(), parameter);
		long sumOrderNum = 0;
		if (tuanUserlogValues != null) {

			for (ITuanUserLogValue value : tuanUserlogValues) {
				sumOrderNum += value.getOrderNum();
			}
		}
		return new Long(sumOrderNum).intValue();
	}

	/**
	 * <p>
	 * 根据团购活动ID得到团购兑换成功的记录人数,用于加载到缓存 订单下达成功后：成功后
	 * key[tuan_success_count:tuanId]：value[兑换成功人数] 从缓存中获取数据
	 * </p>
	 * 
	 * @param tuanId
	 * @return
	 * @throws Exception
	 */
	public String getSuccessCount(String tuanId) throws Exception {
		StringBuffer condition = new StringBuffer("1=1");
		Map<String, String> parameter = new HashMap<String, String>();

		if (!StringUtil.isBlank(tuanId)) {
			condition.append(" and ").append(ITuanUserLogValue.S_TuanId).append(" = :").append(
					ITuanUserLogValue.S_TuanId);
			parameter.put(ITuanUserLogValue.S_TuanId, tuanId);
		}
		int count = TuanUserLogEngine.getBeansCount(condition.toString(), parameter);
		return count + "";
	}

    /**
     * <p>
     *     订单下达成功后，保存数据到记录中
     * </p>
     * @param tuanUserLogValue
     * @throws Exception
     * @date: at 2011-07-28
     * @author:shenfl@asiainfo-linkage.com
     */
    public void saveTuanUserLog(ITuanUserLogValue tuanUserLogValue) throws Exception {

        tuanUserLogValue.setTuanUserLogId(TuanUserLogEngine.getNewId().longValue());
        TuanUserLogEngine.save(tuanUserLogValue);
    }
}
