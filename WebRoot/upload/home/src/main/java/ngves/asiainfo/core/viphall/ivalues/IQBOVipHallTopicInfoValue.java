package ngves.asiainfo.core.viphall.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IQBOVipHallTopicInfoValue extends DataStructInterface{

  public final static  String S_TypeCode = "TYPE_CODE";
  public final static  String S_TopicTitle = "TOPIC_TITLE";
  public final static  String S_KindCode = "KIND_CODE";
  public final static  String S_UpdateDate = "UPDATE_DATE";
  public final static  String S_TopicName = "TOPIC_NAME";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_TopicDescription = "TOPIC_DESCRIPTION";
  public final static  String S_MainPicFile = "MAIN_PIC_FILE";
  public final static  String S_TopicId = "TOPIC_ID";
  public final static  String S_TopicStatus = "TOPIC_STATUS";
  public final static  String S_StartDate = "START_DATE";
  public final static  String S_WareKindId = "WARE_KIND_ID";
  public final static  String S_EndDate = "END_DATE";


public long getTypeCode();

public String getTopicTitle();

public String getKindCode();

public Timestamp getUpdateDate();

public String getTopicName();

public Timestamp getCreateDate();

public String getTopicDescription();

public String getMainPicFile();

public long getTopicId();

public long getTopicStatus();

public Timestamp getStartDate();

public long getWareKindId();

public Timestamp getEndDate();


public  void setTypeCode(long value);

public  void setTopicTitle(String value);

public  void setKindCode(String value);

public  void setUpdateDate(Timestamp value);

public  void setTopicName(String value);

public  void setCreateDate(Timestamp value);

public  void setTopicDescription(String value);

public  void setMainPicFile(String value);

public  void setTopicId(long value);

public  void setTopicStatus(long value);

public  void setStartDate(Timestamp value);

public  void setWareKindId(long value);

public  void setEndDate(Timestamp value);
}
