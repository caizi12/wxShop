package ngves.asiainfo.core.review.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IQBOReviewTGXXValue extends DataStructInterface{

  public final static  String S_OriPayCash = "ORI_PAY_CASH";
  public final static  String S_IsOrderMulti = "IS_ORDER_MULTI";
  public final static  String S_Discount = "DISCOUNT";
  public final static  String S_CurPayIntegral = "CUR_PAY_INTEGRAL";
  public final static  String S_MaxCount = "MAX_COUNT";
  public final static  String S_CurPayCash = "CUR_PAY_CASH";
  public final static  String S_LimitProv = "LIMIT_PROV";
  public final static  String S_MinCount = "MIN_COUNT";
  public final static  String S_OneMaxCount = "ONE_MAX_COUNT";
  public final static  String S_IsAllProv = "IS_ALL_PROV";
  public final static  String S_EndTime = "END_TIME";
  public final static  String S_WareName = "WARE_NAME";
  public final static  String S_StartTime = "START_TIME";
  public final static  String S_Channel = "CHANNEL";
  public final static  String S_Name = "NAME";
  public final static  String S_WareIntegralValue = "WARE_INTEGRAL_VALUE";
  public final static  String S_IsView = "IS_VIEW";

  public final static  String S_CurIntegral = "CUR_INTEGRAL";
  public final static  String S_OriPayIntegrale = "ori_pay_integral";
  
  public long getCurIntegral();
  public void setCurIntegral(long value);
  
  public long getOriPayIntegrale();
  public void setOriPayIntegrale(long value);
  
public long getOriPayCash();



public String getIsOrderMulti();

public long getDiscount();

public long getCurPayIntegral();

public long getMaxCount();

public long getCurPayCash();

public String getLimitProv();

public long getMinCount();

public long getOneMaxCount();

public String getIsAllProv();

public String getEndTime();

public String getWareName();

public String getStartTime();

public String getChannel();

public String getName();

public long getWareIntegralValue();

public String getIsView();


public  void setOriPayCash(long value);


public  void setIsOrderMulti(String value);

public  void setDiscount(long value);

public  void setCurPayIntegral(long value);

public  void setMaxCount(long value);

public  void setCurPayCash(long value);

public  void setLimitProv(String value);

public  void setMinCount(long value);

public  void setOneMaxCount(long value);

public  void setIsAllProv(String value);

public  void setEndTime(String value);

public  void setWareName(String value);

public  void setStartTime(String value);

public  void setChannel(String value);

public  void setName(String value);

public  void setWareIntegralValue(long value);

public  void setIsView(String value);
}
