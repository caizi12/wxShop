/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.dao.impl;

import ngves.asiainfo.core.common.ivalues.IBusiAllegeCommentValue;
import ngves.asiainfo.core.common.ivalues.IBusiAllegeRejectSendValue;
import ngves.asiainfo.core.common.ivalues.IBusiAllegeReplySendValue;
import ngves.asiainfo.core.common.util.InterMsgBusiUtil;
import ngves.asiainfo.core.csvc.CsvcConstant;
import ngves.asiainfo.core.csvc.dao.interfaces.ICsvcSendDAO;
import ngves.asiainfo.core.csvc.util.BeanToXmlObjUtil;
import ngves.asiainfo.core.csvc.util.CustomActionTypeEnum;
import ngves.asiainfo.core.csvc.util.BeanToXmlObjUtil.CsvcInterPara;
import ngves.asiainfo.interfaces.InterConstant;
import ngves.asiainfo.interfaces.InterPara;
import ngves.asiainfo.interfaces.csvc.bean.common.CsvcCommonInterBoss;
import ngves.asiainfo.interfaces.csvc.model.SendCallInfo;
import ngves.asiainfo.interfaces.csvc.realtime.CustomSendInter;

/**
 * 一级客服发送默认DAO实现类
 * @author wzg
 *
 */
public class CsvcSendDAOImpl implements ICsvcSendDAO {

	/**
	 * 投诉回复发送
	 * @param allegeReplySendValue
	 * @return CsvcCommonInterBoss
	 * @throws Exception
	 */
	public CsvcCommonInterBoss sendAllegeReply(IBusiAllegeReplySendValue allegeReplySendValue) throws Exception {
		SendCallInfo sendCallInfo = getCsvcSendCallInfo();
		//生成发送报文
		CsvcCommonInterBoss in = BeanToXmlObjUtil.createReplyInterBoss(new CsvcInterPara(
				CsvcConstant.ALLEGE_REPLY_BIGCODE, CsvcConstant.ALLEGE_REPLY_ACTIVITYCODE, ""
						+ allegeReplySendValue.getBusiId(), "" + sendCallInfo.getInterMsgId()), allegeReplySendValue);
		CsvcCommonInterBoss out = CustomSendInter.getInstance().doSendBusi(in, sendCallInfo);
		//记录报文流水
		InterMsgBusiUtil.recordInterMsg(CustomActionTypeEnum.AllegeReplySend.getValue(), sendCallInfo);
		return out;
	}

	/**
	 * 中途意见发送
	 * @param allegeCommentSendValue
	 * @return
	 * @throws Exception
	 */
	public CsvcCommonInterBoss sendAllegeComment(IBusiAllegeCommentValue allegeCommentSendValue) throws Exception {
		SendCallInfo sendCallInfo = getCsvcSendCallInfo();
		//生成发送报文
		CsvcCommonInterBoss in = BeanToXmlObjUtil.createCommentInterBoss(new CsvcInterPara(
				CsvcConstant.ALLEGE_COMMENT_BIGCODE, CsvcConstant.ALLEGE_COMMENT_ACTIVITYCODE, ""
						+ allegeCommentSendValue.getBusiId(), "" + sendCallInfo.getInterMsgId()),
				allegeCommentSendValue);
		CsvcCommonInterBoss out = CustomSendInter.getInstance().doSendBusi(in, sendCallInfo);
		//记录报文流水
		InterMsgBusiUtil.recordInterMsg(CustomActionTypeEnum.AllegeCommentSend.getValue(), sendCallInfo);
		return out;
	}

	/**
	 * 投诉退回发送
	 * @param allegeRejectSendValue
	 * @return
	 * @throws Exception
	 */
	public CsvcCommonInterBoss sendAllegeReject(IBusiAllegeRejectSendValue allegeRejectSendValue) throws Exception {
		SendCallInfo sendCallInfo = getCsvcSendCallInfo();
		//生成发送报文
		CsvcCommonInterBoss in = BeanToXmlObjUtil.createRejectInterBoss(new CsvcInterPara(
				CsvcConstant.ALLEGE_REJECT_BIGCODE, CsvcConstant.ALLEGE_REJECT_ACTIVITYCODE, ""
						+ allegeRejectSendValue.getBusiId(), "" + sendCallInfo.getInterMsgId()), allegeRejectSendValue);
		CsvcCommonInterBoss out = CustomSendInter.getInstance().doSendBusi(in, sendCallInfo);
		//记录报文流水
		InterMsgBusiUtil.recordInterMsg(CustomActionTypeEnum.AllegeRejectSend.getValue(), sendCallInfo);
		return out;
	}
	
	/**
	 * 获取一级客服的发送回调对象
	 * @return
	 * @throws Exception
	 */
	private SendCallInfo getCsvcSendCallInfo() throws Exception{
		SendCallInfo sendCallInfo = new SendCallInfo();
		sendCallInfo.setInterMsgId(InterMsgBusiUtil.getBusiInterMsgId());
		sendCallInfo.setInterUrl(InterPara.get(InterConstant.CSVC_BUSINESS_URL));
		return sendCallInfo;
	}

}
