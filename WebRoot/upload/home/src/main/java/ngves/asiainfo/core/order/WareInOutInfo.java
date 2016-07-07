package ngves.asiainfo.core.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.CommnException;
import ngves.asiainfo.util.StringUtil;

public class WareInOutInfo {
	private static Log logger = LogFactory.getLog(WareInOutInfo.class);

	/**
	 * 插入库存流水记录
	 */
	private final static String INSERT_WARE_IN_OUT_INFO = "INSERT INTO WARE_INOUT_INFO("
			+ "WARE_INOUT_INFO_ID,WAREHOUSE_ID,WARE_ID,SEQ_ID,WARE_AMOUNT,OP_TYPE,"
			+ "CHANNEL_TYPE,RLT_ID,OP_TIME)VALUES(?,?,?,?,"
			+ "?,?,?,?,SYSDATE)";

	/**
	 * 查询库存流水号
	 */
	private final static String QUERY_WARE_INOUT_SEQID = "SELECT SEQ_WARE_INOUT_INFO.NEXTVAL FROM DUAL";

	/**
	 * 更新库存流水相关标识
	 */
	private final static String UPDATE_WARE_INOUT_RLTID = "UPDATE WARE_INOUT_INFO SET RLT_ID=? WHERE WARE_INOUT_INFO_ID=?";

	/**
	 * 更新库存流水操作类型,此处只使用仓库标识、礼品标识、和相关标识作为查询条件
	 */
	private final static String UPDATE_WARE_INOUT_OPTYPE = "UPDATE WARE_INOUT_INFO SET OP_TYPE=? WHERE WAREHOUSE_ID=?"
			+ "	AND WARE_ID=? AND RLT_ID=? ";

	private WareInOutInfo() {
		// 禁止私有化
	}

