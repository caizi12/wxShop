package ngves.asiainfo.core.tuan.ivalues;

import com.ai.appframe2.common.DataStructInterface;

public interface IQBOTuanWareKindValue extends DataStructInterface {

	public final static String S_KindName = "KIND_NAME";
	public final static String S_WareKindId = "WARE_KIND_ID";

	public String getKindName();

	public long getWareKindId();

	public void setKindName(String value);

	public void setWareKindId(long value);
}
