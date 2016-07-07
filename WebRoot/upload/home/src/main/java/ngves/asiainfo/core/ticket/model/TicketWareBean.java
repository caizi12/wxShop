package ngves.asiainfo.core.ticket.model;

import java.io.Serializable;

/**
 * 在线选做：保存第三方信息
 * 
 * @author shenfl
 * 
 */
public class TicketWareBean implements Serializable {
	private static final long serialVersionUID = -8745712689776127937L;

	private String pWareCode;

	private String ticketMobile;

	private String movieName;

	private String showTime;

	private String ticketPrice;

	private String ticketNum;

	private String seatNumList;

	private String sequenceNum;

	private String lockPeriod;

	private String password;

	public String getPWareCode() {
		return pWareCode;
	}

	public void setPWareCode(String wareCode) {
		pWareCode = wareCode;
	}

	public String getTicketMobile() {
		return ticketMobile;
	}

	public void setTicketMobile(String ticketMobile) {
		this.ticketMobile = ticketMobile;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public String getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(String ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(String ticketNum) {
		this.ticketNum = ticketNum;
	}

	public String getSeatNumList() {
		return seatNumList;
	}

	public void setSeatNumList(String seatNumList) {
		this.seatNumList = seatNumList;
	}

	public String getSequenceNum() {
		return sequenceNum;
	}

	public void setSequenceNum(String sequenceNum) {
		this.sequenceNum = sequenceNum;
	}

	public String getLockPeriod() {
		return lockPeriod;
	}

	public void setLockPeriod(String lockPeriod) {
		this.lockPeriod = lockPeriod;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
