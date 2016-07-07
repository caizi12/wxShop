/**
 * 
 */
package ngves.asiainfo.core.ware.dao.impl;

import java.util.Map;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.custom.AllegeConstant;
import ngves.asiainfo.core.custom.bo.QBOPartnerAllegeInfoEngine;
import ngves.asiainfo.core.custom.ivalues.IQBOPartnerAllegeInfoValue;
import ngves.asiainfo.core.ware.bo.QBOAllWareDescEngine;
import ngves.asiainfo.core.ware.dao.interfaces.WareExportDAO;
import ngves.asiainfo.core.ware.ivalues.IQBOAllWareDescValue;
import ngves.asiainfo.util.StringUtil;

/**
 * @author admin
 * 
 */
public class WareExportDAOImpl implements WareExportDAO {

	public int countWareInfos(String condition, Map<String, String> parameter) throws Exception {
		return QBOAllWareDescEngine.getBeansCount(condition, parameter);
	}

	public int countPartnerAllegeInfo(String condition, Map<String, Object> parameter, String partnerId) throws Exception {
		parameter.put(AllegeConstant.PARTNER_QUERY_RESP_OP_ID, partnerId);
		parameter.put(AllegeConstant.PARTNER_QUERY_PARTNER_ID, partnerId);
		parameter.put(AllegeConstant.PARTNER_QUERY_ASSIGN_PARTNER_ID, partnerId);

		return QBOPartnerAllegeInfoEngine.getBeansCount(condition, parameter);
	}

