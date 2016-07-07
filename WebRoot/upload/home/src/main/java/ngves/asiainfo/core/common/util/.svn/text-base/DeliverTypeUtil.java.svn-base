/**
 *  Copyright (c) 2012 asiainfo-linkage.com
 */
package ngves.asiainfo.core.common.util;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.common.bo.SysParaDataEngine;
import ngves.asiainfo.core.common.ivalues.ISysParaDataValue;
import ngves.asiainfo.core.csvc.util.CodeMapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 积分商城配送方式工具类，该类在运行时会从数据库中加载出配送方式信息。
 * 提供的方法：
 * <p>1、getDeliverTypeFromAiToHp(aiCode);根据AI的配送方式，获得HP对应的业务类型</p>
 * <p>2、getDeliverTypeFromHpToAi(hpCode);根据HP的业务类型，获得AI对应的配送方式</p>
 * <p>3、getDeliverTypeNameByAiCode(aiCode);根据AI的配送方式，获得配送方式在积分商城的名称</p>
 * 
 * 
 * @author liuyq7@asiainfo-linkage.com
 * @date 2012/04/01 创建该工具类
 */
public class DeliverTypeUtil {


	private static Log logger = LogFactory.getLog(DeliverTypeUtil.class);
	
	// 大区仓类型
	private final static String WARE_HOUSE_TYPE_REGION = "0";

	// 中心仓类型
	private final static String WARE_HOUSE_TYPE_GLOBAL = "1";

	//此处可以指定默认的配送类型，例如 deliverTypeMapper = new CodeMapper("AI01","HP01");
    private static CodeMapper deliverTypeMapper = new CodeMapper();

    private static String DELIVER_TYPE_SQL = "select * from sys_para_data spd where spd.para_type_id= :para_type_id";
	//加载配送方式信息
	static {
		if(logger.isDebugEnabled())
			logger.debug("current sql for deliverType is "+DELIVER_TYPE_SQL);
		
		Map<String,String> map = new HashMap<String,String>();
		//配送方式的para_type_id 为51
		map.put("para_type_id", "51");
		ISysParaDataValue [] value = null;
		try {
			value = SysParaDataEngine.getBeansFromSql(DELIVER_TYPE_SQL, map);
		} catch (Exception e) {
			logger.error("error occors when getting deliverType from sys_para_data where para_type_id='51'", e);
		}
		if(null != value){
			for(int i = 0;i < value.length;i++){
				if(logger.isDebugEnabled()){
					logger.debug(value[i].getParaName()+"AI value is :"+value[i].getParaCode()+" HP value is :"+ value[i].getParaAttr1());
				}
				//将配送方式，分别加入到Map表中
				deliverTypeMapper.register(value[i].getParaName(), value[i].getParaCode(), value[i].getParaAttr1());
			}
		}else{
			logger.error("current deliverType is null,please check sys_para_data and para_type_id='51'.");
		}
	}
	
	/**
	 * 根据AI的配送方式，获得HP对应的业务类型
	 * @param aiDeliverType
	 * @return hp的业务类型编码
	 */
	public static String getDeliverTypeFromAiToHp(String aiDeliverType){
		return  deliverTypeMapper.getBCodeByACode(aiDeliverType);
	}
	
	/**
	 * 根据HP的业务类型，获得AI对应的配送方式
	 * @param hpDeliverType
	 * @return ai的配送方式编码
	 */
	public static String getDeliverTypeFromHpToAi(String hpDeliverType){
		return  deliverTypeMapper.getACodeByBCode(hpDeliverType);
	}
	
	/**
	 * 根据AI的配送方式，获得配送方式在积分商城的名称
	 * @param aiDeliverType
	 * @return 配送方式的积分商城名称
	 */
	public static String getDeliverTypeNameByAiCode(String aiDeliverType){
		return deliverTypeMapper.getNameByACode(aiDeliverType);
	}
	
	
	/**
	 * ===================================================以下是配送方式改造部分===================================================
	 * @author zhaoyj
	 */
	

