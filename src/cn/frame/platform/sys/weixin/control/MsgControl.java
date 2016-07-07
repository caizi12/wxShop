package cn.frame.platform.sys.weixin.control;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.frame.platform.common.ConstantPlatform;
import cn.frame.platform.common.util.xml.XmlUtil;
import cn.frame.platform.sys.weixin.WeixinConstant;
import cn.frame.platform.sys.weixin.entitys.WeixinMsgRequest;
import cn.frame.platform.sys.weixin.entitys.WeixinMsgResponse;

/**
 * 微信事件接收、回复类
 * 
 * @author li
 * 
 */

@Controller
@RequestMapping("/weixin/msg")
public class MsgControl {
	private static Logger log = Logger.getLogger(MsgControl.class);
 
	/**
	 * 接收微信反馈的消息
	 * @param request
	 * @param response
	 */
	@SuppressWarnings("finally")
	@RequestMapping("/receive")
	@ResponseBody
	public String receiveMsg(HttpServletRequest request, HttpServletResponse response) {
		// 回复信息
		String replyMsg = "";
		try {
			// 开启服务器配置校验
			String echostr = request.getParameter("echostr");
			log.debug("--echostr---:" + echostr);
			if (StringUtils.isNotBlank(echostr)) {
				replyMsg = echostr;
			} else {
				// 接收微信消息处理
				String receiveMsg = WeixinMsgRequest.readRequestData(request);
				log.info("--receive wei xin msg:" + receiveMsg);
				WeixinMsgRequest msgRequest = (WeixinMsgRequest) XmlUtil.getObjectFromXML(receiveMsg, WeixinMsgRequest.class);

				// 微信二微码扫码事件处理
				if (msgRequest.getEventKey().indexOf(WeixinConstant.EVENT_KEY_SCAN_QR_REGISTER) > -1) {
					replyMsg = MsgControl.qrCodeRegister(msgRequest);
				}
			}

		} catch (Exception e) {
			log.error("reply wei xin msg error", e);
		} finally {
			log.info("reply wei xin msg:" + replyMsg);
		    return replyMsg;
		}
	}

	/**
	 * 二维码扫描注册事件处理
	 */
	public static String qrCodeRegister(WeixinMsgRequest msgRequest) {
		WeixinMsgResponse response = new WeixinMsgResponse();
		response.setFromUserName(msgRequest.getToUserName());
		response.setToUserName(msgRequest.getFromUserName());
		response.setCreateTime(String.valueOf(new Date().getTime()/1000));
		response.setMsgType(WeixinConstant.REPLY_MSG_TYPE_NEWS);
		// 暂固定每次发一条消息
		response.setArticleCount("1");
		StringBuffer responMsg = new StringBuffer(XmlUtil.coventObjectToXml(response).replace("</xml>", ""));
		
		responMsg.append("<Articles>\n");
		WeixinMsgResponse.MsgNews msgNews = new WeixinMsgResponse.MsgNews();
		msgNews.setTitle("欢迎关注净水商城，戳我即可加入净水商城");
		 
		String eventKey=msgRequest.getEventKey();
		String qrParam=eventKey.substring(WeixinConstant.EVENT_KEY_SCAN_QR_REGISTER.length());
		msgNews.setUrl(ConstantPlatform.SYS_SHOP_NET_URL+"/member/"+qrParam+"/registerPage.do");
		responMsg.append(XmlUtil.coventObjectToXml(msgNews, "item"));
		responMsg.append("\n</Articles></xml>");

		return responMsg.toString();
	}

	
	/**
	 * 二维码扫描注册事件处理
	 */
	public static String test(WeixinMsgRequest msgRequest) {
		WeixinMsgResponse response = new WeixinMsgResponse();
		response.setFromUserName(msgRequest.getToUserName());
		response.setToUserName(msgRequest.getFromUserName());
		response.setCreateTime(String.valueOf(new Date().getTime()/1000));
		 
		// 暂固定每次发一条消息
		StringBuffer responMsg = new StringBuffer(XmlUtil.coventObjectToXml(response).replace("</xml>", ""));
		
		responMsg.append("<MsgType><![CDATA[text]]></MsgType><Content><![CDATA[你好]]></Content>");

		responMsg.append("</xml>");

		return responMsg.toString();
	}
	
	public static void main(String[] a) throws JsonParseException, JsonMappingException, IOException {
		String receiveMsg = "<xml><ToUserName><![CDATA[toUser]]></ToUserName> <FromUserName><![CDATA[FromUser]]></FromUserName> <CreateTime>123456789</CreateTime> <MsgType><![CDATA[event]]></MsgType> <Event><![CDATA[subscribe]]></Event> <EventKey><![CDATA[qrscene_123123]]></EventKey> <Ticket><![CDATA[TICKET]]></Ticket> </xml>";

		WeixinMsgRequest msgRequest = (WeixinMsgRequest) XmlUtil.getObjectFromXML(receiveMsg, WeixinMsgRequest.class);
		String res = MsgControl.test(msgRequest);
		System.out.println(res);

	}
}
