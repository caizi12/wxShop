/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.service.interfaces;

import ngves.asiainfo.core.common.ivalues.IBusiAllegeCommentValue;
import ngves.asiainfo.core.common.ivalues.IBusiAllegeRejectSendValue;
import ngves.asiainfo.core.common.ivalues.IBusiAllegeReplySendValue;
import ngves.asiainfo.core.csvc.dao.interfaces.*;
import ngves.asiainfo.interfaces.csvc.bean.common.CsvcCommonInterBoss;

/**
 * CRM类投诉信息发送服务接口
 * @author wzg
 */
public interface ICrmAllegeSendSrv {
	/**
	 * <p>投诉回复：异常方法内处理<br/>
	 * 1：记录投诉回复流水,记录客服交互流水。<br/>
	 * 2: 发送报文,记录发送的报文和结果到报文流水表。<br/>
	 * 3：参数为null时返回null
	 * @param allegeReplyInfo
	 * @return
	 */
	public CsvcCommonInterBoss allegeReply(IBusiAllegeReplySendValue allegeReplyInfo) throws Exception;
	/**
	 * <p>投诉退回：异常方法内处理<br/>
	 * 1：记录投诉退回流水,记录客服交互流水。<br/>
	 * 2: 发送报文,记录发送的报文和结果到报文流水表。<br/>
	 * 3：参数为null时返回null
	 * @param allegeRejectInfo
	 * @return
	 */
	public CsvcCommonInterBoss allegeReject(IBusiAllegeRejectSendValue allegeRejectInfo) throws Exception;
	/**
	 * <p>中途意见发送：异常方法内处理<br/>
	 * 1：记录中途意见流水,记录客服交互流水。<br/>
	 * 2: 发送报文,记录发送的报文和结果到报文流水表。<br/>
	 * 3：参数为null时返回null
	 * @param allegeCommentInfo
	 * @return
	 */
	public CsvcCommonInterBoss allegeCommentSend(IBusiAllegeCommentValue allegeCommentInfo, long staffId, long orgId)  throws Exception;
	
	public void setBusiCustomCommunionDao(IBusiCustomCommunionDAO busiCustomCommunionDao);
	public void setBusiAllegeReplySendDao(IBusiAllegeReplySendDAO busiAllegeReplySendDao);
	public void setBusiAllegeRejectSendDao(IBusiAllegeRejectSendDAO busiAllegeRejectSendDao);
	public void setBusiAllegeCommentDao(IBusiAllegeCommentDAO busiAllegeCommentDao);
	public void setCsvcSendDao(ICsvcSendDAO csvcSendDao);
    public void setBusiAllegeAssignAcceptDao(IBusiAllegeAssignAcceptDAO busiAllegeAssignAcceptDao);

	
}
