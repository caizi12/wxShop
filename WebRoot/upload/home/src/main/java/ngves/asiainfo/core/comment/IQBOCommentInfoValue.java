package ngves.asiainfo.core.comment;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IQBOCommentInfoValue extends DataStructInterface{

  public final static  String S_WareFirstKindId = "WARE_FIRST_KIND_ID";
  public final static  String S_KindName = "KIND_NAME";
  public final static  String S_FName = "F_NAME";
  public final static  String S_BigKindName = "BIG_KIND_NAME";
  public final static  String S_Bak02 = "BAK_02";
  public final static  String S_CommentDate = "COMMENT_DATE";
  public final static  String S_CommentId = "COMMENT_ID";
  public final static  String S_WareKindParentId = "WARE_KIND_PARENT_ID";
  public final static  String S_WareName = "WARE_NAME";
  public final static  String S_PWareId = "P_WARE_ID";
  public final static  String S_CommentOriginal = "COMMENT_ORIGINAL";
  public final static  String S_WareCode = "WARE_CODE";
  public final static  String S_Bak01 = "BAK_01";
  public final static  String S_WareId = "WARE_ID";
  public final static  String S_MobilePhoneNo = "MOBILE_PHONE_NO";
  public final static  String S_WareKindId = "WARE_KIND_ID";
  public final static  String S_AuditFlag = "AUDIT_FLAG";
  public final static  String S_AuditStaffId = "AUDIT_STAFF_ID";
  public final static  String S_AuditTime = "AUDIT_TIME";
  public final static  String S_CommentValue = "COMMENT_VALUE";
//增加礼品大类id和name
  public final static  String S_WareKindInfoId = "WARE_KIND_INFO_ID";
  public final static  String S_WareKindInfoName = "WARE_KIND_INFO_NAME";

public long getWareKindInfoId();

public String getWareKindInfoName();
	
public  void setWareKindInfoId(long value);
	
public  void setWareKindInfoName(String value);

public long getWareFirstKindId();

public String getKindName();

public String getFName();

public String getBigKindName();

public String getBak02();

public Timestamp getCommentDate();

public long getCommentId();

public long getWareKindParentId();

public String getWareName();

public long getPWareId();

public String getCommentOriginal();

public String getWareCode();

public String getBak01();

public long getWareId();

public String getMobilePhoneNo();

public long getWareKindId();

public String getAuditFlag();

public long getAuditStaffId();

public Timestamp getAuditTime();

public long getCommentValue();


public  void setWareFirstKindId(long value);

public  void setKindName(String value);

public  void setFName(String value);

public  void setBigKindName(String value);

public  void setBak02(String value);

public  void setCommentDate(Timestamp value);

public  void setCommentId(long value);

public  void setWareKindParentId(long value);

public  void setWareName(String value);

public  void setPWareId(long value);

public  void setCommentOriginal(String value);

public  void setWareCode(String value);

public  void setBak01(String value);

public  void setWareId(long value);

public  void setMobilePhoneNo(String value);

public  void setWareKindId(long value);

public  void setAuditFlag(String value);

public  void setAuditStaffId(long value);

public  void setAuditTime(Timestamp value);

public  void setCommentValue(long value);
}
