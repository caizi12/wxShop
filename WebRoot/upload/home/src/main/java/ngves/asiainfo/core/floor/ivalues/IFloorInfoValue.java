package ngves.asiainfo.core.floor.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IFloorInfoValue extends DataStructInterface{

  public final static  String S_AdImgHref = "AD_IMG_HREF";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_TabsNum = "TABS_NUM";
  public final static  String S_FloorId = "FLOOR_ID";
  public final static  String S_IsShowSubKind = "IS_SHOW_SUB_KIND";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_FloorImgHref = "FLOOR_IMG_HREF";
  public final static  String S_FloorImgUrl = "FLOOR_IMG_URL";
  public final static  String S_AdImgUrl = "AD_IMG_URL";
  public final static  String S_IsContainAd = "IS_CONTAIN_AD";
  public final static  String S_FloorName = "FLOOR_NAME";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_FloorSort = "FLOOR_SORT";
  public final static  String S_IsHomeShow = "IS_HOME_SHOW";
  public final static  String S_AdBackColor = "AD_BACK_COLOR";


public String getAdImgHref();

public String getAdBackColor();

public String getBakCol2();

public String getBakCol1();

public long getTabsNum();

public long getFloorId();

public String getIsShowSubKind();

public Timestamp getModifyDate();

public String getFloorImgHref();

public String getFloorImgUrl();

public String getAdImgUrl();

public String getIsContainAd();

public String getFloorName();

public Timestamp getCreateDate();

public String getFloorSort();

public String getIsHomeShow();


public  void setAdImgHref(String value);

public  void setAdBackColor(String value);

public  void setBakCol2(String value);

public  void setBakCol1(String value);

public  void setTabsNum(long value);

public  void setFloorId(long value);

public  void setIsShowSubKind(String value);

public  void setModifyDate(Timestamp value);

public  void setFloorImgHref(String value);

public  void setFloorImgUrl(String value);

public  void setAdImgUrl(String value);

public  void setIsContainAd(String value);

public  void setFloorName(String value);

public  void setCreateDate(Timestamp value);

public  void setFloorSort(String value);

public  void setIsHomeShow(String value);
}
