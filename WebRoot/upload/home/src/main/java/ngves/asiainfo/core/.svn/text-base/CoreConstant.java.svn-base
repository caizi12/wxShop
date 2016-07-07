/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core;

import org.apache.commons.lang.StringUtils;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.util.PropertyReader;
import ngves.asiainfo.util.StringUtil;

/**
 * 声明一个常量类<br/>
 * 继承了类<code>CommnConstant</code>
 * @author wzg
 *
 */
public abstract class CoreConstant extends CommnConstant {
	
	/**
	 * 限时抢兑在cache中存放主键的前缀
	 */
	public static final String ACTIVITY_CACHE_PREFIX = "activitycache:";
	
	/**
	 * 字符逗号分割符,
	 */
	public static final String STRING_SPLIT_COMMA = ",";
	
	
	/**
	 * 订单(ActionType)普通活动标识
	 */
	public static final String ORDER_COMMON_ACTION_TYPE = "00";
	
	/**
	 * 订单(ActionType)抢兑活动标识
	 */
	public static final String ORDER_RUSHBUY_ACTION_TYPE = "01";

    /**
	 * 订单(ActionType)0积分优惠兑换标识
	 */
	public static final String ORDER_ZERO_ACTION_TYPE = "04";
	
	/**
	 * 订单(ActionType)团购活动标识
	 */
	public static final String ORDER_TUAN_ACTION_TYPE = "02";
	
	/**
	 * 订单(ActionType)优惠活动标识
	 */
	public static final String ORDER_EXCHANGE_PERMISSION_ACTION_TYPE = "040";
	/**
	 * 订单(ActionType)对于转赠活动填写：05+转赠活动ID
	 */
	public static final String ORDER_IS_ALLOW_DONATION_ACTION_TYPE = "050";
	/**
	 * 订单(ActionType)对于转赠活动填写：05+转赠活动ID
	 */
	public static final String ORDER_ALLOW_DONATION_ACTION_TYPE = "05";
	/**
	 * 订单(ActionType)对于积分返赠活动填写：06+wareID
	 */
	public static final String ORDER_INTEGRAL_RETURN_TYPE = "06";
	
	/**
	 * 订单(ActionType)打包活动标识
	 */
	public static final String ORDER_PACKAGE_ACTION_TYPE = "08";
    /**
     * 派发业务状态-等待接收附件 (paraTypeId=4272)
     */
    public static String SYS_PARA_BUSI_ALLEGE_FILE_UNACCESS = "0";

    /**
     * 派发业务状态-附件接收完成 (paraTypeId=4272)
     */
    public static String SYS_PARA_BUSI_ALLEGE_FILE_ACCESSED = "1";

    /**
     * 派发业务状态-已完结 (paraTypeId=4272)
     */
    public static String SYS_PARA_BUSI_ALLEGE_COMPLETE = "2";

    	/**
     * 投诉工单状态-未派发 (paraTypeId=4269)
     */
    public static String SYS_PARA_CENTER_ALLEGE_UNASSIGN = "01";

    /**
     * 投诉工单状态-已派发 (paraTypeId=4269)
     */
    public static String SYS_PARA_CENTER_ALLEGE_ASSIGNED = "02";

    /**
     * 投诉工单状态-已回复 (paraTypeId=4269)
     */
    public static String SYS_PARA_CENTER_ALLEGE_RESPOND = "03";

    /**
     * 投诉工单状态-已归档 (paraTypeId=4269)
     */
    public static String SYS_PARA_CENTER_ALLEGE_RECORD = "04";
    
    /**
	 * 礼品积分分级类型编码
	 * 301:全球通钻卡
	 */
	public final static String SYN_WARE_LEVEL_TYPE_CODE_DIAMOND= "301";
	
	/**
	 * 礼品积分分级类型编码
	 * 302:全球通金卡
	 */
	public final static String SYN_WARE_LEVEL_TYPE_CODE_GOLD = "302";
	/**
	 * 礼品分级类型编码
	 * 303:全球通银卡
	 */
	public final static String SYN_WARE_LEVEL_TYPE_CODE_SILVER = "303";
	
	/**
	 * 礼品积分分级类型编码
	 * 000:全球通普通（除钻金银外的其它客户级别）
	 */
	public final static String SYN_WARE_LEVEL_TYPE_CODE_G = "000";
	/**
	 * 礼品积分分级类型编码
	 * 999:动感地带
	 */
	public final static String SYN_WARE_LEVEL_TYPE_CODE_M = "999";
	/**
	 * 礼品积分分级类型编码
	 * 888：神州行
	 */
	public final static String SYN_WARE_LEVEL_TYPE_CODE_E ="888";
	
	 /**
	 * 礼品积分分级类型描述
	 * 全球通钻卡
	 */
	public final static String SYN_WARE_LEVEL_TYPE_DESC_DIAMOND= "全球通钻卡";
	
	/**
	 * 礼品积分分级类型描述
	 * 全球通金卡
	 */
	public final static String SYN_WARE_LEVEL_TYPE_DESC_GOLD = "全球通金卡";
	/**
	 * 礼品积分分级类型描述
	 * 全球通银卡
	 */
	public final static String SYN_WARE_LEVEL_TYPE_DESC_SILVER = "全球通银卡";
	
	/**
	 * 礼品积分分级类型描述
	 * 全球通普通（除钻金银外的其它客户级别）
	 */
	public final static String SYN_WARE_LEVEL_TYPE_DESC_G = "全球通普通（除钻金银外的其它客户级别）";
	/**
	 * 礼品积分分级类型描述
	 * 动感地带
	 */
	public final static String SYN_WARE_LEVEL_TYPE_DESC_M = "动感地带";
	/**
	 * 礼品积分分级类型描述
	 * 神州行
	 */
	public final static String SYN_WARE_LEVEL_TYPE_DESC_E ="神州行";
	
	/**
	 * 品牌
	 *    全球通
	 */
	public final static String GLOBAL_NORMAL_INTEGRAL="0";
	
	/**
     * 品牌
     *    动感地带
     */
    public final static String M_NORMAL_INTEGRAL="2";
    /**
     * 品牌  神州行
     */
    public final static String E_NORMAL_INTEGRAL="1";
    
	//优惠礼品资格 校验接口-----------------start-------------------
	// 惠普全球通编码
	public static final String HP_GOTONE_USERBRAND = "01";
	// 惠普动感地带编码
	public static final String HP_MZONE_USERBRAND = "03";
	//惠普神州行编码
	public static final String HP_EASYOWN_USERBEAND = "02";
	//优惠礼品资格 校验接口-----------------end-------------------
    /**
     * 钻卡积分数值
     */
    public final static String DIAMOND_INTEGRAL_CONST = "100000000150001";
    
    /**
     * 金卡积分数值
     */
    public final static String GOLD_INTEGRAL_CONST = "100000000150002";
    
    /**
     * 银卡积分数值
     */
    public final static String SLIVER_INTEGRAL_CONST = "100000000150003";

    /**
     * VIP积分的礼品属性常量
     */
    public final static String WARE_DEFINE_INFO_CONST = "100000000150123";


    /**
     * 凤凰手机报业务类型
     */
    public final static String BUSI_TYPE_CONST = "19";
    
    /**
	 * 字符圆点分割符.
	 */
	public static final String STRING_SPLIT_DOT = ".";
	
	/**
	 * 引用压缩的文件
	 */
	public static final String ON_PRESS = "1";
	
	/**
	 * 不引用压缩文件
	 */
	public static final String OFF_PRESS = "0";
	
