package ngves.asiainfo.core.helpcenter.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IHelpCenterinfoValue extends DataStructInterface{

  public final static  String S_UpdateTime = "UPDATE_TIME";
  public final static  String S_SortId = "SORT_ID";
  public final static  String S_MenuName = "MENU_NAME";
  public final static  String S_ParentHelpId = "PARENT_HELP_ID";
  public final static  String S_HelpCentreId = "HELP_CENTRE_ID";
  public final static  String S_IsShow = "IS_SHOW";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_HelpContent = "HELP_CONTENT";


public Timestamp getUpdateTime();

public long getSortId();

public String getMenuName();

public long getParentHelpId();

public long getHelpCentreId();

public String getIsShow();

public String getBakCol2();

public Timestamp getCreateTime();

public String getBakCol1();

public String getHelpContent();


public  void setUpdateTime(Timestamp value);

public  void setSortId(long value);

public  void setMenuName(String value);

public  void setParentHelpId(long value);

public  void setHelpCentreId(long value);

public  void setIsShow(String value);

public  void setBakCol2(String value);

public  void setCreateTime(Timestamp value);

public  void setBakCol1(String value);

public  void setHelpContent(String value);
}
