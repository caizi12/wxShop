/**
 * Copyright (c) 2012 asiainfo-linkage.com
 */
package ngves.asiainfo.core.ware.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.common.cache.CacheLoaderTemplate;
import ngves.asiainfo.core.ware.WareParamConstant;
import ngves.asiainfo.core.ware.bo.QBOPermissionWareBean;
import ngves.asiainfo.core.ware.ivalues.IPermissionTypeInfoValue;
import ngves.asiainfo.core.ware.ivalues.IQBOPermissionWareValue;
import ngves.asiainfo.core.ware.model.PermissionWare;
import ngves.asiainfo.core.ware.model.PermissionWareBean;
import ngves.asiainfo.core.ware.model.PermissionWareRule;
import ngves.asiainfo.core.ware.model.PermissionWareRuleVo;
import ngves.asiainfo.core.ware.service.interfaces.IWareInfoSrv;
import ngves.asiainfo.util.PropertyReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;

/**
 * 
 * <p>
 * 显示兑换成功后优惠礼品的列表
 * </p>
 * <p>
 * 格式： 您还可以优惠兑换以下礼品，点击礼品名称或URL地址进入礼品详情页： 礼品名称 礼品URL地址
 * </p>
 * 
 * @author shenfl
 * @date 2012-07-30
 */
public class PermissionWareViewUtil {

	private static transient Log logger = LogFactory.getLog(PermissionWareViewUtil.class);

	
	/**
	 * wap和web公共方法（成功提示页面）
	 * 
	 * @param wareIds
	 * @param userMobileBrand
	 * @param userLocalProvince
	 * @param channel
	 * @return
	 * @throws Exception
	 */
	public static List<PermissionWare> getPermissionHtml(String wareIds, String userMobileBrand, String userLocalProvince,
			String channel,String yhFlag) throws Exception {
		//String result = "";
		
		logger.info("wareIds = "+wareIds + ",yhFlag = " + yhFlag + ",channel= " + channel + ",userLocalProvince = " + userLocalProvince + ",userMobileBrand = " + userMobileBrand);
		String[] wareIdArray = wareIds.split(",");
		//存放门户显示优惠礼品,该对象为内部变量
		List<PermissionWare>  permissionWareList = new ArrayList<PermissionWare>() ;
		List<PermissionWare>  temWareList = null;
		try{
			List<PermissionWareRuleVo> permissionWareRuleVoList = getWareRule(channel);
			for (String wareId : wareIdArray) {
				if ("1".equals(yhFlag)) {//1 表示当前礼品优惠
					logger.info("wareId = 【" + wareId +"】 is permission's ware,permission's ware list no data!");
					break;
				}
				if (permissionWareRuleVoList != null && permissionWareRuleVoList.size() > 0) {
					for (PermissionWareRuleVo permissionWareRuleVo : permissionWareRuleVoList) {
						PermissionWareRule permissionWareRule = permissionWareRuleVo.getPermissionWareRule();
						PermissionWareBean value = permissionWareRule.getPermissionWareBaseRule();// 取得基本规则
						boolean isExistpCode = false; // 是否存在省份
						boolean isEqual = false; // 归属省和规则对应的省份是否一致
						recordLog(wareId, value, userLocalProvince, userMobileBrand, channel);
						//目前优惠推荐只支持 WEB渠道、WAP渠道、触屏版渠道
						if(value != null && value.getSupportMobileBrand().contains(userMobileBrand) &&
								(value.getExchangeChannel().contains(WareParamConstant.EXCHANGE_TYPE_WAP) &&
										 WareParamConstant.IS_WAP_CHANNEL.equals(channel)) ||
								(value.getExchangeChannel().contains(WareParamConstant.EXCHANGE_TYPE_WEB) &&
										 WareParamConstant.IS_HTML_CHANNEL.equals(channel)) ||
								(value.getExchangeChannel().contains(WareParamConstant.EXCHANGE_TYPE_MOBILE) &&
										 WareParamConstant.IS_MOBILE_CHANNEL.equals(channel))   ){	
							
							List<String> provCodeList = permissionWareRule.getPermissionWareRuleProvs();
							if (provCodeList != null && provCodeList.size() > 0) {
								isExistpCode = true;
								if (provCodeList.contains(userLocalProvince))
									isEqual = true;
							}
							logger.info("channel = 【" + channel + "】,isEqual = 【" + isEqual + "】,isExsitpCode = 【" + isEqual + "】");
							if (isExistpCode && !isEqual){
								continue;
							}
							
							temWareList = transToPermissionWare(value.getItemScope(), permissionWareRule, wareId,permissionWareRuleVo);
							 if (temWareList != null && temWareList.size() > 0) {
								 permissionWareList.addAll(temWareList);
							} 
							logger.info("each permissionId = 【" +value.getPermissionId()+"】,order success show permissionWareList(size) =【" +permissionWareList.size()+"】record");
						}
					}
				}
			}
		} catch (Exception e) {
			logger.warn(" getPermissionHtml is Exception ", e);
			throw e;
		}
		return permissionWareList;
	}


