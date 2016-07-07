package ngves.asiainfo.core.ware.ivalues;

import com.ai.appframe2.common.DataStructInterface;

public interface IWareUpDownVersionValue extends DataStructInterface {

	public final static String S_AppVersion = "APP_VERSION";
	public final static String S_WareStatus = "WARE_STATUS";
	public final static String S_WareId = "WARE_ID";

	public long getAppVersion();

	public String getWareStatus();

	public long getWareId();

	public void setAppVersion(long value);

	public void setWareStatus(String value);

	public void setWareId(long value);
}
