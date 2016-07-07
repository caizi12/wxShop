package ngves.asiainfo.core.floor.domain;

import java.io.Serializable;
import java.util.List;

//import ngves.asiainfo.core.common.ivalues.IQBORecommCategoryWareInfoValue;
//import ngves.asiainfo.core.ware.ivalues.IWareInfoPortalValue;


/***
 * @author lizq
 *商品页签bean 门户改版用
 */
public class RecommCategoryForFront implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String categoryName;//商品页签名称
	public String sortId;//排序（可不用。。）
	public List<WareInfoForFront> wareInfoList;//商品页签绑定礼品（之前的轮播IWareInfoPortalValue 在portal core里 不能引用 所以做了此转换）
	//public List<IQBORecommCategoryWareInfoValue> recommCategoryWareInfoList;////商品页签绑定礼品（自己写的查询）
	//public List<IWareInfoPortalValue> wareInfoPortalValueList;////商品页签绑定礼品（之前的轮播）
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getSortId() {
		return sortId;
	}
	public void setSortId(String sortId) {
		this.sortId = sortId;
	}
//	public List<IQBORecommCategoryWareInfoValue> getRecommCategoryWareInfoList() {
//		return recommCategoryWareInfoList;
//	}
//	public void setRecommCategoryWareInfoList(List<IQBORecommCategoryWareInfoValue> recommCategoryWareInfoList) {
//		this.recommCategoryWareInfoList = recommCategoryWareInfoList;
//	}
	public List<WareInfoForFront> getWareInfoList() {
		return wareInfoList;
	}
	public void setWareInfoList(List<WareInfoForFront> wareInfoList) {
		this.wareInfoList = wareInfoList;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	
	
}
