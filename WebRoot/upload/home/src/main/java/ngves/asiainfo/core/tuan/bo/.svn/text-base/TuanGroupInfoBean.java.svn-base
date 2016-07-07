package ngves.asiainfo.core.tuan.bo;

import ngves.asiainfo.core.tuan.ivalues.ITuanGroupInfoValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class TuanGroupInfoBean extends DataContainer implements DataContainerInterface, ITuanGroupInfoValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6225359154941116967L;

	private static String m_boName = "ngves.asiainfo.core.tuan.bo.TuanGroupInfo";

	public final static String S_IsIndexDisplay = "IS_INDEX_DISPLAY";
	public final static String S_GroupName = "GROUP_NAME";
	public final static String S_GroupCode = "GROUP_CODE";
	public final static String S_BakCol = "BAK_COL";
	public final static String S_BakCol2 = "BAK_COL2";
	public final static String S_BakCol3 = "BAK_COL3";
	public final static String S_ActivityCount = "ACTIVITY_COUNT";
	public final static String S_TuanGroupId = "TUAN_GROUP_ID";
	public final static String S_GroupType = "GROUP_TYPE";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public TuanGroupInfoBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initIsIndexDisplay(String value) {
		this.initProperty(S_IsIndexDisplay, value);
	}

	public void setIsIndexDisplay(String value) {
		this.set(S_IsIndexDisplay, value);
	}

	public void setIsIndexDisplayNull() {
		this.set(S_IsIndexDisplay, null);
	}

	public String getIsIndexDisplay() {
		return DataType.getAsString(this.get(S_IsIndexDisplay));

	}

	public String getIsIndexDisplayInitialValue() {
		return DataType.getAsString(this.getOldObj(S_IsIndexDisplay));
	}

	public void initGroupName(String value) {
		this.initProperty(S_GroupName, value);
	}

	public void setGroupName(String value) {
		this.set(S_GroupName, value);
	}

	public void setGroupNameNull() {
		this.set(S_GroupName, null);
	}

	public String getGroupName() {
		return DataType.getAsString(this.get(S_GroupName));

	}

	public String getGroupNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_GroupName));
	}

	public void initGroupCode(String value) {
		this.initProperty(S_GroupCode, value);
	}

	public void setGroupCode(String value) {
		this.set(S_GroupCode, value);
	}

	public void setGroupCodeNull() {
		this.set(S_GroupCode, null);
	}

	public String getGroupCode() {
		return DataType.getAsString(this.get(S_GroupCode));

	}

	public String getGroupCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_GroupCode));
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

	public void initBakCol3(String value) {
		this.initProperty(S_BakCol3, value);
	}

	public void setBakCol3(String value) {
		this.set(S_BakCol3, value);
	}

	public void setBakCol3Null() {
		this.set(S_BakCol3, null);
	}

	public String getBakCol3() {
		return DataType.getAsString(this.get(S_BakCol3));

	}

	public String getBakCol3InitialValue() {
		return DataType.getAsString(this.getOldObj(S_BakCol3));
	}

	public void initActivityCount(long value) {
		this.initProperty(S_ActivityCount, new Long(value));
	}

	public void setActivityCount(long value) {
		this.set(S_ActivityCount, new Long(value));
	}

	public void setActivityCountNull() {
		this.set(S_ActivityCount, null);
	}

	public long getActivityCount() {
		return DataType.getAsLong(this.get(S_ActivityCount));

	}

	public long getActivityCountInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_ActivityCount));
	}

	public void initTuanGroupId(long value) {
		this.initProperty(S_TuanGroupId, new Long(value));
	}

	public void setTuanGroupId(long value) {
		this.set(S_TuanGroupId, new Long(value));
	}

	public void setTuanGroupIdNull() {
		this.set(S_TuanGroupId, null);
	}

	public long getTuanGroupId() {
		return DataType.getAsLong(this.get(S_TuanGroupId));

	}

	public long getTuanGroupIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_TuanGroupId));
	}
	
	public void initGroupType(String value) {
		this.initProperty(S_GroupType, value);
	}

	public void setGroupType(String value) {
		this.set(S_GroupType, value);
	}

	public void setGroupTypeNull() {
		this.set(S_GroupType, null);
	}

	public String getGroupType() {
		return DataType.getAsString(this.get(S_GroupType));

	}

	public String getGroupTypeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_GroupType));
	}

}
