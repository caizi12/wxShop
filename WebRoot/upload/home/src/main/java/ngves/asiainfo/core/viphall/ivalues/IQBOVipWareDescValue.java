package ngves.asiainfo.core.viphall.ivalues;

import com.ai.appframe2.common.DataStructInterface;

public interface IQBOVipWareDescValue extends DataStructInterface {

	public final static String S_IsOnline = "IS_ONLINE";
	public final static String S_WareDescValue = "WARE_DESC_VALUE";
	public final static String S_DescDefineId = "DESC_DEFINE_ID";
	public final static String S_TypeCode = "TYPE_CODE";
	
	public String getIsOnline();

	public String getWareDescValue();

	public long getDescDefineId();
	public String getTypeCode();
	public void setIsOnline(String value);

	public void setWareDescValue(String value);

	public void setDescDefineId(long value);
	public void setTypeCode(String value);
}
