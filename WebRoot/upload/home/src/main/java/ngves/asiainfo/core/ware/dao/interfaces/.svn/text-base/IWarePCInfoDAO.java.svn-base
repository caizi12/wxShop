/**
 * 主礼品与父礼品关系的数据层代码
 */
package ngves.asiainfo.core.ware.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.ware.ivalues.IBusiWareInfoParentValue;
import ngves.asiainfo.core.ware.ivalues.IQBOAllWareInfoChildValue;
import ngves.asiainfo.core.ware.ivalues.IQBOWareChildInfoValue;
import ngves.asiainfo.core.ware.ivalues.IQBOWareParentInfoValue;
import ngves.asiainfo.core.ware.ivalues.IWareInfoParentValue;
import ngves.asiainfo.core.ware.ivalues.IWareInfoValue;
import ngves.asiainfo.core.ware.ivalues.IWarePCRltValue;

/**
 * @author liuyq7@asiainfo-linkage.com
 *
 */
public interface IWarePCInfoDAO {

	/**
	 * 根据ID获得主礼品与子礼品的关系数据
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public IWarePCRltValue getWarePCRltValueById(long id)throws Exception;
	
	/**
	 * 根据条件，查询出子礼品与父礼品的关系
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public IWarePCRltValue[] getWarePCRltValue(String condition,Map<String,String> parameter)throws Exception;
	
	/**
	 * 根据条件，查询出子礼品与父礼品的关系
	 * @param condition
	 * @param parameter
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IWarePCRltValue[] getWarePCRltValue(String condition, Map<String, String> parameter,
			int startIndex, int endIndex) throws Exception;
	
	/**
	 * 保存父子礼品的关系数据，并返回ID
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public long saveWarePCInfo(IWarePCRltValue value) throws Exception;
	
	/**
	 * 保存父子礼品的关系数据数组
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public void saveWarePCInfo(IWarePCRltValue[] value) throws Exception;
	
	
	/**
	 * 根据ID获得父礼品的基本信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public IWareInfoParentValue getWareInfoParentById(long id) throws Exception;
	
	/**
	 * 根据条件，查询出符合条件的父礼品信息
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public IWareInfoParentValue[] getWareInfoParentValue(String condition,Map<String,String> parameter)throws Exception;
	
	/**
	 * 根据条件，查询出符合条件的父礼品信息(分页)
	 * @param condition
	 * @param startIndex 开始索引
	 * @param endIndex 结束索引
	 * @return
	 * @throws Exception
	 */
	public IWareInfoParentValue[] getWareInfoParentValue(String condition,Map<String,String> parameter,int startIndex,int endIndex)throws Exception;
	
	
	public int getWareInfoParentValueCount(String condition,Map<String,String> parameter) throws Exception;
	
	/**
	 * 获取子礼品的相关信息
	 * @param condition
	 * @param parameter
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IQBOWareChildInfoValue[] getWareChildInfoValue(String condition,Map<String,String> parameter,int startIndex,int endIndex) throws Exception;
	
	/**
	 * 获取子礼品数量
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int getWareChildInfoValueCount(String condition,Map<String,String> parameter) throws Exception;
	
	/**
	 * 保存拥有父子礼品关系中父礼品的信息
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public long saveWareInfoParentValue(IWareInfoParentValue value) throws Exception;
	
	/**
	 * 保存拥有父子礼品关系中父礼品的信息
	 * @param value
	 * @throws Exception
	 */
	public void saveWareInfoParentValue(IWareInfoParentValue[] value) throws Exception;
	
	
	/**
	 * 查询符合条件的父礼品信息
	 * @param condition
	 * @param parameter
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public IQBOWareParentInfoValue[] getQBOWarePCInfoValue(String condition,Map<String,String> parameter,int startNum,int endNum) throws Exception;
	
	/**
	 * 查询符合条件的父礼品流水信息
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public IBusiWareInfoParentValue [] getBusiWareInfoParentValue(String condition,Map<String,String> parameter) throws Exception;
	
	/**
	 * 根据ID，查询出符合条件父礼品流水信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public IBusiWareInfoParentValue getBusiWareInfoParentValueById(long id) throws Exception;
	
	/**
	 * 保存父礼品信息的流水，并返回流水ID
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public long saveBusiWareInfoParentValue(IBusiWareInfoParentValue  value) throws Exception;
	
	/**
	 * 保存父礼品的基本信息
	 * @param value
	 * @throws Exception
	 */
	public void saveBusiWareInfoParentValue(IBusiWareInfoParentValue [] value) throws Exception;
	
	/**
	 * 根据条件获得礼品基本信息
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public IWareInfoValue[] getWareInfoValue(String condition,Map<String,String> parameter) throws Exception;

	/**
	 * 根据父礼品ID获取子礼品信息
	 * @param wareParentId
	 * @return
	 * @throws Exception
	 * 2012-8-14
	 */
	public IWareInfoValue[] getChildWareInfo(long wareParentId) throws Exception;

	/**
	 * 查询父子礼品信息（按省市县）
	 */
	public IQBOAllWareInfoChildValue[] queryAllWareInfoChild(String condition,Map<String,String> parameter,int startNum,int endNum) throws Exception;

	public int getWareInfoChildValueCount(String condition,Map<String,String> parameter) throws Exception;
	/**
	 * 根据父礼品id查询子礼品id
	 * @param wareParentId
	 * @return
	 * @throws Exception
	 */
	public IWarePCRltValue[] getParentIdFindChildWareInfo(long wareParentId)throws Exception;
	
	/**
	 * 根据子礼品id查询父礼品id
	 * @param wareChildId
	 * @return
	 * @throws Exception
	 */
	public IWarePCRltValue[] getParentPCInfoByChildId(long wareChildId)throws Exception;
}
