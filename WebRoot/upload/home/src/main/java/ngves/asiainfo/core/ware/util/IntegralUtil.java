package ngves.asiainfo.core.ware.util;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.order.OrderConstant;
import ngves.asiainfo.core.ware.ivalues.IWareDescInfoValue;
import ngves.asiainfo.core.ware.ivalues.IWareInfoPortalIntegralValue;
import ngves.asiainfo.core.ware.ivalues.IWareIntegralInfoValue;
import ngves.asiainfo.core.ware.model.ComplexIntegral;
import ngves.asiainfo.core.ware.model.ComplexPayIntegralAndCash;
import ngves.asiainfo.core.ware.service.interfaces.ITestEJBInfoSrv;
import ngves.asiainfo.core.ware.service.interfaces.IWareDescInfoSrv;
import ngves.asiainfo.core.ware.service.interfaces.IWareDetailSrv;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;

public class IntegralUtil {
    
    private static transient Log log = LogFactory.getLog(IntegralUtil.class);
    
    /**
	 * 用于凤凰手机报！ 根据礼品id得到分级积分价值
	 * 
	 * @param wareId
	 * @return
	 */

	public static ComplexIntegral getComplexIntegral(String wareId) {

		IWareIntegralInfoValue[] wareInteralInfos = null;
		IWareIntegralInfoValue wareInteralInfo = null;
		// 凤凰手机报类礼品的兑换积分值信息
		ComplexIntegral complexIntegral = new ComplexIntegral();
		// 礼品属性信息
		IWareDescInfoValue[] wareDescInfos = null;
		// 获取wareDetail服务
		IWareDetailSrv wareDetailSrv = (IWareDetailSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_WARE_DETAIL);

		try {
			// 获取礼品的普通兑换积分
			wareInteralInfos = wareDetailSrv.getWareIntegral(Long.valueOf(wareId));

			if (wareInteralInfos != null && wareInteralInfos.length > 0) {
				log.info("礼品分的记录：" + wareInteralInfos.length);
				for (int i = 0; i < wareInteralInfos.length; i++) {
					wareInteralInfo = wareInteralInfos[i];
					// 取得普通积分
					long integralValue = wareInteralInfo.getIntegralValue();
					long curPayIntegral = wareInteralInfo.getCurPayIntegral();
					long curPayCash = wareInteralInfo.getCurPayCash();
					// 全球通普通积分
					if (CoreConstant.GLOBAL_NORMAL_INTEGRAL.equals(wareInteralInfo.getMobileBrandCode())) {
						complexIntegral.setgValue(integralValue);
						complexIntegral.setGPayIntegralValue(curPayIntegral);
						complexIntegral.setGPayCashValue(curPayCash+"");
					}
					// 动感地带普通积分
					if (CoreConstant.M_NORMAL_INTEGRAL.equals(wareInteralInfo.getMobileBrandCode())) {
						complexIntegral.setmValue(integralValue);
						complexIntegral.setMPayIntegralValue(curPayIntegral);
						complexIntegral.setMPayCashValue(curPayCash+"");
					}
					// 神州行普通积分
					if (CoreConstant.E_NORMAL_INTEGRAL.equals(wareInteralInfo.getMobileBrandCode())) {
						complexIntegral.setEValue(integralValue);
						complexIntegral.setEPayIntegralValue(curPayIntegral);
						complexIntegral.setEPayCashValue(curPayCash+"");
					}
				}
			}
			if (isFengHuang(wareId)) {
				// 通过礼品标识wareId取得礼品属性信息
				// 钻卡，金卡，银卡 全积分与混合支付礼品业务属性id集合
				String strDesDefineIds = CoreConstant.DIAMOND_INTEGRAL_CONST + "," + CoreConstant.GOLD_INTEGRAL_CONST
						+ "," + CoreConstant.SLIVER_INTEGRAL_CONST + "," + CoreConstant.DIAMOND_CARE_INGEGRAL + ","
						+ CoreConstant.DIAMOND_CARE_CASH + "," + CoreConstant.GOLD_CARE_INGEGRAL + ","
						+ CoreConstant.GOLD_CARE_CASH + "," + CoreConstant.SILVER_CARE_INGEGRAL + ","
						+ CoreConstant.SILVER_CARE_CASH;
				wareDescInfos = wareDetailSrv.getWareDescInfoValues(wareId, strDesDefineIds);
				if (null != wareDescInfos && wareDescInfos.length > 0) {
					for (IWareDescInfoValue val : wareDescInfos) {
						if (CoreConstant.DIAMOND_INTEGRAL_CONST.equals(val.getDescDefineId()+"")) {
							// 钻卡全球通兑换积分 descDefineId = 100000000150001 ---
							// 对应的常量可以定义在常量类中
							complexIntegral.setgDiamondValue(Long.valueOf(val.getWareDescValue()));
						} else if (CoreConstant.GOLD_INTEGRAL_CONST.equals(val.getDescDefineId()+"")) {
							// 金卡全球通兑换积分 descDefineId = 100000000150002
							complexIntegral.setgGoldenValue(Long.valueOf(val.getWareDescValue()));
						} else if (CoreConstant.SLIVER_INTEGRAL_CONST.equals(val.getDescDefineId()+"")) {
							// 银卡全球通兑换积分 descDefineId = 100000000150003
							complexIntegral.setgSilverValue(Long.valueOf(val.getWareDescValue()));
						} else if (CoreConstant.DIAMOND_CARE_INGEGRAL.equals(val.getDescDefineId()+"")) {
							// 钻卡混合支付积分值 descDefineId = 999999999999936
							if(!StringUtil.isBlank(val.getWareDescValue())){
								complexIntegral.setGPayIntegralDiamondValue(Long.valueOf(val.getWareDescValue()));
							}
						} else if (CoreConstant.DIAMOND_CARE_CASH.equals(val.getDescDefineId()+"")) {
							// 钻卡混合支付现金值 descDefineId = 999999999999935
							complexIntegral.setGPayCashDiamondValue(val.getWareDescValue());
						} else if (CoreConstant.GOLD_CARE_INGEGRAL.equals(val.getDescDefineId()+"")) {
							// 金卡混合支付积分值descDefineId = 999999999999934
							if(!StringUtil.isBlank(val.getWareDescValue())){
							complexIntegral.setGPayIntegralGoldenValue(Long.valueOf(val.getWareDescValue()));
							}
						} else if (CoreConstant.GOLD_CARE_CASH.equals(val.getDescDefineId()+"")) {
							// 金卡混合支付现金值descDefineId = 999999999999933
							complexIntegral.setGPayCashGoldenValue(val.getWareDescValue());
						} else if (CoreConstant.SILVER_CARE_INGEGRAL.equals(val.getDescDefineId()+"")) {
							// 银卡混合支付积分值descDefineId = 999999999999932
							if(!StringUtil.isBlank(val.getWareDescValue())){
							complexIntegral.setGPayIntegralSilverValue(Long.valueOf(val.getWareDescValue()));
							}
						} else if (CoreConstant.SILVER_CARE_CASH.equals(val.getDescDefineId()+"")) {
							// 银卡混合支付现金值descDefineId = 999999999999931
							complexIntegral.setGPayCashSilverValue(val.getWareDescValue());
						} else {
						}
					}
				}
			}
		} catch (Exception e) {
			log.error("exception is occurred .........",e);
		}
		return complexIntegral;
	}

    
    /**
     * 只用于凤凰手机报！
     * 根据礼品id和用户级别得到兑换积分值
     * @param wareId
     * @param mobileLevel
     * @return
     */
    public static ComplexPayIntegralAndCash getComplexIntegral(String wareId, String mobileBrand, String mobileLevel){
        
        ComplexIntegral  complexIntegral = null;
        ComplexPayIntegralAndCash payIntegralAndCash=new ComplexPayIntegralAndCash();
        long integralValue = 0L;
        long payIntegral =0L;
        String payCash=null;
        complexIntegral =  getComplexIntegral(wareId);
       if(isFengHuang(wareId)){
           
           if(CoreConstant.SYN_WARE_LEVEL_TYPE_CODE_DIAMOND.equals(mobileLevel)){//钻卡积分值
               integralValue =  complexIntegral.getgDiamondValue();  
               //混合支付的现金值以及积分值
               payIntegral = complexIntegral.getGPayIntegralDiamondValue();
               payCash =complexIntegral.getGPayCashDiamondValue();
               if(payIntegral==0&&StringUtil.isBlank(payCash)){
            	   payIntegral = complexIntegral.getGPayIntegralValue();
                   payCash =complexIntegral.getGPayCashValue();
               }
           } else if(CoreConstant.SYN_WARE_LEVEL_TYPE_CODE_GOLD.equals(mobileLevel)){//金卡积分值
               integralValue = complexIntegral.getgGoldenValue();
               payIntegral = complexIntegral.getGPayIntegralGoldenValue();
               payCash =complexIntegral.getGPayCashGoldenValue(); 
               if(payIntegral==0&&StringUtil.isBlank(payCash)){
            	   payIntegral = complexIntegral.getGPayIntegralValue();
                   payCash =complexIntegral.getGPayCashValue();
               }
           } else if(CoreConstant.SYN_WARE_LEVEL_TYPE_CODE_SILVER.equals(mobileLevel)) {//银卡积分值
        	   integralValue = complexIntegral.getgSilverValue();
        	   payIntegral = complexIntegral.getGPayIntegralSilverValue();
               payCash =complexIntegral.getGPayCashSilverValue();
        	   if(payIntegral==0&&StringUtil.isBlank(payCash)){
            	   payIntegral = complexIntegral.getGPayIntegralValue();
                   payCash =complexIntegral.getGPayCashValue();
               }
           } else {
               //其他-普通积分数值
                if(CoreConstant.GLOBAL_NORMAL_INTEGRAL.equals(mobileBrand)) {
                   integralValue = complexIntegral.getgValue();//全球通积分值
                   //混合支付积分及现金
                   payIntegral = complexIntegral.getGPayIntegralValue();
                   payCash =complexIntegral.getGPayCashValue();
                }
                if(CoreConstant.M_NORMAL_INTEGRAL.equals(mobileBrand)) {
                   integralValue = complexIntegral.getmValue();//动感地带积分值
                   payIntegral = complexIntegral.getMPayIntegralValue();
                   payCash =complexIntegral.getMPayCashValue();
                }
                if(CoreConstant.E_NORMAL_INTEGRAL.equals(mobileBrand)){
                	integralValue =complexIntegral.getEValue();//神州行积分值   add  by  guokai
                	payIntegral = complexIntegral.getEPayIntegralValue();
                    payCash =complexIntegral.getEPayCashValue();
                }
           }

       }else{
           if(CoreConstant.GLOBAL_NORMAL_INTEGRAL.equals(mobileBrand)) {
              integralValue = complexIntegral.getgValue();//全球通积分值
              //混合支付积分及现金
              payIntegral = complexIntegral.getGPayIntegralValue();
              payCash =complexIntegral.getGPayCashValue();
           }
           if(CoreConstant.M_NORMAL_INTEGRAL.equals(mobileBrand)) {
              integralValue = complexIntegral.getmValue();//动感地带积分值
              payIntegral = complexIntegral.getMPayIntegralValue();
              payCash =complexIntegral.getMPayCashValue();
           }
           if(CoreConstant.E_NORMAL_INTEGRAL.equals(mobileBrand)){
        	   integralValue = complexIntegral.getEValue();//神州行积分值  add by guokai
        	   payIntegral = complexIntegral.getEPayIntegralValue();
               payCash =complexIntegral.getEPayCashValue();
           }
       }
       payIntegralAndCash.setIntegralValue(integralValue);
       payIntegralAndCash.setPayIntegral(payIntegral);
       payIntegralAndCash.setPayCash(payCash);
        return payIntegralAndCash;
    }

