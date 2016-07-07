package ngves.asiainfo.core.sms.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISmsTemplateValue extends DataStructInterface{

  public final static  String S_SubmitTime = "SUBMIT_TIME";
  public final static  String S_Brand = "BRAND";
  public final static  String S_SendType = "SEND_TYPE";
  public final static  String S_QuartzTime = "QUARTZ_TIME";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_Operat = "OPERAT";
  public final static  String S_OptId = "OPT_ID";
  public final static  String S_SecondTime = "SECOND_TIME";
  public final static  String S_ScoreDown = "SCORE_DOWN";
  public final static  String S_Title = "TITLE";
  public final static  String S_Status = "STATUS";
  public final static  String S_FilePath = "FILE_PATH";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_NoCount = "NO_COUNT";
  public final static  String S_ScoreUp = "SCORE_UP";
  public final static  String S_Content = "CONTENT";
  public final static  String S_FirstTime = "FIRST_TIME";
  public final static  String S_SmsId = "SMS_ID";
  public final static  String S_ProvCode = "PROV_CODE";


public Timestamp getSubmitTime();

public String getBrand();

public String getSendType();

public Timestamp getQuartzTime();

public String getBakCol1();

public Timestamp getCreateTime();

public String getOperat();

public String getOptId();

public Timestamp getSecondTime();

public long getScoreDown();

public String getTitle();

public String getStatus();

public String getFilePath();

public String getBakCol2();

public String getBakCol3();

public long getNoCount();

public long getScoreUp();

public String getContent();

public Timestamp getFirstTime();

public long getSmsId();

public String getProvCode();


public  void setSubmitTime(Timestamp value);

public  void setBrand(String value);

public  void setSendType(String value);

public  void setQuartzTime(Timestamp value);

public  void setBakCol1(String value);

public  void setCreateTime(Timestamp value);

public  void setOperat(String value);

public  void setOptId(String value);

public  void setSecondTime(Timestamp value);

public  void setScoreDown(long value);

public  void setTitle(String value);

public  void setStatus(String value);

public  void setFilePath(String value);

public  void setBakCol2(String value);

public  void setBakCol3(String value);

public  void setNoCount(long value);

public  void setScoreUp(long value);

public  void setContent(String value);

public  void setFirstTime(Timestamp value);

public  void setSmsId(long value);

public  void setProvCode(String value);
}
