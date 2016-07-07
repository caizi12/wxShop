package ngves.asiainfo.core.rechargepoints.model;

import java.io.Serializable;

public class RechargePointModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5206882222305291388L;

	private String taskId;
	
	private String fileName;
	
	private String content;
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
