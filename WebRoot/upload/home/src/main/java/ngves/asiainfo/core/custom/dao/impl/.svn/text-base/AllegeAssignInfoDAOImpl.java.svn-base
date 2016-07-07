package ngves.asiainfo.core.custom.dao.impl;

import java.util.Map;

import ngves.asiainfo.core.common.bo.QBOAllegeAssignQueryInfoEngine;
import ngves.asiainfo.core.common.ivalues.IQBOAllegeAssignQueryInfoValue;
import ngves.asiainfo.core.custom.bo.AllegeAssignDealInfoEngine;
import ngves.asiainfo.core.custom.dao.interfaces.IAllegeAssignInfoDAO;
import ngves.asiainfo.core.custom.ivalues.IAllegeAssignDealInfoValue;

@SuppressWarnings("unchecked")
public class AllegeAssignInfoDAOImpl implements IAllegeAssignInfoDAO {

	public IAllegeAssignDealInfoValue getAllegeAssignDealInfoById(long allegeAssignId) throws Exception {
		return AllegeAssignDealInfoEngine.getBean(allegeAssignId);
	}

	public void saveAllegeAssignInfo(IAllegeAssignDealInfoValue assignInfo) throws Exception {
		if (assignInfo.isNew()) {
			assignInfo.setAllegeAssignId(AllegeAssignDealInfoEngine.getNewId().longValue());
			assignInfo.setSendDate(AllegeAssignDealInfoEngine.getSysDate());

		}
		AllegeAssignDealInfoEngine.save(assignInfo);
	}

	public IAllegeAssignDealInfoValue[] queryAssignInfos(String condition, Map parameter) throws Exception {
		return AllegeAssignDealInfoEngine.getBeans(condition, parameter);
	}

	public IAllegeAssignDealInfoValue[] getAllegeAssignInfo(String condition, Map parameter, int startIndex,
			int endIndex) throws Exception {
		return AllegeAssignDealInfoEngine.getBeans(null, condition, parameter, startIndex, endIndex, false);
	}

	public int countAllegeAssignInfo(String condition, Map parameter) throws Exception {
		return AllegeAssignDealInfoEngine.getBeansCount(condition, parameter);
	}

	public void cancelAllegeAssignDealInfo(IAllegeAssignDealInfoValue[] allegeAssigns) throws Exception {
		AllegeAssignDealInfoEngine.save(allegeAssigns);
	}
	
	public IQBOAllegeAssignQueryInfoValue[] queryAllegeAssignQueryInfos(String condition, Map parameter, int startIndex, int endIndex)
			throws Exception {
		return QBOAllegeAssignQueryInfoEngine.getBeans(null, condition, parameter, startIndex, endIndex, false);
	}
	
	public int countAllegeAssignQueryInfos(String condition, Map parameter) throws Exception{
		return QBOAllegeAssignQueryInfoEngine.getBeansCount(condition, parameter);
	}
}
