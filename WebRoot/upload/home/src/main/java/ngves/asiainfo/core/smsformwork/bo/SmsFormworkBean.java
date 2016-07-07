package ngves.asiainfo.core.smsformwork.bo;

import java.sql.Timestamp;

import ngves.asiainfo.core.smsformwork.ivalues.ISmsFormworkValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class SmsFormworkBean extends DataContainer implements DataContainerInterface,ISmsFormworkValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 5685831832614108488L;



private static String  m_boName = "ngves.asiainfo.core.smsformwork.bo.SmsFormwork";



  public final static  String S_IsStopped = "IS_STOPPED";
  public final static  String S_OperatorCode = "OPERATOR_CODE";
  public final static  String S_FormworkState = "FORMWORK_STATE";
  public final static  String S_FormworkName = "FORMWORK_NAME";
  public final static  String S_SendProvince = "SEND_PROVINCE";
  public final static  String S_FormworkType = "FORMWORK_TYPE";
  public final static  String S_OperateTime = "OPERATE_TIME";
  public final static  String S_Oper = "OPER";
  public final static  String S_FormworkId = "FORMWORK_ID";
  public SmsFormworkBean() throws AIException{
      super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
  }


 public static ObjectType getObjectTypeStatic() throws AIException{
   return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initIsStopped(String value){
     this.initProperty(S_IsStopped,value);
  }
  public  void setIsStopped(String value){
     this.set(S_IsStopped,value);
  }
  public  void setIsStoppedNull(){
     this.set(S_IsStopped,null);
  }

  public String getIsStopped(){
       return DataType.getAsString(this.get(S_IsStopped));
  
  }
  public String getIsStoppedInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsStopped));
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

  public void initFormworkState(String value){
     this.initProperty(S_FormworkState,value);
  }
  public  void setFormworkState(String value){
     this.set(S_FormworkState,value);
  }
  public  void setFormworkStateNull(){
     this.set(S_FormworkState,null);
  }

  public String getFormworkState(){
       return DataType.getAsString(this.get(S_FormworkState));
  
  }
  public String getFormworkStateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FormworkState));
      }

  public void initFormworkName(String value){
     this.initProperty(S_FormworkName,value);
  }
  public  void setFormworkName(String value){
     this.set(S_FormworkName,value);
  }
  public  void setFormworkNameNull(){
     this.set(S_FormworkName,null);
  }

  public String getFormworkName(){
       return DataType.getAsString(this.get(S_FormworkName));
  
  }
  public String getFormworkNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FormworkName));
      }

  public void initSendProvince(String value){
     this.initProperty(S_SendProvince,value);
  }
  public  void setSendProvince(String value){
     this.set(S_SendProvince,value);
  }
  public  void setSendProvinceNull(){
     this.set(S_SendProvince,null);
  }

  public String getSendProvince(){
       return DataType.getAsString(this.get(S_SendProvince));
  
  }
  public String getSendProvinceInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SendProvince));
      }

  public void initFormworkType(String value){
     this.initProperty(S_FormworkType,value);
  }
  public  void setFormworkType(String value){
     this.set(S_FormworkType,value);
  }
  public  void setFormworkTypeNull(){
     this.set(S_FormworkType,null);
  }

  public String getFormworkType(){
       return DataType.getAsString(this.get(S_FormworkType));
  
  }
  public String getFormworkTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FormworkType));
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

  public void initOper(String value){
     this.initProperty(S_Oper,value);
  }
  public  void setOper(String value){
     this.set(S_Oper,value);
  }
  public  void setOperNull(){
     this.set(S_Oper,null);
  }

  public String getOper(){
       return DataType.getAsString(this.get(S_Oper));
  
  }
  public String getOperInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Oper));
      }

  public void initFormworkId(String value){
     this.initProperty(S_FormworkId,value);
  }
  public  void setFormworkId(String value){
     this.set(S_FormworkId,value);
  }
  public  void setFormworkIdNull(){
     this.set(S_FormworkId,null);
  }

  public String getFormworkId(){
       return DataType.getAsString(this.get(S_FormworkId));
  
  }
  public String getFormworkIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FormworkId));
      }


 
 }

