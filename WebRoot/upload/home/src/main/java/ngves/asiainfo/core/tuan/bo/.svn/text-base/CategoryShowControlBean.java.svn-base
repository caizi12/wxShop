package ngves.asiainfo.core.tuan.bo;

import ngves.asiainfo.core.tuan.ivalues.ICategoryShowControlValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class CategoryShowControlBean extends DataContainer implements DataContainerInterface, ICategoryShowControlValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7842661397742027532L;

	private static String m_boName = "ngves.asiainfo.core.tuan.bo.CategoryShowControl";

	public final static String S_ShowName = "SHOW_NAME";
	public final static String S_BakCol = "BAK_COL";
	public final static String S_IsShow = "IS_SHOW";
	public final static String S_BakCol2 = "BAK_COL2";
	public final static String S_ShowId = "SHOW_ID";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public CategoryShowControlBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initShowName(String value) {
		this.initProperty(S_ShowName, value);
	}

	public void setShowName(String value) {
		this.set(S_ShowName, value);
	}

	public void setShowNameNull() {
		this.set(S_ShowName, null);
	}

	public String getShowName() {
		return DataType.getAsString(this.get(S_ShowName));

	}

	public String getShowNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ShowName));
	}

	public void initBakCol(String value) {
		this.initProperty(S_BakCol, value);
	}

	public void setBakCol(String value) {
		this.set(S_BakCol, value);
	}

	public void setBakColNull() {
		this.set(S_BakCol, null);
	}

	public String getBakCol() {
		return DataType.getAsString(this.get(S_BakCol));

	}

	public String getBakColInitialValue() {
		return DataType.getAsString(this.getOldObj(S_BakCol));
	}

	public void initIsShow(String value) {
		this.initProperty(S_IsShow, value);
	}

	public void setIsShow(String value) {
		this.set(S_IsShow, value);
	}

	public void setIsShowNull() {
		this.set(S_IsShow, null);
	}

	public String getIsShow() {
		return DataType.getAsString(this.get(S_IsShow));

	}

	public String getIsShowInitialValue() {
		return DataType.getAsString(this.getOldObj(S_IsShow));
	}

	public void initBakCol2(String value) {
		this.initProperty(S_BakCol2, value);
	}

	public void setBakCol2(String value) {
		this.set(S_BakCol2, value);
	}

	public void setBakCol2Null() {
		this.set(S_BakCol2, null);
	}

	public String getBakCol2() {
		return DataType.getAsString(this.get(S_BakCol2));

	}

	public String getBakCol2InitialValue() {
		return DataType.getAsString(this.getOldObj(S_BakCol2));
	}

	public void initShowId(long value) {
		this.initProperty(S_ShowId, new Long(value));
	}

	public void setShowId(long value) {
		this.set(S_ShowId, new Long(value));
	}

	public void setShowIdNull() {
		this.set(S_ShowId, null);
	}

	public long getShowId() {
		return DataType.getAsLong(this.get(S_ShowId));

	}

	public long getShowIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_ShowId));
	}

}
