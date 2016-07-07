package ngves.asiainfo.core.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IUserBaseValue extends DataStructInterface{

  public final static  String S_SparePhone = "SPARE_PHONE";
  public final static  String S_UpdateDate = "UPDATE_DATE";
  public final static  String S_SparePhone2 = "SPARE_PHONE2";
  public final static  String S_SpareMail = "SPARE_MAIL";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_UserMobile = "USER_MOBILE";
  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_OftenMail = "OFTEN_MAIL";
  public final static  String S_Nickname = "NICKNAME";
  public final static  String S_Remark = "REMARK";


public String getSparePhone();

public Timestamp getUpdateDate();

public String getSparePhone2();

public String getSpareMail();

public String getBakCol2();

public long getUserMobile();

public String getBakCol3();

public String getBakCol1();

public Timestamp getCreateDate();

public String getOftenMail();

public String getNickname();

public String getRemark();


public  void setSparePhone(String value);

public  void setUpdateDate(Timestamp value);

public  void setSparePhone2(String value);

public  void setSpareMail(String value);

public  void setBakCol2(String value);

public  void setUserMobile(long value);

public  void setBakCol3(String value);

public  void setBakCol1(String value);

public  void setCreateDate(Timestamp value);

public  void setOftenMail(String value);

public  void setNickname(String value);

public  void setRemark(String value);
}
