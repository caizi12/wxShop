/**
 * 
 */
package ngves.asiainfo.core.ware;


/**
 * 礼品监控相关静态常量
 * 
 */
public class WareMonitorConstant {
	/**
	 * 礼品上下线动态通知任务
	 */
	public static final String JOB_TASK_TYPE_UP_DOWN = "00";
	
	/**
	 * 礼品监控任务
	 */
	public static final String JOB_TASK_TYPE_MONITOR = "01";
	
	/**
	 * 告警类型——短信
	 */
	public static final String ALARM_TYPE_MSG = "02";
	
	/**
	 * 告警类型——短信名称
	 */
	public static final String ALARM_TYPE_MSG_NAME = "短信类型";
	
	/**
	 * 告警类型——邮件
	 */
	public static final String ALARM_TYPE_EMAIL = "01";
	
	/**
	 * 告警类型——邮件名称
	 */
	public static final String ALARM_TYPE_EMAIL_NAME = "邮件类型";
	
	/**
	 * 礼品监控任务状态——启用
	 */
	public static final String JOB_TASK_STATUS_ENABLE = "1";
	
	/**
	 * 礼品监控任务状态——启用名字
	 */
	public static final String JOB_TASK_STATUS_ENABLE_NAME = "启用";
	
	/**
	 * 礼品监控任务状态——不启用
	 */
	public static final String JOB_TASK_STATUS_UNENABLE = "0";
	
	/**
	 * 礼品监控任务状态——停用名字
	 */
	public static final String JOB_TASK_STATUS_UNENABLE_NAME = "停用";
	
	/**
	 * 监控对象——礼品业务分类
	 */
	public static final String MONITOR_TYPE_BIG_KIND = "00";
	
	/**
	 * ha_product表的礼品业务分类字段
	 */
	public static final String MONITOR_TYPE_BIG_KIND_HA_PRODUCT = "TYPE1";
	
	/**
	 * 监控对象——礼品中类
	 */
	public static final String MONITOR_TYPE_MIDDLE_KIND = "01";
	
	/**
	 * ha_product表的礼品中类字段
	 */
	public static final String MONITOR_TYPE_MIDDLE_KIND_HA_PRODUCT = "TYPE2";
	
	/**
	 * 监控对象——礼品小类
	 */
	public static final String MONITOR_TYPE_SMALL_KIND = "02";
	
	/**
	 * ha_product表的礼品小类字段
	 */
	public static final String MONITOR_TYPE_SMALL_KIND_HA_PRODUCT = "TYPE3";
	
	/**
	 * 监控对象——礼品
	 */
	public static final String MONITOR_TYPE_WARE = "03";
	
	/**
	 * ha_product表的礼品字段
	 */
	public static final String MONITOR_TYPE_WARE_HA_PRODUCT = "ITEMID";
	
	/**
	 * ha_product表的日期格式
	 */
	public static final String MONITOR_DATE_FORMAT = "yyyyMMdd";
	
	/**
	 * 礼品监控操作记录表业务操作类型——任务状态变更（启用、停用）
	 */
	public static final String OPERATE_TYPE_TASK_STATUS = "01";
	
	/**
	 * 礼品监控操作记录表业务操作类型——绑定发送对象状态变更（绑定、解除绑定）
	 */
	public static final String OPERATE_TYPE_BIND_STATUS = "02";
	
	public static final String OPERATE_TYPE_BIND_NAME = "绑定";
	
	public static final String OPERATE_TYPE_UNBIND_NAME = "解绑";
	
	
	/**
	 * 用于页面展示的礼品类别
	 */
	public static final String MONITOR_TYPE_KIND_NAME = "礼品类别";
	
	/**
	 * 用于页面展示的礼品名称
	 */
	public static final String MONITOR_TYPE_WARE_NAME = "礼品";
	
	/**
	 * 分号
	 */
	public static final String SEMICOLON = ";";
	
	/**
	 * 顿号
	 */
	public static final String SLIGHT_PAUSE_SERIES = "、";
	
}
