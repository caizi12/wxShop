package ngves.asiainfo.core.common.model;

/**
 * 场次类
 * @author WL
 *
 */
public class Location extends Theatre implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String locationId;   //场次标识  对应子礼品Id
	private String locationName; //场次名称
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
}
