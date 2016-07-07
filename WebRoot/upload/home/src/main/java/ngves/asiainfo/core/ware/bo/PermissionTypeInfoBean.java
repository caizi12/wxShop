package ngves.asiainfo.core.ware.bo;

import ngves.asiainfo.core.ware.ivalues.IPermissionTypeInfoValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class PermissionTypeInfoBean extends DataContainer implements DataContainerInterface, IPermissionTypeInfoValue {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.ware.bo.PermissionTypeInfo";

	public final static String S_PermissionTypeId = "PERMISSION_TYPE_ID";
	public final static String S_PermissionId = "PERMISSION_ID";
	public final static String S_PermissionName = "PERMISSION_NAME";
	public final static String S_PermissionCode = "PERMISSION_CODE";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public PermissionTypeInfoBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initPermissionTypeId(long value) {
		this.initProperty(S_PermissionTypeId, new Long(value));
	}

	public void setPermissionTypeId(long value) {
		this.set(S_PermissionTypeId, new Long(value));
	}

	public void setPermissionTypeIdNull() {
		this.set(S_PermissionTypeId, null);
	}

	public long getPermissionTypeId() {
		return DataType.getAsLong(this.get(S_PermissionTypeId));

	}

	public long getPermissionTypeIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_PermissionTypeId));
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

	public void initPermissionName(String value) {
		this.initProperty(S_PermissionName, value);
	}

	public void setPermissionName(String value) {
		this.set(S_PermissionName, value);
	}

	public void setPermissionNameNull() {
		this.set(S_PermissionName, null);
	}

	public String getPermissionName() {
		return DataType.getAsString(this.get(S_PermissionName));

	}

	public String getPermissionNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_PermissionName));
	}

	public void initPermissionCode(String value) {
		this.initProperty(S_PermissionCode, value);
	}

	public void setPermissionCode(String value) {
		this.set(S_PermissionCode, value);
	}

	public void setPermissionCodeNull() {
		this.set(S_PermissionCode, null);
	}

	public String getPermissionCode() {
		return DataType.getAsString(this.get(S_PermissionCode));

	}

	public String getPermissionCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_PermissionCode));
	}

}
