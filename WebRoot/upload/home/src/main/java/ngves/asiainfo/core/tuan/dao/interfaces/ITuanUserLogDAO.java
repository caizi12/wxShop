package ngves.asiainfo.core.tuan.dao.interfaces;


import ngves.asiainfo.core.tuan.ivalues.ITuanUserLogValue;

/**
 * 成功下达后写记录
 * @version v1.0
 * @date:at 2011-07-16
 * @author:shenfl@asiainfo-linkage.com
 */
public interface ITuanUserLogDAO {


    /**
     *  单个用户已经兑换成功最大数量
     * @param tuanId
     * @return
     * @throws Exception
     */
    public int getMaxPerCount(String tuanId) throws Exception ;
    /**
     * 团购成功的数量
     * @param tuanId
     * @return
     * @throws Exception
     */
   public int getTuanSuccessCountByTuanId(String tuanId) throws  Exception;


   /**
     * 取得团购用户记录列表
     * @return
     * @throws Exception
     */
   public ITuanUserLogValue[] getTuanUserLogList(String tuanId) throws Exception ;

   /**
    * 当前成功兑换记录
    * @param tuanId
    * @return
    * @throws Exception
    */
   public String  getSuccessCount( String tuanId ) throws Exception;


    /**
     * 成功下达后保存对应的记录
     * @param tuanUserLogValue
     * @throws Exception
     */
   public void saveTuanUserLog(ITuanUserLogValue tuanUserLogValue) throws Exception ;
}
