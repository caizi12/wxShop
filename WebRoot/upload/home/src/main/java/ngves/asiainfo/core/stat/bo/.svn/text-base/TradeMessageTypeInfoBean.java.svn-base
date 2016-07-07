package ngves.asiainfo.core.stat.bo;

import ngves.asiainfo.core.stat.ivalues.ITradeMessageTypeInfoValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class TradeMessageTypeInfoBean extends DataContainer implements DataContainerInterface,
		ITradeMessageTypeInfoValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2112389315243895077L;

	private static String m_boName = "ngves.asiainfo.core.stat.bo.TradeMessageTypeInfo";

	public final static String S_MessageTypeId = "MESSAGE_TYPE_ID";
	public final static String S_MessageTypeDesc = "MESSAGE_TYPE_DESC";
	public final static String S_MessageType = "MESSAGE_TYPE";
	public final static String S_MessageChannel = "MESSAGE_CHANNEL";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public TradeMessageTypeInfoBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型s");
	}

	public void initMessageTypeId(String value) {
		this.initProperty(S_MessageTypeId, value);
	}

	public void setMessageTypeId(String value) {
		this.set(S_MessageTypeId, value);
	}

	public void setMessageTypeIdNull() {
		this.set(S_MessageTypeId, null);
	}

	public String getMessageTypeId() {
		return DataType.getAsString(this.get(S_MessageTypeId));

	}

	public String getMessageTypeIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_MessageTypeId));
	}

	public void initMessageTypeDesc(String value) {
		this.initProperty(S_MessageTypeDesc, value);
	}

	public void setMessageTypeDesc(String value) {
		this.set(S_MessageTypeDesc, value);
	}

	public void setMessageTypeDescNull() {
		this.set(S_MessageTypeDesc, null);
	}

	public String getMessageTypeDesc() {
		return DataType.getAsString(this.get(S_MessageTypeDesc));

	}

	public String getMessageTypeDescInitialValue() {
		return DataType.getAsString(this.getOldObj(S_MessageTypeDesc));
	}

	public void initMessageType(String value) {
		this.initProperty(S_MessageType, value);
	}

	public void setMessageType(String value) {
		this.set(S_MessageType, value);
	}

	public void setMessageTypeNull() {
		this.set(S_MessageType, null);
	}

	public String getMessageType() {
		return DataType.getAsString(this.get(S_MessageType));

	}

	public String getMessageTypeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_MessageType));
	}

	public void initMessageChannel(String value) {
		this.initProperty(S_MessageChannel, value);
	}

	public void setMessageChannel(String value) {
		this.set(S_MessageChannel, value);
	}

	public void setMessageChannelNull() {
		this.set(S_MessageChannel, null);
	}

	public String getMessageChannel() {
		return DataType.getAsString(this.get(S_MessageChannel));

	}

	public String getMessageChannelInitialValue() {
		return DataType.getAsString(this.getOldObj(S_MessageChannel));
	}

}
