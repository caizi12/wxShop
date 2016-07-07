package ngves.asiainfo.core.review.ivalues;
import com.ai.appframe2.common.DataStructInterface;

public interface IQBOReviewPSXXValue extends DataStructInterface{

  public final static  String S_SendDays = "SEND_DAYS";
  public final static  String S_CountyName = "COUNTY_NAME";
  public final static  String S_WarehouseName = "WAREHOUSE_NAME";
  public final static  String S_CityName = "CITY_NAME";
  public final static  String S_SendPrice = "SEND_PRICE";
  public final static  String S_PartnerCode = "PARTNER_CODE";
  public final static  String S_ProvinceName = "PROVINCE_NAME";
  public final static  String S_PartnerName = "PARTNER_NAME";


public long getSendDays();

public String getCountyName();

public String getWarehouseName();

public String getCityName();

public String getSendPrice();

public String getPartnerCode();

public String getProvinceName();

public String getPartnerName();


public  void setSendDays(long value);

public  void setCountyName(String value);

public  void setWarehouseName(String value);

public  void setCityName(String value);

public  void setSendPrice(String value);

public  void setPartnerCode(String value);

public  void setProvinceName(String value);

public  void setPartnerName(String value);
}
