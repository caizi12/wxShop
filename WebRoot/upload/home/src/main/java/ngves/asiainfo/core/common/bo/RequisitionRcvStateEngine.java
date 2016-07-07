package ngves.asiainfo.core.common.bo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.common.ivalues.IRequisitionRcvStateValue;

import com.ai.appframe2.bo.DataContainerFactory;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.util.criteria.Criteria;

@SuppressWarnings("unchecked")
public class RequisitionRcvStateEngine {

	public static RequisitionRcvStateBean[] getBeans(DataContainerInterface dc)
			throws Exception {
		Map ps = dc.getProperties();
		StringBuffer buffer = new StringBuffer();
		Map pList = new HashMap();
		for (java.util.Iterator cc = ps.entrySet().iterator(); cc.hasNext();) {
			Map.Entry e = (Map.Entry) cc.next();
			if (buffer.length() > 0)
				buffer.append(" and ");
			buffer.append(e.getKey().toString() + " = :p_"
					+ e.getKey().toString());
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

	public static RequisitionRcvStateBean getBean(long _RequisitionRcvId)
			throws Exception {
		String condition = "REQUISITION_RCV_ID = " + _RequisitionRcvId;
		Map map = new HashMap();
		RequisitionRcvStateBean[] beans = getBeans(condition, map);
		if (beans != null && beans.length == 1)
			return beans[0];
		else if (beans != null && beans.length > 1) {
			throw new Exception("[错误]根据主键查询出现一条以上记录");
		} else {
			RequisitionRcvStateBean bean = new RequisitionRcvStateBean();
			bean.setRequisitionRcvId(_RequisitionRcvId);
			return bean;
		}
	}

	public static RequisitionRcvStateBean[] getBeans(Criteria sql)
			throws Exception {
		return getBeans(sql, -1, -1, false);
	}

	public static RequisitionRcvStateBean[] getBeans(Criteria sql,
			int startNum, int endNum, boolean isShowFK) throws Exception {
		String[] cols = null;
		String condition = "";
		if (sql != null) {
			cols = (String[]) sql.getSelectColumns().toArray(new String[0]);
			condition = sql.toString();
		}
		return (RequisitionRcvStateBean[]) getBeans(cols, condition, null,
				startNum, endNum, isShowFK);
	}

	public static RequisitionRcvStateBean[] getBeans(String condition,
			Map parameter) throws Exception {
		return getBeans(null, condition, parameter, -1, -1, false);
	}

	public static RequisitionRcvStateBean[] getBeans(String[] cols,
			String condition, Map parameter, int startNum, int endNum,
			boolean isShowFK) throws Exception {
		Connection conn = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			return (RequisitionRcvStateBean[]) ServiceManager.getDataStore()
					.retrieve(conn, RequisitionRcvStateBean.class,
							RequisitionRcvStateBean.getObjectTypeStatic(),
							cols, condition, parameter, startNum, endNum,
							isShowFK, false, null);
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	public static RequisitionRcvStateBean[] getBeans(String[] cols,
			String condition, Map parameter, int startNum, int endNum,
			boolean isShowFK, String[] extendBOAttrs) throws Exception {
		Connection conn = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			return (RequisitionRcvStateBean[]) ServiceManager.getDataStore()
					.retrieve(conn, RequisitionRcvStateBean.class,
							RequisitionRcvStateBean.getObjectTypeStatic(),
							cols, condition, parameter, startNum, endNum,
							isShowFK, false, extendBOAttrs);
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	public static int getBeansCount(String condition, Map parameter)
			throws Exception {
		Connection conn = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			return ServiceManager.getDataStore().retrieveCount(conn,
					RequisitionRcvStateBean.getObjectTypeStatic(), condition,
					parameter, null);
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	public static int getBeansCount(String condition, Map parameter,
			String[] extendBOAttrs) throws Exception {
		Connection conn = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			return ServiceManager.getDataStore().retrieveCount(conn,
					RequisitionRcvStateBean.getObjectTypeStatic(), condition,
					parameter, extendBOAttrs);
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	public static void save(RequisitionRcvStateBean aBean) throws Exception {
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

	public static void save(RequisitionRcvStateBean[] aBeans) throws Exception {
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

	public static void saveBatch(RequisitionRcvStateBean[] aBeans)
			throws Exception {
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

	public static RequisitionRcvStateBean[] getBeansFromQueryBO(String soureBO,
			Map parameter) throws Exception {
		Connection conn = null;
		ResultSet resultset = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			String sql = ServiceManager.getObjectTypeFactory().getInstance(
					soureBO).getMapingEnty();
			resultset = ServiceManager.getDataStore().retrieve(conn, sql,
					parameter);
			return (RequisitionRcvStateBean[]) ServiceManager.getDataStore()
					.crateDtaContainerFromResultSet(
							RequisitionRcvStateBean.class,
							RequisitionRcvStateBean.getObjectTypeStatic(),
							resultset, null, true);

		} catch (Exception e) {
			throw e;
		} finally {
			if (resultset != null)
				resultset.close();
			if (conn != null)
				conn.close();
		}
	}

	public static RequisitionRcvStateBean[] getBeansFromSql(String sql,
			Map parameter) throws Exception {
		Connection conn = null;
		ResultSet resultset = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			resultset = ServiceManager.getDataStore().retrieve(conn, sql,
					parameter);
			return (RequisitionRcvStateBean[]) ServiceManager.getDataStore()
					.crateDtaContainerFromResultSet(
							RequisitionRcvStateBean.class,
							RequisitionRcvStateBean.getObjectTypeStatic(),
							resultset, null, true);

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
		return ServiceManager.getIdGenerator().getNewId(
				RequisitionRcvStateBean.getObjectTypeStatic());
	}

	@SuppressWarnings("deprecation")
	public static java.sql.Timestamp getSysDate() throws Exception {
		return ServiceManager.getIdGenerator().getSysDate(
				RequisitionRcvStateBean.getObjectTypeStatic());
	}

	public static RequisitionRcvStateBean wrap(DataContainerInterface source,
			Map colMatch, boolean canModify) {
		try {
			return (RequisitionRcvStateBean) DataContainerFactory.wrap(source,
					RequisitionRcvStateBean.class, colMatch, canModify);
		} catch (Exception e) {
			if (e.getCause() != null)
				throw new RuntimeException(e.getCause());
			else
				throw new RuntimeException(e);
		}
	}

	public static RequisitionRcvStateBean copy(DataContainerInterface source,
			Map colMatch, boolean canModify) {
		try {
			RequisitionRcvStateBean result = new RequisitionRcvStateBean();
			DataContainerFactory.copy(source, result, colMatch);
			return result;
		} catch (AIException ex) {
			if (ex.getCause() != null)
				throw new RuntimeException(ex.getCause());
			else
				throw new RuntimeException(ex);
		}
	}

	public static RequisitionRcvStateBean transfer(
			IRequisitionRcvStateValue value) {
		if (value == null)
			return null;
		try {
			if (value instanceof RequisitionRcvStateBean) {
				return (RequisitionRcvStateBean) value;
			}
			RequisitionRcvStateBean newBean = new RequisitionRcvStateBean();

			DataContainerFactory.transfer(value, newBean);
			return newBean;
		} catch (Exception ex) {
			if (ex.getCause() != null)
				throw new RuntimeException(ex.getCause());
			else
				throw new RuntimeException(ex);
		}
	}

	public static RequisitionRcvStateBean[] transfer(
			IRequisitionRcvStateValue[] value) {
		if (value == null || value.length == 0)
			return null;

		try {
			if (value instanceof RequisitionRcvStateBean[]) {
				return (RequisitionRcvStateBean[]) value;
			}
			RequisitionRcvStateBean[] newBeans = new RequisitionRcvStateBean[value.length];
			for (int i = 0; i < newBeans.length; i++) {
				newBeans[i] = new RequisitionRcvStateBean();
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

	public static void save(IRequisitionRcvStateValue aValue) throws Exception {
		save(transfer(aValue));
	}

	public static void save(IRequisitionRcvStateValue[] aValues)
			throws Exception {
		save(transfer(aValues));
	}

	public static void saveBatch(IRequisitionRcvStateValue[] aValues)
			throws Exception {
		saveBatch(transfer(aValues));
	}
}
