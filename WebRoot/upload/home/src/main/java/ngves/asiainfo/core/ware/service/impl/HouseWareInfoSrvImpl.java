package ngves.asiainfo.core.ware.service.impl;

import ngves.asiainfo.core.ware.dao.interfaces.IHouseWareInfoDAO;
import ngves.asiainfo.core.ware.ivalues.IQBOHouseWareInfoValue;
import ngves.asiainfo.core.ware.service.interfaces.IHouseWareInfoSrv;

public class HouseWareInfoSrvImpl implements IHouseWareInfoSrv {
    private IHouseWareInfoDAO houseWareInfoDAO;

    public IHouseWareInfoDAO getHouseWareInfoDAO() {
        return houseWareInfoDAO;
    }

    public void setHouseWareInfoDAO(IHouseWareInfoDAO houseWareInfoDAO) {
        this.houseWareInfoDAO = houseWareInfoDAO;
    }
    
    
    public IQBOHouseWareInfoValue[] getHouseWareInfo(String ware_code, String ware_name, String ware_status,
            String ware_kind, String ware_kind_parent,String ware_first_kind, String ware_brand, String provider_id, String storager_id,
           String warehouse_id, String warehouse_type,String provinceCode,String comType,String staffId,String ware_kind_info, int startIndex, int endIndex)
            throws Exception {
        return getHouseWareInfoDAO().getHouseWareInfo(ware_code, ware_name, ware_status, ware_kind, ware_kind_parent,ware_first_kind,
                ware_brand, provider_id, storager_id,  warehouse_id, warehouse_type,provinceCode,comType,staffId,ware_kind_info, startIndex,
                endIndex);
    }

    public int getHouseWareInfoCount(String ware_code, String ware_name, String ware_status, String ware_kind,
            String ware_kind_parent,String ware_first_kind, String ware_brand, String provider_id, String storager_id,
            String warehouse_id, String warehouse_type,String provinceCode,String comType,String staffId,String ware_kind_info) throws Exception {
        return getHouseWareInfoDAO().getHouseWareInfoCount(ware_code, ware_name, ware_status, ware_kind,
                ware_kind_parent,ware_first_kind, ware_brand, provider_id, storager_id,  warehouse_id,
                warehouse_type,provinceCode,comType,staffId,ware_kind_info);
    }


}
