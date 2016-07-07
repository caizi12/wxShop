package ngves.asiainfo.core.viphall.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.common.cache.CacheLoaderTemplate;
import ngves.asiainfo.util.MemcachedClientUtil;
import ngves.asiainfo.core.common.util.WareTypeCodeEnum;
import ngves.asiainfo.core.viphall.ivalues.IQBOVipHallTopicInfoValue;
import ngves.asiainfo.core.viphall.ivalues.IQBOVipHallWareInfoValue;
import ngves.asiainfo.core.viphall.ivalues.IQBOVipWareDescValue;
import ngves.asiainfo.core.viphall.ivalues.IVipHallCountValue;
import ngves.asiainfo.core.viphall.model.VipHallWareInfoVO;
import ngves.asiainfo.core.viphall.service.interfaces.IVipHallTopicSrv;
import ngves.asiainfo.core.ware.ivalues.IWareInfoParentValue;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.StringUtil;

import com.ai.appframe2.service.ServiceFactory;

/**
 * 全国VIP贵宾厅工具类添加
 * @author shenfl 2013-2-26
 */
public class VipHallUtil {

	private static final Log logger = LogFactory.getLog(VipHallUtil.class);
	/**
	 * 判断是否允许兑换或者兑换截止日期是否到
	 * 
	 * @param isOnline
	 *            父礼品状态
	 * @param sfyxdh
	 *            是否允许兑换 999999999999951
	 * @param dhzzrq
	 *            兑换截止日期
	 * @return　true 截止日期大于或者等于当前日期
	 * 			false截止日期小于当前日期或者允许兑换为否或者
	 * @throws Exception
	 */
	public static boolean validateVipIsExchange(String isOnline, String sfyxdh, String dhzzrq) throws Exception {
		// 默认不允许兑换
		boolean xsdhan = false;
		if ("1".equals(isOnline) && "1".equals(sfyxdh)&&!StringUtil.isBlank(dhzzrq)) {
			dhzzrq = dhzzrq + " 23:59:59";
			int result = DateTimeUtil.compareDate(dhzzrq);
			if (result == 1) {
				xsdhan = true;
			}
		}
		return xsdhan;
	}

	/**
	 * 判断是否允许兑换或者兑换截止日期是否到
	 * 
	 * @param wareId
	 *            父礼品ID或者父子礼品关系的子礼品
	 * @return
	 * @throws Exception
	 */
	public static boolean validateVipIsExchange(String wareId) throws Exception {
		boolean vipIsExchange = false;//默认不允许兑换
		long pid = getPartentID(wareId);
		IQBOVipWareDescValue[] values = null;
		if (pid != 0) {//VIP
			String sfyxdh = "";// 是否允许兑换
			String dhzzrq = "";// 兑换截止日期
			String isOnline = "";// 父礼品状态
			IVipHallTopicSrv service = (IVipHallTopicSrv) ServiceFactory
					.getService(CoreSrvContstant.VIP_HALL_TOPIC_SERVICE);
			values = service.queryVipWareDesc(new Long(pid));
			if (values != null && values.length > 0) {
				for (IQBOVipWareDescValue value : values) {
					
					isOnline = value.getIsOnline();
					if (CoreConstant.VIP_IFYXDH_CONST.equals(value.getDescDefineId()+"")) {
						sfyxdh = value.getWareDescValue();
					} 
					if (CoreConstant.VIP_DHJZRQ_CONST.equals(value.getDescDefineId()+"")) {
						dhzzrq = value.getWareDescValue();
					}
				}
				//true为允许兑换
				vipIsExchange = validateVipIsExchange(isOnline, sfyxdh, dhzzrq);
			}
		}else{
			//普通礼品，设置为允许兑换礼品和其他的父子关系的礼品
			vipIsExchange = true;
		}
		return vipIsExchange;
	}

