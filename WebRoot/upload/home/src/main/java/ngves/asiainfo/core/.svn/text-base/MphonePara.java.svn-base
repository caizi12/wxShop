package ngves.asiainfo.core;

import java.util.Enumeration;
import java.util.ResourceBundle;

import ngves.asiainfo.CommnPara;

/**
 * @author fansr <br>
 * Create Time：2015-7-22 下午05:16:54 <br>
 * <a href="mailto:fansr@asiainfo.com">fansr@asiainfo.com</a>
 */
public class MphonePara extends CommnPara {
    static {
        init();// 类加载就初始化
    }

    /**
     * 初始化
     */
    public static void init() {
        String fileName = CoreConstant.MPHONE_PROPS_FILE;
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
