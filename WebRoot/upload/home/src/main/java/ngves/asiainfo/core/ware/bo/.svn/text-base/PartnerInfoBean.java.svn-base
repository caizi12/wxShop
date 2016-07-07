package ngves.asiainfo.core.ware.bo;

import java.sql.Timestamp;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.ware.ivalues.IPartnerInfoValue;

public class PartnerInfoBean extends DataContainer implements DataContainerInterface, IPartnerInfoValue {

	/**
	   * 
	   */
	private static final long serialVersionUID = -117947683155615302L;
	private static String m_boName = "ngves.asiainfo.core.ware.bo.PartnerInfo";

	public final static String S_CallcenterFileName = "CALLCENTER_FILE_NAME";
	public final static String S_CallcenterNo = "CALLCENTER_NO";
	public final static String S_PartnerLongName = "PARTNER_LONG_NAME";
	public final static String S_CreateDate = "CREATE_DATE";
	public final static String S_PartnerTypeId = "PARTNER_TYPE_ID";
	public final static String S_CurStatus = "CUR_STATUS";
	public final static String S_PartnerName = "PARTNER_NAME";
	public final static String S_StatusDate = "STATUS_DATE";
	public final static String S_FrdbLxInfo = "FRDB_LX_INFO";
	public final static String S_CompanyDesc = "COMPANY_DESC";
	public final static String S_ProvinceCode = "PROVINCE_CODE";
	public final static String S_PostAddr = "POST_ADDR";
	public final static String S_PartnerCode = "PARTNER_CODE";
	public final static String S_PostCode = "POST_CODE";
	public final static String S_CompanyName = "COMPANY_NAME";
	public final static String S_PartnerId = "PARTNER_ID";
	public final static String S_OrgId = "ORG_ID";
	public final static String S_FrdbName = "FRDB_NAME";

	public final static String S_PartnerOrg = "PARTNER_ORG";
	public final static String S_PartnerStaff = "PARTNER_STAFF";
	public final static String S_PartnerAuth = "PARTNER_AUTH";
	public final static String S_OnOffLineDate = "ONOFFLINE_DATE";
	public final static String S_AppVersion = "APP_VERSION";
	public final static String S_FetionCode = "FETION_CODE";
	
	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public PartnerInfoBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initCallcenterFileName(String value) {
		this.initProperty(S_CallcenterFileName, value);
	}

	public void setCallcenterFileName(String value) {
		this.set(S_CallcenterFileName, value);
	}

	public void setCallcenterFileNameNull() {
		this.set(S_CallcenterFileName, null);
	}

	public String getCallcenterFileName() {
		return DataType.getAsString(this.get(S_CallcenterFileName));

	}

