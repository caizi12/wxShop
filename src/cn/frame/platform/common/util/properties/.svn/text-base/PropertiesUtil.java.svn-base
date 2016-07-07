package cn.myshop.platform.common.util.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * 系统基础提示信息操作类
 * 
 * @date 2012-08-27 20:55:11
 * @author llliang
 * 
 */
public class PropertiesUtil {
	
	private static Logger log = Logger.getLogger(PropertiesUtil.class);
	
	private static PropertiesUtil PlatformProperties = null;
	public static PropertiesUtil getInstance() {
		if (PlatformProperties == null) {
			PlatformProperties = new PropertiesUtil();
		}
		return PlatformProperties;
	}

	public static final String message_prop = "message.properties";
	public static Properties   messageProperties;
	public static final String sysConfig_prop = "sysconfig.properties";
	public static Properties   sysConfigProperties;
	static {
		messageProperties = loadProperties(message_prop);
	}
	
	/**
	 * 加载属性文件
	 * @param path
	 * @return
	 */
	private static Properties loadProperties(String path){
		InputStream inputStream=null;
		Properties properties=new Properties();
		try {
			inputStream=PropertiesUtil.class.getClassLoader().getResourceAsStream(path);
			properties.load(inputStream);
	        inputStream.close();
		} catch (FileNotFoundException e) {
			log.error("读取属性文件"+path+"失败，文件路径错误.");
			e.printStackTrace();
		} catch (IOException e) {
			log.error("装载属性文件"+path+"失败");
			e.printStackTrace();
		}
		 return properties;
	}

	
	/**
	 * 此方法仅供获取sysconfig.properties文件中的key值
	 * @param key
	 * @return value
	 */
	public static String getSysConfigValue(String key){
		if(StringUtils.isEmpty(key))return null;
		return sysConfigProperties.getProperty(key);
	}
	
	/**
	 * 获取key对应的值
	 * 此方法仅供获取message.properties文件中的key值
	 * @param key
	 * @return value
	 */
	public static String getMessValue(String key){
		if(StringUtils.isEmpty(key))return null;
		return messageProperties.getProperty(key);
	}
	
	/**
	 * 自定义获取message.properties中的value，实现方式为循环替换value中的{0}关键字
	 * @param key
	 * @param ...objs 可变参数，参数个数应与替换的值个数匹配
	 * @return
	 */
	public static String getMessValues(String key,Object ...objs){
		if(StringUtils.isEmpty(key))return null;
		String value=getMessValue(key);
		int i=0;
		for(Object obj : objs) {
			value= value.replaceFirst("\\{"+i+"\\}", String.valueOf(obj));
			i++;
		  }
		return value;
	}
	
	/**
	 * 获取指定properties文件的key值
	 * 
	 * @param key
	 * @param propertiesPath
	 * @return key对应的value
	 */
	public static String getPropertiesValue(String proertiesPath,String key){
		if(StringUtils.isEmpty(key)||StringUtils.isEmpty(proertiesPath))return null;
		Properties prop=loadProperties(proertiesPath);
		return prop.getProperty(key);
	}
	
	
	public static void main(String[] a){
		System.out.println(getMessValue("sys_auth_0001"));
		System.out.println(getPropertiesValue("message.properties","sys_auth_0001"));
		System.out.println(getMessValues("test","用户",""));
	}
}
