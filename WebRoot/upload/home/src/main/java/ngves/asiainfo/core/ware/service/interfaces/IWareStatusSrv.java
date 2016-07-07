/**
 * 
 */
package ngves.asiainfo.core.ware.service.interfaces;

import ngves.asiainfo.core.ware.dao.interfaces.IWareStatusDAO;
import ngves.asiainfo.core.ware.ivalues.IWareUpDownPlanValue;
import ngves.asiainfo.core.ware.ivalues.IWareUpDownVersionValue;

/**
 * @author XXXX@asiainfo-linkage.com
 * @date 2012/06/07 created 
 *
 */
public interface IWareStatusSrv {

	public void setWareStatusDAO(IWareStatusDAO wareStatusDAO) ;
	/**
	 *  保存礼品上下线版本信息
	 * @param wareId
	 * @param wareStatus
	 * @throws Exception
	 */
    public void saveWareUpDownVersion(String wareId,String wareStatus)throws Exception;
    
    /**
     * 更新礼品上下线版本信息
     * @param value
     * @throws Exception
     */
    public void updateWareUpDownVersion(IWareUpDownVersionValue value)throws Exception;
    
    /**
     * 根据礼品ID，查询礼品上下线版本信息
     * @param wareId
     * @throws Exception
     * @return IWareUpDownVersion 版本号
     */
    public IWareUpDownVersionValue getWareUpDownVersion(String wareId)throws Exception;
    
    
    /**
     * 根据任务ID，取消定时任务
     * @param wareUpDownPlanId
     * @throws Exception
     */
    public void cancelPreOperLine(String wareUpDownPlanId, String opState, long staffId, String comType, long orgId) throws Exception;
    
    
   
  /**
   * 保存礼品上下线的历史记录
   * @param wareId
   * @param operType
   * @param statusCause
   * @param note
   * @param ruleId
   * @throws Exception
   */
    public void saveWareUpDownHis(String wareId,String operType,String statusCause,String note,String ruleId,String operater,String updownCause) throws Exception;
    
    /**
     * 根据上下线任务ID，获得上下线任务的记录
     * @param planId
     * @return
     * @throws Exception
     */
    public IWareUpDownPlanValue getWareUpDownPlanValueById(String planId) throws Exception; 
    
    
    /**
     * 保存礼品上下线任务
     * @param value
     * @throws Exception
     */
    public void saveWareUpDownPlan(IWareUpDownPlanValue value)throws Exception;
    
}