	/**
	 * 门户导航页签存放于缓存的key(navigation-memcache-key)
	 */
	public static final String NAVIGATION_MEM_KEY = "navigation-memcache-key";
	
	/**
	 * 团购活动保存成功
	 */
	public static final String SYS_MSG_TUAN_SAVE_SUCC = "SYS_MSG_TUAN_SAVE_SUCC";
	/**
	 * 团购活动保存失败
	 */
	public static final String SYS_MSG_TUAN_SAVE_ERR = "SYS_MSG_TUAN_SAVE_ERR";
	
	/**
	 * 团购活动在商城显示
	 */
	public static final String IS_VIEW_TRUE = "1";
	/**
	 * 团购活动在商城不显示
	 */
	public static final String IS_VIEW_FALSE = "0";
	
	//团购活动分组标识
	//今日推荐
	public static final String ACTIVITY_TUAN_GROUP_TODATY_RECOMMEND = "00";
	//下期预告
	public static final String ACTIVITY_TUAN_GROUP_NEXT_ISSUE = "01";
	//精彩回顾
	public static final String ACTIVITY_TUAN_GROUP_OLD_TIMEY = "02";
	// 商城主页
    public static final	String ACTIVITY_TUAN_GROUP_MAINPAGE = "00";
    // 团购详情页
    public static final	String ACTIVITY_TUAN_GROUP_TUANINFO = "01";
    // 团购汇总页
    public static final	String ACTIVITY_TUAN_GROUP_TUANALL = "02";
    
    //置顶团购活动
    public static final	String ACTIVITY_TUAN_IS_TOP = "1";
    //不置顶团购活动
    public static final	String ACTIVITY_TUAN_IS_UNTOP = "0";
    
	/**
	 * 修改团购活动在前台是否显示成功
	 */
	public static final String SYS_MSG_SETVISIBLE_SUCCESS = "SYS_MSG_ACTIVITY_LIMIT_CHANGE_IS_VIEW_SUCCESS";
	
	/**
	 * 修改团购活动在前台是否显示失败
	 */
	public static final String SYS_MSG_SETVISIBLE_ERR = "SYS_MSG_ACTIVITY_LIMIT_CHANGE_IS_VIEW_ERR";
	
	/*
	 * 团购信息保存成功
	 * */
	public static final String  SYS_MSG_TUAN_UPDATE_TUAN_GROUP_SUCC           ="SYS_MSG_TUAN_UPDATE_TUAN_GROUP_SUCC";
	/*
	 * 团购信息保存失败
	 * */
	public static final String  SYS_MSG_TUAN_UPDATE_TUAN_GROUP_ERR            ="SYS_MSG_TUAN_UPDATE_TUAN_GROUP_ERR";
	

	/*
	 * 团购信息保存成功
	 * */
	public static final String  SYS_MSG_TUAN_SAVE_TUAN_INFO_SUCC           ="SYS_MSG_TUAN_SAVE_TUAN_INFO_SUCC";
	/*
	 * 团购信息保存失败
	 * */
	public static final String  SYS_MSG_TUAN_SAVE_TUAN_INFO_ERR            ="SYS_MSG_TUAN_SAVE_TUAN_INFO_ERR";
	public static final String  SYS_MSG_TUAN_DEL_TUAN_INFO_SUCC           ="SYS_MSG_TUAN_DEL_TUAN_INFO_SUCC";
	public static final String  SYS_MSG_TUAN_DEL_TUAN_INFO_ERR            ="SYS_MSG_TUAN_DEL_TUAN_INFO_ERR";
	
	/*
	 * 团购绑定礼品成功
	 * */
	public static final String  SYS_MSG_TUAN_SAVE_TUAN_WARE_BIND_SUCC      ="SYS_MSG_TUAN_SAVE_TUAN_WARE_BIND_SUCC";
	/*
	 * 团购绑定礼品失败
	 * */
	public static final String  SYS_MSG_TUAN_SAVE_TUAN_WARE_BIND_ERR       ="SYS_MSG_TUAN_SAVE_TUAN_WARE_BIND_ERR";
	public static final String  SYS_MSG_TUAN_DEL_TUAN_WARE_BIND_SUCC      ="SYS_MSG_TUAN_DEL_TUAN_WARE_BIND_SUCC";
	public static final String  SYS_MSG_TUAN_DEL_TUAN_WARE_BIND_ERR       ="SYS_MSG_TUAN_DEL_TUAN_WARE_BIND_ERR";
	
	/*
	 *团购名称重复的提示
	 * */
	public static final String SYS_MSG_TUAN_INFO_NAME_CONFILCT ="SYS_MSG_TUAN_INFO_NAME_CONFILCT";
	/**
	 * 团购绑定礼品并发操作时，保存失败，提示错误信息
	 */
	public static final String SYS_MSG_TUAN_WARE_EXIST_CONCURRENT_OPERATION ="SYS_MSG_TUAN_WARE_EXIST_CONCURRENT_OPERATION";
	/**
	 * 团购活动，没有绑定任何礼品。保存预览成功后信息
	 */
	public static final String SYS_MSG_TUAN_UNBIND_WARE_SUCC  = "SYS_MSG_TUAN_UNBIND_WARE_SUCC";
	public static final String SYS_MSG_TUAN_UNBIND_WARE_ERR  = "SYS_MSG_TUAN_UNBIND_WARE_ERR";
	
	//团购二期开发，同步给HP信息失败，提示的错误信息
	public static final String SYS_MSG_TUAN_INFO_SYN_HP_FAIL ="SYS_MSG_TUAN_INFO_SYN_HP_FAIL";
	
	//	G702	更新失败
	public static final String SYS_MSG_TUAN_INFO_SYN_HP_UPDATE_ERR = "SYS_MSG_TUAN_INFO_SYN_HP_ERROR_CODE_G702";
	//	G703	其他错误
	public static final String SYS_MSG_TUAN_INFO_SYN_HP_OTHER_ERR = "SYS_MSG_TUAN_INFO_SYN_HP_ERROR_CODE_G703";
	//	G704	新增团兑信息中的结束时间早于开始时间
	public static final String SYS_MSG_TUAN_INFO_SYN_HP_NEW_ENDTIME_BEFORE_STARTTIME="SYS_MSG_TUAN_INFO_SYN_HP_ERROR_CODE_G704";
	//	G705	新增团兑信息中的开始时间已晚于当前时间
	public static final String SYS_MSG_TUAN_INFO_SYN_HP_NEW_STARTTIME_AFTER_CURRTIME="SYS_MSG_TUAN_INFO_SYN_HP_ERROR_CODE_G705";
	//	G706	团兑活动已结束，不能修改活动基本信息
	public static final String SYS_MSG_TUAN_INFO_SYN_HP_TUAN_FINISHED="SYS_MSG_TUAN_INFO_SYN_HP_ERROR_CODE_G706";
	//	G707	团兑活动已开始，只能修改活动名称、活动结束时间，其他活动信息不可修改
	public static final String SYS_MSG_TUAN_INFO_SYN_HP_TUAN_STARTED_MODIFY_LIMITED="SYS_MSG_TUAN_INFO_SYN_HP_ERROR_CODE_G707";
	//	G708	团兑活动已开始，不能删除活动基本信息
	public static final String SYS_MSG_TUAN_INFO_SYN_HP_TUAN_STARTED_DELETE_LIMITED="SYS_MSG_TUAN_INFO_SYN_HP_ERROR_CODE_G708";
	//	G709	团兑活动基本信息同步中，没有产品信息
	public static final String SYS_MSG_TUAN_INFO_SYN_HP_TUAN_NO_WAREID="SYS_MSG_TUAN_INFO_SYN_HP_ERROR_CODE_G709";
	//	G710	团兑活动ID不存在，修改失败
	public static final String SYS_MSG_TUAN_INFO_SYN_HP_TUAN_NO_TUANID="SYS_MSG_TUAN_INFO_SYN_HP_ERROR_CODE_G710";
	
	
	
