package ngves.asiainfo.core.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.common.ivalues.*;

@SuppressWarnings("serial")
public class BusiAllegeHastenAcceptBean extends DataContainer implements DataContainerInterface,IBusiAllegeHastenAcceptValue{

  private static String  m_boName = "ngves.asiainfo.core.common.bo.BusiAllegeHastenAccept";



  public final static  String S_Handlingstaff = "HANDLINGSTAFF";
  public final static  String S_BusiId = "BUSI_ID";
  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_Handlingcomment = "HANDLINGCOMMENT";
  public final static  String S_AppVersion = "APP_VERSION";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Indictseq = "INDICTSEQ";
  public final static  String S_Handlingdept = "HANDLINGDEPT";
  public final static  String S_Phonenum = "PHONENUM";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BusiAllegeHastenAcceptBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此类对象不能装入容器");
 }


  public void initHandlingstaff(String value){
     this.initProperty(S_Handlingstaff,value);
  }
  public  void setHandlingstaff(String value){
     this.set(S_Handlingstaff,value);
  }
  public  void setHandlingstaffNull(){
     this.set(S_Handlingstaff,null);
  }

  public String getHandlingstaff(){
       return DataType.getAsString(this.get(S_Handlingstaff));
  
  }
  public String getHandlingstaffInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Handlingstaff));
      }

  public void initBusiId(long value){
     this.initProperty(S_BusiId,new Long(value));
  }
  public  void setBusiId(long value){
     this.set(S_BusiId,new Long(value));
  }
  public  void setBusiIdNull(){
     this.set(S_BusiId,null);
  }

  public long getBusiId(){
        return DataType.getAsLong(this.get(S_BusiId));
  
  }
  public long getBusiIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BusiId));
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

  public void initHandlingcomment(String value){
     this.initProperty(S_Handlingcomment,value);
  }
  public  void setHandlingcomment(String value){
     this.set(S_Handlingcomment,value);
  }
  public  void setHandlingcommentNull(){
     this.set(S_Handlingcomment,null);
  }

  public String getHandlingcomment(){
       return DataType.getAsString(this.get(S_Handlingcomment));
  
  }
  public String getHandlingcommentInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Handlingcomment));
      }

  public void initAppVersion(long value){
     this.initProperty(S_AppVersion,new Long(value));
  }
  public  void setAppVersion(long value){
     this.set(S_AppVersion,new Long(value));
  }
  public  void setAppVersionNull(){
     this.set(S_AppVersion,null);
  }

  public long getAppVersion(){
        return DataType.getAsLong(this.get(S_AppVersion));
  
  }
  public long getAppVersionInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AppVersion));
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

  public void initIndictseq(String value){
     this.initProperty(S_Indictseq,value);
  }
  public  void setIndictseq(String value){
     this.set(S_Indictseq,value);
  }
  public  void setIndictseqNull(){
     this.set(S_Indictseq,null);
  }

  public String getIndictseq(){
       return DataType.getAsString(this.get(S_Indictseq));
  
  }
  public String getIndictseqInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Indictseq));
      }

  public void initHandlingdept(String value){
     this.initProperty(S_Handlingdept,value);
  }
  public  void setHandlingdept(String value){
     this.set(S_Handlingdept,value);
  }
  public  void setHandlingdeptNull(){
     this.set(S_Handlingdept,null);
  }

  public String getHandlingdept(){
       return DataType.getAsString(this.get(S_Handlingdept));
  
  }
  public String getHandlingdeptInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Handlingdept));
      }

  public void initPhonenum(String value){
     this.initProperty(S_Phonenum,value);
  }
  public  void setPhonenum(String value){
     this.set(S_Phonenum,value);
  }
  public  void setPhonenumNull(){
     this.set(S_Phonenum,null);
  }

  public String getPhonenum(){
       return DataType.getAsString(this.get(S_Phonenum));
  
  }
  public String getPhonenumInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Phonenum));
      }


 
 }

