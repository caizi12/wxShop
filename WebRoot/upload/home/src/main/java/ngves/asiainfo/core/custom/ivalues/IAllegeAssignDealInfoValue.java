package ngves.asiainfo.core.custom.ivalues;

import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;

public interface IAllegeAssignDealInfoValue extends DataStructInterface {

	public final static String S_AllegeId = "ALLEGE_ID";
	public final static String S_OverTimeFlag = "OVER_TIME_FLAG";
	public final static String S_DealOpId = "DEAL_OP_ID";
	public final static String S_SendStaffId = "SEND_STAFF_ID";
	public final static String S_PartnerType = "PARTNER_TYPE";
	public final static String S_DealDate = "DEAL_DATE";
	public final static String S_AllegeAssignId = "ALLEGE_ASSIGN_ID";
	public final static String S_SendNote = "SEND_NOTE";
	public final static String S_SendTpId = "SEND_TP_ID";
	public final static String S_DealTpId = "DEAL_TP_ID";
	public final static String S_ToStaffId = "TO_STAFF_ID";
	public final static String S_Note = "NOTE";
	public final static String S_SendDate = "SEND_DATE";
	public final static String S_ComTypeId = "COM_TYPE_ID";
	public final static String S_AssignStatus = "ASSIGN_STATUS";
	public final static String S_DealDesc = "DEAL_DESC";
	public final static String S_PartnerId = "PARTNER_ID";
	public final static String S_DealResult = "DEAL_RESULT";

	public long getAllegeId();

	public String getOverTimeFlag();

	public long getDealOpId();

	public long getSendStaffId();

	public String getPartnerType();

	public Timestamp getDealDate();

	public long getAllegeAssignId();

	public String getSendNote();

	public long getSendTpId();

	public long getDealTpId();

	public long getToStaffId();

	public String getNote();

	public Timestamp getSendDate();

	public String getComTypeId();

	public String getAssignStatus();

	public String getDealDesc();

	public long getPartnerId();
	
	public String getDealResult();

	public void setAllegeId(long value);

	public void setOverTimeFlag(String value);

	public void setDealOpId(long value);

	public void setSendStaffId(long value);

	public void setPartnerType(String value);

	public void setDealDate(Timestamp value);

	public void setAllegeAssignId(long value);

	public void setSendNote(String value);

	public void setSendTpId(long value);

	public void setDealTpId(long value);

	public void setToStaffId(long value);

	public void setNote(String value);

	public void setSendDate(Timestamp value);

	public void setComTypeId(String value);

	public void setAssignStatus(String value);

	public void setDealDesc(String value);

	public void setPartnerId(long value);
	
	public void setDealResult(String value);
}
