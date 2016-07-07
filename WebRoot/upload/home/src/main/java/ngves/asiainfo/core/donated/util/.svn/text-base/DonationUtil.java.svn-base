package ngves.asiainfo.core.donated.util;

import java.io.File;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import ngves.asiainfo.core.donated.DonatedConstant;

public class DonationUtil {
	
	/**
	 * @purpose :获得图片根目录路径的地址
	 * @return
	 * 路径地址，例如：/pic/donation/
	 */
	public static String getImgBasePath(){
		String imgPath = DonatedConstant.DONATED_PORTAL_URL;
		if (imgPath.lastIndexOf("/") < 0 && imgPath.lastIndexOf("\\") < 0)
			imgPath += File.separator;
		String retFilePath = imgPath;
		if (!(retFilePath.endsWith("/") || retFilePath.endsWith("\\")))
			retFilePath = retFilePath + "/";
		retFilePath = retFilePath.replace("\\", "/");
		//log.info(retFilePath);
		return retFilePath;
	}
 
	/**
	 * 将Timestamp 时间转换成为字符串
	 * 例如：2011-8-31 12:51:36 转换成为20110831125136
	 * @param time
	 * @return
	 */
	public static String convertTimestampToStr(Timestamp time){
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		return df.format(time);
	}
}
