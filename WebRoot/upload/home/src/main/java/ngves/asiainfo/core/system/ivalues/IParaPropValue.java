package ngves.asiainfo.core.system.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IParaPropValue extends DataStructInterface{

  public final static  String S_ParaKey = "PARA_KEY";
  public final static  String S_Id = "ID";
  public final static  String S_ParaCreateDate = "PARA_CREATE_DATE";
  public final static  String S_ParaValu = "PARA_VALU";
  public final static  String S_ParaDesc = "PARA_DESC";
  public final static  String S_ParaModifyDate = "PARA_MODIFY_DATE";


public String getParaKey();

public String getId();

public Timestamp getParaCreateDate();

public String getParaValu();

public String getParaDesc();

public Timestamp getParaModifyDate();


public  void setParaKey(String value);

public  void setId(String value);

public  void setParaCreateDate(Timestamp value);

public  void setParaValu(String value);

public  void setParaDesc(String value);

public  void setParaModifyDate(Timestamp value);
}
