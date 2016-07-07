/**
 * Copyright (c) 2010 asiainfo.com
 * 2010-10-26 上午10:26:45
 */
package ngves.asiainfo.core.ware;

import java.util.HashMap;
import java.util.Map;


/**
 * 礼品相关静态常量
 * 
 * @author huangsong
 */
public class WareConstant {
	
	/**
	 * 品牌推荐轮换开关
	 * 1-开 ,0-关
	 */
	public static final String BRAND_SPELL_SWITCH = "1";
	/**
	 * 礼品图片状态-待审核
	 */
	public static final String WARE_PIC_AUDIT = "1";

	/**
	 * 礼品图片状态-审核不通过
	 */
	public static final String WARE_PIC_AUDIT_FAIL = "2";

	/**
	 * 礼品图片状态-上线
	 */
	public static final String WARE_PIC_SUCC = "3";

	/**
	 * 礼品图片状态-在用待审核
	 */
	public static final String WARE_PIC_SUCC_AUDIT = "4";

	/**
	 * 礼品图片状态-删除
	 */
	public static final String WARE_PIC_DEL = "5";

	/**
	 * 礼品主图片 :1
	 */
	public static final String WARE_PIC_MAIN = "1";

	/**
	 * 礼品非主图片 :0
	 */
	public static final String WARE_PIC_NO_MAIN = "0";

	/**
	 * SYS_FILE_INFO表FILE_TYPE,0:礼品图片
	 */
	public static final String FILE_TYPE_WARE = "0";
	/**
	 * SYS_FILE_INFO表FILE_TYPE,1:礼品活动图片
	 */
	public static final String FILE_TYPE_ACTIVITY = "1";
	/**
	 * SYS_FILE_INFO表FILE_TYPE,2:礼品wap图片
	 */
	public static final String FILE_TYPE_WAP = "2";
	
	
	/**
	 * 礼品属性分类，该表中的属性手动维护，见表ware_desc_use_info 
	 * 因礼品属性排序需求，特将原五类属性重新化分为新五类，如下
	 * 原：普通属性、业务属性、招标属性、VIP属性、子礼品属性
	 * 新：普能属性、业务属性、子礼品属性、定制属性、提示属性
	 * 2013-5-29 by luohuan
	 */
	//普能属性
	public static final String PORATL_WARE_DESC_USE = "100000000000000";
	//礼品销售（运营）属性
	public static final String PORTAL_WARE_DESC_USE_BUSINESS = "100000000000001";
	//子礼品属性
	public static final String PORTAL_WARE_DESC_USE_CHILD = "100000000000004";
	//定制属性
	public static final String PORTAL_WARE_DESC_USE_CUSTOM = "100000000000005";
	//提示属性
	public static final String PORTAL_WARE_DESC_USE_REMIND = "100000000000006";

	/**
	 * 没有属性值的情况
	 */
	public static final String DESC_NULL = "无";
	/**
	 * 礼品默认小类
	 */
	public static String WARE_DEFAULT_KIND = "1";

	/**
	 * 业务属性--短信兑换码
	 */
	public static final String MOBILE_EXCHANGE_CODE = "短信兑换码";

	/**
	 * 短信兑换码define_id--业务属性
	 */
	public static final long MOBILE_EXCHANGE_DEFINE_ID = 999999999999999L;
	
	/**
	 * 是否展示短信兑换码define_id--业务属性
	 */
	public static final long VIEW_SMS_DEFINE_ID = 999999999999960L;

	/**
	 * 兑换渠道define_id--业务属性
	 */
	public static final long EXCHANGE_TYPE_DEFINE_ID = 999999999999996L;
	
	/**
	 * 结算方式define_id--业务属性
	 */
	public static final long SETTLE_TYPE_DEFINE_ID=999999999999975L;
	/**
	 * ware_desc_define_info表字段属性，礼品重要提示属性
	 */
	public static final long IMPORTANT_DESC_DEFINE_ID = 999999999999995L;
	
	/**
	 * 合作杂志类礼品 [全网礼品,礼品商配送，同步方式：同步给礼品商]
	 */
	public static final String UNI_MAG_WARE = "13";

	/**
	 * 兑换渠道中的sms兑换，既可以支持短信兑换
	 */
	public static final String EXCHANGE_TYPE_SMS = "4";
	/**
	 * 国航里程数(公里)属性
	 */
	public static final String AIR_MILES_DESC_DEFINE_ID = "999999999999984";
	
	/**
	 * 浦发银行年费礼品属性  年费属性ID 999999999999973
	 */
	public static final String SPDBANK_ANNUAL_FEE_ID = "999999999999973";

