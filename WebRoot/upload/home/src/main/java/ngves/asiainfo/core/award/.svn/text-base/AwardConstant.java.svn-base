/**
 * Copyright (c) 2010 asiainfo.com
 * 2010-10-26 上午10:26:45
 */
package ngves.asiainfo.core.award;




/**
 * 抽奖活动相关静态常量
 * 
 * @author xj
 */
public class AwardConstant {
	
	/**
	 * 活动表表名
	 */
	public static final String AWARD_TABLE_NAME= "AWARD_INFO";
	/**
	 * 活动创建
	 */
	public static final String ACTIVITY_CREATE= "0";
	/**
	 * 活动发布
	 */
	public static final String ACTIVITY_PUBLIC = "1";

	/**
	 * 活动停止
	 */
	public static final String ACTIVITY_STOP = "2";
	/**
	 * 活动删除
	 */
	public static final String ACTIVITY_DELETE = "3";
	
	
	
	// 参与分值最大数
	public static final int AWARD_MAX_BASE_INTEGRAL = 99999999;
	// 参与总数限制
	public static final int AWARD_MAX_COUNT = 99999999;
	// 每人可参与次数限制
	public static final int AWARD_ONE_MAX_COUNT = 99999999;
	
	
	// 修改抽奖活动中，团购的状态
	// 允许修改全部
	public static final String AWARD_MODIFY_ALL_CAN_MODIFY = "AwardnModifyAll";

	// 允许修改部分
	public static final String AWARD_MODIFY_PART_CAN_MODIFY = "AwardModifyPart";

	// 不允许修改，查看操作
	public static final String AWARD_MODIFY_NONE_CAN_MODIFY = "AwardModifyNone";
	
	// 设定档次时，礼品可兑换总数（最大限制）
	public static final int AWARD_WARE_MAX_COUNT = 9999999;
	
	//抽奖活动规则信息增量同步接口
	public static final String AWARD_INFO_SYN_HP_OPT_TYPE_ADD = "01";
	public static final String AWARD_INFO_SYN_HP_OPT_TYPE_MODIFY = "02";
	public static final String AWARD_INFO_SYN_HP_OPT_TYPE_DEL = "03";
	// 默认提示语信息
	public static final String AWARD_LEVEL_DEFAULT_MESSAGE = "恭喜，被幸运女神选中！喜获${wareNickName}";
	// 非100%中奖未取到默认提示语时用的提示语
	public static final String AWARD_LEVEL_DEFAULT_FAIL_MESSAGE = "真遗憾，没中奖，下次参加吧";
	// 100%中奖默认档礼品无库存等异常情况用的提示语
	public static final String AWARD_LEVEL_DEFAULT_EXCE_MESSAGE = "真遗憾，礼品已经抽光了，下次再来吧";
	// 其他异常情况用的提示语
	public static final String AWARD_DEFAULT_EXCE_MESSAGE = "网络忙，请稍后再试。";
	

	/**
	 * 查询抽奖活动列表方法
	 */
	public static final String QUERY_AWARD_ORDERLIST = "queryAwardOrderList(String awardId, String mobileNum, String " +
			"proCode ,String awardResult,String orderSeq, String startTime, String endtime,int $STARTROWINDEX,int $ENDROWINDEX)";
	/**
	 * 查询抽奖活动列表数目
	 */
	public static final String COUNT_AWARD_ORDERLIST = "countAwardOrderList(String awardId, String mobileNum, String " +
			"proCode ,String awardResult, String orderSeq, String startTime, String endtime)";
	
	
	/**
	 * 活动地址
	 */
	public static final String ACTIVITY_PORTAL_URL = "jf.10086.cn/award/";
	/**
	 * 礼品上线状态
	 */
	public static final String WARE_INFO_STATE_ONLINE = "1";
	
	/**
	 * 库存验证异常code
	 */
	public static final String HOUSE_COUNT_ERROR_CODE = "礼品可兑换总数必须小于礼品最大库存量";
		
	/**
	 * HP4.2.3信息增量同步接口ActionID前缀
	 */
	public static final String AWARD_RULE_INFO_ACTIONID = "07";
	
	/**
	 * 未中奖档次的礼品code,ID
	 */
	public static final String AWARD_LEVEL_NOT_WAREID = "1111";
	
	/**
	 * 默认提示语的活动ID
	 */
	public static final Long DEFAULT_MESSAGE_AWARD_ID = 1l;
	
	/**
	 * 是否包含未中奖档次  0：否 1：是
	 * 
	 */
	
	public static final String AWARD_LEVEL_IS_CONTAIN = "1"; 
	public static final String AWARD_LEVEL_NOT_CONTAIN = "0"; 
	/**
	 * 01-非100%有奖02-100%有奖
	 */
	public static final String AWARD_MOST_WARE ="02";
	public static final String AWARD_NOT_MOST_WARE ="01";
	
	/**
	 * 00-全部 01-未中奖 02-中奖
	 */
	public static final String AWARD_LOTTERY_RESULT_ALL ="00";
	public static final String AWARD_LOTTERY_RESULT_YES ="01";
	public static final String AWARD_LOTTERY_RESULT_NO ="02";
	/**
	 * ReceiveStatus 01-已领取02-未领取
	 */
	public  static final String AWARD_RECEIVESTATUS_YES ="01";
	public  static final String AWARD_RECEIVESTATUS_NO ="02";
	
	/**
	 * 提示语状态  0：停用 1：启用
	 */
	public  static final String AWARD_LEVEL_MESSAGE_STOP ="0";
	public  static final String AWARD_LEVEL_MESSAGE_START ="1";
	
	
	/**
	 * 抽奖基础礼品是否有限制(1: 表示限制     0:表示无限制 )
	 */
	public  static final String LIMIT_BASE_WARE ="1";
	public  static final String NOT_LIMIT_BASE_WARE ="0";

	
	/**
	 * 中奖礼品是否有限制(1: 表示限制     0:表示无限制 )
	 */
	public  static final String LIMIT_WIN_WARE ="1";
	public  static final String NOT_LIMIT_WIN_WARE ="0";	
	
	
	/**
	 * 无限制(页面无限制用0表示，但是预扣库存时，不能区分这个0是由其他正整数扣减得到还是管理平台设置的，因此改为-100。 
	 * 另，管理平台页面展示时会将-100转换成0显示
	 */
	public static final int  AWARD_DEFALUT_WARE_MAX_COUNT = -100;
	
	
}
