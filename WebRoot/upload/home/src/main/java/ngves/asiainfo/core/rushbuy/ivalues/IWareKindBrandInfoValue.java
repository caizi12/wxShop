package ngves.asiainfo.core.rushbuy.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IWareKindBrandInfoValue extends DataStructInterface{

  public final static  String S_WareBrandId = "WARE_BRAND_ID";
  public final static  String S_WareBrandName = "WARE_BRAND_NAME";
  public final static  String S_WareId = "WARE_ID";
  public final static  String S_WareKindId = "WARE_KIND_ID";


public long getWareBrandId();

public String getWareBrandName();

public long getWareId();

public long getWareKindId();


public  void setWareBrandId(long value);

public  void setWareBrandName(String value);

public  void setWareId(long value);

public  void setWareKindId(long value);
}
