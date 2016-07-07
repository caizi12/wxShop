package ngves.asiainfo.core.smsformwork.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.smsformwork.ivalues.*;

public class BusiSmsFormworkBean extends DataContainer implements DataContainerInterface, IBusiSmsFormworkValue {

	private static final long serialVersionUID = 2691259416834891016L;

	private static String m_boName = "ngves.asiainfo.core.smsformwork.bo.BusiSmsFormwork";

	public final static String S_IsStopped = "IS_STOPPED";
	public final static String S_OperatorCode = "OPERATOR_CODE";
	public final static String S_FormworkState = "FORMWORK_STATE";
	public final static String S_BusiId = "BUSI_ID";
	public final static String S_FormworkName = "FORMWORK_NAME";
	public final static String S_SendProvince = "SEND_PROVINCE";
	public final static String S_BusiFormworkId = "BUSI_FORMWORK_ID";
	public final static String S_FormworkType = "FORMWORK_TYPE";
	public final static String S_OperateTime = "OPERATE_TIME";
	public final static String S_Oper = "OPER";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public BusiSmsFormworkBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initIsStopped(String value) {
		this.initProperty(S_IsStopped, value);
	}

	public void setIsStopped(String value) {
		this.set(S_IsStopped, value);
	}

	public void setIsStoppedNull() {
		this.set(S_IsStopped, null);
	}

	public String getIsStopped() {
		return DataType.getAsString(this.get(S_IsStopped));

	}

	public String getIsStoppedInitialValue() {
		return DataType.getAsString(this.getOldObj(S_IsStopped));
	}

	public void initOperatorCode(String value) {
		this.initProperty(S_OperatorCode, value);
	}

	public void setOperatorCode(String value) {
		this.set(S_OperatorCode, value);
	}

	public void setOperatorCodeNull() {
		this.set(S_OperatorCode, null);
	}

	public String getOperatorCode() {
		return DataType.getAsString(this.get(S_OperatorCode));

	}

	public String getOperatorCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_OperatorCode));
	}

	public void initFormworkState(String value) {
		this.initProperty(S_FormworkState, value);
	}

	public void setFormworkState(String value) {
		this.set(S_FormworkState, value);
	}

	public void setFormworkStateNull() {
		this.set(S_FormworkState, null);
	}

	public String getFormworkState() {
		return DataType.getAsString(this.get(S_FormworkState));

	}

	public String getFormworkStateInitialValue() {
		return DataType.getAsString(this.getOldObj(S_FormworkState));
	}

	public void initBusiId(String value) {
		this.initProperty(S_BusiId, value);
	}

	public void setBusiId(String value) {
		this.set(S_BusiId, value);
	}

	public void setBusiIdNull() {
		this.set(S_BusiId, null);
	}

	public String getBusiId() {
		return DataType.getAsString(this.get(S_BusiId));

	}

	public String getBusiIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_BusiId));
	}

	public void initFormworkName(String value) {
		this.initProperty(S_FormworkName, value);
	}

	public void setFormworkName(String value) {
		this.set(S_FormworkName, value);
	}

	public void setFormworkNameNull() {
		this.set(S_FormworkName, null);
	}

	public String getFormworkName() {
		return DataType.getAsString(this.get(S_FormworkName));

	}

	public String getFormworkNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_FormworkName));
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

	public void initBusiFormworkId(String value) {
		this.initProperty(S_BusiFormworkId, value);
	}

	public void setBusiFormworkId(String value) {
		this.set(S_BusiFormworkId, value);
	}

	public void setBusiFormworkIdNull() {
		this.set(S_BusiFormworkId, null);
	}

	public String getBusiFormworkId() {
		return DataType.getAsString(this.get(S_BusiFormworkId));

	}

	public String getBusiFormworkIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_BusiFormworkId));
	}

	public void initFormworkType(String value) {
		this.initProperty(S_FormworkType, value);
	}

	public void setFormworkType(String value) {
		this.set(S_FormworkType, value);
	}

	public void setFormworkTypeNull() {
		this.set(S_FormworkType, null);
	}

	public String getFormworkType() {
		return DataType.getAsString(this.get(S_FormworkType));

	}

	public String getFormworkTypeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_FormworkType));
	}

	public void initOperateTime(Timestamp value) {
		this.initProperty(S_OperateTime, value);
	}

	public void setOperateTime(Timestamp value) {
		this.set(S_OperateTime, value);
	}

	public void setOperateTimeNull() {
		this.set(S_OperateTime, null);
	}

	public Timestamp getOperateTime() {
		return DataType.getAsDateTime(this.get(S_OperateTime));

	}

	public Timestamp getOperateTimeInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_OperateTime));
	}

	public void initOper(String value) {
		this.initProperty(S_Oper, value);
	}

	public void setOper(String value) {
		this.set(S_Oper, value);
	}

	public void setOperNull() {
		this.set(S_Oper, null);
	}

	public String getOper() {
		return DataType.getAsString(this.get(S_Oper));

	}

	public String getOperInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Oper));
	}

}
