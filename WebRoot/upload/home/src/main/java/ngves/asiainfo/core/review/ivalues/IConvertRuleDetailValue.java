package ngves.asiainfo.core.review.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IConvertRuleDetailValue extends DataStructInterface{

  public final static  String S_UpdateDate = "UPDATE_DATE";
  public final static  String S_EndAmount = "END_AMOUNT";
  public final static  String S_UpdateStaffId = "UPDATE_STAFF_ID";
  public final static  String S_RuleId = "RULE_ID";
  public final static  String S_RuleDetailId = "RULE_DETAIL_ID";
  public final static  String S_MobileBrandCode = "MOBILE_BRAND_CODE";
  public final static  String S_RuleValue = "RULE_VALUE";
  public final static  String S_BeginAmount = "BEGIN_AMOUNT";


public Timestamp getUpdateDate();

public double getEndAmount();

public long getUpdateStaffId();

public long getRuleId();

public long getRuleDetailId();

public String getMobileBrandCode();

public float getRuleValue();

public double getBeginAmount();


public  void setUpdateDate(Timestamp value);

public  void setEndAmount(double value);

public  void setUpdateStaffId(long value);

public  void setRuleId(long value);

public  void setRuleDetailId(long value);

public  void setMobileBrandCode(String value);

public  void setRuleValue(float value);

public  void setBeginAmount(double value);
}
