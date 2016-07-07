package ngves.asiainfo.core.smsformwork.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.common.model.SysPara;
import ngves.asiainfo.core.common.service.interfaces.ISysBusiLockInfoSrv;
import ngves.asiainfo.core.donated.exception.MgtException;
import ngves.asiainfo.core.order.OrderConstant;
import ngves.asiainfo.core.smsformwork.SmsFormworkConstant;
import ngves.asiainfo.core.smsformwork.dao.interfaces.ISmsOccasionDAO;
import ngves.asiainfo.core.smsformwork.ivalues.ISmsOccasionInfoValue;
import ngves.asiainfo.core.smsformwork.ivalues.ISmsOccasionTypeInfoValue;
import ngves.asiainfo.core.smsformwork.model.ResultBean;
import ngves.asiainfo.core.smsformwork.model.SmsOccasionModel;
import ngves.asiainfo.core.smsformwork.service.interfaces.ISmsOccasionSrv;
import ngves.asiainfo.core.smsformwork.util.SmsFormworkUtils;
import ngves.asiainfo.interfaces.hp.bean.synSmsOccasion.in.SynSmsOccasionInBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.synSmsOccasion.in.SynSmsOccasionInOccasionList;
import ngves.asiainfo.interfaces.hp.bean.synSmsOccasion.out.SynSmsOccasionOutBizRegReq;
import ngves.asiainfo.interfaces.hp.realtime.SynSmsOccasionInter;
import ngves.asiainfo.json.JsonUtil;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;


/**
 * 短信发送时机管理
 * @author yeqh
 * 2013-12-02
 */

@SuppressWarnings("unchecked")
public class SmsOccasionSrvImpl implements ISmsOccasionSrv {
	
	private static Log logger = LogFactory.getLog(SmsOccasionSrvImpl.class);
	
	public ISmsOccasionDAO smsOccasionDAO;
	
	public void setSmsOccasionDAO(ISmsOccasionDAO smsOccasionDAO) {
		this.smsOccasionDAO = smsOccasionDAO;
	}

	/**
	 * 根据发送时机名称（occasionDesc），订单状态（orderStatus）发送时机类型（occasionTypeId），获取发送时机信息列表
	 */
	public ISmsOccasionInfoValue[] getSmsOccasionList(String occasionDesc, String orderStatus, String occasionTypeId, int startIndex, int endIndex) throws Exception {
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		if(!StringUtil.isBlank(occasionDesc)){
			occasionDesc = SmsFormworkUtils.delUnderline(occasionDesc);
			condition.append(" AND ").append(ISmsOccasionInfoValue.S_OccasionName).append(" LIKE :").append(ISmsOccasionInfoValue.S_OccasionName);
			parameter.put(ISmsOccasionInfoValue.S_OccasionName, "%" + occasionDesc + "%");
			condition.append("  ESCAPE '\\' ");
		}
		if(!StringUtil.isBlank(orderStatus) && !SmsFormworkConstant.QRY_ALL_INFO.equals(orderStatus)){
			condition.append(" AND ").append(ISmsOccasionInfoValue.S_OrderState).append(" = :").append(ISmsOccasionInfoValue.S_OrderState);
			parameter.put(ISmsOccasionInfoValue.S_OrderState, orderStatus);
		}
		if(!StringUtil.isBlank(occasionTypeId) && !SmsFormworkConstant.QRY_ALL_INFO.equals(occasionTypeId)){
			condition.append(" AND ").append(ISmsOccasionInfoValue.S_OccasionTypeId).append(" = :").append(ISmsOccasionInfoValue.S_OccasionTypeId);
			parameter.put(ISmsOccasionInfoValue.S_OccasionTypeId, occasionTypeId);
		}
		condition.append(" ORDER BY OCCASION_TYPE_ID DESC");
		
		logger.info("SmsOccasionSrvImpl 中getSmsOccasionList sql:"+condition.toString());
		ISmsOccasionInfoValue[] values = smsOccasionDAO.getSmsOccasionList(condition.toString(), parameter, startIndex, endIndex);
		
		for (ISmsOccasionInfoValue value : values) {
			if(!StringUtil.isBlank(value.getOperatorCode())){
				value.setOperatorCode(SmsFormworkUtils.operCodeToName(value.getOperatorCode()));
			}
		}
		return values;
	}

