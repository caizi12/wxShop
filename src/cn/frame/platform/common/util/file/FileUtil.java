package cn.frame.platform.common.util.file;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 文件工具类
 * 
 */
public class FileUtil {
	private static Log log = LogFactory.getLog(FileUtil.class);

	private static final int MAX_BYTE_LENGTH = 4096;

	private FileUtil() {
		// 禁止初始化
	}

	/**
	 
   

	/**
	 * 删除文件或目录
	 * 
	 * @param fileName
	 *            要删除的文件或目录
	 */
	public static void delete(String fileName) throws IOException {
		File f = new File(fileName);
		if (f.isFile()) {
			deleteFile(fileName);
		} else {
			deleteDir(f);
		}
	}

	/**
	 * 创建单个文件夹。
	 * 
	 * @param dir
	 *            文件目录名称
	 * @param ignoreIfExitst
	 *            true 表示如果文件夹存在就不再创建了。false是重新创建。
	 * @throws IOException
	 */
	public static void mkDir(String dir, boolean ignoreIfExitst)
			throws IOException {
		File file = new File(dir);

		if (ignoreIfExitst && file.exists()) {
			return;
		}
		if ((file.mkdir() == false) && file.mkdirs() == false) {
			log.error("Cannot create the directory = " + dir);
			throw new IOException("Cannot create the directory = " + dir);
		}
	}

	/**
	 * 删除一个文件。
	 * 
	 * @param filename
	 *            要删除的文件名
	 * @throws IOException
	 */
	public static void deleteFile(String filename) throws IOException {
		File file = new File(filename);
		if (file.isDirectory()) {
			log.error("IOException -> " + filename
					+ "BadInputException: not a file.");
			throw new IOException("IOException -> " + filename
					+ "BadInputException: not a file.");
		}
		if (file.exists() == false) {
			log.error("IOException " + filename
					+ "BadInputException: file is not exist.");
			throw new IOException("IOException " + filename
					+ "BadInputException: file is not exist.");
		}
		if (file.delete() == false) {
			log.error("Cannot delete file. filename = " + filename);
			throw new IOException("Cannot delete file. filename = " + filename);
		}
	}

