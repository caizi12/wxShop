package ngves.asiainfo.core.ware.bo;

import ngves.asiainfo.core.ware.ivalues.IRuleInfoValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class RuleInfoBean extends DataContainer implements DataContainerInterface,IRuleInfoValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = -8124771345270979470L;



private static String  m_boName = "ngves.asiainfo.core.ware.bo.RuleInfo";



  public final static  String S_TypeCode = "TYPE_CODE";
  public final static  String S_RuleId = "RULE_ID";
  public final static  String S_TypeName = "TYPE_NAME";
  public final static  String S_Id = "ID";
  public RuleInfoBean() throws AIException{
      super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
  }


 public static ObjectType getObjectTypeStatic() throws AIException{
   return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initTypeCode(String value){
     this.initProperty(S_TypeCode,value);
  }
  public  void setTypeCode(String value){
     this.set(S_TypeCode,value);
  }
  public  void setTypeCodeNull(){
     this.set(S_TypeCode,null);
  }

  public String getTypeCode(){
       return DataType.getAsString(this.get(S_TypeCode));
  
  }
  public String getTypeCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TypeCode));
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

  public void initTypeName(String value){
     this.initProperty(S_TypeName,value);
  }
  public  void setTypeName(String value){
     this.set(S_TypeName,value);
  }
  public  void setTypeNameNull(){
     this.set(S_TypeName,null);
  }

  public String getTypeName(){
       return DataType.getAsString(this.get(S_TypeName));
  
  }
  public String getTypeNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TypeName));
      }

  public void initId(long value){
     this.initProperty(S_Id,new Long(value));
  }
  public  void setId(long value){
     this.set(S_Id,new Long(value));
  }
  public  void setIdNull(){
     this.set(S_Id,null);
  }

  public long getId(){
        return DataType.getAsLong(this.get(S_Id));
  
  }
  public long getIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Id));
      }


 
 }

