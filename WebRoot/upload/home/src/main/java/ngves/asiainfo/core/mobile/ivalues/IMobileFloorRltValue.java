package ngves.asiainfo.core.mobile.ivalues;

import com.ai.appframe2.common.DataStructInterface;

public interface IMobileFloorRltValue extends DataStructInterface {

	public final static String S_ShowPicFile = "SHOW_PIC_FILE";
	public final static String S_FloorRltId = "FLOOR_RLT_ID";
	public final static String S_ShowChannel = "SHOW_CHANNEL";
	public final static String S_BakCol1 = "BAK_COL1";
	public final static String S_RecommendType = "RECOMMEND_TYPE";
	public final static String S_FloorId = "FLOOR_ID";
	public final static String S_IsDelete = "IS_DELETE";
	public final static String S_RecommendId = "RECOMMEND_ID";
	public final static String S_RecommendName = "RECOMMEND_NAME";
	public final static String S_IndexId = "INDEX_ID";

	public String getShowPicFile();

	public long getFloorRltId();

	public String getShowChannel();

	public String getBakCol1();

	public String getRecommendType();

	public String getFloorId();

	public String getIsDelete();

	public String getRecommendId();

	public String getRecommendName();
	
	
	
	public long getIndexId();

	public void setShowPicFile(String value);

	public void setFloorRltId(long value);

	public void setShowChannel(String value);

	public void setBakCol1(String value);

	public void setRecommendType(String value);

	public void setFloorId(String value);

	public void setIsDelete(String value);

	public void setRecommendId(String value);

	public void setRecommendName(String value);
	
	public void setIndexId(long value);
}
