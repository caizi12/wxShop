package ngves.asiainfo.core.sms.dao.impl;

import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ngves.asiainfo.core.sms.bo.QBOSmsTaskAndTemplateEngine;
import ngves.asiainfo.core.sms.bo.SmsTaskEngine;
import ngves.asiainfo.core.sms.dao.interfaces.ISmsTaskDAO;
import ngves.asiainfo.core.sms.ivalues.IQBOSmsTaskAndTemplateValue;
import ngves.asiainfo.core.sms.ivalues.ISmsTaskValue;
import ngves.asiainfo.util.StringUtil;

public class SmsTaskDAOImpl implements ISmsTaskDAO {
	private static Log log = LogFactory.getLog(SmsTaskDAOImpl.class);

	public void deleteSmsTask(String smsTaskId) throws Exception {
		if (!StringUtil.isBlank(smsTaskId)) {
			ISmsTaskValue value = SmsTaskEngine.getBean(Long
					.parseLong(smsTaskId));
			value.delete();
			SmsTaskEngine.save(value);
		} else {
			log.info("delete SmsTask fail,the smsTaskId is null .......");
		}
	}

	public void deleteSmsTasks(String[] smsTaskIds) throws Exception {
		ISmsTaskValue value = null;
		for (String id : smsTaskIds) {
			value = SmsTaskEngine.getBean(Long.parseLong(id));
			value.delete();
			SmsTaskEngine.save(value);
		}
	}

	@SuppressWarnings("unchecked")
	public IQBOSmsTaskAndTemplateValue[] getQBOSmsTaskAndTemplateValues(
			String condition, Map parameter, int startIndex, int endIndex)
			throws Exception {
		return QBOSmsTaskAndTemplateEngine.getBeans(null, condition, parameter,
				startIndex, endIndex, false);
	}

	@SuppressWarnings("unchecked")
	public int getQBOSmsTaskAndTemplateCount(String condition, Map parameter)
			throws Exception {
		return QBOSmsTaskAndTemplateEngine.getBeansCount(condition, parameter);
	}

	public void saveSmsTask(ISmsTaskValue value) throws Exception {
		if (value.isNew()) {
			value.setId(SmsTaskEngine.getNewId().longValue());
		}
		SmsTaskEngine.save(value);
	}

	public void saveSmsTasks(ISmsTaskValue[] values) throws Exception {
		for (ISmsTaskValue value : values) {
			if (value.isNew()) {
				value.setId(SmsTaskEngine.getNewId().longValue());
			}
		}
		SmsTaskEngine.save(values);
	}

	public ISmsTaskValue getSmsTask(String smsTaskId) throws Exception {
		if (!StringUtil.isBlank(smsTaskId)) {
			return SmsTaskEngine.getBean(Long.parseLong(smsTaskId));
		} else {
			log.info("getSmsTask by id ,the smsTaskId is null .......");
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public IQBOSmsTaskAndTemplateValue[] getQBOSmsTaskAndTemplateValues(
			String condition, Map parameter) throws Exception {
		return QBOSmsTaskAndTemplateEngine.getBeans(condition, parameter);
	}

	@SuppressWarnings("unchecked")
	public ISmsTaskValue[] getSmsTask(String condition, Map parameter)
			throws Exception {
		return SmsTaskEngine.getBeans(condition, parameter);
	}
}
