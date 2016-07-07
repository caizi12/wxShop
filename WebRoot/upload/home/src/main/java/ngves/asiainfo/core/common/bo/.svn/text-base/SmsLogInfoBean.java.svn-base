package ngves.asiainfo.core.common.bo;

import java.sql.Timestamp;

import ngves.asiainfo.core.common.ivalues.ISmsLogInfoValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class SmsLogInfoBean extends DataContainer implements DataContainerInterface,ISmsLogInfoValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = -7237648990217273731L;



private static String  m_boName = "ngves.asiainfo.core.common.bo.SmsLogInfo";



  public final static  String S_SmsLogId = "SMS_LOG_ID";
  public final static  String S_SmsTime = "SMS_TIME";
  public final static  String S_SmsContent = "SMS_CONTENT";
  public final static  String S_MobilePhoneNo = "MOBILE_PHONE_NO";
  public SmsLogInfoBean() throws AIException{
      super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
  }


 public static ObjectType getObjectTypeStatic() throws AIException{
   return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initSmsLogId(long value){
     this.initProperty(S_SmsLogId,new Long(value));
  }
  public  void setSmsLogId(long value){
     this.set(S_SmsLogId,new Long(value));
  }
  public  void setSmsLogIdNull(){
     this.set(S_SmsLogId,null);
  }

  public long getSmsLogId(){
        return DataType.getAsLong(this.get(S_SmsLogId));
  
  }
  public long getSmsLogIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SmsLogId));
      }

  public void initSmsTime(Timestamp value){
     this.initProperty(S_SmsTime,value);
  }
  public  void setSmsTime(Timestamp value){
     this.set(S_SmsTime,value);
  }
  public  void setSmsTimeNull(){
     this.set(S_SmsTime,null);
  }

  public Timestamp getSmsTime(){
        return DataType.getAsDateTime(this.get(S_SmsTime));
  
  }
  public Timestamp getSmsTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_SmsTime));
      }

  public void initSmsContent(String value){
     this.initProperty(S_SmsContent,value);
  }
  public  void setSmsContent(String value){
     this.set(S_SmsContent,value);
  }
  public  void setSmsContentNull(){
     this.set(S_SmsContent,null);
  }

  public String getSmsContent(){
       return DataType.getAsString(this.get(S_SmsContent));
  
  }
  public String getSmsContentInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SmsContent));
      }

  public void initMobilePhoneNo(String value){
     this.initProperty(S_MobilePhoneNo,value);
  }
  public  void setMobilePhoneNo(String value){
     this.set(S_MobilePhoneNo,value);
  }
  public  void setMobilePhoneNoNull(){
     this.set(S_MobilePhoneNo,null);
  }

  public String getMobilePhoneNo(){
       return DataType.getAsString(this.get(S_MobilePhoneNo));
  
  }
  public String getMobilePhoneNoInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MobilePhoneNo));
      }


 
 }

