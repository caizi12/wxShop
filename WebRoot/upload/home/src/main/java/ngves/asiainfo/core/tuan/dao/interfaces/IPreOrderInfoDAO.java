package ngves.asiainfo.core.tuan.dao.interfaces;

import ngves.asiainfo.core.tuan.ivalues.IJfinterOrdersInfoValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOPreOrdersInfoValue;


/**
 * 用于展现团兑活动订单信息和做团兑订单统计
 * @author :shenfl
 */
public interface IPreOrderInfoDAO {


    /**
     * 获取团购成功的数量
     * preferences: SELECT SUM(ITEMCOUNT) FROM PRE_ORDER_INFO WHERE ACTIONID='团兑ID' AND ORDTYPE = '02'
     * @param tuanId
     * @param ordType
     * @return
     * @throws Exception
     */
    public int getSumItemCounts(Long tuanId,String ordType) throws Exception;


    /**
     * 户已经兑换成功的数量
     * preferences sql:SELECT SUM(ITEMCOUNT) FROM PRE_ORDER_INFO WHERE ACTIONID=团兑ID AND ORDTYPE = '02'  AND MOBILE = ‘客户手机号’
     * @param tuanId
     * @param ordtype
     * @param mobile
     * @return
     * @throws Exception
     */
    public int getSumItemCountsByMobile(Long tuanId,String ordtype,String mobile) throws Exception;


	/**
	 * 
	 */
	public IQBOPreOrdersInfoValue[]  getPreOrdersInfos() throws Exception;


	/**
	 * 查询本地数据库中所有今日推荐团购信息
	 */
	public IJfinterOrdersInfoValue[] getJfinterOrdersInfos() throws Exception;


	/**
	 * @param jfValue
	 */
	public void saveJfinterOrdersInfo(IJfinterOrdersInfoValue[] jfValue)throws Exception;


	/**
	 * hp表Pre_orders_info插入到本地数据库jfinter_order_info
	 * @param preValue
	 */
	public void saveToJfinterOrdersInfo(IQBOPreOrdersInfoValue[] preValue)throws Exception;
}
