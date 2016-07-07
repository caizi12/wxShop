package cn.frame.platform.common.util;

import java.util.Random;

import cn.frame.platform.common.util.date.DateUtil;

/**
 * 获取随机码
 * @author li
 *
 */
public class RandomNumUtil {
	/**
	 * 生成6位随机码
	 * @return
	 */
	public static String getSixRandomCode(){
		Random r=new Random();
		String smsCode=String.valueOf(r.nextInt(999999));
		if(smsCode.length()!=6){
			smsCode=String.valueOf(r.nextInt(99999)+100000);;
		}
		return smsCode;
	}
	
	
	/**
	 * 生成4位随机码
	 * @return
	 */
	public static String getFourRandomCode(){
		Random r=new Random();
		String smsCode=String.valueOf(r.nextInt(9999));
		if(smsCode.length()!=4){
			smsCode=String.valueOf(r.nextInt(999)+1000);;
		}
		return smsCode;
	}
	
	/**
	 * 生成3位随机码
	 * @return
	 */
	public static String getThreeRandomCode(){
		Random r=new Random();
		String smsCode=String.valueOf(r.nextInt(999));
		if(smsCode.length()!=3){
			smsCode=String.valueOf(r.nextInt(99)+100);;
		}
		return smsCode;
	}
	
	
	 /**
	  * 获取一个20位的数字
	  * 时间戳 + 三位随机码
	  * @return
	  */
	 public static String getDateRandomNum(){
		 return DateUtil.formatDateByFormat(DateUtil.FORMATYYYYMMDDHHMMSSMIS)+RandomNumUtil.getThreeRandomCode();
	 }
}
