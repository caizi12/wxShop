package ngves.asiainfo.core.tuan.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IJfinterOrdersInfoValue extends DataStructInterface{

  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_ItemCount = "ITEM_COUNT";
  public final static  String S_JfinterOrdersInfoId = "JFINTER_ORDERS_INFO_ID";
  public final static  String S_TuanId = "TUAN_ID";


public String getBakCol();

public String getBakCol2();

public long getItemCount();

public long getJfinterOrdersInfoId();

public long getTuanId();


public  void setBakCol(String value);

public  void setBakCol2(String value);

public  void setItemCount(long value);

public  void setJfinterOrdersInfoId(long value);

public  void setTuanId(long value);
}
