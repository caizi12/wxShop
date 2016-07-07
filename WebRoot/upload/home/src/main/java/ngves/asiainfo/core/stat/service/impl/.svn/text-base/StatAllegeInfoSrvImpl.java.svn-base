package ngves.asiainfo.core.stat.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.stat.StatConstant;
import ngves.asiainfo.core.stat.dao.interfaces.IStatAllegeInfoDAO;
import ngves.asiainfo.core.stat.ivalues.IQBOAllegeDetailQRYValue;
import ngves.asiainfo.core.stat.service.interfaces.IStatAllegeInfoSrv;
import ngves.asiainfo.util.StringUtil;

public class StatAllegeInfoSrvImpl implements IStatAllegeInfoSrv {

	    private IStatAllegeInfoDAO statAllegeInfoDAO;

	    public void setStatAllegeInfoDAO(IStatAllegeInfoDAO statAllegeInfoDAO) throws Exception {
	        this.statAllegeInfoDAO = statAllegeInfoDAO;
	    }
	    
	   /**
	     * 客诉详单查询的筛选条件拼装（新增条件）
	     * @param allegeStatus
	     * @param wareFirstKind
	     * @param timeSelectType
	     * @param startTime
	     * @param endTime
	     * @param allegeKind
	     * @param allegeSubKind
	     * @param allegeLevel
	     * @param provinceCode
	     * @param overTime
	     * @param exchangeChannel
	     * @param respPartnerType
	     * @param respPartnerId
	     * @param mobilePhone
	     * @param indictseq
	     * @param warecode
	     * @param userBrand
	     * @param warekindparent
	     * @param warekind
	     * @param indictStatus
	     * @return
	     */
	    @SuppressWarnings("unchecked")
		private List processCondition(String allegeStatus, String wareFirstKind, String timeSelectType, String startTime,
	            String endTime, String allegeKind, String allegeSubKind, String allegeLevel, String provinceCode,
	            String overTime, String exchangeChannel, String respPartnerType, String respPartnerId,
	            String mobilePhone, String indictseq, String warecode, String userBrand, String lstWareParentKind, 
	            String lstWareKind, String indictStatus,String wareKindInfoId) {

	        List result = new ArrayList();
	        StringBuffer condition = new StringBuffer(" 1=1 ");
	        Map<String, String> parameter = new HashMap<String, String>();
	        
	        if (!StringUtil.isBlank(wareFirstKind)) {
	            condition.append(" AND ").append(IQBOAllegeDetailQRYValue.S_WareFirstKindId).append("=:").append(
	                    IQBOAllegeDetailQRYValue.S_WareFirstKindId);
	            parameter.put(IQBOAllegeDetailQRYValue.S_WareFirstKindId, wareFirstKind);
	        }
	        
	        if (!StringUtil.isBlank(allegeKind)) {
	            condition.append(" AND ").append(IQBOAllegeDetailQRYValue.S_AllegeParentKind).append("=:").append(
	                    IQBOAllegeDetailQRYValue.S_AllegeParentKind);
	            parameter.put(IQBOAllegeDetailQRYValue.S_AllegeParentKind, allegeKind);
	        }

	        if (!StringUtil.isBlank(allegeSubKind)) {
	            if (allegeSubKind.indexOf(CoreConstant.SPLIT_SEMCOLON) >= 0) {
	                condition.append(" AND ").append(IQBOAllegeDetailQRYValue.S_AllegeKindId).append(" IN (").append(
	                        allegeSubKind.replaceAll(CoreConstant.SPLIT_SEMCOLON, CoreConstant.SPLIT_COMMA)).append(" )");
	            } else {
	                condition.append(" AND ").append(IQBOAllegeDetailQRYValue.S_AllegeKindId).append("=:").append(
	                        IQBOAllegeDetailQRYValue.S_AllegeKindId);
	                parameter.put(IQBOAllegeDetailQRYValue.S_AllegeKindId, allegeSubKind);
	            }
	        }

	        if (!StringUtil.isBlank(allegeLevel)) {
	            condition.append(" AND ").append(IQBOAllegeDetailQRYValue.S_AllegeLevelId).append("=:").append(
	                    IQBOAllegeDetailQRYValue.S_AllegeLevelId);
	            parameter.put(IQBOAllegeDetailQRYValue.S_AllegeLevelId, allegeLevel);
	        }

	        if (!StringUtil.isBlank(allegeStatus)) {
	            if (allegeStatus.indexOf(",") >= 0) {
	                String[] splits = allegeStatus.split(",");
	                if (null != splits && splits.length > 0) {
	                    StringBuffer sb = new StringBuffer();
	                    for (int i = 0; i < splits.length; i++) {
	                        sb.append("'").append(splits[i]).append("',");
	                    }
	                    sb.deleteCharAt(sb.length() - 1);
	                    condition.append(" AND ").append(IQBOAllegeDetailQRYValue.S_AllegeStatus).append(" IN (").append(sb)
	                            .append(")");
	                }
	            } else {
	                condition.append(" AND ").append(IQBOAllegeDetailQRYValue.S_AllegeStatus).append("=:").append(
	                        IQBOAllegeDetailQRYValue.S_AllegeStatus);
	                parameter.put(IQBOAllegeDetailQRYValue.S_AllegeStatus, allegeStatus);
	            }
	        }

	        if (!StringUtil.isBlank(provinceCode)) {
	            condition.append(" AND ").append(IQBOAllegeDetailQRYValue.S_ProvinceCode).append("=:").append(
	                    IQBOAllegeDetailQRYValue.S_ProvinceCode);
	            parameter.put(IQBOAllegeDetailQRYValue.S_ProvinceCode, provinceCode);
	        }

	        if (!StringUtil.isBlank(overTime)) {
	            condition.append(" AND ").append(IQBOAllegeDetailQRYValue.S_OverTime).append("=:").append(
	                    IQBOAllegeDetailQRYValue.S_OverTime);
	            parameter.put(IQBOAllegeDetailQRYValue.S_OverTime, overTime);
	        }

	        if (!StringUtil.isBlank(respPartnerType)) {
	            condition.append(" AND ").append(IQBOAllegeDetailQRYValue.S_RespPartnerType).append("=:").append(
	                    IQBOAllegeDetailQRYValue.S_RespPartnerType);
	            parameter.put(IQBOAllegeDetailQRYValue.S_RespPartnerType, respPartnerType);
	        }

	        if (!StringUtil.isBlank(respPartnerId)) {
	            condition.append(" AND ").append(IQBOAllegeDetailQRYValue.S_RespPartnerId).append("=:").append(
	                    IQBOAllegeDetailQRYValue.S_RespPartnerId);
	            parameter.put(IQBOAllegeDetailQRYValue.S_RespPartnerId, respPartnerId);
	        }

	        if (!StringUtil.isBlank(startTime)) {
	            if (StringUtil.isBlank(timeSelectType) || timeSelectType.equals(StatConstant.QRY_TIME_SELECTION_ACCEPT)) {
	                condition.append(" AND ").append(IQBOAllegeDetailQRYValue.S_AcceptDate).append(
	                        ">=to_date(:startTime ,'yyyy-mm-dd hh24:mi:ss')");
	                parameter.put("startTime", startTime);
	            } else if (timeSelectType.equals(StatConstant.QRY_TIME_SELECTION_UPDATE)) {
	                condition.append(" AND ").append(IQBOAllegeDetailQRYValue.S_StatusTime).append(
	                        ">=to_date(:startTime ,'yyyy-mm-dd hh24:mi:ss')");
	                parameter.put("startTime", startTime);
	            } else {
	                //全部
	                condition.append(" AND (").append(IQBOAllegeDetailQRYValue.S_AcceptDate).append(
	                        ">=to_date(:createStartTime ,'yyyy-mm-dd hh24:mi:ss') OR ").append(
	                        IQBOAllegeDetailQRYValue.S_StatusTime).append(">=to_date(:updateStartTime ,'yyyy-mm-dd hh24:mi:ss'))");
	                parameter.put("createStartTime", startTime);
	                parameter.put("updateStartTime", startTime);
	            }
	        }

	        if (!StringUtil.isBlank(endTime)) {
	            if (StringUtil.isBlank(timeSelectType) || timeSelectType.equals(StatConstant.QRY_TIME_SELECTION_ACCEPT)) {
	                condition.append(" AND ").append(IQBOAllegeDetailQRYValue.S_AcceptDate).append(
	                        "<=to_date(:endTime ,'yyyy-mm-dd hh24:mi:ss')");
	                parameter.put("endTime", endTime);
	            } else if (timeSelectType.equals(StatConstant.QRY_TIME_SELECTION_UPDATE)) {
	                condition.append(" AND ").append(IQBOAllegeDetailQRYValue.S_StatusTime).append(
	                        "<=to_date(:endTime ,'yyyy-mm-dd hh24:mi:ss')");
	                parameter.put("endTime", endTime);
	            } else {
	                //全部
	                condition.append(" AND (").append(IQBOAllegeDetailQRYValue.S_AcceptDate).append(
	                        "<=to_date(:createEndTime ,'yyyy-mm-dd hh24:mi:ss') OR ").append(IQBOAllegeDetailQRYValue.S_StatusTime)
	                        .append("<=to_date(:updateEndTime ,'yyyy-mm-dd hh24:mi:ss'))");
	                parameter.put("createEndTime", endTime);
	                parameter.put("updateEndTime", endTime);
	            }
	        }

	        if (!StringUtil.isBlank(exchangeChannel)) {
	            condition.append(" AND ").append(IQBOAllegeDetailQRYValue.S_ExchgChannel).append("=:").append(
	                    IQBOAllegeDetailQRYValue.S_ExchgChannel);
	            parameter.put(IQBOAllegeDetailQRYValue.S_ExchgChannel, exchangeChannel);
	        }
	        //新增条件
	        if (!StringUtil.isBlank(mobilePhone)) {
	            condition.append(" AND ").append(IQBOAllegeDetailQRYValue.S_MobilePhoneNo).append("=:").append(
	                    IQBOAllegeDetailQRYValue.S_MobilePhoneNo);
	            parameter.put(IQBOAllegeDetailQRYValue.S_MobilePhoneNo, mobilePhone);
	        }
	        
	        if (!StringUtil.isBlank(indictseq)) {
	            condition.append(" AND ").append(IQBOAllegeDetailQRYValue.S_Indictseq).append("=:").append(
	            		IQBOAllegeDetailQRYValue.S_Indictseq);
	            parameter.put(IQBOAllegeDetailQRYValue.S_Indictseq, indictseq);
	        }
	        if (!StringUtil.isBlank(warecode)) {
	            condition.append(" AND ").append(IQBOAllegeDetailQRYValue.S_WareCode).append("=:").append(
	            		IQBOAllegeDetailQRYValue.S_WareCode);
	            parameter.put(IQBOAllegeDetailQRYValue.S_WareCode, warecode);
	        }
	        if (!StringUtil.isBlank(userBrand)) {
	            condition.append(" AND ").append(IQBOAllegeDetailQRYValue.S_UserBrandCode).append("=:").append(
	            		IQBOAllegeDetailQRYValue.S_UserBrandCode);
	            parameter.put(IQBOAllegeDetailQRYValue.S_UserBrandCode, userBrand);
	        }
	        if (!StringUtil.isBlank(lstWareParentKind)) {
	            condition.append(" AND ").append(IQBOAllegeDetailQRYValue.S_WareKindParentId).append("=:").append(
	            		IQBOAllegeDetailQRYValue.S_WareKindParentId);
	            parameter.put(IQBOAllegeDetailQRYValue.S_WareKindParentId, lstWareParentKind);
	        }
	        if (!StringUtil.isBlank(lstWareKind)) {
	            condition.append(" AND ").append(IQBOAllegeDetailQRYValue.S_WareKindId).append("=:").append(
	            		IQBOAllegeDetailQRYValue.S_WareKindId);
	            parameter.put(IQBOAllegeDetailQRYValue.S_WareKindId, lstWareKind);
	        }
	        if (!StringUtil.isBlank(indictStatus)) {
	            condition.append(" AND ").append(IQBOAllegeDetailQRYValue.S_IndictStatus).append("=:").append(
	            		IQBOAllegeDetailQRYValue.S_IndictStatus);
	            parameter.put(IQBOAllegeDetailQRYValue.S_IndictStatus, indictStatus);
	        }
	        if (!StringUtil.isBlank(wareKindInfoId)) {
	            condition.append(" AND ").append(IQBOAllegeDetailQRYValue.S_WareKindInfoId).append("=:").append(
	            		IQBOAllegeDetailQRYValue.S_WareKindInfoId);
	            parameter.put(IQBOAllegeDetailQRYValue.S_WareKindInfoId, wareKindInfoId);
	        }
	        
	        result.add(condition.toString());
	        result.add(parameter);
	        return result;
	    }

