package com.liftlab.contactdirectory.exception;

/**
 * @author hemanthjamili
 *
 */
public class ContactNotFoundException extends ContactServiceException {

	private static final long serialVersionUID = -2079116398444044139L;

	public ContactNotFoundException(String message) {
		super(message);
	}
}
