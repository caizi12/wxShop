package ngves.asiainfo.core.common.bo;

import ngves.asiainfo.core.common.ivalues.ISysParaDataValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class SysParaDataBean extends DataContainer implements DataContainerInterface, ISysParaDataValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.common.bo.SysParaData";

	public final static String S_ValidFlag = "VALID_FLAG";
	public final static String S_ParaId = "PARA_ID";
	public final static String S_IsMeta = "IS_META";
	public final static String S_ParaTypeId = "PARA_TYPE_ID";
	public final static String S_SortId = "SORT_ID";
	public final static String S_ParaAttr3 = "PARA_ATTR_3";
	public final static String S_ParaCode = "PARA_CODE";
	public final static String S_Note = "NOTE";
	public final static String S_ParaName = "PARA_NAME";
	public final static String S_ParaAttr1 = "PARA_ATTR_1";
	public final static String S_ParaAttr2 = "PARA_ATTR_2";

	public SysParaDataBean() throws AIException {
		super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initValidFlag(String value) {
		this.initProperty(S_ValidFlag, value);
	}

	public void setValidFlag(String value) {
		this.set(S_ValidFlag, value);
	}

	public void setValidFlagNull() {
		this.set(S_ValidFlag, null);
	}

	public String getValidFlag() {
		return DataType.getAsString(this.get(S_ValidFlag));

	}

	public String getValidFlagInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ValidFlag));
	}

	public void initParaId(long value) {
		this.initProperty(S_ParaId, new Long(value));
	}

	public void setParaId(long value) {
		this.set(S_ParaId, new Long(value));
	}

	public void setParaIdNull() {
		this.set(S_ParaId, null);
	}

	public long getParaId() {
		return DataType.getAsLong(this.get(S_ParaId));

	}

	public long getParaIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_ParaId));
	}

	public void initIsMeta(String value) {
		this.initProperty(S_IsMeta, value);
	}

	public void setIsMeta(String value) {
		this.set(S_IsMeta, value);
	}

	public void setIsMetaNull() {
		this.set(S_IsMeta, null);
	}

	public String getIsMeta() {
		return DataType.getAsString(this.get(S_IsMeta));

	}

	public String getIsMetaInitialValue() {
		return DataType.getAsString(this.getOldObj(S_IsMeta));
	}

	public void initParaTypeId(long value) {
		this.initProperty(S_ParaTypeId, new Long(value));
	}

	public void setParaTypeId(long value) {
		this.set(S_ParaTypeId, new Long(value));
	}

	public void setParaTypeIdNull() {
		this.set(S_ParaTypeId, null);
	}

	public long getParaTypeId() {
		return DataType.getAsLong(this.get(S_ParaTypeId));

	}

	public long getParaTypeIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_ParaTypeId));
	}

	public void initSortId(long value) {
		this.initProperty(S_SortId, new Long(value));
	}

	public void setSortId(long value) {
		this.set(S_SortId, new Long(value));
	}

	public void setSortIdNull() {
		this.set(S_SortId, null);
	}

	public long getSortId() {
		return DataType.getAsLong(this.get(S_SortId));

	}

	public long getSortIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_SortId));
	}

	public void initParaAttr3(String value) {
		this.initProperty(S_ParaAttr3, value);
	}

	public void setParaAttr3(String value) {
		this.set(S_ParaAttr3, value);
	}

	public void setParaAttr3Null() {
		this.set(S_ParaAttr3, null);
	}

	public String getParaAttr3() {
		return DataType.getAsString(this.get(S_ParaAttr3));

	}

	public String getParaAttr3InitialValue() {
		return DataType.getAsString(this.getOldObj(S_ParaAttr3));
	}

	public void initParaCode(String value) {
		this.initProperty(S_ParaCode, value);
	}

	public void setParaCode(String value) {
		this.set(S_ParaCode, value);
	}

	public void setParaCodeNull() {
		this.set(S_ParaCode, null);
	}

	public String getParaCode() {
		return DataType.getAsString(this.get(S_ParaCode));

	}

	public String getParaCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ParaCode));
	}

	public void initNote(String value) {
		this.initProperty(S_Note, value);
	}

	public void setNote(String value) {
		this.set(S_Note, value);
	}

	public void setNoteNull() {
		this.set(S_Note, null);
	}

	public String getNote() {
		return DataType.getAsString(this.get(S_Note));

	}

	public String getNoteInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Note));
	}

	public void initParaName(String value) {
		this.initProperty(S_ParaName, value);
	}

	public void setParaName(String value) {
		this.set(S_ParaName, value);
	}

	public void setParaNameNull() {
		this.set(S_ParaName, null);
	}

	public String getParaName() {
		return DataType.getAsString(this.get(S_ParaName));

	}

	public String getParaNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ParaName));
	}

	public void initParaAttr1(String value) {
		this.initProperty(S_ParaAttr1, value);
	}

	public void setParaAttr1(String value) {
		this.set(S_ParaAttr1, value);
	}

	public void setParaAttr1Null() {
		this.set(S_ParaAttr1, null);
	}

	public String getParaAttr1() {
		return DataType.getAsString(this.get(S_ParaAttr1));

	}

	public String getParaAttr1InitialValue() {
		return DataType.getAsString(this.getOldObj(S_ParaAttr1));
	}

	public void initParaAttr2(String value) {
		this.initProperty(S_ParaAttr2, value);
	}

	public void setParaAttr2(String value) {
		this.set(S_ParaAttr2, value);
	}

	public void setParaAttr2Null() {
		this.set(S_ParaAttr2, null);
	}

	public String getParaAttr2() {
		return DataType.getAsString(this.get(S_ParaAttr2));

	}

	public String getParaAttr2InitialValue() {
		return DataType.getAsString(this.getOldObj(S_ParaAttr2));
	}

}
