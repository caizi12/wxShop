package ngves.asiainfo.core.review.ivalues;
import com.ai.appframe2.common.DataStructInterface;

public interface IQBOReviewPSBLValue extends DataStructInterface{

  public final static  String S_WarehouseState = "WAREHOUSE_STATE";
  public final static  String S_PartnerName = "PARTNER_NAME";
  public final static  String S_WarehouseName = "WAREHOUSE_NAME";
  public final static  String S_AllPercent = "ALL_PERCENT";
  public final static  String S_ProvinceName = "PROVINCE_NAME";
  public final static  String S_CurStatus = "CUR_STATUS";


public String getWarehouseState();

public String getPartnerName();

public String getWarehouseName();

public String getAllPercent();

public String getProvinceName();

public String getCurStatus();


public  void setWarehouseState(String value);

public  void setPartnerName(String value);

public  void setWarehouseName(String value);

public  void setAllPercent(String value);

public  void setProvinceName(String value);

public  void setCurStatus(String value);
}
