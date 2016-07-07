package ngves.asiainfo.core.rushbuy.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IQBOMainImageInfoValue extends DataStructInterface{

  public final static  String S_FileName = "FILE_NAME";
  public final static  String S_WareId = "WARE_ID";


public String getFileName();

public long getWareId();


public  void setFileName(String value);

public  void setWareId(long value);
}
