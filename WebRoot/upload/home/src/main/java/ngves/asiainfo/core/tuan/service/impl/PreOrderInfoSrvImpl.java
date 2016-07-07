package ngves.asiainfo.core.tuan.service.impl;

import ngves.asiainfo.core.tuan.TuanConstant;
import ngves.asiainfo.core.tuan.dao.interfaces.IPreOrderInfoDAO;
import ngves.asiainfo.core.tuan.ivalues.IJfinterOrdersInfoValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOPreOrdersInfoValue;
import ngves.asiainfo.core.tuan.service.interfaces.IPreOrderInfoSrv;


/**
 *    用于展现团兑活动订单信息和做团兑订单统计
 */
public class PreOrderInfoSrvImpl implements IPreOrderInfoSrv{


    private IPreOrderInfoDAO preOrderInfoDAO ;


    public void setPreOrderInfoDAO(IPreOrderInfoDAO preOrderInfoDAO) throws Exception{
        this.preOrderInfoDAO = preOrderInfoDAO;
    }

    public int getSumItemCounts(Long tuanId) throws Exception {

        return preOrderInfoDAO.getSumItemCounts(tuanId,TuanConstant.TUAN_ORD_TYPE_CONST);
    }

    public int getSumItemCountsByMobile(Long tuanId, String mobile) throws Exception {
        return preOrderInfoDAO.getSumItemCountsByMobile(tuanId,TuanConstant.TUAN_ORD_TYPE_CONST,mobile);
    }
    
    /**
     * 获取所有当前hp表中信息，用户同步到积分本地库jfinter_orders_info表
     * @return
     * @throws Exception
     */
    public IQBOPreOrdersInfoValue[] getPreOrdersInfos() throws Exception{
    	return preOrderInfoDAO.getPreOrdersInfos();
    }
    
    /**
	 * 把pre_order_info表中团购成功记录信息存入到jfinter_order_info表中
	 * 
	 * @throws Exception
	 */
	public void save() throws Exception {

		IQBOPreOrdersInfoValue[] preValue = getPreOrdersInfos();
		if (preValue != null && preValue.length > 0) {
			// 删除jfinter_order_info后把preValue中的数据新增
			IJfinterOrdersInfoValue[] jfValue = preOrderInfoDAO.getJfinterOrdersInfos();
			if (jfValue != null && jfValue.length > 0) {
				// 逻辑删除
				for (IJfinterOrdersInfoValue value : jfValue) {
					value.delete();
				}
				// 物理删除:批量删除，提高执行效率，减少数据库访问
				preOrderInfoDAO.saveJfinterOrdersInfo(jfValue);
			} 
			//hp表中pre_orders_info表中最新数据放入到本地jfinter_order_info表中
			preOrderInfoDAO.saveToJfinterOrdersInfo(preValue);
		}
	}
}
