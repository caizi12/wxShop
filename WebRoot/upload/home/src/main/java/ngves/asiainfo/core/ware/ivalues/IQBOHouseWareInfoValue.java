package ngves.asiainfo.core.ware.ivalues;

import java.sql.Timestamp;

import com.ai.appframe2.common.DataStructInterface;

public interface IQBOHouseWareInfoValue extends DataStructInterface {

	public final static String S_BaseAmount = "BASE_AMOUNT";
	public final static String S_WareBrandId = "WARE_BRAND_ID";
	public final static String S_KindName = "KIND_NAME";
	public final static String S_FName = "F_NAME";
	public final static String S_WarehouseId = "WAREHOUSE_ID";
	public final static String S_BigKindName = "BIG_KIND_NAME";
	public final static String S_ProviderId = "PROVIDER_ID";
	public final static String S_StoragerCode = "STORAGER_CODE";
	public final static String S_DetailLink = "DETAIL_LINK";
	public final static String S_WarehouseState = "WAREHOUSE_STATE";
	public final static String S_HouseWareState = "HOUSE_WARE_STATE";
	public final static String S_ProviderName = "PROVIDER_NAME";
	public final static String S_WareCode = "WARE_CODE";
	public final static String S_WarehouseCode = "WAREHOUSE_CODE";
	public final static String S_StoragerName = "STORAGER_NAME";
	public final static String S_WareId = "WARE_ID";
	public final static String S_StoragerId = "STORAGER_ID";
	public final static String S_WareFirstKindId = "WARE_FIRST_KIND_ID";
	public final static String S_WarehouseType = "WAREHOUSE_TYPE";
	public final static String S_WareStatus = "WARE_STATUS";
	public final static String S_StatusCause = "STATUS_CAUSE";
	public final static String S_CurrentAmount = "CURRENT_AMOUNT";
	public final static String S_BadAmount = "BAD_AMOUNT";
	public final static String S_WareKindParentId = "WARE_KIND_PARENT_ID";
	public final static String S_WayAmount = "WAY_AMOUNT";
	public final static String S_WarnAmount = "WARN_AMOUNT";
	public final static String S_ConvertibleAmount = "CONVERTIBLE_AMOUNT";
	public final static String S_WareName = "WARE_NAME";
	public final static String S_ProviderCode = "PROVIDER_CODE";
	public final static String S_SecurityAmount = "SECURITY_AMOUNT";
	public final static String S_IsDefaultKind = "IS_DEFAULT_KIND";
	public final static String S_WarehouseName = "WAREHOUSE_NAME";
	public final static String S_WareKindId = "WARE_KIND_ID";
	public final static String S_BadOutAmount = "BAD_OUT_AMOUNT";
	public final static String S_ExchangedAmount = "EXCHANGED_AMOUNT";
	public final static String S_OpenDate = "OPEN_DATE";
	public final static String S_CloseDate = "CLOSE_DATE";
	//仓库省份
	public final static String S_ProvinceCode = "PROVINCE_CODE";
	public final static String S_ProvinceName = "PROVINCE_NAME";
	
	public final static  String S_WareKindInfoId = "WARE_KIND_INFO_ID";
	public final static  String S_WareKindInfoName = "WARE_KIND_INFO_NAME";
	
	public long getWareKindInfoId();
	
	public String getWareKindInfoName();
	
	public  void setWareKindInfoId(long value);
	
	public  void setWareKindInfoName(String value);

	public long getBaseAmount();

	public long getWareBrandId();

	public String getKindName();

	public String getFName();

	public long getWarehouseId();

	public String getBigKindName();

	public long getProviderId();

	public String getStoragerCode();

	public String getDetailLink();

	public String getWarehouseState();

	public String getHouseWareState();

	public String getProviderName();

	public String getWareCode();

	public String getWarehouseCode();

	public String getStoragerName();

	public long getWareId();

	public long getStoragerId();

	public long getWareFirstKindId();

	public String getWarehouseType();

	public String getOpenDate();

	public String getCloseDate();

	public String getWareStatus();

	public String getStatusCause();

	public long getCurrentAmount();

	public long getBadAmount();

	public long getWareKindParentId();

	public long getWayAmount();

	public long getExchangedAmount();

	public long getWarnAmount();

	public long getConvertibleAmount();

	public String getWareName();

	public String getProviderCode();

	public long getSecurityAmount();

	public String getIsDefaultKind();

	public String getWarehouseName();

	public long getWareKindId();

	public long getBadOutAmount();

	public void setBaseAmount(long value);

	public void setWareBrandId(long value);

	public void setKindName(String value);

	public void setFName(String value);

	public void setWarehouseId(long value);

	public void setBigKindName(String value);

	public void setProviderId(long value);

	public void setStoragerCode(String value);

	public void setDetailLink(String value);

	public void setWarehouseState(String value);

	public void setHouseWareState(String value);

	public void setProviderName(String value);

	public void setWareCode(String value);

	public void setWarehouseCode(String value);

	public void setStoragerName(String value);

	public void setWareId(long value);

	public void setStoragerId(long value);

	public void setWareFirstKindId(long value);

	public void setOpenDate(Timestamp value);

	public void setCloseDate(Timestamp value);

	public void setWarehouseType(String value);

	public void setWareStatus(String value);

	public void setStatusCause(String value);

	public void setCurrentAmount(long value);

	public void setExchangedAmount(long value);

	public void setBadAmount(long value);

	public void setWareKindParentId(long value);

	public void setWayAmount(long value);

	public void setWarnAmount(long value);

	public void setConvertibleAmount(long value);

	public void setWareName(String value);

	public void setProviderCode(String value);

	public void setSecurityAmount(long value);

	public void setIsDefaultKind(String value);

	public void setWarehouseName(String value);

	public void setWareKindId(long value);

	public void setBadOutAmount(long value);
	
	public String getProvinceCode();

	public void setProvinceCode(String value);
	
	public String getProvinceName();

	public void setProvinceName(String value);

}
