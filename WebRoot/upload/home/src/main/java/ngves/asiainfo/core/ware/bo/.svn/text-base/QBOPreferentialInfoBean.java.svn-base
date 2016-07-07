package ngves.asiainfo.core.ware.bo;

import ngves.asiainfo.core.ware.ivalues.IQBOPreferentialInfoValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class QBOPreferentialInfoBean extends DataContainer implements DataContainerInterface, IQBOPreferentialInfoValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.ware.bo.QBOPreferentialInfo";

	public final static String S_WareGmeValue = "WARE_GME_VALUE";
	public final static String S_IsAllowDonation = "IS_ALLOW_DONATION";
	public final static String S_IsExchangePermission = "IS_EXCHANGE_PERMISSION";
	public final static String S_WareId = "WARE_ID";
	public final static String S_WareCode = "WARE_CODE";
	public final static String S_PermissionId = "PERMISSION_ID";

	public QBOPreferentialInfoBean() throws AIException {
		super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initWareGmeValue(long value) {
		this.initProperty(S_WareGmeValue, new Long(value));
	}

	public void setWareGmeValue(long value) {
		this.set(S_WareGmeValue, new Long(value));
	}

	public void setWareGmeValueNull() {
		this.set(S_WareGmeValue, null);
	}

	public long getWareGmeValue() {
		return DataType.getAsLong(this.get(S_WareGmeValue));

	}

	public long getWareGmeValueInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_WareGmeValue));
	}

	public void initIsAllowDonation(String value) {
		this.initProperty(S_IsAllowDonation, value);
	}

	public void setIsAllowDonation(String value) {
		this.set(S_IsAllowDonation, value);
	}

	public void setIsAllowDonationNull() {
		this.set(S_IsAllowDonation, null);
	}

	public String getIsAllowDonation() {
		return DataType.getAsString(this.get(S_IsAllowDonation));

	}

	public String getIsAllowDonationInitialValue() {
		return DataType.getAsString(this.getOldObj(S_IsAllowDonation));
	}

	public void initIsExchangePermission(String value) {
		this.initProperty(S_IsExchangePermission, value);
	}

	public void setIsExchangePermission(String value) {
		this.set(S_IsExchangePermission, value);
	}

	public void setIsExchangePermissionNull() {
		this.set(S_IsExchangePermission, null);
	}

	public String getIsExchangePermission() {
		return DataType.getAsString(this.get(S_IsExchangePermission));

	}

	public String getIsExchangePermissionInitialValue() {
		return DataType.getAsString(this.getOldObj(S_IsExchangePermission));
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

	public void initWareCode(String value) {
		this.initProperty(S_WareCode, value);
	}

	public void setWareCode(String value) {
		this.set(S_WareCode, value);
	}

	public void setWareCodeNull() {
		this.set(S_WareCode, null);
	}

	public String getWareCode() {
		return DataType.getAsString(this.get(S_WareCode));

	}

	public String getWareCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_WareCode));
	}

	public void initPermissionId(long value) {
		this.initProperty(S_PermissionId, new Long(value));
	}

	public void setPermissionId(long value) {
		this.set(S_PermissionId, new Long(value));
	}

	public void setPermissionIdNull() {
		this.set(S_PermissionId, null);
	}

	public long getPermissionId() {
		return DataType.getAsLong(this.get(S_PermissionId));

	}

	public long getPermissionIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_PermissionId));
	}
}
