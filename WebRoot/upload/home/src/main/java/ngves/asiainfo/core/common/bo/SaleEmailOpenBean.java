package ngves.asiainfo.core.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.common.ivalues.*;

public class SaleEmailOpenBean extends DataContainer implements DataContainerInterface,ISaleEmailOpenValue{

	private static final long serialVersionUID = -4406683848058742311L;



private static String  m_boName = "ngves.asiainfo.core.common.bo.SaleEmailOpen";



  public final static  String S_UserEmail = "USER_EMAIL";
  public final static  String S_SaleId = "SALE_ID";
  public final static  String S_OpenDate = "OPEN_DATE";
  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_OpenId = "OPEN_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public SaleEmailOpenBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initUserEmail(String value){
     this.initProperty(S_UserEmail,value);
  }
  public  void setUserEmail(String value){
     this.set(S_UserEmail,value);
  }
  public  void setUserEmailNull(){
     this.set(S_UserEmail,null);
  }

  public String getUserEmail(){
       return DataType.getAsString(this.get(S_UserEmail));
  
  }
  public String getUserEmailInitialValue(){
        return DataType.getAsString(this.getOldObj(S_UserEmail));
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

  public void initOpenDate(Timestamp value){
     this.initProperty(S_OpenDate,value);
  }
  public  void setOpenDate(Timestamp value){
     this.set(S_OpenDate,value);
  }
  public  void setOpenDateNull(){
     this.set(S_OpenDate,null);
  }

  public Timestamp getOpenDate(){
        return DataType.getAsDateTime(this.get(S_OpenDate));
  
  }
  public Timestamp getOpenDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_OpenDate));
      }

  public void initBakCol(String value){
     this.initProperty(S_BakCol,value);
  }
  public  void setBakCol(String value){
     this.set(S_BakCol,value);
  }
  public  void setBakColNull(){
     this.set(S_BakCol,null);
  }

  public String getBakCol(){
       return DataType.getAsString(this.get(S_BakCol));
  
  }
  public String getBakColInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BakCol));
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

  public void initOpenId(long value){
     this.initProperty(S_OpenId,new Long(value));
  }
  public  void setOpenId(long value){
     this.set(S_OpenId,new Long(value));
  }
  public  void setOpenIdNull(){
     this.set(S_OpenId,null);
  }

  public long getOpenId(){
        return DataType.getAsLong(this.get(S_OpenId));
  
  }
  public long getOpenIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OpenId));
      }


 
 }

