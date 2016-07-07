package ngves.asiainfo.core.custom.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.custom.AllegeConstant;
import ngves.asiainfo.core.custom.dao.interfaces.IAllegeAssignInfoDAO;
import ngves.asiainfo.core.custom.dao.interfaces.IAllegeInfoDAO;
import ngves.asiainfo.core.custom.ivalues.IAllegeAssignDealInfoValue;
import ngves.asiainfo.core.custom.ivalues.IAllegeInfoValue;
import ngves.asiainfo.core.custom.ivalues.IQBOPartnerAllegeInfoValue;
import ngves.asiainfo.core.custom.service.interfaces.IAllegeInfoSrv;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings("unchecked")
public class AllegeInfoSrvImpl implements IAllegeInfoSrv {

	private static transient Log log = LogFactory.getLog(AllegeInfoSrvImpl.class);
	private String ALLEGE_HISTORY_LINK = "处理历史";

	private String ALLEGE_PROCESS_LINK = "处理";
	protected int ROWS_NUM_ZERO = 0;
	
	


	private IAllegeInfoDAO allegeInfoDAO = null;

	public void setAllegeInfoDAO(IAllegeInfoDAO allegeInfoDAO) throws Exception {
		this.allegeInfoDAO = allegeInfoDAO;
	}

	private IAllegeAssignInfoDAO allegeAssignInfoDAO=null;
		
	public void setAllegeAssignInfoDAO(IAllegeAssignInfoDAO allegeAssignInfoDAO) throws Exception{
		this.allegeAssignInfoDAO = allegeAssignInfoDAO;
	}

	public int countNewQueryAllegeInfo(String orderId, String allegeKind, String allegeLevel, String partnerId,
			String provinceCode, String staffId, String timeSelect, String startTime, String endTime,
			String allegeStatus, String mobilePhone, String overTime, String partnerType, String sendProvince,
			String exchangeChannel, String acceptOpId, String allegeSubKind, String userBrand, String userLevel,
			String indictseq, String indictStatus,String comType) throws Exception {

		//如果没有开始时间，结束时间和手机号码，那么返回0
		if (StringUtil.isBlank(startTime) && StringUtil.isBlank(endTime) && StringUtil.isBlank(mobilePhone)) {
			log.debug("there is no data..");
			return ROWS_NUM_ZERO;
		}
		List result = processNewCondition(allegeKind, allegeLevel, allegeStatus, provinceCode, mobilePhone, orderId,
				null, overTime, staffId, partnerType, partnerId, sendProvince, timeSelect, startTime, endTime, false,
				exchangeChannel, acceptOpId, allegeSubKind, null, indictseq, indictStatus,comType);

		List newResult2 = addCondUser(result, userBrand, userLevel);

		int num = allegeInfoDAO.countAllegeInfos((String) newResult2.get(0), (Map) newResult2.get(1));
		return num;
	}

	public int countPartnerAllAllegeInfo(String orderId, String allegeKind, String allegeLevel, String partnerId,
			String provinceCode, String staffId, String timeSelect, String startTime, String endTime,
			String allegeStatus, String mobilePhone, String overTime, String partnerType, String sendProvince,
			String exchangeChannel, String acceptOpId, String allegeParentKind, String indictSeq, String indictStatus,String comType)
			throws Exception {
		if (StringUtil.isBlank(startTime) && StringUtil.isBlank(endTime) && StringUtil.isBlank(mobilePhone)) {
			return ROWS_NUM_ZERO;
		}
		List result = processCondition(allegeKind, allegeLevel, allegeStatus, provinceCode, mobilePhone, orderId, null,
				overTime, staffId, null, null, sendProvince, timeSelect, startTime, endTime, false, exchangeChannel,
				acceptOpId, allegeParentKind, null, indictSeq, indictStatus,comType);
		return allegeInfoDAO.countPartnerAllegeInfo((String) result.get(0), (Map) result.get(1), partnerId);
	}



