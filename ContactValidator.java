package com.liftlab.contactdirectory.validator;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.liftlab.contactdirectory.exception.ContactValidationException;
import com.liftlab.contactdirectory.model.Contact;

import static com.liftlab.contactdirectory.constants.Constants.*;
import static com.liftlab.contactdirectory.constants.ErrorCodes.*;

/**
 * @author hemanthjamili
 *
 */
@Component
public class ContactValidator {

	public Boolean validateContact(Contact contact, String operation) throws ContactValidationException {
		if (contact == null) {
			throw new ContactValidationException(CANNOT_BE_NULL);
		}
		if (UPDATE.equals(operation) && contact.getId() == null) {
			throw new ContactValidationException(ID_MISSING);
		}
		if (!isValid(contact.getFirstName(), NAME_VALIDATION_PATTERN)) {
			throw new ContactValidationException(String.format(INVALID_FIELD, "First Name"));
		}
		if (!isValid(contact.getLastName(), NAME_VALIDATION_PATTERN)) {
			throw new ContactValidationException(String.format(INVALID_FIELD, "Second Name"));
		}
		if ((!isValid(contact.getPhoneNumber(), PHONENUMBER_VALIDATION_PATTERN)
				&& StringUtils.isEmpty(contact.getPhoneNumber()))
				|| (StringUtils.isNotEmpty(contact.getPhoneNumber()) && contact.getPhoneNumber().length() > 10)) {
			throw new ContactValidationException(String.format(INVALID_FIELD, "Phone number"));
		}
		if (!isValid(contact.getEmail(), EMAIL_VALIDATION_PATTERN)) {
			throw new ContactValidationException(String.format(INVALID_FIELD, "Email"));
		}
		return true;
	}

	private Boolean isValid(String field, String regex) {
		if (StringUtils.isNotEmpty(field) && StringUtils.isNotEmpty(regex)) {
			return Pattern.compile(regex).matcher(field).matches();
		}
		return false;
	}
}
