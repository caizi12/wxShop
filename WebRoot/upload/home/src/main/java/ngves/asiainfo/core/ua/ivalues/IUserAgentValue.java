package ngves.asiainfo.core.ua.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IUserAgentValue extends DataStructInterface{

  public final static  String S_ResolutionHeight = "RESOLUTION_HEIGHT";
  public final static  String S_Os = "OS";
  public final static  String S_Brand = "BRAND";
  public final static  String S_ScreenWidth = "SCREEN_WIDTH";
  public final static  String S_RowsCount = "ROWS_COUNT";
  public final static  String S_ResolutionWidth = "RESOLUTION_WIDTH";
  public final static  String S_WapVersion = "WAP_VERSION";
  public final static  String S_UaStr = "UA_STR";
  public final static  String S_AppearDate = "APPEAR_DATE";
  public final static  String S_ForwardAddress = "FORWARD_ADDRESS";
  public final static  String S_PhoneModel = "PHONE_MODEL";
  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_MatchedRule = "MATCHED_RULE";
  public final static  String S_UaCode = "UA_CODE";
  public final static  String S_ScreenHeight = "SCREEN_HEIGHT";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_ColumnsCount = "COLUMNS_COUNT";
  public final static  String S_VisitedCount = "VISITED_COUNT";
  public final static  String S_Id = "ID";


public long getResolutionHeight();

public String getOs();

public String getBrand();

public long getScreenWidth();

public long getRowsCount();

public long getResolutionWidth();

public String getWapVersion();

public String getUaStr();

public Timestamp getAppearDate();

public String getForwardAddress();

public String getPhoneModel();

public String getBakCol();

public String getMatchedRule();

public String getUaCode();

public long getScreenHeight();

public String getBakCol2();

public long getColumnsCount();

public long getVisitedCount();

public long getId();


public  void setResolutionHeight(long value);

public  void setOs(String value);

public  void setBrand(String value);

public  void setScreenWidth(long value);

public  void setRowsCount(long value);

public  void setResolutionWidth(long value);

public  void setWapVersion(String value);

public  void setUaStr(String value);

public  void setAppearDate(Timestamp value);

public  void setForwardAddress(String value);

public  void setPhoneModel(String value);

public  void setBakCol(String value);

public  void setMatchedRule(String value);

public  void setUaCode(String value);

public  void setScreenHeight(long value);

public  void setBakCol2(String value);

public  void setColumnsCount(long value);

public  void setVisitedCount(long value);

public  void setId(long value);
}
