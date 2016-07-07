package cn.frame.platform.pay.weixin.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.frame.platform.pay.weixin.WeiXinOauth2Token;
import cn.frame.platform.sys.weixin.WeixinConstant;

public class HttpHelper {
	// 新建日志记录
	private static Log log = LogFactory.getLog(HttpHelper.class);
 
	private HttpHelper() {
		// 禁止初始化
	}

	public static String httpGet(String url){
		try{ 
			GetMethod getMethod = new GetMethod(url);
			getMethod.setRequestHeader("content-type","application/x-www-form-urlencoded;charset=utf-8");
	 
			HttpClient httpClient = new HttpClient();
			httpClient.executeMethod(getMethod);
			String res = getMethod.getResponseBodyAsString().trim();
			return res;
		 }catch(Exception e){
			log.error("httpGet error:",e);
			return null;
		}
	}

	public static void main(String[] args) {
		System.out.print(httpGet(WeixinConstant.MENU_DELETE_URL+WeiXinOauth2Token.getWeixinAccessToken()));
	}

 
}
