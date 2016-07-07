/**
 * Copyright (c) 2013 asiainfo.com
 */
package ngves.asiainfo.core.order;

import ngves.asiainfo.CommnConstant;

/**
 * 声明一个常量类<br/>
 * 继承了类<code>CommnConstant</code>
 * @author lijj7
 *
 */
public abstract class OrderConstant extends CommnConstant {
	//超时订单常量定义 -----------------------开始----------------------------------
	/**
	 * 超时订单待审核
	 */
	public static final String STATUS_PENDING_VAULE="01";
	public static final String STATUS_PENDING_NAME="待审核";
	public static final String TYPE_PENDING_VAULE="01";
	public static final String TYPE_PENDING_NAME="正常订单";
	public static final String TYPE_ERROR_VAULE="02";
	public static final String TYPE_ERROR_NAME="异常订单";
	public static final String BRAND_E_VAULE="E";
	public static final String BRAND_E_NAME="神州行";
	public static final String BRAND_G_VAULE="G";
	public static final String BRAND_G_NAME="全球通";
	public static final String BRAND_M_VAULE="M";
	public static final String BRAND_M_NAME="动感地带";
	/**
	 * 超时订单不发短信
	 */
	public static final String STATUS_DONTSEND_VAULE="02";
	public static final String STATUS_DONTSEND_NAME="不发短信";
	/**
	 * 超时订单待发短信
	 */
	public static final String STATUS_SEND_VAULE="03";
	public static final String STATUS_SEND_NAME="待发短信";
	/**
	 * 超时订单已发短信
	 */
	public static final String STATUS_ALREADY_VAULE="05";
	public static final String STATUS_ALREADY_NAME="已发短信";
	
	//  超时订单反馈接口HP对应角色
	/**
	 *  总部积分运营中心-07
	 */
	public static String HEAD_OF_OPERATION_CENTRE="07";
	/**
	 *  总部客服基地组织 -03
	 */
	public static String HEAD_OF_CUSTOMER_SERVICE="03";
	
	// 是否需要发短信  01-不需要发送短信；02-需要发送短信
	 
	/**
	 * 01-不需要发送短信
	 */
	public static String NOT_SEND_MESSAGE="01";
	/**
	 * 02-需要发送短信
	 */
	public static String IS_SEND_MESSAGE="02";

	/**
	 * 未完成订单文件的上传临时路径
	 */	
	public final static String UPLOAD_TMP_UNFINISHED_ORDER_TASK_PATH = "upload_tmp_unfinished_order_task_path";
	
	/**
	 * 未完成订单文件的下载的临时路径
	 */	
	public final static String DOWNLOAD_TMP_UNFINISHED_ORDER_TASK_PATH = "download_tmp_unfinished_order_task_path";
	
	/**
	 * 未完成订单文件的ftp路径
	 */	
	public final static String FTP_UNFINISHED_ORDER_TASK_PATH = "ftp_unfinished_order_task_path";
	
	/**
	 * 未完成订单更新结果文件的ftp路径
	 */	
	public final static String FTP_UNFINISHED_ORDER_TASK_RESULT_PATH = "ftp_unfinished_order_task_result_path";
	
	/**
	 * 超时未完结订单任务的service
	 */
	public static final String SERVICE_CORE_ORDER_UNFINISHED_TASK_SERVICE = "ngves.asiainfo.core.orderUnfininshedTaskSrv";
	
	/**
     * 未完结订单任务状态为起草
     */
    public static final String ORDER_UNFINISHED_STATUS_DRAFT= "00";
    public static final String ORDER_UNFINISHED_NAME_DRAFT= "起草";
    /**
     * 未完结订单任务状态为待审核
     */
    public static final String ORDER_UNFINISHED_STATUS_NOTVERIFY= "01";
    public static final String ORDER_UNFINISHED_NAME_NOTVERIFY= "待审核";
    /**
     * 未完结订单任务状态为初审通过
     */
    public static final String ORDER_UNFINISHED_STATUS_FIRSTVERIFY= "02";
    public static final String ORDER_UNFINISHED_NAME_FIRSTVERIFY= "初审通过";

    /**
     * 未完结订单任务状态为初审不通过
     */
    public static final String ORDER_UNFINISHED_STATUS_NOTFIRSTVERIFY= "03";
    public static final String ORDER_UNFINISHED_NAME_NOTFIRSTVERIFY= "初审不通过";
    /**
     * 未完结订单任务状态为审核通过
     */
    public static final String ORDER_UNFINISHED_STATUS_SECONDVERIFY= "04";
    public static final String ORDER_UNFINISHED_NAME_SECONDVERIFY= "审核通过";
    /**
     * 未完结订单任务状态为审核不通过
     */
    public static final String ORDER_UNFINISHED_STATUS_NOTSECONDVERIFY= "05";
    public static final String ORDER_UNFINISHED_NAME_NOTSECONDVERIFY= "审核不通过";
    
    /**
	 * 任务处理状态 00没有执行 01 执行中 02 执行成功 03 执行失败
	 */
	public static final String ORDER_UNFINISHED_TASK_STATUS_NO = "00";    
	/**
	 * 任务处理状态 00没有执行 01 执行中 02 执行成功 03 执行失败
	 */
	public static final String ORDER_UNFINISHED_TASK_STATUS_ING = "01";
	/**
	 * 任务处理状态 00没有执行 01 执行中 02 执行成功 03 执行失败
	 */
	public static final String ORDER_UNFINISHED_TASK_STATUS_SUCCESS = "02";
	/**
	 * 任务处理状态 00没有执行 01 执行中 02 执行成功 03 执行失败
	 */
	public static final String ORDER_UNFINISHED_TASK_STATUS_FAIL = "03";

	/**
	 * 流水表时间格式化类型
	 */
	public static final String ORDER_DATE_FORMAT_LONG="yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 提示信息
	 */
	public static final String RET_VALUE_Exception1= "操作失败,请稍后重试!";
	
	/**
	 * 其他操作提示
	 */
	public static final String RET_VALUE_OTHER = "操作已成功";
	
	/**
	 * 处于处理页面
	 */
	public static final String MANAGER_PAGE_FLAG= "00";
	/**
	 * 处于初审页面
	 */
	public static final String FIRST_AUDIT_PAGE_FLAG= "01";
	/**
	 * 处于复审页面
	 */
	public static final String RE_AUDIT_PAGE_FLAG= "02";
	/**
	 * 查询全部
	 */
	public static final String QUERY_ALL_VALUE= "-1";
	/**
	 * 新增
	 */
	public static final String ORDER_UNFINISHED_TASK_NEW = "1";
	/**
	 * 删除
	 */
	public static final String ORDER_UNFINISHED_TASK_DELETE = "0";
	
	/**
	 * 未支付订单导出查询方法名
	 */
	public final static String QUERY_EXPORT_NOT_PAY_QUERYMETHOD="getNOtPay(String mobileNum,String orderSeq,String startTime, String endTime,String payState,String userLocalProvince, int $STARTROWINDEX, int $ENDROWINDEX)";
	
	/**
	 * 未支付订单导出行数方法名
	 */
	public final static String QUERY_EXPORT_NOT_PAY_COUNTMETHOD ="getNOtPayCount(String mobileNum,String orderSeq,String startTime, String endTime,String payState,String userLocalProvince)";
	
	/**
	 * 未支付订单导出到excel_task表的ORDER_COL_TYPE标识
	 */
	public final static String NOT_PAY_EXPORT_QUERY_RULE_TYPE = "26";
}
