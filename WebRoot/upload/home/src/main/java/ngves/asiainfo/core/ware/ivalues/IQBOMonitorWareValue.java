package ngves.asiainfo.core.ware.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IQBOMonitorWareValue extends DataStructInterface{

  public final static  String S_PartnerName = "PARTNER_NAME";
  public final static  String S_KindName = "KIND_NAME";
  public final static  String S_JobTaskId = "JOB_TASK_ID";
  public final static  String S_WareStatus = "WARE_STATUS";
  public final static  String S_WareName = "WARE_NAME";
  public final static  String S_WareCode = "WARE_CODE";


public String getPartnerName();

public String getKindName();

public long getJobTaskId();

public String getWareStatus();

public String getWareName();

public String getWareCode();


public  void setPartnerName(String value);

public  void setKindName(String value);

public  void setJobTaskId(long value);

public  void setWareStatus(String value);

public  void setWareName(String value);

public  void setWareCode(String value);
}
