package com.liftlab.contactdirectory.constants;

/**
 * @author hemanthjamili
 *
 */
public interface Constants {

	String NO_CONTENT = "No Content";
	String SUCCESS = "Success";

	String CREATE = "create";
	String UPDATE = "update";

	String NAME_VALIDATION_PATTERN = "^[A-Za-z]+(?:[\\\\s][A-Za-z]+)?$";
	String PHONENUMBER_VALIDATION_PATTERN = "[0-9]";
//	String EMAIL_VALIDATION_PATTERN = "^[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^-]+(?:\\\\.[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\\\.[a-zA-Z0-9-]+)*$";
	String EMAIL_VALIDATION_PATTERN = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
}
