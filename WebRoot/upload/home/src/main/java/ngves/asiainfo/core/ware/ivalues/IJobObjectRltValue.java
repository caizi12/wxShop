package ngves.asiainfo.core.ware.ivalues;
import com.ai.appframe2.common.DataStructInterface;

public interface IJobObjectRltValue extends DataStructInterface{

  public final static  String S_JobTaskId = "JOB_TASK_ID";
  public final static  String S_MonitorType = "MONITOR_TYPE";
  public final static  String S_MonitorObjectId = "MONITOR_OBJECT_ID";
  public final static  String S_JobObjectRltId = "JOB_OBJECT_RLT_ID";


public long getJobTaskId();

public String getMonitorType();

public String getMonitorObjectId();

public long getJobObjectRltId();


public  void setJobTaskId(long value);

public  void setMonitorType(String value);

public  void setMonitorObjectId(String value);

public  void setJobObjectRltId(long value);
}
