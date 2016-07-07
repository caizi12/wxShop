package cn.frame.platform.common.util.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
/**
 * xml 工具类
 * @author li
 *
 */
public class XmlUtil {
	/**
	 * 把xml转换为对应的object
	 * @param xml
	 * @param tClass
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Object getObjectFromXML(String xml, Class tClass) {
	    //将从API返回的XML数据映射到Java对象
	    XStream xStreamForResponseData = new XStream(new DomDriver());
	    xStreamForResponseData.alias("xml", tClass);
	    xStreamForResponseData.ignoreUnknownElements();//暂时忽略掉一些新增的字段
	    return xStreamForResponseData.fromXML(xml);
	}
	
	/**
	 * 把对象转换为xml
	 * @param obj
	 * @return
	 */
	public static String coventObjectToXml(Object obj){
        XStream xStream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));
        xStream.alias("xml", obj.getClass()	);
        return  xStream.toXML(obj);
	}
	
	/**
	 * 把对象转换为xml 根节点名称可以自定义
	 * @param obj
	 * @param rootXmlName 根节点名称
	 * @return
	 */
	public static String coventObjectToXml(Object obj,String rootXmlName){
        XStream xStream = new XStream();
        xStream.alias(rootXmlName,obj.getClass());
        return  xStream.toXML(obj);
	}
}
