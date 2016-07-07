/**
 * Copyright (c) 2011 asiainfo-linkage.com
 */
package ngves.asiainfo.core.ware.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ngves.asiainfo.core.ware.WareParamConstant;
import ngves.asiainfo.core.ware.bo.PermissionTypeInfoEngine;
import ngves.asiainfo.core.ware.bo.QBOAllWareKindInfoEngine;
import ngves.asiainfo.core.ware.bo.QBOPermissionWareEngine;
import ngves.asiainfo.core.ware.bo.QBOWareProvDeliverFeeEngine;
import ngves.asiainfo.core.ware.bo.WareInfoBean;
import ngves.asiainfo.core.ware.bo.WareInfoEngine;
import ngves.asiainfo.core.ware.bo.WareInfoPortalEngine;
import ngves.asiainfo.core.ware.bo.wareWeekRankEngine;
import ngves.asiainfo.core.ware.dao.interfaces.IWareInfoDAO;
import ngves.asiainfo.core.ware.ivalues.IPermissionTypeInfoValue;
import ngves.asiainfo.core.ware.ivalues.IQBOAllWareKindInfoValue;
import ngves.asiainfo.core.ware.ivalues.IQBOPermissionWareValue;
import ngves.asiainfo.core.ware.ivalues.IQBOWareProvDeliverFeeValue;
import ngves.asiainfo.core.ware.ivalues.IWareInfoPortalValue;
import ngves.asiainfo.core.ware.ivalues.IWareInfoValue;
import ngves.asiainfo.core.ware.ivalues.IWarePCRltValue;
import ngves.asiainfo.core.ware.ivalues.IwareWeekRankValue;
import ngves.asiainfo.core.ware.model.PermissionWare;
import ngves.asiainfo.util.SqlUtil;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.ServiceManager;


/**
 * @author asiainfo
 * 
 *
 */
public class WareInfoDAOImpl implements IWareInfoDAO {
    
    private static transient Log log = LogFactory.getLog(WareInfoDAOImpl.class);
    /* (non-Javadoc)
     * @see ngves.asiainfo.core.ware.dao.interfaces.IWareInfoDAO#getBean(java.lang.Long)
     */
    public IWareInfoValue getBean(Long id) throws Exception {
       return  WareInfoEngine.getBean(id);
    }
    
    public void saveWareInfoBean(IWareInfoValue wareInfoValue) throws Exception {
    	WareInfoEngine.save(wareInfoValue);
    }
    
    public IWareInfoValue getWareInfoValueById(long id) throws Exception {
    	return WareInfoEngine.getBean(id);
    }
    
