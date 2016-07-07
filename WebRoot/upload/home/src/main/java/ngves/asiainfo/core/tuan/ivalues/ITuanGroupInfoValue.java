package ngves.asiainfo.core.tuan.ivalues;

import com.ai.appframe2.common.DataStructInterface;

public interface ITuanGroupInfoValue extends DataStructInterface {

	public final static String S_IsIndexDisplay = "IS_INDEX_DISPLAY";
	public final static String S_GroupName = "GROUP_NAME";
	public final static String S_GroupCode = "GROUP_CODE";
	public final static String S_BakCol = "BAK_COL";
	public final static String S_BakCol2 = "BAK_COL2";
	public final static String S_BakCol3 = "BAK_COL3";
	public final static String S_ActivityCount = "ACTIVITY_COUNT";
	public final static String S_TuanGroupId = "TUAN_GROUP_ID";
	public final static String S_GroupType = "GROUP_TYPE";

	public String getIsIndexDisplay();

	public String getGroupName();

	public String getGroupCode();

	public String getBakCol();

	public String getBakCol2();

	public String getBakCol3();

	public long getActivityCount();

	public long getTuanGroupId();
	
	public String getGroupType();
	
	public void setGroupType(String value); 

	public void setIsIndexDisplay(String value);

	public void setGroupName(String value);

	public void setGroupCode(String value);

	public void setBakCol(String value);

	public void setBakCol2(String value);

	public void setBakCol3(String value);

	public void setActivityCount(long value);

	public void setTuanGroupId(long value);
}
