package ngves.asiainfo.core.check.dao.interfaces;

import ngves.asiainfo.core.check.ivalues.IAllGiftInfoValue;

import java.util.Map;

/**
 * 考核礼品下线接口
 * shenfl
 *  at 2011-06-29
 */
public interface IAllGiftInfoDAO {


    /**
     * 查询所有满足条件的记录
     * @param condition
     * @param map
     * @return
     * @throws Exception
     */
    public IAllGiftInfoValue[] queryAllGiftInfo(String condition,Map<String,String> map) throws  Exception;


    /**
     * 根据礼品名称 查询大类对应记录集合
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
     * 根据小类名称 查询小类对应记录集合
     * @param bigKindName
     * @return
     * @throws Exception
     */
    public IAllGiftInfoValue[] queryAllGiftInfoBySmlKindName(String smlKindName,String startTime,String endTime) throws Exception;
    
    
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
     * 根据礼品名称 查询大类对应记录集合
     * @param bigKindName
     * @return
     * @throws Exception
     */
    public IAllGiftInfoValue[] queryAllGiftInfoByFeeDC(String feeDC,String startTime,String endTime) throws Exception;
    
    /**
     * 罗列出所有的建议下线的礼品
     * 兑换量过低
     * @param
     * @return
     * @throws Exception
     */
    public IAllGiftInfoValue[] queryAllProposalOfflineGift(String startTime,String endTime) throws Exception;
    
    
    /**
     * 投诉率过高
     * @return
     * @throws Exception
     */
    public IAllGiftInfoValue[] queryAllProposalOfflineGiftByAllegeRate(String startTime,String endTime) throws Exception;


    /**
     *  兑换量过低-结算价格
     * @param feeDC
     * @return
     * @throws Exception
     */
    public IAllGiftInfoValue[]  queryAllGiftInfoByFeeDCWAMount(String feeDC,String startTime,String endTime) throws Exception    ;

    public IAllGiftInfoValue[]  queryAllGiftInfoRsRate(String bigKindName,String startTime,String endTime) throws Exception;

}