	/**
	 * 票务类专题保存返回信息
	 */
	public static final String  SYS_MSG_TICKET_SAVE_INFO_ERR ="SYS_MSG_TICKET_SAVE_INFO_ERR";
	public static final String  SYS_MSG_TICKET_SAVE_INFO_SUCC ="SYS_MSG_TICKET_SAVE_INFO_SUCC";
	public static final String SYS_MSG_TICKET_UPDATE_INFO_SUCC = "SYS_MSG_TICKET_UPDATE_INFO_SUCC";
	public static final String  SYS_MSG_TICKET_UPDATE_INFO_ERR ="SYS_MSG_TICKET_UPDATE_INFO_ERR";
	public static final String SYS_MSG_TICKET_DELETE_INFO_SUCC = "SYS_MSG_TICKET_DELETE_INFO_SUCC";
	public static final String  SYS_MSG_TICKET_DELETE_INFO_ERR ="SYS_MSG_TICKET_DELETE_INFO_ERR";
	public static final String SYS_MSG_TICKET_OTHER_INFO = "SYS_MSG_TICKET_OTHER_INFO";
	public static final String  SYS_MSG_TICKET_PREVIEW_INFO_SUCC ="save cahce success";
	
	
	/**
     * 用于存放最近访问的地址，方便进行返回上一页的操作。
     * @author zhaoyujie
     */
    public static final String RECENTURLLIST ="recentURLList";


    public static final String  PRE_ORDER_INFO_FROM_HP = "preOrderInfo";

    /**
     * 每月针对曾经在积分商城兑换过礼品的客户0积分赠送一款半年的手机报产品 11月和12月
     */
    public static final String WARE_ID_0_JIFEN_URL = "ware_id_url";
    
    public static final String WARE_ID_0_JIFEN_WAP_URL = "ware_id_wap_url";
    
    public static final String WARE_ID_0_JIFEN_WAP_M_URL = "ware_id_wap_m_url";
    
    public static final String WARE_ID_0_JIFEN_WAP_N_URL = "ware_id_wap_n_url";

    public static final String WARE_ID_0_JIFEN="ware_id";

    public static final String WARE_CODE_0_JIFEN_HALF="ware_code_halfyear";
    
    public static final String WARE_CODE_0_JIFEN_FULL="ware_code_fullyear";
    
    public static final String MCDONALDS_PARTNER_CODE = "mcdonalds_partner_code";
    
    public static final String WARE_CODE_MZY = "ware_code_mzy";
    
    public static final String WARE_CODE_MXF = "ware_code_mxf";
    
    public static final String HALF_IS_SHOW = "HalfYearIsShow"; 
    
    public static final String MZY_IS_SHOW = "MzyIsShow";
    /**
     * 传递业务明细表时，最后的字段分割符
     */
    public static final String BUSI_DETAIL_SPLIT = ",";
    
    /**
     * 业务流水-操作类型-团购活动维护-活动修改
     */
    public static String SYS_PARA_BUSI_TYPE_TUAN_MODIFY = "T1";
    
    /**
     * 业务流水-操作类型-限时抢兑活动维护-活动修改
     */
    public static String SYS_PARA_BUSI_TYPE_ACTIVITYLIMIT_MODIFY = "T2";
    
    /**
     * 业务流水-操作类型-专题活动管理-团购轮转修改
     */
    public static String SYS_PARA_BUSI_TYPE_TUANCYCLE_MODIFY = "T4";
    
    /**
     * 业务流水-操作类型-手机站点楼层维护-楼层新建
     */
    public static String SYS_PARA_BUSI_TYPE_FLOOR_CREATE = "M1";
    
    /**
     * 业务流水-操作类型-手机站点楼层维护-活动修改
     */
    public static String SYS_PARA_BUSI_TYPE_FLOOR_DELETE = "M2";

    /**
     * 业务流水-操作类型-手机站点楼层维护-楼层删除
     */
    public static String SYS_PARA_BUSI_TYPE_FLOOR_MODIFY = "M3";
    
    /**
     * 记录日志表BUSI_INFO操作类型OPT_TYPE 0-增加/删除/文件下载类 
     */
    public static String BUSI_INFO_OPT_TYPE_NEW_DEL_LOAD = "0";
    
    /**
     * 记录日志表BUSI_INFO操作类型OPT_TYPE 1-修改/审核类 
     */
    public static String BUSI_INFO_OPT_TYPE_MODIFY = "1";
    
    /**
     * 记录日志表BUSI_INFO操作类型OPT_TYPE  2-查询记录类
     */
    public static String BUSI_INFO_OPT_TYPE_CHECK = "2";
    
    /**
     * 记录日志表BUSI_INFO操作类型OPT_TYPE 8-文件下载类
     */
    public static String BUSI_INFO_OPT_TYPE_DOC_DOWN= "8";
    /**
     * 操作成功
     */
    public static String DONATED_OBJECT_MGT_SUCCESS ="DONATED_OBJECT_MGT_SUCCESS";
    
    /**
     * 操作失败
     */
    public static String DONATED_OBJECT_MGT_ERR ="DONATED_OBJECT_MGT_ERR";

	/**
	 * 接口：操作类型[新增]
	 */
	public final static String INTER_OP_TYPE_ADD = "01";

	/**
	 * 接口：操作类型[修改]
	 */
	public final static String INTER_OP_TYPE_MODIFY = "02";

    /**
	 * 接口：操作类型[删除]
	 */
	public final static String INTER_OP_TYPE_DEL = "03";

    /**
     * 全部订单
     */
    public final static String INTER_ORDER_STATUS_ALL = "0";

    /**
     * 有效订单
     */
    public final static String INTER_ORDER_STATUS_YX = "1";


    /**
     * 任意礼品
     */
    public final static String INTER_ITEM_SCOPE_ALL = "00";

    /**
     * 部分礼品
     */
    public final static String INTER_ITEM_SCOPE_MX = "01";
    
    /**
     * 存放省编码03
     */
    public final static String PERMISSION_CODE_PROV_CODE = "03";
    
    /**
     * 礼品小类编码00
     */
    public final static String PERMISSION_CODE_KIND_CODE = "00";
    
    /**
     * 礼品商编码01
     */
    public final static String PERMISSION_CODE_PARTNER_CODE = "01";
    
    
    /**
     * 省份key
     */
    public final static String PROVINCE_TYPE_CODE = "0";
    
    /**
     * 合作商、礼品小类、礼品key
     */
    public final static String PARTNER_KIND_WARE_TYPE_CODE = "1";
    
    public final static String PERMISSION_WARE_KEY = "permission_ware";
    
    /**
     * 礼品编码02
     */
    public final static String PERMISSION_CODE_WARE_CODE = "02";
    /**
     * HP提供的国家大剧院库存量中间表
     */
    public static final String HP_THEATRE_TABLE_NAME = "inventoryInfo";
    
