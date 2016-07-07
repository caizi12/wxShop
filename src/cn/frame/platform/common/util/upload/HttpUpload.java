package cn.frame.platform.common.util.upload;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileUploadBase.InvalidContentTypeException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.frame.platform.common.util.file.FileUtil;

/**
 * HTTP方式上传，需要服务器运行了JAVA WEB容器
 * 
 */
public class HttpUpload {
	private static Log logger = LogFactory.getLog(HttpUpload.class);
	/**
	 * 读取文件的最大块大小
	 */
	private int sizeThreshold = 4096;
	/**
	 * 临时文件保存目录
	 */
	private String tempRepository = "/tmp";
	/**
	 * 文件最大大小
	 */
	private int maxSize = 10 * 1024 * 1024;// 10M
	/**
	 * 文件编码方式
	 */
	private String encoding = "UTF-8";
	/**
	 * 允许的文件类型
	 */
	private String allowFileType = ".doc|.zip|.csv|.xls|.txt|.gif|.jpg|.png|.bmp";
	/**
	 * 是否写到文件
	 */
	private boolean writeToFile = true;
	
	public HttpUpload(){
		
	}

	/**
	 * 一次性初始化所有变量
	 * 
	 * @param tempRepository
	 *            临时文件目录
	 * @param encoding
	 *            文件编码方式
	 * @param allowFileType
	 *            允许的文件类型,.doc|.zip格式，分隔符可以是数线、逗号、分号(英文)
	 * @param sizeThreshold
	 *            每次读取的块大小
	 * @param mazSize
	 *            文件最大大小
	 */
	public void init(String tempRepository, String encoding, String allowFileType, int sizeThreshold, int maxSize) {
		if (!StringUtils.isBlank(tempRepository))
			this.tempRepository = tempRepository;
		if (!StringUtils.isBlank(encoding))
			this.encoding = encoding;
		if (!StringUtils.isBlank(allowFileType))
			this.allowFileType = allowFileType;
		this.sizeThreshold = sizeThreshold;
		this.maxSize = maxSize;
	}

	public HttpUploadResult upload(HttpServletRequest request, String toPath, String fileName) throws Exception {
		if (StringUtils.isBlank(toPath) || StringUtils.isBlank(fileName))
			throw new Exception("the toPath parameter or the filename is null or blank!");
		return upload(request, toPath, new String[] { fileName });
	}

