package ngves.asiainfo.core.ware.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ILogisticRulePriceRangeValue extends DataStructInterface{

  public final static  String S_UpdateDate = "UPDATE_DATE";
  public final static  String S_EndAmount = "END_AMOUNT";
  public final static  String S_UpdateStaffId = "UPDATE_STAFF_ID";
  public final static  String S_RuleId = "RULE_ID";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_RangeId = "RANGE_ID";
  public final static  String S_RuleValue = "RULE_VALUE";
  public final static  String S_BeginAmount = "BEGIN_AMOUNT";


public Timestamp getUpdateDate();

public double getEndAmount();

public long getUpdateStaffId();

public long getRuleId();

public String getBakCol2();

public String getBakCol3();

public String getBakCol1();

public long getRangeId();

public long getRuleValue();

public double getBeginAmount();


public  void setUpdateDate(Timestamp value);

public  void setEndAmount(double value);

public  void setUpdateStaffId(long value);

public  void setRuleId(long value);

public  void setBakCol2(String value);

public  void setBakCol3(String value);

public  void setBakCol1(String value);

public  void setRangeId(long value);

public  void setRuleValue(long value);

public  void setBeginAmount(double value);
}
