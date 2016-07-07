package ngves.asiainfo.core.ware.dao.interfaces;



import ngves.asiainfo.core.ware.ivalues.IQBOHouseWareInfoValue;

/**
 * 正常品库存查询管理
 * @author mengss
 *
 */
public interface IHouseWareInfoDAO {
    /**
     * 返回库存信息
     * @param ware_code 礼品编码
     * @param ware_name 礼品名称
     * @param ware_status 礼品状态
     * @param ware_kind 礼品小类
     * @param ware_kind_parent 礼品父类
     * @param ware_first_kind 一级大类
     * @param ware_brand 礼品品牌
     * @param provider_code 礼品商编码
     * @param storager_code 仓储商编码
     * @param logistics_code 配送商编码 //delete 
     * @param warehouse_code 仓库编码
     * @param warehouse_type 仓库类型
     * @param comType 用户角色类型
     * @param startNum 
     * @param endNum
     * @return
     * @throws Exception
     */
    IQBOHouseWareInfoValue[] getHouseWareInfo(String ware_code, String ware_name, String ware_status, String ware_kind,
            String ware_kind_parent, String ware_first_kind, String ware_brand, String provider_id, String storager_id,
            String warehouse_id, String warehouse_type, String provinceCode,String comType,String staffId,String ware_kind_info,int startNum, int endNum) throws Exception;

    int getHouseWareInfoCount(String ware_code, String ware_name, String ware_status, String ware_kind,
            String ware_kind_parent, String ware_first_kind, String ware_brand, String provider_id, String storager_id,
            String warehouse_id, String warehouse_type,String provinceCode,String comType,String staffId,String ware_kind_info) throws Exception;

   
}
