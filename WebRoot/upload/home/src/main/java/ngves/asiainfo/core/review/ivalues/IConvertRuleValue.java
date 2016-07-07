package ngves.asiainfo.core.review.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IConvertRuleValue extends DataStructInterface{
  public final static  String S_RuleName = "RULE_NAME";
  public final static  String S_BankCol = "BANK_COL";
  public final static  String S_RuleId = "RULE_ID";
  public final static  String S_RuleState = "RULE_STATE";
  public final static  String S_RoundId = "ROUND_ID";
  public final static  String S_IntegralCashRate = "INTEGRAL_CASH_RATE";

public String getRuleName();

public String getBankCol();

public long getRuleId();

public String getRuleState();

public String getRoundId();

public float getIntegralCashRate();

public  void setRuleName(String value);

public  void setBankCol(String value);

public  void setRuleId(long value);

public  void setRuleState(String value);

public  void setRoundId(String value);

public  void setIntegralCashRate(float value);
}