	/**
	 * 浦发银行积分礼品属性  积分值属性ID 999999999999972 
	 */
	
	public static final String SPDBANK_JF_DEFINE_ID ="999999999999972";
	
	/**
	 * 前台查询条件没有数值用-1代替
	 */
	public static final String QUERY_CONDITION_NO_VALUE= "-1";
	/**
	 * 国家大剧院
	 */
	public static final String NATIONAL_GRAND_THEATER = "999999999999978";
	
	
	/**
	 * 在线选座礼品URL
	 */
	public static final String SEAT_CHANGE_ONLINE_URL = "999999999999969";
	
	/**
	 * 是否结算二维码费用
	 */
	public static final String SEMACODE_IS_ACCOUNT = "999999999999966";
	
	/**
	 * 是否支持抽奖方式
	 */
	public static final String SUPPORT_IS_LOTTERY = "999999999999930";
	/**
	 * 二维码订单结算状态
	 */
	public static final String SEMACODE_SETTLE_STATUS = "999999999999965";
	
	/**
	 * 二维码结算价格
	 */
	public static final String SEMACODE_PRICE = "999999999999964";
	
	/**
	 * 是否允许搜索
	 */
	public static final String IS_SEARCH = "999999999999963";
	
	/**
	 * 是否允许转赠
	 */
	public static final String IS_DONATED = "999999999999974";
	
	/**
	 * 是否存在有效期
	 */
	public static final String IS_USE_DATE = "999999999999959";
	/**
	 * 有效期（天）
	 */
	public static final String USE_DAYS = "999999999999958";
	/**
	 * 即将过期提醒天数（天）
	 */
	public static final String LIMIT_DAYS = "999999999999957";
	/**
	 * 发码类型
	 */
	public static final String SEND_CODE_TYPE = "999999999999901";
	/**
	 * 有效期类型
	 */
	public static final String USE_DATE_TYPE = "999999999999902";
	/**
	 * 有效截止日期
	 */
	public static final String USE_DATE_TIME = "999999999999903";
	/**
	 * 即将过期提醒日期
	 */
	public static final String LIMIT_USE_DATE_TIME = "999999999999904";
	
	
	/**
	 * 礼品种类--子礼品标识 1  父礼品为null
	 */
	public static final long  WARE_TYPE_CHILDREN = 1;
	
	/**
	 * 礼品上线操作
	 */
	public static final String SYS_UP_OPERATE = "0";
	
	/**
	 * 礼品下线操作
	 */
	public static final String SYS_DOWN_OPERATE = "1";
	
	/**
	 * 礼品状态，未上线 0
	 */
	public static final String SYS_CORE_WARE_STATUS_NOT_ONLINE = "0";
	/**
	 * 礼品状态 ，上线 1 
	 */
	public static final String SYS_CORE_WARE_STATUS_ONLINE  = "1";
	/**
	 * 礼品状态 ，下线 2 
	 */
	public static final String SYS_CORE_WARE_STATUS_OFFLINE = "2";
	
	/**
	 * 父礼品IS_ONLINE状态：未上线
	 */
	public static final String SYS_CORE_PARENT_WARE_STATUS_NOT_ONLINE = "0";
	/**
	 * 父礼品IS_ONLINE状态：上线
	 */
	public static final String SYS_CORE_PARENT_WARE_STATUS_ONLINE = "1";
	/**
	 * 父礼品IS_ONLINE状态：下线
	 */
	public static final String SYS_CORE_PARENT_WARE_STATUS_OFFLINE ="2";
	
	
	
	
	
	/*
	 * 品牌编码详见common  ngves.asiainfo.CommnConstant.CUS_BRAND_QQT...
	 * 
	 * */
	
	//HP方使用编码
	//积分查询品牌类型(全球通,动感地带,神州行)
	public static final String POINT_QUERY_BRAND_QQT = "0";
	public static final String POINT_QUERY_BRAND_EASYOWN = "1";
	public static final String POINT_QUERY_BRAND_MZONE = "2";
	
