package ngves.asiainfo.core.ware.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ILogisticRuleHouseRltValue extends DataStructInterface{

  public final static  String S_UpdateTime = "UPDATE_TIME";
  public final static  String S_RuleId = "RULE_ID";
  public final static  String S_WarehouseId = "WAREHOUSE_ID";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_ValidFlag = "VALID_FLAG";
  public final static  String S_RltId = "RLT_ID";


public Timestamp getUpdateTime();

public long getRuleId();

public long getWarehouseId();

public String getBakCol2();

public String getBakCol3();

public String getBakCol1();

public String getValidFlag();

public long getRltId();


public  void setUpdateTime(Timestamp value);

public  void setRuleId(long value);

public  void setWarehouseId(long value);

public  void setBakCol2(String value);

public  void setBakCol3(String value);

public  void setBakCol1(String value);

public  void setValidFlag(String value);

public  void setRltId(long value);
}
