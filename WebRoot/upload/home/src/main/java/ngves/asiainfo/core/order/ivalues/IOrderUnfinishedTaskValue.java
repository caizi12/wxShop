package ngves.asiainfo.core.order.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IOrderUnfinishedTaskValue extends DataStructInterface{

  public final static  String S_TaskState = "TASK_STATE";
  public final static  String S_IsCreateResult = "IS_CREATE_RESULT";
  public final static  String S_EndState = "END_STATE";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_Oper = "OPER";
  public final static  String S_FailFilePath = "FAIL_FILE_PATH";
  public final static  String S_OptId = "OPT_ID";
  public final static  String S_SecondTime = "SECOND_TIME";
  public final static  String S_ReTrialId = "RE_TRIAL_ID";
  public final static  String S_FailCounts = "FAIL_COUNTS";
  public final static  String S_BusinessType = "BUSINESS_TYPE";
  public final static  String S_FirstTime = "FIRST_TIME";
  public final static  String S_IsSettle = "IS_SETTLE";
  public final static  String S_NotExistsCounts = "NOT_EXISTS_COUNTS";
  public final static  String S_IsSend = "IS_SEND";
  public final static  String S_FirstTrialCode = "FIRST_TRIAL_CODE";
  public final static  String S_FirstTrialId = "FIRST_TRIAL_ID";
  public final static  String S_OrderType = "ORDER_TYPE";
  public final static  String S_ReTrialCode = "RE_TRIAL_CODE";
  public final static  String S_OptCode = "OPT_CODE";
  public final static  String S_SuccFilePath = "SUCC_FILE_PATH";
  public final static  String S_SuccCounts = "SUCC_COUNTS";
  public final static  String S_ManageState = "MANAGE_STATE";
  public final static  String S_FileNameSeq = "FILE_NAME_SEQ";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_DescInfo = "DESC_INFO";
  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_FileName = "FILE_NAME";
  public final static  String S_TaskId = "TASK_ID";


public String getTaskState();

public String getIsCreateResult();

public String getEndState();

public Timestamp getCreateTime();

public String getBakCol1();

public String getOper();

public String getFailFilePath();

public String getOptId();

public Timestamp getSecondTime();

public String getReTrialId();

public long getFailCounts();

public String getBusinessType();

public Timestamp getFirstTime();

public String getIsSettle();

public long getNotExistsCounts();

public String getIsSend();

public String getFirstTrialCode();

public String getFirstTrialId();

public String getOrderType();

public String getReTrialCode();

public String getOptCode();

public String getSuccFilePath();

public long getSuccCounts();

public String getManageState();

public String getFileNameSeq();

public String getBakCol2();

public String getDescInfo();

public String getBakCol3();

public String getFileName();

public long getTaskId();


public  void setTaskState(String value);

public  void setIsCreateResult(String value);

public  void setEndState(String value);

public  void setCreateTime(Timestamp value);

public  void setBakCol1(String value);

public  void setOper(String value);

public  void setFailFilePath(String value);

public  void setOptId(String value);

public  void setSecondTime(Timestamp value);

public  void setReTrialId(String value);

public  void setFailCounts(long value);

public  void setBusinessType(String value);

public  void setFirstTime(Timestamp value);

public  void setIsSettle(String value);

public  void setNotExistsCounts(long value);

public  void setIsSend(String value);

public  void setFirstTrialCode(String value);

public  void setFirstTrialId(String value);

public  void setOrderType(String value);

public  void setReTrialCode(String value);

public  void setOptCode(String value);

public  void setSuccFilePath(String value);

public  void setSuccCounts(long value);

public  void setManageState(String value);

public  void setFileNameSeq(String value);

public  void setBakCol2(String value);

public  void setDescInfo(String value);

public  void setBakCol3(String value);

public  void setFileName(String value);

public  void setTaskId(long value);
}
