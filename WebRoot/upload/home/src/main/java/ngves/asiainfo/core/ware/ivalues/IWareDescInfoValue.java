package ngves.asiainfo.core.ware.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IWareDescInfoValue extends DataStructInterface{

  public final static  String S_IsGroupFlag = "IS_GROUP_FLAG";
  public final static  String S_SortId = "SORT_ID";
  public final static  String S_DescDefineId = "DESC_DEFINE_ID";
  public final static  String S_WareDescId = "WARE_DESC_ID";
  public final static  String S_AppVersion = "APP_VERSION";
  public final static  String S_WareDescValue = "WARE_DESC_VALUE";
  public final static  String S_WareId = "WARE_ID";


public String getIsGroupFlag();

public long getSortId();

public long getDescDefineId();

public long getWareDescId();

public long getAppVersion();

public String getWareDescValue();

public long getWareId();


public  void setIsGroupFlag(String value);

public  void setSortId(long value);

public  void setDescDefineId(long value);

public  void setWareDescId(long value);

public  void setAppVersion(long value);

public  void setWareDescValue(String value);

public  void setWareId(long value);
}
