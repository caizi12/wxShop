/**
 * 
 */
package ngves.asiainfo.core.delivertype.service.interfaces;

/**
 * 配送方式相关业务接口
 * @author zhaoyj@asiainfo-linkage.com
 *
 */
public interface IDeliverTypeSrv {
	/**
	 * 根据配送方式的不同，返回不同的值，用于礼品信息增量同步的ServiceValue节点。
	 * @param deliverType 配送方式
	 * @return 返回礼品属性值，赋给ServiceValue节点
	 */
	public String getServiceValueForSynWareInfo(String deliverType);
	/**
	 * 根据配送方式得到订单配送分类
	 * @param deliverType
	 * @return 返回配送渠道
	 */
	public String getItemTypeBeans(String deliverType);
	/**
	 * 直接兑换的礼品配送省就是用户所在省(用于打包兑换)
	 * @param deliverType 配送方式
	 * @param sendProvinceCode 配送省
	 * @param location 用户所在省
	 * @return 返回sendProvinceCode
	 */
	public String getSendProvinceCodeForPackage(String deliverType, String sendProvinceCode, String location);
	/**
	 * 直接兑换的礼品配送省就是用户所在省(用于抢兑)
	 * @param deliverType 配送方式
	 * @param sendProvinceCode 配送省
	 * @param location 用户所在省
	 * @return 返回sendProvinceCode
	 */
	public String getSendProvinceCodeForRushBuy(String deliverType, String sendProvinceCode, String location);
	/**
	 * 直接兑换的礼品配送省就是用户所在省
	 * @param deliverType 配送方式
	 * @param sendProvinceCode 配送省
	 * @param location 用户所在省
	 * @return 返回sendProvinceCode
	 */
	public String getSendProvinceCodeForDirect(String deliverType, String sendProvinceCode, String location);
	/**
	 * 下单时判断该配送方式是否属于限制数量的礼品
	 * @param deliverType
	 * @return
	 */
	public boolean isLimitedNumOrder(String deliverType);
	
	/**
	 * 根据配送方式得到订单配送分类（用于礼品车兑换）
	 * @param deliverType
	 * @return 返回配送渠道
	 * @throws Exception 
	 */
	public String getItemTypeWareForShop(String deliverType) throws Exception;
	/**
	 * 比较配送省与用户所在省是否一致（针对本省物流配送）
	 * @param deliverType
	 * @param sendProvinceCode 配送省
	 * @param userLocation 用户所在省
	 * @return
	 */
	public boolean isConsistentProvince(String deliverType, String sendProvinceCode, String userLocation);
	/**
	 * 在下单时该配送类型是否需要填充Reserve节点
	 * @param deliverType
	 * @return
	 */
	public boolean isNeedFillReserveWhenOrder(String deliverType);
	
}
