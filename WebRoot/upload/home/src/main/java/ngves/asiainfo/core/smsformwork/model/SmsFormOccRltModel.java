package ngves.asiainfo.core.smsformwork.model;

import java.io.Serializable;

import ngves.asiainfo.core.smsformwork.ivalues.ISmsFormworkOccasionRltValue;

/**   
 * @author Fsr   
 * @version 1.0
 * 创建时间：2013-12-10 上午10:28:48  
 * 类说明 
 */
public class SmsFormOccRltModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5542688602502065304L;
	
	private String rltId;
	private String formworkId;//模板id
	private String occasionTypeId;//时机类型id
	private String occasionId;//时机id
	private String contentId;//内容id
	private String contentName;//内容标题
	private String startTime;//生效开始时间
	private String endTime;//生效结束时间
	private String isSend;//是否发送0-发送;1-不发送
	
	public SmsFormOccRltModel copy(ISmsFormworkOccasionRltValue value){
		SmsFormOccRltModel model = new SmsFormOccRltModel();
		model.setRltId(value.getRltId());
		model.setFormworkId(value.getFormworkId());
		model.setOccasionTypeId(value.getOccasionTypeId());
		model.setOccasionId(value.getOccasionId());
		model.setContentId(value.getContentId());
		model.setContentName(value.getContentName());
		model.setStartTime(value.getStartTime());
		model.setEndTime(value.getEndTime());
		model.setIsSend(value.getIsSend());
		return model;
	}

	public String getRltId() {
		return rltId;
	}

	public void setRltId(String rltId) {
		this.rltId = rltId;
	}

	public String getFormworkId() {
		return formworkId;
	}

	public void setFormworkId(String formworkId) {
		this.formworkId = formworkId;
	}

	public String getOccasionTypeId() {
		return occasionTypeId;
	}

	public void setOccasionTypeId(String occasionTypeId) {
		this.occasionTypeId = occasionTypeId;
	}

	public String getOccasionId() {
		return occasionId;
	}

	public void setOccasionId(String occasionId) {
		this.occasionId = occasionId;
	}

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
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

	public String getIsSend() {
		return isSend;
	}

	public void setIsSend(String isSend) {
		this.isSend = isSend;
	}

}
