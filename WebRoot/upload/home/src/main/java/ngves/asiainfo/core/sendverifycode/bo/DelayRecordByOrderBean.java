package ngves.asiainfo.core.sendverifycode.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.sendverifycode.ivalues.*;

public class DelayRecordByOrderBean extends DataContainer implements
		DataContainerInterface, IDelayRecordByOrderValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1125861876456690565L;

	private static String m_boName = "ngves.asiainfo.core.sendverifycode.bo.DelayRecordByOrder";

	public final static String S_SuborderId = "SUBORDER_ID";
	public final static String S_ItemId = "ITEM_ID";
	public final static String S_Mobile = "MOBILE";
	public final static String S_OldvalidateTime = "OLDVALIDATE_TIME";
	public final static String S_NewvalidateTime = "NEWVALIDATE_TIME";
	public final static String S_Days = "DAYS";
	public final static String S_Opera = "OPERA";
	public final static String S_OperateTime = "OPERATE_TIME";
	public final static String S_OrgId = "ORG_ID";
	public final static String S_ExtendType = "EXTEND_TYPE";
	public final static String S_IsoverdureExtend = "ISOVERDUE_EXTEND";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory()
					.getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public DelayRecordByOrderBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException(
				"The data container cannot reset the business object type!");
	}

	public void initDays(long value) {
		this.initProperty(S_Days, new Long(value));
	}

	public void setDays(long value) {
		this.set(S_Days, new Long(value));
	}

	public void setDaysNull() {
		this.set(S_Days, null);
	}

	public long getDays() {
		return DataType.getAsLong(this.get(S_Days));

	}

	public long getDaysInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_Days));
	}

	public void initExtendType(String value) {
		this.initProperty(S_ExtendType, value);
	}

	public void setExtendType(String value) {
		this.set(S_ExtendType, value);
	}

	public void setExtendTypeNull() {
		this.set(S_ExtendType, null);
	}

	public String getExtendType() {
		return DataType.getAsString(this.get(S_ExtendType));

	}

	public String getExtendTypeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ExtendType));
	}

	public void initSuborderId(String value) {
		this.initProperty(S_SuborderId, value);
	}

	public void setSuborderId(String value) {
		this.set(S_SuborderId, value);
	}

	public void setSuborderIdNull() {
		this.set(S_SuborderId, null);
	}

	public String getSuborderId() {
		return DataType.getAsString(this.get(S_SuborderId));

	}

	public long getSuborderIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_SuborderId));
	}

	public void initOpera(String value) {
		this.initProperty(S_Opera, value);
	}

	public void setOpera(String value) {
		this.set(S_Opera, value);
	}

	public void setOperaNull() {
		this.set(S_Opera, null);
	}

	public String getOpera() {
		return DataType.getAsString(this.get(S_Opera));

	}

	public String getOperaInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Opera));
	}

	public void initOldvalidateTime(String value) {
		this.initProperty(S_OldvalidateTime, value);
	}

	public void setOldvalidateTime(String value) {
		this.set(S_OldvalidateTime, value);
	}

	public void setOldvalidateTimeNull() {
		this.set(S_OldvalidateTime, null);
	}

	public String getOldvalidateTime() {
		return DataType.getAsString(this.get(S_OldvalidateTime));

	}

	public String getOldvalidateTimeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_OldvalidateTime));
	}

	public void initItemId(String value) {
		this.initProperty(S_ItemId, value);
	}

	public void setItemId(String value) {
		this.set(S_ItemId, value);
	}

	public void setItemIdNull() {
		this.set(S_ItemId, null);
	}

	public String getItemId() {
		return DataType.getAsString(this.get(S_ItemId));

	}

	public String getItemIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ItemId));
	}

	public void initOrdOprStime(String value) {
		this.initProperty(S_IsoverdureExtend, value);
	}

	public void setIsoverdureExtend(String value) {
		this.set(S_IsoverdureExtend, value);
	}

	public void setIsoverdureExtendNull() {
		this.set(S_IsoverdureExtend, null);
	}

	public String getIsoverdureExtend() {
		return DataType.getAsString(this.get(S_IsoverdureExtend));

	}

	public String getIsoverdureExtendInitialValue() {
		return DataType.getAsString(this.getOldObj(S_IsoverdureExtend));
	}

	public void initOperateTime(String value) {
		this.initProperty(S_OperateTime, value);
	}

	public void setOperateTime(String value) {
		this.set(S_OperateTime, value);
	}

	public void setOperateTimeNull() {
		this.set(S_OperateTime, null);
	}

	public String getOperateTime() {
		return DataType.getAsString(this.get(S_OperateTime));

	}

	public String getOperateTimeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_OperateTime));
	}

	public void initOrgId(String value) {
		this.initProperty(S_OrgId, value);
	}

	public void setOrgId(String value) {
		this.set(S_OrgId, value);
	}

	public void setOrgIdNull() {
		this.set(S_OrgId, null);
	}

	public String getOrgId() {
		return DataType.getAsString(this.get(S_OrgId));

	}

	public String getOrgIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_OrgId));
	}

	public void initNewvalidateTime(String value) {
		this.initProperty(S_NewvalidateTime, value);
	}

	public void setNewvalidateTime(String value) {
		this.set(S_NewvalidateTime, value);
	}

	public void setNewvalidateTimeNull() {
		this.set(S_NewvalidateTime, null);
	}

	public String getNewvalidateTime() {
		return DataType.getAsString(this.get(S_NewvalidateTime));

	}

	public String getMobile() {

		return DataType.getAsString(this.get(S_Mobile));
	}

	public void setMobile(String value) {

		this.set(S_Mobile, null);
	}
}
