package cn.frame.platform.sys.member.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.stereotype.Service;

import cn.frame.platform.common.base.BaseDaoTemplate;
import cn.frame.platform.common.base.DataGridModel;
import cn.frame.platform.common.util.RandomNumUtil;
import cn.frame.platform.common.util.date.DateUtil;
import cn.frame.platform.entitys.OrderInfo;
import cn.frame.platform.entitys.OrderInfoList;
import cn.frame.platform.sys.member.service.OrderInfoSrv;

import com.ibatis.sqlmap.client.SqlMapExecutor;

@Service("orderInfoSrv")
public class OrderInfoSrvImpl implements OrderInfoSrv {
	
	@Autowired
	public BaseDaoTemplate baseDao;
	/**
	 * 获取订单信息
	 * 
	 * @param OrderInfo
	 * @return
	 */
	public OrderInfo getOrderInfo(Map<String, Object> paraMap) {
		return (OrderInfo) baseDao.getIbatisTemplate().queryForObject("getOrderInfo", paraMap);
	}

	@SuppressWarnings("unchecked")
	public List<OrderInfo> queryOrderInfo(Map<String, Object> paraMap){
		return baseDao.getIbatisTemplate().queryForList("queryOrderInfo", paraMap);
	}
	
	/**
	 * 查询系统订单总数
	 * 
	 */
	@SuppressWarnings("unchecked")
	public int queryCountOrderInfo(Map<String, Object> userMap) {
		return baseDao.getQueryCount("queryOrderInfo", userMap);
	}

	/**
	 * 查询系统订单
	 */
	public DataGridModel queryOrderInfoData(DataGridModel dataGrid) {
		return baseDao.queryForPageDataGrid("queryOrderInfo", dataGrid);
	}

	/**
	 * 生成订单
	 */
	public boolean createOrderInfo(OrderInfo orderInfo,List<OrderInfoList> orderInfoList) {
		orderInfo.setCreateTime(new Date());
		baseDao.getIbatisTemplate().insert("insertOrderInfo", orderInfo);
		
		this.batchCreateOrderInfoList(orderInfoList);
		return true;
	}

	/**
	 * 批量删除订单
	 */
	@SuppressWarnings("unchecked")
	public int batchDelOrderInfo(final List<String> list) throws Exception {
		if (list != null) {
			baseDao.getIbatisTemplate().execute(new SqlMapClientCallback() {
				public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
					executor.startBatch();
					for (int i = 0, n = list.size(); i < n; i++) {
						executor.delete("batchDelOrderInfo", list.get(i));
					}
					executor.executeBatch();
					return null;
				}
			});
		}
		int i = 0;
		return i;
	}

	/**
	 * 修改订单信息
	 */
	public int updateOrderInfo(OrderInfo OrderInfo) {
		return baseDao.getIbatisTemplate().update("updateOrderInfo", OrderInfo);
	}

 
	
	@SuppressWarnings("unchecked")
	public int updateShopToDelStatus(final List<String> list){
		if (list != null) {
			baseDao.getIbatisTemplate().execute(new SqlMapClientCallback() {
				public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
					executor.startBatch();
					for (int i = 0, n = list.size(); i < n; i++) {
						executor.update("updateShopToDelStatus", list.get(i));
					}
					executor.executeBatch();
					return null;
				}
			});
		}
		int i = 0;
		return i;
	}
	
	 /**
	  * 生成一个新的订单号
	  * 时间戳 + 三位随机码
	  * @return
	  */
	 public String getNewOrderId(){
		 return DateUtil.formatDateByFormat(DateUtil.FORMATYYYYMMDDHHMMSSMIS)+RandomNumUtil.getFourRandomCode();
	 }
	 
	 /**
	  * 批量保存子订单
	  * @param list
	  * @return
	  */
	@SuppressWarnings("unchecked")
	public int batchCreateOrderInfoList(final List<OrderInfoList> list){
		if (list != null) {
			baseDao.getIbatisTemplate().execute(new SqlMapClientCallback() {
				public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
					executor.startBatch();
					for (int i = 0, n = list.size(); i < n; i++) {
						executor.insert("insertOrderInfoList", list.get(i));
					}
					executor.executeBatch();
					return null;
				}
			});
		}
		int i = 0;
		return i;
	}

	/**
	 * 保存子订单
	 */
	public boolean createOrderInfoList(OrderInfoList orderInfoList) {
		orderInfoList.setCreateTime(new Date());
		baseDao.getIbatisTemplate().insert("insertOrderInfoList", orderInfoList);
		return true;
	}

	/**
	 * 生成子订单id
	 */
	public String getNewOrderListId(String orderNo) {
		return  DateUtil.formatDateByFormat(DateUtil.FORMATYYYYMMDDHHMMSSMIS)+orderNo;
	}

	/**
	 * 获取子订单信息
	 */
	public OrderInfoList getOrderInfoList(OrderInfoList orderInfoList) {
		 return  (OrderInfoList) baseDao.getIbatisTemplate().queryForObject("getOrderInfoList", orderInfoList);
	}
 
	/**
	 * 更新子订单信息
	 */
	public int updateOrderInfoList(OrderInfoList orderInfoList) {
		return baseDao.getIbatisTemplate().update("updateOrderInfoList", orderInfoList);
	}

	/**
	 * 查询子订单信息
	 */
	@SuppressWarnings("unchecked")
	public List<OrderInfoList> queryOrderInfoList(Map<String, Object> paraMap) {
		return  baseDao.getIbatisTemplate().queryForList("queryOrderInfoList", paraMap);
	}
 
	/**
	 * 查询会员子订单信息
	 */
	@SuppressWarnings("unchecked")
	public List<OrderInfoList> queryMemberOrderInfoList(Map<String, Object> paraMap) {
		return  baseDao.getIbatisTemplate().queryForList("queryMemberOrderInfoList", paraMap);
	} 
	
	/**
	 * 更新订单状态
	 * @param orderInfo
	 * @return
	 */
	public int updateOrderInfoStatus(OrderInfo orderInfo){
		return baseDao.getIbatisTemplate().update("updateOrderInfoStatus", orderInfo);
	}
	
	/**
	 * 更改订单金额
	 * @param orderInfo
	 * @return
	 */
	public int changeOrderPrice(OrderInfo orderInfo){
		return baseDao.getIbatisTemplate().update("updateOrderInfoStatus", orderInfo);
	}
}