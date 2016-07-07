package ngves.asiainfo.core.ware.bo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.ware.ivalues.IWarePCRltValue;

import com.ai.appframe2.bo.DataContainerFactory;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.util.criteria.Criteria;

@SuppressWarnings("unchecked")
public class WarePCRltEngine {

	public static WarePCRltBean[] getBeans(DataContainerInterface dc) throws Exception {
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

	public static WarePCRltBean getBean(long _WarePcRltId) throws Exception {
		String condition = "WARE_PC_RLT_ID = " + _WarePcRltId;
		Map map = new HashMap();
		WarePCRltBean[] beans = getBeans(condition, map);
		if (beans != null && beans.length == 1)
			return beans[0];
		else if (beans != null && beans.length > 1) {
			throw new Exception("[错误]根据主键查询出现一条以上记录");
		} else {
			WarePCRltBean bean = new WarePCRltBean();
			bean.setWarePcRltId(_WarePcRltId);
			return bean;
		}
	}

	public static WarePCRltBean[] getBeans(Criteria sql) throws Exception {
		return getBeans(sql, -1, -1, false);
	}

	public static WarePCRltBean[] getBeans(Criteria sql, int startNum, int endNum, boolean isShowFK) throws Exception {
		String[] cols = null;
		String condition = "";
		if (sql != null) {
			cols = (String[]) sql.getSelectColumns().toArray(new String[0]);
			condition = sql.toString();
		}
		return (WarePCRltBean[]) getBeans(cols, condition, null, startNum, endNum, isShowFK);
	}

	public static WarePCRltBean[] getBeans(String condition, Map parameter) throws Exception {
		return getBeans(null, condition, parameter, -1, -1, false);
	}

	public static WarePCRltBean[] getBeans(String[] cols, String condition, Map parameter, int startNum, int endNum,
			boolean isShowFK) throws Exception {
		Connection conn = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			return (WarePCRltBean[]) ServiceManager.getDataStore().retrieve(conn, WarePCRltBean.class,
					WarePCRltBean.getObjectTypeStatic(), cols, condition, parameter, startNum, endNum, isShowFK, false,
					null);
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	public static WarePCRltBean[] getBeans(String[] cols, String condition, Map parameter, int startNum, int endNum,
			boolean isShowFK, String[] extendBOAttrs) throws Exception {
		Connection conn = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			return (WarePCRltBean[]) ServiceManager.getDataStore().retrieve(conn, WarePCRltBean.class,
					WarePCRltBean.getObjectTypeStatic(), cols, condition, parameter, startNum, endNum, isShowFK, false,
					extendBOAttrs);
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
			return ServiceManager.getDataStore().retrieveCount(conn, WarePCRltBean.getObjectTypeStatic(), condition,
					parameter, null);
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
			return ServiceManager.getDataStore().retrieveCount(conn, WarePCRltBean.getObjectTypeStatic(), condition,
					parameter, extendBOAttrs);
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	public static void save(WarePCRltBean aBean) throws Exception {
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

	public static void save(WarePCRltBean[] aBeans) throws Exception {
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

	public static void saveBatch(WarePCRltBean[] aBeans) throws Exception {
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

	public static WarePCRltBean[] getBeansFromQueryBO(String soureBO, Map parameter) throws Exception {
		Connection conn = null;
		ResultSet resultset = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
			resultset = ServiceManager.getDataStore().retrieve(conn, sql, parameter);
			return (WarePCRltBean[]) ServiceManager.getDataStore().crateDtaContainerFromResultSet(WarePCRltBean.class,
					WarePCRltBean.getObjectTypeStatic(), resultset, null, true);

		} catch (Exception e) {
			throw e;
		} finally {
			if (resultset != null)
				resultset.close();
			if (conn != null)
				conn.close();
		}
	}

	public static WarePCRltBean[] getBeansFromSql(String sql, Map parameter) throws Exception {
		Connection conn = null;
		ResultSet resultset = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			resultset = ServiceManager.getDataStore().retrieve(conn, sql, parameter);
			return (WarePCRltBean[]) ServiceManager.getDataStore().crateDtaContainerFromResultSet(WarePCRltBean.class,
					WarePCRltBean.getObjectTypeStatic(), resultset, null, true);

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
		return ServiceManager.getIdGenerator().getNewId(WarePCRltBean.getObjectTypeStatic());
	}

	@SuppressWarnings("deprecation")
	public static java.sql.Timestamp getSysDate() throws Exception {
		return ServiceManager.getIdGenerator().getSysDate(WarePCRltBean.getObjectTypeStatic());
	}

	public static WarePCRltBean wrap(DataContainerInterface source, Map colMatch, boolean canModify) {
		try {
			return (WarePCRltBean) DataContainerFactory.wrap(source, WarePCRltBean.class, colMatch, canModify);
		} catch (Exception e) {
			if (e.getCause() != null)
				throw new RuntimeException(e.getCause());
			else
				throw new RuntimeException(e);
		}
	}

	public static WarePCRltBean copy(DataContainerInterface source, Map colMatch, boolean canModify) {
		try {
			WarePCRltBean result = new WarePCRltBean();
			DataContainerFactory.copy(source, result, colMatch);
			return result;
		} catch (AIException ex) {
			if (ex.getCause() != null)
				throw new RuntimeException(ex.getCause());
			else
				throw new RuntimeException(ex);
		}
	}

	public static WarePCRltBean transfer(IWarePCRltValue value) {
		if (value == null)
			return null;
		try {
			if (value instanceof WarePCRltBean) {
				return (WarePCRltBean) value;
			}
			WarePCRltBean newBean = new WarePCRltBean();

			DataContainerFactory.transfer(value, newBean);
			return newBean;
		} catch (Exception ex) {
			if (ex.getCause() != null)
				throw new RuntimeException(ex.getCause());
			else
				throw new RuntimeException(ex);
		}
	}

	public static WarePCRltBean[] transfer(IWarePCRltValue[] value) {
		if (value == null || value.length == 0)
			return null;

		try {
			if (value instanceof WarePCRltBean[]) {
				return (WarePCRltBean[]) value;
			}
			WarePCRltBean[] newBeans = new WarePCRltBean[value.length];
			for (int i = 0; i < newBeans.length; i++) {
				newBeans[i] = new WarePCRltBean();
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

	public static void save(IWarePCRltValue aValue) throws Exception {
		save(transfer(aValue));
	}

	public static void save(IWarePCRltValue[] aValues) throws Exception {
		save(transfer(aValues));
	}

	public static void saveBatch(IWarePCRltValue[] aValues) throws Exception {
		saveBatch(transfer(aValues));
	}
}
