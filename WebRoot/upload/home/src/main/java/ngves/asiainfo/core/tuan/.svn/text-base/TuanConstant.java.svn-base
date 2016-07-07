/**
 * Copyright (c) 2011 asiainfo.com
 */
package ngves.asiainfo.core.tuan;

import ngves.asiainfo.util.PropertyReader;

/**
 * 团购活动中的常量
 * 
 * @author asiainfo
 * 
 */
public class TuanConstant {

	// 最大团购量
	public static final int TUAN_MAX_AMOUNT_BUY = 99999999;
	// 单人最大购买量
	public static final int TUAN_MAX_AMOUT_SINGLE_BUY = 99999999;
	// 最低人数限制
	public static final int TUAN_MIN_LIMIT_NUMBER = 999999;
	// 团购活动排序最大数
	public static final int TUAN_MAX_SORT_SINGLE_BUY = 99999999;
	// 活动排序默认数值
	public static final int TUAN_TUAN_SORT_SINGLE_BUY = 99999999;
	//提供默认的置顶标识(1：置顶，0：不置顶)
	public static final int DFAULT_TOP_FLAG = 0;
	
	// 团购活动中礼品绑定 图片大小 先提供两种格式的图片 240/110
	public static final String TUAN_WARE_SHOW_IMG_PX_110 = "_110.";
	public static final String TUAN_WARE_SHOW_IMG_PX_240 = "_240.";

	// 团购活动主图片
	public static final String TUAN_WARE_SHOW_MAIN_IMG_PX = ".";

	// 团购活动是否在前台显示 0：不显示 1：显示
	public static final String TUAN_IS_VIEW_YES = "1";
	public static final String TUAN_IS_VIEW_NO = "0";

	// 团购活动是否支持所有省份 0：不支持 1：支持
	public static final String TUAN_IS_ALL_PROV_YES = "1";
	public static final String TUAN_IS_ALL_PROV_NO = "0";

	// 团购活动的状态 0 表示创建 1 表示发布 2 表示停止 3团购已经发布但是未开始
	public static final String TUAN_STATUS_CREATE = "0";
	public static final String TUAN_STATUS_PUBLISH = "1";
	public static final String TUAN_STATUS_STOP = "2";
	public static final String TUAN_STATUS_NOT_START = "3";

	/**
	 * 团购活动中，省份信息的分割符号
	 */
	public static final String TUAN_PROVINCE_SPLIT_CODE = ",";
	// 团购省份信息，是否被选择 1 被选择 0没有被选择
	public static final String TUAN_PROVINCE_VALID_YES = "1";
	public static final String TUAN_PROVINCE_VALID_NO = "0";

	/**
	 * 用户抢中状态-下单成功
	 */
	public static final String ACTIVITY_LIMIT_USER_LOG_STATE_EXCHANGED = "1";

	/**
	 * 团购返回前台常量串定义
	 */
	// 开始时间
	public static final String TUAN_VIEW_START_TIME = "tuanStartTime";
	// 结束时间
	public static final String TUAN_VIEW_END_TIME = "tuanEndTime";
	// 活动状态
	public static final String TUAN_VIEW_STATUS = "tuanViewStatus";
	// 活动剩余时间
	public static final String TUAN_VIEW_LEFT_TIME = "LeftTime";
	public static final String TUAN_VIEW_LEFT_END_TIME = "leftEndTime";

    public static final String TUAN_CURRENT_TIME = "timeAsNow";
	/**
	 * 团购活动状态--终止(活动进行中强行终止)
	 */
	public static final String TUAN_INFO_STATUS_STOP = "2";

	// add by liuyq
	// 团购活动是否支持单次是否允许购买多个礼品
	// 不允许购买多个礼品
	public static final String TUAN_IS_ORDER_MULTI_NO = "0";

	// 允许购买多个礼品
	public static final String TUAN_IS_ORDER_MULTI_YES = "1";

	// add by liuyq
	// date 2011-07-20
	// 修改团购活动中，团购的状态
	// 允许修改全部
	public static final String TUAN_MODIFY_ALL_CAN_MODIFY = "TuanModifyAll";

	// 允许修改部分
	public static final String TUAN_MODIFY_PART_CAN_MODIFY = "TuanModifyPart";

	// 不允许修改，查看操作
	public static final String TUAN_MODIFY_NONE_CAN_MODIFY = "TuanModifyNone";

	// 情况不存在
	public static final String TUAN_MODIFY_SITUATION_NOT_EXIST = "TuanModifyNotExist";

	// 团购活动中，判断团购时间进行的状态
	// 当前时间在团购活动开始时间之前
	public static final String TUAN_STATUS_BEFORE_START = "before";
	// 当前时间在团购活动开始时间和结束时间之间
	public static final String TUAN_STATUS_BETWEEN_START_END = "between";
	// 当前时间在团购活动在结束时间之后
	public static final String TUAN_STATUS_AFTER_END = "after";

