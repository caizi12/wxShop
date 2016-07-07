package ngves.asiainfo.core.comment.bo;

import java.sql.Timestamp;

import ngves.asiainfo.core.comment.ivalues.ICommentInfoValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class CommentInfoBean extends DataContainer implements DataContainerInterface, ICommentInfoValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.comment.CommentInfo";

	public final static String S_CommentOriginal = "COMMENT_ORIGINAL";
	public final static String S_CommentValue = "COMMENT_VALUE";
	public final static String S_CommentDate = "COMMENT_DATE";
	public final static String S_CommentId = "COMMENT_ID";
	public final static String S_AuditFlag = "AUDIT_FLAG";
	public final static String S_Bak01 = "BAK_01";
	public final static String S_AuditTime = "AUDIT_TIME";
	public final static String S_Bak02 = "BAK_02";
	public final static String S_MobilePhoneNo = "MOBILE_PHONE_NO";
	public final static String S_AuditStaffId = "AUDIT_STAFF_ID";
	public final static String S_WareId = "WARE_ID";
	public final static String S_WareName ="WARE_NAME";
	public final static String S_WareCode = "WARE_CODE";
	public final static String S_PWareId = "P_WARE_ID";

	public CommentInfoBean() throws AIException {
		super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initCommentOriginal(String value) {
		this.initProperty(S_CommentOriginal, value);
	}

	public void setCommentOriginal(String value) {
		this.set(S_CommentOriginal, value);
	}

	public void setCommentOriginalNull() {
		this.set(S_CommentOriginal, null);
	}

	public String getCommentOriginal() {
		return DataType.getAsString(this.get(S_CommentOriginal));

	}

	public String getCommentOriginalInitialValue() {
		return DataType.getAsString(this.getOldObj(S_CommentOriginal));
	}

	public void initCommentDate(Timestamp value) {
		this.initProperty(S_CommentDate, value);
	}

	public void setCommentDate(Timestamp value) {
		this.set(S_CommentDate, value);
	}

	public void setCommentDateNull() {
		this.set(S_CommentDate, null);
	}

	public Timestamp getCommentDate() {
		return DataType.getAsDateTime(this.get(S_CommentDate));

	}

	public Timestamp getCommentDateInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_CommentDate));
	}

	public void initCommentId(long value) {
		this.initProperty(S_CommentId, new Long(value));
	}

	public void setCommentId(long value) {
		this.set(S_CommentId, new Long(value));
	}

	public void setCommentIdNull() {
		this.set(S_CommentId, null);
	}

	public long getCommentId() {
		return DataType.getAsLong(this.get(S_CommentId));

	}

	public long getCommentIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_CommentId));
	}

	public void initAuditFlag(String value) {
		this.initProperty(S_AuditFlag, value);
	}

	public void setAuditFlag(String value) {
		this.set(S_AuditFlag, value);
	}

	public void setAuditFlagNull() {
		this.set(S_AuditFlag, null);
	}

	public String getAuditFlag() {
		return DataType.getAsString(this.get(S_AuditFlag));

	}

	public String getAuditFlagInitialValue() {
		return DataType.getAsString(this.getOldObj(S_AuditFlag));
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

	public void initAuditTime(Timestamp value) {
		this.initProperty(S_AuditTime, value);
	}

	public void setAuditTime(Timestamp value) {
		this.set(S_AuditTime, value);
	}

	public void setAuditTimeNull() {
		this.set(S_AuditTime, null);
	}

	public Timestamp getAuditTime() {
		return DataType.getAsDateTime(this.get(S_AuditTime));

	}

	public Timestamp getAuditTimeInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_AuditTime));
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

	public void initMobilePhoneNo(String value) {
		this.initProperty(S_MobilePhoneNo, value);
	}

	public void setMobilePhoneNo(String value) {
		this.set(S_MobilePhoneNo, value);
	}

	public void setMobilePhoneNoNull() {
		this.set(S_MobilePhoneNo, null);
	}

	public String getMobilePhoneNo() {
		return DataType.getAsString(this.get(S_MobilePhoneNo));

	}

	public String getMobilePhoneNoInitialValue() {
		return DataType.getAsString(this.getOldObj(S_MobilePhoneNo));
	}

	public void initAuditStaffId(long value) {
		this.initProperty(S_AuditStaffId, new Long(value));
	}

	public void setAuditStaffId(long value) {
		this.set(S_AuditStaffId, new Long(value));
	}

	public void setAuditStaffIdNull() {
		this.set(S_AuditStaffId, null);
	}

	public long getAuditStaffId() {
		return DataType.getAsLong(this.get(S_AuditStaffId));

	}

	public long getAuditStaffIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_AuditStaffId));
	}

	public void initWareId(long value) {
		this.initProperty(S_WareId, new Long(value));
	}

	public void setWareId(long value) {
		this.set(S_WareId, new Long(value));
	}

	public void setWareIdNull() {
		this.set(S_WareId, null);
	}

	public long getWareId() {
		return DataType.getAsLong(this.get(S_WareId));

	}

	public long getWareIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_WareId));
	}
	
	public void initWareName(String value) {
		this.initProperty(S_WareName, value);
	}

	public void setWareName(String value) {
		this.set(S_WareName, value);
	}

	public void setWareNameNull() {
		this.set(S_WareName, null);
	}

	public String getWareName() {
		return DataType.getAsString(this.get(S_WareName));

	}

	public String getWareNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_WareName));
	}
	
	 public void initCommentValue(long value){
	     this.initProperty(S_CommentValue,Long.valueOf(value));
	  }
	  public  void setCommentValue(long value){
	     this.set(S_CommentValue,Long.valueOf(value));
	  }
	  public  void setCommentValueNull(){
	     this.set(S_CommentValue,null);
	  }

	  public long getCommentValue(){
	        return DataType.getAsLong(this.get(S_CommentValue));
	  
	  }
	  public long getCommentValueInitialValue(){
	        return DataType.getAsLong(this.getOldObj(S_CommentValue));
	      }
	  
	  public void initWareCode(String value) {
			this.initProperty(S_WareCode, value);
		}

		public void setWareCode(String value) {
			this.set(S_WareCode, value);
		}

		public void setWareCodeNull() {
			this.set(S_WareCode, null);
		}

		public String getWareCode() {
			return DataType.getAsString(this.get(S_WareCode));

		}

		public String getWareCodeInitialValue() {
			return DataType.getAsString(this.getOldObj(S_WareCode));
		}
		
		
		public void initPWareId(long value) {
			this.initProperty(S_PWareId, new Long(value));
		}

		public void setPWareId(long value) {
			this.set(S_PWareId, new Long(value));
		}

		public void setPWareIdNull() {
			this.set(S_PWareId, null);
		}

		public long getPWareId() {
			return DataType.getAsLong(this.get(S_PWareId));

		}

		public long getPWareIdInitialValue() {
			return DataType.getAsLong(this.getOldObj(S_PWareId));
		}
}