    /**
     * 是否凤凰手机报
     *      根据礼品标识wareId，取得礼品属性标识
     * @param wareId 礼品标识
     * @return
     */
    public static boolean isFengHuang(String wareId){
        // 取得礼品属性服务
        IWareDescInfoSrv wareDescInfoSrv = (IWareDescInfoSrv)ServiceFactory.getService(CoreSrvContstant.SERVICE_WARE_DESC_INFO);
        try {
               //select * from ware_desc_info t where t.ware_id='100000000002113' and t.desc_define_id='100000000150123'
            // 是否设定VIP积分的礼品属性标识
            String descValue = wareDescInfoSrv.getWareDescValueByWareIdAndDescDefineId(wareId,CoreConstant.WARE_DEFINE_INFO_CONST);
            return "1".equals(descValue);
        } catch (Exception e) {
            log.error("exception is occurred .........");
        }
        return false;
    }

    public static String getUserLevelDesc(String userLevel) {
		if (userLevel == null) {
			return null;
		}

		if (userLevel.equals(CoreConstant.SYN_WARE_LEVEL_TYPE_CODE_DIAMOND)) { // 钻石卡用户
			return "钻卡用户";
		} else if (userLevel.equals(CoreConstant.SYN_WARE_LEVEL_TYPE_CODE_GOLD)) {
			return "金卡用户";
		} else if (userLevel.equals(CoreConstant.SYN_WARE_LEVEL_TYPE_CODE_SILVER)) {
			return "银卡";
		} else {
			return null;
		}
	}
    
