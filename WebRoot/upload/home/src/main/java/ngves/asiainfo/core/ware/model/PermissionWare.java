/**
 * Copyright (c) 2012 asiainfo-linkage.com
 */
package ngves.asiainfo.core.ware.model;

import java.io.Serializable;

/**
 * @author shenfl
 *
 */
public class PermissionWare implements Serializable {
    private static final long serialVersionUID = -7547737281261476298L;

    //优惠礼品ID
    private long wareId;

    //优惠礼品名称
    private String wareName;
    
    //支付方式
    private String payType;
    
    //图标路径
    private String picFile;
    
    //混合支付现金
    private long payCash;
    
    //混合支付积分
    private long payIntegral;
    
    //纯积分
    private long Integral;

    public long getWareId() {
        return wareId;
    }

    public void setWareId(long wareId) {
        this.wareId = wareId;
    }

    public String getWareName() {
        return wareName;
    }

    public void setWareName(String wareName) {
        this.wareName = wareName;
    }

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getPicFile() {
		return picFile;
	}

	public void setPicFile(String picFile) {
		this.picFile = picFile;
	}

	public long getPayCash() {
		return payCash;
	}

	public void setPayCash(long payCash) {
		this.payCash = payCash;
	}

	public long getPayIntegral() {
		return payIntegral;
	}

	public void setPayIntegral(long payIntegral) {
		this.payIntegral = payIntegral;
	}

	public long getIntegral() {
		return Integral;
	}

	public void setIntegral(long pureIntegral) {
		this.Integral = pureIntegral;
	}

}