    /**
     * 国家大剧院场次票价样式
     * 可用设定样式:sel
     */
    public static final String LOCATION_PRICEINFO_STYLE_SEL = "sel"; 
    /**
     * 国家大剧院场次票价样式
     * 禁用设定样式：dis 
     */
    public static final String LOCATION_PRICEINFO_STYLE_DIS = "dis";
    /**
     * 国家大剧院场次票价样式
     * 未选择设定样式:无样式 
     */                                                      
    public static final String LOCATION_PRICEINFO_STYLE_NULL = ""; 
    /** 
     * 国家大剧院场次标识
     */
    public static final String THEATRE_LOCATION = "1";
    
    /** 
     * 国家大剧院票价标识
     */
    public static final String THEATRE_PRICEINFO = "2";
  
    
    
    /**
	 * 总部用户-typeId=0
	 */
	public static String SYS_PARA_USER_HEAD_COMPANY = "0";

	/**
	 * 省公司管理-typeId=1
	 */
	public static String SYS_PARA_USER_PROVINCE_COMPANY = "1";
	/**
	 * 全网配送商用户-typeId=2
	 */
	public static String SYS_PARA_USER_GLOBAL_LOGISTICS = "2";
	/**
	 * 全网礼品商用户-typeId=3
	 */
	public static String SYS_PARA_USER_GLOBAL_PROVIDER = "3";
	/**
	 * 全网仓储商用户-typeId=6
	 */
	public static String SYS_PARA_USER_GLOBAL_HOUSE = "6";

	/**
	 * 省公司客服-typeId=7
	 */
	public static String SYS_PARA_USER_PROVINCE_CUSTOM = "7";
	
	
	
	/**
	 * Excel导出任务状态
	 * 0：等待处理
	 * 1：正在处理
	 * 2: 完成
	 * 3: 处理时发生异常
	 * 4：任务删除
	 * 5：任务对应的文件删除失败
	 */
	/**
	 * Excel导出任务状态
	 * 0：等待处理
	 */
	public static final String EXCEL_TASK_STATE_WAIT = "0";
	/**
	 * Excel导出任务状态
	 * 1：正在处理
	 */
	public static final String EXCEL_TASK_STATE_DOING = "1";
	/**
	 * Excel导出任务状态
	 * 2: 完成
	 */
	public static final String EXCEL_TASK_STATE_DONE = "2";
	/**
	 * Excel导出任务状态
	 * 3: 处理时发生异常
	 */
	public static final String EXCEL_TASK_STATE_ERROR = "3";
	
	/**
	 * Excel导出任务状态
	 * 4：任务删除
	 */
	public static final String EXCEL_TASK_STATE_DELETE  = "4";
	
	/**
	 * Excel导出任务状态
	 * 5：任务对应的文件删除失败
	 * */
	public static final String EXCEL_TASK_STATE_DELETE_FAILED="5";
	
	/**
	 * Excel导出任务状态
	 * 6：无导出文件
	 * */
	public static final String EXCEL_TASK_STATE_NO_FILE="6";
	
	/**
	 * Excel导出任务状态
	 * 7：导出订单数超限
	 * */
	public static final String EXCEL_TASK_STATE_OVER_LIMIT="7";
	
	
	//以下这几个变量应该放置在mgt包下面，暂时没找到合适的位置。以后再移动
	public static final String EXCEL_TASK_WAIT_DESC= "等待处理";
	public static final String EXCEL_TASK_STATE_DOING_DESC = "正在处理";
	public static final String EXCEL_TASK_STATE_DONE_DESC = "处理完成";
	public static final String EXCEL_TASK_STATE_ERROR_DESC = "处理时发生异常";
	public static final String EXCEL_TASK_STATE_DELETE_DESC ="任务删除";
	public static final String EXCEL_TASK_STATE_DELETE_FILL_DESC ="文件删除失败";
	public static final String EXCEL_TASK_STATE_DNO_FILE_DESC ="无导出文件";
	public static final String EXCEL_TASK_STATE_OVER_LIMIT_DESC ="导出订单数超限";
	//访情况属于特殊情况，只用于临时展示给用户看，不属于表中的任务状态
	public static final String EXCEL_TASK_DOWNLOAD_FILL_WARTING ="文件等待下载";
	

	
	
	
	//==========================================================================================
	//----------------------------HLL的分割线，下面这部分是同步信息表的常量------------------------
	
	/**
	 * 同步信息类型-礼品资料
	 */
	public static String SYS_PARA_SYN_TYPE_WARE = "0";

	/**
	 * 同步信息类型-物流配送价格
	 */
	public static String SYS_PARA_SYN_TYPE_SEND_PRICE = "1";

	/**
	 * 同步信息类型-物流配送关系
	 */
	public static String SYS_PARA_SYN_TYPE_SEND_RELATION = "2";

	/**
	 * 同步信息类型-仓储信息[仓库信息，仓储-仓储商关系]
	 */
	public static String SYS_PARA_SYN_TYPE_STOCK_INFO = "3";

	/**
	 * 同步信息类型-仓储商申请礼品出入库信息
	 */
	public static String SYS_PARA_SYN_TYPE_WARE_STOCK_INFO = "4";

	/**
	 * 同步信息类型-仓储商账号信息
	 */
	public static String SYS_PARA_SYN_TYPE_STOCK_ACCOUNT_INFO = "5";

	/**
	 * 同步信息类型-合作商信息
	 */
	public static String SYS_PARA_SYN_TYPE_PARTNER_INFO = "6";

	/**
	 * 同步状态-增加
	 */
	public static String SYS_PARA_SYN_STATE_ADD = "1";

	/**
	 * 同步信息状态-新增
	 */
	public static String SYS_PARA_SYN_INFO_STATE_ADD = "0";

	/**
	 * 同步信息状态-修改
	 */
	public static String SYS_PARA_SYN_INFO_STATE_MODIFY = "1";

	/**
	 * 同步信息状态-删除
	 */
	public static String SYS_PARA_SYN_INFO_STATE_DEL = "2";

	/**
	 * 同步状态-待同步、通知类型为礼品、类型变更状态为新增
	 */
	public static String SYS_PARA_SYN_STATE_WAIT = "0";

	/**
	 * 同步状态-同步中
	 */
	public static String SYS_PARA_SYN_STATE_SYNING = "1";

	/**
	 * 同步状态-同步成功
	 */
	public static String SYS_PARA_SYN_STATE_SUCC = "2";
	/**
	 * 同步状态-同步失败
	 */
	public static String SYS_PARA_SYN_STATE_FAIL = "3";
	//------------------------同步信息常量定义结束----------------------------------
	//=====================================================================================
	
	/**
	 * 业务流水-操作类型-礼品预上线
	 */
	public static String SYS_PARA_BUSI_TYPE_WARE_PREONLINE = "22";

	/**
	 * 业务流水-操作类型-礼品预下线
	 */
	public static String SYS_PARA_BUSI_TYPE_WARE_PREDOWNLINE = "23";
	
	
//	1）新增优惠兑换规则   P1
	/**
	 * 业务流水-操作类型-新增优惠兑换规则   P1
	 */
	public static String SYS_PARA_BUSI_TYPE_NEW_PERMISSION ="P1";
//	2）修改优惠兑换规则   P2
	/**
	 * 业务流水-操作类型-修改优惠兑换规则   P2
	 */
	public static String SYS_PARA_BUSI_TYPE_MODIFY_PERMISSION ="P2";
//	3）删除优惠兑换规则   P3
	/**
	 * 业务流水-操作类型-删除优惠兑换规则   P3
	 */
	public static String SYS_PARA_BUSI_TYPE_DELETE_PERMISSION ="P3";
//	4）新增绑定优惠兑换规则  P4
	/**
	 * 业务流水-操作类型-新增优惠兑换规则   P4
	 */
	public static String SYS_PARA_BUSI_TYPE_NEW_PERMISSION_BIND ="P4";
//	5）修改绑定优惠兑换规则  P5
	/**
	 * 业务流水-操作类型-修改优惠兑换规则   P5
	 */
	public static String SYS_PARA_BUSI_TYPE_MODIFY_PERMISSION_BIND ="P5";
//	6）解除绑定优惠兑换规则   P6
	/**
	 * 业务流水-操作类型-删除优惠兑换规则   P6
	 */
	public static String SYS_PARA_BUSI_TYPE_DELETE_PERMISSION_BIND ="P6";

