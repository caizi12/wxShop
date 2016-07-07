package cn.myshop.platform.common.base;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import cn.myshop.platform.common.util.JdbcTypeHandler;
import cn.myshop.platform.common.util.ReflectUtil;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.engine.execution.SqlExecutor;
import com.ibatis.sqlmap.engine.impl.ExtendedSqlMapClient;
import com.ibatis.sqlmap.engine.impl.SqlMapClientImpl;
import com.ibatis.sqlmap.engine.mapping.parameter.ParameterMap;
import com.ibatis.sqlmap.engine.mapping.sql.Sql;
import com.ibatis.sqlmap.engine.mapping.statement.MappedStatement;
import com.ibatis.sqlmap.engine.scope.SessionScope;
import com.ibatis.sqlmap.engine.scope.StatementScope;

/**
 * 公共DAO操作类，代替ibatis的SqlMapClientDaoSupport，并整合jdbcTemplate
 * 
 * @date 2012-08-11 17:24:24
 * @author llliang
 * 
 */

public class BaseDaoTemplate {

	private JdbcTemplate jdbcTemplate;
	private SqlMapClientTemplate ibatisTemplate;
	private SqlExecutor sqlExecutor;

	public void setSqlExecutor(SqlExecutor sqlExecutor) {
		this.sqlExecutor = sqlExecutor;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public SqlMapClientTemplate getIbatisTemplate() {
		return ibatisTemplate;
	}

	public void setIbatisTemplate(SqlMapClientTemplate ibatisTemplate) throws SQLException {
		this.ibatisTemplate = ibatisTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) throws SQLException {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setEnableLimit(boolean enableLimit) {
		if (sqlExecutor instanceof LimitSqlExecutor) {
			((LimitSqlExecutor) sqlExecutor).setEnableLimit(enableLimit);
		}
	}

	@SuppressWarnings("deprecation")
	public void initialize() throws Exception {
		if (sqlExecutor != null) {
			SqlMapClient sqlMapClient = ibatisTemplate.getSqlMapClient();
			if (sqlMapClient instanceof ExtendedSqlMapClient) {
				ReflectUtil.setFieldValue(((ExtendedSqlMapClient) sqlMapClient).getDelegate(), "sqlExecutor", SqlExecutor.class, sqlExecutor);
			}
		}
	}

	/**
	 * 根据ibatis statementId获取查询sql语句，并返回该sql查询结果总记录数
	 * 
	 * @param statementId （statementId 必须为查询类sql）
	 * @param objectParm
	 * @return
	 */
	public int getQueryCount(String statementId, Object objectParm) {
		try {
			SqlMapClientImpl sqlmapClient = (SqlMapClientImpl) getIbatisTemplate().getSqlMapClient();
//			MappedStatement mappedStatement = sqlmapClient.getMappedStatement(statementId);
//			Sql stmtSql = mappedStatement.getSql();
//			
//			SessionScope sessionScope = new SessionScope();
//			sessionScope.setSqlMapClient(sqlmapClient);
//			
//			StatementScope statementScope = new StatementScope(sessionScope);
//			statementScope.setStatement(mappedStatement);
//			String querySql=stmtSql.getSql(statementScope, objectParm);
//			
////			sessionScope.incrementRequestStackDepth();
////			mappedStatement.initRequest(statementScope);
////			String querySql = stmtSql.getSql(statementScope, objectParm).toUpperCase();
//			  ParameterMap parameterMap = stmtSql.getParameterMap(statementScope, objectParm);
//			 Object[] parameters = parameterMap.getParameterObjectValues(statementScope, objectParm);
//			
			String querySql= JdbcTypeHandler.getStatementSql(statementId,objectParm,sqlmapClient);
			 
			// 确保执行的sql为查询类型sql
			if (querySql.trim().indexOf("SELECT") != 0) {
				throw new Exception("The currently executing SQL statement, not the query sql。ibatis statement id："+statementId);
			}
			String countSql = " select count(1) dataCount from (" + querySql + ") t1 ";
			int count = getJdbcTemplate().queryForInt(countSql);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * 基于ibatis的物理分页方法，返回类型为List
	 * 
	 * @param statementId
	 * @param dataGrid
	 * @return List
	 */
	@SuppressWarnings("unchecked")
	public List queryForPageList(String statementId, DataGridModel dataGrid) {
		int page=dataGrid.getPage();
		int pageRows=dataGrid.getPageRows();
		List rows=	getIbatisTemplate().queryForList(statementId,dataGrid.getQueryMap(),(page-1)*pageRows,(page-1)*pageRows+pageRows);
		return rows;
	}

	/**
	 *  基于ibatis的物理分页方法，返回类型为DataGridModel
	 * 
	 * @param statementId
	 * @param dataGrid
	 * @return DataGridModel
	 */
	@SuppressWarnings("unchecked")
	public DataGridModel queryForPageDataGrid(String statementId,DataGridModel dataGrid) {
		dataGrid.setTotal(getQueryCount(statementId,dataGrid.getQueryMap()));
		int page=dataGrid.getPage();
		int pageRows=dataGrid.getPageRows();
		List rows=	getIbatisTemplate().queryForList(statementId,dataGrid.getQueryMap(),(page-1)*pageRows,(page-1)*pageRows+pageRows);
		dataGrid.setRows(rows);
		return dataGrid;
	}

	/**
	 * 使用数据库中的max函数获取指定表中指定字段的最大值
	 * @param tableName
	 * @param columnName
	 * @return Object
	 */
	public Object getColumnMaxValue(String tableName,String columnName){
		if(StringUtils.isBlank(tableName)||StringUtils.isBlank(columnName))
		throw new NullPointerException("parameter tableName or columnName is null");
		Map<String,String> map=new HashMap<String,String>();
		map.put("tableName", tableName.toUpperCase());
		map.put("columnName", columnName.toUpperCase());
	   return getIbatisTemplate().queryForObject("getColumnMaxValue", map);
	}
	
	/**
	 * 使用数据库中的max函数获取指定表中指定字段的最大值,如果没有数据则返回零
	 * @param tableName
	 * @param columnName
	 * @return int
	 */
	public int getColumnMaxValueForInt(String tableName,String columnName){
		Object object=this.getColumnMaxValue(tableName,columnName);
		if(object==null){ 
			return 0;
		 }else{
			return Integer.parseInt(object.toString());
		}
	}
	
	public static void main(String[] ab) {
		String a = "    select * select ";
		int abc = a.trim().indexOf("select");
		System.out.print(abc);
	}
}
