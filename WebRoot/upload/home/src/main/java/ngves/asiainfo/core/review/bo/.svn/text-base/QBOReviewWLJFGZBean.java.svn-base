package ngves.asiainfo.core.review.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.review.ivalues.*;

public class QBOReviewWLJFGZBean extends DataContainer implements DataContainerInterface,IQBOReviewWLJFGZValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 3762804349876047221L;



private static String  m_boName = "ngves.asiainfo.core.review.bo.QBOReviewWLJFGZ";



  public final static  String S_RuleValue = "RULE_VALUE";
  public final static  String S_RuleName = "RULE_NAME";
  public final static  String S_EndAmount = "END_AMOUNT";
  public final static  String S_BeginAmount = "BEGIN_AMOUNT";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QBOReviewWLJFGZBean() throws AIException{
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


 
 }

