package ngves.asiainfo.core.tuan.ivalues;
import java.sql.Timestamp;

import com.ai.appframe2.common.DataStructInterface;
public interface IQBOComingSoonValue extends DataStructInterface{

  public final static  String S_MainPic = "MAIN_PIC";
  public final static  String S_WareName = "WARE_NAME";
  public final static  String S_Url = "URL";
  public final static  String S_Name = "NAME";
  public final static  String S_Discount = "DISCOUNT";
  public final static  String S_TuanId = "TUAN_ID";
  public final static  String S_StartTime = "START_TIME";
  public final static  String S_EndTime = "END_TIME";
  public final static  String S_MzoneValue = "ORI_INTEGRAL";
  public final static  String S_EasyownValue = "CUR_INTEGRAL";
  public final static  String S_TopFlag = "TOP_FLAG";
  //混合支付
    public final static String S_PayType = "PAY_TYPE";
	public final static String S_OriPayIntegral = "ORI_PAY_INTEGRAL";
	public final static String S_OriPayCash = "ORI_PAY_CASH";
	public final static String S_CurPayIntegral = "CUR_PAY_INTEGRAL";
	public final static String S_CurPayCash = "CUR_PAY_CASH";
	public final static String S_WarePayType = "WARE_PAY_TYPE";

  public final static  String S_Channel = "CHANNEL";
  public final static  String S_StarLevel = "STAR_LEVEL";
	  
	public String getWarePayType();
	public void setWarePayType(String value);
	
	public String getPayType();
	public void setPayType(String value);
	
	public long getOriPayIntegral();
	public void setOriPayIntegral(long value);
	
	public long getOriPayCash();
	public void setOriPayCash(long value);
	
	public long getCurPayIntegral();
	public void setCurPayIntegral(long value);
	
	public long getCurPayCash();
	public void setCurPayCash(long value);


public String getMainPic();

public String getWareName();

public String getUrl();

public String getName();

public long getDiscount();

public long getTuanId();

public Timestamp getEndTime();

public Timestamp getStartTime();

public long getOriIntegral();

public long getCurIntegral();

public long getTopFlag();

public String getChannel();
public String getStarLevel();

public  void setChannel(String value);
public  void setStarLevel(String value);


public  void setMainPic(String value);

public  void setWareName(String value);

public  void setUrl(String value);

public  void setName(String value);

public  void setDiscount(long value);

public  void setTuanId(long value);

public  void setEndTime(Timestamp value);

public  void setStartTime(Timestamp value);

public  void setOriIntegral(long value);

public void setCurIntegral(long value);

public void setTopFlag(long value);

}