	/**
	 * 区分wap端的三个版本
	 */
	public static final String VERSION_WAP = "wap" ;
	public static final String VERSION_WAP_M = "wap_m";
	public static final String VERSION_WAP_N = "wap_n";
	
	//用于礼品分类推荐-------------------开始-------------------------------
	//用于礼品分类推荐-------------------开始-------------------------------
	//礼品分类推荐
	public static String SYS_PARA_BUSI_TYPE_WARE_SHOW_TYPE_ADD = "R1";
	
	public static String SYS_PARA_BUSI_TYPE_WARE_SHOW_TYPE_DELETE = "R2";
	
	public static String SYS_PARA_BUSI_TYPE_WARE_SHOW_TYPE_MOFIFY = "R3";
	
	//新品推荐
	
	public static String SYS_PARA_BUSI_TYPE_WARE_SHOW_TYPE_NEW_ADD = "R4";
	
	public static String SYS_PARA_BUSI_TYPE_WARE_SHOW_TYPE_NEW_DELETE = "R5";
	
	public static String SYS_PARA_BUSI_TYPE_WARE_SHOW_TYPE_NEW_MOFIFY = "R6";
	
	//品牌推荐
	public static String SYS_PARA_BUSI_TYPE_WARE_SHOW_TYPE_BRAND_ADD = "R7";
	
	public static String SYS_PARA_BUSI_TYPE_WARE_SHOW_TYPE_BRAND_DELETE = "R8";
	
	public static String SYS_PARA_BUSI_TYPE_WARE_SHOW_TYPE_BRAND_MOFIFY = "R9";
		
	public static String SYS_PARA_BUSI_TYPE_WARE_SHOW_TYPE_BRAND_RECYLE_MOFIFY = "Ra";
	
	//用于礼品分类推荐-------------------结束-------------------------------
    
    /**
     * 记录日志表BUSI_INFO操作类型OPT_TYPE 4-新增类
     */
    public static String BUSI_INFO_OPT_TYPE_ADD = "4";
    
    
    /**
     * 记录日志表BUSI_INFO操作类型OPT_TYPE 5-删除类
     */
    public static String BUSI_INFO_OPT_TYPE_DELETE = "5";
    
    /**
     * 记录日志表BUSI_INFO操作类型OPT_TYPE 6-修改类
     */
    public static String BUSI_INFO_OPT_TYPE_MODIFY_KIND = "6";
    
    /**
     * 记录日志表BUSI_INFO操作类型OPT_TYPE 7-审核类
     */
    public static String BUSI_INFO_OPT_TYPE_CHECK_KIND= "7";
    
    /**
     * 记录季度类型为第一季度
     */
    public static String ONE_SEASON= "1";
    
    /**
     * 记录季度类型为第二季度
     */
    public static String TWO_SEASON= "2";
    
    /**
     * 记录季度类型为第三季度
     */
    public static String THIRD_SEASON= "3";
    
    /**
     * 记录季度类型为第四季度
     */
    public static String FOUR_SEASON= "4";
    
    /**
     * 记录季度类型为全部季度
     */
    public static String ALL_SEASON= "-1";
    
    /**
     * 二维码订单文件名前缀
     */
    public static String BARCODE_FILE_PREFIX = "YIMA_ORDER_TO_CHONGQING_BASE_";
    
    /**
     * 订单查询类型的任务生成文件前缀
     */
    public static String ORDER_DETAIL_FILE_PREFIX ="OrderExport_";
    /**
     * 订单状态同步未成功文件对账接口文件名前缀
     */
    public static String ORDER_STATUS_SYNC_FILE_PREFIX = "Order_Status_Sync_";
    
	/**
	 * 在属性表定义表(WARE_DESC_DEFINE_INFO)中的业务属性(兑换方式)的值999999999999988，普通为0或者null，团购2，抢兑为1
	 */
	public static String WARE_DESC_GENERAL_EXCHANGE_MODE = "0";
	public static String WARE_DESC_LIMIT_EXCHANGE_MODE = "1";
	public static String WARE_DESC_TUAN_EXCHANGE_MODE = "2";
	/**
	 * 在属性表定义表（ware_info_portal）中的业务sale字段的值 0  不优惠 不展示优惠图标   1  优惠 展示优惠图标
	 */
	public static String WARE_INFO_PORTAL_SALE_NOCHEAP = "0";
	public static String WARE_INFO_PORTAL_SALE_CHEAP = "1";
	/**
	 * 专题表名
	 */
	public static final String VIP_HALL_TOPIC_TABLE_NAME = "TOPIC";
	
	/*********************** VIP贵宾厅 ****************************/
	
	/**
	 * 存储过程中使用PROC_GUIBINTING_INFO.prc相关存储，扩展函数ZH_CONCAT_IM
	 */
	public static final String KEY_LT_SPLIT = StringUtil.isBlank(PropertyReader.getProperty("vipLTCharacter")) ? "<"
			: StringUtils.trim(PropertyReader.getProperty("vipLTCharacter"));
	/**
	 * 属性和打折信息特殊字符
	 */
	public static final String KEY_AND_SPLIT = StringUtil.isBlank(PropertyReader.getProperty("vipAndCharacter")) ? "&"
			: StringUtils.trim(PropertyReader.getProperty("vipAndCharacter"));

	public static final String KEY_COLON_SPLIT = ":";


    /**
     * vip贵宾厅：基础服务内容
     */
    public final static String VIP_BASE_SERVICE_CONTENT_CONST = "999999999999956";
    
    /**
     * vip贵宾厅：是否有吸烟区
     */
    public final static String VIP_SMOKING_CONST = "999999999999955";
    
    
    /**
     * vip贵宾厅：特殊服务内容
     */
    public final static String VIP_SPECIAL_SERVICE_CONTENT_CONST = "999999999999954";
    
    
    /**
     * vip贵宾厅:服务地点
     */
    public final static String VIP_SERVICE_LOCATION_CONST = "999999999999953";
    
    
    /**
     * vip贵宾厅：服务时间
     */
    public final static String VIP_SERVICE_TIME_CONST = "100000000000047";
    
    
    /**
     * vip贵宾厅：专享热线
     */
    public final static String VIP_PRIVATE_TEL_CONST = "999999999999950";
    /**
     * vip贵宾厅：是否允许兑换
     */
    public final static String VIP_IFYXDH_CONST = "999999999999951";
    /**
     * vip贵宾厅：兑换截至日期
     */
    public final static String VIP_DHJZRQ_CONST = "999999999999952";
    
    

	/**
	 * 分号分隔符
	 */
	public static final String SPLIT_SEMCOLON = ";";

	/**
	 * 逗号分隔符
	 */
	public static final String SPLIT_COMMA = ",";
	/***************************************************/
	
