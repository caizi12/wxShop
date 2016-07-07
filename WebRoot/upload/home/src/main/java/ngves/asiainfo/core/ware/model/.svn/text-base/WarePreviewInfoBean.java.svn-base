/**
 * Copyright (c) 2010 asiainfo.com
 * 2010-10-26 上午10:23:44
 */
package ngves.asiainfo.core.ware.model;

import java.util.List;

import ngves.asiainfo.core.ware.ivalues.IQBOBusiWareDescValue;
import ngves.asiainfo.core.ware.ivalues.IQBOWareImageValue;
import ngves.asiainfo.core.ware.model.MagBean;

import java.io.Serializable;

/**
 * 
 * 礼品预览信息
 * 
 * @author huangsong
 */
public class WarePreviewInfoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8440424816427097881L;
	private long wareId;
	/**
	 * 品牌ID
	 */
	private long wareBrandId;
	private String wareCode;
	private String wareName;
	
	/**
	 * 活动礼品类别（国家大剧院、通票、在线选座）
	 */
	private String typeCode;
	

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	/**
	 * 商城价
	 */
	private long shopPrice;
	/**
	 * 市场价
	 */
	private long marketPrice;
	/**
	 * 结算价
	 */
	private long countValue;

	/**
	 * 礼品小类ID
	 */
	private long wareKindId;

	/**
	 * 礼品品牌名称
	 */
	private String wareBrandName;

	/**
	 * 不同的礼品配送方式是不同的 00:实物配送 01:虚拟无物流 02:礼品商自配送 03:无配送 最终有哪些配送方式不同配送方式的流程是啥样的 待定
	 */
	private String deliverType;
	/**
	 * 00:存放于大区仓库 01:存放于中心仓库 02:存放于虚拟仓库 03:无库存
	 */
	private String wareStorageType;
	private String provinceCode;
	/**
	 * 0:应收结算 1:消费后结算
	 */
	private String countType;
	/**
	 * 礼品商ID
	 */
	private long partner;
	/**
	 * 赔付费，目前没有使用
	 */
	// private long amendsFee;

	private String funcDesc;
	private long wareHouseId;

	/**
	 * 礼品图片信息
	 */
	private IQBOWareImageValue[] wareImages;
	/**
	 * 礼品属性信息
	 */
	private IQBOBusiWareDescValue[] wareDescs;

	/**
	 *重要提示属性
	 */
	private String importantDesc;
	
	/**
	 * 是否展示礼品页签
	 */
	private boolean isShowTag = false;
	
	/**
	 * 富文本(礼品介绍页签展示信息)
	 */
	private String richTextDescInfo = null;
	
	private String alias;
	
	/**
	 * 发货清单  售后保障
	 */
	private String packingList;
	private String safeGuard;

	// --是否为期刊杂志礼品---
	private boolean isMagWare;

	public boolean isMagWare() {
		return isMagWare;
	}

	public void setMagWare(boolean isMagWare) {
		this.isMagWare = isMagWare;
	}

	/**
	 * 期刊礼品信息
	 */
	private List<MagBean> MagBean;

	public List<MagBean> getMagBean() {
		return MagBean;
	}

	public void setMagBean(List<MagBean> magBean) {
		MagBean = magBean;
	}

	/**
	 * 支持短信兑换
	 */
	private boolean canMobileExchange;

	public boolean isCanMobileExchange() {
		return canMobileExchange;
	}

	public void setCanMobileExchange(boolean canMobileExchange) {
		this.canMobileExchange = canMobileExchange;
	}

	/**
	 * 短信兑换码
	 */
	private String mobileExchangeCode;

	public String getMobileExchangeCode() {
		return mobileExchangeCode;
	}

	public void setMobileExchangeCode(String mobileExchangeCode) {
		this.mobileExchangeCode = mobileExchangeCode;
	}

	public long getWareId() {
		return wareId;
	}

	public void setWareId(long wareId) {
		this.wareId = wareId;
	}

	public long getWareBrandId() {
		return wareBrandId;
	}

	public void setWareBrandId(long wareBrandId) {
		this.wareBrandId = wareBrandId;
	}

	public String getWareCode() {
		return wareCode;
	}

	public void setWareCode(String wareCode) {
		this.wareCode = wareCode;
	}

	public String getWareName() {
		return wareName;
	}

	public void setWareName(String wareName) {
		this.wareName = wareName;
	}

	public long getShopPrice() {
		return shopPrice;
	}

	public void setShopPrice(long shopPrice) {
		this.shopPrice = shopPrice;
	}

	public long getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(long marketPrice) {
		this.marketPrice = marketPrice;
	}

	public long getCountValue() {
		return countValue;
	}

	public void setCountValue(long countValue) {
		this.countValue = countValue;
	}

	public String getDeliverType() {
		return deliverType;
	}

	public void setDeliverType(String deliverType) {
		this.deliverType = deliverType;
	}

	public String getWareStorageType() {
		return wareStorageType;
	}

	public void setWareStorageType(String wareStorageType) {
		this.wareStorageType = wareStorageType;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCountType() {
		return countType;
	}

	public void setCountType(String countType) {
		this.countType = countType;
	}

	public long getPartner() {
		return partner;
	}

	public void setPartner(long partner) {
		this.partner = partner;
	}

	public String getFuncDesc() {
		return funcDesc;
	}

	public void setFuncDesc(String funcDesc) {
		this.funcDesc = funcDesc;
	}

	public long getWareHouseId() {
		return wareHouseId;
	}

	public void setWareHouseId(long wareHouseId) {
		this.wareHouseId = wareHouseId;
	}

	public IQBOWareImageValue[] getWareImages() {
		return wareImages;
	}

	public void setWareImages(IQBOWareImageValue[] wareImages) {
		this.wareImages = wareImages;
	}

	public IQBOBusiWareDescValue[] getWareDescs() {
		return wareDescs;
	}

	public void setWareDescs(IQBOBusiWareDescValue[] wareDescs) {
		this.wareDescs = wareDescs;
	}

	public String getImportantDesc() {
		return importantDesc;
	}

	public void setImportantDesc(String importantDesc) {
		this.importantDesc = importantDesc;
	}

	public long getWareKindId() {
		return wareKindId;
	}

	public void setWareKindId(long wareKindId) {
		this.wareKindId = wareKindId;
	}

	public String getWareBrandName() {
		return wareBrandName;
	}

	public void setWareBrandName(String wareBrandName) {
		this.wareBrandName = wareBrandName;
	}
	
	public boolean isShowTag() {
		return isShowTag;
	}

	public void setShowTag(boolean isShowTag) {
		this.isShowTag = isShowTag;
	}

	public String getRichTextDescInfo() {
		return richTextDescInfo;
	}

	public void setRichTextDescInfo(String richTextDescInfo) {
		this.richTextDescInfo = richTextDescInfo;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getPackingList() {
		return packingList;
	}

	public void setPackingList(String packingList) {
		this.packingList = packingList;
	}

	public String getSafeGuard() {
		return safeGuard;
	}

	public void setSafeGuard(String safeGuard) {
		this.safeGuard = safeGuard;
	}
	
}
