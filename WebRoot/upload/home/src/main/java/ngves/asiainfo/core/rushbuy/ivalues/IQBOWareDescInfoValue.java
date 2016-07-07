package ngves.asiainfo.core.rushbuy.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IQBOWareDescInfoValue extends DataStructInterface{

  public final static  String S_SortId = "SORT_ID";
  public final static  String S_IsGroupFlag = "IS_GROUP_FLAG";
  public final static  String S_WareDescId = "WARE_DESC_ID";
  public final static  String S_WareId = "WARE_ID";
  public final static  String S_WareDescValue = "WARE_DESC_VALUE";
  public final static  String S_DescDefineId = "DESC_DEFINE_ID";


public long getSortId();

public String getIsGroupFlag();

public long getWareDescId();

public long getWareId();

public String getWareDescValue();

public long getDescDefineId();


public  void setSortId(long value);

public  void setIsGroupFlag(String value);

public  void setWareDescId(long value);

public  void setWareId(long value);

public  void setWareDescValue(String value);

public  void setDescDefineId(long value);
}