    public static String getEJBSrvName(){
    	String val ="Sorry, an error occurred......";
    	try {
    		ITestEJBInfoSrv testEJBInfoSrv = (ITestEJBInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_TEST_EJB_INFO);
        	val = testEJBInfoSrv.getEJBServiceName();
        	System.out.println(">>>>>>>>>>"+val);
		} catch (Exception e) {
			log.error("exception is getEJBSrvName() .........",e);
		}
		return val;
    }
    
    /**
     * 根据客户星级 和 兑换渠道 查询指定礼品的星级积分信息。
     * @param wareId
     * @param starLevel 可以传NULL表示查所有星级
     * @param channel  可以传NUll表示查所有渠道
     * @return
     */
    public static IWareInfoPortalIntegralValue[] getUserStartIntegral(String wareId,String starLevel, String channel){
    	IWareInfoPortalIntegralValue[] val = null;
    	log.info("wareId：" + wareId +" >>starLevel:"+starLevel+" >>channel"+channel);
    	try {
    		if(!StringUtil.isBlank(wareId) && !StringUtil.isBlank(starLevel) ){
    			IWareDetailSrv wareDetailSrv = (IWareDetailSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_WARE_DETAIL);
        		val = wareDetailSrv.getWareIntergerByStar(wareId, starLevel, channel);
    		}
		} catch (Exception e) {
			log.error("exception is getUserStartIntegral() .........",e);
		}
		return val;
    }
    
