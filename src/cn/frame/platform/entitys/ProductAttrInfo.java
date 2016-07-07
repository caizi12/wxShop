package cn.frame.platform.entitys;

import java.util.Date;

public class ProductAttrInfo {
    private Integer productAttrId;

    private Integer attrId;

    private String productId;

    private String attrVal;

    private Date createTime;
    
    private String attrName;
    
    private ProductAttrType productAttrType;

    public Integer getProductAttrId() {
        return productAttrId;
    }

    public void setProductAttrId(Integer productAttrId) {
        this.productAttrId = productAttrId;
    }

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }


    public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getAttrVal() {
		return attrVal;
	}

	public void setAttrVal(String attrVal) {
		this.attrVal = attrVal;
	}

	public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public ProductAttrType getProductAttrType() {
		return productAttrType;
	}

	public void setProductAttrType(ProductAttrType productAttrType) {
		this.productAttrType = productAttrType;
	}
    
}