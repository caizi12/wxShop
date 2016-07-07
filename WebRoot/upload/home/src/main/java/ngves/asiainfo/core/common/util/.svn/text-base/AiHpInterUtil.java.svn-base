/**
 * Copyright (c) 2012 Asiainfo-Linkage.com
 * 
 * AI与HP通信 或者 HP与AI通信 过程中的工具类
 * 
 * 工具类对外提供的功能：
 * 1、将HP发送给AI报文中的手机品牌编码转成AI使用的编码格式 convertToAIMoblieCode(moblieCode)
 * 2、将HP发送给AI报文中的手机编码转成AI使用的编码格式 convertToHPMoblieCode(moblieCode)
 * 
 * 
 * 工具类更新记录：
 * 1、支持全球通、动感地带、神州行三个品牌编码的转换 @date 2012/03/02  written by liuyq7@asiainfo-linkage.com 
 */

package ngves.asiainfo.core.common.util;

import org.apache.commons.lang.StringUtils;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.interfaces.hp.ProvinceUtil;
import ngves.asiainfo.util.StringUtil;

public class AiHpInterUtil {

	/**
	 * 将HP发送给AI报文中的手机品牌编码转成AI使用的编码格式 <li>HP全球通 G ===>> AI 全球通 0</li> <li>HP动感地带
	 * M ===>> AI 动感地带 2</li> <li>HP神州行 E ===>> AI 神州行1</li>
	 * 
	 * @param moblieCode
	 *            HP手机品牌编码
	 * @return AI 手机编码
	 * @throws Exception
	 *             无法识别HP手机品牌编码
	 * 
	 * @date 2012/03/02 by liuyq7@asiainfo-linkage.com
	 */
	public static String convertToAIMoblieCode(String moblieCode) throws Exception {
		String aiMoblieCode = null;
		// HP 全球通G ===>> AI 全球通 0
		if (CommnConstant.CUS_BRAND_QQT_HP.equals(moblieCode)) {
			aiMoblieCode = CommnConstant.CUS_BRAND_QQT;
			// HP 动感地带 M ===>> AI 动感地带 2
		} else if (CommnConstant.CUS_BRAND_MZONE_HP.equals(moblieCode)) {
			aiMoblieCode = CommnConstant.CUS_BRAND_MZONE;
			// HP 神州行 E ===>> AI 神州行1
		} else if (CommnConstant.CUS_BRAND_EASYOWN_HP.equals(moblieCode)) {
			aiMoblieCode = CommnConstant.CUS_BRAND_EASYOWN;
		} else if (StringUtils.isNotBlank(moblieCode)) {//星级不需要转码
			aiMoblieCode = moblieCode;
		} 
		else {
			throw new Exception("unrecognize HP Customer Mobile Code " + moblieCode);
		}
		return aiMoblieCode;
	}

	/**
	 * 将HP发送给AI报文中的手机编码转成AI使用的编码格式 <li>AI 全球通 0 ===>> HP全球通 G</li> <li>AI 动感地带 2
	 * ===>> HP动感地带 M</li> <li>AI 神州行1 ===>> HP神州行 E</li>
	 * 
	 * @param moblieCode
	 *            AI手机品牌编码
	 * @return HP 手机编码
	 * @throws Exception
	 *             无法识别AI手机品牌编码
	 * 
	 * @date 2012/03/02 by liuyq7@asiainfo-linkage.com
	 */
	public static String convertToHPMoblieCode(String moblieCode) throws Exception {
		String hpMoblieCode = "";
		// AI 全球通 0 ===>> HP全球通G
		if (CommnConstant.CUS_BRAND_QQT.equals(moblieCode)) {
			hpMoblieCode = CommnConstant.CUS_BRAND_QQT_HP;
			// AI 动感地带 2 ===>> HP动感地带 M
		} else if (CommnConstant.CUS_BRAND_MZONE.equals(moblieCode)) {
			hpMoblieCode = CommnConstant.CUS_BRAND_MZONE_HP;
			// AI 神州行1 ===>>HP神州行 E
		} else if (CommnConstant.CUS_BRAND_EASYOWN.equals(moblieCode)) {
			hpMoblieCode = CommnConstant.CUS_BRAND_EASYOWN_HP;
		} else if (StringUtil.isNotBlank(moblieCode)) {
			//星级直接返回
			return moblieCode;
		} else {
			throw new Exception("unrecognize AI Customer Mobile Code " + moblieCode);
		}
		return hpMoblieCode;
	}

