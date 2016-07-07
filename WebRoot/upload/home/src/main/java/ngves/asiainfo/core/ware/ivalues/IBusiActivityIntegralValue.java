package ngves.asiainfo.core.ware.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBusiActivityIntegralValue extends DataStructInterface{

  public final static  String S_OriIntegral = "ORI_INTEGRAL";
  public final static  String S_StarLevel = "STAR_LEVEL";
  public final static  String S_ActivityId = "ACTIVITY_ID";
  public final static  String S_CurPayCash = "CUR_PAY_CASH";
  public final static  String S_OriPayCash = "ORI_PAY_CASH";
  public final static  String S_OriPayIntegral = "ORI_PAY_INTEGRAL";
  public final static  String S_WareId = "WARE_ID";
  public final static  String S_Channel = "CHANNEL";
  public final static  String S_CurIntegral = "CUR_INTEGRAL";
  public final static  String S_Id = "ID";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_CurPayIntegral = "CUR_PAY_INTEGRAL";
  public final static  String S_ActivityType = "ACTIVITY_TYPE";


public long getOriIntegral();

public String getStarLevel();

public long getActivityId();

public long getCurPayCash();

public long getOriPayCash();

public long getOriPayIntegral();

public long getWareId();

public String getChannel();

public long getCurIntegral();

public long getId();

public Timestamp getCreateDate();

public long getCurPayIntegral();

public String getActivityType();


public  void setOriIntegral(long value);

public  void setStarLevel(String value);

public  void setActivityId(long value);

public  void setCurPayCash(long value);

public  void setOriPayCash(long value);

public  void setOriPayIntegral(long value);

public  void setWareId(long value);

public  void setChannel(String value);

public  void setCurIntegral(long value);

public  void setId(long value);

public  void setCreateDate(Timestamp value);

public  void setCurPayIntegral(long value);

public  void setActivityType(String value);
}
