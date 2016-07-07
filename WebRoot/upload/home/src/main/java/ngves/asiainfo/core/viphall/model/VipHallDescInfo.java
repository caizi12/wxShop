/**
 * Copyright (c) 2013 asiainfo.com
 * 2013-2-26 上午 10:02:29
 */
package ngves.asiainfo.core.viphall.model;

import java.io.Serializable;

/**
 * 封装专题内容属性信息
 * @author:shenfl
 */
public class VipHallDescInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9201101079222058820L;


	private long descDefineId;
	private String descDefineName;
	private String wareDescValue;
	public long getDescDefineId() {
		return descDefineId;
	}
	public void setDescDefineId(long descDefineId) {
		this.descDefineId = descDefineId;
	}
	public String getDescDefineName() {
		return descDefineName;
	}
	public void setDescDefineName(String descDefineName) {
		this.descDefineName = descDefineName;
	}
	public String getWareDescValue() {
		return wareDescValue;
	}
	public void setWareDescValue(String wareDescValue) {
		this.wareDescValue = wareDescValue;
	}
}
