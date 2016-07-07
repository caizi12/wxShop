package ngves.asiainfo.core.ware.ivalues;

import java.sql.Timestamp;

import com.ai.appframe2.common.DataStructInterface;

public interface IBusiWareInfoValue extends DataStructInterface {

	public final static String S_DeliverType = "DELIVER_TYPE";
	public final static String S_WarehouseId = "WAREHOUSE_ID";
	public final static String S_RichFuncDesc = "RICH_FUNC_DESC";
	public final static String S_WareId = "WARE_ID";
	public final static String S_Partner = "PARTNER";
	public final static String S_AmendsFee = "AMENDS_FEE";
	public final static String S_FuncDesc = "FUNC_DESC";
	public final static String S_WareBrandId = "WARE_BRAND_ID";
	public final static String S_CountValue = "COUNT_VALUE";
	public final static String S_ProvinceCode = "PROVINCE_CODE";
	public final static String S_WareType = "WARE_TYPE";
	public final static String S_WareStorageType = "WARE_STORAGE_TYPE";
	public final static String S_WareCode = "WARE_CODE";
	public final static String S_PartnerWareBrandId = "PARTNER_WARE_BRAND_ID";
	public final static String S_WareName = "WARE_NAME";
	public final static String S_MarketPrice = "MARKET_PRICE";
	public final static String S_Note = "NOTE";
	public final static String S_LastUpdateDate = "LAST_UPDATE_DATE";
	public final static String S_BusiWareId = "BUSI_WARE_ID";
	public final static String S_Alias = "ALIAS";
	public final static String S_LastUpdateStaffId = "LAST_UPDATE_STAFF_ID";
	public final static String S_Keywords = "KEYWORDS";
	public final static String S_BusiState = "BUSI_STATE";
	public final static String S_BusiIdParent = "BUSI_ID_PARENT";
	public final static String S_BusiId = "BUSI_ID";
	public final static String S_ShopPrice = "SHOP_PRICE";
	public final static String S_CountType = "COUNT_TYPE";
	public final static String S_PackingList = "PACKING_LIST";
	public final static String S_SafeGuard = "SAFE_GUARD";

	public String getDeliverType();

	public long getWarehouseId();

	public String getRichFuncDesc();

	public long getWareId();

	public long getPartner();

	public long getAmendsFee();

	public String getFuncDesc();

	public long getWareBrandId();

	public long getCountValue();

	public String getProvinceCode();

	public long getWareType();

	public String getWareStorageType();

	public String getWareCode();

	public long getPartnerWareBrandId();

	public String getWareName();

	public long getMarketPrice();

	public String getNote();

	public Timestamp getLastUpdateDate();

	public long getBusiWareId();

	public String getAlias();

	public long getLastUpdateStaffId();

	public String getKeywords();

	public String getBusiState();

	public long getBusiIdParent();

	public long getBusiId();

	public long getShopPrice();

	public String getCountType();
	
	public String getPackingList();
	
	public String getSafeGuard();

	public void setDeliverType(String value);

	public void setWarehouseId(long value);

	public void setRichFuncDesc(String value);

	public void setWareId(long value);

	public void setPartner(long value);

	public void setAmendsFee(long value);

	public void setFuncDesc(String value);

	public void setWareBrandId(long value);

	public void setCountValue(long value);

	public void setProvinceCode(String value);

	public void setWareType(long value);

	public void setWareStorageType(String value);

	public void setWareCode(String value);

	public void setPartnerWareBrandId(long value);

	public void setWareName(String value);

	public void setMarketPrice(long value);

	public void setNote(String value);

	public void setLastUpdateDate(Timestamp value);

	public void setBusiWareId(long value);

	public void setAlias(String value);

	public void setLastUpdateStaffId(long value);

	public void setKeywords(String value);

	public void setBusiState(String value);

	public void setBusiIdParent(long value);

	public void setBusiId(long value);

	public void setShopPrice(long value);

	public void setCountType(String value);
	
	public void setPackingList(String value);
	
	public void setSafeGuard(String value);
}
