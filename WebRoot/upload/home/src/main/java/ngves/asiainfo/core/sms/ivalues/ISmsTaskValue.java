package ngves.asiainfo.core.sms.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface ISmsTaskValue extends DataStructInterface{

  public final static  String S_NosendCount = "NOSEND_COUNT";
  public final static  String S_DupliFilePath = "DUPLI_FILE_PATH";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_FailCount = "FAIL_COUNT";
  public final static  String S_DupliCount = "DUPLI_COUNT";
  public final static  String S_ErrorCount = "ERROR_COUNT";
  public final static  String S_FailFilePath = "FAIL_FILE_PATH";
  public final static  String S_SuccCount = "SUCC_COUNT";
  public final static  String S_ErrorFilePath = "ERROR_FILE_PATH";
  public final static  String S_Status = "STATUS";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_NoCount = "NO_COUNT";
  public final static  String S_Opera = "OPERA";
  public final static  String S_IsQuartz = "IS_QUARTZ";
  public final static  String S_SmsId = "SMS_ID";
  public final static  String S_ProvCode = "PROV_CODE";
  public final static  String S_Id = "ID";


public long getNosendCount();

public String getDupliFilePath();

public String getBakCol1();

public long getFailCount();

public long getDupliCount();

public long getErrorCount();

public String getFailFilePath();

public long getSuccCount();

public String getErrorFilePath();

public String getStatus();

public String getBakCol2();

public String getBakCol3();

public long getNoCount();

public String getOpera();

public String getIsQuartz();

public long getSmsId();

public String getProvCode();

public long getId();


public  void setNosendCount(long value);

public  void setDupliFilePath(String value);

public  void setBakCol1(String value);

public  void setFailCount(long value);

public  void setDupliCount(long value);

public  void setErrorCount(long value);

public  void setFailFilePath(String value);

public  void setSuccCount(long value);

public  void setErrorFilePath(String value);

public  void setStatus(String value);

public  void setBakCol2(String value);

public  void setBakCol3(String value);

public  void setNoCount(long value);

public  void setOpera(String value);

public  void setIsQuartz(String value);

public  void setSmsId(long value);

public  void setProvCode(String value);

public  void setId(long value);
}
