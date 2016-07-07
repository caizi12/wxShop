/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.common.ivalues.IBusiAllegeCommentValue;
import ngves.asiainfo.core.common.ivalues.IBusiAllegeRejectSendValue;
import ngves.asiainfo.core.common.ivalues.IBusiAllegeReplySendValue;
import ngves.asiainfo.core.csvc.AllegeQueryConstant;
import ngves.asiainfo.core.csvc.CsvcConstant;
import ngves.asiainfo.interfaces.InterNameSpace;
import ngves.asiainfo.interfaces.InterUtil;
import ngves.asiainfo.interfaces.csvc.CsvcInterConstant;
import ngves.asiainfo.interfaces.csvc.bean.common.CsvcCommonInterBOSSDocument;
import ngves.asiainfo.interfaces.csvc.bean.common.CsvcCommonInterBoss;
import ngves.asiainfo.interfaces.csvc.bean.common.CsvcCommonRouting;
import ngves.asiainfo.interfaces.csvc.bean.common.CsvcCommonSPReserve;
import ngves.asiainfo.interfaces.csvc.bean.csvcBussi.in.CsvcBussiRequestInItem;
import ngves.asiainfo.interfaces.csvc.bean.csvcBussi.in.CsvcBussiRequestInSvcRoot;
import ngves.asiainfo.interfaces.csvc.bean.csvcBussi.in.CsvcBussiRequestInSvcRootDocument;
import ngves.asiainfo.util.DateTimeUtil;

import ngves.asiainfo.util.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 积分平台业务对象转换为XML的报文对象<br/>
 * 不可实例化,可以继承
 * @author wzg
 *
 */
public abstract class BeanToXmlObjUtil {

	private static transient Log log = LogFactory.getLog(BeanToXmlObjUtil.class);
	/**
	 * 序列锁
	 */
	private static final byte[] lock = new byte[0];

	/**
	 * 序列的最小值-该变量可变
	 */
	private static int TRANSIDC_END = 100000;

	/**
	 * 供监控查看-且非同步
	 * @return
	 */
	public static int getTransId() {
		return TRANSIDC_END;
	}

	/**
	 * 得到序列的下一个递增值,同步控制
	 * @return
	 */
	public static int getNextTransId() {
		synchronized (lock) {
			if (TRANSIDC_END >= 999999) {
				TRANSIDC_END = 100000;
			}
			return TRANSIDC_END++;
		}
	}

	/**
	 * 得到 一级客服通用输入(报文头)bean<br/>
	 * 该报文是积分平台发送给一级客服的初始化状态<br>
	 * 会默认填写以下固定的内容，需要自行根据动作进行设置的内容：<br>
	 * BipCode(业务功能代码),ActivityCode(交易动作代码),ProcID(JF_CODE + 各个业务流水主键),TransIDO(JF_CODE + 设置报文流水主键)
	 * @return
	 */
	public static CsvcCommonInterBoss getRequestCsvcCommonBean() {
		CsvcCommonInterBoss in = CsvcCommonInterBOSSDocument.Factory.newInstance().addNewInterBOSS();
		in.setOrigDomain(CsvcInterConstant.JF_CODE);
		in.setHomeDomain(CsvcInterConstant.CSVC_CODE);
		in.setBIPVer("0100");
		in.setActionCode(CsvcInterConstant.ACTIONTYPE_REQUEST);
		CsvcCommonRouting routing = in.addNewRouting();
		routing.setRouteType("00");
		routing.setRouteValue("000");
		in.setProcessTime(DateTimeUtil.format(new Date(), CommnConstant.DATETIME_HP_FORMAT));
		CsvcCommonSPReserve spreserve = in.addNewSPReserve();
		spreserve.setTransIDC("0000" + CsvcInterConstant.JF_CODE
				+ DateTimeUtil.format(new Date(), CommnConstant.DATETIME_HP_FORMAT) + getTransId());
		spreserve.setCutOffDay(DateTimeUtil.format(new Date(), CommnConstant.DATE_FILE_FORMAT));
		spreserve.setOSNDUNS("0000");
		spreserve.setHSNDUNS("0000");
		spreserve.setConvID("007400005563" + DateTimeUtil.format(new Date(), CommnConstant.DATETIME_HP_FORMAT));
		in.setTestFlag("0");
		in.setMsgSender("0135");
		in.setMsgReceiver("0000");
		in.setSvcContVer("0100");
		return in;
	}

