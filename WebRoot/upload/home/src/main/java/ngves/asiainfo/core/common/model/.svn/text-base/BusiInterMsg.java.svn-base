/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.common.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 接口业务报文流水表
 * @author wzg
 *
 */
public class BusiInterMsg implements Serializable{
	

	private static final long serialVersionUID = 7041014059951659267L;
	private long busiId;
	private Date optDate;
	private String msg;
	private String actionType;
	private String sendReplyResult;
	private String bakCol;
	private String bakCol2;
	private String appVersion;
	
	public BusiInterMsg(long busiId, String msg, String actionType, String sendReplyResult) {
		this(busiId,new Date(),msg,actionType,sendReplyResult);
	}
	
	public BusiInterMsg(long busiId, Date optDate, String msg, String actionType, String sendReplyResult) {
		this.busiId = busiId;
		this.optDate = optDate;
		this.msg = msg;
		this.actionType = actionType;
		this.sendReplyResult = sendReplyResult;
	}

	public long getBusiId() {
		return busiId;
	}

	public void setBusiId(long busiId) {
		this.busiId = busiId;
	}

	public Date getOptDate() {
		return optDate;
	}

	public void setOptDate(Date optDate) {
		this.optDate = optDate;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getSendReplyResult() {
		return sendReplyResult == null ? "" : sendReplyResult;
	}

	public void setSendReplyResult(String sendReplyResult) {
		this.sendReplyResult = sendReplyResult;
	}

	public String getBakCol() {
		return bakCol;
	}

	public void setBakCol(String bakCol) {
		this.bakCol = bakCol;
	}

	public String getBakCol2() {
		return bakCol2;
	}

	public void setBakCol2(String bakCol2) {
		this.bakCol2 = bakCol2;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	
	
}
