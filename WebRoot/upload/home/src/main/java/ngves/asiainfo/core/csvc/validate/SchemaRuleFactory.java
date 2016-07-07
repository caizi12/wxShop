/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.validate;

import com.ai.appframe2.common.DataStructInterface;

import ngves.asiainfo.core.common.ivalues.IBusiAllegeAssignAcceptValue;
import ngves.asiainfo.core.common.ivalues.IBusiAllegeCommentValue;
import ngves.asiainfo.core.common.ivalues.IBusiAllegeHandlingAcceptValue;
import ngves.asiainfo.core.common.ivalues.IBusiAllegeHastenAcceptValue;
import ngves.asiainfo.core.common.ivalues.IBusiAllegeRHandleAcceptValue;
import ngves.asiainfo.core.common.ivalues.IBusiAllegeRejectSendValue;
import ngves.asiainfo.core.common.ivalues.IBusiAllegeReplySendValue;
import ngves.asiainfo.core.common.model.CsvcItemRule;
import ngves.asiainfo.core.common.model.ItemRuleCollection;
import ngves.asiainfo.core.csvc.AllegeQueryConstant;

/**
 * @author wzg
 *
 */
public class SchemaRuleFactory {
	
	//接收中途意见规则
	private static final ItemRuleCollection allegeComment = new ItemRuleCollection();
	
	//接收投诉派发规则
	private static final ItemRuleCollection allegeAssign = new ItemRuleCollection();
	
	//接收投诉归档规则
	private static final ItemRuleCollection allegeHandling = new ItemRuleCollection();
	
	//接收投诉再处理规则
	private static final ItemRuleCollection allegeRhandle = new ItemRuleCollection();
	
	//接收投诉催办规则
	private static final ItemRuleCollection allegeHasten = new ItemRuleCollection();	

	//一级客服接收投诉回复规则
	private static final ItemRuleCollection allegeReply = new ItemRuleCollection();
	
	//一级客服接收投诉退回规则
	private static final ItemRuleCollection allegeReject = new ItemRuleCollection();
	
	
	private SchemaRuleFactory() {
	}
	
