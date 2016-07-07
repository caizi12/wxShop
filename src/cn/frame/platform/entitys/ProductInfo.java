package cn.frame.platform.entitys;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import cn.frame.platform.common.util.json.CustomDateSerializer;

public class ProductInfo {
    private Integer productId;

    private Integer productCode;

    private String productName;

    private String title;

    private String productImg;

    private String status;

    private String productBrand;

    private String productKind;

    private Date createTime;

    private Date updateTime;

    private String productDetail;
    
    private Double price;
    private Double discountPrice;
    private String isRecomend;
    private Integer productNum;
    private Integer exchangeNum;
    private String deliverType;
    private String deliverPrice;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductCode() {
        return productCode;
    }

    public void setProductCode(Integer productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductKind() {
        return productKind;
    }

    public void setProductKind(String productKind) {
        this.productKind = productKind;
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

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getIsRecomend() {
		return isRecomend;
	}

	public void setIsRecomend(String isRecomend) {
		this.isRecomend = isRecomend;
	}

	public Integer getProductNum() {
		return productNum;
	}

	public void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}

	public Integer getExchangeNum() {
		return exchangeNum;
	}

	public void setExchangeNum(Integer exchangeNum) {
		this.exchangeNum = exchangeNum;
	}

	public String getDeliverType() {
		return deliverType;
	}

	public void setDeliverType(String deliverType) {
		this.deliverType = deliverType;
	}

	public String getDeliverPrice() {
		return deliverPrice;
	}

	public void setDeliverPrice(String deliverPrice) {
		this.deliverPrice = deliverPrice;
	}
    
}