	@SuppressWarnings("unchecked")
	public IQBOAllWareDescValue[] queryWareInfos(String condition, Map parameter, int startIndex, int endIndex) throws Exception {
		IQBOAllWareDescValue[] values = QBOAllWareDescEngine.getBeans(null, condition, parameter, startIndex, endIndex, false);
		StringBuilder mobileBrand = new StringBuilder();
		for (IQBOAllWareDescValue value : values) {
			// 转换移动品牌字段
			mobileBrand.delete(0, mobileBrand.length());
			/*if("0".equals(value.getWareType())){
				
			}*/
			if (value.getMobileBrand() != null) {
				if (value.getMobileBrand().indexOf("0") > -1) {
					mobileBrand.append(" 全球通");
					if("0".equals(value.getWareType()+"")){
						if(value.getIsVipPrice()!=null&&!"".equals(value.getIsVipPrice())){
							if ("1".equals(value.getIsVipPrice())) {
								value.setIsVipPrice("是");
								vipPayCash(value);
							}else{
								if(StringUtil.isBlank(value.getPayGoldIntegral())&&
										StringUtil.isBlank(value.getPayDrillIntegral())&&StringUtil.isBlank(value.getPaySiliverIntegral())){
									value.setIsVipPrice("否");
								}
								else{
									value.setIsVipPrice("是");
									vipPayCash(value);
								}
							}
						}else {			
							if(StringUtil.isBlank(value.getPayGoldIntegral())&&
									StringUtil.isBlank(value.getPayDrillIntegral())&&StringUtil.isBlank(value.getPaySiliverIntegral())){
								value.setIsVipPrice("否"); 
							} 
							else{
								value.setIsVipPrice("是");
								vipPayCash(value);
							}
						}
					}else{
						value.setIsVipPrice("");
					}
					
				}
				if (value.getMobileBrand().indexOf("2") > -1) {
					mobileBrand.append(" 动感地带");
					
				}
				if (value.getMobileBrand().indexOf("1") > -1) {
					mobileBrand.append(" 神州行");
				}
				
				if (value.getMobileBrand().indexOf("05") > -1) {
					mobileBrand.append(" 五星钻");
				}
				if (value.getMobileBrand().indexOf("06") > -1) {
					mobileBrand.append(" 五星金");
				}
				if (value.getMobileBrand().indexOf("07") > -1) {
					mobileBrand.append(" 五星");
				}
				if (value.getMobileBrand().indexOf("08") > -1) {
					mobileBrand.append(" 四星");
				}
				if (value.getMobileBrand().indexOf("09") > -1) {
					mobileBrand.append(" 三星");
				}
				if (value.getMobileBrand().indexOf("10") > -1) {
					mobileBrand.append(" 二星");
				}
				if (value.getMobileBrand().indexOf("11") > -1) {
					mobileBrand.append(" 一星");
				}
				if (value.getMobileBrand().indexOf("12") > -1) {
					mobileBrand.append(" 准星");
				}
				if (value.getMobileBrand().indexOf("13") > -1) {
					mobileBrand.append(" 未评级");
				}
				value.setMobileBrand(mobileBrand.toString());
			}
			//原积分值
			if(value.getWareIntegralValue()=="0"){
				value.setWareIntegralValue(null);
			}
			if(value.getNoLevel() == "0") {
				value.setNoLevel(null);
			}
			if(value.getStandardStar() == "0"){
				value.setStandardStar(null);
			}
			if(value.getOneStar() == "0"){
				value.setOneStar(null);
			}
			if(value.getTwoStar() == "0"){
				value.setTwoStar(null);
			}
			if (value.getThreeStar() == "0") {
				value.setThreeStar(null);
			}
			if (value.getFourStar() == "0") {
				value.setFourStar(null);
			}
			if (value.getFiveStar() == "0") {
				value.setFiveStar(null);
			}
			if (value.getFiveStarGold() == "0") {
				value.setFiveStarGold(null);
			}
			if (value.getFiveStarDiamond() == "0") {
				value.setFiveStarDiamond(null);
			}
			
			//支付方式
			if(value.getPayType()!=null){
				value.setPayType(value.getPayType().replaceAll(CoreConstant.PAY_TYPE_INTEGRAL,"全积分").replaceAll(CoreConstant.PAY_TYPE_INTEGRAL_CASH,"现金+积分"));
			}
			//现积分+现金
			if(value.getPayCash()!=null&&value.getPayIntegral()!=null){
				value.setPayCash(value.getPayCash()+"元+"+value.getPayIntegral()+"分");
			}
			if(value.getNolevelCurPayCash() != null && value.getNolevelCurPayIntegral() != null){
				value.setNolevelCurPayCash(value.getNolevelCurPayCash()+"元+"+value.getNolevelCurPayIntegral()+"分");
			}
			if(value.getStandardCurPayCash() != null && value.getStandardCurPayIntegral() != null){
				value.setStandardCurPayCash(value.getStandardCurPayCash()+"元+"+value.getStandardCurPayIntegral()+"分");
			}
			if(value.getOneCurPayCash() != null && value.getOneCurPayIntegral () != null){
				value.setOneCurPayCash(value.getOneCurPayCash()+"元+"+value.getOneCurPayIntegral()+"分");
			}
			
			if(value.getTwoCurPayCash() != null && value.getTwoCurPayIntegral () != null){
				value.setTwoCurPayCash(value.getTwoCurPayCash()+"元+"+value.getTwoCurPayIntegral()+"分");
			}
			
			if(value.getThreeCurPayCash() != null && value.getThreeCurPayIntegral () != null){
				value.setThreeCurPayCash(value.getThreeCurPayCash()+"元+"+value.getThreeCurPayIntegral()+"分");
			}
			
			if(value.getFourCurPayCash() != null && value.getFourCurPayIntegral () != null){
				value.setFourCurPayCash(value.getFourCurPayCash()+"元+"+value.getFourCurPayIntegral()+"分");
			}
			
			if(value.getFiveCurPayCash() != null && value.getFiveCurPayIntegral () != null){
				value.setFiveCurPayCash(value.getFiveCurPayCash()+"元+"+value.getFiveCurPayIntegral()+"分");
			}
			
			if(value.getFiveDiamondCurPayCash() != null && value.getFiveDiamondCurPayIntegral () != null){
				value.setFiveDiamondCurPayCash(value.getFiveDiamondCurPayCash()+"元+"+value.getFiveDiamondCurPayIntegral()+"分");
			}
			if(value.getFiveGoldCurPayCash() != null && value.getFiveGoldCurPayIntegral () != null){
				value.setFiveGoldCurPayCash(value.getFiveGoldCurPayCash()+"元+"+value.getFiveGoldCurPayIntegral()+"分");
			}
			//
			//
			//
			// 转换是否支持VIP字段
			
			/*if(value.getIsVipPrice()!=null&&value.getIsVipPrice()!=""){
				if ("1".equals(value.getIsVipPrice())) {
					value.setIsVipPrice("是");
				}else{
					value.setIsVipPrice("否");
				}
			}else if(!"-1".equals(value.getWareIntegralValue())){
				value.setIsVipPrice("否");
			}
			*/
			
			if(value.getDeliverType()!=null&&!"".equals(value.getDeliverType())){
			if("01".equals(value.getDeliverType())){
				value.setDeliverType("省物流配送");
			}
			if("02".equals(value.getDeliverType())){
				value.setDeliverType("营业厅取货");
			}
			
			if(CommnConstant.DELIV_TYPE_DIS_BUS_GIFT.equals(value.getDeliverType())){
				value.setDeliverType("自服务类礼品商");
			}
			if("11".equals(value.getDeliverType())){
				value.setDeliverType("全网实物配送类");
			}	
			if("12".equals(value.getDeliverType())){
				value.setDeliverType("无消费反馈的电子类");
			}	
			if("13".equals(value.getDeliverType())){
				value.setDeliverType("期刊杂志类");
			}	
			if("14".equals(value.getDeliverType())){
				value.setDeliverType("合作DIY类");
			}	
			if("15".equals(value.getDeliverType())){
				value.setDeliverType("有消费反馈的电子类");
				if("00".equals(value.getProvCode())){
					if(value.getIsTwoCode()!=null&&!"".equals(value.getIsTwoCode())){
						if ("1".equals(value.getIsTwoCode())) {
							value.setIsTwoCode("是");
						}else{
							value.setIsTwoCode("否");
						}
					}else 
						value.setIsTwoCode("否");
				}else{
					value.setIsTwoCode("");
				}
				
				
			}	
			if("16".equals(value.getDeliverType())){
				value.setDeliverType("外部积分、里程类");
			}	
			if("17".equals(value.getDeliverType())){
				value.setDeliverType("自有业务类");
			}
			if("18".equals(value.getDeliverType())){
				value.setDeliverType("捐赠类");
			}
			if("19".equals(value.getDeliverType())){
				value.setDeliverType("礼品商实物配送类");
			}
			if("20".equals(value.getDeliverType())){
				value.setDeliverType("中石油加油卡类");
			}
			if("98".equals(value.getDeliverType())){
				value.setDeliverType("外部兑换移动积分类");
			}
			if("99".equals(value.getDeliverType())){
				value.setDeliverType("浦发合作类礼品");
			}
			}
			
			if (value.getExchangeChannel() != null) {
				String s[] = value.getExchangeChannel().split(",");
				mobileBrand.delete(0, mobileBrand.length());
				for (String v : s) {
					if (CommnConstant.EXGCHANNEL_CRM.equals(v)) {
						mobileBrand.append(" CRM兑换");
					}else if (CommnConstant.EXGCHANNEL_SMS.equals(v)) {
						mobileBrand.append(" SMS兑换");
					}else if (CommnConstant.EXGCHANNEL_WEB.equals(v)) {
						mobileBrand.append(" WEB兑换");
					}else if (CommnConstant.EXGCHANNEL_PARTNER_SPDBANK.equals(v)) {
						mobileBrand.append(" 合作商-浦发");
					}else if (CommnConstant.EXGCHANNEL_WAP.equals(v)) {
						mobileBrand.append(" WAP兑换");
					}else if(CommnConstant.EXGCHANNEL_CLIENT.equals(v)){
						mobileBrand.append(" APP兑换");
					}
					else if(CommnConstant.EXGCHANNEL_MOBILE.equals(v)){
						mobileBrand.append(" 触屏版兑换");
					}
					value.setExchangeChannel(mobileBrand.toString());

				}
			}
			if(value.getWareStorageType()!=null && !"".equals(value.getWareStorageType())){
				if("0".equals(value.getWareStorageType())){
					
					value.setWarehouseName("所有仓库");
				}
				
			}
			
			if(value.getIsShowDeliverMsg()!=null && !"".equals(value.getIsShowDeliverMsg())){
				if("1".equals(value.getIsShowDeliverMsg())){
					
					value.setIsShowDeliverMsg("是");
				}else{
					value.setIsShowDeliverMsg("否");
				}
				
			}else if(!"".equals(value.getWareIntegralValue())&&null!=value.getWareIntegralValue()){
				value.setIsShowDeliverMsg("否");
			}
			
		//是否展示短信兑换提示
			if(value.getIsShowSmsmsg()!=null && !"".equals(value.getIsShowSmsmsg())){
				if("1".equals(value.getIsShowSmsmsg())){
					
					value.setIsShowSmsmsg("是");
				}else{
					value.setIsShowSmsmsg("否");
				}
				
			}
			
			//支持优惠兑换方式
			if(value.getIsPreferential()!=null && !"".equals(value.getIsPreferential())){
				if("00".equals(value.getIsPreferential())){
					
					value.setIsPreferential("仅支持普通兑换");
				}
				if("01".equals(value.getIsPreferential())){
					value.setIsPreferential("支持优惠兑换及普通兑换");
				}
				if("02".equals(value.getIsPreferential())){
					value.setIsPreferential("仅支持优惠兑换");
				}
				
			}else if(!"".equals(value.getWareIntegralValue())&&null!=value.getWareIntegralValue()){
				value.setIsPreferential("仅支持普通兑换");
			}
			
			//兑换方式
			if(value.getExchangeType()!=null && !"".equals(value.getExchangeType())){
				if("0".equals(value.getExchangeType())){
					
					value.setExchangeType("普通方式");
				}
				if("1".equals(value.getExchangeType())){
					value.setExchangeType("抢兑方式");
				}
				if("2".equals(value.getExchangeType())){
					value.setExchangeType("团购方式");
				}
				if("3".equals(value.getExchangeType())){
					value.setExchangeType("抽奖方式");
				}
			}else if(!"".equals(value.getWareIntegralValue())&&null!=value.getWareIntegralValue()){
				value.setExchangeType("普通方式");
			}
			
			if(!"".equals(value.getSupportLottery())&&null!=value.getSupportLottery()){
	                if("0".equals(value.getSupportLottery())){						
						value.setSupportLottery("");
					}
					if("1".equals(value.getSupportLottery())){
						value.setSupportLottery("抽奖礼品");
					}
					if("2".equals(value.getSupportLottery())){
						value.setSupportLottery("中奖礼品");
					}
			}
			//是否允许搜索
			if(value.getIsSearch()!=null && !"".equals(value.getIsSearch())){
				if("1".equals(value.getIsSearch())){
					
					value.setIsSearch("是");
				}else{
					value.setIsSearch("否");
				}
				
			}else if(!"".equals(value.getWareIntegralValue())&&null!=value.getWareIntegralValue()){
				value.setIsSearch("是");
			}
			
			//是否存在有效期
			if(value.getValidPeriod()!=null && !"".equals(value.getValidPeriod())){
				if("1".equals(value.getValidPeriod())){
					
					value.setValidPeriod("是");
				}else{
					value.setValidPeriod("否");
				}
				
			}
			
			//是否显示订购数量
			if("0".equals(value.getWareType()+"")){
			if(value.getIsShowBuyNum()!=null && !"".equals(value.getIsShowBuyNum())){
				if("1".equals(value.getIsShowBuyNum())){
					
					value.setIsShowBuyNum("是");
				}else{
					value.setIsShowBuyNum("否");
				}
				
			}else if(!"".equals(value.getWareIntegralValue())&&null!=value.getWareIntegralValue()){
				
				value.setIsShowBuyNum("否");
			}
			}else{
				value.setIsShowBuyNum("");
			}
			
			
			if(value.getMarketPrice()!=null && !"".equals(value.getMarketPrice())){
				
				String val=value.getMarketPrice()+"元";
				value.setMarketPrice(val);
				
			}
               if(value.getCountValue()!=null && !"".equals(value.getCountValue())){
				
				String val=value.getCountValue()+"元";
				value.setCountValue(val);
				
			}
               if(value.getTwoCountPrice()!=null && !"".equals(value.getTwoCountPrice())){
   				
   				String val=value.getTwoCountPrice()+"元";
   				value.setTwoCountPrice(val);
   				
   			}
               if(value.getExchangePrice()!=null && !"".equals(value.getExchangePrice())){
            	   if("0".equals(value.getExchangePrice())){
            		   value.setExchangePrice(null);
            	   }else{
            		   String val=value.getExchangePrice()+"元";
         				value.setExchangePrice(val);
            	   }
            	   
      				/*String val=Float.parseFloat(value.getExchangePrice())+"";
      				val=Float.parseFloat(val)/100+"";
      				//System.out.println(val.substring(val.indexOf(".")+1,val.length()));
      				if(val.substring(val.indexOf(".")+1,val.length()).endsWith("0")){
      					val=val.substring(0,val.lastIndexOf("."));
      				}
      				
      				val=val+"元";
      				value.setExchangePrice(val);*/
      				
      			}
               if(value.getPaidPrice()!=null && !"".equals(value.getPaidPrice())){
      				
      				String val=value.getPaidPrice()+"元";
      				value.setPaidPrice(val);
      				
      			}

		}
	
		return values;
	}

