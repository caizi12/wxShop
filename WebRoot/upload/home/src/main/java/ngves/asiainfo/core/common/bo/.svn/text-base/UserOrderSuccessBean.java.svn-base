package ngves.asiainfo.core.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.common.ivalues.*;

public class UserOrderSuccessBean extends DataContainer implements DataContainerInterface, IUserOrderSuccessValue {

	/**
	   * 
	   */
	private static final long serialVersionUID = -8916527989700630804L;

	private static String m_boName = "ngves.asiainfo.core.common.bo.UserOrderSuccess";

	public final static String S_FailReason = "FAIL_REASON";
	public final static String S_OrderSuccessId = "ORDER_SUCCESS_ID";
	public final static String S_MobilePhoneNo = "MOBILE_PHONE_NO";
	public final static String S_IsSend = "IS_SEND";
	public final static String S_CreateDate = "CREATE_DATE";
	public final static String S_SendDate = "SEND_DATE";
	public final static String S_FlowId = "FLOW_ID";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public UserOrderSuccessBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initFailReason(String value) {
		this.initProperty(S_FailReason, value);
	}

	public void setFailReason(String value) {
		this.set(S_FailReason, value);
	}

	public void setFailReasonNull() {
		this.set(S_FailReason, null);
	}

	public String getFailReason() {
		return DataType.getAsString(this.get(S_FailReason));

	}

	public String getFailReasonInitialValue() {
		return DataType.getAsString(this.getOldObj(S_FailReason));
	}

	public void initOrderSuccessId(long value) {
		this.initProperty(S_OrderSuccessId, new Long(value));
	}

	public void setOrderSuccessId(long value) {
		this.set(S_OrderSuccessId, new Long(value));
	}

	public void setOrderSuccessIdNull() {
		this.set(S_OrderSuccessId, null);
	}

	public long getOrderSuccessId() {
		return DataType.getAsLong(this.get(S_OrderSuccessId));

	}

	public long getOrderSuccessIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_OrderSuccessId));
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

	public void initIsSend(String value) {
		this.initProperty(S_IsSend, value);
	}

	public void setIsSend(String value) {
		this.set(S_IsSend, value);
	}

	public void setIsSendNull() {
		this.set(S_IsSend, null);
	}

	public String getIsSend() {
		return DataType.getAsString(this.get(S_IsSend));

	}

	public String getIsSendInitialValue() {
		return DataType.getAsString(this.getOldObj(S_IsSend));
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

	public void initSendDate(Timestamp value) {
		this.initProperty(S_SendDate, value);
	}

	public void setSendDate(Timestamp value) {
		this.set(S_SendDate, value);
	}

	public void setSendDateNull() {
		this.set(S_SendDate, null);
	}

	public Timestamp getSendDate() {
		return DataType.getAsDateTime(this.get(S_SendDate));

	}

	public Timestamp getSendDateInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_SendDate));
	}

	public void initFlowId(String value) {
		this.initProperty(S_FlowId, value);
	}

	public void setFlowId(String value) {
		this.set(S_FlowId, value);
	}

	public void setFlowIdNull() {
		this.set(S_FlowId, null);
	}

	public String getFlowId() {
		return DataType.getAsString(this.get(S_FlowId));

	}

	public String getFlowIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_FlowId));
	}

}