	/**
	 * 获取有效礼品的列表
	 * 
	 * @param itemScope
	 * @param permissionWareRule
	 * @param wareId
	 * @param permissionWareRuleVo
	 * @return
	 */
	private static List<PermissionWare> transToPermissionWare(String itemScope, PermissionWareRule permissionWareRule,
			String wareId, PermissionWareRuleVo permissionWareRuleVo) {
		boolean isExistWareIdList = false;
		List<PermissionWare> permissionWareList = new ArrayList<PermissionWare>();
		if (CoreConstant.INTER_ITEM_SCOPE_MX.equals(itemScope)) {
			List<String> permissionWareTypeCodes = permissionWareRule.getPermissionWareTypeCodes();
			if (permissionWareTypeCodes != null && permissionWareTypeCodes.size() > 0
					&& permissionWareTypeCodes.contains(wareId)) {
				isExistWareIdList = true;
			}
			
		}
		logger.info( "itemScope = " +itemScope + ",wareId=" + wareId + ",if itemScope = '01' then isExistWareIdList=" + isExistWareIdList);
		if (isExistWareIdList || CoreConstant.INTER_ITEM_SCOPE_ALL.equals(itemScope)) {
			permissionWareList = permissionWareRuleVo.getPermissionWareList();
		}
		logger.info("permissionWareList.size()=" + permissionWareList.size());
		return permissionWareList;
	}

	/**
	 * @param wareId
	 * @param value
	 * @param userLocalProvince
	 * @param userMobileBrand
	 */
	private static void recordLog(String wareId, PermissionWareBean value, String userLocalProvince,
			String userMobileBrand, String channel) {
		logger.info("current user's exchange wareId=" + wareId + ",current permissionId = " + value.getPermissionId()
				+ ",current user's Channel = " + channel + ",permissionWare rule's supportChannel = "
				+ value.getExchangeChannel() + ",supportMobileBrand = " + value.getSupportMobileBrand()
				+ ",userMobileBrand = " + userMobileBrand + ",itemScope=" + value.getItemScope()
				+ ",userLocalProvince = " + userLocalProvince);
	}

	/**
	 *获取wap兑换成功提示信息列表
	 * 
	 * @param wareIds
	 * @param channel
	 * @param userMobileBrand
	 * @param userLocalProvince
	 * @return
	 * @throws Exception
	 */
	public static String getWapSuccessRemindHtml(String wareIds, String userMobileBrand, String userLocalProvince,
			String channel,String wapVersion,String yhFlag)
			throws Exception {
		// 存放门户显示优惠礼品
		Map<Long, String> wareMap = new TreeMap<Long, String>();
		String[] wareIdArray = wareIds.split(",");
		List<PermissionWareRuleVo> permissionWareRuleVoList = getWareRule(channel);
		for (String wareId : wareIdArray) {
			if ("1".equals(yhFlag)) {//1 表示当前礼品是优惠兑换
				logger.info("wareId = " + wareId +" is permission's ware,permission's ware list no data!");
				break;
			}
			if (permissionWareRuleVoList != null && permissionWareRuleVoList.size() > 0) {
				for (PermissionWareRuleVo permissionWareRuleVo : permissionWareRuleVoList) {
					PermissionWareRule permissionWareRule = permissionWareRuleVo.getPermissionWareRule();
					PermissionWareBean value = permissionWareRule.getPermissionWareBaseRule();// 取得基本规则
					boolean isExistpCode = false; // 是否存在省份
					boolean isEqual = false; // 归属省和规则对应的省份是否一致
					recordLog(wareId, value, userLocalProvince, userMobileBrand, channel);
					if (value != null && WareParamConstant.IS_WAP_CHANNEL.equals(channel)
							&& value.getExchangeChannel().contains(WareParamConstant.EXCHANGE_TYPE_WAP)
							&& value.getSupportMobileBrand().contains(userMobileBrand)) {
						List<String> provCodeList = permissionWareRule.getPermissionWareRuleProvs();
						if (provCodeList != null && provCodeList.size() > 0) {
							isExistpCode = true;
							if (provCodeList.contains(userLocalProvince))
								isEqual = true;
						}
						logger.info("channel = " + channel + ",isEqual = " + isEqual + ",isExsitpCode = " + isEqual);
						if (isExistpCode && !isEqual)
							continue;
						
						List<PermissionWare>  permissionWareList = transToPermissionWare(value.getItemScope(), permissionWareRule, wareId,
								permissionWareRuleVo);
						//tranPermissionWareListToMap(permissionWareList);
						if (permissionWareList != null && permissionWareList.size() > 0) {
							for (PermissionWare permissionWare : permissionWareList) {
								//WAP平台只推荐支持全积分的优惠礼品
								if(permissionWare.getPayType().contains("01")){
									wareMap.put(permissionWare.getWareId(), permissionWare.getWareName());
								}
							}
						}
						logger.info("each permissionId = [" +value.getPermissionId()+"]+,order success show permissionWareList(size) =[" +wareMap.size()+"]record");
					}
				}
			}
		}
		logger.info("wareList = [" + wareMap.size() + "]record");
		return getWapCurrentRuleHtml(wareMap,wapVersion);
	}

