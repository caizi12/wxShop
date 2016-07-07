package ngves.asiainfo.core.review.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IQBOReviewJFHSGXValue extends DataStructInterface{
  public final static  String S_RuleId = "RULE_ID" ;
  public final static  String S_MobileBrandCode = "MOBILE_BRAND_CODE";
  public final static  String S_RuleValue = "RULE_VALUE";
  public final static  String S_RuleName = "RULE_NAME";
  public final static  String S_MaxIncrease = "MAX_INCREASE";
  public final static  String S_EndAmount = "END_AMOUNT";
  public final static  String S_IntegralCashRate = "INTEGRAL_CASH_RATE";
  public final static  String S_ConvertRate = "CONVERT_RATE";
  public final static  String S_RoundId = "ROUND_ID";
  public final static  String S_BeginAmount = "BEGIN_AMOUNT";


public String getRuleValue();

public String getRuleName();

public String getMaxIncrease();

public String getEndAmount();

public String getIntegralCashRate();

public String getConvertRate();

public String getMobileBrandCode();

public String getBeginAmount();

public String getRuleId();

public String getRoundId();

public  void setRuleValue(String value);

public  void setRuleName(String value);

public  void setMaxIncrease(String value);

public  void setEndAmount(String value);

public  void setIntegralCashRate(String value);

public  void setConvertRate(String value);

public  void setRoundId(String value);

public  void setBeginAmount(String value);

public  void setMobileBrandCode(String value);

public  void setRuleId(String value);

}
