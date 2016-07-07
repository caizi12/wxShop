package ngves.asiainfo.core.order;

import java.sql.Connection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.CommnException;
import ngves.asiainfo.util.StringUtil;

public class NoramlOrderStock {
	private static Log logger = LogFactory.getLog(NoramlOrderStock.class);

	private NoramlOrderStock() {
		// 禁止实例
	}

	/**
	 * 处理正常订单状态的库存变化
	 * @param conn	数据库连接
	 * @param orderId	订单标识，子订单
	 * @param oldOrderState	前一状态
	 * @param newOrderState	新状态
	 * @param wareId	礼品标识
	 * @param isGlobalSend	是否全网配送
	 * @param count	数量
	 * @param wareHouseId	仓库标识
	 * @param wareHouseType	仓库类型
	 * @param sendProvince	配送省
	 * @param channelType	渠道类型
	 * @throws CommnException	
	 */
	public static void processOrderStock(Connection conn, String orderId,
			String oldOrderState, String newOrderState, long wareId,
			boolean isGlobalSend, int count, String wareHouseId,
			String wareHouseType, String sendProvince, String channelType)
			throws CommnException {
		// 处理正常订单的库存变化,不负责数据库连接的关闭，上级负责关闭
		if (null == conn
				|| StringUtil.isBlank(newOrderState)
				|| wareId <= 0
				|| count <= 0
				|| (StringUtil.isBlank(wareHouseId) && StringUtil
						.isBlank(sendProvince))) {
			logger.error("Illegal normal order stcok argument! Connection=" + conn
					+ " oldOrderState=" + oldOrderState + " newOrderState="
					+ newOrderState + " wareId=" + wareId + " count=" + count
					+ " wareHouseId=" + wareHouseId + " sendProvince="
					+ sendProvince);
			throw new CommnException("Illegal normal order stcok argument! Connection=" + conn
					+ " oldOrderState=" + oldOrderState + " newOrderState="
					+ newOrderState + " wareId=" + wareId + " count=" + count
					+ " wareHouseId=" + wareHouseId + " sendProvince="
					+ sendProvince);
		}
		// 开始判断各种状态，以便扣库存
		// 如果新下订单，则操作类型为订单下单,000
		boolean stockChanged = false;
		String opType = null;
		// 虚拟礼品电子密码-002-》007
		if (!isGlobalSend && oldOrderState.equals(CommnConstant.ORDER_STATE_NORAML_PACKAGE)
				&& newOrderState
						.equals(CommnConstant.ORDER_STATE_NORMAL_SIGNED)) {
			stockChanged = true;
			opType = CommnConstant.WARE_STOCK_OPER_TYPE_OUT_STORE;
			WareStock.processWareStock(conn, wareHouseId, wareHouseType, wareId
					+ "", opType, count, sendProvince);

		}
		// 虚拟礼品-二维码-002->006,由于这两个状态紧挨着，因此只对无配送进行库存扣减
		if (!isGlobalSend
				&& oldOrderState
						.equals(CommnConstant.ORDER_STATE_NORAML_PACKAGE)
				&& newOrderState
						.equals(CommnConstant.ORDER_STATE_NORMAL_SENDING)) {
			stockChanged = true;
			opType = CommnConstant.WARE_STOCK_OPER_TYPE_OUT_STORE;
			WareStock.processWareStock(conn, wareHouseId, wareHouseType, wareId
					+ "", opType, count, sendProvince);

		}
		// 对于01.02的配送方式，流程暂定为001——》006——》007，因此我们要新增001——》006的判断
		if (!isGlobalSend && oldOrderState.equals(CommnConstant.ORDER_STATE_NORMAL_WAITTING)
				&& newOrderState.equals(CommnConstant.ORDER_STATE_NORMAL_SENDING)) {
			stockChanged = true;
			opType = CommnConstant.WARE_STOCK_OPER_TYPE_OUT_STORE;//兑换出库
			WareStock.processWareStock(conn, wareHouseId, wareHouseType, wareId + "", opType, count, sendProvince);

		}
		// 订单礼品出库，则操作类型为礼品出库
		if (newOrderState.equals(CommnConstant.ORDER_STATE_NORMAL_OUT_HOUSE)) {
			stockChanged = true;
			opType = CommnConstant.WARE_STOCK_OPER_TYPE_OUT_STORE;
			WareStock.processWareStock(conn, wareHouseId, wareHouseType, wareId
					+ "", opType, count, sendProvince);
		}
		
		// 订单撤销（要进行更改）
//		if (newOrderState.equals(CommnConstant.ORDER_STATE_NORMAL_CANCEL)) {
//			stockChanged = true;
//			opType = CommnConstant.WARE_STOCK_OPER_TYPE_CANCEL_ORDER;
//			WareStock.processWareStock(conn, wareHouseId, wareHouseType, wareId
//					+ "", opType, count, sendProvince);
//		}
		//订单撤销的时候要进行的更改，要判断订单的前置状态，
		//1.当订单的变化是由000——》013,001——》013,002——》013时，可兑换量+n,在途量-n
		if (( oldOrderState.equals(CommnConstant.ORDER_STATE_NORMAL_PRE_CREATE)
				||oldOrderState.equals(CommnConstant.ORDER_STATE_NORMAL_WAITTING)
				||oldOrderState.equals(CommnConstant.ORDER_STATE_NORAML_PACKAGE))
				&&newOrderState.equals(CommnConstant.ORDER_STATE_NORMAL_CANCEL)){
			stockChanged = true;
			opType = CommnConstant.WARE_STOCK_OPER_TYPE_CANCEL_ORDER;
			WareStock.processWareStock(conn, wareHouseId, wareHouseType, wareId
					+ "", opType, count, sendProvince);
		}
		//2.当是006——》013时，是可兑换量+n,总兑换量+n,新增一种库存操作类型，名称为"合作类006状态订单撤销"
		if (oldOrderState.equals(CommnConstant.ORDER_STATE_NORMAL_SENDING)
				&&newOrderState.equals(CommnConstant.ORDER_STATE_NORMAL_CANCEL)){
			stockChanged = true;
			opType = CommnConstant.WARE_STOCK_OPER_COPER_TYPE_CANCEL_ORDER;
			WareStock.processWareStock(conn, wareHouseId, wareHouseType, wareId
					+ "", opType, count, sendProvince);
		}
		// 无人签收货品回库，也按异常品回库处理
		if (newOrderState
				.equals(CommnConstant.ORDER_STATE_NORMAL_NOSIGNED_BACK)) {
			// 异常退货入库
			stockChanged = true;
			opType = CommnConstant.WARE_STOCK_OPER_TYPE_NO_SIGNED_IN;
			WareStock.processWareStock(conn, wareHouseId, wareHouseType, wareId
					+ "", opType, count, sendProvince);
			// 此处为不良品出库还需要设置一下正常订单的责任方为礼品商
			// 由于没有大订单号，如果该子订单没有，只能记录子订单号，还得插入，插入时还得插入USER_EXCHANGE_LIST,
			// 还需要更新合作商，只有定时跑了。
			ExpOrderWareInOut.updateNorOrderStockFlag(conn, orderId);
		}
		// 至此应该没有状态更新库存了。
		// 记录流水
		if (stockChanged) {
			WareInOutInfo.addWareInOutInfo(conn, wareHouseId, wareId + "",
					count, null, opType, channelType, orderId);
		}
	}
}
