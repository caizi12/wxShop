/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.service.impl;

import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.common.bo.AllegeInfoEngine;
import ngves.asiainfo.core.common.ivalues.*;
import ngves.asiainfo.core.csvc.CsvcException;
import ngves.asiainfo.core.csvc.dao.interfaces.*;
import ngves.asiainfo.util.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ngves.asiainfo.core.csvc.CsvcConstant;
import ngves.asiainfo.core.csvc.util.CustomActionTypeEnum;
import ngves.asiainfo.interfaces.InterConstant;
import ngves.asiainfo.interfaces.csvc.bean.common.CsvcCommonInterBoss;
import ngves.asiainfo.core.csvc.service.interfaces.ICrmAllegeSendSrv;
import ngves.asiainfo.util.DateTimeUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wzg create
 *
 */
public class CrmAllegeSendSrvImpl implements ICrmAllegeSendSrv {
    private static Log logger = LogFactory.getLog(CrmAllegeSendSrvImpl.class);

	public IBusiCustomCommunionDAO getBusiCustomCommunionDao() {
		return busiCustomCommunionDao;
	}

	public void setBusiCustomCommunionDao(
			IBusiCustomCommunionDAO busiCustomCommunionDao) {
		this.busiCustomCommunionDao = busiCustomCommunionDao;
	}

	public IBusiAllegeReplySendDAO getBusiAllegeReplySendDao() {
		return busiAllegeReplySendDao;
	}

	public void setBusiAllegeReplySendDao(
			IBusiAllegeReplySendDAO busiAllegeReplySendDao) {
		this.busiAllegeReplySendDao = busiAllegeReplySendDao;
	}

	public IBusiAllegeRejectSendDAO getBusiAllegeRejectSendDao() {
		return busiAllegeRejectSendDao;
	}

	public void setBusiAllegeRejectSendDao(
			IBusiAllegeRejectSendDAO busiAllegeRejectSendDao) {
		this.busiAllegeRejectSendDao = busiAllegeRejectSendDao;
	}

	public IBusiAllegeCommentDAO getBusiAllegeCommentDao() {
		return busiAllegeCommentDao;
	}

	public void setBusiAllegeCommentDao(IBusiAllegeCommentDAO busiAllegeCommentDao) {
		this.busiAllegeCommentDao = busiAllegeCommentDao;
	}

	public ICsvcSendDAO getCsvcSendDao() {
		return csvcSendDao;
	}

	public void setCsvcSendDao(ICsvcSendDAO csvcSendDao) {
		this.csvcSendDao = csvcSendDao;
	}

    public void setBusiAllegeAssignAcceptDao(IBusiAllegeAssignAcceptDAO busiAllegeAssignAcceptDao) {
        this.busiAllegeAssignAcceptDao = busiAllegeAssignAcceptDao;
    }

    private static transient Log log = LogFactory.getLog(CrmAllegeSendSrvImpl.class);

	IBusiCustomCommunionDAO busiCustomCommunionDao;
	IBusiAllegeReplySendDAO busiAllegeReplySendDao;
	IBusiAllegeRejectSendDAO busiAllegeRejectSendDao;
	IBusiAllegeCommentDAO busiAllegeCommentDao;
	ICsvcSendDAO csvcSendDao;
    IBusiAllegeAssignAcceptDAO busiAllegeAssignAcceptDao;

	/**
	 * <p>投诉回复：异常方法内处理<br/>
	 * 1：记录投诉回复流水,记录客服交互流水。<br/>
	 * 2: 发送报文,记录发送的报文和结果到报文流水表。
	 * @param allegeReplyInfo
	 * @return
	 */
	public CsvcCommonInterBoss allegeReply(IBusiAllegeReplySendValue allegeReplyInfo) throws Exception{

		CsvcCommonInterBoss in = null;
		try {
			if (allegeReplyInfo == null) {
				log.warn("AllegeReplyInfo should not be null..");
				return in;
			}

			busiAllegeReplySendDao.saveBusiAllegeReplySend(allegeReplyInfo);
			busiCustomCommunionDao.saveSendBusiCustomCommunion(CsvcConstant.BUSI_STATUS_END,
					CustomActionTypeEnum.AllegeReplySend.getValue(), allegeReplyInfo.getBusiId(), allegeReplyInfo
							.getIndictseq());
			//转变allegeReplyInfo为xml保存到客服发送报文流水表并发送
            logger.info("sending AllegeReply...");
			in = csvcSendDao.sendAllegeReply(allegeReplyInfo);
            logger.info("send AllegeReply completed.");
            updateAllegeInfoIndictStatus(allegeReplyInfo.getIndictseq(), CoreConstant.SYS_PARA_CENTER_ALLEGE_RESPOND);
            if(!in.getResponse().getRspCode().equals(InterConstant.SUCC)) {
				throw new CsvcException(in.getResponse().getRspCode(), in.getResponse().getRspDesc());
		    }
		} catch (Exception e) {
			log.error("AllegeReply method occur an  exception ...", e);
            throw e;
		}
		return in;

	}

