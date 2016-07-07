/**
 * 
 */
package ngves.asiainfo.core.common.dao.impl;

import java.util.Map;

import ngves.asiainfo.core.common.bo.CityAreaCodeInfoEngine;
import ngves.asiainfo.core.common.dao.interfaces.ICityAreaCodeInfoDAO;
import ngves.asiainfo.core.common.ivalues.ICityAreaCodeInfoValue;


/**
 * @author asiainfo
 * 
 */
public class CityAreaCodeInfoDAOImpl implements ICityAreaCodeInfoDAO {


	public ICityAreaCodeInfoValue[] getCityAreaCodeInfo(String condition,
			Map<String, Object> parameter) throws Exception {
		return CityAreaCodeInfoEngine.getBeans(condition, parameter);
	}


	public ICityAreaCodeInfoValue getCityAreaCodeInfoById(long cityAreaCodeId)
			throws Exception {
		return CityAreaCodeInfoEngine.getBean(cityAreaCodeId);
	}


	public long saveCityAreaCodeInfoValue(ICityAreaCodeInfoValue value)
			throws Exception {
		long id = value.getCityAreaCodeId();
		if(id != 0){
			CityAreaCodeInfoEngine.save(value);
		}else{
			if(value.isModified()){
				value.setStsToNew();
			}
			value.setCityAreaCodeId(CityAreaCodeInfoEngine.getNewId().longValue());
			CityAreaCodeInfoEngine.save(value);
		}
		return value.getCityAreaCodeId();
		
	}



}
