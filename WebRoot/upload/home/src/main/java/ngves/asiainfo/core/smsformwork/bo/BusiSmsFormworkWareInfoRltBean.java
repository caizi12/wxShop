package ngves.asiainfo.core.smsformwork.bo;

import java.sql.Timestamp;

import ngves.asiainfo.core.smsformwork.ivalues.IBusiSmsFormworkWareInfoRltValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class BusiSmsFormworkWareInfoRltBean extends DataContainer implements DataContainerInterface,
		IBusiSmsFormworkWareInfoRltValue {

	private static final long serialVersionUID = -4160478604556642936L;

	private static String m_boName = "ngves.asiainfo.core.smsformwork.bo.BusiSmsFormworkWareInfoRlt";

	public final static String S_OperatorCode = "OPERATOR_CODE";
	public final static String S_BusiId = "BUSI_ID";
	public final static String S_WareCode = "WARE_CODE";
	public final static String S_BusiRltId = "BUSI_RLT_ID";
	public final static String S_ActionType = "ACTION_TYPE";
	public final static String S_ActionId = "ACTION_ID";
	public final static String S_OperateTime = "OPERATE_TIME";
	public final static String S_FormworkId = "FORMWORK_ID";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public BusiSmsFormworkWareInfoRltBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
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

	public void initBusiRltId(String value) {
		this.initProperty(S_BusiRltId, value);
	}

	public void setBusiRltId(String value) {
		this.set(S_BusiRltId, value);
	}

	public void setBusiRltIdNull() {
		this.set(S_BusiRltId, null);
	}

	public String getBusiRltId() {
		return DataType.getAsString(this.get(S_BusiRltId));

	}

	public String getBusiRltIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_BusiRltId));
	}

	public void initActionType(String value) {
		this.initProperty(S_ActionType, value);
	}

	public void setActionType(String value) {
		this.set(S_ActionType, value);
	}

	public void setActionTypeNull() {
		this.set(S_ActionType, null);
	}

	public String getActionType() {
		return DataType.getAsString(this.get(S_ActionType));

	}

	public String getActionTypeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ActionType));
	}

	public void initActionId(String value) {
		this.initProperty(S_ActionId, value);
	}

	public void setActionId(String value) {
		this.set(S_ActionId, value);
	}

	public void setActionIdNull() {
		this.set(S_ActionId, null);
	}

	public String getActionId() {
		return DataType.getAsString(this.get(S_ActionId));

	}

	public String getActionIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ActionId));
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

	public void initFormworkId(String value) {
		this.initProperty(S_FormworkId, value);
	}

	public void setFormworkId(String value) {
		this.set(S_FormworkId, value);
	}

	public void setFormworkIdNull() {
		this.set(S_FormworkId, null);
	}

	public String getFormworkId() {
		return DataType.getAsString(this.get(S_FormworkId));

	}

	public String getFormworkIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_FormworkId));
	}

}
