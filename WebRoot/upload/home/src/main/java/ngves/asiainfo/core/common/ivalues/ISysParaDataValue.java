package ngves.asiainfo.core.common.ivalues;

import com.ai.appframe2.common.DataStructInterface;

public interface ISysParaDataValue extends DataStructInterface {

	public final static String S_ValidFlag = "VALID_FLAG";
	public final static String S_ParaId = "PARA_ID";
	public final static String S_IsMeta = "IS_META";
	public final static String S_ParaTypeId = "PARA_TYPE_ID";
	public final static String S_SortId = "SORT_ID";
	public final static String S_ParaAttr3 = "PARA_ATTR_3";
	public final static String S_ParaCode = "PARA_CODE";
	public final static String S_Note = "NOTE";
	public final static String S_ParaName = "PARA_NAME";
	public final static String S_ParaAttr1 = "PARA_ATTR_1";
	public final static String S_ParaAttr2 = "PARA_ATTR_2";

	public String getValidFlag();

	public long getParaId();

	public String getIsMeta();

	public long getParaTypeId();

	public long getSortId();

	public String getParaAttr3();

	public String getParaCode();

	public String getNote();

	public String getParaName();

	public String getParaAttr1();

	public String getParaAttr2();

	public void setValidFlag(String value);

	public void setParaId(long value);

	public void setIsMeta(String value);

	public void setParaTypeId(long value);

	public void setSortId(long value);

	public void setParaAttr3(String value);

	public void setParaCode(String value);

	public void setNote(String value);

	public void setParaName(String value);

	public void setParaAttr1(String value);

	public void setParaAttr2(String value);
}
