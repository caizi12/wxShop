package ngves.asiainfo.core.award.service.impl;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.ai.appframe2.service.ServiceFactory;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.award.AwardConstant;
import ngves.asiainfo.core.award.bo.AwardInfoBean;
import ngves.asiainfo.core.award.bo.AwardLevelInfoBean;
import ngves.asiainfo.core.award.bo.AwardLevelMessageBean;
import ngves.asiainfo.core.award.dao.interfaces.IAwardInfoDAO;
import ngves.asiainfo.core.award.dao.interfaces.IAwardLevelInfoDAO;
import ngves.asiainfo.core.award.dao.interfaces.IAwardLevelMessageDAO;
import ngves.asiainfo.core.award.exception.MgtAwardException;
import ngves.asiainfo.core.award.ivalues.IAwardInfoValue;
import ngves.asiainfo.core.award.ivalues.IAwardLevelInfoValue;
import ngves.asiainfo.core.award.ivalues.IAwardLevelMessageValue;
import ngves.asiainfo.core.award.ivalues.IQBOAwardLevelRLTWareValue;
import ngves.asiainfo.core.award.ivalues.IQBOWareQueryInfoValue;
import ngves.asiainfo.core.award.service.interfaces.IAwardLevelInfoSrv;
import ngves.asiainfo.core.common.service.interfaces.IBusiInfoDetailSrv;
import ngves.asiainfo.core.common.util.BusiInfoUtil;
import ngves.asiainfo.core.ware.ivalues.IWareInfoPortalValue;
import ngves.asiainfo.core.ware.ivalues.IWareInfoValue;
import ngves.asiainfo.core.ware.service.interfaces.IWareInfoSrv;
import ngves.asiainfo.interfaces.InterConstant;
import ngves.asiainfo.interfaces.hp.bean.synAwardInfo.in.SynAwardInfoInBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.synAwardInfo.in.SynAwardInfoInDisableInfo;
import ngves.asiainfo.interfaces.hp.bean.synAwardInfo.in.SynAwardInfoInRuleInfo;
import ngves.asiainfo.interfaces.hp.bean.synAwardInfo.out.SynAwardInfoOutBizRegReq;
import ngves.asiainfo.interfaces.hp.realtime.SynAwardInfoInter;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.StringUtil;
import ngves.asiainfo.core.award.service.interfaces.IBusiProcessSrv;

public class AwardLevelInfoSrvImpl implements IAwardLevelInfoSrv {
	
	private IAwardLevelInfoDAO awardLevelInfoDAO;	
	
	private IAwardLevelMessageDAO awardLevelMessageDAO;
	
  
	private   IAwardInfoDAO awardInfoDAO;
	
	IWareInfoSrv wareInfosrv = (IWareInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_WARE_INFO);
	
	public void setAwardInfoDAO(IAwardInfoDAO awardInfoDAO) throws Exception {
		this.awardInfoDAO = awardInfoDAO;
	}
	
	public void setAwardLevelInfoDAO(IAwardLevelInfoDAO awardLevelInfoDAO) {
		this.awardLevelInfoDAO=awardLevelInfoDAO;
	}

	public void setAwardLevelMessageDAO(IAwardLevelMessageDAO awardLevelMessageDAO) {
		this.awardLevelMessageDAO=awardLevelMessageDAO;		
	}
	
