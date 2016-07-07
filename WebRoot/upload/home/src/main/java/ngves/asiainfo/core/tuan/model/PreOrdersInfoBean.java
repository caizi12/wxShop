/**
 * @date:2012-10-23
 *
 * Copyright 2012 asiainfo-linkage, Inc. All rights reserved. 
 * @author:shenfl
 */
package ngves.asiainfo.core.tuan.model;

import java.io.Serializable;

public class PreOrdersInfoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long tuanId;
	
	private long itemCount;

	/**
	 * @return the tuanId
	 */
	public long getTuanId() {
		return tuanId;
	}

	/**
	 * @param tuanId the tuanId to set
	 */
	public void setTuanId(long tuanId) {
		this.tuanId = tuanId;
	}

	/**
	 * @return the itemCount
	 */
	public long getItemCount() {
		return itemCount;
	}

	/**
	 * @param itemCount the itemCount to set
	 */
	public void setItemCount(long itemCount) {
		this.itemCount = itemCount;
	}
}
