package cn.frame.platform.sys.weixin.entitys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

public class WeixinMsgRequest {
 //开发者微信号
 private String ToUserName;
 
 //发送方帐号（一个OpenID）
 private String FromUserName;
 private String CreateTime;
 //消息类型，event
 private String MsgType;
 //事件类型，subscribe
 private String Event;
 //事件KEY值，qrscene_为前缀，后面为二维码的参数值
 private String EventKey;
 //二维码的ticket，可用来换取二维码图片
 private String Ticket;
 
public String getToUserName() {
	return ToUserName;
}
public void setToUserName(String toUserName) {
	ToUserName = toUserName;
}
public String getFromUserName() {
	return FromUserName;
}
public void setFromUserName(String fromUserName) {
	FromUserName = fromUserName;
}
public String getCreateTime() {
	return CreateTime;
}
public void setCreateTime(String createTime) {
	CreateTime = createTime;
}
public String getMsgType() {
	return MsgType;
}
public void setMsgType(String msgType) {
	MsgType = msgType;
}
public String getEvent() {
	return Event;
}
public void setEvent(String event) {
	Event = event;
}
public String getEventKey() {
	return EventKey;
}
public void setEventKey(String eventKey) {
	EventKey = eventKey;
}
public String getTicket() {
	return Ticket;
}
public void setTicket(String ticket) {
	Ticket = ticket;
}

/**
 * 读取request中的数据
 * @param request
 * @return
 * @throws IOException
 */
 public static String readRequestData(HttpServletRequest request) throws IOException{
	    InputStreamReader isr = new InputStreamReader(request.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String readLineStr = "";
		StringBuffer tmpStr = new StringBuffer();
		while ((readLineStr = br.readLine()) != null) {
			tmpStr.append(readLineStr);
		}
		return tmpStr.toString();
 }
 
	
}
