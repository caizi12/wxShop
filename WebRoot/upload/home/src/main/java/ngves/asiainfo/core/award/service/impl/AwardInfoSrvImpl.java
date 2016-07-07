package ngves.asiainfo.core.award.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.award.AwardConstant;
import ngves.asiainfo.core.award.bo.AwardDescBean;
import ngves.asiainfo.core.award.bo.AwardInfoBean;
import ngves.asiainfo.core.award.bo.AwardInfoEngine;
import ngves.asiainfo.core.award.bo.AwardLevelInfoBean;
import ngves.asiainfo.core.award.dao.interfaces.IAwardInfoDAO;
import ngves.asiainfo.core.award.dao.interfaces.IAwardLevelInfoDAO;
import ngves.asiainfo.core.award.exception.MgtAwardException;
import ngves.asiainfo.core.award.ivalues.IAwardDescValue;
import ngves.asiainfo.core.award.ivalues.IAwardInfoValue;
import ngves.asiainfo.core.award.ivalues.IAwardLevelInfoValue;
import ngves.asiainfo.core.award.model.ClientAwardInfoViewModel;
import ngves.asiainfo.core.award.model.RollAwardViewModel;
import ngves.asiainfo.core.award.model.RoolAwardInfosViewModel;
import ngves.asiainfo.core.award.service.interfaces.IAwardInfoSrv;
import ngves.asiainfo.core.common.bo.BusiInfoEngine;
import ngves.asiainfo.core.common.dao.interfaces.IClobInfoDAO;
import ngves.asiainfo.core.common.util.BusiInfoUtil;
import ngves.asiainfo.core.ware.bo.WareInfoEngine;
import ngves.asiainfo.core.ware.ivalues.IWareInfoValue;
import ngves.asiainfo.core.ware.util.RollAwardInfoQueryCacheUtil;
import ngves.asiainfo.interfaces.InterConstant;
import ngves.asiainfo.interfaces.hp.ProvinceUtil;
import ngves.asiainfo.interfaces.hp.bean.awardDescInfoQuery.in.AwardDescInfoQueryInBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.awardDescInfoQuery.out.AwardDescInfoQueryOutBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.awardDescInfoQuery.out.AwardDescInfoQueryOutLotterylist;
import ngves.asiainfo.interfaces.hp.bean.clientAwardInfoQuery.in.ClientAwardInfoQueryInBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.clientAwardInfoQuery.out.ClientAwardInfoQueryOutBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.rollAwardInfoQuery.in.RollAwardInfoQueryInBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.rollAwardInfoQuery.out.RollAwardInfoQueryOutBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.rollAwardInfoQuery.out.RollAwardInfoQueryOutLotterylist;
import ngves.asiainfo.interfaces.hp.bean.synAwardInfo.in.SynAwardInfoInBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.synAwardInfo.in.SynAwardInfoInDisableInfo;
import ngves.asiainfo.interfaces.hp.bean.synAwardInfo.in.SynAwardInfoInRuleInfo;
import ngves.asiainfo.interfaces.hp.bean.synAwardInfo.out.SynAwardInfoOutBizRegReq;
import ngves.asiainfo.interfaces.hp.realtime.AwardDescInfoQueryInter;
import ngves.asiainfo.interfaces.hp.realtime.ClientAwardInfoQueryInter;
import ngves.asiainfo.interfaces.hp.realtime.RollAwardInfoQueryInter;
import ngves.asiainfo.interfaces.hp.realtime.SynAwardInfoInter;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.privilege.UserInfoInterface;
import com.ai.appframe2.service.ServiceFactory;

@SuppressWarnings("unused")
public class AwardInfoSrvImpl implements IAwardInfoSrv {
	
	private Log log = LogFactory.getLog(AwardInfoSrvImpl.class);

	private IAwardInfoDAO awardInfoDAO;
	
	private IAwardLevelInfoDAO awardLevelInfoDAO;	
	
	public void setAwardInfoDAO(IAwardInfoDAO awardInfoDAO) throws Exception {
		this.awardInfoDAO = awardInfoDAO;
	}
	

	public void setAwardLevelInfoDAO(IAwardLevelInfoDAO awardLevelInfoDAO) throws Exception {
		this.awardLevelInfoDAO = awardLevelInfoDAO;
	}

	public IAwardInfoValue[] queryAwardInfo(String awardName, int startIndex, int endIndex) throws Exception {
		IAwardInfoValue[]  values =  awardInfoDAO.queryAwardInfo(awardName, startIndex, endIndex);
		return fillAwardInfoHTMLOperationField(values);
	}

