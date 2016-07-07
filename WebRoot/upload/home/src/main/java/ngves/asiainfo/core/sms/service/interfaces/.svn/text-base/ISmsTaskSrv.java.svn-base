package ngves.asiainfo.core.sms.service.interfaces;

import ngves.asiainfo.core.sms.dao.interfaces.IBusiSmsDAO;
import ngves.asiainfo.core.sms.dao.interfaces.ISmsTaskDAO;
import ngves.asiainfo.core.sms.dao.interfaces.ISmsTemplateDAO;
import ngves.asiainfo.core.sms.ivalues.IQBOSmsTaskAndTemplateValue;
import ngves.asiainfo.core.sms.ivalues.ISmsTaskValue;

public interface ISmsTaskSrv {

	public void setSmsTaskDAO(ISmsTaskDAO smsTaskDAO);
	
	public void setBusiSmsDAO(IBusiSmsDAO busiSmsDAO);

	public void setSmsTemplateDAO(ISmsTemplateDAO smsTemplateDAO);

	
	/**
	 * 执行短信任务
	 * 
	 * @param sms_id 短信模板ID
	 * @param operatId 操作人
	 * @param sendTime 操作时间
	 * @throws Exception
	 */
	public void executeSmsTask(String sms_id,String operatId,String sendTime) throws Exception;
	

	
	/**
	 * 查看任务
	 * 
	 * @param task_id
	 * @return
	 * @throws Exception
	 */
	public ISmsTaskValue getSmsTask(String task_id) throws Exception;
	
	
	/**
	 * 获取短信任务列表
	 * 
	 * @param role
	 * @param provCode
	 * @param title
	 * @param context
	 * @param status
	 * @param smsTemStatus
	 * @param sendType 
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IQBOSmsTaskAndTemplateValue[] getQBOSmsTaskAndTemplateValues(String role, String provCode, 
			String title, String context, String status, String smsTemStatus,String sendType, int startIndex, int endIndex ) throws Exception;
			
	/**
	 * 获取短信任务总数
	 * 
	 * @param role
	 * @param provCode
	 * @param title
	 * @param context
	 * @param status
	 * @param smsTemStatus
	 * @param sendType 新增:发送类型
	 * @return
	 * @throws Exception
	 */
	public int getQBOSmsTaskAndTemplateCount(String role, String provCode, String title,String context,String status,String smsTemStatus,String sendType) throws Exception;
	
	
}
