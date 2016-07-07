package ngves.asiainfo.core.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISaleSendInfoValue extends DataStructInterface{

  public final static  String S_SendId = "SEND_ID";
  public final static  String S_SaleId = "SALE_ID";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_SendType = "SEND_TYPE";
  public final static  String S_FailReason = "FAIL_REASON";
  public final static  String S_SendObj = "SEND_OBJ";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_IsSend = "IS_SEND";
  public final static  String S_RltId = "RLT_ID";
  public final static  String S_SendTime = "SEND_TIME";
  public final static  String S_OptTime = "OPT_TIME";


public long getSendId();

public long getSaleId();

public String getBakCol2();

public String getSendType();

public String getFailReason();

public String getSendObj();

public Timestamp getCreateTime();

public long getBakCol1();

public String getIsSend();

public String getRltId();

public Timestamp getSendTime();

public Timestamp getOptTime();


public  void setSendId(long value);

public  void setSaleId(long value);

public  void setBakCol2(String value);

public  void setSendType(String value);

public  void setFailReason(String value);

public  void setSendObj(String value);

public  void setCreateTime(Timestamp value);

public  void setBakCol1(long value);

public  void setIsSend(String value);

public  void setRltId(String value);

public  void setSendTime(Timestamp value);

public  void setOptTime(Timestamp value);
}