	/**
	 * 根据接收到的报文对象形成返回的报文对象,改变请求动作为应答<br/>
	 * 并设置TransIDH(JF_CODE + 报文流水主键)如果出现时格式为(当前时间毫秒+JF_CODE),<br/>
	 * 设置报文体内容为空.
	 * @param in
	 * @return
	 */
	public static CsvcCommonInterBoss getResponseCsvcCommonBean(CsvcCommonInterBoss in, long interMsgId) {
		CsvcCommonInterBoss out = (CsvcCommonInterBoss) in.copy();
		out.setActionCode(CsvcInterConstant.ACTIONTYPE_RESPONSE);
		if (interMsgId < 0) {
			out.setTransIDH(System.currentTimeMillis() + CsvcInterConstant.JF_CODE);
		} else {
			out.setTransIDH(CsvcInterConstant.JF_CODE + interMsgId);
		}
		//设置默认的内容
		out.setSvcCont("");
		return out;
	}

	//测试一级客服接收报文
	public static void getResponseCsvcCommonBean(CsvcCommonInterBoss in) {
		in.setActionCode(CsvcInterConstant.ACTIONTYPE_RESPONSE);
		in.setProcessTime(DateTimeUtil.format(new Date(), CommnConstant.DATETIME_HP_FORMAT));
		in.setSvcCont(CsvcInterConstant.XML_HEADER_UTF8);
	}

	//得到 一级客服业务输入(发送报文体)bean
	public static CsvcBussiRequestInSvcRoot getCsvcBussiRequestInBean() {
		return CsvcBussiRequestInSvcRootDocument.Factory.newInstance().addNewSvcRoot();
	}

	/**
	 * 根据一级客服接口参数对象和积分的Bean对象生成报文对象CsvcCommonInterBoss
	 * 注：只生成header部分
	 * @param csvcInterPara
	 * @return
	 * @throws Exception
	 */
	public static CsvcCommonInterBoss createCsvcCommonInterBoss(CsvcInterPara csvcInterPara) throws Exception {
		CsvcCommonInterBoss in = getRequestCsvcCommonBean();
		in.setBIPCode(csvcInterPara.getBipCode());
		in.setActivityCode(csvcInterPara.getActivityCode());
		in.setProcID(csvcInterPara.getProcID());
		in.setTransIDO(csvcInterPara.getTransIDO());
		//暂时使用空
		in.setTransIDH("");
		return in;
	}

	/**
	 * 投诉回复报文reply：根据一级客服接口参数对象和积分的Bean对象生成报文对象CsvcCommonInterBoss
	 * @param csvcInterPara
	 * @param allegeReplySendValue
	 * @return
	 * @throws Exception
	 */
	public static CsvcCommonInterBoss createReplyInterBoss(CsvcInterPara csvcInterPara,
			IBusiAllegeReplySendValue allegeReplySendValue) throws Exception {
		CsvcCommonInterBoss in = createCsvcCommonInterBoss(csvcInterPara);
		in.setSvcCont(formatReply(allegeReplySendValue));
		return in;
	}

	/**
	 * 投诉退回报文reject：根据一级客服接口参数对象和积分的Bean对象生成报文对象CsvcCommonInterBoss
	 * @param csvcInterPara
	 * @param allegeRejectSendValue
	 * @return
	 * @throws Exception
	 */
	public static CsvcCommonInterBoss createRejectInterBoss(CsvcInterPara csvcInterPara,
			IBusiAllegeRejectSendValue allegeRejectSendValue) throws Exception {
		CsvcCommonInterBoss in = createCsvcCommonInterBoss(csvcInterPara);
		in.setSvcCont(formatReject(allegeRejectSendValue));
		return in;
	}

	/**
	 * 发送中途意见comment：根据一级客服接口参数对象和积分的Bean对象生成报文对象CsvcCommonInterBoss
	 * @param csvcInterPara
	 * @param allegeCommentValue
	 * @return
	 * @throws Exception
	 */
	public static CsvcCommonInterBoss createCommentInterBoss(CsvcInterPara csvcInterPara,
			IBusiAllegeCommentValue allegeCommentValue) throws Exception {
		CsvcCommonInterBoss in = createCsvcCommonInterBoss(csvcInterPara);
		in.setSvcCont(formatComment(allegeCommentValue));
		return in;
	}

	public static String getXmlContent(CsvcBussiRequestInSvcRoot in) throws Exception {
		CsvcBussiRequestInSvcRootDocument doc = CsvcBussiRequestInSvcRootDocument.Factory.newInstance();
		doc.setSvcRoot(in);
		String xmlContent = CsvcInterConstant.XML_HEADER_UTF8 + doc.toString();
		xmlContent = InterUtil.minusNameSpace(InterNameSpace.NAMESPCE_CSVC_BUSSI, xmlContent);
		xmlContent = InterUtil.minusCommonNameSpace(InterNameSpace.NAMESPACE_COMMON_IN, xmlContent);
		xmlContent = InterUtil.minusCommonNameSpace(InterNameSpace.NAMESPACE_COMMON_NIL, xmlContent);
		//返回报文内容
		if (log.isDebugEnabled()) {
			log.debug(" xmlCont := " + xmlContent);
		}
		return xmlContent;
	}

