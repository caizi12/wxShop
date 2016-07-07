package ngves.asiainfo.core.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.common.ivalues.*;

public class SaleInfoBean extends DataContainer implements DataContainerInterface,ISaleInfoValue{

  private static String  m_boName = "ngves.asiainfo.core.common.bo.SaleInfo";

  private static final long serialVersionUID = 1L;

  public final static  String S_ReachSum = "REACH_SUM";
  public final static  String S_SaleType = "SALE_TYPE";
  public final static  String S_AddTime = "ADD_TIME";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_SaleName = "SALE_NAME";
  public final static  String S_SaleStatus = "SALE_STATUS";
  public final static  String S_SaleFile = "SALE_FILE";
  public final static  String S_FinishTime = "FINISH_TIME";
  public final static  String S_SaleId = "SALE_ID";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_SendStatus = "SEND_STATUS";
  public final static  String S_OpenSum = "OPEN_SUM";
  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_SendSum = "SEND_SUM";
  public final static  String S_SaleDiscript = "SALE_DISCRIPT";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public SaleInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initReachSum(long value){
     this.initProperty(S_ReachSum,new Long(value));
  }
  public  void setReachSum(long value){
     this.set(S_ReachSum,new Long(value));
  }
  public  void setReachSumNull(){
     this.set(S_ReachSum,null);
  }

  public long getReachSum(){
        return DataType.getAsLong(this.get(S_ReachSum));
  
  }
  public long getReachSumInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ReachSum));
      }

  public void initSaleType(String value){
     this.initProperty(S_SaleType,value);
  }
  public  void setSaleType(String value){
     this.set(S_SaleType,value);
  }
  public  void setSaleTypeNull(){
     this.set(S_SaleType,null);
  }

  public String getSaleType(){
       return DataType.getAsString(this.get(S_SaleType));
  
  }
  public String getSaleTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleType));
      }

  public void initAddTime(Timestamp value){
     this.initProperty(S_AddTime,value);
  }
  public  void setAddTime(Timestamp value){
     this.set(S_AddTime,value);
  }
  public  void setAddTimeNull(){
     this.set(S_AddTime,null);
  }

  public Timestamp getAddTime(){
        return DataType.getAsDateTime(this.get(S_AddTime));
  
  }
  public Timestamp getAddTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_AddTime));
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

  public void initSaleName(String value){
     this.initProperty(S_SaleName,value);
  }
  public  void setSaleName(String value){
     this.set(S_SaleName,value);
  }
  public  void setSaleNameNull(){
     this.set(S_SaleName,null);
  }

  public String getSaleName(){
       return DataType.getAsString(this.get(S_SaleName));
  
  }
  public String getSaleNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleName));
      }

  public void initSaleStatus(String value){
     this.initProperty(S_SaleStatus,value);
  }
  public  void setSaleStatus(String value){
     this.set(S_SaleStatus,value);
  }
  public  void setSaleStatusNull(){
     this.set(S_SaleStatus,null);
  }

  public String getSaleStatus(){
       return DataType.getAsString(this.get(S_SaleStatus));
  
  }
  public String getSaleStatusInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleStatus));
      }

  public void initSaleFile(String value){
     this.initProperty(S_SaleFile,value);
  }
  public  void setSaleFile(String value){
     this.set(S_SaleFile,value);
  }
  public  void setSaleFileNull(){
     this.set(S_SaleFile,null);
  }

  public String getSaleFile(){
       return DataType.getAsString(this.get(S_SaleFile));
  
  }
  public String getSaleFileInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleFile));
      }

  public void initFinishTime(Timestamp value){
     this.initProperty(S_FinishTime,value);
  }
  public  void setFinishTime(Timestamp value){
     this.set(S_FinishTime,value);
  }
  public  void setFinishTimeNull(){
     this.set(S_FinishTime,null);
  }

  public Timestamp getFinishTime(){
        return DataType.getAsDateTime(this.get(S_FinishTime));
  
  }
  public Timestamp getFinishTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_FinishTime));
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

  public void initSendStatus(String value){
     this.initProperty(S_SendStatus,value);
  }
  public  void setSendStatus(String value){
     this.set(S_SendStatus,value);
  }
  public  void setSendStatusNull(){
     this.set(S_SendStatus,null);
  }

  public String getSendStatus(){
       return DataType.getAsString(this.get(S_SendStatus));
  
  }
  public String getSendStatusInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SendStatus));
      }

  public void initOpenSum(long value){
     this.initProperty(S_OpenSum,new Long(value));
  }
  public  void setOpenSum(long value){
     this.set(S_OpenSum,new Long(value));
  }
  public  void setOpenSumNull(){
     this.set(S_OpenSum,null);
  }

  public long getOpenSum(){
        return DataType.getAsLong(this.get(S_OpenSum));
  
  }
  public long getOpenSumInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OpenSum));
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

  public void initSendSum(long value){
     this.initProperty(S_SendSum,new Long(value));
  }
  public  void setSendSum(long value){
     this.set(S_SendSum,new Long(value));
  }
  public  void setSendSumNull(){
     this.set(S_SendSum,null);
  }

  public long getSendSum(){
        return DataType.getAsLong(this.get(S_SendSum));
  
  }
  public long getSendSumInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SendSum));
      }

  public void initSaleDiscript(String value){
     this.initProperty(S_SaleDiscript,value);
  }
  public  void setSaleDiscript(String value){
     this.set(S_SaleDiscript,value);
  }
  public  void setSaleDiscriptNull(){
     this.set(S_SaleDiscript,null);
  }

  public String getSaleDiscript(){
       return DataType.getAsString(this.get(S_SaleDiscript));
  
  }
  public String getSaleDiscriptInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleDiscript));
      }


 
 }