	/**
     *星级
     *13-未评级
     *12-准星
     *11-一星
     *10-二星
     *09-三星
     *08-四星
     *07-五星
     *06-五星（金）
     *05-五星(钻)
     */
    public static final String STAR_LEVEL_UNRATED = "13";
    public static final String STAR_LEVEL_TOBE = "12";
    public static final String STAR_LEVEL_ONE = "11";
    public static final String STAR_LEVEL_TWO = "10";
    public static final String STAR_LEVEL_THREE = "09";
    public static final String STAR_LEVEL_FOUR = "08";
    public static final String STAR_LEVEL_FIVE = "07";
    public static final String STAR_LEVEL_FIVE_GOLD = "06";
    public static final String STAR_LEVEL_FIVE_DIAMOND = "05";
    /**
     * 星级 展示值
     */
    public static final String STAR_LEVEL_UNRATED_VIEW	= "未评级";
    public static final String STAR_LEVEL_TOBE_VIEW 	= "准星";
    public static final String STAR_LEVEL_ONE_VIEW 		= "一星";
    public static final String STAR_LEVEL_TWO_VIEW 		= "二星";
    public static final String STAR_LEVEL_THREE_VIEW 	= "三星";
    public static final String STAR_LEVEL_FOUR_VIEW 	= "四星";
    public static final String STAR_LEVEL_FIVE_VIEW 	= "五星";
    public static final String STAR_LEVEL_FIVE_GOLD_VIEW = "五星金";
    public static final String STAR_LEVEL_FIVE_DIAMOND_VIEW = "五星钻";
	
	
	//全球通展示值
	public static final String MOBILE_BRAND_GOTONE_VIEW = "全球通";
	
	//动感地带展示值
	public static final String MOBILE_BRAND_MZONE_VIEW = "动感地带";

	//神州行展示值
	public static final String MOBILE_BRAND_EASYOWN_VIEW = "神州行";
	
	//积分查询等级
	public static  Map<String,String> POINT_QUERY_LEVEL_MAP = new HashMap<String,String>();
	
	public static  Map<String,String> POINT_QUERY_STATUS_MAP = new HashMap<String,String>();
	
	public static  Map<String,String> POINT_QUERY_TYPE_MAP = new HashMap<String,String>();
	
	//初始化积分查询信息
	static {
		
		//初始化积分查询等级分配
		POINT_QUERY_LEVEL_MAP.put("100","普通客户");
		POINT_QUERY_LEVEL_MAP.put("200","重要客户");
		POINT_QUERY_LEVEL_MAP.put("201","党政机关客户");
		POINT_QUERY_LEVEL_MAP.put("202","军、警、安全机关客户");
		POINT_QUERY_LEVEL_MAP.put("203","联通合作伙伴客户");
		POINT_QUERY_LEVEL_MAP.put("204","英雄、模范、名星类客户");
		POINT_QUERY_LEVEL_MAP.put("300","普通大客户");
		POINT_QUERY_LEVEL_MAP.put("301","钻石卡大客户");
		POINT_QUERY_LEVEL_MAP.put("302","金卡大客户");
		POINT_QUERY_LEVEL_MAP.put("303","银卡大客户");
		POINT_QUERY_LEVEL_MAP.put("304","贵宾卡大客户");
		
		
		//初始化积分查询用户状态信息
		POINT_QUERY_STATUS_MAP.put("00", "正常");
		POINT_QUERY_STATUS_MAP.put("01", "单向停机");
		POINT_QUERY_STATUS_MAP.put("02", "停机");
		POINT_QUERY_STATUS_MAP.put("03", "预销户");
		POINT_QUERY_STATUS_MAP.put("04", "销户");
		POINT_QUERY_STATUS_MAP.put("05", "过户");
		POINT_QUERY_STATUS_MAP.put("06", "改号");
		POINT_QUERY_STATUS_MAP.put("90", "神州行用户");
		POINT_QUERY_STATUS_MAP.put("99", "此号码不存在");
		
		//初始化用户积分类型
		POINT_QUERY_TYPE_MAP.put("01", "消费积分");
		POINT_QUERY_TYPE_MAP.put("02", "促销回馈积分");
		
	}
	
	
	
	
	//礼品不支持该品牌后，该数值在程序中填写为-1,用来和真正的0积分礼品进行区分。
	public static final long WARE_INTEGRAL_NULL_VALUE = -1L;

	
	/**
	 * 人工上线操作
	 */
	public static final String SYS_CORE_WARE_STATUS_OPER_TYPE_MANUAL_ONLINE ="0";

	/**
	 * 人工下线操作
	 */
	public static final String SYS_CORE_WARE_STATUS_OPER_TYPE_MANUAL_OFFLINE ="1";

	
	/**
	 * 定时上线操作
	 */
	public static final String SYS_CORE_WARE_STATUS_OPER_TYPE_TIMEED_ONLINE ="2";

	/**
	 * 定时下线操作
	 */
	public static final String SYS_CORE_WARE_STATUS_OPER_TYPE_TIMEED_OFFLINE ="3";


