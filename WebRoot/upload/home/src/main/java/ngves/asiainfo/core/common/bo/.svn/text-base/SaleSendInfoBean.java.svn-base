package ngves.asiainfo.core.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.common.ivalues.*;

public class SaleSendInfoBean extends DataContainer implements DataContainerInterface,ISaleSendInfoValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = -7027618789300410611L;



private static String  m_boName = "ngves.asiainfo.core.common.bo.SaleSendInfo";



  public final static  String S_SendId = "SEND_ID";
  public final static  String S_SaleId = "SALE_ID";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_SendType = "SEND_TYPE";
  public final static  String S_FailReason = "FAIL_REASON";
  public final static  String S_SendObj = "SEND_OBJ";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_IsSend = "IS_SEND";
  public final static  String S_RltId = "RLT_ID";
  public final static  String S_SendTime = "SEND_TIME";
  public final static  String S_OptTime = "OPT_TIME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public SaleSendInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initSendId(long value){
     this.initProperty(S_SendId,new Long(value));
  }
  public  void setSendId(long value){
     this.set(S_SendId,new Long(value));
  }
  public  void setSendIdNull(){
     this.set(S_SendId,null);
  }

  public long getSendId(){
        return DataType.getAsLong(this.get(S_SendId));
  
  }
  public long getSendIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SendId));
      }

  public void initSaleId(long value){
     this.initProperty(S_SaleId,new Long(value));
  }
  public  void setSaleId(long value){
     this.set(S_SaleId,new Long(value));
  }
  public  void setSaleIdNull(){
     this.set(S_SaleId,null);
  }

  public long getSaleId(){
        return DataType.getAsLong(this.get(S_SaleId));
  
  }
  public long getSaleIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SaleId));
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

  public void initFailReason(String value){
     this.initProperty(S_FailReason,value);
  }
  public  void setFailReason(String value){
     this.set(S_FailReason,value);
  }
  public  void setFailReasonNull(){
     this.set(S_FailReason,null);
  }

  public String getFailReason(){
       return DataType.getAsString(this.get(S_FailReason));
  
  }
  public String getFailReasonInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FailReason));
      }

  public void initSendObj(String value){
     this.initProperty(S_SendObj,value);
  }
  public  void setSendObj(String value){
     this.set(S_SendObj,value);
  }
  public  void setSendObjNull(){
     this.set(S_SendObj,null);
  }

  public String getSendObj(){
       return DataType.getAsString(this.get(S_SendObj));
  
  }
  public String getSendObjInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SendObj));
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

  public void initBakCol1(long value){
     this.initProperty(S_BakCol1,new Long(value));
  }
  public  void setBakCol1(long value){
     this.set(S_BakCol1,new Long(value));
  }
  public  void setBakCol1Null(){
     this.set(S_BakCol1,null);
  }

  public long getBakCol1(){
        return DataType.getAsLong(this.get(S_BakCol1));
  
  }
  public long getBakCol1InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BakCol1));
      }

  public void initIsSend(String value){
     this.initProperty(S_IsSend,value);
  }
  public  void setIsSend(String value){
     this.set(S_IsSend,value);
  }
  public  void setIsSendNull(){
     this.set(S_IsSend,null);
  }

  public String getIsSend(){
       return DataType.getAsString(this.get(S_IsSend));
  
  }
  public String getIsSendInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsSend));
      }

  public void initRltId(String value){
     this.initProperty(S_RltId,value);
  }
  public  void setRltId(String value){
     this.set(S_RltId,value);
  }
  public  void setRltIdNull(){
     this.set(S_RltId,null);
  }

  public String getRltId(){
       return DataType.getAsString(this.get(S_RltId));
  
  }
  public String getRltIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RltId));
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

  public void initOptTime(Timestamp value){
     this.initProperty(S_OptTime,value);
  }
  public  void setOptTime(Timestamp value){
     this.set(S_OptTime,value);
  }
  public  void setOptTimeNull(){
     this.set(S_OptTime,null);
  }

  public Timestamp getOptTime(){
        return DataType.getAsDateTime(this.get(S_OptTime));
  
  }
  public Timestamp getOptTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_OptTime));
      }


 
 }

