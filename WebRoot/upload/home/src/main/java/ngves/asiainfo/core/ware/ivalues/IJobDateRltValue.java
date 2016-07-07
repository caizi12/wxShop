package ngves.asiainfo.core.ware.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IJobDateRltValue extends DataStructInterface{

  public final static  String S_StartDate = "START_DATE";
  public final static  String S_SortId = "SORT_ID";
  public final static  String S_EndDate = "END_DATE";
  public final static  String S_JobDateRltId = "JOB_DATE_RLT_ID";
  public final static  String S_JobTaskId = "JOB_TASK_ID";


public Timestamp getStartDate();

public long getSortId();

public Timestamp getEndDate();

public long getJobDateRltId();

public long getJobTaskId();


public  void setStartDate(Timestamp value);

public  void setSortId(long value);

public  void setEndDate(Timestamp value);

public  void setJobDateRltId(long value);

public  void setJobTaskId(long value);
}
