/**
 * @date:2012-9-13
 *
 * Copyright 2012 asiainfo-linkage, Inc. All rights reserved. 
 * @author:shenfl
 */
package ngves.asiainfo.core.tuan.model;

import java.io.Serializable;

/**
 * 汇总页面-小类数据
 * 
 */
public class WareKindBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8971284345939817885L;

	private long kindID;

	private String kindName;

	/**
	 * @return the kindID
	 */
	public long getKindID() {
		return kindID;
	}

	/**
	 * @param kindID
	 *            the kindID to set
	 */
	public void setKindID(long kindID) {
		this.kindID = kindID;
	}

	/**
	 * @return the kindName
	 */
	public String getKindName() {
		return kindName;
	}

	/**
	 * @param kindName
	 *            the kindName to set
	 */
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

}
