package ngves.asiainfo.core.ticket.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.ticket.bo.TicketThirdInfoBean;
import ngves.asiainfo.core.ticket.bo.TicketThirdInfoEngine;
import ngves.asiainfo.core.ticket.dao.interfaces.ITicketThirdInfoDAO;
import ngves.asiainfo.core.ticket.ivalues.ITicketThirdInfoValue;
import ngves.asiainfo.util.DateTimeUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TicketThirdInfoDAOImpl implements ITicketThirdInfoDAO {
	
	private static transient Log logger = LogFactory.getLog(TicketThirdInfoDAOImpl.class);
	
	public long saveTicketThirdInfo(ITicketThirdInfoValue value) throws Exception {
		
		TicketThirdInfoEngine.save(value);
		return value.getTicketThirdId();
	}
	public String getTicketThirdInfoByKey(String ticketKey,String wareId, String lockedEndTime, String pWareCode, String ticketMobile,
			String movieName, String showTime, String ticketPrice, String ticketNum, String seatNumList,
			String sequenceNum, String lockPeriod, String password,String ticketStartTime) throws Exception{
		//保存或更新操作
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String,String> parameter = new HashMap<String,String>();
		condition.append(" and ").append(ITicketThirdInfoValue.S_TicketMainKey).append("=:").append(ITicketThirdInfoValue.S_TicketMainKey);
		parameter.put(ITicketThirdInfoValue.S_TicketMainKey, ticketKey);
		ITicketThirdInfoValue[] values =  null;
		values = TicketThirdInfoEngine.getBeans(condition.toString(), parameter);
		ITicketThirdInfoValue tmp  = null;
		if(values!=null && values.length>0){
			logger.info("-------update--------------");
			//update
			tmp = values[0];
			tmp.setStsToOld();
			tmp.setTicketMainKey(ticketKey);
			tmp.setWareId(new Long(wareId));
			tmp.setLockEndTime(DateTimeUtil.stringToTimestamp(lockedEndTime, CommnConstant.DATETIME_JAVA_FORMAT));
			tmp.setPWareCode(pWareCode);
			tmp.setTicketNum(new Long(ticketMobile));
			tmp.setMovieName(movieName);
			tmp.setShowTime(showTime);
			tmp.setTicketPrice(ticketPrice);
			tmp.setTicketNum(new Long(ticketNum));
			tmp.setSeatNumList(seatNumList);
			tmp.setSequenceNum(sequenceNum);
			tmp.setLockPeriod(new Long(lockPeriod));
			tmp.setMd5Code(password);
			tmp.setMobileNum(ticketMobile);
			tmp.setTicketStartTime(DateTimeUtil.stringToTimestamp(ticketStartTime, CommnConstant.DATETIME_JAVA_FORMAT));
		} else {
			logger.info("-------save--------------");
			//save
			tmp = new TicketThirdInfoBean();
			tmp.setTicketMainKey(ticketKey);
			tmp.setTicketThirdId(TicketThirdInfoEngine.getNewId().longValue());
			
			tmp.setLockEndTime(DateTimeUtil.stringToTimestamp(lockedEndTime, CommnConstant.DATETIME_JAVA_FORMAT));
			tmp.setWareId(new Long(wareId));
			tmp.setPWareCode(pWareCode);
			tmp.setTicketNum(new Long(ticketMobile));
			tmp.setMovieName(movieName);
			tmp.setShowTime(showTime);
			tmp.setTicketPrice(ticketPrice);
			tmp.setTicketNum(new Long(ticketNum));
			tmp.setSeatNumList(seatNumList);
			tmp.setSequenceNum(sequenceNum);
			tmp.setLockPeriod(new Long(lockPeriod));
			tmp.setMobileNum(ticketMobile);
			tmp.setTicketStartTime(DateTimeUtil.stringToTimestamp(ticketStartTime, CommnConstant.DATETIME_JAVA_FORMAT));
			tmp.setMd5Code(password);
		}
		TicketThirdInfoEngine.save(tmp);
		return null;
	}
	public ITicketThirdInfoValue getTicketThirdInfoByKey(String ticketKey,String lockedEndTime) throws Exception {
		//保存或更新操作
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String,String> parameter = new HashMap<String,String>();
		condition.append(" and ").append(ITicketThirdInfoValue.S_TicketMainKey).append("=:").append(ITicketThirdInfoValue.S_TicketMainKey);
		parameter.put(ITicketThirdInfoValue.S_TicketMainKey, ticketKey);
		ITicketThirdInfoValue[] values =  null;
		//获取返回结果
		values = TicketThirdInfoEngine.getBeans(condition.toString(), parameter);
		ITicketThirdInfoValue value  = null;
		if(values!=null && values.length>0){
			 value  = values[0];
			//result = DateTimeUtil.format(value.getLockEndTime(),CommnConstant.DATETIME_JAVA_FORMAT);
		}
		return value;
	}
	public ITicketThirdInfoValue[] getTicketThirdInfo(String condition, Map<String, String> parameters)
			throws Exception {
		return TicketThirdInfoEngine.getBeans(condition.toString(), parameters);
	}
}
