package ngves.asiainfo.core.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.CommnException;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.ServiceManager;

public class WareStockUtil {
	private static Log logger = LogFactory.getLog(WareStockUtil.class);

	/**
	 * 根据配送省份查询仓库标识
	 * 添加礼品编号查询条件
	 * 通过礼品省份来确定是查询省网大区仓还是全网大区仓
	 */
	private final static String QUERY_WARE_HOUSE_LOGISITICS = "SELECT A.WAREHOUSE_ID,B.WAREHOUSE_TYPE,A.RLT_STATE  FROM WAREHOUSE_LOGISTIC_RLT A, WAREHOUSE_INFO B"
			+ ", WARE_INFO W  WHERE A.WAREHOUSE_ID = B.WAREHOUSE_ID AND　W.PROVINCE_CODE=B.PROVINCE_CODE "
			+" AND B.WAREHOUSE_TYPE=W.WARE_STORAGE_TYPE "
			+ "  AND (A.RLT_STATE = '"
			+ CommnConstant.SYS_PARA_WARE_HOUSE_LOGISTICS_STATE_ENABLE
			+ "' OR A.RLT_STATE = '"
			+ CommnConstant.SYS_PARA_WARE_HOUSE_LOGISTICS_STATE_TO_REPLACE
			+ "')"
			+ "  AND B.WAREHOUSE_STATE = '"
			+ CommnConstant.VALID_FLAG_ENBALE
			+ "' "
			+ "  AND A.PROVINCE_CODE =? "
			+ "  AND W.WARE_ID =? ";

	/**
	 * 依据礼品编码查询礼品编码
	 */
	private final static String QUERY_WARE_ID = "SELECT WARE_ID,DELIVER_TYPE FROM WARE_INFO WHERE WARE_CODE=?";
	/**
	 * 依据仓库编码查询仓库标识
	 */
	private final static String QUERY_WARE_HOUSE_ID = "SELECT WAREHOUSE_ID FROM WAREHOUSE_INFO WHERE WAREHOUSE_CODE=?";

	/**
	 * 根据礼品标识查询礼品库存类型
	 */
	private final static String QUERY_WARE_INFO = "SELECT A.WARE_STORAGE_TYPE,A.WAREHOUSE_ID FROM WARE_INFO A WHERE A.WARE_ID=?";
	
	/**
	 * 抢兑礼品扣减 "限制" 数量
	 */
	private final static String DEDUCT_LIMIT_WARE_INFO = "update activity_bind_relation t " +
			"set t.grant_max_amount = t.grant_max_amount - ?   where  t.activity_id = " +
			"(select max(a.activity_id) " +
	        "  from activity_limit a, activity_bind_relation b " +
	        " where a.activity_id = b.activity_id " +
	        "  and b.ware_id = " +
	        " (select ware_id from ware_info where ware_code = ? ) " +
	        " and a.activity_start_time <= sysdate " +
	        " and a.activity_end_time >= sysdate) " +
			" and t.ware_id = " +
			"( select c.ware_id from ware_info c where c.ware_code = ? ) " +
			" and  t.grant_max_amount - ? >=0 ";
	
	/**
	 * 抢兑礼品回退 "限制" 数量
	 */
	private final static String ROLL_BACK_LIMIT_WARE_INFO = "update activity_bind_relation t " +
			"set t.grant_max_amount = t.grant_max_amount + ?   where t.activity_id = ? " +
			" and t.ware_id = (select c.ware_id from ware_info c where c.ware_code = ? ) ";
	

	
	
	private WareStockUtil() {

	}

