package ngves.asiainfo.core.ware.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.ware.ivalues.*;

public class JobDateRltBean extends DataContainer implements DataContainerInterface,IJobDateRltValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



private static String  m_boName = "ngves.asiainfo.core.ware.bo.JobDateRlt";



  public final static  String S_StartDate = "START_DATE";
  public final static  String S_SortId = "SORT_ID";
  public final static  String S_EndDate = "END_DATE";
  public final static  String S_JobDateRltId = "JOB_DATE_RLT_ID";
  public final static  String S_JobTaskId = "JOB_TASK_ID";
  public JobDateRltBean() throws AIException{
      super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
  }


 public static ObjectType getObjectTypeStatic() throws AIException{
   return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initStartDate(Timestamp value){
     this.initProperty(S_StartDate,value);
  }
  public  void setStartDate(Timestamp value){
     this.set(S_StartDate,value);
  }
  public  void setStartDateNull(){
     this.set(S_StartDate,null);
  }

  public Timestamp getStartDate(){
        return DataType.getAsDateTime(this.get(S_StartDate));
  
  }
  public Timestamp getStartDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_StartDate));
      }

  public void initSortId(long value){
     this.initProperty(S_SortId,new Long(value));
  }
  public  void setSortId(long value){
     this.set(S_SortId,new Long(value));
  }
  public  void setSortIdNull(){
     this.set(S_SortId,null);
  }

  public long getSortId(){
        return DataType.getAsLong(this.get(S_SortId));
  
  }
  public long getSortIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SortId));
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

  public void initJobDateRltId(long value){
     this.initProperty(S_JobDateRltId,new Long(value));
  }
  public  void setJobDateRltId(long value){
     this.set(S_JobDateRltId,new Long(value));
  }
  public  void setJobDateRltIdNull(){
     this.set(S_JobDateRltId,null);
  }

  public long getJobDateRltId(){
        return DataType.getAsLong(this.get(S_JobDateRltId));
  
  }
  public long getJobDateRltIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_JobDateRltId));
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


 
 }

