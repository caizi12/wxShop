package ngves.asiainfo.core.smsformwork.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface ISmsFormworkOccasionRltValue extends DataStructInterface{

  public final static  String S_ContentId = "CONTENT_ID";
  public final static  String S_EndTime = "END_TIME";
  public final static  String S_OccasionId = "OCCASION_ID";
  public final static  String S_StartTime = "START_TIME";
  public final static  String S_ContentName = "CONTENT_NAME";
  public final static  String S_IsSend = "IS_SEND";
  public final static  String S_RltId = "RLT_ID";
  public final static  String S_OccasionTypeId = "OCCASION_TYPE_ID";
  public final static  String S_FormworkId = "FORMWORK_ID";


public String getContentId();

public String getEndTime();

public String getOccasionId();

public String getStartTime();

public String getContentName();

public String getIsSend();

public String getRltId();

public String getOccasionTypeId();

public String getFormworkId();


public  void setContentId(String value);

public  void setEndTime(String value);

public  void setOccasionId(String value);

public  void setStartTime(String value);

public  void setContentName(String value);

public  void setIsSend(String value);

public  void setRltId(String value);

public  void setOccasionTypeId(String value);

public  void setFormworkId(String value);
}
