package com.liftlab.contactdirectory.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.liftlab.contactdirectory.dto.ContactServiceResponseDto;
import com.liftlab.contactdirectory.exception.ContactNotFoundException;
import com.liftlab.contactdirectory.exception.ContactServiceException;
import com.liftlab.contactdirectory.exception.ContactValidationException;

import static com.liftlab.contactdirectory.constants.Constants.*;
/**
 * @author hemanthjamili
 *
 */
public class BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

	protected <T> ResponseEntity<ContactServiceResponseDto> handleResponse(T response) {
		try {
			if (response == null) {
				return new ResponseEntity<>(new ContactServiceResponseDto(response, NO_CONTENT), 
						HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(new ContactServiceResponseDto(response, SUCCESS),
					HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Exception occurred while handling request");
		}

		return new ResponseEntity<>(new ContactServiceResponseDto(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ContactServiceResponseDto> handle(Exception e) throws Exception {
		LOGGER.warn("Returning HTTP 400 Bad Request", e);
		return new ResponseEntity<>(new ContactServiceResponseDto(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ContactServiceException.class)
	protected ResponseEntity<ContactServiceResponseDto> handleContactServiceException(ContactServiceException ex) {
		try {
			return new ResponseEntity<ContactServiceResponseDto>(new ContactServiceResponseDto(null, ex.getMessage()),
					HttpStatus.PRECONDITION_FAILED);
		} catch (Exception e) {
			LOGGER.error("Exception occurred while handling request");
		}
		return new ResponseEntity<>(new ContactServiceResponseDto(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ContactValidationException.class)
	protected ResponseEntity<ContactServiceResponseDto> handleContactValidationException(ContactValidationException ex) {
		try {
			return new ResponseEntity<ContactServiceResponseDto>(new ContactServiceResponseDto(null, ex.getMessage()),
					HttpStatus.PRECONDITION_FAILED);
		} catch (Exception e) {
			LOGGER.error("Exception occurred while handling request");
		}
		return new ResponseEntity<>(new ContactServiceResponseDto(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ContactNotFoundException.class)
	protected ResponseEntity<ContactServiceResponseDto> handleContactNotFoundException(ContactNotFoundException ex) {
		try {
			return new ResponseEntity<ContactServiceResponseDto>(new ContactServiceResponseDto(null, ex.getMessage()),
					HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			LOGGER.error("Exception occurred while handling request");
		}
		return new ResponseEntity<>(new ContactServiceResponseDto(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
