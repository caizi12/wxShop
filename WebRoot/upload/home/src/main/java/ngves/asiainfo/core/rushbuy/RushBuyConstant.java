package ngves.asiainfo.core.rushbuy;


/**
 * 显示抢兑静态常量
 * @author zhengxk@asiainfo.com
 *
 */
public class RushBuyConstant {
    
    
    public static final String RUSH_BUY_SERVICE = "ngves.asiainfo.core.rushBuySrv";
    
    public static final String RUSH_BUY_PORTAL_SERVICE = "portal.rushBuyPortalSrv";
    
    public static final String RUSH_BUY_WARE_SERVICE = "ngves.asiainfo.core.rushWareDetailSrv";
    
    public final static String ACTIVITY_LIMIT_GROUP_SERVICE = "ngves.asiainfo.core.activityLimitGroupSrv";
    /**
	 * 限时抢兑活动显示状态--未开始
	 */
	public static final String ACTIVITY_LIMIT_VIEW_STATUS_WAIT = "0";

	/**
	 * 限时抢兑活动显示状态--进行中
	 */
	public static final String ACTIVITY_LIMIT_VIEW_STATUS_START = "1";

	/**
	 *  限时抢兑活动显示状态--结束
	 */
	public static final String ACTIVITY_LIMIT_VIEW_STATUS_END = "2";
    //抢中状态
    public static final String  AWARD_STATE_ORDER_WAIT = "0";
    //兑换成功
    public static final String  AWARD_STATE_ORDER_SUCC = "1";
    //撤销
    public static final String  AWARD_STATE_ORDER_CANCEL = "2";
	
	/**
	 * 抢兑返回前台常量串定义
	 */
	//开始时间
	public static final String ACTIVITY_LIMIT_VIEW_START_TIME= "ActivityStartTime";
	//结束时间
	public static final String ACTIVITY_LIMIT_VIEW_END_TIME= "ActivityEndTime";
	//活动状态
	public static final String ACTIVITY_LIMIT_VIEW_STATUS= "ActivityViewStatus";
	//活动剩余时间
	public static final String ACTIVITY_LIMIT_VIEW_LEFT_TIME= "LeftTime";
	//下次活动名称
	public static final String ACTIVITY_LIMIT_VIEW_NEXT_NAME= "NextActivityName";
	//下次活动剩余时间
	public static final String ACTIVITY_LIMIT_VIEW_NEXT_LEFT_TIME= "NextLeftTime";
	//下次活动发布地址
	public static final String ACTIVITY_LIMIT_VIEW_NEXT_URL= "NextActivityUrl";

	/**
	 * 限时抢兑活动状态--创建
	 */
	public static final String ACTIVITY_LIMIT_STATUS_ESTABLISH = "0";

	/**
	 * 限时抢兑活动状态--发布
	 */
	public static final String ACTIVITY_LIMIT_STATUS_PUBLIC = "1";

	/**
	 *  限时抢兑活动状态--撤销(活动未开始 就取消活动)
	 */
	public static final String ACTIVITY_LIMIT_STATUS_CANCEL = "2";

	/**
	 *  限时抢兑活动状态--终止(活动进行中 强行终止)
	 */
	public static final String ACTIVITY_LIMIT_STATUS_STOP = "3";
    /**
     * 限时抢兑活动是否在往期活动中显示(不显示）
     * 注：除了标记为"0"(no)的，其它均表示“显示”，即显示是默认的。
     */
    public static final String ACTIVITY_LIMIT_IS_VIEW_NO = "0";

    /**
     * 限时抢兑活动是否在往期活动中显示(显示）
     * 注：除了标记为"0"(no)的，其它均表示“显示”，即显示是默认的。
     * 老的activity数据该字段留为null，新数据和修改过的，则设为"0"或"1"
     */
    public static final String ACTIVITY_LIMIT_IS_VIEW_YES = "1";

    /**
     * 删除分组链接的模板
     * note: 本应放到web相关的package里
     */
    public static final String DELETE_GROUP_LINK = "<a href='javascript:onRemoveGroup(%s)'>删除分组"+ "</a> ";

    /**
     * 修改分组链接的模板
     * note: 本应放到web相关的package里
     */
    public static final String MODIFY_GROUP_LINK = "<a href='javascript:onModifyGroup(%s)'>修改分组"+ "</a>";

    public static final String MODIFY_GROUP_LINK_TUAN = "<a href='javascript:onModifyGroup(%s,%s)'>修改分组"+ "</a>";
    
    
    public static final String IS_VIEW_NO_LABEL = "在商城不显示";

    public static final String IS_VIEW_YES_LABEL = "在商城显示";

    public static final String MODIFY_ACTIVITY_LINK_TEMPLATE = "<a href='#' onclick='onModifyActivity(this, %s);return false;'>活动修改</a>&nbsp;&nbsp;&nbsp;";

    public static final String CHANGE_IS_VIEW_LINK_TEMPLATE = "&nbsp;&nbsp;&nbsp;<a data-isView='%s' href='#' onclick='onChangeIsView(this, %s);return false;'>%s</a>";
}