	public IAllegeInfoValue[] getNewQueryAllegeInfo(String orderId, String allegeKind, String allegeLevel,
			String partnerId, String provinceCode, String staffId, String timeSelect, String startTime, String endTime,
			String allegeStatus, String mobilePhone, String overTime, String partnerType, String sendProvince,
			String exchangeChannel, String acceptOpId, String allegeSubKind, String userBrand, String userLevel,
			String indictseq, String indictStatus,String comType, int startIndex, int endIndex) throws Exception {

		//开始时间，结束时间，同时手机号都为空，那么返回空值
		if (StringUtil.isBlank(startTime) && StringUtil.isBlank(endTime) && StringUtil.isBlank(mobilePhone)) {
			IAllegeInfoValue[] result = {};
			return result;
		}
		List result = processNewCondition(allegeKind, allegeLevel, allegeStatus, provinceCode, mobilePhone, orderId,
				null, overTime, staffId, partnerType, partnerId, sendProvince, timeSelect, startTime, endTime, false,
				exchangeChannel, acceptOpId, allegeSubKind, null, indictseq, indictStatus,comType);

		List newResult2 = addCondUser(result, userBrand, userLevel);

		String cond = newResult2.get(0) + " order by " + IAllegeInfoValue.S_AcceptDate + " desc";
		newResult2.set(0, cond);
		IAllegeInfoValue[] allegeInfos = allegeInfoDAO.queryAllegeInfos((String) newResult2.get(0), (Map) newResult2
				.get(1), startIndex, endIndex);
		if (null != allegeInfos) {
			for (IAllegeInfoValue allegeInfo : allegeInfos) {
				allegeInfo.setBakCol2(ALLEGE_HISTORY_LINK);
				allegeInfo.setBakCol3(ALLEGE_PROCESS_LINK);
			}
		}
		for (IAllegeInfoValue allegeInfo : allegeInfos) {
	        StringBuffer condition = new StringBuffer();
	        Map parameter = new HashMap();
	        condition.append(IAllegeAssignDealInfoValue.S_AllegeId).append(
			" = :").append("allegeAssignId")
			.append(" and ");
	        condition.append(IAllegeAssignDealInfoValue.S_DealResult).append(
			" = :").append("dealResult")
			.append(" and ");
	        parameter.put("allegeAssignId",allegeInfo.getAllegeId());
	        parameter.put("dealResult",0);
	        condition.append(" 1=1 ");
			int count=allegeAssignInfoDAO.countAllegeAssignInfo(condition.toString(), parameter);
			allegeInfo.setBakCol4(String.valueOf(count));
		}
		return allegeInfos;
	}

	public IQBOPartnerAllegeInfoValue[] queryPartnerAllAllegeInfo(String orderId, String allegeKind,
			String allegeLevel, String partnerId, String provinceCode, String staffId, String timeSelect,
			String startTime, String endTime, String allegeStatus, String mobilePhone, String overTime,
			String partnerType, String sendProvince, String exchangeChannel, String acceptOpId,
			String allegeParentKind, String indictSeq, String indictStatus,String comType, int startIndex, int endIndex)
			throws Exception {
		if (StringUtil.isBlank(startTime) && StringUtil.isBlank(endTime) && StringUtil.isBlank(mobilePhone)) {
			IQBOPartnerAllegeInfoValue[] result = {};
			return result;
		}
		List result = processCondition(allegeKind, allegeLevel, allegeStatus, provinceCode, mobilePhone, orderId, null,
				overTime, staffId, null, null, sendProvince, timeSelect, startTime, endTime, false, exchangeChannel,
				acceptOpId, allegeParentKind, null, indictSeq, indictStatus,comType);

		String cond = result.get(0) + " order by " + IQBOPartnerAllegeInfoValue.S_AcceptDate + " desc";
		result.set(0, cond);
		IQBOPartnerAllegeInfoValue[] allegeInfos = allegeInfoDAO.queryPartnerAllegeInfo((String) result.get(0),
				(Map) result.get(1), partnerId, startIndex, endIndex);
		if (null != allegeInfos) {
			for (IQBOPartnerAllegeInfoValue allegeInfo : allegeInfos) {
				allegeInfo.setBakCol2(ALLEGE_HISTORY_LINK);
			}
		}
		return allegeInfos;
	}

