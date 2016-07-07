package ngves.asiainfo.core.smsformwork.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISmsFormworkWareInfoRltValue extends DataStructInterface{

  public final static  String S_OperatorCode = "OPERATOR_CODE";
  public final static  String S_ActionType = "ACTION_TYPE";
  public final static  String S_WareCode = "WARE_CODE";
  public final static  String S_ActionId = "ACTION_ID";
  public final static  String S_RltId = "RLT_ID";
  public final static  String S_OperateTime = "OPERATE_TIME";
  public final static  String S_FormworkId = "FORMWORK_ID";


public String getOperatorCode();

public String getActionType();

public String getWareCode();

public String getActionId();

public String getRltId();

public Timestamp getOperateTime();

public String getFormworkId();


public  void setOperatorCode(String value);

public  void setActionType(String value);

public  void setWareCode(String value);

public  void setActionId(String value);

public  void setRltId(String value);

public  void setOperateTime(Timestamp value);

public  void setFormworkId(String value);
}
