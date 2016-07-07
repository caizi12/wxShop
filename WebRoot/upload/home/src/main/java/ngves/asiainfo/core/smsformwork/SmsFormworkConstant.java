package ngves.asiainfo.core.smsformwork;

public class SmsFormworkConstant {
	
	/**
	 * 短信模板——发送时机管理服务
	 */
	public static final String SERVICE_SMS_FORMWORK_OCCASION = "ngves.asiainfo.core.SmsOccasionService";

	
	/**
	 * 短信模板——礼品所属短信模板列表查询服务
	 */
	public static final String SERVICE_SMS_FORMWORK_WARE_TEMP = "ngves.asiainfo.core.WareTempService";
	
	/**
	 * 短信模板——活动配置短信模板列表查询服务
	 */
	public static final String SERVICE_SMS_FORMWORK_WARE_ACTION_QRY = "ngves.asiainfo.core.WareActionQryService";
	
	/**
	 * 短信模板——模板内容管理
	 */
	public static final String SERVICE_SMS_TEMP_CONTENT = "ngves.asiainfo.core.SmsTempContentService";

    
    /**
	 * 调用各action返回消息的名称
	 */
	public static final String RET_MSG = "retMsg";
	
	/**
	 * 调用各action返回值的名称
	 */
	public static final String RET_VALUE = "retVal";
	
	/**
	 * 调用各action成功
	 */
	public static final String RET_VALUE_SUCCESS = "SUCCESS";
	
	/**
	 * 调用各action失败
	 */
	public static final String RET_VALUE_FAILURE = "FAILURE";
	
	/**
	 * 短信模板--模板管理服务
	 */
	public static final String SERVICE_SMS_FORMWORK = "ngves.asiainfo.core.SmsFormworkService";
	
	/**
	 * 查询模板相关列表，显示单选框
	 */
	public static final String SMS_FORMWORK_SHOW_METHOD = "qryFormwork";
		
	/**
	 * 信息保存成功
	 */
	public static final String RET_SAVE_SUCCESS = "信息保存成功";
	
	/**
	 * 查询"全部"信息
	 */
	public static final String QRY_ALL_INFO = "-1";
	
	/**
	 * 没有停用，没被删除
	 */
	public static final String SMS_FORMWORK_STATUS_USE = "0";
	
	/**
	 * 已停用,被删除
	 */
	public static final String SMS_FORMWORK_STATUS_NO_USE = "1";
	
	/**
	 * 时间格式化类型
	 */
	public static final String FORMWORK_DATE_FORMAT_LONG="yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 时间格式化类型
	 */
	public static final String FORMWORK_DATE_FORMAT_HP="yyyyMMddHHmmss";
	
	/**
	 * 普通活动类型
	 */
	public static final String FORMWORK_COMMON_ACTION_CODE="000";
	
	/**
	 * 类型 ---转赠 05
	 */
	public static final String FORMWORK_DONATION_ACTION_CODE = "05";
	/**
	 *  调用HP接口发生的异常
	 */
    public static final String SYS_MSG_SRV_EXCEPTION_HP = "24000";
    
    /**
     *  HP接口返回交易成功代码
     */
	public static final String HP_INTERFACE_SUCCESS = "0000";
	
	/**
     *  短信模板操作类型新增----01
     */
	public static final String SMS_OPERATOR_TYPE_ADD = "01";
	
	/**
     *  短信模板操作类型修改----02
     */
	public static final String SMS_OPERATOR_TYPE_UPDATE = "02";
	
	/**
     *  短信模板操作类型删除----03
     */
	public static final String SMS_OPERATOR_TYPE_DELETE = "03";
	
	/**
	 * 模板绑定的省份是否发送 0-发送;
	 */
	public static final String SMS_FORMWORK_PROVINCE_IS_SEND = "0";
	
	/**
	 * 模板绑定的省份是否发送 1-不发送
	 */
	public static final String SMS_FORMWORK_PROVINCE_NOT_SEND = "1";

}
