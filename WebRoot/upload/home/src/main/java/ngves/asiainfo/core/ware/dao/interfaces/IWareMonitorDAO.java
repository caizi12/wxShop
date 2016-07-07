package ngves.asiainfo.core.ware.dao.interfaces;

import java.util.Map;
import com.ai.appframe2.common.AIException;
import ngves.asiainfo.core.ware.ivalues.IJobObjectRltValue;
import ngves.asiainfo.core.ware.ivalues.IQBOAllMonitorValue;
import ngves.asiainfo.core.ware.ivalues.IQBOMonitorWareValue;
import ngves.asiainfo.core.ware.ivalues.IQBOJobDateValue;
import ngves.asiainfo.core.ware.ivalues.IQBOQueryMonitorValue;

public interface IWareMonitorDAO {
/**
 * 保存监控配置信息
 * @param taskId
 * @param queryTime
 * @param warmingtype
 * @param monitorstatus
 * @param operatorId
 * @throws Exception
 */
	public void wareMonitorSave(String taskId,String queryTime ,String warmingtype,String monitorstatus,
			long operatorId)throws Exception;
	/**
	 * 
	 * 员工与任务绑定
	 * @param staffId
	 * @param taskId
	 * @param flag
	 * @param operatorId
	 * @return
	 * @throws Exception
	 */
	
	public boolean staffJobIsBind(String staffId, String taskId,boolean flag,long operatorId) throws Exception;
	/**
	 * 监控配置查询
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public IQBOJobDateValue[] queryWareMonitor(String condition, Map<String, String> parameter) throws Exception;
	
	/**
	 * 列表页查询数据
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 * 2012-11-13
	 */
	public IQBOQueryMonitorValue[] getQueryMonitorValue(String condition, Map<String, String> parameter, int startNum,
			int endNum) throws Exception;
	
	/**
	 * 列表页面查询数据量
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 * 2012-11-13
	 */
	public int getQueryMonitorCount(String condition, Map<String, String> parameter) throws Exception;
	
	/**查看监控详情
	 * @param jobTaskId 任务id ，monitorType 监控类型
	 * @return 记录数组
	 */
	public IQBOAllMonitorValue[] queryMonitorDetail(String jobTaskId,String monitorType) throws Exception;
	/**
	 * 查询出全部监控对象信息
	 * 
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 *             2012-11-6
	 */
	public IQBOAllMonitorValue[] getAllMonitorValue(String condition, Map<String, String> parameter, int startNum,
			int endNum) throws Exception;
	
	/**
	 * 查询监控对象信息
	 * 
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 *             2012-11-9
	 */
	public IQBOAllMonitorValue[] getAllMonitorValue(String condition, Map<String, String> parameter) throws Exception;

	/**
	 * 查询出监控对象的数量
	 * 
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 *             2012-11-6
	 */
	public int getAllMonitorCount(String condition, Map<String, String> parameter) throws Exception;
	
	public IQBOMonitorWareValue[] queryMonitorWare(String jobtaskid) throws Exception;
	/**
	 * @return
	 * @throws AIException 
	 * @throws Exception 
	 */
	public long addJobTask() throws AIException, Exception;
	/**
	 * @param jobObjectRltValues
	 * @param jobTaskId
	 * @throws Exception 
	 */
	public void saveMonitorObject(IJobObjectRltValue[] jobObjectRltValues, long jobTaskId) throws Exception;
	
	public boolean saveWareMonitorRecord(String operateType, String operatorId,String taskId, String sendObjId, String descOfStatus) throws Exception;
/**
 * 删除时间段
 * @param jobDateRltID
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
