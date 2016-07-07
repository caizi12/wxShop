package cn.frame.platform.sys.member.service;

import java.util.List;
import java.util.Map;

import cn.frame.platform.common.base.DataGridModel;
import cn.frame.platform.entitys.OrderInfo;
import cn.frame.platform.entitys.OrderInfoList;

public interface OrderInfoSrv {
	public OrderInfo getOrderInfo(Map<String, Object> paraMap);
	public int queryCountOrderInfo(Map<String, Object> paraMap);
	public DataGridModel queryOrderInfoData(DataGridModel dataGrid);
	public List<OrderInfo> queryOrderInfo(Map<String, Object> paraMap);
	public boolean createOrderInfo(OrderInfo orderInfo,List<OrderInfoList> orderInfoList);
	public int updateOrderInfo(OrderInfo orderInfo);
	public int batchDelOrderInfo(List<String> userId)  throws Exception;
	public int updateShopToDelStatus(final List<String> list);
	public String getNewOrderId();
	
	public List<OrderInfoList> queryOrderInfoList(Map<String, Object> paraMap);
	public OrderInfoList getOrderInfoList(OrderInfoList orderInfoList);
	public boolean createOrderInfoList(OrderInfoList orderInfoList);
	public int updateOrderInfoList(OrderInfoList orderInfoList);
	public String getNewOrderListId(String orderNo);
	public List<OrderInfoList> queryMemberOrderInfoList(Map<String, Object> paraMap);
	 
	public int updateOrderInfoStatus(OrderInfo orderInfo);
}
