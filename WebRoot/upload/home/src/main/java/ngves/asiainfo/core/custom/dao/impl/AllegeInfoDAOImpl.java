/**
 * 
 */
package ngves.asiainfo.core.custom.dao.impl;

import java.util.Map;

import ngves.asiainfo.core.custom.AllegeConstant;
import ngves.asiainfo.core.custom.bo.AllegeInfoEngine;
import ngves.asiainfo.core.custom.bo.QBOPartnerAllegeInfoEngine;
import ngves.asiainfo.core.custom.dao.interfaces.IAllegeInfoDAO;
import ngves.asiainfo.core.custom.ivalues.IAllegeInfoValue;
import ngves.asiainfo.core.custom.ivalues.IQBOPartnerAllegeInfoValue;

/**
 * @author admin
 *
 */
public class AllegeInfoDAOImpl implements IAllegeInfoDAO {

	public int countAllegeInfos(String condition, Map<String, String> parameter) throws Exception {
		return AllegeInfoEngine.getBeansCount(condition, parameter);
	}

	public int countPartnerAllegeInfo(String condition, Map<String, Object> parameter, String partnerId)
			throws Exception {
		parameter.put(AllegeConstant.PARTNER_QUERY_RESP_OP_ID, partnerId);
		parameter.put(AllegeConstant.PARTNER_QUERY_PARTNER_ID, partnerId);
		parameter.put(AllegeConstant.PARTNER_QUERY_ASSIGN_PARTNER_ID, partnerId);

		return QBOPartnerAllegeInfoEngine.getBeansCount(condition, parameter);
	}

	@SuppressWarnings("unchecked")
	public IAllegeInfoValue[] queryAllegeInfos(String condition, Map parameter, int startIndex, int endIndex)
			throws Exception {
		return AllegeInfoEngine.getBeans(null, condition, parameter, startIndex, endIndex, false);
	}

	public IQBOPartnerAllegeInfoValue[] queryPartnerAllegeInfo(String condition, Map<String, Object> parameter,
			String partnerId, int startIndex, int endIndex) throws Exception {
		parameter.put(AllegeConstant.PARTNER_QUERY_RESP_OP_ID, partnerId);
		parameter.put(AllegeConstant.PARTNER_QUERY_PARTNER_ID, partnerId);
		parameter.put(AllegeConstant.PARTNER_QUERY_ASSIGN_PARTNER_ID, partnerId);
		return QBOPartnerAllegeInfoEngine.getBeans(null, condition, parameter, startIndex, endIndex, false);
	}
	
	
}
