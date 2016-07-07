package ngves.asiainfo.core.sms.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.CommnPara;
import ngves.asiainfo.core.common.util.AiFtpUtil;
import ngves.asiainfo.core.sms.SmsConstant;
import ngves.asiainfo.core.sms.bo.BusiSmsAuditBean;
import ngves.asiainfo.core.sms.dao.interfaces.IBusiSmsDAO;
import ngves.asiainfo.core.sms.dao.interfaces.ISmsTaskDAO;
import ngves.asiainfo.core.sms.dao.interfaces.ISmsTemplateDAO;
import ngves.asiainfo.core.sms.exception.MgtSmsException;
import ngves.asiainfo.core.sms.ivalues.IBusiSmsAuditValue;
import ngves.asiainfo.core.sms.ivalues.IQBOSmsTaskAndTemplateValue;
import ngves.asiainfo.core.sms.ivalues.ISmsTaskValue;
import ngves.asiainfo.core.sms.ivalues.ISmsTemplateValue;
import ngves.asiainfo.core.sms.service.interfaces.ISmsTaskSrv;
import ngves.asiainfo.ftp.FtpUtil;
import ngves.asiainfo.interfaces.InterConstant;
import ngves.asiainfo.interfaces.InterPara;
import ngves.asiainfo.interfaces.hp.ProvinceUtil;
import ngves.asiainfo.interfaces.hp.bean.smsPromotionNotice.in.SmsPromotionNoticeInBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.smsPromotionNotice.in.SmsPromotionNoticeInFileList;
import ngves.asiainfo.interfaces.hp.bean.smsPromotionNotice.out.SmsPromotionNoticeOutBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.smsPromotionNoticeByWhiteList.in.SmsPromotionNoticeByWhiteListInBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.smsPromotionNoticeByWhiteList.out.SmsPromotionNoticeByWhiteListOutBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.smsPromotionResult.in.SmsPromotionResultInBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.smsPromotionResult.out.SmsPromotionResultOutBizRegReq;
import ngves.asiainfo.interfaces.hp.realtime.SmsPromotionNoticeByWhiteListInter;
import ngves.asiainfo.interfaces.hp.realtime.SmsPromotionNoticeInter;
import ngves.asiainfo.interfaces.hp.realtime.SmsPromotionResultInter;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SmsTaskSrvImpl implements ISmsTaskSrv {
	
	private static Log log = LogFactory.getLog(SmsTaskSrvImpl.class);
	
	public ISmsTaskDAO smsTaskDAO;
	public IBusiSmsDAO busiSmsDAO;
	public ISmsTemplateDAO smsTemplateDAO;

	public void setSmsTaskDAO(ISmsTaskDAO smsTaskDAO) {
		this.smsTaskDAO = smsTaskDAO;
	}

	public void setSmsTemplateDAO(ISmsTemplateDAO smsTemplateDAO) {
		this.smsTemplateDAO = smsTemplateDAO;
	}

	public void setBusiSmsDAO(IBusiSmsDAO busiSmsDAO) {
		this.busiSmsDAO = busiSmsDAO;
	}

	public void executeSmsTask(String sms_id,String operatId,String sendTime) throws Exception {
		//获得需要发送的短信任务
		log.info("SmsTemplateId is---->"+sms_id);
		ISmsTemplateValue smsTemplateValue = smsTemplateDAO.getSmsTemplateById(sms_id);
		if(null==smsTemplateValue){
			throw new Exception(SmsConstant.SMSTASK_SEND_CONCURRENT_EXCEPTION);
		}
		if(!SmsConstant.SMS_STATUS_SECONDVERIFY.equals(smsTemplateValue.getStatus())){
			throw new Exception(SmsConstant.SMSTASK_SEND_CONCURRENT_EXCEPTION);
		}
		
		//按已订阅用户发送时，直接调用白名单短信推广通知接口
		if(SmsConstant.SMS_SEND_TYPE_ORDER.equals(smsTemplateValue.getSendType())){
			sendSmsPromotionByWhiteListNoticeToHp(sms_id,smsTemplateValue);
		}else{
			//按营销号源文件发送
			downloadAndUploadFile(smsTemplateValue);
			sendSmsPromotionNoticeToHp(sms_id,smsTemplateValue);
		}
		
		updateSmsTaskValue(sms_id, SmsConstant.SMSTASK_STATUS_EXCUTING);
		updateSmsTemplateValue(sms_id,SmsConstant.SMS_STATUS_SENDING);
		insertBusiSmsAudit(sms_id,operatId,sendTime,SmsConstant.SMS_STATUS_SENDING);
	}

	
	
	public ISmsTaskValue getSmsTask(String id) throws Exception {
		//根据Id查询到需要查看的任务
		ISmsTaskValue smsTaskValue = smsTaskDAO.getSmsTask(id);
		if(SmsConstant.SMS_TASK_STATUS_FINISH.equals(smsTaskValue.getStatus())){
			if(SmsConstant.SMS_TASK_STATUS_DOWNLOAD.equals(smsTaskValue.getBakCol1())){
				smsTaskValue=setSmsTaskOperat(smsTaskValue);
			}else {
				smsTaskValue.setOpera("");
			}
		} else {
			smsTaskValue=sendSmsPromotionResultToHp(smsTaskValue);
			smsTaskValue.setOpera("");
		}
		return smsTaskValue;
	}

	
	@SuppressWarnings("unchecked")
	public int getQBOSmsTaskAndTemplateCount(String role, String provCode, String title, String context,
			String status ,String smsTemStatus,String sendType) throws Exception {
		
		StringBuffer condition = new StringBuffer();
		Map parameter = new HashMap();
		if (!StringUtil.isBlank(role)) {
			if (!StringUtil.isBlank(provCode)) {
				if (!"0".equals(role)) {
					if ("1".equals(role)) {
						if (!"-1".equals(provCode)) {
							if ("00".equals(provCode)) {
								condition.append(
										IQBOSmsTaskAndTemplateValue.S_ProvCode)
										.append(" = :provCode and ");
								parameter.put("provCode", "00");
							}
							if ("01".equals(provCode)) {
								condition.append(
										IQBOSmsTaskAndTemplateValue.S_ProvCode)
										.append(" <> :provCode and ");
								parameter.put("provCode", "00");
							}
						}
					}
					if ("2".equals(role)) {
						condition
								.append(IQBOSmsTaskAndTemplateValue.S_ProvCode)
								.append(" = :provCode and ");
						parameter.put("provCode", provCode);
					}
				}
			} else {
				throw new Exception(
						"SmsTaskSrvImpl---getQBOSmsTaskAndTemplateCount---provCode is null !");
			}
		}else {
			throw new Exception("SmsTaskSrvImpl---getQBOSmsTaskAndTemplateCount---role is null !");
		}
		if (!StringUtil.isBlank(title)) {
			condition.append(IQBOSmsTaskAndTemplateValue.S_Title).append(
					" like :title and ");
			parameter.put("title", "%"+title+"%");
		}
		if (!StringUtil.isBlank(context)) {
			condition.append(IQBOSmsTaskAndTemplateValue.S_Content).append(
					" like :context and ");
			parameter.put("context", "%"+context+"%");
		}
		if (!StringUtil.isBlank(status)&&!SmsConstant.SMSTASK_STATUS_ALL.equals(status)) {
			condition.append(IQBOSmsTaskAndTemplateValue.S_Status).append(
					" = :status and ");
			parameter.put("status", status);
		}
		if (!StringUtil.isBlank(smsTemStatus)) {
			if(SmsConstant.SMS_STATUS_ALL.equals(smsTemStatus)){
				condition.append(IQBOSmsTaskAndTemplateValue.S_TemplateStatus).append( " in ('04','07','08') and ");
				parameter.put("smsTemStatus", smsTemStatus);
			}else{
				condition.append(IQBOSmsTaskAndTemplateValue.S_TemplateStatus).append( " = :smsTemStatus and ");
				parameter.put("smsTemStatus", smsTemStatus);
			}
			
		}
		//发送类型
		if(!StringUtil.isBlank(sendType) && !SmsConstant.SMS_SEND_TYPE_ALL.equals(sendType)){
			condition.append(IQBOSmsTaskAndTemplateValue.S_SendType).append("=:").append(IQBOSmsTaskAndTemplateValue.S_SendType).append(" AND ");
			parameter.put(IQBOSmsTaskAndTemplateValue.S_SendType, sendType);
		}
		condition.append("1=1");
		return smsTaskDAO.getQBOSmsTaskAndTemplateCount(condition.toString(),parameter);
	}

	@SuppressWarnings("unchecked")
	public IQBOSmsTaskAndTemplateValue[] getQBOSmsTaskAndTemplateValues(String role, String provCode, 
			String title, String context, String status, String smsTemStatus,String sendType, int startIndex,
			int endIndex) throws Exception {

		log.info("----------------SmsTaskSrvImpl-----------------getQBOSmsTaskAndTemplateValues-----------role:"+role+",provCode:"+provCode);
		StringBuffer condition = new StringBuffer();
		Map parameter = new HashMap();
		if (!StringUtil.isBlank(role)) {
			if (!StringUtil.isBlank(provCode)) {
				if (!"0".equals(role)) {
					if ("1".equals(role)) {
						if (!"-1".equals(provCode)) {
							if ("00".equals(provCode)) {
								condition.append(
										IQBOSmsTaskAndTemplateValue.S_ProvCode)
										.append(" = :provCode and ");
								parameter.put("provCode", "00");
							}
							if ("01".equals(provCode)) {
								condition.append(
										IQBOSmsTaskAndTemplateValue.S_ProvCode)
										.append(" <> :provCode and ");
								parameter.put("provCode", "00");
							}
						}
					}
					if ("2".equals(role)) {
						condition
								.append(IQBOSmsTaskAndTemplateValue.S_ProvCode)
								.append(" = :provCode and ");
						parameter.put("provCode", provCode);
					}
				}
			} else {
				throw new Exception("SmsTaskSrvImpl---getQBOSmsTaskAndTemplateCount---provCode is null !");
			}
		}else {
			throw new Exception("SmsTaskSrvImpl---getQBOSmsTaskAndTemplateValues---role is null !");
		}
		if (!StringUtil.isBlank(title)) {
			condition.append(IQBOSmsTaskAndTemplateValue.S_Title).append(" like :title and ");
			parameter.put("title", "%"+title+"%");
		}
		if (!StringUtil.isBlank(context)) {
			condition.append(IQBOSmsTaskAndTemplateValue.S_Content).append(" like :context and ");
			parameter.put("context", "%"+context+"%");
		}
		if (!StringUtil.isBlank(status)&&!SmsConstant.SMSTASK_STATUS_ALL.equals(status)) {
			condition.append(IQBOSmsTaskAndTemplateValue.S_Status).append( " = :status and ");
			parameter.put("status", status);
		}
		
		if (!StringUtil.isBlank(smsTemStatus)) {
			if(SmsConstant.SMS_STATUS_ALL.equals(smsTemStatus)){
				condition.append(IQBOSmsTaskAndTemplateValue.S_TemplateStatus).append( " in ('04','07','08') and ");
				parameter.put("smsTemStatus", smsTemStatus);
			}else{
				condition.append(IQBOSmsTaskAndTemplateValue.S_TemplateStatus).append( " = :smsTemStatus and ");
				parameter.put("smsTemStatus", smsTemStatus);
			}
			
		}
		//发送类型
		if(!StringUtil.isBlank(sendType) && !SmsConstant.SMS_SEND_TYPE_ALL.equals(sendType)){
			condition.append(IQBOSmsTaskAndTemplateValue.S_SendType).append("=:").append(IQBOSmsTaskAndTemplateValue.S_SendType).append(" AND ");
			parameter.put(IQBOSmsTaskAndTemplateValue.S_SendType, sendType);
		}
		condition.append("1=1 order by second_time desc");

		IQBOSmsTaskAndTemplateValue[] qValues = smsTaskDAO.getQBOSmsTaskAndTemplateValues(condition.toString(),
						parameter, startIndex, endIndex);
		for (int i = 0; i < qValues.length; i++) {
			if("00".equals(qValues[i].getProvCode())){
				qValues[i].setProvCode(qValues[i].getOpera());
			}
			//查询结果集中,如果发送类型为按已订阅用户发送的把号源数设为0
			if(!StringUtil.isBlank(qValues[i].getSendType()) && qValues[i].getSendType().equals(SmsConstant.SMS_SEND_TYPE_ORDER)){
				qValues[i].setNoCount(0);
			}
		}
		if("0".equals(role)){
			return fillHTMLOperationField(qValues);
		}else{
			return fillHTMLOperationField1(qValues);
		}
	}



	
	private FtpUtil getHpFtp(){
			FtpUtil ftpUtil = new FtpUtil();
	        Object obj = CommnPara.get(InterConstant.HP_INTER_SMSFTP_HOST_ADDR);
	        if (null != obj){
	        	ftpUtil.setFtpHost(obj.toString());
	        	log.info("HpFtp's hostAddr "+obj.toString());
	        }
	            
	        obj = CommnPara.get(InterConstant.HP_INTER_SMSFTP_USER_NAME);
	        if (null != obj){
	        	ftpUtil.setFtpUser(obj.toString());
	 	        log.info("HpFtp's userName is "+obj.toString());
	        }
	        obj = CommnPara.get(InterConstant.HP_INTER_SMSFTP_USER_PASSWD);
	        if (null != obj){
	            ftpUtil.setFtpPasswd(obj.toString());
	            log.info("HpFtp's passWord is "+obj.toString());
	        }
	        obj = CommnPara.get(InterConstant.HP_INTER_SMSFTP_RETRY_COUNT);
	        if (null != obj){
	        	ftpUtil.setFtpRetryCount(Integer.parseInt(obj.toString()));
	        }
	        return ftpUtil;
	}
	
	
	/**
	 * 给QBOSmsTaskAndTemplateValue填充操作列的超链接
	 * 
	 * @param qValues
	 * @return
	 */
	private IQBOSmsTaskAndTemplateValue[] fillHTMLOperationField(
			IQBOSmsTaskAndTemplateValue[] qValues) {
		
		if (null != qValues && qValues.length > 0) {
			for (int i = 0; i < qValues.length; i++) {
				StringBuffer sb = new StringBuffer();
				if (SmsConstant.SMSTASK_STATUS_NOEXCUT.equals(qValues[i]
						.getStatus())) {
					if (null == qValues[i].getQuartzTime()
							|| StringUtil.isBlank(qValues[i].getQuartzTime()
									.toString())) {
						sb.append(String.format(SmsConstant.SMS_INFO_SEND, qValues[i].getSmsId()));
					} else {
						sb.append(String.format(SmsConstant.SMS_INFO_MODIFY, qValues[i].getSmsId()));
					}
				} else {
					sb.append(String.format(SmsConstant.SMS_INFO_TASK_DETAIL, qValues[i].getTaskId()));
				}
				sb.append(String.format(SmsConstant.SMS_INFO_TEMPLATE_DETAIL, qValues[i].getSmsId()));
				qValues[i].setOpera(sb.toString());
			}
		}
		return qValues;
	}
	
	/**
	 * 给QBOSmsTaskAndTemplateValue填充操作列的超链接
	 * 
	 * @param qValues
	 * @return
	 */
	private IQBOSmsTaskAndTemplateValue[] fillHTMLOperationField1(
			IQBOSmsTaskAndTemplateValue[] qValues) {
		
		if (null != qValues && qValues.length > 0) {
			for (int i = 0; i < qValues.length; i++) {
				StringBuffer sb = new StringBuffer();
				if (!SmsConstant.SMSTASK_STATUS_NOEXCUT.equals(qValues[i]
						.getStatus())) {
					sb.append(String.format(SmsConstant.SMS_INFO_TASK_DETAIL, qValues[i].getTaskId()));
				}
				sb.append(String.format(SmsConstant.SMS_INFO_TEMPLATE_DETAIL, qValues[i].getSmsId()));
				qValues[i].setOpera(sb.toString());
			}
		}
		return qValues;
	}
	
	
	/**
	 * 下载AI侧Ftp上号源文件，并传到HP侧Ftp
	 * 
	 * @param smsTemplateValue
	 * @throws Exception
	 */
	private void downloadAndUploadFile(ISmsTemplateValue smsTemplateValue) throws Exception{
		//获得短信任务的号源文件
		String fileName = smsTemplateValue.getFilePath();
		log.info("fileName---->"+fileName);
		//设置FTP 服务器的路径
		String localPath = InterPara.get(InterConstant.AI_SMSFILE_LOCAL);
		String remotePathHp = InterPara.get(InterConstant.HP_SMSFILE_REMOTE);
		String remotePathAi = InterPara.get(InterConstant.AI_SMSFILE_REMOTE);
	    //从AI FTP 下载号源文件
	    int downLoadNum =AiFtpUtil.download(localPath,remotePathAi,null,fileName);
	    log.info("downLoadNum---->"+downLoadNum);
	    if(downLoadNum<=0){
	    	log.info("download file fail");
	    	throw new Exception("download file fail");
	    }
    	FtpUtil hpFtp=getHpFtp();
    	//上传到HpFTP 服务器
    	int uploadNum=hpFtp.upload(localPath+fileName, remotePathHp+fileName);
    	log.info("uploadNum---->"+uploadNum);
    	if(downLoadNum!=uploadNum){
    		log.info("upload file fail");
    		throw new Exception("upload file fail");
    	}
	}
	
	/**
	 * 更新任务状态为已执行
	 * 
	 * @param sms_id
	 * @throws Exception
	 */
	private void updateSmsTaskValue(String sms_id,String status) throws Exception{
		StringBuffer condition = new StringBuffer();
		Map<String, String> parameter = new HashMap<String, String>();
		if(!StringUtil.isBlank(sms_id)){
			condition.append(ISmsTaskValue.S_SmsId).append(" = :").append(ISmsTaskValue.S_SmsId).append(" and ");
			parameter.put(ISmsTaskValue.S_SmsId,sms_id);
		}
		condition.append("1=1");
		
		ISmsTaskValue smsTask=smsTaskDAO.getSmsTask(condition.toString(), parameter)[0];
		//更新任务状态
		//smsTask.setStatus(SmsConstant.SMS_TASK_STATUS_ING);
		smsTask.setStatus(status);
		smsTaskDAO.saveSmsTask(smsTask);
	}
	
	/**
	 * 调用惠普短信推广文件到达通知接口
	 * 
	 * @param sms_id
	 * @param smsTemplateValue
	 * @throws Exception
	 */
	private void sendSmsPromotionNoticeToHp(String sms_id,ISmsTemplateValue smsTemplateValue) throws Exception{
		//发送报文
		SmsPromotionNoticeInBizRegReq in = SmsPromotionNoticeInter
		.getSmsPromotionNoticeInBizRegReq();
		SmsPromotionNoticeInFileList sFileList = in.addNewFileList();
		sFileList.setSpreadID(Long.toString(smsTemplateValue.getSmsId()));
		sFileList.setSpreadTitile(smsTemplateValue.getTitle());
		if("00".equals(smsTemplateValue.getProvCode())){
			sFileList.setUserRole(SmsPromotionNoticeInFileList.UserRole.X_08);
			sFileList.setUserID(smsTemplateValue.getOperat());
		}else {
			sFileList.setUserRole(SmsPromotionNoticeInFileList.UserRole.X_05);
			sFileList.setUserID(ProvinceUtil.toHpProvince(smsTemplateValue.getProvCode()));
		}
		sFileList.setMessage(smsTemplateValue.getContent());
		sFileList.setFileName(smsTemplateValue.getFilePath());
		sFileList.setSendDate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
		in.setFileList(sFileList);
		SmsPromotionNoticeOutBizRegReq out = SmsPromotionNoticeInter.doBusi(in);
		log.info("out RejectReason---->"+out.getRejectReason());
		if(SmsConstant.SMS_REASON_SUCESS.equals(out.getRejectReason())){
				//报文发送成功
			if(!sms_id.equals(out.getResultList().getSpreadID())){
				throw new Exception("惠普返回报文错误");
			}
			//updateSmsTaskValue(sms_id,SmsConstant.SMS_TASK_STATUS_ING);
		} else {
			// 发送失败反馈
			log.info("SmsPromotionNoticeOutBizRegReq is fail");
			if (SmsConstant.SMS_REASON_1000.equals(out
					.getRejectReason()))
				throw new MgtSmsException("输入报文格式错误");
			if (SmsConstant.SMS_REASON_9001.equals(out
					.getRejectReason()))
				throw new MgtSmsException("网络忙，请稍后再试");
			if (SmsConstant.SMS_REASON_9999.equals(out
					.getRejectReason()))
				throw new MgtSmsException("系统忙，请稍后再试");
			throw new Exception();
		}
	}
	
	/**
	 * 调用惠普短信推广文件处理结果查询接口
	 * 
	 * @param smsTaskValue
	 * @return
	 * @throws Exception
	 */
	private ISmsTaskValue sendSmsPromotionResultToHp(ISmsTaskValue smsTaskValue) throws Exception{
		//发送报文
		SmsPromotionResultInBizRegReq in = SmsPromotionResultInter
				.getSmsPromotionResultInBizRegReq();
		in.setSpreadID(String.valueOf(smsTaskValue.getSmsId()));
		if("00".equals(smsTaskValue.getProvCode())){
			in.setUserRole(SmsPromotionResultInBizRegReq.UserRole.X_08);
			in.setUserID(smsTaskValue.getOpera());
		}else{
			in.setUserRole(SmsPromotionResultInBizRegReq.UserRole.X_05);
			in.setUserID(ProvinceUtil.toHpProvince(smsTaskValue.getProvCode()));
		}
		SmsPromotionResultOutBizRegReq out = SmsPromotionResultInter.doBusi(in);
		//更新任务
		if (SmsConstant.SMS_REASON_SUCESS.equals(out.getRejectReason())) {
			if(!String.valueOf(smsTaskValue.getSmsId()).equals(out.getResultList().getSpreadID())){
				throw new Exception("惠普返回报文错误");
			}
			smsTaskValue.setNosendCount(out.getResultList().getWaitSendCount());
			smsTaskValue.setSuccCount(out.getResultList().getSuccessCount());
			smsTaskValue.setFailCount(out.getResultList().getFailCount());
			smsTaskValue.setErrorCount(out.getResultList().getWrongNumberCount());
			smsTaskValue.setDupliCount(out.getResultList().getDupliCount());
			smsTaskValue.setBakCol2(out.getResultList().getNoWhiteListCount()+"");
		} else {
			log.info("updateSmsTask fail");
			if (SmsConstant.SMS_REASON_1000.equals(out.getRejectReason()))
				throw new MgtSmsException("输入报文格式错误");
			if (SmsConstant.SMS_REASON_9001.equals(out.getRejectReason()))
				throw new MgtSmsException("网络忙，请稍后再试");
			if (SmsConstant.SMS_REASON_9999.equals(out.getRejectReason()))
				throw new MgtSmsException("系统忙，请稍后再试");
			if (SmsConstant.SMS_REASON_K101.equals(out
					.getRejectReason()))
				throw new MgtSmsException("查询记录不存在");
			throw new Exception("惠普返回报文错误");
		}
		return smsTaskValue;
	}
	
	/**
	 * 设置SmsTask中操作列的值
	 * 
	 * @param smsTaskValue
	 * @return
	 * @throws Exception
	 */
	private ISmsTaskValue setSmsTaskOperat(ISmsTaskValue smsTaskValue)
			throws Exception {

		StringBuffer sb = new StringBuffer();

		String failFilePath = "\"" + smsTaskValue.getFailFilePath() + "\"";
		String errorFilePath = "\"" + smsTaskValue.getErrorFilePath() + "\"";
		String dupliFilePath = "\"" + smsTaskValue.getDupliFilePath() + "\"";
		String noWhiteListFilePath = "\"" + smsTaskValue.getBakCol3() + "\"";

		sb.append(String.format(SmsConstant.SMS_FAILHREF,
				SmsConstant.SMS_DOWNLOAD_SCUESS, failFilePath));
		sb.append(String.format(SmsConstant.SMS_EERORHREF,
				SmsConstant.SMS_DOWNLOAD_SCUESS, errorFilePath));
		sb.append(String.format(SmsConstant.SMS_DUPLIHREF,
				SmsConstant.SMS_DOWNLOAD_SCUESS, dupliFilePath));
		sb.append(String.format(SmsConstant.SMS_NOWHITEHREF,
				SmsConstant.SMS_DOWNLOAD_SCUESS, noWhiteListFilePath));
		
		
		smsTaskValue.setOpera(sb.toString());
		return smsTaskValue;

	}


	/**
	 *  更新短信模板状态
	 * 
	 * @param sms_id
	 * @param status
	 * @throws Exception
	 */
	private void updateSmsTemplateValue(String sms_id, String status) throws Exception {
		ISmsTemplateValue value = smsTemplateDAO.getSmsTemplateById(sms_id);
		value.setStatus(status);
		smsTemplateDAO.saveSmsTemplate(value);
	}

	/**
	 * 插入流水表
	 * 
	 * @param sms_id
	 * @param operatId
	 * @param sendTime
	 * @param sms_status_sending
	 * @throws Exception 
	 */
	private void insertBusiSmsAudit(String sms_id, String operatId, String sendTime,
			String status) throws Exception {
		IBusiSmsAuditValue value = new BusiSmsAuditBean();
		value.setSmsId(Long.parseLong(sms_id));
		value.setOptId(operatId);
		value.setStatus(status);
		value.setAuditTime(DateTimeUtil.stringToTimestamp(sendTime,SmsConstant.SMS_DATE_FORMAT_LONG));
		log.info(value.getSmsId());
		log.info(value.getOptId());
		log.info(value.getAuditTime());
		busiSmsDAO.saveBusiSmsValue(value);
	}
	
	/**
	 * 调用 白名单短信推广通知接口
	 * 
	 * @param sms_id
	 * @param smsTemplateValue
	 * @throws Exception
	 */
	private void sendSmsPromotionByWhiteListNoticeToHp(String sms_id,ISmsTemplateValue smsTemplateValue) throws Exception{
		//发送报文
		SmsPromotionNoticeByWhiteListInBizRegReq in = SmsPromotionNoticeByWhiteListInter.getSmsPromotionNoticeByWhiteListInBizRegReq();
		in.setSpreadID(Long.toString(smsTemplateValue.getSmsId()));
		in.setSpreadTitile(smsTemplateValue.getTitle());
		if("00".equals(smsTemplateValue.getProvCode())){
			in.setUserRole(SmsPromotionNoticeByWhiteListInBizRegReq.UserRole.X_08);
			in.setUserID(smsTemplateValue.getOperat());
		}else {
			in.setUserRole(SmsPromotionNoticeByWhiteListInBizRegReq.UserRole.X_05);
			in.setUserID(ProvinceUtil.toHpProvince(smsTemplateValue.getProvCode()));
		}
		in.setMessage(smsTemplateValue.getContent());
		in.setSendDate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
		SmsPromotionNoticeByWhiteListOutBizRegReq out = SmsPromotionNoticeByWhiteListInter.doBusi(in);
		log.info("out RejectReason---->"+out.getRejectReason());
		if(SmsConstant.SMS_REASON_SUCESS.equals(out.getRejectReason())){
				//报文发送成功
			if(!sms_id.equals(out.getResultList().getSpreadID())){
				throw new Exception("惠普返回报文错误");
			}
			//updateSmsTaskValue(sms_id,SmsConstant.SMS_TASK_STATUS_ING);
		} else {
			// 发送失败反馈
			log.info("SmsPromotionNoticeByWhiteListOutBizRegReq is fail");
			if (SmsConstant.SMS_REASON_1000.equals(out
					.getRejectReason()))
				throw new MgtSmsException("输入报文格式错误");
			if (SmsConstant.SMS_REASON_9001.equals(out
					.getRejectReason()))
				throw new MgtSmsException("网络忙，请稍后再试");
			if (SmsConstant.SMS_REASON_9999.equals(out
					.getRejectReason()))
				throw new MgtSmsException("系统忙，请稍后再试");
			throw new Exception();
		}
	}
}
