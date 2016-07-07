package ngves.asiainfo.core.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface ISendPriceInfoValue extends DataStructInterface{

  public final static  String S_SendPriceInfoId = "SEND_PRICE_INFO_ID";
  public final static  String S_SendDays = "SEND_DAYS";
  public final static  String S_CountyCode = "COUNTY_CODE";
  public final static  String S_CityCode = "CITY_CODE";
  public final static  String S_PartnerId = "PARTNER_ID";
  public final static  String S_WarehouseId = "WAREHOUSE_ID";
  public final static  String S_SendPrice = "SEND_PRICE";
  public final static  String S_ProvinceCode = "PROVINCE_CODE";
  public final static  String S_LossPrice = "LOSS_PRICE";

public long getSendPriceInfoId();

public long getSendDays();

public String getCountyCode();

public String getCityCode();

public long getPartnerId();

public long getWarehouseId();

public float getSendPrice();

public String getProvinceCode();

public float getLossPrice();

public  void setSendPriceInfoId(long value);

public  void setSendDays(long value);

public  void setCountyCode(String value);

public  void setCityCode(String value);

public  void setPartnerId(long value);

public  void setWarehouseId(long value);

public  void setSendPrice(float value);

public  void setProvinceCode(String value);

public  void setLossPrice(float value);
}
