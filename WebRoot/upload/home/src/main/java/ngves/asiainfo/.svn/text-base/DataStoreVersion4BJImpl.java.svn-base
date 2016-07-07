package ngves.asiainfo;

import java.io.StringReader;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.bo.DataStoreImpl;
import com.ai.appframe2.bo.ObjectTypeNull;
import com.ai.appframe2.bo.ObjectTypeSingleValue;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;

public class DataStoreVersion4BJImpl extends DataStoreImpl {

	private static transient Log log = LogFactory.getLog(DataStoreVersion4BJImpl.class);

	private static final String S_VERSION_KEY = "APP_VERSION";

	public void save(Connection conn, DataContainerInterface dc) throws Exception {
		long start_time = System.currentTimeMillis();
		try {
			if (dc == null)
				return;
			if ((dc.getObjectType() instanceof ObjectTypeNull) || (dc.getObjectType() instanceof ObjectTypeSingleValue))
				throw new AIException("不能对类型为" + dc.getObjectType().getFullName() + "的数据进行保存操作");

			if (dc.isNew())
				insert(conn, dc);
			else if (dc.isDeleted()) {
				delete(conn, dc);
			} else if (dc.isModified()) {
				update(conn, dc);
			}
			dc.setStsToOld();
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
			if (e instanceof DataVersionException) {
				throw new DataVersionException(e);
			} else {
				throw new Exception(e);
			}
		} finally {

			if (System.currentTimeMillis() - start_time > 3000) {
				log.warn("数据保存耗时大于3秒:" + (System.currentTimeMillis() - start_time), new Exception("数据保存的时间过长，需要优化"));
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void insert(Connection conn, DataContainerInterface dc) throws Exception {
		ArrayList plist = new ArrayList();
		ArrayList ptype = new ArrayList();

		ArrayList col_list = new ArrayList();

		StringBuffer sql = new StringBuffer();
		StringBuffer value = new StringBuffer();

		String tableName = dc.getTableName();
		sql.append("insert into ").append(tableName).append("(");
		value.append("values(");

		boolean isfirst = true;
		String key;
		Object obj;
		ObjectType type = dc.getObjectType();
		int intertCount = 0;
		for (java.util.Iterator it = dc.getProperties().entrySet().iterator(); it.hasNext();) {
			Map.Entry me = (Map.Entry) (it.next());
			key = (String) me.getKey();
			if (dc.getObjectType().getProperty(key).getType().equalsIgnoreCase("VIRTUAL") == true) {
				continue;
			}
			obj = me.getValue();

			if (isfirst == true)
				isfirst = false;
			else {
				sql.append(",");
				value.append(",");
			}

			String colName = type.getProperty(key).getMapingColName();
			col_list.add(colName);
			sql.append(colName);

			if (obj == null)
				value.append("null");
			else {
				// 为了减少ORACLE编译时间，全部数据都以参数形式进行传递
				value.append("?");
				ptype.add(dc.getPropertyType(key));
				plist.add(obj);
				if (log.isDebugEnabled()) {
					log.debug(key + " = " + obj);
				}
			}
			intertCount = intertCount + 1;
		}
		if (intertCount == 0) {
			log.debug("没有实际的数据插入，只有虚拟字段的修改！");
			return;
		}

		sql.append(")");
		value.append(")");
		String strSql = sql.toString() + value.toString();
		if (log.isDebugEnabled())
			log.debug(strSql);

		java.sql.PreparedStatement statement = conn.prepareStatement(strSql);
		for (int i = 0; i < plist.size(); i++) {
			if (plist.get(i) instanceof String) {
				String content = (String) plist.get(i);
				if (content.length() > 2000) {
					statement.setCharacterStream(i + 1, new StringReader(content), content.length());
				} else {
					statement.setString(i + 1, content);
				}
				continue;
			}
			DataType.setPrepareStatementParameter(statement, i + 1, (String) ptype.get(i), plist.get(i));
		}

		long startTime = System.currentTimeMillis();

		statement.execute();
		statement.close();

		if (log.isDebugEnabled()) {
			log.debug("线程 " + Thread.currentThread().getName() + " insert time :"
					+ (System.currentTimeMillis() - startTime));
		}
	}

	@SuppressWarnings("unchecked")
	private void delete(Connection conn, DataContainerInterface dc) throws Exception {
		ArrayList plist = new ArrayList();
		ArrayList ptype = new ArrayList();
		// 条件查询sql
		StringBuffer where_sql = new StringBuffer(" where ");
		// 删除的表名
		String tableName = dc.getTableName();

		String key = null;
		Object obj = null;
		boolean isfirst = true;
		for (java.util.Iterator it = dc.getObjectType().getKeyProperties().keySet().iterator(); it.hasNext();) {
			key = (String) it.next();
			obj = dc.getOldObj(key);

			if (isfirst == true)
				isfirst = false;
			else {
				where_sql.append(" and ");
			}
			where_sql.append(key).append(" = ");
			if (obj == null)
				throw new AIException("主键不能为空！");

			// 为了减少ORACLE编译时间，全部数据都以参数形式进行传递
			where_sql.append("?");
			ptype.add(dc.getPropertyType(key));
			plist.add(obj);
			if (log.isDebugEnabled()) {
				log.debug(key + " = " + obj);
			}
		}

		// 删除数据的sql语句
		String strDelete_Sql = (where_sql.insert(0, tableName).insert(0, "delete from ")).toString();
		if (log.isDebugEnabled())
			log.debug(strDelete_Sql);

		java.sql.PreparedStatement statement = conn.prepareStatement(strDelete_Sql);
		for (int i = 0; i < plist.size(); i++) {
			if (plist.get(i) instanceof String) {
				String content = (String) plist.get(i);
				if (content.length() > 2000) {
					statement.setCharacterStream(i + 1, new StringReader(content), content.length());
				} else {
					statement.setString(i + 1, content);
				}
				continue;
			}
			DataType.setPrepareStatementParameter(statement, i + 1, (String) ptype.get(i), plist.get(i));
		}

		long startTime = System.currentTimeMillis();

		statement.execute();
		statement.close();

		if (log.isDebugEnabled()) {
			log.debug("线程 " + Thread.currentThread().getName() + " delete time :"
					+ (System.currentTimeMillis() - startTime));
		}

	}

	@SuppressWarnings("unchecked")
	private void update(Connection conn, DataContainerInterface dc) throws Exception {
		ArrayList plist = new ArrayList();
		ArrayList ptype = new ArrayList();

		// add 版本控制
		boolean isVersion = false;
		if (dc.hasPropertyName(S_VERSION_KEY)) {
			isVersion = true;
		}

		// 修改的sql
		StringBuffer sql_update = new StringBuffer();
		String tableName = dc.getTableName();

		sql_update.append("update ").append(tableName).append(" set ");
		boolean isfirst = true;
		String key;
		Object obj;
		int intertCount = 0;
		for (java.util.Iterator it = dc.getNewProperties().entrySet().iterator(); it.hasNext();) {
			Map.Entry me = (Map.Entry) (it.next());
			key = (String) me.getKey();
			if (dc.getObjectType().getProperty(key).getType().equalsIgnoreCase("VIRTUAL") == true) {
				continue;
			}
			obj = me.getValue();

			if (isfirst == true) {
				isfirst = false;
			} else {
				sql_update.append(",");
			}

			sql_update.append(key).append(" = ");
			if (obj == null)
				sql_update.append("null");
			else {
				sql_update.append("?");
				ptype.add(dc.getPropertyType(key));
				plist.add(obj);
				if (log.isDebugEnabled()) {
					log.debug(key + " = " + obj);
				}
			}

			intertCount = intertCount + 1;
		}
		if (intertCount == 0) {
			log.debug("没有实际的数据插入，只有虚拟字段的修改！");
			return;
		}

		// 修改版本
		if (isVersion == true) {
			sql_update.append(",").append(S_VERSION_KEY).append(" = nvl(").append(S_VERSION_KEY).append(",0)+1 ");
		}
		// end 修改版本

		// --------------------------------where-------------
		isfirst = true;
		// 保存where 条件
		StringBuffer where_sql = new StringBuffer(" where  ");

		Map keys = dc.getKeyProperties();
		if (keys.size() == 0)
			throw new AIException("数据容器没有为主键设置数据,不能进行数据更新！");
		for (java.util.Iterator it = keys.keySet().iterator(); it.hasNext();) {
			key = (String) it.next();
			obj = dc.getOldObj(key);
			if (isfirst == true)
				isfirst = false;
			else {
				where_sql.append(" and ");
			}
			where_sql.append(key).append(" = ");
			if (obj == null)
				throw new AIException("主键不能为空！");

			where_sql.append("?");
			ptype.add(dc.getPropertyType(key));
			plist.add(obj);

			if (log.isDebugEnabled()) {
				log.debug(key + " = " + obj);
			}
		}

		// add 版本控制
		if (isVersion == true) {
			where_sql.append(" and nvl(").append(S_VERSION_KEY).append(",0) = ? ");
			ptype.add(dc.getPropertyType(S_VERSION_KEY));
			Object version = dc.getOldObj(S_VERSION_KEY);
			if (version == null) {
				version = new Long(0);
			}
			plist.add(version);
		}
		// end 版本控制

		String strSql = sql_update.append(where_sql).toString();
		if (log.isDebugEnabled())
			log.debug(strSql);

		java.sql.PreparedStatement statement = conn.prepareStatement(strSql);
		for (int i = 0; i < plist.size(); i++) {
			if (plist.get(i) instanceof String) {
				String content = (String) plist.get(i);
				if (content.length() > 2000) {
					statement.setCharacterStream(i + 1, new StringReader(content), content.length());
				} else
					statement.setString(i + 1, content);
				continue;
			}
			DataType.setPrepareStatementParameter(statement, i + 1, (String) ptype.get(i), plist.get(i));

		}

		long startTime = System.currentTimeMillis();

		try {
			statement.execute();
			if (isVersion == true && statement.getUpdateCount() == 0) {
				Object version = dc.getOldObj(S_VERSION_KEY);
				if (version == null) {
					version = new Long(0);
				}

				throw new DataVersionException("更新数据失败,请检查当前版本(" + version + ")是否已更改!");
			}
            //把更新后的appVersion字段同步到dc(Model)实例中。
            if(isVersion){
                Long version = new Long(0);
                Object _version = dc.getOldObj(S_VERSION_KEY);
                if(_version == null){
                    version = new Long(0);
                }else{
                    if(_version instanceof java.math.BigDecimal){
                        version = ((java.math.BigDecimal)(_version)).longValue();
                    }else{
                        version = (Long)_version;
                    }
                }
                version = new Long(version + 1);
                dc.set(S_VERSION_KEY, version);
            }

		} catch (Throwable t) {
			log.error("sql execute ERROR: " + t.getMessage() + "\n" + strSql, t);
			if (t instanceof DataVersionException) {
				throw new DataVersionException(t);
			} else {
				throw new Exception(t);
			}
		} finally {
			statement.close();
		}

		if (log.isDebugEnabled()) {
			log.debug("线程 " + Thread.currentThread().getName() + " update time :"
					+ (System.currentTimeMillis() - startTime));
		}
	}

	public void saveBatch(Connection conn, DataContainerInterface[] dcs) throws Exception {
		save(conn, dcs);
	}
}
