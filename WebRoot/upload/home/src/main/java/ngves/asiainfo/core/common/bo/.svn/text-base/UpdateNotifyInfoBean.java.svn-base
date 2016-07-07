package ngves.asiainfo.core.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.common.ivalues.*;

public class UpdateNotifyInfoBean extends DataContainer implements DataContainerInterface, IUpdateNotifyInfoValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.common.bo.UpdateNotifyInfo";

	public final static String S_ItemStatus = "ITEM_STATUS";
	public final static String S_FailMessage = "FAIL_MESSAGE";
	public final static String S_NotifyType = "NOTIFY_TYPE";
	public final static String S_NotifyInfoId = "NOTIFY_INFO_ID";
	public final static String S_CreateTime = "CREATE_TIME";
	public final static String S_ItemId = "ITEM_ID";
	public final static String S_Status = "STATUS";
	public final static String S_RelationId = "RELATION_ID";

	public UpdateNotifyInfoBean() throws AIException {
		super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initItemStatus(String value) {
		this.initProperty(S_ItemStatus, value);
	}

	public void setItemStatus(String value) {
		this.set(S_ItemStatus, value);
	}

	public void setItemStatusNull() {
		this.set(S_ItemStatus, null);
	}

	public String getItemStatus() {
		return DataType.getAsString(this.get(S_ItemStatus));

	}

	public String getItemStatusInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ItemStatus));
	}

	public void initFailMessage(String value) {
		this.initProperty(S_FailMessage, value);
	}

	public void setFailMessage(String value) {
		this.set(S_FailMessage, value);
	}

	public void setFailMessageNull() {
		this.set(S_FailMessage, null);
	}

	public String getFailMessage() {
		return DataType.getAsString(this.get(S_FailMessage));

	}

	public String getFailMessageInitialValue() {
		return DataType.getAsString(this.getOldObj(S_FailMessage));
	}

	public void initNotifyType(String value) {
		this.initProperty(S_NotifyType, value);
	}

	public void setNotifyType(String value) {
		this.set(S_NotifyType, value);
	}

	public void setNotifyTypeNull() {
		this.set(S_NotifyType, null);
	}

	public String getNotifyType() {
		return DataType.getAsString(this.get(S_NotifyType));

	}

	public String getNotifyTypeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_NotifyType));
	}

	public void initNotifyInfoId(long value) {
		this.initProperty(S_NotifyInfoId, new Long(value));
	}

	public void setNotifyInfoId(long value) {
		this.set(S_NotifyInfoId, new Long(value));
	}

	public void setNotifyInfoIdNull() {
		this.set(S_NotifyInfoId, null);
	}

	public long getNotifyInfoId() {
		return DataType.getAsLong(this.get(S_NotifyInfoId));

	}

	public long getNotifyInfoIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_NotifyInfoId));
	}

	public void initCreateTime(Timestamp value) {
		this.initProperty(S_CreateTime, value);
	}

	public void setCreateTime(Timestamp value) {
		this.set(S_CreateTime, value);
	}

	public void setCreateTimeNull() {
		this.set(S_CreateTime, null);
	}

	public Timestamp getCreateTime() {
		return DataType.getAsDateTime(this.get(S_CreateTime));

	}

	public Timestamp getCreateTimeInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_CreateTime));
	}

	public void initItemId(long value) {
		this.initProperty(S_ItemId, new Long(value));
	}

	public void setItemId(long value) {
		this.set(S_ItemId, new Long(value));
	}

	public void setItemIdNull() {
		this.set(S_ItemId, null);
	}

	public long getItemId() {
		return DataType.getAsLong(this.get(S_ItemId));

	}

	public long getItemIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_ItemId));
	}

	public void initStatus(String value) {
		this.initProperty(S_Status, value);
	}

	public void setStatus(String value) {
		this.set(S_Status, value);
	}

	public void setStatusNull() {
		this.set(S_Status, null);
	}

	public String getStatus() {
		return DataType.getAsString(this.get(S_Status));

	}

	public String getStatusInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Status));
	}

	public void initRelationId(long value) {
		this.initProperty(S_RelationId, new Long(value));
	}

	public void setRelationId(long value) {
		this.set(S_RelationId, new Long(value));
	}

	public void setRelationIdNull() {
		this.set(S_RelationId, null);
	}

	public long getRelationId() {
		return DataType.getAsLong(this.get(S_RelationId));

	}

	public long getRelationIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_RelationId));
	}

}
