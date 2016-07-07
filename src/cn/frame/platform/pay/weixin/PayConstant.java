package cn.frame.platform.pay.weixin;

import java.io.UnsupportedEncodingException;

/**
 * 微信支付参数常量类
 * @author li
 *
 */
public class PayConstant {

	//sdk的版本号
	public static final String sdkVersion = "java sdk 1.0.1";
 
	//微信分配的公众号ID（开通公众号之后可以获取到）
	public static final String appID = "wxdd01fa25bdf452da";

	//微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
	public static final String mchID = "1260378401";
	
	//微信商户支付密钥
	public static final String key = "liuliliang2015083011181300000000";
	
	/**
	 * 应用密钥
	 */
	public static final String AppSecret="dea68ee173d803f0b79f750945578139";
	
	//HTTPS证书密码，默认密码等于商户号MCHID
	public static final String certPassword = "1260378401";
	
	//HTTPS证书的本地路径
	public static final String certLocalPath =PayConstant.class.getResource("/").getPath()+"apiclient_cert.p12";
	
	//微信统一支付URL
	public static final String PAY_URL="https://api.mch.weixin.qq.com/pay/unifiedorder";
	
	/**
	 * 调用统一支付回调URL
	 */
	public static final String PAY_RESULT_URL="http://www.gssc51.com/wxShop/order/payResult.do";
	
	/**
	 * 支付方式-JSAPI支付
	 */
	public static final String PAY_TRADE_TYPE="JSAPI"; 
	
	
	/**
	 * 微信授权回调url
	 */
	public static final String OAUTH_RETURN_URL="http://www.gssc51.com/wxShop/order/pay.do?showwxpaytitle=1";
	//OAUTH_RETURN_URL encdoe 后的路径
	private static String OAUTH_RETURN_URL_ENCODE=null;

	/**
	 * 调用微信授权的url，用来获取code 
	 */
	private static String OAUTH_URL = null;
	
	public static String getOauthUrl(){
		return OAUTH_URL;
	}
	
	/**
	 * 微信授权url，主要用来获取openid
	 */
	public static final String ACCESS_TOKEN_URL="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+PayConstant.appID+
	"&secret="+PayConstant.AppSecret+"&code=CODE&grant_type=authorization_code";
	
	
	/**
	 * 统一支付返回状态码：成功
	 */
	public static final String RETURN_CODE_SUCCESS="SUCCESS";
	
	/**
	 * 统一支付业务结果：成功
	 */
	public static final String RESULT_CODE_SUCCESS="SUCCESS";
	
	/**
	 * 微信支付 签名方式
	 */
	public static final String PAY_SIGN_TYPE="MD5";
	

	//以下是几个API的路径：
	//1）被扫支付API
	public static String PAY_API = "https://api.mch.weixin.qq.com/pay/micropay";

	//2）被扫支付查询API
	public static String PAY_QUERY_API = "https://api.mch.weixin.qq.com/pay/orderquery";

	//3）退款API
	public static String REFUND_API = "https://api.mch.weixin.qq.com/secapi/pay/refund";

	//4）退款查询API
	public static String REFUND_QUERY_API = "https://api.mch.weixin.qq.com/pay/refundquery";

	//5）撤销API
	public static String REVERSE_API = "https://api.mch.weixin.qq.com/secapi/pay/reverse";

	//6）下载对账单API
	public static String DOWNLOAD_BILL_API = "https://api.mch.weixin.qq.com/pay/downloadbill";

	//7) 统计上报API
	public static String REPORT_API = "https://api.mch.weixin.qq.com/payitil/report";

 
	static{
		try {
			OAUTH_RETURN_URL_ENCODE= java.net.URLEncoder.encode(OAUTH_RETURN_URL,"utf-8");
			OAUTH_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+
			PayConstant.appID+"&redirect_uri="+PayConstant.OAUTH_RETURN_URL_ENCODE+"&response_type=code&scope=snsapi_base&state=PARAM_STATE#wechat_redirect";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] a){
		System.out.println(OAUTH_URL);
		System.out.println(OAUTH_RETURN_URL_ENCODE);
	}
}
