/**
 * 
 */
package ngves.asiainfo.core.ware.service.interfaces;
import ngves.asiainfo.core.ware.dao.interfaces.IWareInfoDAO;
import ngves.asiainfo.core.ware.dao.interfaces.IWareMonitorDAO;
import ngves.asiainfo.core.ware.ivalues.IQBOAllMonitorValue;
import ngves.asiainfo.core.ware.ivalues.IQBOJobDateValue;
import ngves.asiainfo.core.ware.ivalues.IQBOQueryMonitorValue;

import ngves.asiainfo.core.ware.ivalues.IQBOMonitorWareValue;


public interface IWareMonitorSrv {
	public void setWareMonitorDAO(IWareMonitorDAO wareMonitorDAO) throws Exception;
/**
 * 保存监控配置信息
 * @param taskId        任务ID
 * @param queryTime     监控时间段
 * @param warmingtype   告警类型
 * @param monitorstatus 启用状态
 * @param operatorId	操作人ID
 * @throws Exception
 */
	public void wareMonitorSave(String taskId, String queryTime,String warmingtype,
			String monitorstatus, long operatorId)throws Exception;
	/**
	 * 员工与任务绑定
	 * @param staffIds
	 * @param taskId
	 * @param flag
	 * @param operatorId
	 * @return
	 * @throws Exception
	 */
	public boolean staffJobIsBind(String staffIds, String taskId,boolean flag,long operatorId) throws Exception;
	/**
	 * 监控配置查询
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public IQBOJobDateValue[] queryWareMonitor(String taskId) throws Exception;
	
	
	public void setWareInfoDAO(IWareInfoDAO wareInfoDAO) throws Exception;
	
	
	/**
	 * 查詢監控對象信息
	 * 
	 * @param wareName
	 * @param firstKindId
	 * @param parentKindId
	 * @param kindId
	 * @param warningType
	 * @param initiateMode
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 *             2012-11-6
	 */
	public IQBOQueryMonitorValue[] getAllMonitorValue(String wareCode, String firstKindId, String parentKindId,
			String kindId, String warningType, String initiateMode, int startNum, int endNum) throws Exception;

	/**
	 * 查詢監控對象數量
	 * 
	 * @param wareName
	 * @param firstKindId
	 * @param parentKindId
	 * @param kindId
	 * @param warningType
	 * @param initiateMode
	 * @return
	 * @throws Exception
	 *             2012-11-6
	 */
	public int getAllMonitorValueCount(String wareCode, String firstKindId, String parentKindId, String kindId,
			String warningType, String initiateMode) throws Exception;
	/**查看监控详情
	 * @param jobTaskId 任务id ，monitorType 监控类型
	 * @return 记录数组
	 */
	public IQBOAllMonitorValue[] queryMonitorDetail(String jobTaskId,String monitorType) throws Exception;
	/**
	 * 根据监控任务编号查询监控礼品
	 * @param jobtaskid
	 * @return
	 * @throws Exception
	 */
	public IQBOMonitorWareValue[] queryMonitorWare(String jobtaskid) throws Exception;
	
	public void saveMonitorObject(String monitorType,String monitorObjectId) throws Exception;
	
	/**
	 * 
	 * @param operateType	业务操作类型
	 * @param operatorId	操作人
	 * @param taskId	任务编号
	 * @param sendObjId	发送对象
	 * @param descOfStatus	描述状态
	 * @return
	 * @throws Exception
	 */
	public boolean saveWareMonitorRecord(String operateType, String operatorId,String taskId, String sendObjId,String descOfStatus) throws Exception;
	/**
	 * 删除时间段
	 * @param jobDateRltID 任务与监控时间段关系 ID
	 * @return
	 * @throws Exception
	 */
	public boolean wareMonitorTimeDel(String jobDateRltID)throws Exception;
	/**
	 * 获得最大的排序
	 * @return
	 * @throws Exception
	 */
	
	public String getMaxSort()throws Exception;
}