	protected IAwardInfoValue[] fillAwardInfoHTMLOperationField(IAwardInfoValue[] values) throws Exception{

		//如果有数据
		if(null != values && values.length > 0 ){
			StringBuffer operationHtml = new StringBuffer();;
		final String VIEW_AWARD_INFO_LINK = "<a href=\"#\" onclick=\"viewAwardInfo(%s)\" >查看基本信息</a>&nbsp;&nbsp;";
		
		final String MODIFY_AWARD_INFO_LINK = "<a href=\"#\" onclick=\"modifyAwardInfo(%s)\" >修改基本信息</a>&nbsp;&nbsp;";
		
		final String VIEW_AWARD_LEVEL_INFO_LINK = "<a href=\"#\" onclick=\"viewAwardLevel(%s,%s,%s)\" >查看分档</a>&nbsp;&nbsp;";		
		
		final String MODIFY_AWARD_LEVEL_INFO_LINK = "<a href=\"#\" onclick=\"modifyAwardLevel(%s,%s,%s)\" >修改分档</a>&nbsp;&nbsp;";
		
		final String ORDER_LIST_AWARD_INFO_LINK = "<a href=\"#\" onclick=\"awardOrder(%s)\" >活动名单</a>&nbsp;&nbsp;";
		
		final String STOP_AWARD_INFO_LINK = "<a href=\"#\" onclick=\"stopAward(%s)\" >活动停止</a>&nbsp;&nbsp;";
		
		final String CONTINUE_AWARD_INFO_LINK = "<a href=\"#\" onclick=\"continueAward(%s)\" >活动延期</a>&nbsp;&nbsp;";
		
		final String DELETE_AWARD_INFO_LINK = "<a href=\"#\" onclick=\"deleteAward(%s)\" >删除活动</a>&nbsp;&nbsp;";
		
		final String COPY_AWARD_INFO_LINK = "<a href=\"#\" onclick=\"copyAward(%s)\" >复制新活动</a>&nbsp;&nbsp;";
			
			long AwardId = 0L;
			//遍历整个数组集合
			String status="";
			String contactNotWin="0";
			String showNotWin="0";
			for(int i=0;i<values.length;i++){
				status="";
				
				AwardId = values[i].getAwardId() ;
				if(StringUtils.isNotBlank(values[i].getContainNotWin())){
					contactNotWin=values[i].getContainNotWin();
				}
				if(StringUtils.isNotBlank(values[i].getShowNotWin())){
					showNotWin=values[i].getShowNotWin();
				}
				
				if(AwardConstant.ACTIVITY_CREATE.equals(values[i].getStatus())){
					status="活动创建";
					//0、活动创建
					//修改基本信息，修改分档,删除活动
					operationHtml
					.append(String.format(MODIFY_AWARD_INFO_LINK,String.valueOf(AwardId)))
					
					.append(String.format(MODIFY_AWARD_LEVEL_INFO_LINK, String.valueOf(AwardId),String.valueOf(contactNotWin),String.valueOf(showNotWin)))
					.append(String.format(DELETE_AWARD_INFO_LINK, String.valueOf(AwardId)));
				}else if(AwardConstant.ACTIVITY_PUBLIC.equals(values[i].getStatus())){
					status="活动发布";
					//2、活动发布
					if(DateTimeUtil.getDefaultSysDate().before(values[i].getStartTime())){
						//修改基本信息，修改分档
						operationHtml
						.append(String.format(MODIFY_AWARD_INFO_LINK,String.valueOf(AwardId)))
						.append(String.format(MODIFY_AWARD_LEVEL_INFO_LINK, String.valueOf(AwardId),String.valueOf(contactNotWin),String.valueOf(showNotWin)));	

					}else if(DateTimeUtil.getDefaultSysDate().after(values[i].getStartTime()) 
							&& DateTimeUtil.getDefaultSysDate().before(values[i].getEndTime())){
						//status="活动进行中";
						//b 活动进行中
						//查看基本信息，查看分档，活动停止，活动延期，活动名单
						operationHtml
						.append(String.format(MODIFY_AWARD_INFO_LINK,String.valueOf(AwardId)))
						.append(String.format(VIEW_AWARD_INFO_LINK,String.valueOf(AwardId)))
						.append(String.format(VIEW_AWARD_LEVEL_INFO_LINK, String.valueOf(AwardId),String.valueOf(contactNotWin),String.valueOf(showNotWin)))
					    .append(String.format(STOP_AWARD_INFO_LINK,String.valueOf(AwardId)))
						.append(String.format(CONTINUE_AWARD_INFO_LINK, String.valueOf(AwardId)))
						.append(String.format(ORDER_LIST_AWARD_INFO_LINK, String.valueOf(AwardId)))
						.append(String.format(MODIFY_AWARD_LEVEL_INFO_LINK, String.valueOf(AwardId),String.valueOf(contactNotWin),String.valueOf(showNotWin)));	
					}else if(DateTimeUtil.getDefaultSysDate().after(values[i].getEndTime())){
						//status="活动已结束";
						//c 活动已经结束
						//查看基本信息，查看分档，活动名单，复制新活动
						operationHtml
						.append(String.format(VIEW_AWARD_INFO_LINK,String.valueOf(AwardId)))
						.append(String.format(VIEW_AWARD_LEVEL_INFO_LINK, String.valueOf(AwardId),String.valueOf(contactNotWin),String.valueOf(showNotWin)))
						.append(String.format(ORDER_LIST_AWARD_INFO_LINK, String.valueOf(AwardId)))
						.append(String.format(COPY_AWARD_INFO_LINK, String.valueOf(AwardId)));
					}else{
						throw new MgtAwardException("indeterminated  Award begin time and end time ,please check it from Award_info table.");
					}
				}else if(AwardConstant.ACTIVITY_STOP.equals(values[i].getStatus())){
					status="活动已结束";
					//c 活动已经结束
					//查看基本信息，查看分档，活动名单，复制新活动
					operationHtml
					.append(String.format(VIEW_AWARD_INFO_LINK,String.valueOf(AwardId)))
					.append(String.format(VIEW_AWARD_LEVEL_INFO_LINK, String.valueOf(AwardId),String.valueOf(contactNotWin),String.valueOf(showNotWin)))
					.append(String.format(ORDER_LIST_AWARD_INFO_LINK, String.valueOf(AwardId)))
					.append(String.format(COPY_AWARD_INFO_LINK, String.valueOf(AwardId)));
				}else{
					throw new MgtAwardException("indeterminated  Award status ,please check it from Award_info table.");
				}
				
				values[i].setBakCol(operationHtml.toString());
				values[i].setStatus(status);
				operationHtml = new StringBuffer();
			}
		}
		
		return values;
			
	}
	public int queryAwardInfoCount(String AwardName) throws Exception {
		return awardInfoDAO.queryAwardInfoCount(AwardName);
	}

	public IAwardInfoValue getAwardInfoById(String AwardId) throws Exception {	
		IAwardInfoValue value= awardInfoDAO.queryAwardById(Long.parseLong(AwardId));
		if((int)value.getOneMaxCount()==AwardConstant.AWARD_DEFALUT_WARE_MAX_COUNT){
			value.setOneMaxCount(0l);
		}
		if((int)value.getMaxCount()==AwardConstant.AWARD_DEFALUT_WARE_MAX_COUNT){
			value.setMaxCount(0l);
		}
		String stopGetTime=DateTimeUtil.format(value.getStopGetTime(), "yyyy-MM-dd");
		value.setStopGetTime(DateTimeUtil.stringToTimestamp(stopGetTime,"yyyy-MM-dd"));
		IClobInfoDAO clobInfoDAO = (IClobInfoDAO) ServiceFactory.getService("ngves.asiainfo.core.clobInfoDAO");
		String desc=clobInfoDAO.getContent(Long.parseLong(AwardId),AwardConstant.AWARD_TABLE_NAME);
		value.setAwardDesc(desc);
		return value;
	}