	/**
	 * 直接兑换礼品(不需要配送)
	 * 
	 * @param deliverType
	 * @return
	 */
	public static boolean isDirectExchangeWare(String deliverType) {
		if (DeliverTypeEnum.AIR_MILES_WARE.getAIValue().equals(deliverType)
				|| DeliverTypeEnum.DIM_CODE_WARE.getAIValue().equals(deliverType)
				|| DeliverTypeEnum.ELE_PASSWD_WARE.getAIValue().equals(deliverType)
				|| DeliverTypeEnum.GAS_CARD_WARE.getAIValue().equals(deliverType)
				|| DeliverTypeEnum.PROV_BUSINESS_WARE.getAIValue().equals(deliverType)
				|| DeliverTypeEnum.SPD_BANK_WARE.getAIValue().equals(deliverType)
				|| DeliverTypeEnum.POINT_DONATE_WARE.getAIValue().equals(deliverType)) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 用于抢兑时的直接兑换礼品(不需要配送)
	 * 
	 * @param deliverType
	 * @return
	 */
	public static boolean isDirectExchangeWareForRushBuy(String deliverType) {
		return DeliverTypeEnum.DIM_CODE_WARE.getAIValue().equals(deliverType)
		|| DeliverTypeEnum.ELE_PASSWD_WARE.getAIValue().equals(deliverType);
	}
	
	/**
	 * 全网实物类配送
	 * @param deliverType
	 * @return
	 */
	public static boolean isGloLogicWare(String deliverType){
		return DeliverTypeEnum.GLO_LOGIC_WARE.getAIValue().equals(deliverType);
	}
	/**
	 * 是否是全网物流大区仓礼品
	 * @param deliverType
	 * @param storageType
	 * @return
	 */
	public static boolean isGloLogicRegionWare(String deliverType,String storageType){
		return DeliverTypeEnum.GLO_LOGIC_WARE.getAIValue().equals(deliverType) && WARE_HOUSE_TYPE_REGION.equals(storageType);
	}
	/**
	 * 是否是全网物流中心仓礼品
	 * @param deliverType
	 * @param storageType
	 * @return
	 */
	public static boolean isGloLogicGlobalWare(String deliverType,String storageType){
		return DeliverTypeEnum.GLO_LOGIC_WARE.getAIValue().equals(deliverType) && WARE_HOUSE_TYPE_GLOBAL.equals(storageType);
	}
	/**
	 * 省物流配送
	 * @param deliverType
	 * @return
	 */
	public static boolean isProvLogicWare(String deliverType){
		return DeliverTypeEnum.PROV_LOGIC_WARE.getAIValue().equals(deliverType);
	}
	/**
	 * 省营业厅取货
	 * @param deliverType
	 * @return
	 */
	public static boolean isProvBusiOfficeWare(String deliverType){
		return DeliverTypeEnum.PROV_BUSI_OFFICE_WARE.getAIValue().equals(deliverType);
	}
	/**
	 * 合作商配送
	 * @param deliverType
	 * @return
	 */
	public static boolean isUniDeliverWare(String deliverType){
		return DeliverTypeEnum.UNI_MAG_WARE.getAIValue().equals(deliverType) 
		|| DeliverTypeEnum.UNI_DIY_WARE.getAIValue().equals(deliverType) 
		|| DeliverTypeEnum.UNI_BEVERAGES_WARE.getAIValue().equals(deliverType);
	}
	/**
	 * 需要重发二维码或者密码的配送类型，用于在订单查询页面显示“重发”按钮
	 * @param deliverType
	 * @return
	 */
	public static boolean isReSendPassWordWare(String deliverType){
		return DeliverTypeEnum.DIM_CODE_WARE.getAIValue().equals(deliverType) 
		|| DeliverTypeEnum.ELE_PASSWD_WARE.getAIValue().equals(deliverType);
	}
	/**
	 * 需要配送的礼品，用于下单时设置配送地址
	 * @param deliverType
	 * @return
	 */
	public static boolean isNeedDeliverWare(String deliverType){
		return DeliverTypeEnum.GLO_LOGIC_WARE.getAIValue().equals(deliverType) 
		|| DeliverTypeEnum.PROV_LOGIC_WARE.getAIValue().equals(deliverType)
		|| DeliverTypeEnum.UNI_DIY_WARE.getAIValue().equals(deliverType)
		|| DeliverTypeEnum.UNI_MAG_WARE.getAIValue().equals(deliverType)
		|| DeliverTypeEnum.UNI_BEVERAGES_WARE.getAIValue().equals(deliverType);
	}
	/**
	 * 抢兑时需要配送的礼品
	 * @param deliverType
	 * @return
	 */
	public static boolean isNeedDeliverWareForRushBuy(String deliverType){
		return DeliverTypeEnum.GLO_LOGIC_WARE.getAIValue().equals(deliverType) 
		|| DeliverTypeEnum.UNI_MAG_WARE.getAIValue().equals(deliverType);
	}
	
	/**
	 * 是否是二维码类礼品
	 * @param deliverType
	 * @return
	 */
	public static boolean isDimCodeWare(String deliverType){
		return DeliverTypeEnum.DIM_CODE_WARE.getAIValue().equals(deliverType);
	}
	
	/**
	 * 该配送类型是否是允许包裹兑换的配送类型
	 * @param deliverType
	 * @return
	 */
	public static boolean isPackageDeliverType(String deliverType){
		return DeliverTypeEnum.ELE_PASSWD_WARE.getAIValue().equals(deliverType) 
		|| DeliverTypeEnum.DIM_CODE_WARE.getAIValue().equals(deliverType) 
		|| DeliverTypeEnum.PROV_BUSINESS_WARE.getAIValue().equals(deliverType);
	}
	
	
	
	
}
