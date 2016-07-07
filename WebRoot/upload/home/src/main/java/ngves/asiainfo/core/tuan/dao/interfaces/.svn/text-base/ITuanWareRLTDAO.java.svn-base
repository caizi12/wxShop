package ngves.asiainfo.core.tuan.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.tuan.ivalues.IQBOTuanWareInfoValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOTuanWareIntegralValue;
import ngves.asiainfo.core.tuan.ivalues.ITuanInfoValue;
import ngves.asiainfo.core.tuan.ivalues.ITuanWareRLTValue;

/**
 * 
 * <p>
 * 团购关联礼品表信息展示
 * </p>
 * 
 * @author shenfl@asiainfo-linkage.com
 */
public interface ITuanWareRLTDAO {

	/**
	 * 获取 团购关联礼品表信息
	 * 
	 * @param tuanId
	 * @return
	 * @throws Exception
	 */
	public ITuanWareRLTValue getTuanWareRLTById(String tuanId) throws Exception;

	/**
	 * @author liuyq
	 * @date 2011-07-18
	 * @purpose 查询团购礼品信息 [分页]
	 * @param condition
	 *            条件
	 * @para parameter 参数
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IQBOTuanWareInfoValue[] queryTuanWare(String condition, Map<String, String> parameter, int startIndex,
			int endIndex) throws Exception;
	
	public int tuanSmsTemp(String tuanId,String wareId) throws Exception;
	
	/**
	 * @author cuihj
	 * @date 2013-08-20
	 * @purpose 根据礼品ID获取礼品配置的仓库类型
	 * @param wareId 礼品ID
	 * @return
	 * @throws Exception
	 */
	public IQBOTuanWareInfoValue[] queryTuanWare(String condition, Map<String, String> parameter) throws Exception;

	/**
	 * @author liuyq
	 * @date 2011-07-18
	 * @purpose 查询团购礼品信息
	 * @param
	 * @return
	 * @throws Exception
	 */
	public int countTuanWare(String condition, Map<String, String> parameter) throws Exception;
	
	/**
	 * 验证此礼品是否已保存到TUAN_WARE_RLT
	 */
	public int isTuanWareRlt(String tuanId,String wareId) throws Exception;

	/**
	 * @author liuyq
	 * @date 2011-07-18
	 * @purpose 团购活动绑定的礼品信息查询 给出团购活动ID，查询出团购活动绑定的礼品信息[不分页]
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public IQBOTuanWareIntegralValue[] queryTuanBindRelationInfo(String condition, Map<String, String> parameter)
			throws Exception;

	/**
	 * @author liuyq
	 * @date 2011-07-19
	 * @purpose 绑定团购对应的礼品信息
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public long saveBindTuanWareInfo(ITuanWareRLTValue value) throws Exception;
	
	//保存并预览团购活动增加日志
	public long saveBindTuanWareInfo(Map<String,Object> in) throws Exception;

	/**
	 * @author liuyq
	 * @date 2011-07-19
	 * @purpose 根据团购Id，删除团购绑定的礼品信息
	 * @param tuanId
	 * @throws Exception
	 */
	public void deleteBindTuanWareInfoById(String tuanId) throws Exception;
	/**
	 * 根据给定tuanWareRlt的数值，直接尝试保存数据，没有自动生成ID，此方法只用于数据回滚操作
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public long saveTuanWareInfoNoId(ITuanWareRLTValue value)throws Exception;
	
	

	/**
	 * 取得当前开始 活动
	 * @param tuanId
	 * @return
	 * @throws Exception
	 */
	public ITuanInfoValue[] getCurTuanInfo(String condition, Map<String, String> parameter) throws Exception;
	
}