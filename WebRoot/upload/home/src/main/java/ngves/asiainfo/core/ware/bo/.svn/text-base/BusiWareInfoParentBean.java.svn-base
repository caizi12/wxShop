package ngves.asiainfo.core.ware.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.ware.ivalues.*;

public class BusiWareInfoParentBean extends DataContainer implements DataContainerInterface, IBusiWareInfoParentValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.ware.bo.BusiWareInfoParent";

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
	//新增两个字段  清单和售后保障
	public final static String S_PackingList = "PACKING_LIST";
	public final static String S_SafeGuard = "SAFE_GUARD";
	public final static String S_BusiState = "BUSI_STATE";
	public final static String S_BusiId = "BUSI_ID";
	public final static String S_ShopPrice = "SHOP_PRICE";
	public final static String S_CountType = "COUNT_TYPE";
	public final static String S_TypeCode = "TYPE_CODE";
	
	public final static  String S_IsTestWare="IS_TEST_WARE";

	public BusiWareInfoParentBean() throws AIException {
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

	public void initPartner(long value) {
		this.initProperty(S_Partner, new Long(value));
	}

	public void setPartner(long value) {
		this.set(S_Partner, new Long(value));
	}

	public void setPartnerNull() {
		this.set(S_Partner, null);
	}

	public long getPartner() {
		return DataType.getAsLong(this.get(S_Partner));

	}

	public long getPartnerInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_Partner));
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

	public void initBusiWareId(long value) {
		this.initProperty(S_BusiWareId, new Long(value));
	}

	public void setBusiWareId(long value) {
		this.set(S_BusiWareId, new Long(value));
	}

	public void setBusiWareIdNull() {
		this.set(S_BusiWareId, null);
	}

	public long getBusiWareId() {
		return DataType.getAsLong(this.get(S_BusiWareId));

	}

	public long getBusiWareIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_BusiWareId));
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

	public void initBusiState(String value) {
		this.initProperty(S_BusiState, value);
	}

	public void setBusiState(String value) {
		this.set(S_BusiState, value);
	}

	public void setBusiStateNull() {
		this.set(S_BusiState, null);
	}

	public String getBusiState() {
		return DataType.getAsString(this.get(S_BusiState));

	}

	public String getBusiStateInitialValue() {
		return DataType.getAsString(this.getOldObj(S_BusiState));
	}

	public void initBusiId(long value) {
		this.initProperty(S_BusiId, new Long(value));
	}

	public void setBusiId(long value) {
		this.set(S_BusiId, new Long(value));
	}

	public void setBusiIdNull() {
		this.set(S_BusiId, null);
	}

	public long getBusiId() {
		return DataType.getAsLong(this.get(S_BusiId));

	}

	public long getBusiIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_BusiId));
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
	
	
	public void initTypeCode(long value){
	    this.initProperty(S_TypeCode,value);
	}
	public  void setTypeCode(long value){
		this.set(S_TypeCode,value);
	}
	public  void setTypeCodeNull(){
		this.set(S_TypeCode,null);
	}
	public long getTypeCode(){
		return DataType.getAsLong(this.get(S_TypeCode));
	}
	public long getTypeCodeInitialValue(){
		return DataType.getAsLong(this.getOldObj(S_TypeCode));
	}

	public void initIsTestWare(String value){
		  this.initProperty(S_IsTestWare, value);
	}
	public void setIsTestWare(String value){
		  this.set(S_IsTestWare, value);
	}
	public void setIsTestWareNull(){
		  this.set(S_IsTestWare, null);
	}
	public String getIsTestWare(){
		  return DataType.getAsString(this.get(S_IsTestWare));
	}
	public String getIsTestWareInitialValue(){
		  return DataType.getAsString(this.getOldObj(S_IsTestWare));
	}
}
