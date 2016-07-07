package ngves.asiainfo.core.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.CommnException;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WareStock {
	private static Log logger = LogFactory.getLog(WareStock.class);
	/**
	 * 查询礼品的上下线状态和下线原因
	 */
	private static final String QUERY_WARE_STATE = "SELECT WARE_STATUS, STATUS_CAUSE FROM WARE_INFO WHERE WARE_ID = ?";

	/**
	 * 02正常兑换下单，更新可兑换量-n和在途量+n
	 */
	private static final String UPDATE_WARE_HOUSE_AVL_OUT = "UPDATE HOUSE_WARE_INFO "
			+ " SET CONVERTIBLE_AMOUNT=CONVERTIBLE_AMOUNT-?,WAY_AMOUNT=WAY_AMOUNT+? "
			+ " WHERE (CONVERTIBLE_AMOUNT-?)>=WARN_AMOUNT AND WAREHOUSE_ID=? AND WARE_ID=?";

	/**
	 * 06异常兑换下单，更新可兑换量-n 和 在途量+n，规则为：如果礼品为永久下线，则扣完必须大于等于0 如果不是永久下线礼品，则可以扣成负数，即随便扣减
	 */
	private static final String UPDATE_EXP_FOREVER_DOWN_WARE_HOUSE_AVL_OUT = "UPDATE HOUSE_WARE_INFO "
			+ " SET CONVERTIBLE_AMOUNT=CONVERTIBLE_AMOUNT-?,WAY_AMOUNT=WAY_AMOUNT+? "
			+ " WHERE (CONVERTIBLE_AMOUNT-?)>=0 AND WAREHOUSE_ID=? AND WARE_ID=?";
	/**
	 * 异常兑换下单，更新可兑换量-n 和 在途量+n，规则为：如果礼品为永久下线，则扣完必须大于等于0 如果不是永久下线礼品，则可以扣成负数，即随便扣减
	 */
	// 异常兑换下单不再区分是否永久下线，均不允许扣减库存成负数 liulongfei 2012-05-10 14:18
//	private static final String UPDATE_EXP_NOT_FOREVER_DOWN_WARE_HOUSE_AVL_OUT = "UPDATE HOUSE_WARE_INFO "
//			+ "SET CONVERTIBLE_AMOUNT=CONVERTIBLE_AMOUNT-?,WAY_AMOUNT=WAY_AMOUNT+? "
//			+ "WHERE WAREHOUSE_ID=? AND WARE_ID=?";

	/**
	 * 05预出库，更新可兑换量-n和在途量+n
	 */
	private static final String UPDATE_WARE_HOUSE_PRE_OUT = "UPDATE HOUSE_WARE_INFO "
			+ " SET CONVERTIBLE_AMOUNT=CONVERTIBLE_AMOUNT-?,WAY_AMOUNT=WAY_AMOUNT+? "
			+ " WHERE (CONVERTIBLE_AMOUNT-?)>=0 AND WAREHOUSE_ID=? AND WARE_ID=?";

	/**
	 * 15预出库撤销，更新可兑换量+n和在途量-n
	 */
	private static final String UPDATE_WARE_HOUSE_PRE_OUT_CANCEL = "UPDATE HOUSE_WARE_INFO "
			+ " SET CONVERTIBLE_AMOUNT=CONVERTIBLE_AMOUNT+?,WAY_AMOUNT=WAY_AMOUNT-? "
			+ " WHERE (WAY_AMOUNT-?)>=0 AND WAREHOUSE_ID=? AND WARE_ID=?";

	/**
	 * 01正常出库，在途量-n，库存量-n
	 */
	private static final String UPDATE_WARE_HOUSE_AVL_AND_STOCK_OUT = "UPDATE HOUSE_WARE_INFO "
			+ " SET WAY_AMOUNT=WAY_AMOUNT-?,"
			+ " CURRENT_AMOUNT=CURRENT_AMOUNT-? "
			+ " WHERE (WAY_AMOUNT-?)>=0 AND (CURRENT_AMOUNT-?)>=0 "
			+ " AND WAREHOUSE_ID=? AND WARE_ID=?";
	/**
	 * 03异常出库,异常出库量+n
	 */
	private static final String UPDATE_WARE_HOUSE_EXP_OUT = "UPDATE HOUSE_WARE_INFO "
			+ " SET BAD_OUT_AMOUNT=BAD_OUT_AMOUNT+? WHERE WAREHOUSE_ID=? AND WARE_ID=?";

	/**
	 * 07异常订单兑换出库，库存量-n，在途量-n 礼品为永久下线，则扣完必须大于等于0 如果不是永久下线礼品，则可以扣成负数，即随便扣减
	 */
	private static final String UPDATE_EXP_FOREVER_DOWN_WARE_HOUSE_STOCK_OUT = "UPDATE HOUSE_WARE_INFO "
			+ " SET CURRENT_AMOUNT=CURRENT_AMOUNT-?,WAY_AMOUNT=WAY_AMOUNT-? ,EXCHANGED_AMOUNT=EXCHANGED_AMOUNT+? "
			+ " WHERE (CURRENT_AMOUNT-?)>=0"
			+ " AND (WAY_AMOUNT-?)>=0 AND WAREHOUSE_ID=? AND WARE_ID=?";
	/**
	 * 07异常订单兑换出库，库存量-n，在途量-n 规则为：礼品为非永久下线，则可以扣成负数，即随便扣减
	 */
	private static final String UPDATE_EXP_NOT_FOREVER_DOWN_WARE_HOUSE_STOCK_OUT = "UPDATE HOUSE_WARE_INFO "
			+ " SET CURRENT_AMOUNT=CURRENT_AMOUNT-?,WAY_AMOUNT=WAY_AMOUNT-? ,EXCHANGED_AMOUNT=EXCHANGED_AMOUNT+? "
			+ " WHERE "
			+ " (WAY_AMOUNT-?)>=0 AND WAREHOUSE_ID=? AND WARE_ID=?";
	/**
	 * 04兑换出库，库存量-n，在途量-n
	 */
	private static final String UPDATE_WARE_HOUSE_STOCK_OUT = "UPDATE HOUSE_WARE_INFO "
			+ " SET CURRENT_AMOUNT=CURRENT_AMOUNT-?,WAY_AMOUNT=WAY_AMOUNT-? ,EXCHANGED_AMOUNT=EXCHANGED_AMOUNT+? "
			+ " WHERE (CURRENT_AMOUNT-?)>=WARN_AMOUNT "
			+ " AND (WAY_AMOUNT-?)>=0 AND WAREHOUSE_ID=? AND WARE_ID=?";

	/**
	 * 10订单撤销,可兑换量+n，在途量-n
	 */
	private static final String UPDATE_WARE_HOUSE_ORDER_CANCEL = "UPDATE HOUSE_WARE_INFO "
			+ " SET CONVERTIBLE_AMOUNT=CONVERTIBLE_AMOUNT+?,WAY_AMOUNT=WAY_AMOUNT-? "
			+ " WHERE (WAY_AMOUNT-?)>=0 AND WAREHOUSE_ID=? AND WARE_ID=?";

	/**
	 * 11正常入库/20合作类006状态订单撤销,可兑换量+n，库存量+n
	 */
	private static final String UPDATE_WARE_HOUSE_STOCK_NORMAL_IN = "UPDATE HOUSE_WARE_INFO "
			+ " SET CONVERTIBLE_AMOUNT=CONVERTIBLE_AMOUNT+?,CURRENT_AMOUNT=CURRENT_AMOUNT+? "
			+ " WHERE WAREHOUSE_ID=? AND WARE_ID=?";

	/**
	 * 12/13/14异常入库，不良品库存+n
	 */
	private static final String UPDATE_WARE_HOUSE_EXP_IN = "UPDATE HOUSE_WARE_INFO "
			+ " SET BAD_AMOUNT=BAD_AMOUNT+? "
			+ " WHERE WAREHOUSE_ID=? AND WARE_ID=?";

	private WareStock() {
		// 禁止实例
	}

	/**
	 * 根据操作类型扣库存
	 * 
	 * @param conn
	 * @param wareHouseId
	 * @param wareId
	 * @param opType
	 * @param count
	 * @throws CommnException
	 */
	public static void processWareStock(Connection conn, String wareHouseId,
			String wareHouseType, String wareId, String opType, int count,
			String sendProvince) throws CommnException {
		if (StringUtil.isBlank(wareHouseId) || StringUtil.isBlank(wareId)
				|| StringUtil.isBlank(opType) || count <= 0 && !CommnConstant.WARE_STOCK_OPER_TYPE_NORMAL_OUT.equals(opType)) {
			logger.error("Illegal house ware stock arguments! wareHouseId="
					+ wareHouseId + " wareId=" + wareId + " opType=" + opType
					+ " count=" + count);
			throw new CommnException(
					"Illegal house ware stock arguments! wareHouseId="
							+ wareHouseId + " wareId=" + wareId + " opType="
							+ opType + " count=" + count);
		}
		PreparedStatement psmt = null;
		try {
			// 根据操作类型扣减相应的总库存
			// 预出库
			if (CommnConstant.WARE_STOCK_OPER_TYPE_PRE_OUT.equals(opType)) {
				psmt = conn.prepareStatement(UPDATE_WARE_HOUSE_PRE_OUT);
				psmt.setInt(1, count);
				psmt.setInt(2, count);
				psmt.setInt(3, count);
				psmt.setString(4, wareHouseId);
				psmt.setString(5, wareId);
			}
			// 预出库撤销
			if (CommnConstant.WARE_STOCK_OPER_TYPE_PRE_OUT_BACK.equals(opType)) {
				psmt = conn.prepareStatement(UPDATE_WARE_HOUSE_PRE_OUT_CANCEL);
				psmt.setInt(1, count);
				psmt.setInt(2, count);
				psmt.setInt(3, count);
				psmt.setString(4, wareHouseId);
				psmt.setString(5, wareId);
			}
			// 正常出库,也不应该
			if (CommnConstant.WARE_STOCK_OPER_TYPE_NORMAL_OUT.equals(opType)) {
				psmt = conn
						.prepareStatement(UPDATE_WARE_HOUSE_AVL_AND_STOCK_OUT);
				psmt.setInt(1, count);
				psmt.setInt(2, count);
				psmt.setInt(3, count);
				psmt.setInt(4, count);
				psmt.setString(5, wareHouseId);
				psmt.setString(6, wareId);
			}
			// 正常兑换下单
			if (CommnConstant.WARE_STOCK_OPER_TYPE_NORMAL_ORDER.equals(opType)) {
				psmt = conn.prepareStatement(UPDATE_WARE_HOUSE_AVL_OUT);
				psmt.setInt(1, count);
				psmt.setInt(2, count);
				psmt.setInt(3, count);
				psmt.setString(4, wareHouseId);
				psmt.setString(5, wareId);
			}
			// 异常兑换下单
			if (CommnConstant.WARE_STOCK_OPER_TYPE_EXP_ORDER.equals(opType)) {
				// 先查询礼品的上下线状态，且是否为永久下线
//				boolean isForeverDown = isWareForeverDown(conn, wareId);
//				// 开始准备
//				if (isForeverDown) {
					// 永久下线
					// 异常兑换下单06状态不再判断是否为永久下线，均不在允许库存扣减成负数。liulongfei 2012-05-10 14:19
					psmt = conn
							.prepareStatement(UPDATE_EXP_FOREVER_DOWN_WARE_HOUSE_AVL_OUT);
					psmt.setInt(1, count);
					psmt.setInt(2, count);
					psmt.setInt(3, count);
					psmt.setString(4, wareHouseId);
					psmt.setString(5, wareId);
//				} else {
//					// 非永久下线
//					psmt = conn
//							.prepareStatement(UPDATE_EXP_NOT_FOREVER_DOWN_WARE_HOUSE_AVL_OUT);
//					psmt.setInt(1, count);
//					psmt.setInt(2, count);
//					psmt.setString(3, wareHouseId);
//					psmt.setString(4, wareId);
//				}
			}
			// 异常不良品出库
			if (CommnConstant.WARE_STOCK_OPER_TYPE_EXP_OUT.equals(opType)) {
				psmt = conn.prepareStatement(UPDATE_WARE_HOUSE_EXP_OUT);
				psmt.setInt(1, count);
				psmt.setString(2, wareHouseId);
				psmt.setString(3, wareId);
			}
			// 兑换出库
			if (CommnConstant.WARE_STOCK_OPER_TYPE_OUT_STORE.equals(opType)) {
				psmt = conn.prepareStatement(UPDATE_WARE_HOUSE_STOCK_OUT);
				psmt.setInt(1, count);
				psmt.setInt(2, count);
				psmt.setInt(3, count);
				psmt.setInt(4, count);
				psmt.setInt(5, count);
				psmt.setString(6, wareHouseId);
				psmt.setString(7, wareId);
			}
			// 异常兑换出库
			if (CommnConstant.WARE_STOCK_OPER_TYPE_EXP_OUT_STORE.equals(opType)) {
				boolean isForeverDown = isWareForeverDown(conn, wareId);
				if (isForeverDown) {
					 // 永久下线
					psmt = conn
							.prepareStatement(UPDATE_EXP_FOREVER_DOWN_WARE_HOUSE_STOCK_OUT);
					psmt.setInt(1, count);
					psmt.setInt(2, count);
					psmt.setInt(3, count);
					psmt.setInt(4, count);
					psmt.setInt(5, count);
					psmt.setString(6, wareHouseId);
					psmt.setString(7, wareId);
				} else {
					// 非永久下线
					psmt = conn
							.prepareStatement(UPDATE_EXP_NOT_FOREVER_DOWN_WARE_HOUSE_STOCK_OUT);
					psmt.setInt(1, count);
					psmt.setInt(2, count);
					psmt.setInt(3, count);
					psmt.setInt(4, count);
					psmt.setString(5, wareHouseId);
					psmt.setString(6, wareId);
				}
			}
			// 订单撤销
			if (CommnConstant.WARE_STOCK_OPER_TYPE_CANCEL_ORDER.equals(opType)) {
				psmt = conn.prepareStatement(UPDATE_WARE_HOUSE_ORDER_CANCEL);
				psmt.setInt(1, count);
				psmt.setInt(2, count);
				psmt.setInt(3, count);
				psmt.setString(4, wareHouseId);
				psmt.setString(5, wareId);
			}
			//下单不成功回滚
			if (CommnConstant.WARE_STOCK_OPER_TYPE_CREATE_ORDER_ROLLBACK.equals(opType)) {
				psmt = conn.prepareStatement(UPDATE_WARE_HOUSE_ORDER_CANCEL);
				psmt.setInt(1, count);
				psmt.setInt(2, count);
				psmt.setInt(3, count);
				psmt.setString(4, wareHouseId);
				psmt.setString(5, wareId);
			}			
			// 正常入库,此时并不增加省份库存，需要手工调节
			if (CommnConstant.WARE_STOCK_OPER_TYPE_NORMAL_IN.equals(opType)) {
				psmt = conn.prepareStatement(UPDATE_WARE_HOUSE_STOCK_NORMAL_IN);
				psmt.setInt(1, count);
				psmt.setInt(2, count);
				psmt.setString(3, wareHouseId);
				psmt.setString(4, wareId);
			}
			//006状态撤销订单
			if (CommnConstant.WARE_STOCK_OPER_COPER_TYPE_CANCEL_ORDER.equals(opType)) {
				psmt = conn.prepareStatement(UPDATE_WARE_HOUSE_STOCK_NORMAL_IN);
				psmt.setInt(1, count);
				psmt.setInt(2, count);
				psmt.setString(3, wareHouseId);
				psmt.setString(4, wareId);
			}
			// 异常退货入库
			if (CommnConstant.WARE_STOCK_OPER_TYPE_EXP_BACK_IN.equals(opType)) {
				psmt = conn.prepareStatement(UPDATE_WARE_HOUSE_EXP_IN);
				psmt.setInt(1, count);
				psmt.setString(2, wareHouseId);
				psmt.setString(3, wareId);
			}
			// 异常换货入库
			if (CommnConstant.WARE_STOCK_OPER_TYPE_EXP_EXCHG_IN.equals(opType)) {
				psmt = conn.prepareStatement(UPDATE_WARE_HOUSE_EXP_IN);
				psmt.setInt(1, count);
				psmt.setString(2, wareHouseId);
				psmt.setString(3, wareId);
			}
			// 无人签收入库
			if (CommnConstant.WARE_STOCK_OPER_TYPE_NO_SIGNED_IN.equals(opType)) {
				psmt = conn.prepareStatement(UPDATE_WARE_HOUSE_EXP_IN);
				psmt.setInt(1, count);
				psmt.setString(2, wareHouseId);
				psmt.setString(3, wareId);
			}
			// 开始执行数据库操作
			int rows = psmt.executeUpdate();
			psmt.close();
			if (rows == 0) {
				logger.error("update ware house count error, update zero row."
						+ " ware_id=" + wareId + " wareHouseId=" + wareHouseId
						+ " opType=" + opType + " count=" + count);
				throw new CommnException(
						"update ware house count error, update zero row."
								+ " ware_id=" + wareId + " wareHouseId="
								+ wareHouseId + " opType=" + opType + " count="
								+ count);
			}
			// 虚拟仓根据操作类型扣减省份库存,兑换下单时要扣除
			if (CommnConstant.WARE_STOCK_OPER_TYPE_NORMAL_ORDER.equals(opType)) {
				if (!StringUtil.isBlank(sendProvince)
						&& wareHouseType
								.equals(CommnConstant.WARE_HOUSE_TYPE_VIRTUAL))
					WareProvinceStock.procssWareProvinceStock(conn, wareId,
							wareHouseId, count, sendProvince, false);
			}
			// 虚拟仓订单撤销时也要回退省份库存
			if (CommnConstant.WARE_STOCK_OPER_TYPE_CANCEL_ORDER.equals(opType)) {
				if (!StringUtil.isBlank(sendProvince)
						&& wareHouseType
								.equals(CommnConstant.WARE_HOUSE_TYPE_VIRTUAL))
					WareProvinceStock.procssWareProvinceStock(conn, wareId,
							wareHouseId, count, sendProvince, true);
			}
			// 记录出入库流水,怎么记,不在这里记录,在上级那里记录
		} catch (Exception e) {
			logger.error("update ware house count error," + " ware_id="
					+ wareId + " wareHouseId=" + wareHouseId + " opType="
					+ opType + " count=" + count + "\n " + e.getMessage(), e);
			throw new CommnException("update ware house count error,"
					+ " ware_id=" + wareId + " wareHouseId=" + wareHouseId
					+ " opType=" + opType + " count=" + count + "\n "
					+ e.getMessage(), e);
		} finally {
			// 关闭数据库连接
			try {
				if (null != psmt)
					psmt.close();
			} catch (Exception e) {
				logger.error("can not close preparestatement!");
			}
		}
	}

	private static boolean isWareForeverDown(Connection conn, String wareId)
			throws CommnException {
		PreparedStatement psmt = null;
		ResultSet rs = null;
		boolean isForeverDown = true;
		try {
			psmt = conn.prepareStatement(QUERY_WARE_STATE);
			psmt.setLong(1, Long.valueOf(wareId));
			rs = psmt.executeQuery();
			if (null != rs) {
				while (rs.next()) {
					String wareState = rs.getString(1);
					String stateCause = rs.getString(2);
					if (!StringUtil.isBlank(wareState)
							&& !StringUtil.isBlank(stateCause)
							&& wareState
									.equals(CommnConstant.WARE_STATE_DOWN_MANUE)
							&& stateCause
									.equals(CommnConstant.WARE_STATE_CAUSE_FOEEVER)) {
						// 礼品状态为2下线，且下线原因为2永久下线
						isForeverDown = true;
					} else {
						isForeverDown = false;
					}
				}
			}
			rs.close();
			psmt.close();
		} catch (Exception e) {
			logger.error("Can not query ware info," + " ware_id=" + wareId
					+ "\n " + e.getMessage(), e);
			throw new CommnException("Can not query ware info," + " ware_id="
					+ wareId + "\n " + e.getMessage(), e);
		} finally {
			// 关闭数据库连接
			try {
				if (null != rs)
					rs.close();
				if (null != psmt)
					psmt.close();
			} catch (Exception e) {
				logger.error("can not close preparestatement!");
			}
		}
		return isForeverDown;
	}
}
