package com.bankofben.bankapplication;

public class BlankFieldException extends Exception {

	/**
	 * Blank field exception is thrown when information that is required is not supplied.
	 */
	private static final long serialVersionUID = -5905724057764255585L;
	
	public BlankFieldException() {
		super();
	}

	public BlankFieldException(String message) {
		super(message);
	}

}