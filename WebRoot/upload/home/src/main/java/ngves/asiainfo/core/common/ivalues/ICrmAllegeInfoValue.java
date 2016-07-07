package ngves.asiainfo.core.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ICrmAllegeInfoValue extends DataStructInterface{

  public final static  String S_Origintime = "ORIGINTIME";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Svccity = "SVCCITY";
  public final static  String S_Contactchannel = "CONTACTCHANNEL";
  public final static  String S_Subslevel = "SUBSLEVEL";
  public final static  String S_Processtype = "PROCESSTYPE";
  public final static  String S_Homeprov = "HOMEPROV";
  public final static  String S_Subsname = "SUBSNAME";
  public final static  String S_IndictStatus = "INDICT_STATUS";
  public final static  String S_Tprov = "TPROV";
  public final static  String S_Pretreatment = "PRETREATMENT";
  public final static  String S_Callerno = "CALLERNO";
  public final static  String S_Calledno = "CALLEDNO";
  public final static  String S_Recordfiles = "RECORDFILES";
  public final static  String S_Servicecontent = "SERVICECONTENT";
  public final static  String S_Acceptstaff = "ACCEPTSTAFF";
  public final static  String S_Contactcontent = "CONTACTCONTENT";
  public final static  String S_Deadtime = "DEADTIME";
  public final static  String S_Subsbrand = "SUBSBRAND";
  public final static  String S_Srid = "SRID";
  public final static  String S_Urgentid = "URGENTID";
  public final static  String S_Servicename = "SERVICENAME";
  public final static  String S_Svctypeid = "SVCTYPEID";
  public final static  String S_Title = "TITLE";
  public final static  String S_Msisdn = "MSISDN";
  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_Attachnames = "ATTACHNAMES";
  public final static  String S_Accepttime = "ACCEPTTIME";
  public final static  String S_Contactid = "CONTACTID";
  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_Indictseq = "INDICTSEQ";
  public final static  String S_AppVersion = "APP_VERSION";

public Timestamp getOrigintime();

public Timestamp getCreateDate();

public String getSvccity();

public String getContactchannel();

public String getSubslevel();

public String getProcesstype();

public String getHomeprov();

public String getSubsname();

public String getIndictStatus();

public String getTprov();

public String getPretreatment();

public String getCallerno();

public String getCalledno();

public String getRecordfiles();

public String getServicecontent();

public String getAcceptstaff();

public String getContactcontent();

public Timestamp getDeadtime();

public String getSubsbrand();

public String getSrid();

public String getUrgentid();

public String getServicename();

public String getSvctypeid();

public String getTitle();

public String getMsisdn();

public String getBakCol();

public String getBakCol2();

public String getAttachnames();

public Timestamp getAccepttime();

public String getContactid();

public String getBakCol3();

public String getIndictseq();


public  void setOrigintime(Timestamp value);

public  void setCreateDate(Timestamp value);

public  void setSvccity(String value);

public  void setContactchannel(String value);

public  void setSubslevel(String value);

public  void setProcesstype(String value);

public  void setHomeprov(String value);

public  void setSubsname(String value);

public  void setIndictStatus(String value);

public  void setTprov(String value);

public  void setPretreatment(String value);

public  void setCallerno(String value);

public  void setCalledno(String value);

public  void setRecordfiles(String value);

public  void setServicecontent(String value);

public  void setAcceptstaff(String value);

public  void setContactcontent(String value);

public  void setDeadtime(Timestamp value);

public  void setSubsbrand(String value);

public  void setSrid(String value);

public  void setUrgentid(String value);

public  void setServicename(String value);

public  void setSvctypeid(String value);

public  void setTitle(String value);

public  void setMsisdn(String value);

public  void setBakCol(String value);

public  void setBakCol2(String value);

public  void setAttachnames(String value);

public  void setAccepttime(Timestamp value);

public  void setContactid(String value);

public  void setBakCol3(String value);

public  void setIndictseq(String value);

public void setAppVersion(String value);

public String getAppVersion();
}
