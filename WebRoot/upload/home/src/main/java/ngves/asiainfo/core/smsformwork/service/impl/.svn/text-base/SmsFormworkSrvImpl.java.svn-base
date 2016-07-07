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
import ngves.asiainfo.core.smsformwork.bo.BusiSmsFormworkBean;
import ngves.asiainfo.core.smsformwork.bo.BusiSmsFormworkOccasionRltBean;
import ngves.asiainfo.core.smsformwork.bo.BusiSmsFormworkWareInfoRltBean;
import ngves.asiainfo.core.smsformwork.bo.SmsFormworkBean;
import ngves.asiainfo.core.smsformwork.bo.SmsFormworkOccasionRltBean;
import ngves.asiainfo.core.smsformwork.bo.SmsFormworkWareInfoRltBean;
import ngves.asiainfo.core.smsformwork.dao.interfaces.ISmsFormworkDAO;
import ngves.asiainfo.core.smsformwork.ivalues.IBusiSmsFormworkOccasionRltValue;
import ngves.asiainfo.core.smsformwork.ivalues.IBusiSmsFormworkValue;
import ngves.asiainfo.core.smsformwork.ivalues.IBusiSmsFormworkWareInfoRltValue;
import ngves.asiainfo.core.smsformwork.ivalues.ISmsFormworkContentValue;
import ngves.asiainfo.core.smsformwork.ivalues.ISmsFormworkOccasionRltValue;
import ngves.asiainfo.core.smsformwork.ivalues.ISmsFormworkValue;
import ngves.asiainfo.core.smsformwork.ivalues.ISmsFormworkWareInfoRltValue;
import ngves.asiainfo.core.smsformwork.model.SmsFormOccRltModel;
import ngves.asiainfo.core.smsformwork.model.SmsFormworkModel;
import ngves.asiainfo.core.smsformwork.model.wareFormworkRltModel;
import ngves.asiainfo.core.smsformwork.service.interfaces.ISmsFormworkSrv;
import ngves.asiainfo.core.smsformwork.util.SmsFormworkUtils;
import ngves.asiainfo.core.ware.ivalues.IWareInfoValue;
import ngves.asiainfo.interfaces.hp.ProvinceUtil;
import ngves.asiainfo.interfaces.hp.bean.synSmsFormwork.in.SynSmsFormworkInBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.synSmsFormwork.in.SynSmsFormworkInContentConfigList;
import ngves.asiainfo.interfaces.hp.bean.synSmsFormwork.in.SynSmsFormworkInProvinceList;
import ngves.asiainfo.interfaces.hp.bean.synSmsFormwork.in.SynSmsFormworkInSmsTemplateList;
import ngves.asiainfo.interfaces.hp.bean.synSmsFormwork.out.SynSmsFormworkOutBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.wareSmsTempConfig.in.WareSmsTempConfigInBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.wareSmsTempConfig.in.WareSmsTempConfigInSmsTConfigList;
import ngves.asiainfo.interfaces.hp.bean.wareSmsTempConfig.out.WareSmsTempConfigOutBizRegReq;
import ngves.asiainfo.interfaces.hp.realtime.SynSmsFormworkInter;
import ngves.asiainfo.interfaces.hp.realtime.WareSmsTempConfigInter;
import ngves.asiainfo.json.JsonUtil;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.JDBCUtils;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;


/**   
 * @author Fsr   
 * @version 1.0
 * 创建时间：2013-12-3 上午11:48:06  
 * 短信模板管理服务 
 */
public class SmsFormworkSrvImpl implements ISmsFormworkSrv {
	private static Log logger = LogFactory.getLog(SmsFormworkSrvImpl.class);
	
	public ISmsFormworkDAO smsFormworkDAO;