	 /**
     * 业务流水-操作类型-物流费积分规则-新增
     */
    public static String SYS_PARA_BUSI_TYPE_LOGISTICTRULE_ADD = "L1";
    
	 /**
     * 业务流水-操作类型-物流费积分规则-修改
     */
    public static String SYS_PARA_BUSI_TYPE_LOGISTICTRULE_MODIFY = "L2";
    
	 /**
     * 业务流水-操作类型-物流费积分规则-删除
     */
    public static String SYS_PARA_BUSI_TYPE_LOGISTICTRULE_DELETE = "L3";
    
	 /**
     * 业务流水-操作类型-物流费积分规则-绑定
     */
    public static String SYS_PARA_BUSI_TYPE_LOGISTICTRULE_BUNDLING = "L4";
    
    
    /**
     * 业务流水-操作类型-帮助中心管理-新增
     */
    public static String SYS_PARA_BUSI_TYPE_HELPCENTERINFO_ADD = "H1";
    
	 /**
     * 业务流水-操作类型-帮助中心管理-修改
     */
    public static String SYS_PARA_BUSI_TYPE_HELPCENTERINFO_MODIFY = "H2";
    
	 /**
     * 业务流水-操作类型-帮助中心管理-删除
     */
    public static String SYS_PARA_BUSI_TYPE_HELPCENTERINFO_DELETE = "H3";
    
    
    
    
    // 省网礼品仓库类型
	public final static String WARE_HOUSE_TYPE_PROVINCE = "3";
	// 省网礼品仓库类型无库存，仓库编码为0000000
	public final static String WARE_HOUSE_TYPE_PROVINCE_WAREHOUSE_CODE = "0000000";
	// 二维码类礼品（包含卖当劳、慈铭健康服务）[全网礼品，不需要配送，同步方式：同步给礼品商或二维码]
	public static final String DIM_CODE_WARE = "15";
	// 大区仓类型
	public final static String WARE_HOUSE_TYPE_REGION = "0";

	// 中心仓类型
	public final static String WARE_HOUSE_TYPE_GLOBAL = "1";

	// 虚拟仓类型
	public final static String WARE_HOUSE_TYPE_VIRTUAL = "2";
	

	//大区仓设置任意标识
	public final static String WARE_HOUSE_TYPE_REGION_BZ = "xxxxxxx";
	
	// 全网实物类礼品 [全网礼品，全网配送，同步方式：同步给仓储商、配送商]
	public static final String GLO_LOGIC_WARE = "11";

	// 电子密码类礼品（包含虚拟电子密码类、IKang健康服务） [全网礼品，不需要配送，同步方式：同步给礼品商]
	public static final String ELE_PASSWD_WARE = "12";

	// 合作杂志类礼品 [全网礼品,礼品商配送，同步方式：同步给礼品商]
	public static final String UNI_MAG_WARE = "13";

	// 合作DIY类礼品[全网礼品，礼品商配送，同步方式：同步给礼品商]
	public static final String UNI_DIY_WARE = "14";

	// 航空里程礼品）[全网礼品，不需要配送，同步方式：同步给礼品商]
	public static final String AIR_MILES_WARE = "16";

	// 省自有业务类礼品[全网礼品，不需要配送，同步方式：同步给省公司]
	public static final String PROV_BUSINESS_WARE = "17";

	// 捐赠积分[全网礼品，不需要配送，同步方式：均不同步]
	public static final String POINT_DONATE_WARE = "18";

	// 礼品商配送（合作）类礼品[全网礼品,礼品商配送，同步方式：同步给礼品商]
	public static final String UNI_BEVERAGES_WARE = "19";

	// 加油卡类礼品 [全网礼品，不需要配送，同步方式：同步给礼品商]
	public static final String GAS_CARD_WARE = "20";
	
	//99不需要配送（浦发合作礼品）
	public static final String PUFA_EXCHANGE_WARE = "99";
	
	/**
	 * 积分值查询接口 
	 * 查询成功，报文返回成功应答码为01
	 */
	public static final String QUERY_SUCCESS = "01"; 
	

	/**
	 *  参数表 para_type_id=6
	 * 合作商类型- 运营中心
	 */
	public static String SYS_PARA_PARTNER_TYPE_MOBILE_CENTER = "0";

	/**
	 * 合作商类型-省公司
	 */
	public static String SYS_PARA_PARTNER_TYPE_MOBILE_PROVINCE = "1";
	
	/**
	 * 大区仓取不到warehouseId时，storeId = 8888888
	 */
	public static final String WARE_HOUSE_TYPE_REGION_NO_WAREHOUSE_ID_CODE= "8888888";  
	
	/**
	 * 礼品属性：是否支持在线支付
	 */
	public static final String IS_ONLINE_PAYMENT ="999999999999939";
	/**
	 * 礼品属性：是否支持线下支付
	 */
	public static final String IS_OFFLINE_PAYMENT ="999999999999938";
	/**
	 * 礼品属性：线下支付描述
	 */
	public static final String OFFLINE_PAYMENT_DESCRIBE ="999999999999937";

	/**
	 *线下支付描述业务参数表业务类型ID
	 */
	public static final String OFFLINE_PAY_DESC_PARATYPE_ID ="900000000000006";
	
	/**
	 * 礼品业务属性：银卡混合支付现金值
	 */
	public static final String SILVER_CARE_CASH= "999999999999931";
	/**
	 * 礼品业务属性：银卡混合支付积分值
	 */
	public static final String SILVER_CARE_INGEGRAL = "999999999999932";
	/**
	 * 礼品业务属性：金卡混合支付现金值
	 */
	public static final String GOLD_CARE_CASH = "999999999999933";
	/**
	 * 礼品业务属性：金卡混合支付积分值
	 */
	public static final String GOLD_CARE_INGEGRAL = "999999999999934";
	/**
	 * 礼品业务属性：钻卡混合支付现金值
	 */
	public static final String DIAMOND_CARE_CASH= "999999999999935";
	/**
	 * 礼品业务属性：钻卡混合支付积分值
	 */
	public static final String DIAMOND_CARE_INGEGRAL= "999999999999936";
	
	
	

	/**支付方式 全积分 */
	public static final String PAY_TYPE_INTEGRAL ="01";
	
	/**支付方式 积分+现金 */
	public static final String PAY_TYPE_INTEGRAL_CASH ="02";
	
	
	/**HP支付方式 全积分 */
	public static final String PAY_TYPE_HP_INTEGRAL ="03";
	
	/**HP支付方式 混合支付线上 */
	public static final String PAY_TYPE_HP_ONLINE ="01";
	
	/**HP支付方式 混合支付线下 */
	public static final String PAY_TYPE_HP_OFFLINE ="02";
	
	/**
	 * 是否支持在线支付--是
	 */
	public static final String IS_ONLINE_PAY_Y ="1";
	/**
	 * 是否支持在线支付--否
	 */
	public static final String IS_ONLINE_PAY_N ="0";
	
	/**
	 * 是否支持线下支付--是
	 */
	public static final String IS_OFFLINE_PAY_Y ="1";
	/**
	 * 是否支持线下支付--否
	 */
	public static final String IS_OFFLINE_PAY_N ="0";
	

	/**
	 * 礼品类型--普通礼品
	 */
	public static final String WARE_TYPE_NORMAL ="0";
	
	/**
	 * 礼品类型--父子类礼品
	 */
	public static final String  WARE_TYPE_PARENT ="1";
	
	/**
	 * 默认订单支付时间 24(小时) * 60（分钟）
	 */
	public static final int DEFAULT_ORDER_PAY_TIME=24 * 60;
	
