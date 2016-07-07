package cn.frame.platform.pay.weixin;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import cn.frame.platform.pay.weixin.util.HttpsRequest;
import cn.frame.platform.sys.weixin.WeixinConstant;
/**
 * 获取微信授权类
 * @author li
 *
 */
public class WeiXinOauth2Token {
	private static ObjectMapper objectMapper=new ObjectMapper();
	private static  Logger log=Logger.getLogger(WeiXinOauth2Token.class);

	private String access_token;
	private int expires_in;
	private String refresh_token;
	private String openid;
	private String scope;
 
	
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	
	/**
	 * 获取调用微信授权后返回数据
	 * @param code
	 * @return
	 */
	public static WeiXinOauth2Token getOauth2AccessToken(String code) {
        try {   
            String requestUrl = PayConstant.ACCESS_TOKEN_URL.replace("CODE", code);
            log.info("weixin access token post url:"+ requestUrl);

            HttpsRequest request=new HttpsRequest();
            String result=request.sendPost(requestUrl, null);
            log.info("weixin access token post return:"+result);
            
        	return objectMapper.readValue(result,WeiXinOauth2Token.class);
        	
        } catch (Exception e) {
            log.error("获取网页授权凭证失败",e);
        }
        return null;
  }
	
	/**
	 * 获取微信access token 
	 * 生成二维码、维护公众号菜单等使用
	 * 
	 * @param code
	 * @return
	 */
	public static String getWeixinAccessToken() {
		String access_token = null;
        try {   
            log.info("weixin access token post url:"+ WeixinConstant.WEIXIN_ACCESS_TOKEN_URL);
            
            HttpsRequest request=new HttpsRequest();
            String result=request.sendPost(WeixinConstant.WEIXIN_ACCESS_TOKEN_URL, null);
            
            log.info("qr code post access return:"+result);
            
            WeiXinOauth2Token token= objectMapper.readValue(result,WeiXinOauth2Token.class);
        	
			if (token != null) {
				access_token = token.getAccess_token();
			}
			return access_token;
        	
        } catch (Exception e) {
            log.error("获取二维码token失败",e);
            return access_token;
        }
  }
	
	public static void main(String[] arg) throws Exception{
		
//		WeiXinOauth2Token a=objectMapper.readValue("{\"access_token\":\"OezXcEiiBSKSxW0eoylIeMcgNRrbgGQcO0VmQc3bFI5NZbSd4iV1IErPzngq2Pa4ktyfs2dGEoJaelkzdw-vN1GrpJ1pzTuI8B2uXoVXaG-kiScZmC7itxHsNWr3TWbkf39dS4VIcWzuUA-gcNWi_w\",\"expires_in\":7200,\"refresh_token\":\"OezXcEiiBSKSxW0eoylIeMcgNRrbgGQcO0VmQc3bFI5NZbSd4iV1IErPzngq2Pa4N2BGThyqj0HEyCC9xCAO-tA8qrhX6zonwlz4NuWl9vsVbDJ7AZfM53ra3qe-M_NUG-OEhu4JjrrGO7KUTAJmYg\",\"openid\":\"oIG20t31hGL38TDmKlcmJCn7JjiU\",\"scope\":\"snsapi_base\"}",
//				WeiXinOauth2Token.class);
//		System.out.println(a.getOpenid());
		
		//WeiXinOauth2Token.getWeixinAccessToken();
		
		HttpsRequest httpsRequest = new HttpsRequest();
		httpsRequest.sendGet(WeixinConstant.MENU_CREATE_URL+WeiXinOauth2Token.getWeixinAccessToken());
		
		
		
	}
	
	
}
