package ngves.asiainfo.core.sms.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.sms.ivalues.*;

public class BusiSmsTemplateBean extends DataContainer implements DataContainerInterface,IBusiSmsTemplateValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



private static String  m_boName = "ngves.asiainfo.core.sms.bo.BusiSmsTemplate";



  public final static  String S_Brand = "BRAND";
  public final static  String S_IsFileupdate = "IS_FILEUPDATE";
  public final static  String S_QuartzTime = "QUARTZ_TIME";
  public final static  String S_SendType = "SEND_TYPE";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_OptId = "OPT_ID";
  public final static  String S_ScoreDown = "SCORE_DOWN";
  public final static  String S_Title = "TITLE";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_Content = "CONTENT";
  public final static  String S_ScoreUp = "SCORE_UP";
  public final static  String S_BusiSmsTemplateId = "BUSI_SMS_TEMPLATE_ID";
  public final static  String S_SmsId = "SMS_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BusiSmsTemplateBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
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

  public void initIsFileupdate(String value){
     this.initProperty(S_IsFileupdate,value);
  }
  public  void setIsFileupdate(String value){
     this.set(S_IsFileupdate,value);
  }
  public  void setIsFileupdateNull(){
     this.set(S_IsFileupdate,null);
  }

  public String getIsFileupdate(){
       return DataType.getAsString(this.get(S_IsFileupdate));
  
  }
  public String getIsFileupdateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsFileupdate));
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

  public void initBusiSmsTemplateId(long value){
     this.initProperty(S_BusiSmsTemplateId,new Long(value));
  }
  public  void setBusiSmsTemplateId(long value){
     this.set(S_BusiSmsTemplateId,new Long(value));
  }
  public  void setBusiSmsTemplateIdNull(){
     this.set(S_BusiSmsTemplateId,null);
  }

  public long getBusiSmsTemplateId(){
        return DataType.getAsLong(this.get(S_BusiSmsTemplateId));
  
  }
  public long getBusiSmsTemplateIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BusiSmsTemplateId));
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


 
 }

