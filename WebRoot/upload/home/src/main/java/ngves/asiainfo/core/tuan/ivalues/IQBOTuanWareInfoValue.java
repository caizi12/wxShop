package ngves.asiainfo.core.tuan.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IQBOTuanWareInfoValue extends DataStructInterface{

  public final static  String S_KindName = "KIND_NAME";
  public final static  String S_KindCode = "KIND_CODE";
  public final static  String S_MzoneValue = "MZONE_VALUE";
  public final static  String S_WareStatus = "WARE_STATUS";
  public final static  String S_WareStorageType = "WARE_STORAGE_TYPE";
  public final static  String S_EasyownValue = "EASYOWN_VALUE";
  public final static  String S_PartnerName = "PARTNER_NAME";
  public final static  String S_WareName = "WARE_NAME";
  public final static  String S_WareCode = "WARE_CODE";
  public final static  String S_ProvinceCode = "PROVINCE_CODE";
  public final static  String S_PartnerCode = "PARTNER_CODE";
  public final static  String S_WareId = "WARE_ID";
  public final static  String S_GozoneValue = "GOZONE_VALUE";
  public final static  String S_WareIntegralValue = "WARE_INTEGRAL_VALUE";
  public final static  String S_PayType = "PAY_TYPE";
  public final static  String S_PayIntegral = "PAY_INTEGRAL";
  public final static  String S_PayCash = "PAY_CASH";


public String getKindName();

public String getKindCode();

public long getMzoneValue();

public String getWareStatus();

public String getWareStorageType();

public long getEasyownValue();

public String getPartnerName();

public String getWareName();

public String getWareCode();

public String getProvinceCode();

public String getPartnerCode();

public long getWareId();

public long getGozoneValue();

public long getWareIntegralValue();

public String getPayType();

public long getPayIntegral();

public long getPayCash();


public  void setKindName(String value);

public  void setKindCode(String value);

public  void setMzoneValue(long value);

public  void setWareStatus(String value);

public  void setWareStorageType(String value);

public  void setEasyownValue(long value);

public  void setPartnerName(String value);

public  void setWareName(String value);

public  void setWareCode(String value);

public  void setProvinceCode(String value);

public  void setPartnerCode(String value);

public  void setWareId(long value);

public  void setGozoneValue(long value);

public  void setWareIntegralValue(long value);

public  void setPayType(String value);

public  void setPayIntegral(long value);

public  void setPayCash(long value);
}