	public ISmsFormworkValue[] qrySmsFormworkList(String formworkName, String formworkState,String queryType, int startNum, int endNum)
			throws Exception {
		logger.info("qrySmsFormworkList --> the formworkName is " + formworkName + ",the formworkState is" + formworkState);
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String,String> parameter = new HashMap<String,String>();
		if (!StringUtil.isBlank(formworkName)) {//模板名称支持模糊查询
			formworkName = SmsFormworkUtils.delUnderline(formworkName);
			condition.append(" AND ").append(ISmsFormworkValue.S_FormworkName).append(" like :").append(ISmsFormworkValue.S_FormworkName);
			parameter.put(ISmsFormworkValue.S_FormworkName, "%"+formworkName+"%");
			condition.append("  ESCAPE '\\' ");
		}
		if (!StringUtil.isBlank(formworkState)) {
			if(!SmsFormworkConstant.QRY_ALL_INFO.equals(formworkState)){//初审页面默认为未执行所以不用考虑特殊处理
				condition.append(" AND ").append(ISmsFormworkValue.S_FormworkState).append(" =:").append(ISmsFormworkValue.S_FormworkState);
				parameter.put(ISmsFormworkValue.S_FormworkState, formworkState);
			}
		}
		condition.append(" AND ").append( ISmsFormworkValue.S_IsStopped).append(" = ").append(SmsFormworkConstant.SMS_FORMWORK_STATUS_USE);
		condition.append(" ORDER BY ").append(ISmsFormworkValue.S_OperateTime).append(" DESC ");
		ISmsFormworkValue[] values = smsFormworkDAO.qrySmsFormworkList(condition.toString(), parameter, startNum, endNum);
		for (ISmsFormworkValue value : values) {
			if(!StringUtil.isBlank(value.getOperatorCode())){
				value.setOperatorCode(SmsFormworkUtils.operCodeToName(value.getOperatorCode()));
			}
		}
		return fillHTMLOperationField(values,queryType);
	}

	public int qrySmsFormworkListCount(String formworkName, String formworkState) throws Exception {
		logger.info("qrySmsFormworkListCount --> the formworkName is " + formworkName + ",the formworkState is" + formworkState);
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String,String> parameter = new HashMap<String,String>();
		if (!StringUtil.isBlank(formworkName)) {//模板名称支持模糊查询
			formworkName = SmsFormworkUtils.delUnderline(formworkName);
			condition.append(" AND ").append(ISmsFormworkValue.S_FormworkName).append(" like :").append(ISmsFormworkValue.S_FormworkName);
			parameter.put(ISmsFormworkValue.S_FormworkName, "%"+formworkName+"%");
			condition.append("  ESCAPE '\\' ");
		}
		if (!StringUtil.isBlank(formworkState)) {
			if(!SmsFormworkConstant.QRY_ALL_INFO.equals(formworkState)){//初审页面默认为未执行所以不用考虑特殊处理
				condition.append(" AND ").append(ISmsFormworkValue.S_FormworkState).append(" =:").append(ISmsFormworkValue.S_FormworkState);
				parameter.put(ISmsFormworkValue.S_FormworkState, formworkState);
			}
		}
		condition.append(" AND ").append( ISmsFormworkValue.S_IsStopped).append(" = ").append(SmsFormworkConstant.SMS_FORMWORK_STATUS_USE);
		return smsFormworkDAO.qrySmsFormworkListCount(condition.toString(), parameter);
	}
	private ISmsFormworkValue[] fillHTMLOperationField(ISmsFormworkValue[] values,String queryType) throws Exception {
		int i=0;
		for (ISmsFormworkValue value : values) {
			if(SmsFormworkConstant.SMS_FORMWORK_SHOW_METHOD.equals(queryType)){
				value.setOper("<input type=\"radio\" name=\"formworkId\" value=\""+value.getFormworkId()+"\" onclick=\"javascript:operIndex("+i+")\">");
				i++;
			}else{
				value.setOper("<a href=\"#\" onclick=\"javascript:indexControl('EDIT','" + value.getFormworkId()
						+ "')\">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"#\" onclick=\"javascript:indexControl('DELETE','" + value.getFormworkId()
						+ "')\">删除</a>");
			}
		}
		return values;
	}
	