	// 团购活动上传图片时，图片大小限制 KB
	public static final int MAX_PIC_FILE_SIZE = 1024;
	
	//捐赠对象上传图片大小限制，60kb
	public static final int MAX_DONATION_OBJECT_PIC_FILE_SIZE = 61440;

	// 团购活动图片，图片宽度限制 950px
	public static final int MAX_PIC_WIDTH_SIMPLE = 450;
	
	public static final int MAX_PIC_HEIGHT_SIMPLE = 350;

	// 团购图片 访问路径
	public static final String PIC_TUAN_URL_KEY = "pic.tuan.url";
	public static final String PIC_TUAN_URL = PropertyReader.getProperty(TuanConstant.PIC_TUAN_URL_KEY);
	
	//团购活动礼品前台展示路径
	public static final String TUAN_PORTAL_URL_KEY="tuan.http.url";
	public static final String TUAN_PORTAL_URL= PropertyReader.getProperty(TuanConstant.TUAN_PORTAL_URL_KEY);
	public static final String PORP_AI_PIC_TUAN_PATH = "pic.tuan.path";


	public static final String TUAN_ORDER_SERVICE = "portal.tuanOrderSrv";

	public static final String SELECT_MUL_MOUNT_PAGE = "/tuan/selectWareMount.jsp";
	public static final String TUAN_LD_PAGE = "/tuan/tuan_ld.jsp";

	/**
	 * 放置到session中的管理用户信息
	 */
	public static final String MGT_USER_INFO = "mgtUserInfo";

	/**
	 * 存在相同的团购名称
	 */
	public static final String TUAN_NAME_CONFLICT_YES = "1";
	/**
	 * 不存在相同的团购名称
	 */
	public static final String TUAN_NAME_CONFLICT_NO = "0";

	/**
	 * 团购绑定礼品操作名称，前台选择的操作是
	 * */
	// delete: 取消团购与礼品的绑定关系
	public static final String ACTION_DELETE_TUAN_WARE_BIND = "delete";
	// publish: 发布团购与礼品的绑定关系 (前台选择了保存并发布)
	public static final String ACTION_PUBLISH_TUAN_WARE_BIND = "publish";
	// view : 保存并预览团购与礼品的绑定关系(前台选择了保存并预览)
	public static final String ACTION_VIEW_TUAN_WARE_BIND = "view";
	
	/**
	 * 团购绑定礼品操作中，存在并发操作，团购活动绑定信息保存失败
	 */
	public static final long TUAN_RETVAL_UPDATE_BIND_WARE_CONCURRENT = -1;
	
	/**
	 * 团购活动绑定礼品操作的返回值，新增绑定礼品时，存在并发操作。
	 */
	public static final long TUAN_RETVAL_NEW_BIND_WARE_CONCURRENT = -2;
	
	public static final long TUAN_RETVAL_NO_OPERATION = 1;
	
	//@团购二期需求开发
	//由于增加了团购与HP增量同步的接口，所以要定义接口返回值的常量说明
	//团购信息同步给HP时，发生失败
	public static final long TUAN_RETVAL_SYN_HP_FAIL = -3;
	//	G702	更新失败
	public static final long TUAN_RETVAL_SYN_HP_FAIL_G702 = -4;
	//	G703	其他错误
	public static final long TUAN_RETVAL_SYN_HP_FAIL_G703 = -5;
	//	G704	新增团兑信息中的结束时间早于开始时间
	public static final long TUAN_RETVAL_SYN_HP_FAIL_G704 = -6;
	//	G705	新增团兑信息中的开始时间已晚于当前时间
	public static final long TUAN_RETVAL_SYN_HP_FAIL_G705 = -7;
	//	G706	团兑活动已结束，不能修改活动基本信息
	public static final long TUAN_RETVAL_SYN_HP_FAIL_G706 = -8;
	//	G707	团兑活动已开始，只能修改活动名称、活动结束时间，其他活动信息不可修改
	public static final long TUAN_RETVAL_SYN_HP_FAIL_G707 = -9;
	//	G708	团兑活动已开始，不能删除活动基本信息
	public static final long TUAN_RETVAL_SYN_HP_FAIL_G708 = -10;
	//	G709	团兑活动基本信息同步中，没有产品信息
	public static final long TUAN_RETVAL_SYN_HP_FAIL_G709 = -11;
	//	G710	团兑活动ID不存在，修改失败
	public static final long TUAN_RETVAL_SYN_HP_FAIL_G710 = -12;
	
	
	//@团购二期需求开发
	//HP 团购增量信息同步接口报文的特定返回值
	//团购活动与HP进行同步时,同步返回成功
	public static final String TUAN_INFO_SYN_HP_SUCC = "0000";
	//团购活动与HP进行同步时,同步返回失败(校验报文格式时出错)
	public static final String TUAN_INFO_SYN_HP_ERR = "1000";
	//	G702	更新失败
	public static final String TUAN_INFO_SYN_HP_UPDATE_ERR = "G702";
	//	G703	其他错误
	public static final String TUAN_INFO_SYN_HP_OTHER_ERR = "G703";
	//	G704	新增团兑信息中的结束时间早于开始时间
	public static final String TUAN_INFO_SYN_HP_NEW_ENDTIME_BEFORE_STARTTIME="G704";
	//	G705	新增团兑信息中的开始时间已晚于当前时间
	public static final String TUAN_INFO_SYN_HP_NEW_STARTTIME_AFTER_CURRTIME="G705";
	//	G706	团兑活动已结束，不能修改活动基本信息
	public static final String TUAN_INFO_SYN_HP_TUAN_FINISHED="G706";
	//	G707	团兑活动已开始，只能修改活动名称、活动结束时间，其他活动信息不可修改
	public static final String TUAN_INFO_SYN_HP_TUAN_STARTED_MODIFY_LIMITED="G707";
	//	G708	团兑活动已开始，不能删除活动基本信息
	public static final String TUAN_INFO_SYN_HP_TUAN_STARTED_DELETE_LIMITED="G708";
	//	G709	团兑活动基本信息同步中，没有产品信息
	public static final String TUAN_INFO_SYN_HP_TUAN_NO_WAREID="G709";
	//	G710	团兑活动ID不存在，修改失败
	public static final String TUAN_INFO_SYN_HP_TUAN_NO_TUANID="G710";
	
	
	