	@SuppressWarnings("unchecked")
	public long addAwardLevelInfos(String[] param,long staffId,
			String comType, long orgId)throws Exception {		
		Long awardId=Long.parseLong(param[6]);
		IAwardInfoValue  awardValue=awardInfoDAO.queryAwardById(awardId);

		IAwardInfoValue oldAwardValue = new AwardInfoBean();
		oldAwardValue.copy(awardValue);
		String awardName = awardValue.getAwardName();
		

		//lizhi for log on set award  level
		Map<String, Object> mapOld = new HashMap<String, Object>();
		Map<String, Object> mapNew = new HashMap<String, Object>();
		Map<String, List> mapRet = new HashMap<String, List>();	
		//lizhi for log on set award  level
		
		if(StringUtil.isBlank(awardValue.getAwardName())){
			throw new MgtAwardException("活动不存在");
		}
		IAwardLevelInfoValue[] value=awardLevelInfoDAO.findByAwardId(awardId);
		
		//lizhi for log on set award  level
		for (IAwardLevelInfoValue v : value) {
			mapOld.put("" + v.getAwardId() + "," + v.getWareId(), v);
		}
		//lizhi for log on set award  level
		
		if(null!=value&&value.length>0){
			awardLevelInfoDAO.deleteAwardLevelInfos(param[6]);
		}
		   String[] wareIdArr=param[0].split(",");
		   String[] wareNickNameArr=param[1].split(",");
		   String[] awardOddArr=param[2].split(",");
		   String[] maxCountArr=param[3].split(",");
		   String[] isShowWareArr=param[4].split(",");
		   //String[] bgColorCodeArr=param[5].split(",");
		   String[] wareCodeArr=param[7].split(",");
		   String[] isDefaultLevelArr=param[8].split(",");		  
		   IAwardLevelInfoValue[]  levelVlaue=new AwardLevelInfoBean[wareIdArr.length];
		   IAwardLevelInfoValue alb=null;
		   Long levelSort=1l;
		   //Long houseCount=0l;
		   int maxCount=0;
		   int levelAngleAvg=0;
		   levelAngleAvg=360/wareIdArr.length;
		   for(int i=0;i<wareIdArr.length;i++){
			   maxCount= Integer.parseInt(maxCountArr[i]);
			 //验证库存,前台提交数据的时候通过ajax验证了，后台暂时不考虑验证
//             if(!AwardConstant.AWARD_LEVEL_NOT_WAREID.equals(wareIdArr[i])&&!"1".equals(isDefaultLevelArr[i])){				   
//            	 houseCount=getHouseWareCountByWareId(wareIdArr[i]);
//            	 if(houseCount>0l&&maxCount>houseCount){
//            		 throw new MgtAwardException(wareNickNameArr[i]+","+AwardConstant.HOUSE_COUNT_ERROR_CODE);
//            	 }
//			   }			   
			   alb=new AwardLevelInfoBean();
			   alb.setLevelSort(levelSort);
			   alb.setWareId(Long.parseLong(wareIdArr[i]));
			   //alb.setBgColourCode(bgColorCodeArr[i]);
			   alb.setWareNickname(wareNickNameArr[i]);
			   alb.setAwardOdds(Long.parseLong(awardOddArr[i]));
			   //礼品库存填0代表无限制，为了方便前台程序库存扣减，存值存成负数
			   if(maxCount==0){
				   maxCount=AwardConstant.AWARD_DEFALUT_WARE_MAX_COUNT;
			   }
			   alb.setMaxCount(new Long(maxCount));
			   alb.setIsShowWare(isShowWareArr[i]);			  
			   alb.setAwardId(awardId);			 
			   if(AwardConstant.AWARD_LEVEL_NOT_WAREID.equals(wareCodeArr[i])){
				   alb.setWareCode("");
			   }else{
				   alb.setWareCode(wareCodeArr[i]);
			   }
			   alb.setIsDefaultLevel(isDefaultLevelArr[i]);
			   alb.setLevelAngle(new Long(i*levelAngleAvg));
			   levelVlaue[i]=alb;
			   levelSort++;
		   }			   
		Long count=awardLevelInfoDAO.addAwardLevelInfos(levelVlaue);
		if(count<=0l){
			return 0l;
		}
					
		//提示语信息处理
		 List<IAwardLevelMessageValue>  amblist=new ArrayList<IAwardLevelMessageValue>();
		 IAwardLevelMessageValue  amb=null;	
		 Map<String,IAwardLevelMessageValue>  messageMap=new HashMap<String,IAwardLevelMessageValue>();
		 boolean isDifferent = false;
		 String busiInfoDesc="";
		if(null!=param[9]&&param[9].length()>0&&StringUtils.isNotBlank(param[9])){	
		 String[] proMsgsArr=param[9].split("#");
		 if(null!=proMsgsArr&&proMsgsArr.length>0){			 
			 String[] levelMessage=new String[4];
			 String[] messageInfo=new String[15];
			 String[] status=new String[15];
			 String[] messageId=new String[15];					
			 for(int i=0;i<proMsgsArr.length;i++){
				 levelMessage=proMsgsArr[i].split("@");
				 messageInfo=levelMessage[0].substring(0, levelMessage[0].length()-1).split(",");
				 status=levelMessage[1].substring(0, levelMessage[1].length()-1).split(",");
				 messageId=levelMessage[3].substring(0, levelMessage[3].length()-1).split(",");
				 for(int j=0;j<messageId.length;j++){
					 //新增
					 if(AwardConstant.AWARD_LEVEL_NOT_WAREID.equals(messageId[j])){
						 amb=new AwardLevelMessageBean();
						 amb.setStsToNew();
						 amb.setAwardId(awardId);
						 amb.setMessage(messageInfo[j]);
						 amb.setStatus(status[j]);
						 amb.setWareCode(levelMessage[2]);
						 amblist.add(amb);
						 if(AwardConstant.AWARD_LEVEL_NOT_WAREID.equals(levelMessage[2])){
							 busiInfoDesc = "活动名称:"+awardName + ",活动ID:"+awardId + ",礼品名称:未中奖,礼品编码:无 ";
						 }else{
							 IWareInfoValue wareInfoValue = wareInfosrv.getByWareCode(levelMessage[2]);
							 busiInfoDesc = "活动名称:"+awardName + ",活动ID:"+awardId + ",礼品名称:" + wareInfoValue.getWareName() + ",礼品编码:" + levelMessage[2];							 
						 }
						 BusiInfoUtil.recordBusiInfo(null, CoreConstant.SYS_PARA_BUSI_TYPE_LOTTERY_MANAGEMENT, staffId, "新增提示语", CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY,
								 busiInfoDesc, -1, comType, orgId);
						
					 //不是新增，包括修改和未经改动过的提示语
					 }else{
						 amb=new AwardLevelMessageBean();
						 //amb.setStsToOld();
						 amb.setAwardMessageId(Long.parseLong(messageId[j]));
						 amb.setAwardId(awardId);
						 amb.setMessage(messageInfo[j]);
						 amb.setStatus(status[j]);
						 amb.setWareCode(levelMessage[2]);
						 //amblist.add(amb);
						 messageMap.put(messageId[j], amb);						 
					 }					
				 }				 
			 }
		    }
		 }
		String wareCode="";
			 IAwardLevelMessageValue[] messageValues=awardLevelMessageDAO.findMessageByAwardId(param[6]);  
			 if(null!=messageValues&&messageValues.length>0){
				 for(IAwardLevelMessageValue message:messageValues){
						if(!messageMap.containsKey((Object)message.getAwardMessageId()+"")){
							message.delete();
							amblist.add(message);
							wareCode = message.getWareCode();
							if(AwardConstant.AWARD_LEVEL_NOT_WAREID.equals(wareCode)){
								 busiInfoDesc = "活动名称:"+awardName + ",活动ID:"+awardId + ",礼品名称:未中奖 ,礼品编码：无";
							 }else{
								 IWareInfoValue wareInfoValue = wareInfosrv.getByWareCode(wareCode);
								 busiInfoDesc = "活动名称:"+awardName + ",活动ID:"+awardId + ",礼品名称:" + wareInfoValue.getWareName() + ",礼品编码:" + wareCode;							 
							 }
							BusiInfoUtil.recordBusiInfo(null, CoreConstant.SYS_PARA_BUSI_TYPE_LOTTERY_MANAGEMENT, staffId, "删除提示语", CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY,
									busiInfoDesc, -1, comType, orgId);
						}else{
							IAwardLevelMessageValue newMesValue = messageMap.get((Object)message.getAwardMessageId()+"");
							isDifferent = BusiInfoUtil.compareValue(message, newMesValue, null);
							if(!isDifferent){
								//amblist.remove(newMesValue);
							}else{
								wareCode = newMesValue.getWareCode();
								if(AwardConstant.AWARD_LEVEL_NOT_WAREID.equals(wareCode)){
									 busiInfoDesc = "活动名称:"+awardName + ",活动ID:"+awardId + ",礼品名称:未中奖 ,礼品编码：无";
								 }else{
									 IWareInfoValue wareInfoValue = wareInfosrv.getByWareCode(wareCode);
									 busiInfoDesc = "活动名称:"+awardName + ",活动ID:"+awardId + ",礼品名称:" + wareInfoValue.getWareName() + ",礼品编码:" + wareCode;							 
								 }
								long busiId = BusiInfoUtil.recordBusiInfo(null, CoreConstant.SYS_PARA_BUSI_TYPE_LOTTERY_MANAGEMENT, staffId, "修改提示语", CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY,
										busiInfoDesc, -1, comType, orgId);
								BusiInfoUtil.recordBusiDetail(busiId + "", new Object[] {message}, new Object[] {newMesValue}, null);
								message.setMessage(newMesValue.getMessage());
								message.setStatus(newMesValue.getStatus());								
								amblist.add(message);
							}
							
						}
					}
			 }
			if(!amblist.isEmpty()){	
				IAwardLevelMessageValue[]  ambArr=new AwardLevelMessageBean[amblist.size()];
				awardLevelMessageDAO.addAwardLevelMessageInfos(amblist.toArray(ambArr));
			}		
			String  actionType=param[10];
			String showNotWin=param[11];
			String containNotWin=param[12];
			awardValue.setShowNotWin(showNotWin);
			awardValue.setContainNotWin(containNotWin);
			if(StringUtils.isNotBlank(actionType)&&actionType.equals("publish")){
				   //活动处于创建状态时候，第一次是新增
				if(awardValue.getStatus().equals(AwardConstant.ACTIVITY_CREATE)){										
					callSysAwardInfo(awardValue,AwardConstant.AWARD_INFO_SYN_HP_OPT_TYPE_ADD);												
				}else if(awardValue.getStatus().equals(AwardConstant.ACTIVITY_PUBLIC)){					
					callSysAwardInfo(awardValue,AwardConstant.AWARD_INFO_SYN_HP_OPT_TYPE_MODIFY);						
				}		
				 awardValue.setPulishStaff(param[13]);
				 awardValue.setStatus(AwardConstant.ACTIVITY_PUBLIC);
				 awardValue.setPublishDate(new Timestamp(new Date().getTime()));
				 String html =AwardConstant.ACTIVITY_PORTAL_URL+ awardId + ".html";
				 awardValue.setUrl(html);		 
			 }else{
				 if(awardValue.getStatus().equals(AwardConstant.ACTIVITY_PUBLIC)){					
						callSysAwardInfo(awardValue,AwardConstant.AWARD_INFO_SYN_HP_OPT_TYPE_MODIFY);						
				 }		
			 }
			awardInfoDAO.saveAwardInfo(awardValue);
			if(StringUtils.isNotBlank(actionType)&&actionType.equals("publish")){
				long busiid = BusiInfoUtil.recordBusiInfo(null, CoreConstant.SYS_PARA_BUSI_TYPE_LOTTERY_MANAGEMENT, staffId, "发布活动", CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY,
						"活动名称:"+awardName + ",活动ID:"+awardId, -1, comType, orgId);
			    BusiInfoUtil.recordBusiDetail(busiid+"", new Object[]{oldAwardValue}, new Object[]{awardValue}, null);
			}else{
				isDifferent = BusiInfoUtil.compareValue(oldAwardValue, awardValue, null);
				if(isDifferent){
					long busiid = BusiInfoUtil.recordBusiInfo(null, CoreConstant.SYS_PARA_BUSI_TYPE_LOTTERY_MANAGEMENT, staffId, "修改抽奖基本信息", CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY,
							"活动名称:"+awardName + ",活动ID:"+awardId, -1, comType, orgId);
				    BusiInfoUtil.recordBusiDetail(busiid+"", new Object[]{oldAwardValue}, new Object[]{awardValue}, null);
				 }				
			}
			
			//lizhi for log on set award  level
			
			IAwardLevelInfoValue[] newvalue = awardLevelInfoDAO.findByAwardId(awardId);
			for (IAwardLevelInfoValue v : newvalue) {
				mapNew.put("" + v.getAwardId() + "," + v.getWareId() , v);
			}
			
			try {
				IBusiProcessSrv busiProcessSrv=(IBusiProcessSrv)ServiceFactory
		        .getService("ngves.asiainfo.core.busiProcessSrv");
				busiProcessSrv.recordBusiInfoDetails("null", mapOld,  mapNew, mapRet);
				//BusiInfoUtil.getResultMapByMultiOp("null", mapOld, mapNew, mapRet);
			} catch (Exception e) {
				System.out.println(e.toString());
				e.printStackTrace();
			}

			List<Object> listNew = mapRet.get("listNew");
			List<Object> listDel = mapRet.get("listDel");
			List<Object> listModifyToCheckOld = mapRet.get("listModifyToCheckOld");
			List<Object> listModidyToCheckNew = mapRet.get("listModifyToCheckNew");

			if (listNew != null && listNew.size() > 0) {
			  for(int i=0;i<listNew.size();i++)
			  {
				  //AwardLevelInfoBean vtemp=(AwardLevelInfoBean) listNew.get(i);
				//String desc=new StringBuffer("Detail:   wareCode-").append(vtemp.getWareCode()+", wareId-").append(vtemp.getWareId()+"  ,warNickName-").append(vtemp.getWareNickname()).toString();
				BusiInfoUtil.recordBusiInfo(null, CoreConstant.SYS_PARA_BUSI_TYPE_LOTTERY_MANAGEMENT, staffId, "新增中奖档次",
						CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY, "活动名称:" + awardName + ",活动ID:" + awardId, -1, comType,
						orgId);
			  }
			}

			if (listDel != null && listDel.size() > 0) {
				for(int i=0;i<listDel.size();i++)
				{
					//AwardLevelInfoBean vtemp=(AwardLevelInfoBean) listDel.get(i);
					//String desc=new StringBuffer("Detail:   wareCode-").append(vtemp.getWareCode()+", wareId-").append(vtemp.getWareId()+"  ,warNickName-").append(vtemp.getWareNickname()).toString();
				    BusiInfoUtil.recordBusiInfo(null, CoreConstant.SYS_PARA_BUSI_TYPE_LOTTERY_MANAGEMENT, staffId, "删除中奖档次",
						    CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY, "活动名称:" + awardName + ",活动ID:" + awardId, -1, comType,
						  orgId);
				}
			}

			if (listModifyToCheckOld != null && listModidyToCheckNew != null
					&& (listModidyToCheckNew.size() == listModifyToCheckOld.size()) && listModidyToCheckNew.size() > 0) {
				//
				boolean changed = false;
				IBusiInfoDetailSrv busiInfoDetailSrv = (IBusiInfoDetailSrv) ServiceFactory
						.getService("ngves.asiainfo.core.BusiInfoDetailService");
				for (int i = 0; i < listModifyToCheckOld.size(); i++) {
					if (busiInfoDetailSrv.compareValueIgnoreAwardLevelId(listModidyToCheckNew.get(i), listModifyToCheckOld
							.get(i), "")) {
						changed = true;
						break;
					}
				}

				if (changed) {				
				
				//
				long busiId = BusiInfoUtil.recordBusiInfo(null, CoreConstant.SYS_PARA_BUSI_TYPE_LOTTERY_MANAGEMENT,
						staffId, "修改中奖档次", CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY,
						"活动名称:" + awardName + ",活动ID:" + awardId, -1, comType, orgId);
				Object[] oldValues = new Object[listModifyToCheckOld.size()];
				Object[] newValues = new Object[listModidyToCheckNew.size()];
				listModifyToCheckOld.toArray(oldValues);
				listModidyToCheckNew.toArray(newValues);
				BusiInfoUtil.recordBusiDetailForAwardLevel(busiId + "", oldValues, newValues, "");
				}
			}
			//lizhi for log on set award  level	
			
		return awardId;
	}

