package ngves.asiainfo.core.system.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IPageRefreshShowValue extends DataStructInterface{

  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_PageId = "PAGE_ID";
  public final static  String S_ShUrl = "SH_URL";
  public final static  String S_PageType = "PAGE_TYPE";
  public final static  String S_PageName = "PAGE_NAME";
  public final static  String S_Note = "NOTE";


public String getBakCol2();

public String getBakCol3();

public String getBakCol1();

public long getPageId();

public String getShUrl();

public String getPageType();

public String getPageName();

public String getNote();


public  void setBakCol2(String value);

public  void setBakCol3(String value);

public  void setBakCol1(String value);

public  void setPageId(long value);

public  void setShUrl(String value);

public  void setPageType(String value);

public  void setPageName(String value);

public  void setNote(String value);
}
