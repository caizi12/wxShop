
package ngves.asiainfo.core.ware.service.interfaces;

import java.util.Map;

import ngves.asiainfo.core.ware.dao.interfaces.IWareLimitExchangeNumDAO;
import ngves.asiainfo.core.ware.ivalues.IQBOLimitExchangeNumWareValue;
import ngves.asiainfo.core.ware.ivalues.IWareExchangeRuleRltValue;
import ngves.asiainfo.core.ware.ivalues.IWareLimitExchangeNumValue;


/**
 * 2014-8-29
 * 增加兑换限制数量服务
 * @author xj
 *
 */
public interface IWareLimitExchangeNumSrv {
    
    public void setWareLimitExchangeNumDAO(IWareLimitExchangeNumDAO wareLimitExchangeNumDAO)  throws Exception;  
    /**
	 * 保存增加兑换数量限制规则的基本信息
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public String saveLimitNumRuleInfoValue(IWareLimitExchangeNumValue  value,Map<String,Object> userMap)throws Exception;
	/**
	 * 根据ID查询增加兑换数量限制基本信息
	 * @param wareLimitId
	 * @return
	 * @throws Exception
	 */	
	public IWareLimitExchangeNumValue getLimitNumRuleInfoById(String wareLimitId)throws Exception;
	/**
	 * 根据条件查询总的记录条数
	 * @param limitName
	 * @param exchangeCycle
	 * @return
	 * @throws Exception
	 */	
	public int getLimitNumRuleCount(String limitName,String exchangeCycle) throws Exception;
	/**
	 * 分页查找总的记录条数
	 * @param limitName 限制名称
	 * @param isEffect  是否生效
	 * @param exchangeCycle 限制兑换周期
	 * @param startNum  开始记录
	 * @param endNum  结束记录条数
	 * @return
	 * @throws Exception
	 */
	public IWareLimitExchangeNumValue[] getLimitNumRule(String limitName,String exchangeCycle,int startNum, int endNum) throws Exception;
    
	/**
	 * 获取限制规则绑定的礼品信息
	 * @param wareLimitId
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IQBOLimitExchangeNumWareValue[] queryBindWareInfo(String wareLimitId, int startIndex,int endIndex) throws Exception;


	/**
	 * 获取限制规则绑定的礼品信息的总条数
	 * @param wareLimitId
	 * @return
	 * @throws Exception
	 */
	public int queryBindWareInfoCount(String wareLimitId)throws Exception;
	/**
	 * 绑定兑换数量限制页查询绑定礼品方法
	 * @param partnerId
	 * @param lstWareFirstKind
	 * @param lstWareParentKind
	 * @param lstWareKind
	 * @param wareName
	 * @param wareCode
	 * @param limitExchangeCycle
	 * @param isEffect
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IQBOLimitExchangeNumWareValue[] getBindWareInfoList(String partnerId,String lstWareFirstKind,
			String lstWareParentKind, String lstWareKind, String wareName, String wareCode,String limitExchangeCycle,
			String isEffect,String provinceCode,String wareKindInfoId,int startIndex,int endIndex) throws Exception;
	/**
	 * 绑定兑换数量限制页查询绑定礼品方法总条数
	 * @param partnerId
	 * @param lstWareFirstKind
	 * @param lstWareParentKind
	 * @param lstWareKind
	 * @param wareName
	 * @param wareCode
	 * @param limitExchangeCycle
	 * @param isEffect
	 * @return
	 * @throws Exception
	 */
	public int getBindWareInfoListCount(String partnerId,String lstWareFirstKind,
			String lstWareParentKind, String lstWareKind, String wareName, String wareCode,String limitExchangeCycle,
			String isEffect,String provinceCode,String wareKindInfoId) throws Exception;
	
	/**
	 * 修改兑换数量限制规则的基本信息
	 * @param value
	 * @param  code  操作人工号
	 * @return
	 * @throws Exception
	 */
	public String modifyLimitNumRuleInfoValue(IWareLimitExchangeNumValue  value,Map<String,Object> map)throws Exception;	
	/**
	 * 修改生效状态
	 * code操作人工号
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public String updateEffect(IWareLimitExchangeNumValue  value,Map<String,Object> userMap)throws Exception;
	
	/**
	 * 保存绑定礼品数量关系
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public String saveLimitNumWareInfoValue(IWareExchangeRuleRltValue[] values,Map<String,Object> userMap)throws Exception;	
	/**
	 * 根据规则ID获取绑定的礼品信息
	 * @param wareLimitId
	 * @return
	 * @throws Exception
	 */
	public IWareExchangeRuleRltValue[] queryBindWareInfos(String wareLimitId)throws Exception;
	/**
	 * 判断规则名称判断是否有重复
	 * @param limitName
	 * @return
	 * @throws Exception
	 */
	public boolean isExistSameName(String limitName) throws Exception;
	
	/**
	 * 解除绑定
	 * @param map
	 * @return
	 * @throws Exception
	 */	
	public boolean unBindWareLimit(Map<String,Object>  map)throws Exception;
}



