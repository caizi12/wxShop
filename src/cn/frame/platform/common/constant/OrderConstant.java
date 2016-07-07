package cn.frame.platform.common.constant;

/**
 * 订单常量类
 * @author li
 *
 */
public class OrderConstant {
	
	/**订单支付方式 0 货到付款线-下支付 */
	public static final String ORDER_PAY_TYPE_OFFLINE="0"; 
	/**订单支付方式 1 微信支付 */
	public static final String ORDER_PAY_TYPE_WEIXIN="1";

	/**订单支付状态 0 已支付 */
	public static final String ORDER_PAY_STATUS_YES="0"; 
	/**订单支付状态 1 未支付 */
	public static final String ORDER_PAY_STATUS_NO="1";
	
	/**订单状态 0 新订单 */
	public static final String ORDER_STATUS_NEW="0"; 
	/**订单状态 1 订单确认 */
	public static final String ORDER_STATUS_CONFIRM="1";
	/**订单状态 2 已发货 */
	public static final String ORDER_STATUS_SENDING="2";
	/**订单状态 3 已收货 */
	public static final String ORDER_STATUS_RECEIVING="3";
	/**订单状态 4 无人签收 */
	public static final String ORDER_STATUS_NO_PERSON_RECEIVING="4";
	/**订单状态 5 用户退货 */
	public static final String ORDER_STATUS_MEMBER_RETURN="5";
	/**订单状态 6 订单完成 */
	public static final String ORDER_STATUS_FINISH="6";
	/**订单状态 7 用户取消订单 */
	public static final String ORDER_STATUS_CANCEL="7";
 
}