	/**
	 * 判断当前礼品是否为VIP贵宾厅的VIP
	 * 父子关系礼品 1 。如果该礼品是父子关系的礼品，返回父礼品ID 2。
	 * 否则，返回 0（非VIP贵宾厅礼品和普通的礼品）
	 * 
	 * @param wareId
	 *            父礼品ID或者子礼品ID
	 * 
	 * @return
	 * @throws Exception
	 */
	public static long  getPartentID(String wareId) throws Exception {
		long pid = 0;
		// 验证当前礼品是否为父礼品
		IVipHallTopicSrv vipHallTopicService = (IVipHallTopicSrv) ServiceFactory
			.getService(CoreSrvContstant.VIP_HALL_TOPIC_SERVICE);
		IWareInfoParentValue wip = vipHallTopicService.getWareInfoParent(wareId);
		// 验证当前礼品是否为父子关系的礼品
		if (wip != null&&(WareTypeCodeEnum.AirportVipRoom.getValue()==(int)wip.getTypeCode()||
				WareTypeCodeEnum.TrainVipHall.getValue()==(int)wip.getTypeCode())) {
			pid = wip.getWareId();
		} else {
			long pId = 0;
			pId = vipHallTopicService.findChildWareIdParentId(wareId);// //根据子礼品Id获取父礼品ID
			wip = vipHallTopicService.getWareInfoParent(pId + "");// 根据父礼品ID获取对应的信息
			// 是父子关系的礼品
			if (wip != null&&(WareTypeCodeEnum.AirportVipRoom.getValue()==(int)wip.getTypeCode()||
					WareTypeCodeEnum.TrainVipHall.getValue()==(int)wip.getTypeCode())) {
				pid = wip.getWareId();
			}
		}
		return pid;
	}

	/**
	 * 获取专题页面礼品展示列表
	 * 
	 * @param wareKindId
	 * @param province
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public static List<VipHallWareInfoVO> getVipHallWareInfo(long wareKindId, String province, int startNum, int endNum) {
		
		List<VipHallWareInfoVO> vipHallWare = new ArrayList<VipHallWareInfoVO>();

		try {
			IVipHallTopicSrv service = (IVipHallTopicSrv) ServiceFactory
					.getService(CoreSrvContstant.VIP_HALL_TOPIC_SERVICE);
			IQBOVipHallWareInfoValue[] vipHallWareInfo = service.queryVipHallWareInfo(wareKindId, province, startNum,
					endNum);

			if (vipHallWareInfo != null && vipHallWareInfo.length > 0) {
				logger.info("vipHallWareInfo size =>" + vipHallWareInfo.length);
				VipHallWareInfoVO vipHallWareInfoVO = null;
				for (IQBOVipHallWareInfoValue value : vipHallWareInfo) {
					value.setWareKindId(wareKindId);
					logger.info("getVipHallWareInfo=>>>cityCode=" + (value != null ? value.getCityCode(): "") 
							 + ",cityName=" + (value != null ? value.getCityName(): "" )
							 + ",wareId=" + (value != null ? value.getWareId(): "") 
						     + ",wareKindId=" +( value != null ? value.getWareKindId() : "")
						     + ",fileName="+(value!=null?value.getFileName():"")
						     + ",isOnline="+ (value!=null?value.getIsOnline():"")
						     + ",descDefineWareValue=" + (value!=null?value.getDescDefineWareValue():"")
						     +" ,wareDisValue=" + (value!=null?value.getWareDisValue():"")	 
							 + ",provCode=" + (value!=null?value.getProvCode():""));
					vipHallWareInfoVO = new VipHallWareInfoVO();
					BeanUtilities.copyVipHallInfo(value, vipHallWareInfoVO);
					vipHallWare.add(vipHallWareInfoVO);
				}
			}
			if(vipHallWare!=null && vipHallWare.size()>0){
				logger.info("vipHallWare.size()=>>" + vipHallWare.size());
			}
		} catch (Exception e) {
			logger.warn("getVipHallWareInfo is exception....", e);
		}
		return vipHallWare;
	}

	/**
	 * 
	 * @param vipProvinceKeySet
	 *            省份列表
	 * @return 省份和当前省份数量对应关系
	 */
	public static Map<String, Object> getProvMap(long wareKindId, String province) throws Exception {
		Map<String, Object> vipHallCountMap = new HashMap<String, Object>();
		Map<String, String> provMap = new TreeMap<String, String>();
		String vipHallCount = "";
		IVipHallTopicSrv service = (IVipHallTopicSrv) ServiceFactory
				.getService(CoreSrvContstant.VIP_HALL_TOPIC_SERVICE);
		IVipHallCountValue viphallCountInfo = service.queryViphallCountInfo(wareKindId);
		if (!viphallCountInfo.isNew()) {
			String provCodeCount = viphallCountInfo.getProvcodeCount();
			String[] split = provCodeCount.split(CoreConstant.KEY_LT_SPLIT);
			if (split != null && split.length > 0)
				for (String provinceInfo : split) {
					String[] split2 = provinceInfo.split(CoreConstant.KEY_COLON_SPLIT);
					if (split2 != null && split2.length == 2) {
						String key = split2[0];
						String value = split2[1];
						provMap.put(key, value);
					}
				}
		}
		if ("showAll".equals(province)) {
			vipHallCount = viphallCountInfo.getKindTotalCount() + "";
		} else {
			vipHallCount = provMap.get(province);
		}
		vipHallCountMap.put("provMap", provMap);
		vipHallCountMap.put("vipHallCount", StringUtil.isBlank(vipHallCount) ? 0 : new Integer(vipHallCount));
		return vipHallCountMap;
	}

