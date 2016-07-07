package ngves.asiainfo.core.comment.bo;

import java.sql.Timestamp;

import ngves.asiainfo.core.comment.ivalues.IFilterWordsInfoValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class FilterWordsInfoBean extends DataContainer implements DataContainerInterface, IFilterWordsInfoValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.comment.FilterWordsInfo";

	public final static String S_ReplaceWord = "REPLACE_WORD";
	public final static String S_FilterWord = "FILTER_WORD";
	public final static String S_Bak01 = "BAK_01";
	public final static String S_Bak02 = "BAK_02";
	public final static String S_FilterWordId = "FILTER_WORD_ID";
	public final static String S_UpdateTime = "UPDATE_TIME";
	public final static String S_FilterWordStatus = "FILTER_WORD_STATUS";

	public FilterWordsInfoBean() throws AIException {
		super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initReplaceWord(String value) {
		this.initProperty(S_ReplaceWord, value);
	}

	public void setReplaceWord(String value) {
		this.set(S_ReplaceWord, value);
	}

	public void setReplaceWordNull() {
		this.set(S_ReplaceWord, null);
	}

	public String getReplaceWord() {
		return DataType.getAsString(this.get(S_ReplaceWord));

	}

	public String getReplaceWordInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ReplaceWord));
	}

	public void initFilterWord(String value) {
		this.initProperty(S_FilterWord, value);
	}

	public void setFilterWord(String value) {
		this.set(S_FilterWord, value);
	}

	public void setFilterWordNull() {
		this.set(S_FilterWord, null);
	}

	public String getFilterWord() {
		return DataType.getAsString(this.get(S_FilterWord));

	}

	public String getFilterWordInitialValue() {
		return DataType.getAsString(this.getOldObj(S_FilterWord));
	}

	public void initBak01(String value) {
		this.initProperty(S_Bak01, value);
	}

	public void setBak01(String value) {
		this.set(S_Bak01, value);
	}

	public void setBak01Null() {
		this.set(S_Bak01, null);
	}

	public String getBak01() {
		return DataType.getAsString(this.get(S_Bak01));

	}

	public String getBak01InitialValue() {
		return DataType.getAsString(this.getOldObj(S_Bak01));
	}

	public void initBak02(String value) {
		this.initProperty(S_Bak02, value);
	}

	public void setBak02(String value) {
		this.set(S_Bak02, value);
	}

	public void setBak02Null() {
		this.set(S_Bak02, null);
	}

	public String getBak02() {
		return DataType.getAsString(this.get(S_Bak02));

	}

	public String getBak02InitialValue() {
		return DataType.getAsString(this.getOldObj(S_Bak02));
	}

	public void initFilterWordId(long value) {
		this.initProperty(S_FilterWordId, new Long(value));
	}

	public void setFilterWordId(long value) {
		this.set(S_FilterWordId, new Long(value));
	}

	public void setFilterWordIdNull() {
		this.set(S_FilterWordId, null);
	}

	public long getFilterWordId() {
		return DataType.getAsLong(this.get(S_FilterWordId));

	}

	public long getFilterWordIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_FilterWordId));
	}

	public void initUpdateTime(Timestamp value) {
		this.initProperty(S_UpdateTime, value);
	}

	public void setUpdateTime(Timestamp value) {
		this.set(S_UpdateTime, value);
	}

	public void setUpdateTimeNull() {
		this.set(S_UpdateTime, null);
	}

	public Timestamp getUpdateTime() {
		return DataType.getAsDateTime(this.get(S_UpdateTime));

	}

	public Timestamp getUpdateTimeInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_UpdateTime));
	}

	public void initFilterWordStatus(String value) {
		this.initProperty(S_FilterWordStatus, value);
	}

	public void setFilterWordStatus(String value) {
		this.set(S_FilterWordStatus, value);
	}

	public void setFilterWordStatusNull() {
		this.set(S_FilterWordStatus, null);
	}

	public String getFilterWordStatus() {
		return DataType.getAsString(this.get(S_FilterWordStatus));

	}

	public String getFilterWordStatusInitialValue() {
		return DataType.getAsString(this.getOldObj(S_FilterWordStatus));
	}

}
