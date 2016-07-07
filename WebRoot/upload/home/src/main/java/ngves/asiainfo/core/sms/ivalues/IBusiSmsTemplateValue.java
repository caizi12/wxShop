package ngves.asiainfo.core.sms.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBusiSmsTemplateValue extends DataStructInterface{

  public final static  String S_Brand = "BRAND";
  public final static  String S_IsFileupdate = "IS_FILEUPDATE";
  public final static  String S_QuartzTime = "QUARTZ_TIME";
  public final static  String S_SendType = "SEND_TYPE";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_OptId = "OPT_ID";
  public final static  String S_ScoreDown = "SCORE_DOWN";
  public final static  String S_Title = "TITLE";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_Content = "CONTENT";
  public final static  String S_ScoreUp = "SCORE_UP";
  public final static  String S_BusiSmsTemplateId = "BUSI_SMS_TEMPLATE_ID";
  public final static  String S_SmsId = "SMS_ID";


public String getBrand();

public String getIsFileupdate();

public Timestamp getQuartzTime();

public String getSendType();

public String getBakCol1();

public Timestamp getCreateTime();

public String getOptId();

public long getScoreDown();

public String getTitle();

public String getBakCol2();

public String getBakCol3();

public String getContent();

public long getScoreUp();

public long getBusiSmsTemplateId();

public long getSmsId();


public  void setBrand(String value);

public  void setIsFileupdate(String value);

public  void setQuartzTime(Timestamp value);

public  void setSendType(String value);

public  void setBakCol1(String value);

public  void setCreateTime(Timestamp value);

public  void setOptId(String value);

public  void setScoreDown(long value);

public  void setTitle(String value);

public  void setBakCol2(String value);

public  void setBakCol3(String value);

public  void setContent(String value);

public  void setScoreUp(long value);

public  void setBusiSmsTemplateId(long value);

public  void setSmsId(long value);
}
