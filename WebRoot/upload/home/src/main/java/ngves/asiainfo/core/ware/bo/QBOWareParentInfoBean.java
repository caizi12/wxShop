package ngves.asiainfo.core.ware.bo;

import java.sql.Timestamp;

import ngves.asiainfo.core.ware.ivalues.IQBOWareParentInfoValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class QBOWareParentInfoBean extends DataContainer implements DataContainerInterface, IQBOWareParentInfoValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.ware.bo.QBOWareParentInfo";

	public final static String S_DeliverType = "DELIVER_TYPE";
	public final static String S_WareKindParentId = "WARE_KIND_PARENT_ID";
	public final static String S_WarehouseId = "WAREHOUSE_ID";
	public final static String S_WareKindId = "WARE_KIND_ID";
	public final static String S_BigKindState = "BIG_KIND_STATE";
	public final static String S_StatusCause = "STATUS_CAUSE";
	public final static String S_CurStatus = "CUR_STATUS";
	public final static String S_WareId = "WARE_ID";
	public final static String S_CloseDate = "CLOSE_DATE";
	public final static String S_AmendsFee = "AMENDS_FEE";
	public final static String S_KindState = "KIND_STATE";
	public final static String S_FuncDesc = "FUNC_DESC";
	public final static String S_FName = "F_NAME";
	public final static String S_PartnerCode = "PARTNER_CODE";
	public final static String S_OpenDate = "OPEN_DATE";
	public final static String S_WareBrandId = "WARE_BRAND_ID";
	public final static String S_CountValue = "COUNT_VALUE";
	public final static String S_ProvinceCode = "PROVINCE_CODE";
	public final static String S_Dblink2 = "DBLINK2";
	public final static String S_PartnerName = "PARTNER_NAME";
	public final static String S_WareStorageType = "WARE_STORAGE_TYPE";
	public final static String S_WareCode = "WARE_CODE";
	public final static String S_Dblink1 = "DBLINK1";
	public final static String S_WareBrandName = "WARE_BRAND_NAME";
	public final static String S_PartnerId = "PARTNER_ID";
	public final static String S_PreOcDate = "PRE_OC_DATE";
	public final static String S_WareName = "WARE_NAME";
	public final static String S_BigKindName = "BIG_KIND_NAME";
	public final static String S_FState = "F_STATE";
	public final static String S_MarketPrice = "MARKET_PRICE";
	public final static String S_Dblink = "DBLINK";
	public final static String S_Note = "NOTE";
	public final static String S_LastUpdateDate = "LAST_UPDATE_DATE";
	public final static String S_WareDescValue = "WARE_DESC_VALUE";
	public final static String S_IntegralG = "INTEGRAL_G";
	public final static String S_WareFirstKindId = "WARE_FIRST_KIND_ID";
	public final static String S_LastUpdateStaffId = "LAST_UPDATE_STAFF_ID";
	public final static String S_OriginalG = "ORIGINAL_G";
	public final static String S_CreateDate = "CREATE_DATE";
	public final static String S_WareStatus = "WARE_STATUS";
	public final static String S_ShopPrice = "SHOP_PRICE";
	public final static String S_KindName = "KIND_NAME";
	public final static String S_CountType = "COUNT_TYPE";
	public final static String S_FirstUpTime="FIRST_UP_TIME";
	//增加礼品大类id和name 
	public final static  String S_WareKindInfoId = "WARE_KIND_INFO_ID";
	  public final static  String S_WareKindInfoName = "WARE_KIND_INFO_NAME";
		 

	  public void initWareKindInfoId(long value){
		  this.initProperty(S_WareKindInfoId,new Long(value));
	  }
	  public  void setWareKindInfoId(long value){
		  this.set(S_WareKindInfoId,new Long(value));
	  }
	  public  void setWareKindInfoIdNull(){
		  this.set(S_WareKindInfoId,null);
	  }

	  public long getWareKindInfoId(){
		  return DataType.getAsLong(this.get(S_WareKindInfoId));
	  }
	  public long getWareKindInfoIdInitialValue(){
		  return DataType.getAsLong(this.getOldObj(S_WareKindInfoId));
	  }

	  public void initWareKindInfoName(String value){
		  this.initProperty(S_WareKindInfoName,value);
	  }
	  public  void setWareKindInfoName(String value){
		  this.set(S_WareKindInfoName,value);
	  }
	  public  void setWareKindInfoNameNull(){
		  this.set(S_WareKindInfoName,null);
	  }

	  public String getWareKindInfoName(){
		  return DataType.getAsString(this.get(S_WareKindInfoName));
	  }
	  public String getWareKindInfoNameInitialValue(){
		  return DataType.getAsString(this.getOldObj(S_WareKindInfoName));
	  }

	public QBOWareParentInfoBean() throws AIException {
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

	public void initWareKindParentId(long value) {
		this.initProperty(S_WareKindParentId, new Long(value));
	}

	public void setWareKindParentId(long value) {
		this.set(S_WareKindParentId, new Long(value));
	}

	public void setWareKindParentIdNull() {
		this.set(S_WareKindParentId, null);
	}

	public long getWareKindParentId() {
		return DataType.getAsLong(this.get(S_WareKindParentId));

	}

	public long getWareKindParentIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_WareKindParentId));
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

	public void initWareKindId(long value) {
		this.initProperty(S_WareKindId, new Long(value));
	}

	public void setWareKindId(long value) {
		this.set(S_WareKindId, new Long(value));
	}

	public void setWareKindIdNull() {
		this.set(S_WareKindId, null);
	}

	public long getWareKindId() {
		return DataType.getAsLong(this.get(S_WareKindId));

	}

	public long getWareKindIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_WareKindId));
	}

	public void initBigKindState(String value) {
		this.initProperty(S_BigKindState, value);
	}

	public void setBigKindState(String value) {
		this.set(S_BigKindState, value);
	}

	public void setBigKindStateNull() {
		this.set(S_BigKindState, null);
	}

	public String getBigKindState() {
		return DataType.getAsString(this.get(S_BigKindState));

	}

	public String getBigKindStateInitialValue() {
		return DataType.getAsString(this.getOldObj(S_BigKindState));
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

	public void initCurStatus(long value) {
		this.initProperty(S_CurStatus, new Long(value));
	}

	public void setCurStatus(long value) {
		this.set(S_CurStatus, new Long(value));
	}

	public void setCurStatusNull() {
		this.set(S_CurStatus, null);
	}

	public long getCurStatus() {
		return DataType.getAsLong(this.get(S_CurStatus));

	}

	public long getCurStatusInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_CurStatus));
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

	public void initKindState(String value) {
		this.initProperty(S_KindState, value);
	}

	public void setKindState(String value) {
		this.set(S_KindState, value);
	}

	public void setKindStateNull() {
		this.set(S_KindState, null);
	}

	public String getKindState() {
		return DataType.getAsString(this.get(S_KindState));

	}

	public String getKindStateInitialValue() {
		return DataType.getAsString(this.getOldObj(S_KindState));
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

	public void initFName(String value) {
		this.initProperty(S_FName, value);
	}

	public void setFName(String value) {
		this.set(S_FName, value);
	}

	public void setFNameNull() {
		this.set(S_FName, null);
	}

	public String getFName() {
		return DataType.getAsString(this.get(S_FName));

	}

	public String getFNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_FName));
	}

	public void initPartnerCode(String value) {
		this.initProperty(S_PartnerCode, value);
	}

	public void setPartnerCode(String value) {
		this.set(S_PartnerCode, value);
	}

	public void setPartnerCodeNull() {
		this.set(S_PartnerCode, null);
	}

	public String getPartnerCode() {
		return DataType.getAsString(this.get(S_PartnerCode));

	}

	public String getPartnerCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_PartnerCode));
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

	public void initCountValue(String value) {
		this.initProperty(S_CountValue, value);
	}

	public void setCountValue(String value) {
		this.set(S_CountValue, value);
	}

	public void setCountValueNull() {
		this.set(S_CountValue, null);
	}

	public String getCountValue() {
		return DataType.getAsString(this.get(S_CountValue));

	}

	public String getCountValueInitialValue() {
		return DataType.getAsString(this.getOldObj(S_CountValue));
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

	public void initDblink2(String value) {
		this.initProperty(S_Dblink2, value);
	}

	public void setDblink2(String value) {
		this.set(S_Dblink2, value);
	}

	public void setDblink2Null() {
		this.set(S_Dblink2, null);
	}

	public String getDblink2() {
		return DataType.getAsString(this.get(S_Dblink2));

	}

	public String getDblink2InitialValue() {
		return DataType.getAsString(this.getOldObj(S_Dblink2));
	}

	public void initPartnerName(String value) {
		this.initProperty(S_PartnerName, value);
	}

	public void setPartnerName(String value) {
		this.set(S_PartnerName, value);
	}

	public void setPartnerNameNull() {
		this.set(S_PartnerName, null);
	}

	public String getPartnerName() {
		return DataType.getAsString(this.get(S_PartnerName));

	}

	public String getPartnerNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_PartnerName));
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

	public void initDblink1(String value) {
		this.initProperty(S_Dblink1, value);
	}

	public void setDblink1(String value) {
		this.set(S_Dblink1, value);
	}

	public void setDblink1Null() {
		this.set(S_Dblink1, null);
	}

	public String getDblink1() {
		return DataType.getAsString(this.get(S_Dblink1));

	}

	public String getDblink1InitialValue() {
		return DataType.getAsString(this.getOldObj(S_Dblink1));
	}

	public void initWareBrandName(String value) {
		this.initProperty(S_WareBrandName, value);
	}

	public void setWareBrandName(String value) {
		this.set(S_WareBrandName, value);
	}

	public void setWareBrandNameNull() {
		this.set(S_WareBrandName, null);
	}

	public String getWareBrandName() {
		return DataType.getAsString(this.get(S_WareBrandName));

	}

	public String getWareBrandNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_WareBrandName));
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

	public void initBigKindName(String value) {
		this.initProperty(S_BigKindName, value);
	}

	public void setBigKindName(String value) {
		this.set(S_BigKindName, value);
	}

	public void setBigKindNameNull() {
		this.set(S_BigKindName, null);
	}

	public String getBigKindName() {
		return DataType.getAsString(this.get(S_BigKindName));

	}

	public String getBigKindNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_BigKindName));
	}

	public void initFState(String value) {
		this.initProperty(S_FState, value);
	}

	public void setFState(String value) {
		this.set(S_FState, value);
	}

	public void setFStateNull() {
		this.set(S_FState, null);
	}

	public String getFState() {
		return DataType.getAsString(this.get(S_FState));

	}

	public String getFStateInitialValue() {
		return DataType.getAsString(this.getOldObj(S_FState));
	}

	public void initMarketPrice(String value) {
		this.initProperty(S_MarketPrice, value);
	}

	public void setMarketPrice(String value) {
		this.set(S_MarketPrice, value);
	}

	public void setMarketPriceNull() {
		this.set(S_MarketPrice, null);
	}

	public String getMarketPrice() {
		return DataType.getAsString(this.get(S_MarketPrice));

	}

	public String getMarketPriceInitialValue() {
		return DataType.getAsString(this.getOldObj(S_MarketPrice));
	}

	public void initDblink(String value) {
		this.initProperty(S_Dblink, value);
	}

	public void setDblink(String value) {
		this.set(S_Dblink, value);
	}

	public void setDblinkNull() {
		this.set(S_Dblink, null);
	}

	public String getDblink() {
		return DataType.getAsString(this.get(S_Dblink));

	}

	public String getDblinkInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Dblink));
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

	public void initWareDescValue(String value) {
		this.initProperty(S_WareDescValue, value);
	}

	public void setWareDescValue(String value) {
		this.set(S_WareDescValue, value);
	}

	public void setWareDescValueNull() {
		this.set(S_WareDescValue, null);
	}

	public String getWareDescValue() {
		return DataType.getAsString(this.get(S_WareDescValue));

	}

	public String getWareDescValueInitialValue() {
		return DataType.getAsString(this.getOldObj(S_WareDescValue));
	}

	public void initIntegralG(String value) {
		this.initProperty(S_IntegralG, value);
	}

	public void setIntegralG(String value) {
		this.set(S_IntegralG, value);
	}

	public void setIntegralGNull() {
		this.set(S_IntegralG, null);
	}

	public String getIntegralG() {
		return DataType.getAsString(this.get(S_IntegralG));

	}

	public String getIntegralGInitialValue() {
		return DataType.getAsString(this.getOldObj(S_IntegralG));
	}

	public void initWareFirstKindId(long value) {
		this.initProperty(S_WareFirstKindId, new Long(value));
	}

	public void setWareFirstKindId(long value) {
		this.set(S_WareFirstKindId, new Long(value));
	}

	public void setWareFirstKindIdNull() {
		this.set(S_WareFirstKindId, null);
	}

	public long getWareFirstKindId() {
		return DataType.getAsLong(this.get(S_WareFirstKindId));

	}

	public long getWareFirstKindIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_WareFirstKindId));
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

	public void initOriginalG(String value) {
		this.initProperty(S_OriginalG, value);
	}

	public void setOriginalG(String value) {
		this.set(S_OriginalG, value);
	}

	public void setOriginalGNull() {
		this.set(S_OriginalG, null);
	}

	public String getOriginalG() {
		return DataType.getAsString(this.get(S_OriginalG));

	}

	public String getOriginalGInitialValue() {
		return DataType.getAsString(this.getOldObj(S_OriginalG));
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

	public void initShopPrice(String value) {
		this.initProperty(S_ShopPrice, value);
	}

	public void setShopPrice(String value) {
		this.set(S_ShopPrice, value);
	}

	public void setShopPriceNull() {
		this.set(S_ShopPrice, null);
	}

	public String getShopPrice() {
		return DataType.getAsString(this.get(S_ShopPrice));

	}

	public String getShopPriceInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ShopPrice));
	}

	public void initKindName(String value) {
		this.initProperty(S_KindName, value);
	}

	public void setKindName(String value) {
		this.set(S_KindName, value);
	}

	public void setKindNameNull() {
		this.set(S_KindName, null);
	}

	public String getKindName() {
		return DataType.getAsString(this.get(S_KindName));

	}

	public String getKindNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_KindName));
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

	public String getFirstUpTime() {
		return DataType.getAsString(this.get(S_FirstUpTime));
	}

	public void setFirstUpTime(String value) {
		this.set(S_FirstUpTime, value);
	}

	public void setFirstUpTimeNull() {
		this.set(S_FirstUpTime, null);
	}
}
