package cn.frame.platform.entitys;

import java.util.Date;

public class ProductAttrType {
    private Integer attrId;

    private String attrKind;

    private String attrName;

    private String status;

    private Integer sortId;

    private String attrType;

    private Date createTime;
    
    
    private ProductAttrInfo productAttrInfo;

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    public String getAttrKind() {
        return attrKind;
    }

    public void setAttrKind(String attrKind) {
        this.attrKind = attrKind;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getAttrType() {
        return attrType;
    }

    public void setAttrType(String attrType) {
        this.attrType = attrType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public ProductAttrInfo getProductAttrInfo() {
		return productAttrInfo;
	}

	public void setProductAttrInfo(ProductAttrInfo productAttrInfo) {
		this.productAttrInfo = productAttrInfo;
	}
    
    
}