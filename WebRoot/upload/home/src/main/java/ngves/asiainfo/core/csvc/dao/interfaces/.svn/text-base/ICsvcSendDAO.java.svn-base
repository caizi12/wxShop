/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.dao.interfaces;

import ngves.asiainfo.core.common.ivalues.IBusiAllegeCommentValue;
import ngves.asiainfo.core.common.ivalues.IBusiAllegeRejectSendValue;
import ngves.asiainfo.core.common.ivalues.IBusiAllegeReplySendValue;
import ngves.asiainfo.interfaces.csvc.bean.common.CsvcCommonInterBoss;

/**
 * 发送接口的DAO操作
 * @author wzg
 *
 */
public interface ICsvcSendDAO {

	public CsvcCommonInterBoss sendAllegeReply(IBusiAllegeReplySendValue allegeReplySendValue) throws Exception;

	/**
	 * 发送中途意见
	 * @param allegeCommentSendValue
	 * @return
	 * @throws Exception
	 */
	public CsvcCommonInterBoss sendAllegeComment(IBusiAllegeCommentValue allegeCommentSendValue) throws Exception;

	/**
	 * 发送投诉退回发送
	 * @param allegeRejectSendValue
	 * @return
	 * @throws Exception
	 */
	public CsvcCommonInterBoss sendAllegeReject(IBusiAllegeRejectSendValue allegeRejectSendValue) throws Exception;
}
