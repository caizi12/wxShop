package ngves.asiainfo.core.viphall.bo;

import ngves.asiainfo.core.viphall.ivalues.IVipHallCountValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class VipHallCountBean extends DataContainer implements DataContainerInterface, IVipHallCountValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.viphall.bo.VipHallCount";

	public final static String S_KindTotalCount = "KIND_TOTAL_COUNT";
	public final static String S_ProvcodeCount = "PROVCODE_COUNT";
	public final static String S_WareKindId = "WARE_KIND_ID";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public VipHallCountBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initKindTotalCount(long value) {
		this.initProperty(S_KindTotalCount, new Long(value));
	}

	public void setKindTotalCount(long value) {
		this.set(S_KindTotalCount, new Long(value));
	}

	public void setKindTotalCountNull() {
		this.set(S_KindTotalCount, null);
	}

	public long getKindTotalCount() {
		return DataType.getAsLong(this.get(S_KindTotalCount));

	}

	public long getKindTotalCountInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_KindTotalCount));
	}

	public void initProvcodeCount(String value) {
		this.initProperty(S_ProvcodeCount, value);
	}

	public void setProvcodeCount(String value) {
		this.set(S_ProvcodeCount, value);
	}

	public void setProvcodeCountNull() {
		this.set(S_ProvcodeCount, null);
	}

	public String getProvcodeCount() {
		return DataType.getAsString(this.get(S_ProvcodeCount));

	}

	public String getProvcodeCountInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ProvcodeCount));
	}

	public void initWareKindId(long value) {
		this.initProperty(S_WareKindId, new Long(value));
	}

	public void setWareKindId(long value) {
		this.set(S_WareKindId, new Long(value));
	}

	public void setWareKindIdNull() {
		this.set(S_WareKindId, null);
	}

	public long getWareKindId() {
		return DataType.getAsLong(this.get(S_WareKindId));

	}

	public long getWareKindIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_WareKindId));
	}

}
