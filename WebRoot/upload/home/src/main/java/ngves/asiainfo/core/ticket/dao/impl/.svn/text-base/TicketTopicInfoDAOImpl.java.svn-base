package ngves.asiainfo.core.ticket.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Map;

import ngves.asiainfo.core.common.util.DBCnnUtil;
import ngves.asiainfo.core.ticket.bo.QBOTicketTopicInfoEngine;
import ngves.asiainfo.core.ticket.bo.TicketTopicInfoBean;
import ngves.asiainfo.core.ticket.bo.TicketTopicInfoEngine;
import ngves.asiainfo.core.ticket.dao.interfaces.ITicketTopicInfoDAO;
import ngves.asiainfo.core.ticket.ivalues.IQBOTicketTopicInfoValue;
import ngves.asiainfo.core.ticket.ivalues.ITicketTopicInfoValue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 票务类专题数据层接口实现
 * 
 * @author WL
 * 
 */
public class TicketTopicInfoDAOImpl implements ITicketTopicInfoDAO {
	private static Log logger =LogFactory.getLog(TicketTopicInfoDAOImpl.class);
	/*
	 * 查询所有票务专题页信息
	 */
	public IQBOTicketTopicInfoValue[] queryTicketTopicInfo(String condition,
			Map<String, Object> parameter, String partnerId, int startIndex,
			int endIndex) throws Exception {
	     return QBOTicketTopicInfoEngine.getBeans(null, null, null, startIndex, endIndex, true, null);
	}
	public int queryTicketTopicInfoCount() throws Exception {
		return TicketTopicInfoEngine.getBeansCount(null, null);
	}
	/*
	 * 根据一组、或一个分类标识，获取分类名称
	 */
	public String getWareKindNameByWareKindId(String wareKindIds)
			throws Exception {
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			if(wareKindIds == null){
				logger.error("wareKindIds is null:topic no Binding ware_kind please check ……");
			}
			String[] wks = wareKindIds.split(",");
			StringBuffer sbf = new StringBuffer();
			sbf.append("select wm_concat(kind_name) kind_name from ware_kind wk where wk.ware_kind_id in(");
			for (int i = 0; i < wks.length; i++) {
				sbf.append("?").append(",");
			}
			sbf.append("?)"); //多一个空赋值项.
			conn = DBCnnUtil.getDBConnection();
			ps = conn.prepareStatement(sbf.toString());
			for (int i = 0; i < wks.length; i++) {
				ps.setString(i+1, wks[i]);
			}
			ps.setString(wks.length+1, "");//多一个空赋值项.
			ps.execute();
			rs = ps.executeQuery();
			String result = "";
			if (rs.next()) {
				result = rs.getString("kind_name");
			}
			wks=null;
			sbf=null;
			return result;
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBCnnUtil.closeDBConnetion(rs,ps,conn);
		}
	}
	/*
	 * 保存票务专题页信息
	 */
	public void saveTicketInfo(ITicketTopicInfoValue tickValue) throws Exception{
		long ticketId = TicketTopicInfoEngine.getNewId().longValue();
		tickValue.setTopicId(ticketId);
		tickValue.setStsToNew();
		TicketTopicInfoEngine.save(tickValue);
		//return ticketId;
	}
	/*
	 * 修改票务专题信息
	 */
	public void modifyTicketInfo(ITicketTopicInfoValue ticketValue)
			throws Exception {
		 ITicketTopicInfoValue newDataBean = TicketTopicInfoEngine.getBean(ticketValue.getTopicId()); 
		 
		 newDataBean.setTopicName(ticketValue.getTopicName());
		 newDataBean.setTopicUrl(ticketValue.getTopicUrl());
		 newDataBean.setTopicTitle(ticketValue.getTopicTitle());
		 newDataBean.setTopicInfo(ticketValue.getTopicInfo());
		 
		 newDataBean.setTopicBgImage(ticketValue.getTopicBgImage());
		 newDataBean.setDescBgImage(ticketValue.getDescBgImage());
		 newDataBean.setTopicColor(ticketValue.getTopicColor());
		 newDataBean.setTopicPic(ticketValue.getTopicPic());
		 
		 newDataBean.setTopicTemplet(ticketValue.getTopicTemplet());
		 newDataBean.setWareKindIds(ticketValue.getWareKindIds());
		 
		 newDataBean.setRecordPartner(ticketValue.getRecordPartner());
		 newDataBean.setRecordTime(ticketValue.getRecordTime());
		 TicketTopicInfoEngine.save(newDataBean);
		
	}
	/*
	 * 删除票务专题信息
	 */
	public void deleteTicketInfo(ITicketTopicInfoValue ticketValue)
			throws Exception {
		  	ITicketTopicInfoValue  newDataBean = TicketTopicInfoEngine.getBean(ticketValue.getTopicId());
	        newDataBean.delete();
	        newDataBean.setTopicId(ticketValue.getTopicId());
	        TicketTopicInfoEngine.save(newDataBean);
	}
	
	/**根据专题id获取专题信息 liulin
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public ITicketTopicInfoValue queryTicketTopicInfoByTopicId(String condition, Map<String, String> parameter) throws Exception {
		ITicketTopicInfoValue[] ticketTopicInfoValues = TicketTopicInfoEngine.getBeans(condition, parameter);
		if(null != ticketTopicInfoValues && ticketTopicInfoValues.length>0)
			return ticketTopicInfoValues[0];
		else
			return new TicketTopicInfoBean();
	}

}
