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
public class BusiInfoBean extends DataContainer implements DataContainerInterface,IBusiInfoValue{

  private static String  m_boName = "ngves.asiainfo.core.common.bo.BusiInfo";



  public final static  String S_BusiInfoId = "BUSI_INFO_ID";
  public final static  String S_BusiStaffId = "BUSI_STAFF_ID";
  public final static  String S_BusiDate = "BUSI_DATE";
  public final static  String S_BusiId = "BUSI_ID";
  public final static  String S_BusiComType = "BUSI_COM_TYPE";
  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_OptObj = "OPT_OBJ";
  public final static  String S_Note = "NOTE";
  public final static  String S_BusiTypeId = "BUSI_TYPE_ID";
  public final static  String S_OptType = "OPT_TYPE";
  public final static  String S_BusiComId = "BUSI_COM_ID";
  public BusiInfoBean() throws AIException{
      super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
  }


 public static ObjectType getObjectTypeStatic() throws AIException{
   return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initBusiInfoId(long value){
     this.initProperty(S_BusiInfoId,new Long(value));
  }
  public  void setBusiInfoId(long value){
     this.set(S_BusiInfoId,new Long(value));
  }
  public  void setBusiInfoIdNull(){
     this.set(S_BusiInfoId,null);
  }

  public long getBusiInfoId(){
        return DataType.getAsLong(this.get(S_BusiInfoId));
  
  }
  public long getBusiInfoIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BusiInfoId));
      }

  public void initBusiStaffId(long value){
     this.initProperty(S_BusiStaffId,new Long(value));
  }
  public  void setBusiStaffId(long value){
     this.set(S_BusiStaffId,new Long(value));
  }
  public  void setBusiStaffIdNull(){
     this.set(S_BusiStaffId,null);
  }

  public long getBusiStaffId(){
        return DataType.getAsLong(this.get(S_BusiStaffId));
  
  }
  public long getBusiStaffIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BusiStaffId));
      }

  public void initBusiDate(Timestamp value){
     this.initProperty(S_BusiDate,value);
  }
  public  void setBusiDate(Timestamp value){
     this.set(S_BusiDate,value);
  }
  public  void setBusiDateNull(){
     this.set(S_BusiDate,null);
  }

  public Timestamp getBusiDate(){
        return DataType.getAsDateTime(this.get(S_BusiDate));
  
  }
  public Timestamp getBusiDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_BusiDate));
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

  public void initBusiComType(String value){
     this.initProperty(S_BusiComType,value);
  }
  public  void setBusiComType(String value){
     this.set(S_BusiComType,value);
  }
  public  void setBusiComTypeNull(){
     this.set(S_BusiComType,null);
  }

  public String getBusiComType(){
       return DataType.getAsString(this.get(S_BusiComType));
  
  }
  public String getBusiComTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BusiComType));
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

  public void initOptObj(String value){
     this.initProperty(S_OptObj,value);
  }
  public  void setOptObj(String value){
     this.set(S_OptObj,value);
  }
  public  void setOptObjNull(){
     this.set(S_OptObj,null);
  }

  public String getOptObj(){
       return DataType.getAsString(this.get(S_OptObj));
  
  }
  public String getOptObjInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OptObj));
      }

  public void initNote(String value){
     this.initProperty(S_Note,value);
  }
  public  void setNote(String value){
     this.set(S_Note,value);
  }
  public  void setNoteNull(){
     this.set(S_Note,null);
  }

  public String getNote(){
       return DataType.getAsString(this.get(S_Note));
  
  }
  public String getNoteInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Note));
      }

  public void initBusiTypeId(String value){
     this.initProperty(S_BusiTypeId,value);
  }
  public  void setBusiTypeId(String value){
     this.set(S_BusiTypeId,value);
  }
  public  void setBusiTypeIdNull(){
     this.set(S_BusiTypeId,null);
  }

  public String getBusiTypeId(){
       return DataType.getAsString(this.get(S_BusiTypeId));
  
  }
  public String getBusiTypeIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BusiTypeId));
      }

  public void initOptType(String value){
     this.initProperty(S_OptType,value);
  }
  public  void setOptType(String value){
     this.set(S_OptType,value);
  }
  public  void setOptTypeNull(){
     this.set(S_OptType,null);
  }

  public String getOptType(){
       return DataType.getAsString(this.get(S_OptType));
  
  }
  public String getOptTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OptType));
      }

  public void initBusiComId(long value){
     this.initProperty(S_BusiComId,new Long(value));
  }
  public  void setBusiComId(long value){
     this.set(S_BusiComId,new Long(value));
  }
  public  void setBusiComIdNull(){
     this.set(S_BusiComId,null);
  }

  public long getBusiComId(){
        return DataType.getAsLong(this.get(S_BusiComId));
  
  }
  public long getBusiComIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BusiComId));
      }


 
 }

