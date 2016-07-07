package ngves.asiainfo.core.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IWareFirstKindRltValue extends DataStructInterface{

  public final static  String S_WareFirstKindRltId = "WARE_FIRST_KIND_RLT_ID";
  public final static  String S_WareKindParentId = "WARE_KIND_PARENT_ID";
  public final static  String S_SortId = "SORT_ID";
  public final static  String S_IsIndexNavView = "IS_INDEX_NAV_VIEW";
  public final static  String S_ShowChannelMid = "SHOW_CHANNEL_MID";
  public final static  String S_WareFirstKindId = "WARE_FIRST_KIND_ID";


public long getWareFirstKindRltId();

public long getWareKindParentId();

public long getSortId();

public String getIsIndexNavView();

public String getShowChannelMid();

public long getWareFirstKindId();


public  void setWareFirstKindRltId(long value);

public  void setWareKindParentId(long value);

public  void setSortId(long value);

public  void setIsIndexNavView(String value);

public  void setShowChannelMid(String value);

public  void setWareFirstKindId(long value);
}
