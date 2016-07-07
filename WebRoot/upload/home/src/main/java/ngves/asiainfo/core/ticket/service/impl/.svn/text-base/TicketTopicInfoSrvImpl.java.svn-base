package ngves.asiainfo.core.ticket.service.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.ticket.TicketConstant;
import ngves.asiainfo.core.ticket.dao.interfaces.ITicketTopicInfoDAO;
import ngves.asiainfo.core.ticket.ivalues.IQBOTicketTopicInfoValue;
import ngves.asiainfo.core.ticket.ivalues.ITicketTopicInfoValue;
import ngves.asiainfo.core.ticket.service.interfaces.ITicketTopicInfoSrv;
import ngves.asiainfo.core.ticket.util.TicketUtil;

/**
 * 票务类专题业务接口实现
 * @author WL
 *
 */
public class TicketTopicInfoSrvImpl implements ITicketTopicInfoSrv{
	
	private ITicketTopicInfoDAO ticketTopicInfoDAO;
	 public void setTicketTopicInfoDAO(ITicketTopicInfoDAO ticketTopicInfoDAO) {
		this.ticketTopicInfoDAO = ticketTopicInfoDAO;
	}
	/*
     * 查询所有票务专题页信息
     */
	public IQBOTicketTopicInfoValue[] queryTicketTopicInfo(int startIndex,int endIndex) throws Exception {
		IQBOTicketTopicInfoValue[] ticketTopicInfoValues  =  ticketTopicInfoDAO.queryTicketTopicInfo(null, null, null, startIndex, endIndex);
		for (int i = 0; i < ticketTopicInfoValues.length; i++) {
			String wareKindIds = ticketTopicInfoValues[i].getWareKindIds();
			String wareKindName = getWareKindNameByWareKindId(wareKindIds);
			ticketTopicInfoValues[i].setWareKind(wareKindName);
		}
		return ticketTopicInfoValues;
	}
	public int queryTicketTopicInfoCount() throws Exception {
		return ticketTopicInfoDAO.queryTicketTopicInfoCount();
	}
	/*
	 * 保存、删除、修改票务专题页信息
	 */
	public void saveTicketInfo(ITicketTopicInfoValue ticketValue,String operate) throws Exception {
		
		if(operate.equals(TicketConstant.OPERATE_UPDATE)){ 
			ticketTopicInfoDAO.modifyTicketInfo(ticketValue);
		}
		else if(operate.equals(TicketConstant.OPERATE_ADD)){ 
			ticketTopicInfoDAO.saveTicketInfo(ticketValue);
		}else if(operate.equals(TicketConstant.OPERATE_DELETE)){ 
			ticketTopicInfoDAO.deleteTicketInfo(ticketValue);
		}
	}
	/*
	 * 根据一组、或一个分类标识，获取分类名称
	 */
	public String getWareKindNameByWareKindId(String wareKindIds)
			throws Exception {
		return ticketTopicInfoDAO.getWareKindNameByWareKindId(wareKindIds);
	}
	public ITicketTopicInfoValue getTicketTopicInfo() throws Exception {
		return TicketUtil.getTicketTopicInfo();
	}
	/*
	 * 保存票务专题到Memcache缓存中
	 */
	public void setTicketTopicInfoToCache(ITicketTopicInfoValue value) throws Exception {
		TicketUtil.setTicketTopicInfo(value);		
	}
	/**根据专题id获取专题信息
	 * @param topicId
	 * @return
	 * @throws Exception
	 */
	public ITicketTopicInfoValue queryTicketTopicInfoByTopicId(String topicId) throws Exception{
		StringBuffer condition = new StringBuffer();
		Map<String, String> parameter = new HashMap<String, String>();
		condition.append("1=1");
		condition.append(" AND ").append(ITicketTopicInfoValue.S_TopicId).append("=:").append(ITicketTopicInfoValue.S_TopicId);
		parameter.put(ITicketTopicInfoValue.S_TopicId,topicId);
		return ticketTopicInfoDAO.queryTicketTopicInfoByTopicId(condition.toString(), parameter);
	}
		
}