	static {
		//初始化接收中途意见规则
		allegeComment.add(new CsvcItemRule(AllegeQueryConstant.QUERY_INDICTSEQ, 0, 23, 1, 1, IBusiAllegeCommentValue.S_Indictseq));
		allegeComment.add(new CsvcItemRule(AllegeQueryConstant.QUERY_HANDLINGDEPT, 0, 20, 1, 1, IBusiAllegeCommentValue.S_Handlingdept));
		allegeComment.add(new CsvcItemRule(AllegeQueryConstant.QUERY_HANDLINGSTAFF, 0, 20, 1, 1, IBusiAllegeCommentValue.S_Handlingstaff));
		allegeComment.add(new CsvcItemRule(AllegeQueryConstant.QUERY_PHONENUM, 0, 20, 0, 1, IBusiAllegeCommentValue.S_Phonenum));
		allegeComment.add(new CsvcItemRule(AllegeQueryConstant.QUERY_HANDLINGCOMMENT, 0, 2000, 1, 1, IBusiAllegeCommentValue.S_Handlingcomment));
		//初始化接受投诉派发规则
		allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_INDICTSEQ,0,23,1,1,IBusiAllegeAssignAcceptValue.S_Indictseq));
	    allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_CONTACTID, 0, 27, 1, 1, IBusiAllegeAssignAcceptValue.S_Contactid));
	    allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_CONTACTCHANNEL, 0, 10, 1, 1, IBusiAllegeAssignAcceptValue.S_Contactchannel));
	    allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_ORIGINTIME, 19, 19, 1, 1, IBusiAllegeAssignAcceptValue.S_Origintime));
	    allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_CONTACTCONTENT, 0, 2000, 0, 1, IBusiAllegeAssignAcceptValue.S_Contactcontent));	
	    allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_SRID, 0, 26, 1, 1, IBusiAllegeAssignAcceptValue.S_Srid));
	    allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_MSISDN, 11, 11, 1, 1, IBusiAllegeAssignAcceptValue.S_Msisdn));      
	    allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_SUBSNAME, 0, 64, 1, 1, IBusiAllegeAssignAcceptValue.S_Subsname));
	    allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_SVCCITY, 0, 20, 1, 1, IBusiAllegeAssignAcceptValue.S_Svccity));
	    allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_SUBSLEVEL, 0, 2, 1, 1, IBusiAllegeAssignAcceptValue.S_Subslevel));
	    allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_SUBSBRAND, 0, 2, 1, 1, IBusiAllegeAssignAcceptValue.S_Subsbrand));
	    allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_CALLERNO, 0, 20, 1, 1, IBusiAllegeAssignAcceptValue.S_Callerno));
	    allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_CALLEDNO, 0, 20, 1, 1, IBusiAllegeAssignAcceptValue.S_Calledno));       
	    allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_SVCTYPEID, 0, 128, 1, 1, IBusiAllegeAssignAcceptValue.S_Svctypeid));
        allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_URGENTID, 2, 2, 1, 1, IBusiAllegeAssignAcceptValue.S_Urgentid));
        allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_HOMEPROV, 0, 4, 1, 1, IBusiAllegeAssignAcceptValue.S_Homeprov));
        allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_TPROV, 0, 4, 1, 1, IBusiAllegeAssignAcceptValue.S_Tprov));
        allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_ACCEPTTIME, 19, 19, 1, 1, IBusiAllegeAssignAcceptValue.S_Accepttime));
        allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_DEADTIME, 19, 19, 1, 1, IBusiAllegeAssignAcceptValue.S_Deadtime));  
        allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_ACCEPTSTAFF, 0, 20, 1, 1, IBusiAllegeAssignAcceptValue.S_Acceptstaff));
        allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_TITLE, 0, 200, 1, 1, IBusiAllegeAssignAcceptValue.S_Title));
        allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_SERVICECONTENT, 0, 2000, 1, 1, IBusiAllegeAssignAcceptValue.S_Servicecontent));
        allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_PRETREATMENT, 0, 2000, 0, 1, IBusiAllegeAssignAcceptValue.S_Pretreatment));
        allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_PROCESSTYPE, 0, 20, 1, 1, IBusiAllegeAssignAcceptValue.S_Processtype));
        allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_SERVICENAME, 0, 50, 1, 1, IBusiAllegeAssignAcceptValue.S_Servicename));
		//投诉派发独有业务要素
	    allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_ALLEGELEVEL, 0, 15, 1, 1, IBusiAllegeAssignAcceptValue.S_Allegelevel));
	    allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_ITEMID, 0, 16, 1, 1, IBusiAllegeAssignAcceptValue.S_Itemid));
	    //订单和子订单都不强制是20位
	    allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_ORDSEQ, 0, 20, 1, 1, IBusiAllegeAssignAcceptValue.S_Ordseq));
	    allegeAssign.add(new CsvcItemRule(AllegeQueryConstant.QUERY_SUBORDSEQ, 0, 20, 1, 1, IBusiAllegeAssignAcceptValue.S_Subordseq));
		//初始化接收投诉归档规则
		allegeHandling.add(new CsvcItemRule(AllegeQueryConstant.QUERY_INDICTSEQ, 0, 23, 1, 1, IBusiAllegeHandlingAcceptValue.S_Indictseq));
		allegeHandling.add(new CsvcItemRule(AllegeQueryConstant.QUERY_HANDLINGDEPT, 0, 20, 1, 1, IBusiAllegeHandlingAcceptValue.S_Handlingdept));
		allegeHandling.add(new CsvcItemRule(AllegeQueryConstant.QUERY_HANDLINGSTAFF, 0, 20, 1, 1, IBusiAllegeHandlingAcceptValue.S_Handlingstaff));
		allegeHandling.add(new CsvcItemRule(AllegeQueryConstant.QUERY_HANDLINGCOMMENT, 0, 2000, 1, 1, IBusiAllegeHandlingAcceptValue.S_Handlingcomment));
	    allegeHandling.add(new CsvcItemRule(AllegeQueryConstant.QUERY_ENDTIME, 19, 19, 1, 1, IBusiAllegeHandlingAcceptValue.S_Endtime));
	    allegeHandling.add(new CsvcItemRule(AllegeQueryConstant.QUERY_STAFFCONTACTPHONE, 0, 20, 1, 1, IBusiAllegeHandlingAcceptValue.S_Staffcontactphone));
	    allegeHandling.add(new CsvcItemRule(AllegeQueryConstant.QUERY_DOCUMENTSSATISFACTION, 2, 2, 1, 1, IBusiAllegeHandlingAcceptValue.S_Documentssatisfaction));
	    allegeHandling.add(new CsvcItemRule(AllegeQueryConstant.QUERY_SATISFACTION, 2, 2, 0, 1, IBusiAllegeHandlingAcceptValue.S_Satisfaction));
	    allegeHandling.add(new CsvcItemRule(AllegeQueryConstant.QUERY_ISELIGIBLE, 2, 2, 0, 1, IBusiAllegeHandlingAcceptValue.S_Iseligible));
	    allegeHandling.add(new CsvcItemRule(AllegeQueryConstant.QUERY_DUTYREASON, 0, 6, 1, 1, IBusiAllegeHandlingAcceptValue.S_Dutyreason));
	    allegeHandling.add(new CsvcItemRule(AllegeQueryConstant.QUERY_DUTYCAUSEGRADE, 0, 2, 1, 1, IBusiAllegeHandlingAcceptValue.S_Dutycausegrade));
		//初始化接收投诉再处理规则
		allegeRhandle.add(new CsvcItemRule(AllegeQueryConstant.QUERY_INDICTSEQ, 0, 23, 1, 1, IBusiAllegeRHandleAcceptValue.S_Indictseq));
		allegeRhandle.add(new CsvcItemRule(AllegeQueryConstant.QUERY_HANDLINGCOMMENT, 0, 2000, 1, 1, IBusiAllegeRHandleAcceptValue.S_Handlingcomment));
		allegeRhandle.add(new CsvcItemRule(AllegeQueryConstant.QUERY_HANDLINGDEPT, 0, 20, 1, 1, IBusiAllegeRHandleAcceptValue.S_Handlingdept));
		allegeRhandle.add(new CsvcItemRule(AllegeQueryConstant.QUERY_HANDLINGSTAFF, 0, 20, 1, 1, IBusiAllegeRHandleAcceptValue.S_Handlingstaff));
		allegeRhandle.add(new CsvcItemRule(AllegeQueryConstant.QUERY_PHONENUM, 0, 20, 0, 1, IBusiAllegeRHandleAcceptValue.S_Phonenum));
		//初始化接收投诉催办规则
		allegeHasten.add(new CsvcItemRule(AllegeQueryConstant.QUERY_INDICTSEQ, 0, 23, 1, 1, IBusiAllegeHastenAcceptValue.S_Indictseq));
		allegeHasten.add(new CsvcItemRule(AllegeQueryConstant.QUERY_HANDLINGCOMMENT, 0, 2000, 1, 1, IBusiAllegeHastenAcceptValue.S_Handlingcomment));
		allegeHasten.add(new CsvcItemRule(AllegeQueryConstant.QUERY_HANDLINGDEPT, 0, 20, 1, 1, IBusiAllegeHastenAcceptValue.S_Handlingdept));
		allegeHasten.add(new CsvcItemRule(AllegeQueryConstant.QUERY_HANDLINGSTAFF, 0, 20, 1, 1, IBusiAllegeHastenAcceptValue.S_Handlingstaff));
		allegeHasten.add(new CsvcItemRule(AllegeQueryConstant.QUERY_PHONENUM, 0, 20, 0, 1, IBusiAllegeHastenAcceptValue.S_Phonenum));
	
		//初始化一级客服接受投诉回复规则
		allegeReply.add(new CsvcItemRule("IndictSeq", 0, 23, 1, 1, IBusiAllegeReplySendValue.S_Indictseq));
		allegeReply.add(new CsvcItemRule("Satisfaction", 2, 2, 0, 1, IBusiAllegeReplySendValue.S_Satisfaction));
		allegeReply.add(new CsvcItemRule("IndictRslt", 0, 2000, 1, 1, IBusiAllegeReplySendValue.S_Indictrslt));
		allegeReply.add(new CsvcItemRule("SubsLevel", 0, 128, 1, 1, IBusiAllegeReplySendValue.S_Subslevel));
		allegeReply.add(new CsvcItemRule("SubsBrand", 0, 128, 1, 1, IBusiAllegeReplySendValue.S_Subsbrand));
		allegeReply.add(new CsvcItemRule("HandlingDept", 0, 20, 1, 1, IBusiAllegeReplySendValue.S_Handlingdept));
		allegeReply.add(new CsvcItemRule("HandlingStaff", 0, 20, 1, 1, IBusiAllegeReplySendValue.S_Handlingstaff));
		allegeReply.add(new CsvcItemRule("StaffContactPhone", 0, 20, 1, 1, IBusiAllegeReplySendValue.S_Staffcontactphone));
		allegeReply.add(new CsvcItemRule("ReplyTime", 19, 19, 1, 1, IBusiAllegeReplySendValue.S_Replytime));
		allegeReply.add(new CsvcItemRule("DutyReason", 0, 6, 1, 1, IBusiAllegeReplySendValue.S_Dutyreason));
		allegeReply.add(new CsvcItemRule(AllegeQueryConstant.QUERY_DUTYCAUSEGRADE, 0, 2, 1, 1, IBusiAllegeReplySendValue.S_Dutycausegrade));
		//初始化一级客服接受投诉退回规则
		allegeReject.add(new CsvcItemRule("IndictSeq", 0, 20, 1, 1, IBusiAllegeRejectSendValue.S_Indictseq));
		allegeReject.add(new CsvcItemRule("RejectTime", 0, 20, 1, 1, IBusiAllegeRejectSendValue.S_Rejecttime));
		allegeReject.add(new CsvcItemRule("HandlingDept", 0, 20, 1, 1, IBusiAllegeRejectSendValue.S_Handlingdept));
		allegeReject.add(new CsvcItemRule("HandlingStaff", 0, 20, 1, 1, IBusiAllegeRejectSendValue.S_Handlingstaff));
		allegeReject.add(new CsvcItemRule("PhoneNum", 0, 20, 1, 1, IBusiAllegeRejectSendValue.S_Phonenum));
		allegeReject.add(new CsvcItemRule("HandlingComment", 0, 20, 1, 1, IBusiAllegeRejectSendValue.S_Handlingcomment));
	}
	
	public static ItemRuleCollection getItemRuleCollection(DataStructInterface dataContainer) throws Exception {
		if(dataContainer instanceof IBusiAllegeCommentValue ) {
			return allegeComment;
		}else if(dataContainer instanceof IBusiAllegeAssignAcceptValue) {
			return allegeAssign;
		}else if(dataContainer instanceof IBusiAllegeHandlingAcceptValue){
			return allegeHandling;
		}else if(dataContainer instanceof IBusiAllegeRHandleAcceptValue){
			return allegeRhandle;
		}else if(dataContainer instanceof IBusiAllegeHastenAcceptValue){
			return allegeHasten;
		}else if(dataContainer instanceof IBusiAllegeReplySendValue){
			return allegeReply;
		}else if(dataContainer instanceof IBusiAllegeRejectSendValue){
			return allegeReject;
		}else{
			return null;
		}
	}
}
