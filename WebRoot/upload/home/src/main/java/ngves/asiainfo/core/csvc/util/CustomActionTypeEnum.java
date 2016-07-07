/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.util;

/**
 * 客服交互动作类型枚举<br>
 * 01:收到投诉派发;02:发送投诉回复;03:收到投诉归档;04:发送投诉退回;05:收到中途意见06:发送中途意见;07:收到投诉再处理;08:收到投诉催办;09:手机加解锁请求处理;
 * @author wzg
 *
 */
public enum CustomActionTypeEnum {
	AllegeAssignAccept("01"),AllegeReplySend("02"),AllegeHandlingAccept("03"),
	AllegeRejectSend("04"),AllegeCommentAccept("05"),AllegeCommentSend("06"),
	AllegeRhandleAccept("07"),AllegeHastenAccept("08"),MobileLockUnlock("09");
	
	private String value;

	private CustomActionTypeEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	
}
