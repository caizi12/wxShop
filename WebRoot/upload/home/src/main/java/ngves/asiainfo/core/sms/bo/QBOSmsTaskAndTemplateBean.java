package ngves.asiainfo.core.sms.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.sms.ivalues.*;

public class QBOSmsTaskAndTemplateBean extends DataContainer implements DataContainerInterface,IQBOSmsTaskAndTemplateValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



private static String  m_boName = "ngves.asiainfo.core.sms.bo.QBOSmsTaskAndTemplate";



  public final static  String S_QuartzTime = "QUARTZ_TIME";
  public final static  String S_SendType = "SEND_TYPE";
  public final static  String S_SecondTime = "SECOND_TIME";
  public final static  String S_Title = "TITLE";
  public final static  String S_IsDownload = "IS_DOWNLOAD";
  public final static  String S_Status = "STATUS";
  public final static  String S_FilePath = "FILE_PATH";
  public final static  String S_NoCount = "NO_COUNT";
  public final static  String S_Content = "CONTENT";
  public final static  String S_TaskId = "TASK_ID";
  public final static  String S_Opera = "OPERA";
  public final static  String S_SmsId = "SMS_ID";
  public final static  String S_TemplateStatus = "TEMPLATE_STATUS";
  public final static  String S_ProvCode = "PROV_CODE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QBOSmsTaskAndTemplateBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initQuartzTime(Timestamp value){
     this.initProperty(S_QuartzTime,value);
  }
  public  void setQuartzTime(Timestamp value){
     this.set(S_QuartzTime,value);
  }
  public  void setQuartzTimeNull(){
     this.set(S_QuartzTime,null);
  }

  public Timestamp getQuartzTime(){
        return DataType.getAsDateTime(this.get(S_QuartzTime));
  
  }
  public Timestamp getQuartzTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_QuartzTime));
      }

  public void initSendType(String value){
     this.initProperty(S_SendType,value);
  }
  public  void setSendType(String value){
     this.set(S_SendType,value);
  }
  public  void setSendTypeNull(){
     this.set(S_SendType,null);
  }

  public String getSendType(){
       return DataType.getAsString(this.get(S_SendType));
  
  }
  public String getSendTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SendType));
      }

  public void initSecondTime(Timestamp value){
     this.initProperty(S_SecondTime,value);
  }
  public  void setSecondTime(Timestamp value){
     this.set(S_SecondTime,value);
  }
  public  void setSecondTimeNull(){
     this.set(S_SecondTime,null);
  }

  public Timestamp getSecondTime(){
        return DataType.getAsDateTime(this.get(S_SecondTime));
  
  }
  public Timestamp getSecondTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_SecondTime));
      }

  public void initTitle(String value){
     this.initProperty(S_Title,value);
  }
  public  void setTitle(String value){
     this.set(S_Title,value);
  }
  public  void setTitleNull(){
     this.set(S_Title,null);
  }

  public String getTitle(){
       return DataType.getAsString(this.get(S_Title));
  
  }
  public String getTitleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Title));
      }

  public void initIsDownload(String value){
     this.initProperty(S_IsDownload,value);
  }
  public  void setIsDownload(String value){
     this.set(S_IsDownload,value);
  }
  public  void setIsDownloadNull(){
     this.set(S_IsDownload,null);
  }

  public String getIsDownload(){
       return DataType.getAsString(this.get(S_IsDownload));
  
  }
  public String getIsDownloadInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsDownload));
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

  public void initFilePath(String value){
     this.initProperty(S_FilePath,value);
  }
  public  void setFilePath(String value){
     this.set(S_FilePath,value);
  }
  public  void setFilePathNull(){
     this.set(S_FilePath,null);
  }

  public String getFilePath(){
       return DataType.getAsString(this.get(S_FilePath));
  
  }
  public String getFilePathInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FilePath));
      }

  public void initNoCount(long value){
     this.initProperty(S_NoCount,new Long(value));
  }
  public  void setNoCount(long value){
     this.set(S_NoCount,new Long(value));
  }
  public  void setNoCountNull(){
     this.set(S_NoCount,null);
  }

  public long getNoCount(){
        return DataType.getAsLong(this.get(S_NoCount));
  
  }
  public long getNoCountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_NoCount));
      }

  public void initContent(String value){
     this.initProperty(S_Content,value);
  }
  public  void setContent(String value){
     this.set(S_Content,value);
  }
  public  void setContentNull(){
     this.set(S_Content,null);
  }

  public String getContent(){
       return DataType.getAsString(this.get(S_Content));
  
  }
  public String getContentInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Content));
      }

  public void initTaskId(long value){
     this.initProperty(S_TaskId,new Long(value));
  }
  public  void setTaskId(long value){
     this.set(S_TaskId,new Long(value));
  }
  public  void setTaskIdNull(){
     this.set(S_TaskId,null);
  }

  public long getTaskId(){
        return DataType.getAsLong(this.get(S_TaskId));
  
  }
  public long getTaskIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TaskId));
      }

  public void initOpera(String value){
     this.initProperty(S_Opera,value);
  }
  public  void setOpera(String value){
     this.set(S_Opera,value);
  }
  public  void setOperaNull(){
     this.set(S_Opera,null);
  }

  public String getOpera(){
       return DataType.getAsString(this.get(S_Opera));
  
  }
  public String getOperaInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Opera));
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

  public void initTemplateStatus(String value){
     this.initProperty(S_TemplateStatus,value);
  }
  public  void setTemplateStatus(String value){
     this.set(S_TemplateStatus,value);
  }
  public  void setTemplateStatusNull(){
     this.set(S_TemplateStatus,null);
  }

  public String getTemplateStatus(){
       return DataType.getAsString(this.get(S_TemplateStatus));
  
  }
  public String getTemplateStatusInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TemplateStatus));
      }

  public void initProvCode(String value){
     this.initProperty(S_ProvCode,value);
  }
  public  void setProvCode(String value){
     this.set(S_ProvCode,value);
  }
  public  void setProvCodeNull(){
     this.set(S_ProvCode,null);
  }

  public String getProvCode(){
       return DataType.getAsString(this.get(S_ProvCode));
  
  }
  public String getProvCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ProvCode));
      }


 
 }

