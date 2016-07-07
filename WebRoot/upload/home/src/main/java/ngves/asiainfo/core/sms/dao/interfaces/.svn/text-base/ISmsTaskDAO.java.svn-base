package ngves.asiainfo.core.sms.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.sms.ivalues.IQBOSmsTaskAndTemplateValue;
import ngves.asiainfo.core.sms.ivalues.ISmsTaskValue;

public interface ISmsTaskDAO {

	/**
	 * 短信任务批量保存
	 * 
	 * @param values
	 * @return
	 * @throws Exception
	 */
	public void saveSmsTasks(ISmsTaskValue[] values) throws Exception;

	/**
	 * 短信任务保存
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public void saveSmsTask(ISmsTaskValue value) throws Exception;

	/**
	 * 短信模板与任务关联列表获取
	 * 
	 * @param condition
	 * @param parameter
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public IQBOSmsTaskAndTemplateValue[] getQBOSmsTaskAndTemplateValues(
			String condition, Map parameter, int startIndex, int endIndex)
			throws Exception;

	/**
	 * 短信模板与任务关联列表获取(不进行分页)
	 * 
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public IQBOSmsTaskAndTemplateValue[] getQBOSmsTaskAndTemplateValues(
			String condition, Map parameter) throws Exception;

	/**
	 * 短信模板与任务关联列表行数
	 * 
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public int getQBOSmsTaskAndTemplateCount(String condition, Map parameter)
			throws Exception;

	/**
	 * 短信任务详情获取
	 * 
	 * @param smsTaskId
	 * @return
	 * @throws Exception
	 */
	public ISmsTaskValue getSmsTask(String smsTaskId) throws Exception;

	/**
	 * 短信任务批量删除
	 * 
	 * @param smsTaskIds
	 * @return
	 * @throws Exception
	 */
	public void deleteSmsTasks(String[] smsTaskIds) throws Exception;

	/**
	 * 短信任务删除
	 * 
	 * @param smsTaskId
	 * @return
	 * @throws Exception
	 */
	public void deleteSmsTask(String smsTaskId) throws Exception;

	/**
	 * 根据条件查询任务
	 * 
	 * @param smsTaskId
	 * @return
	 * @throws Exception
	 */

	@SuppressWarnings("unchecked")
	public ISmsTaskValue[] getSmsTask(String condition, Map parameter)
			throws Exception;

}
