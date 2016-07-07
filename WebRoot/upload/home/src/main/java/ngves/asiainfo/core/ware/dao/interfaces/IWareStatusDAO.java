package ngves.asiainfo.core.ware.dao.interfaces;

import java.util.Map;

import com.ai.secframe.ivalues.orgmodel.ISysStaffValue;

import ngves.asiainfo.core.ware.ivalues.IWareUpDownHisValue;
import ngves.asiainfo.core.ware.ivalues.IWareUpDownPlanValue;
import ngves.asiainfo.core.ware.ivalues.IWareUpDownVersionValue;

/**
 * @author liuyq7@asiainfo-linkage.com
 * @date 2012/06/07 created 
 *
 */

public interface IWareStatusDAO {

	/**
	 * 保存礼品上下线任务
	 * @param value
	 * @throws Exception
	 */
	public void saveWareUpDownPlanValue(IWareUpDownPlanValue value) throws Exception;
	
	
	/**
	 * 根据指定信息，获得礼品上下线任务
	 * @param condition
	 * @param parameter
	 * @throws Exception
	 */
	public IWareUpDownPlanValue[] getWareUpDownPlanValue(String condition,Map<String,String> parameter)throws Exception;
	
	/**
	 * 根据ID，获得单个信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public IWareUpDownPlanValue getWareUpDownPlanValueById(long id)throws Exception;
	
	/**
	 * 保存礼品上下线版本号
	 * @param value
	 * @throws Exception
	 */
	public void saveWareUpDownVersionValue(IWareUpDownVersionValue value) throws Exception;
	
	/**
	 * 查询礼品上下线版本号
	 * @param conditon
	 * @param parameter
	 * @throws Exception
	 */
	public IWareUpDownVersionValue[] getWareUpDownVersionValue(String condition,Map<String,String> parameter)throws Exception;
	
	/**
	 * 根据ID，获得单个礼品上下线版本号信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public IWareUpDownVersionValue getWareUpDownVersionValueById(long id)throws Exception;
	
	
	/**
	 * 保存礼品上下线记录
	 * @param value
	 * @throws Exception
	 */
	public void saveWareUpDownHisValue(IWareUpDownHisValue value) throws Exception;
	
	/**
	 * 查询员工编号
	 * @param staffId
	 * @return
	 * @throws Exception
	 */
	public ISysStaffValue getSysStaffValue(String staffId) throws Exception;
		
}
