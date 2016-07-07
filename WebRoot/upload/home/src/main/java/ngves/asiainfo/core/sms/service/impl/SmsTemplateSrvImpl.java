package ngves.asiainfo.core.sms.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.common.service.interfaces.ISysBusiLockInfoSrv;
import ngves.asiainfo.core.rushbuy.dao.impl.RushWareDetailDAOImpl;
import ngves.asiainfo.core.sms.SmsConstant;
import ngves.asiainfo.core.sms.bo.BusiSmsAuditBean;
import ngves.asiainfo.core.sms.bo.BusiSmsAuditEngine;
import ngves.asiainfo.core.sms.bo.BusiSmsTemplateBean;
import ngves.asiainfo.core.sms.bo.SmsTaskBean;
import ngves.asiainfo.core.sms.bo.SmsTemplateBean;
import ngves.asiainfo.core.sms.bo.SmsTemplateEngine;
import ngves.asiainfo.core.sms.dao.interfaces.IBusiSmsDAO;
import ngves.asiainfo.core.sms.dao.interfaces.IBusiSmsTemplateDAO;
import ngves.asiainfo.core.sms.dao.interfaces.ISmsTaskDAO;
import ngves.asiainfo.core.sms.dao.interfaces.ISmsTemplateDAO;
import ngves.asiainfo.core.sms.ivalues.IBusiSmsAuditValue;
import ngves.asiainfo.core.sms.ivalues.IBusiSmsTemplateValue;
import ngves.asiainfo.core.sms.ivalues.ISmsTaskValue;
import ngves.asiainfo.core.sms.ivalues.ISmsTemplateValue;
import ngves.asiainfo.core.sms.service.interfaces.ISmsTemplateSrv;

import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.secframe.bo.orgmodel.SysStaffEngine;
import com.ai.secframe.ivalues.orgmodel.ISysStaffValue;

@SuppressWarnings("unchecked")
public class SmsTemplateSrvImpl implements ISmsTemplateSrv {

	private static Log logger = LogFactory.getLog(RushWareDetailDAOImpl.class);

	public ISmsTemplateDAO smsTemplateDAO;
	public ISmsTaskDAO smsTaskDAO;
	public IBusiSmsDAO busiSmsDAO;
	public IBusiSmsTemplateDAO busiSmsTemplateDAO;
	
	public void setBusiSmsTemplateDAO(IBusiSmsTemplateDAO busiSmsTemplateDAO) {
		this.busiSmsTemplateDAO = busiSmsTemplateDAO;
	}
	public void setSmsTemplateDAO(ISmsTemplateDAO smsTemplateDAO) {
		this.smsTemplateDAO = smsTemplateDAO;
	}
	public void setSmsTaskDAO(ISmsTaskDAO smsTaskDAO) {
		this.smsTaskDAO = smsTaskDAO;
	}
	public void setBusiSmsDAO(IBusiSmsDAO busiSmsDAO) {
		this.busiSmsDAO = busiSmsDAO;
	}
	public int countMarketingSmsList(String smsTemplateTitle,
			String smsTemplateContent, String smsStatus,String sendType,String proCode) throws Exception {
		logger.info("the smsTemplateTitle is " + smsTemplateTitle
				+ ",the smsTemplateContent is" + smsTemplateContent
				+ ",  the smsStatus is" + smsStatus + ",  the sendType is"
				+ sendType + ", proCode is " + proCode);
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map parameter = new HashMap();
		// 模板标题
		if (!StringUtil.isBlank(smsTemplateTitle)) {
			condition.append(" AND ").append(ISmsTemplateValue.S_Title).append(" like :").append(ISmsTemplateValue.S_Title);
			parameter.put(ISmsTemplateValue.S_Title, "%"+smsTemplateTitle.trim()+"%");
		}
		// 模板内容
		if (!StringUtil.isBlank(smsTemplateContent)) {
			condition.append(" AND ").append(ISmsTemplateValue.S_Content).append(" like :").append(ISmsTemplateValue.S_Content);
			parameter.put(ISmsTemplateValue.S_Content, "%"+smsTemplateContent.trim()+"%");
		}
		//短信状态
		if (!SmsConstant.SMS_STATUS_ALL.equals(smsStatus)) {
			condition.append(" AND ").append(ISmsTemplateValue.S_Status).append("=:").append(ISmsTemplateValue.S_Status);
			parameter.put(ISmsTemplateValue.S_Status, smsStatus);
		}
		//发送类型
		if(!StringUtil.isBlank(sendType) && !SmsConstant.SMS_SEND_TYPE_ALL.equals(sendType)){
			condition.append(" AND ").append(ISmsTemplateValue.S_SendType).append("=:").append(ISmsTemplateValue.S_SendType);
			parameter.put(ISmsTemplateValue.S_SendType, sendType);
		}
		//省代码
		if (!StringUtil.isBlank(proCode)) {
			condition.append(" AND ").append(ISmsTemplateValue.S_ProvCode).append("=:").append(ISmsTemplateValue.S_ProvCode);
			parameter.put(ISmsTemplateValue.S_ProvCode, proCode);
		}
		int num = smsTemplateDAO.getSmsTemplatesCount(condition.toString(), parameter);
		return num;
	}

