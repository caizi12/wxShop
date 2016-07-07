package ngves.asiainfo.core.tuan.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.tuan.ivalues.*;

public class TuanCycleInfoBean extends DataContainer implements DataContainerInterface, ITuanCycleInfoValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.tuan.bo.TuanCycleInfo";

	public final static String S_IsSpell = "IS_SPELL";
	public final static String S_GroupCode = "GROUP_CODE";
	public final static String S_BakCol = "BAK_COL";
	public final static String S_ShowType = "SHOW_TYPE";
	public final static String S_BakCol2 = "BAK_COL2";
	public final static String S_SpellSatrtTime = "SPELL_SATRT_TIME";
	public final static String S_SpellInternalLength = "SPELL_INTERNAL_LENGTH";
	public final static String S_SpellCycleId = "SPELL_CYCLE_ID";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public TuanCycleInfoBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initIsSpell(long value) {
		this.initProperty(S_IsSpell, new Long(value));
	}

	public void setIsSpell(long value) {
		this.set(S_IsSpell, new Long(value));
	}

	public void setIsSpellNull() {
		this.set(S_IsSpell, null);
	}

	public long getIsSpell() {
		return DataType.getAsLong(this.get(S_IsSpell));

	}

	public long getIsSpellInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_IsSpell));
	}

	public void initGroupCode(String value) {
		this.initProperty(S_GroupCode, value);
	}

	public void setGroupCode(String value) {
		this.set(S_GroupCode, value);
	}

	public void setGroupCodeNull() {
		this.set(S_GroupCode, null);
	}

	public String getGroupCode() {
		return DataType.getAsString(this.get(S_GroupCode));

	}

	public String getGroupCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_GroupCode));
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

	public void initShowType(String value) {
		this.initProperty(S_ShowType, value);
	}

	public void setShowType(String value) {
		this.set(S_ShowType, value);
	}

	public void setShowTypeNull() {
		this.set(S_ShowType, null);
	}

	public String getShowType() {
		return DataType.getAsString(this.get(S_ShowType));

	}

	public String getShowTypeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ShowType));
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

	public void initSpellSatrtTime(Timestamp value) {
		this.initProperty(S_SpellSatrtTime, value);
	}

	public void setSpellSatrtTime(Timestamp value) {
		this.set(S_SpellSatrtTime, value);
	}

	public void setSpellSatrtTimeNull() {
		this.set(S_SpellSatrtTime, null);
	}

	public Timestamp getSpellSatrtTime() {
		return DataType.getAsDateTime(this.get(S_SpellSatrtTime));

	}

	public Timestamp getSpellSatrtTimeInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_SpellSatrtTime));
	}

	public void initSpellInternalLength(long value) {
		this.initProperty(S_SpellInternalLength, new Long(value));
	}

	public void setSpellInternalLength(long value) {
		this.set(S_SpellInternalLength, new Long(value));
	}

	public void setSpellInternalLengthNull() {
		this.set(S_SpellInternalLength, null);
	}

	public long getSpellInternalLength() {
		return DataType.getAsLong(this.get(S_SpellInternalLength));

	}

	public long getSpellInternalLengthInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_SpellInternalLength));
	}

	public void initSpellCycleId(long value) {
		this.initProperty(S_SpellCycleId, new Long(value));
	}

	public void setSpellCycleId(long value) {
		this.set(S_SpellCycleId, new Long(value));
	}

	public void setSpellCycleIdNull() {
		this.set(S_SpellCycleId, null);
	}

	public long getSpellCycleId() {
		return DataType.getAsLong(this.get(S_SpellCycleId));

	}

	public long getSpellCycleIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_SpellCycleId));
	}

}
