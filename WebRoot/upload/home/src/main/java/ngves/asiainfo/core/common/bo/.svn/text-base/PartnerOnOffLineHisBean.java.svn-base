package ngves.asiainfo.core.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.common.ivalues.*;

public class PartnerOnOffLineHisBean extends DataContainer implements DataContainerInterface, IPartnerOnOffLineHisValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3527506545051626685L;

	private static String m_boName = "ngves.asiainfo.core.common.bo.PartnerOnOffLineHis";

	public final static String S_PartnerTypeId = "PARTNER_TYPE_ID";
	public final static String S_PartnerName = "PARTNER_NAME";
	public final static String S_StaffId = "STAFF_ID";
	public final static String S_HisId = "HIS_ID";
	public final static String S_PartnerCode = "PARTNER_CODE";
	public final static String S_OnoffLine = "ONOFF_LINE";
	public final static String S_SettleCode = "SETTLE_CODE";
	public final static String S_PartnerId = "PARTNER_ID";
	public final static String S_OperDate = "OPER_DATE";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public PartnerOnOffLineHisBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initPartnerTypeId(String value) {
		this.initProperty(S_PartnerTypeId, value);
	}

	public void setPartnerTypeId(String value) {
		this.set(S_PartnerTypeId, value);
	}

	public void setPartnerTypeIdNull() {
		this.set(S_PartnerTypeId, null);
	}

	public String getPartnerTypeId() {
		return DataType.getAsString(this.get(S_PartnerTypeId));

	}

	public String getPartnerTypeIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_PartnerTypeId));
	}

	public void initPartnerName(String value) {
		this.initProperty(S_PartnerName, value);
	}

	public void setPartnerName(String value) {
		this.set(S_PartnerName, value);
	}

	public void setPartnerNameNull() {
		this.set(S_PartnerName, null);
	}

	public String getPartnerName() {
		return DataType.getAsString(this.get(S_PartnerName));

	}

	public String getPartnerNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_PartnerName));
	}

	public void initStaffId(long value) {
		this.initProperty(S_StaffId, new Long(value));
	}

	public void setStaffId(long value) {
		this.set(S_StaffId, new Long(value));
	}

	public void setStaffIdNull() {
		this.set(S_StaffId, null);
	}

	public long getStaffId() {
		return DataType.getAsLong(this.get(S_StaffId));

	}

	public long getStaffIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_StaffId));
	}

	public void initHisId(long value) {
		this.initProperty(S_HisId, new Long(value));
	}

	public void setHisId(long value) {
		this.set(S_HisId, new Long(value));
	}

	public void setHisIdNull() {
		this.set(S_HisId, null);
	}

	public long getHisId() {
		return DataType.getAsLong(this.get(S_HisId));

	}

	public long getHisIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_HisId));
	}

	public void initPartnerCode(String value) {
		this.initProperty(S_PartnerCode, value);
	}

	public void setPartnerCode(String value) {
		this.set(S_PartnerCode, value);
	}

	public void setPartnerCodeNull() {
		this.set(S_PartnerCode, null);
	}

	public String getPartnerCode() {
		return DataType.getAsString(this.get(S_PartnerCode));

	}

	public String getPartnerCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_PartnerCode));
	}

	public void initOnoffLine(String value) {
		this.initProperty(S_OnoffLine, value);
	}

	public void setOnoffLine(String value) {
		this.set(S_OnoffLine, value);
	}

	public void setOnoffLineNull() {
		this.set(S_OnoffLine, null);
	}

	public String getOnoffLine() {
		return DataType.getAsString(this.get(S_OnoffLine));

	}

	public String getOnoffLineInitialValue() {
		return DataType.getAsString(this.getOldObj(S_OnoffLine));
	}

	public void initSettleCode(String value) {
		this.initProperty(S_SettleCode, value);
	}

	public void setSettleCode(String value) {
		this.set(S_SettleCode, value);
	}

	public void setSettleCodeNull() {
		this.set(S_SettleCode, null);
	}

	public String getSettleCode() {
		return DataType.getAsString(this.get(S_SettleCode));

	}

	public String getSettleCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_SettleCode));
	}

	public void initPartnerId(long value) {
		this.initProperty(S_PartnerId, new Long(value));
	}

	public void setPartnerId(long value) {
		this.set(S_PartnerId, new Long(value));
	}

	public void setPartnerIdNull() {
		this.set(S_PartnerId, null);
	}

	public long getPartnerId() {
		return DataType.getAsLong(this.get(S_PartnerId));

	}

	public long getPartnerIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_PartnerId));
	}

	public void initOperDate(Timestamp value) {
		this.initProperty(S_OperDate, value);
	}

	public void setOperDate(Timestamp value) {
		this.set(S_OperDate, value);
	}

	public void setOperDateNull() {
		this.set(S_OperDate, null);
	}

	public Timestamp getOperDate() {
		return DataType.getAsDateTime(this.get(S_OperDate));

	}

	public Timestamp getOperDateInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_OperDate));
	}

}