	private static String encodeUTF8(String s) throws UnsupportedEncodingException {
		return s;
		//        if(s == null){
		//            return null;
		//        }
		//        return URLEncoder.encode(s, CommnConstant.ENCODING_UTF);
	}

	/**
	 * 响应中途意见
	 * @param
	 * @return
	 * @throws Exception
	 */
	public static String formatComment(IBusiAllegeCommentValue value) throws Exception {

		CsvcBussiRequestInSvcRoot in = getCsvcBussiRequestInBean();
		CsvcBussiRequestInItem item = null;
		item = in.addNewItem();
		item.setName(AllegeQueryConstant.QUERY_INDICTSEQ);
		item.setValue(value.getIndictseq());

		item = in.addNewItem();
		item.setName(AllegeQueryConstant.QUERY_HANDLINGDEPT);
		item.setValue(encodeUTF8(value.getHandlingdept()));

		item = in.addNewItem();
		item.setName(AllegeQueryConstant.QUERY_HANDLINGSTAFF);
		item.setValue(encodeUTF8(value.getHandlingstaff()));

		item = in.addNewItem();
		item.setName(AllegeQueryConstant.QUERY_PHONENUM);
		item.setValue(value.getPhonenum());

		item = in.addNewItem();
		item.setName(AllegeQueryConstant.QUERY_HANDLINGCOMMENT);
		item.setValue(encodeUTF8(value.getHandlingcomment()));
		return BeanToXmlObjUtil.getXmlContent(in);
	}

	/**
	 * 响应投诉退回
	 * @param
	 * @return
	 * @throws Exception
	 */
	public static String formatReject(IBusiAllegeRejectSendValue value) throws Exception {

		CsvcBussiRequestInSvcRoot in = getCsvcBussiRequestInBean();
		CsvcBussiRequestInItem item = null;
		item = in.addNewItem();
		item.setName(AllegeQueryConstant.QUERY_INDICTSEQ);
		item.setValue(value.getIndictseq());

		item = in.addNewItem();
		item.setName(AllegeQueryConstant.QUERY_HANDLINGDEPT);
		item.setValue(encodeUTF8(value.getHandlingdept()));

		item = in.addNewItem();
		item.setName(AllegeQueryConstant.QUERY_HANDLINGSTAFF);
		item.setValue(encodeUTF8(value.getHandlingstaff()));

		item = in.addNewItem();
		item.setName(AllegeQueryConstant.QUERY_REJECTTIME);
		item.setValue(DateTimeUtil.format(new Date(), CommnConstant.DATETIME_JAVA_FORMAT));

		item = in.addNewItem();
		item.setName(AllegeQueryConstant.QUERY_PHONENUM);
		item.setValue(value.getPhonenum());

		item = in.addNewItem();
		item.setName(AllegeQueryConstant.QUERY_HANDLINGCOMMENT);
		item.setValue(encodeUTF8(value.getHandlingcomment()));
		return BeanToXmlObjUtil.getXmlContent(in);
	}

	/**
	 * 响应投诉回复
	 * @param
	 * @return
	 * @throws Exception
	 */
	public static String formatReply(IBusiAllegeReplySendValue value) throws Exception {

		CsvcBussiRequestInSvcRoot in = getCsvcBussiRequestInBean();
		CsvcBussiRequestInItem item = null;
		item = in.addNewItem();
		item.setName(AllegeQueryConstant.QUERY_INDICTSEQ);
		item.setValue(value.getIndictseq());

		item = in.addNewItem();
		item.setName(AllegeQueryConstant.QUERY_HANDLINGDEPT);
		item.setValue(encodeUTF8(value.getHandlingdept()));

		item = in.addNewItem();
		item.setName(AllegeQueryConstant.QUERY_HANDLINGSTAFF);
		item.setValue(encodeUTF8(value.getHandlingstaff()));

        String satisfaction = value.getSatisfaction();
        if(StringUtil.isBlank(satisfaction)){
            satisfaction = CsvcConstant.SATISFACTION_UNKNOWN;
        }

        item = in.addNewItem();
        item.setName(AllegeQueryConstant.QUERY_SATISFACTION);
        item.setValue(satisfaction);

		item = in.addNewItem();
		item.setName(AllegeQueryConstant.QUERY_INDICTRSLT);
		item.setValue(encodeUTF8(value.getIndictrslt()));

		item = in.addNewItem();
		item.setName(AllegeQueryConstant.QUERY_SUBSLEVEL);
		item.setValue(value.getSubslevel());

		item = in.addNewItem();
		item.setName(AllegeQueryConstant.QUERY_SUBSBRAND);
		item.setValue(value.getSubsbrand());

		item = in.addNewItem();
		item.setName(AllegeQueryConstant.QUERY_STAFFCONTACTPHONE);
		item.setValue(value.getStaffcontactphone());

		item = in.addNewItem();
		item.setName(AllegeQueryConstant.QUERY_REPLYTIME);
		item.setValue(DateTimeUtil.formatDateTime(value.getReplytime()));

		item = in.addNewItem();
		item.setName(AllegeQueryConstant.QUERY_DUTYREASON);
		item.setValue(value.getDutyreason());

		item = in.addNewItem();
		item.setName(AllegeQueryConstant.QUERY_DUTYCAUSEGRADE);
		item.setValue(value.getDutycausegrade());
		
		return BeanToXmlObjUtil.getXmlContent(in);
	}

