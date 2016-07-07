package ngves.asiainfo.core.review.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IQBOReviewWLJFBDCKValue extends DataStructInterface{

  public final static  String S_WarehouseType = "WAREHOUSE_TYPE";
  public final static  String S_WarehouseName = "WAREHOUSE_NAME";
  public final static  String S_RuleName = "RULE_NAME";
  public final static  String S_WarehouseCode = "WAREHOUSE_CODE";
  public final static  String S_PackageFee = "PACKAGE_FEE";


public String getWarehouseType();

public String getWarehouseName();

public String getRuleName();

public String getWarehouseCode();

public String getPackageFee();


public  void setWarehouseType(String value);

public  void setWarehouseName(String value);

public  void setRuleName(String value);

public  void setWarehouseCode(String value);

public  void setPackageFee(String value);
}
