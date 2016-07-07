package ngves.asiainfo.core.viphall.bo;

import ngves.asiainfo.core.viphall.ivalues.IQBOVipWareDescValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class QBOVipWareDescBean extends DataContainer implements DataContainerInterface, IQBOVipWareDescValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.viphall.bo.QBOVipWareDesc";

	public final static String S_IsOnline = "IS_ONLINE";
	public final static String S_WareDescValue = "WARE_DESC_VALUE";
	public final static String S_DescDefineId = "DESC_DEFINE_ID";
	public final static String S_TypeCode = "TYPE_CODE";
	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public QBOVipWareDescBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initIsOnline(String value) {
		this.initProperty(S_IsOnline, value);
	}

	public void setIsOnline(String value) {
		this.set(S_IsOnline, value);
	}

	public void setIsOnlineNull() {
		this.set(S_IsOnline, null);
	}

	public String getIsOnline() {
		return DataType.getAsString(this.get(S_IsOnline));

	}

	public String getIsOnlineInitialValue() {
		return DataType.getAsString(this.getOldObj(S_IsOnline));
	}

	public void initWareDescValue(String value) {
		this.initProperty(S_WareDescValue, value);
	}

	public void setWareDescValue(String value) {
		this.set(S_WareDescValue, value);
	}

	public void setWareDescValueNull() {
		this.set(S_WareDescValue, null);
	}

	public String getWareDescValue() {
		return DataType.getAsString(this.get(S_WareDescValue));

	}

	public String getWareDescValueInitialValue() {
		return DataType.getAsString(this.getOldObj(S_WareDescValue));
	}

	public void initDescDefineId(long value) {
		this.initProperty(S_DescDefineId, new Long(value));
	}

	public void setDescDefineId(long value) {
		this.set(S_DescDefineId, new Long(value));
	}

	public void setDescDefineIdNull() {
		this.set(S_DescDefineId, null);
	}

	public long getDescDefineId() {
		return DataType.getAsLong(this.get(S_DescDefineId));

	}

	public long getDescDefineIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_DescDefineId));
	}

	
	public void initTypeCode(String value) {
		this.initProperty(S_TypeCode, value);
	}

	public void setTypeCode(String value) {
		this.set(S_TypeCode, value);
	}

	public void setTypeCodeNull() {
		this.set(S_TypeCode, null);
	}

	public String getTypeCode() {
		return DataType.getAsString(this.get(S_TypeCode));

	}

	public String getTypeCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_TypeCode));
	}
}
