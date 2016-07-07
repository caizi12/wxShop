package ngves.asiainfo.core.common.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ngves.asiainfo.core.common.dao.interfaces.ICityAreaCodeInfoDAO;
import ngves.asiainfo.core.common.ivalues.ICityAreaCodeInfoValue;
import ngves.asiainfo.core.common.service.interfaces.ICityAreaCodeInfoSrv;

public class CityAreaCodeInfoSrvImpl implements ICityAreaCodeInfoSrv {

	private static transient Log log = LogFactory.getLog(CityAreaCodeInfoSrvImpl.class);
    private ICityAreaCodeInfoDAO cityAreaCodeInfoDAO;
    
	public void setCityAreaCodeInfoDAO(ICityAreaCodeInfoDAO cityAreaCodeInfoDAO)
		throws Exception {
		this.cityAreaCodeInfoDAO = cityAreaCodeInfoDAO;
	
	}
	
	
	
	public ICityAreaCodeInfoValue getCityAreaValueByCityCode(String cityAreaCode)
			throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
		ICityAreaCodeInfoValue[] values = null;
		condition.append(" AND ").append(ICityAreaCodeInfoValue.S_CityAreaCode)
					.append("='").append(cityAreaCode).append("' ");
		condition.append(" ORDER BY ").append(ICityAreaCodeInfoValue.S_CityAreaCode);
		values = cityAreaCodeInfoDAO.getCityAreaCodeInfo(condition.toString(), null);
		
		log.info("The method getCityAreaValueByCityCode is running...");
		if(null!=values && 0< values.length){
			return values[0];
		}else{
			return null;
		}
	}
	

	public ICityAreaCodeInfoValue[] getCityAreaValueByProCode(String provinceCode) throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
		
		condition.append(" AND ").append(ICityAreaCodeInfoValue.S_ProvinceCode)
			.append("='").append(provinceCode).append("' ");
		condition.append(" ORDER BY ").append(ICityAreaCodeInfoValue.S_CityAreaCode);
		log.info("The method getWarePicSynValue is running...");
		return cityAreaCodeInfoDAO.getCityAreaCodeInfo(condition.toString(), null);
	}

	public ICityAreaCodeInfoValue getCityAreaCodeInfoById(long cityAreaCodeId)
			throws Exception {
		return cityAreaCodeInfoDAO.getCityAreaCodeInfoById(cityAreaCodeId);
	}


	public long saveCityAreaCodeInfoValue(ICityAreaCodeInfoValue value)
			throws Exception {
		return cityAreaCodeInfoDAO.saveCityAreaCodeInfoValue(value);
	}




	


}
