/**
 * @date:2012-9-13
 *
 * Copyright 2012 asiainfo-linkage, Inc. All rights reserved. 
 * @author:shenfl
 */
package ngves.asiainfo.core.tuan.model;

import java.util.List;

/**
 * 团购汇总页面Bean
 * 
 */
public class TuanInfoVO {

	private List<WareKindBean> wareKindList;

	private List<TuanWareDataBean> tuanDataList;

	/**
	 * @return the wareKindList
	 */
	public List<WareKindBean> getWareKindList() {
		return wareKindList;
	}

	/**
	 * @param wareKindList
	 *            the wareKindList to set
	 */
	public void setWareKindList(List<WareKindBean> wareKindList) {
		this.wareKindList = wareKindList;
	}

	/**
	 * @return the tuanDataList
	 */
	public List<TuanWareDataBean> getTuanDataList() {
		return tuanDataList;
	}

	/**
	 * @param tuanDataList
	 *            the tuanDataList to set
	 */
	public void setTuanDataList(List<TuanWareDataBean> tuanDataList) {
		this.tuanDataList = tuanDataList;
	}

}
