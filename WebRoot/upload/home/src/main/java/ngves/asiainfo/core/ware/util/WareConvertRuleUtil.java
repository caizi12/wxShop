package ngves.asiainfo.core.ware.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.ware.ivalues.IQBOWareIdFirstKindValue;
import ngves.asiainfo.core.ware.service.interfaces.IWareIdFirstKindSrv;

import com.ai.appframe2.service.ServiceFactory;

public class WareConvertRuleUtil {
    
	 private static IWareIdFirstKindSrv wareIdFirstKindSrv= (IWareIdFirstKindSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_WARE_FIRST_ID_KIND_SRV);
	    
	 private static Map<Long, Long> wareIdFirstkind = null;


	    /**
	     *  
	     *类别
	     *结算价 A jsIntegralA countValue
	     *市场价  B marketPriceB
	     *积分单价    C djIntegralC detailValue 
	     *混合支付比例  G mixIntegralRule =convertRuleValue.getIntegralCashRate();
	     *取整规则 roundId
	     *类别 参考全积分定价
	     *实物类|合作类 （1）A≥B时，积分值  E=A/C；
	     *             （2）A< B时，积分值  E=MIN（A*1.2，B） /C；
	     *自有类       （1）积分值 E=B/C
	    */
	    public static long caculateIntegral(long wareId, long jsIntegralA, long marketPriceB, float djIntegralC, String roundId) throws Exception{
	        long firstKindId = 100000000000001l;
	        if(wareIdFirstkind==null){
	            wareIdFirstkind = new HashMap<Long, Long>();
	            init();
	        }
	        
	        if(wareIdFirstkind.get(wareId)!=null){
	            firstKindId = wareIdFirstkind.get(wareId);
	        } else {
	            IQBOWareIdFirstKindValue value = wareIdFirstKindSrv.getWareIdFirstKindInfoById(wareId);
	            if(value!=null){
	                firstKindId = value.getWareFirstKindId();
	                wareIdFirstkind.put(value.getWareId(), firstKindId);
	            }
	        }
	        float value = 0f; 
	    
	        if(100000000000001l==firstKindId){
	          //自有类
	          value = marketPriceB/djIntegralC;
	        } else {
	          //实物类|合作类
	          if(jsIntegralA>=marketPriceB){
	              value = jsIntegralA / djIntegralC;
	          }else {
	              //取得A*1.2，B的最小值
	              long minABMultiply10 = Math.min(jsIntegralA*12,marketPriceB*10);
	              float minAB = minABMultiply10/10;
	              value = minAB/djIntegralC;
	          }                
	        }
	        
	        long longValue = Math.round(value / 100.0);
	        long result = roundValue(longValue, roundId);
	        return result;
	    }
	    
	    /**
	     * 计算混合支付中的现金值 
	     * 
	     * 混合支付定价规则
	     * 积分单价    C djIntegralC
	     * 生效混合支付积分(X) 手动输入
	     * 生效混合支付现金(Y) (商城积分值-X)*C
	     * 
	     * 本方法返回的是以分为单位的 现金值
	     * 
	     * @param aValue 全积分
	     * @param payIntegralX 混合积分值
	     * @param detailValueC 积分单价
	     */
	    public static long caculatePayCash(long aValue,long payIntegralX,float detailValueC) throws Exception{
	        //混合积分中的现金值 在数据库中 要以乘以100 存储（以 分 为单位），如果展示得 在除以 100 ，以元展示。 
	        //现金以分之后四舍五入 ，所以乘以100  。返回的是以分为单位的
	        BigDecimal payCash = BigDecimal.valueOf(aValue)
	        .subtract(BigDecimal.valueOf(payIntegralX))
	        .multiply(BigDecimal.valueOf(detailValueC))
	        .multiply(BigDecimal.valueOf(100));
	        
	        return Math.round(payCash.doubleValue());
	    }
	    
	    /**
	     * 计算混合支付中的参考现金值 
	     * 
	     * 混合支付定价规则
	     * 参考混合支付积分 商城积分值*混合比例
	     * 参考混合支付现金 (商城积分值-商城积分值*混合比例）*C
	     * (E-E*F）*C
	     * 本方法返回的是以分为单位的 现金值
	     * 
	     * @param aValue 全积分
	     * @param payIntegralX 混合积分值
	     * @param detailValueC 积分单价
	     */
	    public static long caculateCPayCash(long aValue,float rate,float detailValueC, String roundId) throws Exception{
	        //混合积分中的现金值 在数据库中 要以乘以100 存储（以 分 为单位），如果展示得 在除以 100 ，以元展示。 
	        //现金以分之后四舍五入 ，所以乘以100  。返回的是以分为单位的
	        BigDecimal e = BigDecimal.valueOf(aValue);
	        BigDecimal eMF = BigDecimal.valueOf(Math.round(aValue * rate));
            eMF = BigDecimal.valueOf(roundValue(eMF.longValue(), roundId));
            
            BigDecimal payCash = e.subtract(eMF).multiply(BigDecimal.valueOf(detailValueC)).multiply(BigDecimal.valueOf(100));
	        
	        return Math.round(payCash.doubleValue());
	    }
	    
	    /**
	     * 初始化Map
	     * @throws Exception
	     */
	    private static void init() throws Exception{
	        //类加载时缓存所有礼品ID对类的映射
	        IQBOWareIdFirstKindValue[] values;
	        try {
	            values = wareIdFirstKindSrv.getWareIdFirstKindInfos();
	            for(IQBOWareIdFirstKindValue value: values){
	                wareIdFirstkind.put(value.getWareId(), value.getWareFirstKindId());
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
    

    /*
     *  对积分取整
     */
    private static long roundValue(long value, String roundId) throws Exception {
    	int round = Integer.parseInt(roundId);
        if(round < 1){
            return value;
        }else if(round==45){	//四舍五入
        	return Math.round((float)value/10)*10;
        }else{
            return (value % round) == 0 ? value : (value / round + 1) * round;
        }
    }
    /**
     * 计算混合支付中的积分值 aValue*rate
     * @param aValue 全积分值
     * @param rate 混合积分折算比例
     * @param roundId 取整规则
     * @return
     * @throws Exception
     */
    public static long comPayIntegral(long aValue,float rate,String roundId) throws Exception{
    	return roundValue(Math.round(aValue * rate), roundId);
    }
}