	public ISmsTemplateValue[] queryMarketingSmsList(String smsTemplateTitle,
			String smsTemplateContent, String smsStatus,String sendType,String proCode, int startIndex,
			int endIndex) throws Exception {
		logger.info("the smsTemplateTitle is " + smsTemplateTitle
				+ ",the smsTemplateContent is" + smsTemplateContent
				+ ",  the smsStatus is" + smsStatus + ",  the sendType is"
				+ sendType + ", proCode is " + proCode);
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map parameter = new HashMap();
		// 模板标题
		if (!StringUtil.isBlank(smsTemplateTitle)) {
			condition.append(" AND ").append(ISmsTemplateValue.S_Title).append(" like :").append(ISmsTemplateValue.S_Title);
			parameter.put(ISmsTemplateValue.S_Title, "%"+smsTemplateTitle.trim()+"%");
		}
		// 模板内容
		if (!StringUtil.isBlank(smsTemplateContent)) {
			condition.append(" AND ").append(ISmsTemplateValue.S_Content).append(" like :").append(ISmsTemplateValue.S_Content);
			parameter.put(ISmsTemplateValue.S_Content, "%"+smsTemplateContent.trim()+"%");
		}
		//短信状态
		if (!SmsConstant.SMS_STATUS_ALL.equals(smsStatus)) {
			condition.append(" AND ").append(ISmsTemplateValue.S_Status).append("=:").append(ISmsTemplateValue.S_Status);
			parameter.put(ISmsTemplateValue.S_Status, smsStatus);
		}
		//发送类型
		if(!StringUtil.isBlank(sendType) && !SmsConstant.SMS_SEND_TYPE_ALL.equals(sendType)){
			condition.append(" AND ").append(ISmsTemplateValue.S_SendType).append("=:").append(ISmsTemplateValue.S_SendType);
			parameter.put(ISmsTemplateValue.S_SendType, sendType);
		}
		//省代码
		if (!StringUtil.isBlank(proCode)) {
			condition.append(" AND ").append(ISmsTemplateValue.S_ProvCode).append("=:").append(ISmsTemplateValue.S_ProvCode);
			parameter.put(ISmsTemplateValue.S_ProvCode, proCode);
		}
		// 增加排序选项，按照创建时间倒序排序
		condition.append(" order by create_time desc ");
		ISmsTemplateValue[] values = smsTemplateDAO.getSmsTemplates(condition.toString(), parameter, startIndex, endIndex);
		values = changeNoCountbySendType(values);
		return fillHTMLOperationField(values);

	}
	
	/**查询结果集中,如果发送类型为按已订阅用户发送的把号源数设为0
	 * @param values
	 * @return
	 */
	private ISmsTemplateValue[] changeNoCountbySendType(ISmsTemplateValue[] values) {
		if(values !=null && values.length>0){
			for(ISmsTemplateValue value : values){
				if(!StringUtil.isBlank(value.getSendType()) && value.getSendType().equals(SmsConstant.SMS_SEND_TYPE_ORDER)){
					value.setNoCount(0);
				}
			}
		}
		return values;
	}


	/**
	 * 填充操作区域的html代码
	 * 
	 * @param values
	 * @return
	 * @throws Exception 
	 */
	private ISmsTemplateValue[] fillHTMLOperationField(ISmsTemplateValue[] values) throws Exception {
		for (ISmsTemplateValue v : values) {

			if (v.getStatus().equals(SmsConstant.SMS_STATUS_DRAFT)||v.getStatus().equals(SmsConstant.SMS_STATUS_NOTFIRSTVERIFY)||v.getStatus().equals(SmsConstant.SMS_STATUS_NOTSECONDVERIFY)) {
				v.setOperat("<a href=\"#\" onclick=\"javascript:indexControl('SEEMORE','" + v.getSmsId()
						+ "')\">查看详情</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"#\" onclick=\"javascript:indexControl('EDIT','" + v.getSmsId()
						+ "')\">修改</a>");	

				//v.setOperat(String.format(SmsConstant.SMS_EDIT, v.getSmsId())+"&nbsp;&nbsp;&nbsp;&nbsp;"+String.format(SmsConstant.SMS_INFO, v.getSmsId()));	

			}else if(v.getStatus().equals(SmsConstant.SMS_STATUS_SECONDVERIFY)){
				//	v.setOperat(String.format(SmsConstant.SMS_INFO, v.getSmsId())+"&nbsp;&nbsp;&nbsp;&nbsp;"+String.format(SmsConstant.SMS_BACK, v.getSmsId()));	
				//v.setOperat("<a href=\"#\" onclick=\"javascript:indexControl('SEEMORE','" + v.getSmsId()
				//		+ "')\">查看详情</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"#\" onclick=\"javascript:indexControl('BACK','" + v.getSmsId()
				//		+ "')\">撤回</a>");	
				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append("<a href=\"#\" onclick=\"javascript:indexControl('SEEMORE','" + v.getSmsId()+ "')\">查看详情</a>");
				ISmsTaskValue smsTask = getSmsTackBySmsId(String.valueOf(v.getSmsId()));//这里会抛异常
				if (smsTask != null && smsTask.getStatus().equals(SmsConstant.SMSTASK_STATUS_NOEXCUT)) {//短信任务存在并且任务状态为未执行
					v.setOperat("<a href=\"#\" onclick=\"javascript:indexControl('SEEMORE','" + v.getSmsId()
									+ "')\">查看详情</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"#\" onclick=\"javascript:indexControl('BACK','" + v.getSmsId()
									+ "')\">撤回</a>");	
				}else{
					v.setOperat("<a href=\"#\" onclick=\"javascript:indexControl('SEEMORE','" + v.getSmsId()+ "')\">查看详情</a>");
				}
				
			}else if(v.getStatus().equals(SmsConstant.SMS_STATUS_NOTVERIFY)||v.getStatus().equals(SmsConstant.SMS_STATUS_FIRSTVERIFY)||v.getStatus().equals(SmsConstant.SMS_STATUS_END)||v.getStatus().equals(SmsConstant.SMS_STATUS_SENDED)||v.getStatus().equals(SmsConstant.SMS_STATUS_SENDING)){
				//v.setOperat(String.format(SmsConstant.SMS_INFO, v.getSmsId()));		
				v.setOperat("<a href=\"#\" onclick=\"javascript:indexControl('SEEMORE','" + v.getSmsId()
						+ "')\">查看详情</a>" );	
			}
		}
		return values;
	}
	
