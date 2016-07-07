package cn.frame.platform.common.util.img;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import org.apache.log4j.Logger;
import cn.frame.platform.common.util.RandomNumUtil;
import cn.frame.platform.sys.weixin.control.MsgControl;

/**
 * 图片下载保存公共类
 */
public class ImgUtil {
	private static Logger log = Logger.getLogger(MsgControl.class);

	/**
	 * 从指定的url下载图片到本地
	 * @param doloadImgUrl 图片下载的地址
	 * @param fileName 下载到本地文件名称
	 * @param fileURL 下载到本地的目录
	 * @throws IOException
	 */
	public static void downloadImgFromUrl(String downloadImgUrl,String fileName, String fileURL) throws Exception {
		BufferedInputStream in=null;
		BufferedOutputStream out=null;
		try {
			// 创建流
			in = new BufferedInputStream(new URL(downloadImgUrl).openStream());
			// 存放地址
			File img = new File(fileURL + fileName);
			// 生成图片
			out= new BufferedOutputStream(new FileOutputStream(img));
			byte[] buf = new byte[2048];
			int length = in.read(buf);
			while (length != -1) {
				out.write(buf, 0, length);
				length = in.read(buf);
			}
			
		} finally{
			if(in!=null){
				in.close();
			}
			if(out!=null){
				out.close();
			}
		}
	}
	
	/**
	 * 下载指定url的图片
	 * @param doloadImgUrl 下载文件的路径
	 * @param fileURL 下载到本地的目录
	 * @return 保存后图片的名称
	 */
	public static String downloadImgFromUrl(String downloadImgUrl, String fileURL) {
		try {
			String fileName=RandomNumUtil.getDateRandomNum()+".jpg";
			ImgUtil.downloadImgFromUrl(downloadImgUrl,fileName,fileURL);
			return fileName;
		} catch (Exception e) {
			log.error("downloadImgFromUrl IoException ",e);
			return null;
		}
	}
	
	
	public static void main(String[] a) throws IOException{
		ImgUtil.downloadImgFromUrl("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQEG8DoAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL1ZVekhNUlBsTlROTWtQSVVnV1RrAAIELfwtVgMEAAAAAA==","C:/Users/li/Desktop/");
	}
}
