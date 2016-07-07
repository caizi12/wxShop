package ngves.asiainfo.core.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface INorExcelClauseValue extends DataStructInterface{

  public final static  String S_NorExcelClauseId = "NOR_EXCEL_CLAUSE_ID";
  public final static  String S_ClauseValue = "CLAUSE_VALUE";
  public final static  String S_SortId = "SORT_ID";
  public final static  String S_ExcelTaskId = "EXCEL_TASK_ID";
  public final static  String S_ClauseViewName = "CLAUSE_VIEW_NAME";
  public final static  String S_ClauseMethod = "CLAUSE_METHOD";
  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_ClauseTransformValue = "CLAUSE_TRANSFORM_VALUE";
  public final static  String S_ClauseName = "CLAUSE_NAME";


public long getNorExcelClauseId();

public String getClauseValue();

public long getSortId();

public String getExcelTaskId();

public String getClauseViewName();

public String getClauseMethod();

public String getBakCol();

public String getBakCol2();

public String getClauseTransformValue();

public String getClauseName();


public  void setNorExcelClauseId(long value);

public  void setClauseValue(String value);

public  void setSortId(long value);

public  void setExcelTaskId(String value);

public  void setClauseViewName(String value);

public  void setClauseMethod(String value);

public  void setBakCol(String value);

public  void setBakCol2(String value);

public  void setClauseTransformValue(String value);

public  void setClauseName(String value);
}
