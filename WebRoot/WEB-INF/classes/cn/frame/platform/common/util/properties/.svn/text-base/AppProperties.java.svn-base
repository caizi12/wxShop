 

package cn.myshop.platform.common.util.properties;

import java.io.Serializable;
import java.util.Properties;

/**
 * properties操作类
 * @date 2012-08-27 20:55:11
 * @author llliang
 *
 */
public class AppProperties implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 606271452116829389L;

	private static AppProperties appEnv = null;

	public static AppProperties getInstance()
	{
		if (appEnv == null) {
			appEnv = new AppProperties();// just in time instance creation
		}
		return appEnv;
	}

	/**
	 * 系统入口文件所在路径，对系统来讲这是固定的，但对开发人员来讲可以修改这里的参数
	 */
	public static final String SYSTEM_PROPS = "config.env.app";

	public static final String MODULES_PROPS = "config.env.module";

	private Properties systemProps = null;

	public Properties getSystemProps()
	{
		return this.systemProps;
	}

	public String getSystemProp(String key)
	{
		return getSystemProps().getProperty(key);
	}

	public void setSystemProps(Properties systemProps)
	{
		this.systemProps = systemProps;
	}

	public void appendSystemProps(Properties props)
	{
		this.systemProps.putAll(props);
	}

	public boolean getBooleanProp(String key)
	{
		return Boolean.valueOf(getSystemProp(key)).booleanValue();
	}

	/** =========以下开发人员可自由增加=========== */

	/**
	 * logback日志配置文件路径
	 */
	private static final String LOGBACK_CONFIG_FILE_PATH = "logback.config.file.path";
	

	public String LOGBACK_CONFIG_FILE_PATH()
	{
		return LOGBACK_CONFIG_FILE_PATH;
	}

}
