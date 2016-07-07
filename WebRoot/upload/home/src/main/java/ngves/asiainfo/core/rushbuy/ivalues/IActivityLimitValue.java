package ngves.asiainfo.core.rushbuy.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IActivityLimitValue extends DataStructInterface{

  public final static  String S_ActivityEndTime = "ACTIVITY_END_TIME";
  public final static  String S_BgPic = "BG_PIC";
  public final static  String S_AlGroupId = "AL_GROUP_ID";
  public final static  String S_ActivityId = "ACTIVITY_ID";
  public final static  String S_BgColor = "BG_COLOR";
  public final static  String S_AppVersion = "APP_VERSION";
  public final static  String S_ActivityStartTime = "ACTIVITY_START_TIME";
  public final static  String S_ActivityQuestion = "ACTIVITY_QUESTION";
  public final static  String S_ActivityPublicTime = "ACTIVITY_PUBLIC_TIME";
  public final static  String S_ActivityRule = "ACTIVITY_RULE";
  public final static  String S_MainPic = "MAIN_PIC";
  public final static  String S_ActivityState = "ACTIVITY_STATE";
  public final static  String S_ActivityPublicPartner = "ACTIVITY_PUBLIC_PARTNER";
  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_ActivityUrl = "ACTIVITY_URL";
  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_ActivityName = "ACTIVITY_NAME";
  public final static  String S_ActivityRecordPartner = "ACTIVITY_RECORD_PARTNER";
  public final static  String S_IsView = "IS_VIEW";
  public final static  String S_ActivityRecordTime = "ACTIVITY_RECORD_TIME";
  public final static String S_ActivityAction = "ACTIVITY_ACTION";
  public final static String S_WareBind = "WARE_BIND";
  public final static String S_ActivityResult = "ACTIVITY_RESULT";
  
  public final static String S_PayType = "PAY_TYPE";
  public final static String S_PayTime = "PAY_TIME";


public Timestamp getActivityEndTime();

public String getBgPic();

public long getAlGroupId();

public long getActivityId();

public String getBgColor();

public long getAppVersion();

public Timestamp getActivityStartTime();

public String getActivityQuestion();

public Timestamp getActivityPublicTime();

public String getActivityRule();

public String getMainPic();

public String getActivityState();

public String getActivityPublicPartner();

public String getBakCol();

public String getBakCol2();

public String getActivityUrl();

public String getBakCol3();

public String getActivityName();

public String getActivityRecordPartner();

public String getIsView();

public Timestamp getActivityRecordTime();

public String getPayType();

public String getPayTime();




public  void setPayTime(String value);

public  void setPayType(String value);

public  void setActivityEndTime(Timestamp value);

public  void setBgPic(String value);

public  void setAlGroupId(long value);

public  void setActivityId(long value);

public  void setBgColor(String value);

public  void setAppVersion(long value);

public  void setActivityStartTime(Timestamp value);

public  void setActivityQuestion(String value);

public  void setActivityPublicTime(Timestamp value);

public  void setActivityRule(String value);

public  void setMainPic(String value);

public  void setActivityState(String value);

public  void setActivityPublicPartner(String value);

public  void setBakCol(String value);

public  void setBakCol2(String value);

public  void setActivityUrl(String value);

public  void setBakCol3(String value);

public  void setActivityName(String value);

public  void setActivityRecordPartner(String value);

public  void setIsView(String value);

public  void setActivityRecordTime(Timestamp value);

public boolean isView();

public String getActivityAction();

public void setActivityAction(String value);

public String getWareBind();


public String getActivityResult();

public void setActivityResult(String value);
}
