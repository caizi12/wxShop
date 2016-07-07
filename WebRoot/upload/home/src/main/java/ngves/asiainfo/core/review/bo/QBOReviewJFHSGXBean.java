package ngves.asiainfo.core.review.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.review.ivalues.*;

public class QBOReviewJFHSGXBean extends DataContainer implements DataContainerInterface,IQBOReviewJFHSGXValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 7749600624177112892L;



private static String  m_boName = "ngves.asiainfo.core.review.bo.QBOReviewJFHSGX";


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

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QBOReviewJFHSGXBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initRuleValue(String value){
     this.initProperty(S_RuleValue,value);
  }
  public  void setRuleValue(String value){
     this.set(S_RuleValue,value);
  }
  public  void setRuleValueNull(){
     this.set(S_RuleValue,null);
  }

  public String getRuleValue(){
        return DataType.getAsString(this.get(S_RuleValue));
  
  }
  public String getRuleValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RuleValue));
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

  public void initMaxIncrease(String value){
     this.initProperty(S_MaxIncrease,value);
  }
  public  void setMaxIncrease(String value){
     this.set(S_MaxIncrease,value);
  }
  public  void setMaxIncreaseNull(){
     this.set(S_MaxIncrease,null);
  }

  public String getMaxIncrease(){
        return DataType.getAsString(this.get(S_MaxIncrease));
  
  }
  public String getMaxIncreaseInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MaxIncrease));
      }

  public void initEndAmount(String value){
     this.initProperty(S_EndAmount,value);
  }
  public  void setEndAmount(String value){
     this.set(S_EndAmount,value);
  }
  public  void setEndAmountNull(){
     this.set(S_EndAmount,null);
  }

  public String getEndAmount(){
        return DataType.getAsString(this.get(S_EndAmount));
  
  }
  public String getEndAmountInitialValue(){
        return DataType.getAsString(this.getOldObj(S_EndAmount));
      }

  public void initIntegralCashRate(String value){
     this.initProperty(S_IntegralCashRate,value);
  }
  public  void setIntegralCashRate(String value){
     this.set(S_IntegralCashRate,value);
  }
  public  void setIntegralCashRateNull(){
     this.set(S_IntegralCashRate,null);
  }

  public String getIntegralCashRate(){
        return DataType.getAsString(this.get(S_IntegralCashRate));
  
  }
  public String getIntegralCashRateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IntegralCashRate));
      }

  public void initConvertRate(String value){
     this.initProperty(S_ConvertRate,value);
  }
  public  void setConvertRate(String value){
     this.set(S_ConvertRate,value);
  }
  public  void setConvertRateNull(){
     this.set(S_ConvertRate,null);
  }

  public String getConvertRate(){
        return DataType.getAsString(this.get(S_ConvertRate));
  
  }
  public String getConvertRateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ConvertRate));
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

  public void initBeginAmount(String value){
     this.initProperty(S_BeginAmount,value);
  }
  public  void setBeginAmount(String value){
     this.set(S_BeginAmount,value);
  }
  public  void setBeginAmountNull(){
     this.set(S_BeginAmount,null);
  }

  public String getBeginAmount(){
        return DataType.getAsString(this.get(S_BeginAmount));
  
  }
  public String getBeginAmountInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BeginAmount));
      }

  	public void initRuleId(String value){
		this.initProperty(S_RuleId,value);
	}
	public  void setRuleId(String value){
		this.set(S_RuleId,value);
	}
	public  void setRuleIdNull(){
		this.set(S_RuleId,null);
	}
	
	public String getRuleId(){
		return DataType.getAsString(this.get(S_RuleId));
	
	}
	public String getRuleIdInitialValue(){
		return DataType.getAsString(this.getOldObj(S_RuleId));
	}
 
	public void initMobileBrandCode(String value){
		this.initProperty(S_MobileBrandCode,value);
	}
	public  void setMobileBrandCode(String value){
		this.set(S_MobileBrandCode,value);
	}
	public  void setMobileBrandCodeNull(){
		this.set(S_MobileBrandCode,null);
	}

	public String getMobileBrandCode(){
		return DataType.getAsString(this.get(S_MobileBrandCode));

	}
	public String getMobileBrandCodeInitialValue(){
		return DataType.getAsString(this.getOldObj(S_MobileBrandCode));
	}
 }