	public int countWareInfosByWareName(String awardId,String wareName) throws Exception {
		
		return awardLevelInfoDAO.countWareInfosByWareName(awardId,wareName);
	}

	public IQBOWareQueryInfoValue[] findAllWareInfosByWareName(String awardId,String wareName,
			int startIndex, int endIndex) throws Exception {
		
		IQBOWareQueryInfoValue[] value= awardLevelInfoDAO.findAllWareInfosByWareName(awardId,wareName, startIndex, endIndex);
		 return value;
	}

	public IAwardLevelInfoValue[] findAllByAwardId(String awardId) throws Exception {
		if(StringUtil.isNotNullValue(awardId)){
			return awardLevelInfoDAO.findByAwardId(Long.parseLong(awardId));
		}else{
			return null;
		}
		
	}

	public void deleteAwardLevelInfos(String awardId) throws Exception {
		
		awardLevelInfoDAO.deleteAwardLevelInfos(awardId);
	}

	

	public long updateAwardLevelInfos(
			IAwardLevelInfoValue[] awardLevelInfoValues) throws Exception {
		
		return awardLevelInfoDAO.updateAwardLevelInfos(awardLevelInfoValues);
	}

	public IQBOAwardLevelRLTWareValue[] findAllLevelInfosByAwardId(
			String awardId) throws Exception {
		
		IQBOAwardLevelRLTWareValue[] values= awardLevelInfoDAO.findAllLevelInfosByAwardId(awardId);
		return fillAwardLevelInfoHTMLOperationField(values);
	}


