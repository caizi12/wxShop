package ngves.asiainfo.core.ticket.ivalues;

import java.sql.Timestamp;

import com.ai.appframe2.common.DataStructInterface;

public interface ITicketThirdInfoValue extends DataStructInterface {

	public final static String S_TicketPrice = "TICKET_PRICE";
	public final static String S_MovieName = "MOVIE_NAME";
	public final static String S_LockEndTime = "LOCK_END_TIME";
	public final static String S_BakCol1 = "BAK_COL1";
	public final static String S_MobileNum = "MOBILE_NUM";
	public final static String S_PWareCode = "P_WARE_CODE";
	public final static String S_SeatNumList = "SEAT_NUM_LIST";
	public final static String S_LockPeriod = "LOCK_PERIOD";
	public final static String S_Md5Code = "MD5_CODE";
	public final static String S_BakCol2 = "BAK_COL2";
	public final static String S_TicketThirdId = "TICKET_THIRD_ID";
	public final static String S_WareId = "WARE_ID";
	public final static String S_TicketNum = "TICKET_NUM";
	public final static String S_SequenceNum = "SEQUENCE_NUM";
	public final static String S_ShowTime = "SHOW_TIME";
	public final static String S_TicketMainKey = "TICKET_MAIN_KEY";
	public final static String S_TicketStartTime = "TICKET_START_TIME";

	public Timestamp getTicketStartTime();

	public void setTicketStartTime(Timestamp value);

	public String getTicketPrice();

	public String getMovieName();

	public Timestamp getLockEndTime();

	public String getBakCol1();

	public String getMobileNum();

	public String getPWareCode();

	public String getSeatNumList();

	public long getLockPeriod();

	public String getMd5Code();

	public String getBakCol2();

	public long getTicketThirdId();

	public long getWareId();

	public long getTicketNum();

	public String getSequenceNum();

	public String getShowTime();

	public String getTicketMainKey();

	public void setTicketPrice(String value);

	public void setMovieName(String value);

	public void setLockEndTime(Timestamp value);

	public void setBakCol1(String value);

	public void setMobileNum(String value);

	public void setPWareCode(String value);

	public void setSeatNumList(String value);

	public void setLockPeriod(long value);

	public void setMd5Code(String value);

	public void setBakCol2(String value);

	public void setTicketThirdId(long value);

	public void setWareId(long value);

	public void setTicketNum(long value);

	public void setSequenceNum(String value);

	public void setShowTime(String value);

	public void setTicketMainKey(String value);
}
