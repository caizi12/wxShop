package ngves.asiainfo.core.smsformwork.service.interfaces;

import java.util.List;

import ngves.asiainfo.core.smsformwork.dao.interfaces.ISmsTempContentDAO;
import ngves.asiainfo.core.smsformwork.ivalues.ISmsFormworkContentValue;
import ngves.asiainfo.core.smsformwork.model.ResultBean;
import ngves.asiainfo.core.smsformwork.model.SmsContentArgBean;

/**
 * 短信模板内容管理
 * @author yeqh
 * 2013-12-09
 */

public interface ISmsTempContentSrv {
	
	public void setSmsTempContentDAO(ISmsTempContentDAO smsTempContentDAO)throws Exception;
	
	/**
	 * 查询模板内容信息
	 * @param contentName 内容标题
	 * @param content 模板内容
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public ISmsFormworkContentValue[] qryTempContent(String contentName, String content,String operType, int startIndex, int endIndex) throws Exception;
	
	/**
	 * 根据条件查询模板内容信息列表数量
	 * @param contentName 内容标题
	 * @param content 模板内容
	 * @return
	 * @throws Exception
	 */
	public int qryTempContentCount(String contentName, String content) throws Exception;
	
	
	/**
	 * 新增，修改，删除模板内容信息
	 * @param value
	 * @param isModify 内容是否被修改，0：未被修改，1：修改
	 * @throws Exception
	 */
	public ResultBean saveSmsFormworkContent(ISmsFormworkContentValue value, String isModify) throws Exception;
	
	
	/**
	 * 测试模板内容信息
	 * @param mobiles 测试手机号码
	 * @param contentID 内容ID
	 * @throws Exception
	 */
	public ResultBean TestTempContent(String mobiles, String contentID) throws Exception;
	
	
	/**
	 * 获取模板参数
	 * @param SRowNum 记录开始编号
	 * @param ERowNum 记录结束编号
	 * @throws Exception
	 */
	public List<SmsContentArgBean> getTempArg(int SRowNum, int ERowNum) throws Exception;
	
	
	/**
	 * 通过模板内容id获取模板内容信息
	 * @param contentId
	 * @return
	 * @throws Exception
	 */
	public ISmsFormworkContentValue getSmsFormworkContent(String contentId)throws Exception;

	/**
	 * 根据模板内容id查询相应的模板内容
	 * @return
	 */
	public String qryFormworkContentById(String smsContentId) throws Exception;

}
