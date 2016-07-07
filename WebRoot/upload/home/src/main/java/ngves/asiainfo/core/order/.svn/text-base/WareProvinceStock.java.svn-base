package ngves.asiainfo.core.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ngves.asiainfo.CommnException;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WareProvinceStock {
	private static Log logger = LogFactory.getLog(WareProvinceStock.class);

	/**
	 * 查询省份库存限制
	 */
	private static final String QUERY_WARE_PROVINCE_LIMIT = "SELECT A.HOUSE_WARE_INFO_ID"
			+ " FROM HOUSE_WARE_INFO A, HOUSE_WARE_LIMIT B"
			+ " WHERE A.HOUSE_WARE_INFO_ID = B.HOUSE_WARE_INFO_ID"
			+ "  AND A.WARE_ID = ?"
			+ "  AND A.WAREHOUSE_ID = ? AND B.PROVINCE_CODE=?";

	/**
	 * 扣减省份库存
	 */
	private static final String UPDATE_WARE_PROVINCE_LIMIT_SUB = "UPDATE HOUSE_WARE_LIMIT SET LIMIT_NUM=LIMIT_NUM-?"
			+ " WHERE (LIMIT_NUM-?)>=0 AND HOUSE_WARE_INFO_ID=? AND PROVINCE_CODE=?";

	/**
	 * 增加省份库存
	 */
	private static final String UPDATE_WARE_PROVINCE_LIMIT_ADD = "UPDATE HOUSE_WARE_LIMIT SET LIMIT_NUM=LIMIT_NUM+?"
			+ " WHERE HOUSE_WARE_INFO_ID=? AND PROVINCE_CODE=?";

	private WareProvinceStock() {
		// 禁止实例
	}

	/**
	 * 根据不同类型进行省份库存的加或者减
	 * 
	 * @param conn
	 *            数据库连接
	 * @param wareId
	 *            礼品标识
	 * @param wareHouseId
	 *            仓库标识
	 * @param count
	 *            数量
	 * @param sendProvince
	 *            配送省份或者客户所在省份
	 * @param isAdd
	 *            是否增加
	 * @throws CommnException
	 */
	public static void procssWareProvinceStock(Connection conn, String wareId,
			String wareHouseId, int count, String sendProvince, boolean isAdd)
			throws CommnException {
		if (StringUtil.isBlank(wareHouseId) || StringUtil.isBlank(wareId)
				|| count <= 0 || StringUtil.isBlank(sendProvince)) {
			logger.error("Illegal province stock arguments! wareHouseId="
					+ wareHouseId + " wareId=" + wareId + " count=" + count
					+ " sendProvince=" + sendProvince);
			throw new CommnException(
					"Illegal province stock  arguments! wareHouseId="
							+ wareHouseId + " wareId=" + wareId + " count="
							+ count + " sendProvince=" + sendProvince);
		}
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 首先判断是否有，有的话更新，没有就不更新了
			psmt = conn.prepareStatement(QUERY_WARE_PROVINCE_LIMIT);
			psmt.setString(1, wareId);
			psmt.setString(2, wareHouseId);
			psmt.setString(3, sendProvince);
			rs = psmt.executeQuery();
			if (null != rs) {
				String wareHouseInfoId = null;
				while (rs.next()) {
					wareHouseInfoId = rs.getString(1);
					break;
				}
				psmt.close();
				// 这里暂时对为空不抛异常了
				if (null != wareHouseInfoId) {
					if (isAdd) {
						psmt = conn
								.prepareStatement(UPDATE_WARE_PROVINCE_LIMIT_ADD);
						psmt.setInt(1, count);
						psmt.setString(2, wareHouseInfoId);
						psmt.setString(3, sendProvince);
					} else {
						psmt = conn
								.prepareStatement(UPDATE_WARE_PROVINCE_LIMIT_SUB);
						psmt.setInt(1, count);
						psmt.setInt(2, count);
						psmt.setString(3, wareHouseInfoId);
						psmt.setString(4, sendProvince);
					}
					int rows = psmt.executeUpdate();
					psmt.close();
					if (rows == 0) {
						// 更新了0行，这就不对了，说明不够
						logger
								.error("update ware house province count error, update count great than province stock!,"
										+ " ware_id="
										+ wareId
										+ " wareHouseId="
										+ wareHouseId
										+ " count=" + count);
						throw new CommnException(
								"update ware house  count error, update count great than province stock!"
										+ " ware_id=" + wareId
										+ " wareHouseId=" + wareHouseId
										+ " count=" + count);
					}
				}
			}
		} catch (Exception e) {
			logger.error("update ware house province count error,"
					+ " ware_id=" + wareId + " wareHouseId=" + wareHouseId
					+ " count=" + count + "\n " + e.getMessage(), e);
			throw new CommnException("update ware house province count error,"
					+ " ware_id=" + wareId + " wareHouseId=" + wareHouseId
					+ " count=" + count + "\n " + e.getMessage(), e);
		} finally {
			// 关闭数据库连接
			try {
				if (rs != null) {
					rs.close();
				}
				if (null != psmt)
					psmt.close();
			} catch (Exception e) {
				logger.error("can not close resultset and preparestatement!");
			}
		}
	}
}