	public void deleteFormworkInfo(String formworkId) throws Exception{
		ISmsFormworkWareInfoRltValue[] values = smsFormworkDAO.qryFormworkWareinfoRltList(formworkId);
		if(values != null && values.length > 0){
			throw new Exception("error,rltvalues'length > 0 not delete!");
		}
		
		ISmsFormworkValue value = smsFormworkDAO.qryFormworkById(formworkId);
		value.setIsStopped(SmsFormworkConstant.SMS_FORMWORK_STATUS_NO_USE);//代表已删除
		this.smsFormworkDAO.saveSmsFormworkInfo(value);//保存信息
		
		String busiId = JDBCUtils.getValueNewId(); //获得一个唯一的流水id标识，记录一次操作记录
		
		IBusiSmsFormworkValue[] busiValues = new IBusiSmsFormworkValue[1];
		busiValues[0]= copyValue(value,busiId);//放入新增或者修改，删除后的新数据;
		this.smsFormworkDAO.savaBusiSmsFormworkInfo(busiValues);//保存模板的流水信息
		
		ISmsFormworkOccasionRltValue[] rltValues =  smsFormworkDAO.qryFormworkOccasionRltInfo(formworkId,"");
		List<IBusiSmsFormworkOccasionRltValue> busiFormOccaList = new ArrayList<IBusiSmsFormworkOccasionRltValue>();//记录模板时机关系的流水记录
		for(ISmsFormworkOccasionRltValue rltValue : rltValues){
			busiFormOccaList.add(copyValue(rltValue,busiId));
		}		
		IBusiSmsFormworkOccasionRltValue[] busiRltValues = new  IBusiSmsFormworkOccasionRltValue[busiFormOccaList.size()];
		busiRltValues = busiFormOccaList.toArray(busiRltValues);
		smsFormworkDAO.savaBusiFormOccRlt(busiRltValues);//保存关系的流水信息
		
		String operType = SmsFormworkConstant.SMS_OPERATOR_TYPE_DELETE;//删除
		sendForworkOccasionRltInfoToHp(value,rltValues,operType);//同步HP信息
		
	}
	
	public ISmsFormworkValue qrySmsFormworkById(String formworkId) throws Exception{
		if(!StringUtils.isBlank(formworkId))
			return smsFormworkDAO.qryFormworkById(formworkId);
		return null;
	}
	
