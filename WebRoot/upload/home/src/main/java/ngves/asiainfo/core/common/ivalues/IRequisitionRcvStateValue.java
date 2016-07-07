package ngves.asiainfo.core.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IRequisitionRcvStateValue extends DataStructInterface{

  public final static  String S_AnswerContent = "ANSWER_CONTENT";
  public final static  String S_RequisitionRcvId = "REQUISITION_RCV_ID";
  public final static  String S_RequisitionStatus = "REQUISITION_STATUS";
  public final static  String S_RequisitionId = "REQUISITION_ID";
  public final static  String S_AnswerDate = "ANSWER_DATE";
  public final static  String S_BrowseDate = "BROWSE_DATE";
  public final static  String S_RcvStaffId = "RCV_STAFF_ID";


public String getAnswerContent();

public long getRequisitionRcvId();

public String getRequisitionStatus();

public long getRequisitionId();

public Timestamp getAnswerDate();

public Timestamp getBrowseDate();

public long getRcvStaffId();


public  void setAnswerContent(String value);

public  void setRequisitionRcvId(long value);

public  void setRequisitionStatus(String value);

public  void setRequisitionId(long value);

public  void setAnswerDate(Timestamp value);

public  void setBrowseDate(Timestamp value);

public  void setRcvStaffId(long value);
}
