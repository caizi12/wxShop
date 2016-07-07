package ngves.asiainfo.core.ware.bo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.ware.ivalues.IBusiWareInfoParentValue;

import com.ai.appframe2.bo.DataContainerFactory;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.util.criteria.Criteria;

@SuppressWarnings("unchecked")
public class BusiWareInfoParentEngine {

	public static BusiWareInfoParentBean[] getBeans(DataContainerInterface dc) throws Exception {
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

	public static BusiWareInfoParentBean getBean(long _BusiWareId) throws Exception {
		String condition = "BUSI_WARE_ID = " + _BusiWareId;
		Map map = new HashMap();
		BusiWareInfoParentBean[] beans = getBeans(condition, map);
		if (beans != null && beans.length == 1)
			return beans[0];
		else if (beans != null && beans.length > 1) {
			throw new Exception("[错误]根据主键查询出现一条以上记录");
		} else {
			BusiWareInfoParentBean bean = new BusiWareInfoParentBean();
			bean.setBusiWareId(_BusiWareId);
			return bean;
		}
	}

	public static BusiWareInfoParentBean[] getBeans(Criteria sql) throws Exception {
		return getBeans(sql, -1, -1, false);
	}

	public static BusiWareInfoParentBean[] getBeans(Criteria sql, int startNum, int endNum, boolean isShowFK)
			throws Exception {
		String[] cols = null;
		String condition = "";
		if (sql != null) {
			cols = (String[]) sql.getSelectColumns().toArray(new String[0]);
			condition = sql.toString();
		}
		return (BusiWareInfoParentBean[]) getBeans(cols, condition, null, startNum, endNum, isShowFK);
	}

	public static BusiWareInfoParentBean[] getBeans(String condition, Map parameter) throws Exception {
		return getBeans(null, condition, parameter, -1, -1, false);
	}

	public static BusiWareInfoParentBean[] getBeans(String[] cols, String condition, Map parameter, int startNum,
			int endNum, boolean isShowFK) throws Exception {
		Connection conn = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			return (BusiWareInfoParentBean[]) ServiceManager.getDataStore().retrieve(conn,
					BusiWareInfoParentBean.class, BusiWareInfoParentBean.getObjectTypeStatic(), cols, condition,
					parameter, startNum, endNum, isShowFK, false, null);
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	public static BusiWareInfoParentBean[] getBeans(String[] cols, String condition, Map parameter, int startNum,
			int endNum, boolean isShowFK, String[] extendBOAttrs) throws Exception {
		Connection conn = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			return (BusiWareInfoParentBean[]) ServiceManager.getDataStore().retrieve(conn,
					BusiWareInfoParentBean.class, BusiWareInfoParentBean.getObjectTypeStatic(), cols, condition,
					parameter, startNum, endNum, isShowFK, false, extendBOAttrs);
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	public static int getBeansCount(String condition, Map parameter) throws Exception {
		Connection conn = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			return ServiceManager.getDataStore().retrieveCount(conn, BusiWareInfoParentBean.getObjectTypeStatic(),
					condition, parameter, null);
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	public static int getBeansCount(String condition, Map parameter, String[] extendBOAttrs) throws Exception {
		Connection conn = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			return ServiceManager.getDataStore().retrieveCount(conn, BusiWareInfoParentBean.getObjectTypeStatic(),
					condition, parameter, extendBOAttrs);
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	public static void save(BusiWareInfoParentBean aBean) throws Exception {
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

	public static void save(BusiWareInfoParentBean[] aBeans) throws Exception {
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

	public static void saveBatch(BusiWareInfoParentBean[] aBeans) throws Exception {
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

	public static BusiWareInfoParentBean[] getBeansFromQueryBO(String soureBO, Map parameter) throws Exception {
		Connection conn = null;
		ResultSet resultset = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
			resultset = ServiceManager.getDataStore().retrieve(conn, sql, parameter);
			return (BusiWareInfoParentBean[]) ServiceManager.getDataStore().crateDtaContainerFromResultSet(
					BusiWareInfoParentBean.class, BusiWareInfoParentBean.getObjectTypeStatic(), resultset, null, true);

		} catch (Exception e) {
			throw e;
		} finally {
			if (resultset != null)
				resultset.close();
			if (conn != null)
				conn.close();
		}
	}

	public static BusiWareInfoParentBean[] getBeansFromSql(String sql, Map parameter) throws Exception {
		Connection conn = null;
		ResultSet resultset = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			resultset = ServiceManager.getDataStore().retrieve(conn, sql, parameter);
			return (BusiWareInfoParentBean[]) ServiceManager.getDataStore().crateDtaContainerFromResultSet(
					BusiWareInfoParentBean.class, BusiWareInfoParentBean.getObjectTypeStatic(), resultset, null, true);

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
		return ServiceManager.getIdGenerator().getNewId(BusiWareInfoParentBean.getObjectTypeStatic());
	}

	@SuppressWarnings("deprecation")
	public static java.sql.Timestamp getSysDate() throws Exception {
		return ServiceManager.getIdGenerator().getSysDate(BusiWareInfoParentBean.getObjectTypeStatic());
	}

	public static BusiWareInfoParentBean wrap(DataContainerInterface source, Map colMatch, boolean canModify) {
		try {
			return (BusiWareInfoParentBean) DataContainerFactory.wrap(source, BusiWareInfoParentBean.class, colMatch,
					canModify);
		} catch (Exception e) {
			if (e.getCause() != null)
				throw new RuntimeException(e.getCause());
			else
				throw new RuntimeException(e);
		}
	}

	public static BusiWareInfoParentBean copy(DataContainerInterface source, Map colMatch, boolean canModify) {
		try {
			BusiWareInfoParentBean result = new BusiWareInfoParentBean();
			DataContainerFactory.copy(source, result, colMatch);
			return result;
		} catch (AIException ex) {
			if (ex.getCause() != null)
				throw new RuntimeException(ex.getCause());
			else
				throw new RuntimeException(ex);
		}
	}

	public static BusiWareInfoParentBean transfer(IBusiWareInfoParentValue value) {
		if (value == null)
			return null;
		try {
			if (value instanceof BusiWareInfoParentBean) {
				return (BusiWareInfoParentBean) value;
			}
			BusiWareInfoParentBean newBean = new BusiWareInfoParentBean();

			DataContainerFactory.transfer(value, newBean);
			return newBean;
		} catch (Exception ex) {
			if (ex.getCause() != null)
				throw new RuntimeException(ex.getCause());
			else
				throw new RuntimeException(ex);
		}
	}

	public static BusiWareInfoParentBean[] transfer(IBusiWareInfoParentValue[] value) {
		if (value == null || value.length == 0)
			return null;

		try {
			if (value instanceof BusiWareInfoParentBean[]) {
				return (BusiWareInfoParentBean[]) value;
			}
			BusiWareInfoParentBean[] newBeans = new BusiWareInfoParentBean[value.length];
			for (int i = 0; i < newBeans.length; i++) {
				newBeans[i] = new BusiWareInfoParentBean();
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

	public static void save(IBusiWareInfoParentValue aValue) throws Exception {
		save(transfer(aValue));
	}

	public static void save(IBusiWareInfoParentValue[] aValues) throws Exception {
		save(transfer(aValues));
	}

	public static void saveBatch(IBusiWareInfoParentValue[] aValues) throws Exception {
		saveBatch(transfer(aValues));
	}
}