	/**
	 * 更新出入库流水的订单号码
	 * 
	 * @param wareInOutInfoId
	 *            出入库流水流水号
	 * @param rltId
	 *            相关订单标识
	 * @throws CommnException
	 */
	public void updateWareInOutSeqId(long wareInOutInfoId, long rltId)
			throws CommnException {
		if (wareInOutInfoId <= 0 || rltId <= 0) {
			logger.error("illegal arguments! wareInOutId=" + wareInOutInfoId
					+ " rltId=" + rltId);
			throw new CommnException("illegal arguments! wareInOutId="
					+ wareInOutInfoId + " rltId=" + rltId);
		}
		Connection conn = null;
		try {
			// 获取数据库数据库连接
			conn = getDBConnection();
			WareInOutInfo.updateWareInOutSeqId(conn, wareInOutInfoId, rltId);
		} catch (Exception e) {
			logger.error("update ware in out rlt id error! wareInOutInfoId="
					+ wareInOutInfoId + " rltId=" + rltId + "\n "
					+ e.getMessage(), e);
			throw new CommnException(
					"update ware in out rlt id error! wareInOutInfoId="
							+ wareInOutInfoId + " rltId=" + rltId + "\n "
							+ e.getMessage(), e);
		} finally {
			// 关闭数据库连接
			closeDBConnetion(conn);
		}
	}

