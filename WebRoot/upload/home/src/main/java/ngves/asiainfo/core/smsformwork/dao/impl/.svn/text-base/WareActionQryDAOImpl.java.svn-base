package ngves.asiainfo.core.smsformwork.dao.impl;

import ngves.asiainfo.core.smsformwork.bo.QBOWareActionQryEngine;
import ngves.asiainfo.core.smsformwork.dao.interfaces.IWareActionQryDAO;
import ngves.asiainfo.core.smsformwork.ivalues.IQBOWareActionQryValue;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WareActionQryDAOImpl implements IWareActionQryDAO {

	private static Log logger = LogFactory.getLog(WareActionQryDAOImpl.class);
	
	public IQBOWareActionQryValue[] getWareActionQryList(String activeKind,String activeName, String wareId,int startIndex, int endIndex) throws Exception{
		
		StringBuffer sql = new StringBuffer();
		if(startIndex != -1 && endIndex != -1){
			sql.append(" select WARE_ID,                                  \n");
			sql.append("        WARE_CODE,                                \n");
			sql.append("        WARE_NAME,                                \n");
			sql.append("        ACTION_ID,                                \n");
			sql.append("        ACTION_NAME,                              \n");
			sql.append("        ACTION_TYPE,                              \n");
			sql.append("        FORMWORK_ID,                              \n");
			sql.append("        FORMWORK_NAME                            \n");
			sql.append(" from ( SELECT WARE_ID,                           \n");
			sql.append("        WARE_CODE,                                \n");
			sql.append("        WARE_NAME,                                \n");
			sql.append("        ACTION_ID,                                \n");
			sql.append("        ACTION_NAME,                              \n");
			sql.append("        ACTION_TYPE,                              \n");
			sql.append("        FORMWORK_ID,                              \n");
			sql.append("        FORMWORK_NAME,                            \n");
			sql.append(" 		rownum as row_index                       \n");
			sql.append("   FROM (                   					  \n");
		}
		
		if ("02".equals(activeKind)){
			//团购
			logger.debug("团购："+activeKind);

			sql.append("SELECT          								  \n");
			sql.append("                DISTINCT WI.WARE_ID,              \n");
			sql.append("                WI.WARE_CODE,                     \n");
			sql.append("                WI.WARE_NAME,                     \n");
			sql.append("                TI.TUAN_ID ACTION_ID,             \n");
			sql.append("                TI.NAME ACTION_NAME,              \n");
			sql.append("                '02' ACTION_TYPE,                 \n");
			sql.append("                '' FORMWORK_ID,                   \n");           
			sql.append("                (SELECT DISTINCT NVL(SF.FORMWORK_NAME,'')  \n");
			sql.append("				FROM SMS_FORMWORK_WARE_INFO_RLT SFWIR,\n");
			sql.append("					 SMS_FORMWORK SF              \n");
			sql.append("   WHERE SFWIR.FORMWORK_ID=SF.FORMWORK_ID         \n");
			sql.append("     AND SFWIR.WARE_CODE = WI.WARE_CODE           \n");
			sql.append("     AND SFWIR.ACTION_ID = TI.TUAN_ID           \n");
			sql.append("     AND SFWIR.ACTION_TYPE= '02' ) FORMWORK_NAME  \n");
			sql.append("           FROM WARE_INFO                  WI,    \n");
			sql.append("                TUAN_WARE_RLT              TWR,   \n");
			sql.append("                TUAN_INFO                  TI     \n");
			sql.append("          WHERE TWR.WARE_ID = WI.WARE_ID          \n");
			sql.append("            AND TWR.TUAN_ID = TI.TUAN_ID          \n");
			if(StringUtil.isNotNullValue(activeName)){
			sql.append("            AND TI.TUAN_ID IN(" + activeName + ") \n");	
			} 	
		}else if ("01".equals(activeKind)) {
			//抢兑
			logger.debug("抢兑："+activeKind);
			
			sql.append("SELECT                                            \n");
			sql.append("                DISTINCT WI.WARE_ID,              \n");
			sql.append("                WI.WARE_CODE,                     \n");
			sql.append("                WI.WARE_NAME,                     \n");
			sql.append("                AL.ACTIVITY_ID ACTION_ID,         \n");
			sql.append("                AL.ACTIVITY_NAME ACTION_NAME,     \n");
			sql.append("                '01' ACTION_TYPE,                 \n");
			sql.append("                '' FORMWORK_ID,                   \n");           
			sql.append("                (SELECT DISTINCT NVL(SF.FORMWORK_NAME,'')  \n");
			sql.append("				FROM SMS_FORMWORK_WARE_INFO_RLT SFWIR,\n");
			sql.append("					 SMS_FORMWORK SF              \n");
			sql.append("   WHERE SFWIR.FORMWORK_ID=SF.FORMWORK_ID         \n");
			sql.append("     AND SFWIR.WARE_CODE = WI.WARE_CODE           \n");
			sql.append("     AND SFWIR.ACTION_ID = AL.ACTIVITY_ID         \n");
			sql.append("     AND SFWIR.ACTION_TYPE= '01' ) FORMWORK_NAME  \n");
			sql.append("           FROM WARE_INFO                  WI,    \n");
			sql.append("                ACTIVITY_BIND_RELATION     ABR,   \n");
			sql.append("                ACTIVITY_LIMIT             AL     \n");
			sql.append("          WHERE ABR.WARE_ID = WI.WARE_ID          \n");
			sql.append("            AND ABR.ACTIVITY_ID = AL.ACTIVITY_ID  \n");
			if(StringUtil.isNotNullValue(activeName)){
			sql.append("            AND AL.ACTIVITY_ID IN(" + activeName + ") \n");	
				} 	
			
		}else if ("04".equals(activeKind)) {
			//优惠
			logger.debug("优惠："+activeKind);
			
			sql.append("SELECT                                            \n");
			sql.append("                DISTINCT WI.WARE_ID,              \n");
			sql.append("                WI.WARE_CODE,                     \n");
			sql.append("                WI.WARE_NAME,                     \n");
			sql.append("                PI.PERMISSION_ID ACTION_ID,       \n");
			sql.append("                PI.PERMISSION_NAME ACTION_NAME,   \n");
			sql.append("                '04' ACTION_TYPE,                 \n");
			sql.append("                '' FORMWORK_ID,                   \n");       
			sql.append("                (SELECT DISTINCT NVL(SF.FORMWORK_NAME,'')  \n");
			sql.append("				FROM SMS_FORMWORK_WARE_INFO_RLT SFWIR,\n");
			sql.append("					 SMS_FORMWORK SF              \n");
			sql.append("   WHERE SFWIR.FORMWORK_ID=SF.FORMWORK_ID         \n");
			sql.append("     AND SFWIR.WARE_CODE = WI.WARE_CODE           \n");
			sql.append("     AND SFWIR.ACTION_ID = PI.PERMISSION_ID       \n");
			sql.append("     AND SFWIR.ACTION_TYPE= '04' ) FORMWORK_NAME  \n");
			sql.append("           FROM WARE_INFO                  WI,    \n");
			sql.append("                PERMISSION_RULE_RLT        PRR,   \n");
			sql.append("                PERMISSION_INFO            PI     \n");
			sql.append("          WHERE PRR.WARE_ID = WI.WARE_ID          \n");
			sql.append("            AND PRR.PERMISSION_ID = PI.PERMISSION_ID \n");
			sql.append("            AND PRR.BIND_STATUS = '1'			  \n");
			if(StringUtil.isNotNullValue(activeName)){
			sql.append("            AND PI.PERMISSION_ID IN(" + activeName + ") \n");	
			} 	
			
			
		}else if ("00".equals(activeKind)) {
			//打折
			logger.debug("打折："+activeKind);
			
			//判断是否为全查的标志，flag=true代表不全查
			boolean flag=true;
			
			//当activeName为空的时候，执行全查
			if (StringUtil.isBlank(activeName)) {
				activeName="-1";
				flag=false;
			}
			
			if(activeName.indexOf("-1")>=0){
				//按积分折扣值打折和促销规则
				logger.debug("按积分折扣值打折和促销规则");
				sql.append(" SELECT                                                                       \n");
				sql.append("        WI.WARE_ID,                                                           \n");
				sql.append("        WI.WARE_CODE,                                                         \n");
				sql.append("        WI.WARE_NAME,                                                         \n");
				sql.append("        ACTION_ID,  														  \n");
				sql.append("        ACTION_NAME,                                                          \n");
				sql.append("        ACTION_TYPE,                                                    	  \n");
				sql.append("        FORMWORK_ID,                                                   		  \n");
				sql.append("        FORMWORK_NAME                                                     	  \n");
				sql.append("        FROM (																  \n");
				sql.append(" SELECT                                                                       \n");
				sql.append("        DISTINCT WI.WARE_ID,                                                  \n");
				sql.append("        WI.WARE_CODE,                                                         \n");
				sql.append("        WI.WARE_NAME,                                                         \n");
				sql.append("        TO_CHAR(WDVR.DISCOUNT_VALUE, 'FM000000000000000') ACTION_ID,          \n");
				sql.append("        '按折扣值打折' ACTION_NAME,                                             \n");
				sql.append("        '00' ACTION_TYPE,                                                     \n");
				sql.append("        '' FORMWORK_ID,                                                       \n");
				sql.append("                (SELECT DISTINCT NVL(SF.FORMWORK_NAME,'')                     \n");
				sql.append("				FROM SMS_FORMWORK_WARE_INFO_RLT SFWIR,                        \n");
				sql.append("					 SMS_FORMWORK SF                                          \n");
				sql.append("   WHERE SFWIR.FORMWORK_ID=SF.FORMWORK_ID                                     \n");
				sql.append("     AND SFWIR.WARE_CODE = WI.WARE_CODE                                       \n");
				sql.append("     AND SFWIR.ACTION_ID = TO_CHAR(WDVR.DISCOUNT_VALUE, 'FM000000000000000')  \n");
				sql.append("     AND SFWIR.ACTION_TYPE= '00' ) FORMWORK_NAME                              \n");
				sql.append("   FROM WARE_DISCOUNT_VALUE_RLT    WDVR,                                      \n");
				sql.append("        WARE_INTEGRAL_INFO         WII,                                       \n");
				sql.append("        WARE_INFO                  WI                                         \n");				
				sql.append("  WHERE WII.WARE_ID = WDVR.WARE_ID                                            \n");
				sql.append("    AND WII.MOBILE_BRAND_CODE = WDVR.MOBILE_BRAND_CODE                        \n");           
				sql.append("    AND WII.WARE_ID = WI.WARE_ID                                              \n");
				sql.append("    AND WDVR.RLT_STATE != '2'                                                 \n");
				sql.append("   UNION  ALL                     				      						  \n");
				sql.append(" SELECT                               							              \n");
				sql.append("                DISTINCT WI.WARE_ID,                       				      \n");
				sql.append("                WI.WARE_CODE,                     							  \n");
				sql.append("                WI.WARE_NAME,                    							  \n");
				sql.append("                TO_CHAR(WDI.DISCOUNT_ID) ACTION_ID,							  \n");
				sql.append("                WDI.DISCOUNT_NAME ACTION_NAME,    							  \n");
				sql.append("                '00' ACTION_TYPE,                							  \n");
				sql.append("                '' FORMWORK_ID,                				     			  \n");           
				sql.append("                (SELECT DISTINCT NVL(SF.FORMWORK_NAME,'')                     \n");
				sql.append("				FROM SMS_FORMWORK_WARE_INFO_RLT SFWIR,                        \n");
				sql.append("					 SMS_FORMWORK SF                                          \n");
				sql.append("   WHERE SFWIR.FORMWORK_ID=SF.FORMWORK_ID                                     \n");
				sql.append("     AND SFWIR.WARE_CODE = WI.WARE_CODE                                       \n");
				sql.append("     AND SFWIR.ACTION_ID = TO_CHAR(WDI.DISCOUNT_ID)                           \n");
				sql.append("     AND SFWIR.ACTION_TYPE= '00' ) FORMWORK_NAME                              \n");
				sql.append("           FROM WARE_INFO                  WI,    							  \n");
				sql.append("                WARE_DISCOUNT_RLT          WDR,   							  \n");
				sql.append("                WARE_DISCOUNT_INFO         WDI   							  \n");
				sql.append("          WHERE WDR.WARE_ID = WI.WARE_ID         							  \n");
				sql.append("            AND WDR.DISCOUNT_ID = WDI.DISCOUNT_ID 							  \n");
				sql.append("            AND WDR.RLT_STATE != '2'										  \n");
				if(StringUtil.isNotNullValue(activeName)&&flag){
				sql.append("            AND WDI.DISCOUNT_ID IN(" + activeName + ")    					  \n");			
				}
				sql.append(" ) WI WHERE 1=1  															  \n");			
			}else {
				//按促销规则
				sql.append("SELECT                                            \n");
				sql.append("                DISTINCT WI.WARE_ID,              \n");
				sql.append("                WI.WARE_CODE,                     \n");
				sql.append("                WI.WARE_NAME,                     \n");
				sql.append("                TO_CHAR(WDI.DISCOUNT_ID) ACTION_ID,\n");
				sql.append("                WDI.DISCOUNT_NAME ACTION_NAME,    \n");
				sql.append("                '00' ACTION_TYPE,                 \n");
				sql.append("                '' FORMWORK_ID,                   \n");           
				sql.append("                (SELECT DISTINCT NVL(SF.FORMWORK_NAME,'')  \n");
				sql.append("				FROM SMS_FORMWORK_WARE_INFO_RLT SFWIR,\n");
				sql.append("					 SMS_FORMWORK SF              \n");
				sql.append("   WHERE SFWIR.FORMWORK_ID=SF.FORMWORK_ID         \n");
				sql.append("     AND SFWIR.WARE_CODE = WI.WARE_CODE           \n");
				sql.append("     AND SFWIR.ACTION_ID = TO_CHAR(WDI.DISCOUNT_ID)\n");
				sql.append("     AND SFWIR.ACTION_TYPE= '00' ) FORMWORK_NAME  \n");
				sql.append("           FROM WARE_INFO                  WI,    \n");
				sql.append("                WARE_DISCOUNT_RLT          WDR,   \n");
				sql.append("                WARE_DISCOUNT_INFO         WDI    \n");
				sql.append("          WHERE WDR.WARE_ID = WI.WARE_ID          \n");
				sql.append("            AND WDR.DISCOUNT_ID = WDI.DISCOUNT_ID \n");
				sql.append("            AND WDR.RLT_STATE != '2'			  \n");
				if(StringUtil.isNotNullValue(activeName)){
				sql.append("            AND WDI.DISCOUNT_ID IN(" + activeName + ") \n");			
				}
			}	
		}else if ("05".equals(activeKind)) {
			//转赠
			logger.debug("转赠："+activeKind);
			
			sql.append("SELECT                                            \n");
			sql.append("                DISTINCT WI.WARE_ID,              \n");
			sql.append("                WI.WARE_CODE,                     \n");
			sql.append("                WI.WARE_NAME,                     \n");
			sql.append("                '050' ACTION_ID,                  \n");
			sql.append("                '转赠' ACTION_NAME,                \n");
			sql.append("                '05' ACTION_TYPE,                 \n");
			sql.append("                '' FORMWORK_ID,                   \n");           
			sql.append("                (SELECT DISTINCT NVL(SF.FORMWORK_NAME,'')  \n");
			sql.append("				FROM SMS_FORMWORK_WARE_INFO_RLT SFWIR,\n");
			sql.append("					 SMS_FORMWORK SF              \n");
			sql.append("   WHERE SFWIR.FORMWORK_ID=SF.FORMWORK_ID         \n");
			sql.append("     AND SFWIR.WARE_CODE = WI.WARE_CODE           \n");
			sql.append("     AND SFWIR.ACTION_ID = '050'                  \n");
			sql.append("     AND SFWIR.ACTION_TYPE= '05' ) FORMWORK_NAME  \n");
			sql.append("           FROM WARE_INFO                  WI,    \n");
			sql.append("                WARE_DESC_INFO             WDI    \n");
			sql.append("          WHERE WDI.WARE_ID = WI.WARE_ID          \n");
			sql.append("            AND WDI.DESC_DEFINE_ID=999999999999974\n");
			sql.append("            AND WDI.WARE_DESC_VALUE='1'           \n");
		}
		
		if (!"".equals(wareId)) {
			sql.append("            AND WI.WARE_ID IN (" + wareId + ")    \n");
		}
		sql.append(" ORDER BY WI.WARE_CODE  \n"); 
		
		
		if(startIndex != -1 && endIndex != -1){
			sql.append(" )  ) where  row_index >=").append(startIndex).append(" and row_index <= ").append(endIndex);
		}
		     			                  	
		
		return QBOWareActionQryEngine.getBeansFromSql(sql.toString(), null);
	}
	
	public int getWareActionQryCount(String activeKind,String activeName,String wareId)throws Exception{
		
			StringBuffer sql = new StringBuffer();
		
			if ("02".equals(activeKind)){
				//团购
				logger.debug("团购："+activeKind);

				sql.append("SELECT          								  \n");
				sql.append("                DISTINCT WI.WARE_ID,              \n");
				sql.append("                WI.WARE_CODE,                     \n");
				sql.append("                WI.WARE_NAME,                     \n");
				sql.append("                TI.TUAN_ID ACTION_ID,             \n");
				sql.append("                TI.NAME ACTION_NAME,              \n");
				sql.append("                '02' ACTION_TYPE,                 \n");
				sql.append("                '' FORMWORK_ID,                   \n");           
				sql.append("                (SELECT DISTINCT NVL(SF.FORMWORK_NAME,'')  \n");
				sql.append("				FROM SMS_FORMWORK_WARE_INFO_RLT SFWIR,\n");
				sql.append("					 SMS_FORMWORK SF              \n");
				sql.append("   WHERE SFWIR.FORMWORK_ID=SF.FORMWORK_ID         \n");
				sql.append("     AND SFWIR.WARE_CODE = WI.WARE_CODE           \n");
				sql.append("     AND SFWIR.ACTION_ID = TI.TUAN_ID           \n");
				sql.append("     AND SFWIR.ACTION_TYPE= '02' ) FORMWORK_NAME  \n");
				sql.append("           FROM WARE_INFO                  WI,    \n");
				sql.append("                TUAN_WARE_RLT              TWR,   \n");
				sql.append("                TUAN_INFO                  TI     \n");
				sql.append("          WHERE TWR.WARE_ID = WI.WARE_ID          \n");
				sql.append("            AND TWR.TUAN_ID = TI.TUAN_ID          \n");
				if(StringUtil.isNotNullValue(activeName)){
				sql.append("            AND TI.TUAN_ID IN(" + activeName + ") \n");	
				} 	
			}else if ("01".equals(activeKind)) {
				//抢兑
				logger.debug("抢兑："+activeKind);
				
				sql.append("SELECT                                            \n");
				sql.append("                DISTINCT WI.WARE_ID,              \n");
				sql.append("                WI.WARE_CODE,                     \n");
				sql.append("                WI.WARE_NAME,                     \n");
				sql.append("                AL.ACTIVITY_ID ACTION_ID,         \n");
				sql.append("                AL.ACTIVITY_NAME ACTION_NAME,     \n");
				sql.append("                '01' ACTION_TYPE,                 \n");
				sql.append("                '' FORMWORK_ID,                   \n");           
				sql.append("                (SELECT DISTINCT NVL(SF.FORMWORK_NAME,'')  \n");
				sql.append("				FROM SMS_FORMWORK_WARE_INFO_RLT SFWIR,\n");
				sql.append("					 SMS_FORMWORK SF              \n");
				sql.append("   WHERE SFWIR.FORMWORK_ID=SF.FORMWORK_ID         \n");
				sql.append("     AND SFWIR.WARE_CODE = WI.WARE_CODE           \n");
				sql.append("     AND SFWIR.ACTION_ID = AL.ACTIVITY_ID         \n");
				sql.append("     AND SFWIR.ACTION_TYPE= '01' ) FORMWORK_NAME  \n");
				sql.append("           FROM WARE_INFO                  WI,    \n");
				sql.append("                ACTIVITY_BIND_RELATION     ABR,   \n");
				sql.append("                ACTIVITY_LIMIT             AL     \n");
				sql.append("          WHERE ABR.WARE_ID = WI.WARE_ID          \n");
				sql.append("            AND ABR.ACTIVITY_ID = AL.ACTIVITY_ID  \n");
				if(StringUtil.isNotNullValue(activeName)){
				sql.append("            AND AL.ACTIVITY_ID IN(" + activeName + ") \n");	
					} 	
				
			}else if ("04".equals(activeKind)) {
				//优惠
				logger.debug("优惠："+activeKind);
				
				sql.append("SELECT                                            \n");
				sql.append("                DISTINCT WI.WARE_ID,              \n");
				sql.append("                WI.WARE_CODE,                     \n");
				sql.append("                WI.WARE_NAME,                     \n");
				sql.append("                PI.PERMISSION_ID ACTION_ID,       \n");
				sql.append("                PI.PERMISSION_NAME ACTION_NAME,   \n");
				sql.append("                '04' ACTION_TYPE,                 \n");
				sql.append("                '' FORMWORK_ID,                   \n");       
				sql.append("                (SELECT DISTINCT NVL(SF.FORMWORK_NAME,'')  \n");
				sql.append("				FROM SMS_FORMWORK_WARE_INFO_RLT SFWIR,\n");
				sql.append("					 SMS_FORMWORK SF              \n");
				sql.append("   WHERE SFWIR.FORMWORK_ID=SF.FORMWORK_ID         \n");
				sql.append("     AND SFWIR.WARE_CODE = WI.WARE_CODE           \n");
				sql.append("     AND SFWIR.ACTION_ID = PI.PERMISSION_ID       \n");
				sql.append("     AND SFWIR.ACTION_TYPE= '04' ) FORMWORK_NAME  \n");
				sql.append("           FROM WARE_INFO                  WI,    \n");
				sql.append("                PERMISSION_RULE_RLT        PRR,   \n");
				sql.append("                PERMISSION_INFO            PI     \n");
				sql.append("          WHERE PRR.WARE_ID = WI.WARE_ID          \n");
				sql.append("            AND PRR.PERMISSION_ID = PI.PERMISSION_ID \n");
				sql.append("            AND PRR.BIND_STATUS = '1'			  \n");
				if(StringUtil.isNotNullValue(activeName)){
				sql.append("            AND PI.PERMISSION_ID IN(" + activeName + ") \n");	
				} 	
				
				
			}else if ("00".equals(activeKind)) {
				//打折
				logger.debug("打折："+activeKind);
				
				//判断是否为全查的标志，flag=true代表不全查
				boolean flag=true;
				
				//当activeName为空的时候，执行全查
				if (StringUtil.isBlank(activeName)) {
					activeName="-1";
					flag=false;
				}
				
				if(activeName.indexOf("-1")>=0){
					//按积分折扣值打折和促销规则
					logger.debug("按积分折扣值打折和促销规则");
					sql.append(" SELECT                                                                       \n");
					sql.append("        COUNT(1) WARE_ID                                                      \n");
					sql.append("        FROM (																  \n");
					sql.append(" SELECT                                                                       \n");
					sql.append("        DISTINCT WI.WARE_ID,                                                  \n");
					sql.append("        WDVR.DISCOUNT_VALUE ACTION_ID                                         \n");
					sql.append("   FROM WARE_DISCOUNT_VALUE_RLT    WDVR,                                      \n");
					sql.append("        WARE_INTEGRAL_INFO         WII,                                       \n");
					sql.append("        WARE_INFO                  WI                                         \n");				
					sql.append("  WHERE WII.WARE_ID = WDVR.WARE_ID                                            \n");
					sql.append("    AND WII.MOBILE_BRAND_CODE = WDVR.MOBILE_BRAND_CODE                        \n");           
					sql.append("    AND WII.WARE_ID = WI.WARE_ID                                              \n");
					sql.append("    AND WDVR.RLT_STATE != '2'                                                 \n");
					sql.append("   UNION  ALL                     				      						  \n");
					sql.append(" SELECT                               							              \n");
					sql.append("                DISTINCT WI.WARE_ID,                       				      \n");
					sql.append("                WDI.DISCOUNT_ID ACTION_ID  							          \n");
					sql.append("           FROM WARE_INFO                  WI,    							  \n");
					sql.append("                WARE_DISCOUNT_RLT          WDR,   							  \n");
					sql.append("                WARE_DISCOUNT_INFO         WDI   							  \n");
					sql.append("          WHERE WDR.WARE_ID = WI.WARE_ID         							  \n");
					sql.append("            AND WDR.DISCOUNT_ID = WDI.DISCOUNT_ID 							  \n");
					sql.append("            AND WDR.RLT_STATE != '2'										  \n");
					if(StringUtil.isNotNullValue(activeName)&&flag){
					sql.append("            AND WDI.DISCOUNT_ID IN(" + activeName + ")    					  \n");			
					}
					sql.append(" ) WI WHERE 1=1  															  \n");	
					if (!"".equals(wareId)) {
						sql.append("            AND WI.WARE_ID IN (" + wareId + ")                            \n");
					}
					IQBOWareActionQryValue[] wareActionQryCount=QBOWareActionQryEngine.getBeansFromSql(sql.toString(), null);
					int count=Integer.parseInt(wareActionQryCount[0].getWareId());
					logger.debug("返回结果集行数："+count);
					return count;
				}else {
					//按促销规则
					sql.append("SELECT                                            \n");
					sql.append("                DISTINCT WI.WARE_ID,              \n");
					sql.append("                TO_CHAR(WDI.DISCOUNT_ID) ACTION_ID \n");
					sql.append("           FROM WARE_INFO                  WI,    \n");
					sql.append("                WARE_DISCOUNT_RLT          WDR,   \n");
					sql.append("                WARE_DISCOUNT_INFO         WDI    \n");
					sql.append("          WHERE WDR.WARE_ID = WI.WARE_ID          \n");
					sql.append("            AND WDR.DISCOUNT_ID = WDI.DISCOUNT_ID \n");
					sql.append("            AND WDR.RLT_STATE != '2'			  \n");
					if(StringUtil.isNotNullValue(activeName)){
					sql.append("            AND WDI.DISCOUNT_ID IN(" + activeName + ") \n");			
					}
				}	
			}else if ("05".equals(activeKind)) {
				//转赠
				logger.debug("转赠："+activeKind);
				
				sql.append("SELECT                                            \n");
				sql.append("                DISTINCT WI.WARE_ID,              \n");
				sql.append("                WI.WARE_CODE,                     \n");
				sql.append("                WI.WARE_NAME,                     \n");
				sql.append("                '050' ACTION_ID,                  \n");
				sql.append("                '转赠' ACTION_NAME,                \n");
				sql.append("                '05' ACTION_TYPE,                 \n");
				sql.append("                '' FORMWORK_ID,                   \n");           
				sql.append("                (SELECT DISTINCT NVL(SF.FORMWORK_NAME,'')  \n");
				sql.append("				FROM SMS_FORMWORK_WARE_INFO_RLT SFWIR,\n");
				sql.append("					 SMS_FORMWORK SF              \n");
				sql.append("   WHERE SFWIR.FORMWORK_ID=SF.FORMWORK_ID         \n");
				sql.append("     AND SFWIR.WARE_CODE = WI.WARE_CODE           \n");
				sql.append("     AND SFWIR.ACTION_ID = '050'                  \n");
				sql.append("     AND SFWIR.ACTION_TYPE= '05' ) FORMWORK_NAME  \n");
				sql.append("           FROM WARE_INFO                  WI,    \n");
				sql.append("                WARE_DESC_INFO             WDI    \n");
				sql.append("          WHERE WDI.WARE_ID = WI.WARE_ID          \n");
				sql.append("            AND WDI.DESC_DEFINE_ID=999999999999974\n");
				sql.append("            AND WDI.WARE_DESC_VALUE='1'           \n");
			}
			
			if (!"".equals(wareId)) {
				sql.append("            AND WI.WARE_ID IN (" + wareId + ")    \n");
			}
			
		IQBOWareActionQryValue[] wareActionQryCount=QBOWareActionQryEngine.getBeansFromSql(sql.toString(), null);
		int count=wareActionQryCount.length;
		logger.debug("返回结果集行数："+count);
		return count;
	}
}
