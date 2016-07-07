/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc;

public class AllegeQueryConstant {

    /**
     * 接受投诉派发 
     * 客户接触编号:ContactId
     */
    public final static String  QUERY_CONTACTID = "ContactId";
    
    /**
     * 接受投诉派发 
     * 接触渠道 :ContactChannel
     */
    public final static String  QUERY_CONTACTCHANNEL = "ContactChannel";
    
    /**
     * 接受投诉派发 
     * 用户接触时间:OriginTime
     */
    public final static String  QUERY_ORIGINTIME = "OriginTime";
    
    /**
     * 接受投诉派发 
     * 接触内容:ContactContent
     */
    public final static String  QUERY_CONTACTCONTENT = "ContactContent"; 
    
    /**
     * 接受投诉派发 
     * 客户服务请求编号:SRId
     */
    public final static String  QUERY_SRID = "SRId";
    
    /**
     * 接受投诉派发 
     * 用户手机号码:MSISDN
     */
    public final static String  QUERY_MSISDN = "MSISDN"; 
    
    
    /**
     * 接受投诉派发 
     * 用户姓名:SubsName
     */
    public final static String  QUERY_SUBSNAME = "SubsName";
    
    /**
     * 接受投诉派发 
     * 业务城市:SvcCity
     */
    public final static String  QUERY_SVCCITY = "SvcCity"; 
    
    
    /**
     * 接受投诉派发 
     * 主叫号码:CallerNo
     */
    public final static String  QUERY_CALLERNO = "CallerNo";
    
    /**
     * 接受投诉派发 
     * 被叫号码:CalledNo
     */
    public final static String  QUERY_CALLEDNO = "CalledNo"; 
    
    
    /**
     * 接受投诉派发 
     * 服务请求分类编码:SvcTypeId
     */
    public final static String  QUERY_SVCTYPEID = "SvcTypeId";
    
    /**
     * 接受投诉派发 
     * 紧急程度:UrgentId
     */
    public final static String  QUERY_URGENTID = "UrgentId"; 
    
    
    /**
     * 接受投诉派发 
     * 受理机构代码：HomeProv
     */
    public final static String  QUERY_HOMEPROV = "HomeProv";
    
    /**
     * 接受投诉派发 
     * 目标机构代码：TProv
     */
    public final static String  QUERY_TPROV = "TProv"; 
    
    /**
     * 接受投诉派发 
     * 投诉提交时间：AcceptTime
     */
    public final static String  QUERY_ACCEPTTIME = "AcceptTime";
    
    /**
     * 接受投诉派发 
     * 最后犯规时间：DeadTime
     */
    public final static String  QUERY_DEADTIME = "DeadTime"; 
    

    /**
     * 接受投诉派发 
     * 最后犯规时间：AcceptStaff
     */
    public final static String  QUERY_ACCEPTSTAFF = "AcceptStaff"; 
    
    /**
     * 接受投诉派发 
     * 最后犯规时间：Title
     */
    public final static String  QUERY_TITLE = "Title"; 
    
    
    /**
     * 接受投诉派发 
     * 业务内容：ServiceContent
     */
    public final static String  QUERY_SERVICECONTENT = "ServiceContent"; 
    
    /**
     * 接受投诉派发 
     * 预处理情况：Pretreatment
     */
    public final static String  QUERY_PRETREATMENT = "Pretreatment"; 
    
    
    /**
     * 接受投诉派发 
     * 流程类别：ProcessType
     */
    public final static String  QUERY_PROCESSTYPE = "ProcessType"; 
    
