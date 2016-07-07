package ngves.asiainfo.core.floor.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.floor.ivalues.*;

public class O2OWareRltBean extends DataContainer implements DataContainerInterface,IO2OWareRltValue{

	/**
	 * 序列化
	 */
  private static final long serialVersionUID = 1L;
  private static String  m_boName = "ngves.asiainfo.core.floor.bo.O2OWareRlt";



  public final static  String S_O2oId = "O2O_ID";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_WareCode = "WARE_CODE";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_O2oRltId = "O2O_RLT_ID";
  public final static  String S_CreateDate = "CREATE_DATE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public O2OWareRltBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("");
 }


  public void initO2oId(long value){
     this.initProperty(S_O2oId,new Long(value));
  }
  public  void setO2oId(long value){
     this.set(S_O2oId,new Long(value));
  }
  public  void setO2oIdNull(){
     this.set(S_O2oId,null);
  }

  public long getO2oId(){
        return DataType.getAsLong(this.get(S_O2oId));
  
  }
  public long getO2oIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_O2oId));
      }

  public void initModifyDate(Timestamp value){
     this.initProperty(S_ModifyDate,value);
  }
  public  void setModifyDate(Timestamp value){
     this.set(S_ModifyDate,value);
  }
  public  void setModifyDateNull(){
     this.set(S_ModifyDate,null);
  }

  public Timestamp getModifyDate(){
        return DataType.getAsDateTime(this.get(S_ModifyDate));
  
  }
  public Timestamp getModifyDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ModifyDate));
      }

  public void initWareCode(String value){
     this.initProperty(S_WareCode,value);
  }
  public  void setWareCode(String value){
     this.set(S_WareCode,value);
  }
  public  void setWareCodeNull(){
     this.set(S_WareCode,null);
  }

  public String getWareCode(){
       return DataType.getAsString(this.get(S_WareCode));
  
  }
  public String getWareCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WareCode));
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

  public void initO2oRltId(long value){
     this.initProperty(S_O2oRltId,new Long(value));
  }
  public  void setO2oRltId(long value){
     this.set(S_O2oRltId,new Long(value));
  }
  public  void setO2oRltIdNull(){
     this.set(S_O2oRltId,null);
  }

  public long getO2oRltId(){
        return DataType.getAsLong(this.get(S_O2oRltId));
  
  }
  public long getO2oRltIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_O2oRltId));
      }

  public void initCreateDate(Timestamp value){
     this.initProperty(S_CreateDate,value);
  }
  public  void setCreateDate(Timestamp value){
     this.set(S_CreateDate,value);
  }
  public  void setCreateDateNull(){
     this.set(S_CreateDate,null);
  }

  public Timestamp getCreateDate(){
        return DataType.getAsDateTime(this.get(S_CreateDate));
  
  }
  public Timestamp getCreateDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CreateDate));
      }
  

 
 }

