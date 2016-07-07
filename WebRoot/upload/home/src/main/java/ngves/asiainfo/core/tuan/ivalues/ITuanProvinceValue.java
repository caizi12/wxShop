package ngves.asiainfo.core.tuan.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface ITuanProvinceValue extends DataStructInterface{

  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_TuanProvinceId = "TUAN_PROVINCE_ID";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_LimitProv = "LIMIT_PROV";
  public final static  String S_TuanId = "TUAN_ID";


public String getBakCol();

public long getTuanProvinceId();

public String getBakCol2();

public String getLimitProv();

public long getTuanId();


public  void setBakCol(String value);

public  void setTuanProvinceId(long value);

public  void setBakCol2(String value);

public  void setLimitProv(String value);

public  void setTuanId(long value);
}
