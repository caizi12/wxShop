package ngves.asiainfo.core.check.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IQBOCheckWareOnOrOffLineValue extends DataStructInterface{

  public final static  String S_Wamount = "WAMOUNT";
  public final static  String S_WareStatus = "WARE_STATUS";
  public final static  String S_FName = "F_NAME";
  public final static  String S_StatusCause = "STATUS_CAUSE";
  public final static  String S_WkKindName = "WK_KIND_NAME";
  public final static  String S_KpBigKindName = "KP_BIG_KIND_NAME";
  public final static  String S_AllegeCount = "ALLEGE_COUNT";
  public final static  String S_CountValue = "COUNT_VALUE";
  public final static  String S_PartnerName = "PARTNER_NAME";
  public final static  String S_AllegeCountRate = "ALLEGE_COUNT_RATE";
  public final static  String S_WamountCountValue = "WAMOUNT_COUNT_VALUE";
  public final static  String S_WareName = "WARE_NAME";
  public final static  String S_MarketPrice = "MARKET_PRICE";
  public final static  String S_WareCode = "WARE_CODE";
  public final static  String S_PartnerCode = "PARTNER_CODE";
  public final static  String S_WkiKindName = "WKI_KIND_NAME";


public long getWamount();

public String getWareStatus();

public String getFName();

public String getStatusCause();

public String getWkKindName();

public String getKpBigKindName();

public long getAllegeCount();

public long getCountValue();

public String getPartnerName();

public long getAllegeCountRate();

public long getWamountCountValue();

public String getWareName();

public long getMarketPrice();

public String getWareCode();

public String getPartnerCode();

public String getWkiKindName();


public  void setWamount(long value);

public  void setWareStatus(String value);

public  void setFName(String value);

public  void setStatusCause(String value);

public  void setWkKindName(String value);

public  void setKpBigKindName(String value);

public  void setAllegeCount(long value);

public  void setCountValue(long value);

public  void setPartnerName(String value);

public  void setAllegeCountRate(long value);

public  void setWamountCountValue(long value);

public  void setWareName(String value);

public  void setMarketPrice(long value);

public  void setWareCode(String value);

public  void setPartnerCode(String value);

public  void setWkiKindName(String value);
}
