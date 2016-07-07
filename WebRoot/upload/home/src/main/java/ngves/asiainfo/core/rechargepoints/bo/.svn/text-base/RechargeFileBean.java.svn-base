package ngves.asiainfo.core.rechargepoints.bo;

import ngves.asiainfo.core.rechargepoints.ivalues.IRechargeFileValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class RechargeFileBean extends DataContainer implements DataContainerInterface, IRechargeFileValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8916264671156130292L;

	private static String m_boName = "ngves.asiainfo.core.rechargepoints.bo.RechargeFile";

	public final static String S_RechargeFileName = "RECHARGE_FILE_NAME";
	public final static String S_BakCol2 = "BAK_COL2";
	public final static String S_BakCol1 = "BAK_COL1";
	public final static String S_SuccFilePath = "SUCC_FILE_PATH";
	public final static String S_FailFilePath = "FAIL_FILE_PATH";
	public final static String S_RechargeFileNickname = "RECHARGE_FILE_NICKNAME";
	public final static String S_NotRechargeCounts = "NOT_RECHARGE_COUNTS";
	public final static String S_FileManageStatus = "FILE_MANAGE_STATUS";
	public final static String S_RechargeTaskId = "RECHARGE_TASK_ID";
	public final static String S_FileStatus = "FILE_STATUS";
	public final static String S_IsDeleted = "IS_DELETED";
	public final static String S_SuccCounts = "SUCC_COUNTS";
	public final static String S_FailCounts = "FAIL_COUNTS";
	public final static String S_SmsMessage = "SMS_MESSAGE";
	public final static String S_RechargeFileId = "RECHARGE_FILE_ID";
	public final static String S_IsSendSms = "IS_SEND_SMS";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public RechargeFileBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initRechargeFileName(String value) {
		this.initProperty(S_RechargeFileName, value);
	}

	public void setRechargeFileName(String value) {
		this.set(S_RechargeFileName, value);
	}

	public void setRechargeFileNameNull() {
		this.set(S_RechargeFileName, null);
	}

	public String getRechargeFileName() {
		return DataType.getAsString(this.get(S_RechargeFileName));

	}

	public String getRechargeFileNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_RechargeFileName));
	}

	public void initBakCol2(String value) {
		this.initProperty(S_BakCol2, value);
	}

	public void setBakCol2(String value) {
		this.set(S_BakCol2, value);
	}

	public void setBakCol2Null() {
		this.set(S_BakCol2, null);
	}

	public String getBakCol2() {
		return DataType.getAsString(this.get(S_BakCol2));

	}

	public String getBakCol2InitialValue() {
		return DataType.getAsString(this.getOldObj(S_BakCol2));
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

	public void initSuccFilePath(String value) {
		this.initProperty(S_SuccFilePath, value);
	}

	public void setSuccFilePath(String value) {
		this.set(S_SuccFilePath, value);
	}

	public void setSuccFilePathNull() {
		this.set(S_SuccFilePath, null);
	}

	public String getSuccFilePath() {
		return DataType.getAsString(this.get(S_SuccFilePath));

	}

	public String getSuccFilePathInitialValue() {
		return DataType.getAsString(this.getOldObj(S_SuccFilePath));
	}

	public void initFailFilePath(String value) {
		this.initProperty(S_FailFilePath, value);
	}

	public void setFailFilePath(String value) {
		this.set(S_FailFilePath, value);
	}

	public void setFailFilePathNull() {
		this.set(S_FailFilePath, null);
	}

	public String getFailFilePath() {
		return DataType.getAsString(this.get(S_FailFilePath));

	}

	public String getFailFilePathInitialValue() {
		return DataType.getAsString(this.getOldObj(S_FailFilePath));
	}

	public void initRechargeFileNickname(String value) {
		this.initProperty(S_RechargeFileNickname, value);
	}

	public void setRechargeFileNickname(String value) {
		this.set(S_RechargeFileNickname, value);
	}

	public void setRechargeFileNicknameNull() {
		this.set(S_RechargeFileNickname, null);
	}

	public String getRechargeFileNickname() {
		return DataType.getAsString(this.get(S_RechargeFileNickname));

	}

	public String getRechargeFileNicknameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_RechargeFileNickname));
	}

	public void initNotRechargeCounts(long value) {
		this.initProperty(S_NotRechargeCounts, new Long(value));
	}

	public void setNotRechargeCounts(long value) {
		this.set(S_NotRechargeCounts, new Long(value));
	}

	public void setNotRechargeCountsNull() {
		this.set(S_NotRechargeCounts, null);
	}

	public long getNotRechargeCounts() {
		return DataType.getAsLong(this.get(S_NotRechargeCounts));

	}

	public long getNotRechargeCountsInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_NotRechargeCounts));
	}

	public void initFileManageStatus(String value) {
		this.initProperty(S_FileManageStatus, value);
	}

	public void setFileManageStatus(String value) {
		this.set(S_FileManageStatus, value);
	}

	public void setFileManageStatusNull() {
		this.set(S_FileManageStatus, null);
	}

	public String getFileManageStatus() {
		return DataType.getAsString(this.get(S_FileManageStatus));

	}

	public String getFileManageStatusInitialValue() {
		return DataType.getAsString(this.getOldObj(S_FileManageStatus));
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

	public void initFileStatus(String value) {
		this.initProperty(S_FileStatus, value);
	}

	public void setFileStatus(String value) {
		this.set(S_FileStatus, value);
	}

	public void setFileStatusNull() {
		this.set(S_FileStatus, null);
	}

	public String getFileStatus() {
		return DataType.getAsString(this.get(S_FileStatus));

	}

	public String getFileStatusInitialValue() {
		return DataType.getAsString(this.getOldObj(S_FileStatus));
	}

	public void initIsDeleted(String value) {
		this.initProperty(S_IsDeleted, value);
	}

	public void setIsDeleted(String value) {
		this.set(S_IsDeleted, value);
	}

	public void setIsDeletedNull() {
		this.set(S_IsDeleted, null);
	}

	public String getIsDeleted() {
		return DataType.getAsString(this.get(S_IsDeleted));

	}

	public String getIsDeletedInitialValue() {
		return DataType.getAsString(this.getOldObj(S_IsDeleted));
	}

	public void initSuccCounts(long value) {
		this.initProperty(S_SuccCounts, new Long(value));
	}

	public void setSuccCounts(long value) {
		this.set(S_SuccCounts, new Long(value));
	}

	public void setSuccCountsNull() {
		this.set(S_SuccCounts, null);
	}

	public long getSuccCounts() {
		return DataType.getAsLong(this.get(S_SuccCounts));

	}

	public long getSuccCountsInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_SuccCounts));
	}

	public void initFailCounts(long value) {
		this.initProperty(S_FailCounts, new Long(value));
	}

	public void setFailCounts(long value) {
		this.set(S_FailCounts, new Long(value));
	}

	public void setFailCountsNull() {
		this.set(S_FailCounts, null);
	}

	public long getFailCounts() {
		return DataType.getAsLong(this.get(S_FailCounts));

	}

	public long getFailCountsInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_FailCounts));
	}

	public void initSmsMessage(String value) {
		this.initProperty(S_SmsMessage, value);
	}

	public void setSmsMessage(String value) {
		this.set(S_SmsMessage, value);
	}

	public void setSmsMessageNull() {
		this.set(S_SmsMessage, null);
	}

	public String getSmsMessage() {
		return DataType.getAsString(this.get(S_SmsMessage));

	}

	public String getSmsMessageInitialValue() {
		return DataType.getAsString(this.getOldObj(S_SmsMessage));
	}

	public void initRechargeFileId(String value) {
		this.initProperty(S_RechargeFileId, value);
	}

	public void setRechargeFileId(String value) {
		this.set(S_RechargeFileId, value);
	}

	public void setRechargeFileIdNull() {
		this.set(S_RechargeFileId, null);
	}

	public String getRechargeFileId() {
		return DataType.getAsString(this.get(S_RechargeFileId));

	}

	public String getRechargeFileIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_RechargeFileId));
	}

	public void initIsSendSms(String value) {
		this.initProperty(S_IsSendSms, value);
	}

	public void setIsSendSms(String value) {
		this.set(S_IsSendSms, value);
	}

	public void setIsSendSmsNull() {
		this.set(S_IsSendSms, null);
	}

	public String getIsSendSms() {
		return DataType.getAsString(this.get(S_IsSendSms));

	}

	public String getIsSendSmsInitialValue() {
		return DataType.getAsString(this.getOldObj(S_IsSendSms));
	}

}