	/**
	 * 礼品绑定模板，如果礼品为子礼品，也要把其他相关的子礼品也要绑定。
	 */
	public void bindFormworkInfo(String formworkId,String josnStr,String operCode) throws Exception{
		ISmsFormworkValue[] smsFormworkValues = smsFormworkDAO.qrySmsFormworkInfo(formworkId);
		if(smsFormworkValues == null || smsFormworkValues.length <= 0){
			throw new MgtException("此模板已不存在，不能被绑定！","此模板已不存在，不能被绑定！");
		}
		ISmsFormworkWareInfoRltValue value = null;
		List<wareFormworkRltModel> modelList = JsonUtil.jsonToList(josnStr, wareFormworkRltModel.class);//转为list
		List<wareFormworkRltModel> list = new ArrayList<wareFormworkRltModel>();//存入相关所有礼品的model（包括相关的父子礼品）
		
		//***查询所有相关的礼品绑定模板（如果是子礼品，就查询所有相关的子礼品）
		IWareInfoValue[] wareValues = null;
		wareFormworkRltModel model;
		List<String> wareList = new ArrayList<String>();//为了去重使用（可以批量绑定，如果选择两个相关的子礼品同时绑定的话，就需要去重）
		for(int i=0 ;i<modelList.size();i++){
			if(SmsFormworkConstant.FORMWORK_COMMON_ACTION_CODE.equals(modelList.get(i).getActionType())){
				//只有普通类型需要查询所有子礼品
				wareValues = smsFormworkDAO.qryCWareInfosById(modelList.get(i).getWareCode());//查询所有子礼品
			}
			if(wareValues!=null && wareValues.length>0){//表示是子礼品
				for(IWareInfoValue wareValue : wareValues){
					if(!wareList.contains(wareValue.getWareCode())){ //如果包含就不需要在进行循环
						model = new wareFormworkRltModel();
						model.setActionId(modelList.get(i).getActionId());
						model.setActionType(modelList.get(i).getActionType());
						model.setWareCode(wareValue.getWareCode());
						list.add(model);
						wareList.add(wareValue.getWareCode());
					}
				}
			}else{//表示为普通礼品或者活动礼品
				list.add(modelList.get(i));
			}
		}
		//*************************************************************8
		
		ISmsFormworkWareInfoRltValue[] values = new ISmsFormworkWareInfoRltValue[list.size()];//用于保存数据用
		ISmsFormworkWareInfoRltValue[] rltValues;
		
		String busiId = JDBCUtils.getValueNewId();//获得一个唯一的流水id标识，记录一次操作记录
		List<IBusiSmsFormworkWareInfoRltValue> busiList = new ArrayList<IBusiSmsFormworkWareInfoRltValue>();//用于存放流水记录
		
		String dateTime = DateTimeUtil.dateToString(DateTimeUtil.getNowDate(), SmsFormworkConstant.FORMWORK_DATE_FORMAT_LONG);
		for(int i = 0;i<list.size();i++){
			rltValues = smsFormworkDAO.qryFormworkWareRlt(list.get(i).getWareCode(),list.get(i).getActionId(),list.get(i).getActionType());
			if(rltValues.length > 0){//查询是否存在相同活动类型活动id下的关系，如果存在就更新
				//busiList.add(copyValue(rltValues[0],busiId));//记录修改前的旧值。
				
				rltValues[0].setFormworkId(formworkId);
				rltValues[0].setOperatorCode(operCode);
				rltValues[0].setOperateTime(DateTimeUtil.stringToTimestamp(dateTime,SmsFormworkConstant.FORMWORK_DATE_FORMAT_LONG));
				values[i] = rltValues[0];
				
				busiList.add(copyValue(rltValues[0],busiId));//记录修改后的值
			}else{
				value = new SmsFormworkWareInfoRltBean();
				value.setRltId(JDBCUtils.getValueNewId());
				value.setFormworkId(formworkId);
				value.setWareCode(list.get(i).getWareCode());
				value.setActionId(list.get(i).getActionId());
				value.setActionType(list.get(i).getActionType());
				value.setOperatorCode(operCode);
				value.setOperateTime(DateTimeUtil.stringToTimestamp(dateTime,SmsFormworkConstant.FORMWORK_DATE_FORMAT_LONG));
				values[i] = value;
				
				busiList.add(copyValue(value,busiId));//记录新增的记录
			}
		}
		
		IBusiSmsFormworkWareInfoRltValue[] busiRltValues = new IBusiSmsFormworkWareInfoRltValue[busiList.size()];
		busiRltValues = busiList.toArray(busiRltValues);//list 与 数组转化
		smsFormworkDAO.saveBusiFormworkWareRlt(busiRltValues);//保存流水记录
		
		smsFormworkDAO.saveFormworkWareRlt(values);//保存新增修改记录
		
		sendWareForworkRltInfoToHp(values,operCode);//同步hp礼品绑定模板最新信息
	}
	
	/**
	 * 数值转换到流水IBusiSmsFormworkWareInfoRltValue里
	 * @param value
	 * @param busiId
	 * @return
	 * @throws Exception
	 */
	public IBusiSmsFormworkWareInfoRltValue copyValue(ISmsFormworkWareInfoRltValue value,String busiId) throws Exception{
		IBusiSmsFormworkWareInfoRltValue busiValue = null;//记录流水关系
		busiValue = new BusiSmsFormworkWareInfoRltBean();
		busiValue.setBusiId(busiId);
		busiValue.setActionId(value.getActionId());
		busiValue.setActionType(value.getActionType());
		busiValue.setBusiRltId(value.getRltId());
		busiValue.setFormworkId(value.getFormworkId());
		busiValue.setOperateTime(value.getOperateTime());
		busiValue.setOperatorCode(value.getOperatorCode());
		busiValue.setWareCode(value.getWareCode());
		return busiValue;
	}
	
