package cn.frame.platform.common.util.upload;


/**
 * 上传文件相关参数常量类
 * @date 2011-07-14
 *
 */
public class UploadFileConstant {
	
	/**
	 * 单个文件最大值 ,单位：M  最大值规定为10M, 默认为2M
	 */
	public static final  int FILESIZEMAX = 2;
	
	/**
	 * 多个文件最大值,单位：M 最大值规定为20M, 默认为5M
	 */
	public static final  int SIZEMAX = 5;
	/**
	 * 上传文件规定类型
	 */
	public static final String[] allowedExt = new String[]{"xls"};
	//"jpg","jpeg","gif","txt","doc","mp3","wma","m4a","rar","zip"
	/**
	 * 拼接分割符号
	 */
	public static final  String  DECOLLATOR= ":";
}
