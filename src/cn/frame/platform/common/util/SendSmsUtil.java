package cn.frame.platform.common.util;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;

public class SendSmsUtil {
	
	private static final String SMS_URL="http://106.ihuyi.cn/webservice/sms.php?method=Submit";
	private static final String SMS_CONTENT_REGISTER="感谢注册净水商城会员，您的临时验证码为：${smsCode}。本验证码三分钟后失效，过期后请重新申请。";
	private static final String SMS_CONTENT_ORDER="尊敬的客户您好，您的短信确认码为${smsCode}，请在净水商城输入，以便确认购买。";
	private static Logger logger=Logger.getLogger(SendSmsUtil.class);
	
	public static boolean sendSmsForRegister(String mobileNo,String smsCode){
		return sendSms(mobileNo,smsCode,SMS_CONTENT_REGISTER);
	}
	
	public static boolean sendSmsForOrder(String mobileNo,String smsCode){
		return sendSms(mobileNo,smsCode,SMS_CONTENT_ORDER);
	}
	
	/**
	 * 发送手机验证码
	 * true：发送成功
	 * false:发送失败
	 * @param mobileNo
	 * @param smsCode
	 * @return
	 */
	public static boolean sendSms(String mobileNo,String smsCode,String smsContent) {
		  try {
	            //发送POST请求
	            URL url = new URL(SMS_URL);
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("POST");
	            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	            conn.setRequestProperty("Connection", "Keep-Alive");
	            conn.setUseCaches(false);
	            conn.setDoOutput(true);
	            
	        	smsContent=smsContent.replace("${smsCode}", smsCode);
	            smsContent="account=cf_gsxd&password=liang123&mobile="+mobileNo+"&sign=北京广顺信达&content="+java.net.URLEncoder.encode(smsContent,"utf-8");
	            logger.info("注册验证码发送内容："+smsContent+"\n：验证码："+smsCode);
	            conn.setRequestProperty("Content-Length", "" + smsContent.length());
	            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
	            out.write(smsContent);
	            out.flush();
	            out.close();

	            //获取响应状态
	            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
	                System.out.println("connect failed!");
	                return false;
	            }
	            //获取响应内容体
	            String line, result = "";
	            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
	            while ((line = in.readLine()) != null) {
	                result += line ;
	            }
	            in.close();
	            logger.info("发送注册验证码返回内容："+result); System.out.println(result);
	            
	        	if(result.indexOf("<code>2</code>")>-1){
	        		return true;
	        	}
	        	return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
//	        return false;
	}
	 
	
	
 public static void main(String[] args) throws Exception
	{  	 
		System.out.print(sendSmsForOrder("18500135767","1234"));
	}
 
}
