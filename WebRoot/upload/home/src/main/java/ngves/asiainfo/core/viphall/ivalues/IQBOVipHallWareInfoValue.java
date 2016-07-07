package ngves.asiainfo.core.viphall.ivalues;

import com.ai.appframe2.common.DataStructInterface;

public interface IQBOVipHallWareInfoValue extends DataStructInterface {

	public final static String S_IsOnline = "IS_ONLINE";
	public final static String S_WareName = "WARE_NAME";
	public final static String S_CityCode = "CITY_CODE";
	public final static String S_DescDefineWareValue = "DESC_DEFINE_WARE_VALUE";
	public final static String S_FileName = "FILE_NAME";
	public final static String S_CityName = "CITY_NAME";
	public final static String S_WareId = "WARE_ID";
	public final static String S_WareKindId = "WARE_KIND_ID";
	public final static String S_WareDisValue = "WARE_DIS_VALUE";
	public final static String S_ProvCode = "PROV_CODE";

	public String getIsOnline();

	public String getWareName();

	public String getCityCode();

	public String getDescDefineWareValue();

	public String getFileName();

	public String getCityName();

	public long getWareId();

	public long getWareKindId();

	public String getWareDisValue();

	public String getProvCode();

	public void setIsOnline(String value);

	public void setWareName(String value);

	public void setCityCode(String value);

	public void setDescDefineWareValue(String value);

	public void setFileName(String value);

	public void setCityName(String value);

	public void setWareId(long value);

	public void setWareKindId(long value);

	public void setWareDisValue(String value);

	public void setProvCode(String value);
}
