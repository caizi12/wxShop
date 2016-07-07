package ngves.asiainfo.core.common.ivalues;
import java.sql.Timestamp;

import com.ai.appframe2.common.DataStructInterface;
public interface ISmsLogInfoValue extends DataStructInterface{

  public final static  String S_SmsLogId = "SMS_LOG_ID";
  public final static  String S_SmsTime = "SMS_TIME";
  public final static  String S_SmsContent = "SMS_CONTENT";
  public final static  String S_MobilePhoneNo = "MOBILE_PHONE_NO";


public long getSmsLogId();

public Timestamp getSmsTime();

public String getSmsContent();

public String getMobilePhoneNo();


public  void setSmsLogId(long value);

public  void setSmsTime(Timestamp value);

public  void setSmsContent(String value);

public  void setMobilePhoneNo(String value);
}
