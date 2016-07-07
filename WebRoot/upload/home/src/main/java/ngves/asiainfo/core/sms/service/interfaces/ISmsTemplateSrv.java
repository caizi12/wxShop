package ngves.asiainfo.core.sms.service.interfaces;

import ngves.asiainfo.core.sms.dao.interfaces.IBusiSmsDAO;
import ngves.asiainfo.core.sms.dao.interfaces.IBusiSmsTemplateDAO;
import ngves.asiainfo.core.sms.dao.interfaces.ISmsTaskDAO;
import ngves.asiainfo.core.sms.dao.interfaces.ISmsTemplateDAO;
import ngves.asiainfo.core.sms.ivalues.IBusiSmsAuditValue;
import ngves.asiainfo.core.sms.ivalues.ISmsTemplateValue;

public interface ISmsTemplateSrv {

	public void setSmsTemplateDAO(ISmsTemplateDAO smsTemplateDAO);

	public void setSmsTaskDAO(ISmsTaskDAO smsTaskDAO);

	public void setBusiSmsDAO(IBusiSmsDAO busiSmsDAO);
	
	public void setBusiSmsTemplateDAO(IBusiSmsTemplateDAO busiSmsTemplateDAO);

	/**
	 * 查询营销短信列表
	 * 
	 * @param smsTemplateTitle
	 *            模板标题
	 * @param smsTemplateContent
	 *            模板内容
	 * @param smsStatus
	 *            短信状态
	 * @param sendType   发送类型    
	 * @param proCode 操作人省份
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 *             异常
	 * 
	 */

	public ISmsTemplateValue[] queryMarketingSmsList(String smsTemplateTitle,
			String smsTemplateContent, String smsStatus, String sendType,String proCode, int startIndex,
			int endIndex) throws Exception;

	/**
	 * 查询营销短信数目
	 * 
	 * @param smsTemplateTitle
	 *            模板标题
	 * @param smsTemplateContent
	 *            模板内容
	 * @param smsStatus
	 *            短信状态
	 * @param sendType   发送类型    
	 * @param proCode 操作人省份
	 * @return
	 * @throws Exception
	 *             异常
	 * 
	 */
	public int countMarketingSmsList(String smsTemplateTitle,
			String smsTemplateContent, String smsStatus,String sendType,String proCode) throws Exception;
	/**
	 *通过短信id获取短信模板
	 * @param smsId
	 * @return
	 * @throws Exception
	 * 
	 */
	public ISmsTemplateValue queryMarketingSmsListById(String smsId) throws Exception;

	
	/**
	 * 根据Id查询短信模版
	 * @author 侯栖荫   2012-11-19
	 * @param id 短信Id
	 * @return 单个短信模版
	 */
	public ISmsTemplateValue getISmsTemplateValueById(String id) throws Exception;
	
	/**
	 * 更新短信模版
	 * @author 侯栖荫   2012-11-19
	 * @param smsTemplateValue 短信模版
	 * @throws Exception
	 */
	public void updateISmsTemplateValue(ISmsTemplateValue smsTemplateValue) throws Exception;

	/**
	 * 查询营销短信列表（短信初审）
	 * @param title
	 * @param content
	 * @param Status
	 * @param sendType 新增发送类型
	 * @param $STARTROWINDEX
	 * @param $ENDROWINDEX
	 * @return
	 * @author 李进军 2012-11-22
	 * @throws Exception
	 */
	public ISmsTemplateValue[] queryFirstExaminList(String title,String content,String status,String sendType,
			int startIndex,int endIndex)throws Exception;
	/**
	 * 查询营销短信列表行数（短信初审）
	 * @param title
	 * @param content
	 * @param Status
	 * @param sendType 新增发送类型
	 * @return
	 * @author 李进军 2012-11-22
	 * @throws Exception
	 */
	public int queryFirstExaminCount(String title,String content,String status,String sendType)throws Exception;
	/**
	 * 短信初审
	 * @param value
	 * @throws Exception
	 * @author 李进军 2012-11-22
	 */
	public void eaxminSmsTemplate(String smsId,String firstTime,String Opinion,String status,String operater)throws Exception;
	/**
	 * 批量短信初审
	 * @param smsIds
	 * @param Opinion
	 * @param through
	 * @throws Exception
	 * @author 李进军 2012-11-23
	 */
	public void eaxminSmsTemplates(String[] smsIds,String Opinion,String status,String operater)throws Exception;
	/**
	 * 查询营销短信复审列表
	 * @author 侯栖荫   2012-11-22
	 * @param smsTemplateTitle 模板标题
	 * @param smsTemplateContent 模板内容
	 * @param smsStatus 短信状态
	 * @param sendType
	 * @param startIndex 
	 * @param endIndex
	 * @return
	 * @throws Exception 异常
	 * 
	 */

	public ISmsTemplateValue[] queryMarketingSmsListOfReview(String smsTemplateTitle,
			String smsTemplateContent, String smsStatus ,String sendType,int startIndex,
			int endIndex) throws Exception;
	
	/**
	 * 短信模版驳回 或终止
	 * @author 侯栖荫   2012-11-22
	 * @param id 短信模版Id
	 * @param stauts 类型:驳回或终止
	 * @param content 驳回或终止意见
	 * @param operer 操作人
	 * @param date_time 流水时间
	 * @param type 特殊类型操作
	 */
	public void smsRejectedOrStop(String smsid, String status, String content, String operer,String date_time,String type) throws Exception;
	
	/**
	 * 短信模版操作:整体业务操作:     审核、 状态修改、 复审、 驳回、终止、添加流水记录、删除短信任务 
	 * @author Administrator 侯栖荫   2012-11-26
	 * @param smsid 短信模版
	 * @param status 更改的状态
	 * @param content 审核意见
	 * @param operer 操作人
	 * @param dateTime 时间
	 * @param type 特殊类型操作
	 * @throws Exception
	 */
	public void smsOperer(String smsid, String status, String content, String operer , String dateTime ,String type) throws Exception;

	/**
	 * 新增短信模板
	 * @param smsTemplateValue
	 * @throws Exception
	 *
	 */
	public void saveSmsTemplate(ISmsTemplateValue smsTemplateValue) throws Exception;
	/**查询操作历史
	 * @param smsId
	 * @throws Exception
	 *
	 */
	public IBusiSmsAuditValue[] queryBusiInfo(String smsId) throws Exception;
	/**批量删除短信模板
	 * @param smsIds
	 * @throws Exception
	 *
	 */
	public void delteAll(String []smsIds) throws Exception;
	
	/**
	 * 复审 查询个数  
	 * @author Administrator 侯栖荫 2012-12-05
	 * @param smsTemplateTitle 标题
	 * @param smsTemplateContent 内容
	 * @param smsStatus 状态
	 * @param sendType
	 * @return 个数
	 * @throws Exception
	 */
	public int countMarketingSmsListOfReView(String smsTemplateTitle,
			String smsTemplateContent, String smsStatus,String sendType) throws Exception;

	
}
