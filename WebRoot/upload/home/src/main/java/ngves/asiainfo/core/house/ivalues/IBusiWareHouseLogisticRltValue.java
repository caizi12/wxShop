package ngves.asiainfo.core.house.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBusiWareHouseLogisticRltValue extends DataStructInterface{

  public final static  String S_LogisticRltBegTime = "LOGISTIC_RLT_BEG_TIME";
  public final static  String S_ProvinceRltBegTime = "PROVINCE_RLT_BEG_TIME";
  public final static  String S_RltState = "RLT_STATE";
  public final static  String S_LogisticRltEndTime = "LOGISTIC_RLT_END_TIME";
  public final static  String S_WarehouseId = "WAREHOUSE_ID";
  public final static  String S_Note = "NOTE";
  public final static  String S_ProvinceRltEndTime = "PROVINCE_RLT_END_TIME";
  public final static  String S_ProvinceCode = "PROVINCE_CODE";
  public final static  String S_AllPercent = "ALL_PERCENT";
  public final static  String S_WarehouseLogisticRltId = "WAREHOUSE_LOGISTIC_RLT_ID";
  public final static  String S_PartnerId = "PARTNER_ID";
  public final static  String S_PartnerState = "PARTNER_STATE";
  
  public final static  String S_BusiId = "BUSI_ID";
  public final static  String S_BusiStatus = "BUSI_STATUS";
  public final static  String S_Operator = "OPERATOR";
  public final static  String S_SynTime = "SYN_TIME";


public Timestamp getLogisticRltBegTime();

public Timestamp getProvinceRltBegTime();

public String getRltState();

public Timestamp getLogisticRltEndTime();

public long getWarehouseId();

public String getNote();

public Timestamp getProvinceRltEndTime();

public String getProvinceCode();

public String getAllPercent();

public long getWarehouseLogisticRltId();

public long getPartnerId();

public String getPartnerState();


public  void setLogisticRltBegTime(Timestamp value);

public  void setProvinceRltBegTime(Timestamp value);

public  void setRltState(String value);

public  void setLogisticRltEndTime(Timestamp value);

public  void setWarehouseId(long value);

public  void setNote(String value);

public  void setProvinceRltEndTime(Timestamp value);

public  void setProvinceCode(String value);

public  void setAllPercent(String value);

public  void setWarehouseLogisticRltId(long value);

public  void setPartnerId(long value);

public  void setPartnerState(String value);


public String getBusiStatus();
public  void setBusiStatus(String value);

public long getBusiId();
public  void setBusiId(long value);

public String getOperator();
public  void setOperator(String value);

public String getSynTime();
public  void setSynTime(String value);
}
