package ngves.asiainfo.core.rechargepoints.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IQBORechargeFileValue extends DataStructInterface{

  public final static  String S_RechargeFileName = "RECHARGE_FILE_NAME";
  public final static  String S_RechargeFileNickname = "RECHARGE_FILE_NICKNAME";
  public final static  String S_TaskName = "TASK_NAME";
  public final static  String S_RechargeTaskId = "RECHARGE_TASK_ID";
  public final static  String S_SmsMessage = "SMS_MESSAGE";
  public final static  String S_IsSendSms = "IS_SEND_SMS";
  public final static String S_IsDeleted = "IS_DELETED";


public String getRechargeFileName();

public String getRechargeFileNickname();

public String getTaskName();

public long getRechargeTaskId();

public String getSmsMessage();

public String getIsSendSms();

public String getIsDeleted();

public void setIsDeleted(String value);

public  void setRechargeFileName(String value);

public  void setRechargeFileNickname(String value);

public  void setTaskName(String value);

public  void setRechargeTaskId(long value);

public  void setSmsMessage(String value);

public  void setIsSendSms(String value);
}
