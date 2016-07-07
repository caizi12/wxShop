package ngves.asiainfo.core.viphall.bo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.viphall.ivalues.IQBOVipHallWareInfoValue;

import com.ai.appframe2.bo.DataContainerFactory;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.util.criteria.Criteria;

public class QBOVipHallWareInfoEngine {

	@SuppressWarnings("unchecked")
	public static QBOVipHallWareInfoBean[] getBeans(DataContainerInterface dc) throws Exception {
		Map ps = dc.getProperties();
		StringBuffer buffer = new StringBuffer();
		Map pList = new HashMap();
		for (java.util.Iterator cc = ps.entrySet().iterator(); cc.hasNext();) {
			Map.Entry e = (Map.Entry) cc.next();
			if (buffer.length() > 0)
				buffer.append(" and ");
			buffer.append(e.getKey().toString() + " = :p_" + e.getKey().toString());
			pList.put("p_" + e.getKey().toString(), e.getValue());
		}
		Connection conn = ServiceManager.getSession().getConnection();
		try {
			return getBeans(buffer.toString(), pList);
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	public static QBOVipHallWareInfoBean[] getBeans(Criteria sql) throws Exception {
		return getBeans(sql, -1, -1, false);
	}

	@SuppressWarnings("unchecked")
	public static QBOVipHallWareInfoBean[] getBeans(Criteria sql, int startNum, int endNum, boolean isShowFK)
			throws Exception {
		String[] cols = null;
		String condition = "";
		if (sql != null) {
			cols = (String[]) sql.getSelectColumns().toArray(new String[0]);
			condition = sql.toString();
		}
		return (QBOVipHallWareInfoBean[]) getBeans(cols, condition, null, startNum, endNum, isShowFK);
	}

	@SuppressWarnings("unchecked")
	public static QBOVipHallWareInfoBean[] getBeans(String condition, Map parameter) throws Exception {
		return getBeans(null, condition, parameter, -1, -1, false);
	}

	@SuppressWarnings("unchecked")
	public static QBOVipHallWareInfoBean[] getBeans(String[] cols, String condition, Map parameter, int startNum,
			int endNum, boolean isShowFK) throws Exception {
		Connection conn = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			return (QBOVipHallWareInfoBean[]) ServiceManager.getDataStore().retrieve(conn,
					QBOVipHallWareInfoBean.class, QBOVipHallWareInfoBean.getObjectTypeStatic(), cols, condition,
					parameter, startNum, endNum, isShowFK, false, null);
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	@SuppressWarnings("unchecked")
	public static QBOVipHallWareInfoBean[] getBeans(String[] cols, String condition, Map parameter, int startNum,
			int endNum, boolean isShowFK, String[] extendBOAttrs) throws Exception {
		Connection conn = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			return (QBOVipHallWareInfoBean[]) ServiceManager.getDataStore().retrieve(conn,
					QBOVipHallWareInfoBean.class, QBOVipHallWareInfoBean.getObjectTypeStatic(), cols, condition,
					parameter, startNum, endNum, isShowFK, false, extendBOAttrs);
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	@SuppressWarnings("unchecked")
	public static int getBeansCount(String condition, Map parameter) throws Exception {
		Connection conn = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			return ServiceManager.getDataStore().retrieveCount(conn, QBOVipHallWareInfoBean.getObjectTypeStatic(),
					condition, parameter, null);
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	@SuppressWarnings("unchecked")
	public static int getBeansCount(String condition, Map parameter, String[] extendBOAttrs) throws Exception {
		Connection conn = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			return ServiceManager.getDataStore().retrieveCount(conn, QBOVipHallWareInfoBean.getObjectTypeStatic(),
					condition, parameter, extendBOAttrs);
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	public static void save(QBOVipHallWareInfoBean aBean) throws Exception {
		Connection conn = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			ServiceManager.getDataStore().save(conn, aBean);
		} catch (Exception e) {
			throw e;
		} finally {
			conn.close();
		}
	}

	public static void save(QBOVipHallWareInfoBean[] aBeans) throws Exception {
		Connection conn = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			ServiceManager.getDataStore().save(conn, aBeans);
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	public static void saveBatch(QBOVipHallWareInfoBean[] aBeans) throws Exception {
		Connection conn = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			ServiceManager.getDataStore().saveBatch(conn, aBeans);
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	@SuppressWarnings("unchecked")
	public static QBOVipHallWareInfoBean[] getBeansFromQueryBO(String soureBO, Map parameter) throws Exception {
		Connection conn = null;
		ResultSet resultset = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
			resultset = ServiceManager.getDataStore().retrieve(conn, sql, parameter);
			return (QBOVipHallWareInfoBean[]) ServiceManager.getDataStore().crateDtaContainerFromResultSet(
					QBOVipHallWareInfoBean.class, QBOVipHallWareInfoBean.getObjectTypeStatic(), resultset, null, true);

		} catch (Exception e) {
			throw e;
		} finally {
			if (resultset != null)
				resultset.close();
			if (conn != null)
				conn.close();
		}
	}

	@SuppressWarnings("unchecked")
	public static QBOVipHallWareInfoBean[] getBeansFromSql(String sql, Map parameter) throws Exception {
		Connection conn = null;
		ResultSet resultset = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			resultset = ServiceManager.getDataStore().retrieve(conn, sql, parameter);
			return (QBOVipHallWareInfoBean[]) ServiceManager.getDataStore().crateDtaContainerFromResultSet(
					QBOVipHallWareInfoBean.class, QBOVipHallWareInfoBean.getObjectTypeStatic(), resultset, null, true);

		} catch (Exception e) {
			throw e;
		} finally {
			if (resultset != null)
				resultset.close();
			if (conn != null)
				conn.close();
		}
	}

	public static java.math.BigDecimal getNewId() throws Exception {
		return ServiceManager.getIdGenerator().getNewId(QBOVipHallWareInfoBean.getObjectTypeStatic());
	}

	@SuppressWarnings("deprecation")
	public static java.sql.Timestamp getSysDate() throws Exception {
		return ServiceManager.getIdGenerator().getSysDate(QBOVipHallWareInfoBean.getObjectTypeStatic());
	}

	@SuppressWarnings("unchecked")
	public static QBOVipHallWareInfoBean wrap(DataContainerInterface source, Map colMatch, boolean canModify) {
		try {
			return (QBOVipHallWareInfoBean) DataContainerFactory.wrap(source, QBOVipHallWareInfoBean.class, colMatch,
					canModify);
		} catch (Exception e) {
			if (e.getCause() != null)
				throw new RuntimeException(e.getCause());
			else
				throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static QBOVipHallWareInfoBean copy(DataContainerInterface source, Map colMatch, boolean canModify) {
		try {
			QBOVipHallWareInfoBean result = new QBOVipHallWareInfoBean();
			DataContainerFactory.copy(source, result, colMatch);
			return result;
		} catch (AIException ex) {
			if (ex.getCause() != null)
				throw new RuntimeException(ex.getCause());
			else
				throw new RuntimeException(ex);
		}
	}

	public static QBOVipHallWareInfoBean transfer(IQBOVipHallWareInfoValue value) {
		if (value == null)
			return null;
		try {
			if (value instanceof QBOVipHallWareInfoBean) {
				return (QBOVipHallWareInfoBean) value;
			}
			QBOVipHallWareInfoBean newBean = new QBOVipHallWareInfoBean();

			DataContainerFactory.transfer(value, newBean);
			return newBean;
		} catch (Exception ex) {
			if (ex.getCause() != null)
				throw new RuntimeException(ex.getCause());
			else
				throw new RuntimeException(ex);
		}
	}

	public static QBOVipHallWareInfoBean[] transfer(IQBOVipHallWareInfoValue[] value) {
		if (value == null || value.length == 0)
			return null;

		try {
			if (value instanceof QBOVipHallWareInfoBean[]) {
				return (QBOVipHallWareInfoBean[]) value;
			}
			QBOVipHallWareInfoBean[] newBeans = new QBOVipHallWareInfoBean[value.length];
			for (int i = 0; i < newBeans.length; i++) {
				newBeans[i] = new QBOVipHallWareInfoBean();
				DataContainerFactory.transfer(value[i], newBeans[i]);
			}
			return newBeans;
		} catch (Exception ex) {
			if (ex.getCause() != null)
				throw new RuntimeException(ex.getCause());
			else
				throw new RuntimeException(ex);
		}
	}

	public static void save(IQBOVipHallWareInfoValue aValue) throws Exception {
		save(transfer(aValue));
	}

	public static void save(IQBOVipHallWareInfoValue[] aValues) throws Exception {
		save(transfer(aValues));
	}

	public static void saveBatch(IQBOVipHallWareInfoValue[] aValues) throws Exception {
		saveBatch(transfer(aValues));
	}
}
