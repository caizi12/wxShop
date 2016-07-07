package ngves.asiainfo.core.mobile.model;

import java.io.Serializable;

/**
 * 楼层推荐关系信息bean
 * @author yeqh
 * 2015-01-07
 */
public class MobileFloorRlt implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8327301419382627254L;
	
	public String showPicFile;
	public String floorRltId;
	public String showChannel;
	public String recommendType;
	public String recommendId;
	public String recommendName;
	public String indexId;
	public String floorId;
	public String bakCol1;
	public String isDelete;
	
	
	
	public String getShowPicFile() {
		return showPicFile;
	}
	public void setShowPicFile(String showPicFile) {
		this.showPicFile = showPicFile;
	}
	public String getFloorRltId() {
		return floorRltId;
	}
	public void setFloorRltId(String floorRltId) {
		this.floorRltId = floorRltId;
	}
	public String getShowChannel() {
		return showChannel;
	}
	public void setShowChannel(String showChannel) {
		this.showChannel = showChannel;
	}
	public String getRecommendType() {
		return recommendType;
	}
	public void setRecommendType(String recommendType) {
		this.recommendType = recommendType;
	}
	public String getRecommendId() {
		return recommendId;
	}
	public void setRecommendId(String recommendId) {
		this.recommendId = recommendId;
	}
	public String getRecommendName() {
		return recommendName;
	}
	public void setRecommendName(String recommendName) {
		this.recommendName = recommendName;
	}
	public String getFloorId() {
		return floorId;
	}
	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}
	public String getBakCol1() {
		return bakCol1;
	}
	public void setBakCol1(String bakCol1) {
		this.bakCol1 = bakCol1;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public String getIndexId() {
		return indexId;
	}
	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}
	
	
	

}
