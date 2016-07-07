package ngves.asiainfo.core;
import java.io.InputStream;

import org.apache.log4j.Logger;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;


/**
 * @author shenfl
 *
 */
public class IbatisSQLMapConfig {
	
	private static Logger log = Logger.getLogger(IbatisSQLMapConfig.class);
	
	private static  SqlMapClient sqlMapClient;
	// 在静态区块中初试化返回
	static {
		try {
			// 声明配置文件的名称（映射文件被定义在其中）
			String resource = "config/sql-map-config.xml";
			// 利用工具类Resources来读取到配置文件
			//Reader reader = Resources.getResourceAsReader(resource);
			InputStream in = IbatisSQLMapConfig.class.getClassLoader().getResourceAsStream(resource);
			// 创建SqlMapClient接口的变量实例
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(in);
		} catch (Exception e) {
			log.error("Init SqlMapClient is error", e);
		}
	}
	public static SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}
	
	public static void main(String[] args){
		System.out.println("sqlMapClient = "+sqlMapClient);
	}
}
