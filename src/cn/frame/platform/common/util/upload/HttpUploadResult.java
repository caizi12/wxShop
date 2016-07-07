package cn.frame.platform.common.util.upload;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * HTTP 上传返回结果对象,包含请求的参数值对和上传文件的字节，需要设置是否写文件选项才能获取字节数组
 * 
 */
public class HttpUploadResult {
	/**
	 * 请求中的参数值对
	 */
	private Map<String, String> formFields = null;
	/**
	 * 字节数组
	 */
	private List<byte[]> buf = new ArrayList<byte[]>();

	public List<byte[]> getBuf() {
		return buf;
	}

	public void setBuf(List<byte[]> buf) {
		this.buf = buf;
	}

	public List<String> getFileNames() {
		return fileNames;
	}

	public void setFileNames(List<String> fileNames) {
		this.fileNames = fileNames;
	}

	/**
	 * 上传后文件名
	 */
	private List<String> fileNames = new ArrayList<String>();

	/**
	 * 获取上传时其他非文件字段
	 * 
	 * @return
	 */
	public Map<String, String> getFormFields() {
		return formFields;
	}

	public void setFormFields(Map<String, String> formFields) {
		this.formFields = formFields;
	}
	/**
	 * 返回上传文件流对象
	 * @return
	 */
	public InputStream getInputStream(){
		List<byte[]> bytes = this.getBuf();
		InputStream is = null;
		for (byte[] bs : bytes) {
			is = new ByteArrayInputStream(bs); 
		}
		return is;
	
	}

}