	/**
	 * 礼品短信模板配置增量同步
	 * 
	 * 活动编码:ActionID
	 * 对于普通兑换默认填写000；
	 * 对于打折活动填写：00+打折活动ID；
	 * 对于抢兑活动填写：01+抢兑活动ID；
	 * 对于团兑活动填写：02+团兑活动ID；
	 * 对于捐赠活动填写：03+捐赠活动ID；
	 * 对于优惠活动填写：04+优惠活动ID；
	 * 对于转赠活动填写：05+转赠活动ID；
	 * @param values
	 * @param operCode
	 * @throws Exception
	 */
	public void sendWareForworkRltInfoToHp(ISmsFormworkWareInfoRltValue[] values,String operCode) throws Exception{
		WareSmsTempConfigInBizRegReq in = WareSmsTempConfigInter.getWareSmsTempConfigInter();
		in.setAmount(values.length);
		in.setOperateTime(DateTimeUtil.dateToString(DateTimeUtil.getNowDate(), SmsFormworkConstant.FORMWORK_DATE_FORMAT_HP));
		in.setOperator(operCode);
		for(ISmsFormworkWareInfoRltValue value : values){
			WareSmsTempConfigInSmsTConfigList list = in.addNewSmsTConfigList();
			list.setActionType(value.getActionType());
			if(SmsFormworkConstant.FORMWORK_COMMON_ACTION_CODE.equals(value.getActionType())){
				list.setActionID(value.getActionId());
			}else if(SmsFormworkConstant.FORMWORK_DONATION_ACTION_CODE.equals(value.getActionType())){
				list.setActionID(value.getActionId());//转赠发送050 actionId
			}else{
				list.setActionID(""+value.getActionType()+value.getActionId());
			}
			list.setItemID(value.getWareCode());
			list.setSmsTConfigID(value.getRltId());
			list.setSmsTemplateID(value.getFormworkId());
		}
		WareSmsTempConfigOutBizRegReq out = WareSmsTempConfigInter.doBusi(in);
		String rejectReason=out.getRejectReason();
		String resultString  = out.getErrorMsg();
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
	}
	
	public String qryFormworkOccasionRltInfo(String formworkId,String occasionTypeId) throws Exception{
		ISmsFormworkOccasionRltValue[] values = smsFormworkDAO.qryFormworkOccasionRltInfo(formworkId,occasionTypeId);
		SmsFormOccRltModel model = null;
		List<SmsFormOccRltModel> list = new ArrayList<SmsFormOccRltModel>();
		for(ISmsFormworkOccasionRltValue value : values){
			model = new SmsFormOccRltModel();
			model = model.copy(value);
			list.add(model);
		}
		return JsonUtil.toJson(list);
	}
	
	/**
	 * 数值转换到流水IBusiSmsFormworkValue里
	 * @param value
	 * @param busiId
	 * @return
	 * @throws Exception
	 */
	public IBusiSmsFormworkValue copyValue(ISmsFormworkValue value,String busiId) throws Exception{
		IBusiSmsFormworkValue busiValue = new BusiSmsFormworkBean();//用于存放旧的记录
		busiValue.setBusiId(busiId);
		busiValue.setBusiFormworkId(value.getFormworkId());
		busiValue.setFormworkName(value.getFormworkName());
		busiValue.setFormworkState(value.getFormworkState());//发送还是不发送0-发送;1-不发送
		busiValue.setOperateTime(value.getOperateTime());
		busiValue.setOperatorCode(value.getOperatorCode());//操作人编号
		busiValue.setSendProvince(value.getSendProvince());
		busiValue.setIsStopped(value.getIsStopped());//修改或新增
		return busiValue;
	}
	
