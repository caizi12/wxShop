package ngves.asiainfo.core.donated.bo;

import ngves.asiainfo.core.donated.ivalues.IQBOWareObjectRltValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class QBOWareObjectRltBean extends DataContainer implements DataContainerInterface, IQBOWareObjectRltValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.donated.bo.QBOWareObjectRlt";

	public final static String S_BakCol = "BAK_COL";
	public final static String S_WareSort = "WARE_SORT";
	public final static String S_RltId = "RLT_ID";
	public final static String S_ObjectId = "OBJECT_ID";
	public final static String S_ActivityId = "ACTIVITY_ID";
	public final static String S_AppVersion = "APP_VERSION";
	public final static String S_WareId = "WARE_ID";

	public QBOWareObjectRltBean() throws AIException {
		super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
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

	public void initWareSort(long value) {
		this.initProperty(S_WareSort, new Long(value));
	}

	public void setWareSort(long value) {
		this.set(S_WareSort, new Long(value));
	}

	public void setWareSortNull() {
		this.set(S_WareSort, null);
	}

	public long getWareSort() {
		return DataType.getAsLong(this.get(S_WareSort));

	}

	public long getWareSortInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_WareSort));
	}

	public void initRltId(long value) {
		this.initProperty(S_RltId, new Long(value));
	}

	public void setRltId(long value) {
		this.set(S_RltId, new Long(value));
	}

	public void setRltIdNull() {
		this.set(S_RltId, null);
	}

	public long getRltId() {
		return DataType.getAsLong(this.get(S_RltId));

	}

	public long getRltIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_RltId));
	}

	public void initObjectId(long value) {
		this.initProperty(S_ObjectId, new Long(value));
	}

	public void setObjectId(long value) {
		this.set(S_ObjectId, new Long(value));
	}

	public void setObjectIdNull() {
		this.set(S_ObjectId, null);
	}

	public long getObjectId() {
		return DataType.getAsLong(this.get(S_ObjectId));

	}

	public long getObjectIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_ObjectId));
	}

	public void initActivityId(long value) {
		this.initProperty(S_ActivityId, new Long(value));
	}

	public void setActivityId(long value) {
		this.set(S_ActivityId, new Long(value));
	}

	public void setActivityIdNull() {
		this.set(S_ActivityId, null);
	}

	public long getActivityId() {
		return DataType.getAsLong(this.get(S_ActivityId));

	}

	public long getActivityIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_ActivityId));
	}

	public void initAppVersion(long value) {
		this.initProperty(S_AppVersion, new Long(value));
	}

	public void setAppVersion(long value) {
		this.set(S_AppVersion, new Long(value));
	}

	public void setAppVersionNull() {
		this.set(S_AppVersion, null);
	}

	public long getAppVersion() {
		return DataType.getAsLong(this.get(S_AppVersion));

	}

	public long getAppVersionInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_AppVersion));
	}

	public void initWareId(long value) {
		this.initProperty(S_WareId, new Long(value));
	}

	public void setWareId(long value) {
		this.set(S_WareId, new Long(value));
	}

	public void setWareIdNull() {
		this.set(S_WareId, null);
	}

	public long getWareId() {
		return DataType.getAsLong(this.get(S_WareId));

	}

	public long getWareIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_WareId));
	}

}
