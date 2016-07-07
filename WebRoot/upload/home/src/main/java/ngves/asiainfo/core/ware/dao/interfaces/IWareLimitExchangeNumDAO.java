/**
 * 
 */
package ngves.asiainfo.core.ware.dao.interfaces;

import java.util.Map;
import ngves.asiainfo.core.ware.ivalues.IQBOLimitExchangeNumWareValue;
import ngves.asiainfo.core.ware.ivalues.IWareExchangeRuleRltValue;
import ngves.asiainfo.core.ware.ivalues.IWareLimitExchangeNumValue;

/**
 * 增加兑换限制数量(规则表管理)
 * @author xj
 * 2014-8-29
 *
 */
public interface IWareLimitExchangeNumDAO {
	
	/**
	 * 保存增加兑换数量限制规则的基本信息
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public String saveLimitNumRuleInfoValue(IWareLimitExchangeNumValue  value)throws Exception;
	/**
	 * 根据ID查询增加兑换数量限制基本信息
	 * @param wareLimitId
	 * @return
	 * @throws Exception
	 */	
	public IWareLimitExchangeNumValue getLimitNumRuleInfoById(String wareLimitId)throws Exception;
	
	public int getLimitNumRuleCount(String condition, Map<String, Object> parameter) throws Exception;
	/**
	 * 分页查询增加兑换数量规则
	 * @param string
	 * @param parameter
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public IWareLimitExchangeNumValue[] getLimitNumRule(String condition, Map<String, Object> parameter, int startNum, int endNum) throws Exception;
	
	//获取限制规则绑定的礼品信息
	public IQBOLimitExchangeNumWareValue[] queryBindWareInfo(String condition, Map<String, Object> parameter, int startNum, int endNum) throws Exception;
	
	//获取限制规则绑定的礼品信息总条数
	public int queryBindWareInfoCount(String condition, Map<String, Object> parameter) throws Exception;	
	/**
	 * 保存绑定礼品数量关系
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public String saveLimitNumWareInfoValue(IWareExchangeRuleRltValue[]  values)throws Exception;	
	/**
	 * 根据限制规则ID，礼品ID查询记录是否存在
	 * @param wareLimitId
	 * @param wareId 不传值，查询规则下面绑定的礼品信息
	 * @return
	 * @throws Exception
	 */
	public IWareExchangeRuleRltValue[]  getLimitNumWareInfoValues(String  wareLimitId,Long  wareId)throws Exception;		
	/**
	 * 根据绑定id删除绑定关系
	 * 逻辑删除
	 * @param wareBindRultIds
	 * @return
	 * @throws Exception
	 */
	public boolean  deleteBindWare(String  wareBindRltIds)throws Exception;
	/**
	 * 判断规则名称是否有重复
	 * @param limitName
	 * @return
	 * @throws Exception
	 */
	public boolean isExistSameName(String limitName) throws Exception;
	/**
	 * 查询该礼品是否有正在生效的时间段
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public IWareExchangeRuleRltValue[] isEffectRuleAmongWare(IWareExchangeRuleRltValue value) throws Exception;	
	/**
	 * 查询绑定关系基本信息
	 * @param relationId
	 * @param isBind
	 * @return
	 * @throws Exception
	 */
	public IWareExchangeRuleRltValue[] getWareExchangeRuleRltValue(String relationId,String isBind)throws Exception;
}
