package com.liftlab.contactdirectory.service;

import java.util.List;

import com.liftlab.contactdirectory.exception.ContactServiceException;
import com.liftlab.contactdirectory.model.Contact;

/**
 * @author hemanthjamili
 *
 */
public interface ContactService {
	Contact getContactById(Integer id) throws ContactServiceException;
	List<Contact> getAllContacts() throws ContactServiceException;
	Contact createContact(Contact contact) throws ContactServiceException;
	Contact updateContact(Contact contact) throws ContactServiceException;
	Contact deleteContact(Integer id) throws ContactServiceException;	
}
