package ngves.asiainfo.core.review.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IQBOReviewJSXXLPValue extends DataStructInterface{

  public final static  String S_SuitRate = "SUIT_RATE";
  public final static  String S_PartnerName = "PARTNER_NAME";
  public final static  String S_WareName = "WARE_NAME";
  public final static  String S_FName = "F_NAME";
  public final static  String S_WareCode = "WARE_CODE";
  public final static  String S_PartnerCode = "PARTNER_CODE";
  public final static  String S_Value = "VALUE";
  public final static  String S_Name = "NAME";
  public final static  String S_IsSeparate = "IS_SEPARATE";


public String getSuitRate();

public String getPartnerName();

public String getWareName();

public String getFName();

public String getWareCode();

public String getPartnerCode();

public String getValue();

public String getName();

public String getIsSeparate();


public  void setSuitRate(String value);

public  void setPartnerName(String value);

public  void setWareName(String value);

public  void setFName(String value);

public  void setWareCode(String value);

public  void setPartnerCode(String value);

public  void setValue(String value);

public  void setName(String value);

public  void setIsSeparate(String value);
}
