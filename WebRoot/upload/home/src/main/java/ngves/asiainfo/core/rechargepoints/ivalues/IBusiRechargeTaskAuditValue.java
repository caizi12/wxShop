package ngves.asiainfo.core.rechargepoints.ivalues;

import java.sql.Timestamp;

import com.ai.appframe2.common.DataStructInterface;

public interface IBusiRechargeTaskAuditValue extends DataStructInterface {

	public final static String S_OperatorCode = "OPERATOR_CODE";
	public final static String S_AuditContent = "AUDIT_CONTENT";
	public final static String S_BakCol1 = "BAK_COL1";
	public final static String S_AuditTime = "AUDIT_TIME";
	public final static String S_RechargeTaskId = "RECHARGE_TASK_ID";
	public final static String S_Status = "STATUS";
	public final static String S_BusiId = "BUSI_ID";

	public String getOperatorCode();

	public String getAuditContent();

	public String getBakCol1();

	public Timestamp getAuditTime();

	public long getRechargeTaskId();

	public String getStatus();

	public long getBusiId();

	public void setOperatorCode(String value);

	public void setAuditContent(String value);

	public void setBakCol1(String value);

	public void setAuditTime(Timestamp value);

	public void setRechargeTaskId(long value);

	public void setStatus(String value);

	public void setBusiId(long value);
}
