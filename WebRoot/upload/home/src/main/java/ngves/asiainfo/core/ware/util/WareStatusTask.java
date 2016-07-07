package ngves.asiainfo.core.ware.util;

import java.io.Serializable;

import ngves.asiainfo.core.ware.WareConstant;
import ngves.asiainfo.core.ware.service.interfaces.IWareStatus;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 礼品上下线任务 ，礼品ID：wareId, 操作类型：operType
 * 
 * 可以采用：
 * <code>
 * <pre>
 * WareStatusTask task = new WareStatusTask(); 
 * task.setWareId(wareId);
 * task.setOperType(operType);
 * ...
 * task.setXXX();
 * </pre>
 * </code>
 * 
 * 操作员ID，上下线原因
 * 
 * @author liuyq7@asiainfo-linkage.com
 *
 */
public class WareStatusTask  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static transient Log log = LogFactory.getLog(WareStatusTask.class);

	private IWareStatus wareStatus = null;
	
	//礼品ID
	private String wareId =null;
	//目标状态  [1:上线;2:下线]  由操作类型判断，不用传递
	private String targetState = null;
	//操作类型[0,1,2,3,4,5]
	private String operType = null;
	//上下线原因
	private String wareStatusCause = null;
	
	//操作员Id
	private long staffId ;
	
	private String operater=null;
	//上下线操作的备注信息
	private String note = null;
	
	//上下线历史记录中的原因
	private String cause = null;
	
	//自动上下线时的规则ID
	private String ruleId = null;
	
	
	
	public String getOperater() {
		return operater;
	}
	public void setOperater(String operater) {
		this.operater = operater;
	}
	/**
	 * @return the ruleId
	 */
	public String getRuleId() {
		return ruleId;
	}
	/**
	 * @param ruleId the ruleId to set
	 */
	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}
	/**
	 * @return the cause
	 */
	public String getCause() {
		return cause;
	}
	/**
	 * @param cause the cause to set
	 */
	public void setCause(String cause) {
		this.cause = cause;
	}
	//礼品上下线任务的ID，为了定时任务更新状态使用
	private String wareUpDownPlanId = null;
	
	
	
	/**
	 * @return the wareStatusCause
	 */
	public String getWareStatusCause() {
		return wareStatusCause;
	}
	/**
	 * @param wareStatusCause the wareStatusCause to set
	 */
	public void setWareStatusCause(String wareStatusCause) {
		this.wareStatusCause = wareStatusCause;
	}
	
	/**
	 * @return the staffId
	 */
	public long getStaffId() {
		return staffId;
	}
	/**
	 * @param staffId the staffId to set
	 */
	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}
	/**
	 * @param wareStatus the wareStatus to set
	 */
	public void setWareStatus(IWareStatus wareStatus) {
		this.wareStatus = wareStatus;
	}
	/**
	 * @param targetState the targetState to set
	 */
	public void setTargetState(String targetState) {
		this.targetState = targetState;
	}
	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * @return the wareUpDownPlanId
	 */
	public String getWareUpDownPlanId() {
		return wareUpDownPlanId;
	}
	/**
	 * @param wareUpDownPlanId the wareUpDownPlanId to set
	 */
	public void setWareUpDownPlanId(String wareUpDownPlanId) {
		this.wareUpDownPlanId = wareUpDownPlanId;
	}
	public WareStatusTask(){
	}
	/**
	 * @return the wareStatus
	 */
	public IWareStatus getWareStatus() {
		return wareStatus;
	}
	/**
	 * @param wareStatus the wareStatus to set
	 */
	//该方法不暴露给用户，由operType字段构造
	//public void setWareStatus(IWareStatus wareStatus) {
	//	this.wareStatus = wareStatus;
	//}
	
	/**
	 * @return the wareId
	 */
	public String getWareId() {
		return wareId;
	}
	/**
	 * @param wareId the wareId to set
	 */
	public void setWareId(String wareId) {
		this.wareId = wareId;
	}
	
	/**
	 * @return the targetState
	 */
	public String getTargetState() {
		return targetState;
	}
	/**
	 * @param targetState the targetState to set
	 */
	//该setter 函数不暴露给用户
	//public void setTargetState(String targetState) {
	//	this.targetState = targetState;
	//}
	/**
	 * @return the operType
	 */
	public String getOperType() {
		return operType;
	}
	/**
	 * @param operType the operType to set
	 */
	public void setOperType(String operType) {
		if(log.isDebugEnabled()){
			log.debug("in this wareStatus task ,operType is "+ operType);
		}
		this.operType = operType;
		
		//请求该操作的是礼品人工上线
		if(WareConstant.SYS_CORE_WARE_STATUS_OPER_TYPE_MANUAL_ONLINE.equals(operType)){
			//wareStatus = new ManualWareStatue();
			this.targetState = WareConstant.SYS_CORE_WARE_STATUS_ONLINE;
		}
		//请求该操作的是礼品人工下线
		else if(WareConstant.SYS_CORE_WARE_STATUS_OPER_TYPE_MANUAL_OFFLINE.equals(operType)){
			//wareStatus = new ManualWareStatue();
			this.targetState = WareConstant.SYS_CORE_WARE_STATUS_OFFLINE;
		}
		//请求该操作的是礼品定时上线
		else if(WareConstant.SYS_CORE_WARE_STATUS_OPER_TYPE_TIMEED_ONLINE.equals(operType)){
			//wareStatus = new FixedTimeWareStatus();
			this.targetState = WareConstant.SYS_CORE_WARE_STATUS_ONLINE;
		}
		//请求该操作的是礼品定时下线
		else if(WareConstant.SYS_CORE_WARE_STATUS_OPER_TYPE_TIMEED_OFFLINE.equals(operType)){
			//wareStatus = new FixedTimeWareStatus();
			this.targetState = WareConstant.SYS_CORE_WARE_STATUS_OFFLINE;
		}
		
		//请求该操作的是礼品自动上线
		else if(WareConstant.SYS_CORE_WARE_STATUS_OPER_TYPE_AUTO_ONLINE.equals(operType)){
			//wareStatus = new AutoWareStatus();
			this.targetState = WareConstant.SYS_CORE_WARE_STATUS_ONLINE;
		}
		//请求该操作的是礼品自动下线
		else if(WareConstant.SYS_CORE_WARE_STATUS_OPER_TYPE_AUTO_OFFLINE.equals(operType)){
			//wareStatus = new AutoWareStatus();
			this.targetState = WareConstant.SYS_CORE_WARE_STATUS_OFFLINE;
		}
	}
	
}
