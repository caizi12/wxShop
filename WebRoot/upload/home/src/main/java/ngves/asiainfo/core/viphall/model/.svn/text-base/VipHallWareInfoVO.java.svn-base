package ngves.asiainfo.core.viphall.model;

import java.io.Serializable;
import java.util.Map;

/**
 * 专题礼品列表信息
 * 对于展示信息的封装遵循OOP原则进行
 * @author shenfl
 * @version 1.0
 * 
 */
public class VipHallWareInfoVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* 礼品基本信息 */
	private VipHallWareBaseInfo vipHallWareBaseInfo;
	/* 礼品属性信息： key为属性ID，value为礼品对应的属性信息 */
	private Map<Long, VipHallDescInfo> vipDescInfoMap;
	/* 当前父礼品按照业务规则获取当前打折子礼品信息 */
	private WareDiscountInfo wareDiscountInfo;
	public VipHallWareBaseInfo getVipHallWareBaseInfo() {
		return vipHallWareBaseInfo;
	}
	public void setVipHallWareBaseInfo(VipHallWareBaseInfo vipHallWareBaseInfo) {
		this.vipHallWareBaseInfo = vipHallWareBaseInfo;
	}
	public Map<Long, VipHallDescInfo> getVipDescInfoMap() {
		return vipDescInfoMap;
	}
	public void setVipDescInfoMap(Map<Long, VipHallDescInfo> vipDescInfoMap) {
		this.vipDescInfoMap = vipDescInfoMap;
	}
	public WareDiscountInfo getWareDiscountInfo() {
		return wareDiscountInfo;
	}
	public void setWareDiscountInfo(WareDiscountInfo wareDiscountInfo) {
		this.wareDiscountInfo = wareDiscountInfo;
	}
}