	public String stopAward(String awardId, long staffId, String comType,
			long orgId) throws Exception {
		IAwardInfoValue oldvalue =  awardInfoDAO.queryAwardById(Long.valueOf(awardId));
		IAwardInfoValue value =  awardInfoDAO.queryAwardById(Long.valueOf(awardId));
		String awardName=value.getAwardName();
		if(value.getStatus().equals(AwardConstant.ACTIVITY_PUBLIC)
				&&DateTimeUtil.getDefaultSysDate().after(value.getStartTime()) 
				&& DateTimeUtil.getDefaultSysDate().before(value.getEndTime())){
			value.setEndTime(DateTimeUtil.getDefaultSysDate());
			value.setStatus(AwardConstant.ACTIVITY_STOP);
		 callSysAwardInfo(value, AwardConstant.AWARD_INFO_SYN_HP_OPT_TYPE_MODIFY);
		 long AwardId =awardInfoDAO.saveAwardInfo(value);
		 long busiId=BusiInfoUtil.recordBusiInfo(null, CoreConstant.SYS_PARA_BUSI_TYPE_LOTTERY_MANAGEMENT, staffId, "停止活动", CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY, "活动名称："+awardName+",活动ID:"+AwardId, staffId, comType, orgId);	
		 BusiInfoUtil.recordBusiDetail(busiId+"", new Object[]{oldvalue}, new Object[]{value}, "");
		 return String.valueOf(AwardId);
			
		}else{
			throw new Exception("只能停止进行状态的活动");
		}
		

	}

	public long modifyAwardInfo(IAwardInfoValue value, long staffId, String comType, long orgId) throws Exception {

		 	value.setStsToOld();
		    value.setAwardName(value.getAwardName());
		    value.setAwardDesc(value.getAwardDesc());
		    value.setBaseIntegral(value.getBaseIntegral());
		    value.setBaseWareId(value.getBaseWareId());
		    value.setContainNotWin(value.getContainNotWin());
		    value.setEndTime(value.getEndTime());
		    value.setExchangeChannel(value.getExchangeChannel());
		    value.setMaxCount(value.getMaxCount());
		    value.setOneMaxCount(value.getOneMaxCount());
		    value.setPublishDate(value.getPublishDate());
		    value.setPulishStaff(value.getPulishStaff());
		   // value.setShowNotWin(value.getShowNotWin());
		    value.setStartTime(value.getStartTime());
		    String stopGetTime=DateTimeUtil.format(value.getStopGetTime(), "yyyy-MM-dd 23:59:59");
			Date d=DateTimeUtil.parse(stopGetTime, "yyyy-MM-dd HH:mm:ss");
			value.setStopGetTime(new Timestamp(d.getTime()));
		    value.setMainPic(value.getMainPic());
		    
		    IAwardInfoValue  oldvalue=awardInfoDAO.queryAwardById(value.getAwardId());
		    IWareInfoValue ware = WareInfoEngine.getBean(value.getBaseWareId());
			if(!ware.getWareStatus().equals(AwardConstant.WARE_INFO_STATE_ONLINE)){
				throw new Exception("基础礼品不是上线状态！");
				
			}
		   
		    if(oldvalue==null){
		    	throw  new Exception("awardinfo is null");
		    }
		    //活动进行中时nowCount发生变化。必须计算变化量
		    if(oldvalue.getStatus().equals(AwardConstant.ACTIVITY_PUBLIC)
					&&DateTimeUtil.getDefaultSysDate().after(oldvalue.getStartTime()) 
					&& DateTimeUtil.getDefaultSysDate().before(oldvalue.getEndTime())
					&& value.getMaxCount()!=0l){
		    	Long changCount  = value.getMaxCount()-oldvalue.getMaxCount();
		    	Long nowCount = oldvalue.getNowCount()+changCount;
		    	value.setNowCount(nowCount<0 ? 0 : nowCount);
		    	
		    }else{
		    	value.setNowCount(value.getMaxCount());
		    }
		    
		    if(value.getMaxCount()==0l){
		    	value.setMaxCount(new Long(AwardConstant.AWARD_DEFALUT_WARE_MAX_COUNT));
		    	value.setNowCount(0l);
		    }
			if(value.getOneMaxCount()==0l){
		    	value.setOneMaxCount(new Long(AwardConstant.AWARD_DEFALUT_WARE_MAX_COUNT));
		    }
		    
			IClobInfoDAO clobInfoDAO = (IClobInfoDAO) ServiceFactory.getService("ngves.asiainfo.core.clobInfoDAO");
			boolean flag = clobInfoDAO.saveClobInfo(value.getAwardId(), AwardConstant.AWARD_TABLE_NAME, value.getAwardDesc());
			if(oldvalue.getStatus().equals(AwardConstant.ACTIVITY_PUBLIC)){//修改发布状态的活动需要调接口
				 callSysAwardInfo(value, AwardConstant.AWARD_INFO_SYN_HP_OPT_TYPE_MODIFY);
			}
		   value.setAwardDesc("");
		   long AwardId=awardInfoDAO.saveAwardInfo(value);
		   String awardName = value.getAwardName();
		   long busiId = BusiInfoUtil.recordBusiInfo(null, CoreConstant.SYS_PARA_BUSI_TYPE_LOTTERY_MANAGEMENT, staffId, "修改抽奖基本信息", CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY,
					"活动名称:"+awardName + ",活动ID:"+AwardId, -1, comType, orgId);
		   BusiInfoUtil.recordBusiDetail(busiId+"", new Object[]{oldvalue}, new Object[]{value}, "AwardName");
		    if(flag){
				return AwardId;
			}else{
				return 0l;
			}
		
	}

