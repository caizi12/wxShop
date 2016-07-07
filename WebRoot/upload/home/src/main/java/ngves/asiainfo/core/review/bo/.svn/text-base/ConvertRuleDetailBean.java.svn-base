package ngves.asiainfo.core.review.bo;

import java.sql.*;

import ngves.asiainfo.core.review.ivalues.IConvertRuleDetailValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

public class ConvertRuleDetailBean extends DataContainer implements DataContainerInterface,IConvertRuleDetailValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



private static String  m_boName = "ngves.asiainfo.core.review.bo.ConvertRuleDetail";



  public final static  String S_UpdateDate = "UPDATE_DATE";
  public final static  String S_EndAmount = "END_AMOUNT";
  public final static  String S_UpdateStaffId = "UPDATE_STAFF_ID";
  public final static  String S_RuleId = "RULE_ID";
  public final static  String S_RuleDetailId = "RULE_DETAIL_ID";
  public final static  String S_MobileBrandCode = "MOBILE_BRAND_CODE";
  public final static  String S_RuleValue = "RULE_VALUE";
  public final static  String S_BeginAmount = "BEGIN_AMOUNT";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public ConvertRuleDetailBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initUpdateDate(Timestamp value){
     this.initProperty(S_UpdateDate,value);
  }
  public  void setUpdateDate(Timestamp value){
     this.set(S_UpdateDate,value);
  }
  public  void setUpdateDateNull(){
     this.set(S_UpdateDate,null);
  }

  public Timestamp getUpdateDate(){
        return DataType.getAsDateTime(this.get(S_UpdateDate));
  
  }
  public Timestamp getUpdateDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_UpdateDate));
      }

  public void initEndAmount(double value){
     this.initProperty(S_EndAmount,new Double(value));
  }
  public  void setEndAmount(double value){
     this.set(S_EndAmount,new Double(value));
  }
  public  void setEndAmountNull(){
     this.set(S_EndAmount,null);
  }

  public double getEndAmount(){
        return DataType.getAsDouble(this.get(S_EndAmount));
  
  }
  public double getEndAmountInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_EndAmount));
      }

  public void initUpdateStaffId(long value){
     this.initProperty(S_UpdateStaffId,new Long(value));
  }
  public  void setUpdateStaffId(long value){
     this.set(S_UpdateStaffId,new Long(value));
  }
  public  void setUpdateStaffIdNull(){
     this.set(S_UpdateStaffId,null);
  }

  public long getUpdateStaffId(){
        return DataType.getAsLong(this.get(S_UpdateStaffId));
  
  }
  public long getUpdateStaffIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_UpdateStaffId));
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

  public void initRuleDetailId(long value){
     this.initProperty(S_RuleDetailId,new Long(value));
  }
  public  void setRuleDetailId(long value){
     this.set(S_RuleDetailId,new Long(value));
  }
  public  void setRuleDetailIdNull(){
     this.set(S_RuleDetailId,null);
  }

  public long getRuleDetailId(){
        return DataType.getAsLong(this.get(S_RuleDetailId));
  
  }
  public long getRuleDetailIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RuleDetailId));
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

  public void initRuleValue(float value){
     this.initProperty(S_RuleValue,new Float(value));
  }
  public  void setRuleValue(float value){
     this.set(S_RuleValue,new Float(value));
  }
  public  void setRuleValueNull(){
     this.set(S_RuleValue,null);
  }

  public float getRuleValue(){
        return DataType.getAsFloat(this.get(S_RuleValue));
  
  }
  public float getRuleValueInitialValue(){
        return DataType.getAsFloat(this.getOldObj(S_RuleValue));
      }

  public void initBeginAmount(double value){
     this.initProperty(S_BeginAmount,new Double(value));
  }
  public  void setBeginAmount(double value){
     this.set(S_BeginAmount,new Double(value));
  }
  public  void setBeginAmountNull(){
     this.set(S_BeginAmount,null);
  }

  public double getBeginAmount(){
        return DataType.getAsDouble(this.get(S_BeginAmount));
  
  }
  public double getBeginAmountInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_BeginAmount));
      }


 
 }