	@SuppressWarnings("unchecked")
	private static String getWapCurrentRuleHtml(Map wareMap,String wapVersion) {
		String currentRuleHtml = "";
		//--如果取到了优惠礼品，逐个获取其url------
		if (wareMap != null && wareMap.size() > 0) {
			String preUrl = "";
			if(wapVersion.equals(CoreConstant.VERSION_WAP)){
				preUrl = CoreConstant.WARE_ID_0_JIFEN_WAP_URL;
			}
			else if(wapVersion.equals(CoreConstant.VERSION_WAP_M)){
				preUrl = CoreConstant.WARE_ID_0_JIFEN_WAP_M_URL;
			}
			else if(wapVersion.equals(CoreConstant.VERSION_WAP_N)){
				preUrl = CoreConstant.WARE_ID_0_JIFEN_WAP_N_URL;
			}
			else {
				return currentRuleHtml;
			}
			for (Iterator it = wareMap.entrySet().iterator(); it.hasNext();) {
				Map.Entry<Long, String> entry = (Map.Entry<Long, String>) it.next();
				String wareIdUrl = PropertyReader.getProperty(preUrl) + "/ware/detail.jsp?wareId="
						+ entry.getKey();
				currentRuleHtml += " &nbsp;&nbsp;&nbsp;&nbsp;<a href=\"" + wareIdUrl
						+ "\" target=\"_blank\"><font color=\"red\">" + entry.getValue() + "</font></a><br/>";
			}
		}
		return currentRuleHtml;	
	}


	public static List<PermissionWare> getWareInfoList(long permissionId, String channel) throws Exception {
		// 取得前台门户的信息
		IWareInfoSrv wareInfoSrv = (IWareInfoSrv) ServiceFactory
				.getService(CoreSrvContstant.SERVICE_WARE_INFO);
		return wareInfoSrv.getPermissionWareList(permissionId, channel);
	}

	public static Map<String, List<String>> getAllRuleTypeCodes(IQBOPermissionWareValue value, String channel)
			throws Exception {
		// 取得前台门户的信息
		IWareInfoSrv wareInfoSrv = (IWareInfoSrv) ServiceFactory
				.getService(CoreSrvContstant.SERVICE_WARE_INFO);
		Map<String, List<String>> typeMap = new HashMap<String, List<String>>();// 存放省份编码和类别wareId
		IPermissionTypeInfoValue[] ptInfos = wareInfoSrv.getPermissionTypeInfos(value.getPermissionId(), null);
		List<String> provCodeList = null;
		List<String> partnerCodeList = null;
		List<String> wareKindCodeList = null;
		List<String> wareCodeList = null;
		List<String> typeCode = null;
		if (ptInfos != null && ptInfos.length > 0) {
			provCodeList = new ArrayList<String>();
			partnerCodeList = new ArrayList<String>();
			wareKindCodeList = new ArrayList<String>();
			wareCodeList = new ArrayList<String>();
			for (IPermissionTypeInfoValue ptInfo : ptInfos) {
				if (CoreConstant.PERMISSION_CODE_PROV_CODE.equals(ptInfo.getPermissionName())) {
					// 获取省份列表
					provCodeList.add(ptInfo.getPermissionCode());
				} else if (CoreConstant.PERMISSION_CODE_KIND_CODE.equals(ptInfo.getPermissionName())) {
					// 00--礼品所属礼品小类
					wareKindCodeList.add(ptInfo.getPermissionCode());
				} else if (CoreConstant.PERMISSION_CODE_PARTNER_CODE.equals(ptInfo.getPermissionName())) {
					// 01--礼品所属合作商
					partnerCodeList.add(ptInfo.getPermissionCode());
				} else if (CoreConstant.PERMISSION_CODE_WARE_CODE.equals(ptInfo.getPermissionName())) {
					// 02--特殊礼品设置
					wareCodeList.add(ptInfo.getPermissionCode());
				}
			}
			typeCode = wareInfoSrv.getWareInfoPortalByPermissionId(partnerCodeList, wareKindCodeList, wareCodeList,
					channel);
		}
		typeMap.put(CoreConstant.PROVINCE_TYPE_CODE, provCodeList);
		typeMap.put(CoreConstant.PARTNER_KIND_WARE_TYPE_CODE, typeCode);
		return typeMap;
	}

