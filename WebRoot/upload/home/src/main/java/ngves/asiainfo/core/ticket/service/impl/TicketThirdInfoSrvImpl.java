package ngves.asiainfo.core.ticket.service.impl;

import ngves.asiainfo.core.ticket.dao.interfaces.ITicketThirdInfoDAO;
import ngves.asiainfo.core.ticket.ivalues.ITicketThirdInfoValue;
import ngves.asiainfo.core.ticket.service.interfaces.ITicketThirdInfoSrv;

public class TicketThirdInfoSrvImpl implements ITicketThirdInfoSrv {

	private ITicketThirdInfoDAO ticketThirdInfoDAO;

	public void setTicketThirdInfoDAO(ITicketThirdInfoDAO ticketThirdInfoDAO) throws Exception {

		this.ticketThirdInfoDAO = ticketThirdInfoDAO;
	}

	public ITicketThirdInfoValue getTicketThirdInfoByKey(String ticketKey, String lockEndTime) throws Exception {
		return ticketThirdInfoDAO.getTicketThirdInfoByKey(ticketKey, lockEndTime);
	}

	public String getTicketThirdInfoByKey(String ticketKey, String wareId, String lockEndTime, String pWareCode,
			String ticketMobile, String movieName, String showTime, String ticketPrice, String ticketNum,
			String seatNumList, String sequenceNum, String lockPeriod, String password,String ticketStartTime) throws Exception {
		return ticketThirdInfoDAO.getTicketThirdInfoByKey(ticketKey,wareId, lockEndTime, pWareCode, ticketMobile, movieName,
				showTime, ticketPrice, ticketNum, seatNumList, sequenceNum, lockPeriod, password,ticketStartTime);
	}
}