	public String getCallcenterFileNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_CallcenterFileName));
	}

	public void initCallcenterNo(String value) {
		this.initProperty(S_CallcenterNo, value);
	}

	public void setCallcenterNo(String value) {
		this.set(S_CallcenterNo, value);
	}

	public void setCallcenterNoNull() {
		this.set(S_CallcenterNo, null);
	}

	public String getCallcenterNo() {
		return DataType.getAsString(this.get(S_CallcenterNo));

	}

	public String getCallcenterNoInitialValue() {
		return DataType.getAsString(this.getOldObj(S_CallcenterNo));
	}

	public void initPartnerLongName(String value) {
		this.initProperty(S_PartnerLongName, value);
	}

	public void setPartnerLongName(String value) {
		this.set(S_PartnerLongName, value);
	}

	public void setPartnerLongNameNull() {
		this.set(S_PartnerLongName, null);
	}

	public String getPartnerLongName() {
		return DataType.getAsString(this.get(S_PartnerLongName));

	}

	public String getPartnerLongNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_PartnerLongName));
	}

	public void initCreateDate(Timestamp value) {
		this.initProperty(S_CreateDate, value);
	}

	public void setCreateDate(Timestamp value) {
		this.set(S_CreateDate, value);
	}

	public void setCreateDateNull() {
		this.set(S_CreateDate, null);
	}

	public Timestamp getCreateDate() {
		return DataType.getAsDateTime(this.get(S_CreateDate));

	}

	public Timestamp getCreateDateInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_CreateDate));
	}

	public void initPartnerTypeId(String value) {
		this.initProperty(S_PartnerTypeId, value);
	}

	public void setPartnerTypeId(String value) {
		this.set(S_PartnerTypeId, value);
	}

	public void setPartnerTypeIdNull() {
		this.set(S_PartnerTypeId, null);
	}

	public String getPartnerTypeId() {
		return DataType.getAsString(this.get(S_PartnerTypeId));

	}

	public String getPartnerTypeIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_PartnerTypeId));
	}

	public void initCurStatus(long value) {
		this.initProperty(S_CurStatus, Long.valueOf(value));
	}

	public void setCurStatus(long value) {
		this.set(S_CurStatus, Long.valueOf(value));
	}

	public void setCurStatusNull() {
		this.set(S_CurStatus, null);
	}

	public long getCurStatus() {
		return DataType.getAsLong(this.get(S_CurStatus));

	}

	public long getCurStatusInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_CurStatus));
	}

	public void initPartnerName(String value) {
		this.initProperty(S_PartnerName, value);
	}

	public void setPartnerName(String value) {
		this.set(S_PartnerName, value);
	}

	public void setPartnerNameNull() {
		this.set(S_PartnerName, null);
	}

	public String getPartnerName() {
		return DataType.getAsString(this.get(S_PartnerName));

	}

	public String getPartnerNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_PartnerName));
	}

	public void initStatusDate(Timestamp value) {
		this.initProperty(S_StatusDate, value);
	}

	public void setStatusDate(Timestamp value) {
		this.set(S_StatusDate, value);
	}

	public void setStatusDateNull() {
		this.set(S_StatusDate, null);
	}

	public Timestamp getStatusDate() {
		return DataType.getAsDateTime(this.get(S_StatusDate));

	}

	public Timestamp getStatusDateInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_StatusDate));
	}

	public void initFrdbLxInfo(String value) {
		this.initProperty(S_FrdbLxInfo, value);
	}

	public void setFrdbLxInfo(String value) {
		this.set(S_FrdbLxInfo, value);
	}

	public void setFrdbLxInfoNull() {
		this.set(S_FrdbLxInfo, null);
	}

	public String getFrdbLxInfo() {
		return DataType.getAsString(this.get(S_FrdbLxInfo));

	}

	public String getFrdbLxInfoInitialValue() {
		return DataType.getAsString(this.getOldObj(S_FrdbLxInfo));
	}

	public void initCompanyDesc(String value) {
		this.initProperty(S_CompanyDesc, value);
	}

	public void setCompanyDesc(String value) {
		this.set(S_CompanyDesc, value);
	}

	public void setCompanyDescNull() {
		this.set(S_CompanyDesc, null);
	}

	public String getCompanyDesc() {
		return DataType.getAsString(this.get(S_CompanyDesc));

	}

	public String getCompanyDescInitialValue() {
		return DataType.getAsString(this.getOldObj(S_CompanyDesc));
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

	public void initPostAddr(String value) {
		this.initProperty(S_PostAddr, value);
	}

	public void setPostAddr(String value) {
		this.set(S_PostAddr, value);
	}

	public void setPostAddrNull() {
		this.set(S_PostAddr, null);
	}

	public String getPostAddr() {
		return DataType.getAsString(this.get(S_PostAddr));

	}

	public String getPostAddrInitialValue() {
		return DataType.getAsString(this.getOldObj(S_PostAddr));
	}

	public void initPartnerCode(String value) {
		this.initProperty(S_PartnerCode, value);
	}

	public void setPartnerCode(String value) {
		this.set(S_PartnerCode, value);
	}

	public void setPartnerCodeNull() {
		this.set(S_PartnerCode, null);
	}

	public String getPartnerCode() {
		return DataType.getAsString(this.get(S_PartnerCode));

	}

	public String getPartnerCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_PartnerCode));
	}

	public void initPostCode(String value) {
		this.initProperty(S_PostCode, value);
	}

	public void setPostCode(String value) {
		this.set(S_PostCode, value);
	}

	public void setPostCodeNull() {
		this.set(S_PostCode, null);
	}

	public String getPostCode() {
		return DataType.getAsString(this.get(S_PostCode));

	}

	public String getPostCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_PostCode));
	}

	public void initCompanyName(String value) {
		this.initProperty(S_CompanyName, value);
	}

	public void setCompanyName(String value) {
		this.set(S_CompanyName, value);
	}

	public void setCompanyNameNull() {
		this.set(S_CompanyName, null);
	}

	public String getCompanyName() {
		return DataType.getAsString(this.get(S_CompanyName));

	}

	public String getCompanyNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_CompanyName));
	}

	public void initPartnerId(long value) {
		this.initProperty(S_PartnerId, Long.valueOf(value));
	}

	public void setPartnerId(long value) {
		this.set(S_PartnerId, Long.valueOf(value));
	}

	public void setPartnerIdNull() {
		this.set(S_PartnerId, null);
	}

	public long getPartnerId() {
		return DataType.getAsLong(this.get(S_PartnerId));

	}

	public long getPartnerIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_PartnerId));
	}

	public void initOrgId(long value) {
		this.initProperty(S_OrgId, Long.valueOf(value));
	}

	public void setOrgId(long value) {
		this.set(S_OrgId, Long.valueOf(value));
	}

	public void setOrgIdNull() {
		this.set(S_OrgId, null);
	}

	public long getOrgId() {
		return DataType.getAsLong(this.get(S_OrgId));

	}

	public long getOrgIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_OrgId));
	}

	public void initFrdbName(String value) {
		this.initProperty(S_FrdbName, value);
	}

	public void setFrdbName(String value) {
		this.set(S_FrdbName, value);
	}

	public void setFrdbNameNull() {
		this.set(S_FrdbName, null);
	}

	public String getFrdbName() {
		return DataType.getAsString(this.get(S_FrdbName));

	}

	public String getFrdbNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_FrdbName));
	}

	//add by hand 

	public void initPartnerOrg(String value) {
		this.initProperty(S_PartnerOrg, value);
	}

	public void setPartnerOrg(String value) {
		this.set(S_PartnerOrg, value);
	}

	public void setPartnerOrgNull() {
		this.set(S_PartnerOrg, null);
	}

	public String getPartnerOrg() {
		return DataType.getAsString(this.get(S_PartnerOrg));

	}

	public String getPartnerOrgInitialValue() {
		return DataType.getAsString(this.getOldObj(S_PartnerOrg));
	}

	public void initPartnerStaff(String value) {
		this.initProperty(S_PartnerStaff, value);
	}

	public void setPartnerStaff(String value) {
		this.set(S_PartnerStaff, value);
	}

	public void setPartnerStaffNull() {
		this.set(S_PartnerStaff, null);
	}

	public String getPartnerStaff() {
		return DataType.getAsString(this.get(S_PartnerStaff));

	}

	public String getPartnerStaffInitialValue() {
		return DataType.getAsString(this.getOldObj(S_PartnerStaff));
	}

	public void initPartnerAuth(String value) {
		this.initProperty(S_PartnerAuth, value);
	}

	public void setPartnerAuth(String value) {
		this.set(S_PartnerAuth, value);
	}

	public void setPartnerAuthNull() {
		this.set(S_PartnerAuth, null);
	}

	public String getPartnerAuth() {
		return DataType.getAsString(this.get(S_PartnerAuth));

	}

	public String getPartnerAuthInitialValue() {
		return DataType.getAsString(this.getOldObj(S_PartnerAuth));
	}

	public void initOnOffLineDate(Timestamp value) {
		this.initProperty(S_OnOffLineDate, value);
	}

	public void setOnOffLineDate(Timestamp value) {
		this.set(S_OnOffLineDate, value);
	}

	public void setOnOffLineDateNull() {
		this.set(S_OnOffLineDate, null);
	}

	public Timestamp getOnOffLineDate() {
		return DataType.getAsDateTime(this.get(S_OnOffLineDate));

	}

	public Timestamp getOnOffLineDateInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_OnOffLineDate));
	}

	public void initAppVersion(long value) {
		this.initProperty(S_AppVersion, Long.valueOf(value));
	}

	public void setAppVersion(long value) {
		this.set(S_AppVersion, Long.valueOf(value));
	}

	public void setAppVersionNull() {
		this.set(S_AppVersion, null);
	}

	public long getAppVersion() {
		return DataType.getAsLong(this.get(S_AppVersion));

	}

	public long getAppVersionInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_AppVersion));
	}
	
	//add FetionCode function
	public void initFetionCode(String value) {
		this.initProperty(S_FetionCode, value);
	}

	public void setFetionCode(String value) {
		this.set(S_FetionCode, value);
	}

	public void setFetionCodeNull() {
		this.set(S_FetionCode, null);
	}

	public String getFetionCode() {
		return DataType.getAsString(this.get(S_FetionCode));

	}

	public String getFetionCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_FetionCode));
	}


}
