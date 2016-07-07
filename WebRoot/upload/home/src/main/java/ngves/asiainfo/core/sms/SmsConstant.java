package ngves.asiainfo.core.sms;

public class SmsConstant {
	
	/**
     * 页面短信任务状态为全部状态的默认值
     */
    public static final String SMSTASK_STATUS_ALL= "-1";
    
	/**
	 * 短信任务状态--未执行
	 */
	public static final String SMSTASK_STATUS_NOEXCUT = "00";

	/**
	 * 短信任务状态--执行中
	 */
	public static final String SMSTASK_STATUS_EXCUTING = "01";

	/**
	 * 短信任务状态--已执行
	 */
	public static final String SMSTASK_STATUS_EXCUTED = "02";
	
	/**
     * 页面短信状态为全部状态的默认值
     */
    public static final String SMS_STATUS_ALL= "-1";

    /**
     * 短信状态为起草
     */
    public static final String SMS_STATUS_DRAFT= "00";
    /**
     * 短信状态为待审核
     */
    public static final String SMS_STATUS_NOTVERIFY= "01";
    /**
     * 短信状态为初审通过
     */
    public static final String SMS_STATUS_FIRSTVERIFY= "02";

    /**
     * 短信状态为初审不通过
     */
    public static final String SMS_STATUS_NOTFIRSTVERIFY= "03";
    /**
     * 短信状态为审核通过
     */
    public static final String SMS_STATUS_SECONDVERIFY= "04";
    /**
     * 短信状态为审核不通过
     */
    public static final String SMS_STATUS_NOTSECONDVERIFY= "05";
    
    /**
     * 短信状态为终止
     */
    public static final String SMS_STATUS_END= "06";
    
    /**
     * 短信状态为发送完毕
     */
    public static final String SMS_STATUS_SENDED= "07";
    
    /**
     * 短信状态为发送中
     */
    public static final String SMS_STATUS_SENDING= "08";
    
	/**
     * 导航标签服务定义
     */
    //public static final String NAVIGATION_INFO_SERVICE = "ngves.asiainfo.core.NavigationInfoSrv";
	
	/**
     * 短信模版审核链接
     */
    public static final String SMS_INFO_AUDIT = "<a href='javascript:onSmsInfoAudit(%s)'>审核"+ "</a>";
	
    /**
     * 短信模版查看详情链接
     */
    public static final String SMS_INFO = "<a href='javascript:onSmsInfo(%s)'>查看详情"+ "</a>";
    
    /**
     * 查看详情链接
     */
    public static final String SMS_CHECKINFO = "<a href='javascript:indexControl(\"SEEMORE\",%s)'>查看详情"+ "</a>";
    /**
     * 新增模板
     */
    public static final String SMS_ADD = "<a href='javascript:indexControl(\"ADD\",%s)'>新增"+ "</a>";
    /**
     * 修改模板
     */
    public static final String SMS_EDIT = "<a href='javascript:indexControl(\"EDIT\",%s)'>修改"+ "</a>";
    /**
     * 初审
     */
    public static final String SMS_FIRSTAUDIT = "<a href='javascript:indexControl(\"FIRSTAUDIT\",%s)'>&nbsp;审核&nbsp;"+ "</a>";
    /**
     * 复审
     */
    public static final String SMS_SECONDAUDIT = "<a href='javascript:indexControl(\"SECONDAUDIT\",%s)'>审核"+ "</a>";
    /**
     * 修改定时
     */
    public static final String SMS_TASKEDIT = "<a href='javascript:indexControl(\"TASKEDIT\",%s)'>修改定时"+ "</a>";
   
    
    /**
     * 短信模板撤回链接
     */
    public static final String SMS_BACK = "<a href='javascript:indexControl('BACK',%s)'>撤回"+ "</a>";
	
	
    /**
     * 短信模版驳回链接
     */
    public static final String SMS_INFO_REJECTED = "<a href='javascript:onSmsInfoRejected(%s)'>驳回"+ "</a>";
	
    /**
     * 短信模版终止链接
     */
    public static final String SMS_INFO_STOP = "<a href='javascript:onSmsInfoStop(%s)'>终止"+ "</a>";
    
    
    /**
     * 短信模版发送链接
     */
    public static final String SMS_INFO_SEND = "<a href='javascript:executeSmsTask(%s)'>&nbsp;发送短信&nbsp;"+ "</a>";
    
    /**
     * 短信模版修改定时链接
     */
    public static final String SMS_INFO_MODIFY = "<a href='javascript:modifySmsTemplate(%s)'>&nbsp;修改定时&nbsp;"+ "</a>";
    
    /**
     * 短信模版查看详情链接
     */
    public static final String SMS_INFO_TEMPLATE_DETAIL = "<a href='javascript:getTemplateDetail(%s)'>&nbsp;查看详情&nbsp;"+ "</a>";
    
