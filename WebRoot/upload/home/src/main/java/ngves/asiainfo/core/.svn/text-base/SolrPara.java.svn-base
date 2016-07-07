package ngves.asiainfo.core;

import java.util.Enumeration;
import java.util.ResourceBundle;

import ngves.asiainfo.CommnPara;

/**
 * 读取solr配置文件内容
 * Description:
 * @author: zhangwz
 *
 */
public class SolrPara extends CommnPara {
    static {
        init();// 类加载就初始化
    }

    /**
     * 初始化
     */
    public static void init() {
        String fileName = SolrConstant.SOLR_PROPS_FILE;
        if (fileName.endsWith(".properties"))
            fileName = fileName.substring(0, fileName.indexOf(".properties"));
        ResourceBundle bundle = ResourceBundle.getBundle(fileName);
        Enumeration<String> enumer = bundle.getKeys();
        while (enumer.hasMoreElements()) {
            String key = (String) enumer.nextElement();
            String value = bundle.getString(key);
            CommnPara.put(key, value);
        }
    }
    
    /**
     * @param key
     * @param value
     */
    public static void put(String key, String value) {
        CommnPara.put(key, value);
    }

    /**
     * @param key
     * @return
     */
    public static String get(String key) {
        return CommnPara.get(key);
    }

}
