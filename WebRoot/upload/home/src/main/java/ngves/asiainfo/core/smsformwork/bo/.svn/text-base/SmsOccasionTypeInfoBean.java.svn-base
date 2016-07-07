package ngves.asiainfo.core.smsformwork.bo;

import java.sql.Timestamp;

import ngves.asiainfo.core.smsformwork.ivalues.ISmsOccasionTypeInfoValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class SmsOccasionTypeInfoBean extends DataContainer implements DataContainerInterface,ISmsOccasionTypeInfoValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 7619895812725867092L;



private static String  m_boName = "ngves.asiainfo.core.smsformwork.bo.SmsOccasionTypeInfo";



  public final static  String S_OperatorCode = "OPERATOR_CODE";
  public final static  String S_OccasionTypeName = "OCCASION_TYPE_NAME";
  public final static  String S_OccasionTypeCode = "OCCASION_TYPE_CODE";
  public final static  String S_OperateTime = "OPERATE_TIME";
  public final static  String S_OccasionTypeId = "OCCASION_TYPE_ID";
  public SmsOccasionTypeInfoBean() throws AIException{
      super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
  }


 public static ObjectType getObjectTypeStatic() throws AIException{
   return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initOperatorCode(String value){
     this.initProperty(S_OperatorCode,value);
  }
  public  void setOperatorCode(String value){
     this.set(S_OperatorCode,value);
  }
  public  void setOperatorCodeNull(){
     this.set(S_OperatorCode,null);
  }

  public String getOperatorCode(){
       return DataType.getAsString(this.get(S_OperatorCode));
  
  }
  public String getOperatorCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OperatorCode));
      }

  public void initOccasionTypeName(String value){
     this.initProperty(S_OccasionTypeName,value);
  }
  public  void setOccasionTypeName(String value){
     this.set(S_OccasionTypeName,value);
  }
  public  void setOccasionTypeNameNull(){
     this.set(S_OccasionTypeName,null);
  }

  public String getOccasionTypeName(){
       return DataType.getAsString(this.get(S_OccasionTypeName));
  
  }
  public String getOccasionTypeNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OccasionTypeName));
      }

  public void initOccasionTypeCode(String value){
     this.initProperty(S_OccasionTypeCode,value);
  }
  public  void setOccasionTypeCode(String value){
     this.set(S_OccasionTypeCode,value);
  }
  public  void setOccasionTypeCodeNull(){
     this.set(S_OccasionTypeCode,null);
  }

  public String getOccasionTypeCode(){
       return DataType.getAsString(this.get(S_OccasionTypeCode));
  
  }
  public String getOccasionTypeCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OccasionTypeCode));
      }

  public void initOperateTime(Timestamp value){
     this.initProperty(S_OperateTime,value);
  }
  public  void setOperateTime(Timestamp value){
     this.set(S_OperateTime,value);
  }
  public  void setOperateTimeNull(){
     this.set(S_OperateTime,null);
  }

  public Timestamp getOperateTime(){
        return DataType.getAsDateTime(this.get(S_OperateTime));
  
  }
  public Timestamp getOperateTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_OperateTime));
      }

  public void initOccasionTypeId(String value){
     this.initProperty(S_OccasionTypeId,value);
  }
  public  void setOccasionTypeId(String value){
     this.set(S_OccasionTypeId,value);
  }
  public  void setOccasionTypeIdNull(){
     this.set(S_OccasionTypeId,null);
  }

  public String getOccasionTypeId(){
       return DataType.getAsString(this.get(S_OccasionTypeId));
  
  }
  public String getOccasionTypeIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OccasionTypeId));
      }


 
 }

