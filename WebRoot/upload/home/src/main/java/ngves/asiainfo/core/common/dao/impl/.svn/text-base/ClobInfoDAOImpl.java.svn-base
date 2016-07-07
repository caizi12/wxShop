/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.common.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oracle.sql.CLOB;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.ServiceManager;

import ngves.asiainfo.core.common.dao.interfaces.IClobInfoDAO;

/**
 * @author wzg
 * 
 */
public class ClobInfoDAOImpl implements IClobInfoDAO {
	private static final Log log = LogFactory.getLog(ClobInfoDAOImpl.class);

	private static final String INSERT_CLOB_SQL = " INSERT INTO CLOB_INFO(ID,TABLE_NAME,CONTENT) VALUES(?,?,EMPTY_CLOB()) ";
	private static final String UPDATE_CLOB_SQL = " UPDATE CLOB_INFO SET CONTENT=EMPTY_CLOB() WHERE ID = ? AND TABLE_NAME = ? ";
	private static final String QUERY_CONTENT_SQL = " SELECT C.CONTENT FROM CLOB_INFO C WHERE C.ID = ? AND C.TABLE_NAME = ? ";
	private static final String SQL_FOR_UPDATE = " FOR UPDATE ";
	private static final String DELETE_CLOB_SQL = "DELETE FROM CLOB_INFO C WHERE C.ID = ? AND C.TABLE_NAME = ? ";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ngves.asiainfo.core.common.dao.interfaces.IClobInfoDAO#getContent(long,
	 * java.lang.String)
	 */
	public String getContent(long id, String tableName) throws Exception {
		long s1 = System.currentTimeMillis();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			log.info(" execute GETCONTENT_SQL sql id := " + id + " tableName := " + tableName);
			conn = ServiceManager.getSession().getConnection();
			pstmt = conn.prepareStatement(QUERY_CONTENT_SQL);
			pstmt.setLong(1, id);
			pstmt.setString(2, tableName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				CLOB clob = (CLOB) rs.getClob(1);
				char[] content = new char[(int) clob.length()];
				// 注意是从1开始读
				clob.getChars(1L, (int) clob.length(), content);
				return new String(content);
			}
			// 不存在该记录返回null
			return null;
		} catch (Exception e) {
			throw e;
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
			log.info(" getContent execute by id:= " + id + " tableName := " + tableName + " is cost :="
					+ (System.currentTimeMillis() - s1));
		}
	}

	/**
	 * 依赖业务层的事务提交
	 */
	public boolean saveClobInfo(long id, String tableName, String content) throws Exception {
		long s1 = System.currentTimeMillis();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			log.info(" execute SAVECLOBINFO_SQL sql id := " + id + " tableName := " + tableName);
			// 还得先查询是否存在记录
			conn = ServiceManager.getSession().getConnection();
			pstmt = conn.prepareStatement(QUERY_CONTENT_SQL);
			pstmt.setLong(1, id);
			pstmt.setString(2, tableName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// 更新
				pstmt.close();
				pstmt = conn.prepareStatement(UPDATE_CLOB_SQL);
				pstmt.setLong(1, id);
				pstmt.setString(2, tableName);
				pstmt.executeUpdate();
			} else {
				pstmt.close();
				pstmt = conn.prepareStatement(INSERT_CLOB_SQL);
				pstmt.setLong(1, id);
				pstmt.setString(2, tableName);
				pstmt.executeUpdate();
			}
			pstmt.close();
			if (!StringUtils.isBlank(content)) {
				pstmt = conn.prepareStatement(QUERY_CONTENT_SQL + SQL_FOR_UPDATE);
				pstmt.setLong(1, id);
				pstmt.setString(2, tableName);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					((CLOB) rs.getClob(1)).putChars(content.length(), content.toCharArray());
				}
			}
			return true;
		} catch (Exception e) {
			throw e;
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
			log.info(" saveClobInfo execute by id:= " + id + " tableName := " + tableName + " is cost :="
					+ (System.currentTimeMillis() - s1));
		}

	}

	public boolean deleteClobInfo(long id, String tableName) throws Exception {
		long s1 = System.currentTimeMillis();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			log.info(" execute DELETECLOBINFO_SQL sql id := " + id + " tableName := " + tableName);
			conn = ServiceManager.getSession().getConnection();
			pstmt = conn.prepareStatement(DELETE_CLOB_SQL);
			pstmt.setLong(1, id);
			pstmt.setString(2, tableName);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
			log.info(" deleteClobInfo execute by id:= " + id + " tableName := " + tableName + " is cost :="
					+ (System.currentTimeMillis() - s1));
		}
	}

	public static void main(String[] args) {
		String cont = "sdfsdfsdfsdfsdfsf我们的日志进行测试啊";
		System.out.println(" cont length := " + cont.length() + " cont char[] length " + cont.toCharArray().length);
	}
}
