package ngves.asiainfo.core.ware.service.interfaces;

import ngves.asiainfo.core.ware.dao.interfaces.IWareDescInfoDAO;
import ngves.asiainfo.core.ware.ivalues.IWareDescInfoValue;

/**
 * func: 创建礼品属性服务接口
 */
public interface IWareDescInfoSrv {

	public void setWareDescInfoDAO(IWareDescInfoDAO wareDescInfoDAO) throws Exception;

	/**
	 * 取得礼品属性定义记录
	 * 
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public String getWareDescValueByWareIdAndDescDefineId(String wareId, String wareDescDefineId) throws Exception;
	
	  /**
     *  获取所有礼品指定属性值
     * @param wareId
     * @return IWareDescInfoValue
     * @throws Exception
     */
	public IWareDescInfoValue[] queryWareIdsDescInfo(String wareIds, String wareDescDefineId)throws Exception;
}
