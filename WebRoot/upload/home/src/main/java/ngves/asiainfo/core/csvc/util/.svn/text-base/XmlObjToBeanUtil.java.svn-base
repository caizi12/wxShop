/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.util;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.common.model.CsvcItemRule;
import ngves.asiainfo.core.common.model.ItemRuleCollection;
import ngves.asiainfo.core.csvc.CsvcConstant;
import ngves.asiainfo.core.csvc.validate.SchemaRuleFactory;
import ngves.asiainfo.core.csvc.validate.SchemaValidateChain;
import ngves.asiainfo.interfaces.InterNameSpace;
import ngves.asiainfo.interfaces.InterUtil;
import ngves.asiainfo.interfaces.csvc.bean.common.CsvcCommonInterBoss;
import ngves.asiainfo.interfaces.csvc.bean.csvcBussi.in.CsvcBussiRequestInItem;
import ngves.asiainfo.interfaces.csvc.bean.csvcBussi.in.CsvcBussiRequestInSvcRoot;
import ngves.asiainfo.interfaces.csvc.bean.csvcBussi.in.CsvcBussiRequestInSvcRootDocument;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.DataStructInterface;

/**
 * XML的报文对象转换为积分平台业务对象<br/>
 * 不可实例化,可以继承
 * @author wzg
 *
 */
public abstract class XmlObjToBeanUtil {

	private static transient Log log = LogFactory.getLog(XmlObjToBeanUtil.class);
	//提供监控,但不支持序列化
	private static transient final Map<String, Method> setMethods = new HashMap<String, Method>();

	/**
	 * 得到缓存方法对象的视图
	 * @return
	 */
	public static Map<String, Method> getStats() {
		return Collections.unmodifiableMap(setMethods);
	}

	public static void xmlToBean(CsvcCommonInterBoss in, DataStructInterface dataContainer) throws Exception {
		String result = in.getSvcCont();
		result = InterUtil.addNameSpace(InterNameSpace.NAMESPCE_CSVC_BUSSI, result,
				InterNameSpace.SVCROOT_NAMESPACE_REPLACE_HEAD);
		CsvcBussiRequestInSvcRoot svcRoot = CsvcBussiRequestInSvcRootDocument.Factory.parse(result).getSvcRoot();
		//该操作不会返回null
		CsvcBussiRequestInItem[] items = svcRoot.getItemArray();
		//然后进行报文体内容的验证
		SchemaValidateChain.getInstance().executeValidation(items, dataContainer);
		ItemRuleCollection itemRules = SchemaRuleFactory.getItemRuleCollection(dataContainer);
		CsvcItemRule rule = null;
		for (int i = 0; i < items.length; i++) {
			rule = itemRules.getCsvcItemRule(items[i].getName());
			setBeanProperties(rule, items[i], dataContainer);
			rule = null;
		}
		//获取附件节点原代码，getAttachListArray()不能获取多个附件
		if (null != svcRoot.getAttachList()) {
			setFiles(svcRoot.getAttachList().getAttachNameArray(), dataContainer, "setAttachnames");
		}
		if (null != svcRoot.getRecordList()) {
			setFiles(svcRoot.getRecordList().getRecordFileArray(), dataContainer, "setRecordfiles");
		}
		
	}
	//测试一级客服接收报文
	public static void serviceXmlToBean(CsvcCommonInterBoss in, DataStructInterface dataContainer) throws Exception {
		String result = in.getSvcCont();
		result = InterUtil.addNameSpace(InterNameSpace.NAMESPCE_CSVC_BUSSI, result,
				InterNameSpace.RESPONSE_NAMESPACE_REPLACE_HEAD);
		CsvcBussiRequestInSvcRoot svcRoot = CsvcBussiRequestInSvcRootDocument.Factory.parse(result).getSvcRoot();
		//该操作不会返回null
		CsvcBussiRequestInItem[] items = svcRoot.getItemArray();
		//然后进行报文体内容的验证
		SchemaValidateChain.getInstance().executeValidation(items, dataContainer);
		ItemRuleCollection itemRules = SchemaRuleFactory.getItemRuleCollection(dataContainer);
		CsvcItemRule rule = null;
		for (int i = 0; i < items.length; i++) {
			rule = itemRules.getCsvcItemRule(items[i].getName());
			setBeanProperties(rule, items[i], dataContainer);
			rule = null;
		}
		if (null != svcRoot.getAttachList()) {
			setFiles(svcRoot.getAttachList().getAttachNameArray(), dataContainer, "setAttachnames");
		}
		if (null != svcRoot.getRecordList()) {
			setFiles(svcRoot.getRecordList().getRecordFileArray(), dataContainer, "setRecordfiles");
		}
	}
	
