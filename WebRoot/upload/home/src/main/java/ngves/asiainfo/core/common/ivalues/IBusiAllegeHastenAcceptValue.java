package ngves.asiainfo.core.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBusiAllegeHastenAcceptValue extends DataStructInterface{

  public final static  String S_Handlingstaff = "HANDLINGSTAFF";
  public final static  String S_BusiId = "BUSI_ID";
  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_Handlingcomment = "HANDLINGCOMMENT";
  public final static  String S_AppVersion = "APP_VERSION";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Indictseq = "INDICTSEQ";
  public final static  String S_Handlingdept = "HANDLINGDEPT";
  public final static  String S_Phonenum = "PHONENUM";


public String getHandlingstaff();

public long getBusiId();

public String getBakCol();

public String getBakCol2();

public String getBakCol3();

public String getHandlingcomment();

public long getAppVersion();

public Timestamp getCreateDate();

public String getIndictseq();

public String getHandlingdept();

public String getPhonenum();


public  void setHandlingstaff(String value);

public  void setBusiId(long value);

public  void setBakCol(String value);

public  void setBakCol2(String value);

public  void setBakCol3(String value);

public  void setHandlingcomment(String value);

public  void setAppVersion(long value);

public  void setCreateDate(Timestamp value);

public  void setIndictseq(String value);

public  void setHandlingdept(String value);

public  void setPhonenum(String value);
}
