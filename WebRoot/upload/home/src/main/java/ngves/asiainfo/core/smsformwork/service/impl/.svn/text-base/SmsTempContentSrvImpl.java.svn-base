package ngves.asiainfo.core.smsformwork.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.common.service.interfaces.ISysBusiLockInfoSrv;
import ngves.asiainfo.core.donated.exception.MgtException;
import ngves.asiainfo.core.order.OrderConstant;
import ngves.asiainfo.core.smsformwork.SmsFormworkConstant;
import ngves.asiainfo.core.smsformwork.bo.BusiSmsFormworkContentBean;
import ngves.asiainfo.core.smsformwork.dao.interfaces.ISmsTempContentDAO;
import ngves.asiainfo.core.smsformwork.ivalues.IBusiSmsFormworkContentValue;
import ngves.asiainfo.core.smsformwork.ivalues.ISmsFormworkContentValue;
import ngves.asiainfo.core.smsformwork.model.ResultBean;
import ngves.asiainfo.core.smsformwork.model.SmsContentArgBean;
import ngves.asiainfo.core.smsformwork.service.interfaces.ISmsTempContentSrv;
import ngves.asiainfo.core.smsformwork.util.SmsFormworkUtils;
import ngves.asiainfo.interfaces.hp.bean.smsContentArgQuery.out.SmsContentArgQueryOutArgList;
import ngves.asiainfo.interfaces.hp.bean.smsContentArgQuery.out.SmsContentArgQueryOutBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.smsContentTest.out.SmsContentTestOutBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.synSmsTempContent.in.SynSmsTempContentInBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.synSmsTempContent.in.SynSmsTempContentInContentList;
import ngves.asiainfo.interfaces.hp.bean.synSmsTempContent.out.SynSmsTempContentOutBizRegReq;
import ngves.asiainfo.interfaces.hp.realtime.SynSmsTempContentInter;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.JDBCUtils;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;


/**
 * 短信模板内容管理
 * @author yeqh
 * 2013-12-09
 */

public class SmsTempContentSrvImpl implements ISmsTempContentSrv {
	
	private static Log logger = LogFactory.getLog(SmsTempContentSrvImpl.class);
	
	public ISmsTempContentDAO smsTempContentDAO;
	
	public void setSmsTempContentDAO(ISmsTempContentDAO smsTempContentDAO) {
		this.smsTempContentDAO = smsTempContentDAO;
	}

	/**
	 * 测试模板内容信息
	 * @param mobiles 测试手机号码
	 * @param contentID 内容ID
	 * @throws Exception
	 */
	public ResultBean TestTempContent(String mobiles, String contentID) throws Exception {
		SmsContentTestOutBizRegReq smsContentTestOut = smsTempContentDAO.TestTempContent(mobiles, contentID);
		ResultBean result = new ResultBean();
		result.setRejectReason(smsContentTestOut.getRejectReason());
		result.setErrorMsg(smsContentTestOut.getErrorMsg());
		return result;
	}

	/**
	 * 获取模板参数
	 * @param SRowNum 记录开始编号
	 * @param ERowNum 记录结束编号
	 * @throws Exception
	 */
	public List<SmsContentArgBean> getTempArg(int SRowNum, int ERowNum) throws Exception {
		SmsContentArgQueryOutBizRegReq smsContentArgQueryOut = smsTempContentDAO.getTempArg(SRowNum, ERowNum);
		List<SmsContentArgBean> smsContentArgList = new ArrayList<SmsContentArgBean>();
		int row = 0;
		SmsContentArgQueryOutArgList[] argList = smsContentArgQueryOut.getArgListArray();
		if(argList!=null && argList.length > 0){
			for(SmsContentArgQueryOutArgList arg : argList){					
				SmsContentArgBean argInfo = new SmsContentArgBean();
				argInfo.setRejectReason(smsContentArgQueryOut.getRejectReason());
				argInfo.setErrorMsg(smsContentArgQueryOut.getErrorMsg());
				argInfo.setRowsCount(++row);
				argInfo.setArgCode(arg.getArgCode());
				argInfo.setArgName(arg.getArgName());
				smsContentArgList.add(argInfo);
			}
		}
		return smsContentArgList;
	}

