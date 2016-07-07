package ngves.asiainfo.core.tuan.service.interfaces;

import ngves.asiainfo.core.tuan.dao.interfaces.ITuanUserLogDAO;
import ngves.asiainfo.core.tuan.ivalues.ITuanUserLogValue;

/**
 * 成功下达后写记录业务逻辑
 * 
 * @version v1.0
 * @date:at 2011-07-16
 * @author:shenfl@asiainfo-linkage.com
 */
public interface ITuanUserLogSrv {

	public void setTuanUserLogDAO(ITuanUserLogDAO tuanUserLogDAO) throws Exception;

	/**
	 * 单个用户已经兑换成功最大数量
	 * 
	 * @param tuanId
	 * @return
	 * @throws Exception
	 */
	public int getMaxPerCount(String tuanId) throws Exception;

	/**
	 * 团购成功的数量
	 * 
	 * @param tuanId
	 * @return
	 * @throws Exception
	 */
	public int getTuanSuccessCountByTuanId(String tuanId) throws Exception;

	/**
	 * 取得团购用户记录列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public ITuanUserLogValue[] getTuanUserLogList(String tuanId) throws Exception;

    /**
     * 根据团购活动ID得到团购兑换成功的记录人数,用于加载到缓存
     * @param tuanId
     * @return
     * @throws Exception
     * @func:  订单下达成功后：成功后 key[tuanId]：value[兑换成功人数]
     */
    public String  getSuccessCount( String tuanId ) throws Exception;

     /**
     * 成功下达后保存对应的记录
     * @param tuanUserLogValue
     * @throws Exception
     */
   public void saveTuanUserLog(ITuanUserLogValue tuanUserLogValue) throws Exception ;

}
