package ngves.asiainfo.core.rechargepoints.bo;

import java.sql.Timestamp;

import ngves.asiainfo.core.rechargepoints.ivalues.IBusiRechargePointsTaskValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class BusiRechargePointsTaskBean extends DataContainer implements DataContainerInterface,
		IBusiRechargePointsTaskValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2633736539035012757L;

	private static String m_boName = "ngves.asiainfo.core.rechargepoints.bo.BusiRechargePointsTask";

	public final static String S_FirstTrialCode = "FIRST_TRIAL_CODE";
	public final static String S_CreateTime = "CREATE_TIME";
	public final static String S_TaskChannel = "TASK_CHANNEL";
	public final static String S_RechargeTaskId = "RECHARGE_TASK_ID";
	public final static String S_ActivityName = "ACTIVITY_NAME";
	public final static String S_ChannelName = "CHANNEL_NAME";
	public final static String S_RequestSeq = "REQUEST_SEQ";
	public final static String S_CancelCause = "CANCEL_CAUSE";
	public final static String S_IsDeleted = "IS_DELETED";
	public final static String S_TaskStatus = "TASK_STATUS";
	public final static String S_UserRole = "USER_ROLE";
	public final static String S_TaskType = "TASK_TYPE";
	public final static String S_AddpointActionId = "ADDPOINT_ACTION_ID";
	public final static String S_ActivityType = "ACTIVITY_TYPE";
	public final static String S_BakCol3 = "BAK_COL3";
	public final static String S_BakCol2 = "BAK_COL2";
	public final static String S_BusiRechargeTaskId = "BUSI_RECHARGE_TASK_ID";
	public final static String S_BakCol1 = "BAK_COL1";
	public final static String S_SecondTime = "SECOND_TIME";
	public final static String S_TaskTitile = "TASK_TITILE";
	public final static String S_UserId = "USER_ID";
	public final static String S_FirstTime = "FIRST_TIME";
	public final static String S_TaskManageStatus = "TASK_MANAGE_STATUS";
	public final static String S_ExecutionTime = "EXECUTION_TIME";
	public final static String S_Mobile = "MOBILE";
	public final static String S_TaskName = "TASK_NAME";
	public final static String S_IsSendSms = "IS_SEND_SMS";
	public final static String S_ReTrialCode = "RE_TRIAL_CODE";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public BusiRechargePointsTaskBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initFirstTrialCode(String value) {
		this.initProperty(S_FirstTrialCode, value);
	}

	public void setFirstTrialCode(String value) {
		this.set(S_FirstTrialCode, value);
	}

	public void setFirstTrialCodeNull() {
		this.set(S_FirstTrialCode, null);
	}

	public String getFirstTrialCode() {
		return DataType.getAsString(this.get(S_FirstTrialCode));

	}

	public String getFirstTrialCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_FirstTrialCode));
	}

	public void initCreateTime(Timestamp value) {
		this.initProperty(S_CreateTime, value);
	}

	public void setCreateTime(Timestamp value) {
		this.set(S_CreateTime, value);
	}

	public void setCreateTimeNull() {
		this.set(S_CreateTime, null);
	}

	public Timestamp getCreateTime() {
		return DataType.getAsDateTime(this.get(S_CreateTime));

	}

	public Timestamp getCreateTimeInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_CreateTime));
	}

	public void initTaskChannel(String value) {
		this.initProperty(S_TaskChannel, value);
	}

	public void setTaskChannel(String value) {
		this.set(S_TaskChannel, value);
	}

	public void setTaskChannelNull() {
		this.set(S_TaskChannel, null);
	}

	public String getTaskChannel() {
		return DataType.getAsString(this.get(S_TaskChannel));

	}

	public String getTaskChannelInitialValue() {
		return DataType.getAsString(this.getOldObj(S_TaskChannel));
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

	public void initActivityName(String value) {
		this.initProperty(S_ActivityName, value);
	}

	public void setActivityName(String value) {
		this.set(S_ActivityName, value);
	}

	public void setActivityNameNull() {
		this.set(S_ActivityName, null);
	}

	public String getActivityName() {
		return DataType.getAsString(this.get(S_ActivityName));

	}

	public String getActivityNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ActivityName));
	}

	public void initChannelName(String value) {
		this.initProperty(S_ChannelName, value);
	}

	public void setChannelName(String value) {
		this.set(S_ChannelName, value);
	}

	public void setChannelNameNull() {
		this.set(S_ChannelName, null);
	}

	public String getChannelName() {
		return DataType.getAsString(this.get(S_ChannelName));

	}

	public String getChannelNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ChannelName));
	}

	public void initRequestSeq(String value) {
		this.initProperty(S_RequestSeq, value);
	}

	public void setRequestSeq(String value) {
		this.set(S_RequestSeq, value);
	}

	public void setRequestSeqNull() {
		this.set(S_RequestSeq, null);
	}

	public String getRequestSeq() {
		return DataType.getAsString(this.get(S_RequestSeq));

	}

	public String getRequestSeqInitialValue() {
		return DataType.getAsString(this.getOldObj(S_RequestSeq));
	}

	public void initCancelCause(String value) {
		this.initProperty(S_CancelCause, value);
	}

	public void setCancelCause(String value) {
		this.set(S_CancelCause, value);
	}

	public void setCancelCauseNull() {
		this.set(S_CancelCause, null);
	}

	public String getCancelCause() {
		return DataType.getAsString(this.get(S_CancelCause));

	}

	public String getCancelCauseInitialValue() {
		return DataType.getAsString(this.getOldObj(S_CancelCause));
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

	public void initTaskStatus(String value) {
		this.initProperty(S_TaskStatus, value);
	}

	public void setTaskStatus(String value) {
		this.set(S_TaskStatus, value);
	}

	public void setTaskStatusNull() {
		this.set(S_TaskStatus, null);
	}

	public String getTaskStatus() {
		return DataType.getAsString(this.get(S_TaskStatus));

	}

	public String getTaskStatusInitialValue() {
		return DataType.getAsString(this.getOldObj(S_TaskStatus));
	}

	public void initUserRole(String value) {
		this.initProperty(S_UserRole, value);
	}

	public void setUserRole(String value) {
		this.set(S_UserRole, value);
	}

	public void setUserRoleNull() {
		this.set(S_UserRole, null);
	}

	public String getUserRole() {
		return DataType.getAsString(this.get(S_UserRole));

	}

	public String getUserRoleInitialValue() {
		return DataType.getAsString(this.getOldObj(S_UserRole));
	}

	public void initTaskType(String value) {
		this.initProperty(S_TaskType, value);
	}

	public void setTaskType(String value) {
		this.set(S_TaskType, value);
	}

	public void setTaskTypeNull() {
		this.set(S_TaskType, null);
	}

	public String getTaskType() {
		return DataType.getAsString(this.get(S_TaskType));

	}

	public String getTaskTypeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_TaskType));
	}

	public void initAddpointActionId(String value) {
		this.initProperty(S_AddpointActionId, value);
	}

	public void setAddpointActionId(String value) {
		this.set(S_AddpointActionId, value);
	}

	public void setAddpointActionIdNull() {
		this.set(S_AddpointActionId, null);
	}

	public String getAddpointActionId() {
		return DataType.getAsString(this.get(S_AddpointActionId));

	}

	public String getAddpointActionIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_AddpointActionId));
	}

	public void initActivityType(String value) {
		this.initProperty(S_ActivityType, value);
	}

	public void setActivityType(String value) {
		this.set(S_ActivityType, value);
	}

	public void setActivityTypeNull() {
		this.set(S_ActivityType, null);
	}

	public String getActivityType() {
		return DataType.getAsString(this.get(S_ActivityType));

	}

	public String getActivityTypeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ActivityType));
	}

	public void initBakCol3(String value) {
		this.initProperty(S_BakCol3, value);
	}

	public void setBakCol3(String value) {
		this.set(S_BakCol3, value);
	}

	public void setBakCol3Null() {
		this.set(S_BakCol3, null);
	}

	public String getBakCol3() {
		return DataType.getAsString(this.get(S_BakCol3));

	}

	public String getBakCol3InitialValue() {
		return DataType.getAsString(this.getOldObj(S_BakCol3));
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

	public void initBusiRechargeTaskId(long value) {
		this.initProperty(S_BusiRechargeTaskId, new Long(value));
	}

	public void setBusiRechargeTaskId(long value) {
		this.set(S_BusiRechargeTaskId, new Long(value));
	}

	public void setBusiRechargeTaskIdNull() {
		this.set(S_BusiRechargeTaskId, null);
	}

	public long getBusiRechargeTaskId() {
		return DataType.getAsLong(this.get(S_BusiRechargeTaskId));

	}

	public long getBusiRechargeTaskIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_BusiRechargeTaskId));
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

	public void initSecondTime(Timestamp value) {
		this.initProperty(S_SecondTime, value);
	}

	public void setSecondTime(Timestamp value) {
		this.set(S_SecondTime, value);
	}

	public void setSecondTimeNull() {
		this.set(S_SecondTime, null);
	}

	public Timestamp getSecondTime() {
		return DataType.getAsDateTime(this.get(S_SecondTime));

	}

	public Timestamp getSecondTimeInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_SecondTime));
	}

	public void initTaskTitile(String value) {
		this.initProperty(S_TaskTitile, value);
	}

	public void setTaskTitile(String value) {
		this.set(S_TaskTitile, value);
	}

	public void setTaskTitileNull() {
		this.set(S_TaskTitile, null);
	}

	public String getTaskTitile() {
		return DataType.getAsString(this.get(S_TaskTitile));

	}

	public String getTaskTitileInitialValue() {
		return DataType.getAsString(this.getOldObj(S_TaskTitile));
	}

	public void initUserId(String value) {
		this.initProperty(S_UserId, value);
	}

	public void setUserId(String value) {
		this.set(S_UserId, value);
	}

	public void setUserIdNull() {
		this.set(S_UserId, null);
	}

	public String getUserId() {
		return DataType.getAsString(this.get(S_UserId));

	}

	public String getUserIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_UserId));
	}

	public void initFirstTime(Timestamp value) {
		this.initProperty(S_FirstTime, value);
	}

	public void setFirstTime(Timestamp value) {
		this.set(S_FirstTime, value);
	}

	public void setFirstTimeNull() {
		this.set(S_FirstTime, null);
	}

	public Timestamp getFirstTime() {
		return DataType.getAsDateTime(this.get(S_FirstTime));

	}

	public Timestamp getFirstTimeInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_FirstTime));
	}

	public void initTaskManageStatus(String value) {
		this.initProperty(S_TaskManageStatus, value);
	}

	public void setTaskManageStatus(String value) {
		this.set(S_TaskManageStatus, value);
	}

	public void setTaskManageStatusNull() {
		this.set(S_TaskManageStatus, null);
	}

	public String getTaskManageStatus() {
		return DataType.getAsString(this.get(S_TaskManageStatus));

	}

	public String getTaskManageStatusInitialValue() {
		return DataType.getAsString(this.getOldObj(S_TaskManageStatus));
	}

	public void initExecutionTime(Timestamp value) {
		this.initProperty(S_ExecutionTime, value);
	}

	public void setExecutionTime(Timestamp value) {
		this.set(S_ExecutionTime, value);
	}

	public void setExecutionTimeNull() {
		this.set(S_ExecutionTime, null);
	}

	public Timestamp getExecutionTime() {
		return DataType.getAsDateTime(this.get(S_ExecutionTime));

	}

	public Timestamp getExecutionTimeInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_ExecutionTime));
	}

	public void initMobile(String value) {
		this.initProperty(S_Mobile, value);
	}

	public void setMobile(String value) {
		this.set(S_Mobile, value);
	}

	public void setMobileNull() {
		this.set(S_Mobile, null);
	}

	public String getMobile() {
		return DataType.getAsString(this.get(S_Mobile));

	}

	public String getMobileInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Mobile));
	}

	public void initTaskName(String value) {
		this.initProperty(S_TaskName, value);
	}

	public void setTaskName(String value) {
		this.set(S_TaskName, value);
	}

	public void setTaskNameNull() {
		this.set(S_TaskName, null);
	}

	public String getTaskName() {
		return DataType.getAsString(this.get(S_TaskName));

	}

	public String getTaskNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_TaskName));
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

	public void initReTrialCode(String value) {
		this.initProperty(S_ReTrialCode, value);
	}

	public void setReTrialCode(String value) {
		this.set(S_ReTrialCode, value);
	}

	public void setReTrialCodeNull() {
		this.set(S_ReTrialCode, null);
	}

	public String getReTrialCode() {
		return DataType.getAsString(this.get(S_ReTrialCode));

	}

	public String getReTrialCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ReTrialCode));
	}

}
