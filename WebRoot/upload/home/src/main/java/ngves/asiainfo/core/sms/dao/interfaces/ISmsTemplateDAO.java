package ngves.asiainfo.core.sms.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.sms.ivalues.ISmsTemplateValue;

public interface ISmsTemplateDAO {
	
	/**
	 * 短信模板保存
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public void saveSmsTemplate(ISmsTemplateValue value) throws Exception;

	/**
	 * 短信模板批量保存
	 * 
	 * @param values
	 * @return
	 * @throws Exception
	 */
	public void saveSmsTemplates(ISmsTemplateValue[] values)
			throws Exception;

	/**
	 * 短信模板列表获取
	 * 
	 * @param condition
	 * @param parameter
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ISmsTemplateValue[] getSmsTemplates(String condition,
			Map parameter,int startIndex, int endIndex)
			throws Exception;
	/**
	 * 短信模板列表获取(不进行分页)
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ISmsTemplateValue[] getSmsTemplates(String condition,
			Map parameter)
			throws Exception;

	/**
	 * 短信模板列表行数
	 * 
	 * @param condition
	 * @param parameter
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public int getSmsTemplatesCount(String condition,
			Map parameter) throws Exception;

	/**
	 * 短信模板详情获取
	 * 
	 * @param smsId
	 * @return
	 * @throws Exception
	 */
	public ISmsTemplateValue getSmsTemplateById(String smsId) throws Exception;

	/**
	 * 短信模板批量删除
	 * 
	 * @param smsIds
	 * @return
	 * @throws Exception
	 */
	public void deleteSmsTemplates(String[] smsIds) throws Exception;

	/**
	 * 短信模板删除
	 * 
	 * @param smsId
	 * @return
	 * @throws Exception
	 */

	public void deleteSmsTemplate(String smsId)throws Exception;





}
