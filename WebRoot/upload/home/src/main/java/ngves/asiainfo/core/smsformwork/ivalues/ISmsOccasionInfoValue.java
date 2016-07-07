package ngves.asiainfo.core.smsformwork.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISmsOccasionInfoValue extends DataStructInterface{

  public final static  String S_OperatorCode = "OPERATOR_CODE";
  public final static  String S_EndTime = "END_TIME";
  public final static  String S_OccasionId = "OCCASION_ID";
  public final static  String S_StartTime = "START_TIME";
  public final static  String S_OccasionName = "OCCASION_NAME";
  public final static  String S_OperateTime = "OPERATE_TIME";
  public final static  String S_Oper = "OPER";
  public final static  String S_OrderState = "ORDER_STATE";
  public final static  String S_OccasionTypeId = "OCCASION_TYPE_ID";


public String getOperatorCode();

public String getEndTime();

public String getOccasionId();

public String getStartTime();

public String getOccasionName();

public Timestamp getOperateTime();

public String getOper();

public String getOrderState();

public String getOccasionTypeId();


public  void setOperatorCode(String value);

public  void setEndTime(String value);

public  void setOccasionId(String value);

public  void setStartTime(String value);

public  void setOccasionName(String value);

public  void setOperateTime(Timestamp value);

public  void setOper(String value);

public  void setOrderState(String value);

public  void setOccasionTypeId(String value);
}
