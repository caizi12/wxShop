package ngves.asiainfo.core.viphall.model;

import java.io.Serializable;

/**
 * 专题礼品列表基本信息
 * 
 * @author shenfl
 * @version 1.0
 * 
 */
public class VipHallWareBaseInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// T2.WARE_NAME ,T2.IS_ONLINE,T2.FILE_NAME,T2.PROV_CODE,T2.CITY_CODE,
	// T2.CITY_NAME,T2.WARE_KIND_ID,
	private long wareId;
	private String wareName;
	private String isOnline;// 1-上线 ，2-下线
	private String fileName;
	private String provCode;
	private String cityCode;
	private String cityName;
	private long wareKindId;
	public String getWareName() {
		return wareName;
	}

	public void setWareName(String wareName) {
		this.wareName = wareName;
	}

	public String getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getProvCode() {
		return provCode;
	}

	public void setProvCode(String provCode) {
		this.provCode = provCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public long getWareKindId() {
		return wareKindId;
	}

	public void setWareKindId(long wareKindId) {
		this.wareKindId = wareKindId;
	}
	public long getWareId() {
		return wareId;
	}

	public void setWareId(long wareId) {
		this.wareId = wareId;
	}
}
