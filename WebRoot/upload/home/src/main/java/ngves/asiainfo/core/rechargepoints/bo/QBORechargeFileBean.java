package ngves.asiainfo.core.rechargepoints.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.rechargepoints.ivalues.*;

@SuppressWarnings("serial")
public class QBORechargeFileBean extends DataContainer implements DataContainerInterface,IQBORechargeFileValue{

  private static String  m_boName = "ngves.asiainfo.core.rechargepoints.bo.QBORechargeFile";



  public final static  String S_RechargeFileName = "RECHARGE_FILE_NAME";
  public final static  String S_RechargeFileNickname = "RECHARGE_FILE_NICKNAME";
  public final static  String S_TaskName = "TASK_NAME";
  public final static  String S_RechargeTaskId = "RECHARGE_TASK_ID";
  public final static  String S_SmsMessage = "SMS_MESSAGE";
  public final static  String S_IsSendSms = "IS_SEND_SMS";
  public final static String S_IsDeleted = "IS_DELETED";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QBORechargeFileBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initRechargeFileName(String value){
     this.initProperty(S_RechargeFileName,value);
  }
  public  void setRechargeFileName(String value){
     this.set(S_RechargeFileName,value);
  }
  public  void setRechargeFileNameNull(){
     this.set(S_RechargeFileName,null);
  }

  public String getRechargeFileName(){
       return DataType.getAsString(this.get(S_RechargeFileName));
  
  }
  public String getRechargeFileNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RechargeFileName));
      }

  public void initRechargeFileNickname(String value){
     this.initProperty(S_RechargeFileNickname,value);
  }
  public  void setRechargeFileNickname(String value){
     this.set(S_RechargeFileNickname,value);
  }
  public  void setRechargeFileNicknameNull(){
     this.set(S_RechargeFileNickname,null);
  }

  public String getRechargeFileNickname(){
       return DataType.getAsString(this.get(S_RechargeFileNickname));
  
  }
  public String getRechargeFileNicknameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RechargeFileNickname));
      }

  public void initTaskName(String value){
     this.initProperty(S_TaskName,value);
  }
  public  void setTaskName(String value){
     this.set(S_TaskName,value);
  }
  public  void setTaskNameNull(){
     this.set(S_TaskName,null);
  }

  public String getTaskName(){
       return DataType.getAsString(this.get(S_TaskName));
  
  }
  public String getTaskNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TaskName));
      }

  public void initRechargeTaskId(long value){
     this.initProperty(S_RechargeTaskId,new Long(value));
  }
  public  void setRechargeTaskId(long value){
     this.set(S_RechargeTaskId,new Long(value));
  }
  public  void setRechargeTaskIdNull(){
     this.set(S_RechargeTaskId,null);
  }

  public long getRechargeTaskId(){
        return DataType.getAsLong(this.get(S_RechargeTaskId));
  
  }
  public long getRechargeTaskIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RechargeTaskId));
      }

  public void initSmsMessage(String value){
     this.initProperty(S_SmsMessage,value);
  }
  public  void setSmsMessage(String value){
     this.set(S_SmsMessage,value);
  }
  public  void setSmsMessageNull(){
     this.set(S_SmsMessage,null);
  }

  public String getSmsMessage(){
       return DataType.getAsString(this.get(S_SmsMessage));
  
  }
  public String getSmsMessageInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SmsMessage));
      }

  public void initIsSendSms(String value){
     this.initProperty(S_IsSendSms,value);
  }
  public  void setIsSendSms(String value){
     this.set(S_IsSendSms,value);
  }
  public  void setIsSendSmsNull(){
     this.set(S_IsSendSms,null);
  }

  public String getIsSendSms(){
       return DataType.getAsString(this.get(S_IsSendSms));
  
  }
  public String getIsSendSmsInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsSendSms));
      }
  public void initIsDeleted(String value) {
		this.initProperty(S_IsDeleted, value);
	}

	public void setIsDeleted(String value) {
		this.set(S_IsDeleted, value);
	}

	public void setIsDeletedNull() {
		this.set(S_IsDeleted, null);
	}

	public String getIsDeleted() {
		return DataType.getAsString(this.get(S_IsDeleted));

	}

	public String getIsDeletedInitialValue() {
		return DataType.getAsString(this.getOldObj(S_IsDeleted));
	}

 
 }

