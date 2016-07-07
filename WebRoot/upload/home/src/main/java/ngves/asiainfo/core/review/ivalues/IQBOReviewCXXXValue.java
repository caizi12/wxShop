package ngves.asiainfo.core.review.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IQBOReviewCXXXValue extends DataStructInterface{

  public final static  String S_KindName = "KIND_NAME";
  public final static  String S_DiscountValue = "DISCOUNT_VALUE";
  public final static  String S_BegTime = "BEG_TIME";
  public final static  String S_Discount = "DISCOUNT";
  public final static  String S_PayIntegral = "PAY_INTEGRAL";
  public final static  String S_MobileBrandCode = "MOBILE_BRAND_CODE";
  public final static  String S_PartnerName = "PARTNER_NAME";
  public final static  String S_EndTime = "END_TIME";
  public final static  String S_NewPayIntegral = "NEW_PAY_INTEGRAL";
  public final static  String S_WareName = "WARE_NAME";
  public final static  String S_WareBrandName = "WARE_BRAND_NAME";
  public final static  String S_WareCode = "WARE_CODE";
  public final static  String S_NewPayCash= "NEW_PAY_CASH";
  public final static  String S_PayCash = "PAY_CASH";
  public final static  String S_DiscountName = "DISCOUNT_NAME";
  public final static  String S_WareIntegralValue = "WARE_INTEGRAL_VALUE";
  public final static  String S_PayType="PAY_TYPE";
  public final static  String S_Channel="CHANNEL";

public String getChannel();  
public  void setChannel(String value); 
  
public String getKindName();

public long getDiscountValue();

public String getBegTime();

public long getDiscount();

public long getPayIntegral();

public String getMobileBrandCode();

public String getPartnerName();

public String getEndTime();

public long getNewPayIntegral();

public String getWareName();

public String getWareBrandName();

public String getWareCode();

public long getNewPayCash();

public long getPayCash();

public String getDiscountName();

public long getWareIntegralValue();

public String getPayType();

public  void setPayType(String value);

public  void setKindName(String value);

public  void setDiscountValue(long value);

public  void setBegTime(String value);

public  void setDiscount(long value);

public  void setPayIntegral(long value);

public  void setMobileBrandCode(String value);

public  void setPartnerName(String value);

public  void setEndTime(String value);

public  void setNewPayIntegral(long value);

public  void setWareName(String value);

public  void setWareBrandName(String value);

public  void setWareCode(String value);

public  void setNewPayCash(long value);

public  void setPayCash(long value);

public  void setDiscountName(String value);

public  void setWareIntegralValue(long value);
}
