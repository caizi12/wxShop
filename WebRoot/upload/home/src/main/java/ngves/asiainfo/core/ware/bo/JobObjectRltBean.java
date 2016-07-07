package ngves.asiainfo.core.ware.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.ware.ivalues.*;

public class JobObjectRltBean extends DataContainer implements DataContainerInterface,IJobObjectRltValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



private static String  m_boName = "ngves.asiainfo.core.ware.bo.JobObjectRlt";



  public final static  String S_JobTaskId = "JOB_TASK_ID";
  public final static  String S_MonitorType = "MONITOR_TYPE";
  public final static  String S_MonitorObjectId = "MONITOR_OBJECT_ID";
  public final static  String S_JobObjectRltId = "JOB_OBJECT_RLT_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public JobObjectRltBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
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

  public void initJobObjectRltId(long value){
     this.initProperty(S_JobObjectRltId,new Long(value));
  }
  public  void setJobObjectRltId(long value){
     this.set(S_JobObjectRltId,new Long(value));
  }
  public  void setJobObjectRltIdNull(){
     this.set(S_JobObjectRltId,null);
  }

  public long getJobObjectRltId(){
        return DataType.getAsLong(this.get(S_JobObjectRltId));
  
  }
  public long getJobObjectRltIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_JobObjectRltId));
      }


 
 }

