package ngves.asiainfo.core.ware.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IJobTaskValue extends DataStructInterface{

  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_JobTaskType = "JOB_TASK_TYPE";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_JobTaskName = "JOB_TASK_NAME";
  public final static  String S_JobTaskId = "JOB_TASK_ID";


public String getBakCol3();

public String getBakCol2();

public String getBakCol1();

public String getJobTaskType();

public Timestamp getCreateTime();

public String getJobTaskName();

public long getJobTaskId();


public  void setBakCol3(String value);

public  void setBakCol2(String value);

public  void setBakCol1(String value);

public  void setJobTaskType(String value);

public  void setCreateTime(Timestamp value);

public  void setJobTaskName(String value);

public  void setJobTaskId(long value);
}
