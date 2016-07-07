/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.common.util;

import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.service.ServiceFactory;

import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.common.model.BusiInterMsg;
import ngves.asiainfo.core.csvc.service.interfaces.IInterMsgBusiSrv;
import ngves.asiainfo.interfaces.csvc.model.SendCallInfo;

/**
 * 记录对外接口报文交换流水工具类<br/>
 * 对应查询类型的接口不记录报文交换<br/>
 * 不可实例化,可以继承
 * @author wzg
 *
 */
public abstract class InterMsgBusiUtil {
	
	//定义接口报文流水表的sequence名称
	private static final String BUSI_INTER_MSG_TABLENAME = "BUSI_INTER_MSG";
	
	/**
	 * 记录报文交换流水无返回结果
	 * @param interMsgId  报文流水的主键
	 * @param actionType  记录动作类型(例如：接收投诉派发/发送投诉回复)
	 * @param message	  发送的报文或接收的报文
	 * @return
	 * @throws Exception
	 */
	public static long recordInterMsg(String actionType,String message) throws Exception {
		return recordInterMsg(0L,actionType, message, null);
	}
	
	/**
	 * 记录报文交换流水无返回结果
	 * @param actionType  记录动作类型(例如：接收投诉派发/发送投诉回复)
	 * @param sendCallInfo	  保存发送和结果报文的回调对象
	 * @return
	 * @throws Exception
	 */
	public static long recordInterMsg(String actionType,SendCallInfo sendCallInfo) throws Exception {
		return recordInterMsg(sendCallInfo.getInterMsgId(),actionType, sendCallInfo.getSendXmlContent(), sendCallInfo.getResult());
	}
	/**
	 * 记录报文交换流水存在返回结果
	 * @param interMsgId  报文流水的主键
	 * @param actionType 记录动作类型(例如：接收投诉派发/发送投诉回复)
	 * @param message    发送的报文或接收的报文
	 * @param result	 返回的结果报文
	 * @return
	 * @throws Exception
	 */
	public static long recordInterMsg(long interMsgId,String actionType,String message,String result) throws Exception {
		BusiInterMsg busiInterMsg = new BusiInterMsg(interMsgId, message, actionType, result);
		return ((IInterMsgBusiSrv)ServiceFactory
				.getService(CoreSrvContstant.SERVICE_INTERMSG_BUSI)).addInterMsgBusiInfo(busiInterMsg);
	}
	
	/**
	 * 生成接口报文流水的主键
	 * @return
	 * @throws Exception
	 */
	public static long getBusiInterMsgId() throws Exception{
		 return ServiceManager.getIdGenerator().getNewId(BUSI_INTER_MSG_TABLENAME).longValue();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
