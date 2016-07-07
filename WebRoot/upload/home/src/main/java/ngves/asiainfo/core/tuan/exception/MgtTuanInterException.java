package ngves.asiainfo.core.tuan.exception;

public class MgtTuanInterException extends MgtException {

	/**
	 * 团购异常类，与HP同步的接口出现异常。
	 */
	private static final long serialVersionUID = 1L;
	public MgtTuanInterException(String message, Throwable cause) {
		super(message, cause);
	}

	public MgtTuanInterException(String message) {
		super(message);
	}

	public MgtTuanInterException(String code, String message) {
		super(code, message);
	}

	public MgtTuanInterException(Throwable cause) {
		super(cause);
	}
}
