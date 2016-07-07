package ngves.asiainfo.core.ware.bo;

import java.sql.Timestamp;

import ngves.asiainfo.core.ware.ivalues.IWareInfoValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class WareInfoBean extends DataContainer implements DataContainerInterface, IWareInfoValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.ware.bo.WareInfo";

	public final static String S_DeliverType = "DELIVER_TYPE";
	public final static String S_WarehouseId = "WAREHOUSE_ID";
	public final static String S_StatusCause = "STATUS_CAUSE";
	public final static String S_RichFuncDesc = "RICH_FUNC_DESC";
	public final static String S_WareId = "WARE_ID";
	public final static String S_CloseDate = "CLOSE_DATE";
	public final static String S_AmendsFee = "AMENDS_FEE";
	public final static String S_FuncDesc = "FUNC_DESC";
	public final static String S_OpenDate = "OPEN_DATE";
	public final static String S_WareBrandId = "WARE_BRAND_ID";
	public final static String S_CountValue = "COUNT_VALUE";
	public final static String S_ProvinceCode = "PROVINCE_CODE";
	public final static String S_WareType = "WARE_TYPE";
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
	public final static String S_AppVersion = "APP_VERSION";
	public final static String S_CreateDate = "CREATE_DATE";
	public final static String S_WareStatus = "WARE_STATUS";
	public final static String S_ShopPrice = "SHOP_PRICE";
	public final static String S_CountType = "COUNT_TYPE";

	public final static String S_PackingList = "PACKING_LIST";
	public final static String S_SafeGuard = "SAFE_GUARD";

	
	
	//统一积分新增的字段
	public final static String S_WareIntegralValue = "WARE_INTEGRAL_VALUE";
	
	//混合积分改造
	public final static String S_PayType = "PAY_TYPE";
	public final static String S_PayIntegral = "PAY_INTEGRAL";
	public final static String S_PayCash = "PAY_CASH";

	
	public WareInfoBean() throws AIException {
		super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initDeliverType(String value) {
		this.initProperty(S_DeliverType, value);
	}

	public void setDeliverType(String value) {
		this.set(S_DeliverType, value);
	}

	public void setDeliverTypeNull() {
		this.set(S_DeliverType, null);
	}

	public String getDeliverType() {
		return DataType.getAsString(this.get(S_DeliverType));

	}

	public String getDeliverTypeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_DeliverType));
	}

	public void initWarehouseId(long value) {
		this.initProperty(S_WarehouseId, new Long(value));
	}

	public void setWarehouseId(long value) {
		this.set(S_WarehouseId, new Long(value));
	}

	public void setWarehouseIdNull() {
		this.set(S_WarehouseId, null);
	}

	public long getWarehouseId() {
		return DataType.getAsLong(this.get(S_WarehouseId));

	}

	public long getWarehouseIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_WarehouseId));
	}

	public void initStatusCause(String value) {
		this.initProperty(S_StatusCause, value);
	}

	public void setStatusCause(String value) {
		this.set(S_StatusCause, value);
	}

	public void setStatusCauseNull() {
		this.set(S_StatusCause, null);
	}

	public String getStatusCause() {
		return DataType.getAsString(this.get(S_StatusCause));

	}

	public String getStatusCauseInitialValue() {
		return DataType.getAsString(this.getOldObj(S_StatusCause));
	}

	public void initRichFuncDesc(String value) {
		this.initProperty(S_RichFuncDesc, value);
	}

	public void setRichFuncDesc(String value) {
		this.set(S_RichFuncDesc, value);
	}

	public void setRichFuncDescNull() {
		this.set(S_RichFuncDesc, null);
	}

	public String getRichFuncDesc() {
		return DataType.getAsString(this.get(S_RichFuncDesc));

	}

	public String getRichFuncDescInitialValue() {
		return DataType.getAsString(this.getOldObj(S_RichFuncDesc));
	}

	public void initWareId(long value) {
		this.initProperty(S_WareId, new Long(value));
	}

	public void setWareId(long value) {
		this.set(S_WareId, new Long(value));
	}

	public void setWareIdNull() {
		this.set(S_WareId, null);
	}

	public long getWareId() {
		return DataType.getAsLong(this.get(S_WareId));

	}

	public long getWareIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_WareId));
	}

	public void initCloseDate(Timestamp value) {
		this.initProperty(S_CloseDate, value);
	}

	public void setCloseDate(Timestamp value) {
		this.set(S_CloseDate, value);
	}

	public void setCloseDateNull() {
		this.set(S_CloseDate, null);
	}

	public Timestamp getCloseDate() {
		return DataType.getAsDateTime(this.get(S_CloseDate));

	}

	public Timestamp getCloseDateInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_CloseDate));
	}

	public void initAmendsFee(long value) {
		this.initProperty(S_AmendsFee, new Long(value));
	}

	public void setAmendsFee(long value) {
		this.set(S_AmendsFee, new Long(value));
	}

	public void setAmendsFeeNull() {
		this.set(S_AmendsFee, null);
	}

	public long getAmendsFee() {
		return DataType.getAsLong(this.get(S_AmendsFee));

	}

	public long getAmendsFeeInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_AmendsFee));
	}

	public void initFuncDesc(String value) {
		this.initProperty(S_FuncDesc, value);
	}

	public void setFuncDesc(String value) {
		this.set(S_FuncDesc, value);
	}

	public void setFuncDescNull() {
		this.set(S_FuncDesc, null);
	}

	public String getFuncDesc() {
		return DataType.getAsString(this.get(S_FuncDesc));

	}

	public String getFuncDescInitialValue() {
		return DataType.getAsString(this.getOldObj(S_FuncDesc));
	}

	public void initOpenDate(Timestamp value) {
		this.initProperty(S_OpenDate, value);
	}

	public void setOpenDate(Timestamp value) {
		this.set(S_OpenDate, value);
	}

	public void setOpenDateNull() {
		this.set(S_OpenDate, null);
	}

	public Timestamp getOpenDate() {
		return DataType.getAsDateTime(this.get(S_OpenDate));

	}

	public Timestamp getOpenDateInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_OpenDate));
	}

	public void initWareBrandId(long value) {
		this.initProperty(S_WareBrandId, new Long(value));
	}

	public void setWareBrandId(long value) {
		this.set(S_WareBrandId, new Long(value));
	}

	public void setWareBrandIdNull() {
		this.set(S_WareBrandId, null);
	}

	public long getWareBrandId() {
		return DataType.getAsLong(this.get(S_WareBrandId));

	}

	public long getWareBrandIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_WareBrandId));
	}

	public void initCountValue(long value) {
		this.initProperty(S_CountValue, new Long(value));
	}

	public void setCountValue(long value) {
		this.set(S_CountValue, new Long(value));
	}

	public void setCountValueNull() {
		this.set(S_CountValue, null);
	}

	public long getCountValue() {
		return DataType.getAsLong(this.get(S_CountValue));

	}

	public long getCountValueInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_CountValue));
	}

	public void initProvinceCode(String value) {
		this.initProperty(S_ProvinceCode, value);
	}

	public void setProvinceCode(String value) {
		this.set(S_ProvinceCode, value);
	}

	public void setProvinceCodeNull() {
		this.set(S_ProvinceCode, null);
	}

	public String getProvinceCode() {
		return DataType.getAsString(this.get(S_ProvinceCode));

	}

	public String getProvinceCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ProvinceCode));
	}

	public void initWareType(long value) {
		this.initProperty(S_WareType, new Long(value));
	}

	public void setWareType(long value) {
		this.set(S_WareType, new Long(value));
	}

	public void setWareTypeNull() {
		this.set(S_WareType, null);
	}

	public long getWareType() {
		return DataType.getAsLong(this.get(S_WareType));

	}

	public long getWareTypeInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_WareType));
	}

	public void initWareStorageType(String value) {
		this.initProperty(S_WareStorageType, value);
	}

	public void setWareStorageType(String value) {
		this.set(S_WareStorageType, value);
	}

	public void setWareStorageTypeNull() {
		this.set(S_WareStorageType, null);
	}

	public String getWareStorageType() {
		return DataType.getAsString(this.get(S_WareStorageType));

	}

	public String getWareStorageTypeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_WareStorageType));
	}

	public void initWareCode(String value) {
		this.initProperty(S_WareCode, value);
	}

	public void setWareCode(String value) {
		this.set(S_WareCode, value);
	}

	public void setWareCodeNull() {
		this.set(S_WareCode, null);
	}

	public String getWareCode() {
		return DataType.getAsString(this.get(S_WareCode));

	}

	public String getWareCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_WareCode));
	}

	public void initPartnerId(long value) {
		this.initProperty(S_PartnerId, new Long(value));
	}

	public void setPartnerId(long value) {
		this.set(S_PartnerId, new Long(value));
	}

	public void setPartnerIdNull() {
		this.set(S_PartnerId, null);
	}

	public long getPartnerId() {
		return DataType.getAsLong(this.get(S_PartnerId));

	}

	public long getPartnerIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_PartnerId));
	}

	public void initPartnerWareBrandId(long value) {
		this.initProperty(S_PartnerWareBrandId, new Long(value));
	}

	public void setPartnerWareBrandId(long value) {
		this.set(S_PartnerWareBrandId, new Long(value));
	}

	public void setPartnerWareBrandIdNull() {
		this.set(S_PartnerWareBrandId, null);
	}

	public long getPartnerWareBrandId() {
		return DataType.getAsLong(this.get(S_PartnerWareBrandId));

	}

	public long getPartnerWareBrandIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_PartnerWareBrandId));
	}

	public void initPreOcDate(Timestamp value) {
		this.initProperty(S_PreOcDate, value);
	}

	public void setPreOcDate(Timestamp value) {
		this.set(S_PreOcDate, value);
	}

	public void setPreOcDateNull() {
		this.set(S_PreOcDate, null);
	}

	public Timestamp getPreOcDate() {
		return DataType.getAsDateTime(this.get(S_PreOcDate));

	}

	public Timestamp getPreOcDateInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_PreOcDate));
	}

	public void initWareName(String value) {
		this.initProperty(S_WareName, value);
	}

	public void setWareName(String value) {
		this.set(S_WareName, value);
	}

	public void setWareNameNull() {
		this.set(S_WareName, null);
	}

	public String getWareName() {
		return DataType.getAsString(this.get(S_WareName));

	}

	public String getWareNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_WareName));
	}

	public void initMarketPrice(long value) {
		this.initProperty(S_MarketPrice, new Long(value));
	}

	public void setMarketPrice(long value) {
		this.set(S_MarketPrice, new Long(value));
	}

	public void setMarketPriceNull() {
		this.set(S_MarketPrice, null);
	}

	public long getMarketPrice() {
		return DataType.getAsLong(this.get(S_MarketPrice));

	}

	public long getMarketPriceInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_MarketPrice));
	}

	public void initNote(String value) {
		this.initProperty(S_Note, value);
	}

	public void setNote(String value) {
		this.set(S_Note, value);
	}

	public void setNoteNull() {
		this.set(S_Note, null);
	}

	public String getNote() {
		return DataType.getAsString(this.get(S_Note));

	}

	public String getNoteInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Note));
	}

	public void initLastUpdateDate(Timestamp value) {
		this.initProperty(S_LastUpdateDate, value);
	}

	public void setLastUpdateDate(Timestamp value) {
		this.set(S_LastUpdateDate, value);
	}

	public void setLastUpdateDateNull() {
		this.set(S_LastUpdateDate, null);
	}

	public Timestamp getLastUpdateDate() {
		return DataType.getAsDateTime(this.get(S_LastUpdateDate));

	}

	public Timestamp getLastUpdateDateInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_LastUpdateDate));
	}

	public void initAlias(String value) {
		this.initProperty(S_Alias, value);
	}

	public void setAlias(String value) {
		this.set(S_Alias, value);
	}

	public void setAliasNull() {
		this.set(S_Alias, null);
	}

	public String getAlias() {
		return DataType.getAsString(this.get(S_Alias));

	}

	public String getAliasInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Alias));
	}

	public void initLastUpdateStaffId(long value) {
		this.initProperty(S_LastUpdateStaffId, new Long(value));
	}

	public void setLastUpdateStaffId(long value) {
		this.set(S_LastUpdateStaffId, new Long(value));
	}

	public void setLastUpdateStaffIdNull() {
		this.set(S_LastUpdateStaffId, null);
	}

	public long getLastUpdateStaffId() {
		return DataType.getAsLong(this.get(S_LastUpdateStaffId));

	}

	public long getLastUpdateStaffIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_LastUpdateStaffId));
	}

	public void initKeywords(String value) {
		this.initProperty(S_Keywords, value);
	}

	public void setKeywords(String value) {
		this.set(S_Keywords, value);
	}

	public void setKeywordsNull() {
		this.set(S_Keywords, null);
	}

	public String getKeywords() {
		return DataType.getAsString(this.get(S_Keywords));

	}

	public String getKeywordsInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Keywords));
	}

	public void initAppVersion(long value) {
		this.initProperty(S_AppVersion, new Long(value));
	}

	public void setAppVersion(long value) {
		this.set(S_AppVersion, new Long(value));
	}

	public void setAppVersionNull() {
		this.set(S_AppVersion, null);
	}

	public long getAppVersion() {
		return DataType.getAsLong(this.get(S_AppVersion));

	}

	public long getAppVersionInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_AppVersion));
	}

	public void initCreateDate(Timestamp value) {
		this.initProperty(S_CreateDate, value);
	}

	public void setCreateDate(Timestamp value) {
		this.set(S_CreateDate, value);
	}

	public void setCreateDateNull() {
		this.set(S_CreateDate, null);
	}

	public Timestamp getCreateDate() {
		return DataType.getAsDateTime(this.get(S_CreateDate));

	}

	public Timestamp getCreateDateInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_CreateDate));
	}

	public void initWareStatus(String value) {
		this.initProperty(S_WareStatus, value);
	}

	public void setWareStatus(String value) {
		this.set(S_WareStatus, value);
	}

	public void setWareStatusNull() {
		this.set(S_WareStatus, null);
	}

	public String getWareStatus() {
		return DataType.getAsString(this.get(S_WareStatus));

	}

	public String getWareStatusInitialValue() {
		return DataType.getAsString(this.getOldObj(S_WareStatus));
	}

	public void initShopPrice(long value) {
		this.initProperty(S_ShopPrice, new Long(value));
	}

	public void setShopPrice(long value) {
		this.set(S_ShopPrice, new Long(value));
	}

	public void setShopPriceNull() {
		this.set(S_ShopPrice, null);
	}

	public long getShopPrice() {
		return DataType.getAsLong(this.get(S_ShopPrice));

	}

	public long getShopPriceInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_ShopPrice));
	}

	public void initCountType(String value) {
		this.initProperty(S_CountType, value);
	}

	public void setCountType(String value) {
		this.set(S_CountType, value);
	}

	public void setCountTypeNull() {
		this.set(S_CountType, null);
	}

	public String getCountType() {
		return DataType.getAsString(this.get(S_CountType));

	}

	public String getCountTypeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_CountType));
	}

	
	
	//统一积分添加的五个函数
	public void initWareIntegralValue(long value) {
		this.initProperty(S_WareIntegralValue, new Long(value));
	}

	public void setWareIntegralValue(long value) {
		this.set(S_WareIntegralValue, new Long(value));
	}

	public void setWareIntegralValueNull() {
		this.set(S_WareIntegralValue, null);
	}

	public long getWareIntegralValue() {
		return DataType.getAsLong(this.get(S_WareIntegralValue));

	}

	public long getWareIntegralValueInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_WareIntegralValue));
	}

	
	public void initPackingList(String value) {
		this.initProperty(S_PackingList, value);
	}


	public void setPackingList(String value) {
		this.set(S_PackingList, value);
	}

	public void setPackingListNull() {
		this.set(S_PackingList, null);
	}

	public String getPackingList() {
		return DataType.getAsString(this.get(S_PackingList));

	}

	public String getPackingListInitialValue() {
		return DataType.getAsString(this.getOldObj(S_PackingList));
	}
	
	public void initSafeGuard(String value) {
		this.initProperty(S_SafeGuard, value);
	}

	public void setSafeGuard(String value) {
		this.set(S_SafeGuard, value);
	}

	public void setSafeGuardNull() {
		this.set(S_SafeGuard, null);
	}

	public String getSafeGuard() {
		return DataType.getAsString(this.get(S_SafeGuard));

	}

	public String getSafeGuardInitialValue() {
		return DataType.getAsString(this.getOldObj(S_SafeGuard));
	}
	//为新增字段“MAPPING_CODE”实现5个方法
	public String getMappingCodeInitValue(){
		return DataType.getAsString(this.getOldObj(S_MappingCode));
	}
	
	public void setMappingCodeNull(){
		this.set(S_MappingCode, null);
	}
	
	public void initMappingCode(String value){
		this.initProperty(S_MappingCode, new String(value));
	}
	
	public String getMappingCode() {
		return DataType.getAsString(this.get(S_MappingCode));
	}

	public void setMappingCode(String value) {
		this.set(S_MappingCode, new String(value));
	}
	
	public void initPayCash(long value) {
		this.initProperty(S_PayCash, new Long(value));
	}

	public void setPayCash(long value) {
		this.set(S_PayCash, new Long(value));
	}

	public void setPayCashNull() {
		this.set(S_PayCash, null);
	}

	public long getPayCash() {
		return DataType.getAsLong(this.get(S_PayCash));

	}

	public long getPayCashInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_PayCash));
	}
	
	public void initPayIntegral(long value) {
		this.initProperty(S_PayIntegral, new Long(value));
	}

	public void setPayIntegral(long value) {
		this.set(S_PayIntegral, new Long(value));
	}

	public void setPayIntegralNull() {
		this.set(S_PayIntegral, null);
	}

	public long getPayIntegral() {
		return DataType.getAsLong(this.get(S_PayIntegral));

	}

	public long getPayIntegralInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_PayIntegral));
	}
	
	  public String getPayType() {
			return DataType.getAsString(this.get(S_PayType));
	  }
	  
	  public String getPayTypeInitialValue(){
	        return DataType.getAsString(this.getOldObj(S_PayType));
	  }
	  
	  public void initPayType(String value){
		    this.initProperty(S_PayType,value);
	  }
		 
	  public  void setPayTypeNull(){
		    this.set(S_PayType,null);
	  }
	  
	public void setPayType(String payType) {
		this.set(S_PayType, payType);
	}
}
