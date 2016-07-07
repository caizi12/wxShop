package ngves.asiainfo.core.donated.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IDistributionInfoValue extends DataStructInterface{

  public final static  String S_Phone = "PHONE";
  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_ZipCode = "ZIP_CODE";
  public final static  String S_CountyCode = "COUNTY_CODE";
  public final static  String S_CityCode = "CITY_CODE";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_Address = "ADDRESS";
  public final static  String S_Email = "EMAIL";
  public final static  String S_ProvinceCode = "PROVINCE_CODE";
  public final static  String S_DistributionId = "DISTRIBUTION_ID";


public long getPhone();

public String getBakCol();

public long getZipCode();

public String getCountyCode();

public String getCityCode();

public String getBakCol2();

public String getAddress();

public String getEmail();

public String getProvinceCode();

public long getDistributionId();


public  void setPhone(long value);

public  void setBakCol(String value);

public  void setZipCode(long value);

public  void setCountyCode(String value);

public  void setCityCode(String value);

public  void setBakCol2(String value);

public  void setAddress(String value);

public  void setEmail(String value);

public  void setProvinceCode(String value);

public  void setDistributionId(long value);
}
