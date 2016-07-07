package ngves.asiainfo.core.review.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IQBOReviewHZSKHValue extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_Name = "NAME";
  public final static  String S_ExamType = "EXAM_TYPE";
  public final static  String S_ValidDate = "VALID_DATE";
  public final static  String S_UpdateDate = "UPDATE_DATE";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Code = "CODE";


public String getState();

public String getName();

public String getExamType();

public String getValidDate();

public String getUpdateDate();

public String getCreateDate();

public String getCode();


public  void setState(String value);

public  void setName(String value);

public  void setExamType(String value);

public  void setValidDate(String value);

public  void setUpdateDate(String value);

public  void setCreateDate(String value);

public  void setCode(String value);
}
