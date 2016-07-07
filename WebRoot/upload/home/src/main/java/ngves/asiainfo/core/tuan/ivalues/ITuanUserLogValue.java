package ngves.asiainfo.core.tuan.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ITuanUserLogValue extends DataStructInterface{

  public final static  String S_TuanUserLogId = "TUAN_USER_LOG_ID";
  public final static  String S_CustomerBrand = "CUSTOMER_BRAND";
  public final static  String S_OrderNum = "ORDER_NUM";
  public final static  String S_ProvinceCode = "PROVINCE_CODE";
  public final static  String S_BakCok = "BAK_COK";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_MobileNumber = "MOBILE_NUMBER";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_TuanId = "TUAN_ID";


public long getTuanUserLogId();

public String getCustomerBrand();

public long getOrderNum();

public String getProvinceCode();

public String getBakCok();

public String getOrderId();

public String getMobileNumber();

public Timestamp getCreateDate();

public long getTuanId();


public  void setTuanUserLogId(long value);

public  void setCustomerBrand(String value);

public  void setOrderNum(long value);

public  void setProvinceCode(String value);

public  void setBakCok(String value);

public  void setOrderId(String value);

public  void setMobileNumber(String value);

public  void setCreateDate(Timestamp value);

public  void setTuanId(long value);
}
