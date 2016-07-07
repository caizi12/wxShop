/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.common.model;

import java.io.Serializable;

import ngves.asiainfo.util.StringUtil;


/**
 * 线程安全实例,主要用于一级客服接入的验证
 * @author wzg
 *
 */
public final class CsvcItemRule implements Serializable{
	
	private static final long serialVersionUID = -2284943533166671407L;
	/**
	 * get方法的前缀
	 */
	public static final String METHOD_GET_PREFIX = "get";
	/**
	 * set方法的前缀
	 */
	public static final String METHOD_SET_PREFIX = "set";
	//item对象的name
	private String name;
	//value值的最小长度
	private int minLength;
	//value值的最大长度
	private int maxLength;
	//该节点出现的最小次数
	private int minNum;
	//该节点出现的最大次数	
	private int maxNum;
	//对应的自动名称,可以直接get/set
	private String ref;
	
	/**
	 * 
	 * @param name   接口定义的字段名称，例如："HandlingStaff"
	 * @param minLength
	 * @param maxLength
	 * @param minNum
	 * @param maxNum
	 * @param ref  传递为AppFrame生成的静态变量,例如:"HANDLINGCOMMENT"
	 */
	public CsvcItemRule(String name, int minLength, int maxLength, int minNum, int maxNum,String ref) {
		this.name = name;
		this.minLength = minLength;
		this.maxLength = maxLength;
		this.minNum = minNum;
		this.maxNum = maxNum;
		init(ref);
	}
	
	/**
	 * 修改为JAVABEAN标准方法,第一个字母大写,后面全是小写
	 * @param ref
	 */
	private void init(String ref) {
		if( StringUtil.isBlank(ref) ) {
			this.ref = ref;
			return;
		}
		String first = ref.substring(0,1).toUpperCase();
		this.ref = first + ref.substring(1).toLowerCase();
	}
	public String getName() {
		return name;
	}
	public int getMinLength() {
		return minLength;
	}
	public int getMaxLength() {
		return maxLength;
	}
	public int getMinNum() {
		return minNum;
	}
	public int getMaxNum() {
		return maxNum;
	}
	
	public String getRef() {
		return ref;
	}
	
	public String getMethedGetName() {
		return METHOD_GET_PREFIX + ref;
	}
	
	public String getMethodSetName() {
		return METHOD_SET_PREFIX + ref;
	}
}
