package ngves.asiainfo.core.theatre.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.common.cache.CacheLoaderTemplate;
import ngves.asiainfo.core.common.util.KeyUtil;
import ngves.asiainfo.util.MemcachedClientUtil;
import ngves.asiainfo.core.theatre.service.interfaces.ITheatreInfoSrv;
import ngves.asiainfo.core.ware.WareConstant;

import com.ai.appframe2.service.ServiceFactory;

public class TheatreUtil {
	
	private static transient Log log = LogFactory.getLog(TheatreUtil.class);
	
	public static void loadTheatreInfoToMemcache() throws Exception{
		//从ware_info_portal表里查出所有国家大剧院的子礼品编码
		List<String> wareCodeList = getWareCodeByWareType(WareConstant.WARE_TYPE_CHILDREN+"");
		for (Iterator<String> iterator = wareCodeList.iterator(); iterator.hasNext();) {
			String wareCode = iterator.next();
			updateTheatreInfo(wareCode);
		}
	}
	/**
	 * 根据ware_info_portal表中的ware_type字段获得ware_code集合
	 * @author zhaoyujie
	 * @CreateDate 2011-11-29 18:00
	 * @param wareType
	 * @return
	 * @throws Exception
	 */
	private static List<String> getWareCodeByWareType(String wareType) throws Exception{
		ITheatreInfoSrv theatreInfoSrv = (ITheatreInfoSrv)ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_THEATREINFO_SRV);
		List<String> wareCodeList = theatreInfoSrv.getWareCodeByWareType(wareType);
		return wareCodeList;
	}
	/**
	 * 将ware_code对应的大剧院子礼品同步到Memcache
	 * @author zhaoyujie
	 * @CreateDate 2011-11-29 18:30
	 * @param wareCode
	 * @return
	 * @throws Exception
	 */
	private static String updateTheatreInfo(String wareCode) throws Exception {
		String theatreSurplusCountKey = KeyUtil.composeKey(CommnConstant.MEMCACHE_THEATRE_SURPLUS_COUNT,wareCode);
		
		//从HP中间表中取数据
		String theatreCount = new TheatreCacheUtil.TheatreCacheLoader().findBeansByKey(theatreSurplusCountKey);
		//更新到Memcache缓存
		MemcachedClientUtil.setObject(theatreSurplusCountKey, theatreCount);
		return theatreCount;
	}
	/**
	 * 根据ware_code取得库存量。先从Memcache缓存中去，如果取不到，再去查询数据库。
	 * @author zhaoyujie
	 * @CreateDate 2011-11-29 18:43
	 * @param wareCode
	 * @return
	 * @throws Exception
	 */
	public static String getTheatreInventory(String wareCode) throws Exception {
		String theatreInventory = "0";
		try {
			theatreInventory = CacheLoaderTemplate.getEntity(CommnConstant.MEMCACHE_THEATRE_SURPLUS_COUNT, wareCode, new TheatreCacheUtil.TheatreCacheLoader());
		} catch (Exception e) {
			log.error("getTheatreInventory is excep by wareCode := " + wareCode, e);
		}
		return theatreInventory;
	}
	/**
	 * 判断场次是否有重复集合数据
	 */
	public static List<String> locationList = null;
	
	public static List<String> getLocationList() {
		locationList =  new ArrayList<String>();
		return locationList;
	}
	
	/**
	 * 根据值查询集合中存在数量
	 * @param locationName
	 * @return 场次数量
	 */
	public static  int findCountByValue(String value){
		int count = 0;
		for (int i = 0; i < locationList.size(); i++) {
			if((""+value).equals(locationList.get(i))){
				count++;
			}
		}
		return count;
	}
	/**
	 * 模拟库存信息
	 */
	static Map<String, String> map = null;
	static {
		map = new HashMap<String, String>();
		map.put("373800", String.valueOf(8));
		map.put("373801", String.valueOf(1));
		map.put("373802", String.valueOf(2));
		map.put("103077", String.valueOf(12));
		map.put("379000", String.valueOf(0));
		map.put("379002", String.valueOf(12));
		map.put("379003", String.valueOf(12));
		map.put("379004", String.valueOf(12));
		map.put("379300", String.valueOf(12));
		map.put("379302", String.valueOf(12));
		
		map.put("370783", String.valueOf(12));
		map.put("370790", String.valueOf(12));
		map.put("370793", String.valueOf(12));
		
		
		
		
		

	}
	/**
	 *返回库存信息数量
	 * 
	 * @param code
	 * @return
	 */
	public static int getKc(String code) {
		if (null != map.get(code)) {
			return Integer.parseInt(map.get(code));
		}
		return 0;
	}
	
}
