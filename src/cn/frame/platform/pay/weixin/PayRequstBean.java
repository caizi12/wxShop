package cn.frame.platform.pay.weixin;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import cn.frame.platform.pay.weixin.util.HttpsRequest;
import cn.frame.platform.pay.weixin.util.RandomStringGenerator;
import cn.frame.platform.pay.weixin.util.Signature;
/**
 * 调用微信统一支付接口对象
 * 微信支付 V3.3.7
 * @author li
 *
 */
public class PayRequstBean {
	private String appid=PayConstant.appID;
	private String mch_id=PayConstant.mchID;
	private String device_info;
	private String nonce_str;
	private String sign;
	private String body;
	private String attach;
	private String out_trade_no;
	private String total_fee;
	private String spbill_create_ip;
	private String time_start;
	private String time_expire;
	private String goods_tag;
	private String notify_url=PayConstant.PAY_RESULT_URL;
	private String trade_type=PayConstant.PAY_TRADE_TYPE;
	private String openid;
	private String product_id;
	
	
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}
	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}
	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}
	public String getTime_start() {
		return time_start;
	}
	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}
	public String getTime_expire() {
		return time_expire;
	}
	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}
	public String getGoods_tag() {
		return goods_tag;
	}
	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}
	public String getNotify_url() {
		return notify_url;
	}
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	
	
    public Map<String,Object> toMap(){
        Map<String,Object> map = new HashMap<String, Object>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            Object obj;
            try {
                obj = field.get(this);
                if(obj!=null){
                    map.put(field.getName(), obj);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
    
    public static void main(String[] str) throws Exception{
    	PayRequstBean bean=new PayRequstBean();
    	bean.setNonce_str(RandomStringGenerator.getRandomStringByLength(20));
    	bean.setBody("净水机");
    	bean.setOut_trade_no("2015083013091000123");
    	bean.setSpbill_create_ip("10.12.3.4");
    	bean.setTotal_fee("1");
    	bean.setOpenid("oIG20t31hGL38TDmKlcmJCn7JjiU");
    	bean.setNotify_url(PayConstant.PAY_RESULT_URL);
    	String sign=Signature.getSign(bean);
    	bean.setSign(sign);
    	System.out.println(sign);
    	
    	HttpsRequest http=new HttpsRequest();
    	System.out.println(http.sendPost(PayConstant.PAY_URL, bean));
    }
	
} 
