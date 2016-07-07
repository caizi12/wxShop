package ngves.asiainfo.core.ticket.service.interfaces;

import ngves.asiainfo.core.ticket.dao.interfaces.ITicketThirdInfoDAO;
import ngves.asiainfo.core.ticket.ivalues.ITicketThirdInfoValue;

public interface ITicketThirdInfoSrv {
	
	public void setTicketThirdInfoDAO(ITicketThirdInfoDAO ticketThirdInfoDAO) throws Exception;
	
	/**
	 * 
	 * @param ticketKey   当前用户选做礼品的主键
	 * @param lockEndTime 锁定礼品结束时间
	 * @return
	 * @throws Exception
	 * 1. ticketKey -->>查表：有数据,更新lockedEndTime ,无数据，插入lockedEndTime和ticketKey字段-->>返回lockedEndTime
	 */
	public ITicketThirdInfoValue getTicketThirdInfoByKey(String ticketKey,String lockEndTime) throws Exception;
	
	public String getTicketThirdInfoByKey(String ticketKey, String wareId, String lockEndTime, String pWareCode,
			String ticketMobile, String movieName, String showTime, String ticketPrice, String ticketNum,
			String seatNumList, String sequenceNum, String lockPeriod, String password, String ticketStartTime)
			throws Exception;
}