	public long saveAwardInfo(IAwardInfoValue value, long staffId,  String comType, long orgId) throws Exception {
		long AwardId = 0L;
		String awardName = null;
		if (value.isNew()) {
			AwardId = AwardInfoEngine.getNewId().longValue();
			value.setAwardId(AwardId);
			value.setStatus(AwardConstant.ACTIVITY_CREATE);			
			// 创建时间
			value.setCreateDate(DateTimeUtil.getNowTimeStamp());
			value.setRecordStaff(staffId + "");
			value.setStsToNew();
			String stopGetTime=DateTimeUtil.format(value.getStopGetTime(), "yyyy-MM-dd 23:59:59");
			Date d=DateTimeUtil.parse(stopGetTime, "yyyy-MM-dd HH:mm:ss");
			value.setStopGetTime(new Timestamp(d.getTime()));			
			value.setNowCount(value.getMaxCount());
			if(value.getMaxCount()==0l){
		    	value.setMaxCount(AwardConstant.AWARD_DEFALUT_WARE_MAX_COUNT);
		    }
			if(value.getOneMaxCount()==0l){
		    	value.setOneMaxCount(AwardConstant.AWARD_DEFALUT_WARE_MAX_COUNT);
		    }
		}
		IWareInfoValue ware = WareInfoEngine.getBean(value.getBaseWareId());
		if(!ware.getWareStatus().equals(AwardConstant.WARE_INFO_STATE_ONLINE)){
			throw new Exception("基础礼品不是上线状态！");
			
		}
		IClobInfoDAO clobInfoDAO = (IClobInfoDAO) ServiceFactory.getService("ngves.asiainfo.core.clobInfoDAO");
		boolean flag = clobInfoDAO.saveClobInfo(AwardId, AwardConstant.AWARD_TABLE_NAME, value.getAwardDesc());
		value.setAwardDesc("");
		//新增活动的时候，不涉及任何同步HP操作。因为这时候，活动还没有发布。
		AwardId = awardInfoDAO.saveAwardInfo(value);
		awardName = value.getAwardName();
		BusiInfoUtil.recordBusiInfo(null, CoreConstant.SYS_PARA_BUSI_TYPE_ADD_LOTTERY, staffId, "新增积分抽奖", CoreConstant.BUSI_INFO_OPT_TYPE_ADD,
				"活动名称:" + awardName + ",活动ID:"+ AwardId, -1, comType, orgId);
		if(flag){
			return AwardId;
		}else{
			return 0l;
		}
		
	}


	public String modifyAwardinfoStatus(String status,Long AwardId) throws Exception {		
		IAwardInfoValue  value=awardInfoDAO.queryAwardById(AwardId);
	    if(value==null){
	    	throw  new Exception("awardinfo is null");
	    }	
		value.setStatus(status);
		AwardId = awardInfoDAO.saveAwardInfo(value);
		return AwardId.toString();
	}
	
