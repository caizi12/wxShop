package ngves.asiainfo.core.review.bo;

import ngves.asiainfo.core.review.ivalues.IConvertRuleValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class ConvertRuleBean extends DataContainer implements DataContainerInterface,IConvertRuleValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



private static String  m_boName = "ngves.asiainfo.core.review.bo.ConvertRule";

  public final static  String S_RuleName = "RULE_NAME";
  public final static  String S_BankCol = "BANK_COL";
  public final static  String S_RuleId = "RULE_ID";
  public final static  String S_RuleState = "RULE_STATE";
  public final static  String S_RoundId = "ROUND_ID";
  public final static  String S_IntegralCashRate = "INTEGRAL_CASH_RATE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public ConvertRuleBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }

  public void initRuleName(String value){
     this.initProperty(S_RuleName,value);
  }
  public  void setRuleName(String value){
     this.set(S_RuleName,value);
  }
  public  void setRuleNameNull(){
     this.set(S_RuleName,null);
  }

  public String getRuleName(){
       return DataType.getAsString(this.get(S_RuleName));
  
  }
  public String getRuleNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RuleName));
      }

  public void initBankCol(String value){
     this.initProperty(S_BankCol,value);
  }
  public  void setBankCol(String value){
     this.set(S_BankCol,value);
  }
  public  void setBankColNull(){
     this.set(S_BankCol,null);
  }

  public String getBankCol(){
       return DataType.getAsString(this.get(S_BankCol));
  
  }
  public String getBankColInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BankCol));
      }

  public void initRuleId(long value){
     this.initProperty(S_RuleId,new Long(value));
  }
  public  void setRuleId(long value){
     this.set(S_RuleId,new Long(value));
  }
  public  void setRuleIdNull(){
     this.set(S_RuleId,null);
  }

  public long getRuleId(){
        return DataType.getAsLong(this.get(S_RuleId));
  
  }
  public long getRuleIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RuleId));
      }

  public void initRuleState(String value){
     this.initProperty(S_RuleState,value);
  }
  public  void setRuleState(String value){
     this.set(S_RuleState,value);
  }
  public  void setRuleStateNull(){
     this.set(S_RuleState,null);
  }

  public String getRuleState(){
       return DataType.getAsString(this.get(S_RuleState));
  
  }
  public String getRuleStateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RuleState));
      }

  public void initRoundId(String value){
     this.initProperty(S_RoundId,value);
  }
  public  void setRoundId(String value){
     this.set(S_RoundId,value);
  }
  public  void setRoundIdNull(){
     this.set(S_RoundId,null);
  }

  public String getRoundId(){
       return DataType.getAsString(this.get(S_RoundId));
  }
  public String getRoundIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RoundId));
  }
  
  public void initIntegralCashRate(float value){
	     this.initProperty(S_IntegralCashRate,new Float(value));
  }
  public  void setIntegralCashRate(float value){
     this.set(S_IntegralCashRate,new Float(value));
  }
  public  void setIntegralCashRateNull(){
     this.set(S_IntegralCashRate,null);
  }

  public float getIntegralCashRate(){
        return DataType.getAsFloat(this.get(S_IntegralCashRate));
  }
  public float getIntegralCashRateInitialValue(){
        return DataType.getAsFloat(this.getOldObj(S_IntegralCashRate));
  }
 
 }

