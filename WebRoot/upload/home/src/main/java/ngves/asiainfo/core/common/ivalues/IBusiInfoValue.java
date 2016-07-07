package ngves.asiainfo.core.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBusiInfoValue extends DataStructInterface{

  public final static  String S_BusiInfoId = "BUSI_INFO_ID";
  public final static  String S_BusiStaffId = "BUSI_STAFF_ID";
  public final static  String S_BusiDate = "BUSI_DATE";
  public final static  String S_BusiId = "BUSI_ID";
  public final static  String S_BusiComType = "BUSI_COM_TYPE";
  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_OptObj = "OPT_OBJ";
  public final static  String S_Note = "NOTE";
  public final static  String S_BusiTypeId = "BUSI_TYPE_ID";
  public final static  String S_OptType = "OPT_TYPE";
  public final static  String S_BusiComId = "BUSI_COM_ID";


public long getBusiInfoId();

public long getBusiStaffId();

public Timestamp getBusiDate();

public long getBusiId();

public String getBusiComType();

public String getBakCol();

public String getOptObj();

public String getNote();

public String getBusiTypeId();

public String getOptType();

public long getBusiComId();


public  void setBusiInfoId(long value);

public  void setBusiStaffId(long value);

public  void setBusiDate(Timestamp value);

public  void setBusiId(long value);

public  void setBusiComType(String value);

public  void setBakCol(String value);

public  void setOptObj(String value);

public  void setNote(String value);

public  void setBusiTypeId(String value);

public  void setOptType(String value);

public  void setBusiComId(long value);
}