	public ISmsTemplateValue queryMarketingSmsListById(String smsId) throws Exception {
		return	smsTemplateDAO.getSmsTemplateById(smsId);		
	}

	public ISmsTemplateValue getISmsTemplateValueById(String id) throws Exception {

		return this.smsTemplateDAO.getSmsTemplateById(id);
	}

	public void updateISmsTemplateValue(ISmsTemplateValue smsTemplateValue) throws Exception {
		this.smsTemplateDAO.saveSmsTemplate(smsTemplateValue);
	}

	public ISmsTemplateValue[] queryMarketingSmsListOfReview(String smsTemplateTitle, String smsTemplateContent,
			String smsStatus,String sendType ,int startIndex, int endIndex) throws Exception {
		StringBuffer condition = new StringBuffer(" 1 = 1 ");

		Map parameter = new HashMap();
		// 模板标题
		if (!StringUtil.isBlank(smsTemplateTitle)) {
			condition.append(" AND ").append(ISmsTemplateValue.S_Title).append(" like :").append(
					ISmsTemplateValue.S_Title);
			parameter.put(ISmsTemplateValue.S_Title, "%" + smsTemplateTitle.trim() + "%");
		}
		// 模板内容
		if (!StringUtil.isBlank(smsTemplateContent)) {
			condition.append(" AND ").append(ISmsTemplateValue.S_Content).append(" like :").append(
					ISmsTemplateValue.S_Content);
			parameter.put(ISmsTemplateValue.S_Content, "%" + smsTemplateContent.trim() + "%");
		}
		//短信状态
		if ( SmsConstant.SMSTASK_REVIEW_STATUS_ALL.equals(smsStatus)) {//全部
			condition.append(" AND ").append(ISmsTemplateValue.S_Status).append(" in ( " + SmsConstant.SMSTASK_REVIEW_STATUS_ALL + " )");
		}else{
			condition.append(" AND ").append(ISmsTemplateValue.S_Status).append(" in ( " + smsStatus + " )");
		}
		//发送类型
		if(!StringUtil.isBlank(sendType) && !SmsConstant.SMS_SEND_TYPE_ALL.equals(sendType)){
			condition.append(" AND ").append(ISmsTemplateValue.S_SendType).append("=:").append(ISmsTemplateValue.S_SendType);
			parameter.put(ISmsTemplateValue.S_SendType, sendType);
		}
		// 增加排序选项，按照初审时间倒序排序
		condition.append(" order by FIRST_TIME desc, SECOND_TIME desc ");
		ISmsTemplateValue[] smsTemplateValues = smsTemplateDAO.getSmsTemplates(condition.toString(), parameter,
				startIndex, endIndex);
		//数据转化
		smsTemplateValues = changeNoCountbySendType(smsTemplateValues);
		return fillHTMLOperationFieldOfReview(smsTemplateValues);
	}