	/**
	 * 从缓存获取方法对象,如果没有生成,通过反射设置属性值
	 * @param rule
	 * @param item
	 * @param dataContainer
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private static void setBeanProperties(CsvcItemRule rule, CsvcBussiRequestInItem item,
			DataStructInterface dataContainer) throws Exception {
		String key = dataContainer.getClass() + rule.getMethodSetName();
		Method method = setMethods.get(key);
		if (method == null) {
			try {
				method = dataContainer.getClass().getDeclaredMethod(rule.getMethodSetName(), String.class);
				setMethods.put(key, method);
			} catch (NoSuchMethodException e) {
				//更换为世间格式,如果还不正确,报异常返回
				method = dataContainer.getClass().getDeclaredMethod(rule.getMethodSetName(), Timestamp.class);
				setMethods.put(key, method);
			}
		}
		if (log.isDebugEnabled()) {
			log.debug(item.getName() + " SetMethod name := " + method.getName());
		}
		Class[] ps = method.getParameterTypes();
		//由于都是带参数获取的方法,此处不必对参数类型数组进行空和长度判断
		if(String.class.equals(ps[0])) {
			method.invoke(dataContainer, item.getValue());
		}else if(Timestamp.class.equals(ps[0])) {
			//都按照19位的格式转换
			method.invoke(dataContainer, DateTimeUtil.stringToTimestamp(item.getValue(),
					CommnConstant.DATETIME_JAVA_FORMAT));
		}else {
			throw new Exception(method.getName() + " parameterType 0 " + ps[0] + " is not right !!! ");
		}
	}

	/**
	 * 设置文件名称
	 * @param files
	 * @param dataContainer
	 * @param setName
	 * @throws Exception
	 */
	private static void setFiles(String[] files, DataStructInterface dataContainer, String setName) throws Exception {
		Method method = null;
		if (files != null && files.length > 0) {
			String fileName = filterInvalidStr(files[0]);
			for (int i = 1; i < files.length; i++) {
				fileName += CsvcConstant.CUSTOM_FILE_SPLIT + filterInvalidStr(files[i]);
			}
			method = dataContainer.getClass().getDeclaredMethod(setName, String.class);
			method.invoke(dataContainer, fileName);
		}
	}
	
	/**
	 *  过滤无效的字符\n\r\t,去掉前后空格,空不操作
	 * @param fileName
	 * @return
	 */
	private static String filterInvalidStr(String fileName) {
		if(StringUtil.isBlank(fileName)) {
			return fileName;
		}
		String result = fileName.replaceAll("\n", "");
		result = result.replaceAll("\r", "");
		result = result.replaceAll("\t", "");
		return result.trim();
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		String d = new String();
		Method[] methods = d.getClass().getDeclaredMethods();
		Method[] method2s = d.getClass().getMethods();
		Method m = d.getClass().getMethod("split", String.class);
		//System.out.println(" method := " + method);
		Class[] ps = m.getParameterTypes();
		for (Class c : ps) {
			System.out.println(c + " c := " + (c.equals(String.class)));
		}
		System.out.println(" ml := " + methods.length + " ml2 := " + method2s.length);
		//		for(int i = 0; i<methods.length;i++) {
		//			System.out.println(" ml.name := " + methods[i].getName());
		//		}
		System.out.println(filterInvalidStr("\n\r\tsdfs  sdfs     \n"));
	}

}
