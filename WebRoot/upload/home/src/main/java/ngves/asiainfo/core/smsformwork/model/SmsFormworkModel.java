package ngves.asiainfo.core.smsformwork.model;

import java.io.Serializable;

/**   
 * @author Fsr   
 * @version 1.0
 * 创建时间：2013-12-12 下午02:30:24  
 * 类说明 短信模板model
 */
public class SmsFormworkModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7220083719410341004L;

	private String formworkId;
	private String formworkName;
	private String formworkType;
	private String formworkState;
	private String operateTime;
	private String operatorCode;
	private String sendProvince;
	public String getFormworkId() {
		return formworkId;
	}
	public void setFormworkId(String formworkId) {
		this.formworkId = formworkId;
	}
	public String getFormworkName() {
		return formworkName;
	}
	public void setFormworkName(String formworkName) {
		this.formworkName = formworkName;
	}
	public String getFormworkType() {
		return formworkType;
	}
	public void setFormworkType(String formworkType) {
		this.formworkType = formworkType;
	}
	public String getFormworkState() {
		return formworkState;
	}
	public void setFormworkState(String formworkState) {
		this.formworkState = formworkState;
	}
	public String getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}
	public String getOperatorCode() {
		return operatorCode;
	}
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}
	public String getSendProvince() {
		return sendProvince;
	}
	public void setSendProvince(String sendProvince) {
		this.sendProvince = sendProvince;
	}	
}
