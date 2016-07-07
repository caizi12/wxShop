package ngves.asiainfo.core.ware.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IQBOMergeBusiLeastWareCheckValue extends DataStructInterface{

  public final static  String S_WareBrandId = "WARE_BRAND_ID";
  public final static  String S_WareFirstKindId = "WARE_FIRST_KIND_ID";
  public final static  String S_Partner = "PARTNER";
  public final static  String S_BusiId = "BUSI_ID";
  public final static  String S_LastUpdateDate = "LAST_UPDATE_DATE";
  public final static  String S_WareStorageType = "WARE_STORAGE_TYPE";
  public final static  String S_BusiState = "BUSI_STATE";
  public final static  String S_WareKindParentId = "WARE_KIND_PARENT_ID";
  public final static  String S_CountValue = "COUNT_VALUE";
  public final static  String S_WareName = "WARE_NAME";
  public final static  String S_MarketPrice = "MARKET_PRICE";
  public final static  String S_WareCode = "WARE_CODE";
  public final static  String S_ProvinceCode = "PROVINCE_CODE";
  public final static  String S_WareType = "WARE_TYPE";
  public final static  String S_WareId = "WARE_ID";
  public final static  String S_DeliverType = "DELIVER_TYPE";
  public final static  String S_WareKindId = "WARE_KIND_ID";
  public final static  String S_WareKindInfoId = "WARE_KIND_INFO_ID";
  public final static  String S_WareKindInfoName = "WARE_KIND_INFO_NAME";

public long getWareKindInfoId();

public String getWareKindInfoName();
	
public  void setWareKindInfoId(long value);
	
public  void setWareKindInfoName(String value);

public long getWareBrandId();

public long getWareFirstKindId();

public long getPartner();

public long getBusiId();

public Timestamp getLastUpdateDate();

public String getWareStorageType();

public String getBusiState();

public long getWareKindParentId();

public long getCountValue();

public String getWareName();

public long getMarketPrice();

public String getWareCode();

public String getProvinceCode();

public long getWareType();

public long getWareId();

public String getDeliverType();

public long getWareKindId();


public  void setWareBrandId(long value);

public  void setWareFirstKindId(long value);

public  void setPartner(long value);

public  void setBusiId(long value);

public  void setLastUpdateDate(Timestamp value);

public  void setWareStorageType(String value);

public  void setBusiState(String value);

public  void setWareKindParentId(long value);

public  void setCountValue(long value);

public  void setWareName(String value);

public  void setMarketPrice(long value);

public  void setWareCode(String value);

public  void setProvinceCode(String value);

public  void setWareType(long value);

public  void setWareId(long value);

public  void setDeliverType(String value);

public  void setWareKindId(long value);
}