	/**
	 * 将本地文件通过HTTP上传到服务器，如果只是简单上传，可以不理会返回。
	 * 返回结果为一个对象，包括传递的参数值对，可以循环取出。还有就是如果设置不写文件时，返回的字节数组
	 * 
	 * @param request
	 *            请求对象
	 * @param toPath
	 *            上传后放置目录
	 * @return 返回上传结果
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public HttpUploadResult upload(HttpServletRequest request, String toPath, String[] fileNames) throws Exception {
		if (StringUtils.isBlank(toPath))
			throw new Exception("the toPath parameter is null or blank!");
		// 创建临时目录，如果不存在
		FileUtil.mkDir(tempRepository, true);
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			// Create a factory for disk-based file items
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(sizeThreshold);
			factory.setRepository(new File(tempRepository));

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(maxSize);
			upload.setHeaderEncoding(encoding);
			String[] splits = allowFileType.split("\\||,|;]");
			// Parse the request
			List items = upload.parseRequest(request);
			HttpUploadResult result = new HttpUploadResult();
			UploadResult uploadResult = null;
			String path = toPath;
			if (!path.endsWith(File.separator))
				path += File.separator;
			FileUtil.mkDir(path, true);
			Map formFields = new HashMap();
			Iterator iter = items.iterator();
			int i = 0;
			byte[] buf = null;
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				uploadResult = null;
				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString();
					formFields.put(name, value);
				} else {
					uploadResult = processUploadedFile(item, path, splits, fileNames, i);
					result.getFileNames().add(uploadResult.getFileName());
					buf = null;
					if (null != uploadResult.getBuf() && uploadResult.getBuf().length > 0) {
						System.arraycopy(uploadResult.getBuf(), 0, buf, 0, uploadResult.getBuf().length);
						result.getBuf().add(buf);
					}
					i++;
				}
			}
			// 这里引用了局部对象，不知道也没有问题
			result.setFormFields(formFields);
			return result;
		} else {
			logger.error("no file to upload for the request without multipart!");
			throw new Exception("no file to upload!");
		}
	}
	
	
	/**
	 * 将本地文件通过HTTP上传到服务器，如果只是简单上传，可以不理会返回。
	 * 返回结果为一个对象，包括传递的参数值对，可以循环取出。还有就是如果设置不写文件时，返回的字节数组
	 * 
	 * @param request
	 *            请求对象
	 * @param toPath
	 *            上传后放置目录
	 * @return 返回上传结果
	 * @param maxSize 文件大小
	 * @throws Exception
     *
	 *
	 */
	@SuppressWarnings("unchecked")
	public HttpUploadResult upload(HttpServletRequest request, String toPath, String fileName,int maxSize) throws Exception {
		if (StringUtils.isBlank(toPath) || StringUtils.isBlank(fileName))
			throw new Exception("the toPath parameter or the filename is null or blank!");
	String[] fileNames=	 new String[] { fileName };
		if (StringUtils.isBlank(toPath))
			throw new Exception("the toPath parameter is null or blank!");
		// 创建临时目录，如果不存在
		FileUtil.mkDir(tempRepository, true);
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			// Create a factory for disk-based file items
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(sizeThreshold);
			factory.setRepository(new File(tempRepository));
			
			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(maxSize);
			upload.setHeaderEncoding(encoding);
			String[] splits = allowFileType.split("\\||,|;]");
			// Parse the request
			List items = upload.parseRequest(request);
			HttpUploadResult result = new HttpUploadResult();
			UploadResult uploadResult = null;
			String path = toPath;
			if (!path.endsWith(File.separator))
				path += File.separator;
			FileUtil.mkDir(path, true);
			Map formFields = new HashMap();
			Iterator iter = items.iterator();
			int i = 0;
			byte[] buf = null;
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				uploadResult = null;
				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString();
					formFields.put(name, value);
				} else {
					uploadResult = processUploadedFile(item, path, splits, fileNames, i);
					result.getFileNames().add(uploadResult.getFileName());
					buf = null;
					if (null != uploadResult.getBuf() && uploadResult.getBuf().length > 0) {
						System.arraycopy(uploadResult.getBuf(), 0, buf, 0, uploadResult.getBuf().length);
						result.getBuf().add(buf);
					}
					i++;
				}
			}
			// 这里引用了局部对象，不知道也没有问题
			result.setFormFields(formFields);
			return result;
		} else {
			logger.error("no file to upload for the request without multipart!");
			throw new Exception("no file to upload!");
		}
	}

	/**
	 * 处理上传文件
	 * 
	 * @param item
	 *            文件条目
	 * @param splits
	 *            允许的文件类型
	 * @return 返回是否写字节数组
	 * @throws Exception
	 */
	private UploadResult processUploadedFile(FileItem item, String toPath, String[] splits, String[] fileNames,
			int index) throws Exception {
		UploadResult result = new UploadResult();
		byte[] buf = null;
		String fileName = null;
		if (!item.isFormField()) {

			fileName = getFileName(item.getName());
			if (StringUtils.isBlank(fileName)) {
				throw new Exception("the filename parameter is null or blank!");
			}
			fileName = fileName.toLowerCase();
			long sizeInBytes = item.getSize();
			boolean upload = false;
			if (null != splits) {
				for (int i = 0; i < splits.length; i++) {
					if (fileName.endsWith(StringUtils.trim(splits[i]))) {
						upload = true;
						break;
					}
				}
			}
			if (upload) {
				if (null != fileNames && fileNames.length > index) {
					fileName = compisteFileExt(fileName, fileNames[index]);
				}
				if (StringUtils.isBlank(fileName)) {
					throw new Exception("the assigned filename parameter is null or blank!");
				}
				//此处需要替换后缀
				FileUtil.mkDir(toPath, true);
				if (writeToFile) {
					File uploadedFile = new File(toPath + fileName);
					item.write(uploadedFile);
				} else {
					buf = new byte[(int) sizeInBytes];
					InputStream uploadedStream = null;
					try {
						uploadedStream = item.getInputStream();
						uploadedStream.read(buf, 0, (int) sizeInBytes);
					} catch (Exception e) {
						logger.error(e);
					} finally {
						if (uploadedStream != null) {
							uploadedStream.close();
						}
					}
				}
			} else {
				logger.error(item.getName() + " file can not be uploaded for forbidden, only allow fiel type "
						+ allowFileType);
				throw new Exception(item.getName()
						+ " file can not be uploaded for forbidden, only allow fiel type " + allowFileType);
			}
		}
		result.setBuf(buf);
		result.setFileName(fileName);
		return result;
	}
	
	@SuppressWarnings("static-access")
	public HttpUpload(HttpServletRequest rq) throws Exception{
		fileSizeMax = UploadFileConstant.FILESIZEMAX;
		sizeMax = UploadFileConstant.SIZEMAX;
		if(fileSizeMax < 0 ){
			throw new Exception("单个文件大小不能为负数,请修改相关常量类参数值");
		}else if(fileSizeMax  > 10 ){
			throw new Exception("单个文件大小最大值为10M,请修改相关常量类参数值");
		}
		if(sizeMax < 0 ){
			throw new Exception("多个文件大小不能为负数,请修改相关常量类参数值");
		}else if(sizeMax  > 20 ){
			throw new Exception("多个文件大小最大值为20M,请修改相关常量类参数值");
		}
		this.request = rq;
		this.fileItems = this.getFileItem(fileSizeMax, sizeMax);
	}
	
	public  static HttpServletRequest request = null;
	/**
	 * request请求数据FileItem
	 */
	private static List<FileItem> fileItems  = null;
	
	//单个文件最大值 ,单位：M  最大值规定为10M, 默认为2M
	public static int fileSizeMax;
	
	//多个文件最大值,单位：M 最大值规定为20M, 默认为5M
	public static int sizeMax;
	/**
	 * 获取解析request请求数据FileItem
	 * @param request：HttpServletRequest
	 * @param maxSize：上传文件最大值,单位：M,默认为2M
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static List<FileItem> getFileItem(int fileSizeMax,int sizeMax)throws Exception {
		try{
			// 实力化一个磁盘工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			int size = 1 * 1024 * 1024;
			factory.setSizeThreshold(size);
			// 初始化上传组件
			ServletFileUpload sfu = new ServletFileUpload(factory);
			
			// 指定单个上传文件的最大尺寸,单位:字节 1M = (1024*1024) byte
	        sfu.setFileSizeMax(fileSizeMax * 1024 * 1024);   
	        
	       //指定一次上传多个文件的总尺寸,单位:字节
	        sfu.setSizeMax(sizeMax * 1024 * 1024);    
	
			// 开始解析request请求数据
			List<FileItem> fileItems = sfu.parseRequest(request);
			
			return fileItems;
		}catch (InvalidContentTypeException e) {
			//该表单类参数值型不是multipart/form-data类参数值型
			throw new Exception("form表单类参数值型应为multipart/form-data,请设置表单enctype属性!");
		} catch (FileUploadException e) { 
			// 这个异常是文件大小超过规定大小时发生的
			throw new Exception("上传文件尺寸超过规定值");
		}
		
	}
	/**
	 * 获取上传文件输入流
	 * @param request：HttpServletRequest
	 * @param maxSize：上传文件最大值，单位：M，默认为2M 
	 * @return
	 * @throws Exception
	 */
	public static InputStream getInputStream() throws Exception {
		List<FileItem> fi  = fileItems;
		InputStream is = null;
		for (FileItem fileItem : fi) {
			try {
				//处理文件域信息
				if(!fileItem.isFormField()){
					//获取上传文件后缀
					String suffix = fileItem.getName(); //获取该上传文件硬盘绝对路径
					suffix = suffix.substring(suffix.lastIndexOf(".")+1);//得到该文件后缀
				    String[] allowedExt = UploadFileConstant.allowedExt; //上传文件规定类型数组
				    boolean exist = false;//是否存在
						for (int i = 0; i < allowedExt.length; i++) {
							if(allowedExt[i].equals(suffix)){ //如果存在
								exist  =  true;
								break;
							}
						}
						if(!exist){
							throw new Exception(); //在指定位置抛出自定义异常信息。
						}
				    //获取文件流
				    is = fileItem.getInputStream();
				    return is;
				}
			}
			catch(Exception e){
				throw new Exception("上传文件类型与规定文件类型不符合"+e.getMessage());
			}finally{
				try {
					if(is != null){
						is.close();
					}
				} catch (IOException e) {
					throw new Exception("InputStream关闭异常："+e.getMessage());
				}
			}
		}
		return null;
	}
	/**
	 * 获取表单普通字段信息
	 * @return map集合，通过key获取表单相应的值，key相当于表单的name属性值
	 * @throws Exception
	 */
	public static Map<String,String> getFormField() throws Exception{
		//允许存入null值，非线程安全
		Map<String,String> map;
		try {
			map = new HashMap<String,String>(); 
			List<FileItem> fi  = fileItems;
			if(fi != null){
				// 一共多少个表单对象
				int leng = fileItems.size();
				for (int i = 0; i < leng; i++) {
					// 从集合中获取一个文件流
					FileItem item = fileItems.get(i);
					if(item.isFormField()){
						//获取普通表单字段的名称和值
						map.put(item.getFieldName(), item.getString("utf-8"));
					}
				}
  }
		} catch (UnsupportedEncodingException e) {
			throw new Exception(e.getMessage());
		}
		return map;
	}
	/**
	 * 设置读取块大小
	 * 
	 * @param sizeThreshold
	 */
	public void setSizeThreshold(int sizeThreshold) {
		this.sizeThreshold = sizeThreshold;
	}

	/**
	 * 设置临时保存文件夹
	 * 
	 * @param tempRepository
	 */
	public void setTempRepository(String tempRepository) {
		this.tempRepository = tempRepository;
	}

	/**
	 * 设置最大大小
	 * 
	 * @param mazSize
	 */
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	/**
	 * 设置文件编码
	 * 
	 * @param encoding
	 */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	/**
	 * 设置允许的文件类型
	 * 
	 * @param allowFileType
	 */
	public void setAllowFileType(String allowFileType) {
		this.allowFileType = allowFileType;
	}

	public void setWriteToFile(boolean writeToFile) {
		this.writeToFile = writeToFile;
	}

	private String getFileName(String fileName) {
		int start = 0;
		int end = 0;
		if (fileName == null)
			return null;
		if (fileName.lastIndexOf("/") >= 0)
			start = fileName.lastIndexOf("/") + 1;
		if (fileName.lastIndexOf("\\") >= 0)
			start = fileName.lastIndexOf("\\") + 1;
		end = fileName.length();
		String value = fileName.substring(start, end);
		return value;
	}

	private String compisteFileExt(String uploadFileName, String fileName) {
		if (StringUtils.isBlank(uploadFileName) || StringUtils.isBlank(fileName)) {
			return null;
		}
		String ext = getFileExt(uploadFileName);
		if (fileName.lastIndexOf(".") >= 0 && null != ext) {
			return fileName.substring(0, fileName.lastIndexOf(".")) + "." + ext;
		} else {
			return fileName;
		}
	}

	/**
	 * 获取文件名后缀
	 * @param fileName
	 * @return
	 */
	private String getFileExt(String fileName) {
		if (fileName.lastIndexOf(".") >= 0) {
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		} else {
			return null;
		}
	}

	/**
	 * 内部类
	 * @author douxf2
	 *
	 */
	private class UploadResult {
		String fileName = null;

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public byte[] getBuf() {
			return buf;
		}

		public void setBuf(byte[] buf) {
			this.buf = buf;
		}

		private byte[] buf = null;
	}
}