	public RoolAwardInfosViewModel[] getRollAwardInfo() throws Exception {
		Calendar calendar = Calendar.getInstance();
		RoolAwardInfosViewModel[] roolAwardInfosViewModel = null;
		RollAwardInfoQueryInBizRegReq rollAwardInfoQueryIn = RollAwardInfoQueryInter.getRollAwardInfoQueryBean();
		
		rollAwardInfoQueryIn.setOrgID(CommnConstant.INTER_ORG_WEB);
		rollAwardInfoQueryIn.setDisplayNum(100);
		rollAwardInfoQueryIn.setLotteryResult("00");
		//结束时间为当前时间
		rollAwardInfoQueryIn.setEndTime(
				DateTimeUtil.dateToString(calendar.getTime(), CommnConstant.DATETIME_HP_FORMAT));
		//开始时间为前30分钟
		calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) - 30);
		rollAwardInfoQueryIn.setStartTime(
				DateTimeUtil.dateToString(calendar.getTime(), CommnConstant.DATETIME_HP_FORMAT));
		
		//获取所有发布状态并且正在进行的抽奖活动。
		IAwardInfoValue[] vals =awardInfoDAO.getPublishAwardValues(); 
		if(null!=vals && 0<vals.length){
			roolAwardInfosViewModel = new RoolAwardInfosViewModel[vals.length];
			for(int k=0;k<vals.length;k++){
				
				rollAwardInfoQueryIn.setActionID(CoreConstant.ORDER_AWARD_ACTION_TYPE + vals[k].getAwardId()+"");
				RollAwardInfoQueryOutBizRegReq RollAwardInfoQueryOut = RollAwardInfoQueryInter.doBusi(rollAwardInfoQueryIn);
				
				if(InterConstant.SUCC.equals(RollAwardInfoQueryOut.getRejectReason())){
					RollAwardInfoQueryOutLotterylist[]  RollAwardInfoQueryOutLotterylist =RollAwardInfoQueryOut.getLotterylistArray();
					if(null!=RollAwardInfoQueryOutLotterylist && 0<RollAwardInfoQueryOutLotterylist.length){
						//有抽奖订单列表
						roolAwardInfosViewModel[k] = new RoolAwardInfosViewModel();
						roolAwardInfosViewModel[k].setAwardId(vals[k].getAwardId()+"");
						
						List<RollAwardViewModel> rollAwardViewModelList = new ArrayList<RollAwardViewModel>();
						for(int i=0; i<RollAwardInfoQueryOutLotterylist.length; i++){
							RollAwardViewModel rollAwardViewModel = new RollAwardViewModel();
							String oldNum = RollAwardInfoQueryOutLotterylist[i].getMobile();
							String newNum = oldNum.substring(0,4)+"****"+oldNum.substring(oldNum.length()-3, oldNum.length());
							rollAwardViewModel.setMobileNum(newNum);
							rollAwardViewModel.setAwardStatus(RollAwardInfoQueryOutLotterylist[i].getLotteryResult());
							//取抽奖时间
							rollAwardViewModel.setAwardTime(DateTimeUtil.dateTrans(
									RollAwardInfoQueryOutLotterylist[i].getLotteryTime()));
							if("02".equals(RollAwardInfoQueryOutLotterylist[i].getLotteryResult())){
								String newName = StringUtil.sub(RollAwardInfoQueryOutLotterylist[i].getGiftInfo().getGiftItemName(),11);
								rollAwardViewModel.setAwardName(newName);
							}else{
								//未中奖时礼品名称展示‘未中奖’
								rollAwardViewModel.setAwardName("未中奖");
							}
							rollAwardViewModelList.add(rollAwardViewModel);
						}
						roolAwardInfosViewModel[k].setRollAwardView(rollAwardViewModelList);
						
					}
				}
				
				
			}
		}
	
	return roolAwardInfosViewModel;
	}

	public void rushRollAwardInfos() throws Exception {
		
		RollAwardInfoQueryCacheUtil.reLoadWareWeekRankToCache();
		
	}

	public String deleteAwardinfoByID(String awardId)throws Exception{
		IAwardInfoValue value =  awardInfoDAO.queryAwardById(Long.valueOf(awardId));
		if(value.getStatus().equals(AwardConstant.ACTIVITY_CREATE)){
			//callSysAwardInfo(value,AwardConstant.AWARD_INFO_SYN_HP_OPT_TYPE_DEL);
			return modifyAwardinfoStatus(AwardConstant.ACTIVITY_DELETE,Long.valueOf(awardId));
		}else{
			throw new Exception("只能删除创建中状态的活动");
		}	
	}
	public void recordAwardDescExportlog(String querystr, long staffId, String comType,long orgId) throws Exception {

		BusiInfoUtil.recordBusiInfo(BusiInfoEngine.getNewId().longValue()+ "", 
				CoreConstant.SYS_PARA_BUSI_TYPE_PARTNER_AWARD_EXPORT,
				staffId, "积分抽奖中奖名单导出", 
				CoreConstant.BUSI_INFO_OPT_TYPE_CHECK,
				querystr, staffId, comType, orgId);
		
	}
	public String copyAwardByID(String awardId) throws Exception {
		IAwardInfoValue value = new AwardInfoBean();
		IAwardInfoValue oldvalue =  getAwardInfoById(awardId);
		Long AwardId =AwardInfoEngine.getNewId().longValue();
		value.setAwardId(AwardId);
		value.setAwardName(oldvalue.getAwardName());
	    value.setAwardDesc(oldvalue.getAwardDesc());
	    value.setStatus(AwardConstant.ACTIVITY_CREATE);
	    value.setBaseIntegral(oldvalue.getBaseIntegral());
	    value.setBaseWareId(oldvalue.getBaseWareId());
	    UserInfoInterface user = SessionManager.getUser();
	    value.setRecordStaff(user.getID()+"");
	    value.setContainNotWin(oldvalue.getContainNotWin());
	    value.setCreateDate(DateTimeUtil.getNowTimeStamp());
	    Timestamp starttime = DateTimeUtil.stringToTimestamp(DateTimeUtil.dateAdd(1,
	    		DateTimeUtil.getNowTimeStamp().toString(),CommnConstant.DATETIME_JAVA_FORMAT),
	    		CommnConstant.DATETIME_JAVA_FORMAT);
	    Timestamp endtime = DateTimeUtil.stringToTimestamp(DateTimeUtil.dateAdd(7,
	    		DateTimeUtil.getNowTimeStamp().toString(),CommnConstant.DATETIME_JAVA_FORMAT),
	    		CommnConstant.DATETIME_JAVA_FORMAT);
	  
	    value.setStartTime(starttime);
	    value.setEndTime(endtime);
	    value.setExchangeChannel(oldvalue.getExchangeChannel());
	    value.setMainPic(oldvalue.getMainPic());
	    value.setMaxCount(oldvalue.getMaxCount());
	    value.setNowCount(oldvalue.getMaxCount());
	    value.setOneMaxCount(oldvalue.getOneMaxCount());
	    value.setShowNotWin(oldvalue.getShowNotWin());
	    
	    Timestamp stopgettime = DateTimeUtil.stringToTimestamp(DateTimeUtil.dateAdd(7,
	    		DateTimeUtil.getNowTimeStamp().toString(),CommnConstant.DATETIME_JAVA_FORMAT),
	    		CommnConstant.DATETIME_JAVA_FORMAT);
	   Date d = DateTimeUtil.parse( DateTimeUtil.format(stopgettime, "yyyy-MM-dd 23:59:59"),
	    		"yyyy-MM-dd HH:mm:ss");
	    value.setStopGetTime(new Timestamp(d.getTime()));
	    
	    IClobInfoDAO clobInfoDAO = (IClobInfoDAO) ServiceFactory.getService("ngves.asiainfo.core.clobInfoDAO");
		boolean flag = clobInfoDAO.saveClobInfo(AwardId, AwardConstant.AWARD_TABLE_NAME, value.getAwardDesc());
		value.setAwardDesc("");
		//新增活动的时候，不涉及任何同步HP操作。因为这时候，活动还没有发布。
		AwardId = awardInfoDAO.saveAwardInfo(value);	
		
		IAwardLevelInfoValue[] awardLevels = awardLevelInfoDAO.findByAwardId(Long.parseLong(awardId));
		IAwardLevelInfoValue[] newawardLevels = new AwardLevelInfoBean[awardLevels.length];
		for(int i=0;i<awardLevels.length;i++){
			newawardLevels[i] = new AwardLevelInfoBean(); 
			newawardLevels[i].setAwardId(AwardId);
			newawardLevels[i].setWareId(awardLevels[i].getWareId());
			newawardLevels[i].setWareCode(awardLevels[i].getWareCode());
			newawardLevels[i].setWareNickname(awardLevels[i].getWareNickname());
			newawardLevels[i].setAwardOdds(awardLevels[i].getAwardOdds());
			newawardLevels[i].setMaxCount(awardLevels[i].getMaxCount());
			newawardLevels[i].setIsShowWare(awardLevels[i].getIsShowWare());
			newawardLevels[i].setBgColourCode(awardLevels[i].getBgColourCode());
			newawardLevels[i].setIsDefaultLevel(awardLevels[i].getIsDefaultLevel());
			newawardLevels[i].setLevelSort(awardLevels[i].getLevelSort());
			newawardLevels[i].setBakCol(awardLevels[i].getBakCol());
			newawardLevels[i].setBakCol2(awardLevels[i].getBakCol2());
			newawardLevels[i].setBakCol3(awardLevels[i].getBakCol3());
			newawardLevels[i].setLevelAngle(awardLevels[i].getLevelAngle());
		}
		awardLevelInfoDAO.addAwardLevelInfos(newawardLevels);
		if(flag){
			return AwardId.toString();
		}else{
			return null;
		}
		

	}

	public String continueAward(String awardId, String endTime, String getStopTime) throws Exception {
		IAwardInfoValue value =  awardInfoDAO.queryAwardById(Long.valueOf(awardId));
		if(value.getStatus().equals(AwardConstant.ACTIVITY_PUBLIC)
				&&DateTimeUtil.getDefaultSysDate().after(value.getStartTime())){
			value.setEndTime(DateTimeUtil.stringToTimestamp(endTime,CommnConstant.DATETIME_JAVA_FORMAT));
			value.setStopGetTime(DateTimeUtil.stringToTimestamp(getStopTime,CommnConstant.DATETIME_JAVA_FORMAT));
			//调用抽奖活动规则信息增量同步接口 。 
			callSysAwardInfo(value,AwardConstant.AWARD_INFO_SYN_HP_OPT_TYPE_MODIFY);
		    long AwardId =awardInfoDAO.saveAwardInfo(value);
		    return  String.valueOf(AwardId);
		}else{
			throw new Exception("只能延期进行状态的活动");
		}
	}

	private void callSysAwardInfo(IAwardInfoValue value, String optType) throws Exception {
	
		SynAwardInfoOutBizRegReq out=getSynAwardInfoBizRegReq(value,optType);
		
		if(!(InterConstant.SUCC.equals(out.getRejectReason()))){
			throw new Exception(out.getErrorMsg());
		}
	}
			

	public int countAwardOrderList(String awardId, String mobileNum, String proCode,String awardResult,
			String orderSeq, String startTime,String endtime) throws Exception {
		int sum =getAwardOrderListBizRegReq(awardId,mobileNum, proCode,awardResult,orderSeq, 
				startTime,endtime,-9, -9).getLotterySum();
		return sum;
	}


	public IAwardDescValue[] queryAwardOrderList(String awardId, String mobileNum, String proCode,String awardResult,
			String orderSeq, String startTime, String endtime, int startNum, int endNum) throws Exception {
		IAwardDescValue  values[] = null;
		
		AwardDescInfoQueryOutBizRegReq out = getAwardOrderListBizRegReq(awardId,mobileNum, proCode,awardResult,orderSeq, 
				startTime,endtime,startNum, endNum);
		if (!out.getRejectReason().equals(InterConstant.SUCC)) {
			throw new Exception(out.getErrorMsg());
			
		}else{
			IAwardInfoValue awardInfo =  AwardInfoEngine.getBean(Long.parseLong(awardId));	
			AwardDescInfoQueryOutLotterylist[] list = out.getLotterylistArray();
			values = new AwardDescBean[list.length];
			for(int i = 0 ;i<list.length; i++){
				values[i] = new AwardDescBean();
				values[i].setActionname(awardInfo.getAwardName());
				values[i].setPreOprTime(formatTime(list[i].getPreOprTime()));
				values[i].setOrderID(list[i].getOrderID());
				values[i].setLotteryPoint(list[i].getLotteryPoint()+"");
				if(list[i].getLotteryResult().equals(AwardConstant.AWARD_LOTTERY_RESULT_YES)){
					values[i].setLotteryResult("未中奖");
				}else if(list[i].getLotteryResult().equals(AwardConstant.AWARD_LOTTERY_RESULT_NO)){
					values[i].setLotteryResult("已中奖");
				}else{
					throw new Exception("接口LotteryResult字段："+list[i].getLotteryResult()+"不在[01,02]范围内");
				}
				values[i].setActionEndTime(formatTime(list[i].getActionEndTime()));
				if(list[i].getLotteryResult().equals(AwardConstant.AWARD_LOTTERY_RESULT_NO)){
					if(null == list[i].getGiftInfo()){
						throw new Exception("节点LotteryResult为02-已中奖时，节点GiftInfo不能为空");
					}
					
					
					values[i].setGiftOrderID(list[i].getGiftInfo().getGiftOrderID()+"");
					values[i].setGiftWinTime(formatTime(list[i].getGiftInfo().getGiftWinTime()));
					values[i].setGiftItemID(list[i].getGiftInfo().getGiftItemID());
					values[i].setGiftItemName(list[i].getGiftInfo().getGiftItemName());
					if(list[i].getGiftInfo().getReceiveStatus().equals(AwardConstant.AWARD_RECEIVESTATUS_YES)){
						values[i].setReceiveStatus("已领取");
					}else if(list[i].getGiftInfo().getReceiveStatus().equals(AwardConstant.AWARD_RECEIVESTATUS_NO)){
						values[i].setReceiveStatus("未领取");
					}else{
						throw new Exception("接口ReceiveStatus字段："+list[i].getGiftInfo().getReceiveStatus()
								+"不在[01,02]范围内");
					}
					
					values[i].setLengthenTime(formatTime(list[i].getGiftInfo().getLengthenTime()));
				}
			}
		}
		
		
		return values;
	}

	private String formatTime(String  time)throws Exception {
		if(null!=time||"".equals(time)){
			Timestamp timest=DateTimeUtil.stringToTimestamp(time,CommnConstant.DATETIME_HP_FORMAT);
			return DateTimeUtil.format(timest,CommnConstant.DATETIME_JAVA_FORMAT);
		}
		return null;
	}

	protected SynAwardInfoOutBizRegReq getSynAwardInfoBizRegReq(IAwardInfoValue value, String optType) throws Exception{
		
		SynAwardInfoInBizRegReq in = SynAwardInfoInter.getSynAwardInfoBean();
		in.setOptType(optType);
		
		if(AwardConstant.AWARD_INFO_SYN_HP_OPT_TYPE_ADD.equals(optType)
				||AwardConstant.AWARD_INFO_SYN_HP_OPT_TYPE_MODIFY.equals(optType)){
			SynAwardInfoInRuleInfo ruleInfo = in.addNewRuleInfo();
			ruleInfo.setActionID(AwardConstant.AWARD_RULE_INFO_ACTIONID+String.valueOf(value.getAwardId()));
			ruleInfo.setActionName(value.getAwardName());
			ruleInfo.setOrgID(CommnConstant.INTER_ORG_WEB);
			if(value.getContainNotWin().equals(AwardConstant.AWARD_LEVEL_IS_CONTAIN)){
				ruleInfo.setActionType(AwardConstant.AWARD_NOT_MOST_WARE);			
				ruleInfo.setItemID("");
				ruleInfo.setItemName("");
			}else if(value.getContainNotWin().equals(AwardConstant.AWARD_LEVEL_NOT_CONTAIN)){
				ruleInfo.setActionType(AwardConstant.AWARD_MOST_WARE);	
				IWareInfoValue awardInfo= awardInfoDAO.findLevelInfoByAwardId(value.getAwardId());
				ruleInfo.setItemID(awardInfo.getWareCode());
				ruleInfo.setItemName(awardInfo.getWareName());
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
	// 获取抽奖活动名单列表接口
	protected AwardDescInfoQueryOutBizRegReq getAwardOrderListBizRegReq(String awardId, String mobileNum, String 
			proCode,String awardResult,String orderSeq, String startTime,String endtime,int startNum, int endNum) 
		throws Exception {
		if (startNum == -1 && endNum == -1) {
			startNum = 1;
			endNum = 5000;
		}
		// 获取输入报文对象
		AwardDescInfoQueryInBizRegReq in = AwardDescInfoQueryInter.getAwardDescInfoQueryBean();
		
		if (!StringUtil.isBlank(mobileNum)) {
			in.setMobile(mobileNum);
		} else {
			in.setMobile("");
		}
		in.setOrgID(CommnConstant.INTER_ORG_WEB);

		IAwardInfoValue value= awardInfoDAO.queryAwardById(Long.parseLong(awardId));
		IWareInfoValue ware = WareInfoEngine.getBean(value.getBaseWareId());
		in.setLotteryItemID(ware.getWareCode());
		
		if (!StringUtil.isBlank(awardId)) {
			in.setActionID(AwardConstant.AWARD_RULE_INFO_ACTIONID+awardId);
		} else {
			in.setActionID("");
		}
		if (!StringUtil.isBlank(orderSeq)) {
			in.setOrderID(orderSeq);
		} else {
			in.setOrderID("");
		}
		
		if (!StringUtil.isBlank(proCode)&& !("-1".equals(proCode))) {
			in.setProvince(ProvinceUtil.toHpProvince(proCode));
			
		} else {
			in.setProvince("");
		}
		if(!StringUtil.isBlank(awardResult)){
			in.setLotteryResult(awardResult);
		}else{
			in.setLotteryResult("");
		}
		
		if (!StringUtil.isBlank(startTime)) {
			startTime=startTime.replaceAll("-", "").replaceAll(" ", "").replaceAll(":", "");
			in.setStartTime(startTime);
		} else {
			in.setStartTime("");
		}
		if (!StringUtil.isBlank(endtime)) {
			endtime = endtime.replaceAll("-", "").replaceAll(" ", "").replaceAll(":", "");
			in.setEndTime(endtime);
		} else {
			in.setEndTime("");
		}
		if(!StringUtil.isBlank(startNum+"")){
			in.setSRowNum(startNum);
		}
		if(!StringUtil.isBlank(endNum+"")){
			in.setERowNum(endNum);
		}
		return AwardDescInfoQueryInter.doBusi(in);
	}


	public ClientAwardInfoViewModel[] getClineAwardInfo(String mobileNum,String awardId, 
			String timePrior,String lotteryResult,String OrgID)throws Exception{
		
		Calendar calendar = Calendar.getInstance();
		ClientAwardInfoViewModel[] clientAwardInfoViewModel = null;
		ClientAwardInfoQueryInBizRegReq clientAwardInfoQueryIn = ClientAwardInfoQueryInter.getClientAwardInfoQueryBean();
		
		clientAwardInfoQueryIn.setOrgID(OrgID);
		clientAwardInfoQueryIn.setMobile(mobileNum);
		clientAwardInfoQueryIn.setLotteryResult(lotteryResult);
		clientAwardInfoQueryIn.setSRowNum(1);
		clientAwardInfoQueryIn.setERowNum(5000);
		if(!StringUtil.isBlank(awardId)){
			clientAwardInfoQueryIn.setActionID(CoreConstant.ORDER_AWARD_ACTION_TYPE + awardId);
		}else{
			clientAwardInfoQueryIn.setActionID("");
		}
		
		//结束时间为当前时间
		clientAwardInfoQueryIn.setEndTime(
				DateTimeUtil.dateToString(calendar.getTime(), CommnConstant.DATETIME_HP_FORMAT));
		if("0".equals(timePrior)){
			//开始时间为前30分钟
			calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) - 30);
			clientAwardInfoQueryIn.setStartTime(
					DateTimeUtil.dateToString(calendar.getTime(), CommnConstant.DATETIME_HP_FORMAT));
		}else if("1".equals(timePrior)){
			//开始时间为前一个月
			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
			clientAwardInfoQueryIn.setStartTime(
					DateTimeUtil.dateToString(calendar.getTime(), CommnConstant.DATETIME_HP_FORMAT));
		}else if("2".equals(timePrior)){
			//开始时间为前三个月
			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 3);
			clientAwardInfoQueryIn.setStartTime(
					DateTimeUtil.dateToString(calendar.getTime(), CommnConstant.DATETIME_HP_FORMAT));
		}else if("3".equals(timePrior)){
			//查询全部
			clientAwardInfoQueryIn.setStartTime("");
		}
		
		ClientAwardInfoQueryOutBizRegReq clientAwardInfoQueryOut = ClientAwardInfoQueryInter.doBusi(clientAwardInfoQueryIn);
		if(InterConstant.SUCC.equals(clientAwardInfoQueryOut.getRejectReason())){
			if(null!=clientAwardInfoQueryOut.getLotterylistArray() && 0<clientAwardInfoQueryOut.getLotterylistArray().length){
				clientAwardInfoViewModel = new ClientAwardInfoViewModel[clientAwardInfoQueryOut.getLotterylistArray().length];
				for(int i=0; i<clientAwardInfoQueryOut.getLotterylistArray().length; i++){
					clientAwardInfoViewModel[i] = new ClientAwardInfoViewModel();
					clientAwardInfoViewModel[i].setLotteryPoint(
							clientAwardInfoQueryOut.getLotterylistArray()[i].getLotteryPoint());
					clientAwardInfoViewModel[i].setLotteryResult(
							clientAwardInfoQueryOut.getLotterylistArray()[i].getLotteryResult());
					clientAwardInfoViewModel[i].setOrderID(
							clientAwardInfoQueryOut.getLotterylistArray()[i].getOrderID());
					clientAwardInfoViewModel[i].setActionId(
							clientAwardInfoQueryOut.getLotterylistArray()[i].getActionID());
					String oldPreOprTime = clientAwardInfoQueryOut.getLotterylistArray()[i].getPreOprTime();
					clientAwardInfoViewModel[i].setPreOprTime(DateTimeUtil.dateTrans(oldPreOprTime));
					//抽奖状态为已中奖
					if("02".equals(clientAwardInfoQueryOut.getLotterylistArray()[i].getLotteryResult())){
						if(null != clientAwardInfoQueryOut.getLotterylistArray()[i].getGiftInfo()){
							clientAwardInfoViewModel[i].setGiftOrderID(
									clientAwardInfoQueryOut.getLotterylistArray()[i].getGiftInfo().getGiftOrderID());
							clientAwardInfoViewModel[i].setAwardName(
									clientAwardInfoQueryOut.getLotterylistArray()[i].getGiftInfo().getGiftItemName());
							
							String oldAwardTime = clientAwardInfoQueryOut.getLotterylistArray()[i].getGiftInfo().getGiftWinTime();
							if(!StringUtil.isBlank(oldAwardTime)){
								clientAwardInfoViewModel[i].setAwardTime(DateTimeUtil.dateTrans(oldAwardTime));
							}else{
								clientAwardInfoViewModel[i].setAwardTime("");
							}
							
							clientAwardInfoViewModel[i].setReceiveStatus(
									clientAwardInfoQueryOut.getLotterylistArray()[i].getGiftInfo().getReceiveStatus());
							String oldThenTime = clientAwardInfoQueryOut.getLotterylistArray()[i].getGiftInfo().getLengthenTime();
							clientAwardInfoViewModel[i].setLengthenTime(DateTimeUtil.dateTrans(oldThenTime));
							clientAwardInfoViewModel[i].setGiftItemID(
									clientAwardInfoQueryOut.getLotterylistArray()[i].getGiftInfo().getGiftItemID());
							clientAwardInfoViewModel[i].setGiftSubOrderID(
									clientAwardInfoQueryOut.getLotterylistArray()[i].getGiftInfo().getGiftSubOrderID());
							clientAwardInfoViewModel[i].setShippingSeq(
									clientAwardInfoQueryOut.getLotterylistArray()[i].getGiftInfo().getShippingSeq());
							
							
						}
					}
					
				}
			}
			
			
		}
		
		
		return clientAwardInfoViewModel;
	}
