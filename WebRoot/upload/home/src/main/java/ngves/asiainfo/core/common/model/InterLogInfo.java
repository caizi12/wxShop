package ngves.asiainfo.core.common.model;

import java.io.Serializable;

public class InterLogInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long interLogId;
	//接口业务编码
	private String bipCode;
	//渠道类型
	private String channelType;
	//请求报文
	private String requestLog;
	//响应报文
	private String responseLog;
	//备注
	private String baKcol1;
	
	
	
	public long getInterLogId() {
		return interLogId;
	}
	public void setInterLogId(long interLogId) {
		this.interLogId = interLogId;
	}
	public String getBipCode() {
		return bipCode;
	}
	public void setBipCode(String bipCode) {
		this.bipCode = bipCode;
	}
	public String getChannelType() {
		return channelType;
	}
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
	public String getRequestLog() {
		return requestLog;
	}
	public void setRequestLog(String requestLog) {
		this.requestLog = requestLog;
	}
	public String getResponseLog() {
		return responseLog;
	}
	public void setResponseLog(String responseLog) {
		this.responseLog = responseLog;
	}
	public String getBaKcol1() {
		return baKcol1;
	}
	public void setBaKcol1(String baKcol1) {
		this.baKcol1 = baKcol1;
	}

}
