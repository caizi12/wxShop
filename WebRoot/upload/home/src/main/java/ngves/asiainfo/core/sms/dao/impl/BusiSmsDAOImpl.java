package ngves.asiainfo.core.sms.dao.impl;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ngves.asiainfo.core.sms.bo.BusiSmsAuditEngine;
import ngves.asiainfo.core.sms.dao.interfaces.IBusiSmsDAO;
import ngves.asiainfo.core.sms.ivalues.IBusiSmsAuditValue;
import ngves.asiainfo.util.StringUtil;

public class BusiSmsDAOImpl implements IBusiSmsDAO {
	private static Log log = LogFactory.getLog(SmsTemplateDAOImpl.class);
	public IBusiSmsAuditValue getBusiSmsValueById(String busiSmsId)
			throws Exception {
		if(StringUtil.isBlank(busiSmsId)){
		IBusiSmsAuditValue value = BusiSmsAuditEngine.getBean(Long
				.parseLong(busiSmsId));
		return value;
		}else{
			log.info("busiSmsId is null .............");
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public IBusiSmsAuditValue[] getBusiSmsValues(String condition,
			Map parameter, int startIndex, int endIndex) throws Exception {
		IBusiSmsAuditValue[] values = BusiSmsAuditEngine.getBeans(null,
				condition, parameter, startIndex, endIndex, false);
		return values;
	}

	public void saveBusiSmsValue(IBusiSmsAuditValue value) throws Exception {
		if (value.isNew()) {
			value.setBusiSmsId(BusiSmsAuditEngine.getNewId().longValue());
		}
		BusiSmsAuditEngine.save(value);
	}

	public void saveBusiSmsValues(IBusiSmsAuditValue[] values) throws Exception {
		for (IBusiSmsAuditValue value : values) {
			if(value.isNew()){
			value.setBusiSmsId(BusiSmsAuditEngine.getNewId().longValue());
			
			}
		}
		BusiSmsAuditEngine.save(values);
	}

	@SuppressWarnings("unchecked")
	public int getBusiSmsValuesCount(String condition, Map parameter)
			throws Exception {
		return BusiSmsAuditEngine.getBeansCount(condition, parameter);
	}

	@SuppressWarnings("unchecked")
	public IBusiSmsAuditValue[] getBusiSmsValues(String condition, Map parameter)
			throws Exception {
		return BusiSmsAuditEngine.getBeans(condition, parameter);
	}

}
