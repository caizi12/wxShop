/**
 * 
 */
package ngves.asiainfo.core.ware.exception;

import ngves.asiainfo.core.tuan.exception.MgtException;

/**
 * @author asiainfo-linkage
 *
 */
public class WarePermissionHPInterException extends MgtException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WarePermissionHPInterException(String message, Throwable cause) {
		super(message, cause);
	}

	public WarePermissionHPInterException(String message) {
		super(message);
	}

	public WarePermissionHPInterException(String code, String message) {
		super(code, message);
	}

	public WarePermissionHPInterException(Throwable cause) {
		super(cause);
	}
}
