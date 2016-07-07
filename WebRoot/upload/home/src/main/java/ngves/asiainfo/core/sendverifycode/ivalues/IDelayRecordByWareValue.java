package ngves.asiainfo.core.sendverifycode.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IDelayRecordByWareValue extends DataStructInterface{

  public final static  String S_Days = "DAYS";
  public final static  String S_ExtendType = "EXTEND_TYPE";
  public final static  String S_OrderNum = "ORDER_NUM";
  public final static  String S_Comments = "COMMENTS";
  public final static  String S_Opera = "OPERA";
  public final static  String S_OrdOprEtime = "ORD_OPR_ETIME";
  public final static  String S_ItemId = "ITEM_ID";
  public final static  String S_OrdOprStime = "ORD_OPR_STIME";
  public final static  String S_OperateTime = "OPERATE_TIME";
  public final static  String S_ValidateStime = "VALIDATE_STIME";
  public final static  String S_ValidateEtime = "VALIDATE_ETIME";
  public final static  String S_ItemExtendId = "ITEM_EXTEND_ID";
  public final static  String S_NewValidateTime = "NEW_VALIDATE_TIME";


public long getDays();

public String getExtendType();

public long getOrderNum();

public String getComments();

public String getOpera();

public String getOrdOprEtime();

public String getItemId();

public String getOrdOprStime();

public String getOperateTime();

public String getValidateStime();

public String getValidateEtime();

public String getItemExtendId();

public String getNewValidateTime();


public  void setDays(long value);

public  void setExtendType(String value);

public  void setOrderNum(long value);

public  void setComments(String value);

public  void setOpera(String value);

public  void setOrdOprEtime(String value);

public  void setItemId(String value);

public  void setOrdOprStime(String value);

public  void setOperateTime(String value);

public  void setValidateStime(String value);

public  void setValidateEtime(String value);

public  void setItemExtendId(String value);

public  void setNewValidateTime(String value);
}