	/**
	 * 删除文件夹及其下面的子文件夹
	 * 
	 * @param dir
	 *            文件夹目录
	 * @throws IOException
	 */
	public static void deleteDir(File dir) throws IOException {
		if (dir.isFile())

			throw new IOException(
					"IOException -> BadInputException: not a directory.");
		File[] files = dir.listFiles();
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				File file = files[i];
				if (file.isFile()) {
					file.delete();
				} else {
					deleteDir(file);
				}
			}
		}// if
		dir.delete();
	}

	/**
	 * 列出指定文件目录下面的文件信息。
	 * 
	 * @param dir
	 * @return
	 * @throws IOException
	 */
	public static List<String> getFiles(File dir) throws IOException {
		List<String> l = new ArrayList<String>();
		if (dir.isFile()) {
			l.add(dir.getAbsolutePath() + File.separator + dir.getName());
			return l;
		}
		if (!dir.exists()) {
			throw new IOException(" don't exist ");
		}

		File[] files = dir.listFiles();

		int len = 0;
		if (files != null) {
			len = files.length;
		}
		for (int i = 0; i < len; i++) {
			// String temp = files[i].getAbsolutePath();
			String temp = files[i].getName();
			l.add(temp);
		}
		return l;
	}

	/**
	 * 获取到目录下面文件的大小。包含了子目录。
	 * 
	 * @param dir
	 * @return
	 * @throws IOException
	 */
	public static long getDirLength(File dir) throws IOException {
		if (dir.isFile()) {
			log.error("BadInputException: " + dir + " not a directory.");
			throw new IOException("BadInputException: " + dir
					+ " not a directory.");
		}
		long size = 0;
		File[] files = dir.listFiles();
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				File file = files[i];
				// file.getName();
				// System.out.println(file.getName());
				long length = 0;
				if (file.isFile()) {
					length = file.length();
				} else {
					length = getDirLength(file);
				}
				size += length;
			}// for
		}// if
		return size;
	}

	/**
	 * 将文件清空。
	 * 
	 * @param srcFilename
	 *            要清空的文件名称
	 * @throws IOException
	 */
	public static void emptyFile(String srcFilename) throws IOException {
		File srcFile = new File(srcFilename);
		if (!srcFile.exists()) {
			log.error("Cannot find the file: " + srcFile.getAbsolutePath());
			throw new FileNotFoundException("Cannot find the file: "
					+ srcFile.getAbsolutePath());
		}
		if (!srcFile.canWrite()) {
			log.error("Cannot write the file: " + srcFile.getAbsolutePath());
			throw new IOException("Cannot write the file: "
					+ srcFile.getAbsolutePath());
		}

		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(srcFilename);
		} catch (IOException e) {
			throw e;
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}

	/**
	 * Write content to a fileName with the destEncoding 写文件。如果此文件不存在就创建一个。
	 * 
	 * @param content
	 *            要写的内容 String
	 * @param fileName
	 *            文件名 String
	 * @param destEncoding
	 *            编码类型 String
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void writeFile(String content, String fileName,
			String destEncoding) throws IOException {
		File file = null;
		file = new File(fileName);
		if (!file.exists()) {
			if (file.createNewFile() == false) {
				throw new IOException("create file '" + fileName + "' failure.");
			}
		}
		if (file.isFile() == false) {
			throw new IOException("'" + fileName + "' is not a file.");
		}
		if (file.canWrite() == false) {
			throw new IOException("'" + fileName + "' is a read-only file.");
		}
		BufferedWriter out = null;
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			out = new BufferedWriter(new OutputStreamWriter(fos, destEncoding));
			out.write(content);
			out.flush();
		} catch (FileNotFoundException fe) {
			log.error("Error", fe);
			throw fe;
		} catch (IOException e) {
			log.error("Error", e);
			throw e;
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException ex) {
			}
		}
	}
	/**
	 * 读取文件的内容，并将文件内容以字符串的形式返回。
	 * 
	 * @param fileName
	 *            文件名
	 * @param srcEncoding
	 *            编码格式
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String readFile(String fileName, String srcEncoding)
			throws IOException {

		File file = null;
		try {
			file = new File(fileName);
			if (file.isFile() == false) {
				throw new IOException("'" + fileName + "' is not a file.");
			}
		} finally {
			// we dont have to close File here
		}
		BufferedReader reader = null;
		try {
			StringBuffer result = new StringBuffer(1024);
			FileInputStream fis = new FileInputStream(fileName);
			reader = new BufferedReader(new InputStreamReader(fis, srcEncoding));

			char[] block = new char[512];
			while (true) {
				int readLength = reader.read(block);
				if (readLength == -1)
					break;// end of file
				result.append(block, 0, readLength);
			}
			return result.toString();
		} catch (FileNotFoundException fe) {
			log.error("Error", fe);
			throw fe;
		} catch (IOException e) {
			log.error("Error", e);
			throw e;
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException ex) {
			}
		}
	}
	 

	/**
	 * 单个文件拷贝。
	 * 
	 * @param srcFilename
	 *            原目录名称
	 * @param destFilename
	 *            目标目录名称
	 * @param overwrite
	 *            是否覆盖
	 * @throws IOException
	 */
	public static void copyFile(String srcFilename, String destFilename,
			boolean overwrite) throws IOException {

		File srcFile = new File(srcFilename);
		// 首先判断源文件是否存在
		if (!srcFile.exists()) {
			log.error("Cannot find the source file: "
					+ srcFile.getAbsolutePath());
			throw new FileNotFoundException("Cannot find the source file: "
					+ srcFile.getAbsolutePath());
		}
		// 判断源文件是否可读
		if (!srcFile.canRead()) {
			log.error("Cannot read the source file: "
					+ srcFile.getAbsolutePath());
			throw new IOException("Cannot read the source file: "
					+ srcFile.getAbsolutePath());
		}

		File destFile = new File(destFilename);

		if (overwrite == false) {
			// 目标文件存在就不覆盖
			if (destFile.exists())
				return;
		} else {
			// 如果要覆盖已经存在的目标文件，首先判断是否目标文件可写。
			if (destFile.exists()) {
				if (!destFile.canWrite()) {
					log.error("Cannot write the destination file: "
							+ destFile.getAbsolutePath());
					throw new IOException("Cannot write the destination file: "
							+ destFile.getAbsolutePath());
				}
			} else {
				// 不存在就创建一个新的空文件。
				if (!destFile.createNewFile()) {
					log.error("Cannot write the destination file: "
							+ destFile.getAbsolutePath());
					throw new IOException("Cannot write the destination file: "
							+ destFile.getAbsolutePath());
				}
			}
		}

		BufferedInputStream inputStream = null;
		BufferedOutputStream outputStream = null;
		byte[] block = new byte[MAX_BYTE_LENGTH];
		try {
			inputStream = new BufferedInputStream(new FileInputStream(srcFile));
			outputStream = new BufferedOutputStream(new FileOutputStream(
					destFile));
			while (true) {
				int readLength = inputStream.read(block);
				if (readLength == -1)
					break;// end of file
				outputStream.write(block, 0, readLength);
			}
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException ex) {
					// just ignore
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException ex) {
					// just ignore
				}
			}
		}
	}

	/**
	 * 单个文件拷贝
	 * 
	 * @param srcFile
	 *            源文件
	 * @param destFile
	 *            目标文件
	 * @param overwrite
	 *            是否覆盖目的文件
	 * @throws IOException
	 */
	public static void copyFile(File srcFile, File destFile, boolean overwrite)
			throws IOException {

		// 首先判断源文件是否存在
		if (!srcFile.exists()) {
			log.error("Cannot find the source file: "
					+ srcFile.getAbsolutePath());
			throw new FileNotFoundException("Cannot find the source file: "
					+ srcFile.getAbsolutePath());
		}
		// 判断源文件是否可读
		if (!srcFile.canRead()) {
			log.error("Cannot read the source file: "
					+ srcFile.getAbsolutePath());
			throw new IOException("Cannot read the source file: "
					+ srcFile.getAbsolutePath());
		}

		if (overwrite == false) {
			// 目标文件存在就不覆盖
			if (destFile.exists())
				return;
		} else {
			// 如果要覆盖已经存在的目标文件，首先判断是否目标文件可写。
			if (destFile.exists()) {
				if (!destFile.canWrite()) {
					log.error("Cannot write the destination file: "
							+ destFile.getAbsolutePath());
					throw new IOException("Cannot write the destination file: "
							+ destFile.getAbsolutePath());
				}
			} else {
				// 不存在就创建一个新的空文件。
				if (!destFile.createNewFile()) {
					log.error("Cannot write the destination file: "
							+ destFile.getAbsolutePath());
					throw new IOException("Cannot write the destination file: "
							+ destFile.getAbsolutePath());
				}
			}
		}

		BufferedInputStream inputStream = null;
		BufferedOutputStream outputStream = null;
		byte[] block = new byte[MAX_BYTE_LENGTH];
		try {
			inputStream = new BufferedInputStream(new FileInputStream(srcFile));
			outputStream = new BufferedOutputStream(new FileOutputStream(
					destFile));
			while (true) {
				int readLength = inputStream.read(block);
				if (readLength == -1)
					break;// end of file
				outputStream.write(block, 0, readLength);
			}
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException ex) {
					// just ignore
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException ex) {
					// just ignore
				}
			}
		}
	}

	/**
	 * 拷贝文件，从源文件夹拷贝文件到目的文件夹。 <br>
	 * 参数源文件夹和目的文件夹，最后都不要带文件路径符号，例如：c:/aa正确，c:/aa/错误。
	 * 
	 * @param srcDirName
	 *            源文件夹名称 ,例如：c:/test/aa 或者c:\\test\\aa
	 * @param destDirName
	 *            目的文件夹名称,例如：c:/test/aa 或者c:\\test\\aa
	 * @param overwrite
	 *            是否覆盖目的文件夹下面的文件。
	 * @throws IOException
	 */
	public static void copyFiles(String srcDirName, String destDirName,
			boolean overwrite) throws IOException {
		File srcDir = new File(srcDirName);// 声明源文件夹
		// 首先判断源文件夹是否存在
		if (!srcDir.exists()) {
			log.error("Cannot find the source directory: "
					+ srcDir.getAbsolutePath());
			throw new FileNotFoundException(
					"Cannot find the source directory: "
							+ srcDir.getAbsolutePath());
		}

		File destDir = new File(destDirName);
		if (overwrite == false) {
			if (destDir.exists()) {
				// do nothing
			} else {
				if (destDir.mkdirs() == false) {
					log.error("Cannot create the destination directories = "
							+ destDir);
					throw new IOException(
							"Cannot create the destination directories = "
									+ destDir);
				}
			}
		} else {
			// 覆盖存在的目的文件夹
			if (destDir.exists()) {
				// do nothing
			} else {
				// create a new directory
				if (destDir.mkdirs() == false) {
					log.error("Cannot create the destination directories = "
							+ destDir);
					throw new IOException(
							"Cannot create the destination directories = "
									+ destDir);
				}
			}
		}

		// 循环查找源文件夹目录下面的文件（屏蔽子文件夹），然后将其拷贝到指定的目的文件夹下面。
		File[] srcFiles = srcDir.listFiles();
		if (srcFiles == null || srcFiles.length < 1) {
			// throw new IOException ("Cannot find any file from source
			// directory!!!");
			return;// do nothing
		}

		// 开始复制文件
		int SRCLEN = srcFiles.length;

		for (int i = 0; i < SRCLEN; i++) {
			// File tempSrcFile = srcFiles[i];

			File destFile = new File(destDirName + File.separator
					+ srcFiles[i].getName());
			// 注意构造文件对象时候，文件名字符串中不能包含文件路径分隔符";".
			// log.debug(destFile);
			if (srcFiles[i].isFile()) {
				copyFile(srcFiles[i], destFile, overwrite);
			} else {
				// 在这里进行递归调用，就可以实现子文件夹的拷贝
				copyFiles(srcFiles[i].getAbsolutePath(), destDirName
						+ File.separator + srcFiles[i].getName(), overwrite);
			}
		}
	}
	/**
	 * 写入文件 用于写入字符流。要写入原始字节流，请考虑使用 FileOutputStream 
	 * 使用缓冲，高效的做法
	 * 先将数据写入缓冲，在通过flush()让缓冲区内容写入文件，高效做法
	 * @param fileName 文件名称
	 * @param datas 待写入数据集
	 * @author wenglin@asiainfo-linkage.com 
	 */
	public static void writeFile(String fileName, List<String> datas) throws IOException{
		FileWriter writer = null;
		BufferedWriter bw = null;
		try {
			// 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
			if(fileName == null){
				throw new IOException("The file path is empty:"+fileName);
			}
			writer = new FileWriter(fileName, true);
			bw = new BufferedWriter(writer);
			if (null != datas) {
				for (String content : datas) {
					bw.write(content);
					bw.newLine();
				}
				bw.flush(); //让缓冲区内容写入文件
			}
		} catch (IOException e) {
			 log.error("An error has occurred writing files,Method names:writeFile"+e.getMessage());
			 throw new IOException("An error has occurred writing files, Method names:writeFile"+e.getMessage());
			 
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
				if (bw != null) {
					bw.close();
				}
			} catch (IOException ex) {
				log.error("Close the object appear a mistake,Method names:writeFile()"+ex.getMessage());
				 throw new IOException("Close the object appear a mistake,Method names:writeFile()"+ex.getMessage());
			}
		}
	}
	/**
	 * 用于读取字符流。要读取原始字节流，请考虑使用 FileInputStream 使用缓冲，高效的做法
	 * @param fileName 文件名称
	 * @return
	 * @author wenglin@asiainfo-linkage.com 
	 */
	public static List<String> readFile(String fileName) throws IOException{
		FileReader fr = null;
		List<String> datas = new ArrayList<String>();
		try {
			// 创建FileReader对象，用来读取字符流
			fr = new FileReader(fileName);
			// 缓冲指定文件的输入
			BufferedReader br = new BufferedReader(fr);

			// 定义一个String类型的变量,用来每次读取一行
			String myreadline;
			while (br.ready()) {
				// 读取一行
				myreadline = br.readLine();
				datas.add(myreadline);
			}
			return datas;
		} catch (FileNotFoundException e) {
			log.error(fileName+"not found"+e.getMessage());
			throw new FileNotFoundException(fileName+"not found");
		} catch (IOException e) {
			log.error("Read the file there is an error:"+fileName+e.getMessage());
			throw new IOException("Read the file there is an error:"+fileName+e.getMessage());
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (IOException ex) {
				log.error("Close the object appear a mistake,Method names:writeFile()"+ex.getMessage());
				 throw new IOException("Close the object appear a mistake,Method names:writeFile()"+ex.getMessage());
			}
		}
	}
	
	/**
	 * 修改文件名称
	 * @param fileName
	 * @throws IOException
	 */
	public static void updateFileName(String fileName) throws IOException{
		File file = new File(fileName);
		// 首先判断源文件是否存在
		if (!file.exists()) {
			log.error("Cannot find the source file: " + file.getAbsolutePath());
			throw new FileNotFoundException("Cannot find the source file: "
					+ file.getAbsolutePath());
		}
		log.info("update befroe file name:"+file.getName());
		String rootPath = file.getParent();
		String newFileName = rootPath + File.separator +fileName.substring(fileName.lastIndexOf("/")+1)+ "_read";
		File newFile = new File(newFileName);
		log.info("update after file name:" + newFile.getName());
		if (file.renameTo(newFile)) {
			log.info("update file name success");
		} else {
			log.info("update file name error");
		}
		
	}
	
	public static String getImgPath(String pathName) throws Exception {
		String imgPath ="";// PropertyReader.getProperty(pathName);
		if (imgPath.lastIndexOf("/") < 0 && imgPath.lastIndexOf("\\") < 0)
			imgPath += File.separator;
		return imgPath;

	}
	
	public static String addFileSeparator(String filePath) throws Exception {
		String retFilePath = filePath;
		if (!(retFilePath.endsWith("/") || retFilePath.endsWith("\\")))
			retFilePath = retFilePath + "/";
		return retFilePath;
	}
	/*
	 * 字节数组写入文件
	 */
	public static void writeByteArrayToFile(byte[] bylist ,File file) throws Exception{
		FileOutputStream filePath = new FileOutputStream(file);
		BufferedInputStream bis = new BufferedInputStream(new ByteArrayInputStream(bylist));
		int b;
		while ((b = bis.read()) != -1) {
			filePath.write(b);
		}
	}
	public static void main(String[] args) {
		try {
		
			//第一步：将已读取文件移至新文件夹
			FileUtil.copyFile("E:/price_change/price_change_20130426.log", "E:/price_old_file/price_change_20130426.log", true);
		    
			//第二步：将当前读取文件名称修改后缀：xxx_read
			FileUtil.updateFileName("E:/price_change/price_change_20130426.log");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
