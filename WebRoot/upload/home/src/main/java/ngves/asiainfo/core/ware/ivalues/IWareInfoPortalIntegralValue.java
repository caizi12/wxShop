package ngves.asiainfo.core.ware.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IWareInfoPortalIntegralValue extends DataStructInterface{

  public final static  String S_Channel = "CHANNEL";
  public final static  String S_CurIntegral = "CUR_INTEGRAL";
  public final static  String S_OriIntegral = "ORI_INTEGRAL";
  public final static  String S_StarLevel = "STAR_LEVEL";
  public final static  String S_Id = "ID";
  public final static  String S_CurPayCash = "CUR_PAY_CASH";
  public final static  String S_OriPayCash = "ORI_PAY_CASH";
  public final static  String S_OriPayIntegral = "ORI_PAY_INTEGRAL";
  public final static  String S_CurPayIntegral = "CUR_PAY_INTEGRAL";
  public final static  String S_WareId = "WARE_ID";


public String getChannel();

public long getCurIntegral();

public long getOriIntegral();

public String getStarLevel();

public long getId();

public long getCurPayCash();

public long getOriPayCash();

public long getOriPayIntegral();

public long getCurPayIntegral();

public long getWareId();


public  void setChannel(String value);

public  void setCurIntegral(long value);

public  void setOriIntegral(long value);

public  void setStarLevel(String value);

public  void setId(long value);

public  void setCurPayCash(long value);

public  void setOriPayCash(long value);

public  void setOriPayIntegral(long value);

public  void setCurPayIntegral(long value);

public  void setWareId(long value);
}
