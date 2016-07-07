package cn.frame.platform.common.util;

import org.apache.commons.lang.StringUtils;


public class MD5Encoder {

	/**
	 * @author liull
	 * 
	 * @param str 需要转为md5的字符串
	 * @return String md5加密后的字符
	 */
	public static String getMD5(String str) {
		if(StringUtils.isBlank(str))return "";
		
		byte[] source = str.getBytes();
		String s = null;
		char hexDigits[] = { // 用来将字节转换成 16 进制表示的字符
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			md.update(source);
			// MD5 的计算结果是一个 128 位的长整数， 用字节表示就是 16 个字节
			byte tmp[] = md.digest(); 
			// 每个字节用 16 进制表示的话，使用两个字符，所以表示成 16 进制需要 32 个字符
			char str1[] = new char[16 * 2]; 
			int k = 0; // 表示转换结果中对应的字符位置
			
			 // 从第一个字节开始，对 MD5 的每一个字节转换成 16 进制字符的转换
			for (int i = 0; i < 16; i++) {
				byte byte0 = tmp[i]; // 取第 i 个字节
				
				 // 取字节中高 4 位的数字转换, >>> 为逻辑右移，将符号位一起右移
				str1[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str1[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
			}
			s = new String(str1); // 换后的结果转换为字符串

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public static void main(String xu[]) { 
		//计算"1234"的MD5代码应为：81dc9bdb52d04dc20036dbd8313ed055
		System.out.println(MD5Encoder.getMD5("12345656"));
	 
		System.out.print(MD5Encoder.getMD5("appid=wxdd01fa25bdf452da&body=净水机&mch_id=1260378401&nonce_str=ohwlasl0niol5jtry6af&notify_url=http://www.gssc51.com:8080/wxShop/pay/result.do&openid=oIG20t31hGL38TDmKlcmJCn7JjiU&out_trade_no=2015083013091000123&spbill_create_ip=10.12.3.4&total_fee=1&trade_type=JSAPI&key=liuliliang2015083011181300000000"));
		
	}
}