	public IWareInfoPortalValue[] getShowLevelAwardById(String awardId)
			throws Exception {
		
		return awardLevelInfoDAO.getShowLevelAwardById(awardId);
	}

	protected IQBOAwardLevelRLTWareValue[] fillAwardLevelInfoHTMLOperationField(IQBOAwardLevelRLTWareValue[] values) throws Exception{
		//如果有数据
		if(null != values && values.length > 0 ){
			
			Long awardId = values[0].getAwardId();
			String wareCode="";
			IAwardLevelMessageValue[]  messageValues=null;
			String proMsg="";
			for(int i=0;i<values.length;i++){		
				wareCode=values[i].getWareCode();
				if(StringUtils.isBlank(wareCode)){
					wareCode=AwardConstant.AWARD_LEVEL_NOT_WAREID;
				}
				messageValues=awardLevelMessageDAO.findMessageByAwardId(awardId,wareCode,"");
				if(null!=messageValues&&messageValues.length>0){
					String message="";
					String status="";
					String messageId="";
					for(int j=0;j<messageValues.length;j++){
						message=message+messageValues[j].getMessage()+",";
						status=status+messageValues[j].getStatus()+",";
						messageId=messageId+messageValues[j].getAwardMessageId()+",";
					}
					proMsg=message+"@"+status+"@"+wareCode+"@"+messageId;					
					values[i].setBakColThree(proMsg);
				}
			}
		}
		return values;
	}
	
