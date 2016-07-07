package ngves.asiainfo.core.common.util;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.ware.WareConstant;
import ngves.asiainfo.util.StringUtil;

/**
 * 记录日志时，需要的工具类。其中包括：
 * 1、需要做的编码与展示直接的转换
 * @author liuyq
 * @date 2012/03/20 创建该工具类
 *
 */
public class LogInfoUtil {

	/**
	 * 根据用户手机品牌编码BrandCode 获得 用户手机品牌名称 BrandName
	 * <p>参数与返回值对应的关系为 [0,全球通],[1,神州行],[2,动感地带],[-1,全部]
	 * @param brandCode 用户品牌编码
	 * @return brandName 用户品牌名称
	 */
	public static String getMobileBrandNameByCode(String brandCode) {
		String brandName = null;
		if(StringUtil.isBlank(brandCode))
		{
			brandName ="全部";
			return brandName;
		}
		if (CommnConstant.CUS_BRAND_QQT.equals(brandCode)) {
			brandName =  WareConstant.MOBILE_BRAND_GOTONE_VIEW;
		} else if (CommnConstant.CUS_BRAND_MZONE.equals(brandCode)) {
			brandName = WareConstant.MOBILE_BRAND_MZONE_VIEW;
		} else if (CommnConstant.CUS_BRAND_EASYOWN.equals(brandCode)) {
			brandName = WareConstant.MOBILE_BRAND_EASYOWN_VIEW ;
		} else if (CommnConstant.STAR_LEVEL_UNRATED.equals(brandCode)) {
			brandName = CommnConstant.STAR_LEVEL_UNRATED_NAME ;
		} else if (CommnConstant.STAR_LEVEL_TOBE.equals(brandCode)) {
			brandName = CommnConstant.STAR_LEVEL_TOBE_NAME ;
		} else if (CommnConstant.STAR_LEVEL_ONE.equals(brandCode)) {
			brandName = CommnConstant.STAR_LEVEL_ONE_NAME ;
		} else if (CommnConstant.STAR_LEVEL_TWO.equals(brandCode)) {
			brandName = CommnConstant.STAR_LEVEL_TWO_NAME ;
		} else if (CommnConstant.STAR_LEVEL_THREE.equals(brandCode)) {
			brandName = CommnConstant.STAR_LEVEL_THREE_NAME ;
		} else if (CommnConstant.STAR_LEVEL_FOUR.equals(brandCode)) {
			brandName = CommnConstant.STAR_LEVEL_FOUR_NAME ;
		} else if (CommnConstant.STAR_LEVEL_FIVE.equals(brandCode)) {
			brandName = CommnConstant.STAR_LEVEL_FIVE_NAME ;
		} else if (CommnConstant.STAR_LEVEL_FIVE_GOLD.equals(brandCode)) {
			brandName = CommnConstant.STAR_LEVEL_FIVE_GOLD_NAME ;
		} else if (CommnConstant.STAR_LEVEL_FIVE_DIAMOND.equals(brandCode)) {
			brandName = CommnConstant.STAR_LEVEL_FIVE_DIAMOND_NAME ;
		} else if(CommnConstant.MOBILE_BRAND_ALL.equals(brandCode)){
			brandName = "全部";
		}else {
			brandName = "无法识别的手机星级编码"+brandCode;
		}
		return brandName;
	}
	
	/**
	 * 根据兑换渠道的编码返回兑换渠道名称
	 * @param exchangeChannel 兑换渠道编码
	 * @return 兑换渠道名称
	 * 2012-4-1
	 */
	public static String getExgChannalNameByCode(String exchangeChannel) {
		String exgChannalName = null;
		// 判断条件中并未增加INTER_ORG_CRM_10086和INTER_ORG_STOCK渠道，原因是下拉列表中没有这两种渠道
		if (CommnConstant.INTER_ORG_WEB.equals(exchangeChannel))
            exgChannalName = "网站";
        else if (CommnConstant.INTER_ORG_SMS.equals(exchangeChannel))
            exgChannalName = "短信";
        else if (CommnConstant.INTER_ORG_CRM.equals(exchangeChannel))
            exgChannalName = "CRM";
        else if (CommnConstant.INTER_ORG_F.equals(exchangeChannel))
            exgChannalName = "WAP";
        else if (CommnConstant.INTER_ORG_PARTNER_SPDBANK.equals(exchangeChannel))
        	exgChannalName = "合作商-浦发";
        else if (CommnConstant.INTER_ORG_ALL.equals(exchangeChannel))
        	exgChannalName = "--全部--";
        else if (CommnConstant.INTER_ORG_CLIENT.equals(exchangeChannel))
            exgChannalName = "APP";
        else if (CommnConstant.INTER_ORG_MOBILE.equals(exchangeChannel))
            exgChannalName = "触屏版";
        else
        	exgChannalName = "无法识别的兑换渠道编码"+exchangeChannel;
		return exgChannalName;
	}
	
	
	
	
	public static void main(String [] args){
		System.out.println(getExgChannalNameByCode("0001"));
		System.out.println(getExgChannalNameByCode("0002"));
		System.out.println(getExgChannalNameByCode("0003"));
		System.out.println(getExgChannalNameByCode("0004"));
		System.out.println(getExgChannalNameByCode("1001"));
		System.out.println(getExgChannalNameByCode("-1"));
	}
}
