package cn.frame.platform.common.util;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class MessageUtil {

	/**提示信息类型 成功*/
	public static final String SUCCESS="success";
	/**提示信息类型 失败*/
	public static final String ERROR="error";
	
	
	public enum MessageType {
		
		SUCCESS("保存成功"), ERROR("保存失败");

		private String value;

		private MessageType(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}
	}
	
 
	//提示消息类型
	private String msgType;
	//提示信息
	private String msg;
	
	private Map<String,Object> dataMap=null;

	/**
	 * 
	 * 提示信息
	 * 
	 * @param msgType 提示信息类型</p>
	 * 
	 *    当值为success时，提示信息为“保存成功” </p>
	 * 
	 *    当值为error时，提示信息为“保存失败”
	 * 
	 * @return MessageUtil
	 */
	public static MessageUtil message(String msgType) {
		if (StringUtils.isNotBlank(msgType) && SUCCESS.equals(msgType)) {
			return new MessageUtil(msgType, MessageType.SUCCESS.getValue());
		} else if (StringUtils.isNotBlank(msgType) && ERROR.equals(msgType)) {
			return new MessageUtil(msgType, MessageType.ERROR.getValue());
		}
		return null;
	}
	
	/**
	 * 
	 * 提示信息
	 * 
	 * @param msgType 提示信息类型 </p>
	 * @param msg     提示信息
	 * @return MessageUtil
	 */
	public static MessageUtil message(String msgType,String msg){
		if(StringUtils.isNotBlank(msgType)||StringUtils.isNotBlank(msg)){
			return new MessageUtil(msgType,msg);
		}
		return null;
	}
	
	
	/**
	 * 
	 * 提示信息
	 * 
	 * @param msgType 提示信息类型 </P>
	 * @param dataMap 自定义数据
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static MessageUtil message(String msgType,Map dataMap) {
		if (StringUtils.isNotBlank(msgType) && SUCCESS.equals(msgType)) {
			return new MessageUtil(msgType, MessageType.SUCCESS.getValue(),dataMap);
		} else if (StringUtils.isNotBlank(msgType) && ERROR.equals(msgType)) {
			return new MessageUtil(msgType, MessageType.ERROR.getValue(),dataMap);
		}
		return null;
	}
	
	
	/**
	 * 
	 * 提示信息
	 * 
	 * @param msgType 提示信息类型 </p>
	 * @param msg     提示信息
	 * @dataMap       自定义数据
	 * @return MessageUtil
	 */
	@SuppressWarnings("unchecked")
	public static MessageUtil message(String msgType,String msg,Map dataMap){
		if(StringUtils.isNotBlank(msgType)||StringUtils.isNotBlank(msg)){
			return new MessageUtil(msgType,msg,dataMap);
		}
		return null;
	}
	
	private  MessageUtil(String msgType,String msg){
		this.setMsg(msg);
		this.setMsgType(msgType);
	}
	
	@SuppressWarnings("unchecked")
	private  MessageUtil(String msgType,String msg,Map dataMap){
		this.setMsg(msg);
		this.setMsgType(msgType);
		this.setDataMap(dataMap);
	}
	
	public MessageUtil(){};
	

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsgType() {
		return msgType;
	}
	
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	
	public Map<String, Object> getDataMap() {
		return this.dataMap;
	}

	public void setDataMap(Map<String,Object> dataMap) {
		this.dataMap = dataMap;
	}

	public static void main(String ar[]){
		MessageUtil d=MessageUtil.message("success");
		System.out.print(d.msg+""+d.msgType);
	}
}
