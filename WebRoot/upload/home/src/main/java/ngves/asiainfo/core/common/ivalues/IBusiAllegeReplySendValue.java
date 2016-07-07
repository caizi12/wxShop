package ngves.asiainfo.core.common.ivalues;

import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;

public interface IBusiAllegeReplySendValue extends DataStructInterface {

	public final static String S_Staffcontactphone = "STAFFCONTACTPHONE";
	public final static String S_Indictrslt = "INDICTRSLT";
	public final static String S_BusiId = "BUSI_ID";
	public final static String S_Subsbrand = "SUBSBRAND";
	public final static String S_CreateDate = "CREATE_DATE";
	public final static String S_Handlingdept = "HANDLINGDEPT";
	public final static String S_Subslevel = "SUBSLEVEL";
	public final static String S_Satisfaction = "SATISFACTION";
	public final static String S_Dutyreason = "DUTYREASON";
	public final static String S_Handlingstaff = "HANDLINGSTAFF";
	public final static String S_BakCol = "BAK_COL";
	public final static String S_BakCol2 = "BAK_COL2";
	public final static String S_Attachnames = "ATTACHNAMES";
	public final static String S_BakCol3 = "BAK_COL3";
	public final static String S_Replytime = "REPLYTIME";
	public final static String S_Indictseq = "INDICTSEQ";
	public final static String S_Recordfiles = "RECORDFILES";
	public final static String S_AppVersion = "APP_VERSION";
	public final static String S_Dutycausegrade = "DUTYCAUSEGRADE";

	public String getStaffcontactphone();

	public String getIndictrslt();

	public long getBusiId();

	public String getSubsbrand();

	public Timestamp getCreateDate();

	public String getHandlingdept();

	public String getSubslevel();

	public String getSatisfaction();

	public String getDutyreason();

	public String getHandlingstaff();

	public String getBakCol();

	public String getBakCol2();

	public String getAttachnames();

	public String getBakCol3();

	public Timestamp getReplytime();

	public String getIndictseq();

	public String getRecordfiles();
	
	public String getDutycausegrade();
	
	

	public void setStaffcontactphone(String value);

	public void setIndictrslt(String value);

	public void setBusiId(long value);

	public void setSubsbrand(String value);

	public void setCreateDate(Timestamp value);

	public void setHandlingdept(String value);

	public void setSubslevel(String value);

	public void setSatisfaction(String value);

	public void setDutyreason(String value);

	public void setHandlingstaff(String value);

	public void setBakCol(String value);

	public void setBakCol2(String value);

	public void setAttachnames(String value);

	public void setBakCol3(String value);

	public void setReplytime(Timestamp value);

	public void setIndictseq(String value);

	public void setRecordfiles(String value);

	public void setAppVersion(String value);

	public String getAppVersion();
	
	public void setDutycausegrade(String value);
	
}