	/**
	 * 数值转换到流水IBusiSmsFormworkOccasionRltValue里
	 * @param value
	 * @param busiId
	 * @return
	 * @throws Exception
	 */
	public IBusiSmsFormworkOccasionRltValue copyValue(ISmsFormworkOccasionRltValue value,String busiId) throws Exception{
		IBusiSmsFormworkOccasionRltValue busiValue = new BusiSmsFormworkOccasionRltBean();
		busiValue.setBusiId(busiId);
		busiValue.setBusiRltId(value.getRltId());
		busiValue.setContentId(value.getContentId());
		busiValue.setContentName(value.getContentName());
		busiValue.setEndTime(value.getEndTime());
		busiValue.setFormworkId(value.getFormworkId());
		busiValue.setIsSend(value.getIsSend());//发送还是不发送0-发送;1-不发送
		busiValue.setOccasionId(value.getOccasionId());
		busiValue.setOccasionTypeId(value.getOccasionTypeId());
		busiValue.setStartTime(value.getStartTime());
		return busiValue;
	}
	
	public void saveInfo(String infoJson,String rltInfoJson,String operCode) throws Exception{
		SmsFormworkModel formWorkModel = JsonUtil.jsonToBean(infoJson, SmsFormworkModel.class);
		//业务锁服务
		ISysBusiLockInfoSrv busiLockInfoSrv = (ISysBusiLockInfoSrv)ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_SYS_BUSI_LOCK_SRV);
		//模板名称 与 2001 作为唯一主键   形成业务锁。2001暂为短信模板管理的业务码
		boolean locked = busiLockInfoSrv.gainBusiLock(formWorkModel.getFormworkName(), "2001",-1);
		try {
            if(locked) {
            	List<SmsFormOccRltModel> list = JsonUtil.jsonToList(rltInfoJson, SmsFormOccRltModel.class);
        		String dateTime = DateTimeUtil.dateToString(DateTimeUtil.getNowDate(), SmsFormworkConstant.FORMWORK_DATE_FORMAT_LONG);
        		String operType = SmsFormworkConstant.SMS_OPERATOR_TYPE_ADD;//初始值为新增	
        		ISmsFormworkValue value = new SmsFormworkBean();//新增或修改的
        		
        		String busiId = JDBCUtils.getValueNewId(); //获得一个唯一的流水id标识，记录一次操作记录
        		List<IBusiSmsFormworkValue> busiFormList = new ArrayList<IBusiSmsFormworkValue>();//记录模板流水记录
        		
        		if(StringUtil.isBlank(formWorkModel.getFormworkId())){
        			formWorkModel.setFormworkId(JDBCUtils.getValueNewId());//生成新主键
        			value.setStsToNew();
        		}else{
        			ISmsFormworkValue oldValue = smsFormworkDAO.qryFormworkById(formWorkModel.getFormworkId());//查询旧数据
        			//busiFormList.add(copyValue(oldValue,busiId));//将旧数据放入流水list中
        			
        			operType = SmsFormworkConstant.SMS_OPERATOR_TYPE_UPDATE;//修改
        			value = oldValue;
        		}
        		value.setFormworkId(formWorkModel.getFormworkId());
        		value.setFormworkName(formWorkModel.getFormworkName());
        		value.setFormworkState(formWorkModel.getFormworkState());//发送还是不发送0-发送;1-不发送
        		value.setOperateTime(DateTimeUtil.stringToTimestamp(dateTime,SmsFormworkConstant.FORMWORK_DATE_FORMAT_LONG));
        		value.setOperatorCode(operCode);//操作人编号
        		value.setSendProvince(formWorkModel.getSendProvince());
        		value.setIsStopped(SmsFormworkConstant.SMS_FORMWORK_STATUS_USE);//修改或新增
        		this.smsFormworkDAO.saveSmsFormworkInfo(value);//保存模板信息
        		
        		busiFormList.add(copyValue(value,busiId));//放入新增或者修改后的新数据
        		IBusiSmsFormworkValue[] busiValues = new IBusiSmsFormworkValue[busiFormList.size()];
        		busiValues = busiFormList.toArray(busiValues);
        		this.smsFormworkDAO.savaBusiSmsFormworkInfo(busiValues);//保存模板的流水信息
        		
        		
        		ISmsFormworkOccasionRltValue rltValue = null;
        		ISmsFormworkOccasionRltValue[] rltValues = new ISmsFormworkOccasionRltValue[list.size()];
        		List<IBusiSmsFormworkOccasionRltValue> busiFormOccaList = new ArrayList<IBusiSmsFormworkOccasionRltValue>();//记录模板时机关系的流水记录
        		
        		ISmsFormworkOccasionRltValue[] oldRltValues =  smsFormworkDAO.qryFormworkOccasionRltInfo(formWorkModel.getFormworkId(),"");
        		for(ISmsFormworkOccasionRltValue oldRltValue : oldRltValues){
        			oldRltValue.delete();
        		}
        		smsFormworkDAO.saveFormOccRlt(oldRltValues);//删除模板关联的旧的关系信息
        		
        		int i=0;
        		ISmsFormworkContentValue[] ismsContentValues = null;
        		
        		for(;i<list.size();i++){
        			SmsFormOccRltModel rltModel = list.get(i);
        			ismsContentValues = smsFormworkDAO.qryTempContent(rltModel.getContentId());//判断内容id是否存在
        			if(ismsContentValues == null || ismsContentValues.length <= 0){
        				throw new MgtException("模板内容【"+rltModel.getContentName()+"】已不存在，请修改！","模板内容【"+rltModel.getContentName()+"】已不存在，请修改！");
        			}
        			rltValue = new SmsFormworkOccasionRltBean();
        			if(StringUtil.isBlank(rltModel.getRltId())){
        				rltModel.setRltId(JDBCUtils.getValueNewId());//生成新主键
        			}
//        			else{
//        				ISmsFormworkOccasionRltValue oldRltValue =  smsFormworkDAO.qryFormworkOccasionRltInfo(rltModel.getRltId());
//        				//busiFormOccaList.add(copyValue(oldRltValue,busiId));
//        				rltValue = oldRltValue;
//        			}
        			rltValue.setStsToNew();
        			rltValue.setRltId(rltModel.getRltId());
        			rltValue.setContentId(rltModel.getContentId());
        			rltValue.setContentName(rltModel.getContentName());
        			rltValue.setEndTime(rltModel.getEndTime());
        			rltValue.setFormworkId(formWorkModel.getFormworkId());
        			rltValue.setIsSend(rltModel.getIsSend());//发送还是不发送0-发送;1-不发送
        			rltValue.setOccasionId(rltModel.getOccasionId());
        			rltValue.setOccasionTypeId(rltModel.getOccasionTypeId());
        			rltValue.setStartTime(rltModel.getStartTime());
        			rltValues[i] = rltValue;
        			busiFormOccaList.add(copyValue(rltValue,busiId));
        		}
        		smsFormworkDAO.saveFormOccRlt(rltValues);//保存关系信息
        		
        		IBusiSmsFormworkOccasionRltValue[] busiRltValues = new  IBusiSmsFormworkOccasionRltValue[busiFormOccaList.size()];
        		busiRltValues = busiFormOccaList.toArray(busiRltValues);
        		smsFormworkDAO.savaBusiFormOccRlt(busiRltValues);//保存关系的流水信息
        		
        		sendForworkOccasionRltInfoToHp(value,rltValues,operType);//同步HP信息
        		busiLockInfoSrv.releaseBusiLock(formWorkModel.getFormworkName(), "2001");//解锁
            }
		}catch (MgtException e) {
			if (locked) {
	       		busiLockInfoSrv.releaseBusiLock(formWorkModel.getFormworkName(), "2001");
	       	}
        	e.printStackTrace();
        	throw new MgtException(e.getErrorCode(), e.getMessage());
		}catch (Exception e ) {
			if (locked) {
	       		busiLockInfoSrv.releaseBusiLock(formWorkModel.getFormworkName(), "2001");
	       	}
            logger.warn("The system is busy, please try again later!", e);
			throw new Exception(OrderConstant.RET_VALUE_Exception1, e);
	    }
	}
	/**
	 * 4.6.8. 短信模板增量同步接口
	 * @param value 模板信息
	 * @param rltValues 时机关系信息
	 * @param operType   操作类型	01-新增；02-修改；03-删除
	 */
	public void sendForworkOccasionRltInfoToHp(ISmsFormworkValue value,ISmsFormworkOccasionRltValue[] rltValues,String operType) throws Exception{
		SynSmsFormworkInBizRegReq in = SynSmsFormworkInter.getSynSmsOccasionInBean();
		in.setOperatorType(operType);
		in.setAmount(1);//新增和修改只是对一个模板进行操作
		in.setOperator(value.getOperatorCode());
		in.setOperateTime(DateTimeUtil.dateToString(value.getOperateTime(), SmsFormworkConstant.FORMWORK_DATE_FORMAT_HP));
		SynSmsFormworkInSmsTemplateList list = in.addNewSmsTemplateList();
		list.setSmsTemplateID(value.getFormworkId());
		list.setSmsTemplateName(value.getFormworkName());
		list.setSmsTemplateStatus(value.getFormworkState());//0-发送;1-不发送
		for(ISmsFormworkOccasionRltValue rltValue : rltValues){
			SynSmsFormworkInContentConfigList contentList = list.addNewContentConfigList();
			contentList.setContentConfigID(rltValue.getRltId());
			contentList.setOccasion(rltValue.getOccasionId());
			contentList.setContentID(rltValue.getContentId());
			contentList.setStatus(rltValue.getIsSend());//0-发送;1-不发送
			contentList.setLimitStime(Integer.parseInt(rltValue.getStartTime()));
			contentList.setLimitEtime(Integer.parseInt(rltValue.getEndTime()));
		}
		String[] provinceCodes = ProvinceUtil.aiProvinceCodes;
		String provincesStr = value.getSendProvince();
		for(int i=0;i<provinceCodes.length;i++){
			SynSmsFormworkInProvinceList provinceList = list.addNewProvinceList();
			provinceList.setProvince(ProvinceUtil.toHpProvince(provinceCodes[i]));
			if(StringUtil.isBlank(provincesStr) || provincesStr.indexOf(provinceCodes[i]) < 0){
				provinceList.setStatus(SmsFormworkConstant.SMS_FORMWORK_PROVINCE_NOT_SEND);
			}else{
				provinceList.setStatus(SmsFormworkConstant.SMS_FORMWORK_PROVINCE_IS_SEND);
			}
		}
		SynSmsFormworkOutBizRegReq out = SynSmsFormworkInter.doBusi(in);
		String rejectReason=out.getRejectReason();
		String resultString  = out.getErrorMsg();
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
	}
	
	
	public boolean isExistSameName(String formworkName) throws Exception{
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String,String> parameter = new HashMap<String,String>();
		if (!StringUtil.isBlank(formworkName)) {//模板名称
			condition.append(" AND ").append(ISmsFormworkValue.S_FormworkName).append(" = :").append(ISmsFormworkValue.S_FormworkName);
			parameter.put(ISmsFormworkValue.S_FormworkName, formworkName);
		}
		condition.append(" AND ").append( ISmsFormworkValue.S_IsStopped).append(" = ").append(SmsFormworkConstant.SMS_FORMWORK_STATUS_USE);
		int count =  smsFormworkDAO.qrySmsFormworkListCount(condition.toString(), parameter);
		if (count == 0)
			return false;
		return true;
	}
	
	public ISmsFormworkDAO getSmsFormworkDAO() {
		return smsFormworkDAO;
	}

	public void setSmsFormworkDAO(ISmsFormworkDAO smsFormworkDAO) {
		this.smsFormworkDAO = smsFormworkDAO;
	}
	

}