    /**
     * 接受投诉派发 
     * 业务类别：ServiceName
     */
    public final static String  QUERY_SERVICENAME = "ServiceName"; 
    
    
    /**
     * 投诉派发独有业务要素
     * 投诉级别:AllegeLevel
     */
    public final static String QUERY_ALLEGELEVEL = "AllegeLevel";
    /**
     * 投诉派发独有业务要素
     * 礼品编码: ItemID
     */
    public final static String QUERY_ITEMID = "ItemID";
    /**
     * 投诉派发独有业务要素
     * 订单标识:OrdSeq
     */
    public final static String QUERY_ORDSEQ = "OrdSeq";
    /**
     * 投诉派发独有业务要素
     * 子订单标识: SubOrdSeq
     */
    public final static String QUERY_SUBORDSEQ = "SubOrdSeq";
    
    /**
     * 投诉归档接收流水表 
     * 归档时间 ：EndTime   
     */
    public final static String QUERY_ENDTIME = "EndTime";
    

    /**
     * 投诉归档接收流水表 
     * 工单满意度 ：DocumentsSatisfaction   
     */
    public final static String QUERY_DOCUMENTSSATISFACTION = "DocumentsSatisfaction";
    
    /**
     * 投诉归档接收流水表 
     * 回单质量是否合格 ：IsEligible   
     */
    public final static String QUERY_ISELIGIBLE = "IsEligible";

    
    
	/**
	 * 投诉查询   中途意见  投诉退回   投诉回复
	 * 投诉工单编号： IndictSeq
	 */
	public final static String QUERY_INDICTSEQ ="IndictSeq";
	
	/**
	 * 投诉查询
	 * 投诉工单状态： busi_id
	 */
	public final static String QUERY_STATUS ="Status";
	
	/**
	 * 投诉查询
	 * 当前环节：CurrentNode
	 */
	public final static String QUERY_CURRENTNODE ="CurrentNode";
	
	/**
	 * 投诉查询   中途意见   投诉退回   投诉回复
	 * 处理部门：HandlingDept
	 */
	public final static String QUERY_HANDLINGDEPT ="HandlingDept";
	
	/**
	 * 投诉查询   中途意见    投诉退回   投诉回复
	 * 处理人：HandlingStaff
	 */
	public final static String QUERY_HANDLINGSTAFF ="HandlingStaff";
	
	/**
	 * 中途意见  投诉退回
	 * 操作人联系电话：PhoneNum
	 */
	public final static String QUERY_PHONENUM ="PhoneNum";
	
	/**
	 * 中途意见    投诉退回
	 * 中途意见：HandlingComment
	 */
	public final static String QUERY_HANDLINGCOMMENT ="HandlingComment";
	
	/**
	 * 投诉退回
	 * 退回时间：RejectTime
	 */
	public final static String QUERY_REJECTTIME ="RejectTime";
	
	/**
	 * 投诉回复
	 * 用户满意度：Satisfaction
	 */
	public final static String QUERY_SATISFACTION ="Satisfaction";
	
	/**
	 * 投诉回复
	 * 投诉处理结果：Satisfaction
	 */
	public final static String QUERY_INDICTRSLT ="IndictRslt";
	
	/**
	 * 投诉回复
	 * 用户级别：SubsLevel
	 */
	public final static String QUERY_SUBSLEVEL ="SubsLevel";
	
	/**
	 * 投诉回复
	 * 用户品牌：SubsBrand
	 */
	public final static String QUERY_SUBSBRAND ="SubsBrand";
	
	/**
	 * 投诉回复
	 * 回单人联系电话：StaffContactPhone
	 */
	public final static String QUERY_STAFFCONTACTPHONE ="StaffContactPhone";
	
	/**
	 * 投诉回复
	 * 回单时间：ReplyTime
	 */
	public final static String QUERY_REPLYTIME ="ReplyTime";
	
	/**
	 * 投诉回复
	 * 责任原因：DutyReason
	 */
	public final static String QUERY_DUTYREASON ="DutyReason";
	
	/**
	 * 投诉回复
	 * 责任原因级别：DutyCauseGrade
	 */
	public final static String QUERY_DUTYCAUSEGRADE ="DutyCauseGrade";
	
	
	
}