	private void vipPayCash(IQBOAllWareDescValue value) throws Exception {
		if(value.getPayDrillCash()!=null){
			value.setPayDrillCash(StringUtil.priceFormatTo2D(value.getPayDrillCash())+"元+"+value.getPayDrillIntegral()+"分");
		}
		if(value.getPayGoldCash()!=null){
		value.setPayGoldCash(StringUtil.priceFormatTo2D(value.getPayGoldCash())+"元+"+value.getPayGoldIntegral()+"分");
		}
		if(value.getPaySiliverCash()!=null){
		value.setPaySiliverCash(StringUtil.priceFormatTo2D(value.getPaySiliverCash())+"元+"+value.getPaySiliverIntegral()+"分");
		}
	}

	public IQBOPartnerAllegeInfoValue[] queryPartnerAllegeInfo(String condition, Map<String, Object> parameter, String partnerId, int startIndex, int endIndex)
			throws Exception {
		parameter.put(AllegeConstant.PARTNER_QUERY_RESP_OP_ID, partnerId);
		parameter.put(AllegeConstant.PARTNER_QUERY_PARTNER_ID, partnerId);
		parameter.put(AllegeConstant.PARTNER_QUERY_ASSIGN_PARTNER_ID, partnerId);
		return QBOPartnerAllegeInfoEngine.getBeans(null, condition, parameter, startIndex, endIndex, false);
	}

}
