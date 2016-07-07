package ngves.asiainfo.core.sms.dao.interfaces;

import ngves.asiainfo.core.sms.ivalues.IBusiSmsTemplateValue;

public interface IBusiSmsTemplateDAO {
	/**
	 * 短信模板流水信息保存
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public void saveBusiSmsTemplate(IBusiSmsTemplateValue value) throws Exception;
	
	/**
	 * 获取短信模板流水信息（BySmsId）
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public IBusiSmsTemplateValue[] getBusiSmsTemplateBySmsId(long smsId) throws Exception;
	
}
