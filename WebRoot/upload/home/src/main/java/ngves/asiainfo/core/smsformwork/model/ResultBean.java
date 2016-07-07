package ngves.asiainfo.core.smsformwork.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * HP应答信息bean
 * @author yeqh
 * 2013-12-11
 */
public class ResultBean implements Serializable{

	private static final long serialVersionUID = 4786498990191292496L;
	private String rejectReason;
	private String errorMsg;
	private int rowsCount;
	private Map<String, String> argMap = new HashMap<String, String>();
	
	
	public int getRowsCount() {
		return rowsCount;
	}
	public void setRowsCount(int rowsCount) {
		this.rowsCount = rowsCount;
	}
	public Map<String, String> getArgMap() {
		return argMap;
	}
	public void setArgMap(Map<String, String> argMap) {
		this.argMap = argMap;
	}
	public String getRejectReason() {
		return rejectReason;
	}
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	

}
