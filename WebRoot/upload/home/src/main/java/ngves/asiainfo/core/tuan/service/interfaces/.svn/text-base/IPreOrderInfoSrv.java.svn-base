package ngves.asiainfo.core.tuan.service.interfaces;

import ngves.asiainfo.core.tuan.dao.interfaces.IPreOrderInfoDAO;
import ngves.asiainfo.core.tuan.ivalues.IQBOPreOrdersInfoValue;

/**
 * 用于展现团兑活动订单信息和做团兑订单统计
 * @author :shenfl
 */
public interface IPreOrderInfoSrv {


    /**
     * 注入DAO
     * @param preOrderInfoDAO
     * @throws Exception
     */
     public void setPreOrderInfoDAO(IPreOrderInfoDAO preOrderInfoDAO) throws Exception;
    /**
     * 获取团购成功的数量
     * preferences: SELECT SUM(ITEMCOUNT) FROM PRE_ORDERS_INFO WHERE ACTIONID='团兑ID' AND ORDTYPE = '02'
     * @param tuanId
     * @return
     * @throws Exception
     */
    public int getSumItemCounts(Long tuanId) throws Exception;


    /**
     * 户已经兑换成功的数量
     * preferences sql:SELECT SUM(ITEMCOUNT) FROM PRE_ORDERS_INFO WHERE ACTIONID=团兑ID AND ORDTYPE = '02'  AND MOBILE = ‘客户手机号’
     * @param tuanId
     * @param mobile
     * @return
     * @throws Exception
     */
    public int getSumItemCountsByMobile(Long tuanId,String mobile) throws Exception;
    
    /**
		select substr(t.actionid, 3, 15) actionid, sum(itemcount) itemcount
		  from pre_orders_info t
		 where t.ORDSTATUS in ('P00', 'P01', 'P03')
		   and t.ordtype = '02'
		 group by t.actionid
     * @return
     * @throws Exception
     */
    public IQBOPreOrdersInfoValue[] getPreOrdersInfos() throws Exception;
    /**
     * 同步pre_orders_info表到jfinter_orders_info表
     * @throws Exception
     */
    public void save() throws Exception;
}
