package ngves.asiainfo.core.sms.service.interfaces;

import ngves.asiainfo.core.sms.dao.interfaces.IBusiSmsTemplateDAO;
import ngves.asiainfo.core.sms.ivalues.ISmsTemplateValue;

public interface IBusiSmsTemplateSrv {
	
	public void setBusiSmsTemplateDAO(IBusiSmsTemplateDAO busiSmsTemplateDAO);
	
	/**短信模板流水记录
	 *@param busiSmsTemplateValue
	 * @throws Exception 
	 */
	public void savBusiSmsTemplate(ISmsTemplateValue smsTemplateValue) throws Exception;
}
