package ngves.asiainfo.core.ware.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IQBOWareChildInfoValue extends DataStructInterface{

  public final static  String S_Smscode = "SMSCODE";
  public final static  String S_Viewsms = "VIEWSMS";
  public final static  String S_ChildProperties = "CHILD_PROPERTIES";
  public final static  String S_MarketPrice = "MARKET_PRICE";
  public final static  String S_WareCode = "WARE_CODE";
  public final static  String S_WareId = "WARE_ID";
  public final static  String S_BusiId = "BUSI_ID";
  public final static  String S_OriginalValue = "ORIGINAL_VALUE";
  public final static  String S_ShopPrice = "SHOP_PRICE";
  public final static  String S_CountValue = "COUNT_VALUE";
  
//--------------增加税率类型和税率--------------
  public final static String S_TaxTypeId = "TAXTYPE_ID";
  public final static String S_TaxRateId = "TAXRATE_ID";
  
  //-----------增加映射编码------------
  public final static String S_MappingCode = "MAPPING_CODE";

  public final static String S_PayType = "PAY_TYPE";
  public final static String S_OriPayCash = "ORI_PAY_CASH";
  public final static String S_OriPayIntegral = "ORI_PAY_INTEGRAL";
  public final static String S_BakCol = "BAK_COL";

public String getSmscode();

public String getViewsms();

public String getChildProperties();

public long getMarketPrice();

public String getWareCode();

public long getWareId();

public long getOriginalValue();

public long getShopPrice();

public long getCountValue();

public long getBusiId();

public String getPayType();
public long getOriPayCash();
public long getOriPayIntegral();
public String getBakCol();

public  void setPayType(String value);
public  void setOriPayCash(long value);
public  void setOriPayIntegral(long value);
public  void setBakCol(String value);

public  void setSmscode(String value);

public  void setViewsms(String value);

public  void setChildProperties(String value);

public  void setMarketPrice(long value);

public  void setWareCode(String value);

public  void setWareId(long value);

public  void setOriginalValue(long value);

public  void setShopPrice(long value);

public  void setCountValue(long value);

public  void setBusiId(long value);

//--------------------税率类型和税率-----------
public long getTaxTypeId();
public long getTaxRateId();
public void setTaxTypeId(long value);
public void setTaxRateId(long value);

//------------映射编码-------------
public String getMappingCode();
public void setMappingCode(String value);
}
