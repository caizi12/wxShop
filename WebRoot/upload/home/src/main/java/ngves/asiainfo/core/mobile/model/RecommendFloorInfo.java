package ngves.asiainfo.core.mobile.model;

import java.io.Serializable;


/**
 * 单个推荐楼层的完整信息
 * @author yeqh
 * 2015-01-06
 */
public class RecommendFloorInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3139844806277929793L;
	
	
	//存放楼层基本信息
	public MobileFloorInfo floorInfo;
	//存放楼层关系信息
	public MobileFloorRlt[] floorRlts;
	
	
	public MobileFloorInfo getFloorInfo() {
		return floorInfo;
	}
	public void setFloorInfo(MobileFloorInfo floorInfo) {
		this.floorInfo = floorInfo;
	}
	public MobileFloorRlt[] getFloorRlts() {
		return floorRlts;
	}
	public void setFloorRlts(MobileFloorRlt[] floorRlts) {
		this.floorRlts = floorRlts;
	}
	
	
}
