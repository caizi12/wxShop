package ngves.asiainfo.core.viphall.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.viphall.ivalues.IQBOVipHallWareInfoValue;
import ngves.asiainfo.core.viphall.model.VipHallDescInfo;
import ngves.asiainfo.core.viphall.model.VipHallWareBaseInfo;
import ngves.asiainfo.core.viphall.model.VipHallWareInfoVO;
import ngves.asiainfo.core.viphall.model.WareDiscountInfo;
import ngves.asiainfo.util.StringUtil;

/**
 * <p>
 * 对象复制工具类
 * </p>
 * 
 * @author shenfl
 * @version 1.0
 * 
 */
public class BeanUtilities {

	private static transient Log logger = LogFactory.getLog(BeanUtilities.class);
	/**
	 * 
	 * @param value
	 *            source object
	 * @param vipHallWareBaseInfo
	 *            target object
	 */
	public static void copyVipHallInfo(IQBOVipHallWareInfoValue value, VipHallWareInfoVO vipHallWareInfoVO)  throws Exception{
		VipHallWareBaseInfo vipHallWareBaseInfo = new VipHallWareBaseInfo();
		Map<Long, VipHallDescInfo> vipDescInfoMap = new HashMap<Long, VipHallDescInfo>();
		WareDiscountInfo wareDiscountInfo = new WareDiscountInfo();
		// 基本信息拷贝
		copyVipBaseInfo(value, vipHallWareBaseInfo);
		// 属性信息拷贝
		copyVipDescInfo(value, vipDescInfoMap);
		// 打折信息拷贝
		copyVipDisInfo(value, wareDiscountInfo);
		// 拷贝数据放入数据展示对象中
		vipHallWareInfoVO.setVipHallWareBaseInfo(vipHallWareBaseInfo);
		vipHallWareInfoVO.setVipDescInfoMap(vipDescInfoMap);
		vipHallWareInfoVO.setWareDiscountInfo(wareDiscountInfo);
	}

	/**
	 * 根据专题礼品列表判断当前父礼品对应打折礼品的分值列表
	 * 
	 * @param value
	 * @param wareDiscountInfo
	 */
	private static void copyVipDisInfo(IQBOVipHallWareInfoValue value, WareDiscountInfo wareDiscountInfo) throws Exception{
		logger.info("copyVipDisInfo==> + " + (value!=null?value.getWareDisValue():""));
		if(value==null){
			logger.warn("copyVipDisInfo is exception,value is null");
			return;
		}
		String wareDisValue = value.getWareDisValue();
		String[] childInfos = wareDisValue.split(CoreConstant.KEY_LT_SPLIT);
		if (childInfos != null && childInfos.length > 0) {
			boolean isDiscount = false;// 表示是否打折 true为打折
			long wareIntegralValue = 0;
			long curGValue = 0;
			long curMValue = 0;
			long curEValue = 0;
			for (String childInfo : childInfos) {

				String[] childInfoValue = childInfo.split(CoreConstant.KEY_AND_SPLIT);
				if (childInfoValue != null && childInfoValue.length == 5) {
					wareIntegralValue = new Long(childInfoValue[1]);
					curGValue = new Long(childInfoValue[2]);
					curMValue = new Long(childInfoValue[3]);
					curEValue = new Long(childInfoValue[4]);

					if (curGValue != 0 && wareIntegralValue != curGValue || curMValue != 0
							&& wareIntegralValue != curMValue || curEValue != 0 && wareIntegralValue != curEValue) {
						isDiscount = true;
					}
					if (isDiscount) {
						break;
					}
				}
			}
			wareDiscountInfo.setWareIntegralValue(wareIntegralValue);
			wareDiscountInfo.setWareGValue(curGValue);
			wareDiscountInfo.setWareMValue(curMValue);
			wareDiscountInfo.setWareEValue(curEValue);
		}
	}

	/**
	 * 拷贝属性信息到目标对象vipDescInfoMap
	 * 
	 * @param value
	 * @param vipDescInfoMap
	 */
	private static void copyVipDescInfo(IQBOVipHallWareInfoValue value, Map<Long, VipHallDescInfo> vipDescInfoMap) throws Exception {
		logger.info("copyVipDescInfo==> descDefineWareValue=" + (value!=null?value.getDescDefineWareValue():""));
		if(value==null){
			logger.warn("copyVipDescInfo is exception ,value is null");
			return;
		}
		String descDefineWareValue = value.getDescDefineWareValue();
		String[] split = descDefineWareValue.split(CoreConstant.KEY_LT_SPLIT);
		if (split != null && split.length > 0) {
			for (String descInfos : split) {
				String[] descInfo = descInfos.split(CoreConstant.KEY_AND_SPLIT);
				if (descInfo != null && descInfo.length == 3) {
					logger.info("【"+value.getWareId()+"】=>>" + "first parameter is " + descInfo[0] + ",the secord parameter is " + descInfo[1] + ",the third parameter is " + descInfo[2]);
					VipHallDescInfo vipHallDescInfo = new VipHallDescInfo();
					vipHallDescInfo.setDescDefineId(new Long(descInfo[0]));
					vipHallDescInfo.setDescDefineName(descInfo[1]);
					vipHallDescInfo.setWareDescValue(StringUtil.htmlifyText(descInfo[2]));
					vipDescInfoMap.put(new Long(descInfo[0]), vipHallDescInfo);
				}
			}
		}
	}

	/**
	 * 拷贝礼品基本信息到目标对象vipHallWareBaseInfo中
	 * 
	 * @param value
	 *            source object
	 * @param vipHallWareBaseInfo
	 *            target object
	 */
	public static void copyVipBaseInfo(IQBOVipHallWareInfoValue value, VipHallWareBaseInfo vipHallWareBaseInfo) throws Exception{
		logger.info("copyVipBaseInfo==> cityCode=" + (value != null ? value.getCityCode(): "" )
			 + ",cityName=" +( value != null ? value.getCityName(): "" )
			 + ",wareId=" + (value != null ? value.getWareId(): "" )
		     + ",wareKindId=" + (value != null ? value.getWareKindId() : "") 
		     + ",fileName="+(value!=null?value.getFileName():"")
		     + ",isOnline="+ (value!=null?value.getIsOnline():"")
			 + ",provCode=" + (value!=null?value.getProvCode():"")
			 +",wareName = " + (value!=null?value.getWareName():""));
		if(value==null){
			logger.warn("copyVipBaseInfo is exception, value is null ");
			return;
		}
		vipHallWareBaseInfo.setCityCode(value.getCityCode());
		vipHallWareBaseInfo.setCityName(value.getCityName());
		vipHallWareBaseInfo.setFileName(value.getFileName());
		vipHallWareBaseInfo.setIsOnline(value.getIsOnline());
		vipHallWareBaseInfo.setProvCode(value.getProvCode());
		vipHallWareBaseInfo.setWareKindId(value.getWareKindId());
		vipHallWareBaseInfo.setWareName(value.getWareName());
		vipHallWareBaseInfo.setWareId(value.getWareId());
	}
}
