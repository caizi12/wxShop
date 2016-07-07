package ngves.asiainfo.core.ware.ivalues;

import java.sql.Timestamp;

import com.ai.appframe2.common.DataStructInterface;

public interface IWareInfoParentValue extends DataStructInterface {

	public final static String S_DeliverType = "DELIVER_TYPE";
	public final static String S_WarehouseId = "WAREHOUSE_ID";
	public final static String S_StatusCause = "STATUS_CAUSE";
	public final static String S_RichFuncDesc = "RICH_FUNC_DESC";
	public final static String S_WareId = "WARE_ID";
	public final static String S_CloseDate = "CLOSE_DATE";
	public final static String S_IsOnline = "IS_ONLINE";
	public final static String S_AmendsFee = "AMENDS_FEE";
	public final static String S_FuncDesc = "FUNC_DESC";
	public final static String S_OpenDate = "OPEN_DATE";
	public final static String S_WareBrandId = "WARE_BRAND_ID";
	public final static String S_CountValue = "COUNT_VALUE";
	public final static String S_ProvinceCode = "PROVINCE_CODE";
	public final static String S_WareStorageType = "WARE_STORAGE_TYPE";
	public final static String S_WareCode = "WARE_CODE";
	public final static String S_PartnerId = "PARTNER_ID";
	public final static String S_PartnerWareBrandId = "PARTNER_WARE_BRAND_ID";
	public final static String S_PreOcDate = "PRE_OC_DATE";
	public final static String S_WareName = "WARE_NAME";
	public final static String S_MarketPrice = "MARKET_PRICE";
	public final static String S_Note = "NOTE";
	public final static String S_LastUpdateDate = "LAST_UPDATE_DATE";
	public final static String S_Alias = "ALIAS";
	public final static String S_LastUpdateStaffId = "LAST_UPDATE_STAFF_ID";
	public final static String S_Keywords = "KEYWORDS";
	//新增两个字段  清单和售后保障
	public final static String S_PackingList = "PACKING_LIST";
	public final static String S_SafeGuard = "SAFE_GUARD";
	
	public final static String S_AppVersion = "APP_VERSION";
	public final static String S_CreateDate = "CREATE_DATE";
	public final static String S_WareStatus = "WARE_STATUS";
	public final static String S_ShopPrice = "SHOP_PRICE";
	public final static String S_CountType = "COUNT_TYPE";
	public final static String S_TypeCode = "TYPE_CODE";

	public final static String S_PayType = "PAY_TYPE";
	
	public final static  String S_IsTestWare="IS_TEST_WARE";
	
	public  String getIsTestWare();
	
	public void setIsTestWare(String value);
	
	public String getDeliverType();

	public long getWarehouseId();

	public String getStatusCause();

	public String getRichFuncDesc();

	public long getWareId();

	public Timestamp getCloseDate();

	public String getIsOnline();

	public long getAmendsFee();

	public String getFuncDesc();

	public Timestamp getOpenDate();

	public long getWareBrandId();

	public long getCountValue();

	public String getProvinceCode();

	public String getWareStorageType();

	public String getWareCode();

	public long getPartnerId();

	public long getPartnerWareBrandId();

	public Timestamp getPreOcDate();

	public String getWareName();

	public long getMarketPrice();

	public String getNote();

	public Timestamp getLastUpdateDate();

	public String getAlias();

	public long getLastUpdateStaffId();

	public String getKeywords();

	public long getAppVersion();

	public Timestamp getCreateDate();

	public String getWareStatus();

	public long getShopPrice();

	public String getCountType();
	
	public long getTypeCode();
	
	

	public void setDeliverType(String value);

	public void setWarehouseId(long value);

	public void setStatusCause(String value);

	public void setRichFuncDesc(String value);

	public void setWareId(long value);

	public void setCloseDate(Timestamp value);

	public void setIsOnline(String value);

	public void setAmendsFee(long value);

	public void setFuncDesc(String value);

	public void setOpenDate(Timestamp value);

	public void setWareBrandId(long value);

	public void setCountValue(long value);

	public void setProvinceCode(String value);

	public void setWareStorageType(String value);

	public void setWareCode(String value);

	public void setPartnerId(long value);

	public void setPartnerWareBrandId(long value);

	public void setPreOcDate(Timestamp value);

	public void setWareName(String value);

	public void setMarketPrice(long value);

	public void setNote(String value);

	public void setLastUpdateDate(Timestamp value);

	public void setAlias(String value);

	public void setLastUpdateStaffId(long value);

	public void setKeywords(String value);

	public void setAppVersion(long value);

	public void setCreateDate(Timestamp value);

	public void setWareStatus(String value);

	public void setShopPrice(long value);

	public void setCountType(String value);
	
	public void setTypeCode(long value);
	
    public void setPackingList(String value);
	
	public void setSafeGuard(String value);
	
	public String getPackingList();
	
	public String getSafeGuard();
	
	public String getPayType();
	public void setPayType(String value);
}