	/**
	 * 自动上线操作
	 */
	public static final String SYS_CORE_WARE_STATUS_OPER_TYPE_AUTO_ONLINE ="4";

	/**
	 * 自动下线操作
	 */
	public static final String SYS_CORE_WARE_STATUS_OPER_TYPE_AUTO_OFFLINE ="5";
	
	//==================================================================================
	//礼品上下线流程优化，将定时礼品上下线任务所用的常量提取到core包下，方便mgt和quartz使用
	//2012/06/14
	//==================================================================================
	/**
	 * 礼品上下线任务状态-未处理
	 */
	public static final String SYS_CORE_WARE_UP_DOWN_PLAN_STATUS_UNHANDLED = "0";
	/**
	 * 礼品上下线任务状态-正在处理
	 */
	public static final String SYS_CORE_WARE_UP_DOWN_PLAN_STATUS_DOING = "2";
	
	// why this success state occupied the value '1'???
	// I don't know.
	/**
	 * 礼品上下线任务状态-处理成功
	 */
	public static final String SYS_CORE_WARE_UP_DOWN_PLAN_STATUS_SUCCESS = "1";
	/**
	 * 礼品上下线任务状态-处理失败
	 */
	public static final String SYS_CORE_WARE_UP_DOWN_PLAN_STATUS_ERROR = "3";
	/**
	 * 礼品上下线任务状态-人工取消
	 */
	public static final String SYS_CORE_WARE_UP_DOWN_PLAN_STATUS_MANUAL_CANCELED = "4";
	/**
	 * 礼品上下线任务状态-自动取消
	 */
	public static final String SYS_CORE_WARE_UP_DOWN_PLAN_STATUS_AUTO_CANCELED = "5";
	
	/**
	 * 取消定时发送短信模板
	 */
	public static final String CANCEL_PREOPERLINE_SMS_CONTENT = "【积分商城任务自动提醒】您设定的%s的%t任务已被%u取消， 详情请登录管理平台查看。";
	
	/**
	 * 执行定时发送短信
	 */
	public static final String RUN_PREOPERLINE_SMS_CONTENT = "【积分商城任务自动提醒】您设定的%s的%t任务已执行%u，详情请登录管理平台查看。";
	
	
	
	/**
	 * 优惠兑换资格  绑定状态为：有效 -- 1
	 */
	public static final String SYS_PERMISSION_WARE_RLT_STATUS_VALID ="1";
	
	/**
	 * 优惠兑换资格 绑定状态为：无效  -- 0
	 */
	public static final String SYS_PERMISSION_WARE_RLT_STATUS_UNVALID ="0";
	
	/**
	 * 优惠兑换资格  规则类别--- 礼品小类编码 00
	 */
	public static final String SYS_PERMISSION_TYPE_CODE_SUBKINDCODE = "00";
	/**
	 * 优惠兑换资格  规则类别--- 礼品所属合作商编码 01
	 */
	public static final String SYS_PERMISSION_TYPE_CODE_PARTNERCODE ="01";
	/**
	 * 优惠兑换资格  规则类别--- 礼品编码 02
	 */
	public static final String SYS_PERMISSION_TYPE_CODE_WARECODE = "02";
	/**
	 * 优惠兑换资格  规则类别--- 省编码 03
	 */
	public static final String SYS_PERMISSION_TYPE_CODE_PROVINCECODE="03";
	/**
	 * 优惠兑换资格  同步HP类型  操作类型 01新增
	 */
	public static final String SYS_PERMISSION_HP_INTER_OPT_TYPE_NEW = "01";
	/**
	 * 优惠兑换资格  同步HP类型  操作类型 02修改
	 */
	public static final String SYS_PERMISSION_HP_INTER_OPT_TYPE_MODIFY = "02";
	/**
	 * 优惠兑换资格  同步HP类型  操作类型 03删除
	 */
	public static final String SYS_PERMISSION_HP_INTER_OPT_TYPE_DELETE = "03";
	
	/**
	 * 同步HP 返回成功
	 */
	