	/**
	 * 保存发送时机信息到数据库中,并调用短信发送时机增量同步接口(AI->HP)
	 */
	public ResultBean saveSmsOccasionInfo(ISmsOccasionInfoValue value) throws Exception {
		//业务锁服务
		ISysBusiLockInfoSrv busiLockInfoSrv = (ISysBusiLockInfoSrv)ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_SYS_BUSI_LOCK_SRV);
		//发送时机说明 与 2000 作为唯一主键   形成业务锁。2002暂为短信模板的业务码
		boolean locked = busiLockInfoSrv.gainBusiLock(value.getOccasionName(), "2002",-1);
		ResultBean result = new ResultBean();
		try {
            if(locked) {
            	//获取操作时间
        		value.setOperateTime(DateTimeUtil.getNowTimeStamp());
        		//判断短信发送时机说明是否能被修改
        		if(!smsOccasionDAO.isCanModifySmsOccasionInfo(value.getOccasionName(),value.getOccasionTypeId())){
        			throw new MgtException("操作失败,短信发送时机说明,在该发送时机类型中已存在","操作失败,短信发送时机说明,在该发送时机类型中已存在"); 
        		}
        		
        		//将模板内容信息数据保存到数据库中
        		smsOccasionDAO.saveSmsOccasionInfo(value);
        		
        		//将修改之后的发送时机信息推送给HP
                SynSmsOccasionInBizRegReq synSmsOccasionIn = SynSmsOccasionInter.getSynSmsOccasionInBean();
                synSmsOccasionIn.setAmount(1);
                synSmsOccasionIn.setOperator(value.getOperatorCode()); //操作人code
                synSmsOccasionIn.setOperateTime(DateTimeUtil.dateToString(value.getOperateTime(), SmsFormworkConstant.FORMWORK_DATE_FORMAT_HP)); //操作时间
                SynSmsOccasionInOccasionList occasionList = synSmsOccasionIn.addNewOccasionList();
                occasionList.setOccasion(value.getOccasionId()); //发送时机标识
                occasionList.setOccasionDesc(value.getOccasionName()); //发送时机标题
                //将发送时机类型发送给HP
                occasionList.setOccasionType(getSmsOccasionTypeInfo(value.getOccasionTypeId()).getOccasionTypeCode()); 
                occasionList.setOrderStatus(value.getOrderState()); //订单状态
                occasionList.setLimitStime(Integer.parseInt(value.getStartTime())); //开始生效时间
                occasionList.setLimitEtime(Integer.parseInt(value.getEndTime())); //结束生效时间
                
                SynSmsOccasionOutBizRegReq synSmsOccasionOut = SynSmsOccasionInter.doBusi(synSmsOccasionIn);
                String rejectReason = synSmsOccasionOut.getRejectReason();
                String resultString = synSmsOccasionOut.getErrorMsg();
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
//        		if(!SmsFormworkConstant.HP_INTERFACE_SUCCESS.equals(synSmsOccasionOut.getRejectReason())){
//        			throw new MgtException("【E601】更新失败","【E601】更新失败"); 
//        		}
        		
        		result.setRejectReason(synSmsOccasionOut.getRejectReason());
        		result.setErrorMsg(synSmsOccasionOut.getErrorMsg());
        		busiLockInfoSrv.releaseBusiLock(value.getOccasionName(), "2002");//解锁
            }
        }catch (MgtException e) {
        	e.printStackTrace();
        	if (locked) {
           		busiLockInfoSrv.releaseBusiLock(value.getOccasionName(), "2002");
           	}
        	throw new MgtException(e.getErrorCode(), e.getMessage());
		}catch (Exception e ) {
        	if (locked) {
           		busiLockInfoSrv.releaseBusiLock(value.getOccasionName(), "2002");
           	}
            logger.warn("The system is busy, please try again later!", e);
			throw new Exception(OrderConstant.RET_VALUE_Exception1, e);
        }
		return result;
	}
	
	/**
	 * 根据发送时机名称（occasionDesc），订单状态（orderStatus）发送时机类型（occasionTypeId）获取发送时机信息数量
	 */
	public int getSmsOccasionListCount(String occasionDesc, String occasionTypeId, String orderStatus) throws Exception {
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		if(!StringUtil.isBlank(occasionDesc)){
			occasionDesc = SmsFormworkUtils.delUnderline(occasionDesc);
			condition.append(" AND ").append(ISmsOccasionInfoValue.S_OccasionName).append(" LIKE :").append(ISmsOccasionInfoValue.S_OccasionName);
			parameter.put(ISmsOccasionInfoValue.S_OccasionName, "%" + occasionDesc + "%");
			condition.append("  ESCAPE '\\' \n");
		}
		if(!StringUtil.isBlank(orderStatus) && !SmsFormworkConstant.QRY_ALL_INFO.equals(orderStatus)){
			condition.append(" AND ").append(ISmsOccasionInfoValue.S_OrderState).append(" = :").append(ISmsOccasionInfoValue.S_OrderState);
			parameter.put(ISmsOccasionInfoValue.S_OrderState, orderStatus);
		}
		if(!StringUtil.isBlank(occasionTypeId) && !SmsFormworkConstant.QRY_ALL_INFO.equals(occasionTypeId)){
			condition.append(" AND ").append(ISmsOccasionInfoValue.S_OccasionTypeId).append(" = :").append(ISmsOccasionInfoValue.S_OccasionTypeId);
			parameter.put(ISmsOccasionInfoValue.S_OccasionTypeId, occasionTypeId);
		}
		
		logger.info("SmsOccasionSrvImpl getSmsOccasionListCount sql:"+condition.toString());
		
		int num = smsOccasionDAO.getSmsOccasionInfoCount(condition.toString(), parameter);
		return num;
	}
	
	/**
	 * 通过时机code获取发送时机信息
	 */
	public ISmsOccasionInfoValue getSmsOccasionInfoById(String occasionId) throws Exception {
		return smsOccasionDAO.getSmsOccasionInfoById(occasionId);
	}
	
	/**
	 * 通过时机类型id获取发送时机信息
	 * @param occasionTypeId
	 * @return
	 * @throws Exception
	 */
	public String getSmsOccasionInfoJsonByTypeId(String occasionTypeId) throws Exception{
		ISmsOccasionInfoValue[] values = smsOccasionDAO.getSmsOccasionInfoByTypeId(occasionTypeId);
		SmsOccasionModel model = null;
		List<SmsOccasionModel> list = new ArrayList<SmsOccasionModel>();
		for(ISmsOccasionInfoValue value : values){
			model = new SmsOccasionModel();
			model = model.copy(value);
			list.add(model);
		}
		return JsonUtil.toJson(list);
	}
	
	/**
	 * 获取发送时机类型
	 */
	public List<SysPara> getSmsOccionTypeJson() throws Exception {
		ISmsOccasionTypeInfoValue[] values = smsOccasionDAO.getSmsOccionTypeList();
		List<SysPara> paras = new ArrayList<SysPara>();
		SysPara sp = null;
		if (values != null && values.length > 0) {
			for (int i = 0; i < values.length; i++) {
				sp = new SysPara();
				sp.setValue(values[i].getOccasionTypeId());
				sp.setText(values[i].getOccasionTypeName());
				paras.add(sp);
				sp = null;
			}
		}
		return paras;
	}
	
	/**
	 * 保存HP发送过来的发送时机信息
	 */
	public void saveBatchSmsOccasionInfo(ISmsOccasionInfoValue[] smsOccasionInfos)throws Exception {
		//由于HP那边存的是发送时机类型code，而数据库表中存的是发送时机的类型标识。所以需要做转换处理,变成标识存入库里
		for(ISmsOccasionInfoValue smsOccasionInfo:smsOccasionInfos){
			smsOccasionInfo.setOccasionTypeId(getSmsOccasionTypeInfoByCode(smsOccasionInfo.getOccasionTypeId()).getOccasionTypeId());
		}
		smsOccasionDAO.saveBatchSmsOccasionInfo(smsOccasionInfos);
	}
	
	/**
	 * 保存HP发送过来的发送时机分类信息
	 * @param smsOccasionTypeInfo
	 * @throws Exception
	 */
	public void saveBatchSmsOccasionTypeInfo(ISmsOccasionTypeInfoValue[] smsOccasionTypeInfo)throws Exception {
		smsOccasionDAO.saveBatchSmsOccasionTypeInfo(smsOccasionTypeInfo);
	}
	
	/**
	 * 通过发送时机类型id查询发送时机类型信息
	 * @param occasionTypeId
	 * @return
	 * @throws Exception
	 */
	public ISmsOccasionTypeInfoValue getSmsOccasionTypeInfo(String occasionTypeId)throws Exception {
		return smsOccasionDAO.getSmsOccasionTypeInfo(occasionTypeId);
	}
	
	/**
	 * 通过发送时机类型code查询发送时机类型信息
	 * @param occasionTypeId
	 * @return
	 * @throws Exception
	 */
	public ISmsOccasionTypeInfoValue getSmsOccasionTypeInfoByCode(String occasionTypeCode)throws Exception {
		return smsOccasionDAO.getSmsOccasionTypeInfoByCode(occasionTypeCode);
	}

}
