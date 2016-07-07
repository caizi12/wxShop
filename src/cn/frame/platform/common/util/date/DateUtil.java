package cn.frame.platform.common.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 日期格式化、日期字符串转为日期工具类
 * 
 * @author li
 *
 */
public class DateUtil {
       

   public static final String FORMAT_YYYYMMDDHHMMSS="yyyy-MM-dd HH:mm:ss";
   public static final String FORMAT_YYYYMMDD="yyyy-MM-dd";
   public static final String FORMAT_YYYYMMDDHHMMSS_MIS="yyyy-MM-dd HH:mm:ss:SSS";
   public static final String FORMATYYYYMMDDHHMMSSMIS="yyyyMMddHHmmssSSS";
   
   /**
    * 格式化日期，把日期转为字符串
    * 
    * @param date 日期值 </p>
    * @param format 日期格式， 例:yyyy-MM-dd、yyyy-MM-dd HH:mm:ss等
    * @return
    */
   public static String formatDate(Date date,String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

   /**
    * 格式化日期
    * 
    * @param date
    * @return 返回格式为yyyy-MM-dd的日期字符串
    */
   public static String formatDate(Date date) {
        return formatDate(date,FORMAT_YYYYMMDD);
    }

	/**
	 * 格式化日期 
	 * 
	 * @param date
	 * @return 返回格式为yyyy-MM-dd HH:mm:ss的日期字符串
	 */
	public static String formatDateForTime(Date date) {
		return formatDate(date,FORMAT_YYYYMMDDHHMMSS);
	}    

	/**
	 * 格式化日期 
	 * 
	 * @param date
	 * @return 返回格式为yyyy-MM-dd HH:mm:ss:SSS的日期字符串
	 */
	public static String formatDateForTimestamp(Date date) {
		return formatDate(date,FORMAT_YYYYMMDDHHMMSS_MIS);
	}  
	
	/**
	 * 格式化日期 
	 * 
	 * @param date
	 * @return 返回格式为yyyy-MM-dd HH:mm:ss:SSS的日期字符串
	 */
	public static String formatDateByFormat(String format) {
		return formatDate(new Date(),format);
	}  
	
    /**
     * 根据日期字符格式自动转换为日期类型
     * 
     * @param dateStr 
     *    值应为以下几种日期格式：2013-10-10、2013-10-10 10:30:40、2013-10-10 10:30:40:200
     * @return
     * @throws ParseException
     */
    public static Date parseDateStrToDate(String dateStr) throws ParseException{
	  if (dateStr.indexOf(":") == -1 && dateStr.length() == 10) {  
          return  parseStrToDate(dateStr);
       }else if (dateStr.indexOf(":") > 0 && dateStr.length() == 19) {  
       	 return  parseStrToTime(dateStr);  
       }else if (dateStr.indexOf(":") > 0 && dateStr.length() == 23) {  
       	 return  parseStrToTimestamp(dateStr);  
       }
	  return null;
    }
    
    /**
    * 把格式yyyy-MM-dd日期字符串转为日期类型
    * 
    * @param dateStr 值应为2013-10-10格式的日期字符串
    * @return
    */
    public static Date parseStrToDate(String dateStr) throws ParseException{
		return parseStrToDate(dateStr,FORMAT_YYYYMMDD);
    }
    
    /**
     * 把格式yyyy-MM-dd HH:mm:ss日期字符串转为日期类型
     * 
     * @param dateStr 值为2013-10-10 12:10:10格式的日期字符串
     * @return
     * @throws ParseException
     */
    public static Date parseStrToTime(String dateStr) throws ParseException{
    	return parseStrToDate(dateStr,FORMAT_YYYYMMDDHHMMSS);
    }

    /**
     * 把格式yyyy-MM-dd HH:mm:ss:SSS日期字符串转为日期类型
     * 
     * @param dateStr 值为2013-10-10 12:10:10:100格式的日期字符串
     * @return
     * @throws ParseException
     */
    public static Date parseStrToTimestamp(String dateStr) throws ParseException {
    	return parseStrToDate(dateStr,FORMAT_YYYYMMDDHHMMSS_MIS);
    }
    
    /**
	 * 日期字符转换为日期类型
	 *   
	 * @param dateStr 例：2013-10-30,2013-10-30 12:10:20等</br>
	 * @param format  例：yyyy-MM-dd,yyyy-MM-dd HH:mm:ss等
	 * 
	 * @return java.util.Date
	 * @throws ParseException
	 */
    public static Date parseStrToDate(String dateStr,String format) throws ParseException{
	  try {
        	SimpleDateFormat df = new SimpleDateFormat(format);
			return df.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new ParseException("Can not parse "+dateStr+" to date ", e.getErrorOffset());
		}
    }
    
	    
    public static void main(String[] a) throws ParseException{
    	System.out.println(DateUtil.formatDateByFormat(DateUtil.FORMATYYYYMMDDHHMMSSMIS));
    	System.out.println(formatDateForTime(parseStrToTime("2013-12-01 12:10:01")));
    	System.out.println(formatDateForTime(parseStrToTimestamp("2013-12-01 12:10:01:400")));
    }
	    
}
