package ngves.asiainfo.core.common.ivalues;

import com.ai.appframe2.common.DataStructInterface;

public interface ITempBusiInterMsgValue extends DataStructInterface {

	public final static String S_Msg = "MSG";
	public final static String S_BusiId = "BUSI_ID";

	public String getMsg();

	public long getBusiId();

	public void setMsg(String value);

	public void setBusiId(long value);
}
