package ngves.asiainfo.core.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface INormalOrderExcelValue extends DataStructInterface{

  public final static  String S_NorOrderExcelId = "NOR_ORDER_EXCEL_ID";
  public final static  String S_NorColumnGet = "NOR_COLUMN_GET";
  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_FontColor = "FONT_COLOR";
  public final static  String S_NorMapGet = "NOR_MAP_GET";
  public final static  String S_ColumnDesc = "COLUMN_DESC";
  public final static  String S_NorListGet = "NOR_LIST_GET";
  public final static  String S_AdaptType = "ADAPT_TYPE";


public long getNorOrderExcelId();

public String getNorColumnGet();

public String getBakCol();

public String getBakCol2();

public long getFontColor();

public String getNorMapGet();

public String getColumnDesc();

public String getNorListGet();

public String getAdaptType();


public  void setNorOrderExcelId(long value);

public  void setNorColumnGet(String value);

public  void setBakCol(String value);

public  void setBakCol2(String value);

public  void setFontColor(long value);

public  void setNorMapGet(String value);

public  void setColumnDesc(String value);

public  void setNorListGet(String value);

public  void setAdaptType(String value);
}
