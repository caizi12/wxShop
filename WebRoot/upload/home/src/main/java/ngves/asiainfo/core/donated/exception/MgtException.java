package ngves.asiainfo.core.donated.exception;

public class MgtException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1617503421110247585L;
	/**
     * 
     */
	

	private String errorCode;

	public MgtException() {
		super();
	}

	public MgtException(String message, Throwable cause) {
		super(message, cause);
	}

	public MgtException(String message) {
		super(message);
	}

	public MgtException(String code, String message) {
		super(message);
		setErrorCode(code);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public MgtException(Throwable cause) {
		super(cause);
	}

}