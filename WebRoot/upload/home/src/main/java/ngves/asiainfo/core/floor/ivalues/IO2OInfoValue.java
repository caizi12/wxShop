package ngves.asiainfo.core.floor.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IO2OInfoValue extends DataStructInterface{

  public final static  String S_O2oId = "O2O_ID";
  public final static  String S_O2oName = "O2O_NAME";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_O2oType = "O2O_TYPE";
  public final static  String S_O2oImgUrl = "O2O_IMG_URL";
  public final static  String S_O2oContent = "O2O_CONTENT";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_IsHomeShow = "IS_HOME_SHOW";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Sort = "SORT";


public long getO2oId();

public String getO2oName();

public Timestamp getModifyDate();

public String getO2oType();

public String getO2oImgUrl();

public String getO2oContent();

public String getBakCol1();

public String getIsHomeShow();

public Timestamp getCreateDate();

public String getSort();


public  void setO2oId(long value);

public  void setO2oName(String value);

public  void setModifyDate(Timestamp value);

public  void setO2oType(String value);

public  void setO2oImgUrl(String value);

public  void setO2oContent(String value);

public  void setBakCol1(String value);

public  void setIsHomeShow(String value);

public  void setCreateDate(Timestamp value);

public  void setSort(String value);
}
