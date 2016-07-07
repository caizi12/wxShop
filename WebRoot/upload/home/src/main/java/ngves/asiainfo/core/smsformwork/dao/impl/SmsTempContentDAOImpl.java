package ngves.asiainfo.core.smsformwork.dao.impl;



import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.smsformwork.bo.BusiSmsFormworkContentEngine;
import ngves.asiainfo.core.smsformwork.bo.SmsFormworkContentEngine;
import ngves.asiainfo.core.smsformwork.dao.interfaces.ISmsTempContentDAO;
import ngves.asiainfo.core.smsformwork.ivalues.IBusiSmsFormworkContentValue;
import ngves.asiainfo.core.smsformwork.ivalues.ISmsFormworkContentValue;
import ngves.asiainfo.interfaces.hp.bean.smsContentArgQuery.in.SmsContentArgQueryInBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.smsContentArgQuery.out.SmsContentArgQueryOutBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.smsContentTest.in.SmsContentTestInBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.smsContentTest.out.SmsContentTestOutBizRegReq;
import ngves.asiainfo.interfaces.hp.realtime.SmsContentArgQueryInter;
import ngves.asiainfo.interfaces.hp.realtime.SmsContentTestInter;
import ngves.asiainfo.util.StringUtil;

/**
 * 短信模板内容管理
 * @author yeqh
 * 2013-12-09
 */

public class SmsTempContentDAOImpl implements ISmsTempContentDAO {

	/**
	 * 测试模板内容信息
	 * @param mobiles 测试手机号码
	 * @param contentID 内容ID
	 * @throws Exception
	 */
	public SmsContentTestOutBizRegReq TestTempContent(String mobiles, String ContentID) throws Exception {
		SmsContentTestInBizRegReq smsContentTestIn = SmsContentTestInter.getSmsContentTestInBean();
		smsContentTestIn.setMobiles(mobiles);
		smsContentTestIn.setContentID(ContentID);
		
		return SmsContentTestInter.doBusi(smsContentTestIn);
	}

	/**
	 * 获取模板参数
	 * @param SRowNum 记录开始编号
	 * @param ERowNum 记录结束编号
	 * @throws Exception
	 */
	public SmsContentArgQueryOutBizRegReq getTempArg(int SRowNum, int ERowNum) throws Exception {
		SmsContentArgQueryInBizRegReq smsContentArgQueryIn = SmsContentArgQueryInter.getSynSmsOccasionInBean();
		smsContentArgQueryIn.setSRowNum(SRowNum);
		smsContentArgQueryIn.setERowNum(ERowNum);
		smsContentArgQueryIn.setArgCode("");
		smsContentArgQueryIn.setArgName("");
		
		return SmsContentArgQueryInter.doBusi(smsContentArgQueryIn);
	}


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
	public ISmsFormworkContentValue[] qryTempContent(String condition, Map parameter, int startIndex, int endIndex)
			throws Exception {
		return SmsFormworkContentEngine.getBeans(null, condition, parameter, startIndex, endIndex, false);
	}

	/**
	 * 根据条件查询模板内容信息列表数量
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public int qryTempContentCount(String condition, Map parameter) throws Exception {
		return SmsFormworkContentEngine.getBeansCount(condition, parameter);
	}

	/**
	 * 新增，修改，删除模板内容信息
	 * @param value
	 * @throws Exception
	 */
	public void saveSmsFormworkContent(ISmsFormworkContentValue value) throws Exception {
		SmsFormworkContentEngine.save(value);
	}
	
	/**
	 * 通过内容id查询模板内容信息
	 * @param ContentID
	 * @return
	 * @throws Exception
	 */
	public ISmsFormworkContentValue getSmsFormworkContentByContentID(String contentId)throws Exception {
		return SmsFormworkContentEngine.getBean(contentId);
	}
	
	/**
	 * 判断短信内容是否能被删除
	 * 新增的短信内容可删除，绑定短信模板后不可删除，需解除绑定关系才可删除。
	 * @param contentId 内容id
	 * @return
	 * @throws Exception
	 */
	public boolean isCanDelSmsFormworkContent(String contentId)throws Exception {
		if(StringUtil.isBlank(contentId)){
			throw new Exception("delete smsFormworkContent failure");
		}
		StringBuffer condition = new StringBuffer(" M.CONTENT_ID IN (SELECT SFOR.CONTENT_ID \n");
		condition.append("   FROM SMS_FORMWORK_OCCASION_RLT SFOR, SMS_FORMWORK SF \n");
		condition.append("  WHERE SF.FORMWORK_ID = SFOR.FORMWORK_ID \n");
		condition.append("    AND SF.IS_STOPPED = '0'  \n");
		condition.append("    AND SFOR.CONTENT_ID = '"+ contentId +"') \n");
		ISmsFormworkContentValue[] SmsFormworkContent= SmsFormworkContentEngine.getBeans(condition.toString(), null);
		if(SmsFormworkContent != null && SmsFormworkContent.length>0){
			return false;
		}
		return true;
	}
	
	
	/**
	 * 新增，修改，删除模板内容信息记录操作流水
	 * @param value
	 * @throws Exception
	 */
	public void saveBusiSmsFormworkContent(IBusiSmsFormworkContentValue value) throws Exception {
		BusiSmsFormworkContentEngine.save(value);
	}
	
	/**
	 * 判断短信内容是否能增加
	 * 模板内容标题不能重复
	 * @param contentName 内容标题
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public boolean isCanAddSmsFormworkContent(String contentName)throws Exception {
		if(StringUtil.isBlank(contentName)){
			throw new Exception("add smsFormworkContent failure");
		}
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1=1 \n");
		if(!StringUtil.isBlank(contentName)){
			condition.append(" AND ").append(ISmsFormworkContentValue.S_ContentName).append(" = :").append(ISmsFormworkContentValue.S_ContentName);
			//查询出来的模板内容不包含被“删除”的记录 03表示删除
			condition.append(" AND IS_STOPPED <> '03' \n");
			parameter.put(ISmsFormworkContentValue.S_ContentName, contentName);
		}
		ISmsFormworkContentValue[] SmsFormworkContent= SmsFormworkContentEngine.getBeans(condition.toString(), parameter);
		if(SmsFormworkContent != null && SmsFormworkContent.length>0){
			return false;
		}
		return true;
	}
}
