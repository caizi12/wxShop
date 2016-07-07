package ngves.asiainfo.core.rechargepoints.bo;

import java.sql.Timestamp;

import ngves.asiainfo.core.rechargepoints.ivalues.IBusiRechargeTaskAuditValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class BusiRechargeTaskAuditBean extends DataContainer implements DataContainerInterface,
		IBusiRechargeTaskAuditValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8132466649122801882L;

	private static String m_boName = "ngves.asiainfo.core.rechargepoints.bo.BusiRechargeTaskAudit";

	public final static String S_OperatorCode = "OPERATOR_CODE";
	public final static String S_AuditContent = "AUDIT_CONTENT";
	public final static String S_BakCol1 = "BAK_COL1";
	public final static String S_AuditTime = "AUDIT_TIME";
	public final static String S_RechargeTaskId = "RECHARGE_TASK_ID";
	public final static String S_Status = "STATUS";
	public final static String S_BusiId = "BUSI_ID";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public BusiRechargeTaskAuditBean() throws AIException {
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

	public void initAuditContent(String value) {
		this.initProperty(S_AuditContent, value);
	}

	public void setAuditContent(String value) {
		this.set(S_AuditContent, value);
	}

	public void setAuditContentNull() {
		this.set(S_AuditContent, null);
	}

	public String getAuditContent() {
		return DataType.getAsString(this.get(S_AuditContent));

	}

	public String getAuditContentInitialValue() {
		return DataType.getAsString(this.getOldObj(S_AuditContent));
	}

	public void initBakCol1(String value) {
		this.initProperty(S_BakCol1, value);
	}

	public void setBakCol1(String value) {
		this.set(S_BakCol1, value);
	}

	public void setBakCol1Null() {
		this.set(S_BakCol1, null);
	}

	public String getBakCol1() {
		return DataType.getAsString(this.get(S_BakCol1));

	}

	public String getBakCol1InitialValue() {
		return DataType.getAsString(this.getOldObj(S_BakCol1));
	}

	public void initAuditTime(Timestamp value) {
		this.initProperty(S_AuditTime, value);
	}

	public void setAuditTime(Timestamp value) {
		this.set(S_AuditTime, value);
	}

	public void setAuditTimeNull() {
		this.set(S_AuditTime, null);
	}

	public Timestamp getAuditTime() {
		return DataType.getAsDateTime(this.get(S_AuditTime));

	}

	public Timestamp getAuditTimeInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_AuditTime));
	}

	public void initRechargeTaskId(long value) {
		this.initProperty(S_RechargeTaskId, new Long(value));
	}

	public void setRechargeTaskId(long value) {
		this.set(S_RechargeTaskId, new Long(value));
	}

	public void setRechargeTaskIdNull() {
		this.set(S_RechargeTaskId, null);
	}

	public long getRechargeTaskId() {
		return DataType.getAsLong(this.get(S_RechargeTaskId));

	}

	public long getRechargeTaskIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_RechargeTaskId));
	}

	public void initStatus(String value) {
		this.initProperty(S_Status, value);
	}

	public void setStatus(String value) {
		this.set(S_Status, value);
	}

	public void setStatusNull() {
		this.set(S_Status, null);
	}

	public String getStatus() {
		return DataType.getAsString(this.get(S_Status));

	}

	public String getStatusInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Status));
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

}
