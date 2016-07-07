package cn.frame.platform.sys.province.service;

import java.util.List;
import java.util.Map;

import cn.frame.platform.entitys.CityInfo;
import cn.frame.platform.entitys.CountryInfo;
import cn.frame.platform.entitys.ProvinceInfo;

public interface ProvinceCityCountrySrv {
	
	public ProvinceInfo getProvinceInfo(Map<String,String> paraMap) ;
	 
	/**
	 * 查询省份信息
	 */
	public List<ProvinceInfo> queryProvinceInfo(Map<String,String> paraMap) ;
 
	/**
	 * 查询市区
	 * 
	 * @param paraMap
	 * @return
	 */
	public CityInfo getCityInfo(Map<String,String>  paraMap) ;
 
	/**
	 * 查询市区信息
	 */
	public List<CityInfo> queryCityInfo(Map<String,String>  paraMap) ;
 

	/**
	 * 查询区县
	 * 
	 * @param paraMap
	 * @return
	 */
	public CountryInfo getCountryInfo(Map<String,String>  paraMap) ;

	/**
	 * 查询查询区县信息
	 */
	@SuppressWarnings("unchecked")
	public List<CountryInfo> queryCountryInfo(Map<String,String>  paraMap);


}