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
public class ExcelTaskBean extends DataContainer implements DataContainerInterface,IExcelTaskValue{

  private static String  m_boName = "ngves.asiainfo.core.common.bo.ExcelTask";



  public final static  String S_TaskState = "TASK_STATE";
  public final static  String S_ExcelTaskId = "EXCEL_TASK_ID";
  public final static  String S_ImplserviceQuerymethod = "IMPLSERVICE_QUERYMETHOD";
  public final static  String S_StaffId = "STAFF_ID";
  public final static  String S_TaskeType = "TASKE_TYPE";
  public final static  String S_OrderColType = "ORDER_COL_TYPE";
  public final static  String S_AppVersion = "APP_VERSION";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_ImplserviceCountmethod = "IMPLSERVICE_COUNTMETHOD";
  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_FailReason = "FAIL_REASON";
  public final static  String S_ImplserviceName = "IMPLSERVICE_NAME";
  public final static  String S_FileName = "FILE_NAME";
  public final static  String S_EndDate = "END_DATE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public ExcelTaskBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("error");
 }


  public void initTaskState(String value){
     this.initProperty(S_TaskState,value);
  }
  public  void setTaskState(String value){
     this.set(S_TaskState,value);
  }
  public  void setTaskStateNull(){
     this.set(S_TaskState,null);
  }

  public String getTaskState(){
       return DataType.getAsString(this.get(S_TaskState));
  
  }
  public String getTaskStateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TaskState));
      }

  public void initExcelTaskId(String value){
     this.initProperty(S_ExcelTaskId,value);
  }
  public  void setExcelTaskId(String value){
     this.set(S_ExcelTaskId,value);
  }
  public  void setExcelTaskIdNull(){
     this.set(S_ExcelTaskId,null);
  }

  public String getExcelTaskId(){
       return DataType.getAsString(this.get(S_ExcelTaskId));
  
  }
  public String getExcelTaskIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExcelTaskId));
      }

  public void initImplserviceQuerymethod(String value){
     this.initProperty(S_ImplserviceQuerymethod,value);
  }
  public  void setImplserviceQuerymethod(String value){
     this.set(S_ImplserviceQuerymethod,value);
  }
  public  void setImplserviceQuerymethodNull(){
     this.set(S_ImplserviceQuerymethod,null);
  }

  public String getImplserviceQuerymethod(){
       return DataType.getAsString(this.get(S_ImplserviceQuerymethod));
  
  }
  public String getImplserviceQuerymethodInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ImplserviceQuerymethod));
      }

  public void initStaffId(long value){
     this.initProperty(S_StaffId,new Long(value));
  }
  public  void setStaffId(long value){
     this.set(S_StaffId,new Long(value));
  }
  public  void setStaffIdNull(){
     this.set(S_StaffId,null);
  }

  public long getStaffId(){
        return DataType.getAsLong(this.get(S_StaffId));
  
  }
  public long getStaffIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_StaffId));
      }

  public void initTaskeType(String value){
     this.initProperty(S_TaskeType,value);
  }
  public  void setTaskeType(String value){
     this.set(S_TaskeType,value);
  }
  public  void setTaskeTypeNull(){
     this.set(S_TaskeType,null);
  }

  public String getTaskeType(){
       return DataType.getAsString(this.get(S_TaskeType));
  
  }
  public String getTaskeTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TaskeType));
      }

  public void initOrderColType(String value){
     this.initProperty(S_OrderColType,value);
  }
  public  void setOrderColType(String value){
     this.set(S_OrderColType,value);
  }
  public  void setOrderColTypeNull(){
     this.set(S_OrderColType,null);
  }

  public String getOrderColType(){
       return DataType.getAsString(this.get(S_OrderColType));
  
  }
  public String getOrderColTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrderColType));
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

  public void initImplserviceCountmethod(String value){
     this.initProperty(S_ImplserviceCountmethod,value);
  }
  public  void setImplserviceCountmethod(String value){
     this.set(S_ImplserviceCountmethod,value);
  }
  public  void setImplserviceCountmethodNull(){
     this.set(S_ImplserviceCountmethod,null);
  }

  public String getImplserviceCountmethod(){
       return DataType.getAsString(this.get(S_ImplserviceCountmethod));
  
  }
  public String getImplserviceCountmethodInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ImplserviceCountmethod));
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

  public void initImplserviceName(String value){
     this.initProperty(S_ImplserviceName,value);
  }
  public  void setImplserviceName(String value){
     this.set(S_ImplserviceName,value);
  }
  public  void setImplserviceNameNull(){
     this.set(S_ImplserviceName,null);
  }

  public String getImplserviceName(){
       return DataType.getAsString(this.get(S_ImplserviceName));
  
  }
  public String getImplserviceNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ImplserviceName));
      }

  public void initFileName(String value){
     this.initProperty(S_FileName,value);
  }
  public  void setFileName(String value){
     this.set(S_FileName,value);
  }
  public  void setFileNameNull(){
     this.set(S_FileName,null);
  }

  public String getFileName(){
       return DataType.getAsString(this.get(S_FileName));
  
  }
  public String getFileNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FileName));
      }

  public void initEndDate(Timestamp value){
     this.initProperty(S_EndDate,value);
  }
  public  void setEndDate(Timestamp value){
     this.set(S_EndDate,value);
  }
  public  void setEndDateNull(){
     this.set(S_EndDate,null);
  }

  public Timestamp getEndDate(){
        return DataType.getAsDateTime(this.get(S_EndDate));
  
  }
  public Timestamp getEndDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_EndDate));
      }


 
 }

