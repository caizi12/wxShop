package ngves.asiainfo.core.floor.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface ITabsAreaInfoValue extends DataStructInterface{

  public final static  String S_AreaContentType = "AREA_CONTENT_TYPE";
  public final static  String S_AreaSort = "AREA_SORT";
  public final static  String S_TabsAreaId = "TABS_AREA_ID";
  public final static  String S_AreaImgUrl = "AREA_IMG_URL";
  public final static  String S_AreaContent = "AREA_CONTENT";
  public final static  String S_TabsId = "TABS_ID";


public long getAreaContentType();

public String getAreaSort();

public long getTabsAreaId();

public String getAreaImgUrl();

public String getAreaContent();

public long getTabsId();


public  void setAreaContentType(long value);

public  void setAreaSort(String value);

public  void setTabsAreaId(long value);

public  void setAreaImgUrl(String value);

public  void setAreaContent(String value);

public  void setTabsId(long value);
}