	/**
	 * 更新库存
	 * 
	 * @param houseCode
	 *            仓库编码
	 * @param wareCode
	 *            礼品编码
	 * @param sendProvince
	 *            配送省份
	 * @param count
	 *            数量
	 * @param opType
	 *            操作类型
	 * @param channelType
	 *            渠道类型
	 * @param seqId
	 *            相关关联标识
	 * @return
	 * @throws CommnException
	 */
	public static long processWareStock(String houseCode, String wareCode,
			String sendProvince, int count, String opType, String channelType,
			String seqId) throws CommnException {
		if (StringUtil.isBlank(wareCode) || count <= 0) {
			logger.error("illegal arguments! wareCode=" + wareCode + " count="
					+ count);
			throw new CommnException("illegal arguments! wareCode=" + wareCode
					+ " count=" + count);
		}
		long wareId = -1L;
		String houseId = null;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 获取数据库数据库连接
			conn = getDBConnection();
			psmt = conn.prepareStatement(QUERY_WARE_ID);
			psmt.setString(1, wareCode);
			// 开始查询
			rs = psmt.executeQuery();

			if (null != rs) {
				while (rs.next()) {
					wareId = rs.getLong(1);
					break;
				}
			}
			psmt.close();
			psmt = conn.prepareStatement(QUERY_WARE_HOUSE_ID);
			psmt.setString(1, houseCode);
			// 开始查询
			rs = psmt.executeQuery();
			if (null != rs) {
				while (rs.next()) {
					houseId = rs.getString(1);
					break;
				}
			}
			psmt.close();
		} catch (Exception e) {
			logger.error("query ware id error! wareCode=" + wareCode, e);
			throw new CommnException("query ware id error! wareCode="
					+ wareCode, e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					logger.error(e);
				}
			}
			// 关闭数据库连接
			if (null != psmt) {
				try {
					psmt.close();
				} catch (SQLException e) {
					logger.error("close psmt fail", e);
					// throw new CommnException("close psmt fail", e);
				}
			}
			closeDBConnetion(conn);
		}
		return processWareStock(houseId, wareId, sendProvince, count, opType,
				channelType, seqId);
	}

	/**
	 * 提供给接口用的库存扣减
	 * 
	 * @param wareId
	 *            礼品标识
	 * @param sendProvince
	 *            配送省份
	 * @param opType
	 *            操作类型
	 * @param channelType
	 *            渠道类型
	 * @param seqId
	 *            相关标识(下单序列号)
	 * @throws CommnException
	 */
	public static long processWareStock(String houseId, long wareId,
			String sendProvince, int count, String opType, String channelType,
			String seqId) throws CommnException {
		if (wareId <= 0
				|| (StringUtil.isBlank(sendProvince) && StringUtil
						.isBlank(houseId)) || StringUtil.isBlank(opType)
				|| count <= 0 && !CommnConstant.WARE_STOCK_OPER_TYPE_NORMAL_OUT.equals(opType) || StringUtil.isBlank(channelType)
				|| StringUtil.isBlank(seqId)) {
			logger.error("illegal arguments! wareHouseId=" + houseId
					+ " wareId=" + wareId + " sendProvince=" + sendProvince
					+ " count=" + count + " opType=" + opType + " channelType="
					+ channelType + " seqId=" + seqId);
			throw new CommnException("illegal arguments! wareHouseId="
					+ houseId + " wareId=" + wareId + " sendProvince="
					+ sendProvince + " count=" + count + " opType=" + opType
					+ " channelType=" + channelType + " seqId=" + seqId);
		}
		long wareInOutId = -1L;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 获取数据库数据库连接
			conn = getDBConnection();
			// 根据 wareId获取仓库类型
			psmt = conn.prepareStatement(QUERY_WARE_INFO);
			psmt.setLong(1, wareId);
			// 开始查询
			rs = psmt.executeQuery();
			String wareHouseType = null;
			String wareHouseId = houseId;
			if (null != rs) {
				while (rs.next()) {
					wareHouseType = rs.getString(1);
					// 这里再次设置了一次wareHouseId，可能有，也可能没有，或者已经发生变化
					if (wareHouseType
							.equals(CommnConstant.WARE_HOUSE_TYPE_GLOBAL)
							|| wareHouseType
									.equals(CommnConstant.WARE_HOUSE_TYPE_VIRTUAL))
						wareHouseId = rs.getString(2);
					break;
				}
			}
			psmt.close();
			// 如果为空报错
			if (null == wareHouseType) {
				logger
						.error("query ware house type is null by wareId! wareId ="
								+ wareId);
				throw new CommnException(
						"query ware house type is null by wareId! wareId ="
								+ wareId);
			}
			// 如果为空，且类型又是中心仓或者虚拟仓报错
			if ((wareHouseType.equals(CommnConstant.WARE_HOUSE_TYPE_GLOBAL) || wareHouseType
					.equals(CommnConstant.WARE_HOUSE_TYPE_VIRTUAL))
					&& null == wareHouseId) {
				logger
						.error("query ware house id is null by gloabal or virtual wareId! wareId ="
								+ wareId);
				throw new CommnException(
						"query ware house id is null by gloabal or virtual wareId! wareId ="
								+ wareId);
			}
			// 根据配送省份获取仓库标识，这里不管怎么样都查询一下，以确定有没有这样的关系
			// 这里还要判断一下这种配送关系是否支持下单，即配送关系处于启用 1 和 替换中 的允许下单，
			// 其他未启用，停用的不能下单,这里也不判断仓库类型了，所有的进行判断
			// 可能会查到多条记录，如虚拟仓、大区仓、中心仓的
			// 对于所有仓库类型可能都多条
			// 这里还得看看是否传进配送省份
			if (!StringUtil.isBlank(sendProvince)) {
				psmt = conn.prepareStatement(getQuerySql(wareHouseType));
				psmt.setString(1, sendProvince.toLowerCase());
				psmt.setLong(2, wareId);
				rs = psmt.executeQuery();
				// 先初始化为null;
				if (null == houseId)
					houseId = wareHouseId;
				wareHouseId = null;
				// 仓库和仓储有配送关系否，默认没有
				Boolean hasProvincRlt = false;
				if (null != rs) {
					while (rs.next()) {
						String houseType = rs.getString(2);
						// 应该不关系非此类型的仓库
						if (houseType.equals(wareHouseType)) {
							if (houseType
									.equals(CommnConstant.WARE_HOUSE_TYPE_REGION)) {
								// 大区仓，大区仓可能有正在启用的大区仓，也有可能是处于替换中、启用的状态
								// 此时，houseId
								// 可能为空,也可能不为空,如果为空，则找状态为1的，如果不为空，则找相应的状态
								if (StringUtil.isBlank(houseId)) {
									if (rs.getString(3).equals(CommnConstant.SYS_PARA_WARE_HOUSE_LOGISTICS_STATE_ENABLE)) {
										wareHouseId = rs.getString(1);
										hasProvincRlt = true;
									}
								} else {
									// 仓库标识参数不为空
									if (rs.getString(1).equals(houseId)) {
										wareHouseId = rs.getString(1);
										hasProvincRlt = true;
									}
								}
							} else {
								// 虚拟仓、中心仓主要看是否存在关系
								// 如果能查出这种关系，则表示可以下单，
								if (rs.getString(1).equals(houseId)) {
									wareHouseId = rs.getString(1);
									hasProvincRlt = true;
								}
							}
						}
					}
				}
				rs.close();
				psmt.close();
				if (!hasProvincRlt) {
					logger
							.error("This ware does not allow order in the warehouse and the province! wareId="
									+ wareId
									+ " sendProvince="
									+ sendProvince
									+ " warehouse_id=" + houseId);
					throw new CommnException(
							"This ware does not allow order in the warehouse and the province! wareId="
									+ wareId + " sendProvince=" + sendProvince
									+ " warehouse_id=" + houseId);
				}
			}
			// 此处还有判断库存标识
			if (null == wareHouseId) {
				logger
						.error("can not query the ware house Id by send province! wareId="
								+ wareId + " sendProvince=" + sendProvince);
				throw new CommnException(
						"can not query the ware house Id by send province! wareId="
								+ wareId + " sendProvince=" + sendProvince);
			}
			// 这里要重新开始考虑库存省份关系。对于老订单生成的异常订单，则使用老仓库标识
			if (!StringUtil.isBlank(houseId) && !wareHouseId.equals(houseId)) {
				// 这里可能存在老订单生成异常订单，这么处理每问题
				// 对于新下订单，可能也传进来仓库标识，存在可能后台已经改了仓库，前台传进来的还是老的。
				// 这里没有办法判断
				wareHouseId = houseId;
			}

			// 开始更新总库存及省份库存
			WareStock.processWareStock(conn, wareHouseId, wareHouseType, wareId
					+ "", opType, count, sendProvince);

			// 记录出入库流水，对于订单失败的需要回滚时，则更新以前的流水位回滚流水
			if (opType
					.equals(CommnConstant.WARE_STOCK_OPER_TYPE_CREATE_ORDER_ROLLBACK)) {
				wareInOutId = WareInOutInfo.updateWareInOutInfo(conn,
						wareHouseId, wareId + "", count, null, opType,
						channelType, seqId);
			} else
				wareInOutId = WareInOutInfo.addWareInOutInfo(conn, wareHouseId,
						wareId + "", count, null, opType, channelType, seqId);
		} catch (Exception e) {
			logger.error("Process ware house stock error! wareId=" + wareId
					+ " sendProvince=" + sendProvince + " count=" + count
					+ " opType=" + opType + " channelType=" + channelType
					+ " seqId=" + seqId + "\n " + e.getMessage(), e);
			throw new CommnException("Process ware house stock error! wareId="
					+ wareId + " sendProvince=" + sendProvince + " count="
					+ count + " opType=" + opType + " channelType="
					+ channelType + " seqId=" + seqId + "\n " + e.getMessage(),
					e);
		} finally {
			try {
				if (null != rs) {
					rs.close();
				}
				if (null != psmt)
					psmt.close();
			} catch (Exception e) {
				logger.error("can not close resultset and preparestatement!");
			}
			// 关闭数据库连接
			closeDBConnetion(conn);
		}
		return wareInOutId;
	}

	/**
	 * 更新订单状态
	 * 
	 * @param orderId
	 *            订单标识
	 * @param oldOrderState
	 *            订单前一状态
	 * @param newOrderState
	 *            订单下一状态
	 * @param wareCode
	 *            礼品编码
	 * @param count
	 *            数量
	 * @param wareHouseId
	 *            仓库标识
	 * @param sendProvince
	 *            配送省
	 * @param channelType
	 *            渠道类型
	 * @throws CommnException
	 */
	public static void processWareStock(String orderId, String oldOrderState,
			String newOrderState, String wareCode, int count,
			String wareHouseCode, String sendProvince, String channelType)
			throws CommnException {
		if (StringUtil.isBlank(wareCode) || count <= 0) {
			logger.error("illegal order update arguments! wareCode=" + wareCode
					+ " count=" + count);
			throw new CommnException(
					"illegal order update arguments! wareCode=" + wareCode
							+ " count=" + count);
		}
		long wareId = -1L;
		String wareDeliverType = null;
		String wareHouseId = null;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 获取数据库数据库连接
			conn = getDBConnection();
			psmt = conn.prepareStatement(QUERY_WARE_ID);
			psmt.setString(1, wareCode);
			// 开始查询
			rs = psmt.executeQuery();

			if (null != rs) {
				while (rs.next()) {
					wareId = rs.getLong(1);
					wareDeliverType = rs.getString(2);
					break;
				}
			}
			psmt.close();
			psmt = conn.prepareStatement(QUERY_WARE_HOUSE_ID);
			psmt.setString(1, wareHouseCode);
			// 开始查询
			rs = psmt.executeQuery();
			if (null != rs) {
				while (rs.next()) {
					wareHouseId = rs.getString(1);
					break;
				}
			}
			psmt.close();
		} catch (Exception e) {
			logger.error("query ware id error! wareCode=" + wareCode, e);
			throw new CommnException("query ware id error! wareCode="
					+ wareCode, e);
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					logger.error(e);
				}
			}
			if (null != psmt) {
				try {
					psmt.close();
				} catch (SQLException e) {
					logger.error("close psmt fail", e);
					// throw new CommnException("close psmt fail", e);
				}
			}
			// 关闭数据库连接
			closeDBConnetion(conn);
		}
		processWareStock(orderId, oldOrderState, newOrderState, wareId,
				wareDeliverType, count, wareHouseId, sendProvince, channelType);
	}

	/**
	 * 根据传入的订单操作类型及数量进行，针对子订单进行
	 * 
	 * @param orderId
	 *            正常订单、异常订单标识
	 * @param oldOrderState
	 *            订单老状态，包括正常订单状态和异常订单状态 对于下订单时，老状态可以为空
	 * @param newOrderState
	 *            订单新状态 包括正常订单状态和异常订单状态
	 * @param wareId
	 *            礼品标识
	 * @param count
	 *            数量，订单量
	 * @param sendProvince
	 *            配送省份，可选，对于有省份库存时需传入
	 * @param channelType
	 *            兑换渠道类型，取自 CommnConstant.WARE_INOUT_CHANNEL...
	 * @throws CommnException
	 */
	public static void processWareStock(String orderId, String oldOrderState,
			String newOrderState, long wareId, String wareDeliverType,
			int count, String wareHouseId, String sendProvince,
			String channelType) throws CommnException {
		// 如果订单标识、数量小于等于0，仓库标识和配送省份都为空，则认为非法参数
		if (StringUtil.isBlank(orderId)
				|| count <= 0
				|| (StringUtil.isBlank(wareHouseId) && StringUtil
						.isBlank(sendProvince))) {
			logger.error("illegal order update arguments! orderId=" + orderId
					+ " count=" + count + " wareHouseId=" + wareHouseId
					+ " sendProvince=" + sendProvince);
			throw new CommnException("illegal order update arguments! orderId="
					+ orderId + " count=" + count + " wareHouseId="
					+ wareHouseId + " sendProvince=" + sendProvince);
		}
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 获取数据库数据库连接
			conn = getDBConnection();
			// 得到仓库标识
			String houseId = wareHouseId;
			// 根据 wareId获取仓库类型
			psmt = conn.prepareStatement(QUERY_WARE_INFO);
			psmt.setLong(1, wareId);
			// 开始查询
			rs = psmt.executeQuery();
			String wareHouseType = null;
			if (null != rs) {
				while (rs.next()) {
					wareHouseType = rs.getString(1);
					houseId = rs.getString(2);
					break;
				}
			}
			psmt.close();
			// 如果为空报错
			if (null == wareHouseType) {
				logger
						.error("query ware house type is null by wareId! wareId ="
								+ wareId);
				throw new CommnException(
						"query ware house type is null by wareId! wareId ="
								+ wareId);
			}
			if (!wareHouseType.equals(CommnConstant.WARE_HOUSE_TYPE_REGION)
					&& StringUtil.isBlank(houseId)) {
				// 对于虚拟仓和中心仓，不允许仓库标识为空
				logger
						.error("the ware type is global and virtul, but houseId is null! wareId ="
								+ wareId);
				throw new CommnException(
						"the ware type is global and virtul, but houseId is null! wareId ="
								+ wareId);
			}
			if (StringUtil.isBlank(houseId)){
				houseId = wareHouseId;
			}
			if (StringUtil.isBlank(houseId)) {
				psmt = conn.prepareStatement(getQuerySql(wareHouseType));
				psmt.setString(1, sendProvince);
				psmt.setLong(2, wareId);
				rs = psmt.executeQuery();
				if (null != rs) {
					while (rs.next()) {
						// 这里需要好好判断，因为可能查出好多关系,因为不是大区仓
						String houseType = rs.getString(2);
						if (houseType.equals(wareHouseType)) {
							if (wareHouseType.equals(CommnConstant.WARE_HOUSE_TYPE_REGION)) {
								if (rs.getString(3).equals(CommnConstant.SYS_PARA_WARE_HOUSE_LOGISTICS_STATE_ENABLE)) {
									houseId = rs.getString(1);
									break;
								}
							}
						}
					}
				}
				psmt.close();
			}
			// 此时如果仓库标识还为空，则抛出异常了
			if (StringUtil.isBlank(houseId)) {
				logger
						.error("Can not get the ware house Id according to the wareId and send province!"
								+ " ware_id="
								+ wareId
								+ " wareHouseId="
								+ wareHouseId + " sendProvince=" + sendProvince);
				throw new CommnException(
						"Can not get the ware house Id according to the wareId and send province!"
								+ " ware_id=" + wareId + " wareHouseId="
								+ wareHouseId + " sendProvince=" + sendProvince);
			}

			// 是否为全网配送
			boolean isGlobalSend = true;
			if (!StringUtil.isBlank(wareDeliverType)) {
				if (wareDeliverType.equals(CommnConstant.DELIV_TYPE_VIR_ELE)
						|| wareDeliverType
								.equals(CommnConstant.DELIV_TYPE_COOPERATE_MAGAZINE)
						|| wareDeliverType
								.equals(CommnConstant.DELIV_TYPE_DIY_DELIV)
						|| wareDeliverType
								.equals(CommnConstant.DELIV_TYPE_TWODIM_DELIV)
						|| wareDeliverType
								.equals(CommnConstant.DELIV_TYPE_AIRLINE)
						|| wareDeliverType
								.equals(CommnConstant.DELIV_TYPE_PRIVATE)
						|| wareDeliverType
								.equals(CommnConstant.DELIV_TYPE_VALUE_DONATE)
						||wareDeliverType
						        .equals(CommnConstant.DELIV_TYPE_PROVINCE_DELIV)
						||wareDeliverType
						        .equals(CommnConstant.DELIV_TYPE_SELF_GET)
						||wareDeliverType
						        .equals(CommnConstant.DELIV_TYPE_WARE)
						||wareDeliverType
						        .equals(CommnConstant.DELIV_TYPE_GAS_CARD)
						||wareDeliverType
						        .equals(CommnConstant.DELIV_TYPE_OUT_EXCHANGE)
						||wareDeliverType
						        .equals(CommnConstant.DELIV_TYPE_PUFA)
					   )
					isGlobalSend = false;
			}
			// 判断是否正常订单
			// 取第一位字符
			// 判断是否异常订单
			String first = newOrderState.substring(0, 1);
			if (first.equals(CommnConstant.ORDER_TYPE_NORMAL)) {
				// 正常订单库存
				NoramlOrderStock.processOrderStock(conn, orderId,
						oldOrderState, newOrderState, wareId, isGlobalSend,
						count, wareHouseId, wareHouseType, sendProvince,
						channelType);
			} else {
				// 异常订单库存
					ExpOrderStock.processExpOrderStock(conn, orderId,
							oldOrderState, newOrderState, wareId, count,
							wareHouseId, wareHouseType, sendProvince, channelType);
			}
		} catch (Exception e) {
			logger.error("Process order ware house stock error! oldOrderState="
					+ oldOrderState + " newOrderState=" + newOrderState
					+ " wareId=" + wareId + " count=" + count + " wareHouseId="
					+ wareHouseId + " sendProvince=" + sendProvince + "\n "
					+ e.getMessage(), e);
			throw new CommnException(
					"Process order ware house stock error! oldOrderState="
							+ oldOrderState + " newOrderState=" + newOrderState
							+ " wareId=" + wareId + " count=" + count
							+ " wareHouseId=" + wareHouseId + " sendProvince="
							+ sendProvince + "\n " + e.getMessage(), e);
		} finally {
			try {
				if (null != rs) {
					rs.close();
				}
				if (null != psmt)
					psmt.close();
				closeDBConnetion(conn);
			} catch (Exception e) {
				logger.error("can not close resultset and preparestatement!");
			}
			// 关闭数据库连接
		}
	}
	
	//如果是大区仓和中心仓，需要添加省份物流关系为启用的条件
	public static  String getQuerySql(String wareHouseType){ 
		if (CommnConstant.WARE_HOUSE_TYPE_GLOBAL.equals(wareHouseType) 
		|| CommnConstant.WARE_HOUSE_TYPE_REGION.equals(wareHouseType)) {
			return QUERY_WARE_HOUSE_LOGISITICS + " AND A.PARTNER_STATE ='"
					+ CommnConstant.SYS_PARA_WARE_HOUSE_LOGISTICS_PARTNER_STATE_ENABLE + "' ";
		} else {
			return QUERY_WARE_HOUSE_LOGISITICS;
		} 
	}
	
	/**
	 * @author zhengxk@asiainfo.com
	 * <p>目前此接口用于短信库存扣减/回退接口操作</p>
	 * <p>处理抢兑礼品库存信息</p>
	 * @param wareCode
	 * @param wareCount
	 * @param operType
	 * @throws CommnException 
	 * 
	 */
	public static void processLimitWareStockInfo(String actionId, String wareCode, int wareCount, String operType) throws CommnException {
		
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			//数据库连接
			conn = getDBConnection();
			//库存扣减
			if(operType.equals(CommnConstant.WARE_STOCK_OPER_TYPE_NORMAL_ORDER)) {
				
				psmt = conn.prepareStatement(DEDUCT_LIMIT_WARE_INFO);
				psmt.setInt(1, wareCount);
				psmt.setString(2, wareCode);
				psmt.setString(3, wareCode);
				psmt.setInt(4, wareCount);
				int rows = psmt.executeUpdate();
				if (rows == 0) {
					throw new CommnException("update activity_bind_relation t number is zero!" );
				}
			//库存回退	
			}else if(operType.equals(CommnConstant.WARE_STOCK_OPER_TYPE_CANCEL_ORDER)) {
				psmt = conn.prepareStatement(ROLL_BACK_LIMIT_WARE_INFO);
				psmt.setInt(1, wareCount);
				//截取抢兑前缀
				psmt.setString(2, actionId.substring(2));
				psmt.setString(3, wareCode);
				psmt.executeUpdate();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new CommnException(e.getMessage());
			
		} finally {
			
			//处理连接关闭
			try {
				if (null != psmt) {
					psmt.close();
				}
				closeDBConnetion(conn);
			} catch (Exception e) {
				logger.error(e.getCause());
				logger.error("can not close resultset and preparestatement!");
				throw new CommnException(e.getMessage());
			}
		}
	}

	
	
	/**
	 * 获取数据库连接
	 * 
	 * @return
	 * @throws CommnException
	 */
	private static Connection getDBConnection() throws CommnException {
		Connection conn = null;
		try {
			conn = ServiceManager.getSession().getConnection();
		} catch (Exception e) {
			throw new CommnException("can not gain db connection", e);
		}
		return conn;
	}

	/**
	 * 关闭数据库连接
	 * 
	 * @param conn
	 * @throws CommnException
	 */
	private static void closeDBConnetion(Connection conn) throws CommnException {
		try {
			if (null != conn)
				conn.close();
		} catch (Exception e) {
			try {
				if (null != conn)
					conn.close();
			} catch (Exception ex) {
				throw new CommnException("can not close db connection", ex);
			}
		}
	}
}





