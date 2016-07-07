package ngves.asiainfo.core.ware.bo;

import ngves.asiainfo.core.ware.ivalues.IQBOWareProvDeliverFeeValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class QBOWareProvDeliverFeeBean extends DataContainer implements DataContainerInterface,
		IQBOWareProvDeliverFeeValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.ware.bo.QBOWareProvDeliverFee";

	public final static String S_ProvIntegralValue = "PROV_INTEGRAL_VALUE";
	public final static String S_WareId = "WARE_ID";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public QBOWareProvDeliverFeeBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initProvIntegralValue(String value) {
		this.initProperty(S_ProvIntegralValue, value);
	}

	public void setProvIntegralValue(String value) {
		this.set(S_ProvIntegralValue, value);
	}

	public void setProvIntegralValueNull() {
		this.set(S_ProvIntegralValue, null);
	}

	public String getProvIntegralValue() {
		return DataType.getAsString(this.get(S_ProvIntegralValue));

	}

	public String getProvIntegralValueInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ProvIntegralValue));
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
