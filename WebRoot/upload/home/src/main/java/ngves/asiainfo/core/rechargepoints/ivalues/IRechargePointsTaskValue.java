package ngves.asiainfo.core.rechargepoints.ivalues;

import java.sql.Timestamp;

import com.ai.appframe2.common.DataStructInterface;

public interface IRechargePointsTaskValue extends DataStructInterface {

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

	public String getFirstTrialCode();

	public Timestamp getCreateTime();

	public String getTaskChannel();

	public long getRechargeTaskId();

	public String getActivityName();

	public String getChannelName();

	public String getRequestSeq();

	public String getCancelCause();

	public String getIsDeleted();

	public String getTaskStatus();

	public String getUserRole();

	public String getTaskType();

	public String getAddpointActionId();

	public String getActivityType();

	public String getBakCol3();

	public String getBakCol2();

	public String getBakCol1();

	public Timestamp getSecondTime();

	public String getTaskTitile();

	public String getUserId();

	public Timestamp getFirstTime();

	public String getTaskManageStatus();

	public Timestamp getExecutionTime();

	public String getMobile();

	public String getTaskName();

	public String getIsSendSms();

	public String getReTrialCode();

	public void setFirstTrialCode(String value);

	public void setCreateTime(Timestamp value);

	public void setTaskChannel(String value);

	public void setRechargeTaskId(long value);

	public void setActivityName(String value);

	public void setChannelName(String value);

	public void setRequestSeq(String value);

	public void setCancelCause(String value);

	public void setIsDeleted(String value);

	public void setTaskStatus(String value);

	public void setUserRole(String value);

	public void setTaskType(String value);

	public void setAddpointActionId(String value);

	public void setActivityType(String value);

	public void setBakCol3(String value);

	public void setBakCol2(String value);

	public void setBakCol1(String value);

	public void setSecondTime(Timestamp value);

	public void setTaskTitile(String value);

	public void setUserId(String value);

	public void setFirstTime(Timestamp value);

	public void setTaskManageStatus(String value);

	public void setExecutionTime(Timestamp value);

	public void setMobile(String value);

	public void setTaskName(String value);

	public void setIsSendSms(String value);

	public void setReTrialCode(String value);
}
