package ngves.asiainfo.core.mobile.bo;

import java.sql.Timestamp;

import ngves.asiainfo.core.mobile.ivalues.IMobileFloorInfoValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class MobileFloorInfoBean extends DataContainer implements DataContainerInterface, IMobileFloorInfoValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.mobile.bo.MobileFloorInfo";

	public final static String S_IsDeleted = "IS_DELETED";
	public final static String S_ShowTemplateType = "SHOW_TEMPLATE_TYPE";
	public final static String S_ShowChannel = "SHOW_CHANNEL";
	public final static String S_BakCol1 = "BAK_COL1";
	public final static String S_CreateStartTime = "CREATE_START_TIME";
	public final static String S_SortId = "SORT_ID";
	public final static String S_IsShow = "IS_SHOW";
	public final static String S_FloorName = "FLOOR_NAME";
	public final static String S_FloorId = "FLOOR_ID";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public MobileFloorInfoBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initIsDeleted(String value) {
		this.initProperty(S_IsDeleted, value);
	}

	public void setIsDeleted(String value) {
		this.set(S_IsDeleted, value);
	}

	public void setIsDeletedNull() {
		this.set(S_IsDeleted, null);
	}

	public String getIsDeleted() {
		return DataType.getAsString(this.get(S_IsDeleted));

	}

	public String getIsDeletedInitialValue() {
		return DataType.getAsString(this.getOldObj(S_IsDeleted));
	}

	public void initShowTemplateType(String value) {
		this.initProperty(S_ShowTemplateType, value);
	}

	public void setShowTemplateType(String value) {
		this.set(S_ShowTemplateType, value);
	}

	public void setShowTemplateTypeNull() {
		this.set(S_ShowTemplateType, null);
	}

	public String getShowTemplateType() {
		return DataType.getAsString(this.get(S_ShowTemplateType));

	}

	public String getShowTemplateTypeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ShowTemplateType));
	}

	public void initShowChannel(String value) {
		this.initProperty(S_ShowChannel, value);
	}

	public void setShowChannel(String value) {
		this.set(S_ShowChannel, value);
	}

	public void setShowChannelNull() {
		this.set(S_ShowChannel, null);
	}

	public String getShowChannel() {
		return DataType.getAsString(this.get(S_ShowChannel));

	}

	public String getShowChannelInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ShowChannel));
	}

	public void initBakCol1(String value) {
		this.initProperty(S_BakCol1, value);
	}

	public void setBakCol1(String value) {
		this.set(S_BakCol1, value);
	}

	public void setBakCol1Null() {
		this.set(S_BakCol1, null);
	}

	public String getBakCol1() {
		return DataType.getAsString(this.get(S_BakCol1));

	}

	public String getBakCol1InitialValue() {
		return DataType.getAsString(this.getOldObj(S_BakCol1));
	}

	public void initCreateStartTime(Timestamp value) {
		this.initProperty(S_CreateStartTime, value);
	}

	public void setCreateStartTime(Timestamp value) {
		this.set(S_CreateStartTime, value);
	}

	public void setCreateStartTimeNull() {
		this.set(S_CreateStartTime, null);
	}

	public Timestamp getCreateStartTime() {
		return DataType.getAsDateTime(this.get(S_CreateStartTime));

	}

	public Timestamp getCreateStartTimeInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_CreateStartTime));
	}

	public void initSortId(long value) {
		this.initProperty(S_SortId, value);
	}

	public void setSortId(long value) {
		this.set(S_SortId, value);
	}

	public void setSortIdNull() {
		this.set(S_SortId, null);
	}

	public long getSortId() {
		return DataType.getAsLong(this.get(S_SortId));

	}

	public long getSortIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_SortId));
	}

	public void initIsShow(String value) {
		this.initProperty(S_IsShow, value);
	}

	public void setIsShow(String value) {
		this.set(S_IsShow, value);
	}

	public void setIsShowNull() {
		this.set(S_IsShow, null);
	}

	public String getIsShow() {
		return DataType.getAsString(this.get(S_IsShow));

	}

	public String getIsShowInitialValue() {
		return DataType.getAsString(this.getOldObj(S_IsShow));
	}

	public void initFloorName(String value) {
		this.initProperty(S_FloorName, value);
	}

	public void setFloorName(String value) {
		this.set(S_FloorName, value);
	}

	public void setFloorNameNull() {
		this.set(S_FloorName, null);
	}

	public String getFloorName() {
		return DataType.getAsString(this.get(S_FloorName));

	}

	public String getFloorNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_FloorName));
	}

	public void initFloorId(long value) {
		this.initProperty(S_FloorId, new Long(value));
	}

	public void setFloorId(long value) {
		this.set(S_FloorId, new Long(value));
	}

	public void setFloorIdNull() {
		this.set(S_FloorId, null);
	}

	public long getFloorId() {
		return DataType.getAsLong(this.get(S_FloorId));

	}

	public long getFloorIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_FloorId));
	}

}
