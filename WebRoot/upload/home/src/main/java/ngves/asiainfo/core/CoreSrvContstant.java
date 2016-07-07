/**
 * Copyright (c) 2011 asiainfo-linkage.com
 */
package ngves.asiainfo.core;

/**
 * 核心包的服务定义
 * @author wzg
 *
 */
public abstract class CoreSrvContstant {
	
	// ----------------------一级客服接入服务定义----开始----------------------------------------------
	/**
	 * 一级客服报文流水服务
	 */
	public static final String SERVICE_INTERMSG_BUSI = "ngves.asiainfo.core.interMsgBusiSrv";
	// ----------------------一级客服接入服务定义----结束----------------------------------------------
	
	// ----------------------系统通知服务定义----开始----------------------------------------------
	
	/**
	 * 系统通知接收服务
	 */
	public static final String SERVICE_SYSTEM_REQUISITION_RCV_STATE = "ngves.asiainfo.core.RequisitionRcvStateDAO";
	
	/**
	 * 系统通知请求服务
	 */
	public static final String SERVICE_SYSTEM_REQUISITION_INFO = "ngves.asiainfo.core.RequisitionInfoDAO";

    /**
	 * 接收一级客服投诉
	 */
    public final static String SERVICE_CRM_ALLEGE_SEND = "ngves.asiainfo.core.CrmAllegeSendService";

	
	// ----------------------系统通知服务定义----结束----------------------------------------------
    
    //-------------------------凤凰手机报积分兑换---开始--------------------------------
    public final static String SERVICE_WARE_INFO = "ngves.asiainfo.core.wareInfoSrv";
    public final static String SERVICE_WARE_DETAIL = "ngves.asiainfo.core.wareDetailSrv";
    public final static String SERVICE_WARE_DESC_INFO = "ngves.asiainfo.core.wareDescInfoSrv";
    
    //EJB服务信息查询
    public final static String SERVICE_TEST_EJB_INFO = "ngves.asiainfo.core.testEJBInfoSrv";
	
	/**
	 * 团购汇总页面服务
	 */
	public static final String TUAN_RANK_SRV = "ngves.asiainfo.core.tuanRankSrv";
	
    public final static String SERVICE_USER_AGENT="ngves.asiainfo.core.userAgentSrv";
    
    //礼品下线考核
    public final static String SERVICE_WARE_ON_OR_OFFLINE="ngves.asiainfo.core.CheckWareOnOrOffLineSrv";
    //  礼品下线考核-定时处理
    public final static String SERVICE_EXMAINE_WARE_ON_OR_OFFLINE="ngves.asiainfo.core.examineWareOffLineSrv";
    public final static String SERVICE_ALLGIFT_INFO="ngves.asiainfo.core.allGiftInfoSrv";

    /**
	 * 考核信息查询
	 */
	public final static String SERVICE_CORE_CHECK_EXAMINE = "ngves.asiainfo.core.ExamineFileService";
	public final static String SERVICE_CORE_CHECK_EXAMINE_DAO = "ngves.asiainfo.core.ExamineFileDAO";
	
	 /**
	 * 合作商考核日志
	 */
	public final static String SERVICE_CORE_CHECK_PARTNERCHECK = "ngves.asiainfo.core.PartnerCheckFileService";
	public final static String SERVICE_CORE_CHECK_PARTNERCHECK_DAO = "ngves.asiainfo.core.PartnerCheckFileDAO";

	/**
	 * 礼品团购服务
	 */
	public final static String SERVICE_CORE_TUAN_INFO = "ngves.asiainfo.core.TuanInfoService";
	public final static String SERVICE_CORE_TUANINFO_DAO = "ngves.asiainfo.core.tuanInfoDAO";
	public final static String SERVICE_CORE_TUAN_GROUP_INFO_DAO = "ngves.asiainfo.core.TuanGroupInfoService";
	
