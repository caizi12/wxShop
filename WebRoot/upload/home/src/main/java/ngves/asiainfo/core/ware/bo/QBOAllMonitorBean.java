package ngves.asiainfo.core.ware.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.ware.ivalues.*;

@SuppressWarnings("serial")
public class QBOAllMonitorBean extends DataContainer implements DataContainerInterface,IQBOAllMonitorValue{

  private static String  m_boName = "ngves.asiainfo.core.ware.bo.QBOAllMonitor";



  public final static  String S_CommonName = "COMMON_NAME";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_InitiateMode = "INITIATE_MODE";
  public final static  String S_MonitorObjectId = "MONITOR_OBJECT_ID";
  public final static  String S_MonitorType = "MONITOR_TYPE";
  public final static  String S_JobTaskId = "JOB_TASK_ID";
  public final static  String S_WarningType = "WARNING_TYPE";
  public final static  String S_Operate = "OPERATE";
  public QBOAllMonitorBean() throws AIException{
      super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
  }


 public static ObjectType getObjectTypeStatic() throws AIException{
   return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initCommonName(String value){
     this.initProperty(S_CommonName,value);
  }
  public  void setCommonName(String value){
     this.set(S_CommonName,value);
  }
  public  void setCommonNameNull(){
     this.set(S_CommonName,null);
  }

  public String getCommonName(){
       return DataType.getAsString(this.get(S_CommonName));
  
  }
  public String getCommonNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CommonName));
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

  public void initInitiateMode(String value){
     this.initProperty(S_InitiateMode,value);
  }
  public  void setInitiateMode(String value){
     this.set(S_InitiateMode,value);
  }
  public  void setInitiateModeNull(){
     this.set(S_InitiateMode,null);
  }

  public String getInitiateMode(){
       return DataType.getAsString(this.get(S_InitiateMode));
  
  }
  public String getInitiateModeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_InitiateMode));
      }

  public void initMonitorObjectId(String value){
     this.initProperty(S_MonitorObjectId,value);
  }
  public  void setMonitorObjectId(String value){
     this.set(S_MonitorObjectId,value);
  }
  public  void setMonitorObjectIdNull(){
     this.set(S_MonitorObjectId,null);
  }

  public String getMonitorObjectId(){
       return DataType.getAsString(this.get(S_MonitorObjectId));
  
  }
  public String getMonitorObjectIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MonitorObjectId));
      }

  public void initMonitorType(String value){
     this.initProperty(S_MonitorType,value);
  }
  public  void setMonitorType(String value){
     this.set(S_MonitorType,value);
  }
  public  void setMonitorTypeNull(){
     this.set(S_MonitorType,null);
  }

  public String getMonitorType(){
       return DataType.getAsString(this.get(S_MonitorType));
  
  }
  public String getMonitorTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MonitorType));
      }

  public void initJobTaskId(long value){
     this.initProperty(S_JobTaskId,new Long(value));
  }
  public  void setJobTaskId(long value){
     this.set(S_JobTaskId,new Long(value));
  }
  public  void setJobTaskIdNull(){
     this.set(S_JobTaskId,null);
  }

  public long getJobTaskId(){
        return DataType.getAsLong(this.get(S_JobTaskId));
  
  }
  public long getJobTaskIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_JobTaskId));
      }

  public void initWarningType(String value){
     this.initProperty(S_WarningType,value);
  }
  public  void setWarningType(String value){
     this.set(S_WarningType,value);
  }
  public  void setWarningTypeNull(){
     this.set(S_WarningType,null);
  }

  public String getWarningType(){
       return DataType.getAsString(this.get(S_WarningType));
  
  }
  public String getWarningTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WarningType));
      }

  public void initOperate(String value){
     this.initProperty(S_Operate,value);
  }
  public  void setOperate(String value){
     this.set(S_Operate,value);
  }
  public  void setOperateNull(){
     this.set(S_Operate,null);
  }

  public String getOperate(){
       return DataType.getAsString(this.get(S_Operate));
  
  }
  public String getOperateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Operate));
      }


 
 }