    /**
     * 查询对应礼品下对应渠道的品牌支持信息
     * @param wareId
     * @param channel
     * @return
     */
    public static IWareInfoPortalIntegralValue[] getWareStarInfo(String wareId, String channel){
    	IWareInfoPortalIntegralValue[] val = null;
    	log.info("wareId：" + wareId+" >>channel"+channel);
    	try {
    		IWareDetailSrv wareDetailSrv = (IWareDetailSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_WARE_DETAIL);
    		val = wareDetailSrv.getWareStarInfo(wareId, channel);
		} catch (Exception e) {
			log.error("exception is getWareStarInfo() .........",e);
		}
		return val;
    }
    
    /**
     * 根据星级编码获取星级名称
     * @param starLevel
     * @return
     */
    public static String tranceWareStarName(String starLevel){
    	String starName="";
    	if(CommnConstant.STAR_LEVEL_UNRATED.equals(starLevel)){
			starName=CommnConstant.STAR_LEVEL_UNRATED_NAME;
		}else if(CommnConstant.STAR_LEVEL_TOBE.equals(starLevel)){
			starName=CommnConstant.STAR_LEVEL_TOBE_NAME;
		}else if(CommnConstant.STAR_LEVEL_ONE.equals(starLevel)){
			starName=CommnConstant.STAR_LEVEL_ONE_NAME;
		}else if(CommnConstant.STAR_LEVEL_TWO.equals(starLevel)){
			starName=CommnConstant.STAR_LEVEL_TWO_NAME;
		}else if(CommnConstant.STAR_LEVEL_THREE.equals(starLevel)){
			starName=CommnConstant.STAR_LEVEL_THREE_NAME;
		}else if(CommnConstant.STAR_LEVEL_FOUR.equals(starLevel)){
			starName=CommnConstant.STAR_LEVEL_FOUR_NAME;
		}else if(CommnConstant.STAR_LEVEL_FIVE.equals(starLevel)){
			starName=CommnConstant.STAR_LEVEL_FIVE_NAME;
		}else if(CommnConstant.STAR_LEVEL_FIVE_GOLD.equals(starLevel)){
			starName=CommnConstant.STAR_LEVEL_FIVE_GOLD_NAME;
		}else if(CommnConstant.STAR_LEVEL_FIVE_DIAMOND.equals(starLevel)){
			starName=CommnConstant.STAR_LEVEL_FIVE_DIAMOND_NAME;
		}
    	return starName;
    }
    
