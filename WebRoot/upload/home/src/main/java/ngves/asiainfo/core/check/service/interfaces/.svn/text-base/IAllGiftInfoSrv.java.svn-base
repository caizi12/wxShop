package ngves.asiainfo.core.check.service.interfaces;

import ngves.asiainfo.core.check.dao.interfaces.IAllGiftInfoDAO;
import ngves.asiainfo.core.check.ivalues.IAllGiftInfoValue;

/**
 * 考核礼品下线业务逻辑
 */
public interface IAllGiftInfoSrv {

    public void setAllGiftInfoDAO(IAllGiftInfoDAO allGiftInfoDAO) throws  Exception ;

    /**
     * 查询所有礼品下线数据
     * @param startTime
     * @param endTime
     * @return
     * @throws Exception
     */
    public IAllGiftInfoValue[] queryAllGiftInfo(String startTime,String endTime) throws Exception;

    /**
     * 通过大类取得对应的大类下的记录
     * @param bigKindName
     * @return
     * @throws Exception
     */
    public IAllGiftInfoValue[] queryAllGiftInfo(String bigKindName,String startTime,String endTime) throws Exception;
    
    
    /**
     * 根据礼品名称查询大类对应记录集合，并根据总的兑换金额。
     * @param bigKindName
     * @return
     * @throws Exception
     */
    public IAllGiftInfoValue[]  queryAllGiftInfoBySortAllWaFee(String bigKindName,String startTime,String endTime) throws Exception;
    
    /**
     * 通过小类取得对应的小类下的记录
     * @param bigKindName
     * @return
     * @throws Exception
     */
    public IAllGiftInfoValue[] queryAllGiftInfoBySMlKindName(String smlKindName,String startTime,String endTime) throws Exception;
    
    /**
     * 通过大类获得该大类下的所有小类
     * @param bigKindName
     * @param startTime
     * @param endTime
     * @return
     * @throws Exception
     */
    public IAllGiftInfoValue[] queryAllGiftInfoByBigKindName(String bigKindName,String startTime,String endTime) throws Exception;
    
    /**
     * 通过价格档次取得对应的档次下的记录
     * @param feeDC
     * @return
     * @throws Exception
     */
    public IAllGiftInfoValue[] queryAllGiftInfoByFeeDC(String feeDC,String startTime,String endTime) throws Exception;
    
    /**
     * 取的所有建议下线的礼品
     *      兑换量过低
     * @param feeDC
     * @return
     * @throws Exception
     */
    public IAllGiftInfoValue[] queryAllProposalOfflineGift(String startTime,String endTime) throws Exception;
    
    
    /**
     * 投诉率过高
     * @return
     * @throws Exception
     *   shenfl
     */
    public IAllGiftInfoValue[] queryAllProposalOfflineGiftByAllegeRate(String startTime,String endTime) throws Exception;


    /**
     * 投诉率过高-sheet0
     * @param feeDC
     * @return
     * @throws Exception
     */
    public IAllGiftInfoValue[]  queryAllGiftInfoByFeeDCWAMount(String feeDC,String startTime,String endTime) throws Exception;

    public IAllGiftInfoValue[]  queryAllGiftInfoRsRate(String bigKindName,String startTime,String endTime) throws Exception;



}
