package ngves.asiainfo.core.rechargepoints.bo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.rechargepoints.ivalues.IBusiRechargeFileValue;

import com.ai.appframe2.bo.DataContainerFactory;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.util.criteria.Criteria;

@SuppressWarnings("unchecked")
public class BusiRechargeFileEngine {

	public static BusiRechargeFileBean[] getBeans(DataContainerInterface dc) throws Exception {
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

	public static BusiRechargeFileBean getBean(String _BusiRechargeFileId) throws Exception {
		String condition = "BUSI_RECHARGE_FILE_ID = '" + _BusiRechargeFileId + "'";
		Map map = new HashMap();
		BusiRechargeFileBean[] beans = getBeans(condition, map);
		if (beans != null && beans.length == 1)
			return beans[0];
		else if (beans != null && beans.length > 1) {
			throw new Exception("[错误]根据主键查询出现一条以上记录");
		} else {
			BusiRechargeFileBean bean = new BusiRechargeFileBean();
			bean.setBusiRechargeFileId(_BusiRechargeFileId);
			return bean;
		}
	}

	public static BusiRechargeFileBean[] getBeans(Criteria sql) throws Exception {
		return getBeans(sql, -1, -1, false);
	}

	public static BusiRechargeFileBean[] getBeans(Criteria sql, int startNum, int endNum, boolean isShowFK)
			throws Exception {
		String[] cols = null;
		String condition = "";
		if (sql != null) {
			cols = (String[]) sql.getSelectColumns().toArray(new String[0]);
			condition = sql.toString();
		}
		return (BusiRechargeFileBean[]) getBeans(cols, condition, null, startNum, endNum, isShowFK);
	}

	public static BusiRechargeFileBean[] getBeans(String condition, Map parameter) throws Exception {
		return getBeans(null, condition, parameter, -1, -1, false);
	}

	public static BusiRechargeFileBean[] getBeans(String[] cols, String condition, Map parameter, int startNum,
			int endNum, boolean isShowFK) throws Exception {
		Connection conn = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			return (BusiRechargeFileBean[]) ServiceManager.getDataStore().retrieve(conn, BusiRechargeFileBean.class,
					BusiRechargeFileBean.getObjectTypeStatic(), cols, condition, parameter, startNum, endNum, isShowFK,
					false, null);
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	public static BusiRechargeFileBean[] getBeans(String[] cols, String condition, Map parameter, int startNum,
			int endNum, boolean isShowFK, String[] extendBOAttrs) throws Exception {
		Connection conn = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			return (BusiRechargeFileBean[]) ServiceManager.getDataStore().retrieve(conn, BusiRechargeFileBean.class,
					BusiRechargeFileBean.getObjectTypeStatic(), cols, condition, parameter, startNum, endNum, isShowFK,
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
			return ServiceManager.getDataStore().retrieveCount(conn, BusiRechargeFileBean.getObjectTypeStatic(),
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
			return ServiceManager.getDataStore().retrieveCount(conn, BusiRechargeFileBean.getObjectTypeStatic(),
					condition, parameter, extendBOAttrs);
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	public static void save(BusiRechargeFileBean aBean) throws Exception {
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

	public static void save(BusiRechargeFileBean[] aBeans) throws Exception {
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

	public static void saveBatch(BusiRechargeFileBean[] aBeans) throws Exception {
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

	public static BusiRechargeFileBean[] getBeansFromQueryBO(String soureBO, Map parameter) throws Exception {
		Connection conn = null;
		ResultSet resultset = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
			resultset = ServiceManager.getDataStore().retrieve(conn, sql, parameter);
			return (BusiRechargeFileBean[]) ServiceManager.getDataStore().crateDtaContainerFromResultSet(
					BusiRechargeFileBean.class, BusiRechargeFileBean.getObjectTypeStatic(), resultset, null, true);

		} catch (Exception e) {
			throw e;
		} finally {
			if (resultset != null)
				resultset.close();
			if (conn != null)
				conn.close();
		}
	}

	public static BusiRechargeFileBean[] getBeansFromSql(String sql, Map parameter) throws Exception {
		Connection conn = null;
		ResultSet resultset = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			resultset = ServiceManager.getDataStore().retrieve(conn, sql, parameter);
			return (BusiRechargeFileBean[]) ServiceManager.getDataStore().crateDtaContainerFromResultSet(
					BusiRechargeFileBean.class, BusiRechargeFileBean.getObjectTypeStatic(), resultset, null, true);

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
		return ServiceManager.getIdGenerator().getNewId(BusiRechargeFileBean.getObjectTypeStatic());
	}

	@SuppressWarnings("deprecation")
	public static java.sql.Timestamp getSysDate() throws Exception {
		return ServiceManager.getIdGenerator().getSysDate(BusiRechargeFileBean.getObjectTypeStatic());
	}

	public static BusiRechargeFileBean wrap(DataContainerInterface source, Map colMatch, boolean canModify) {
		try {
			return (BusiRechargeFileBean) DataContainerFactory.wrap(source, BusiRechargeFileBean.class, colMatch,
					canModify);
		} catch (Exception e) {
			if (e.getCause() != null)
				throw new RuntimeException(e.getCause());
			else
				throw new RuntimeException(e);
		}
	}

	public static BusiRechargeFileBean copy(DataContainerInterface source, Map colMatch, boolean canModify) {
		try {
			BusiRechargeFileBean result = new BusiRechargeFileBean();
			DataContainerFactory.copy(source, result, colMatch);
			return result;
		} catch (AIException ex) {
			if (ex.getCause() != null)
				throw new RuntimeException(ex.getCause());
			else
				throw new RuntimeException(ex);
		}
	}

	public static BusiRechargeFileBean transfer(IBusiRechargeFileValue value) {
		if (value == null)
			return null;
		try {
			if (value instanceof BusiRechargeFileBean) {
				return (BusiRechargeFileBean) value;
			}
			BusiRechargeFileBean newBean = new BusiRechargeFileBean();

			DataContainerFactory.transfer(value, newBean);
			return newBean;
		} catch (Exception ex) {
			if (ex.getCause() != null)
				throw new RuntimeException(ex.getCause());
			else
				throw new RuntimeException(ex);
		}
	}

	public static BusiRechargeFileBean[] transfer(IBusiRechargeFileValue[] value) {
		if (value == null || value.length == 0)
			return null;

		try {
			if (value instanceof BusiRechargeFileBean[]) {
				return (BusiRechargeFileBean[]) value;
			}
			BusiRechargeFileBean[] newBeans = new BusiRechargeFileBean[value.length];
			for (int i = 0; i < newBeans.length; i++) {
				newBeans[i] = new BusiRechargeFileBean();
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

	public static void save(IBusiRechargeFileValue aValue) throws Exception {
		save(transfer(aValue));
	}

	public static void save(IBusiRechargeFileValue[] aValues) throws Exception {
		save(transfer(aValues));
	}

	public static void saveBatch(IBusiRechargeFileValue[] aValues) throws Exception {
		saveBatch(transfer(aValues));
	}
}
