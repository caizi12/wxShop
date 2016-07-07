package ngves.asiainfo.core.smsformwork.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.smsformwork.ivalues.IBusiSmsFormworkContentValue;
import ngves.asiainfo.core.smsformwork.ivalues.ISmsFormworkContentValue;
import ngves.asiainfo.interfaces.hp.bean.smsContentArgQuery.out.SmsContentArgQueryOutBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.smsContentTest.out.SmsContentTestOutBizRegReq;

/**
 * 短信模板内容管理
 * @author yeqh
 * 2013-12-09
 */

public interface ISmsTempContentDAO {
	
	/**
	 * 查询模板内容信息
	 * @param condition
	 * @param parameter
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ISmsFormworkContentValue[] qryTempContent(String condition, Map parameter, int startIndex, int endIndex) throws Exception;
	
	/**
	 * 根据条件查询模板内容信息列表数量
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public int qryTempContentCount(String condition,Map parameter) throws Exception;
	
	
	/**
	 * 新增，修改，删除模板内容信息
	 * @param value
	 * @throws Exception
	 */
	public void saveSmsFormworkContent(ISmsFormworkContentValue value) throws Exception;
	
	
	/**
	 * 测试模板内容信息
	 * @param mobiles 测试手机号码
	 * @param contentID 内容ID
	 * @throws Exception
	 */
	public SmsContentTestOutBizRegReq TestTempContent(String mobiles, String contentID) throws Exception;
	
	
	/**
	 * 获取模板参数
	 * @param SRowNum 记录开始编号
	 * @param ERowNum 记录结束编号
	 * @throws Exception
	 */
	public SmsContentArgQueryOutBizRegReq getTempArg(int SRowNum, int ERowNum) throws Exception;
	
	
	/**
	 * 通过内容id查询模板内容信息
	 * @param contentId
	 * @return
	 * @throws Exception
	 */
	public ISmsFormworkContentValue getSmsFormworkContentByContentID(String contentId)throws Exception;
	
	
	/**
	 * 判断短信内容是否能被删除
	 * 新增的短信内容可删除，绑定短信模板后不可删除，需解除绑定关系才可删除。
	 * @param contentId 内容id
	 * @return
	 * @throws Exception
	 */
	public boolean isCanDelSmsFormworkContent(String contentId)throws Exception;
	
	/**
	 * 新增，修改，删除模板内容信息记录操作流水
	 * @param value
	 * @throws Exception
	 */
	public void saveBusiSmsFormworkContent(IBusiSmsFormworkContentValue value) throws Exception;
	
	/**
	 * 判断短信内容是否能增加
	 * 模板内容标题不能重复
	 * @param contentName 内容标题
	 * @return
	 * @throws Exception
	 */
	public boolean isCanAddSmsFormworkContent(String contentName)throws Exception ;
	
}