	private String callSysAwardInfo(IAwardInfoValue value, String optType) throws Exception {
			
			SynAwardInfoOutBizRegReq out=getSynAwardInfoBizRegReq(value,optType);
			
			if(!(InterConstant.SUCC.equals(out.getRejectReason()))){
				throw new Exception(out.getErrorMsg());
			}
			return "0000";
		}	
	
	//信息增量同步接口
	protected SynAwardInfoOutBizRegReq getSynAwardInfoBizRegReq(IAwardInfoValue value, String optType) throws Exception{
			
			SynAwardInfoInBizRegReq in = SynAwardInfoInter.getSynAwardInfoBean();
			in.setOptType(optType);
			
			if(AwardConstant.AWARD_INFO_SYN_HP_OPT_TYPE_ADD.equals(optType)
					||AwardConstant.AWARD_INFO_SYN_HP_OPT_TYPE_MODIFY.equals(optType)){
				SynAwardInfoInRuleInfo ruleInfo = in.addNewRuleInfo();
				ruleInfo.setActionID(AwardConstant.AWARD_RULE_INFO_ACTIONID+String.valueOf(value.getAwardId()));
				ruleInfo.setActionName(value.getAwardName());
				ruleInfo.setOrgID(CommnConstant.INTER_ORG_WEB);
				if(AwardConstant.AWARD_LEVEL_IS_CONTAIN.equals(value.getContainNotWin())){
					ruleInfo.setActionType(AwardConstant.AWARD_NOT_MOST_WARE);
					ruleInfo.setItemID("");
					ruleInfo.setItemName("");		
				}else if(AwardConstant.AWARD_LEVEL_NOT_CONTAIN.equals(value.getContainNotWin())){
					ruleInfo.setActionType(AwardConstant.AWARD_MOST_WARE);	
					IWareInfoValue wareValue=awardInfoDAO.findLevelInfoByAwardId(value.getAwardId());
					ruleInfo.setItemID(wareValue.getWareCode());
					ruleInfo.setItemName(wareValue.getWareName());		
				}
				
				ruleInfo.setActionStartTime(DateTimeUtil.format(value.getStartTime(), "yyyyMMddHHmmss"));
				ruleInfo.setActionEndTime(DateTimeUtil.format(value.getEndTime(), "yyyyMMddHHmmss"));
				ruleInfo.setLengthenTime(DateTimeUtil.format(value.getStopGetTime(), "yyyyMMddHHmmss"));
				ruleInfo.setLimitNum( value.getOneMaxCount()==new Long(AwardConstant.AWARD_DEFALUT_WARE_MAX_COUNT)? "-1":String.valueOf(value.getOneMaxCount()));
			}else if(AwardConstant.AWARD_INFO_SYN_HP_OPT_TYPE_DEL.equals(optType)){
				SynAwardInfoInDisableInfo disableInfo = in.addNewDisableInfo();
				disableInfo.setActionID(String.valueOf(value.getAwardId()));
			}else{
				throw new Exception("请求报文OptType字段:"+optType+"不在[01,02,03]范围内");
			}		
			return SynAwardInfoInter.doBusi(in);
		}

