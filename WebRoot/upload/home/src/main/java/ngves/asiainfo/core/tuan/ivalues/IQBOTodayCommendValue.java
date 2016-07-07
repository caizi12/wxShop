package ngves.asiainfo.core.tuan.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IQBOTodayCommendValue extends DataStructInterface{

  public final static  String S_OriPayCash = "ORI_PAY_CASH";
  public final static  String S_OriIntegral = "ORI_INTEGRAL";
  public final static  String S_WarePayType = "WARE_PAY_TYPE";
  public final static  String S_Discount = "DISCOUNT";
  public final static  String S_CurPayIntegral = "CUR_PAY_INTEGRAL";
  public final static  String S_CurIntegral = "CUR_INTEGRAL";
  public final static  String S_CurPayCash = "CUR_PAY_CASH";
  public final static  String S_PayType = "PAY_TYPE";
  public final static  String S_OriPayIntegral = "ORI_PAY_INTEGRAL";
  public final static  String S_MainPic = "MAIN_PIC";
  public final static  String S_TuanPayType = "TUAN_PAY_TYPE";
  public final static  String S_EndTime = "END_TIME";
  public final static  String S_WareName = "WARE_NAME";
  public final static  String S_StartTime = "START_TIME";
  public final static  String S_ProvinceCode = "PROVINCE_CODE";
  public final static  String S_Url = "URL";
  public final static  String S_TopFlag = "TOP_FLAG";
  public final static  String S_Name = "NAME";
  public final static  String S_TuanId = "TUAN_ID";
  public final static  String S_Channel = "CHANNEL";
  public final static  String S_StarLevel = "STAR_LEVEL";


public long getOriPayCash();

public long getOriIntegral();

public String getWarePayType();

public long getDiscount();

public long getCurPayIntegral();

public long getCurIntegral();

public long getCurPayCash();

public String getPayType();

public long getOriPayIntegral();

public String getMainPic();

public String getTuanPayType();

public Timestamp getEndTime();

public String getWareName();

public Timestamp getStartTime();

public String getProvinceCode();

public String getUrl();

public long getTopFlag();

public String getName();

public long getTuanId();

public String getChannel();
public String getStarLevel();

public  void setChannel(String value);
public  void setStarLevel(String value);

public  void setOriPayCash(long value);

public  void setOriIntegral(long value);

public  void setWarePayType(String value);

public  void setDiscount(long value);

public  void setCurPayIntegral(long value);

public  void setCurIntegral(long value);

public  void setCurPayCash(long value);

public  void setPayType(String value);

public  void setOriPayIntegral(long value);

public  void setMainPic(String value);

public  void setTuanPayType(String value);

public  void setEndTime(Timestamp value);

public  void setWareName(String value);

public  void setStartTime(Timestamp value);

public  void setProvinceCode(String value);

public  void setUrl(String value);

public  void setTopFlag(long value);

public  void setName(String value);

public  void setTuanId(long value);
}