	/**
	 * AI的用户品牌转HP的用户品牌 例如：0,1,2 转成 01,03,02
	 * 
	 * @param mobileBrand
	 * @return
	 * @throws Exception
	 */
	public static String formatMobileBrandHPCood(String mobileBrand) throws Exception {
		String SEND_HP_USERBRAND = "";
		if (!StringUtil.isBlank(mobileBrand)) {
			String[] supportBrands = mobileBrand.split(CoreConstant.STRING_SPLIT_COMMA);
			for (int i = 0; i < supportBrands.length; i++) {
				// 用户品牌转换为惠普编码--
				if (i != supportBrands.length - 1) {
					if (CoreConstant.GLOBAL_NORMAL_INTEGRAL.equals(supportBrands[i])) {
						SEND_HP_USERBRAND += CoreConstant.HP_GOTONE_USERBRAND + CoreConstant.STRING_SPLIT_COMMA;
					} else if (CoreConstant.M_NORMAL_INTEGRAL.equals(supportBrands[i])) {
						SEND_HP_USERBRAND += CoreConstant.HP_MZONE_USERBRAND + CoreConstant.STRING_SPLIT_COMMA;
					} else if (CoreConstant.E_NORMAL_INTEGRAL.equals(supportBrands[i])) {
						SEND_HP_USERBRAND += CoreConstant.HP_EASYOWN_USERBEAND + CoreConstant.STRING_SPLIT_COMMA;
					}
				} else {
					if (CoreConstant.GLOBAL_NORMAL_INTEGRAL.equals(supportBrands[i])) {
						SEND_HP_USERBRAND += CoreConstant.HP_GOTONE_USERBRAND;
					} else if (CoreConstant.M_NORMAL_INTEGRAL.equals(supportBrands[i])) {
						SEND_HP_USERBRAND += CoreConstant.HP_MZONE_USERBRAND;
					} else if (CoreConstant.E_NORMAL_INTEGRAL.equals(supportBrands[i])) {
						SEND_HP_USERBRAND += CoreConstant.HP_EASYOWN_USERBEAND;
					} 
				}
			}
		}
		return SEND_HP_USERBRAND;
	}
	
	/**
	 * AI的用户星级转HP的用户星级 例如：05	五星（钻） 06	五星（金） 07	五星 08	四星 09	三星 10	二星
	 *	11一星, 12	准星,13 未评级
	 * 
	 * @param mobileBrand
	 * @return
	 * @throws Exception
	 */
	public static String formatStarLevelHPCood(String starLevel) throws Exception {
		String SEND = "";
		if (!StringUtil.isBlank(starLevel)) {
			String[] starLevels = starLevel.split(CoreConstant.STRING_SPLIT_COMMA);
			for (int i = 0; i < starLevels.length; i++) {
				if(1 == starLevels[i].length()){
					continue;
				}
				SEND=SEND+starLevels[i]+",";
			}
		}
		if(StringUtil.isNotBlank(SEND)){
			SEND = SEND.substring(0,SEND.length()-1);
		}
		return SEND;
	}
	

