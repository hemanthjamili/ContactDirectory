package com.liftlab.contactdirectory.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liftlab.contactdirectory.exception.ContactNotFoundException;
import com.liftlab.contactdirectory.exception.ContactServiceException;
import com.liftlab.contactdirectory.model.Contact;
import com.liftlab.contactdirectory.repository.ContactRepository;
import com.liftlab.contactdirectory.service.ContactService;
import com.liftlab.contactdirectory.validator.ContactValidator;

import static com.liftlab.contactdirectory.constants.Constants.*;
import static com.liftlab.contactdirectory.constants.MessageCodes.*;

/**
 * @author hemanthjamili
 *
 */
@Service
public class ContactServiceImpl implements ContactService {

	private static Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class);

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private ContactValidator validator;

	@Override
	public Contact getContactById(Integer id) throws ContactServiceException {
		Optional<Contact> contact = null;
		try {
			contact = contactRepository.findById(id);
			if (contact.isEmpty()) {
				String message = String.format(NO_CONTACT_FOUND_WITH_ID, id);
				logger.info(message);
				throw new ContactNotFoundException(message);
			}

		} catch (ContactServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception occurred while fetching contact by id {}", e);
		}
		return contact.get();
	}

	@Override
	public List<Contact> getAllContacts() throws ContactServiceException {
		List<Contact> contacts = new ArrayList<>();
		try {
			contacts = contactRepository.findAll();
			if (contacts.isEmpty()) {
				logger.info(CONTACT_DIRECTORY_EMPTY);
				throw new ContactServiceException(CONTACT_DIRECTORY_EMPTY);
			}
			logger.info(String.format(FETCH_SUCCESS, contacts.size()));
		} catch (ContactServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception occurred while fetching all contacts {}", e);
		}
		return contacts;
	}

	@Override
	public Contact createContact(Contact contact) throws ContactServiceException {
		Contact savedContact = null;
		try {
			validator.validateContact(contact, CREATE);
			logger.info(VALIDATION_PASSED);
			savedContact = contactRepository.save(contact);
			logger.info(CREATION_SUCCESS);
		} catch (ContactServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception occurred while creating a contact {}", e);
		}
		return savedContact;
	}

	@Override
	public Contact updateContact(Contact contact) throws ContactServiceException {
		Contact updatedContact = null;
		try {
			updatedContact = getContactById(contact.getId());
			validator.validateContact(contact, UPDATE);
			logger.info(VALIDATION_PASSED);
			if (updatedContact != null) {
				updatedContact = contactRepository.save(contact);
				logger.info(UPDATION_SUCCESS);
			}
		} catch (ContactServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception occurred while updating a contact {}", e);
		}
		return updatedContact;
	}

	@Override
	public Contact deleteContact(Integer id) throws ContactServiceException {
		Contact deletedContact = null;
		try {
			deletedContact = getContactById(id);
			if (deletedContact != null) {
				contactRepository.delete(deletedContact);
				logger.info(DELETION_SUCCESS);
			}
		} catch (ContactServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception occurred while deleting a contact {}", e);
		}
		return deletedContact;
	}

}
