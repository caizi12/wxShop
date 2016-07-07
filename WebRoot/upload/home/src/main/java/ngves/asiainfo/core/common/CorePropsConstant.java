package ngves.asiainfo.core.common;

import ngves.asiainfo.util.PropertyReader;

public class CorePropsConstant {
	/**
	 * FTP文件服务器地址属性名
	 */
	public final static String PROP_AI_FILES_FTP_HOST = "files.ftp.ip";

	/**
	 * FTP文件服务器连接用户属性名
	 */
	public final static String PROP_AI_FILES_FTP_USER = "files.ftp.user";

	/**
	 * FTP文件服务器连接用户密码属性名
	 */
	public final static String PROP_AI_FILES_FTP_USER_PASSWD = "files.ftp.password";

	/**
	 * FTP文件服务器连接尝试次数属性名
	 */
	public final static String PROP_AI_FILES_FTP_RETRY_COUNT = "files.ftp.retry.count";
	
	
	/**
	 * 一级BOSS的FTP文件服务器地址属性名
	 */
	public final static String PROP_CUSTOM_FILES_FTP_HOST = "custom.files.ftp.ip";

	/**
	 * 一级BOSS的FTP文件服务器连接用户属性名
	 */
	public final static String PROP_CUSTOM_FILES_FTP_USER = "custom.files.ftp.user";

	/**
	 * 一级BOSS的FTP文件服务器连接用户密码属性名
	 */
	public final static String PROP_CUSTOM_FILES_FTP_USER_PASSWD = "custom.files.ftp.password";

	/**
	 * 一级BOSS的FTP文件服务器连接尝试次数属性名
	 */
	public final static String PROP_CUSTOM_FILES_FTP_RETRY_COUNT = "custom.files.ftp.retry.count";
	/**
	 * 一级BOSS的下载主目录
	 */
	public final static String PROP_CUSTOM_FILES_FTP_OUTGOING = "custom.files.ftp.outgoing";
	/**
	 * 一级BOSS的上传的主目录
	 */
	public final static String PROP_CUSTOM_FILES_FTP_INGOING = "custom.files.ftp.ingoing";

	/**
	 * 图片显示根路径名称属性名
	 */
	public final static String PORP_AI_PIC_ROOT_URL = "pic.root.url";

	public final static String PORP_AI_PIC_WARE_URL = "pic.ware.url";

	public final static String PORP_AI_PIC_BRAND_URL = "pic.brand.url";

	public final static String PORP_AI_PIC_MARKET_URL = "pic.market.url";

	public final static String PORP_AI_PIC_TOPIC_URL = "pic.topic.url";

	/**
	 * 图片实际根路径属性名称
	 */
	public final static String PORP_AI_PIC_ROOT_PATH = "pic.root.path";

	public final static String PORP_AI_PIC_WARE_PATH = "pic.ware.path";

	public final static String PORP_AI_PIC_BRAND_PATH = "pic.brand.path";

	public final static String PORP_AI_PIC_MARKET_PATH = "pic.market.path";

	public final static String PORP_AI_PIC_TOPIC_PATH = "pic.topic.path";

	/**
	 * 文档下载根路径属性名称
	 */
	public final static String PORP_AI_DOC_ROOT_PATH = "doc.root.path";

	public final static String PORP_AI_DOC_ORDER_PATH = "doc.order.path";

	public final static String PORP_AI_DOC_PARTNER_PATH = "doc.partner.path";

	public final static String PORP_AI_DOC_SETTLE_PATH = "doc.settle.path";

	public final static String PORP_AI_DOC_HELP_PATH = "doc.help.path";

	public final static String PORP_AI_DOC_WARE_PATH = "doc.ware.path";

	public final static String PORP_AI_DOC_EXAM_PATH = "doc.exam.path";
	public final static String PORP_AI_DOC_INFORMATION_PATH = "doc.information.path";
	public final static String PORP_AI_DOC_CSVC_PATH = "doc.csvc.path";
	

	/**
	 * 图片、文档上传临时根目录属性名称
	 */
	public final static String PORP_AI_TMP_ROOT_PATH = "tmp.root.path";

	public final static String PORP_AI_TMP_WARE_PATH = "tmp.ware.path";

	public final static String PORP_AI_TMP_BRAND_PATH = "tmp.brand.path";

	public final static String PORP_AI_TMP_MARKET_PATH = "tmp.market.path";

	public final static String PORP_AI_TMP_PARTNER_PATH = "tmp.partner.path";

	public final static String PORP_AI_TMP_SETTLE_PATH = " tmp.settle.path";

	public final static String PORP_AI_TMP_HELP_PATH = "tmp.help.path";

	public final static String PORP_AI_TMP_ORDER_PATH = "tmp.order.path";

	public final static String PORP_AI_TMP_EXAM_PATH = "tmp.exam.path";

	public final static String PORP_AI_TMP_TOPIC_PATH = "tmp.topic.path";

	public final static String PORP_AI_TMP_INFORMATION_PATH = "tmp.information.path";
	public final static String PORP_AI_TMP_CSVC_PATH = "tmp.csvc.path";

	/**
	 * 合作商资料FTP路径属性名称
	 */
	public final static String PORP_AI_FTP_PARTNER_PATH = "ftp.partner.path";

	/**
	 * 订单FTP路径属性名称
	 */
	public final static String PORP_AI_FTP_ORDER_PATH = "ftp.order.path";

	/**
	 * 结算FTP路径属性名称
	 */
	public final static String PORP_AI_FTP_SETTLE_PATH = "ftp.settle.path";

