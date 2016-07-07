package ngves.asiainfo.core.ware.ivalues;

import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;

public interface IPartnerInfoValue extends DataStructInterface {

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
	
	

	public String getFetionCode();
	public void setFetionCode(String value);
	public String getCallcenterFileName();

	public long getAppVersion();

	public String getCallcenterNo();

	public String getPartnerLongName();

	public Timestamp getCreateDate();

	public Timestamp getOnOffLineDate();

	public String getPartnerTypeId();

	public long getCurStatus();

	public String getPartnerName();

	public Timestamp getStatusDate();

	public String getFrdbLxInfo();

	public String getCompanyDesc();

	public String getProvinceCode();

	public String getPostAddr();

	public String getPartnerCode();

	public String getPostCode();

	public String getCompanyName();

	public long getPartnerId();

	public long getOrgId();

	public String getFrdbName();

	public String getPartnerOrg();

	public String getPartnerStaff();

	public String getPartnerAuth();

	public void setCallcenterFileName(String value);

	public void setCallcenterNo(String value);

	public void setPartnerLongName(String value);

	public void setCreateDate(Timestamp value);

	public void setOnOffLineDate(Timestamp value);

	public void setPartnerTypeId(String value);

	public void setCurStatus(long value);

	public void setAppVersion(long value);

	public void setPartnerName(String value);

	public void setStatusDate(Timestamp value);

	public void setFrdbLxInfo(String value);

	public void setCompanyDesc(String value);

	public void setProvinceCode(String value);

	public void setPostAddr(String value);

	public void setPartnerCode(String value);

	public void setPostCode(String value);

	public void setCompanyName(String value);

	public void setPartnerId(long value);

	public void setOrgId(long value);

	public void setFrdbName(String value);

	public void setPartnerOrg(String value);

	public void setPartnerStaff(String value);

	public void setPartnerAuth(String value);
}
