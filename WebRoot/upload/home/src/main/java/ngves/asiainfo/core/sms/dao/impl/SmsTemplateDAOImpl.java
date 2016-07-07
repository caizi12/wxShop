package ngves.asiainfo.core.sms.dao.impl;

import java.util.Map;
import ngves.asiainfo.core.sms.bo.SmsTemplateBean;
import ngves.asiainfo.core.sms.bo.SmsTemplateEngine;
import ngves.asiainfo.core.sms.dao.interfaces.ISmsTemplateDAO;
import ngves.asiainfo.core.sms.ivalues.ISmsTemplateValue;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SmsTemplateDAOImpl implements ISmsTemplateDAO {
	private static Log log = LogFactory.getLog(SmsTemplateDAOImpl.class);

	public ISmsTemplateValue getSmsTemplateById(String smsId) throws Exception {
		if (!StringUtil.isBlank(smsId)) {
			return SmsTemplateEngine.getBean(Long.parseLong(smsId));
		} else {
			log.info("smsId is null.....");
			return null;
		}
	}

	public void saveSmsTemplate(ISmsTemplateValue value) throws Exception {
		if (value.isNew()) {
			if(StringUtil.isBlank((value.getSmsId()+""))){
				value.setSmsId(SmsTemplateEngine.getNewId().longValue());
			}
			
		}
		SmsTemplateEngine.save(value);
	}

	public void saveSmsTemplates(ISmsTemplateValue[] values) throws Exception {
		for (ISmsTemplateValue value : values) {
			if (value.isNew()) {
				value.setSmsId(SmsTemplateEngine.getNewId().longValue());
			}
		}
		SmsTemplateEngine.save(values);
	}

	@SuppressWarnings("unchecked")
	public ISmsTemplateValue[] getSmsTemplates(String condition, Map parameter,
			int startIndex, int endIndex) throws Exception {
		return SmsTemplateEngine.getBeans(null, condition, parameter,
				startIndex, endIndex, false);
	}

	@SuppressWarnings("unchecked")
	public int getSmsTemplatesCount(String condition, Map parameter)
			throws Exception {
		return SmsTemplateEngine.getBeansCount(condition, parameter);
	}

	public void deleteSmsTemplate(String smsId) throws Exception {
		if (!StringUtil.isBlank(smsId)) {
			SmsTemplateBean bean = SmsTemplateEngine.getBean(Long
					.parseLong(smsId));
			bean.delete();
			SmsTemplateEngine.save(bean);
		} else {
			log.info("delete SmsTemplate, the smsId is null .......  ");
		}
	}

	public void deleteSmsTemplates(String[] smsIds) throws Exception {
		if (smsIds.length > 0) {
			ISmsTemplateValue value=null;
			for (String id : smsIds) {
				value=SmsTemplateEngine.getBean(Long.parseLong(id));
				value.delete();
				SmsTemplateEngine.save(value);
			}
		} else {
			log.info("delete SmsTemplates, the smsIds is null .......  ");
		}
	}

	@SuppressWarnings("unchecked")
	public ISmsTemplateValue[] getSmsTemplates(String condition, Map parameter)
			throws Exception {
		return SmsTemplateEngine.getBeans(condition, parameter);
	}
	
	
}
