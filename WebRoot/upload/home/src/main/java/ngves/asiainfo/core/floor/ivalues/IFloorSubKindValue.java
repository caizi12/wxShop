package ngves.asiainfo.core.floor.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IFloorSubKindValue extends DataStructInterface{

  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_WareKindId = "WARE_KIND_ID";
  public final static  String S_FloorId = "FLOOR_ID";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_FloorSubName = "FLOOR_SUB_NAME";
  public final static  String S_FloorSubId = "FLOOR_SUB_ID";
  public final static  String S_ModifyDate = "MODIFY_DATE";


public String getBakCol1();

public long getWareKindId();

public long getFloorId();

public Timestamp getCreateDate();

public String getFloorSubName();

public long getFloorSubId();

public Timestamp getModifyDate();


public  void setBakCol1(String value);

public  void setWareKindId(long value);

public  void setFloorId(long value);

public  void setCreateDate(Timestamp value);

public  void setFloorSubName(String value);

public  void setFloorSubId(long value);

public  void setModifyDate(Timestamp value);
}
