package ngves.asiainfo.core.rushbuy.bo;

import java.sql.*;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.rushbuy.ivalues.*;

public class ActivityBindRelationBean extends DataContainer implements DataContainerInterface,
		IActivityBindRelationValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.rushbuy.bo.ActivityBindRelation";

	public final static String S_BaseMaxAmount = "BASE_MAX_AMOUNT";
	public final static String S_GrantMaxAmount = "GRANT_MAX_AMOUNT";
	public final static String S_BindTime = "BIND_TIME";
	public final static String S_ActivityId = "ACTIVITY_ID";
	public final static String S_WareId = "WARE_ID";
	public final static String S_Sort = "SORT";
	public final static String S_ActivityRelationId = "ACTIVITY_RELATION_ID";
	public final static String S_OneMaxAmount = "ONE_MAX_AMOUNT";
	public final static String S_WarePayType = "WARE_PAY_TYPE";
	

	public ActivityBindRelationBean() throws AIException {
		super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initBaseMaxAmount(long value) {
		this.initProperty(S_BaseMaxAmount, new Long(value));
	}

	public void setBaseMaxAmount(long value) {
		this.set(S_BaseMaxAmount, new Long(value));
	}

	public void setBaseMaxAmountNull() {
		this.set(S_BaseMaxAmount, null);
	}

	public long getBaseMaxAmount() {
		return DataType.getAsLong(this.get(S_BaseMaxAmount));

	}

	public long getBaseMaxAmountInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_BaseMaxAmount));
	}

	public void initGrantMaxAmount(long value) {
		this.initProperty(S_GrantMaxAmount, new Long(value));
	}

	public void setGrantMaxAmount(long value) {
		this.set(S_GrantMaxAmount, new Long(value));
	}

	public void setGrantMaxAmountNull() {
		this.set(S_GrantMaxAmount, null);
	}

	public long getGrantMaxAmount() {
		return DataType.getAsLong(this.get(S_GrantMaxAmount));

	}

	public long getGrantMaxAmountInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_GrantMaxAmount));
	}

	public void initBindTime(Timestamp value) {
		this.initProperty(S_BindTime, value);
	}

	public void setBindTime(Timestamp value) {
		this.set(S_BindTime, value);
	}

	public void setBindTimeNull() {
		this.set(S_BindTime, null);
	}

	public Timestamp getBindTime() {
		return DataType.getAsDateTime(this.get(S_BindTime));

	}

	public Timestamp getBindTimeInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_BindTime));
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


	public void initSort(long value) {
		this.initProperty(S_Sort, new Long(value));
	}

	public void setSort(long value) {
		this.set(S_Sort, new Long(value));
	}

	public void setSortNull() {
		this.set(S_Sort, null);
	}

	public long getSort() {
		return DataType.getAsLong(this.get(S_Sort));

	}

	public long getSortInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_Sort));
	}


	public void initActivityRelationId(long value) {
		this.initProperty(S_ActivityRelationId, new Long(value));
	}

	public void setActivityRelationId(long value) {
		this.set(S_ActivityRelationId, new Long(value));
	}

	public void setActivityRelationIdNull() {
		this.set(S_ActivityRelationId, null);
	}

	public long getActivityRelationId() {
		return DataType.getAsLong(this.get(S_ActivityRelationId));

	}

	public long getActivityRelationIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_ActivityRelationId));
	}

	public void initOneMaxAmount(long value) {
		this.initProperty(S_OneMaxAmount, new Long(value));
	}

	public void setOneMaxAmount(long value) {
		this.set(S_OneMaxAmount, new Long(value));
	}

	public void setOneMaxAmountNull() {
		this.set(S_OneMaxAmount, null);
	}

	public long getOneMaxAmount() {
		return DataType.getAsLong(this.get(S_OneMaxAmount));

	}

	public long getOneMaxAmountInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_OneMaxAmount));
	}
	
	public void initWarePayType(String value) {
		this.initProperty(S_WarePayType, value);
	}

	public void setWarePayType(String value) {
		this.set(S_WarePayType, value);
	}

	public void setWarePayTypeNull() {
		this.set(S_WarePayType, null);
	}

	public String getWarePayType() {
		return DataType.getAsString(this.get(S_WarePayType));

	}

	public String getWarePayTypeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_WarePayType));
	}
	
}
