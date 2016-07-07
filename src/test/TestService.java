package test;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;

public class TestService {
	
	private static final String SMS_URL="http://localhost:8080/testXfire/services/testCxf?wsdl";
	private static Logger logger=Logger.getLogger(TestService.class);
	
 
	/**
	 * 发送手机验证码
	 * true：发送成功
	 * false:发送失败
	 * @param mobileNo
	 * @param smsCode
	 * @return
	 */
	public static boolean sendSms(String smsContent) {
		  try {
	            //发送POST请求
	            URL url = new URL(SMS_URL);
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            //conn.setRequestMethod("POST");
	            conn.setRequestProperty("Content-Type","application/soap+xml; charset=utf-8");
	            conn.setRequestProperty("Connection", "Keep-Alive");
	            conn.setUseCaches(false);
	            conn.setDoOutput(true);
	            
	            smsContent="ab=123";
	            conn.setRequestProperty("Content-Length", "" + smsContent.length());
	            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
	            out.write(smsContent);
	            out.flush();
	            out.close();
	            System.out.println("connect failed!");
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
	            System.out.println(result);
	            
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
		System.out.print(sendSms("1234"));
	}
 
}
