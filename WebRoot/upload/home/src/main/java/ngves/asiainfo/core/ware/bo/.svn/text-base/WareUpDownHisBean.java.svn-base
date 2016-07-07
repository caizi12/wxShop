package ngves.asiainfo.core.ware.bo;

import java.sql.Timestamp;

import ngves.asiainfo.core.ware.ivalues.IWareUpDownHisValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class WareUpDownHisBean extends DataContainer implements DataContainerInterface, IWareUpDownHisValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.ware.bo.WareUpDownHis";

	public final static String S_OperateType = "OPERATE_TYPE";
	public final static String S_BakCol3 = "BAK_COL3";
	public final static String S_WareUpdownHisId = "WARE_UPDOWN_HIS_ID";
	public final static String S_Cause = "CAUSE";
	public final static String S_BakCol2 = "BAK_COL2";
	public final static String S_BakCol1 = "BAK_COL1";
	public final static String S_Note = "NOTE";
	public final static String S_UpdownTime = "UPDOWN_TIME";
	public final static String S_WareId = "WARE_ID";
    public final static String S_Operater="OPERATER";
    public final static String S_UpdownCause="UPDOWN_CAUSE";
    
	public WareUpDownHisBean() throws AIException {
		super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initOperateType(String value) {
		this.initProperty(S_OperateType, value);
	}

	public void setOperateType(String value) {
		this.set(S_OperateType, value);
	}

	public void setOperateTypeNull() {
		this.set(S_OperateType, null);
	}

	public String getOperateType() {
		return DataType.getAsString(this.get(S_OperateType));

	}

	public String getOperateTypeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_OperateType));
	}

	public void initBakCol3(String value) {
		this.initProperty(S_BakCol3, value);
	}

	public void setBakCol3(String value) {
		this.set(S_BakCol3, value);
	}

	public void setBakCol3Null() {
		this.set(S_BakCol3, null);
	}

	public String getBakCol3() {
		return DataType.getAsString(this.get(S_BakCol3));

	}

	public String getBakCol3InitialValue() {
		return DataType.getAsString(this.getOldObj(S_BakCol3));
	}

	public void initWareUpdownHisId(long value) {
		this.initProperty(S_WareUpdownHisId, new Long(value));
	}

	public void setWareUpdownHisId(long value) {
		this.set(S_WareUpdownHisId, new Long(value));
	}

	public void setWareUpdownHisIdNull() {
		this.set(S_WareUpdownHisId, null);
	}

	public long getWareUpdownHisId() {
		return DataType.getAsLong(this.get(S_WareUpdownHisId));

	}

	public long getWareUpdownHisIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_WareUpdownHisId));
	}

	public void initCause(String value) {
		this.initProperty(S_Cause, value);
	}

	public void setCause(String value) {
		this.set(S_Cause, value);
	}

	public void setCauseNull() {
		this.set(S_Cause, null);
	}

	public String getCause() {
		return DataType.getAsString(this.get(S_Cause));

	}

	public String getCauseInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Cause));
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

	public void initBakCol1(String value) {
		this.initProperty(S_BakCol1, value);
	}

	public void setBakCol1(String value) {
		this.set(S_BakCol1, value);
	}

	public void setBakCol1Null() {
		this.set(S_BakCol1, null);
	}

	public String getBakCol1() {
		return DataType.getAsString(this.get(S_BakCol1));

	}

	public String getBakCol1InitialValue() {
		return DataType.getAsString(this.getOldObj(S_BakCol1));
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

	public void initUpdownTime(Timestamp value) {
		this.initProperty(S_UpdownTime, value);
	}

	public void setUpdownTime(Timestamp value) {
		this.set(S_UpdownTime, value);
	}

	public void setUpdownTimeNull() {
		this.set(S_UpdownTime, null);
	}

	public Timestamp getUpdownTime() {
		return DataType.getAsDateTime(this.get(S_UpdownTime));

	}

	public Timestamp getUpdownTimeInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_UpdownTime));
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
	
	public void initOperater(String value) {
		this.initProperty(S_Operater, value);
	}

	public void setOperater(String value) {
		this.set(S_Operater, value);
	}

	public void setOperaterNull() {
		this.set(S_Operater, null);
	}

	public String getOperater() {
		return DataType.getAsString(this.get(S_Operater));

	}

	public String getOperaterInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Operater));
	}
	
	public void initUpdownCause(String value) {
		this.initProperty(S_UpdownCause, value);
	}

	public void setUpdownCause(String value) {
		this.set(S_UpdownCause, value);
	}

	public void setUpdownCauseNull() {
		this.set(S_UpdownCause, null);
	}

	public String getUpdownCause() {
		return DataType.getAsString(this.get(S_UpdownCause));

	}

	public String getUpdownCauseInitialValue() {
		return DataType.getAsString(this.getOldObj(S_UpdownCause));
	}

}
