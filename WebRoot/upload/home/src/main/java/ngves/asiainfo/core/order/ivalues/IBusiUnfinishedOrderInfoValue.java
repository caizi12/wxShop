package ngves.asiainfo.core.order.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBusiUnfinishedOrderInfoValue extends DataStructInterface{

  public final static  String S_BusiId = "BUSI_ID";
  public final static  String S_OrderType = "ORDER_TYPE";
  public final static  String S_EndState = "END_STATE";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_OperTime = "OPER_TIME";
  public final static  String S_OptId = "OPT_ID";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_BusinessType = "BUSINESS_TYPE";
  public final static  String S_DescInfo = "DESC_INFO";
  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_IsSettle = "IS_SETTLE";
  public final static  String S_TaskId = "TASK_ID";
  public final static  String S_IsSend = "IS_SEND";
  public final static  String S_IsFileChange = "IS_FILE_CHANGE";


public long getBusiId();

public String getOrderType();

public String getEndState();

public String getBakCol1();

public Timestamp getOperTime();

public String getOptId();

public String getBakCol2();

public String getBusinessType();

public String getDescInfo();

public String getBakCol3();

public String getIsSettle();

public String getTaskId();

public String getIsSend();

public String getIsFileChange();


public  void setBusiId(long value);

public  void setOrderType(String value);

public  void setEndState(String value);

public  void setBakCol1(String value);

public  void setOperTime(Timestamp value);

public  void setOptId(String value);

public  void setBakCol2(String value);

public  void setBusinessType(String value);

public  void setDescInfo(String value);

public  void setBakCol3(String value);

public  void setIsSettle(String value);

public  void setTaskId(String value);

public  void setIsSend(String value);

public  void setIsFileChange(String value);
}
