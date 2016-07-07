package ngves.asiainfo.core.rushbuy.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IQBOFinishedActivityLimitGroupValue extends DataStructInterface{

  public final static  String S_Title = "TITLE";
  public final static  String S_EndTime = "END_TIME";
  public final static  String S_StartTime = "START_TIME";
  public final static  String S_AlGroupId = "AL_GROUP_ID";
  public final static  String S_Url = "URL";
  public final static  String S_ActivityId = "ACTIVITY_ID";


public String getTitle();

public Timestamp getEndTime();

public Timestamp getStartTime();

public long getAlGroupId();

public String getUrl();

public long getActivityId();


public  void setTitle(String value);

public  void setEndTime(Timestamp value);

public  void setStartTime(Timestamp value);

public  void setAlGroupId(long value);

public  void setUrl(String value);

public  void setActivityId(long value);
}
