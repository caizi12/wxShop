package ngves.asiainfo.core.common.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import oracle.sql.CLOB;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ngves.asiainfo.core.common.bo.BusiInfoEngine;
import ngves.asiainfo.core.common.dao.interfaces.IBusiInfoDAO;
import ngves.asiainfo.core.common.ivalues.IBusiInfoValue;
import ngves.asiainfo.core.common.model.InterLogInfo;
import ngves.asiainfo.util.StringUtil;

import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.util.criteria.Criteria;

public class BusiInfoDAOImpl implements IBusiInfoDAO {

	private static final Log log = LogFactory.getLog(BusiInfoDAOImpl.class);

	private static final String INTERFACE_LOG_INFO = "INTERFACE_LOG_INFO";

	private static final String INSERT_INTERLOG_SQL = "INSERT INTO  INTERFACE_LOG_INFO "
			+ "(INTERFACE_LOG_ID ,REQUEST_TIME,CHANNEL_TYPE ,REQUEST_LOG,BIP_CODE) "
			+ "VALUES (? ,SYSDATE,?, EMPTY_CLOB(), ?)";
	private static final String UPDATE_INTERLOG_SQL = "UPDATE INTERFACE_LOG_INFO "
			+ "SET  RESPONSE_LOG = EMPTY_CLOB(), RESPONSE_TIME =SYSDATE " + "WHERE INTERFACE_LOG_ID = ?";
	private static final String QUERY_REQUEST_INTERLOG_SQL = " SELECT REQUEST_LOG FROM INTERFACE_LOG_INFO  WHERE INTERFACE_LOG_ID = ?  FOR UPDATE ";
	private static final String QUERY_RESPONSE_INTERLOG_SQL = " SELECT RESPONSE_LOG FROM INTERFACE_LOG_INFO  WHERE INTERFACE_LOG_ID = ?  FOR UPDATE ";

	//添加新的总业务记录，返回businessid
	public long saveBusinessInfo(IBusiInfoValue businessinfo) throws Exception {
		long busiId = -1;
		if (businessinfo.isNew()) {
			busiId = ((BigDecimal) BusiInfoEngine.getNewId()).longValue();
			businessinfo.setBusiInfoId(busiId);
			if (0 >= businessinfo.getBusiId())
				businessinfo.setBusiId(busiId);

		}
		busiId = businessinfo.getBusiId();
		BusiInfoEngine.save(businessinfo);
		return busiId;

	}

	public IBusiInfoValue[] getBusinessInfo(IBusiInfoValue businessInfoValue) throws Exception {
		return BusiInfoEngine.getBeans(BusiInfoEngine.transfer(businessInfoValue));
	}

	@SuppressWarnings("unchecked")
	public IBusiInfoValue[] getBusinessInfo(String condition, Map parameter) throws Exception {
		return BusiInfoEngine.getBeans(condition, parameter);
	}

	public IBusiInfoValue[] getBusinessInfo(Criteria sql) throws Exception {
		return BusiInfoEngine.getBeans(sql);
	}

	@SuppressWarnings("unchecked")
	public IBusiInfoValue[] getBusinessInfos(long businessId) throws Exception {
		StringBuffer condition = new StringBuffer();
		Map parameter = new HashMap();
		condition.append(IBusiInfoValue.S_BusiId).append("=:").append(IBusiInfoValue.S_BusiId);
		parameter.put(IBusiInfoValue.S_BusiId, businessId);
		return BusiInfoEngine.getBeans(condition.toString(), parameter);
	}

	public void saveBusinessInfos(IBusiInfoValue[] busiInfos) throws Exception {
		Long busiId = 0l;
		for (IBusiInfoValue businessinfo : busiInfos) {
			if (businessinfo.isNew()) {
				busiId = ((BigDecimal) BusiInfoEngine.getNewId()).longValue();
				businessinfo.setBusiInfoId(busiId);
			}
			if (0 >= businessinfo.getBusiId())
				businessinfo.setBusiId(busiId);
		}
		BusiInfoEngine.saveBatch(busiInfos);
	}
	/**
	 * 记录请求日志
	 */
	public long recordRequestInterLog(InterLogInfo loginfo) throws Exception {

		Long logID = ServiceManager.getIdGenerator().getNewId(INTERFACE_LOG_INFO).longValue();
		loginfo.setInterLogId(logID);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		long id = loginfo.getInterLogId();
		String requestLog = loginfo.getRequestLog();
		try {
			conn = ServiceManager.getSession().getConnection();
			pstmt = conn.prepareStatement(INSERT_INTERLOG_SQL);
			pstmt.setLong(1, id);
			pstmt.setString(2, loginfo.getChannelType());
			pstmt.setString(3, loginfo.getBipCode());
			pstmt.executeUpdate();
			pstmt.close();
			if (!StringUtil.isBlank(requestLog)) {
				pstmt = conn.prepareStatement(QUERY_REQUEST_INTERLOG_SQL);
				pstmt.setLong(1, id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					((CLOB) rs.getClob(1)).putChars(requestLog.length(), requestLog.toCharArray());
				}
			}
			return loginfo.getInterLogId();
		} catch (Exception e) {
			log.error("insert INTERFACE_LOG_INFO fail" ,e);
			return 0L;

		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}
	/**
	 * 记录响应日志
	 */
	public long recordResponseInterLog(InterLogInfo loginfo) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		long id = loginfo.getInterLogId();
		String responseLog = loginfo.getResponseLog();

		try {
			if (!StringUtil.isBlank(responseLog)) {
				conn = ServiceManager.getSession().getConnection();
				pstmt = conn.prepareStatement(UPDATE_INTERLOG_SQL);
				pstmt.setLong(1, id);
				int row = pstmt.executeUpdate();
				pstmt.close();
				if (row != 1) {
					log.info("update INTERFACE_LOG_INFO fail：ID:" + id + "has " + row + "row");
					throw new SQLException("update INTERFACE_LOG_INFO fail：ID:" + id + "has " + row + "row");
				}
				pstmt = conn.prepareStatement(QUERY_RESPONSE_INTERLOG_SQL);
				pstmt.setLong(1, id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					((CLOB) rs.getClob(1)).putChars(responseLog.length(), responseLog.toCharArray());
				}
			}
			return loginfo.getInterLogId();
		} catch (Exception e) {
			//e.printStackTrace();
			log.error("update INTERFACE_LOG_INFO fail",e);
			return 0L;

		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

}