	/**
	 * 加载当前专题信息到Memcached中-管理平台
	 * 
	 * @param wareKindId
	 * @return
	 * @throws Exception
	 */
	public static void loadVipHallTopic() throws Exception {
		IVipHallTopicSrv service = (IVipHallTopicSrv) ServiceFactory
				.getService(CoreSrvContstant.VIP_HALL_TOPIC_SERVICE);
		IQBOVipHallTopicInfoValue[] values = service.queryVipHallTopicInfo();
		MemcachedClientUtil.setObject(CommnConstant.MEMCACHE_VIP_HALL_TOPIC, values);
	}
	/**
	 * 从Memcached中加载当前专题信息-门户调用
	 * 
	 * @param wareKindId
	 * @return
	 * @throws Exception
	 */
	public static IQBOVipHallTopicInfoValue[] getVipHallTopic() throws Exception {
		IQBOVipHallTopicInfoValue[] memcachedVipHall = null;
		memcachedVipHall = CacheLoaderTemplate.getEntity(CommnConstant.MEMCACHE_VIP_HALL_TOPIC,
				new VipHallCacheUtil.VipHallTopicCacheLoader());
		return memcachedVipHall;
	}
	
	/**
	 * 根据礼品的数值获取礼品的
	 * 
	 * @param wareDescValue
	 * @return
	 */
	public static String getWareDescName(int wareDescValue) {
		String wareDescName = "";
		switch (wareDescValue) {
		case 1:
			wareDescName = "免费茶点";
			break;
		case 2:
			wareDescName = "报刊阅览";
			break;
		case 4:
			wareDescName = "航班信息查询";
			break;
		case 5:
			wareDescName = "基本移动业务办理";
			break;
		case 6:
			wareDescName = "跨区移动业务办理";
			break;
		case 7:
			wareDescName = "移动新业务展示";
			break;
		case 8:
			wareDescName = "手机自助充电服务";
			break;
		case 9:
			wareDescName = "WLAN或手机上网";
			break;
		case 10:
			wareDescName = "业务宣传资料阅览";
			break;
		default:
			break;
		}
		return wareDescName;
	}

	/**
	 * 转换为中文
	 * @param value
	 * @return
	 */
	public static String getChinaWord(String value){
		String result = "";
		if(!StringUtil.isBlank(value)){
			if("1".equals(value)){
				result ="是";
			}else{
				result ="否";
			}
		}
		return result;
	}
	
}
