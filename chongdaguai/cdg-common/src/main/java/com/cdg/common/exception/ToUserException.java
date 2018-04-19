package com.cdg.common.exception;

/**
 * 显示给用户的异常
 * 
 * @author guoyongshi
 *
 */
public final class ToUserException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String errorCode = TpErrorCodeGeneral.RESULT_CODE_ERR_MSG;
	public String errorField = null;

	public ToUserException(String message, String code, String errorField) {
		super(message);
		this.errorCode = code;
		this.errorField = errorField;
	}

	public ToUserException(String message, String errorField) {
		super(message);
		this.errorField = errorField;
	}

	public ToUserException(String message) {
		super(message);
	}

}
