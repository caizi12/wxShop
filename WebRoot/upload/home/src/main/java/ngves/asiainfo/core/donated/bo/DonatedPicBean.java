package ngves.asiainfo.core.donated.bo;

import ngves.asiainfo.core.donated.ivalues.IDonatedPicValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class DonatedPicBean extends DataContainer implements DataContainerInterface, IDonatedPicValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.donated.bo.DonatedPic";

	public final static String S_Bgcolor = "BGCOLOR";
	public final static String S_BakCol = "BAK_COL";
	public final static String S_BakCol2 = "BAK_COL2";
	public final static String S_TopPx = "TOP_PX";
	public final static String S_RightPx = "RIGHT_PX";
	public final static String S_ActivityPicId = "ACTIVITY_PIC_ID";
	public final static String S_MainPic = "MAIN_PIC";
	public final static String S_DescPic = "DESC_PIC";
	public final static String S_BgPic = "BG_PIC";
	public final static String S_LeftPx = "LEFT_PX";
	public final static String S_BottomPx = "BOTTOM_PX";

	public DonatedPicBean() throws AIException {
		super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initBgcolor(String value) {
		this.initProperty(S_Bgcolor, value);
	}

	public void setBgcolor(String value) {
		this.set(S_Bgcolor, value);
	}

	public void setBgcolorNull() {
		this.set(S_Bgcolor, null);
	}

	public String getBgcolor() {
		return DataType.getAsString(this.get(S_Bgcolor));

	}

	public String getBgcolorInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Bgcolor));
	}

	public void initBakCol(String value) {
		this.initProperty(S_BakCol, value);
	}

	public void setBakCol(String value) {
		this.set(S_BakCol, value);
	}

	public void setBakColNull() {
		this.set(S_BakCol, null);
	}

	public String getBakCol() {
		return DataType.getAsString(this.get(S_BakCol));

	}

	public String getBakColInitialValue() {
		return DataType.getAsString(this.getOldObj(S_BakCol));
	}

	public void initBakCol2(String value) {
		this.initProperty(S_BakCol2, value);
	}

	public void setBakCol2(String value) {
		this.set(S_BakCol2, value);
	}

	public void setBakCol2Null() {
		this.set(S_BakCol2, null);
	}

	public String getBakCol2() {
		return DataType.getAsString(this.get(S_BakCol2));

	}

	public String getBakCol2InitialValue() {
		return DataType.getAsString(this.getOldObj(S_BakCol2));
	}

	public void initTopPx(long value) {
		this.initProperty(S_TopPx, new Long(value));
	}

	public void setTopPx(long value) {
		this.set(S_TopPx, new Long(value));
	}

	public void setTopPxNull() {
		this.set(S_TopPx, null);
	}

	public long getTopPx() {
		return DataType.getAsLong(this.get(S_TopPx));

	}

	public long getTopPxInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_TopPx));
	}

	public void initRightPx(long value) {
		this.initProperty(S_RightPx, new Long(value));
	}

	public void setRightPx(long value) {
		this.set(S_RightPx, new Long(value));
	}

	public void setRightPxNull() {
		this.set(S_RightPx, null);
	}

	public long getRightPx() {
		return DataType.getAsLong(this.get(S_RightPx));

	}

	public long getRightPxInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_RightPx));
	}

	public void initActivityPicId(long value) {
		this.initProperty(S_ActivityPicId, new Long(value));
	}

	public void setActivityPicId(long value) {
		this.set(S_ActivityPicId, new Long(value));
	}

	public void setActivityPicIdNull() {
		this.set(S_ActivityPicId, null);
	}

	public long getActivityPicId() {
		return DataType.getAsLong(this.get(S_ActivityPicId));

	}

	public long getActivityPicIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_ActivityPicId));
	}

	public void initMainPic(String value) {
		this.initProperty(S_MainPic, value);
	}

	public void setMainPic(String value) {
		this.set(S_MainPic, value);
	}

	public void setMainPicNull() {
		this.set(S_MainPic, null);
	}

	public String getMainPic() {
		return DataType.getAsString(this.get(S_MainPic));

	}

	public String getMainPicInitialValue() {
		return DataType.getAsString(this.getOldObj(S_MainPic));
	}

	public void initDescPic(String value) {
		this.initProperty(S_DescPic, value);
	}

	public void setDescPic(String value) {
		this.set(S_DescPic, value);
	}

	public void setDescPicNull() {
		this.set(S_DescPic, null);
	}

	public String getDescPic() {
		return DataType.getAsString(this.get(S_DescPic));

	}

	public String getDescPicInitialValue() {
		return DataType.getAsString(this.getOldObj(S_DescPic));
	}

	public void initBgPic(String value) {
		this.initProperty(S_BgPic, value);
	}

	public void setBgPic(String value) {
		this.set(S_BgPic, value);
	}

	public void setBgPicNull() {
		this.set(S_BgPic, null);
	}

	public String getBgPic() {
		return DataType.getAsString(this.get(S_BgPic));

	}

	public String getBgPicInitialValue() {
		return DataType.getAsString(this.getOldObj(S_BgPic));
	}

	public void initLeftPx(long value) {
		this.initProperty(S_LeftPx, new Long(value));
	}

	public void setLeftPx(long value) {
		this.set(S_LeftPx, new Long(value));
	}

	public void setLeftPxNull() {
		this.set(S_LeftPx, null);
	}

	public long getLeftPx() {
		return DataType.getAsLong(this.get(S_LeftPx));

	}

	public long getLeftPxInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_LeftPx));
	}

	public void initBottomPx(long value) {
		this.initProperty(S_BottomPx, new Long(value));
	}

	public void setBottomPx(long value) {
		this.set(S_BottomPx, new Long(value));
	}

	public void setBottomPxNull() {
		this.set(S_BottomPx, null);
	}

	public long getBottomPx() {
		return DataType.getAsLong(this.get(S_BottomPx));

	}

	public long getBottomPxInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_BottomPx));
	}

}
