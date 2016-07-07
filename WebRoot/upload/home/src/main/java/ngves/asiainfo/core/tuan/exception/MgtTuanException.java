package ngves.asiainfo.core.tuan.exception;

public class MgtTuanException extends MgtException {
	/**
	 * 团购活动异常信息类
	 * 
	 * @author liuyq7@asiainfo-linkage.com
	 */
	private static final long serialVersionUID = 7883496059567607785L;

	public MgtTuanException(String message, Throwable cause) {
		super(message, cause);
	}

	public MgtTuanException(String message) {
		super(message);
	}

	public MgtTuanException(String code, String message) {
		super(code, message);
	}

	public MgtTuanException(Throwable cause) {
		super(cause);
	}
}
