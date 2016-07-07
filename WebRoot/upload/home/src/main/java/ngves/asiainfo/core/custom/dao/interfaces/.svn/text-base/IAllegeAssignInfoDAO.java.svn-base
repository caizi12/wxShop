package ngves.asiainfo.core.custom.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.common.ivalues.IQBOAllegeAssignQueryInfoValue;
import ngves.asiainfo.core.custom.ivalues.IAllegeAssignDealInfoValue;

@SuppressWarnings("unchecked")
public interface IAllegeAssignInfoDAO {

	/**
	 * 取消投诉派单
	 * @param allegeAssignIds
	 * @throws Exception
	 */
	public void cancelAllegeAssignDealInfo(IAllegeAssignDealInfoValue[] allegeAssigns) throws Exception;

	/**
	 * 根据派单ID得到派单信息
	 * 
	 * @param allegeAssignId
	 * @return
	 * @throws Exception
	 */
	public IAllegeAssignDealInfoValue getAllegeAssignDealInfoById(long allegeAssignId) throws Exception;

	/**
	 * 保存投诉单指派信息
	 * 
	 * @param assignInfo
	 * @throws Exception
	 */
	public void saveAllegeAssignInfo(IAllegeAssignDealInfoValue assignInfo) throws Exception;

	/**
	 * 查询投诉单指派信息
	 * 
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */

	public IAllegeAssignDealInfoValue[] queryAssignInfos(String condition, Map parameter) throws Exception;

	/**
	 * 根据查询条件得到投诉单指派信息，并分页显示
	 * 
	 * @param condition
	 * @param parameter
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IAllegeAssignDealInfoValue[] getAllegeAssignInfo(String condition, Map parameter, int startIndex,
			int endIndex) throws Exception;

	/**
	 * 根据查询条件得到投诉单指派信息数量
	 * 
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public int countAllegeAssignInfo(String condition, Map parameter) throws Exception;
	
	/**
	 * 查询派单处理报表
	 * @param string
	 * @param map
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public IQBOAllegeAssignQueryInfoValue[] queryAllegeAssignQueryInfos(String string, Map map, int startIndex,
			int endIndex) throws Exception;

	/**
	 * 查询派单处理报表数量
	 * @param string
	 * @param map
	 * @return
	 */
	public int countAllegeAssignQueryInfos(String condition, Map parameter) throws Exception;
}