	/**
	 * 团购轮转服务
	 */
	public final static String SERVICE_CORE_TUANCYCLE_INFO = "ngves.asiainfo.core.TuanCycleInfoService";
	
    /**
     * 团购关联礼品表 服务
     */
	public final static String SERVICE_CORE_TUANWARERLT_SRV = "ngves.asiainfo.core.tuanWareRLTSrv";
    public final static String SERVICE_CORE_TUANUSERLOG_SRV = "ngves.asiainfo.core.tuanUserLogSrv";

    /**
     *   用于展现团兑活动订单信息和做团兑订单统计
     */
    public final static String SERVICE_CORE_PREORDERINFO_SRV = "ngves.asiainfo.core.preOrderInfoSrv";
    
    /**
     * 业务流水服务
     */
    public final static String SERVICE_MGT_COMMON_BUSI_DETAIL = "ngves.asiainfo.core.BusiInfoDetailService";
    
    /**
     * 业务总表服务
     */
    public static final String SERVICE_MGT_BUSI_INFO = "ngves.asiainfo.core.BusiInfoService";
    
    
    /**
     * 
     */
    public static final String SERVICE_CORE_DONATED_ACTIVITY_SRV="ngves.asiainfo.core.DonatedActivityService";
    /**
     * 捐赠对象服务
     */
    public static final String SERVICE_CODE_DONATED_OBJECT_SRV ="ngves.asiainfo.core.DonatedObjectService";
    
    /**
     * 捐赠活动中，礼品信息服务
     */
    public static final String SERVICE_CORE_DOANTED_WARE_OBJECT_SRV = "ngves.asiainfo.core.DonatedWareService";
    /**
     * WAP商城网关服务
     */
    public final static String SERVICE_GATE_WAY="ngves.asiainfo.core.gatewaySrv";
    
    /**
     * 主礼品与子礼品的信息服务
     */
    public final static String SERVICE_CORE_WARE_PARENT_CHILDREN_INFO_SRV = "ngves.asiainfo.core.WarePCInfoService";
    /**
     * 国家大剧院礼品信息服务
     */
    public final static String SERVICE_CORE_THEATREINFO_SRV = "ngves.asiainfo.core.theatreInfoService";
    
    /**
     * 咨询投诉查询服务
     */
    public final static String SERVICE_CORE_ALLEGEINFO_SRV = "ngves.asiainfo.core.custom.AllegeInfoService";
    
    
    /**
     * 积分平台业务锁服务
     */
    public final static String SERVICE_CORE_SYS_BUSI_LOCK_SRV = "ngves.asiainfo.core.SysBusiLockInfoSrv";
    
    
    /**
     * 礼品上下线状态服务
     */
    public final static String SERVICE_CORE_SYS_WARE_STATUS_SRV = "ngves.asiainfo.core.WareStatusSrv";
    
    
    /**
     * 积分平台，同步信息服务
     */
    public final static String SERVICE_CORE_SYS_BASE_SYN_SRV = "ngves.asiainfo.core.BaseSynSrv";
    
    /**
     * 积分平台，优惠兑换资格的服务层
     */
    public final static String SERVICE_CORE_SYS_PERMISSION_RULE_SRV = "ngves.asiainfo.core.ware.WarePermissionInfoService";
    
    /**
	 * 票务专题页服务定义
	 */
	public final static String SERVICE_CORE_TICKET_SERVICE = "ngves.asiainfo.core.ticket.ticketTopicInfoSrv";
	public final static String SERVICE_CORE_TICKET_DAO = "ngves.asiainfo.core.ticket.ticketTopicInfoDAO";
	