	/**
	 * 用户角色-01-运营中心;02-客服基地;03-省管理员;06-省客服;07-用户
	 */
	public static final String USER_ROLE_USER="07";
	
	/**
	 * 发起方(01-省公司) 
	 */
	public static final String ORG_PROVINCE="01";
	
	/**
	 * 发起方(02-河南客服基地) 
	 */
	public static final String ORG_KFJD="02";
	
	/**
	 * 未支付订单查询支付状态 01-等待支付 
	 */
	public static final String PAY_STATUE_WAIT_PAY="01";
	
	/**
	 * 支付状态 05-取消支付 
	 */
	public static final String PAY_STATUE_CANCEL_PAY="05";
	
	/**
	 * 支付状态 06-支付过期 
	 */
	public static final String PAY_STATUE_PAY_OUTTIME="06";
	
	/**
	 * 未支付订单撤销应答码 J704-撤销成功 
	 */
	public static final String NO_PAY_ORDER_CANCEL_SUCCESS="J704";
	
	/**
	 * 团购订单查询支付状态 P10-等待支付 
	 */
	public static final String TUAN_WAIT_PAY_STATUE="P10";
	
	/**
	 * 话费直充类礼品分类ID 
	 */
	public static final long WARE_KIND_ID_TELEPHONE=100000000000065L;
	
	/**
	 *仓库省份物流流水状态--待同步 
	 */
	public static final String WAREHOUSE_LOGISTIC_BUSI_STATE_WAIT="0";
	
	/**
	 *仓库省份物流流水状态--同步中 
	 */
	public static final String WAREHOUSE_LOGISTIC_BUSI_STATE_SYNING="1";
	
	/**
	 *仓库省份物流流水状态--同步成功 
	 */
	public static final String WAREHOUSE_LOGISTIC_BUSI_STATE_SUCC="2";
	
	/**
	 *仓库省份物流流水状态--同步失败 
	 */
	public static final String WAREHOUSE_LOGISTIC_BUSI_STATE_FAIL="3";
	
	/**
	 *仓库省份物流流水状态--已生效 
	 */
	public static final String WAREHOUSE_LOGISTIC_BUSI_STATE_EFFECTIVE="4";
	
	/**
	 * 订单范围
	 */
	// 所有订单
	public static final String SEL_ALL_ORDER_SCOPE="000,001,002,003,005,006,007";
	// 有效订单
	public static final String SEL_VALID_ORDER_SCOPE="100,101,102,103,105,106,107";
	// 选择所有订单的所有订单范围时-向HP传099
	public static final String ALL_ORDER_SCOPE_TO_HP="099";
	// 选择有效订单的所有订单范围时-向HP传099
	public static final String VALID_ORDER_SCOPE_TO_HP="199";
	
	/**
	 *  订单类型
	 *  0 所有订单
	 *  1 有效订单
	 */
	public static final String ALL_ORDER_SCOPE="0";
	public static final String VALID_ORDER_SCOPE="1";
	
	 /**
	 * 抽奖基础类礼品
	 */
	public static final String AWARD_ORDER_TAKE = "1";
	
	/**
	 * 中奖礼品为积分充值类
	 */
	public static final String WINNING_ORDER_TAKE_RECHARGE = "2";
	
	/**
	 * 中奖礼品为非积分充值类
	 */
	public static final String AWARD_ORDER_TAKE_NOT_RECHARGE = "3";
	
	/**
	 * 抽奖活动前缀类型
	 */
	public static final String ORDER_AWARD_ACTION_TYPE = "07";
	
	/**
	 * 抽奖活动列表导出
	 */
	public static final String AWARD_LIST_NAME = "27";
	
	/**
	 * 礼品兑换数量限制异步导出类型
	 */
	public static final String WARE_LIMIT_EXCHANGE_NUM_NAME = "28";
	
	 /**
     * 日志业务类型：积分抽奖->积分抽奖中奖名单导出
     */
    public static String SYS_PARA_BUSI_TYPE_PARTNER_AWARD_EXPORT = "V6";
    
    /**
     * 日志业务类型：积分抽奖->积分抽奖活动导出
     */
    public static String SYS_PARA_BUSI_TYPE_LOTTERY_ACTIVITY_EXPORT = "V7";
    
    /**
     * 日志业务类型：积分抽奖->积分抽奖管理
     */
    public static String SYS_PARA_BUSI_TYPE_LOTTERY_MANAGEMENT = "V8";
    
	 /**
     * 日志业务类型：积分抽奖->新增积分抽奖
     */
    public static String SYS_PARA_BUSI_TYPE_ADD_LOTTERY = "V9";
    
	/**
     * 积分返赠任务状态为起草
     */
    public static final String RECHARGE_POINTS_TASK_STATUS_DRAFT= "01";
    public static final String RECHARGE_POINTS_TASK_NAME_DRAFT= "起草";
    /**
     * 积分返赠任务状态为待审核
     */
    public static final String RECHARGE_POINTS_TASK_STATUS_NOTVERIFY= "02";
    public static final String RECHARGE_POINTS_TASK_NAME_NOTVERIFY= "待审核";
    /**
     * 积分返赠任务状态为初审通过
     */
    public static final String RECHARGE_POINTS_TASK_STATUS_FIRSTVERIFY= "03";
    public static final String RECHARGE_POINTS_TASK_NAME_FIRSTVERIFY= "初审通过";

    /**
     * 积分返赠任务状态为初审不通过
     */
    public static final String RECHARGE_POINTS_TASK_STATUS_NOTFIRSTVERIFY= "04";
    public static final String RECHARGE_POINTS_TASK_NAME_NOTFIRSTVERIFY= "初审不通过";
    /**
     * 积分返赠任务状态为审核通过
     */
    public static final String RECHARGE_POINTS_TASK_STATUS_SECONDVERIFY= "05";
    public static final String RECHARGE_POINTS_TASK_NAME_SECONDVERIFY= "审核通过";
    /**
     * 积分返赠任务状态为审核不通过
     */
    public static final String RECHARGE_POINTS_TASK_STATUS_NOTSECONDVERIFY= "06";
    public static final String RECHARGE_POINTS_TASK_NAME_NOTSECONDVERIFY= "审核不通过";
	/**
     * 积分返赠任务状态为审核废止
     */
    public static final String RECHARGE_POINTS_TASK_STATUS_ABOLISH= "07";
    public static final String RECHARGE_POINTS_TASK_NAME_ABOLISH= "废止";
    
    /**
     * 积分返赠 审核操作类型(00:审核通过；01：审核不通过)
     */
    public static final String RECHARGE_POINTS_AUDIT_OPERATOR_PASS= "00";
    public static final String RECHARGE_POINTS_AUDIT_OPERATOR_NOPASS= "01";
    
    /**
     * 积分返赠 审核类型（01：初审；02：复审）
     */
    public static final String RECHARGE_POINTS_AUDIT_FIRST_TRIAL= "01";
    public static final String RECHARGE_POINTS_AUDIT_REPEAT_TRIAL= "02";
	