    /**
     * 短信模版查看任务链接
     */
    public static final String SMS_INFO_TASK_DETAIL = "<a href='javascript:getTaskDetail(%s)'>&nbsp;查看任务&nbsp;"+ "</a>";
    
    
    
    
    
    /**
	 * 短信业务类接口
	 */
	public static final String SMS_INFO_SMSTEMPLATESRV = "ngves.asiainfo.core.ISmsTemplateSrv";
    /**
	 * 短信模板流水
	 */
	public static final String BUSI_SMS_TEMPLATE_SRV = "ngves.asiainfo.core.BusiSmsTemplateSrv";
	/**
	 * 短信任务类接口
	 */
	public static final String SMS_INFO_SMSTASKSRV = "ngves.asiainfo.core.ISmsTaskSrv";
	
	/**
	 * 
	 *  接口操作成功
	 */
	public static final String SMS_REASON_SUCESS = "0000";
	
	public static final String SMS_REASON_1000 = "1000";
	
	public static final String SMS_REASON_9001 = "9001";
	
	public static final String SMS_REASON_9999 = "9999";
	
	public static final String SMS_REASON_K101 = "K101";
	
	/**
	 * 任务状态 00没有执行 01 执行中 02 已执行
	 */
	public static final String SMS_TASK_STATUS_ING = "01";
	/**
	 * 任务状态 00没有执行 01 执行中 02 已执行
	 */
	public static final String SMS_TASK_STATUS_FINISH = "02";
	
	/**
	 * 是否可下载 1可下载
	 */
	public static final String SMS_TASK_STATUS_DOWNLOAD = "1";
	
	/**
	 * 发送失败号码的href
	 */
	public static final String SMS_FAILHREF="<a href=\'#\' onclick=\'javascript:downLoadFile(%s,%s)'>&nbsp;失败号码&nbsp;</a>";
	public static final String SMS_EERORHREF="<a href=\'#\' onclick=\'javascript:downLoadFile(%s,%s)'>&nbsp;错误号码&nbsp;</a>";
	public static final String SMS_DUPLIHREF="<a href=\'#\' onclick=\'javascript:downLoadFile(%s,%s)'>&nbsp;重复号码&nbsp;</a>";
	public static final String SMS_NOWHITEHREF="<a href=\'#\' onclick=\'javascript:downLoadFile(%s,%s)'>&nbsp;在黑名单号码&nbsp;</a>";
	
	/**
	 * 问题号码文件下载成功
	 */
	public static final String SMS_DOWNLOAD_SCUESS="\"01\"";
	/**
	 * 问题号码文件下载失败
	 */
	public static final String SMS_DOWNLOAD_FAIL="\"00\"";
	
	/**
	 * 流水表时间格式化类型
	 */
	public static final String SMS_DATE_FORMAT_LONG="yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 审核意见的最大长度(汉字)
	 */
	public static final int SMS_AUDIT_CONTENT_LONG = 500;
	
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
	 * 驳回短信状态提示
	 */
	public static final String RET_VALUE_05 = "短信已驳回";
	

	/**
	 * 驳回短信状态提示
	 */
	public static final String RET_VALUE_09 = "短信已撤回";
	
	/**
	 * 终止短信状态提示
	 */
	public static final String RET_VALUE_06 = "短信已终止";
	
	/**
	 * 批量操作提示
	 */
	public static final String RET_VALUE_04_s = "批量操作已成功";
	
	/**
	 * 其他操作提示
	 */
	public static final String RET_VALUE_OTHER = "操作已成功";
	
	/**
     * 复审页面短信任务状态为全部状态的默认值
     */
    public static final String SMSTASK_REVIEW_STATUS_ALL= "02,04,06";
    
    /**
     * 复审页面短信任务状态为全部状态的默认值
     */
    public static final String RET_VALUE_Exception1= "操作失败,请稍后重试!";
    
    /**
     * 短信任务并发操作异常信息
     */
    public static final String SMSTASK_SEND_CONCURRENT_EXCEPTION ="操作失败，此短信已不允许发送";
    
    /**
     * 短信任务发送成功操作提示信息
     */
    public static final String SMSTASK_SEND_SUCCESS ="发送成功";
    
    /**
     * 短信任务发送失败，系统异常提示信息
     */
    public static final String SMSTASK_SEND_EXCEPTION ="系统内部异常，如有疑问，请咨询当地10086";
    
    /**
     * 短信操作: 驳回和复审不通过的判断区别  驳回,终止,撤回==1 ,
     */
    public static final String SMS_STATUS_OPER_DIFFERENTIATE ="1";
    
    /**
     * 营销短信: 发送类型为按已订阅用户发送
     */
    public static final String SMS_SEND_TYPE_ORDER ="0";
    /**
     * 营销短信: 发送类型为按营销号源文件发送
     */
    public static final String SMS_SEND_TYPE_NUMBER ="1";
    
	/**
     * 营销短信: 发送类型选择全部
     */
    public static final String SMS_SEND_TYPE_ALL= "-1";
}
