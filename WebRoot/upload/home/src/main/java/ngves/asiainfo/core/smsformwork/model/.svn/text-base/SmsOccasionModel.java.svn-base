package ngves.asiainfo.core.smsformwork.model;

import java.io.Serializable;

import ngves.asiainfo.core.smsformwork.ivalues.ISmsOccasionInfoValue;

/**   
 * @author Fsr   
 * @version 1.0
 * 创建时间：2013-12-9 上午11:23:29  
 */
public class SmsOccasionModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3404924984871059853L;
	
	private String occasionId;//时机id
	private String occasionTypeId;//时机类型id
	private String occasionName;//时机名称
	private String startTime;//生效开始时间
	private String endTime;//生效结束时间
	private String orderState;//订单状态
	
	public SmsOccasionModel copy(ISmsOccasionInfoValue value){
		SmsOccasionModel model = new SmsOccasionModel();
		model.setOccasionId(value.getOccasionId());
		model.setOccasionTypeId(value.getOccasionTypeId());
		model.setOccasionName(value.getOccasionName());
		model.setStartTime(value.getStartTime());
		model.setEndTime(value.getEndTime());
		model.setOrderState(value.getOrderState());
		return model;
	}
	
	public String getOccasionId() {
		return occasionId;
	}
	public void setOccasionId(String occasionId) {
		this.occasionId = occasionId;
	}
	public String getOccasionTypeId() {
		return occasionTypeId;
	}
	public void setOccasionTypeId(String occasionTypeId) {
		this.occasionTypeId = occasionTypeId;
	}
	public String getOccasionName() {
		return occasionName;
	}
	public void setOccasionName(String occasionName) {
		this.occasionName = occasionName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

}
