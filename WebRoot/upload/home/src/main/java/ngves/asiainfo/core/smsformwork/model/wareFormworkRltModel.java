package ngves.asiainfo.core.smsformwork.model;

import java.io.Serializable;

/**   
 * @author Fsr   
 * @version 1.0
 * 创建时间：2013-12-5 下午05:48:58  
 * 类说明 礼品模板绑定关系model
 */
public class wareFormworkRltModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1902294981352780062L;
	
	private String rltId;
	private String wareCode;//礼品编号
	private String formworkId;//模板编号
	private String operatorCode;//操作人工号
	private String operateTime;//操作时间
	private String actionId;//活动编号
	private String actionType;//活动类型
	
	public String getRltId() {
		return rltId;
	}
	public void setRltId(String rltId) {
		this.rltId = rltId;
	}
	public String getWareCode() {
		return wareCode;
	}
	public void setWareCode(String wareCode) {
		this.wareCode = wareCode;
	}
	public String getFormworkId() {
		return formworkId;
	}
	public void setFormworkId(String formworkId) {
		this.formworkId = formworkId;
	}
	public String getOperatorCode() {
		return operatorCode;
	}
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}
	public String getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}
	public String getActionId() {
		return actionId;
	}
	public void setActionId(String actionId) {
		this.actionId = actionId;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
}
