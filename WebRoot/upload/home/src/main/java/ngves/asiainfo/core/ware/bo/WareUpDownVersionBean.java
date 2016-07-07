package ngves.asiainfo.core.ware.bo;

import ngves.asiainfo.core.ware.ivalues.IWareUpDownVersionValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class WareUpDownVersionBean extends DataContainer implements DataContainerInterface, IWareUpDownVersionValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.ware.bo.WareUpDownVersion";

	public final static String S_AppVersion = "APP_VERSION";
	public final static String S_WareStatus = "WARE_STATUS";
	public final static String S_WareId = "WARE_ID";

	public WareUpDownVersionBean() throws AIException {
		super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
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

	public void initWareStatus(String value) {
		this.initProperty(S_WareStatus, value);
	}

	public void setWareStatus(String value) {
		this.set(S_WareStatus, value);
	}

	public void setWareStatusNull() {
		this.set(S_WareStatus, null);
	}

	public String getWareStatus() {
		return DataType.getAsString(this.get(S_WareStatus));

	}

	public String getWareStatusInitialValue() {
		return DataType.getAsString(this.getOldObj(S_WareStatus));
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
