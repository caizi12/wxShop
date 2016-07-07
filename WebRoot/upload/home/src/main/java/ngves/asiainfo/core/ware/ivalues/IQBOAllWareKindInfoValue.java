package ngves.asiainfo.core.ware.ivalues;

import com.ai.appframe2.common.DataStructInterface;

public interface IQBOAllWareKindInfoValue extends DataStructInterface {

	public final static String S_WareId    = "WARE_ID";
	public final static String S_WareCode  = "WARE_CODE";
	public final static String S_FKindId   = "F_KIND_ID";
	public final static String S_FKindName = "F_KIND_NAME";
	public final static String S_BKindId   = "B_KIND_ID";
	public final static String S_BKindName = "B_KIND_NAME";
	public final static String S_MKindId   = "M_KIND_ID";
	public final static String S_MKindName = "M_KIND_NAME";
	public final static String S_SKindId   = "S_KIND_ID";
	public final static String S_SKindName = "S_KIND_NAME";

	public String getSKindName();

	public String getFKindName();

	public long getBKindId();

	public String getBKindName();

	public String getFKindId();

	public long getSKindId();

	public String getMKindName();

	public long getMKindId();

	public long getWareId();

	public String getWareCode();

	public void setSKindName(String value);

	public void setFKindName(String value);

	public void setBKindId(long value);

	public void setBKindName(String value);

	public void setFKindId(String value);

	public void setSKindId(long value);

	public void setMKindName(String value);

	public void setMKindId(long value);

	public void setWareId(long value);

	public void setWareCode(String value);
}
