package ngves.asiainfo.core.tuan.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IQBOTuanWareIntegralValue extends DataStructInterface{

  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_OriIntegral = "ORI_INTEGRAL";
  public final static  String S_TuanWareRltId = "TUAN_WARE_RLT_ID";
  public final static  String S_Name = "NAME";
  public final static  String S_TuanId = "TUAN_ID";
  public final static  String S_WareName = "WARE_NAME";
  public final static  String S_BindDate = "BIND_DATE";
  public final static  String S_CurPayCash = "CUR_PAY_CASH";
  public final static  String S_OriPayCash = "ORI_PAY_CASH";
  public final static  String S_OriPayIntegral = "ORI_PAY_INTEGRAL";
  public final static  String S_WareId = "WARE_ID";
  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_CurIntegral = "CUR_INTEGRAL";
  public final static  String S_WarePayType = "WARE_PAY_TYPE";
  public final static  String S_CurPayIntegral = "CUR_PAY_INTEGRAL";
  public final static  String S_Discount = "DISCOUNT";
  public final static  String S_Status = "STATUS";


  public String getStatus();
  
public String getBakCol2();

public long getOriIntegral();

public long getTuanWareRltId();

public String getName();

public long getTuanId();

public String getWareName();

public Timestamp getBindDate();

public long getCurPayCash();

public long getOriPayCash();

public long getOriPayIntegral();

public long getWareId();

public String getBakCol();

public long getCurIntegral();

public String getWarePayType();

public long getCurPayIntegral();

public long getDiscount();


public  void setBakCol2(String value);

public  void setOriIntegral(long value);

public  void setTuanWareRltId(long value);

public  void setName(String value);

public  void setTuanId(long value);

public  void setWareName(String value);

public  void setBindDate(Timestamp value);

public  void setCurPayCash(long value);

public  void setOriPayCash(long value);

public  void setOriPayIntegral(long value);

public  void setWareId(long value);

public  void setBakCol(String value);

public  void setCurIntegral(long value);

public  void setWarePayType(String value);

public  void setCurPayIntegral(long value);

public  void setDiscount(long value);

public void setStatus(String value);
}
