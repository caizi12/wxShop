package ngves.asiainfo.core.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface ISysUserInterestValue extends DataStructInterface{

  public final static  String S_InterestId = "INTEREST_ID";
  public final static  String S_InterestName = "INTEREST_NAME";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_InterestCode = "INTEREST_CODE";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_WareKindId = "WARE_KIND_ID";
  public final static  String S_InterestSeq = "INTEREST_SEQ";


public long getInterestId();

public String getInterestName();

public String getBakCol2();

public String getInterestCode();

public long getBakCol1();

public long getWareKindId();

public long getInterestSeq();


public  void setInterestId(long value);

public  void setInterestName(String value);

public  void setBakCol2(String value);

public  void setInterestCode(String value);

public  void setBakCol1(long value);

public  void setWareKindId(long value);

public  void setInterestSeq(long value);
}
