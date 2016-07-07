package ngves.asiainfo.core.ware.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IQBOLogisticRuleHouseInfoValue extends DataStructInterface{

  public final static  String S_WarehouseType = "WAREHOUSE_TYPE";
  public final static  String S_AdminName = "ADMIN_NAME";
  public final static  String S_PackageFee = "PACKAGE_FEE";
  public final static  String S_WarehouseId = "WAREHOUSE_ID";
  public final static  String S_IsSettleUnit = "IS_SETTLE_UNIT";
  public final static  String S_AdminTel = "ADMIN_TEL";
  public final static  String S_WarehouseState = "WAREHOUSE_STATE";
  public final static  String S_WarehouseAddr = "WAREHOUSE_ADDR";
  public final static  String S_AdminMobilePhone = "ADMIN_MOBILE_PHONE";
  public final static  String S_WarehouseCode = "WAREHOUSE_CODE";
  public final static  String S_PostCode = "POST_CODE";
  public final static  String S_WarehouseName = "WAREHOUSE_NAME";
  public final static  String S_MonthFee = "MONTH_FEE";
  public final static  String S_RuleId = "RULE_ID";


public String getWarehouseType();

public String getAdminName();

public long getPackageFee();

public long getWarehouseId();

public String getIsSettleUnit();

public String getAdminTel();

public String getWarehouseState();

public String getWarehouseAddr();

public String getAdminMobilePhone();

public String getWarehouseCode();

public String getPostCode();

public String getWarehouseName();

public long getMonthFee();

public long getRuleId();


public  void setWarehouseType(String value);

public  void setAdminName(String value);

public  void setPackageFee(long value);

public  void setWarehouseId(long value);

public  void setIsSettleUnit(String value);

public  void setAdminTel(String value);

public  void setWarehouseState(String value);

public  void setWarehouseAddr(String value);

public  void setAdminMobilePhone(String value);

public  void setWarehouseCode(String value);

public  void setPostCode(String value);

public  void setWarehouseName(String value);

public  void setMonthFee(long value);

public  void setRuleId(long value);
}