	/**
	 * 第三方票务类服务
	 */
	public final static String SERVICE_CORE_SEAT_SERVICE = "ngves.asiainfo.core.ticket.ticketThirdInfoSrv";
	
	
	/**
	 * 团购分类是否显示
	 */
	public final static String SERVICE_CORE_TUAN_CATEGORY_SERVICE = "ngves.asiainfo.core.CategoryShowControlService";
	/**
	 * 超时订单审核服务
	 */
	public final static String SERVICE_CORE_OVER_TIME_ORDER_SERVICE = "ngves.asiainfo.core.overTimeOrderService";
	/**
	 * 客诉详单
	 */
	public final static String SERVICE_CORE_STAT_ALLEGE_INFO_SERVICE = "ngves.asiainfo.core.StatAllegeInfoService";
	/**
	 * vip贵宾厅的service
	 */
	public static final String VIP_HALL_TOPIC_SERVICE = "ngves.asiainfo.core.vipHallTopicSrv";
	
	/**
	 * 礼品价格变更修改
	 */
    public final static String WARE_PRICECHANGE_SERVICE = "ngves.asiainfo.core.warePriceChangeSrv";
    
    /**
	 * 物流积分规则服务
	 */
    public final static String LOGISTICS_RULES_SERVICE = "ngves.asiainfo.core.ware.LogisticsRulesSrv";
    
    /**
	 * 未支付订单
	 */
    public final static String NOT_PAY_ORDER_SERVICE = "ngves.asiainfo.mgt.order.NoPayOrderSrv";
    
    /**
	 * 抽奖活动管理
	 */
    public final static String SERVICE_CORE_AWARD_INFO = "ngves.asiainfo.core.award.AwardInfoSrv";
    
    /**
	 * 中奖档次管理
	 */
    public final static String SERVICE_CORE_AWARD_LEVEL_INFO = "ngves.asiainfo.core.award.AwardLevelInfoSrv";
    
    /**
	 * 积分返赠
	 */
	
	public static final String RECHARGE_POINTS_TASK= "ngves.asiainfo.core.RechargePointsTaskService";
	
	/**
	 * 礼品推荐列表
	 */
	public static final String RECOMM_CATEGORY_WARE_RLT_SERVICE= "ngves.asiainfo.core.RecommCategoryWareRltSrv";
	
	/**
     * 合优选 礼品图片同步服务
     */
    public final static String SERVICE_CORE_WARE_PIC_SYN_SRV = "ngves.asiainfo.core.WarePicSynService";
    
    /**
     * 增加礼品兑换数量限制  城市区号信息服务
     */
    public final static String SERVICE_CITY_AREA_CODE_INFO_SRV = "ngves.asiainfo.core.CityAreaCodeInfoService";
	
    /**
     * 星级体系重构：
     * 礼品信息DAO
     * 父子礼品信息DAO
     * 礼品积分信息DAO
     */
    public final static String SERVICE_CORE_WARE_INFO_DAO = "ngves.asiainfo.core.wareInfoDAO";
    public final static String SERVICE_CORE_WARE_PC_INFO_DAO = "ngves.asiainfo.core.WarePCInfoDAO";
    public final static String SERVICE_CORE_WARE_PORTAL_INTEGRAL_DAO = "ngves.asiainfo.core.WareInfoPortalIntegralDAO";
    public final static String SERVICE_CORE_ACTIVITY_INTEGRAL_DAO = "ngves.asiainfo.core.ActivityIntegralDAO";
    public final static String SERVICE_CORE_BUSI_ACTIVITY_INTEGRAL_DAO = "ngves.asiainfo.core.BusiActivityIntegralDAO";
    
    public final static String SERVICE_WARE_FIRST_ID_KIND_SRV = "ngves.asiainfo.core.WareIdFirstKindSrv";
    
    public final static String SERVICE_NAVBAR_INFO_SRV = "ngves.asiainfo.core.NavbarInfoSrv";
    public final static String SERVICE_NAVBARKIND_INFO_SRV = "ngves.asiainfo.core.NavbarKindInfoSrv";
	/**
	 * 楼层信息
	 */
	public static final String SERVICE_FLOOR_INFO = "ngves.asiainfo.core.floor.FloorInfoService";
}
