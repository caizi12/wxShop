package ngves.asiainfo.core.sms.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.sms.ivalues.*;

public class SmsTemplateBean extends DataContainer implements DataContainerInterface,ISmsTemplateValue{


	private static final long serialVersionUID = 1L;



private static String  m_boName = "ngves.asiainfo.core.sms.bo.SmsTemplate";



  public final static  String S_SubmitTime = "SUBMIT_TIME";
  public final static  String S_Brand = "BRAND";
  public final static  String S_SendType = "SEND_TYPE";
  public final static  String S_QuartzTime = "QUARTZ_TIME";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_Operat = "OPERAT";
  public final static  String S_OptId = "OPT_ID";
  public final static  String S_SecondTime = "SECOND_TIME";
  public final static  String S_ScoreDown = "SCORE_DOWN";
  public final static  String S_Title = "TITLE";
  public final static  String S_Status = "STATUS";
  public final static  String S_FilePath = "FILE_PATH";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_NoCount = "NO_COUNT";
  public final static  String S_ScoreUp = "SCORE_UP";
  public final static  String S_Content = "CONTENT";
  public final static  String S_FirstTime = "FIRST_TIME";
  public final static  String S_SmsId = "SMS_ID";
  public final static  String S_ProvCode = "PROV_CODE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public SmsTemplateBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initSubmitTime(Timestamp value){
     this.initProperty(S_SubmitTime,value);
  }
  public  void setSubmitTime(Timestamp value){
     this.set(S_SubmitTime,value);
  }
  public  void setSubmitTimeNull(){
     this.set(S_SubmitTime,null);
  }

  public Timestamp getSubmitTime(){
        return DataType.getAsDateTime(this.get(S_SubmitTime));
  
  }
  public Timestamp getSubmitTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_SubmitTime));
      }

  public void initBrand(String value){
     this.initProperty(S_Brand,value);
  }
  public  void setBrand(String value){
     this.set(S_Brand,value);
  }
  public  void setBrandNull(){
     this.set(S_Brand,null);
  }

  public String getBrand(){
       return DataType.getAsString(this.get(S_Brand));
  
  }
  public String getBrandInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Brand));
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

  public void initOperat(String value){
     this.initProperty(S_Operat,value);
  }
  public  void setOperat(String value){
     this.set(S_Operat,value);
  }
  public  void setOperatNull(){
     this.set(S_Operat,null);
  }

  public String getOperat(){
       return DataType.getAsString(this.get(S_Operat));
  
  }
  public String getOperatInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Operat));
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

  public void initScoreDown(long value){
     this.initProperty(S_ScoreDown,new Long(value));
  }
  public  void setScoreDown(long value){
     this.set(S_ScoreDown,new Long(value));
  }
  public  void setScoreDownNull(){
     this.set(S_ScoreDown,null);
  }

  public long getScoreDown(){
        return DataType.getAsLong(this.get(S_ScoreDown));
  
  }
  public long getScoreDownInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ScoreDown));
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

  public void initScoreUp(long value){
     this.initProperty(S_ScoreUp,new Long(value));
  }
  public  void setScoreUp(long value){
     this.set(S_ScoreUp,new Long(value));
  }
  public  void setScoreUpNull(){
     this.set(S_ScoreUp,null);
  }

  public long getScoreUp(){
        return DataType.getAsLong(this.get(S_ScoreUp));
  
  }
  public long getScoreUpInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ScoreUp));
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

  public void initFirstTime(Timestamp value){
     this.initProperty(S_FirstTime,value);
  }
  public  void setFirstTime(Timestamp value){
     this.set(S_FirstTime,value);
  }
  public  void setFirstTimeNull(){
     this.set(S_FirstTime,null);
  }

  public Timestamp getFirstTime(){
        return DataType.getAsDateTime(this.get(S_FirstTime));
  
  }
  public Timestamp getFirstTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_FirstTime));
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

