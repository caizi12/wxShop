package ngves.asiainfo.core.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.common.ivalues.*;

public class ExpOrderWareInOutBean extends DataContainer implements DataContainerInterface, IExpOrderWareInOutValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3861840183796508151L;

	private static String m_boName = "ngves.asiainfo.core.common.bo.ExpOrderWareInOut";

	public final static String S_GetAddrId = "GET_ADDR_ID";
	public final static String S_WarehouseId = "WAREHOUSE_ID";
	public final static String S_TimeRequest = "TIME_REQUEST";
	public final static String S_SendAddrId = "SEND_ADDR_ID";
	public final static String S_ExgbackResp = "EXGBACK_RESP";
	public final static String S_SendProvince = "SEND_PROVINCE";
	public final static String S_ProviderId = "PROVIDER_ID";
	public final static String S_StorageContainer = "STORAGE_CONTAINER";
	public final static String S_OrdOprTime = "ORD_OPR_TIME";
	public final static String S_OrdOverTime = "ORD_OVER_TIME";
	public final static String S_Amount = "AMOUNT";
	public final static String S_InStorageFlag = "IN_STORAGE_FLAG";
	public final static String S_OldSuborderId = "OLD_SUBORDER_ID";
	public final static String S_Note = "NOTE";
	public final static String S_Ordersumpoint = "ORDERSUMPOINT";
	public final static String S_OutStorageFlag = "OUT_STORAGE_FLAG";
	public final static String S_OtherOrderId = "OTHER_ORDER_ID";
	public final static String S_UserProvince = "USER_PROVINCE";
	public final static String S_ExpInoutId = "EXP_INOUT_ID";
	public final static String S_OldOrderId = "OLD_ORDER_ID";
	public final static String S_WareId = "WARE_ID";
	public final static String S_MobilePhoneNo = "MOBILE_PHONE_NO";
	public final static String S_LogisticId = "LOGISTIC_ID";
	public final static String S_OrderTypeId = "ORDER_TYPE_ID";
	public final static String S_BadWareStatus = "BAD_WARE_STATUS";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public ExpOrderWareInOutBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initGetAddrId(long value) {
		this.initProperty(S_GetAddrId, new Long(value));
	}

	public void setGetAddrId(long value) {
		this.set(S_GetAddrId, new Long(value));
	}

	public void setGetAddrIdNull() {
		this.set(S_GetAddrId, null);
	}

	public long getGetAddrId() {
		return DataType.getAsLong(this.get(S_GetAddrId));

	}

	public long getGetAddrIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_GetAddrId));
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

	public void initTimeRequest(String value) {
		this.initProperty(S_TimeRequest, value);
	}

	public void setTimeRequest(String value) {
		this.set(S_TimeRequest, value);
	}

	public void setTimeRequestNull() {
		this.set(S_TimeRequest, null);
	}

	public String getTimeRequest() {
		return DataType.getAsString(this.get(S_TimeRequest));

	}

	public String getTimeRequestInitialValue() {
		return DataType.getAsString(this.getOldObj(S_TimeRequest));
	}

	public void initSendAddrId(long value) {
		this.initProperty(S_SendAddrId, new Long(value));
	}

	public void setSendAddrId(long value) {
		this.set(S_SendAddrId, new Long(value));
	}

	public void setSendAddrIdNull() {
		this.set(S_SendAddrId, null);
	}

	public long getSendAddrId() {
		return DataType.getAsLong(this.get(S_SendAddrId));

	}

	public long getSendAddrIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_SendAddrId));
	}

	public void initExgbackResp(String value) {
		this.initProperty(S_ExgbackResp, value);
	}

	public void setExgbackResp(String value) {
		this.set(S_ExgbackResp, value);
	}

	public void setExgbackRespNull() {
		this.set(S_ExgbackResp, null);
	}

	public String getExgbackResp() {
		return DataType.getAsString(this.get(S_ExgbackResp));

	}

	public String getExgbackRespInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ExgbackResp));
	}

	public void initSendProvince(String value) {
		this.initProperty(S_SendProvince, value);
	}

	public void setSendProvince(String value) {
		this.set(S_SendProvince, value);
	}

	public void setSendProvinceNull() {
		this.set(S_SendProvince, null);
	}

	public String getSendProvince() {
		return DataType.getAsString(this.get(S_SendProvince));

	}

	public String getSendProvinceInitialValue() {
		return DataType.getAsString(this.getOldObj(S_SendProvince));
	}

	public void initProviderId(long value) {
		this.initProperty(S_ProviderId, new Long(value));
	}

	public void setProviderId(long value) {
		this.set(S_ProviderId, new Long(value));
	}

	public void setProviderIdNull() {
		this.set(S_ProviderId, null);
	}

	public long getProviderId() {
		return DataType.getAsLong(this.get(S_ProviderId));

	}

	public long getProviderIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_ProviderId));
	}

	public void initStorageContainer(long value) {
		this.initProperty(S_StorageContainer, new Long(value));
	}

	public void setStorageContainer(long value) {
		this.set(S_StorageContainer, new Long(value));
	}

	public void setStorageContainerNull() {
		this.set(S_StorageContainer, null);
	}

	public long getStorageContainer() {
		return DataType.getAsLong(this.get(S_StorageContainer));

	}

	public long getStorageContainerInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_StorageContainer));
	}

	public void initOrdOprTime(Timestamp value) {
		this.initProperty(S_OrdOprTime, value);
	}

	public void setOrdOprTime(Timestamp value) {
		this.set(S_OrdOprTime, value);
	}

	public void setOrdOprTimeNull() {
		this.set(S_OrdOprTime, null);
	}

	public Timestamp getOrdOprTime() {
		return DataType.getAsDateTime(this.get(S_OrdOprTime));

	}

	public Timestamp getOrdOprTimeInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_OrdOprTime));
	}

	public void initAmount(long value) {
		this.initProperty(S_Amount, new Long(value));
	}

	public void setAmount(long value) {
		this.set(S_Amount, new Long(value));
	}

	public void setAmountNull() {
		this.set(S_Amount, null);
	}

	public long getAmount() {
		return DataType.getAsLong(this.get(S_Amount));

	}

	public long getAmountInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_Amount));
	}

	public void initInStorageFlag(String value) {
		this.initProperty(S_InStorageFlag, value);
	}

	public void setInStorageFlag(String value) {
		this.set(S_InStorageFlag, value);
	}

	public void setInStorageFlagNull() {
		this.set(S_InStorageFlag, null);
	}

	public String getInStorageFlag() {
		return DataType.getAsString(this.get(S_InStorageFlag));

	}

	public String getInStorageFlagInitialValue() {
		return DataType.getAsString(this.getOldObj(S_InStorageFlag));
	}

	public void initOldSuborderId(String value) {
		this.initProperty(S_OldSuborderId, value);
	}

	public void setOldSuborderId(String value) {
		this.set(S_OldSuborderId, value);
	}

	public void setOldSuborderIdNull() {
		this.set(S_OldSuborderId, null);
	}

	public String getOldSuborderId() {
		return DataType.getAsString(this.get(S_OldSuborderId));

	}

	public String getOldSuborderIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_OldSuborderId));
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

	public void initOrdersumpoint(long value) {
		this.initProperty(S_Ordersumpoint, new Long(value));
	}

	public void setOrdersumpoint(long value) {
		this.set(S_Ordersumpoint, new Long(value));
	}

	public void setOrdersumpointNull() {
		this.set(S_Ordersumpoint, null);
	}

	public long getOrdersumpoint() {
		return DataType.getAsLong(this.get(S_Ordersumpoint));

	}

	public long getOrdersumpointInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_Ordersumpoint));
	}

	public void initOutStorageFlag(String value) {
		this.initProperty(S_OutStorageFlag, value);
	}

	public void setOutStorageFlag(String value) {
		this.set(S_OutStorageFlag, value);
	}

	public void setOutStorageFlagNull() {
		this.set(S_OutStorageFlag, null);
	}

	public String getOutStorageFlag() {
		return DataType.getAsString(this.get(S_OutStorageFlag));

	}

	public String getOutStorageFlagInitialValue() {
		return DataType.getAsString(this.getOldObj(S_OutStorageFlag));
	}

	public void initOtherOrderId(String value) {
		this.initProperty(S_OtherOrderId, value);
	}

	public void setOtherOrderId(String value) {
		this.set(S_OtherOrderId, value);
	}

	public void setOtherOrderIdNull() {
		this.set(S_OtherOrderId, null);
	}

	public String getOtherOrderId() {
		return DataType.getAsString(this.get(S_OtherOrderId));

	}

	public String getOtherOrderIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_OtherOrderId));
	}

	public void initUserProvince(String value) {
		this.initProperty(S_UserProvince, value);
	}

	public void setUserProvince(String value) {
		this.set(S_UserProvince, value);
	}

	public void setUserProvinceNull() {
		this.set(S_UserProvince, null);
	}

	public String getUserProvince() {
		return DataType.getAsString(this.get(S_UserProvince));

	}

	public String getUserProvinceInitialValue() {
		return DataType.getAsString(this.getOldObj(S_UserProvince));
	}

	public void initExpInoutId(String value) {
		this.initProperty(S_ExpInoutId, value);
	}

	public void setExpInoutId(String value) {
		this.set(S_ExpInoutId, value);
	}

	public void setExpInoutIdNull() {
		this.set(S_ExpInoutId, null);
	}

	public String getExpInoutId() {
		return DataType.getAsString(this.get(S_ExpInoutId));

	}

	public long getExpInoutIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_ExpInoutId));
	}

	public void initOldOrderId(String value) {
		this.initProperty(S_OldOrderId, value);
	}

	public void setOldOrderId(String value) {
		this.set(S_OldOrderId, value);
	}

	public void setOldOrderIdNull() {
		this.set(S_OldOrderId, null);
	}

	public String getOldOrderId() {
		return DataType.getAsString(this.get(S_OldOrderId));

	}

	public String getOldOrderIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_OldOrderId));
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

	public void initMobilePhoneNo(String value) {
		this.initProperty(S_MobilePhoneNo, value);
	}

	public void setMobilePhoneNo(String value) {
		this.set(S_MobilePhoneNo, value);
	}

	public void setMobilePhoneNoNull() {
		this.set(S_MobilePhoneNo, null);
	}

	public String getMobilePhoneNo() {
		return DataType.getAsString(this.get(S_MobilePhoneNo));

	}

	public String getMobilePhoneNoInitialValue() {
		return DataType.getAsString(this.getOldObj(S_MobilePhoneNo));
	}

	public void initLogisticId(long value) {
		this.initProperty(S_LogisticId, new Long(value));
	}

	public void setLogisticId(long value) {
		this.set(S_LogisticId, new Long(value));
	}

	public void setLogisticIdNull() {
		this.set(S_LogisticId, null);
	}

	public long getLogisticId() {
		return DataType.getAsLong(this.get(S_LogisticId));

	}

	public long getLogisticIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_LogisticId));
	}

	public void initOrderTypeId(String value) {
		this.initProperty(S_OrderTypeId, value);
	}

	public void setOrderTypeId(String value) {
		this.set(S_OrderTypeId, value);
	}

	public void setOrderTypeIdNull() {
		this.set(S_OrderTypeId, null);
	}

	public String getOrderTypeId() {
		return DataType.getAsString(this.get(S_OrderTypeId));

	}

	public String getOrderTypeIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_OrderTypeId));
	}

	public void initOrdOverTime(Timestamp value) {
		this.initProperty(S_OrdOverTime, value);
	}

	public void setOrdOverTime(Timestamp value) {
		this.set(S_OrdOverTime, value);
	}

	public void setOrdOverTimeNull() {
		this.set(S_OrdOverTime, null);
	}

	public Timestamp getOrdOverTime() {
		return DataType.getAsDateTime(this.get(S_OrdOverTime));

	}

	public Timestamp getOrdOverTimeInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_OrdOverTime));
	}
	
	public void initBadWareStatus(String value) {
		this.initProperty(S_BadWareStatus, value);
	}

	public void setBadWareStatus(String value) {
		this.set(S_BadWareStatus, value);
	}

	public void setBadWareStatusNull() {
		this.set(S_BadWareStatus, null);
	}

	public String getBadWareStatus() {
		return DataType.getAsString(this.get(S_BadWareStatus));

	}

	public String getBadWareStatusInitialValue() {
		return DataType.getAsString(this.getOldObj(S_BadWareStatus));
	}
	
}