	private List processCondition(String allegeKind, String allegeLevel, String allegeState, String provinceCode,
			String mobilePhone, String orderId, String subOrderId, String overTime, String staffID, String partnerType,
			String partnerId, String sendProvince, String timeSelect, String startTime, String endTime,
			boolean isPartnerQuery, String exchangeChannel, String acceptOpId, String allegeSubKind,
			String allegeSendStatus, String indictSeq, String indictStatus,String comType) {
		List result = new ArrayList();
		StringBuffer condition = new StringBuffer(" 1=1");
		Map<String, String> parameter = new HashMap<String, String>();

		//当登录用户的角色为“省业务管理员”或“省客服”，在查询投诉单时，增加下面查询条件 （2010-12-01 客服基地改造）
		
		if(CoreConstant.SYS_PARA_USER_PROVINCE_COMPANY.equals(comType) || CoreConstant.SYS_PARA_USER_PROVINCE_CUSTOM.equals(comType) ){
			condition.append(" AND ").append(IAllegeInfoValue.S_ComTypeId).append("=:").append(
					IAllegeInfoValue.S_ComTypeId);
			parameter.put(IAllegeInfoValue.S_ComTypeId, CoreConstant.SYS_PARA_USER_PROVINCE_COMPANY);
		}
		
		if(CoreConstant.SYS_PARA_USER_HEAD_COMPANY.equals(comType)&& StringUtil.isBlank(allegeSendStatus)){
//			 //客服基地人员在我受理的投诉单，可以查询到分配给他的，省公司录入投诉单
//			condition.append(" AND ").append(IAllegeInfoValue.S_AcceptComType).append("=:").append(
//					IAllegeInfoValue.S_AcceptComType);
//			parameter.put(IAllegeInfoValue.S_AcceptComType, CoreConstant.SYS_PARA_USER_HEAD_COMPANY);

			/** 客服基地录入的投诉分配给“省客服”后，客服基地人员不能查询到该投诉单；（仅限客服基地录入功能的查询） **/
			condition.append(" AND ").append(IAllegeInfoValue.S_ComTypeId).append("=:").append(
					IAllegeInfoValue.S_ComTypeId);
			parameter.put(IAllegeInfoValue.S_ComTypeId, CoreConstant.SYS_PARA_USER_HEAD_COMPANY);
		}
		
		
		/** 当登录用户的角色为“省业务管理员”或“省客服”，在查询投诉单时，增加下面查询条件 （2010-12-01 客服基地改造） **/
		// UserInfoInterface user = SessionManager.getUser();
		// MgtUserInfo userInfo = (MgtUserInfo)
		// user.get(MgtConstant.MGT_USER_INFO);
		// if (null != userInfo) {
		// if
		// ((MgtCmmnConstant.SYS_PARA_USER_PROVINCE_COMPANY).equals(userInfo.getComType())
		// ||
		// (MgtCmmnConstant.SYS_PARA_USER_PROVINCE_CUSTOM).equals(userInfo.getComType()))
		// {
		// condition.append(" AND ").append(IAllegeInfoValue.S_ComTypeId).append("=:").append(
		// IAllegeInfoValue.S_ComTypeId);
		// parameter.put(IAllegeInfoValue.S_ComTypeId,
		// MgtCmmnConstant.SYS_PARA_USER_PROVINCE_COMPANY);
		// }
		//
		// /** 客服基地二阶段的调整，客服基地人员只能够查询由客服基地人员录入的投诉（咨询）单 （2010-12-06） **/
		// if
		// ((MgtCmmnConstant.SYS_PARA_USER_HEAD_COMPANY).equals(userInfo.getComType())
		// && StringUtil.isBlank(allegeSendStatus)) {
		// //客服基地人员在我受理的投诉单，可以查询到分配给他的，省公司录入投诉单
		// //condition.append(" AND ").append(IAllegeInfoValue.S_AcceptComType).append("=:").append(
		// // IAllegeInfoValue.S_AcceptComType);
		// //parameter.put(IAllegeInfoValue.S_AcceptComType,
		// MgtCmmnConstant.SYS_PARA_USER_HEAD_COMPANY);
		//
		// /** 客服基地录入的投诉分配给“省客服”后，客服基地人员不能查询到该投诉单；（仅限客服基地录入功能的查询）**/
		// condition.append(" AND ").append(IAllegeInfoValue.S_ComTypeId).append("=:").append(
		// IAllegeInfoValue.S_ComTypeId);
		// parameter.put(IAllegeInfoValue.S_ComTypeId,
		// MgtCmmnConstant.SYS_PARA_USER_HEAD_COMPANY);
		// }
		// }
		// ** 客服基地二阶段的调整，增加总部客服基地人员可以查询分配和未分配 （2010-12-09） **/
		if (!StringUtil.isBlank(allegeSendStatus)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_AssignStatus).append("=:").append(
					IAllegeInfoValue.S_AssignStatus);
			parameter.put(IAllegeInfoValue.S_AssignStatus, allegeSendStatus);
		}

