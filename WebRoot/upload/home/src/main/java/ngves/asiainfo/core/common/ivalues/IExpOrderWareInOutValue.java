package ngves.asiainfo.core.common.ivalues;

import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;

public interface IExpOrderWareInOutValue extends DataStructInterface {

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

	public long getGetAddrId();

	public long getWarehouseId();

	public String getTimeRequest();

	public String getOrderTypeId();

	public long getSendAddrId();

	public String getExgbackResp();

	public String getSendProvince();

	public long getProviderId();

	public long getStorageContainer();

	public Timestamp getOrdOprTime();

	public Timestamp getOrdOverTime();

	public long getAmount();

	public String getInStorageFlag();

	public String getOldSuborderId();

	public String getNote();

	public long getOrdersumpoint();

	public String getOutStorageFlag();

	public String getOtherOrderId();

	public String getUserProvince();

	public String getExpInoutId();

	public String getOldOrderId();

	public long getWareId();

	public String getMobilePhoneNo();

	public long getLogisticId();
	
	public String getBadWareStatus();

	public void setGetAddrId(long value);

	public void setWarehouseId(long value);

	public void setTimeRequest(String value);

	public void setSendAddrId(long value);

	public void setExgbackResp(String value);

	public void setOrderTypeId(String value);

	public void setSendProvince(String value);

	public void setProviderId(long value);

	public void setStorageContainer(long value);

	public void setOrdOprTime(Timestamp value);

	public void setOrdOverTime(Timestamp value);

	public void setAmount(long value);

	public void setInStorageFlag(String value);

	public void setOldSuborderId(String value);

	public void setNote(String value);

	public void setOrdersumpoint(long value);

	public void setOutStorageFlag(String value);

	public void setOtherOrderId(String value);

	public void setUserProvince(String value);

	public void setExpInoutId(String value);

	public void setOldOrderId(String value);

	public void setWareId(long value);

	public void setMobilePhoneNo(String value);

	public void setLogisticId(long value);

	public void setBadWareStatus(String value);
}
