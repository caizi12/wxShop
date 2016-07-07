package cn.frame.platform.common.util;

import com.ibatis.sqlmap.engine.impl.SqlMapClientImpl;
import com.ibatis.sqlmap.engine.mapping.parameter.ParameterMap;
import com.ibatis.sqlmap.engine.mapping.sql.Sql;
import com.ibatis.sqlmap.engine.mapping.statement.MappedStatement;
import com.ibatis.sqlmap.engine.scope.SessionScope;
import com.ibatis.sqlmap.engine.scope.StatementScope;

public class JdbcTypeHandler {
	/**
	 * 获取完整的ibatis查询语句
	 * @param statementId
	 * @param objectParm
	 * @param sqlmapClient
	 * @return 不带占位符的sql语句
	 */
	public static String getStatementSql(String statementId, Object objectParm, SqlMapClientImpl sqlmapClient) {
		//获取执行sql
		MappedStatement mappedStatement = sqlmapClient.getMappedStatement(statementId);
		Sql stmtSql = mappedStatement.getSql();
		SessionScope sessionScope = new SessionScope();
		sessionScope.setSqlMapClient(sqlmapClient);

		StatementScope statementScope = new StatementScope(sessionScope);
		statementScope.setStatement(mappedStatement);
		String querySql = stmtSql.getSql(statementScope, objectParm);
		
		//获取参数
		ParameterMap parameterMap = stmtSql.getParameterMap(statementScope, objectParm);
		Object[] parameters = parameterMap.getParameterObjectValues(statementScope, objectParm);
		
		return parseStatementSql(querySql,parameters);
	}
	
	/**
	 * 替换sql中的占位符为对应的参数值
	 * @param querySql
	 * @param parms
	 * @return
	 */
	public static String parseStatementSql(String querySql,Object[] parms){
		int count=getPlaceholderCount(querySql,"\\?");
		if(count==0)return querySql;
	    	//Object[] parms=new Object[]{"user?saas",123,12.3,new Long(1231313)};
		for(int i=0;i<count;i++){
			 if(parms[i] instanceof String){
				querySql=querySql.replaceFirst("\\?", "'"+String.valueOf(parms[i])+"'");
			}else if(parms[i] instanceof Integer){
				querySql=querySql.replaceFirst("\\?", String.valueOf(parms[i]));
			}else if(parms[i] instanceof Long){
				querySql=querySql.replaceFirst("\\?", String.valueOf(parms[i]));
			}else if(parms[i] instanceof Double){
				querySql=querySql.replaceFirst("\\?", String.valueOf(parms[i]));
			}else if(parms[i] instanceof Float){
				querySql=querySql.replaceFirst("\\?", String.valueOf(parms[i]));
			}else if(parms[i] instanceof java.util.Date){
				querySql=querySql.replaceFirst("\\?", String.valueOf(parms[i]));
			}
		}
	 return querySql;
	}
	public static void main(String[] arg){
		
		//String[] str=querySql.trim().split("\\?");
		//System.out.print(getSql());
	}
	
	/**
	 * 获取占位符的个数
	 * @param str 
	 * @param placeholder 占位符
	 * @return
	 */
	public static int getPlaceholderCount(String str,String placeholder){
		int oldLength=str.length();
		int newLength=str.replaceAll(placeholder, "").length();
		return oldLength-newLength;
	}
		
}