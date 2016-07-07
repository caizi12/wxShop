package ngves.asiainfo.core.tuan.service.impl;

import ngves.asiainfo.core.tuan.dao.interfaces.ITuanUserLogDAO;
import ngves.asiainfo.core.tuan.ivalues.ITuanUserLogValue;
import ngves.asiainfo.core.tuan.service.interfaces.ITuanUserLogSrv;

/**
 * User: shenfl@asiainfo-linkage.com Date: 11-7-16 Time: 下午11:28
 */
public class TuanUserLogSrvImpl implements ITuanUserLogSrv {

	private ITuanUserLogDAO tuanUserLogDAO;

	public void setTuanUserLogDAO(ITuanUserLogDAO tuanUserLogDAO) throws Exception {
		this.tuanUserLogDAO = tuanUserLogDAO;
	}

	public int getTuanSuccessCountByTuanId(String tuanId) throws Exception {

		return tuanUserLogDAO.getTuanSuccessCountByTuanId(tuanId);
	}

	public ITuanUserLogValue[] getTuanUserLogList(String tuanId) throws Exception {
		return tuanUserLogDAO.getTuanUserLogList(tuanId);
	}

	public int getMaxPerCount(String tuanId) throws Exception {
		return tuanUserLogDAO.getMaxPerCount(tuanId);
	}

	/**
	 * 根据团购活动ID得到团购兑换成功的记录人数,用于加载到缓存
	 * 
	 * @param tuanId
	 * @return
	 * @throws Exception
	 * @func: 订单下达成功后：成功后 key[tuan_success_count:tuanId]：value[兑换成功人数]
	 */
	public String getSuccessCount(String tuanId) throws Exception {

		return tuanUserLogDAO.getSuccessCount(tuanId);
	}


        /**
     * 成功下达后保存对应的记录
     * @param tuanUserLogValue
     * @throws Exception
     */
   public void saveTuanUserLog(ITuanUserLogValue tuanUserLogValue) throws Exception {
        tuanUserLogDAO.saveTuanUserLog(tuanUserLogValue);
   }
}
