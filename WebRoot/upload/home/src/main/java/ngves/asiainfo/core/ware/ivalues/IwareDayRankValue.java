package ngves.asiainfo.core.ware.ivalues;
import java.sql.Timestamp;

import com.ai.appframe2.common.DataStructInterface;
public interface IwareDayRankValue extends DataStructInterface{

  public final static  String S_WareBrandId = "WARE_BRAND_ID";
  public final static  String S_ExchangeDay = "EXCHANGE_DAY";
  public final static  String S_ExchangeCount = "EXCHANGE_COUNT";
  public final static  String S_WareId = "WARE_ID";
  public final static  String S_WareDayRankId = "WARE_DAY_RANK_ID";
  public final static  String S_ExchangeChannel = "EXCHANGE_CHANNEL";


public long getWareBrandId();

public Timestamp getExchangeDay();

public long getExchangeCount();

public long getWareId();

public long getWareDayRankId();

public String getExchangeChannel();


public  void setWareBrandId(long value);

public  void setExchangeDay(Timestamp value);

public  void setExchangeCount(long value);

public  void setWareId(long value);

public  void setWareDayRankId(long value);

public  void setExchangeChannel(String value);
}
