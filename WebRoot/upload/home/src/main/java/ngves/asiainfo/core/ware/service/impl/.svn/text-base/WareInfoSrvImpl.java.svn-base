/**
 * Copyright (c) 2011 asiainfo-linkage.com
 */
package ngves.asiainfo.core.ware.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ngves.asiainfo.core.ware.bo.WareDescInfoEngine;
import ngves.asiainfo.core.ware.bo.WareInfoEngine;
import ngves.asiainfo.core.ware.dao.interfaces.IWareInfoDAO;
import ngves.asiainfo.core.ware.ivalues.IPermissionTypeInfoValue;
import ngves.asiainfo.core.ware.ivalues.IQBOPermissionWareValue;
import ngves.asiainfo.core.ware.ivalues.IQBOWareProvDeliverFeeValue;
import ngves.asiainfo.core.ware.ivalues.IWareDescInfoValue;
import ngves.asiainfo.core.ware.ivalues.IWareInfoValue;
import ngves.asiainfo.core.ware.ivalues.IwareWeekRankValue;
import ngves.asiainfo.core.ware.model.PermissionWare;
import ngves.asiainfo.core.ware.service.interfaces.IWareInfoSrv;

/**    
 * @author asiainfo
 */
public class WareInfoSrvImpl implements IWareInfoSrv {

    private IWareInfoDAO wareInfoDAO;


    public void setWareInfoDAO(IWareInfoDAO wareInfoDAO) throws Exception {
        this.wareInfoDAO = wareInfoDAO;
    }

    /* (non-Javadoc)
     * @see ngves.asiainfo.core.ware.service.impl.IWareInfoSrv#getBean(java.lang.Long)
     */
    public IWareInfoValue getBean(Long id) throws Exception {

        return this.wareInfoDAO.getBean(id);
    }

    /**
     * 通过礼品编码查到礼品
     *
     * @param wareCode
     * @return
     * @throws Exception
     */
    public IWareInfoValue getByWareCode(String wareCode) throws Exception {
        String sql = IWareInfoValue.S_WareCode + " = :" + IWareInfoValue.S_WareCode;
        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put(IWareInfoValue.S_WareCode, wareCode);

        IWareInfoValue[] wareInfoValues = WareInfoEngine.getBeans(sql, condition);
        if (wareInfoValues != null && wareInfoValues.length != 0) {
            return wareInfoValues[0];
        }

        return null;
    }
    
    public void saveWareInfoValue(IWareInfoValue wareInfoValue) throws Exception {
    	IWareInfoValue wareInfoValue2;
    	if(0 != wareInfoValue.getWareId()){
    		wareInfoValue2 = wareInfoDAO.getWareInfoValueById(wareInfoValue.getWareId());
    		wareInfoValue2.setStsToOld();
    		if(!"".equals(wareInfoValue.getDeliverType()) && null != wareInfoValue.getDeliverType())
    			wareInfoValue2.setDeliverType(wareInfoValue.getDeliverType());
    		if(!"".equals(wareInfoValue.getWareStorageType()) && null != wareInfoValue.getWareStorageType())
    			wareInfoValue2.setWareStorageType(wareInfoValue.getWareStorageType());
    		if(0 != wareInfoValue.getCountValue())
    			wareInfoValue2.setCountValue(wareInfoValue.getCountValue());
    		if(0 != wareInfoValue.getWarehouseId())
    			wareInfoValue2.setWarehouseId(wareInfoValue.getWarehouseId());
    		wareInfoDAO.saveWareInfoBean(wareInfoValue2);
    	}
    }

	
	public void saveWareInfo(IWareInfoValue values) throws Exception {
		wareInfoDAO.saveWareInfoBean(values);
	}
	
	public IQBOPermissionWareValue[] getAllPermissionWare(String channel) throws Exception {
        return wareInfoDAO.getAllPermissionWare(channel);
    }

    public IPermissionTypeInfoValue[] getPermissionTypeInfos(long permissionId, String permissionCode) throws Exception {
        return wareInfoDAO.getPermissionTypeInfos(permissionId, permissionCode);
    }

    public IWareDescInfoValue[] getWareDescInfo(long wareId) throws Exception {

        //在属性表定义表(WARE_DESC_DEFINE_INFO)中的业务属性(可兑换渠道)的值999999999999996，理论上这个值不可变
        String GET_WARE_DESC_INFO_SQL = IWareDescInfoValue.S_DescDefineId + " in (" + 999999999999996L + ") and "
                + IWareDescInfoValue.S_WareId + " =:" + IWareDescInfoValue.S_WareId;
        Map<String, Long> paremeter = new HashMap<String, Long>();
        paremeter.put(IWareDescInfoValue.S_WareId, wareId);
        return WareDescInfoEngine.getBeans(GET_WARE_DESC_INFO_SQL, paremeter);
    }

    public List<String> getWareInfoPortalByPermissionId(List<String> partnerCodeList, List<String> wareKindCodeList,
            List<String> wareCodeList, String channel) throws Exception {
        return wareInfoDAO.getWareInfoPortalByPermissionId(partnerCodeList, wareKindCodeList, wareCodeList, channel);
    }

    public List<PermissionWare> getPermissionWareList(long permissionId, String channel) throws Exception {
        return wareInfoDAO.getPermissionWareList(permissionId, channel);
    }
    
    public boolean isPermissionWare(long wareId) throws Exception{
        return wareInfoDAO.isPermissionWare(wareId);
    }
    
    public IQBOWareProvDeliverFeeValue[] getWareProvDeliverFeeById(String wareIds) throws Exception{
    	return wareInfoDAO.getWareProvDeliverFeeById(wareIds);
    }
	public IwareWeekRankValue[] getWareWeekRankValue() throws Exception {
		return wareInfoDAO.getWareWeekRankValue();
	}

	 /**
     * 通过礼品编码查到礼品
     * @param wareCode 是一个礼品code编码串
     * @return  
     * @throws Exception  
     */
    public IWareInfoValue[] getByWareCodes(String wareCodes) throws Exception{
    	return wareInfoDAO.getByWareCodes(wareCodes);
    }
    public IWareInfoValue[] getWareInfoByO2oId(String wareCodes,String o2oId) throws Exception{
    	return wareInfoDAO.getWareInfoByO2oId(wareCodes, o2oId);
    }
}