	public static final String SYS_HP_INTER_SUCCESS="0000";
	/**
	 * 不良品状态--未申请
	 */
	public static final String BAD_WARE_STATUS_NOT_APPLY = "00";
	/**
	 * 不良品状态--待审核
	 */
	public static final String BAD_WARE_STATUS_NOT_AUDIT = "01";
	/**
	 * 不良品状态--待确认
	 */
	public static final String BAD_WARE_STATUS_NOT_COMFIRM = "02";
	/**
	 * 不良品状态--已确认
	 */
	public static final String BAD_WARE_STATUS_HAS_CONFIRM = "03";
	/************************省网礼品无库存的状态，para_type_id=50*****************************/
	/**
	 * 无库存
	 */
	public static String SYS_PARA_WARE_HOUSE_TYPE_NO_HOUSE = "3";
	
	
	/**
	 * 默认规则
	 */
	public final static String LOGISTICS_RULE_DEFAULT_ID = "-1";
	
	/**
	 * 物流规则生效 1 (包括绑定仓库是否生效)
	 */
	public final static String LOGISTICS_RULES_STATUS_ON = "1";
	
	/**
	 * 物流规则失效 0 (包括绑定仓库是否生效)
	 */
	public final static String LOGISTICS_RULES_STATUS_OFF = "0";
	
	/**
	 * 同步信息类型-物流配送价格
	 */
	public final static String SYS_PARA_SYN_TYPE_SEND_PRICE = "1";
	/**
	 * 同步状态-待同步
	 */
	public final static String SYS_PARA_SYN_STATE_WAIT = "0";
	
	/**
	 * 1,仓库信息包装费保存，触发物流费积分重新计算，传入一个wareHouseId     
	 */
	public final static String LOGISTICS_RULES_OPERATE_TYPE1 = "1";
	/**
	 * 2,仓库绑定配送省，触发物流费积分重新计算，传入一个wareHouseId
	 */
	public final static String LOGISTICS_RULES_OPERATE_TYPE2 = "2";
	/**
	 * 3,仓库绑定配送商，触发物流费积分重新计算，传入一个wareHouseId 
	 */
	public final static String LOGISTICS_RULES_OPERATE_TYPE3 = "3";
	/**
	 * 4,仓库绑定物流费规则，触发物流费积分重新计算，传入一个wareHouseId
	 */
	public final static String LOGISTICS_RULES_OPERATE_TYPE4 = "4";
	/**
	 *  5,配送价发生变化，触发物流费积分重新计算，传入多个wareHouseId,一个partnerId
	 */
	public final static String LOGISTICS_RULES_OPERATE_TYPE5 = "5";
	/**
	 *  6,物流费规则修改，触发物流费积分重新计算，出入多个wareHouseId,一个ruleId 
	 */
	public final static String LOGISTICS_RULES_OPERATE_TYPE6 = "6";
	/**
	 *  7,仓库删除配送商，触发物流费积分重新计算，传入一个wareHouseId 
	 */
	public final static String LOGISTICS_RULES_OPERATE_TYPE7 = "7";
	
	/**
	 * 物流积分操作：新增
	 */
	public final static String LOGISTICS_INTEGTAL_INSERT = "0";
	
	/**
	 * 物流积分操作：删除
	 */
	public final static String LOGISTICS_INTEGTAL_DELETE = "1";
	
	/**
	 * 物流积分操作：修改
	 */
	public final static String LOGISTICS_INTEGTAL_UPDATE = "2";
	
	/**
	 * 定时执行状态-待执行
	 */
	public static String SYS_PLAN_STATE_WAIT = "0";
	/**
	 * 非测试礼品
	 */
	public static String ISNOT_TEST_WARE ="0";
	
	
	/**
	 * 查询限制兑换数量绑定礼品信息列表方法
	 */
	public static final String GET_BIND_WARE_INFO_LIST = "getBindWareInfoList(String partnerId,String lstWareFirstKind," +
					"String lstWareParentKind, String lstWareKind, String wareName, String wareCode,String limitExchangeCycle," +
					"String isEffect, String provinceCode,String wareKindInfoId,int $STARTROWINDEX, int $ENDROWINDEX)";
	/**
	 * 查询限制兑换数量绑定礼品信息列表方法总条数
	 */
	public static final String GET_BIND_WARE_INFO_LIST_COUNT = "getBindWareInfoListCount(String partnerId,String lstWareFirstKind," +
					"String lstWareParentKind, String lstWareKind, String wareName, String wareCode,String limitExchangeCycle," +
					"String isEffect,String provinceCode,String wareKindInfoId)";
	/**
	 * 生成50*50、70*70、110*110、 240*240、 480*480规格的文件名 以逗号分割 PLACEHOLDER占位符
	 */
   public static String  WARE_SYN_FORMAT="PLACEHOLDER_50.jpg,PLACEHOLDER_70.jpg,PLACEHOLDER_110.jpg,PLACEHOLDER_240.jpg" +
   		",PLACEHOLDER_480.jpg";
}
