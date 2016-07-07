package ngves.asiainfo.core.award.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IAwardLevelInfoValue extends DataStructInterface{

  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_AwardOdds = "AWARD_ODDS";
  public final static  String S_MaxCount = "MAX_COUNT";
  public final static  String S_AwardId = "AWARD_ID";
  public final static  String S_WareId = "WARE_ID";
  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_IsDefaultLevel = "IS_DEFAULT_LEVEL";
  public final static  String S_LevelSort = "LEVEL_SORT";
  public final static  String S_WareNickname = "WARE_NICKNAME";
  public final static  String S_IsShowWare = "IS_SHOW_WARE";
  public final static  String S_AwardLevelId = "AWARD_LEVEL_ID";
  public final static  String S_BgColourCode = "BG_COLOUR_CODE";
  public final static  String S_WareCode = "WARE_CODE";
  public final static  String S_LevelAngle = "LEVEL_ANGLE";
  
public long getLevelAngle();

public String getBakCol3();

public String getBakCol2();

public long getAwardOdds();

public long getMaxCount();

public long getAwardId();

public long getWareId();

public String getBakCol();

public String getIsDefaultLevel();

public long getLevelSort();

public String getWareNickname();

public String getIsShowWare();

public long getAwardLevelId();

public String getBgColourCode();

public String getWareCode();


public  void setBakCol3(String value);

public  void setBakCol2(String value);

public  void setAwardOdds(long value);

public  void setMaxCount(long value);

public  void setAwardId(long value);

public  void setWareId(long value);

public  void setBakCol(String value);

public  void setIsDefaultLevel(String value);

public  void setLevelSort(long value);

public  void setWareNickname(String value);

public  void setIsShowWare(String value);

public  void setAwardLevelId(long value);

public  void setBgColourCode(String value);

public  void setWareCode(String value);
public  void setLevelAngle(long value);
}
