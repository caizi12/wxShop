package ngves.asiainfo.core.ware.bo;

import ngves.asiainfo.core.ware.ivalues.IwareWeekRankValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class wareWeekRankBean extends DataContainer implements DataContainerInterface, IwareWeekRankValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2184545827353314673L;

	private static String m_boName = "ngves.asiainfo.core.ware.bo.wareWeekRank";

	public final static String S_WareBrandId = "WARE_BRAND_ID";
	public final static String S_WareIds = "WARE_IDS";
	public final static String S_IsParent = "IS_PARENT";
	public final static String S_WareWeekRankId = "WARE_WEEK_RANK_ID";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public wareWeekRankBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initWareBrandId(long value) {
		this.initProperty(S_WareBrandId, new Long(value));
	}

	public void setWareBrandId(long value) {
		this.set(S_WareBrandId, new Long(value));
	}

	public void setWareBrandIdNull() {
		this.set(S_WareBrandId, null);
	}

	public long getWareBrandId() {
		return DataType.getAsLong(this.get(S_WareBrandId));

	}

	public long getWareBrandIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_WareBrandId));
	}

	public void initWareIds(String value) {
		this.initProperty(S_WareIds, value);
	}

	public void setWareIds(String value) {
		this.set(S_WareIds, value);
	}

	public void setWareIdsNull() {
		this.set(S_WareIds, null);
	}

	public String getWareIds() {
		return DataType.getAsString(this.get(S_WareIds));

	}

	public String getWareIdsInitialValue() {
		return DataType.getAsString(this.getOldObj(S_WareIds));
	}

	public void initIsParent(long value) {
		this.initProperty(S_IsParent, new Long(value));
	}

	public void setIsParent(long value) {
		this.set(S_IsParent, new Long(value));
	}

	public void setIsParentNull() {
		this.set(S_IsParent, null);
	}

	public long getIsParent() {
		return DataType.getAsLong(this.get(S_IsParent));

	}

	public long getIsParentInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_IsParent));
	}

	public void initWareWeekRankId(long value) {
		this.initProperty(S_WareWeekRankId, new Long(value));
	}

	public void setWareWeekRankId(long value) {
		this.set(S_WareWeekRankId, new Long(value));
	}

	public void setWareWeekRankIdNull() {
		this.set(S_WareWeekRankId, null);
	}

	public long getWareWeekRankId() {
		return DataType.getAsLong(this.get(S_WareWeekRankId));

	}

	public long getWareWeekRankIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_WareWeekRankId));
	}

}
