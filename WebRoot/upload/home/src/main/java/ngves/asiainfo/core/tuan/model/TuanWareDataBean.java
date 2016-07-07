/**
 * @date:2012-9-13
 *
 * Copyright 2012 asiainfo-linkage, Inc. All rights reserved. 
 * @author:shenfl
 */
package ngves.asiainfo.core.tuan.model;

import java.io.Serializable;

/**
 * 团购汇总-团购信息和礼品信息
 * 
 */
public class TuanWareDataBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6576822935169953732L;

	private long tuanID;

	private String tuanName;

	private String tuanMainPic;

	private long tuanSort;

	private long tuanDiscount;

	private long wareID;

	private String wareName;
	// 团购兑换数量
	private long tuanItemCount;
	// 统一积分数值
	private long wareIntegralValue;
	// 全球通当前积分数值
	private long wareGValue;
	// 动感地带当前M数值
	private long wareMValue;
	// 神州行当前积分值
	private long wareEValue;
	// 礼品主图片
	private String wareMainPic;

	/**
	 * @return the tuanID
	 */
	public long getTuanID() {
		return tuanID;
	}

	/**
	 * @param tuanID
	 *            the tuanID to set
	 */
	public void setTuanID(long tuanID) {
		this.tuanID = tuanID;
	}

	/**
	 * @return the tuanName
	 */
	public String getTuanName() {
		return tuanName;
	}

	/**
	 * @param tuanName
	 *            the tuanName to set
	 */
	public void setTuanName(String tuanName) {
		this.tuanName = tuanName;
	}

	/**
	 * @return the tuanMainPic
	 */
	public String getTuanMainPic() {
		return tuanMainPic;
	}

	/**
	 * @param tuanMainPic
	 *            the tuanMainPic to set
	 */
	public void setTuanMainPic(String tuanMainPic) {
		this.tuanMainPic = tuanMainPic;
	}

	/**
	 * @return the tuanSort
	 */
	public long getTuanSort() {
		return tuanSort;
	}

	/**
	 * @param tuanSort
	 *            the tuanSort to set
	 */
	public void setTuanSort(long tuanSort) {
		this.tuanSort = tuanSort;
	}

	/**
	 * @return the tuanDiscount
	 */
	public long getTuanDiscount() {
		return tuanDiscount;
	}

	/**
	 * @param tuanDiscount
	 *            the tuanDiscount to set
	 */
	public void setTuanDiscount(long tuanDiscount) {
		this.tuanDiscount = tuanDiscount;
	}

	/**
	 * @return the wareID
	 */
	public long getWareID() {
		return wareID;
	}

	/**
	 * @param wareID
	 *            the wareID to set
	 */
	public void setWareID(long wareID) {
		this.wareID = wareID;
	}

	/**
	 * @return the wareName
	 */
	public String getWareName() {
		return wareName;
	}

	/**
	 * @param wareName
	 *            the wareName to set
	 */
	public void setWareName(String wareName) {
		this.wareName = wareName;
	}

	/**
	 * @return the tuanItemCount
	 */
	public long getTuanItemCount() {
		return tuanItemCount;
	}

	/**
	 * @param tuanItemCount
	 *            the tuanItemCount to set
	 */
	public void setTuanItemCount(long tuanItemCount) {
		this.tuanItemCount = tuanItemCount;
	}

	/**
	 * @return the wareIntegralValue
	 */
	public long getWareIntegralValue() {
		return wareIntegralValue;
	}

	/**
	 * @param wareIntegralValue
	 *            the wareIntegralValue to set
	 */
	public void setWareIntegralValue(long wareIntegralValue) {
		this.wareIntegralValue = wareIntegralValue;
	}

	/**
	 * @return the wareGValue
	 */
	public long getWareGValue() {
		return wareGValue;
	}

	/**
	 * @param wareGValue
	 *            the wareGValue to set
	 */
	public void setWareGValue(long wareGValue) {
		this.wareGValue = wareGValue;
	}

	/**
	 * @return the wareMValue
	 */
	public long getWareMValue() {
		return wareMValue;
	}

	/**
	 * @param wareMValue
	 *            the wareMValue to set
	 */
	public void setWareMValue(long wareMValue) {
		this.wareMValue = wareMValue;
	}

	/**
	 * @return the wareEValue
	 */
	public long getWareEValue() {
		return wareEValue;
	}

	/**
	 * @param wareEValue
	 *            the wareEValue to set
	 */
	public void setWareEValue(long wareEValue) {
		this.wareEValue = wareEValue;
	}

	/**
	 * @return the wareMainPic
	 */
	public String getWareMainPic() {
		return wareMainPic;
	}

	/**
	 * @param wareMainPic
	 *            the wareMainPic to set
	 */
	public void setWareMainPic(String wareMainPic) {
		this.wareMainPic = wareMainPic;
	}

}
