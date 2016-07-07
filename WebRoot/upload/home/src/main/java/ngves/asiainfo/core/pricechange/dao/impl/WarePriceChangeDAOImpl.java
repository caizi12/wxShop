package ngves.asiainfo.core.pricechange.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ngves.asiainfo.core.pricechange.dao.interfaces.IWarePriceChangeDAO;
import ngves.asiainfo.core.pricechange.model.WarePriceRecordObject;
import ngves.asiainfo.core.pricechange.util.WarePriceChangeConstant;
import ngves.asiainfo.util.JDBCUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.ServiceManager;

public class WarePriceChangeDAOImpl implements IWarePriceChangeDAO {
	private static transient Log log = LogFactory.getLog(WarePriceChangeDAOImpl.class);
	public WarePriceRecordObject findWarePriceRecordObjectByBusiId(String busiId) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			ps = conn.prepareStatement(WarePriceChangeConstant.SQL_findWarePriceRecordObjectByBuisId);
			log.debug(WarePriceChangeConstant.SQL_findWarePriceRecordObjectByBuisId);
			log.debug("busiId:" + busiId);
			ps.setString(1, busiId);
			ps.setString(2, busiId);
			rs = ps.executeQuery();
			return publicObject(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("execute method error,method names:findWarePriceRecordObjectByBuis()"
					+ e.getMessage());
		} finally {
			JDBCUtils.closeAll(conn, ps, rs);
		}
	}
	public WarePriceRecordObject publicObject(ResultSet rs) {
		try {
			if (rs.next()) {
				WarePriceRecordObject object = null;
				object = new WarePriceRecordObject();
				object.setWareId(rs.getLong("ware_id"));
				object.setMarketPrice(rs.getLong("market_price"));
				object.setCountValue(rs.getLong("count_value"));
				object.setWareIntegralValue(rs.getLong("ware_integral_value"));
				object.setOperateId(rs.getLong("last_update_staff_id"));
				object.setCheck_id(rs.getLong("check_staff_id"));
				object.setOperateDate(rs.getString("last_update_date"));
				object.setCheckDate(rs.getString("check_time"));
				object.setPayIntegralValue(rs.getLong("pay_integral"));
				object.setPayCashValue(rs.getLong("pay_cash"));
				return object;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean isAdd(String busiId) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			ps = conn.prepareStatement(WarePriceChangeConstant.SQL_isAdd);
			log.debug(WarePriceChangeConstant.SQL_isAdd);
			log.debug("busiId:" + busiId);
			ps.setString(1, busiId);
			rs = ps.executeQuery();
			boolean result = false;
			if (rs.next()) {
				result = rs.getInt("isAdd") > 1 ? false : true;
			}
			return result;
		} catch (SQLException e) {
			throw new SQLException("execute method error,method names:isAdd()" + e.getMessage());
		} finally {
			JDBCUtils.closeAll(conn, ps, rs);
		}
	}
	public String findLastBusiId(String busiId) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String lastBusiId = "";
		try {
			conn = ServiceManager.getSession().getConnection();
			ps = conn.prepareStatement(WarePriceChangeConstant.SQL_findLastBusiId);
			log.debug(WarePriceChangeConstant.SQL_findLastBusiId);
			log.debug("busiId:" + busiId);
			ps.setString(1, busiId);
			ps.setString(2, busiId);
			ps.setString(3, busiId);
			ps.setString(4, busiId);
			rs = ps.executeQuery();
			if (rs.next()) {
				lastBusiId = rs.getString("busi_id");
			}
			log.debug("return result:" + busiId);
			return lastBusiId;
		} catch (SQLException e) {
			throw new SQLException("execute method error,method names:findLastBusiId()" + e.getMessage());
		} finally {
			JDBCUtils.closeAll(conn, ps, rs);
		}
	}
	public List<String> findCBusiIdIdByPBusiId(String p_busi_id) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<String> busiList = new ArrayList<String>();
		try {
			conn = ServiceManager.getSession().getConnection();
			ps = conn.prepareStatement(WarePriceChangeConstant.SQL_findCBusiIdIdByPBusiId);
			log.debug(WarePriceChangeConstant.SQL_findCBusiIdIdByPBusiId);
			log.debug("p_busi_id:" + p_busi_id);
			ps.setString(1, p_busi_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				busiList.add(rs.getString("busi_id"));
			}
			return busiList;
		} catch (SQLException e) {
			throw new SQLException("execute method error,method names:findCBusiIdIdByPBusiId()" + e.getMessage());
		} finally {
			JDBCUtils.closeAll(conn, ps, rs);
		}
	}

	public WarePriceRecordObject findWarePriceRecordObjectByWareId(String wareId) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			ps = conn.prepareStatement(WarePriceChangeConstant.SQL_findWarePriceRecordObjectByWareId);
			log.debug(WarePriceChangeConstant.SQL_findWarePriceRecordObjectByWareId);
			log.debug("wareId:" + wareId);
			ps.setString(1, wareId);
			rs = ps.executeQuery();
			return publicObject(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("execute method error,method names:findWarePriceRecordObjectByWareId()"
					+ e.getMessage());
		} finally {
			JDBCUtils.closeAll(conn, ps, rs);
		}
	}
	public long getWarePriceChangeId() throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		long busiInfoId = -1L;
		try {
			conn = ServiceManager.getSession().getConnection();
			ps = conn.prepareStatement(WarePriceChangeConstant.SQL_getWarePriceChangeId);
			log.debug(WarePriceChangeConstant.SQL_getWarePriceChangeId);
			rs = ps.executeQuery();
			if(rs.next()){
				busiInfoId = rs.getLong("SEQ_ID");
				log.info("SQL_getWarePriceChangeId:"+busiInfoId);
			}
			return busiInfoId;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("execute method error,method names:getWarePriceChangeId()"
					+ e.getMessage());
		} finally {
			JDBCUtils.closeAll(conn, ps, rs);
		}
	}
	public boolean saveInfoFromFiles(List<WarePriceRecordObject> datas) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		final int batchSize = 1000;
		int count = 0;
		try {
			conn = ServiceManager.getSession().getConnection();
			ps = conn.prepareStatement(WarePriceChangeConstant.SQL_ADD_DATAFROMFILE);
			log.debug(WarePriceChangeConstant.SQL_ADD_DATAFROMFILE);
			for (WarePriceRecordObject warePriceRecordObject : datas) {
				ps.setLong(1, warePriceRecordObject.getBusiId());
				ps.setString(2, warePriceRecordObject.getBusiTypeId());
				ps.setLong(3, warePriceRecordObject.getWareId());
				ps.setLong(4, warePriceRecordObject.getBeginValue());
				ps.setLong(5, warePriceRecordObject.getAfterValue());
				ps.setLong(6, warePriceRecordObject.getOperateId());
				ps.setString(7, warePriceRecordObject.getOperateDate());
				ps.setLong(8, warePriceRecordObject.getCheck_id());
				ps.setString(9, warePriceRecordObject.getCheckDate());
				ps.setString(10, warePriceRecordObject.getOperateCause());
				ps.setLong(11, getWarePriceChangeId());
				// 批量插入
				ps.addBatch();
				if (++count % batchSize == 0) {
					ps.executeBatch();
				}
			}
			ps.executeBatch();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("execute method error,method names:saveInfoFromFiles()" + e.getMessage());
		} finally {
			JDBCUtils.closeAll(conn, ps, rs);
		}
	}
	public String findBusiId() throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String result = "";
		try {
			conn = ServiceManager.getSession().getConnection();
			ps = conn.prepareStatement(WarePriceChangeConstant.SQL_findBuisId);
			log.debug(WarePriceChangeConstant.SQL_findBuisId);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getString("busi_id");
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("execute method error,method names:findWarePriceRecordObjectByBuis()"
					+ e.getMessage());
		} finally {
			JDBCUtils.closeAll(conn, ps, rs);
		}
	}
	public String findWareIdByWareCode(String wareCode) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			ps = conn.prepareStatement(WarePriceChangeConstant.SQL_findWareIdByWareCode);
			log.debug(WarePriceChangeConstant.SQL_findLastBusiId);
			log.debug("wareCode:" + wareCode);
			ps.setString(1, wareCode);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString("wareCode");
			}
			return "";
		} catch (SQLException e) {
			throw new SQLException("execute method error,method names:findWareIdByWareCode()" + e.getMessage());
		} finally {
			JDBCUtils.closeAll(conn, ps, rs);
		}
	}
}
