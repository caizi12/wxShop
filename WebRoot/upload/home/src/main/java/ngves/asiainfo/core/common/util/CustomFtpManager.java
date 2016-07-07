/**
 * Copyright (c) 2011 asiainfo-linkage.com
 */
package ngves.asiainfo.core.common.util;

import ngves.asiainfo.core.common.CorePropsConstant;
import ngves.asiainfo.ftp.FtpUtil;
import ngves.asiainfo.util.PropertyReader;

/**
 * 一级枢纽的ftp操作类
 * @author wzg
 *
 */
public class CustomFtpManager {
	
	private static FtpUtil CUSTOM_FTP_MANAGER = null;
	
	private static final String CUSTOM_FTP_OUTROOT_PATH = PropertyReader.getProperty(CorePropsConstant.PROP_CUSTOM_FILES_FTP_OUTGOING);
	
	private static final String CUSTOM_FTP_INROOT_PATH = PropertyReader.getProperty(CorePropsConstant.PROP_CUSTOM_FILES_FTP_INGOING);
	
	static {
		CUSTOM_FTP_MANAGER = new FtpUtil();
        Object obj = PropertyReader.getProperty(CorePropsConstant.PROP_CUSTOM_FILES_FTP_HOST);
        if (null != obj)
        	CUSTOM_FTP_MANAGER.setFtpHost(obj.toString());
        obj = PropertyReader.getProperty(CorePropsConstant.PROP_CUSTOM_FILES_FTP_USER);
        if (null != obj)
        	CUSTOM_FTP_MANAGER.setFtpUser(obj.toString());
        obj = PropertyReader.getProperty(CorePropsConstant.PROP_CUSTOM_FILES_FTP_USER_PASSWD);
        if (null != obj)
        	CUSTOM_FTP_MANAGER.setFtpPasswd(obj.toString());
        obj = PropertyReader.getProperty(CorePropsConstant.PROP_CUSTOM_FILES_FTP_RETRY_COUNT);
        if (null != obj)
        	CUSTOM_FTP_MANAGER.setFtpRetryCount(Integer.parseInt(obj.toString()));
	}
	
	private CustomFtpManager() {
		 
	}
	
	/**
	 * 从一级枢纽下载文件到临时目录
	 * @param fileName   要下载的文件名称
	 * @param tmpFilePath  临时目录
	 * @return
	 * @throws Exception
	 */
	public static int loadCustomFileToTmp(String fileName,String tmpFilePath) throws Exception {
		return CUSTOM_FTP_MANAGER.download(tmpFilePath, CUSTOM_FTP_OUTROOT_PATH, fileName, null);
	}
	
	 /**
     * 上传文件到一级BOSS的FTP服务器，这里只返回成功上传的文件数
     * @param localPath
     * @param localFileNames
     * @param remotePath
     * @return
     * @throws Exception
     */
    public static int upload(String localPath, String[] localFileNames) throws Exception {
        return CUSTOM_FTP_MANAGER.upload(localPath, localFileNames, CUSTOM_FTP_INROOT_PATH);
    }
}