	/**
	 * 帮助FTP路径属性名称
	 */
	public final static String PORP_AI_FTP_HELP_PATH = "ftp.help.path";

	/**
	 * 符合上下线礼品导出
	 */
	public final static String PORP_AI_FTP_WARE_PATH = "ftp.ware.path";

	/**
	 * 在线调研礼品上传ftp路径
	 */
	public final static String PORP_AI_FTP_EXAM_PATH = "ftp.exam.path";

	/**
	 * 信息订阅模板文件上传ftp路径
	 */
	public final static String PORP_AI_FTP_INFORMATION_PATH = "ftp.information.path";
	/**
	 * 一级客服商城ftp路径
	 */
	public final static String PORP_AI_FTP_CSVC_PATH = "ftp.csvc.path";

	/**
	 * 
	 */
	public final static String PORP_AI_ORDER_THREAD_POOL_CORE = "order.threadPool.core";

	/**
	 * 
	 */
	public final static String PORP_AI_ORDER_THREAD_POOL_MAX = "order.threadPool.max";

	/**
	 * 
	 */
	public final static String PORP_AI_ORDER_THREAD_POOL_KEEP = "order.threadPool.keep";

	public final static String PORP_AI_EXP_ORDER_THREAD_POOL_CORE = "expOrder.threadPool.core";

	public final static String PORP_AI_EXP_ORDER_THREAD_POOL_MAX = "expOrder.threadPool.max";

	public final static String PORP_AI_EXP_ORDER_THREAD_POOL_KEEP = "expOrder.threadPool.keep";

	public final static String PORP_AI_UP_ORDER_THREAD_POOL_CORE = "upOrder.threadPool.core";

	public final static String PORP_AI_UP_ORDER_THREAD_POOL_MAX = "upOrder.threadPool.max";

	public final static String PORP_AI_UP_ORDER_THREAD_POOL_KEEP = "upOrder.threadPool.keep";

	public final static String PROP_AI_GLABAL_ORDER = "GLOBAL_ORDER";

	public final static String PROP_AI_GLABAL_ORDER_UP_SUC = "GLOBAL_ORDER_UP_SUC";

	public final static String PROP_AI_GLOBAL_ORDER_UP_FAIL = "GLOBAL_ORDER_UP_FAIL";

	public final static String PROP_AI_GLOBAL_EXPORDER = "GLOBAL_EXPORDER";

	public final static String PROP_AI_GLOBAL_EXPORDER_UP_SUC = "GLOBAL_EXPORDER_UP_SUC";

	public final static String PROP_AI_GLOBAL_EXPORDER_UP_FAIL = "GLOBAL_EXPORDER_UP_FAIL";

	public final static String PROP_AI_GLOBAL_SMS_THREAD_POOL_NUM = "sms.thread.pool.num";

	public final static String PROP_AI_PORTAL_PREVIEW_URL = "portal.server.url";

	/**
	 * 门户host
	 */
	public static final String PORTAL_HTTP_URL = PropertyReader
			.getProperty(CorePropsConstant.PROP_AI_PORTAL_PREVIEW_URL);

	/**
	 *	邮件相关配置名称 
	 */
	public static final String MAIL_SMTP_HOST = "mail.smtp.host";

	public static final String MAIL_SMTP_AUTH = "mail.smtp.auth";

	public static final String MAIL_SEND_SMTP_HOST = "mail.send.smtp.host";

	public static final String MAIL_SEND_ADDR = "mail.send.addr";

	public static final String MAIL_SEND_CONTENT_TYPE = "mail.send.content.type";

	public static final String MAIL_SEND_ACCOUNT = "mail.send.account";

	public static final String MAIL_SEND_PASSWD = "mail.send.passwd";
	//接收者看到的发送用户的别名
	public static final String MAIL_SEND_NAME = "mail.send.name";

	/**
	 * 限时抢兑地址
	 */
	public static final String PROP_ACTIVITY_URL = "activity.url";
	
	/**
	 * 是否是黑白图标记-wzg
	 */
	public static final String IS_BLANK_WHITE_FLAG = "is_blank_white_flag";
	
	/**
	 * 系统版本号,用户js和css后缀,发布时替换10086,默认是-10086
	 */
	public static final String PORTAL_VERSION = "portal.version";
	
	/**
	 * 是否引用压缩文件开关，用于是否引用压缩后的js或者css文件 
	 * 不引用为 0 ，引用为 1
	 */
	public static final String COMPRESS_FILL = "compress.fill";
	
	/**
	 * 属性信息,用于获取所有合并js文件信息和被合并js文件,用;(英文)分割
	 * 每行第一个为合并后的js文件,后面的js皆为被合并js文件,每个被合并的js文件
	 * 用逗号(英文)分割
	 */
	public static final String MERGEA_JS = "merge_1.js";
	public static final String MERGEB_JS = "merge_2.js";
	
	/**
	 * 属性信息,用于指定需要加载哪些js的源文件,该属性用于解决某些js压缩后出现的问题，
	 * 可以通过该属性配置来解决，格式为**.js,**.js的合并压缩后的文件包含了有问题的文件。
	 *  每个被合并的js文件 用逗号(英文)分割
	 */
	public static final String EXCLUDE_JS = "exclude.js";
	
	/**
	 * 图片域名配置,以","分割,只有生产系统配置,测试和开发环境注释掉
	 */
	public static final String IMGAGE_DOMAINS = "img.domains";
	/**
	 *延迟加载时默认使用的图片,需要添加容器path,目前前台使用 
	 */
	public static final String LOADLAZY_IMG_URL = "loadlazy.img.url";

}