	/**
	 * 查询模板内容信息
	 * @param contentName 内容标题
	 * @param content 模板内容
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ISmsFormworkContentValue[] qryTempContent(String contentName, String content,String operType, int startIndex, int endIndex)
			throws Exception {
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		if(!StringUtil.isBlank(contentName)){
			contentName = SmsFormworkUtils.delUnderline(contentName);
			condition.append(" AND ").append(ISmsFormworkContentValue.S_ContentName).append(" LIKE :").append(ISmsFormworkContentValue.S_ContentName);
			parameter.put(ISmsFormworkContentValue.S_ContentName, "%"+ contentName + "%");
			condition.append("  ESCAPE '\\' ");
		}
		if(!StringUtil.isBlank(content)){
			content = SmsFormworkUtils.delUnderline(content);
			condition.append(" AND ").append(ISmsFormworkContentValue.S_ContentInfo).append(" LIKE :").append(ISmsFormworkContentValue.S_ContentInfo);
			parameter.put(ISmsFormworkContentValue.S_ContentInfo, "%"+ content + "%");
			condition.append("  ESCAPE '\\' ");
		}
		//查询出来的模板内容不包含被“删除”的记录 03表示删除
		condition.append(" AND IS_STOPPED <> '03'");
		condition.append(" ORDER BY OPERATE_TIME DESC ");
		logger.info("SmsTempContentSrvImpl qryTempContent's sql====>"+condition.toString());
		ISmsFormworkContentValue[] values = smsTempContentDAO.qryTempContent(condition.toString(), parameter, startIndex, endIndex);
		for(ISmsFormworkContentValue value:values){
			if(!StringUtil.isBlank(value.getOperatorCode())){
				value.setOperatorCode(SmsFormworkUtils.operCodeToName(value.getOperatorCode()));
			}
		}
		return fillHTMLOperationField(values,operType);
	}
	
	private ISmsFormworkContentValue[] fillHTMLOperationField(ISmsFormworkContentValue[] values,String operType){
		int i=0;
		for (ISmsFormworkContentValue value : values) {
			if(SmsFormworkConstant.SMS_FORMWORK_SHOW_METHOD.equals(operType)){
				value.setOper("<input type='radio' name='smsTempContentId' value='"+value.getContentId()+"' onclick='javascript:operIndex("+i+")'>");
			}else{
				value.setOper(" <a href=\"#\" onclick=\"updateRow('" + value.getContentId() + "')\" >修改</a>&nbsp;&nbsp; " +
						"<a href=\"#\" onclick=\"deleteRow('" + i + "')\" >删除</a>&nbsp;&nbsp;&nbsp;&nbsp;" +
						"<a href=\"#\" onclick=\"testRow('" + value.getContentId() + "')\" >测试</a>&nbsp;&nbsp;");
			}
			i++;
		}
		return values;
	}

	/**
	 * 根据条件查询模板内容信息列表数量
	 * @param contentName 内容标题
	 * @param content 模板内容
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public int qryTempContentCount(String contentName, String content) throws Exception {
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		if(!StringUtil.isBlank(contentName)){
			contentName = SmsFormworkUtils.delUnderline(contentName);
			condition.append(" AND ").append(ISmsFormworkContentValue.S_ContentName).append(" LIKE :").append(ISmsFormworkContentValue.S_ContentName);
			parameter.put(ISmsFormworkContentValue.S_ContentName, "%"+ contentName +"%");
			condition.append("  ESCAPE '\\' ");
		}
		if(!StringUtil.isBlank(content)){
			content = SmsFormworkUtils.delUnderline(content);
			condition.append(" AND ").append(ISmsFormworkContentValue.S_ContentInfo).append(" LIKE :").append(ISmsFormworkContentValue.S_ContentInfo);
			parameter.put(ISmsFormworkContentValue.S_ContentInfo, "%"+ content + "%");
			condition.append("  ESCAPE '\\' ");
		}
		//查询出来的模板内容不包含被“删除”的记录 03表示删除
		condition.append(" AND IS_STOPPED <> '03'");
		logger.info("SmsTempContentSrvImpl qryTempContentCount's sql====>"+condition.toString());
		
		return smsTempContentDAO.qryTempContentCount(condition.toString(), parameter);
	}

	/**
	 * 新增，修改，删除模板内容信息保存到数据库并调用 短信模板内容增量同步接口同步给HP
	 * @param value
	 * @param isModify
	 * @throws Exception
	 */
	public ResultBean saveSmsFormworkContent(ISmsFormworkContentValue value, String isModify) throws Exception {
		//业务锁服务
		ISysBusiLockInfoSrv busiLockInfoSrv = (ISysBusiLockInfoSrv)ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_SYS_BUSI_LOCK_SRV);
		//短信模板内容 与 2000 作为唯一主键   形成业务锁。2000暂为短信模板的业务码
		boolean locked = busiLockInfoSrv.gainBusiLock(value.getContentName(), "2000",-1);
		ResultBean result = new ResultBean();
		try {
            if(locked) {
            	//记录流水信息
        		String busiId = JDBCUtils.getValueNewId();
        		String operatorType = value.getIsStopped();
        		//获取操作时间
        		value.setOperateTime(DateTimeUtil.getNowTimeStamp());
        		if(SmsFormworkConstant.SMS_OPERATOR_TYPE_ADD.equals(operatorType)){
        			if(value.isNew() || StringUtil.isBlank(value.getContentId())){
        				if(!smsTempContentDAO.isCanAddSmsFormworkContent(value.getContentName())){
        					throw new MgtException("操作失败,内容标题已存在","操作失败,内容标题已存在"); 
        				}
        				value.setContentId(JDBCUtils.getValueNewId());
        				//设为新对象，防止value.isNew()为false
        				value.setStsToNew();
        			}else{
        				throw new MgtException("操作失败,数据在库中已经存在","操作失败,数据在库中已经存在"); 
        			}			
        		}else if(SmsFormworkConstant.SMS_OPERATOR_TYPE_UPDATE.equals(operatorType)){
        			if(StringUtil.isBlank(value.getContentId()) || value.isNew()){
        				throw new MgtException("操作失败,所修改模板的内容id不存在","操作失败,所修改模板的内容id不存在");
        			}
        			if(!smsTempContentDAO.isCanAddSmsFormworkContent(value.getContentName()) && "1".equals(isModify)){
        				throw new MgtException("操作失败,内容标题已存在","操作失败,内容标题已存在"); 
        			}
        			//修改模板内容之前先把原先的模板内容记录到流水表中
//        			IBusiSmsFormworkContentValue busiValueOld = new BusiSmsFormworkContentBean();
//        			ISmsFormworkContentValue valueOld = smsTempContentDAO.getSmsFormworkContentByContentID(value.getContentId());
//        			busiValueOld.setBusiId(busiId);
//        			busiValueOld.setBusiContentId(valueOld.getContentId());
//        			busiValueOld.setContentInfo(valueOld.getContentInfo());
//        			busiValueOld.setContentName(valueOld.getContentName());
//        			busiValueOld.setOper(valueOld.getOper());
//        			busiValueOld.setIsStopped(valueOld.getIsStopped());
//        			busiValueOld.setOperateTime(valueOld.getOperateTime());
//        			busiValueOld.setOperatorCode(valueOld.getOperatorCode());
//        			busiValueOld.setStsToNew();
//        			smsTempContentDAO.saveBusiSmsFormworkContent(busiValueOld);
        		}
        		
        		//判断操作类型是否是删除（新增的短信内容可删除，绑定短信模板后不可删除，需解除绑定关系才可删除。）
        		if(SmsFormworkConstant.SMS_OPERATOR_TYPE_DELETE.equals(operatorType)){
        			if(!smsTempContentDAO.isCanDelSmsFormworkContent(value.getContentId())){
        				throw new MgtException("操作失败,短信内容绑定了短信模板，需解除绑定关系才可删除","操作失败,短信内容绑定了短信模板，需解除绑定关系才可删除"); 
        			}
        		}
        		
        		//将当前修改的模板内容保存到流水表中
        		IBusiSmsFormworkContentValue busiValue = new BusiSmsFormworkContentBean();
        		busiValue.setBusiId(busiId);
        		busiValue.setBusiContentId(value.getContentId());
        		busiValue.setContentInfo(value.getContentInfo());
        		busiValue.setContentName(value.getContentName());
        		busiValue.setOper(value.getOper());
        		busiValue.setIsStopped(value.getIsStopped());
        		busiValue.setOperateTime(value.getOperateTime());
        		busiValue.setOperatorCode(value.getOperatorCode());
        		busiValue.setStsToNew();
        		smsTempContentDAO.saveBusiSmsFormworkContent(busiValue);
        		
        		//将模板内容信息数据保存到数据库中
        		smsTempContentDAO.saveSmsFormworkContent(value);
        		SynSmsTempContentInBizRegReq synSmsTempContentIn = SynSmsTempContentInter.getSynSmsTempContentInBean();
        		synSmsTempContentIn.setAmount(1);
        		//操作类型	01-新增；02-修改；03-删除
        		synSmsTempContentIn.setOperatorType(operatorType);
        		//操作人code
        		synSmsTempContentIn.setOperator(value.getOperatorCode());
        		//操作时间
        		synSmsTempContentIn.setOperateTime(DateTimeUtil.dateToString(value.getOperateTime(), SmsFormworkConstant.FORMWORK_DATE_FORMAT_HP));
        		//由于页面一次只能操作一个模板内容，所以contentList里面只有一个对象
        		SynSmsTempContentInContentList contentList = synSmsTempContentIn.addNewContentList();
        		contentList.setContentID(value.getContentId());
        		contentList.setContentName(value.getContentName());
        		contentList.setContent(value.getContentInfo());
        		SynSmsTempContentOutBizRegReq synSmsTempContentOut = SynSmsTempContentInter.doBusi(synSmsTempContentIn);
//        		if(!SmsFormworkConstant.HP_INTERFACE_SUCCESS.equals(synSmsTempContentOut.getRejectReason())){
//        			throw new MgtException("【E701】更新失败","【E701】更新失败"); 
//        		}
                String rejectReason = synSmsTempContentOut.getRejectReason();
                String resultString = synSmsTempContentOut.getErrorMsg();
                if(StringUtil.isBlank(resultString)){
                	throw new Exception("error_msg 节点错误，没有返回信息!"); 
                }
                if(StringUtil.isBlank(rejectReason)){
        			throw new MgtException("【9001】网络忙，请稍后再试","【9001】网络忙，请稍后再试"); 
        		}else{
        			if(!SmsFormworkConstant.HP_INTERFACE_SUCCESS.equals(rejectReason)){
        				throw new MgtException("【"+rejectReason+"】"+resultString,"【"+rejectReason+"】"+resultString); 
        			}
        		}
        		result.setRejectReason(synSmsTempContentOut.getRejectReason());
        		result.setErrorMsg(synSmsTempContentOut.getErrorMsg());
        		busiLockInfoSrv.releaseBusiLock(value.getContentName(), "2000");//解锁
            }
        }catch (MgtException e) {
        	e.printStackTrace();
        	if (locked) {
           		busiLockInfoSrv.releaseBusiLock(value.getContentName(), "2000");
           	}
        	throw new MgtException(e.getErrorCode(), e.getMessage());
		} catch (Exception e ) {
        	if (locked) {
           		busiLockInfoSrv.releaseBusiLock(value.getContentName(), "2000");
           	}
            logger.warn("The system is busy, please try again later!", e);
			throw new Exception(OrderConstant.RET_VALUE_Exception1, e);
        }
        return result;

	}
	
	/**
	 * 通过模板内容id获取模板内容信息
	 * @param contentId
	 * @return
	 * @throws Exception
	 */
	public ISmsFormworkContentValue getSmsFormworkContent(String contentId)throws Exception{
		return smsTempContentDAO.getSmsFormworkContentByContentID(contentId);
	}
	
	public String qryFormworkContentById(String smsContentId) throws Exception{
		ISmsFormworkContentValue value = this.getSmsFormworkContent(smsContentId);
		return value.getContentInfo();
	}

}