    public List<PermissionWare> getPermissionWareList(long permissionId,String channel) throws Exception{
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        List<PermissionWare> permList = new ArrayList<PermissionWare>();
        String querySql = "  select wip.ware_id,wip.ware_name ,pi.pay_type,pi.pay_integral," 
        				  +"  pi.pay_cash,pi.ware_gme_value as integral,wip.main_pic_file"
                          +"  from  permission_rule_rlt b, ware_info_portal wip ,permission_info pi"
                          +"    where b.ware_id = wip.ware_id "
                          +"   and b.permission_id=? "
                          +"   and wip.ware_status = '1' "
                          +"  and pi.permission_id = b.permission_id"
                          +"   and wip.is_exchange_permission in('01','02')"
                          +"   and sysdate between b.action_start_time and b.action_end_time and b.bind_status = '1' ";
        				  	
        try {
            if (channel.equals(WareParamConstant.IS_HTML_CHANNEL)) {
                querySql+=" and wip.is_html_channel = '1' ";
            } else if (channel.equals(WareParamConstant.IS_WAP_CHANNEL)) {
                querySql+=" and wip.is_wap_channel = '1' ";
            } 
            conn = ServiceManager.getSession().getConnection();
            psmt = conn.prepareStatement(querySql);
            psmt.setLong(1, permissionId);
            rs = psmt.executeQuery();
            if (null != rs) {
                while (rs.next()) {
                    PermissionWare bean = new PermissionWare();
                    bean.setWareId(rs.getLong("ware_id"));
                    bean.setWareName(rs.getString("ware_name"));
                    bean.setPayType(rs.getString("pay_type"));
                    bean.setIntegral(rs.getLong("integral"));
                    bean.setPayCash(rs.getLong("pay_cash"));
                    bean.setPayIntegral(rs.getLong("pay_integral"));
                    bean.setPicFile(rs.getString("main_pic_file"));
                    permList.add(bean);
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (null != rs) {
                rs.close();
            }
            if (null != psmt) {
                psmt.close();
            }
            if (null != conn) {
                conn.close();
            }
        }
        return permList;
    }
    
    public IQBOPermissionWareValue[] getAllPermissionWare(String channel) throws Exception{
        
        StringBuffer condition = new StringBuffer("");
        condition.append(" select ")
          .append(" a.permission_id,")   
          .append(" a.permission_name,   ")
          .append(" a.opt_type,        ")
          .append(" a.exchange_channel, ")
          .append(" a.support_type,      ")
          .append(" a.order_status,    ")
          .append(" a.item_scope,        ")
          .append(" a.order_num,        ")
          .append(" a.order_start_time,")
          .append(" a.order_end_time,")
          .append(" a.max_times,       ")
          .append(" a.max_item_num,     ")
          .append(" a.cretae_time,     ")
          .append(" a.mobile_brand_code,")
          .append(" a.ware_gme_value,")
          .append(" b.ware_bind_rule_rlt_id,")
          .append(" b.ware_id,  ")
          .append(" b.action_start_time,")
          .append(" b.action_end_time,")
          .append(" b.bind_status,")
          .append(" wi.ware_name ")
          .append(" from permission_info a, permission_rule_rlt b,ware_info_portal wi ")
          .append(" where a.permission_id = b.permission_id")
          .append(" and wi.ware_id = b.ware_id ")
          .append(" and wi.ware_status='1' ");
          
        if (channel.equals(WareParamConstant.IS_HTML_CHANNEL)) {
            condition.append(" and wi.is_html_channel = '1' ");
        } else if (channel.equals(WareParamConstant.IS_WAP_CHANNEL)) {
            condition.append(" and wi.is_wap_channel = '1' ");
        } 
        condition
          .append(" and  sysdate between b.action_start_time and b.action_end_time ")
          .append(" and  b.bind_status='1' ")
          .append(" and wi.is_exchange_permission<>'00' ");//当前支持优惠类型为01或者02
        log.info("getAllPermissionWare Sql==>>" + condition.toString());
        IQBOPermissionWareValue[] qboBean = QBOPermissionWareEngine.getBeansFromSql(condition.toString(), null);
        return qboBean;
    }
    
    
    public IPermissionTypeInfoValue[] getPermissionTypeInfos(long permissionId,String permissionCode ) throws Exception {
        
        StringBuffer condition = new StringBuffer(" ");
        Map<String, String> parameter = new HashMap<String, String>();
        if (permissionId != 0L) {

            condition.append(IPermissionTypeInfoValue.S_PermissionId).append(" = :permissionId").append(" ");
            parameter.put("permissionId", permissionId + "");
        }
        if (!StringUtil.isBlank(permissionCode)) {

            condition.append(IPermissionTypeInfoValue.S_PermissionCode).append(" = :permissionCode");
            parameter.put("permissionCode", permissionCode);
        }

        return PermissionTypeInfoEngine.getBeans(condition.toString(), parameter);
    }
    

    /**
     * 不依赖ware_info_portal
     */
    public List<String> getWareInfoPortalByPermissionId(List<String> partnerCodeList,
            List<String> wareKindCodeList, List<String> wareCodeList,String channel) throws Exception {
       
        List<String> list = new ArrayList<String>();
        StringBuffer condition = new StringBuffer("");
        //查询所有礼品商下的礼品
        condition.append(" select  wi.ware_id")
                 .append("       from partner_info pi, ware_info wi")
                 .append(" where pi.partner_id = wi.partner_id")
                 //.append("       and wi.province_code = '00'")
                 .append("       and wi.ware_status = '1'")
                 .append("       and pi.partner_code in('")
                 .append(getSqlString(partnerCodeList))
                 .append("')");
        
        condition.append(" union ");
        //小类对应的编码
        condition.append(" select  wip.ware_id ")
                 .append("       from ware_info_portal wip, ware_kind_rlt wkr,ware_kind wk")
                 .append(" where wip.ware_id = wkr.ware_id")
                 .append("       and wk.ware_kind_id = wkr.ware_kind_id")
                 .append("       and wk.kind_code In('")
                 .append( getSqlString(wareKindCodeList) )
                 .append("')")
                 //.append("       and wip.province_code = '00'")
                 .append("       and wip.ware_status = '1'");
         if(channel.equals(WareParamConstant.IS_HTML_CHANNEL)){
             condition.append( " and wip.is_html_channel = '1' ");
         }else if(channel.equals(WareParamConstant.IS_WAP_CHANNEL)){
             condition.append(" and wip.is_wap_channel = '1' ");
         } 
        
        condition.append(" union ");
        //礼品小类
        condition.append(" select  wip.ware_id")
                 .append("      from ware_info_portal wip")
                 .append(" where  wip.ware_status = '1'")
                 .append("       and ware_code in('")
                 .append(getSqlString(wareCodeList))
                 .append("')")
                // .append("       and wip.province_code = '00'")
                 .append("       and wip.ware_status = '1'");
         if(channel.equals(WareParamConstant.IS_HTML_CHANNEL)){
             condition.append( " and wip.is_html_channel = '1' ");
         }else if(channel.equals(WareParamConstant.IS_WAP_CHANNEL)){
             condition.append(" and wip.is_wap_channel = '1' ");
         } 
         log.info("getWareInfoPortalByPermissionId sql==>>" + condition.toString());
       WareInfoBean[] wareInfo = WareInfoEngine.getBeansFromSql(condition.toString(), null);
       if(wareInfo!=null&wareInfo.length>0){
           for (WareInfoBean wareInfoBean : wareInfo) {
               list.add(wareInfoBean.getWareId()+"");
        }
       }
       return list;
    }
    
    /**
     * 把List中的数据串转成逗号分隔的字符串，放在Oracle数据的in连接数据
     */
    public static String getSqlString(List<String> codeList) throws Exception{
        
        String condition = "";
        if(codeList!=null && codeList.size()>0) {
            
            for (int i = 0; i < codeList.size(); i++) {
                if (i == codeList.size() - 1) {
                    condition += SqlUtil.encodeString(codeList.get(i)) + "";
                } else {
                    condition += SqlUtil.encodeString(codeList.get(i)) + "','";
                }
            }
        }
        return condition;
    }
    
    public boolean isPermissionWare(long wareId) throws Exception{
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String querySql = " select wip.is_exchange_permission from ware_info_portal wip where wip.ware_status='1'   and wip.ware_id=?";
        boolean flag = false;
        try {
            conn = ServiceManager.getSession().getConnection();
            psmt = conn.prepareStatement(querySql);
            psmt.setLong(1, wareId);
            rs = psmt.executeQuery();
            if (null != rs) {
                while (rs.next()) {
                    String value = rs.getString("is_exchange_permission");
                    if(!"00".equals(value)) {//01或02
                        flag = true;
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (null != rs) {
                rs.close();
            }
            if (null != psmt) {
                psmt.close();
            }
            if (null != conn) {
                conn.close();
            }
        }
        return flag;
    }
    
    public IWareInfoValue[] getInfoValue(String condition, Map<String, String> parameter) throws Exception {
		return WareInfoEngine.getBeans(condition, parameter);
	}
    
    public IQBOAllWareKindInfoValue[] getAllWareKindInfo() throws Exception {
		return QBOAllWareKindInfoEngine.getBeans(null, null);
	}
	
	public IQBOAllWareKindInfoValue[] getWareKindInfo(String wareId) throws Exception{
		StringBuilder condition = new StringBuilder().append(" 1=1 ").append(" AND ")
			.append(IQBOAllWareKindInfoValue.S_WareId).append("=:").append(IQBOAllWareKindInfoValue.S_WareId);
		Map<String, String> parameter = new HashMap<String, String>();
		parameter.put(IQBOAllWareKindInfoValue.S_WareId, wareId);
		return QBOAllWareKindInfoEngine.getBeans(condition.toString(), parameter);
	}
	
	public IQBOWareProvDeliverFeeValue[] getWareProvDeliverFee() throws Exception{
		String sql  = " SELECT WARE_ID, WM_CONCAT((PROVINCE_CODE || '=' || INTEGRAL_VALUE)) PROV_INTEGRAL_VALUE\n" +
		"  FROM (SELECT WIP.WARE_ID,\n" + 
		"               CPI.PROVINCE_CODE,\n" + 
		"               (SELECT NVL(MAX(L.INTEGRAL_VALUE), 0)\n" + 
		"                  FROM LOGISTIC_INTEGRAL_INFO L\n" + 
		"                 WHERE WIP.WARE_STORAGE_TYPE = L.WAREHOUSE_TYPE\n" + 
		"                   AND L.WAREHOUSE_PROVINCE_CODE = WIP.PROVINCE_CODE\n" + 
		"                   AND CPI.PROVINCE_CODE = L.PROVINCE_CODE(+)\n" + 
		"                   AND L.WAREHOUSE_ID = WIP.WAREHOUSE_ID) INTEGRAL_VALUE\n" + 
		"          FROM WARE_INFO_PORTAL WIP, CM_PROVINCE_INFO CPI\n" + 
		"         WHERE WIP.WAREHOUSE_ID <> 0\n" + 
		"           AND WIP.WARE_STORAGE_TYPE != '3'\n" + 
		"           AND CPI.PROVINCE_CODE != '00'\n" + 
		"        UNION ALL\n" + 
		"        SELECT WIP.WARE_ID,\n" + 
		"               CPI.PROVINCE_CODE,\n" + 
		"				NVL((SELECT MAX(L.INTEGRAL_VALUE)\n" +
		"                     FROM LOGISTIC_INTEGRAL_INFO L ,WAREHOUSE_LOGISTIC_RLT A, WAREHOUSE_INFO B\n" + 
		"                    WHERE WIP.WARE_STORAGE_TYPE = L.WAREHOUSE_TYPE\n" + 
		"                      AND L.WAREHOUSE_PROVINCE_CODE = WIP.PROVINCE_CODE\n" + 
		"                      AND CPI.PROVINCE_CODE = L.PROVINCE_CODE(+)\n" + 
		"                      AND l.WAREHOUSE_ID = a.WAREHOUSE_ID\n" + 
		"                      AND A.WAREHOUSE_ID = B.WAREHOUSE_ID\n" + 
		"                      AND A.RLT_STATE = '1'\n" + 
		"                      AND A.PARTNER_STATE = '1'\n" + 
		"                      AND B.WAREHOUSE_STATE = '1'\n" + 
		"                      AND B.WAREHOUSE_TYPE = '0'\n" + 
		"                      AND A.PROVINCE_CODE = CPI.PROVINCE_CODE\n" + 
		"                      AND B.PROVINCE_CODE = WIP.PROVINCE_CODE),\n" + 
		"                      (SELECT NVL(MAX(L.INTEGRAL_VALUE), 0)\n" + 
		"                           FROM LOGISTIC_INTEGRAL_INFO L\n" + 
		"                           WHERE WIP.WARE_STORAGE_TYPE = L.WAREHOUSE_TYPE\n" + 
		"                           AND L.WAREHOUSE_PROVINCE_CODE = WIP.PROVINCE_CODE\n" + 
		"                           AND CPI.PROVINCE_CODE = L.PROVINCE_CODE(+))) INTEGRAL_VALUE\n" +
		"          FROM WARE_INFO_PORTAL WIP, CM_PROVINCE_INFO CPI\n" + 
		"         WHERE WIP.WAREHOUSE_ID = 0\n" + 
		"           AND WIP.WARE_STORAGE_TYPE != '3'\n" + 
		"           AND CPI.PROVINCE_CODE != '00'\n" + 
		"        UNION ALL\n" + 
		"        SELECT W.WARE_ID, CPI.PROVINCE_CODE, 0 INTEGRAL_VALUE\n" + 
		"          FROM WARE_INFO_PORTAL W, CM_PROVINCE_INFO CPI\n" + 
		"         WHERE NOT EXISTS\n" + 
		"         (SELECT WIP.WARE_ID\n" + 
		"                  FROM WARE_INFO_PORTAL WIP, LOGISTIC_INTEGRAL_INFO L\n" + 
		"                 WHERE WIP.WAREHOUSE_ID <> 0\n" + 
		"                   AND WIP.WARE_STORAGE_TYPE = L.WAREHOUSE_TYPE\n" + 
		"                   AND L.WAREHOUSE_PROVINCE_CODE = WIP.PROVINCE_CODE\n" + 
		"                   AND WIP.WAREHOUSE_ID = L.WAREHOUSE_ID(+)\n" + 
		"                   AND WIP.WARE_STORAGE_TYPE != '3'\n" + 
		"                   AND W.WARE_ID = WIP.WARE_ID\n" + 
		"                UNION ALL\n" + 
		"                SELECT WIP.WARE_ID\n" + 
		"                  FROM WARE_INFO_PORTAL WIP, LOGISTIC_INTEGRAL_INFO L\n" + 
		"                 WHERE WIP.WAREHOUSE_ID = 0\n" + 
		"                   AND WIP.WARE_STORAGE_TYPE = L.WAREHOUSE_TYPE\n" + 
		"                   AND L.WAREHOUSE_PROVINCE_CODE = WIP.PROVINCE_CODE\n" + 
		"                   AND WIP.WARE_STORAGE_TYPE != '3'\n" + 
		"                   AND W.WARE_ID = WIP.WARE_ID\n" + 
		"                )\n" + 
		"           AND CPI.PROVINCE_CODE <> '00')\n" + 
		"           GROUP BY WARE_ID";
		return QBOWareProvDeliverFeeEngine.getBeansFromSql(sql, null);
	}
	
	public IQBOWareProvDeliverFeeValue getWareProvDeliverFeeById(long wareId) throws Exception{
		String sql  = " SELECT WM_CONCAT((PROVINCE_CODE || '=' || INTEGRAL_VALUE)) PROV_INTEGRAL_VALUE\n" +
		"  FROM (SELECT WIP.WARE_ID,\n" + 
		"               CPI.PROVINCE_CODE,\n" + 
		"               (SELECT NVL(MAX(L.INTEGRAL_VALUE), 0)\n" + 
		"                  FROM LOGISTIC_INTEGRAL_INFO L\n" + 
		"                 WHERE WIP.WARE_STORAGE_TYPE = L.WAREHOUSE_TYPE\n" + 
		"                   AND L.WAREHOUSE_PROVINCE_CODE = WIP.PROVINCE_CODE\n" + 
		"                   AND CPI.PROVINCE_CODE = L.PROVINCE_CODE(+)\n" + 
		"                   AND L.WAREHOUSE_ID = WIP.WAREHOUSE_ID) INTEGRAL_VALUE\n" + 
		"          FROM WARE_INFO_PORTAL WIP, CM_PROVINCE_INFO CPI\n" + 
		"         WHERE WIP.WAREHOUSE_ID <> 0\n" + 
		"           AND WIP.WARE_STORAGE_TYPE != '3'\n" + 
		"           AND CPI.PROVINCE_CODE != '00'\n" +
		"           AND WIP.WARE_ID = :WARE_ID \n" +
		"        UNION ALL\n" + 
		"        SELECT WIP.WARE_ID,\n" + 
		"               CPI.PROVINCE_CODE,\n" + 
		"				NVL((SELECT MAX(L.INTEGRAL_VALUE)\n" +
		"                     FROM LOGISTIC_INTEGRAL_INFO L ,WAREHOUSE_LOGISTIC_RLT A, WAREHOUSE_INFO B\n" + 
		"                    WHERE WIP.WARE_STORAGE_TYPE = L.WAREHOUSE_TYPE\n" + 
		"                      AND L.WAREHOUSE_PROVINCE_CODE = WIP.PROVINCE_CODE\n" + 
		"                      AND CPI.PROVINCE_CODE = L.PROVINCE_CODE(+)\n" + 
		"                      AND l.WAREHOUSE_ID = a.WAREHOUSE_ID\n" + 
		"                      AND A.WAREHOUSE_ID = B.WAREHOUSE_ID\n" + 
		"                      AND A.RLT_STATE = '1'\n" + 
		"                      AND A.PARTNER_STATE = '1'\n" + 
		"                      AND B.WAREHOUSE_STATE = '1'\n" + 
		"                      AND B.WAREHOUSE_TYPE = '0'\n" + 
		"                      AND A.PROVINCE_CODE = CPI.PROVINCE_CODE\n" + 
		"                      AND B.PROVINCE_CODE = WIP.PROVINCE_CODE),\n" + 
		"                      (SELECT NVL(MAX(L.INTEGRAL_VALUE),0)\n" + 
		"                           FROM LOGISTIC_INTEGRAL_INFO L\n" + 
		"                           WHERE WIP.WARE_STORAGE_TYPE = L.WAREHOUSE_TYPE\n" + 
		"                           AND L.WAREHOUSE_PROVINCE_CODE = WIP.PROVINCE_CODE\n" + 
		"                           AND CPI.PROVINCE_CODE = L.PROVINCE_CODE(+) )) INTEGRAL_VALUE\n" +
		"          FROM WARE_INFO_PORTAL WIP, CM_PROVINCE_INFO CPI\n" + 
		"         WHERE WIP.WAREHOUSE_ID = 0\n" + 
		"           AND WIP.WARE_STORAGE_TYPE != '3'\n" + 
		"           AND CPI.PROVINCE_CODE != '00'\n" +
		"           AND WIP.WARE_ID = :WARE_ID \n" +
		"        UNION ALL\n" + 
		"        SELECT W.WARE_ID, CPI.PROVINCE_CODE, 0 INTEGRAL_VALUE\n" + 
		"          FROM WARE_INFO_PORTAL W, CM_PROVINCE_INFO CPI\n" + 
		"         WHERE NOT EXISTS\n" + 
		"         (SELECT WIP.WARE_ID\n" + 
		"                  FROM WARE_INFO_PORTAL WIP, LOGISTIC_INTEGRAL_INFO L\n" + 
		"                 WHERE WIP.WAREHOUSE_ID <> 0\n" + 
		"                   AND WIP.WARE_STORAGE_TYPE = L.WAREHOUSE_TYPE\n" + 
		"                   AND L.WAREHOUSE_PROVINCE_CODE = WIP.PROVINCE_CODE\n" + 
		"                   AND WIP.WAREHOUSE_ID = L.WAREHOUSE_ID(+)\n" + 
		"                   AND WIP.WARE_STORAGE_TYPE != '3'\n" + 
		"                   AND W.WARE_ID = WIP.WARE_ID\n" + 
		"                UNION ALL\n" + 
		"                SELECT WIP.WARE_ID\n" + 
		"                  FROM WARE_INFO_PORTAL WIP, LOGISTIC_INTEGRAL_INFO L\n" + 
		"                 WHERE WIP.WAREHOUSE_ID = 0\n" + 
		"                   AND WIP.WARE_STORAGE_TYPE = L.WAREHOUSE_TYPE\n" + 
		"                   AND L.WAREHOUSE_PROVINCE_CODE = WIP.PROVINCE_CODE\n" + 
		"                   AND WIP.WARE_STORAGE_TYPE != '3'\n" + 
		"                   AND W.WARE_ID = WIP.WARE_ID\n" + 
		"                )\n" + 
		"           AND W.WARE_ID = :WARE_ID \n" +
		"           AND CPI.PROVINCE_CODE <> '00')\n" + 
		"           WHERE WARE_ID = :WARE_ID ";
		Map<String,String> param = new HashMap<String, String>();
		param.put("WARE_ID",String.valueOf(wareId));
		IQBOWareProvDeliverFeeValue[] values = QBOWareProvDeliverFeeEngine.getBeansFromSql(sql, param);
		if(values.length!=0 && values!=null){
			return values[0];
		}
		return null;
    }
	
	public IQBOWareProvDeliverFeeValue[] getWareProvDeliverFeeById(String wareIds) throws Exception{
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT A.WARE_ID,\n");
		sb.append("        '[' || WM_CONCAT('#name:\"' || PROVINCE_CODE || '\",value:' || INTEGRAL_VALUE || '}') || ']' PROV_INTEGRAL_VALUE \n");
		sb.append("  FROM (SELECT WIP.WARE_ID,\n" );
		sb.append("               CPI.PROVINCE_CODE,\n");
		sb.append("               (SELECT NVL(MAX(L.INTEGRAL_VALUE), 0)\n");
		sb.append("                  FROM LOGISTIC_INTEGRAL_INFO L\n");
		sb.append("                 WHERE WIP.WARE_STORAGE_TYPE = L.WAREHOUSE_TYPE\n");
		sb.append("                   AND L.WAREHOUSE_PROVINCE_CODE = WIP.PROVINCE_CODE\n");
		sb.append("                   AND CPI.PROVINCE_CODE = L.PROVINCE_CODE(+)\n");
		sb.append("                   AND L.WAREHOUSE_ID = WIP.WAREHOUSE_ID) INTEGRAL_VALUE\n");
		sb.append("          FROM WARE_INFO_PORTAL WIP, CM_PROVINCE_INFO CPI\n");
		sb.append("         WHERE WIP.WAREHOUSE_ID <> 0\n");
		sb.append("           AND WIP.WARE_STORAGE_TYPE != '3'\n");
		sb.append("           AND CPI.PROVINCE_CODE != '00'\n");
		sb.append("           AND WIP.WARE_ID IN ("+SqlUtil.encodeNumberList(wareIds)+")\n");
		sb.append("        UNION ALL\n");
		sb.append("        SELECT WIP.WARE_ID,\n");
		sb.append("               CPI.PROVINCE_CODE,\n");
		sb.append("               NVL((SELECT MAX(L.INTEGRAL_VALUE)\n");
		sb.append("                     FROM LOGISTIC_INTEGRAL_INFO L,\n");
		sb.append("                          WAREHOUSE_LOGISTIC_RLT A,\n");
		sb.append("                          WAREHOUSE_INFO         B\n");
		sb.append("                    WHERE WIP.WARE_STORAGE_TYPE = L.WAREHOUSE_TYPE\n");
		sb.append("                      AND L.WAREHOUSE_PROVINCE_CODE = WIP.PROVINCE_CODE\n");
		sb.append("                      AND CPI.PROVINCE_CODE = L.PROVINCE_CODE(+)\n");
		sb.append("                      AND L.WAREHOUSE_ID = A.WAREHOUSE_ID\n");
		sb.append("                      AND A.WAREHOUSE_ID = B.WAREHOUSE_ID\n");
		sb.append("                      AND A.RLT_STATE = '1'\n");
		sb.append("                      AND A.PARTNER_STATE = '1'\n");
		sb.append("                      AND B.WAREHOUSE_STATE = '1'\n");
		sb.append("                      AND B.WAREHOUSE_TYPE = '0'\n");
		sb.append("                      AND A.PROVINCE_CODE = CPI.PROVINCE_CODE\n");
		sb.append("                      AND B.PROVINCE_CODE = WIP.PROVINCE_CODE),\n");
		sb.append("                   (SELECT NVL(MAX(L.INTEGRAL_VALUE), 0)\n");
		sb.append("                      FROM LOGISTIC_INTEGRAL_INFO L\n");
		sb.append("                     WHERE WIP.WARE_STORAGE_TYPE = L.WAREHOUSE_TYPE\n");
		sb.append("                       AND L.WAREHOUSE_PROVINCE_CODE = WIP.PROVINCE_CODE\n");
		sb.append("                       AND CPI.PROVINCE_CODE = L.PROVINCE_CODE(+))) INTEGRAL_VALUE\n");
		sb.append("          FROM WARE_INFO_PORTAL WIP, CM_PROVINCE_INFO CPI\n");
		sb.append("         WHERE WIP.WAREHOUSE_ID = 0\n");
		sb.append("           AND WIP.WARE_STORAGE_TYPE != '3'\n");
		sb.append("           AND CPI.PROVINCE_CODE != '00'\n");
		sb.append("           AND WIP.WARE_ID IN ("+SqlUtil.encodeNumberList(wareIds)+")\n");
		sb.append("        UNION ALL\n");
		sb.append("        SELECT W.WARE_ID, CPI.PROVINCE_CODE, 0 INTEGRAL_VALUE\n");
		sb.append("          FROM WARE_INFO_PORTAL W, CM_PROVINCE_INFO CPI\n");
		sb.append("         WHERE NOT EXISTS\n");
		sb.append("         (SELECT WIP.WARE_ID\n");
		sb.append("                  FROM WARE_INFO_PORTAL WIP, LOGISTIC_INTEGRAL_INFO L\n");
		sb.append("                 WHERE WIP.WAREHOUSE_ID <> 0\n");
		sb.append("                   AND WIP.WARE_STORAGE_TYPE = L.WAREHOUSE_TYPE\n");
		sb.append("                   AND L.WAREHOUSE_PROVINCE_CODE = WIP.PROVINCE_CODE\n");
		sb.append("                   AND WIP.WAREHOUSE_ID = L.WAREHOUSE_ID(+)\n");
		sb.append("                   AND WIP.WARE_STORAGE_TYPE != '3'\n");
		sb.append("                   AND W.WARE_ID = WIP.WARE_ID\n");
		sb.append("                UNION ALL\n");
		sb.append("                SELECT WIP.WARE_ID\n");
		sb.append("                  FROM WARE_INFO_PORTAL WIP, LOGISTIC_INTEGRAL_INFO L\n");
		sb.append("                 WHERE WIP.WAREHOUSE_ID = 0\n");
		sb.append("                   AND WIP.WARE_STORAGE_TYPE = L.WAREHOUSE_TYPE\n");
		sb.append("                   AND L.WAREHOUSE_PROVINCE_CODE = WIP.PROVINCE_CODE\n");
		sb.append("                   AND WIP.WARE_STORAGE_TYPE != '3'\n");
		sb.append("                   AND W.WARE_ID = WIP.WARE_ID)\n");
		sb.append("           AND W.WARE_ID IN ("+SqlUtil.encodeNumberList(wareIds)+")\n");
		sb.append("           AND CPI.PROVINCE_CODE <> '00') A\n");
		sb.append(" WHERE WARE_ID IN ("+SqlUtil.encodeNumberList(wareIds)+")\n");
		sb.append(" GROUP BY A.WARE_ID");
		Map<String,String> parameter = new HashMap<String,String>();
		parameter.put("strKey", "");
		
		IQBOWareProvDeliverFeeValue[] values = QBOWareProvDeliverFeeEngine.getBeansFromSql(sb.toString(), null);
		if(values.length!=0 && values!=null){
			return values;
		}
		return null;
    }
	
	public IWareInfoPortalValue[] getAllWareInfoPortal() throws Exception {
		//此处type_code放到备用字段bak_col3
		//TODO [2013年10月版本]需改造成业务属性
		StringBuffer sql = new StringBuffer().append(
				" select wi.ware_id,                              ").append(
				"        wi.ware_code,                            ").append(
				"        wi.ware_name,                            ").append(
				"        wi.ware_integral_value,                  ").append(
				"        wi.main_pic_file,                        ").append(
				"        wi.func_desc,                            ").append(
				"        wi.exchange_id,                          ").append(
				"        wi.exchange_mode,                        ").append(
				"        wi.alias,                                ").append(
				"        wi.bak_col1,                             ").append(
				"        wi.deliver_type,                         ").append(
				"        wi.is_search,                            ").append(
				"        wi.is_html_channel,                      ").append(
				"        wi.ware_status,                          ").append(
				"        wi.province_code,                        ").append(
				"        wi.search_hot,                           ").append(
				"        wi.warehouse_id,                         ").append(
				"        wi.ware_storage_type,                    ").append(
				"        wi.is_allow_donation,                    ").append(
				"        wi.open_date,                            ").append(
				"        wi.ware_brand_id,                        ").append(
				"        wi.keywords,                             ").append(
				"        wi.shop_price,                           ").append(
				"        wi.discount,                             ").append(
				"        wi.sale_amount,                          ").append(
				"        wi.comment_count,                        ").append(
				"        wi.comment_value,                        ").append(
				"        wi.is_client_channel,                    ").append(
				"        wi.packing_list,                         ").append(
				"        wi.safe_guard,                           ").append(
				"        wp.type_code bak_col3,                   ").append(
				"		 wi.pay_type,							  ").append(
			    "		 wi.ORI_PAY_INTEGRAL,                     ").append(
			    "		 wi.ORI_PAY_CASH,                         ").append(
			    "		 wi.IS_ONLINE_PAY,                        ").append(
			    "		 wi.IS_OFFLINE_PAY,                       ").append(
			    "		 wi.OFFLINE_DESC,                         ").append(
			    "		 wi.WARE_TYPE                             ").append(
				"   from ware_info_portal wi,                     ").append(
				"        ware_pc_rlt rlc,                         ").append(
				"        ware_info_parent wp                      ").append(
				"  where wi.ware_status='1' and wi.ware_id = rlc.c_ware_id(+)            ").append(
				"    and rlc.p_ware_id = wp.ware_id(+)            ");
		return WareInfoPortalEngine.getBeansFromSql(sql.toString(), null);
	}
	
	public IWareInfoPortalValue getWareInfoPortal(long wareId) throws Exception {
		//此处type_code放到备用字段bak_col3
		//TODO [2013年10月版本]需改造成业务属性
		StringBuffer sql = new StringBuffer().append(
				" select wi.ware_id,                              ").append(
				"        wi.ware_code,                            ").append(
				"        wi.ware_name,                            ").append(
				"        wi.ware_integral_value,                  ").append(
				"        wi.main_pic_file,                        ").append(
				"        wi.func_desc,                            ").append(
				"        wi.exchange_id,                          ").append(
				"        wi.exchange_mode,                        ").append(
				"        wi.alias,                                ").append(
				"        wi.bak_col1,                             ").append(
				"        wi.deliver_type,                         ").append(
				"        wi.is_search,                            ").append(
				"        wi.is_html_channel,                      ").append(
				"        wi.ware_status,                          ").append(
				"        wi.province_code,                        ").append(
				"        wi.search_hot,                           ").append(
				"        wi.warehouse_id,                         ").append(
				"        wi.ware_storage_type,                    ").append(
				"        wi.is_allow_donation,                    ").append(
				"        wi.open_date,                            ").append(
				"        wi.ware_brand_id,                        ").append(
				"        wi.keywords,                             ").append(
				"        wi.shop_price,                           ").append(
				"        wi.discount,                             ").append(
				"        wi.sale_amount,                          ").append(
				"        wi.comment_count,                        ").append(
				"        wi.comment_value,                        ").append(
				"        wi.is_client_channel,                    ").append(
				"        wi.packing_list,                         ").append(
				"        wi.safe_guard,                           ").append(
				"        wp.type_code bak_col3,                   ").append(
				"		 wi.pay_type,							  ").append(
			    "		 wi.ORI_PAY_INTEGRAL,                     ").append(
			    "		 wi.ORI_PAY_CASH,                         ").append(
			    "		 wi.IS_ONLINE_PAY,                        ").append(
			    "		 wi.IS_OFFLINE_PAY,                       ").append(
			    "		 wi.OFFLINE_DESC,                         ").append(
			    "		 wi.WARE_TYPE                             ").append(
				"   from ware_info_portal wi,                     ").append(
				"        ware_pc_rlt rlc,                         ").append(
				"        ware_info_parent wp                      ").append(
				"  where wi.ware_id = rlc.c_ware_id(+)            ").append(
				"    and rlc.p_ware_id = wp.ware_id(+)            ").append(
				"    and wi.ware_id =:WARE_ID                    ");
		Map<String,String> param = new HashMap<String, String>();
		param.put("WARE_ID",String.valueOf(wareId));
		IWareInfoPortalValue[] values = WareInfoPortalEngine.getBeansFromSql(sql.toString(), param);
		if(values.length!=0 && values!=null){
			return values[0];
}
		return null;
	}
	
	public IwareWeekRankValue[] getWareWeekRankValue() throws Exception {
		
		return wareWeekRankEngine.getBeans("", null);
	}
	
	/**
	 * 获取所有子礼品(当前礼品状态 上线状态)
	 * @param childWareId 父礼品Ware Id
	 * @return
	 * @throws Exception
	 */
	public IWareInfoPortalValue[] qryAllCWarePortalInfosByPId(String parentWareId) throws Exception{
		StringBuffer sqlBuf = new StringBuffer();
		Map<String,String> parameter = new HashMap<String,String>();
		sqlBuf.append(" SELECT * FROM WARE_INFO_PORTAL WHERE WARE_ID IN ");
		sqlBuf.append("(SELECT C_WARE_ID  FROM WARE_PC_RLT ");
		sqlBuf.append("WHERE ").append(IWarePCRltValue.S_PWareId).append(" = :").append(IWarePCRltValue.S_PWareId);
		parameter.put(IWarePCRltValue.S_PWareId, parentWareId);
		sqlBuf.append(" ) and WARE_STATUS='1' ");
		return WareInfoPortalEngine.getBeansFromSql(sqlBuf.toString(), parameter);
	}
	
	 /**
     * 通过礼品编码查到礼品
     * @param wareCode 是一个礼品code编码串
     * @return
     * @throws Exception
     */
    public IWareInfoValue[] getByWareCodes(String wareCodes) throws Exception{
    	 StringBuffer strbuf=new StringBuffer("  1=1");
		 Map<String,String >  parame=new  HashMap<String, String>();
		 IWareInfoValue[] tempWareInfos=null;
    	if(null!=wareCodes&&!"".equals(wareCodes)){
    		 String str=" and WARE_CODE in ("+wareCodes+")";
			 strbuf.append(str);
			 tempWareInfos=WareInfoEngine.getBeans(strbuf.toString(), parame);
    	}
    	return tempWareInfos;
    }
      
    public IWareInfoValue[] getWareInfoByO2oId(String wareCodes,String o2oId) throws Exception{
    	 StringBuffer strbuf=new StringBuffer();
		 Map<String,String >  parame=new  HashMap<String, String>();
		 String sql="select w.ware_id, w.ware_brand_id, w.ware_code, w.ware_name,  w.ware_status, w.note, b.o2o_rlt_id  "+
		 "  from WARE_INFO w, o2o_ware_rlt b, o2o_info c "+
		 "  where w.ware_code = b.ware_code  " +
		 "  and b.o2o_id = c.o2o_id" +
		 "  and c.o2o_id =:o2oId " +
		 "  and b.ware_code in ("+wareCodes+")"+
		 "  order by b.o2o_rlt_id";  
		 parame.put("o2oId", o2oId);
		 strbuf.append(sql);
	     return WareInfoEngine.getBeansFromSql(strbuf.toString(), parame);
		   
    }
}
