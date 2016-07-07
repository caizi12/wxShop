package ngves.asiainfo.core.common.util;

import ngves.asiainfo.core.common.CorePropsConstant;
import ngves.asiainfo.ftp.FtpUtil;
import ngves.asiainfo.util.PropertyReader;

public class AiFtpUtil {
    public static FtpUtil getIntance() {
        FtpUtil ftpUtil = new FtpUtil();
        Object obj = PropertyReader.getProperty(CorePropsConstant.PROP_AI_FILES_FTP_HOST);
        if (null != obj)
            ftpUtil.setFtpHost(obj.toString());
        obj = PropertyReader.getProperty(CorePropsConstant.PROP_AI_FILES_FTP_USER);
        if (null != obj)
            ftpUtil.setFtpUser(obj.toString());
        obj = PropertyReader.getProperty(CorePropsConstant.PROP_AI_FILES_FTP_USER_PASSWD);
        if (null != obj)
            ftpUtil.setFtpPasswd(obj.toString());
        obj = PropertyReader.getProperty(CorePropsConstant.PROP_AI_FILES_FTP_RETRY_COUNT);
        if (null != obj)
            ftpUtil.setFtpRetryCount(Integer.parseInt(obj.toString()));
        return ftpUtil;
    }

    /**
	 * 按照一定模式下载匹配的文件,文件匹配原则是：第一个是文件名含有某个子串，第二个为文件以什么结尾，两个匹配原则为"或"关系。当参数为空时，不参与匹配。
	 * 
	 * @param localPath
	 *            需要保存文件的本地路径
	 * @param remotePath
	 *            要下载的FTP路径
	 * @param match
	 *            要匹配的文件名
	 * @param endStr
	 *            要匹配的文件尾
	 * @return 成功下载的文件数量
	 * @throws Exception
	 */
    public static int download(String localPath, String remotePath, String match, String endStr) throws Exception {
        return getIntance().download(localPath, remotePath, match, endStr);
    }

    /**
     * 上传文件到FTP服务器，这里只返回成功上传的文件数
     * @param localPath
     * @param localFileNames
     * @param remotePath
     * @return
     * @throws Exception
     */
    public static int upload(String localPath, String[] localFileNames, String remotePath) throws Exception {
        return getIntance().upload(localPath, localFileNames, remotePath);
    }
}
