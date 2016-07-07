package ngves.asiainfo.core.rushbuy.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IActivityLimitGroupValue extends DataStructInterface{

  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_AlGroupTitle = "AL_GROUP_TITLE";
  public final static  String S_AlGroupId = "AL_GROUP_ID";
  public final static  String S_AlGroupCreate = "AL_GROUP_CREATE";


public String getBakCol();

public String getBakCol2();

public String getAlGroupTitle();

public long getAlGroupId();

public Timestamp getAlGroupCreate();


public  void setBakCol(String value);

public  void setBakCol2(String value);

public  void setAlGroupTitle(String value);

public  void setAlGroupId(long value);

public  void setAlGroupCreate(Timestamp value);
}
