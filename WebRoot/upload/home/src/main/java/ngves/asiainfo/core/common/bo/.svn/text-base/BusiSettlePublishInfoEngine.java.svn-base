package ngves.asiainfo.core.common.bo;

import java.util.Map;
import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.Connection;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.util.criteria.Criteria;
import com.ai.appframe2.bo.DataContainerFactory;

import ngves.asiainfo.core.common.ivalues.*;

public class BusiSettlePublishInfoEngine {

    @SuppressWarnings("unchecked")
    public static BusiSettlePublishInfoBean[] getBeans(DataContainerInterface dc) throws Exception {
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

    @SuppressWarnings("unchecked")
    public static BusiSettlePublishInfoBean getBean(long _SeqId) throws Exception {
        String condition = "SEQ_ID = " + _SeqId;
        Map map = new HashMap();
        BusiSettlePublishInfoBean[] beans = getBeans(condition, map);
        if (beans != null && beans.length == 1)
            return beans[0];
        else if (beans != null && beans.length > 1) {
            throw new Exception("[错误]根据主键查询出现一条以上记录");
        } else {
            BusiSettlePublishInfoBean bean = new BusiSettlePublishInfoBean();
            bean.setSeqId(_SeqId);
            return bean;
        }
    }

    public static BusiSettlePublishInfoBean[] getBeans(Criteria sql) throws Exception {
        return getBeans(sql, -1, -1, false);
    }

    @SuppressWarnings("unchecked")
    public static BusiSettlePublishInfoBean[] getBeans(Criteria sql, int startNum, int endNum, boolean isShowFK)
            throws Exception {
        String[] cols = null;
        String condition = "";
        if (sql != null) {
            cols = (String[]) sql.getSelectColumns().toArray(new String[0]);
            condition = sql.toString();
        }
        return (BusiSettlePublishInfoBean[]) getBeans(cols, condition, null, startNum, endNum, isShowFK);
    }

    @SuppressWarnings("unchecked")
    public static BusiSettlePublishInfoBean[] getBeans(String condition, Map parameter) throws Exception {
        return getBeans(null, condition, parameter, -1, -1, false);
    }

    @SuppressWarnings("unchecked")
    public static BusiSettlePublishInfoBean[] getBeans(String[] cols, String condition, Map parameter, int startNum,
            int endNum, boolean isShowFK) throws Exception {
        Connection conn = null;
        try {
            conn = ServiceManager.getSession().getConnection();
            return (BusiSettlePublishInfoBean[]) ServiceManager.getDataStore().retrieve(conn,
                    BusiSettlePublishInfoBean.class, BusiSettlePublishInfoBean.getObjectTypeStatic(), cols, condition,
                    parameter, startNum, endNum, isShowFK, false, null);
        } catch (Exception e) {
            throw e;
        } finally {
            if (conn != null)
                conn.close();
        }
    }

    @SuppressWarnings("unchecked")
    public static BusiSettlePublishInfoBean[] getBeans(String[] cols, String condition, Map parameter, int startNum,
            int endNum, boolean isShowFK, String[] extendBOAttrs) throws Exception {
        Connection conn = null;
        try {
            conn = ServiceManager.getSession().getConnection();
            return (BusiSettlePublishInfoBean[]) ServiceManager.getDataStore().retrieve(conn,
                    BusiSettlePublishInfoBean.class, BusiSettlePublishInfoBean.getObjectTypeStatic(), cols, condition,
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
            return ServiceManager.getDataStore().retrieveCount(conn, BusiSettlePublishInfoBean.getObjectTypeStatic(),
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
            return ServiceManager.getDataStore().retrieveCount(conn, BusiSettlePublishInfoBean.getObjectTypeStatic(),
                    condition, parameter, extendBOAttrs);
        } catch (Exception e) {
            throw e;
        } finally {
            if (conn != null)
                conn.close();
        }
    }

    public static void save(BusiSettlePublishInfoBean aBean) throws Exception {
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

    public static void save(BusiSettlePublishInfoBean[] aBeans) throws Exception {
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

    public static void saveBatch(BusiSettlePublishInfoBean[] aBeans) throws Exception {
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
    public static BusiSettlePublishInfoBean[] getBeansFromQueryBO(String soureBO, Map parameter) throws Exception {
        Connection conn = null;
        ResultSet resultset = null;
        try {
            conn = ServiceManager.getSession().getConnection();
            String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
            resultset = ServiceManager.getDataStore().retrieve(conn, sql, parameter);
            return (BusiSettlePublishInfoBean[]) ServiceManager.getDataStore().crateDtaContainerFromResultSet(
                    BusiSettlePublishInfoBean.class, BusiSettlePublishInfoBean.getObjectTypeStatic(), resultset, null,
                    true);

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
    public static BusiSettlePublishInfoBean[] getBeansFromSql(String sql, Map parameter) throws Exception {
        Connection conn = null;
        ResultSet resultset = null;
        try {
            conn = ServiceManager.getSession().getConnection();
            resultset = ServiceManager.getDataStore().retrieve(conn, sql, parameter);
            return (BusiSettlePublishInfoBean[]) ServiceManager.getDataStore().crateDtaContainerFromResultSet(
                    BusiSettlePublishInfoBean.class, BusiSettlePublishInfoBean.getObjectTypeStatic(), resultset, null,
                    true);

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
        return ServiceManager.getIdGenerator().getNewId(BusiSettlePublishInfoBean.getObjectTypeStatic());
    }

    @SuppressWarnings("deprecation")
    public static java.sql.Timestamp getSysDate() throws Exception {
        return ServiceManager.getIdGenerator().getSysDate(BusiSettlePublishInfoBean.getObjectTypeStatic());
    }

    @SuppressWarnings("unchecked")
    public static BusiSettlePublishInfoBean wrap(DataContainerInterface source, Map colMatch, boolean canModify) {
        try {
            return (BusiSettlePublishInfoBean) DataContainerFactory.wrap(source, BusiSettlePublishInfoBean.class,
                    colMatch, canModify);
        } catch (Exception e) {
            if (e.getCause() != null)
                throw new RuntimeException(e.getCause());
            else
                throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static BusiSettlePublishInfoBean copy(DataContainerInterface source, Map colMatch, boolean canModify) {
        try {
            BusiSettlePublishInfoBean result = new BusiSettlePublishInfoBean();
            DataContainerFactory.copy(source, result, colMatch);
            return result;
        } catch (AIException ex) {
            if (ex.getCause() != null)
                throw new RuntimeException(ex.getCause());
            else
                throw new RuntimeException(ex);
        }
    }

    public static BusiSettlePublishInfoBean transfer(IBusiSettlePublishInfoValue value) {
        if (value == null)
            return null;
        try {
            if (value instanceof BusiSettlePublishInfoBean) {
                return (BusiSettlePublishInfoBean) value;
            }
            BusiSettlePublishInfoBean newBean = new BusiSettlePublishInfoBean();

            DataContainerFactory.transfer(value, newBean);
            return newBean;
        } catch (Exception ex) {
            if (ex.getCause() != null)
                throw new RuntimeException(ex.getCause());
            else
                throw new RuntimeException(ex);
        }
    }

    public static BusiSettlePublishInfoBean[] transfer(IBusiSettlePublishInfoValue[] value) {
        if (value == null || value.length == 0)
            return null;

        try {
            if (value instanceof BusiSettlePublishInfoBean[]) {
                return (BusiSettlePublishInfoBean[]) value;
            }
            BusiSettlePublishInfoBean[] newBeans = new BusiSettlePublishInfoBean[value.length];
            for (int i = 0; i < newBeans.length; i++) {
                newBeans[i] = new BusiSettlePublishInfoBean();
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

    public static void save(IBusiSettlePublishInfoValue aValue) throws Exception {
        save(transfer(aValue));
    }

    public static void save(IBusiSettlePublishInfoValue[] aValues) throws Exception {
        save(transfer(aValues));
    }

    public static void saveBatch(IBusiSettlePublishInfoValue[] aValues) throws Exception {
        saveBatch(transfer(aValues));
    }
}
