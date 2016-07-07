package ngves.asiainfo.core.sms.dao.impl;


import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.sms.bo.BusiSmsTemplateEngine;
import ngves.asiainfo.core.sms.dao.interfaces.IBusiSmsTemplateDAO;
import ngves.asiainfo.core.sms.ivalues.IBusiSmsTemplateValue;

public class BusiSmsTemplateDAOImpl implements IBusiSmsTemplateDAO {

	public void saveBusiSmsTemplate(IBusiSmsTemplateValue value)
			throws Exception {
		if (value.isNew()) {
			value.setBusiSmsTemplateId(BusiSmsTemplateEngine.getNewId().longValue());
		}
		BusiSmsTemplateEngine.save(value);
	}
	
	@SuppressWarnings("unchecked")
	public IBusiSmsTemplateValue[] getBusiSmsTemplateBySmsId(long smsId)
			throws Exception {
		StringBuffer condition = new StringBuffer();
		Map parameter = new HashMap();
		condition.append(IBusiSmsTemplateValue.S_SmsId).append(
		"  = :").append("SMSID")
		.append(" and ");
		parameter.put("SMSID",smsId);
		condition.append(" 1=1 ");
		String sql = condition.toString();
		return BusiSmsTemplateEngine.getBeans(sql,parameter);
	}

}
