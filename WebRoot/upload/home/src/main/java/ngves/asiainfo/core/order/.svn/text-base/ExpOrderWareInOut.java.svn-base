package ngves.asiainfo.core.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.CommnException;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.ServiceManager;

public class ExpOrderWareInOut {
	private static Log logger = LogFactory.getLog(ExpOrderWareInOut.class);

	/**
	 * 更新不良品回库状态
	 */
	private static final String UPDATE_EXPORDER_WARE_INOUT_STOCK_FLAG = "UPDATE EXPORDER_WARE_INOUT SET IN_STORAGE_FLAG='1', ORD_OVER_TIME=SYSDATE WHERE OTHER_ORDER_ID=?";

	/**
	 * 查询某个子订单记录是否存在
	 */
	private static final String QUERY_NORMAL_ORDER_INFO = "SELECT OLD_SUBORDER_ID FROM EXPORDER_WARE_INOUT "
			+ "WHERE OLD_SUBORDER_ID=?";

	/**
	 * 插入一条用户订单记录
	 */
	private static final String INSERT_EXPORDER_WARE_INOUT = "INSERT INTO EXPORDER_WARE_INOUT ("
			+ " EXP_INOUT_ID,OLD_SUBORDER_ID,OTHER_ORDER_ID,ORDER_TYPE_ID,EXGBACK_RESP,ORD_OPR_TIME,ORD_OVER_TIME,OUT_STORAGE_FLAG,IN_STORAGE_FLAG)"
			+ "VALUES(TO_CHAR(SYSDATE,'yyyymmddhh24miss')||SEQ_EXPORDER_WARE_INOUT.NEXTVAL,?,?,'00','02',SYSDATE,SYSDATE,0,1)";

	private static final String UPDATE_EXPORDER_WARE_INOUT = "UPDATE EXPORDER_WARE_INOUT SET "
			+ " EXGBACK_RESP='02',ORD_OVER_TIME=SYSDATE, OUT_STORAGE_FLAG=0,IN_STORAGE_FLAG=1 " + " WHERE OTHER_ORDER_ID=?";

	private ExpOrderWareInOut() {
		// 禁止实例化
	}

	/**
	 * 更新异常订单不良品回库状态
	 * 
	 * @param conn	数据库连接
	 * @param expId	异常订单号
	 * @throws CommnException
	 */
	public static void updateExpOrderStockFlag(Connection conn, String expId) throws CommnException {
		if (StringUtil.isBlank(expId)) {
			logger.error("Illegal arguments! expId=" + expId);
			throw new CommnException("Illegal arguments! expId=" + expId);
		}
		PreparedStatement psmt = null;
		try {
			psmt = conn.prepareStatement(UPDATE_EXPORDER_WARE_INOUT_STOCK_FLAG);
			psmt.setString(1, expId);
			int count = psmt.executeUpdate();
			psmt.close();
			if (count <= 0) {
				logger.error("update user exchange record table stock in flag 0 rows! expId=" + expId);
				throw new CommnException("update user exchange record table stock in flag 0 rows! expId=" + expId);
			}
		} catch (Exception e) {
			logger.error("update user exchange record table stock in flag ," + " expId=" + expId, e);
			throw new CommnException("update user exchange record table stock in flag ," + " expId=" + expId, e);
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
	 * 更新无人签收订单的不良品回库状态
	 * @param conn	数据库连接
	 * @param norSubOrderId		无人签收子订单号
	 * @throws CommnException
	 */
	public static void updateNorOrderStockFlag(Connection conn, String norSubOrderId) throws CommnException {
		// 先得查询也没有这条订单记录，如果有更新，没有，插入
		if (StringUtil.isBlank(norSubOrderId)) {
			logger.error("Illegal arguments! normalOrderId=" + norSubOrderId);
			throw new CommnException("Illegal arguments! normalOrderId=" + norSubOrderId);
		}
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//先查询一下是否有无人签收子订单
			psmt = conn.prepareStatement(QUERY_NORMAL_ORDER_INFO);
			psmt.setString(1, norSubOrderId);
			rs = psmt.executeQuery();
			boolean hasOrder = false;
			if (null != rs) {
				while (rs.next()) {
					hasOrder = true;
					break;
				}
			}
			psmt.close();
			int count = -1;
			//如果没有子订单，则插入，有则更新
			if (hasOrder) {
				// 更新
				psmt = conn.prepareStatement(UPDATE_EXPORDER_WARE_INOUT);
				psmt.setString(1, norSubOrderId);
				count = psmt.executeUpdate();
				psmt.close();
			} else {
				// 插入
				psmt = conn.prepareStatement(INSERT_EXPORDER_WARE_INOUT);
				psmt.setString(1, norSubOrderId);
				psmt.setString(2, norSubOrderId);
				count = psmt.executeUpdate();
				psmt.close();
			}
			if (count <= 0) {
				logger.error("insert or update user exchange record table stock in flag ," + " norSubOrderId="
						+ norSubOrderId);
				throw new CommnException("insert or update user exchange record table stock in flag ,"
						+ " norSubOrderId=" + norSubOrderId);
			}
		} catch (Exception e) {
			logger.error("insert or update user exchange record table stock in flag ," + " norSubOrderId="
					+ norSubOrderId, e);
			throw new CommnException("insert or update user exchange record table stock in flag ," + " norSubOrderId="
					+ norSubOrderId, e);
		} finally {
			// 关闭数据库连接
			try {
				if (rs != null) {
					rs.close();
				}
				if (null != psmt)
					psmt.close();
			} catch (Exception e) {
				logger.error("can not close preparestatement!");
			}
		}
	}

	/**
	 * 下达或更新hp接口所需要的序列号yyyyMMddHHmmss + 6位sequence
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getHpOrdSeq() throws Exception {
		return DateTimeUtil.dateToString(new Date(), CommnConstant.DATETIME_HP_FORMAT)
				+ ServiceManager.getIdGenerator().getNewId(CommnConstant.ORDER_UPDATE_SEQ);
	}
}
