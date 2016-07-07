package ngves.asiainfo.core.mobile.bo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.mobile.ivalues.IMobileFloorInfoValue;

import com.ai.appframe2.bo.DataContainerFactory;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.util.criteria.Criteria;

@SuppressWarnings("unchecked")
public class MobileFloorInfoEngine {

	public static MobileFloorInfoBean[] getBeans(DataContainerInterface dc) throws Exception {
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

	public static MobileFloorInfoBean getBean(long _FloorId) throws Exception {
		String condition = "FLOOR_ID = " + _FloorId;
		Map map = new HashMap();
		MobileFloorInfoBean[] beans = getBeans(condition, map);
		if (beans != null && beans.length == 1)
			return beans[0];
		else if (beans != null && beans.length > 1) {
			throw new Exception("[错误]根据主键查询出现一条以上记录");
		} else {
			MobileFloorInfoBean bean = new MobileFloorInfoBean();
			bean.setFloorId(_FloorId);
			return bean;
		}
	}

	public static MobileFloorInfoBean[] getBeans(Criteria sql) throws Exception {
		return getBeans(sql, -1, -1, false);
	}

	public static MobileFloorInfoBean[] getBeans(Criteria sql, int startNum, int endNum, boolean isShowFK)
			throws Exception {
		String[] cols = null;
		String condition = "";
		if (sql != null) {
			cols = (String[]) sql.getSelectColumns().toArray(new String[0]);
			condition = sql.toString();
		}
		return (MobileFloorInfoBean[]) getBeans(cols, condition, null, startNum, endNum, isShowFK);
	}

	public static MobileFloorInfoBean[] getBeans(String condition, Map parameter) throws Exception {
		return getBeans(null, condition, parameter, -1, -1, false);
	}

	public static MobileFloorInfoBean[] getBeans(String[] cols, String condition, Map parameter, int startNum,
			int endNum, boolean isShowFK) throws Exception {
		Connection conn = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			return (MobileFloorInfoBean[]) ServiceManager.getDataStore().retrieve(conn, MobileFloorInfoBean.class,
					MobileFloorInfoBean.getObjectTypeStatic(), cols, condition, parameter, startNum, endNum, isShowFK,
					false, null);
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	public static MobileFloorInfoBean[] getBeans(String[] cols, String condition, Map parameter, int startNum,
			int endNum, boolean isShowFK, String[] extendBOAttrs) throws Exception {
		Connection conn = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			return (MobileFloorInfoBean[]) ServiceManager.getDataStore().retrieve(conn, MobileFloorInfoBean.class,
					MobileFloorInfoBean.getObjectTypeStatic(), cols, condition, parameter, startNum, endNum, isShowFK,
					false, extendBOAttrs);
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
			return ServiceManager.getDataStore().retrieveCount(conn, MobileFloorInfoBean.getObjectTypeStatic(),
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
			return ServiceManager.getDataStore().retrieveCount(conn, MobileFloorInfoBean.getObjectTypeStatic(),
					condition, parameter, extendBOAttrs);
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	public static void save(MobileFloorInfoBean aBean) throws Exception {
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

	public static void save(MobileFloorInfoBean[] aBeans) throws Exception {
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

	public static void saveBatch(MobileFloorInfoBean[] aBeans) throws Exception {
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

	public static MobileFloorInfoBean[] getBeansFromQueryBO(String soureBO, Map parameter) throws Exception {
		Connection conn = null;
		ResultSet resultset = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
			resultset = ServiceManager.getDataStore().retrieve(conn, sql, parameter);
			return (MobileFloorInfoBean[]) ServiceManager.getDataStore().crateDtaContainerFromResultSet(
					MobileFloorInfoBean.class, MobileFloorInfoBean.getObjectTypeStatic(), resultset, null, true);

		} catch (Exception e) {
			throw e;
		} finally {
			if (resultset != null)
				resultset.close();
			if (conn != null)
				conn.close();
		}
	}

	public static MobileFloorInfoBean[] getBeansFromSql(String sql, Map parameter) throws Exception {
		Connection conn = null;
		ResultSet resultset = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			resultset = ServiceManager.getDataStore().retrieve(conn, sql, parameter);
			return (MobileFloorInfoBean[]) ServiceManager.getDataStore().crateDtaContainerFromResultSet(
					MobileFloorInfoBean.class, MobileFloorInfoBean.getObjectTypeStatic(), resultset, null, true);

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
		return ServiceManager.getIdGenerator().getNewId(MobileFloorInfoBean.getObjectTypeStatic());
	}

	@SuppressWarnings("deprecation")
	public static java.sql.Timestamp getSysDate() throws Exception {
		return ServiceManager.getIdGenerator().getSysDate(MobileFloorInfoBean.getObjectTypeStatic());
	}

	public static MobileFloorInfoBean wrap(DataContainerInterface source, Map colMatch, boolean canModify) {
		try {
			return (MobileFloorInfoBean) DataContainerFactory.wrap(source, MobileFloorInfoBean.class, colMatch,
					canModify);
		} catch (Exception e) {
			if (e.getCause() != null)
				throw new RuntimeException(e.getCause());
			else
				throw new RuntimeException(e);
		}
	}

	public static MobileFloorInfoBean copy(DataContainerInterface source, Map colMatch, boolean canModify) {
		try {
			MobileFloorInfoBean result = new MobileFloorInfoBean();
			DataContainerFactory.copy(source, result, colMatch);
			return result;
		} catch (AIException ex) {
			if (ex.getCause() != null)
				throw new RuntimeException(ex.getCause());
			else
				throw new RuntimeException(ex);
		}
	}

	public static MobileFloorInfoBean transfer(IMobileFloorInfoValue value) {
		if (value == null)
			return null;
		try {
			if (value instanceof MobileFloorInfoBean) {
				return (MobileFloorInfoBean) value;
			}
			MobileFloorInfoBean newBean = new MobileFloorInfoBean();

			DataContainerFactory.transfer(value, newBean);
			return newBean;
		} catch (Exception ex) {
			if (ex.getCause() != null)
				throw new RuntimeException(ex.getCause());
			else
				throw new RuntimeException(ex);
		}
	}

	public static MobileFloorInfoBean[] transfer(IMobileFloorInfoValue[] value) {
		if (value == null || value.length == 0)
			return null;

		try {
			if (value instanceof MobileFloorInfoBean[]) {
				return (MobileFloorInfoBean[]) value;
			}
			MobileFloorInfoBean[] newBeans = new MobileFloorInfoBean[value.length];
			for (int i = 0; i < newBeans.length; i++) {
				newBeans[i] = new MobileFloorInfoBean();
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

	public static void save(IMobileFloorInfoValue aValue) throws Exception {
		save(transfer(aValue));
	}

	public static void save(IMobileFloorInfoValue[] aValues) throws Exception {
		save(transfer(aValues));
	}

	public static void saveBatch(IMobileFloorInfoValue[] aValues) throws Exception {
		saveBatch(transfer(aValues));
	}
}
