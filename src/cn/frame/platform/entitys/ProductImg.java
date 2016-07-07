package cn.frame.platform.entitys;

import java.util.Date;

public class ProductImg {
    private Integer productId;
   
    private Integer imgId;
   
    private String imgUrl;

    private Date createTime;
    
    public ProductImg(){};
    
    public ProductImg(String imgUrl,Integer imgId){
    	this.imgUrl=imgUrl;
    	this.imgId=imgId;
    }
  
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getImgId() {
		return imgId;
	}

	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

  
}