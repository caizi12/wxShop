package ngves.asiainfo.core.ware.dao.interfaces;

import ngves.asiainfo.core.ware.ivalues.IWareDescInfoValue;


/**

 * FUNC: 创建礼品属性接口
 */

public interface IWareDescInfoDAO {


     /**
     * 取得礼品属性定义记录
     * @param condition
     * @param parameter
     * @return
     * @throws Exception
     */
    public String getWareDescValueByWareIdAndDescDefineId(String wareId,String wareDescDefineId)
        throws  Exception;
    /**
     *  根据礼品名称获取礼品属性
     * @param wareId
     * @return IWareDescInfoValue
     * @throws Exception
     */
    public IWareDescInfoValue[] queryWareIdsDescInfo(String wareIds,String wareDescDefineId)throws Exception;
}