	/**
	 * 转为所有有效规则
	 * 
	 * @param allPermissionInfos
	 * @return
	 * @throws Exception
	 */
	public static Map<Long, IQBOPermissionWareValue> filterRuleFromRules(IQBOPermissionWareValue[] allPermissionInfos)
			throws Exception {

		Map<Long, IQBOPermissionWareValue> allRulesMap = new HashMap<Long, IQBOPermissionWareValue>();
		IQBOPermissionWareValue ruleBean = null;
		if (allPermissionInfos != null && allPermissionInfos.length > 0) {
			for (IQBOPermissionWareValue value : allPermissionInfos) {

				ruleBean = new QBOPermissionWareBean();
				ruleBean.setPermissionId(value.getPermissionId());
				ruleBean.setPermissionName(value.getPermissionName());
				ruleBean.setOptType(value.getOptType());
				ruleBean.setExchangeChannel(value.getExchangeChannel());
				ruleBean.setSupportType(value.getSupportType());
				ruleBean.setOrderStatus(value.getOrderStatus());
				ruleBean.setItemScope(value.getItemScope());
				ruleBean.setOrderNum(value.getOrderNum());
				ruleBean.setOrderStartTime(value.getOrderStartTime());
				ruleBean.setOrderEndTime(value.getOrderEndTime());
				ruleBean.setCretaeTime(value.getCretaeTime());
				ruleBean.setMobileBrandCode(value.getMobileBrandCode());
				ruleBean.setWareGmeValue(value.getWareGmeValue());
				allRulesMap.put(value.getPermissionId(), ruleBean);
			}
		}
		return allRulesMap;
	}
	
	@SuppressWarnings("unchecked")
	public static String getCurrentRuleHtml(Map wareMap) throws Exception {
		String currentRuleHtml = "";
		if (wareMap != null && wareMap.size() > 0) {
			for (Iterator it = wareMap.entrySet().iterator(); it.hasNext();) {
				Map.Entry<Long, String> entry = (Map.Entry<Long, String>) it.next();
				String wareIdUrl = PropertyReader.getProperty(CoreConstant.WARE_ID_0_JIFEN_URL) + "/ware/"
						+ entry.getKey() + ".html";
				currentRuleHtml += " &nbsp;&nbsp;&nbsp;&nbsp;<a href=\"" + wareIdUrl
						+ "\" target=\"_blank\"><font color=\"red\">" + entry.getValue() + "</font></a><br/>";
			}
		}
		return currentRuleHtml;
	}
	
	// 当前礼品是否为优惠礼品
	public static boolean isPermissionWare(String wareId) throws Exception {
		// 取得前台门户的信息
		IWareInfoSrv wareInfoSrv = (IWareInfoSrv) ServiceFactory
				.getService(CoreSrvContstant.SERVICE_WARE_INFO);
		return wareInfoSrv.isPermissionWare(new Long(wareId));
	}


	// 取得所有正在进行中的优惠规则
	public static IQBOPermissionWareValue[] getAllPermissionInfo(String channel) throws Exception {
		// 取得前台门户的信息
		IWareInfoSrv wareInfoSrv = (IWareInfoSrv) ServiceFactory
				.getService(CoreSrvContstant.SERVICE_WARE_INFO);
		IQBOPermissionWareValue[] values = wareInfoSrv.getAllPermissionWare(channel);
		return values;
	}

