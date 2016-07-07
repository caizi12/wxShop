package ngves.asiainfo.core.sms.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.sms.ivalues.*;

public class BusiSmsAuditBean extends DataContainer implements DataContainerInterface,IBusiSmsAuditValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 7125125441081465354L;



private static String  m_boName = "ngves.asiainfo.core.sms.bo.BusiSmsAudit";



  public final static  String S_OptId = "OPT_ID";
  public final static  String S_BusiSmsId = "BUSI_SMS_ID";
  public final static  String S_AuditContent = "AUDIT_CONTENT";
  public final static  String S_Status = "STATUS";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_SmsId = "SMS_ID";
  public final static  String S_AuditTime = "AUDIT_TIME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BusiSmsAuditBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initOptId(String value){
     this.initProperty(S_OptId,value);
  }
  public  void setOptId(String value){
     this.set(S_OptId,value);
  }
  public  void setOptIdNull(){
     this.set(S_OptId,null);
  }

  public String getOptId(){
       return DataType.getAsString(this.get(S_OptId));
  
  }
  public String getOptIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OptId));
      }

  public void initBusiSmsId(long value){
     this.initProperty(S_BusiSmsId,new Long(value));
  }
  public  void setBusiSmsId(long value){
     this.set(S_BusiSmsId,new Long(value));
  }
  public  void setBusiSmsIdNull(){
     this.set(S_BusiSmsId,null);
  }

  public long getBusiSmsId(){
        return DataType.getAsLong(this.get(S_BusiSmsId));
  
  }
  public long getBusiSmsIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BusiSmsId));
      }

  public void initAuditContent(String value){
     this.initProperty(S_AuditContent,value);
  }
  public  void setAuditContent(String value){
     this.set(S_AuditContent,value);
  }
  public  void setAuditContentNull(){
     this.set(S_AuditContent,null);
  }

  public String getAuditContent(){
       return DataType.getAsString(this.get(S_AuditContent));
  
  }
  public String getAuditContentInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AuditContent));
      }

  public void initStatus(String value){
     this.initProperty(S_Status,value);
  }
  public  void setStatus(String value){
     this.set(S_Status,value);
  }
  public  void setStatusNull(){
     this.set(S_Status,null);
  }

  public String getStatus(){
       return DataType.getAsString(this.get(S_Status));
  
  }
  public String getStatusInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Status));
      }

  public void initBakCol2(String value){
     this.initProperty(S_BakCol2,value);
  }
  public  void setBakCol2(String value){
     this.set(S_BakCol2,value);
  }
  public  void setBakCol2Null(){
     this.set(S_BakCol2,null);
  }

  public String getBakCol2(){
       return DataType.getAsString(this.get(S_BakCol2));
  
  }
  public String getBakCol2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_BakCol2));
      }

  public void initBakCol3(String value){
     this.initProperty(S_BakCol3,value);
  }
  public  void setBakCol3(String value){
     this.set(S_BakCol3,value);
  }
  public  void setBakCol3Null(){
     this.set(S_BakCol3,null);
  }

  public String getBakCol3(){
       return DataType.getAsString(this.get(S_BakCol3));
  
  }
  public String getBakCol3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_BakCol3));
      }

  public void initBakCol1(String value){
     this.initProperty(S_BakCol1,value);
  }
  public  void setBakCol1(String value){
     this.set(S_BakCol1,value);
  }
  public  void setBakCol1Null(){
     this.set(S_BakCol1,null);
  }

  public String getBakCol1(){
       return DataType.getAsString(this.get(S_BakCol1));
  
  }
  public String getBakCol1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_BakCol1));
      }

  public void initSmsId(long value){
     this.initProperty(S_SmsId,new Long(value));
  }
  public  void setSmsId(long value){
     this.set(S_SmsId,new Long(value));
  }
  public  void setSmsIdNull(){
     this.set(S_SmsId,null);
  }

  public long getSmsId(){
        return DataType.getAsLong(this.get(S_SmsId));
  
  }
  public long getSmsIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SmsId));
      }

  public void initAuditTime(Timestamp value){
     this.initProperty(S_AuditTime,value);
  }
  public  void setAuditTime(Timestamp value){
     this.set(S_AuditTime,value);
  }
  public  void setAuditTimeNull(){
     this.set(S_AuditTime,null);
  }

  public Timestamp getAuditTime(){
        return DataType.getAsDateTime(this.get(S_AuditTime));
  
  }
  public Timestamp getAuditTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_AuditTime));
      }


 
 }

