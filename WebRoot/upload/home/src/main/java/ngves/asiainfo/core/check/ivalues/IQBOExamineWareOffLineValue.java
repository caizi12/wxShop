package ngves.asiainfo.core.check.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IQBOExamineWareOffLineValue extends DataStructInterface{

  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_FileName = "FILE_NAME";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_ExamineYear = "EXAMINE_YEAR";
  public final static  String S_RuleType = "RULE_TYPE";
  public final static  String S_ExmineMonths = "EXMINE_MONTHS";
  public final static  String S_ExamineWareOfflineId = "EXAMINE_WARE_OFFLINE_ID";


public String getBakCol2();

public String getFileName();

public String getBakCol1();

public String getExamineYear();

public String getRuleType();

public String getExmineMonths();

public long getExamineWareOfflineId();


public  void setBakCol2(String value);

public  void setFileName(String value);

public  void setBakCol1(String value);

public  void setExamineYear(String value);

public  void setRuleType(String value);

public  void setExmineMonths(String value);

public  void setExamineWareOfflineId(long value);
}