	/**
	 * 更新关联ID，主要正常订单号或者异常订单号
	 * 
	 * @param conn
	 * @param wareInOutId
	 * @param rltId
	 * @throws CommnException
	 */
	public static void updateWareInOutSeqId(Connection conn,
			long wareInOutInfoId, long rltId) throws CommnException {
		PreparedStatement psmt = null;
		try {
			psmt = conn.prepareStatement(UPDATE_WARE_INOUT_RLTID);
			psmt.setLong(1, rltId);
			psmt.setLong(2, wareInOutInfoId);
			psmt.executeUpdate();
			psmt.close();
		} catch (Exception e) {
			logger.error("update ware in out rlt id error! wareInOutInfoId="
					+ wareInOutInfoId + " rltId=" + rltId, e);
			throw new CommnException(
					"update ware in out rlt id error! wareInOutInfoId="
							+ wareInOutInfoId + " rltId=" + rltId, e);
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

	/**
	 * 更新出入库流水
	 * 
	 * @param conn
	 *            数据库连接
	 * @param wareHouseId
	 *            仓库编号
	 * @param wareId
	 *            礼品标识
	 * @param count
	 *            数量
	 * @param seqId
	 *            序列号
	 * @param opType
	 *            操作类型
	 * @param channelType
	 *            渠道类型
	 * @param rltId
	 *            相关标识
	 * @return
	 * @throws CommnException
	 */
	public static long updateWareInOutInfo(Connection conn, String wareHouseId,
			String wareId, int count, String seqId, String opType,
			String channelType, String rltId) throws CommnException {
		if (StringUtil.isBlank(wareHouseId) || StringUtil.isBlank(wareId)
				|| count <= 0 || StringUtil.isBlank(opType)
				|| StringUtil.isBlank(channelType) || StringUtil.isBlank(rltId)) {
			logger.error("Illegal arguments for ware in out seq! wareHouseId="
					+ wareHouseId + " wareId=" + wareId + " count=" + count
					+ " seqId=" + seqId + " opType=" + opType + " channelType="
					+ channelType + " rltId=" + rltId);
			throw new CommnException(
					"Illegal arguments for ware in out seq! wareHouseId="
							+ wareHouseId + " wareId=" + wareId + " count="
							+ count + " seqId=" + seqId + " opType=" + opType
							+ " channelType=" + channelType + " rltId=" + rltId);
		}
		long wareInOutSeqId = -1L;
		// 开始构造更新语句
		PreparedStatement psmt = null;
		try {
			psmt = conn.prepareStatement(UPDATE_WARE_INOUT_OPTYPE);
			psmt.setString(1, opType);
			psmt.setLong(2, Long.parseLong(wareHouseId));
			psmt.setLong(3, Long.parseLong(wareId));
			psmt.setString(4, rltId);
			psmt.executeUpdate();
			psmt.close();

		} catch (Exception e) {
			logger.error("update ware in out op_type error! wareHouseId="
					+ wareHouseId + " wareId=" + wareId + " count=" + count
					+ " seqId=" + seqId + " opType=" + opType + " channelType="
					+ channelType + " rltId=" + rltId + "\n " + e.getMessage(),
					e);
			throw new CommnException("update ware in out op_type error,"
					+ " ware_id=" + wareId + " wareHouseId=" + wareHouseId
					+ " opType=" + opType + " count=" + count + "\n "
					+ e.getMessage(), e);
		} finally {
			// 关闭数据库连接
			try {
				if (null != psmt)
					psmt.close();
			} catch (Exception e) {
				logger.error("can not close ware inout preparestatement!");
			}
		}
		return wareInOutSeqId;
	}

	/**
	 * 增加库存流水
	 * 
	 * @param conn
	 *            数据库连接
	 * @param wareHouseId
	 *            仓库标识
	 * @param wareId
	 *            礼品标识
	 * @param count
	 *            数量
	 * @param seqId
	 *            相关标识，正常订单号
	 * @param opType
	 *            操作类型
	 * @param channelType
	 *            渠道类型
	 * @param rltId
	 *            相关标识
	 * @return
	 * @throws CommnException
	 */
	public static long addWareInOutInfo(Connection conn, String wareHouseId,
			String wareId, int count, String seqId, String opType,
			String channelType, String rltId) throws CommnException {
		if (StringUtil.isBlank(wareHouseId) || StringUtil.isBlank(wareId)
				|| count <= 0 && !CommnConstant.WARE_STOCK_OPER_TYPE_NORMAL_OUT.equals(opType) || StringUtil.isBlank(opType)
				|| StringUtil.isBlank(channelType) || StringUtil.isBlank(rltId)) {
			logger.error("Illegal arguments for ware in out seq! wareHouseId="
					+ wareHouseId + " wareId=" + wareId + " count=" + count
					+ " seqId=" + seqId + " opType=" + opType + " channelType="
					+ channelType + " rltId=" + rltId);
			throw new CommnException(
					"Illegal arguments for ware in out seq! wareHouseId="
							+ wareHouseId + " wareId=" + wareId + " count="
							+ count + " seqId=" + seqId + " opType=" + opType
							+ " channelType=" + channelType + " rltId=" + rltId);
		}
		long wareInOutSeqId = -1L;
		// 开始构造插入语句
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			psmt = conn.prepareStatement(QUERY_WARE_INOUT_SEQID);
			rs = psmt.executeQuery();
			if (null != rs) {
				while (rs.next()) {
					wareInOutSeqId = rs.getLong(1);
					break;
				}
			}
			psmt.close();
			if (wareInOutSeqId == -1) {
				logger.error("can not get  ware_inout seq value! wareHouseId="
						+ wareHouseId + " wareId=" + wareId + " count=" + count
						+ " seqId=" + seqId + " opType=" + opType
						+ " channelType=" + channelType + " rltId=" + rltId);
				throw new CommnException("can not get  ware_inout  seq value!"
						+ " ware_id=" + wareId + " wareHouseId=" + wareHouseId
						+ " opType=" + opType + " count=" + count);
			}
			psmt = conn.prepareStatement(INSERT_WARE_IN_OUT_INFO);
			psmt.setLong(1, wareInOutSeqId);
			psmt.setLong(2, Long.parseLong(wareHouseId));
			psmt.setLong(3, Long.parseLong(wareId));
			if (StringUtil.isBlank(seqId))
				psmt.setNull(4, Types.NUMERIC);
			else
				psmt.setString(4, seqId);
			psmt.setInt(5, count);
			if (StringUtil.isBlank(opType))
				psmt.setNull(6, Types.VARCHAR);
			else
				psmt.setString(6, opType);
			if (StringUtil.isBlank(channelType))
				psmt.setNull(7, Types.VARCHAR);
			else
				psmt.setString(7, channelType);
			if (StringUtil.isBlank(rltId))
				psmt.setNull(8, Types.VARCHAR);
			else
				psmt.setString(8, rltId);
			psmt.executeUpdate();
			psmt.close();

		} catch (Exception e) {
			logger.error("insert ware in out seq error! wareHouseId="
					+ wareHouseId + " wareId=" + wareId + " count=" + count
					+ " seqId=" + seqId + " opType=" + opType + " channelType="
					+ channelType + " rltId=" + rltId + "\n " + e.getMessage(),
					e);
			throw new CommnException("insert ware in out seq error,"
					+ " ware_id=" + wareId + " wareHouseId=" + wareHouseId
					+ " opType=" + opType + " count=" + count + "\n "
					+ e.getMessage(), e);
		} finally {
			// 关闭数据库连接
			try {
				if (null != rs) {
					rs.close();
				}
				if (null != psmt)
					psmt.close();
			} catch (Exception e) {
				logger.error("can not close ware inout preparestatement!");
			}
		}
		return wareInOutSeqId;
	}
}
