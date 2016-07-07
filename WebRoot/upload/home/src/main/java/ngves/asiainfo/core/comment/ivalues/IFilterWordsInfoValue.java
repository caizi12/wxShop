package ngves.asiainfo.core.comment.ivalues;

import java.sql.Timestamp;

import com.ai.appframe2.common.DataStructInterface;

public interface IFilterWordsInfoValue extends DataStructInterface {

	public final static String S_ReplaceWord = "REPLACE_WORD";
	public final static String S_FilterWord = "FILTER_WORD";
	public final static String S_Bak01 = "BAK_01";
	public final static String S_Bak02 = "BAK_02";
	public final static String S_FilterWordId = "FILTER_WORD_ID";
	public final static String S_UpdateTime = "UPDATE_TIME";
	public final static String S_FilterWordStatus = "FILTER_WORD_STATUS";

	public String getReplaceWord();

	public String getFilterWord();

	public String getBak01();

	public String getBak02();

	public long getFilterWordId();

	public Timestamp getUpdateTime();

	public String getFilterWordStatus();

	public void setReplaceWord(String value);

	public void setFilterWord(String value);

	public void setBak01(String value);

	public void setBak02(String value);

	public void setFilterWordId(long value);

	public void setUpdateTime(Timestamp value);

	public void setFilterWordStatus(String value);
}
