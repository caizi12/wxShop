package cn.frame.platform.common.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cn.frame.platform.entitys.CityInfo;
import cn.frame.platform.entitys.CountryInfo;
import cn.frame.platform.entitys.ProvinceInfo;

/**
 * 获取省市区数据
 * @author li
 *
 */
public class ProvinceUtil {
	
	public static List<ProvinceInfo> provinceList=null;
	public static List<CityInfo> cityList=null;
	public static List<CountryInfo> countryList=null;

	//省市区
	private static Map<String,String> provinceMap=null;
	private static Map<String,String> cityMap=null;
	private static Map<String,String> countryMap=null;
	
	public static Map<String, String> getProvinceMap() {
		if(provinceMap==null){
			initProvinceMap();
		}
		return provinceMap;
	}

	public static Map<String, String> getCityMap() {
		if(cityMap==null){
			initCityMap();
		}
		return cityMap;
	}


	public static Map<String, String> getCountryMap() {
		if(countryMap==null){
			initCountryMap();
		}
		return countryMap;
	}


	public static String getProvinceName(String provinceCode){
		if(provinceMap==null){
			initProvinceMap();
		}
		return provinceMap.get(provinceCode);
	}
	
	public  static String getCityName(String cityCode){
		if(cityMap==null){
			initCityMap();
		}
		return cityMap.get(cityCode);
	}
	
	public static  String getCountryName(String countryCode){
		if(countryMap==null){
			initCountryMap();
		}
		return countryMap.get(countryCode);
	}
	
	public static void initProvinceMap(){
		provinceMap=new HashMap<String,String>();
		for(ProvinceInfo info:provinceList){
			provinceMap.put(info.getProvinceCode(), info.getProvinceName());
		}
	}
	
	public static void initCityMap(){
		cityMap=new HashMap<String,String>();
		for(CityInfo info:cityList){
			cityMap.put(info.getCityCode(), info.getCityName());
		}
	}
	
	public static void initCountryMap(){
		countryMap=new HashMap<String,String>();
		for(CountryInfo info:countryList){
			countryMap.put(info.getCountyCode(), info.getCountyName());
		}
	}
}
