package ngves.asiainfo.core.ware.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IStaffJobRltValue extends DataStructInterface{

  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_StaffId = "STAFF_ID";
  public final static  String S_IsBind = "IS_BIND";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_StaffJobRltId = "STAFF_JOB_RLT_ID";
  public final static  String S_JobTaskId = "JOB_TASK_ID";


public String getBakCol3();

public String getBakCol2();

public long getStaffId();

public long getIsBind();

public String getBakCol1();

public long getStaffJobRltId();

public long getJobTaskId();


public  void setBakCol3(String value);

public  void setBakCol2(String value);

public  void setStaffId(long value);

public  void setIsBind(long value);

public  void setBakCol1(String value);

public  void setStaffJobRltId(long value);

public  void setJobTaskId(long value);
}
