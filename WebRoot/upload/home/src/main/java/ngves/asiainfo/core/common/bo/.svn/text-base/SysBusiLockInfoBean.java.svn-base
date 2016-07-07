package ngves.asiainfo.core.common.bo;

import java.sql.Timestamp;

import ngves.asiainfo.core.common.ivalues.ISysBusiLockInfoValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class SysBusiLockInfoBean extends DataContainer implements DataContainerInterface, ISysBusiLockInfoValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.common.bo.SysBusiLockInfo";

	public final static String S_BusiLockOpNo = "BUSI_LOCK_OP_NO";
	public final static String S_BusiLockType = "BUSI_LOCK_TYPE";
	public final static String S_BusiLockTime = "BUSI_LOCK_TIME";
	public final static String S_Note = "NOTE";
	public final static String S_BusiLockCode = "BUSI_LOCK_CODE";

	public SysBusiLockInfoBean() throws AIException {
		super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initBusiLockOpNo(String value) {
		this.initProperty(S_BusiLockOpNo, value);
	}

	public void setBusiLockOpNo(String value) {
		this.set(S_BusiLockOpNo, value);
	}

	public void setBusiLockOpNoNull() {
		this.set(S_BusiLockOpNo, null);
	}

	public String getBusiLockOpNo() {
		return DataType.getAsString(this.get(S_BusiLockOpNo));

	}

	public String getBusiLockOpNoInitialValue() {
		return DataType.getAsString(this.getOldObj(S_BusiLockOpNo));
	}

	public void initBusiLockType(String value) {
		this.initProperty(S_BusiLockType, value);
	}

	public void setBusiLockType(String value) {
		this.set(S_BusiLockType, value);
	}

	public void setBusiLockTypeNull() {
		this.set(S_BusiLockType, null);
	}

	public String getBusiLockType() {
		return DataType.getAsString(this.get(S_BusiLockType));

	}

	public String getBusiLockTypeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_BusiLockType));
	}

	public void initBusiLockTime(Timestamp value) {
		this.initProperty(S_BusiLockTime, value);
	}

	public void setBusiLockTime(Timestamp value) {
		this.set(S_BusiLockTime, value);
	}

	public void setBusiLockTimeNull() {
		this.set(S_BusiLockTime, null);
	}

	public Timestamp getBusiLockTime() {
		return DataType.getAsDateTime(this.get(S_BusiLockTime));

	}

	public Timestamp getBusiLockTimeInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_BusiLockTime));
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

	public void initBusiLockCode(String value) {
		this.initProperty(S_BusiLockCode, value);
	}

	public void setBusiLockCode(String value) {
		this.set(S_BusiLockCode, value);
	}

	public void setBusiLockCodeNull() {
		this.set(S_BusiLockCode, null);
	}

	public String getBusiLockCode() {
		return DataType.getAsString(this.get(S_BusiLockCode));

	}

	public String getBusiLockCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_BusiLockCode));
	}

}
