package ngves.asiainfo.core.donated.ivalues;

import com.ai.appframe2.common.DataStructInterface;

public interface IQBODonatedObjectRltValue extends DataStructInterface {

	public final static String S_ObjectName = "OBJECT_NAME";
	public final static String S_DonatedI = "DONATED_I";
	public final static String S_BakCol = "BAK_COL";
	public final static String S_RltId = "RLT_ID";
	public final static String S_ObjectSort = "OBJECT_SORT";
	public final static String S_ObjectId = "OBJECT_ID";
	public final static String S_ActivityId = "ACTIVITY_ID";
	public final static String S_DonatedM = "DONATED_M";
	public final static String S_AppVersion = "APP_VERSION";
	public final static String S_DonatedWare = "DONATED_WARE";

	public String getObjectName();

	public long getDonatedI();

	public String getBakCol();

	public long getRltId();

	public long getObjectSort();

	public long getObjectId();

	public long getActivityId();

	public long getDonatedM();

	public long getAppVersion();

	public long getDonatedWare();

	public void setObjectName(String value);

	public void setDonatedI(long value);

	public void setBakCol(String value);

	public void setRltId(long value);

	public void setObjectSort(long value);

	public void setObjectId(long value);

	public void setActivityId(long value);

	public void setDonatedM(long value);

	public void setAppVersion(long value);

	public void setDonatedWare(long value);
}
