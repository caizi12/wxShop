package ngves.asiainfo.core.ware.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IWareUpDownPlanValue extends DataStructInterface{

  public final static  String S_OpRltId = "OP_RLT_ID";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_PreopTime = "PREOP_TIME";
  public final static  String S_OpState = "OP_STATE";
  public final static  String S_UpdownPlanId = "UPDOWN_PLAN_ID";
  public final static  String S_Note = "NOTE";
  public final static  String S_StatusCause = "STATUS_CAUSE";
  public final static  String S_OpType = "OP_TYPE";
  public final static  String S_JobId = "JOB_ID";
  public final static  String S_WareId = "WARE_ID";


public long getOpRltId();

public Timestamp getCreateTime();

public Timestamp getPreopTime();

public String getOpState();

public long getUpdownPlanId();

public String getNote();

public String getStatusCause();

public String getOpType();

public long getJobId();

public long getWareId();


public  void setOpRltId(long value);

public  void setCreateTime(Timestamp value);

public  void setPreopTime(Timestamp value);

public  void setOpState(String value);

public  void setUpdownPlanId(long value);

public  void setNote(String value);

public  void setStatusCause(String value);

public  void setOpType(String value);

public  void setJobId(long value);

public  void setWareId(long value);
}