	/**
	 * 从AI的省编码，获得HP的省编码
	 * 
	 * @param aiProviceCode
	 * @return
	 * @throws Exception
	 */
	public static String getHPProvinceCodeByAICode(String aiProviceCode) throws Exception {
		StringBuffer buffer = new StringBuffer();
		String retVal = "";

		String _aiProvinceCode = aiProviceCode;
		if (!StringUtil.isBlank(_aiProvinceCode)) {
			// 不为空
			String[] _aiCodeArray = _aiProvinceCode.split(",");
			if (_aiCodeArray != null && _aiCodeArray.length > 0) {
				// 存在省编码
				int i = 0;
				for (i = 0; i < _aiCodeArray.length; i++) {
					// 转换成为Hp的省编码
					buffer.append(ProvinceUtil.toHpProvince(_aiCodeArray[i])).append(",");
				}
				if (0 != i) {
					// 截取掉最后的那个','
					retVal = buffer.substring(0, buffer.length() - 1);
				}
			}
		}

		return retVal;
	}

	/**
	 * 
	 * 将字符串转换为同步HP的兑换渠道报文,在现有的基础上新增 合作商-浦发渠道 其对应数据库的字段值为16
	 * 发起方属于移动自有渠道以0开头，发起方属于合作渠道则以1开头
	 * 
	 * @param supportType
	 *            ware_desc_info中desc_define_id =999999999999996的value值
	 * 
	 * @return 同步HP的兑换渠道报文
	 * 
	 * @throws Exception
	 */

	public static String supportTypeConverter(String supportType) throws Exception {

		String[] supportTemp = supportType.split(",");
		StringBuffer supportTypes = new StringBuffer();
		for (String support : supportTemp) {
			switch (Integer.parseInt(support)) {
			case 1:
				supportTypes.append("0004,"); // 数据库中的1 对应的是 wap渠道，现报文格式改为0004，
				break;
			case 2:
				supportTypes.append("0003,"); // 数据库中的2 对应的是CRM渠道-营业厅，现报文格式改为0003
				break;
			case 4:
				supportTypes.append("0002,"); // 数据库中的4 对应的是短信 渠道，现报文格式改为0002
				break;
			case 8:
				supportTypes.append("0001,"); // 数据库中的8 对应的是网站 渠道，现报文格式改为0001
				break;
			case 16:
				supportTypes.append("1001,"); // 数据库中的 16对应的是 合作商-浦发 渠道
												// 报文格式为1001 该兑换渠道为新增，但现在后台暂不支持
				break;
			case 32:
				supportTypes.append("0005,"); // 数据库中的32 对应的是CRM渠道-10086，现报文格式改为0005
				break;
			case 3:
				supportTypes.append("0006,"); // 数据库中的3 对应的是APP渠道，现报文格式改为0006
				break;
			case 9:
				supportTypes.append("0007,"); // 数据库中的9 对应的是手机站点渠道，现报文格式改为0007
				break;
			default:
				break;
			}
		}
		return supportTypes.toString().substring(0, supportTypes.length() - 1);
	}
	
	/**
	 * 将 SELECT * FROM sys_para_data s WHERE s.para_type_id='50' 查询出来的仓库类型编码转换为hp编码
	 * @param storeType
	 * @return
	 * @throws Exception
	 */
	public static String getHPStoreTypeByAIParaCode(String storeType) throws Exception {
		if(CommnConstant.SPD_STORE_TYPE_DAQUCANG.equals(storeType)){
			storeType=CommnConstant.STORE_TYPE_DAQUCANG;
		}else if (CommnConstant.SPD_STORE_TYPE_ZHXINCANG.equals(storeType)){
			storeType=CommnConstant.STORE_TYPE_ZHXINCANG;
		}else if (CommnConstant.SPD_STORE_TYPE_XUNICANG.equals(storeType)){
			storeType=CommnConstant.STORE_TYPE_XUNICANG;
		}else if (CommnConstant.SPD_STORE_TYPE_WUCANG.equals(storeType)){
			storeType=CommnConstant.STORE_TYPE_WUCANG;
		}
		return storeType;
	}
}
