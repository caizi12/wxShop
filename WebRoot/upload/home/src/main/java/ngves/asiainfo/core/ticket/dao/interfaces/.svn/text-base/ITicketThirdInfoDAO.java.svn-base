package ngves.asiainfo.core.ticket.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.ticket.ivalues.ITicketThirdInfoValue;

public interface ITicketThirdInfoDAO {

	/**
	 * 
	 * @param ticketKey
	 *            当前用户选做礼品的主键
	 * @param lockEndTime
	 *            锁定礼品结束时间
	 * @return
	 * @throws Exception
	 *             1. ticketKey -->>查表：有数据,更新lockedEndTime
	 *             ,无数据，插入lockedEndTime和ticketKey字段-->>返回lockedEndTime
	 */
	public ITicketThirdInfoValue getTicketThirdInfoByKey(String ticketKey,String lockedEndTime) throws Exception;

	public String getTicketThirdInfoByKey(String ticketKey,String wareId, String lockEndTime, String pWareCode, String ticketMobile,
			String movieName, String showTime, String ticketPrice, String ticketNum, String seatNumList,
			String sequenceNum, String lockPeriod, String password,String ticketStartTime) throws Exception;

	public ITicketThirdInfoValue[] getTicketThirdInfo(String condition, Map<String, String> parameters)
			throws Exception;

	public long saveTicketThirdInfo(ITicketThirdInfoValue value) throws Exception;
}
