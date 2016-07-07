package ngves.asiainfo.core.smsformwork.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.smsformwork.ivalues.*;

public class BusiSmsFormworkContentBean extends DataContainer implements DataContainerInterface,
		IBusiSmsFormworkContentValue {

	private static final long serialVersionUID = -1365053391883471182L;

	private static String m_boName = "ngves.asiainfo.core.smsformwork.bo.BusiSmsFormworkContent";

	public final static String S_IsStopped = "IS_STOPPED";
	public final static String S_BusiContentId = "BUSI_CONTENT_ID";
	public final static String S_OperatorCode = "OPERATOR_CODE";
	public final static String S_BusiId = "BUSI_ID";
	public final static String S_ContentInfo = "CONTENT_INFO";
	public final static String S_ContentName = "CONTENT_NAME";
	public final static String S_OperateTime = "OPERATE_TIME";
	public final static String S_Oper = "OPER";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public BusiSmsFormworkContentBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initIsStopped(String value) {
		this.initProperty(S_IsStopped, value);
	}

	public void setIsStopped(String value) {
		this.set(S_IsStopped, value);
	}

	public void setIsStoppedNull() {
		this.set(S_IsStopped, null);
	}

	public String getIsStopped() {
		return DataType.getAsString(this.get(S_IsStopped));

	}

	public String getIsStoppedInitialValue() {
		return DataType.getAsString(this.getOldObj(S_IsStopped));
	}

	public void initBusiContentId(String value) {
		this.initProperty(S_BusiContentId, value);
	}

	public void setBusiContentId(String value) {
		this.set(S_BusiContentId, value);
	}

	public void setBusiContentIdNull() {
		this.set(S_BusiContentId, null);
	}

	public String getBusiContentId() {
		return DataType.getAsString(this.get(S_BusiContentId));

	}

	public String getBusiContentIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_BusiContentId));
	}

	public void initOperatorCode(String value) {
		this.initProperty(S_OperatorCode, value);
	}

	public void setOperatorCode(String value) {
		this.set(S_OperatorCode, value);
	}

	public void setOperatorCodeNull() {
		this.set(S_OperatorCode, null);
	}

	public String getOperatorCode() {
		return DataType.getAsString(this.get(S_OperatorCode));

	}

	public String getOperatorCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_OperatorCode));
	}

	public void initBusiId(String value) {
		this.initProperty(S_BusiId, value);
	}

	public void setBusiId(String value) {
		this.set(S_BusiId, value);
	}

	public void setBusiIdNull() {
		this.set(S_BusiId, null);
	}

	public String getBusiId() {
		return DataType.getAsString(this.get(S_BusiId));

	}

	public String getBusiIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_BusiId));
	}

	public void initContentInfo(String value) {
		this.initProperty(S_ContentInfo, value);
	}

	public void setContentInfo(String value) {
		this.set(S_ContentInfo, value);
	}

	public void setContentInfoNull() {
		this.set(S_ContentInfo, null);
	}

	public String getContentInfo() {
		return DataType.getAsString(this.get(S_ContentInfo));

	}

	public String getContentInfoInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ContentInfo));
	}

	public void initContentName(String value) {
		this.initProperty(S_ContentName, value);
	}

	public void setContentName(String value) {
		this.set(S_ContentName, value);
	}

	public void setContentNameNull() {
		this.set(S_ContentName, null);
	}

	public String getContentName() {
		return DataType.getAsString(this.get(S_ContentName));

	}

	public String getContentNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ContentName));
	}

	public void initOperateTime(Timestamp value) {
		this.initProperty(S_OperateTime, value);
	}

	public void setOperateTime(Timestamp value) {
		this.set(S_OperateTime, value);
	}

	public void setOperateTimeNull() {
		this.set(S_OperateTime, null);
	}

	public Timestamp getOperateTime() {
		return DataType.getAsDateTime(this.get(S_OperateTime));

	}

	public Timestamp getOperateTimeInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_OperateTime));
	}

	public void initOper(String value) {
		this.initProperty(S_Oper, value);
	}

	public void setOper(String value) {
		this.set(S_Oper, value);
	}

	public void setOperNull() {
		this.set(S_Oper, null);
	}

	public String getOper() {
		return DataType.getAsString(this.get(S_Oper));

	}

	public String getOperInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Oper));
	}

}
