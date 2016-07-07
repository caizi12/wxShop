package ngves.asiainfo.core.ware.bo;

import ngves.asiainfo.core.ware.ivalues.IWarePCRltValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class WarePCRltBean extends DataContainer implements DataContainerInterface, IWarePCRltValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.ware.bo.WarePCRlt";

	public final static String S_WarePcRltId = "WARE_PC_RLT_ID";
	public final static String S_CWareId = "C_WARE_ID";
	public final static String S_BalCol = "BAL_COL";
	public final static String S_PWareId = "P_WARE_ID";

	public WarePCRltBean() throws AIException {
		super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initWarePcRltId(long value) {
		this.initProperty(S_WarePcRltId, new Long(value));
	}

	public void setWarePcRltId(long value) {
		this.set(S_WarePcRltId, new Long(value));
	}

	public void setWarePcRltIdNull() {
		this.set(S_WarePcRltId, null);
	}

	public long getWarePcRltId() {
		return DataType.getAsLong(this.get(S_WarePcRltId));

	}

	public long getWarePcRltIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_WarePcRltId));
	}


	public void initCWareId(long value) {
		this.initProperty(S_CWareId, new Long(value));
	}

	public void setCWareId(long value) {
		this.set(S_CWareId, new Long(value));
	}

	public void setCWareIdNull() {
		this.set(S_CWareId, null);
	}

	public long getCWareId() {
		return DataType.getAsLong(this.get(S_CWareId));

	}

	public long getCWareIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_CWareId));
	}

	public void initBalCol(String value) {
		this.initProperty(S_BalCol, value);
	}

	public void setBalCol(String value) {
		this.set(S_BalCol, value);
	}

	public void setBalColNull() {
		this.set(S_BalCol, null);
	}

	public String getBalCol() {
		return DataType.getAsString(this.get(S_BalCol));

	}

	public String getBalColInitialValue() {
		return DataType.getAsString(this.getOldObj(S_BalCol));
	}

	public void initPWareId(long value) {
		this.initProperty(S_PWareId, new Long(value));
	}

	public void setPWareId(long value) {
		this.set(S_PWareId, new Long(value));
	}

	public void setPWareIdNull() {
		this.set(S_PWareId, null);
	}

	public long getPWareId() {
		return DataType.getAsLong(this.get(S_PWareId));

	}

	public long getPWareIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_PWareId));
	}

}