	/**
	 * 复审列表功能的页面显示操作填充
	 * 
	 * @param smsTemplateValues
	 *            需要填充的短信模版集合
	 * @return
	 * @throws Exception
	 */
	public ISmsTemplateValue[] fillHTMLOperationFieldOfReview(ISmsTemplateValue[] smsTemplateValues) throws Exception {
		for (ISmsTemplateValue smsTemplateValue : smsTemplateValues) {
			StringBuffer stringBuffer = new StringBuffer(); // 要拼接的操作字符串
			if (SmsConstant.SMS_STATUS_FIRSTVERIFY.equals(smsTemplateValue.getStatus())) { // 已通过初审  //拼接  审核  、查看详情   
				                                                                           //案例参考:NavigationInfoSrvImpl
				stringBuffer.append(String.format(SmsConstant.SMS_INFO_AUDIT, smsTemplateValue.getSmsId()))
						.append("  ").append(String.format(SmsConstant.SMS_INFO, smsTemplateValue.getSmsId()));
			} else if (SmsConstant.SMS_STATUS_SECONDVERIFY.equals(smsTemplateValue.getStatus())) { // 已复审  //拼接  查看详情   驳回   终止
				stringBuffer.append("&nbsp;&nbsp;&nbsp;&nbsp;").append(String.format(SmsConstant.SMS_INFO, smsTemplateValue.getSmsId()));
				// 在任务未执行的情况下，显示驳回和终止 所以先得到根据smsId得到任务 在得到任务状态
				ISmsTaskValue smsTask = getSmsTackBySmsId(String.valueOf(smsTemplateValue.getSmsId()));
				if (smsTask != null && SmsConstant.SMSTASK_STATUS_NOEXCUT.equals(smsTask.getStatus())) {
					stringBuffer.append("  ").append(
							String.format(SmsConstant.SMS_INFO_REJECTED, smsTemplateValue.getSmsId())).append("  ")
							.append(String.format(SmsConstant.SMS_INFO_STOP, smsTemplateValue.getSmsId()));
				}
			} else if (SmsConstant.SMS_STATUS_END.equals(smsTemplateValue.getStatus())) {// 终止
				stringBuffer.append("&nbsp;&nbsp;&nbsp;&nbsp;").append(String.format(SmsConstant.SMS_INFO, smsTemplateValue.getSmsId()));
			} else { // 其他状态
				stringBuffer = stringBuffer.append(smsTemplateValue.getStatus());
			}
			smsTemplateValue.setOperat(stringBuffer.toString());// 把拼接字符串 赋值给  操作列
		}
		return smsTemplateValues;
	}

	public void smsRejectedOrStop(String smsid, String status, String content, String operer, String date_time ,String type) throws Exception {
		
		logger.debug("SmsTemplateSrvImpl --> smsRejectedOrStop status:" + status);
		
		
		//业务锁服务
		ISysBusiLockInfoSrv busiLockInfoSrv = (ISysBusiLockInfoSrv)ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_SYS_BUSI_LOCK_SRV);
		
