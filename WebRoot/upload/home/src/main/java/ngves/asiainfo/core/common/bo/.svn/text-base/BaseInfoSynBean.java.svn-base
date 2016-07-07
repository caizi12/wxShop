package ngves.asiainfo.core.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.common.ivalues.*;

public class BaseInfoSynBean extends DataContainer implements DataContainerInterface, IBaseInfoSynValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.common.bo.BaseInfoSyn";

	public final static String S_SynId = "SYN_ID";
	public final static String S_SynRetryTime = "SYN_RETRY_TIME";
	public final static String S_SynInfoType = "SYN_INFO_TYPE";
	public final static String S_SynCreateTime = "SYN_CREATE_TIME";
	public final static String S_SynInfoState = "SYN_INFO_STATE";
	public final static String S_SynState = "SYN_STATE";
	public final static String S_SynEndTime = "SYN_END_TIME";
	public final static String S_InfoId = "INFO_ID";

	public BaseInfoSynBean() throws AIException {
		super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initSynId(long value) {
		this.initProperty(S_SynId, new Long(value));
	}

	public void setSynId(long value) {
		this.set(S_SynId, new Long(value));
	}

	public void setSynIdNull() {
		this.set(S_SynId, null);
	}

	public long getSynId() {
		return DataType.getAsLong(this.get(S_SynId));

	}

	public long getSynIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_SynId));
	}

	public void initSynRetryTime(long value) {
		this.initProperty(S_SynRetryTime, new Long(value));
	}

	public void setSynRetryTime(long value) {
		this.set(S_SynRetryTime, new Long(value));
	}

	public void setSynRetryTimeNull() {
		this.set(S_SynRetryTime, null);
	}

	public long getSynRetryTime() {
		return DataType.getAsLong(this.get(S_SynRetryTime));

	}

	public long getSynRetryTimeInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_SynRetryTime));
	}

	public void initSynInfoType(String value) {
		this.initProperty(S_SynInfoType, value);
	}

	public void setSynInfoType(String value) {
		this.set(S_SynInfoType, value);
	}

	public void setSynInfoTypeNull() {
		this.set(S_SynInfoType, null);
	}

	public String getSynInfoType() {
		return DataType.getAsString(this.get(S_SynInfoType));

	}

	public String getSynInfoTypeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_SynInfoType));
	}

	public void initSynCreateTime(Timestamp value) {
		this.initProperty(S_SynCreateTime, value);
	}

	public void setSynCreateTime(Timestamp value) {
		this.set(S_SynCreateTime, value);
	}

	public void setSynCreateTimeNull() {
		this.set(S_SynCreateTime, null);
	}

	public Timestamp getSynCreateTime() {
		return DataType.getAsDateTime(this.get(S_SynCreateTime));

	}

	public Timestamp getSynCreateTimeInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_SynCreateTime));
	}

	public void initSynInfoState(String value) {
		this.initProperty(S_SynInfoState, value);
	}

	public void setSynInfoState(String value) {
		this.set(S_SynInfoState, value);
	}

	public void setSynInfoStateNull() {
		this.set(S_SynInfoState, null);
	}

	public String getSynInfoState() {
		return DataType.getAsString(this.get(S_SynInfoState));

	}

	public String getSynInfoStateInitialValue() {
		return DataType.getAsString(this.getOldObj(S_SynInfoState));
	}

	public void initSynState(String value) {
		this.initProperty(S_SynState, value);
	}

	public void setSynState(String value) {
		this.set(S_SynState, value);
	}

	public void setSynStateNull() {
		this.set(S_SynState, null);
	}

	public String getSynState() {
		return DataType.getAsString(this.get(S_SynState));

	}

	public String getSynStateInitialValue() {
		return DataType.getAsString(this.getOldObj(S_SynState));
	}

	public void initSynEndTime(Timestamp value) {
		this.initProperty(S_SynEndTime, value);
	}

	public void setSynEndTime(Timestamp value) {
		this.set(S_SynEndTime, value);
	}

	public void setSynEndTimeNull() {
		this.set(S_SynEndTime, null);
	}

	public Timestamp getSynEndTime() {
		return DataType.getAsDateTime(this.get(S_SynEndTime));

	}

	public Timestamp getSynEndTimeInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_SynEndTime));
	}

	public void initInfoId(long value) {
		this.initProperty(S_InfoId, new Long(value));
	}

	public void setInfoId(long value) {
		this.set(S_InfoId, new Long(value));
	}

	public void setInfoIdNull() {
		this.set(S_InfoId, null);
	}

	public long getInfoId() {
		return DataType.getAsLong(this.get(S_InfoId));

	}

	public long getInfoIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_InfoId));
	}

}
