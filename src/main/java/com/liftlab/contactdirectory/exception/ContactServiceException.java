package com.liftlab.contactdirectory.exception;
/**
 * @author hemanthjamili
 *
 */
public class ContactServiceException extends Exception {
	
	private static final long serialVersionUID = -1239962265310650117L;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public ContactServiceException(String message) {
		super();
		this.message = message;
	}
}
