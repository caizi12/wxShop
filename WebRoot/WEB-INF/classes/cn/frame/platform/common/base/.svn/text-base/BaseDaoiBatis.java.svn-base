package cn.myshop.platform.common.base;

import java.io.UnsupportedEncodingException;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import cn.myshop.platform.common.util.ReflectUtil;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.engine.execution.SqlExecutor;
import com.ibatis.sqlmap.engine.impl.SqlMapClientImpl;


public class BaseDaoiBatis extends SqlMapClientDaoSupport {
	private SqlExecutor sqlExecutor;

	public SqlExecutor getSqlExecutor() {
		return sqlExecutor;
	}

	public void setSqlExecutor(SqlExecutor sqlExecutor) {
		this.sqlExecutor = sqlExecutor;
	}

	public void setEnableLimit(boolean enableLimit) {
		if (sqlExecutor instanceof LimitSqlExecutor) {
			((LimitSqlExecutor) sqlExecutor).setEnableLimit(enableLimit);
		}
	}

	public void initialize() throws Exception {
		if (sqlExecutor != null) {
			SqlMapClient sqlMapClient = getSqlMapClientTemplate().getSqlMapClient();
			if (sqlMapClient instanceof SqlMapClientImpl) {
				ReflectUtil.setFieldValue(((SqlMapClientImpl) sqlMapClient).getDelegate(), "sqlExecutor", SqlExecutor.class, sqlExecutor);
			}
		}
	}

	public static void main(String[] a) throws UnsupportedEncodingException{
		StringBuilder sb=new StringBuilder();
		sb.append("中国在");
		sb.append("asda");
		System.out.print(sb.toString());
	}
}
