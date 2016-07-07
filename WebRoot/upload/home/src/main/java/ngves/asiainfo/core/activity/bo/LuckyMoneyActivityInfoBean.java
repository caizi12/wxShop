package ngves.asiainfo.core.activity.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.activity.ivalues.*;
@SuppressWarnings("serial")
public class LuckyMoneyActivityInfoBean extends DataContainer implements DataContainerInterface,ILuckyMoneyActivityInfoValue{

  private static String  m_boName = "ngves.asiainfo.core.activity.bo.LuckyMoneyActivityInfo";



  public final static  String S_LuckyType = "LUCKY_TYPE";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_Mobile = "MOBILE";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_LuckyId = "LUCKY_ID";
  public final static  String S_LuckyScore = "LUCKY_SCORE";
  public LuckyMoneyActivityInfoBean() throws AIException{
      super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
  }


 public static ObjectType getObjectTypeStatic() throws AIException{
   return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("");
 }


  public void initLuckyType(String value){
     this.initProperty(S_LuckyType,value);
  }
  public  void setLuckyType(String value){
     this.set(S_LuckyType,value);
  }
  public  void setLuckyTypeNull(){
     this.set(S_LuckyType,null);
  }

  public String getLuckyType(){
       return DataType.getAsString(this.get(S_LuckyType));
  
  }
  public String getLuckyTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_LuckyType));
      }

  public void initOrderId(String value){
     this.initProperty(S_OrderId,value);
  }
  public  void setOrderId(String value){
     this.set(S_OrderId,value);
  }
  public  void setOrderIdNull(){
     this.set(S_OrderId,null);
  }

  public String getOrderId(){
       return DataType.getAsString(this.get(S_OrderId));
  
  }
  public String getOrderIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrderId));
      }

  public void initMobile(String value){
     this.initProperty(S_Mobile,value);
  }
  public  void setMobile(String value){
     this.set(S_Mobile,value);
  }
  public  void setMobileNull(){
     this.set(S_Mobile,null);
  }

  public String getMobile(){
       return DataType.getAsString(this.get(S_Mobile));
  
  }
  public String getMobileInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Mobile));
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

  public void initLuckyId(long value){
     this.initProperty(S_LuckyId,new Long(value));
  }
  public  void setLuckyId(long value){
     this.set(S_LuckyId,new Long(value));
  }
  public  void setLuckyIdNull(){
     this.set(S_LuckyId,null);
  }

  public long getLuckyId(){
        return DataType.getAsLong(this.get(S_LuckyId));
  
  }
  public long getLuckyIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_LuckyId));
      }

  public void initLuckyScore(long value){
     this.initProperty(S_LuckyScore,new Long(value));
  }
  public  void setLuckyScore(long value){
     this.set(S_LuckyScore,new Long(value));
  }
  public  void setLuckyScoreNull(){
     this.set(S_LuckyScore,null);
  }

  public long getLuckyScore(){
        return DataType.getAsLong(this.get(S_LuckyScore));
  
  }
  public long getLuckyScoreInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_LuckyScore));
      }


 
 }

