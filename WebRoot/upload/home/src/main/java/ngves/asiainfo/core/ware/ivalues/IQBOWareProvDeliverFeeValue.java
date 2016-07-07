package ngves.asiainfo.core.ware.ivalues;

import com.ai.appframe2.common.DataStructInterface;

public interface IQBOWareProvDeliverFeeValue extends DataStructInterface {

	//礼品标识
	public final static String S_WareId = "WARE_ID";
	//礼品对应的31个省份的运费积分串
	public final static String S_ProvIntegralValue = "PROV_INTEGRAL_VALUE";

	public String getProvIntegralValue();

	public long getWareId();

	public void setProvIntegralValue(String value);

	public void setWareId(long value);
}