	// 取得多有优惠规则对应的礼品列表
	public static List<PermissionWareBean> getPermissionWareList(IQBOPermissionWareValue[] values) throws Exception {
		// 保存优惠礼品
		List<PermissionWareBean> permissionWareList = new ArrayList<PermissionWareBean>();
		PermissionWareBean bean = null;
		// 获取所有正在进行的有效规则列表
		if (values != null && values.length > 0) {
			for (IQBOPermissionWareValue value : values) {

				// 当前规则下优惠礼品
				bean = new PermissionWareBean();
				bean.setPermissionId(value.getPermissionId());
				bean.setWareId(value.getWareId());
				bean.setWareName(value.getWareName());
				bean.setWareGmeValue(value.getWareGmeValue());
				bean.setExchangeChannel(value.getExchangeChannel());
				bean.setSupportType(value.getSupportType());
				bean.setItemScope(value.getItemScope());
				permissionWareList.add(bean);
				bean = null;
			}
		}
		return permissionWareList;
	}

	/**
	 * 转为基本规则 TODO
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public static PermissionWareBean tranRuleToBaseRule(IQBOPermissionWareValue value) throws Exception {
		PermissionWareBean bean = null;
		if (value != null) {
			bean = new PermissionWareBean();
			bean = new PermissionWareBean();
			bean.setPermissionId(value.getPermissionId());
			bean.setWareId(value.getWareId());
			bean.setWareName(value.getWareName());
			bean.setWareGmeValue(value.getWareGmeValue());
			bean.setExchangeChannel(value.getExchangeChannel());
			bean.setSupportMobileBrand(value.getMobileBrandCode());
			bean.setWareName(value.getWareName());
			bean.setItemScope(value.getItemScope());
			bean.setSupportType(value.getSupportType());
		}
		return bean;
	}

	/**
	 * wap和web成功提醒页面优惠礼品公共方法
	 * 
	 * @return
	 */
	public static List<PermissionWareRuleVo> getWareRule(String channel) {

		List<PermissionWareRuleVo> permissionWareRuleVoList = null;
		try {
			permissionWareRuleVoList = CacheLoaderTemplate.getEntity(CommnConstant.MEMCACHE_PERMISSION_RECORD, channel,
					PermissionInfoCacheUtil.getAcCacheLoader());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return permissionWareRuleVoList;
	}

	/**
	 * @param list
	 * @return
	 */
	public static Object getValue(Object key) {

		return key == null ? "" : key;
	}

	/**
	 * 获取当前渠道对应的规则信息（基本规则，优惠礼品）
	 * 
	 * @param channel
	 */
	public static List<PermissionWareRuleVo> createPermissionWareRuleList(String channel) throws Exception {
		PermissionWareRuleVo permissionWareRuleVo = null;
		Map<Long, IQBOPermissionWareValue> allRulesMap = null;
		PermissionWareRule permissionWareRule = null;
		List<PermissionWareRuleVo> permissionWareRuleVoList = null;
		IQBOPermissionWareValue[] allRuleAndWares = PermissionWareViewUtil.getAllPermissionInfo(channel);
		// 过滤有效规则：key = 规则ID value = 当前规则对象
		allRulesMap = PermissionWareViewUtil.filterRuleFromRules(allRuleAndWares);
		logger.info("allRulesMap.size() = " + allRulesMap.size());
		if (allRulesMap != null && allRulesMap.size() > 0) {
			permissionWareRuleVoList = new ArrayList<PermissionWareRuleVo>();
			for (Iterator<Map.Entry<Long, IQBOPermissionWareValue>> it = allRulesMap.entrySet().iterator(); it
					.hasNext();) {
				permissionWareRuleVo = new PermissionWareRuleVo();
				Map.Entry<Long, IQBOPermissionWareValue> entry = (Map.Entry<Long, IQBOPermissionWareValue>) it.next();
				IQBOPermissionWareValue value = (IQBOPermissionWareValue) entry.getValue();// 取得当前规则
				// 当前规则对应的基本规则
				permissionWareRule = new PermissionWareRule();
				permissionWareRule.setPermissionWareBaseRule(tranRuleToBaseRule(value));
				Map<String, List<String>> typeMap = getAllRuleTypeCodes(value, channel);
				if (typeMap != null) {
					permissionWareRule.setPermissionWareRuleProvs(typeMap.get(CoreConstant.PROVINCE_TYPE_CODE));
					permissionWareRule
							.setPermissionWareTypeCodes(typeMap.get(CoreConstant.PARTNER_KIND_WARE_TYPE_CODE));
				}
				permissionWareRuleVo.setPermissionWareRule(permissionWareRule);
				List<PermissionWare> permissionWareList = getWareInfoList(value.getPermissionId(), channel);
				permissionWareRuleVo.setPermissionWareList(permissionWareList);
				permissionWareRuleVoList.add(permissionWareRuleVo);
			}
		}
		return permissionWareRuleVoList;
	}

}
