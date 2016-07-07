package ngves.asiainfo.core.mail.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.mail.ivalue.ISendMailTaskValue;

public class SendMailTaskBean extends DataContainer implements DataContainerInterface,ISendMailTaskValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



private static String  m_boName = "ngves.asiainfo.core.mail.bo.SendMailTask";



  public final static  String S_Bak1 = "BAK1";
  public final static  String S_SendStutas = "SEND_STUTAS";
  public final static  String S_StaffId = "STAFF_ID";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_SendTime = "SEND_TIME";
  public final static  String S_SendTitle = "SEND_TITLE";
  public final static  String S_sendType = "SEND_TYPE";
  public final static  String S_SendMailTaskId = "SEND_MAIL_TASK_ID";
  public final static  String S_SendContant = "SEND_CONTANT";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public SendMailTaskBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initBak1(String value){
     this.initProperty(S_Bak1,value);
  }
  public  void setBak1(String value){
     this.set(S_Bak1,value);
  }
  public  void setBak1Null(){
     this.set(S_Bak1,null);
  }

  public String getBak1(){
       return DataType.getAsString(this.get(S_Bak1));
  
  }
  public String getBak1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Bak1));
      }

  public void initSendStutas(String value){
     this.initProperty(S_SendStutas,value);
  }
  public  void setSendStutas(String value){
     this.set(S_SendStutas,value);
  }
  public  void setSendStutasNull(){
     this.set(S_SendStutas,null);
  }

  public String getSendStutas(){
       return DataType.getAsString(this.get(S_SendStutas));
  
  }
  public String getSendStutasInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SendStutas));
      }

  public void initStaffId(long value){
     this.initProperty(S_StaffId,new Long(value));
  }
  public  void setStaffId(long value){
     this.set(S_StaffId,new Long(value));
  }
  public  void setStaffIdNull(){
     this.set(S_StaffId,null);
  }

  public long getStaffId(){
        return DataType.getAsLong(this.get(S_StaffId));
  
  }
  public long getStaffIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_StaffId));
      }

  public void initCreateTime(Timestamp value){
     this.initProperty(S_CreateTime,value);
  }
  public  void setCreateTime(Timestamp value){
     this.set(S_CreateTime,value);
  }
  public  void setCreateTimeNull(){
     this.set(S_CreateTime,null);
  }

  public Timestamp getCreateTime(){
        return DataType.getAsDateTime(this.get(S_CreateTime));
  
  }
  public Timestamp getCreateTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CreateTime));
      }

  public void initSendTime(Timestamp value){
     this.initProperty(S_SendTime,value);
  }
  public  void setSendTime(Timestamp value){
     this.set(S_SendTime,value);
  }
  public  void setSendTimeNull(){
     this.set(S_SendTime,null);
  }

  public Timestamp getSendTime(){
        return DataType.getAsDateTime(this.get(S_SendTime));
  
  }
  public Timestamp getSendTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_SendTime));
      }

  public void initSendTitle(String value){
     this.initProperty(S_SendTitle,value);
  }
  public  void setSendTitle(String value){
     this.set(S_SendTitle,value);
  }
  public  void setSendTitleNull(){
     this.set(S_SendTitle,null);
  }

  public String getSendTitle(){
       return DataType.getAsString(this.get(S_SendTitle));
  
  }
  public String getSendTitleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SendTitle));
      }

  public void initSendType(String value){
     this.initProperty(S_sendType,value);
  }
  public  void setSendType(String value){
     this.set(S_sendType,value);
  }
  public  void setSendTypeNull(){
     this.set(S_sendType,null);
  }

  public String getSendType(){
       return DataType.getAsString(this.get(S_sendType));
  
  }
  public String getSendTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_sendType));
      }

  public void initSendMailTaskId(long value){
     this.initProperty(S_SendMailTaskId,new Long(value));
  }
  public  void setSendMailTaskId(long value){
     this.set(S_SendMailTaskId,new Long(value));
  }
  public  void setSendMailTaskIdNull(){
     this.set(S_SendMailTaskId,null);
  }

  public long getSendMailTaskId(){
        return DataType.getAsLong(this.get(S_SendMailTaskId));
  
  }
  public long getSendMailTaskIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SendMailTaskId));
      }

  public void initSendContant(String value){
     this.initProperty(S_SendContant,value);
  }
  public  void setSendContant(String value){
     this.set(S_SendContant,value);
  }
  public  void setSendContantNull(){
     this.set(S_SendContant,null);
  }

  public String getSendContant(){
       return DataType.getAsString(this.get(S_SendContant));
  
  }
  public String getSendContantInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SendContant));
      }
 
 }

