package ngves.asiainfo.core.common.model;


/**
 * 票价类
 * @author WL
 *
 */
public class PriceInfo extends Theatre  implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ticketPriceId; //   票价标识 对应子礼品Id
	private String ticketPrice;  // 票价
	
	
	
	

	public String getTicketPriceId() {
		return ticketPriceId;
	}
	public void setTicketPriceId(String ticketPriceId) {
		this.ticketPriceId = ticketPriceId;
	}
	public String getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(String ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
}