 public static void updateAllegeInfoIndictStatus(String indictSeq, String indictStatus) throws Exception{
     Map<String, String> params = new HashMap<String, String>();
     params.put(IAllegeInfoValue.S_Indictseq, indictSeq);
     IAllegeInfoValue[] values = AllegeInfoEngine.getBeans(IAllegeInfoValue.S_Indictseq + " = :" + IAllegeInfoValue.S_Indictseq, params);
     if(values == null || values.length < 1){
        logger.error("can't find allege_info by indictseq:" + indictSeq);
         return;
     }

     //更新indict_status
     logger.info("updating allege_info's indictStatus to " + indictStatus);
     IAllegeInfoValue allegeInfo = values[0];
     allegeInfo.setStsToOld();
     allegeInfo.setIndictStatus(indictStatus);
     AllegeInfoEngine.save(allegeInfo);
  }

	/**
	 * <p>中途意见发送：异常方法内处理<br/>
	 * 1：记录中途意见流水,记录客服交互流水。<br/>
	 * 2: 发送报文,记录发送的报文和结果到报文流水表。
	 * @param allegeCommentInfo
	 * @return
	 * @throws Exception 
	 */
	public CsvcCommonInterBoss allegeCommentSend(IBusiAllegeCommentValue allegeCommentInfo, long staffId, long orgId) throws Exception  {

		CsvcCommonInterBoss in = null;
		allegeCommentInfo.setCreateDate(DateTimeUtil.getNowTimeStamp());
		allegeCommentInfo.setHandlingstaff(staffId + "");
		allegeCommentInfo.setHandlingdept(orgId + "");
		allegeCommentInfo.setCommentType(CustomActionTypeEnum.AllegeCommentSend.getValue());
		busiAllegeCommentDao.saveBusiAllegeComment(allegeCommentInfo);
		busiCustomCommunionDao.saveSendBusiCustomCommunion(CsvcConstant.BUSI_STATUS_END,
				CustomActionTypeEnum.AllegeCommentSend.getValue(), allegeCommentInfo.getBusiId(), allegeCommentInfo
						.getIndictseq());
		in = csvcSendDao.sendAllegeComment(allegeCommentInfo);
		if(!in.getResponse().getRspCode().equals(InterConstant.SUCC)) {
				throw new CsvcException(in.getResponse().getRspCode(), in.getResponse().getRspDesc());
		}
        return in;
	}

	/**
	 * <p>投诉退回：异常方法内处理<br/>
	 * 1：记录投诉退回流水,记录客服交互流水。<br/>
	 * 2: 发送报文,记录发送的报文和结果到报文流水表。
	 * @param allegeRejectInfo
	 * @return
	 */
	public CsvcCommonInterBoss allegeReject(IBusiAllegeRejectSendValue allegeRejectInfo) throws Exception{

		CsvcCommonInterBoss in = null;
		try {
			if (allegeRejectInfo == null) {
				log.warn("AllegeRejectInfo should not be null..");
				return in;
			}
            //----- 修改AssignAccept表的状态为完结
            String indictSeq = allegeRejectInfo.getIndictseq();
            if(!StringUtil.isBlank(indictSeq)){
                IBusiAllegeAssignAcceptValue assignValue = busiAllegeAssignAcceptDao.getByIndictSeq(indictSeq);
                if(assignValue != null){
                    if(CoreConstant.SYS_PARA_BUSI_ALLEGE_COMPLETE.equals(assignValue.getBusiStatus())){
                        throw new Exception("已完结的咨询投诉单不允许退回");
                    }
                    assignValue.setStsToOld();
                    assignValue.setBusiStatus(CoreConstant.SYS_PARA_BUSI_ALLEGE_COMPLETE);
                    busiAllegeAssignAcceptDao.saveBusiAllegeAssignAccept(assignValue);
                }
            }

			busiAllegeRejectSendDao.saveBusiAllegeRejectSend(allegeRejectInfo);
			busiCustomCommunionDao.saveSendBusiCustomCommunion(CsvcConstant.BUSI_STATUS_END,
					CustomActionTypeEnum.AllegeRejectSend.getValue(), allegeRejectInfo.getBusiId(), allegeRejectInfo
							.getIndictseq());

			in = csvcSendDao.sendAllegeReject(allegeRejectInfo);
            if(!in.getResponse().getRspCode().equals(InterConstant.SUCC)) {
				throw new CsvcException(in.getResponse().getRspCode(), in.getResponse().getRspDesc());
		    }
		} catch (Exception e) {
			log.error("AllegeRejectInfo method occur an  exception ...", e);
            throw e;
		}
		return in;
	}


}