	public long getHouseWareCountByWareId(String wareId) throws Exception {
		
		return awardLevelInfoDAO.getHouseWareCountByWareId(Long.parseLong(wareId));
	}

	public IAwardLevelMessageValue[] getDefaultMessage(Long awardId, String wareCode,String status)throws Exception {
		IAwardLevelMessageValue[]  messageValues=awardLevelMessageDAO.findMessageByAwardId(awardId,wareCode,status);
		return messageValues;
	}


	
	public void recordExcel(String conditionExcel, long staffId, String comType, long orgId) throws Exception{		
		//记录业务操作日志
		if("".equals(conditionExcel))
		{
			BusiInfoUtil.recordBusiInfo(null, CoreConstant.SYS_PARA_BUSI_TYPE_LOTTERY_ACTIVITY_EXPORT, staffId, "积分抽奖活动导出", CoreConstant.BUSI_INFO_OPT_TYPE_CHECK,
					  "查询条件:"+ "无", -1, comType, orgId);
		}else{
			BusiInfoUtil.recordBusiInfo(null, CoreConstant.SYS_PARA_BUSI_TYPE_LOTTERY_ACTIVITY_EXPORT, staffId, "积分抽奖活动导出", CoreConstant.BUSI_INFO_OPT_TYPE_CHECK,
					  "查询条件:"+ conditionExcel, -1, comType, orgId);
		}
	}

}
