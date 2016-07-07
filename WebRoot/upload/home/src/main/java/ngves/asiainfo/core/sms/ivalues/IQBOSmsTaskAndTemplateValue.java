package ngves.asiainfo.core.sms.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IQBOSmsTaskAndTemplateValue extends DataStructInterface{

  public final static  String S_QuartzTime = "QUARTZ_TIME";
  public final static  String S_SendType = "SEND_TYPE";
  public final static  String S_SecondTime = "SECOND_TIME";
  public final static  String S_Title = "TITLE";
  public final static  String S_IsDownload = "IS_DOWNLOAD";
  public final static  String S_Status = "STATUS";
  public final static  String S_FilePath = "FILE_PATH";
  public final static  String S_NoCount = "NO_COUNT";
  public final static  String S_Content = "CONTENT";
  public final static  String S_TaskId = "TASK_ID";
  public final static  String S_Opera = "OPERA";
  public final static  String S_SmsId = "SMS_ID";
  public final static  String S_TemplateStatus = "TEMPLATE_STATUS";
  public final static  String S_ProvCode = "PROV_CODE";


public Timestamp getQuartzTime();

public String getSendType();

public Timestamp getSecondTime();

public String getTitle();

public String getIsDownload();

public String getStatus();

public String getFilePath();

public long getNoCount();

public String getContent();

public long getTaskId();

public String getOpera();

public long getSmsId();

public String getTemplateStatus();

public String getProvCode();


public  void setQuartzTime(Timestamp value);

public  void setSendType(String value);

public  void setSecondTime(Timestamp value);

public  void setTitle(String value);

public  void setIsDownload(String value);

public  void setStatus(String value);

public  void setFilePath(String value);

public  void setNoCount(long value);

public  void setContent(String value);

public  void setTaskId(long value);

public  void setOpera(String value);

public  void setSmsId(long value);

public  void setTemplateStatus(String value);

public  void setProvCode(String value);
}
