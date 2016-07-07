package ngves.asiainfo.core.order.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBusiUnfinishedOrderAuditValue extends DataStructInterface{

  public final static  String S_OptId = "OPT_ID";
  public final static  String S_BusiId = "BUSI_ID";
  public final static  String S_AuditContent = "AUDIT_CONTENT";
  public final static  String S_Status = "STATUS";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_TaskId = "TASK_ID";
  public final static  String S_AuditTime = "AUDIT_TIME";


public String getOptId();

public long getBusiId();

public String getAuditContent();

public String getStatus();

public String getBakCol2();

public String getBakCol3();

public String getBakCol1();

public long getTaskId();

public Timestamp getAuditTime();


public  void setOptId(String value);

public  void setBusiId(long value);

public  void setAuditContent(String value);

public  void setStatus(String value);

public  void setBakCol2(String value);

public  void setBakCol3(String value);

public  void setBakCol1(String value);

public  void setTaskId(long value);

public  void setAuditTime(Timestamp value);
}
