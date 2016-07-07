package ngves.asiainfo.core.ware.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IWareMonitorRecordValue extends DataStructInterface{

  public final static  String S_OperatorId = "OPERATOR_ID";
  public final static  String S_OperateDesc = "OPERATE_DESC";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_WareMonitorRecordId = "WARE_MONITOR_RECORD_ID";
  public final static  String S_OperateType = "OPERATE_TYPE";
  public final static  String S_OperateTime = "OPERATE_TIME";


public long getOperatorId();

public String getOperateDesc();

public String getBakCol1();

public long getWareMonitorRecordId();

public String getOperateType();

public Timestamp getOperateTime();


public  void setOperatorId(long value);

public  void setOperateDesc(String value);

public  void setBakCol1(String value);

public  void setWareMonitorRecordId(long value);

public  void setOperateType(String value);

public  void setOperateTime(Timestamp value);
}
