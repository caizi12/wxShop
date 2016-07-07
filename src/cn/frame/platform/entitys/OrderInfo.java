package cn.frame.platform.entitys;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import cn.frame.platform.common.util.json.CustomDateSerializer;

public class OrderInfo {
    private String orderId;

    private String memberId;

    private String orderStatus;

    private String payType;

    private String payStatus;

    private Double orderCash;

    private String sendPrice;

    private String linkman;

    private String phone;

    private String address;

    private String postCode;

    private String sendTime;

    private Date createTime;

    private Date updateTime;

    private String remark;
    
    private Integer givePoint;
    
    private String orderCashChangeRemark;
    private String expressCompany;
    private String expressId;
    private String payTradeId;
    private String payOutRefundNo;
    private Double payCash;
    private Date payTime;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }


    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }


    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public Double getOrderCash() {
        return orderCash;
    }

    public void setOrderCash(Double orderCash) {
        this.orderCash = orderCash;
    }

    public String getSendPrice() {
        return sendPrice;
    }

    public void setSendPrice(String sendPrice) {
        this.sendPrice = sendPrice;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    @JsonSerialize(using=CustomDateSerializer.class)
    public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@JsonSerialize(using=CustomDateSerializer.class)
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

	public Integer getGivePoint() {
		return givePoint;
	}

	public void setGivePoint(Integer givePoint) {
		this.givePoint = givePoint;
	}

	public String getOrderCashChangeRemark() {
		return orderCashChangeRemark;
	}

	public void setOrderCashChangeRemark(String orderCashChangeRemark) {
		this.orderCashChangeRemark = orderCashChangeRemark;
	}


	public String getExpressCompany() {
		return expressCompany;
	}

	public void setExpressCompany(String expressCompany) {
		this.expressCompany = expressCompany;
	}

	public String getExpressId() {
		return expressId;
	}

	public void setExpressId(String expressId) {
		this.expressId = expressId;
	}

	public String getPayTradeId() {
		return payTradeId;
	}

	public void setPayTradeId(String payTradeId) {
		this.payTradeId = payTradeId;
	}

	public String getPayOutRefundNo() {
		return payOutRefundNo;
	}

	public void setPayOutRefundNo(String payOutRefundNo) {
		this.payOutRefundNo = payOutRefundNo;
	}

	public Double getPayCash() {
		return payCash;
	}

	public void setPayCash(Double payCash) {
		this.payCash = payCash;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
    
    
}
