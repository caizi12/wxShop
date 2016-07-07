package ngves.asiainfo.core.order;

import java.sql.Connection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.CommnException;
import ngves.asiainfo.util.StringUtil;

public class ExpOrderStock {
	private static Log logger = LogFactory.getLog(ExpOrderStock.class);

	/**
	 * 处理异常订单状态变化的库存变化
	 * 
	 * @param conn
	 *            数据库连接
	 * @param expOrderId
	 *            异常订单标识
	 * @param oldOrderState
	 *            异常订单前一状态
	 * @param newOrderState
	 *            异常订单当前状态
	 * @param wareId
	 *            礼品标识
	 * @param count
	 *            数量
	 * @param wareHouseId
	 *            仓库标识
	 * @param wareHouseType
	 *            仓库类型
	 * @param sendProvince
	 *            配送省
	 * @param channelType
	 *            渠道类型
	 * @throws CommnException
	 */
	public static void processExpOrderStock(Connection conn, String expOrderId,
			String oldOrderState, String newOrderState, long wareId, int count,
			String wareHouseId, String wareHouseType, String sendProvince,
			String channelType) throws CommnException {
		// 处理异常订单的库存变化,不负责数据库连接的关闭
		if (null == conn
				|| StringUtil.isBlank(newOrderState)
				|| wareId <= 0
				|| count <= 0
				|| (StringUtil.isBlank(wareHouseId) && StringUtil
						.isBlank(sendProvince))) {
			logger.error("Illegal exp order stcok argument! Connection=" + conn
					+ " oldOrderState=" + oldOrderState + " newOrderState="
					+ newOrderState + " wareId=" + wareId + " count=" + count
					+ " wareHouseId=" + wareHouseId + " sendProvince="
					+ sendProvince);
			throw new CommnException(
					"Illegal exp order stcok argument! Connection=" + conn
							+ " oldOrderState=" + oldOrderState
							+ " newOrderState=" + newOrderState + " wareId="
							+ wareId + " count=" + count + " wareHouseId="
							+ wareHouseId + " sendProvince=" + sendProvince);
		}
		// 开始判断各种状态，以便扣库存
		boolean stockChanged = false;
		String opType = null;

		// 当场退货，货品回库
		if (newOrderState
				.equals(CommnConstant.ORDER_STATE_EXP_REJECT_BACK_TO_HOUSE)) {
			stockChanged = true;
			opType = CommnConstant.WARE_STOCK_OPER_TYPE_EXP_BACK_IN;
			WareStock.processWareStock(conn, wareHouseId, wareHouseType, wareId
					+ "", opType, count, sendProvince);
			// 更新不良品入库状态
			ExpOrderWareInOut.updateExpOrderStockFlag(conn, expOrderId);
		}
		// 当场换货撤销
		if (newOrderState
				.equals(CommnConstant.ORDER_STATE_EXP_REJECT_EXCHANGE_CANCEL)) {
			stockChanged = true;
			opType = CommnConstant.WARE_STOCK_OPER_TYPE_CANCEL_ORDER;
			WareStock.processWareStock(conn, wareHouseId, wareHouseType, wareId
					+ "", opType, count, sendProvince);
			// 不应该更新不良品入库状态
		}
		// 事后换货货品不回库撤销
		if (newOrderState
				.equals(CommnConstant.ORDER_STATE_EXP_LATER_EXCHANGE_CANCEL)) {
			stockChanged = true;
			opType = CommnConstant.WARE_STOCK_OPER_TYPE_CANCEL_ORDER;
			WareStock.processWareStock(conn, wareHouseId, wareHouseType, wareId
					+ "", opType, count, sendProvince);
		}
		// 当场换货撤销货品回库214
		if (newOrderState
				.equals(CommnConstant.ORDER_STATE_EXP_REJECT_EXCHANGE_CANCEL_BACK_TO_HOUSE)) {
			stockChanged = true;
			opType = CommnConstant.WARE_STOCK_OPER_TYPE_EXP_BACK_IN;
			WareStock.processWareStock(conn, wareHouseId, wareHouseType, wareId
					+ "", opType, count, sendProvince);
			ExpOrderWareInOut.updateExpOrderStockFlag(conn, expOrderId);
		}
		// 205—当场换货出库完成,405 事后换货出库完成
		if (newOrderState
				.equals(CommnConstant.ORDER_STATE_EXP_REJECT_EXCHANGE_OUT)
				|| newOrderState
						.equals(CommnConstant.ORDER_STATE_EXP_LATER_EXCHANGE_OUT)) {
			stockChanged = true;
			opType = CommnConstant.WARE_STOCK_OPER_TYPE_EXP_OUT_STORE;
			WareStock.processWareStock(conn, wareHouseId, wareHouseType, wareId
					+ "", opType, count, sendProvince);
		}
		// 215—当场退货旧货品回库、304—事后退货货品回库、416—当场退货旧货品回库
		if (newOrderState
				.equals(CommnConstant.ORDER_STATE_EXP_REJECT_BACK_WARE_TO_HOUSE)
				|| newOrderState
						.equals(CommnConstant.ORDER_STATE_EXP_LATER_BACK_TO_HOUSE)
				|| newOrderState
						.equals(CommnConstant.ORDER_STATE_EXP_IMM_BACK_WARE_TO_HOUSE)) {
			stockChanged = true;
			opType = CommnConstant.WARE_STOCK_OPER_TYPE_EXP_BACK_IN;
			WareStock.processWareStock(conn, wareHouseId, wareHouseType, wareId
					+ "", opType, count, sendProvince);
			ExpOrderWareInOut.updateExpOrderStockFlag(conn, expOrderId);
		}
		// 216—当场换货旧货品回库、
		// 417—当场换货旧货品回库、208—当场换货货品回库、415—事后换货撤销货品回库、408—事后换货货品回库
		if (newOrderState
				.equals(CommnConstant.ORDER_STATE_EXP_REJECT_EXCHANGE_WARE_TO_HOUSE)
				|| newOrderState
						.equals(CommnConstant.ORDER_STATE_EXP_IMM_EXCHANGE_WARE_TO_HOUSE)
				|| newOrderState
						.equals(CommnConstant.ORDER_STATE_EXP_REJECT_EXCHANGE_BACK)
				|| newOrderState
						.equals(CommnConstant.ORDER_STATE_EXP_LATER_EXCHANGE_CANCEL_BACK)
				|| newOrderState
						.equals(CommnConstant.ORDER_STATE_EXP_LATER_EXCHANGE_BACK)) {
			stockChanged = true;
			opType = CommnConstant.WARE_STOCK_OPER_TYPE_EXP_EXCHG_IN;
			WareStock.processWareStock(conn, wareHouseId, wareHouseType, wareId
					+ "", opType, count, sendProvince);
			ExpOrderWareInOut.updateExpOrderStockFlag(conn, expOrderId);
		}
		// 更新投诉单，对于撤销的异常单，此时视为已撤单完毕，可以关闭投诉单了
		// 异常订单当场换货撤销
		if (newOrderState
				.equals(CommnConstant.ORDER_STATE_EXP_REJECT_EXCHANGE_CANCEL)
				|| newOrderState
						.equals(CommnConstant.ORDER_STATE_EXP_REJECT_EXCHANGE_CANCEL_BACK)
				||

				newOrderState
						.equals(CommnConstant.ORDER_STATE_EXP_LATER_BACK_CANCEL)
				|| newOrderState
						.equals(CommnConstant.ORDER_STATE_EXP_LATER_EXCHANGE_CANCEL)
				|| newOrderState
						.equals(CommnConstant.ORDER_STATE_EXP_LATER_EXCHANGE_BACK_CANCEL)) {
			AllegeInfo.updateAllegeInfoExpCancel(conn, expOrderId);
		}
		// 更新投诉单，对于已经回库的状态，认为异常订单已经完成
		if (newOrderState
				.equals(CommnConstant.ORDER_STATE_EXP_LATER_BACK_TO_HOUSE)

				|| newOrderState
						.equals(CommnConstant.ORDER_STATE_EXP_LATER_EXCHANGE_BACK)
				|| newOrderState
						.equals(CommnConstant.ORDER_STATE_EXP_IMM_BACK_WARE_TO_HOUSE)
				|| newOrderState
						.equals(CommnConstant.ORDER_STATE_EXP_IMM_EXCHANGE_WARE_TO_HOUSE)) {
			AllegeInfo.updateAllegeInfoExpOver(conn, expOrderId);
		}
		// 计流水
		if (stockChanged) {
			WareInOutInfo.addWareInOutInfo(conn, wareHouseId, wareId + "",
					count, null, opType, channelType, expOrderId);
		}
	}
}
