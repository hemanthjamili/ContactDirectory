package com.liftlab.contactdirectory.exception;
/**
 * @author hemanthjamili
 *
 */
public class ContactValidationException extends ContactServiceException {
	
	private static final long serialVersionUID = -6319937585057029221L;

	public ContactValidationException(String message) {
		super(message);
	}
}