	//团购活动与HP进行同步时，团购ID前面加的固定字符串标识
	public static final String TUAN_INFO_SYN_HP_TUAN_ID_PREFIX ="02";
	
	//团购活动与HP进行同步时，团购信息的操作类型--新增
	public static final String TUAN_INFO_SYN_HP_TUAN_OPT_TYPE_ADD = "01";
	
	//团购活动与HP进行同步时，团购信息的操作类型--修改
	public static final String TUAN_INFO_SYN_HP_TUAN_OPT_TYPE_MODIFY = "02";
	
	//团购活动与HP进行同步时，团购订单类型，固定00(达到团兑数量下限即开始拆单)
	public static final String TUAN_INFO_SYN_HP_TUAN_OPT_ORDER_TYPE_DEFAULT ="00";

    /**
     * ORDTYPE订单类型
     *   00：打折活动订单、01：抢兑活动订单、02：团兑活动订单、03：捐赠活动订单
     */
    public static final String TUAN_ORD_TYPE_CONST = "02";
    
    /**
     * 团购活动修改成功
     */
    public static final String TUAN_INFO_MODIFY_SUCCESS = "SUCCESS";
    
    /**
     * 团购活动修改失败
     */
    public static final String TUAN_INFO_MODIFY_FAILURE = "FAILURE";

    //团购三期-main_pic字段无效，任意默认数值
    public static final	String TUAN_MAIN_PIC_DEFAULT= "9999999999999.jpg";
    
    /**
     * 团兑订单状态-团兑失败（对应hp后台查询状态P04-团兑失败） 
     */
    public static final String TUAN_ORDER_STATUS_FAIL="团兑失败";
   
    /**
     * 团兑订单状态-未成团（对应hp后台查询状态P00-订单预处理、P01-积分扣减成功、P02-积分扣减失败） 
     */
    public static final String TUAN_ORDER_STATUS_WCY="未成团";
    
    /**
     *团兑订单状态- P03-团兑成功
     */
    public static final String TUAN_ORDER_STATUS_TDCG="团兑成功";
    /**
     * 团购状态：P00-订单预处理
     */
    public static final String TUAN_ORDER_STATUS_CONST_P00="P00";
    
    /**
     * 团购状态：P01-积分扣减成功
     */
    public static final String TUAN_ORDER_STATUS_CONST_P01="P01";
    
    /**
     * 团购状态：P02-积分扣减失败
     */
    public static final String TUAN_ORDER_STATUS_CONST_P02="P02";
    
    
    /**
     * 团购状态：P03-团兑成功
     */
    public static final String TUAN_ORDER_STATUS_CONST_P03 = "P03";
    
    /**
     * 团购状态：P04-团兑失败
     */
	public static final String TUAN_ORDER_STATUS_CONST_P04 = "P04";
    
	
	/**
     * 团购状态：007 - 已完结
     */
	public static final String TUAN_ORDER_STATUS_CONST_007 = "007";
	/**
     * 团购状态：008-用户拒收
     */
	public static final String TUAN_ORDER_STATUS_CONST_008 = "008";
	/**
     * 团购状态：012-无人签收货品回库
     */
	public static final String TUAN_ORDER_STATUS_CONST_012 = "012";
	/**
     *团兑订单状态- 团购成团
     */
    public static final String TUAN_ORDER_STATUS_TGCT="团购成团";
    
    /**
     混合支付——支付类型 :01全积分;02现金+积分;01,02选择两种支付类型
     * */
    public static final String TUAN_PAY_TYPE_INTEGRAL="01";
   
	public static final String TUAN_PAY_TYPE_INTEGRAL_CASH ="02";
	
}
