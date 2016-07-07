package ngves.asiainfo.core.smsformwork.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.smsformwork.ivalues.IBusiSmsFormworkOccasionRltValue;
import ngves.asiainfo.core.smsformwork.ivalues.IBusiSmsFormworkValue;
import ngves.asiainfo.core.smsformwork.ivalues.IBusiSmsFormworkWareInfoRltValue;
import ngves.asiainfo.core.smsformwork.ivalues.ISmsFormworkContentValue;
import ngves.asiainfo.core.smsformwork.ivalues.ISmsFormworkOccasionRltValue;
import ngves.asiainfo.core.smsformwork.ivalues.ISmsFormworkValue;
import ngves.asiainfo.core.smsformwork.ivalues.ISmsFormworkWareInfoRltValue;
import ngves.asiainfo.core.ware.ivalues.IWareInfoValue;

/**   
 * @author Fsr   
 * @version 1.0
 * 创建时间：2013-12-3 下午12:03:14  
 */
public interface ISmsFormworkDAO {
	/**
	 * 根据模板名称，模板状态，查询模板列表。（支持名称模糊查询）
	 * @param formworkName
	 * @param formworkState
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public ISmsFormworkValue[] qrySmsFormworkList(String condition, Map<String,String> parameter, int startNum, int endNum) throws Exception;
	
	/**
	 * 返回列表数量
	 * @param formworkName
	 * @param formworkState
	 * @return
	 * @throws Exception
	 */
	public int qrySmsFormworkListCount(String condition, Map<String,String> parameter) throws Exception ;
	
	/**
	 * 根据模板id查询 与其绑定的礼品关系列表
	 * @param formworkId
	 * @return
	 * @throws Exception
	 */
	public ISmsFormworkWareInfoRltValue[] qryFormworkWareinfoRltList(String formworkId) throws Exception;
	
	/**
	 * 根据模板id查询模板信息
	 * @param formworkId
	 * @return
	 * @throws Exception
	 */
	public ISmsFormworkValue qryFormworkById(String formworkId) throws Exception;
	
	/**
	 * 查询模板列表(生效的模板)
	 * @param formworkId
	 * @return
	 * @throws Exception
	 */
	public ISmsFormworkValue[] qrySmsFormworkInfo(String formworkId) throws Exception;
	
	/**
	 * 保存模板信息
	 * @param value
	 * @throws Exception
	 */
	public void saveSmsFormworkInfo(ISmsFormworkValue value) throws Exception;
	
	/**
	 * 保存模板的流水信息
	 * @throws Exception
	 */
	public void savaBusiSmsFormworkInfo(IBusiSmsFormworkValue[] values) throws Exception;
	
	/**
	 * 保存礼品模板绑定关系
	 * @throws Exception
	 */
	public void saveFormworkWareRlt(ISmsFormworkWareInfoRltValue[] values) throws Exception;
	
	/**
	 * 保存模板时机关系信息
	 * @param rltValues
	 * @throws Exception
	 */
	public void saveFormOccRlt(ISmsFormworkOccasionRltValue[] rltValues) throws Exception;
	
	/**
	 * 保存模板时机关系的流水信息
	 * @param busiRltValues
	 * @throws Exception
	 */
	public void savaBusiFormOccRlt(IBusiSmsFormworkOccasionRltValue[] busiRltValues) throws Exception;
	
	/**
	 * 根据模板id查询模板时机关系信息
	 * @param formworkId
	 * @return
	 * @throws Exception
	 */
	public ISmsFormworkOccasionRltValue[] qryFormworkOccasionRltInfo(String formworkId,String occasionTypeId) throws Exception;
	
	/**
	 * 根据模板时机关系id查询模板时机关系信息
	 * @param rltId
	 * @return
	 * @throws Exception
	 */
	public ISmsFormworkOccasionRltValue qryFormworkOccasionRltInfo(String rltId) throws Exception;
	
	/**
	 * 根据礼品code，活动id，活动type查询唯一的关系记录
	 * @param wareCode
	 * @param actionId
	 * @param actionType
	 * @return
	 * @throws Exception
	 */
	public ISmsFormworkWareInfoRltValue[] qryFormworkWareRlt(String wareCode,String actionId,String actionType) throws Exception;
	
	/**
	 * 保存礼品与模板的关系流水记录
	 * @param busiRltValues
	 * @throws Exception
	 */
	public void saveBusiFormworkWareRlt(IBusiSmsFormworkWareInfoRltValue[] busiRltValues) throws Exception;
	
	/**
	 * 根据子礼品code 查询相关的所有子礼品
	 * @param wareCode
	 * @return
	 * @throws Exception
	 */
	public IWareInfoValue[] qryCWareInfosById(String wareCode) throws Exception;
	
	/**
	 * 根据模板id查询模板内容列表（生效的）
	 * @param contentId
	 * @return
	 * @throws Exception
	 */
	public ISmsFormworkContentValue[] qryTempContent(String contentId) throws Exception;

}
