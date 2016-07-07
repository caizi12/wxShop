/**
 * 
 */
package ngves.asiainfo.core.common.service.interfaces;

import ngves.asiainfo.core.common.dao.interfaces.ICityAreaCodeInfoDAO;
import ngves.asiainfo.core.common.ivalues.ICityAreaCodeInfoValue;

/**
 * @author asiainfo
 * 
 */
public interface ICityAreaCodeInfoSrv {

	public void setCityAreaCodeInfoDAO(ICityAreaCodeInfoDAO cityAreaCodeInfoDAO) throws Exception;

	/**
	 * 根据省份代码获取其下所有城市区号对象
	 * @param infoType
	 * @param infoId
	 * @throws Exception
	 */

	public ICityAreaCodeInfoValue[] getCityAreaValueByProCode(String provinceCode) throws Exception;
	

	/**
	 * 根据城市区号获取城市区号对象
	 * @param provinceCode
	 * @return
	 * @throws Exception
	 */
	public ICityAreaCodeInfoValue getCityAreaValueByCityCode(String cityAreaCode) throws Exception;
	
	/**
	 * 保存对象信息
	 * @param value
	 * @throws Exception
	 */
	public long saveCityAreaCodeInfoValue(ICityAreaCodeInfoValue value) throws Exception;

	/**
	 * 根据主键获取对象
	 * @param warePicSynId
	 * @return
	 * @throws Exception
	 */
    public ICityAreaCodeInfoValue getCityAreaCodeInfoById(long cityAreaCodeId) throws Exception;
	
}
