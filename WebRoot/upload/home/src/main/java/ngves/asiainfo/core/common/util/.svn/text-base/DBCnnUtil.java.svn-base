package ngves.asiainfo.core.common.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ngves.asiainfo.CommnException;

import com.ai.appframe2.common.ServiceManager;

public class DBCnnUtil {
	/**
	 * 获取数据库连接
	 * 
	 * @return
	 * @throws CommnException
	 */
	public static Connection getDBConnection() throws CommnException {
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
	public static void closeDBConnetion(ResultSet rs, PreparedStatement psmt, Connection conn) throws CommnException {
		try {
			if (null != rs) {
				rs.close();
			}
			if (null != psmt) {
				psmt.close();
			}
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

	/**
	 * 关闭数据库连接
	 * 
	 * @param conn
	 * @throws CommnException
	 */
	public static void closeDBConnetion(Connection conn) throws CommnException {
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
