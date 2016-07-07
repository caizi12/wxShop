package ngves.asiainfo.core.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.common.ivalues.*;

public class BusiCustomCommunionBean extends DataContainer implements DataContainerInterface, IBusiCustomCommunionValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4811980416671609508L;

	private static String m_boName = "ngves.asiainfo.core.common.bo.BusiCustomCommunion";

	public final static String S_AcceptUser = "ACCEPT_USER";
	public final static String S_BusiId = "BUSI_ID";
	public final static String S_BakCol = "BAK_COL";
	public final static String S_ActionBusiId = "ACTION_BUSI_ID";
	public final static String S_BakCol2 = "BAK_COL2";
	public final static String S_BakCol3 = "BAK_COL3";
	public final static String S_ActionType = "ACTION_TYPE";
	public final static String S_SendUser = "SEND_USER";
	public final static String S_OptDate = "OPT_DATE";
	public final static String S_BusiStatus = "BUSI_STATUS";
	public final static String S_Indictseq = "INDICTSEQ";
	public final static  String S_AppVersion = "APP_VERSION";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public BusiCustomCommunionBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initAcceptUser(String value) {
		this.initProperty(S_AcceptUser, value);
	}

	public void setAcceptUser(String value) {
		this.set(S_AcceptUser, value);
	}

	public void setAcceptUserNull() {
		this.set(S_AcceptUser, null);
	}

	public String getAcceptUser() {
		return DataType.getAsString(this.get(S_AcceptUser));

	}

	public String getAcceptUserInitialValue() {
		return DataType.getAsString(this.getOldObj(S_AcceptUser));
	}

	public void initBusiId(long value) {
		this.initProperty(S_BusiId, new Long(value));
	}

	public void setBusiId(long value) {
		this.set(S_BusiId, new Long(value));
	}

	public void setBusiIdNull() {
		this.set(S_BusiId, null);
	}

	public long getBusiId() {
		return DataType.getAsLong(this.get(S_BusiId));

	}

	public long getBusiIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_BusiId));
	}

	public void initBakCol(String value) {
		this.initProperty(S_BakCol, value);
	}

	public void setBakCol(String value) {
		this.set(S_BakCol, value);
	}

	public void setBakColNull() {
		this.set(S_BakCol, null);
	}

	public String getBakCol() {
		return DataType.getAsString(this.get(S_BakCol));

	}

	public String getBakColInitialValue() {
		return DataType.getAsString(this.getOldObj(S_BakCol));
	}

	public void initActionBusiId(long value) {
		this.initProperty(S_ActionBusiId, new Long(value));
	}

	public void setActionBusiId(long value) {
		this.set(S_ActionBusiId, new Long(value));
	}

	public void setActionBusiIdNull() {
		this.set(S_ActionBusiId, null);
	}

	public long getActionBusiId() {
		return DataType.getAsLong(this.get(S_ActionBusiId));

	}

	public long getActionBusiIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_ActionBusiId));
	}

	public void initBakCol2(String value) {
		this.initProperty(S_BakCol2, value);
	}

	public void setBakCol2(String value) {
		this.set(S_BakCol2, value);
	}

	public void setBakCol2Null() {
		this.set(S_BakCol2, null);
	}

	public String getBakCol2() {
		return DataType.getAsString(this.get(S_BakCol2));

	}

	public String getBakCol2InitialValue() {
		return DataType.getAsString(this.getOldObj(S_BakCol2));
	}

	public void initBakCol3(String value) {
		this.initProperty(S_BakCol3, value);
	}

	public void setBakCol3(String value) {
		this.set(S_BakCol3, value);
	}

	public void setBakCol3Null() {
		this.set(S_BakCol3, null);
	}

	public String getBakCol3() {
		return DataType.getAsString(this.get(S_BakCol3));

	}

	public String getBakCol3InitialValue() {
		return DataType.getAsString(this.getOldObj(S_BakCol3));
	}

	public void initActionType(String value) {
		this.initProperty(S_ActionType, value);
	}

	public void setActionType(String value) {
		this.set(S_ActionType, value);
	}

	public void setActionTypeNull() {
		this.set(S_ActionType, null);
	}

	public String getActionType() {
		return DataType.getAsString(this.get(S_ActionType));

	}

	public String getActionTypeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ActionType));
	}

	public void initSendUser(String value) {
		this.initProperty(S_SendUser, value);
	}

	public void setSendUser(String value) {
		this.set(S_SendUser, value);
	}

	public void setSendUserNull() {
		this.set(S_SendUser, null);
	}

	public String getSendUser() {
		return DataType.getAsString(this.get(S_SendUser));

	}

	public String getSendUserInitialValue() {
		return DataType.getAsString(this.getOldObj(S_SendUser));
	}

	public void initOptDate(Timestamp value) {
		this.initProperty(S_OptDate, value);
	}

	public void setOptDate(Timestamp value) {
		this.set(S_OptDate, value);
	}

	public void setOptDateNull() {
		this.set(S_OptDate, null);
	}

	public Timestamp getOptDate() {
		return DataType.getAsDateTime(this.get(S_OptDate));

	}

	public Timestamp getOptDateInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_OptDate));
	}

	public void initBusiStatus(String value) {
		this.initProperty(S_BusiStatus, value);
	}

	public void setBusiStatus(String value) {
		this.set(S_BusiStatus, value);
	}

	public void setBusiStatusNull() {
		this.set(S_BusiStatus, null);
	}

	public String getBusiStatus() {
		return DataType.getAsString(this.get(S_BusiStatus));

	}

	public String getBusiStatusInitialValue() {
		return DataType.getAsString(this.getOldObj(S_BusiStatus));
	}

	public void initIndictseq(String value) {
		this.initProperty(S_Indictseq, value);
	}

	public void setIndictseq(String value) {
		this.set(S_Indictseq, value);
	}

	public void setIndictseqNull() {
		this.set(S_Indictseq, null);
	}

	public String getIndictseq() {
		return DataType.getAsString(this.get(S_Indictseq));

	}

	public String getIndictseqInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Indictseq));
	}
	
	public void initAppVersion(String value) {
		this.initProperty(S_AppVersion, value);
	}

	public void setAppVersion(String value) {
		this.set(S_AppVersion, value);
	}

	public void setAppVersionNull() {
		this.set(S_AppVersion, null);
	}

	public String getAppVersion() {
		return DataType.getAsString(this.get(S_AppVersion));

	}

	public String getAppVersionInitialValue() {
		return DataType.getAsString(this.getOldObj(S_AppVersion));
	}

}