	@SuppressWarnings("unchecked")
	public int queryAllegeDetailCount(String allegeStatus,
			String wareFirstKind, String timeSelectType, String startTime,
			String endTime, String allegeKind, String allegeSubKind,
			String allegeLevel, String provinceCode, String overTime,
			String exchangeChannel, String respPartnerType,
			String respPartnerId, String mobilePhone, String indictseq,
			String warecode, String userBrand, String lstWareParentKind,
			String lstWareKind, String indictStatus,String wareKindInfoId) throws Exception {
		if(StringUtil.isBlank(startTime)&&StringUtil.isBlank(endTime)){
            throw new Exception("The parameters of queryAllegeDetail() is null!");
        }
        
        List result = processCondition(allegeStatus, wareFirstKind, timeSelectType, startTime, endTime, allegeKind,
                allegeSubKind, allegeLevel, provinceCode, overTime, exchangeChannel, respPartnerType, respPartnerId,
                mobilePhone,  indictseq, warecode,userBrand, lstWareParentKind, lstWareKind, indictStatus,wareKindInfoId );

        return statAllegeInfoDAO.queryAllegeDetailCount((String) result.get(0), (Map) result.get(1));
	}

	@SuppressWarnings("unchecked")
	public IQBOAllegeDetailQRYValue[] queryAllegeDetail(String allegeStatus,
			String wareFirstKind, String timeSelectType, String startTime,
			String endTime, String allegeKind, String allegeSubKind,
			String allegeLevel, String provinceCode, String overTime,
			String exchangeChannel, String respPartnerType,
			String respPartnerId, String mobilePhone, String indictseq,
			String warecode, String userBrand, String lstWareParentKind,
			String lstWareKind, String indictStatus,String wareKindInfoId, int startIndex,
			int endIndex) throws Exception {

		   if(StringUtil.isBlank(startTime)&&StringUtil.isBlank(endTime)){
	            throw new Exception("The parameters of queryAllegeDetail() is null!");
	        }
	        System.out.println(">>>>>>>>"+startIndex+"<<<<<<<<<"+endIndex);
	        List result = processCondition(allegeStatus, wareFirstKind, timeSelectType, startTime, endTime, allegeKind,
	                allegeSubKind, allegeLevel, provinceCode, overTime, exchangeChannel, respPartnerType, respPartnerId,
	                 mobilePhone,  indictseq, warecode,userBrand, lstWareParentKind, lstWareKind, indictStatus,wareKindInfoId      
	        );

	        return statAllegeInfoDAO.queryAllegeDetail((String) result.get(0), (Map) result.get(1), startIndex, endIndex);
	}

}
