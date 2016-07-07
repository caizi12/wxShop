package ngves.asiainfo.core.review.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IQBOReviewLPXXValue extends DataStructInterface{

  public final static  String S_PriorityOnline = "PRIORITY_ONLINE";
  public final static  String S_WareName = "WARE_NAME";
  public final static  String S_BigKindName = "BIG_KIND_NAME";
  public final static  String S_MarketPrice = "MARKET_PRICE";
  public final static  String S_WareIntegralValue = "WARE_INTEGRAL_VALUE";
  public final static  String S_WareId = "WARE_ID";
  public final static  String S_FName = "F_NAME";
  public final static  String S_PartnerCode = "PARTNER_CODE";
  public final static  String S_CountValue = "COUNT_VALUE";
  public final static  String S_PartnerName = "PARTNER_NAME";
  public final static  String S_PriorityOffline = "PRIORITY_OFFLINE";
  public final static  String S_KindName = "KIND_NAME";
  public final static  String S_WareCode = "WARE_CODE";


public String getPriorityOnline();

public String getWareName();

public String getBigKindName();

public long getMarketPrice();

public long getWareIntegralValue();

public long getWareId();

public String getFName();

public String getPartnerCode();

public long getCountValue();

public String getPartnerName();

public String getPriorityOffline();

public String getKindName();

public String getWareCode();


public  void setPriorityOnline(String value);

public  void setWareName(String value);

public  void setBigKindName(String value);

public  void setMarketPrice(long value);

public  void setWareIntegralValue(long value);

public  void setWareId(long value);

public  void setFName(String value);

public  void setPartnerCode(String value);

public  void setCountValue(long value);

public  void setPartnerName(String value);

public  void setPriorityOffline(String value);

public  void setKindName(String value);

public  void setWareCode(String value);
}
