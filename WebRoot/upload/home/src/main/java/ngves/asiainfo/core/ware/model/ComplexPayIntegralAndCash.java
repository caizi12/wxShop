package ngves.asiainfo.core.ware.model;

import java.io.Serializable;

/**
 * 用于封装凤凰手机报的现金+积分
 * */
public class ComplexPayIntegralAndCash  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//全积分
	private long integralValue;
	//混合积分的积分值
	private long payIntegral;
	//混合支付的现金值
	private String payCash;
	public long getIntegralValue() {
		return integralValue;
	}
	public void setIntegralValue(long integralValue) {
		this.integralValue = integralValue;
	}
	public long getPayIntegral() {
		return payIntegral;
	}
	public void setPayIntegral(long payIntegral) {
		this.payIntegral = payIntegral;
	}
	public String getPayCash() {
		return payCash;
	}
	public void setPayCash(String payCash) {
		this.payCash = payCash;
	}
	
	

}