@SuppressWarnings("unchecked")
public Map[] queryClientAwardInfo(String mobileNum,String awardId, 
		String timePrior,String lotteryResult,String OrgID)throws Exception{
	List<Map<String,Object>> retList = new ArrayList<Map<String,Object>>();
	Map<String,Object> retMap =null;

	ClientAwardInfoViewModel[] clientAwardInfoViewModel =getClineAwardInfo( mobileNum, awardId,timePrior, lotteryResult, OrgID);
	if(null!=clientAwardInfoViewModel&&0<clientAwardInfoViewModel.length){
		for(ClientAwardInfoViewModel bean:clientAwardInfoViewModel){
			retMap = new HashMap<String,Object>();
			retMap.put("orderID", bean.getOrderID());
			retMap.put("preOprTime", bean.getPreOprTime());
			retMap.put("lotteryPoint", bean.getLotteryPoint());
			retMap.put("lotteryResult", bean.getLotteryResult());
			retMap.put("actionId", bean.getActionId());
			retMap.put("giftItemId", bean.getGiftItemID());
			retMap=setResultAndUrl( bean,retMap);
			retList.add(retMap);
		}
	}
	return (Map[])retList.toArray(new Map[retList.size()]);
}
private Map<String, Object> setResultAndUrl(ClientAwardInfoViewModel bean,Map<String, Object> retMap)throws Exception{
	long nowTime = DateTimeUtil.getNowDate().getTime();
	String awardStatus=bean.getLotteryResult();
	String receiveStatus=bean.getReceiveStatus();
	String status="";
	String detailUrl="";
	String deliverUrl="";
	String showButton="";
	if("01".equals(awardStatus)){
		status="未中奖";
	}else if("02".equals(awardStatus)&&"02".equals(receiveStatus)){
		status="已中奖未领取";
	}else if("02".equals(awardStatus)&&"01".equals(receiveStatus)){
		status="已中奖已领取";

	}
	if("02".equals(awardStatus)){
		//查看详细
		detailUrl="/portal/award/web/AwardInfoAction?action=queryAwardOrderDetail&orderId="+bean.getGiftOrderID()+"&bigOrderId="+bean.getOrderID()
		+"&receiveStatus="+bean.getReceiveStatus() +"&lengthenTime="+bean.getLengthenTime()+"&wareCode="+bean.getGiftItemID();
		if("02".equals(awardStatus) && "01".equals(receiveStatus)){
            //配送信息
			deliverUrl="/portal/user/web/UserOrderQueryAction?action=queryDelivStatus&orderType=lottery&subOrderId="+bean.getGiftSubOrderID()+"&packSeq=";
			if("".equals(bean.getShippingSeq())){
				deliverUrl=deliverUrl+"000";
			}else{
				deliverUrl=deliverUrl+bean.getShippingSeq();
			}
	    } 
		if("02".equals(awardStatus) && "02".equals(receiveStatus)
       		 && (DateTimeUtil.stringToDate(bean.getLengthenTime(),CommnConstant.DATETIME_JAVA_FORMAT).getTime()>= nowTime)){ 
			showButton="show";
    	} 
	}
	
	retMap.put("status", status);
	retMap.put("detailUrl", detailUrl);
	retMap.put("deliverUrl", deliverUrl);
	retMap.put("showButton", showButton);
	return retMap;
}
}
