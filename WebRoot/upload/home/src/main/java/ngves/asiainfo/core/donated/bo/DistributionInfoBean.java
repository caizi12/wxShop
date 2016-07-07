package ngves.asiainfo.core.donated.bo;

import ngves.asiainfo.core.donated.ivalues.IDistributionInfoValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class DistributionInfoBean extends DataContainer implements DataContainerInterface, IDistributionInfoValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.donated.bo.DistributionInfo";

	public final static String S_Phone = "PHONE";
	public final static String S_BakCol = "BAK_COL";
	public final static String S_ZipCode = "ZIP_CODE";
	public final static String S_CountyCode = "COUNTY_CODE";
	public final static String S_CityCode = "CITY_CODE";
	public final static String S_BakCol2 = "BAK_COL2";
	public final static String S_Address = "ADDRESS";
	public final static String S_Email = "EMAIL";
	public final static String S_ProvinceCode = "PROVINCE_CODE";
	public final static String S_DistributionId = "DISTRIBUTION_ID";

	public DistributionInfoBean() throws AIException {
		super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initPhone(long value) {
		this.initProperty(S_Phone, new Long(value));
	}

	public void setPhone(long value) {
		this.set(S_Phone, new Long(value));
	}

	public void setPhoneNull() {
		this.set(S_Phone, null);
	}

	public long getPhone() {
		return DataType.getAsLong(this.get(S_Phone));

	}

	public long getPhoneInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_Phone));
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

	public void initZipCode(long value) {
		this.initProperty(S_ZipCode, new Long(value));
	}

	public void setZipCode(long value) {
		this.set(S_ZipCode, new Long(value));
	}

	public void setZipCodeNull() {
		this.set(S_ZipCode, null);
	}

	public long getZipCode() {
		return DataType.getAsLong(this.get(S_ZipCode));

	}

	public long getZipCodeInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_ZipCode));
	}

	public void initCountyCode(String value) {
		this.initProperty(S_CountyCode, value);
	}

	public void setCountyCode(String value) {
		this.set(S_CountyCode, value);
	}

	public void setCountyCodeNull() {
		this.set(S_CountyCode, null);
	}

	public String getCountyCode() {
		return DataType.getAsString(this.get(S_CountyCode));

	}

	public String getCountyCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_CountyCode));
	}

	public void initCityCode(String value) {
		this.initProperty(S_CityCode, value);
	}

	public void setCityCode(String value) {
		this.set(S_CityCode, value);
	}

	public void setCityCodeNull() {
		this.set(S_CityCode, null);
	}

	public String getCityCode() {
		return DataType.getAsString(this.get(S_CityCode));

	}

	public String getCityCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_CityCode));
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

	public void initAddress(String value) {
		this.initProperty(S_Address, value);
	}

	public void setAddress(String value) {
		this.set(S_Address, value);
	}

	public void setAddressNull() {
		this.set(S_Address, null);
	}

	public String getAddress() {
		return DataType.getAsString(this.get(S_Address));

	}

	public String getAddressInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Address));
	}

	public void initEmail(String value) {
		this.initProperty(S_Email, value);
	}

	public void setEmail(String value) {
		this.set(S_Email, value);
	}

	public void setEmailNull() {
		this.set(S_Email, null);
	}

	public String getEmail() {
		return DataType.getAsString(this.get(S_Email));

	}

	public String getEmailInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Email));
	}

	public void initProvinceCode(String value) {
		this.initProperty(S_ProvinceCode, value);
	}

	public void setProvinceCode(String value) {
		this.set(S_ProvinceCode, value);
	}

	public void setProvinceCodeNull() {
		this.set(S_ProvinceCode, null);
	}

	public String getProvinceCode() {
		return DataType.getAsString(this.get(S_ProvinceCode));

	}

	public String getProvinceCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ProvinceCode));
	}

	public void initDistributionId(long value) {
		this.initProperty(S_DistributionId, new Long(value));
	}

	public void setDistributionId(long value) {
		this.set(S_DistributionId, new Long(value));
	}

	public void setDistributionIdNull() {
		this.set(S_DistributionId, null);
	}

	public long getDistributionId() {
		return DataType.getAsLong(this.get(S_DistributionId));

	}

	public long getDistributionIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_DistributionId));
	}

}