    /**
     * 积分返赠页面标识管理页
     */
    public static final String RECHARGE_POINTS_TASK_JSP_MANAGER="01";
    /**
     * 积分返赠页面标识初审页
     */
    public static final String RECHARGE_POINTS_TASK_JSP_FIRST_TRIAL="02";
    /**
     * 积分返赠页面标识复审页
     */
    public static final String RECHARGE_POINTS_TASK_JSP_REPEAT_TRIAL="03";
    /**
     * 积分返赠任务类型为实时
     */
    public static final String RECHARGE_POINTS_TASK_TYPE_NOW="00";
    public static final String RECHARGE_POINTS_TASK_NAME_NOW="实时";
    /**
     * 积分返赠任务类型为定时
     */
    public static final String RECHARGE_POINTS_TASK_TYPE_TIMING="01";
    public static final String RECHARGE_POINTS_TASK_NAME_TIMING="定时";
    /**
     * 积分返赠任务是否发送短信：否
     */
    public static final String RECHARGE_POINTS_TASK_IS_SEND_SMS_NO="0";
    /**
     * 积分返赠任务是否发送短信：是
     */
    public static final String RECHARGE_POINTS_TASK_IS_SEND_SMS_YES="1";
    /**
     * 积分返赠--任务处理状态：未处理
     */
    public static final String RECHARGE_POINTS_TASK_MANAGE_STATUS_UNFINISH="00";
    /**
     * 积分返赠--文件处理状态：处理中
     */
    public static final String RECHARGE_POINTS_TASK_MANAGE_STATUS_DEALING="01";
    /**
     * 积分返赠--文件处理状态：处理失败
     */
    public static final String RECHARGE_POINTS_TASK_MANAGE_STATUS_FAILURE="02";
    /**
     * 积分返赠--任务处理状态：处理成功
     */
    public static final String RECHARGE_POINTS_TASK_MANAGE_STATUS_FINISHED="03";
    /**
     * 积分返赠--文件处理状态：未处理
     */
    public static final String RECHARGE_POINTS_FILE_MANAGE_STATUS_UNFINISH="00";
    /**
     * 积分返赠--文件处理状态：处理中
     */
    public static final String RECHARGE_POINTS_FILE_MANAGE_STATUS_DEALING="01";
    /**
     * 积分返赠--文件处理状态：处理失败
     */
    public static final String RECHARGE_POINTS_FILE_MANAGE_STATUS_FAILURE="02";
    /**
     * 积分返赠--文件处理状态：处理成功
     */
    public static final String RECHARGE_POINTS_FILE_MANAGE_STATUS_SUCCESS="03";
    /**
     * 积分返赠--文件可废止状态
     */
    public static final String RECHARGE_POINTS_TASK_STATUS_CAN_ABOLISH="'01','02','03','04','06'";
    /**
     * 积分返赠--文件处理完结状态（无回执文件）
     */
    public static final String RECHARGE_POINTS_FILE_STATUS_FINISHED_HASNOT_FILE="J904,J906,J907,J909,J910,J917,J918,J915,J919,J920";
    /**
     * 积分返赠--文件处理完结状态（有回执文件）
     */
    public static final String RECHARGE_POINTS_FILE_STATUS_FINISHED_HAS_FILE="J916";
    /**
     * 积分返赠--可以撤销的文件状态
     */
    public static final String RECHARGE_POINTS_FILE_STATUS_REPEAL="J903,J905,J908,J911,J912";
    /**
     * 积分返赠--文件处理未完结状态
     */
    public static final String RECHARGE_POINTS_FILE_STATUS_UNFINISH="J903,J911,J905,J908,J912,J913,J914";
    /**
	 * 积分返赠文件的上传临时路径
	 */	
	public final static String UPLOAD_TMP_RECHARGE_POINTS_FILE_PATH = "upload_tmp_recharge_points_file_path";
	/**
	 * 积分返赠文件的ftp路径
	 */	
	public final static String FTP_RECHARGE_POINTS_TASK_PATH = "ftp_recharge_points_task_path";
	
   //-----------------增加兑换限制数量日志类型 
	/**
	 * 业务流水-操作类型-新增配置兑换
	 */
    public static String SYS_PARA_BUSI_TYPE_LIMITNUM_ADD = "H4";
    
	 /**
     * 业务流水-操作类型-修改配置兑换
     */
    public static String SYS_PARA_BUSI_TYPE_LIMITNUM_MODIFY = "H5";
    
	 /**
     * 业务流水-操作类型-绑定兑换限制
     */
    public static String SYS_PARA_BUSI_TYPE_LIMITNUM_BIND = "H6";	
    
	/**
	 * 积分返赠文件的下载的临时路径
	 */	
	public final static String DOWNLOAD_TMP_RECHARGE_POINTS_TASK_PATH = "download_tmp_recharge_points_file_path";
	
	/**
	 * 积分返赠文件更新结果文件的ftp路径
	 */	
	public final static String FTP_RECHARGE_POINTS_TASK_RESULT_PATH = "ftp_recharge_points_task_result_path";
	
	/**
	 * 积分返赠记录操作日志标记
	 */
	public static String SYS_PARA_BUSI_TYPE_DELETE_RECHARGE_TASK="RP";
	
	/**
	 * 积分转赠受让人状态  00-全部
	 */
	public static String CURRENT_ASSIGNEE_STATUS="00";
	/**
	 * 积分转赠受让人状态  01-已生效
	 */
	public static String CURRENT_ASSIGNEE_STATUS_EFFECT="01";
	/**
	 * 积分转赠受让人状态  02-待生效
	 */
	public static String CURRENT_ASSIGNEE_STATUS_UNEFFECT="02";
	/**
	 * 积分转赠受让人状态  03-停用
	 */
	public static String CURRENT_ASSIGNEE_STATUS_DISCARD="03";
	
	/**
	 * 0-启用
	 */
	public static final String ENABLE = "0";
	/**
	 * 1-停用
	 */
	public static final String DISABLE = "1";
	
	/**
	 * 1-展示
	 */
	public static final String IS_SHOW = "1";
	/**
	 * 0-不展示
	 */
	public static final String NOT_SHOW = "0";
	
	/**
	 * 触屏版展示模板
	 */
	public static final String SHOW_TEMPLATE_TYPE = "900000000000034";
	
	/**
	 * 触屏版广告类型
	 */
	public static final String MOBILE_AD_PIC_TYPE = "12";
	
	/**
	 * 楼层绑定规则专题类型
	 */
	public static final String RECOMMEND_TYPE_TOPIC = "002";
	/**
	 * 楼层绑定规则大类类型
	 */
	public static final String RECOMMEND_TYPE_KIND = "001";
	
	/**
	 * 活动类型 
	 * 01 抢兑
	 * 02 团购
	 * 08 打包
	 */
	public static final String ACTIVITY_RUSHBUY = "01";
	public static final String ACTIVITY_TUAN = "02";
	public static final String ACTIVITY_PACKAGE = "08";
	
	/**
	 * mPhoneServer服务的配置文件
	 */
	public static final String MPHONE_PROPS_FILE = "mphone.properties";
	
    /**
     * 访问mPhoneServer鉴权接口
     */
    public static final String MPHONE_CLIENT_SERVER_URL = "mphone_client_server_url";
    
    /**
     * 业务流水-操作类型-门户首页O2O(操作类型常量在sys_para_data 对应para_type_id=5)
     */
    public static String BUSI_TYPE_O2O_CREATE = "O1";
    public static String BUSI_TYPE_O2O_DELETE = "O2";
    public static String BUSI_TYPE_O2O_UPDATE = "O3";
    public static String BUSI_TYPE_O2O_BIND   = "O4"; 
      
    /**
     * 业务流水-操作类型-门户首页精品推荐  
     */
    public static String BUSI_TYPE_FINERECOMON_CREATE = "1R";
    public static String BUSI_TYPE_FINERECOMON_DELETE = "2R";
    public static String BUSI_TYPE_FINERECOMON_UPDATE = "3R";
    
}
