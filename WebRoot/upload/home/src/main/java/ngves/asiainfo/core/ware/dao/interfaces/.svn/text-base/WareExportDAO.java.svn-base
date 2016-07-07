/**
 * 
 */
package ngves.asiainfo.core.ware.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.custom.ivalues.IQBOPartnerAllegeInfoValue;
import ngves.asiainfo.core.ware.ivalues.IQBOAllWareDescValue;

/**
 * @author admin
 * 
 */
public interface WareExportDAO {

	/**
	 * 获取投诉单数量
	 * 
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public int countWareInfos(String condition, Map<String, String> parameter) throws Exception;

	/**
	 * 统计查询结果的条数
	 * 
	 * @param partnerId
	 *            合作商的ID
	 * @param whereCondition
	 *            构造的Where查询条件
	 * @param overTime
	 *            超时标识
	 */
	public int countPartnerAllegeInfo(String condition, Map<String, Object> parameter, String partnerId)
			throws Exception;
	
	
	@SuppressWarnings("unchecked")
	public IQBOAllWareDescValue[] queryWareInfos(String condition, Map parameter, int startIndex, int endIndex) throws Exception;
	
	/**
	 *	查询所有曾经派给合作商的投诉单，以及合作商当前处理的投诉单 
	 * 	@param partnerId 合作商的ID
	 * 	@param whereCondition 构造的Where查询条件
	 *  @param overTime 超时标识
	 */
	 public IQBOPartnerAllegeInfoValue[] queryPartnerAllegeInfo(String condition, Map<String,Object> parameter, String partnerId,int startIndex, int endIndex)
     throws Exception;
}