		boolean locked = busiLockInfoSrv.gainBusiLock(smsid+"", "10",-1);
        try {
             if(locked) {
				ISmsTemplateValue smsTemplateValue = this.smsTemplateDAO.getSmsTemplateById(String.valueOf(smsid));
				if (smsTemplateValue != null) {
					
					if(!isAllowOperate(smsTemplateValue.getStatus(),status,type)){
					    throw new Exception(SmsConstant.RET_VALUE_Exception1);
					}
					
					if(StringUtil.isBlank(date_time)){
						date_time = DateTimeUtil.dateToString(DateTimeUtil.getNowDate(), SmsConstant.SMS_DATE_FORMAT_LONG);
					}
					
					// 根据短信状态，判断是否生成或撤销短信任务
					if (SmsConstant.SMS_STATUS_SECONDVERIFY.equals(status)) {// 04为复审通过
						opSmsTemAndBusi( smsid,  status,  content,  operer,  date_time);
						addSmsTask(String.valueOf(smsid), smsTemplateValue.getNoCount(),smsTemplateValue.getProvCode(),smsTemplateValue.getOperat());
					}  
					else if ( (SmsConstant.SMS_STATUS_NOTSECONDVERIFY.equals(status) ||  //05为审核不通过或者驳回
							SmsConstant.SMS_STATUS_DRAFT.equals(status) ||  //撤回
							SmsConstant.SMS_STATUS_END.equals(status))  //终止
							&& SmsConstant.SMS_STATUS_SECONDVERIFY.equals(smsTemplateValue.getStatus()) //并且更新前状态为审核通过
							){ 
						ISmsTaskValue smsTask = getSmsTackBySmsId(String.valueOf(smsid));
						if (smsTask != null && SmsConstant.SMSTASK_STATUS_NOEXCUT.equals(smsTask.getStatus())) {
							deleteSmsTask(smsTask.getId());
							opSmsTemAndBusi( smsid,  status,  content,  operer,  date_time);
						}
						else{
							throw new Exception(SmsConstant.RET_VALUE_Exception1);
						}
					}
					else {
						opSmsTemAndBusi( smsid,  status,  content,  operer,  date_time);
					}
				}
             }
        } catch (Exception e ) {
            logger.warn("The system is busy, please try again later!", e);
			throw new Exception(SmsConstant.RET_VALUE_Exception1, e);
        } finally {
           	if (locked) {
           		busiLockInfoSrv.releaseBusiLock(smsid+"", "10");
           	}
           	logger.info("copyWareDescInfo  unlocked successfully ");
		}
	}

	/**
	 * 操作短信模版表 和 短信任务表
	 * @author Administrator 侯栖荫 2012-11-29
	 * @param smsid 短信id
	 * @param status 短信新状态
	 * @param content 短信评审内容
	 * @param operer 操作人 
	 * @param date_time 更改时间
	 * @throws Exception 
	 */
	public void opSmsTemAndBusi(String smsid, String status, String content, String operer, String date_time) throws Exception{
		ISmsTemplateValue smsTemplateValue = this.smsTemplateDAO.getSmsTemplateById(String.valueOf(smsid));
		
		// 增加流水记录
		//if(!status.equals(smsTemplateValue.getStatus())){ //状态发生变化，则在插入流水表，如起草状态再次编辑保存，(而不是提交)就不比插入流水表了
			addSmsBusi( smsid,  content ,  status , operer, date_time);
		//}
		
		// 修改短信模版表
		smsTemplateValue.setStatus(status);
		if(SmsConstant.SMS_STATUS_NOTVERIFY.equals(status)){//提交带审核时，添加审核时间
			smsTemplateValue.setSubmitTime(DateTimeUtil.stringToTimestamp(date_time, SmsConstant.SMS_DATE_FORMAT_LONG));
		}
		else if(SmsConstant.SMS_STATUS_FIRSTVERIFY.equals(status) || SmsConstant.SMS_STATUS_NOTFIRSTVERIFY.equals(status)){ //设置初审时间，不管审核通过或不通过
			smsTemplateValue.setFirstTime(DateTimeUtil.stringToTimestamp(date_time, SmsConstant.SMS_DATE_FORMAT_LONG));
		}else if(SmsConstant.SMS_STATUS_SECONDVERIFY.equals(status) || SmsConstant.SMS_STATUS_NOTSECONDVERIFY.equals(status) ){//复审时间,不管审核通过或不通过
			smsTemplateValue.setSecondTime(DateTimeUtil.stringToTimestamp(date_time, SmsConstant.SMS_DATE_FORMAT_LONG));
		}
		
		if(SmsConstant.SMS_STATUS_DRAFT.equals(status) || SmsConstant.SMS_STATUS_NOTVERIFY.equals(status)){//撤回或待审核时要清空初审和复审时间
			smsTemplateValue.setFirstTime(null);
			smsTemplateValue.setSecondTime(null);
		}
		this.smsTemplateDAO.saveSmsTemplate(smsTemplateValue);
	}
	
	public int queryFirstExaminCount(String title, String content, String status,String sendType)
			throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map parameter = new HashMap();
		// 模板标题
		if (!StringUtil.isBlank(title)) {
			condition.append(" AND ").append(ISmsTemplateValue.S_Title).append(" like :").append(ISmsTemplateValue.S_Title);
			parameter.put(ISmsTemplateValue.S_Title, "%"+title.trim()+"%");
		}
		// 模板内容
		if (!StringUtil.isBlank(content)) {
			condition.append(" AND ").append(ISmsTemplateValue.S_Content).append(" like :").append(ISmsTemplateValue.S_Content);
			parameter.put(ISmsTemplateValue.S_Content,  "%"+content.trim()+"%");
		}
		//短信状态
		if (!SmsConstant.SMS_STATUS_ALL.equals(status)) {
			condition.append(" AND ").append(ISmsTemplateValue.S_Status).append("=:").append(ISmsTemplateValue.S_Status);
			parameter.put(ISmsTemplateValue.S_Status, status);
		}
		//发送类型
		if(!StringUtil.isBlank(sendType) && !SmsConstant.SMS_SEND_TYPE_ALL.equals(sendType)){
			condition.append(" AND ").append(ISmsTemplateValue.S_SendType).append("=:").append(ISmsTemplateValue.S_SendType);
			parameter.put(ISmsTemplateValue.S_SendType, sendType);
		}
		return smsTemplateDAO.getSmsTemplatesCount(condition.toString(), parameter);
	}
	public ISmsTemplateValue[] queryFirstExaminList(String title,
			String content, String status,String sendType ,int startIndex, int endIndex)
			throws Exception {
		
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map parameter = new HashMap();
		// 模板标题
		if (!StringUtil.isBlank(title)) {
			condition.append(" AND ").append(ISmsTemplateValue.S_Title).append(" like :").append(ISmsTemplateValue.S_Title);
			parameter.put(ISmsTemplateValue.S_Title, "%"+title.trim()+"%");
		}
		// 模板内容
		if (!StringUtil.isBlank(content)) {
			condition.append(" AND ").append(ISmsTemplateValue.S_Content).append(" like :").append(ISmsTemplateValue.S_Content);
			parameter.put(ISmsTemplateValue.S_Content,  "%"+content.trim()+"%");
		}
		//短信状态
		if (!SmsConstant.SMS_STATUS_ALL.equals(status)) {
			condition.append(" AND ").append(ISmsTemplateValue.S_Status).append("=:").append(ISmsTemplateValue.S_Status);
			parameter.put(ISmsTemplateValue.S_Status, status);
		}
		//发送类型
		if(!StringUtil.isBlank(sendType) && !SmsConstant.SMS_SEND_TYPE_ALL.equals(sendType)){
			condition.append(" AND ").append(ISmsTemplateValue.S_SendType).append("=:").append(ISmsTemplateValue.S_SendType);
			parameter.put(ISmsTemplateValue.S_SendType, sendType);
		}
		
		condition.append(" order by submit_time desc ");
		
		 ISmsTemplateValue[] values=smsTemplateDAO.getSmsTemplates(condition.toString(), parameter, startIndex, endIndex);
		 for (ISmsTemplateValue value : values) {
			 if(!StringUtil.isNullValue(value.getStatus())){
					StringBuffer stringBuffer = new StringBuffer(); //要拼接的操作字符串
					if((SmsConstant.SMS_STATUS_NOTVERIFY).equals(value.getStatus())){ //待 审核 -- 审核、查看详情    //案例参考:NavigationInfoSrvImpl
						stringBuffer.append(String.format(SmsConstant.SMS_FIRSTAUDIT,value.getSmsId()))
						.append(String.format(SmsConstant.SMS_CHECKINFO,value.getSmsId()));
						value.setOperat(stringBuffer.toString());
					}
			 }
			//查询结果集中,如果发送类型为按已订阅用户发送的把号源数设为0
			 if (!StringUtil.isBlank(value.getSendType()) && value.getSendType().equals(SmsConstant.SMS_SEND_TYPE_ORDER)) {
				value.setNoCount(0);
			}
		}
		 //为了效率就不用公用的方法了
		 //values = changeNoCountbySendType(values);
		 return values;
	}
	
	public void eaxminSmsTemplate(String smsId, String firstTime,
			String Opinion, String status,String operater) throws Exception {
		Timestamp ftime=null ;
		if(!StringUtil.isBlank(firstTime)){
			ftime=DateTimeUtil.stringToTimestamp(firstTime, "yyyy-MM-dd hh:mm:ss");
		}else{
			ftime=DateTimeUtil.getNowTimeStamp();
		}
		ISmsTemplateValue bean=SmsTemplateEngine.getBean(Long.parseLong(smsId));
		bean.setFirstTime(ftime);
		bean.setOptId(operater);
		bean.setStatus(status);
		smsTemplateDAO.saveSmsTemplate(bean);
		BusiSmsAuditBean busiBean=new BusiSmsAuditBean();
		busiBean.setBusiSmsId(BusiSmsAuditEngine.getNewId().longValue());
		busiBean.setSmsId(Long.parseLong(smsId));
		busiBean.setAuditTime(ftime);
		busiBean.setAuditContent(Opinion);
		busiBean.setStatus(status);
		busiBean.setOptId(operater);
		busiSmsDAO.saveBusiSmsValue(busiBean);	
	}
	public void eaxminSmsTemplates(String[] smsIds, String Opinion,
			String status,String operater) throws Exception {
		Timestamp time = DateTimeUtil.getNowTimeStamp();
		ISmsTemplateValue[] values = new SmsTemplateBean[smsIds.length];
		for(int i=0;i<values.length;i++){
			values[i]=SmsTemplateEngine.getBean(Long.parseLong(smsIds[i]));
			values[i].setStatus(status);
			values[i].setFirstTime(time);
			values[i].setOptId(operater);
		}
		smsTemplateDAO.saveSmsTemplates(values);
		IBusiSmsAuditValue[] busiValues= new BusiSmsAuditBean[smsIds.length];
		for (int i=0;i<busiValues.length;i++) {
			busiValues[i] = new BusiSmsAuditBean();
			busiValues[i].setSmsId(Long.parseLong(smsIds[i]));
			busiValues[i].setAuditTime(time);
			busiValues[i].setAuditContent(Opinion);
			busiValues[i].setStatus(status);
			busiValues[i].setOptId(operater);
		}
		busiSmsDAO.saveBusiSmsValues(busiValues);	
	}


	/**
	 * 增加短信模版流水记录
	 * 
	 * @author Administrator 侯栖荫 2012-11-23
	 * @param id 短信模版id
	 * @param type 短信状态
	 * @param content  短信评审原因
	 * @param operer  操作人
	 * @param operer  时间
	 * @throws Exception
	 */
	public void addSmsBusi(String smsid, String content , String status ,String operer , String date_time) throws Exception {
		IBusiSmsAuditValue busiSmsAuditValue = new BusiSmsAuditBean();
		busiSmsAuditValue.setSmsId(Long.parseLong(smsid));
		busiSmsAuditValue.setAuditContent(content);
		busiSmsAuditValue.setStatus(status);
		if(StringUtil.isBlank(date_time)){
			busiSmsAuditValue.setAuditTime(new Timestamp(new Date().getTime()));
		}else{
			busiSmsAuditValue.setAuditTime(DateTimeUtil.stringToTimestamp(date_time,SmsConstant.SMS_DATE_FORMAT_LONG));
		}
		
		busiSmsAuditValue.setOptId(operer);
		this.busiSmsDAO.saveBusiSmsValue(busiSmsAuditValue);
	}

	/**
	 * 保存短信模版任务
	 * 
	 * @author Administrator 侯栖荫 2012-11-23
	 * @param id 短信模版id
	 * @param countNum  短信模版号源数
	 * @param proCode  省份
	 * @throws Exception
	 */
	public void addSmsTask(String id, Long countNum,String proCode, String userId) throws Exception {
		ISmsTaskValue smsTaskValue = new SmsTaskBean();
		smsTaskValue.setSmsId(Long.parseLong(id));
		smsTaskValue.setStatus(SmsConstant.SMSTASK_STATUS_NOEXCUT);
		smsTaskValue.setNoCount(countNum);
		smsTaskValue.setProvCode(proCode);
		smsTaskValue.setOpera(userId);
		this.smsTaskDAO.saveSmsTask(smsTaskValue);
	}

	/**
	 * 根据短信模版Id 得到短信任务
	 * 
	 * @author Administrator 侯栖荫 2012-11-23
	 * @param smsId
	 *            短信模版的id
	 * @return
	 * @throws Exception
	 */
	public ISmsTaskValue getSmsTackBySmsId(String smsId) throws Exception {
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		condition.append(" AND ").append(ISmsTaskValue.S_SmsId).append(" = :").append(ISmsTaskValue.S_SmsId);
		parameter.put(ISmsTaskValue.S_SmsId, smsId);
		ISmsTaskValue[] smsTaskValue = this.smsTaskDAO.getSmsTask(condition.toString(), parameter);
		if (smsTaskValue != null && smsTaskValue.length > 0) {
			return smsTaskValue[0];
		}
		return null;
	}

	/**
	 * 根据短信任务码删除任务
	 * 
	 * @author Administrator 侯栖荫 2012-11-23
	 * @param smsTaskId
	 *            短信任务id
	 * @throws Exception
	 */
	public void deleteSmsTask(long smsTaskId) throws Exception {
		this.smsTaskDAO.deleteSmsTask(String.valueOf(smsTaskId));
	}
	public void saveSmsTemplate(ISmsTemplateValue smsTemplateValue)
			throws Exception {
		logger.info("the smsid is" + smsTemplateValue.getSmsId());
		this.smsTemplateDAO.saveSmsTemplate(smsTemplateValue);
		
		//短信模板流水
		IBusiSmsTemplateValue busiSmsTemplateValue =new BusiSmsTemplateBean();
		busiSmsTemplateValue.setSmsId(smsTemplateValue.getSmsId());
		busiSmsTemplateValue.setOptId(smsTemplateValue.getOptId());
		busiSmsTemplateValue.setTitle(smsTemplateValue.getTitle());
		busiSmsTemplateValue.setContent(smsTemplateValue.getContent());
		busiSmsTemplateValue.setBrand(smsTemplateValue.getBrand());
		busiSmsTemplateValue.setScoreUp(smsTemplateValue.getScoreUp());
		busiSmsTemplateValue.setScoreDown(smsTemplateValue.getScoreDown());
		if(smsTemplateValue.getBakCol2().equals("true")){
			busiSmsTemplateValue.setIsFileupdate("1");
		}else{
			busiSmsTemplateValue.setIsFileupdate("0");
		}
		busiSmsTemplateValue.setQuartzTime(smsTemplateValue.getQuartzTime());
		busiSmsTemplateValue.setCreateTime(DateTimeUtil.getDefaultSysDate());
		//新增发送类型属性
		busiSmsTemplateValue.setSendType(smsTemplateValue.getSendType());
		this.busiSmsTemplateDAO.saveBusiSmsTemplate(busiSmsTemplateValue);
	}
	public IBusiSmsAuditValue[] queryBusiInfo(String smsId) throws Exception {
		logger.info("the smsid is" + smsId);
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map parameter = new HashMap();
		// 短信Id
		if (!StringUtil.isBlank(smsId)) {
			condition.append(" AND ").append(ISmsTemplateValue.S_SmsId).append("=:").append(ISmsTemplateValue.S_SmsId);
			parameter.put(ISmsTemplateValue.S_SmsId, smsId);
		}
		// 增加排序选项，按照创建时间倒序排序
		condition.append(" order by audit_time desc ");
		IBusiSmsAuditValue[] values= this.busiSmsDAO.getBusiSmsValues(condition.toString(), parameter);
		
		 for (IBusiSmsAuditValue value : values) {
			if (!StringUtil.isBlank(value.getOptId())) {
				if (!"SYSTEM".equals(value.getOptId())) {
					ISysStaffValue staffValue = SysStaffEngine.getBean(Long
							.parseLong(value.getOptId()));
					value.setOptId(staffValue.getStaffName());
				}
			}
		}
		
		return values;
	}

	public void smsOperer(String smsid, String status, String content, String operer , String date_time,String type) throws Exception{
		String[] smsids = smsid.split(",");
		for (int i = 0; i < smsids.length; i++) {
			this.smsRejectedOrStop( smsids[i],  status,  content,  operer,date_time, type);
		}
	}
	
	public void delteAll(String []smsIds) throws Exception {
		for (int i = 0; i < smsIds.length; i++) {
			ISmsTemplateValue sms=this.smsTemplateDAO.getSmsTemplateById(smsIds[i]);
			if(!"00".equals(sms.getStatus())&&!"05".equals(sms.getStatus())&&!"03".equals(sms.getStatus())){
				throw new Exception("can not delete the smsTemplate!");
				
			}
		}	
		this.smsTemplateDAO.deleteSmsTemplates(smsIds);
	}
	
	public int countMarketingSmsListOfReView(String smsTemplateTitle, String smsTemplateContent, String smsStatus,String sendType)
			throws Exception {
		logger.info("the smsTemplateTitle is " + smsTemplateTitle+ ",the smsTemplateContent is" + smsTemplateContent
				+ ",  the smsStatus is" + smsStatus );
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map parameter = new HashMap();
		// 模板标题
		if (!StringUtil.isBlank(smsTemplateTitle)) {
			condition.append(" AND ").append(ISmsTemplateValue.S_Title).append(" like :").append(ISmsTemplateValue.S_Title);
			parameter.put(ISmsTemplateValue.S_Title, "%"+smsTemplateTitle.trim()+"%");
		}
		
		// 模板内容
		if (!StringUtil.isBlank(smsTemplateContent)) {
			condition.append(" AND ").append(ISmsTemplateValue.S_Content).append(" like :").append(ISmsTemplateValue.S_Content);
			parameter.put(ISmsTemplateValue.S_Content, "%"+smsTemplateContent.trim()+"%");
		}
		
		//短信状态
		if ( SmsConstant.SMSTASK_REVIEW_STATUS_ALL.equals(smsStatus)) {//全部
			condition.append(" AND ").append(ISmsTemplateValue.S_Status).append(" in ( " + SmsConstant.SMSTASK_REVIEW_STATUS_ALL + " )");
		}else{
			condition.append(" AND ").append(ISmsTemplateValue.S_Status).append(" in ( " + smsStatus + " )");
		}
		//发送类型
		if(!StringUtil.isBlank(sendType) && !SmsConstant.SMS_SEND_TYPE_ALL.equals(sendType)){
			condition.append(" AND ").append(ISmsTemplateValue.S_SendType).append("=:").append(ISmsTemplateValue.S_SendType);
			parameter.put(ISmsTemplateValue.S_SendType, sendType);
		}
		int num = smsTemplateDAO.getSmsTemplatesCount(condition.toString(), parameter);
		return num;
	}
	
	/**
	 * 这里做系统的状态判断，防止多人同时操作，对单一对象操作，造成不必要的修改
	 * @param smsId 短信模版id
	 * @param newStatus 新模版状态
	 * @param type 特殊操作类型
	 * @throws Exception
	 */
	private boolean isAllowOperate(String oldStatus,String newStatus,String type)  throws Exception{
		
		    if( oldStatus.equals(newStatus) && SmsConstant.SMS_STATUS_DRAFT.equals(newStatus)){//新状态 ==老状态/00 说明是编辑
		    	return true;
		    }
		    else if(SmsConstant.SMS_STATUS_DRAFT.equals(oldStatus) && SmsConstant.SMS_STATUS_NOTVERIFY.equals(newStatus) 
		    		){ // 00-->01 起草-->带审核
		    	return true;
		    } 
		    else if(SmsConstant.SMS_STATUS_NOTVERIFY.equals(oldStatus) && 
					(SmsConstant.SMS_STATUS_FIRSTVERIFY.equals(newStatus) ||SmsConstant.SMS_STATUS_NOTFIRSTVERIFY.equals(newStatus))
					){//初审状态可以操作 为 ：01-->02,03 待审核-->审核通过,初审不通过
				return true;
			}
			else if(SmsConstant.SMS_STATUS_FIRSTVERIFY.equals(oldStatus) &&
					(SmsConstant.SMS_STATUS_SECONDVERIFY.equals(newStatus) ||SmsConstant.SMS_STATUS_NOTSECONDVERIFY.equals(newStatus))
					){//复审状态可以操作 为 ：02-->04,05 复审-->复审通过,复审不通过
				return true;
			}
			else if(SmsConstant.SMS_STATUS_SECONDVERIFY.equals(oldStatus) && SmsConstant.SMS_STATUS_OPER_DIFFERENTIATE.equals(type) &&
					(SmsConstant.SMS_STATUS_DRAFT.equals(newStatus) ||SmsConstant.SMS_STATUS_NOTSECONDVERIFY.equals(newStatus) ||
							SmsConstant.SMS_STATUS_END.equals(newStatus))
			  ){//复审通过可以操作 为 ：04-->00,05,06 复审通过-->撤回,驳回,终止
				return true;
			}
			else if(SmsConstant.SMS_STATUS_NOTVERIFY.equals(newStatus) && (
					SmsConstant.SMS_STATUS_NOTFIRSTVERIFY.equals(oldStatus) || SmsConstant.SMS_STATUS_NOTSECONDVERIFY.equals(oldStatus)	)	
			){//03-->01 || 05-->01 //初审失败 或 复审失败 或 驳回 到带审核
				return true;
			}
			else{
				return false;
			}
	}
	
}
