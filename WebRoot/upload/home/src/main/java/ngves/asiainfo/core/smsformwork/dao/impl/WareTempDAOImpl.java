package ngves.asiainfo.core.smsformwork.dao.impl;

import java.util.ArrayList;
import java.util.List;

import ngves.asiainfo.core.common.bo.SysParaDataBean;
import ngves.asiainfo.core.common.bo.SysParaDataEngine;
import ngves.asiainfo.core.common.model.SysPara;
import ngves.asiainfo.core.smsformwork.bo.QBOWareTempEngine;
import ngves.asiainfo.core.smsformwork.dao.interfaces.IWareTempDAO;
import ngves.asiainfo.core.smsformwork.ivalues.IQBOWareTempValue;
import ngves.asiainfo.core.smsformwork.util.SmsFormworkUtils;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 礼品所属短信模板列表查询DAO
 * @author liuyf
 * 2013-12-04
 */
public class WareTempDAOImpl implements IWareTempDAO {

	private static Log logger = LogFactory.getLog(WareTempDAOImpl.class);
	
	/**
	 * 礼品所属短信模板列表查询
	 * @param wareFirstKindId
	 * @param wareKindParentId
	 * @param wareKindId
	 * @param wareName
	 * @param wareCode
	 * @param provinceCode
	 * @param tempName
	 * @param activeKind
	 * @param activeName
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public IQBOWareTempValue[] getWareTempList(String wareFirstKindId, String wareKindParentId, String wareKindId,
			String wareName, String wareCode, String provinceCode, String tempName, String activeKind,
			String activeName,String wareKindInfoId, int startNum, int endNum) throws Exception {
		
		StringBuffer sql = new StringBuffer();
		if(startNum != -1 && endNum != -1){
			sql.append("select * from (SELECT WARE_ID,         				   \n");
			sql.append("       WARE_CODE,       							   \n");
			sql.append("       WARE_NAME,       							   \n");
			sql.append("       ACTION_ID,       							   \n");
			sql.append("       ACTION_NAME,     			                   \n");
			sql.append("       ACTION_TYPE,     							   \n");
			sql.append("       ACTION_TYPE_NAME,							   \n");
			sql.append("       FORMWORK_ID,     							   \n");
			sql.append("       FORMWORK_NAME,   							   \n");
			sql.append("       LITTLE_KIND,     							   \n");
			sql.append("       MIDDLE_KIND,     							   \n");
			sql.append("       FIRST_KIND,      						   	   \n");
			sql.append("       OPERATE_TIME,    							   \n");
			sql.append("       OPERATOR_CODE,    							   \n");
			sql.append("       ware_kind_info_id,							   \n");
			sql.append("       ware_kind_info_name,    						   \n");
			sql.append("       rownum as row_index    						   \n");
			sql.append("  FROM (                   							   \n");
		}
		if ("02".equals(activeKind)) {
			//团购
			logger.debug("团购："+activeKind);
			sql.append("SELECT      							               \n");		
			sql.append("       WI.WARE_ID,                                     \n");
			sql.append("       WI.WARE_CODE,                                   \n");
			sql.append("       WI.WARE_NAME,                                   \n");
			sql.append("       SFWIR.ACTION_ID,                                \n");
			sql.append("       TI.NAME ACTION_NAME,                            \n");
			sql.append("       SFWIR.ACTION_TYPE,                              \n");
			sql.append("       SPD.PARA_NAME ACTION_TYPE_NAME,                 \n");
			sql.append("       SFWIR.FORMWORK_ID,                              \n");
			sql.append("       SF.FORMWORK_NAME,                               \n");
			sql.append("       WK.KIND_NAME LITTLE_KIND,                       \n");
			sql.append("       WKP.BIG_KIND_NAME MIDDLE_KIND,                  \n");
			sql.append("       WFK.F_NAME FIRST_KIND,                          \n");
			sql.append("       SFWIR.OPERATE_TIME,                             \n");
			sql.append("       SFWIR.OPERATOR_CODE,                            \n");
			sql.append("       wki.kind_id ware_kind_info_id,                  \n");
			sql.append("       wki.kind_name ware_kind_info_name               \n");
			sql.append("  FROM WARE_FIRST_KIND            WFK,                 \n");
			sql.append("   	   ware_kind_info      		  wki,                 \n");
			sql.append("       ware_first_kind_rlt        wfkr,                \n");
			sql.append("       WARE_KIND_PARENT           WKP,                 \n");
			sql.append("       WARE_KIND                  WK,                  \n");
			sql.append("       WARE_KIND_RLT              WKR,                 \n");
			sql.append("       WARE_INFO                  WI,                  \n");
			sql.append("       SMS_FORMWORK_WARE_INFO_RLT SFWIR,               \n");
			sql.append("       SMS_FORMWORK               SF,                  \n");
			sql.append("       SYS_PARA_DATA              SPD,                 \n");
			sql.append("       TUAN_INFO                  TI                   \n");
			sql.append(" WHERE WKP.WARE_FIRST_KIND_ID = WFK.WARE_FIRST_KIND_ID \n");
			sql.append("   AND WK.WARE_KIND_PARENT_ID = WKP.WARE_KIND_PARENT_ID\n");
			sql.append("   and wfkr.ware_first_kind_id = wki.kind_id(+)			\n");
			sql.append("   and WKP.ware_kind_parent_id = wfkr.ware_kind_parent_id(+)	\n");
			sql.append("   AND WKR.WARE_KIND_ID = WK.WARE_KIND_ID              \n");
			sql.append("   AND WKR.WARE_ID = WI.WARE_ID                        \n");
			sql.append("   AND SFWIR.WARE_CODE = WI.WARE_CODE                  \n");
			sql.append("   AND SFWIR.FORMWORK_ID = SF.FORMWORK_ID              \n");
			sql.append("   AND SPD.PARA_CODE=SFWIR.ACTION_TYPE                 \n");
			sql.append("   AND SFWIR.ACTION_ID=TI.TUAN_ID                      \n");
			sql.append("   AND SPD.PARA_TYPE_ID=2013120510                     \n");
			sql.append("   AND SFWIR.ACTION_TYPE='02'                          \n");
			if(!"-1".equals(wareFirstKindId)){
			sql.append("   AND WFK.WARE_FIRST_KIND_ID =" + wareFirstKindId + " \n");
			}
			if(!"-1".equals(wareKindParentId)){
			sql.append("   AND WKP.WARE_KIND_PARENT_ID =" + wareKindParentId +"\n");	
			}
			if(!"-1".equals(wareKindId)){
			sql.append("   AND WK.WARE_KIND_ID =" + wareKindId + "             \n");	
			}
			if (!StringUtil.isBlank(wareName)) {
				wareName = SmsFormworkUtils.delUnderline(wareName);
			sql.append("   AND WI.WARE_NAME LIKE '%" + wareName + "%'   ESCAPE '\\'           \n");
			}
			if(!"-1".equals(provinceCode)){
			sql.append("   AND WI.PROVINCE_CODE ='" + provinceCode + "'        \n");
			}
			if (!StringUtil.isBlank(tempName)) {
				tempName = SmsFormworkUtils.delUnderline(tempName);
				sql.append("   AND SF.FORMWORK_NAME like '%" + tempName + "%'	  ESCAPE '\\'    \n");
			}
			if(!"-1".equals(wareKindInfoId)){
				sql.append("   AND wki.kind_id =" + wareKindInfoId + "             \n");	
			}
			if(!"-11".equals(activeName)&&!StringUtil.isBlank(activeName)){
			sql.append("   AND SFWIR.ACTION_ID =" + activeName + "             \n"); 	
			}
		} else if ("01".equals(activeKind)) {
			//抢兑
			logger.debug("抢兑："+activeKind);
			
			sql.append("SELECT        							               \n");		
			sql.append("       WI.WARE_ID,                                     \n");
			sql.append("       WI.WARE_CODE,                                   \n");
			sql.append("       WI.WARE_NAME,                                   \n");
			sql.append("       SFWIR.ACTION_ID,                                \n");
			sql.append("       AL.ACTIVITY_NAME ACTION_NAME,                   \n");
			sql.append("       SFWIR.ACTION_TYPE,                              \n");
			sql.append("       SPD.PARA_NAME ACTION_TYPE_NAME,                 \n");
			sql.append("       SFWIR.FORMWORK_ID,                              \n");
			sql.append("       SF.FORMWORK_NAME,                               \n");
			sql.append("       WK.KIND_NAME LITTLE_KIND,                       \n");
			sql.append("       WKP.BIG_KIND_NAME MIDDLE_KIND,                  \n");
			sql.append("       WFK.F_NAME FIRST_KIND,                          \n");
			sql.append("       SFWIR.OPERATE_TIME,                             \n");
			sql.append("       SFWIR.OPERATOR_CODE,                            \n");
			sql.append("       wki.kind_id ware_kind_info_id,                  \n");
			sql.append("       wki.kind_name ware_kind_info_name               \n");
			sql.append("  FROM WARE_FIRST_KIND            WFK,                 \n");
			sql.append("   	   ware_kind_info      		  wki,                 \n");
			sql.append("       ware_first_kind_rlt        wfkr,                \n");
			sql.append("       WARE_KIND_PARENT           WKP,                 \n");
			sql.append("       WARE_KIND                  WK,                  \n");
			sql.append("       WARE_KIND_RLT              WKR,                 \n");
			sql.append("       WARE_INFO                  WI,                  \n");
			sql.append("       SMS_FORMWORK_WARE_INFO_RLT SFWIR,               \n");
			sql.append("       SMS_FORMWORK               SF,                  \n");
			sql.append("       SYS_PARA_DATA              SPD,                 \n");
			sql.append("       ACTIVITY_LIMIT             AL                   \n");
			sql.append(" WHERE WKP.WARE_FIRST_KIND_ID = WFK.WARE_FIRST_KIND_ID \n");
			sql.append("   AND WK.WARE_KIND_PARENT_ID = WKP.WARE_KIND_PARENT_ID\n");
			sql.append("   and wfkr.ware_first_kind_id = wki.kind_id(+)			\n");
			sql.append("   and WKP.ware_kind_parent_id = wfkr.ware_kind_parent_id(+)	\n");
			sql.append("   AND WKR.WARE_KIND_ID = WK.WARE_KIND_ID              \n");
			sql.append("   AND WKR.WARE_ID = WI.WARE_ID                        \n");
			sql.append("   AND SFWIR.WARE_CODE = WI.WARE_CODE                  \n");
			sql.append("   AND SFWIR.FORMWORK_ID = SF.FORMWORK_ID              \n");
			sql.append("   AND SPD.PARA_CODE=SFWIR.ACTION_TYPE                 \n");
			sql.append("   AND SFWIR.ACTION_ID=AL.ACTIVITY_ID                  \n");
			sql.append("   AND SPD.PARA_TYPE_ID=2013120510                     \n");
			sql.append("   AND SFWIR.ACTION_TYPE='01'                          \n");
			if(!"-1".equals(wareFirstKindId)){
			sql.append("   AND WFK.WARE_FIRST_KIND_ID =" + wareFirstKindId + " \n");
			}
			if(!"-1".equals(wareKindParentId)){
			sql.append("   AND WKP.WARE_KIND_PARENT_ID =" + wareKindParentId +"\n");	
			}
			if(!"-1".equals(wareKindId)){
			sql.append("   AND WK.WARE_KIND_ID =" + wareKindId + "             \n");	
			}
			if (!StringUtil.isBlank(wareName)) {
				wareName = SmsFormworkUtils.delUnderline(wareName);
			sql.append("   AND WI.WARE_NAME LIKE '%" + wareName + "%'   ESCAPE '\\'           \n");
			}
			if(!"-1".equals(provinceCode)){
			sql.append("   AND WI.PROVINCE_CODE ='" + provinceCode + "'        \n");
			}
			if (!StringUtil.isBlank(tempName)) {
				tempName = SmsFormworkUtils.delUnderline(tempName);
			sql.append("   AND SF.FORMWORK_NAME like '%" + tempName + "%'   ESCAPE '\\' 	   \n");   	
			}
			if(!"-1".equals(wareKindInfoId)){
				sql.append("   AND wki.kind_id =" + wareKindInfoId + "             \n");	
			}
			if(!"-11".equals(activeName)&&!StringUtil.isBlank(activeName)){
			sql.append("   AND SFWIR.ACTION_ID =" + activeName + "             \n"); 		
			}

			
		} else if ("04".equals(activeKind)) {
			//优惠
			logger.debug("优惠："+activeKind);
			

			sql.append("SELECT   							                   \n");		
			sql.append("       WI.WARE_ID,                                     \n");
			sql.append("       WI.WARE_CODE,                                   \n");
			sql.append("       WI.WARE_NAME,                                   \n");
			sql.append("       SFWIR.ACTION_ID,                                \n");
			sql.append("       PI.PERMISSION_NAME ACTION_NAME,                 \n");
			sql.append("       SFWIR.ACTION_TYPE,                              \n");
			sql.append("       SPD.PARA_NAME ACTION_TYPE_NAME,                 \n");
			sql.append("       SFWIR.FORMWORK_ID,                              \n");
			sql.append("       SF.FORMWORK_NAME,                               \n");
			sql.append("       WK.KIND_NAME LITTLE_KIND,                       \n");
			sql.append("       WKP.BIG_KIND_NAME MIDDLE_KIND,                  \n");
			sql.append("       WFK.F_NAME FIRST_KIND,                          \n");
			sql.append("       SFWIR.OPERATE_TIME,                             \n");
			sql.append("       SFWIR.OPERATOR_CODE,                            \n");
			sql.append("       SFWIR.OPERATOR_CODE,                            \n");
			sql.append("       wki.kind_id ware_kind_info_id,                  \n");
			sql.append("       wki.kind_name ware_kind_info_name               \n");
			sql.append("  FROM WARE_FIRST_KIND            WFK,                 \n");
			sql.append("   	   ware_kind_info      		  wki,                 \n");
			sql.append("       ware_first_kind_rlt        wfkr,                \n");
			sql.append("       WARE_KIND_PARENT           WKP,                 \n");
			sql.append("       WARE_KIND                  WK,                  \n");
			sql.append("       WARE_KIND_RLT              WKR,                 \n");
			sql.append("       WARE_INFO                  WI,                  \n");
			sql.append("       SMS_FORMWORK_WARE_INFO_RLT SFWIR,               \n");
			sql.append("       SMS_FORMWORK               SF,                  \n");
			sql.append("       SYS_PARA_DATA              SPD,                 \n");
			sql.append("       PERMISSION_INFO            PI                   \n");
			sql.append(" WHERE WKP.WARE_FIRST_KIND_ID = WFK.WARE_FIRST_KIND_ID \n");
			sql.append("   AND WK.WARE_KIND_PARENT_ID = WKP.WARE_KIND_PARENT_ID\n");
			sql.append("   and wfkr.ware_first_kind_id = wki.kind_id(+)			\n");
			sql.append("   and WKP.ware_kind_parent_id = wfkr.ware_kind_parent_id(+)	\n");
			sql.append("   AND WKR.WARE_KIND_ID = WK.WARE_KIND_ID              \n");
			sql.append("   AND WKR.WARE_ID = WI.WARE_ID                        \n");
			sql.append("   AND SFWIR.WARE_CODE = WI.WARE_CODE                  \n");
			sql.append("   AND SFWIR.FORMWORK_ID = SF.FORMWORK_ID              \n");
			sql.append("   AND SPD.PARA_CODE=SFWIR.ACTION_TYPE                 \n");
			sql.append("   AND SFWIR.ACTION_ID=PI.PERMISSION_ID                \n");
			sql.append("   AND SPD.PARA_TYPE_ID=2013120510                     \n");
			sql.append("   AND SFWIR.ACTION_TYPE='04'                          \n");
			if(!"-1".equals(wareFirstKindId)){
			sql.append("   AND WFK.WARE_FIRST_KIND_ID =" + wareFirstKindId + " \n");
			}
			if(!"-1".equals(wareKindParentId)){
			sql.append("   AND WKP.WARE_KIND_PARENT_ID =" + wareKindParentId +"\n");	
			}
			if(!"-1".equals(wareKindId)){
			sql.append("   AND WK.WARE_KIND_ID =" + wareKindId + "             \n");	
			}
			if (!StringUtil.isBlank(wareName)) {
				wareName = SmsFormworkUtils.delUnderline(wareName);
			sql.append("   AND WI.WARE_NAME LIKE '%" + wareName + "%'   ESCAPE '\\'           \n");
			}
			if(!"-1".equals(provinceCode)){
			sql.append("   AND WI.PROVINCE_CODE ='" + provinceCode + "'        \n");
			}
			if (!StringUtil.isBlank(tempName)) {
				tempName = SmsFormworkUtils.delUnderline(tempName);
			sql.append("   AND SF.FORMWORK_NAME like '%" + tempName + "%'   ESCAPE '\\' 	   \n");   	
			}
			if(!"-1".equals(wareKindInfoId)){
				sql.append("   AND wki.kind_id =" + wareKindInfoId + "             \n");	
			}
			if(!"-11".equals(activeName)&&!StringUtil.isBlank(activeName)){
			sql.append("   AND SFWIR.ACTION_ID =" + activeName + "             \n"); 
			}

			
		} else if ("00".equals(activeKind)) {
			//打折
			logger.debug("打折："+activeKind);
			
			sql.append("SELECT       						   	               \n");		
			sql.append("       WI.WARE_ID,                                     \n");
			sql.append("       WI.WARE_CODE,                                   \n");
			sql.append("       WI.WARE_NAME,                                   \n");
			sql.append("       SFWIR.ACTION_ID,                                \n");
			sql.append("       NVL((SELECT WDI.DISCOUNT_NAME                   \n"); 
			sql.append("       FROM WARE_DISCOUNT_INFO WDI                     \n");
			sql.append("       WHERE                                           \n");
			sql.append("       SFWIR.ACTION_ID=WDI.DISCOUNT_ID),'按折扣值打折') ACTION_NAME,   \n");	
			sql.append("       SFWIR.ACTION_TYPE,                              \n");
			sql.append("       SPD.PARA_NAME ACTION_TYPE_NAME,                 \n");
			sql.append("       SFWIR.FORMWORK_ID,                              \n");
			sql.append("       SF.FORMWORK_NAME,                               \n");
			sql.append("       WK.KIND_NAME LITTLE_KIND,                       \n");
			sql.append("       WKP.BIG_KIND_NAME MIDDLE_KIND,                  \n");
			sql.append("       WFK.F_NAME FIRST_KIND,                          \n");
			sql.append("       SFWIR.OPERATE_TIME,                             \n");
			sql.append("       SFWIR.OPERATOR_CODE,                            \n");
			sql.append("       wki.kind_id ware_kind_info_id,                  \n");
			sql.append("       wki.kind_name ware_kind_info_name               \n");
			sql.append("  FROM WARE_FIRST_KIND            WFK,                 \n");
			sql.append("   	   ware_kind_info      		  wki,                 \n");
			sql.append("       ware_first_kind_rlt        wfkr,                \n");
			sql.append("       WARE_KIND_PARENT           WKP,                 \n");
			sql.append("       WARE_KIND                  WK,                  \n");
			sql.append("       WARE_KIND_RLT              WKR,                 \n");
			sql.append("       WARE_INFO                  WI,                  \n");
			sql.append("       SMS_FORMWORK_WARE_INFO_RLT SFWIR,               \n");
			sql.append("       SMS_FORMWORK               SF,                  \n");	
			sql.append("       SYS_PARA_DATA              SPD                  \n");
			sql.append(" WHERE WKP.WARE_FIRST_KIND_ID = WFK.WARE_FIRST_KIND_ID \n");
			sql.append("   AND WK.WARE_KIND_PARENT_ID = WKP.WARE_KIND_PARENT_ID\n");
			sql.append("   and wfkr.ware_first_kind_id = wki.kind_id(+)			\n");
			sql.append("   and WKP.ware_kind_parent_id = wfkr.ware_kind_parent_id(+)	\n");
			sql.append("   AND WKR.WARE_KIND_ID = WK.WARE_KIND_ID              \n");
			sql.append("   AND WKR.WARE_ID = WI.WARE_ID                        \n");
			sql.append("   AND SFWIR.WARE_CODE = WI.WARE_CODE                  \n");
			sql.append("   AND SFWIR.FORMWORK_ID = SF.FORMWORK_ID              \n");
			sql.append("   AND SPD.PARA_CODE=SFWIR.ACTION_TYPE                 \n");
			sql.append("   AND SPD.PARA_TYPE_ID=2013120510                     \n");
			sql.append("   AND SFWIR.ACTION_TYPE='00'                          \n");
			if(!"-1".equals(wareFirstKindId)){
			sql.append("   AND WFK.WARE_FIRST_KIND_ID =" + wareFirstKindId + " \n");
			}
			if(!"-1".equals(wareKindParentId)){
			sql.append("   AND WKP.WARE_KIND_PARENT_ID =" + wareKindParentId +"\n");	
			}
			if(!"-1".equals(wareKindId)){
			sql.append("   AND WK.WARE_KIND_ID =" + wareKindId + "             \n");	
			}
			if (!StringUtil.isBlank(wareName)) {
				wareName = SmsFormworkUtils.delUnderline(wareName);
			sql.append("   AND WI.WARE_NAME LIKE '%" + wareName + "%'   ESCAPE '\\'           \n");
			}
			if(!"-1".equals(provinceCode)){
			sql.append("   AND WI.PROVINCE_CODE ='" + provinceCode + "'        \n");
			}
			if (!StringUtil.isBlank(tempName)) {
				tempName = SmsFormworkUtils.delUnderline(tempName);
				sql.append("   AND SF.FORMWORK_NAME like '%" + tempName + "%'   ESCAPE '\\' 	   \n");   	
			}
			if(!"-1".equals(wareKindInfoId)){
				sql.append("   AND wki.kind_id =" + wareKindInfoId + "             \n");	
			}
			if(!"-11".equals(activeName)&&!StringUtil.isBlank(activeName)){
				if (!"-1".equals(activeName)) {
					sql.append("   AND SFWIR.ACTION_ID =" + activeName + "                               \n"); 	
				}else {
					sql.append("     AND SFWIR.ACTION_ID NOT IN                                          \n");
					sql.append("         (SELECT DISTINCT SFWIR.ACTION_ID                                \n");
					sql.append("            FROM WARE_DISCOUNT_RLT WDR, SMS_FORMWORK_WARE_INFO_RLT SFWIR \n");
					sql.append("           WHERE WDR.DISCOUNT_ID = SFWIR.ACTION_ID                       \n");
					sql.append("             AND SFWIR.ACTION_TYPE = '00')                               \n");
				}
			}
			
		} else if ("05".equals(activeKind)) {
			//转赠
			logger.debug("转赠："+activeKind);

			sql.append("SELECT      							               \n");		
			sql.append("       WI.WARE_ID,                                     \n");
			sql.append("       WI.WARE_CODE,                                   \n");
			sql.append("       WI.WARE_NAME,                                   \n");
			sql.append("       SFWIR.ACTION_ID,                                \n");
			sql.append("       '转赠' ACTION_NAME,                              \n");
			sql.append("       SFWIR.ACTION_TYPE,                              \n");
			sql.append("       SPD.PARA_NAME ACTION_TYPE_NAME,                 \n");
			sql.append("       SFWIR.FORMWORK_ID,                              \n");
			sql.append("       SF.FORMWORK_NAME,                               \n");
			sql.append("       WK.KIND_NAME LITTLE_KIND,                       \n");
			sql.append("       WKP.BIG_KIND_NAME MIDDLE_KIND,                  \n");
			sql.append("       WFK.F_NAME FIRST_KIND,                          \n");
			sql.append("       SFWIR.OPERATOR_CODE,                            \n");
			sql.append("       wki.kind_id ware_kind_info_id,                  \n");
			sql.append("       wki.kind_name ware_kind_info_name               \n");
			sql.append("  FROM WARE_FIRST_KIND            WFK,                 \n");
			sql.append("   	   ware_kind_info      		  wki,                 \n");
			sql.append("       ware_first_kind_rlt        wfkr,                \n");
			sql.append("       WARE_KIND_PARENT           WKP,                 \n");
			sql.append("       WARE_KIND                  WK,                  \n");
			sql.append("       WARE_KIND_RLT              WKR,                 \n");
			sql.append("       WARE_INFO                  WI,                  \n");
			sql.append("       SMS_FORMWORK_WARE_INFO_RLT SFWIR,               \n");
			sql.append("       SMS_FORMWORK               SF,                  \n");
			sql.append("       SYS_PARA_DATA              SPD                  \n");
			sql.append(" WHERE WKP.WARE_FIRST_KIND_ID = WFK.WARE_FIRST_KIND_ID \n");
			sql.append("   AND WK.WARE_KIND_PARENT_ID = WKP.WARE_KIND_PARENT_ID\n");
			sql.append("   and wfkr.ware_first_kind_id = wki.kind_id(+)			\n");
			sql.append("   and WKP.ware_kind_parent_id = wfkr.ware_kind_parent_id(+)	\n");
			sql.append("   AND WKR.WARE_KIND_ID = WK.WARE_KIND_ID              \n");
			sql.append("   AND WKR.WARE_ID = WI.WARE_ID                        \n");
			sql.append("   AND SFWIR.WARE_CODE = WI.WARE_CODE                  \n");
			sql.append("   AND SFWIR.FORMWORK_ID = SF.FORMWORK_ID              \n");
			sql.append("   AND SPD.PARA_CODE=SFWIR.ACTION_TYPE                 \n");
			sql.append("   AND SFWIR.ACTION_ID= '050'                          \n");
			sql.append("   AND SPD.PARA_TYPE_ID=2013120510                     \n");
			sql.append("   AND SFWIR.ACTION_TYPE='05'                          \n");
			if(!"-1".equals(wareFirstKindId)){
			sql.append("   AND WFK.WARE_FIRST_KIND_ID =" + wareFirstKindId + " \n");
			}
			if(!"-1".equals(wareKindParentId)){
			sql.append("   AND WKP.WARE_KIND_PARENT_ID =" + wareKindParentId +"\n");	
			}
			if(!"-1".equals(wareKindId)){
			sql.append("   AND WK.WARE_KIND_ID =" + wareKindId + "             \n");	
			}
			if (!StringUtil.isBlank(wareName)) {
				wareName = SmsFormworkUtils.delUnderline(wareName);
			sql.append("   AND WI.WARE_NAME LIKE '%" + wareName + "%'   ESCAPE '\\'           \n");
			}
			if(!"-1".equals(provinceCode)){
			sql.append("   AND WI.PROVINCE_CODE ='" + provinceCode + "'        \n");
			}	
			if(!"-1".equals(wareKindInfoId)){
				sql.append("   AND wki.kind_id =" + wareKindInfoId + "             \n");	
			}
			if (!StringUtil.isBlank(tempName)) {
				tempName = SmsFormworkUtils.delUnderline(tempName);
			sql.append("   AND SF.FORMWORK_NAME like '%" + tempName + "%'   ESCAPE '\\' 	   \n");   	
			}
		}  else if ("000".equals(activeKind)) {
			//普通
			logger.debug("普通："+activeKind);
			
			sql.append("SELECT      							               \n");		
			sql.append("       WI.WARE_ID,                                     \n");
			sql.append("       WI.WARE_CODE,                                   \n");
			sql.append("       WI.WARE_NAME,                                   \n");
			sql.append("       SFWIR.ACTION_ID,                                \n");
			sql.append("       '' ACTION_NAME,                                 \n");
			sql.append("       SFWIR.ACTION_TYPE,                              \n");
			sql.append("       SPD.PARA_NAME ACTION_TYPE_NAME,                 \n");
			sql.append("       SFWIR.FORMWORK_ID,                              \n");
			sql.append("       SF.FORMWORK_NAME,                               \n");
			sql.append("       WK.KIND_NAME LITTLE_KIND,                       \n");
			sql.append("       WKP.BIG_KIND_NAME MIDDLE_KIND,                  \n");
			sql.append("       WFK.F_NAME FIRST_KIND,                          \n");
			sql.append("       SFWIR.OPERATE_TIME,                             \n");
			sql.append("       SFWIR.OPERATOR_CODE,                            \n");
			sql.append("       wki.kind_id ware_kind_info_id,                  \n");
			sql.append("       wki.kind_name ware_kind_info_name               \n");
			sql.append("  FROM WARE_FIRST_KIND            WFK,                 \n");
			sql.append("   	   ware_kind_info      		  wki,                 \n");
			sql.append("       ware_first_kind_rlt        wfkr,                \n");
			sql.append("       WARE_KIND_PARENT           WKP,                 \n");
			sql.append("       WARE_KIND                  WK,                  \n");
			sql.append("       WARE_KIND_RLT              WKR,                 \n");
			sql.append("       WARE_INFO                  WI,                  \n");
			sql.append("       SMS_FORMWORK_WARE_INFO_RLT SFWIR,               \n");
			sql.append("       SMS_FORMWORK               SF,                  \n");
			sql.append("       SYS_PARA_DATA              SPD                  \n");
			sql.append(" WHERE WKP.WARE_FIRST_KIND_ID = WFK.WARE_FIRST_KIND_ID \n");
			sql.append("   AND WK.WARE_KIND_PARENT_ID = WKP.WARE_KIND_PARENT_ID\n");
			sql.append("   and wfkr.ware_first_kind_id = wki.kind_id(+)			\n");
			sql.append("   and WKP.ware_kind_parent_id = wfkr.ware_kind_parent_id(+)	\n");
			sql.append("   AND WKR.WARE_KIND_ID = WK.WARE_KIND_ID              \n");
			sql.append("   AND WKR.WARE_ID = WI.WARE_ID                        \n");
			sql.append("   AND SFWIR.WARE_CODE = WI.WARE_CODE                  \n");
			sql.append("   AND SFWIR.FORMWORK_ID = SF.FORMWORK_ID              \n");
			sql.append("   AND SPD.PARA_CODE=SFWIR.ACTION_TYPE                 \n");
			sql.append("   AND SPD.PARA_TYPE_ID=2013120510                     \n");
			sql.append("   AND SFWIR.ACTION_TYPE='000'                         \n");
			if(!"-1".equals(wareFirstKindId)){
			sql.append("   AND WFK.WARE_FIRST_KIND_ID =" + wareFirstKindId + " \n");
			}
			if(!"-1".equals(wareKindParentId)){
			sql.append("   AND WKP.WARE_KIND_PARENT_ID =" + wareKindParentId +"\n");	
			}
			if(!"-1".equals(wareKindId)){
			sql.append("   AND WK.WARE_KIND_ID =" + wareKindId + "             \n");	
			}
			if (!StringUtil.isBlank(wareName)) {
				wareName = SmsFormworkUtils.delUnderline(wareName);
			sql.append("   AND WI.WARE_NAME LIKE '%" + wareName + "%'   ESCAPE '\\'           \n");
			}
			if(!"-1".equals(provinceCode)){
			sql.append("   AND WI.PROVINCE_CODE ='" + provinceCode + "'        \n");
			}		
			if (!StringUtil.isBlank(tempName)) {
				tempName = SmsFormworkUtils.delUnderline(tempName);
			sql.append("   AND SF.FORMWORK_NAME like '%" + tempName + "%'   ESCAPE '\\' 	   \n");   	
			}
			if(!"-1".equals(wareKindInfoId)){
				sql.append("   AND wki.kind_id =" + wareKindInfoId + "             \n");	
			}
		}
		if (!StringUtil.isBlank(wareCode)) {
			sql.append("   AND WI.WARE_CODE like '%" + wareCode + "%'          \n");	
		}
		sql.append("   AND WKR.IS_DEFAULT_KIND ='1'        					   \n");
		sql.append("ORDER BY SFWIR.OPERATE_TIME DESC     			           \n");
		if(startNum != -1 && endNum != -1){
			sql.append(" ) ) where  row_index >=").append(startNum).append(" and row_index <= ").append(endNum); 	
		}
		 	
		return QBOWareTempEngine.getBeansFromSql(sql.toString(), null);
	}
	
	public int getWareTempListCount(String wareFirstKindId, String wareKindParentId, String wareKindId,
			String wareName, String wareCode, String provinceCode, String tempName, String activeKind,String activeName,String wareKindInfoId) throws Exception {
	StringBuffer sql = new StringBuffer();
		
		if ("02".equals(activeKind)) {
			//团购
			logger.debug("团购："+activeKind);

			sql.append("SELECT COUNT(WI.WARE_ID) WARE_ID                       \n");
			sql.append("  FROM WARE_FIRST_KIND            WFK,                 \n");
			sql.append("   	   ware_kind_info      		  wki,                 \n");
			sql.append("       ware_first_kind_rlt        wfkr,                \n");
			sql.append("       WARE_KIND_PARENT           WKP,                 \n");
			sql.append("       WARE_KIND                  WK,                  \n");
			sql.append("       WARE_KIND_RLT              WKR,                 \n");
			sql.append("       WARE_INFO                  WI,                  \n");
			sql.append("       SMS_FORMWORK_WARE_INFO_RLT SFWIR,               \n");
			sql.append("       SMS_FORMWORK               SF,                  \n");
			sql.append("       SYS_PARA_DATA              SPD,                 \n");
			sql.append("       TUAN_INFO                  TI                   \n");
			sql.append(" WHERE WKP.WARE_FIRST_KIND_ID = WFK.WARE_FIRST_KIND_ID \n");
			sql.append("   AND WK.WARE_KIND_PARENT_ID = WKP.WARE_KIND_PARENT_ID\n");
			sql.append("   and wfkr.ware_first_kind_id = wki.kind_id(+)			\n");
			sql.append("   and WKP.ware_kind_parent_id = wfkr.ware_kind_parent_id(+)	\n");
			sql.append("   AND WKR.WARE_KIND_ID = WK.WARE_KIND_ID              \n");
			sql.append("   AND WKR.WARE_ID = WI.WARE_ID                        \n");
			sql.append("   AND SFWIR.WARE_CODE = WI.WARE_CODE                  \n");
			sql.append("   AND SFWIR.FORMWORK_ID = SF.FORMWORK_ID              \n");
			sql.append("   AND SPD.PARA_CODE=SFWIR.ACTION_TYPE                 \n");
			sql.append("   AND SFWIR.ACTION_ID=TI.TUAN_ID                      \n");
			sql.append("   AND SPD.PARA_TYPE_ID=2013120510                     \n");
			sql.append("   AND SFWIR.ACTION_TYPE='02'                          \n");
			if(!"-1".equals(wareFirstKindId)){
			sql.append("   AND WFK.WARE_FIRST_KIND_ID =" + wareFirstKindId + " \n");
			}
			if(!"-1".equals(wareKindParentId)){
			sql.append("   AND WKP.WARE_KIND_PARENT_ID =" + wareKindParentId +"\n");	
			}
			if(!"-1".equals(wareKindId)){
			sql.append("   AND WK.WARE_KIND_ID =" + wareKindId + "             \n");	
			}
			if (!StringUtil.isBlank(wareName)) {
				wareName = SmsFormworkUtils.delUnderline(wareName);
			sql.append("   AND WI.WARE_NAME LIKE '%" + wareName + "%'   ESCAPE '\\'           \n");
			}
			if(!"-1".equals(provinceCode)){
			sql.append("   AND WI.PROVINCE_CODE ='" + provinceCode + "'        \n");
			}
			if (!StringUtil.isBlank(tempName)) {
				tempName = SmsFormworkUtils.delUnderline(tempName);
			sql.append("   AND SF.FORMWORK_NAME like '%" + tempName + "%'   ESCAPE '\\' 	   \n");   	
			}
			if(!"-1".equals(wareKindInfoId)){
				sql.append("   AND wki.kind_id =" + wareKindInfoId + "             \n");	
			}
			if(!"-11".equals(activeName)&&!StringUtil.isBlank(activeName)){
			sql.append("   AND SFWIR.ACTION_ID =" + activeName + "             \n"); 	
			}
			
		} else if ("01".equals(activeKind)) {
			//抢兑
			logger.debug("抢兑："+activeKind);

			sql.append("SELECT COUNT(WI.WARE_ID) WARE_ID                       \n");
			sql.append("  FROM WARE_FIRST_KIND            WFK,                 \n");
			sql.append("   	   ware_kind_info      		  wki,                 \n");
			sql.append("       ware_first_kind_rlt        wfkr,                \n");
			sql.append("       WARE_KIND_PARENT           WKP,                 \n");
			sql.append("       WARE_KIND                  WK,                  \n");
			sql.append("       WARE_KIND_RLT              WKR,                 \n");
			sql.append("       WARE_INFO                  WI,                  \n");
			sql.append("       SMS_FORMWORK_WARE_INFO_RLT SFWIR,               \n");
			sql.append("       SMS_FORMWORK               SF,                  \n");
			sql.append("       SYS_PARA_DATA              SPD,                 \n");
			sql.append("       ACTIVITY_LIMIT             AL                   \n");
			sql.append(" WHERE WKP.WARE_FIRST_KIND_ID = WFK.WARE_FIRST_KIND_ID \n");
			sql.append("   AND WK.WARE_KIND_PARENT_ID = WKP.WARE_KIND_PARENT_ID\n");
			sql.append("   and wfkr.ware_first_kind_id = wki.kind_id(+)			\n");
			sql.append("   and WKP.ware_kind_parent_id = wfkr.ware_kind_parent_id(+)	\n");
			sql.append("   AND WKR.WARE_KIND_ID = WK.WARE_KIND_ID              \n");
			sql.append("   AND WKR.WARE_ID = WI.WARE_ID                        \n");
			sql.append("   AND SFWIR.WARE_CODE = WI.WARE_CODE                  \n");
			sql.append("   AND SFWIR.FORMWORK_ID = SF.FORMWORK_ID              \n");
			sql.append("   AND SPD.PARA_CODE=SFWIR.ACTION_TYPE                 \n");
			sql.append("   AND SFWIR.ACTION_ID=AL.ACTIVITY_ID                  \n");
			sql.append("   AND SPD.PARA_TYPE_ID=2013120510                     \n");
			sql.append("   AND SFWIR.ACTION_TYPE='01'                          \n");
			if(!"-1".equals(wareFirstKindId)){
			sql.append("   AND WFK.WARE_FIRST_KIND_ID =" + wareFirstKindId + " \n");
			}
			if(!"-1".equals(wareKindParentId)){
			sql.append("   AND WKP.WARE_KIND_PARENT_ID =" + wareKindParentId +"\n");	
			}
			if(!"-1".equals(wareKindId)){
			sql.append("   AND WK.WARE_KIND_ID =" + wareKindId + "             \n");	
			}
			if (!StringUtil.isBlank(wareName)) {
				wareName = SmsFormworkUtils.delUnderline(wareName);
			sql.append("   AND WI.WARE_NAME LIKE '%" + wareName + "%'   ESCAPE '\\'           \n");
			}
			if(!"-1".equals(provinceCode)){
			sql.append("   AND WI.PROVINCE_CODE ='" + provinceCode + "'        \n");
			}
			if (!StringUtil.isBlank(tempName)) {
				tempName = SmsFormworkUtils.delUnderline(tempName);
			sql.append("   AND SF.FORMWORK_NAME like '%" + tempName + "%'   ESCAPE '\\' 	   \n");   	
			}
			if(!"-1".equals(wareKindInfoId)){
				sql.append("   AND wki.kind_id =" + wareKindInfoId + "             \n");	
			}
			if(!"-11".equals(activeName)&&!StringUtil.isBlank(activeName)){
			sql.append("   AND SFWIR.ACTION_ID =" + activeName + "             \n"); 	
			}
			
		} else if ("04".equals(activeKind)) {
			//优惠
			logger.debug("优惠："+activeKind);

			sql.append("SELECT COUNT(WI.WARE_ID) WARE_ID                       \n");
			sql.append("  FROM WARE_FIRST_KIND            WFK,                 \n");
			sql.append("   	   ware_kind_info      		  wki,                 \n");
			sql.append("       ware_first_kind_rlt        wfkr,                \n");
			sql.append("       WARE_KIND_PARENT           WKP,                 \n");
			sql.append("       WARE_KIND                  WK,                  \n");
			sql.append("       WARE_KIND_RLT              WKR,                 \n");
			sql.append("       WARE_INFO                  WI,                  \n");
			sql.append("       SMS_FORMWORK_WARE_INFO_RLT SFWIR,               \n");
			sql.append("       SMS_FORMWORK               SF,                  \n");
			sql.append("       SYS_PARA_DATA              SPD,                 \n");
			sql.append("       PERMISSION_INFO            PI                   \n");
			sql.append(" WHERE WKP.WARE_FIRST_KIND_ID = WFK.WARE_FIRST_KIND_ID \n");
			sql.append("   AND WK.WARE_KIND_PARENT_ID = WKP.WARE_KIND_PARENT_ID\n");
			sql.append("   and wfkr.ware_first_kind_id = wki.kind_id(+)			\n");
			sql.append("   and WKP.ware_kind_parent_id = wfkr.ware_kind_parent_id(+)	\n");
			sql.append("   AND WKR.WARE_KIND_ID = WK.WARE_KIND_ID              \n");
			sql.append("   AND WKR.WARE_ID = WI.WARE_ID                        \n");
			sql.append("   AND SFWIR.WARE_CODE = WI.WARE_CODE                  \n");
			sql.append("   AND SFWIR.FORMWORK_ID = SF.FORMWORK_ID              \n");
			sql.append("   AND SPD.PARA_CODE=SFWIR.ACTION_TYPE                 \n");
			sql.append("   AND SFWIR.ACTION_ID=PI.PERMISSION_ID                \n");
			sql.append("   AND SPD.PARA_TYPE_ID=2013120510                     \n");
			sql.append("   AND SFWIR.ACTION_TYPE='04'                          \n");
			if(!"-1".equals(wareFirstKindId)){
			sql.append("   AND WFK.WARE_FIRST_KIND_ID =" + wareFirstKindId + " \n");
			}
			if(!"-1".equals(wareKindParentId)){
			sql.append("   AND WKP.WARE_KIND_PARENT_ID =" + wareKindParentId +"\n");	
			}
			if(!"-1".equals(wareKindId)){
			sql.append("   AND WK.WARE_KIND_ID =" + wareKindId + "             \n");	
			}
			if (!StringUtil.isBlank(wareName)) {
				wareName = SmsFormworkUtils.delUnderline(wareName);
			sql.append("   AND WI.WARE_NAME LIKE '%" + wareName + "%'   ESCAPE '\\'           \n");
			}
			if(!"-1".equals(provinceCode)){
			sql.append("   AND WI.PROVINCE_CODE ='" + provinceCode + "'        \n");
			}
			if (!StringUtil.isBlank(tempName)) {
				tempName = SmsFormworkUtils.delUnderline(tempName);
			sql.append("   AND SF.FORMWORK_NAME like '%" + tempName + "%'   ESCAPE '\\' 	   \n");   	
			}
			if(!"-1".equals(wareKindInfoId)){
				sql.append("   AND wki.kind_id =" + wareKindInfoId + "             \n");	
			}
			if(!"-11".equals(activeName)&&!StringUtil.isBlank(activeName)){
			sql.append("   AND SFWIR.ACTION_ID =" + activeName + "             \n"); 	
			}
		} else if ("00".equals(activeKind)) {
			//打折
			logger.debug("打折："+activeKind);

			sql.append("SELECT COUNT(WI.WARE_ID) WARE_ID                       \n");
			sql.append("  FROM WARE_FIRST_KIND            WFK,                 \n");
			sql.append("   	   ware_kind_info      		  wki,                 \n");
			sql.append("       ware_first_kind_rlt        wfkr,                \n");
			sql.append("       WARE_KIND_PARENT           WKP,                 \n");
			sql.append("       WARE_KIND                  WK,                  \n");
			sql.append("       WARE_KIND_RLT              WKR,                 \n");
			sql.append("       WARE_INFO                  WI,                  \n");
			sql.append("       SMS_FORMWORK_WARE_INFO_RLT SFWIR,               \n");
			sql.append("       SMS_FORMWORK               SF,                  \n");
			sql.append("       SYS_PARA_DATA              SPD                  \n");
			sql.append(" WHERE WKP.WARE_FIRST_KIND_ID = WFK.WARE_FIRST_KIND_ID \n");
			sql.append("   AND WK.WARE_KIND_PARENT_ID = WKP.WARE_KIND_PARENT_ID\n");
			sql.append("   and wfkr.ware_first_kind_id = wki.kind_id(+)			\n");
			sql.append("   and WKP.ware_kind_parent_id = wfkr.ware_kind_parent_id(+)	\n");
			sql.append("   AND WKR.WARE_KIND_ID = WK.WARE_KIND_ID              \n");
			sql.append("   AND WKR.WARE_ID = WI.WARE_ID                        \n");
			sql.append("   AND SFWIR.WARE_CODE = WI.WARE_CODE                  \n");
			sql.append("   AND SFWIR.FORMWORK_ID = SF.FORMWORK_ID              \n");
			sql.append("   AND SPD.PARA_CODE=SFWIR.ACTION_TYPE                 \n");
			sql.append("   AND SPD.PARA_TYPE_ID=2013120510                     \n");
			sql.append("   AND SFWIR.ACTION_TYPE='00'                          \n");
			if(!"-1".equals(wareFirstKindId)){
			sql.append("   AND WFK.WARE_FIRST_KIND_ID =" + wareFirstKindId + " \n");
			}
			if(!"-1".equals(wareKindParentId)){
			sql.append("   AND WKP.WARE_KIND_PARENT_ID =" + wareKindParentId +"\n");	
			}
			if(!"-1".equals(wareKindId)){
			sql.append("   AND WK.WARE_KIND_ID =" + wareKindId + "             \n");	
			}
			if (!StringUtil.isBlank(wareName)) {
				wareName = SmsFormworkUtils.delUnderline(wareName);
			sql.append("   AND WI.WARE_NAME LIKE '%" + wareName + "%'   ESCAPE '\\'           \n");
			}
			if(!"-1".equals(provinceCode)){
			sql.append("   AND WI.PROVINCE_CODE ='" + provinceCode + "'        \n");
			}
			if (!StringUtil.isBlank(tempName)) {
				tempName = SmsFormworkUtils.delUnderline(tempName);
			sql.append("   AND SF.FORMWORK_NAME like '%" + tempName + "%'   ESCAPE '\\' 	   \n");   	
			}
			if(!"-1".equals(wareKindInfoId)){
				sql.append("   AND wki.kind_id =" + wareKindInfoId + "             \n");	
			}
			if(!"-11".equals(activeName)&&!StringUtil.isBlank(activeName)){
				if (!"-1".equals(activeName)) {
					sql.append("   AND SFWIR.ACTION_ID =" + activeName + "     \n"); 	
				}else {
					sql.append("     AND SFWIR.ACTION_ID NOT IN                                          \n");
					sql.append("         (SELECT DISTINCT SFWIR.ACTION_ID                                \n");
					sql.append("            FROM WARE_DISCOUNT_RLT WDR, SMS_FORMWORK_WARE_INFO_RLT SFWIR \n");
					sql.append("           WHERE WDR.DISCOUNT_ID = SFWIR.ACTION_ID                       \n");
					sql.append("             AND SFWIR.ACTION_TYPE = '00')                               \n");
				}
			}
		} else if ("05".equals(activeKind)) {
			//转赠
			logger.debug("转赠："+activeKind);

			sql.append("SELECT COUNT(WI.WARE_ID) WARE_ID                       \n");
			sql.append("  FROM WARE_FIRST_KIND            WFK,                 \n");
			sql.append("   	   ware_kind_info      		  wki,                 \n");
			sql.append("       ware_first_kind_rlt        wfkr,                \n");
			sql.append("       WARE_KIND_PARENT           WKP,                 \n");
			sql.append("       WARE_KIND                  WK,                  \n");
			sql.append("       WARE_KIND_RLT              WKR,                 \n");
			sql.append("       WARE_INFO                  WI,                  \n");
			sql.append("       SMS_FORMWORK_WARE_INFO_RLT SFWIR,               \n");
			sql.append("       SMS_FORMWORK               SF,                  \n");
			sql.append("       SYS_PARA_DATA              SPD                  \n");
			sql.append(" WHERE WKP.WARE_FIRST_KIND_ID = WFK.WARE_FIRST_KIND_ID \n");
			sql.append("   AND WK.WARE_KIND_PARENT_ID = WKP.WARE_KIND_PARENT_ID\n");
			sql.append("   and wfkr.ware_first_kind_id = wki.kind_id(+)			\n");
			sql.append("   and WKP.ware_kind_parent_id = wfkr.ware_kind_parent_id(+)	\n");
			sql.append("   AND WKR.WARE_KIND_ID = WK.WARE_KIND_ID              \n");
			sql.append("   AND WKR.WARE_ID = WI.WARE_ID                        \n");
			sql.append("   AND SFWIR.WARE_CODE = WI.WARE_CODE                  \n");
			sql.append("   AND SFWIR.FORMWORK_ID = SF.FORMWORK_ID              \n");
			sql.append("   AND SPD.PARA_CODE=SFWIR.ACTION_TYPE                 \n");
			sql.append("   AND SFWIR.ACTION_ID= '050'                          \n");
			sql.append("   AND SPD.PARA_TYPE_ID=2013120510                     \n");
			sql.append("   AND SFWIR.ACTION_TYPE='05'                          \n");
			if(!"-1".equals(wareFirstKindId)){
			sql.append("   AND WFK.WARE_FIRST_KIND_ID =" + wareFirstKindId + " \n");
			}
			if(!"-1".equals(wareKindParentId)){
			sql.append("   AND WKP.WARE_KIND_PARENT_ID =" + wareKindParentId +"\n");	
			}
			if(!"-1".equals(wareKindId)){
			sql.append("   AND WK.WARE_KIND_ID =" + wareKindId + "             \n");	
			}
			if (!StringUtil.isBlank(wareName)) {
				wareName = SmsFormworkUtils.delUnderline(wareName);
			sql.append("   AND WI.WARE_NAME LIKE '%" + wareName + "%'   ESCAPE '\\'           \n");
			}
			if(!"-1".equals(provinceCode)){
			sql.append("   AND WI.PROVINCE_CODE ='" + provinceCode + "'        \n");
			}
			if(!"-1".equals(wareKindInfoId)){
				sql.append("   AND wki.kind_id =" + wareKindInfoId + "             \n");	
			}
			if (!StringUtil.isBlank(tempName)) {
				tempName = SmsFormworkUtils.delUnderline(tempName);
			sql.append("   AND SF.FORMWORK_NAME like '%" + tempName + "%'   ESCAPE '\\' 	   \n");   	
			}
		} else if ("000".equals(activeKind)) {
			//普通
			logger.debug("普通："+activeKind);

			sql.append("SELECT COUNT(WI.WARE_ID) WARE_ID                       \n");
			sql.append("  FROM WARE_FIRST_KIND            WFK,                 \n");
			sql.append("   	   ware_kind_info      		  wki,                 \n");
			sql.append("       ware_first_kind_rlt        wfkr,                \n");
			sql.append("       WARE_KIND_PARENT           WKP,                 \n");
			sql.append("       WARE_KIND                  WK,                  \n");
			sql.append("       WARE_KIND_RLT              WKR,                 \n");
			sql.append("       WARE_INFO                  WI,                  \n");
			sql.append("       SMS_FORMWORK_WARE_INFO_RLT SFWIR,               \n");
			sql.append("       SMS_FORMWORK               SF,                  \n");
			sql.append("       SYS_PARA_DATA              SPD                  \n");
			sql.append(" WHERE WKP.WARE_FIRST_KIND_ID = WFK.WARE_FIRST_KIND_ID \n");
			sql.append("   AND WK.WARE_KIND_PARENT_ID = WKP.WARE_KIND_PARENT_ID\n");
			sql.append("   and wfkr.ware_first_kind_id = wki.kind_id(+)			\n");
			sql.append("   and WKP.ware_kind_parent_id = wfkr.ware_kind_parent_id(+)	\n");
			sql.append("   AND WKR.WARE_KIND_ID = WK.WARE_KIND_ID              \n");
			sql.append("   AND WKR.WARE_ID = WI.WARE_ID                        \n");
			sql.append("   AND SFWIR.WARE_CODE = WI.WARE_CODE                  \n");
			sql.append("   AND SFWIR.FORMWORK_ID = SF.FORMWORK_ID              \n");
			sql.append("   AND SPD.PARA_CODE=SFWIR.ACTION_TYPE                 \n");
			sql.append("   AND SPD.PARA_TYPE_ID=2013120510                     \n");
			sql.append("   AND SFWIR.ACTION_TYPE='000'                         \n");
			if(!"-1".equals(wareFirstKindId)){
			sql.append("   AND WFK.WARE_FIRST_KIND_ID =" + wareFirstKindId + " \n");
			}
			if(!"-1".equals(wareKindParentId)){
			sql.append("   AND WKP.WARE_KIND_PARENT_ID =" + wareKindParentId +"\n");	
			}
			if(!"-1".equals(wareKindId)){
			sql.append("   AND WK.WARE_KIND_ID =" + wareKindId + "             \n");	
			}
			if (!StringUtil.isBlank(wareName)) {
				wareName = SmsFormworkUtils.delUnderline(wareName);
			sql.append("   AND WI.WARE_NAME LIKE '%" + wareName + "%'   ESCAPE '\\'           \n");
			}
			if(!"-1".equals(provinceCode)){
			sql.append("   AND WI.PROVINCE_CODE ='" + provinceCode + "'        \n");
			}
			if (!StringUtil.isBlank(tempName)) {
				tempName = SmsFormworkUtils.delUnderline(tempName);
			sql.append("   AND SF.FORMWORK_NAME like '%" + tempName + "%'   ESCAPE '\\' 	   \n");   	
			}
			if(!"-1".equals(wareKindInfoId)){
				sql.append("   AND wki.kind_id =" + wareKindInfoId + "             \n");	
			}
		}
		if (!StringUtil.isBlank(wareCode)) {
			sql.append("   AND WI.WARE_CODE like '%" + wareCode + "%'          \n");	
		}

		sql.append("   AND WKR.IS_DEFAULT_KIND ='1'        					   \n");
		
		IQBOWareTempValue[] wareTempList = QBOWareTempEngine.getBeansFromSql(sql.toString(), null);  
		
		int count=Integer.parseInt(wareTempList[0].getWareId());
		logger.debug("返回行数："+count);
		return count;
	}
	
	public List<SysPara> getactiveKindJson(String activeKind) throws Exception {
		
		String sql=null;
		if ("02".equals(activeKind)) {
			//团购
			 sql = "SELECT ti.tuan_id PARA_ID ,ti.name PARA_NAME FROM tuan_info ti";
		} else if("01".equals(activeKind)){
			//抢兑
			 sql = "SELECT al.activity_id PARA_ID ,al.activity_name PARA_NAME FROM activity_limit al";
		} else if("04".equals(activeKind)){
			//优惠
			 sql = "SELECT p.permission_id PARA_ID,p.permission_name PARA_NAME FROM permission_info p";
		} else if("00".equals(activeKind)){
			//打折
			 sql = "SELECT w.discount_id PARA_ID,w.discount_name PARA_NAME FROM ware_discount_info w";
		} 
			logger.debug(sql);
			SysParaDataBean[] b  = SysParaDataEngine.getBeansFromSql(sql, null);

			ArrayList<SysPara> list = new ArrayList<SysPara>();
			SysPara sp = null;
			for (int i = 0; i < b.length; i++) {
				sp = new SysPara();
				sp.setText(b[i].getParaName());
				sp.setValue(b[i].getParaId()+"");
				list.add(sp);
				sp = null;
			}
			if ("00".equals(activeKind)) {
				sp = new SysPara();
				sp.setText("按折扣值打折");
				sp.setValue("-1");
				list.add(sp);
				sp = null;
			}
			logger.info(list);
			return list;
	}
}