		if (!StringUtil.isBlank(allegeKind)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_AllegeParentKind).append("=:").append(
					IAllegeInfoValue.S_AllegeParentKind);
			parameter.put(IAllegeInfoValue.S_AllegeParentKind, allegeKind);
		}

		if (!StringUtil.isBlank(allegeSubKind)) {
			if (allegeSubKind.indexOf(AllegeConstant.SPLIT_SEMCOLON) >= 0) {
				condition.append(" AND ").append(IAllegeInfoValue.S_AllegeKindId).append(" IN (").append(
						allegeSubKind.replaceAll(AllegeConstant.SPLIT_SEMCOLON, AllegeConstant.SPLIT_COMMA)).append(
						" )");
			} else {
				condition.append(" AND ").append(IAllegeInfoValue.S_AllegeKindId).append("=:").append(
						IAllegeInfoValue.S_AllegeKindId);
				parameter.put(IAllegeInfoValue.S_AllegeKindId, allegeSubKind);
			}
		}

		if (!StringUtil.isBlank(sendProvince) && !sendProvince.equals("-1")) {
			condition.append(" AND ").append(IAllegeInfoValue.S_SendProvince).append("=:").append(
					IAllegeInfoValue.S_SendProvince);
			parameter.put(IAllegeInfoValue.S_SendProvince, sendProvince);
		}

		if (!StringUtil.isBlank(allegeLevel)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_AllegeLevelId).append("=:").append(
					IAllegeInfoValue.S_AllegeLevelId);
			parameter.put(IAllegeInfoValue.S_AllegeLevelId, allegeLevel);
		}
		if (!StringUtil.isBlank(allegeState)) {
			if (allegeState.indexOf(",") >= 0) {
				String[] splits = allegeState.split(",");
				if (null != splits && splits.length > 0) {
					StringBuffer sb = new StringBuffer();
					for (int i = 0; i < splits.length; i++) {
						sb.append("'").append(splits[i]).append("',");
					}
					sb.deleteCharAt(sb.length() - 1);
					condition.append(" AND ").append(IAllegeInfoValue.S_AllegeStatus).append(" IN (").append(sb)
							.append(")");
				}
			} else {
				condition.append(" AND ").append(IAllegeInfoValue.S_AllegeStatus).append("=:").append(
						IAllegeInfoValue.S_AllegeStatus);
				parameter.put(IAllegeInfoValue.S_AllegeStatus, allegeState);
			}
		}
		if (!StringUtil.isBlank(provinceCode)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_ProvinceCode).append("=:").append(
					IAllegeInfoValue.S_ProvinceCode);
			parameter.put(IAllegeInfoValue.S_ProvinceCode, provinceCode);
		}
		if (!StringUtil.isBlank(mobilePhone)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_MobilePhoneNo).append("=:").append(
					IAllegeInfoValue.S_MobilePhoneNo);
			parameter.put(IAllegeInfoValue.S_MobilePhoneNo, mobilePhone);
		}
		if (!StringUtil.isBlank(orderId)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_OldOrderId).append("=:").append(
					IAllegeInfoValue.S_OldOrderId);
			parameter.put(IAllegeInfoValue.S_OldOrderId, orderId);
		}
		if (!StringUtil.isBlank(subOrderId)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_OldSuborderId).append("=:").append(
					IAllegeInfoValue.S_OldSuborderId);
			parameter.put(IAllegeInfoValue.S_OldSuborderId, subOrderId);
		}
		if (!StringUtil.isBlank(overTime)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_OverTime).append("=:").append(
					IAllegeInfoValue.S_OverTime);
			parameter.put(IAllegeInfoValue.S_OverTime, overTime);
		}
		if (!StringUtil.isBlank(staffID)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_RespOpId).append("=:").append(
					IAllegeInfoValue.S_RespOpId);
			parameter.put(IAllegeInfoValue.S_RespOpId, staffID);
		}

		if (!StringUtil.isBlank(partnerType)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_RespPartnerType).append("=:").append(
					IAllegeInfoValue.S_RespPartnerType);
			parameter.put(IAllegeInfoValue.S_RespPartnerType, partnerType);
		}

		if (!StringUtil.isBlank(partnerId)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_RespPartnerId).append("=:").append(
					IAllegeInfoValue.S_RespPartnerId);
			parameter.put(IAllegeInfoValue.S_RespPartnerId, partnerId);
		}
		if (!StringUtil.isBlank(startTime)) {
			if (!isPartnerQuery) {
				if (StringUtil.isBlank(timeSelect) || timeSelect.equals(AllegeConstant.QRY_TIME_SELECTION_ACCEPT)) {
					condition.append(" AND ").append(IAllegeInfoValue.S_AcceptDate).append(
							">=to_date(:startTime ,'yyyy-mm-dd hh24:mi:ss')");
					parameter.put("startTime", startTime);
				} else if (timeSelect.equals(AllegeConstant.QRY_TIME_SELECTION_UPDATE)) {
					condition.append(" AND ").append(IAllegeInfoValue.S_StatusTime).append(
							">=to_date(:startTime ,'yyyy-mm-dd hh24:mi:ss')");
					parameter.put("startTime", startTime);
				} else {
					// 全部
					condition.append(" AND (").append(IAllegeInfoValue.S_AcceptDate).append(
							">=to_date(:createStartTime ,'yyyy-mm-dd hh24:mi:ss') OR ").append(
							IAllegeInfoValue.S_StatusTime).append(
							">=to_date(:updateStartTime ,'yyyy-mm-dd hh24:mi:ss'))");
					parameter.put("createStartTime", startTime);
					parameter.put("updateStartTime", startTime);
				}
			}
		}
		if (!StringUtil.isBlank(endTime)) {
			if (!isPartnerQuery) {
				if (StringUtil.isBlank(timeSelect) || timeSelect.equals(AllegeConstant.QRY_TIME_SELECTION_ACCEPT)) {
					condition.append(" AND ").append(IAllegeInfoValue.S_AcceptDate).append(
							"<=to_date(:endTime ,'yyyy-mm-dd hh24:mi:ss')");
					parameter.put("endTime", endTime);
				} else if (timeSelect.equals(AllegeConstant.QRY_TIME_SELECTION_UPDATE)) {
					condition.append(" AND ").append(IAllegeInfoValue.S_StatusTime).append(
							"<=to_date(:endTime ,'yyyy-mm-dd hh24:mi:ss')");
					parameter.put("endTime", endTime);
				} else {
					// 全部
					condition.append(" AND (").append(IAllegeInfoValue.S_AcceptDate).append(
							"<=to_date(:createEndTime ,'yyyy-mm-dd hh24:mi:ss') OR ").append(
							IAllegeInfoValue.S_StatusTime)
							.append("<=to_date(:updateEndTime ,'yyyy-mm-dd hh24:mi:ss'))");
					parameter.put("createEndTime", endTime);
					parameter.put("updateEndTime", endTime);
				}
			}
		}

		if (!StringUtil.isBlank(exchangeChannel)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_ExchgChannel).append("=:").append(
					IAllegeInfoValue.S_ExchgChannel);
			parameter.put(IAllegeInfoValue.S_ExchgChannel, exchangeChannel);
		}

		if (!StringUtil.isBlank(acceptOpId)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_AcceptOpId).append("=:").append(
					IAllegeInfoValue.S_AcceptOpId);
			parameter.put(IAllegeInfoValue.S_AcceptOpId, acceptOpId);
		}

		// 根据订单工号（一级客服上的编号）查询
		if (!StringUtil.isBlank(indictSeq)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_Indictseq).append("=:").append(
					IAllegeInfoValue.S_Indictseq);
			parameter.put(IAllegeInfoValue.S_Indictseq, indictSeq);
		}
		// 根据订单在一级客服上的状态查询
		if (!StringUtil.isBlank(indictStatus)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_IndictStatus).append("=:").append(
					IAllegeInfoValue.S_IndictStatus);
			parameter.put(IAllegeInfoValue.S_IndictStatus, indictStatus);
		}

		result.add(condition.toString());
		result.add(parameter);
		return result;
	}

	/**
	 * “咨询投诉查询”功能专用条件拼装方法 （2010-12-27）
	 */
	private List processNewCondition(String allegeKind, String allegeLevel, String allegeState, String provinceCode,
			String mobilePhone, String orderId, String subOrderId, String overTime, String staffID, String partnerType,
			String partnerID, String sendProvince, String timeSelect, String startTime, String endTime,
			boolean isPartnerQuery, String exchangeChannel, String acceptOpId, String allegeSubKind,
			String allegeSendStatus, String indictseq, String indictStatus,String comType) {
		List result = new ArrayList();
		StringBuffer condition = new StringBuffer(" 1=1");
		Map<String, String> parameter = new HashMap<String, String>();

		// 当登录用户的角色为“省业务管理员”或“省客服”，在查询投诉单时，增加下面查询条件 （2010-12-01 客服基地改造）
		 //此处根据需求，放开不在加省公司限制，而只靠省份限制2011-02-20
		if(CoreConstant.SYS_PARA_USER_PROVINCE_COMPANY.equals(comType)|| CoreConstant.SYS_PARA_USER_PROVINCE_CUSTOM.equals(comType)){
			 condition.append(" AND (").append(IAllegeInfoValue.S_ComTypeId).append("=:").append(
					IAllegeInfoValue.S_ComTypeId);
			parameter.put(IAllegeInfoValue.S_ComTypeId, CoreConstant.SYS_PARA_USER_PROVINCE_COMPANY);
			condition.append(" OR ").append(IAllegeInfoValue.S_AcceptComType).append("=:").append(
					IAllegeInfoValue.S_AcceptComType).append(" )");
			parameter.put(IAllegeInfoValue.S_AcceptComType, CoreConstant.SYS_PARA_USER_PROVINCE_COMPANY);
		}
		// /**
		// * 客服基地二阶段的调整，客服基地人员只能够查询由客服基地人员录入的投诉（咨询）单 （2010-12-06）
		// * 需求调整为：客服基地人员可以查询已分配投诉、未分配投诉，及省客服录入的投诉。（2010-12-27）
		// **/
		if ((CoreConstant.SYS_PARA_USER_HEAD_COMPANY).equals(comType)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_AcceptComType).append(" in (").append(
					CoreConstant.SYS_PARA_USER_HEAD_COMPANY).append(",").append(
					CoreConstant.SYS_PARA_USER_PROVINCE_COMPANY).append(")");
		}
		
		
		/** 当登录用户的角色为“省业务管理员”或“省客服”，在查询投诉单时，增加下面查询条件 （2010-12-01 客服基地改造） **/
		// UserInfoInterface user = SessionManager.getUser();
		// MgtUserInfo userInfo = (MgtUserInfo)
		// user.get(MgtConstant.MGT_USER_INFO);
		// if (null != userInfo) {
		// //此处根据需求，放开不在加省公司限制，而只靠省份限制2011-02-20
		//
		// if
		// ((MgtCmmnConstant.SYS_PARA_USER_PROVINCE_COMPANY).equals(userInfo.getComType())
		// ||
		// (MgtCmmnConstant.SYS_PARA_USER_PROVINCE_CUSTOM).equals(userInfo.getComType()))
		// {
		// condition.append(" AND (").append(IAllegeInfoValue.S_ComTypeId).append("=:").append(
		// IAllegeInfoValue.S_ComTypeId);
		// parameter.put(IAllegeInfoValue.S_ComTypeId,
		// MgtCmmnConstant.SYS_PARA_USER_PROVINCE_COMPANY);
		// condition.append(" OR ").append(IAllegeInfoValue.S_AcceptComType).append("=:").append(
		// IAllegeInfoValue.S_AcceptComType).append(" )");
		// parameter.put(IAllegeInfoValue.S_AcceptComType,
		// MgtCmmnConstant.SYS_PARA_USER_PROVINCE_COMPANY);
		// }
		// /**
		// * 客服基地二阶段的调整，客服基地人员只能够查询由客服基地人员录入的投诉（咨询）单 （2010-12-06）
		// * 需求调整为：客服基地人员可以查询已分配投诉、未分配投诉，及省客服录入的投诉。（2010-12-27）
		// **/
		// if
		// ((MgtCmmnConstant.SYS_PARA_USER_HEAD_COMPANY).equals(userInfo.getComType()))
		// {
		// condition.append(" AND ").append(IAllegeInfoValue.S_AcceptComType).append(" in (").append(
		// MgtCmmnConstant.SYS_PARA_USER_HEAD_COMPANY).append(",").append(
		// MgtCmmnConstant.SYS_PARA_USER_PROVINCE_COMPANY).append(")");
		// }
		// }
		// ** 客服基地二阶段的调整，增加总部客服基地人员可以查询分配和未分配 （2010-12-09） **/
		if (!StringUtil.isBlank(allegeSendStatus)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_AssignStatus).append("=:").append(
					IAllegeInfoValue.S_AssignStatus);
			parameter.put(IAllegeInfoValue.S_AssignStatus, allegeSendStatus);
		}

		if (!StringUtil.isBlank(allegeKind)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_AllegeParentKind).append("=:").append(
					IAllegeInfoValue.S_AllegeParentKind);
			parameter.put(IAllegeInfoValue.S_AllegeParentKind, allegeKind);
		}

		if (!StringUtil.isBlank(allegeSubKind)) {
			if (allegeSubKind.indexOf(AllegeConstant.SPLIT_SEMCOLON) >= 0) {
				condition.append(" AND ").append(IAllegeInfoValue.S_AllegeKindId).append(" IN (").append(
						allegeSubKind.replaceAll(AllegeConstant.SPLIT_SEMCOLON, AllegeConstant.SPLIT_COMMA)).append(
						" )");
			} else {
				condition.append(" AND ").append(IAllegeInfoValue.S_AllegeKindId).append("=:").append(
						IAllegeInfoValue.S_AllegeKindId);
				parameter.put(IAllegeInfoValue.S_AllegeKindId, allegeSubKind);
			}
		}

		if (!StringUtil.isBlank(sendProvince) && !sendProvince.equals("-1")) {
			condition.append(" AND ").append(IAllegeInfoValue.S_SendProvince).append("=:").append(
					IAllegeInfoValue.S_SendProvince);
			parameter.put(IAllegeInfoValue.S_SendProvince, sendProvince);
		}

		if (!StringUtil.isBlank(allegeLevel)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_AllegeLevelId).append("=:").append(
					IAllegeInfoValue.S_AllegeLevelId);
			parameter.put(IAllegeInfoValue.S_AllegeLevelId, allegeLevel);
		}
		if (!StringUtil.isBlank(allegeState)) {
			if (allegeState.indexOf(",") >= 0) {
				String[] splits = allegeState.split(",");
				if (null != splits && splits.length > 0) {
					StringBuffer sb = new StringBuffer();
					for (int i = 0; i < splits.length; i++) {
						sb.append("'").append(splits[i]).append("',");
					}
					sb.deleteCharAt(sb.length() - 1);
					condition.append(" AND ").append(IAllegeInfoValue.S_AllegeStatus).append(" IN (").append(sb)
							.append(")");
				}
			} else {
				condition.append(" AND ").append(IAllegeInfoValue.S_AllegeStatus).append("=:").append(
						IAllegeInfoValue.S_AllegeStatus);
				parameter.put(IAllegeInfoValue.S_AllegeStatus, allegeState);
			}
		}
		if (!StringUtil.isBlank(provinceCode)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_ProvinceCode).append("=:").append(
					IAllegeInfoValue.S_ProvinceCode);
			parameter.put(IAllegeInfoValue.S_ProvinceCode, provinceCode);
		}
		if (!StringUtil.isBlank(mobilePhone)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_MobilePhoneNo).append("=:").append(
					IAllegeInfoValue.S_MobilePhoneNo);
			parameter.put(IAllegeInfoValue.S_MobilePhoneNo, mobilePhone);
		}
		if (!StringUtil.isBlank(orderId)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_OldOrderId).append("=:").append(
					IAllegeInfoValue.S_OldOrderId);
			parameter.put(IAllegeInfoValue.S_OldOrderId, orderId);
		}
		if (!StringUtil.isBlank(subOrderId)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_OldSuborderId).append("=:").append(
					IAllegeInfoValue.S_OldSuborderId);
			parameter.put(IAllegeInfoValue.S_OldSuborderId, subOrderId);
		}
		if (!StringUtil.isBlank(overTime)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_OverTime).append("=:").append(
					IAllegeInfoValue.S_OverTime);
			parameter.put(IAllegeInfoValue.S_OverTime, overTime);
		}
		if (!StringUtil.isBlank(staffID)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_RespOpId).append("=:").append(
					IAllegeInfoValue.S_RespOpId);
			parameter.put(IAllegeInfoValue.S_RespOpId, staffID);
		}

		if (!StringUtil.isBlank(partnerType)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_RespPartnerType).append("=:").append(
					IAllegeInfoValue.S_RespPartnerType);
			parameter.put(IAllegeInfoValue.S_RespPartnerType, partnerType);
		}

		if (!StringUtil.isBlank(partnerID)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_RespPartnerId).append("=:").append(
					IAllegeInfoValue.S_RespPartnerId);
			parameter.put(IAllegeInfoValue.S_RespPartnerId, partnerID);
		}
		if (!StringUtil.isBlank(startTime)) {
			if (!isPartnerQuery) {
				if (StringUtil.isBlank(timeSelect) || timeSelect.equals(AllegeConstant.QRY_TIME_SELECTION_ACCEPT)) {
					condition.append(" AND ").append(IAllegeInfoValue.S_AcceptDate).append(
							">=to_date(:startTime ,'yyyy-mm-dd hh24:mi:ss')");
					parameter.put("startTime", startTime);
				} else if (timeSelect.equals(AllegeConstant.QRY_TIME_SELECTION_UPDATE)) {
					condition.append(" AND ").append(IAllegeInfoValue.S_StatusTime).append(
							">=to_date(:startTime ,'yyyy-mm-dd hh24:mi:ss')");
					parameter.put("startTime", startTime);
				} else {
					// 全部
					condition.append(" AND (").append(IAllegeInfoValue.S_AcceptDate).append(
							">=to_date(:createStartTime ,'yyyy-mm-dd hh24:mi:ss') OR ").append(
							IAllegeInfoValue.S_StatusTime).append(
							">=to_date(:updateStartTime ,'yyyy-mm-dd hh24:mi:ss'))");
					parameter.put("createStartTime", startTime);
					parameter.put("updateStartTime", startTime);
				}
			}
		}
		if (!StringUtil.isBlank(endTime)) {
			if (!isPartnerQuery) {
				if (StringUtil.isBlank(timeSelect) || timeSelect.equals(AllegeConstant.QRY_TIME_SELECTION_ACCEPT)) {
					condition.append(" AND ").append(IAllegeInfoValue.S_AcceptDate).append(
							"<=to_date(:endTime ,'yyyy-mm-dd hh24:mi:ss')");
					parameter.put("endTime", endTime);
				} else if (timeSelect.equals(AllegeConstant.QRY_TIME_SELECTION_UPDATE)) {
					condition.append(" AND ").append(IAllegeInfoValue.S_StatusTime).append(
							"<=to_date(:endTime ,'yyyy-mm-dd hh24:mi:ss')");
					parameter.put("endTime", endTime);
				} else {
					// 全部
					condition.append(" AND (").append(IAllegeInfoValue.S_AcceptDate).append(
							"<=to_date(:createEndTime ,'yyyy-mm-dd hh24:mi:ss') OR ").append(
							IAllegeInfoValue.S_StatusTime)
							.append("<=to_date(:updateEndTime ,'yyyy-mm-dd hh24:mi:ss'))");
					parameter.put("createEndTime", endTime);
					parameter.put("updateEndTime", endTime);
				}
			}
		}

		if (!StringUtil.isBlank(exchangeChannel)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_ExchgChannel).append("=:").append(
					IAllegeInfoValue.S_ExchgChannel);
			parameter.put(IAllegeInfoValue.S_ExchgChannel, exchangeChannel);
		}

		if (!StringUtil.isBlank(acceptOpId)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_AcceptOpId).append("=:").append(
					IAllegeInfoValue.S_AcceptOpId);
			parameter.put(IAllegeInfoValue.S_AcceptOpId, acceptOpId);
		}

		// 根据订单工号（一级客服上的编号）查询
		if (!StringUtil.isBlank(indictseq)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_Indictseq).append("=:").append(
					IAllegeInfoValue.S_Indictseq);
			parameter.put(IAllegeInfoValue.S_Indictseq, indictseq);
		}
		// 根据订单在一级客服上的状态查询
		if (!StringUtil.isBlank(indictStatus)) {
			condition.append(" AND ").append(IAllegeInfoValue.S_IndictStatus).append("=:").append(
					IAllegeInfoValue.S_IndictStatus);
			parameter.put(IAllegeInfoValue.S_IndictStatus, indictStatus);
		}
		result.add(condition.toString());
		result.add(parameter);
		return result;
	}

	/**
	 * 查询条件后来添加了userBrand和userLevel，为了不影响以前的其他查询语句拼装，新增以下方法添加
	 * 
	 * @param newResult
	 * @param userBrand
	 * @param userLevel
	 * @return
	 */
	private List addCondUser(List newResult, String userBrand, String userLevel) {
		if (StringUtil.isBlank(userBrand) && StringUtil.isBlank(userLevel)) {
			return newResult;
		} else {
			String cond = (String) newResult.get(0);
			Map para = (Map) newResult.get(1);
			if (!StringUtil.isBlank(userBrand) && !CommnConstant.QRY_OPTION_ALL.equals(userBrand)) {
				cond += " and " + IAllegeInfoValue.S_UserBrand + "=:" + IAllegeInfoValue.S_UserBrand;
				para.put(IAllegeInfoValue.S_UserBrand, userBrand);
			}
			if (!StringUtil.isBlank(userLevel) && !CommnConstant.QRY_OPTION_ALL.equals(userLevel)) {
				cond += " and " + IAllegeInfoValue.S_UserLevel + "=:" + IAllegeInfoValue.S_UserLevel;
				para.put(IAllegeInfoValue.S_UserLevel, userLevel);
			}
			List newResult2 = new ArrayList();
			newResult2.add(cond);
			newResult2.add(para);

			return newResult2;
		}
	}

}
