package exception;

import constants.EnumConstants.ErrorCodes;

/**
 * @author shardul
 *
 */
public class ParkException extends Exception {

	private static final long serialVersionUID = -7553240895731651278L;

	private ErrorCodes errorCode = null;

	public ParkException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public ParkException(String message) {
		super(message);
	}

	public ParkException(Throwable throwable) {
		super(throwable);
	}

	public ParkException(ErrorCodes errorCode, String message, Object[] errorParameters) {
		super(message);
		this.setErrorCode(errorCode);
	}

	public ParkException(ErrorCodes errorCode, String message, Throwable throwable) {
		super(message, throwable);
		this.setErrorCode(errorCode);
	}

	public ParkException(ErrorCodes errorCode, String message, Object[] errorParameters, Throwable throwable) {
		super(message, throwable);
		this.setErrorCode(errorCode);
	}

	public ErrorCodes getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCodes errorCode) {
		this.errorCode = errorCode;
	}

}
