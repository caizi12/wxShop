package ngves.asiainfo.core.ware.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IQBOAllMonitorValue extends DataStructInterface{

  public final static  String S_CommonName = "COMMON_NAME";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_InitiateMode = "INITIATE_MODE";
  public final static  String S_MonitorObjectId = "MONITOR_OBJECT_ID";
  public final static  String S_MonitorType = "MONITOR_TYPE";
  public final static  String S_JobTaskId = "JOB_TASK_ID";
  public final static  String S_WarningType = "WARNING_TYPE";
  public final static  String S_Operate = "OPERATE";


public String getCommonName();

public Timestamp getCreateTime();

public String getInitiateMode();

public String getMonitorObjectId();

public String getMonitorType();

public long getJobTaskId();

public String getWarningType();

public String getOperate();


public  void setCommonName(String value);

public  void setCreateTime(Timestamp value);

public  void setInitiateMode(String value);

public  void setMonitorObjectId(String value);

public  void setMonitorType(String value);

public  void setJobTaskId(long value);

public  void setWarningType(String value);

public  void setOperate(String value);
}
