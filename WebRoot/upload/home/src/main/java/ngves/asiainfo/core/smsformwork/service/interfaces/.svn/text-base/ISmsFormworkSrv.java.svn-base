package ngves.asiainfo.core.smsformwork.service.interfaces;

import ngves.asiainfo.core.smsformwork.dao.interfaces.ISmsFormworkDAO;
import ngves.asiainfo.core.smsformwork.ivalues.ISmsFormworkValue;

public interface ISmsFormworkSrv {
	
	/**
	 * 根据模板名称，模板状态，查询模板列表。（支持名称模糊查询）
	 * @param formworkName
	 * @param formworkState
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public ISmsFormworkValue[] qrySmsFormworkList(String formworkName,String formworkState,String queryType,int startNum, int endNum) throws Exception;
	
	/**
	 * 返回列表数量
	 * @param formworkName
	 * @param formworkState
	 * @return
	 * @throws Exception
	 */
	public int qrySmsFormworkListCount(String formworkName,String formworkState) throws Exception;
	
	public void setSmsFormworkDAO(ISmsFormworkDAO smsFormworkDAO) ;
	
	/**
	 * 删除短信模板信息
	 * @throws Exception
	 */
	public void deleteFormworkInfo(String formworkId) throws Exception;
	
	/**
	 * 根据模板id查询模板信息
	 * @param formworkId
	 * @return
	 * @throws Exception
	 */
	public ISmsFormworkValue qrySmsFormworkById(String formworkId) throws Exception;
	
	/**
	 * 礼品绑定模板信息
	 * @param formworkId 模板id
	 * @param jsonStr  以礼品code 活动类型 活动编号 组成的Json串
	 * @param operCode  操作人编号
	 * @throws Exception
	 */
	public void bindFormworkInfo(String formworkId,String josnStr,String operCode) throws Exception;
	
	/**
	 * 查询模板时机关系的信息
	 * @param formworkId,occasionTypeId
	 * @return json格式的Sring
	 * @throws Exception
	 */
	public String qryFormworkOccasionRltInfo(String formworkId,String occasionTypeId) throws Exception;
	
	/**
	 * 保存模板及其关系的时机信息
	 * @param infoJson 模板信息
	 * @param rltInfoJson  时机关系信息
	 * @throws Exception
	 */
	public void saveInfo(String infoJson,String rltInfoJson,String operCode) throws Exception;
	
	/**
	 * 根据模板名称查询模板是否存在 不存在返回false
	 * @param formworkName
	 * @return
	 * @throws Exception
	 */
	public boolean isExistSameName(String formworkName) throws Exception;

}
