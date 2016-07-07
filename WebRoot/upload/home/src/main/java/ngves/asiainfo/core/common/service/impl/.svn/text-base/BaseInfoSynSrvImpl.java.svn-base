package ngves.asiainfo.core.common.service.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.StarUtil;
import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.common.bo.BaseInfoSynBean;
import ngves.asiainfo.core.common.bo.UpdateNotifyInfoBean;
import ngves.asiainfo.core.common.dao.interfaces.IBaseInfoSynDAO;
import ngves.asiainfo.core.common.ivalues.IBaseInfoSynValue;
import ngves.asiainfo.core.common.ivalues.IUpdateNotifyInfoValue;
import ngves.asiainfo.core.common.model.GrantResultListBean;
import ngves.asiainfo.core.common.model.PointGrantQueryBean;
import ngves.asiainfo.core.common.model.PointQueryInfoBean;
import ngves.asiainfo.core.common.model.PointTypeInfoBean;
import ngves.asiainfo.core.common.model.PointUseQueryBean;
import ngves.asiainfo.core.common.model.UseResultListBean;
import ngves.asiainfo.core.common.service.interfaces.IBaseInfoSynSrv;
import ngves.asiainfo.interfaces.InterConstant;
import ngves.asiainfo.interfaces.hp.ProvinceUtil;
import ngves.asiainfo.interfaces.hp.bean.pointGrantQuery.in.PointGrantQueryInBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.pointGrantQuery.out.PointGrantQueryOutBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.pointGrantQuery.out.PointGrantQueryOutResultList;
import ngves.asiainfo.interfaces.hp.bean.pointQuery.in.PointQueryInBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.pointQuery.out.PointQueryOutBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.pointQuery.out.PointQueryOutUserInfo;
import ngves.asiainfo.interfaces.hp.bean.pointUseQuery.in.PointUseQueryInBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.pointUseQuery.out.PointUseQueryOutBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.pointUseQuery.out.PointUseQueryOutResultList;
import ngves.asiainfo.interfaces.hp.realtime.PointGrantQueryInter;
import ngves.asiainfo.interfaces.hp.realtime.PointQueryInter;
import ngves.asiainfo.interfaces.hp.realtime.PointUseQueryInter;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseInfoSynSrvImpl implements IBaseInfoSynSrv {

    private IBaseInfoSynDAO baseInfoSynDAO = null;
    private static transient Log log = LogFactory.getLog(BaseInfoSynSrvImpl.class);

	public void addSynInfo(String infoType, long infoId, String infoState) throws Exception {
		IBaseInfoSynValue synInfo = null;
    	IUpdateNotifyInfoValue notifyInfo = null;
        if (!StringUtil.isBlank(infoType) && !StringUtil.isBlank(infoState)) {
        	synInfo = new BaseInfoSynBean();
            synInfo.setSynInfoType(infoType);
            synInfo.setInfoId(infoId);
            synInfo.setSynState(infoState);
            synInfo.setSynInfoState(CoreConstant.SYS_PARA_SYN_STATE_WAIT);
            synInfo.setStsToNew();
            baseInfoSynDAO.saveSynInfos(new IBaseInfoSynValue[] { synInfo });
        }
        
        //如果是礼品信息发生变更，需要同时插入通知表
        if(!StringUtil.isBlank(infoType) && infoType.equals(CoreConstant.SYS_PARA_SYN_TYPE_WARE)) {
        	notifyInfo = new UpdateNotifyInfoBean();
        	notifyInfo.setNotifyType(infoType);
        	notifyInfo.setItemId(infoId);
        	notifyInfo.setItemStatus(infoState);
        	notifyInfo.setStatus(CoreConstant.SYS_PARA_SYN_STATE_WAIT);
        	notifyInfo.setRelationId(synInfo.getSynId());
        	baseInfoSynDAO.saveNotifyInfo(new IUpdateNotifyInfoValue[] { notifyInfo });
        }
	}

	public void addSynInfo(String infoType, long infoId, String infoState, Timestamp validDate) throws Exception {
		 IBaseInfoSynValue synInfo = null;
	        if (!StringUtil.isBlank(infoType) && !StringUtil.isBlank(infoState)) {
	            synInfo = new BaseInfoSynBean();
	            synInfo.setSynInfoType(infoType);
	            synInfo.setInfoId(infoId);
	            synInfo.setSynState(infoState);
	            synInfo.setSynInfoState(CoreConstant.SYS_PARA_SYN_STATE_WAIT);
	            synInfo.setSynEndTime(validDate);
	            synInfo.setStsToNew();
	            baseInfoSynDAO.saveSynInfos(new IBaseInfoSynValue[] { synInfo });
	        }
	}

	public IBaseInfoSynValue[] getBaseInfoSynValueByType(String infoType, String infoState) throws Exception {
		StringBuffer condition = new StringBuffer("1=1");
		Map<String, String> parameter = new HashMap<String, String>();
		if(!StringUtil.isBlank(infoState)&&!StringUtil.isBlank(infoType)){
			condition.append(" AND ").append(IBaseInfoSynValue.S_SynInfoType).append("=:").append(
					IBaseInfoSynValue.S_SynInfoType);
			parameter.put(IBaseInfoSynValue.S_SynInfoType, infoType);
			condition.append(" AND ").append(IBaseInfoSynValue.S_SynInfoState).append("=:").append(
					IBaseInfoSynValue.S_SynInfoState);
			parameter.put(IBaseInfoSynValue.S_SynInfoState, infoState);
		}
		
		return baseInfoSynDAO.querySynInfos(condition.toString(), parameter);
	}

	public void setBaseInfoSynDAO(IBaseInfoSynDAO baseInfoSynDAO) throws Exception {
		this.baseInfoSynDAO = baseInfoSynDAO;
	}
	
	public PointQueryInfoBean getPointQueryDesc(String orgID, String orgName,
			String mobileNum) throws Exception {

		PointQueryInfoBean pointQueryBean = new PointQueryInfoBean();
		
		PointQueryInBizRegReq pointQueryIn = PointQueryInter.getPointQueryBean();
		pointQueryIn.setOrgID(orgID);
		pointQueryIn.setOrgName(orgName);
		pointQueryIn.setMobileNum(mobileNum);
		PointQueryOutBizRegReq pointQueryOut = PointQueryInter.doBusi(pointQueryIn);
		
		pointQueryBean.setErrorMsg(pointQueryOut.getErrorMsg());
		pointQueryBean.setReturnXml(PointQueryInter.format(pointQueryOut));
		pointQueryBean.setIsSuccess(pointQueryOut.getRejectReason());
		
		if (pointQueryOut.getRejectReason().equals(InterConstant.SUCC)) {
			PointQueryOutUserInfo pointQueryOutUserInfo = pointQueryOut.getUserInfo();
			
			pointQueryBean.setUserBrand(pointQueryOutUserInfo.getUserBrand());
			pointQueryBean.setUserLevel(pointQueryOutUserInfo.getUserLevel());
			pointQueryBean.setStarLevel(pointQueryOutUserInfo.getStarLevel());
	
			pointQueryBean.setValidateStartTime(pointQueryOutUserInfo.getValidateStartTime());
			pointQueryBean.setUserStatus(pointQueryOutUserInfo.getUserStatus());
			pointQueryBean.setMobileNum(pointQueryOut.getMobile());
			pointQueryBean.setUserProvince(ProvinceUtil.getProvinceNameByHpProvince(pointQueryOut.getProvince()));
			pointQueryBean.setUserScore(pointQueryOutUserInfo.getUserScore());
			pointQueryBean.setMobileNum(mobileNum);
			pointQueryBean.setPointQueryInfoView();
			//用户总积分（包含可用积分、未生效的促销回馈积分、冻结积分等、包括消费积分+促销积分）
			pointQueryBean.setTotalPoint(pointQueryOutUserInfo.getTotalPoint());
			if(StarUtil.isSupportStar(ProvinceUtil.toVesProvince(pointQueryOut.getProvince()))){
				pointQueryBean.setStarLevelValue(pointQueryOutUserInfo.getStarLevel());
			}else{
			    pointQueryBean.setUserBrandValue(pointQueryOutUserInfo.getUserBrand());
			}
			if(null != pointQueryOutUserInfo.getPointTypeInfoArray() && 0<pointQueryOutUserInfo.getPointTypeInfoArray().length){
				int pointTypeCount = pointQueryOutUserInfo.getPointTypeInfoArray().length;
				PointTypeInfoBean[] pointTypeBean = new PointTypeInfoBean[pointTypeCount];
				
				for(int i=0; i<pointTypeCount;i++){
					pointTypeBean[i] = new PointTypeInfoBean();
					pointTypeBean[i].setPointSum(pointQueryOutUserInfo.getPointTypeInfoArray()[i].getPointSum());
					pointTypeBean[i].setPointType(pointQueryOutUserInfo.getPointTypeInfoArray()[i].getPointType());
					pointTypeBean[i].setValidateTime(pointQueryOutUserInfo.getPointTypeInfoArray()[i].getValidateTime());
					pointTypeBean[i].setPointTypeInfoView();
				}
				pointQueryBean.setPointTypeInfo(pointTypeBean);
				pointQueryBean.setPointTypeHtmlTr(getPointTypeInfoHtmlTr(pointTypeBean));
			}
			
		}else{
			log.info("The Method PointQueryDescUtil.getPointQueryDesc is error. errorMessage>"+pointQueryOut.getErrorMsg());
			pointQueryBean = null;
		}
		
		return pointQueryBean;
	}

	public PointGrantQueryBean getPointGrantQueryInfo(String orgID,
			String orgName, String mobileNum, String searchDateType)
			throws Exception {

		PointGrantQueryBean pointGrantQueryBean = new PointGrantQueryBean();
		Calendar calendar = Calendar.getInstance();
		String nowTime =  DateTimeUtil.dateToString(calendar.getTime(), "yyyyMMdd");
		
		PointGrantQueryInBizRegReq pointGrantQueryIn = PointGrantQueryInter.getPointGrantQueryBean();
		pointGrantQueryIn.setOrgID(orgID);
		pointGrantQueryIn.setOrgName(orgName);
		pointGrantQueryIn.setMobileNum(mobileNum);
		pointGrantQueryIn.setStartTime(getDateTimeStrByType(searchDateType));
		pointGrantQueryIn.setEndTime(nowTime);
		PointGrantQueryOutBizRegReq pointGrantQueryOut = PointGrantQueryInter.doBusi(pointGrantQueryIn);
		
		pointGrantQueryBean.setErrorMsg(pointGrantQueryOut.getErrorMsg());
		pointGrantQueryBean.setIsSuccess(pointGrantQueryOut.getRejectReason());
		
		if (pointGrantQueryOut.getRejectReason().equals(InterConstant.SUCC)) {
			PointGrantQueryOutResultList[] pointQueryResultList = pointGrantQueryOut.getResultListArray();
			
			if(null!=pointQueryResultList && 0<pointQueryResultList.length){
				GrantResultListBean[] grantResultList = new GrantResultListBean[pointQueryResultList.length];
				
				for(int i=0; i<pointQueryResultList.length;i++){
					grantResultList[i] = new GrantResultListBean();
					grantResultList[i].setReleasePoint(pointQueryResultList[i].getReleasePoint());
					grantResultList[i].setReleasePointType(pointQueryResultList[i].getReleasePointType());
					grantResultList[i].setReleaseTime(pointQueryResultList[i].getReleaseTime());
					grantResultList[i].setValidateTime(pointQueryResultList[i].getValidateTime());
					grantResultList[i].setComments(pointQueryResultList[i].getComments());
					grantResultList[i].setPointTypeInfoView();
				}
				pointGrantQueryBean.setGrandResultList(grantResultList);
				pointGrantQueryBean.setPointTypeHtmlTr(getPointGrantInfoHtmlTr(grantResultList));
			}
			
		}else{
			log.info("The Method PointQueryDescUtil.getPointGrantQueryInfo is error. errorMessage>"+pointGrantQueryOut.getErrorMsg());
			pointGrantQueryBean = null;
		}
		
		return pointGrantQueryBean;
	}

	public PointUseQueryBean getPointUseQueryInfo(String orgID, String orgName,
			String mobileNum, String searchDateType) throws Exception {
		PointUseQueryBean pointUseQueryBean = new PointUseQueryBean();
		Calendar calendar = Calendar.getInstance();
		String nowTime =  DateTimeUtil.dateToString(calendar.getTime(), "yyyyMMdd");
		
		PointUseQueryInBizRegReq pointUseQueryIn = PointUseQueryInter.getPointUseQueryBean();
		pointUseQueryIn.setOrgID(orgID);
		pointUseQueryIn.setOrgName(orgName);
		pointUseQueryIn.setMobileNum(mobileNum);
		pointUseQueryIn.setStartTime(getDateTimeStrByType(searchDateType));
		pointUseQueryIn.setEndTime(nowTime);
		PointUseQueryOutBizRegReq pointUseQueryOut = PointUseQueryInter.doBusi(pointUseQueryIn);
		
		pointUseQueryBean.setErrorMsg(pointUseQueryOut.getErrorMsg());
		pointUseQueryBean.setIsSuccess(pointUseQueryOut.getRejectReason());
		
		if (pointUseQueryOut.getRejectReason().equals(InterConstant.SUCC)) {
			PointUseQueryOutResultList[] pointQueryResultList = pointUseQueryOut.getResultListArray();
			
			if(null!=pointQueryResultList && 0<pointQueryResultList.length){
				UseResultListBean[] useResultList = new UseResultListBean[pointQueryResultList.length];
				
				for(int i=0; i<pointQueryResultList.length;i++){
					useResultList[i] = new UseResultListBean();
					useResultList[i].setUsePoint(pointQueryResultList[i].getUsePoint());
					useResultList[i].setUseTime(pointQueryResultList[i].getUseTime());
					useResultList[i].setComments(pointQueryResultList[i].getComments());
					useResultList[i].setUseWayCode(pointQueryResultList[i].getUseWayCode());
					useResultList[i].setUseWayDesc(pointQueryResultList[i].getUseWayDesc());
					useResultList[i].setPointTypeInfoView();
				}
				pointUseQueryBean.setUseResultList(useResultList);
				pointUseQueryBean.setPointTypeHtmlTr(getPointUseInfoHtmlTr(useResultList));
				
			}
			
		}else{
			log.info("The Method PointQueryDescUtil.getPointUseQueryInfo is error. errorMessage>"+pointUseQueryOut.getErrorMsg());
			pointUseQueryBean = null;
		}
		
		return pointUseQueryBean;
	}
	
	
	/**
	 * 根据查询类型返回指定的查询起始时间
	 * @param searchDateType
	 * @return
	 * @throws Exception
	 */
	private static String getDateTimeStrByType(String searchDateType)throws Exception{
		
		Calendar calendar = Calendar.getInstance();
		String startMonthDate ="";

		if("00".equals(searchDateType)){
			//获取前一个月
			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
			startMonthDate = DateTimeUtil.dateToString(calendar.getTime(), "yyyyMMdd");
		}else if("01".equals(searchDateType)){
			//获取前三个月
			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 3);
			startMonthDate = DateTimeUtil.dateToString(calendar.getTime(), "yyyyMMdd");
		}else if("02".equals(searchDateType)){
			//获取前六个月
			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 6);
			startMonthDate = DateTimeUtil.dateToString(calendar.getTime(), "yyyyMMdd");
		}else if("03".equals(searchDateType)){
			//获取前十二个月
			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 12);
			startMonthDate = DateTimeUtil.dateToString(calendar.getTime(), "yyyyMMdd");
		}else{
			startMonthDate = DateTimeUtil.dateToString(calendar.getTime(), "yyyyMMdd");
		}
		
		return startMonthDate;
	}
	
	
	/**
	 * 将积分详细查询PointTypeInfo结点转成HTML
	 * @param pointTypeBean
	 * @return
	 * @throws Exception
	 */
	private static String getPointTypeInfoHtmlTr(PointTypeInfoBean[] pointTypeBean)throws Exception{
		
		StringBuffer stringBuffer = new StringBuffer();
		if (null != pointTypeBean && 0<pointTypeBean.length) {
			for (PointTypeInfoBean resultBean :pointTypeBean) {
				stringBuffer.append("<tr class='GD-Total-TR'>");
				if("01".equals(resultBean.getPointType())){
					stringBuffer.append("<td align='center'>消费积分</td>");
				}
				if("02".equals(resultBean.getPointType())){
					stringBuffer.append("<td align='center'>促销回馈积分</td>");
				}
				
				stringBuffer.append("<td align='center'>"+resultBean.getPointSum()+"</td>");
				stringBuffer.append("<td align='center'>"+resultBean.getValidateTime()+"</td>");
				stringBuffer.append("</tr>");
			}
		}else{
			stringBuffer.append("");
		}
		
		return stringBuffer.toString();
	}
	
	/**
	 * 将积分发放查询PointTypeInfo结点转成HTML
	 * @param pointTypeBean
	 * @return
	 * @throws Exception
	 */
	private static String getPointGrantInfoHtmlTr(GrantResultListBean[] grantResultList)throws Exception{
		
		StringBuffer stringBuffer = new StringBuffer();
		if (null != grantResultList && 0<grantResultList.length) {
			for (GrantResultListBean resultBean :grantResultList) {
				stringBuffer.append("<tr class='GD-Total-TR'>");
				stringBuffer.append("<td align='center'>"+resultBean.getReleaseTime()+"</td>");
				stringBuffer.append("<td align='center'>"+resultBean.getReleasePointType()+"</td>");
				stringBuffer.append("<td align='center'>"+resultBean.getReleasePoint()+"</td>");
				stringBuffer.append("<td align='center'>"+resultBean.getValidateTime()+"</td>");
				stringBuffer.append("<td align='center'>"+resultBean.getComments()+"</td>");
				stringBuffer.append("</tr>");
			}
		}else{
			stringBuffer.append("");
		}
		
		return stringBuffer.toString();
	}
	
	/**
	 * 将积分使用查询PointTypeInfo结点转成HTML
	 * @param pointTypeBean
	 * @return
	 * @throws Exception
	 */
	private static String getPointUseInfoHtmlTr(UseResultListBean[] useResultList)throws Exception{
		
		StringBuffer stringBuffer = new StringBuffer();
		if (null != useResultList && 0<useResultList.length) {
			for (UseResultListBean resultBean :useResultList) {
				stringBuffer.append("<tr class='GD-Total-TR'>");
				stringBuffer.append("<td align='center'>"+resultBean.getUseTime()+"</td>");
				stringBuffer.append("<td align='center'>"+resultBean.getUsePoint()+"</td>");
				stringBuffer.append("<td align='center'>"+resultBean.getComments()+"</td>");
				stringBuffer.append("</tr>");
			}
		}else{
			stringBuffer.append("");
		}
		
		return stringBuffer.toString();
	}
	


}
