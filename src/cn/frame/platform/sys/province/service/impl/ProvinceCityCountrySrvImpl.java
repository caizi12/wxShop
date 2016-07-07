package cn.frame.platform.sys.province.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.frame.platform.common.base.BaseDaoTemplate;
import cn.frame.platform.common.util.ProvinceUtil;
import cn.frame.platform.entitys.CityInfo;
import cn.frame.platform.entitys.CountryInfo;
import cn.frame.platform.entitys.ProvinceInfo;
import cn.frame.platform.sys.province.service.ProvinceCityCountrySrv;

/**
 * 省市区信息查询
 * @author li
 *
 */
@Service("provinceCityCountrySrv")
public class ProvinceCityCountrySrvImpl implements ProvinceCityCountrySrv {
	
	@Autowired
	public BaseDaoTemplate baseDao;
	
	/**
	 * 初始化省市区数据
	 */
	@SuppressWarnings("unused")
	private void init(){
		Map<String,String> paraMap=new HashMap<String,String>();
		ProvinceUtil.provinceList = queryProvinceInfo(paraMap);
		ProvinceUtil.cityList= queryCityInfo(paraMap);
		ProvinceUtil.countryList= queryCountryInfo(paraMap);
	}
	
	/**
	 * 查询省份
	 * 
	 * @param ProvinceInfo
	 * @return
	 */
	public ProvinceInfo getProvinceInfo(Map<String,String>  paraMap) {
		return (ProvinceInfo) baseDao.getIbatisTemplate().queryForObject("getProvinceInfo", paraMap);
	}


	/**
	 * 查询省份信息
	 */
	@SuppressWarnings("unchecked")
	public List<ProvinceInfo> queryProvinceInfo(Map<String,String>  paraMap) {
		return  baseDao.getIbatisTemplate().queryForList("queryProvinceInfo", paraMap);
	}
	
	/**
	 * 查询市区
	 * 
	 * @param CityInfo
	 * @return
	 */
	public CityInfo getCityInfo(Map<String,String>  paraMap) {
		return   (CityInfo) baseDao.getIbatisTemplate().queryForObject("getCityInfo", paraMap);
	}


	/**
	 * 查询市区信息
	 */
	@SuppressWarnings("unchecked")
	public List<CityInfo> queryCityInfo(Map paraMap) {
		return  baseDao.getIbatisTemplate().queryForList("queryCityInfo", paraMap);
	}

	/**
	 * 查询区县
	 * 
	 * @param CityInfo
	 * @return
	 */
	public CountryInfo getCountryInfo(Map<String,String>  paraMap) {
		return (CountryInfo) baseDao.getIbatisTemplate().queryForObject("getCountryInfo", paraMap);
	}


	/**
	 * 查询查询区县信息
	 */
	@SuppressWarnings("unchecked")
	public List<CountryInfo> queryCountryInfo(Map paraMap) {
		return  baseDao.getIbatisTemplate().queryForList("queryCountryInfo", paraMap);
	}
}