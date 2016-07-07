/**
 * Copyright (c) 2011 asiainfo-linkage.com
 */
package ngves.asiainfo.core.ware.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.ware.bo.WareDescInfoEngine;
import ngves.asiainfo.core.ware.bo.WareInfoPortalIntegralEngine;
import ngves.asiainfo.core.ware.bo.WareIntegralInfoBean;
import ngves.asiainfo.core.ware.bo.WareIntegralInfoEngine;
import ngves.asiainfo.core.ware.dao.interfaces.IWareDetailDAO;
import ngves.asiainfo.core.ware.ivalues.IWareDescInfoValue;
import ngves.asiainfo.core.ware.ivalues.IWareInfoPortalIntegralValue;
import ngves.asiainfo.core.ware.ivalues.IWareIntegralInfoValue;
import ngves.asiainfo.util.StringUtil;

/**
 * @author asiainfo
 *
 */
public class WareDetailDAOImpl implements IWareDetailDAO {

    /**
     * 取得普通礼品的积分值
     */
        
     public IWareIntegralInfoValue[] getWareIntegral(long ware_id) throws Exception {
            // 如果传入的礼品ID不大于0，则直接返回空；
            if (ware_id <= 0) {
                return null;
            }

            Map<String, String> param = new HashMap<String, String>();
            param.put("ware_id", String.valueOf(ware_id));
            
            WareIntegralInfoBean[] integralVals = WareIntegralInfoEngine.getBeans(" ware_id= :ware_id ", param);
            
            String sql = "";
            sql = " " + IWareIntegralInfoValue.S_WareId + "= :ware_id  ";
            if(null!=integralVals && 0<integralVals.length){
	            sql += "  and channel = '"+integralVals[0].getChannel()+"' ";
            }
            
            
            return WareIntegralInfoEngine.getBeans(sql, param);
      }

    /* (non-Javadoc)
     * @see ngves.asiainfo.core.ware.dao.interfaces.IWareDetailDAO#getWareDescInfo(java.lang.String, java.lang.String)
     */
    public IWareDescInfoValue[] getWareDescInfo(String wareId, String descDefineId) throws Exception {
        //select ware_desc_value from ware_desc_info where desc_define_id = :descDefineId and ware_id = :wareId
        Map<String, String> param = new HashMap<String, String>();
        String sql = "";
        sql = " " +IWareDescInfoValue.S_WareId + "= :wareId" ;
        param.put("wareId", wareId);
        sql+="  and " + IWareDescInfoValue.S_DescDefineId + "= :descDefineId";
        param.put("descDefineId", descDefineId);
        
        return WareDescInfoEngine.getBeans(sql, param);
    }

	public IWareDescInfoValue[] getWareDescInfoValues(String wareId,
			String strDesDefineIds) throws Exception {
		StringBuffer condition = new StringBuffer();
        Map<String, String> param = new HashMap<String, String>();
        condition.append(" " +IWareDescInfoValue.S_WareId + "= :wareId") ;
        param.put("wareId", wareId);
        condition.append("  and " + IWareDescInfoValue.S_DescDefineId + " in("+strDesDefineIds+") ");

        
		return WareDescInfoEngine.getBeans(condition.toString(), param);
	}

	public IWareIntegralInfoValue[] getUserStartValues(long ware_id)
			throws Exception {
        // 如果传入的礼品ID不大于0，则直接返回空；
        if (ware_id <= 0)return null;

        Map<String, String> param = new HashMap<String, String>();
        StringBuffer condition = new StringBuffer();
        
        condition.append(" " +IWareIntegralInfoValue.S_WareId + "= :ware_id   ") ;
        param.put("ware_id", String.valueOf(ware_id));
        condition.append("  and " +IWareIntegralInfoValue.S_MobileBrandCode+"!='0'");
        condition.append("  and " +IWareIntegralInfoValue.S_MobileBrandCode+"!='2'");
        condition.append("  and " +IWareIntegralInfoValue.S_MobileBrandCode+"!='1'");
        
        return WareIntegralInfoEngine.getBeans(condition.toString(), param);
	}

	public IWareInfoPortalIntegralValue[] getWareIntergerByStar(String wareId,
									String starLevel, String channel) throws Exception {
		Map<String, String> parameter = new HashMap<String, String>();
        StringBuffer condition = new StringBuffer(" 1 = 1 ");
        condition.append(" AND ").append(IWareInfoPortalIntegralValue.S_WareId).append(" = :").append(IWareInfoPortalIntegralValue.S_WareId);
        parameter.put(IWareInfoPortalIntegralValue.S_WareId, String.valueOf(wareId));
        
        if(!StringUtil.isBlank(channel)){
            condition.append(" AND ").append(IWareInfoPortalIntegralValue.S_Channel).append(" = :").append(IWareInfoPortalIntegralValue.S_Channel);
            parameter.put(IWareInfoPortalIntegralValue.S_Channel, String.valueOf(channel));
        }
        
        if(!StringUtil.isBlank(starLevel)){
            condition.append(" AND ").append(IWareInfoPortalIntegralValue.S_StarLevel).append(" = :").append(IWareInfoPortalIntegralValue.S_StarLevel);
            parameter.put(IWareInfoPortalIntegralValue.S_StarLevel, String.valueOf(starLevel));
        }

        IWareInfoPortalIntegralValue[] vals = WareInfoPortalIntegralEngine.getBeans(condition.toString(), parameter);
		
        return vals;
	}

	public IWareInfoPortalIntegralValue[] getWareStarInfo(String wareId,
			String channel) throws Exception {
		Map<String, String> parameter = new HashMap<String, String>();
        StringBuffer condition = new StringBuffer(" 1 = 1 ");
        condition.append(" AND ").append(IWareInfoPortalIntegralValue.S_StarLevel).append(" NOT IN('0','1','2')  ");
        
        condition.append(" AND ").append(IWareInfoPortalIntegralValue.S_WareId).append(" = :").append(IWareInfoPortalIntegralValue.S_WareId);
        parameter.put(IWareInfoPortalIntegralValue.S_WareId, String.valueOf(wareId));
        
        if(!StringUtil.isBlank(channel)){
            condition.append(" AND ").append(IWareInfoPortalIntegralValue.S_Channel).append(" = :").append(IWareInfoPortalIntegralValue.S_Channel);
            parameter.put(IWareInfoPortalIntegralValue.S_Channel, String.valueOf(channel));
        }
        condition.append(" ORDER BY ").append(IWareInfoPortalIntegralValue.S_StarLevel).append(" DESC ");

        IWareInfoPortalIntegralValue[] vals = WareInfoPortalIntegralEngine.getBeans(condition.toString(), parameter);
		
        return vals;
	}
	
	/**
	 *  根据礼品Id获取礼品支持星级或品牌
	 * @param ware_id
	 * @return
	 * @throws Exception
	 */
	public String[] getWareSupportStarLevel(long ware_id) throws Exception {
		String sql ="select distinct mobile_brand_code from ware_integral_info where ware_id = "+ware_id;
		 Map<String, String> param = new HashMap<String, String>();
         param.put("ware_id", String.valueOf(ware_id));
         IWareIntegralInfoValue[]  values= WareIntegralInfoEngine.getBeansFromSql(sql, null);
         String[] starLevel = null;
         if(null!=values){
        	 starLevel =new String[values.length];
	         for(int i=0;i<values.length;i++){
	        	 starLevel[i] = values[i].getMobileBrandCode();
	         }
         }else{
        	 starLevel =new String[0];
         }
         return starLevel;
	}
}
