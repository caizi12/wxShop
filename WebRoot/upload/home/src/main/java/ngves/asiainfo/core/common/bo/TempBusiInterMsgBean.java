package ngves.asiainfo.core.common.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.common.ivalues.*;

public class TempBusiInterMsgBean extends DataContainer implements DataContainerInterface, ITempBusiInterMsgValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6068941042099105368L;

	private static String m_boName = "ngves.asiainfo.core.common.bo.TempBusiInterMsg";

	public final static String S_Msg = "MSG";
	public final static String S_BusiId = "BUSI_ID";

	public TempBusiInterMsgBean() throws AIException {
		super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initMsg(String value) {
		this.initProperty(S_Msg, value);
	}

	public void setMsg(String value) {
		this.set(S_Msg, value);
	}

	public void setMsgNull() {
		this.set(S_Msg, null);
	}

	public String getMsg() {
		return DataType.getAsString(this.get(S_Msg));

	}

	public String getMsgInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Msg));
	}

	public void initBusiId(long value) {
		this.initProperty(S_BusiId, new Long(value));
	}

	public void setBusiId(long value) {
		this.set(S_BusiId, new Long(value));
	}

	public void setBusiIdNull() {
		this.set(S_BusiId, null);
	}

	public long getBusiId() {
		return DataType.getAsLong(this.get(S_BusiId));

	}

	public long getBusiIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_BusiId));
	}

}