	/**
	 * 使用内部类提供内聚性
	 * @author wzg
	 *
	 */
	public static class CsvcInterPara {
		private String bipCode;
		private String activityCode;
		private String procID;
		private String transIDO;

		public CsvcInterPara(String bipCode, String activityCode, String procID, String transIDO) {
			this.bipCode = bipCode;
			this.activityCode = activityCode;
			this.procID = CsvcInterConstant.JF_CODE + procID;
			this.transIDO = CsvcInterConstant.JF_CODE + transIDO;
		}

		public String getBipCode() {
			return bipCode;
		}

		public String getActivityCode() {
			return activityCode;
		}

		public String getProcID() {
			return procID;
		}

		public String getTransIDO() {
			return transIDO;
		}

	}

	public static void main(String args[]) throws Exception {
		CsvcCommonInterBOSSDocument out = CsvcCommonInterBOSSDocument.Factory.newInstance();
		CsvcCommonInterBoss in = out.addNewInterBOSS();
		in.setOrigDomain(CsvcInterConstant.JF_CODE);
		in.setHomeDomain(CsvcInterConstant.CSVC_CODE);
		in.setBIPVer("0100");
		in.setActionCode(CsvcInterConstant.ACTIONTYPE_REQUEST);
		CsvcCommonRouting routing = in.addNewRouting();
		routing.setRouteType("00");
		routing.setRouteValue("000");
		in.setProcessTime(DateTimeUtil.format(new Date(), CommnConstant.DATETIME_HP_FORMAT));
		CsvcCommonSPReserve spreserve = in.addNewSPReserve();
		spreserve.setTransIDC("0000" + CsvcInterConstant.JF_CODE
				+ DateTimeUtil.format(new Date(), CommnConstant.DATETIME_HP_FORMAT) + getTransId());
		spreserve.setCutOffDay(DateTimeUtil.format(new Date(), CommnConstant.DATE_FILE_FORMAT));
		spreserve.setOSNDUNS("0000");
		spreserve.setHSNDUNS("0000");
		spreserve.setConvID("007400005563" + DateTimeUtil.format(new Date(), CommnConstant.DATETIME_HP_FORMAT));
		in.setTestFlag("0");
		in.setMsgSender("0135");
		in.setMsgReceiver("0000");
		in.setSvcContVer("0100");
		System.out.print("InterBOSS ==>>" + out.toString());
		//测试svcroot报文格式
		CsvcBussiRequestInSvcRoot inSvc = getCsvcBussiRequestInBean();
		CsvcBussiRequestInItem item = inSvc.addNewItem();
		item.setName(AllegeQueryConstant.QUERY_INDICTSEQ);
		item.setValue("23423423423424");
		CsvcBussiRequestInSvcRootDocument doc = CsvcBussiRequestInSvcRootDocument.Factory.newInstance();
		doc.setSvcRoot(inSvc);
		System.out.println("SvcRoot ==>> " + doc.toString());

		CsvcBussiRequestInSvcRootDocument doc2 = CsvcBussiRequestInSvcRootDocument.Factory.newInstance();
		doc2.setSvcRoot(null);
		String xmlContent = CsvcInterConstant.XML_HEADER_UTF8 + doc2.toString();
		xmlContent = InterUtil.minusNameSpace(InterNameSpace.NAMESPCE_CSVC_BUSSI, xmlContent);
		xmlContent = InterUtil.minusCommonNameSpace(InterNameSpace.NAMESPACE_COMMON_IN, xmlContent);
		xmlContent = InterUtil.minusCommonNameSpace(InterNameSpace.NAMESPACE_COMMON_NIL, xmlContent);
		//返回报文内容
		System.out.println(" xmlCont := " + xmlContent);
	}

}
