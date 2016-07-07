package ngves.asiainfo.core.donated.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IDonatedPicValue extends DataStructInterface{

  public final static  String S_Bgcolor = "BGCOLOR";
  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_TopPx = "TOP_PX";
  public final static  String S_RightPx = "RIGHT_PX";
  public final static  String S_ActivityPicId = "ACTIVITY_PIC_ID";
  public final static  String S_MainPic = "MAIN_PIC";
  public final static  String S_DescPic = "DESC_PIC";
  public final static  String S_BgPic = "BG_PIC";
  public final static  String S_LeftPx = "LEFT_PX";
  public final static  String S_BottomPx = "BOTTOM_PX";


public String getBgcolor();

public String getBakCol();

public String getBakCol2();

public long getTopPx();

public long getRightPx();

public long getActivityPicId();

public String getMainPic();

public String getDescPic();

public String getBgPic();

public long getLeftPx();

public long getBottomPx();


public  void setBgcolor(String value);

public  void setBakCol(String value);

public  void setBakCol2(String value);

public  void setTopPx(long value);

public  void setRightPx(long value);

public  void setActivityPicId(long value);

public  void setMainPic(String value);

public  void setDescPic(String value);

public  void setBgPic(String value);

public  void setLeftPx(long value);

public  void setBottomPx(long value);
}
