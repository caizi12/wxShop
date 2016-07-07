package ngves.asiainfo.core.review.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IQBOReviewJSXXWLSValue extends DataStructInterface{

  public final static  String S_PartnerName = "PARTNER_NAME";
  public final static  String S_PartnerCode = "PARTNER_CODE";
  public final static  String S_SuitRate = "SUIT_RATE";
  public final static  String S_Name = "NAME";
  public final static  String S_IsSeparate = "IS_SEPARATE";


public String getPartnerName();

public String getPartnerCode();

public String getSuitRate();

public String getName();

public String getIsSeparate();


public  void setPartnerName(String value);

public  void setPartnerCode(String value);

public  void setSuitRate(String value);

public  void setName(String value);

public  void setIsSeparate(String value);
}
