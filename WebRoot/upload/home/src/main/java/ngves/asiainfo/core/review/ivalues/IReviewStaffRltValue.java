package ngves.asiainfo.core.review.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IReviewStaffRltValue extends DataStructInterface{

  public final static  String S_Bak1 = "BAK1";
  public final static  String S_StaffId = "STAFF_ID";
  public final static  String S_ReviewStaffId = "REVIEW_STAFF_ID";
  public final static  String S_ReviewDescId = "REVIEW_DESC_ID";
  public final static  String S_UpdateDate = "UPDATE_DATE";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Status = "STATUS";


public String getBak1();

public long getStaffId();

public long getReviewStaffId();

public long getReviewDescId();

public Timestamp getUpdateDate();

public Timestamp getCreateDate();

public String getStatus();


public  void setBak1(String value);

public  void setStaffId(long value);

public  void setReviewStaffId(long value);

public  void setReviewDescId(long value);

public  void setUpdateDate(Timestamp value);

public  void setCreateDate(Timestamp value);

public  void setStatus(String value);
}
