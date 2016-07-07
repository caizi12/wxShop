package ngves.asiainfo.core.review.bo;

import java.sql.*;

import ngves.asiainfo.core.review.ivalues.IWareConvertRuleValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

public class WareConvertRuleBean extends DataContainer implements DataContainerInterface,IWareConvertRuleValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



private static String  m_boName = "ngves.asiainfo.core.review.bo.WareConvertRule";



  public final static  String S_UpdateDate = "UPDATE_DATE";
  public final static  String S_RuleId = "RULE_ID";
  public final static  String S_WareId = "WARE_ID";
  public final static  String S_ValidFlag = "VALID_FLAG";
  public final static  String S_BindId = "BIND_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public WareConvertRuleBean() throws AIException{
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

  public void initWareId(long value){
     this.initProperty(S_WareId,new Long(value));
  }
  public  void setWareId(long value){
     this.set(S_WareId,new Long(value));
  }
  public  void setWareIdNull(){
     this.set(S_WareId,null);
  }

  public long getWareId(){
        return DataType.getAsLong(this.get(S_WareId));
  
  }
  public long getWareIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_WareId));
      }

  public void initValidFlag(String value){
     this.initProperty(S_ValidFlag,value);
  }
  public  void setValidFlag(String value){
     this.set(S_ValidFlag,value);
  }
  public  void setValidFlagNull(){
     this.set(S_ValidFlag,null);
  }

  public String getValidFlag(){
       return DataType.getAsString(this.get(S_ValidFlag));
  
  }
  public String getValidFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ValidFlag));
      }

  public void initBindId(long value){
     this.initProperty(S_BindId,new Long(value));
  }
  public  void setBindId(long value){
     this.set(S_BindId,new Long(value));
  }
  public  void setBindIdNull(){
     this.set(S_BindId,null);
  }

  public long getBindId(){
        return DataType.getAsLong(this.get(S_BindId));
  
  }
  public long getBindIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BindId));
      }


 
 }

