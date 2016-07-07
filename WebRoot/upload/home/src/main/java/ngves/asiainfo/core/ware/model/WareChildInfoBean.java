package ngves.asiainfo.core.ware.model;

import java.io.Serializable;

public class WareChildInfoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7656877923412730821L;
	//编码
	private String wareCode;
	//场次
	private String Screening;
	//市场价
	private String iptMarketPrice;
	//结算价
	private String iptCountPrice;
	//票价
	private String ticketPrice;
	
	public WareChildInfoBean() {
		super();
	}
	public WareChildInfoBean(String wareCode, String screening, String iptMarketPrice, String iptCountPrice,
			String ticketPrice) {
		super();
		this.wareCode = wareCode;
		Screening = screening;
		this.iptMarketPrice = iptMarketPrice;
		this.iptCountPrice = iptCountPrice;
		this.ticketPrice = ticketPrice;
	}
	public String getWareCode() {
		return wareCode;
	}
	public void setWareCode(String wareCode) {
		this.wareCode = wareCode;
	}
	public String getScreening() {
		return Screening;
	}
	public void setScreening(String screening) {
		Screening = screening;
	}
	public String getIptMarketPrice() {
		return iptMarketPrice;
	}
	public void setIptMarketPrice(String iptMarketPrice) {
		this.iptMarketPrice = iptMarketPrice;
	}
	public String getIptCountPrice() {
		return iptCountPrice;
	}
	public void setIptCountPrice(String iptCountPrice) {
		this.iptCountPrice = iptCountPrice;
	}
	public String getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(String ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Screening == null) ? 0 : Screening.hashCode());
		result = prime * result + ((iptCountPrice == null) ? 0 : iptCountPrice.hashCode());
		result = prime * result + ((iptMarketPrice == null) ? 0 : iptMarketPrice.hashCode());
		result = prime * result + ((ticketPrice == null) ? 0 : ticketPrice.hashCode());
		result = prime * result + ((wareCode == null) ? 0 : wareCode.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WareChildInfoBean other = (WareChildInfoBean) obj;
		if (Screening == null) {
			if (other.Screening != null)
				return false;
		} else if (!Screening.equals(other.Screening))
			return false;
		if (iptCountPrice == null) {
			if (other.iptCountPrice != null)
				return false;
		} else if (!iptCountPrice.equals(other.iptCountPrice))
			return false;
		if (iptMarketPrice == null) {
			if (other.iptMarketPrice != null)
				return false;
		} else if (!iptMarketPrice.equals(other.iptMarketPrice))
			return false;
		if (ticketPrice == null) {
			if (other.ticketPrice != null)
				return false;
		} else if (!ticketPrice.equals(other.ticketPrice))
			return false;
		if (wareCode == null) {
			if (other.wareCode != null)
				return false;
		} else if (!wareCode.equals(other.wareCode))
			return false;
		return true;
	}
}