    /**
     * 展示用户登录后的星级（只从一星开始）
     * @param starLevel
     * @return
     */
    public static String showUserStarName(String starLevel){
    	String starName="";
    	if(CommnConstant.STAR_LEVEL_ONE.equals(starLevel)){
			starName=CommnConstant.STAR_LEVEL_ONE_NAME;
		}else if(CommnConstant.STAR_LEVEL_TWO.equals(starLevel)){
			starName=CommnConstant.STAR_LEVEL_TWO_NAME;
		}else if(CommnConstant.STAR_LEVEL_THREE.equals(starLevel)){
			starName=CommnConstant.STAR_LEVEL_THREE_NAME;
		}else if(CommnConstant.STAR_LEVEL_FOUR.equals(starLevel)){
			starName=CommnConstant.STAR_LEVEL_FOUR_NAME;
		}else if(CommnConstant.STAR_LEVEL_FIVE.equals(starLevel)){
			starName=CommnConstant.STAR_LEVEL_FIVE_NAME;
		}else if(CommnConstant.STAR_LEVEL_FIVE_GOLD.equals(starLevel)){
			starName=CommnConstant.STAR_LEVEL_FIVE_GOLD_NAME;
		}else if(CommnConstant.STAR_LEVEL_FIVE_DIAMOND.equals(starLevel)){
			starName=CommnConstant.STAR_LEVEL_FIVE_DIAMOND_NAME;
		}
    	return starName;
    }
    
    
    /**
     * 根据用户星级、品牌code获取对应的星级、品牌名称
     * @param starLevelCode
     * @return
     */
    public static String getUserStarOrBrandName(String starLevelCode){
    	String starLevelName=tranceWareStarName(starLevelCode);
    	//处理品牌
    	if(StringUtil.isBlank(starLevelName)){
    		if(OrderConstant.BRAND_E_VAULE.equals(starLevelCode)||
    		   CommnConstant.CUS_BRAND_EASYOWN.equals(starLevelCode)){
    			
    			starLevelName=OrderConstant.BRAND_E_NAME;
    		}else if(OrderConstant.BRAND_G_VAULE.equals(starLevelCode)||
    				CommnConstant.CUS_BRAND_QQT.equals(starLevelCode)){
    			
    			starLevelName=OrderConstant.BRAND_G_NAME;
    		}else if(OrderConstant.BRAND_M_VAULE.equals(starLevelCode)||
    				 CommnConstant.CUS_BRAND_MZONE.equals(starLevelCode)){
    			
    			starLevelName=OrderConstant.BRAND_M_NAME;
    		}
    	}
    	
    	return starLevelName;
    }
}
