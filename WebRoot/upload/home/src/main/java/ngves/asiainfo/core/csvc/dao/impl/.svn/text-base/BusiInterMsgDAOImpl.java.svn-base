/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

import oracle.sql.CLOB;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.ServiceManager;

import ngves.asiainfo.core.common.model.BusiInterMsg;
import ngves.asiainfo.core.common.util.InterMsgBusiUtil;
import ngves.asiainfo.core.csvc.dao.interfaces.IBusiInterMsgDAO;

/**
 * <p>报文流水表DAO的默认实现类<br/>
 * <code>ClobInfoDAOImpl</code>类中的保存操作业务判断太多和该保存方法可重构性不高,故不重构。
 * 
 * @author ggs
 */
public class BusiInterMsgDAOImpl implements IBusiInterMsgDAO {

	private static final Log log = LogFactory.getLog(BusiInterMsgDAOImpl.class);

	private static final String INSERT_INTERMSG_SQL = " INSERT INTO BUSI_INTER_MSG(BUSI_ID,OPT_DATE,MSG,ACTION_TYPE,SEND_REPLY_RESULT) VALUES(?,?,EMPTY_CLOB(),?,?) ";
	private static final String QUERY_INTERMSG_SQL = " SELECT MSG FROM BUSI_INTER_MSG  WHERE BUSI_ID = ?  FOR UPDATE ";

	public long saveBusiInterMsg(BusiInterMsg busiInterMsg) throws Exception {
		if(busiInterMsg.getBusiId() <= 0 ) {
			busiInterMsg.setBusiId(InterMsgBusiUtil.getBusiInterMsgId());
		}
		long s1 = System.currentTimeMillis();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String msg = busiInterMsg.getMsg();
		long id = busiInterMsg.getBusiId();
		try {
			conn = ServiceManager.getSession().getConnection();
			pstmt = conn.prepareStatement(INSERT_INTERMSG_SQL);
			pstmt.setLong(1, id);
			pstmt.setTimestamp(2, new Timestamp(new Date().getTime()));
			pstmt.setString(3, busiInterMsg.getActionType());
			pstmt.setString(4, busiInterMsg.getSendReplyResult());
			pstmt.executeUpdate();
			pstmt.close();
			if (!StringUtils.isBlank(msg)) {
				pstmt = conn.prepareStatement(QUERY_INTERMSG_SQL);
				pstmt.setLong(1, id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					((CLOB) rs.getClob(1)).putChars(msg.length(), msg.toCharArray());
				}
			}
			return busiInterMsg.getBusiId();
		} catch (Exception e) {
			throw e;
		} finally {
			if(rs != null ) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
			log.info(" saveBusiInterMsg execute by id:= " + id + " actionType := "
					+ busiInterMsg.getActionType() + " is cost :=" + (System.currentTimeMillis() - s1));
		}
	}
}
