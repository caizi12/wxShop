package ngves.asiainfo.core.ware.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IwareWeekRankValue extends DataStructInterface{

  public final static  String S_WareBrandId = "WARE_BRAND_ID";
  public final static  String S_WareIds = "WARE_IDS";
  public final static  String S_IsParent = "IS_PARENT";
  public final static  String S_WareWeekRankId = "WARE_WEEK_RANK_ID";


public long getWareBrandId();

public String getWareIds();

public long getIsParent();

public long getWareWeekRankId();


public  void setWareBrandId(long value);

public  void setWareIds(String value);

public  void setIsParent(long value);

public  void setWareWeekRankId(long value);
}
