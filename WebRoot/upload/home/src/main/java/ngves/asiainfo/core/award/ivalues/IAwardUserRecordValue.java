package ngves.asiainfo.core.award.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IAwardUserRecordValue extends DataStructInterface{

  public final static  String S_MobileNum = "MOBILE_NUM";
  public final static  String S_LevelSort = "LEVEL_SORT";
  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_AwardUserRecordId = "AWARD_USER_RECORD_ID";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_UserBrand = "USER_BRAND";
  public final static  String S_ProvinceCode = "PROVINCE_CODE";
  public final static  String S_AwardLevelId = "AWARD_LEVEL_ID";
  public final static  String S_WareId = "WARE_ID";
  public final static  String S_AwardId = "AWARD_ID";
  public final static  String S_AwardType = "AWARD_TYPE";
  
public String getAwardType();

public String getMobileNum();

public long getLevelSort();

public String getBakCol();

public String getBakCol2();

public long getAwardUserRecordId();

public Timestamp getCreateTime();

public String getUserBrand();

public String getProvinceCode();

public long getAwardLevelId();

public long getWareId();

public long getAwardId();


public  void setMobileNum(String value);

public  void setLevelSort(long value);

public  void setBakCol(String value);

public  void setBakCol2(String value);

public  void setAwardUserRecordId(long value);

public  void setCreateTime(Timestamp value);

public  void setUserBrand(String value);

public  void setProvinceCode(String value);

public  void setAwardLevelId(long value);

public  void setWareId(long value);

public  void setAwardId(long value);
public  void setAwardType(String value);
}
