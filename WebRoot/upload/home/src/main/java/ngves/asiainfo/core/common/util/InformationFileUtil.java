package ngves.asiainfo.core.common.util;

import com.enterprisedt.util.debug.Logger;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.common.CorePropsConstant;
import ngves.asiainfo.file.FileUtil;
import ngves.asiainfo.util.PropertyReader;

public class InformationFileUtil {

	private static Logger log = Logger.getLogger(InformationFileUtil.class);

	/**
	 *	获取信息订阅模块的根据文件名得到的内容 
	 *@see getVmTptContent(String fileName, String localPath, String remotePath)
	 */
	public static String getInformationVmTptContent(String fileName) throws Exception {
		return getVmTptContent(fileName, PropertyReader.getProperty(CorePropsConstant.PORP_AI_TMP_INFORMATION_PATH),
				PropertyReader.getProperty(CorePropsConstant.PORP_AI_FTP_INFORMATION_PATH));

	}

	/**
	 * 默认写入信息订阅模块内容到文件
	 * @see	updateVmTptContent(String content, String fileName, String localPath, String remotePath)
	 * @param content
	 * @param fileName
	 * @throws Exception
	 * 
	 */
	public static void updateInformationVmTptContent(String content, String fileName) throws Exception {
		updateVmTptContent(content, fileName, PropertyReader
				.getProperty(CorePropsConstant.PORP_AI_TMP_INFORMATION_PATH), PropertyReader
				.getProperty(CorePropsConstant.PORP_AI_FTP_INFORMATION_PATH));
	}

	/**
	 * 路径最后结果必须带路径符号(/,\\) ,文件名称不能有路径符号
	 * @param fileName
	 * @param localPath 以路径符号(/,\\)结尾
	 * @param remotePath 以路径符号(/,\\)结尾
	 * @return
	 * @throws Exception
	 */
	public static String getVmTptContent(String fileName, String localPath, String remotePath) throws Exception {
		if (fileName == null) {
			throw new Exception("fileName can not be null!");
		}
		int num = AiFtpUtil.download(localPath, remotePath, fileName, null);
		if (log.isInfoEnabled()) {
			log.info("download " + num + "files by fileName : " + fileName + " from ftp");
		}		
		return FileUtil.readFile(localPath + fileName, CommnConstant.ENCODING_UTF);
	}

	/**
	 * 路径最后结果必须带路径符号(/,\\) ,文件名称不能有路径符号
	 * @param content
	 * @param fileName
	 * @param localPath 以路径符号(/,\\)结尾
	 * @param remotePath 以路径符号(/,\\)结尾
	 * @throws Exception
	 */
	public static void updateVmTptContent(String content, String fileName, String localPath, String remotePath)
			throws Exception {
		if (fileName == null) {
			throw new Exception("fileName can not be null!");
		}
		FileUtil.writeFile(content, localPath + fileName, CommnConstant.ENCODING_UTF);
		//更新FTP文件内容
		String[] fileNames = new String[] { fileName };
		AiFtpUtil.upload(localPath, fileNames, remotePath);
	}
}
