package ngves.asiainfo.core.ware.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.ware.ivalues.*;

@SuppressWarnings("serial")
public class BrandCategoryInfoBean extends DataContainer implements DataContainerInterface, IBrandCategoryInfoValue {

	private static String m_boName = "ngves.asiainfo.core.ware.bo.BrandCategoryInfo";

	public final static String S_CategoryId = "CATEGORY_ID";
	public final static String S_IsSpell = "IS_SPELL";
	public final static String S_BrandShowName = "BRAND_SHOW_NAME";
	public final static String S_SpellSatrtTime = "SPELL_SATRT_TIME";
	public final static String S_SpellInternalLength = "SPELL_INTERNAL_LENGTH";
	public final static String S_BrandShowId = "BRAND_SHOW_ID";
	public final static  String S_CycleNum = "CYCLE_NUM";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public BrandCategoryInfoBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initCategoryId(long value) {
		this.initProperty(S_CategoryId, new Long(value));
	}

	public void setCategoryId(long value) {
		this.set(S_CategoryId, new Long(value));
	}

	public void setCategoryIdNull() {
		this.set(S_CategoryId, null);
	}

	public long getCategoryId() {
		return DataType.getAsLong(this.get(S_CategoryId));

	}

	public long getCategoryIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_CategoryId));
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

	public void initBrandShowName(String value) {
		this.initProperty(S_BrandShowName, value);
	}

	public void setBrandShowName(String value) {
		this.set(S_BrandShowName, value);
	}

	public void setBrandShowNameNull() {
		this.set(S_BrandShowName, null);
	}

	public String getBrandShowName() {
		return DataType.getAsString(this.get(S_BrandShowName));

	}

	public String getBrandShowNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_BrandShowName));
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

	public void initBrandShowId(long value) {
		this.initProperty(S_BrandShowId, new Long(value));
	}

	public void setBrandShowId(long value) {
		this.set(S_BrandShowId, new Long(value));
	}

	public void setBrandShowIdNull() {
		this.set(S_BrandShowId, null);
	}

	public long getBrandShowId() {
		return DataType.getAsLong(this.get(S_BrandShowId));

	}

	public long getBrandShowIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_BrandShowId));
	}
	
	public void initCycleNum(long value) {
		this.initProperty(S_CycleNum, new Long(value));
	}

	public void setCycleNum(long value) {
		this.set(S_CycleNum, new Long(value));
	}

	public void setCycleNumNull() {
		this.set(S_CycleNum, null);
	}

	public long getCycleNum() {
		return DataType.getAsLong(this.get(S_CycleNum));

	}

	public long getCycleNumInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_CycleNum));
	}

}
