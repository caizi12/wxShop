package ngves.asiainfo.core.system.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IBusiParaDataValue extends DataStructInterface{

  public final static  String S_ParaCode = "PARA_CODE";
  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_ParaId = "PARA_ID";
  public final static  String S_ParaName = "PARA_NAME";
  public final static  String S_ParaTypeId = "PARA_TYPE_ID";
  public final static  String S_ParaCodeType = "PARA_CODE_TYPE";


public String getParaCode();

public String getBakCol();

public long getParaId();

public String getParaName();

public long getParaTypeId();

public String getParaCodeType();


public  void setParaCode(String value);

public  void setBakCol(String value);

public  void setParaId(long value);

public  void setParaName(String value);

public  void setParaTypeId(long value);

public  void setParaCodeType(String value);
}
