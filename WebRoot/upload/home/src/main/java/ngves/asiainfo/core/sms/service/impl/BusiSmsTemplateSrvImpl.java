package ngves.asiainfo.core.sms.service.impl;

import ngves.asiainfo.core.sms.bo.BusiSmsTemplateBean;
import ngves.asiainfo.core.sms.dao.interfaces.IBusiSmsTemplateDAO;
import ngves.asiainfo.core.sms.ivalues.IBusiSmsTemplateValue;
import ngves.asiainfo.core.sms.ivalues.ISmsTemplateValue;
import ngves.asiainfo.core.sms.service.interfaces.IBusiSmsTemplateSrv;
import ngves.asiainfo.util.DateTimeUtil;

public class BusiSmsTemplateSrvImpl implements IBusiSmsTemplateSrv{

	private IBusiSmsTemplateDAO busiSmsTemplateDAO;
	public void setBusiSmsTemplateDAO(IBusiSmsTemplateDAO busiSmsTemplateDAO) {
		this.busiSmsTemplateDAO=busiSmsTemplateDAO;
	}

	public void savBusiSmsTemplate(ISmsTemplateValue smsTemplateValue) throws Exception {
		IBusiSmsTemplateValue busiSmsTemplateValue =new BusiSmsTemplateBean();
		busiSmsTemplateValue.setSmsId(smsTemplateValue.getSmsId());
		busiSmsTemplateValue.setOptId(smsTemplateValue.getOptId());
		busiSmsTemplateValue.setTitle(smsTemplateValue.getTitle());
		busiSmsTemplateValue.setContent(smsTemplateValue.getContent());
		busiSmsTemplateValue.setBrand(smsTemplateValue.getBrand());
		busiSmsTemplateValue.setScoreUp(smsTemplateValue.getScoreUp());
		busiSmsTemplateValue.setScoreDown(smsTemplateValue.getScoreDown());
		busiSmsTemplateValue.setIsFileupdate(smsTemplateValue.getFilePath());
		busiSmsTemplateValue.setQuartzTime(smsTemplateValue.getQuartzTime());
		busiSmsTemplateValue.setCreateTime(DateTimeUtil.getDefaultSysDate());
		this.busiSmsTemplateDAO.saveBusiSmsTemplate(busiSmsTemplateValue);
	}

}
