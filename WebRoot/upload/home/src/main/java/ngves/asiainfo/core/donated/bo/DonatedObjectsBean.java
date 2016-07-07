package ngves.asiainfo.core.donated.bo;

import java.sql.Timestamp;

import ngves.asiainfo.core.donated.ivalues.IDonatedObjectsValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class DonatedObjectsBean extends DataContainer implements DataContainerInterface, IDonatedObjectsValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.donated.bo.DonatedObjects";

	public final static String S_ObjectName = "OBJECT_NAME";
	public final static String S_BakCol = "BAK_COL";
	public final static String S_BakCol2 = "BAK_COL2";
	public final static String S_ObjectCode = "OBJECT_CODE";
	public final static String S_PicUrl = "PIC_URL";
	public final static String S_ObjectId = "OBJECT_ID";
	public final static String S_ObjectDes = "OBJECT_DES";
	public final static String S_AppVersion = "APP_VERSION";
	public final static String S_CreateDate = "CREATE_DATE";
	public final static String S_Status = "STATUS";
	public final static String S_DistributionId = "DISTRIBUTION_ID";

	public DonatedObjectsBean() throws AIException {
		super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initObjectName(String value) {
		this.initProperty(S_ObjectName, value);
	}

	public void setObjectName(String value) {
		this.set(S_ObjectName, value);
	}

	public void setObjectNameNull() {
		this.set(S_ObjectName, null);
	}

	public String getObjectName() {
		return DataType.getAsString(this.get(S_ObjectName));

	}

	public String getObjectNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ObjectName));
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

	public void initObjectCode(String value) {
		this.initProperty(S_ObjectCode, value);
	}

	public void setObjectCode(String value) {
		this.set(S_ObjectCode, value);
	}

	public void setObjectCodeNull() {
		this.set(S_ObjectCode, null);
	}

	public String getObjectCode() {
		return DataType.getAsString(this.get(S_ObjectCode));

	}

	public String getObjectCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ObjectCode));
	}

	public void initPicUrl(String value) {
		this.initProperty(S_PicUrl, value);
	}

	public void setPicUrl(String value) {
		this.set(S_PicUrl, value);
	}

	public void setPicUrlNull() {
		this.set(S_PicUrl, null);
	}

	public String getPicUrl() {
		return DataType.getAsString(this.get(S_PicUrl));

	}

	public String getPicUrlInitialValue() {
		return DataType.getAsString(this.getOldObj(S_PicUrl));
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

	public void initObjectDes(String value) {
		this.initProperty(S_ObjectDes, value);
	}

	public void setObjectDes(String value) {
		this.set(S_ObjectDes, value);
	}

	public void setObjectDesNull() {
		this.set(S_ObjectDes, null);
	}

	public String getObjectDes() {
		return DataType.getAsString(this.get(S_ObjectDes));

	}

	public String getObjectDesInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ObjectDes));
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

	public void initCreateDate(Timestamp value) {
		this.initProperty(S_CreateDate, value);
	}

	public void setCreateDate(Timestamp value) {
		this.set(S_CreateDate, value);
	}

	public void setCreateDateNull() {
		this.set(S_CreateDate, null);
	}

	public Timestamp getCreateDate() {
		return DataType.getAsDateTime(this.get(S_CreateDate));

	}

	public Timestamp getCreateDateInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_CreateDate));
	}

	public void initStatus(long value) {
		this.initProperty(S_Status, new Long(value));
	}

	public void setStatus(long value) {
		this.set(S_Status, new Long(value));
	}

	public void setStatusNull() {
		this.set(S_Status, null);
	}

	public long getStatus() {
		return DataType.getAsLong(this.get(S_Status));

	}

	public long getStatusInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_Status));
	}

	public void initDistributionId(long value) {
		this.initProperty(S_DistributionId, new Long(value));
	}

	public void setDistributionId(long value) {
		this.set(S_DistributionId, new Long(value));
	}

	public void setDistributionIdNull() {
		this.set(S_DistributionId, null);
	}

	public long getDistributionId() {
		return DataType.getAsLong(this.get(S_DistributionId));

	}

	public long getDistributionIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_DistributionId));
	}

}
