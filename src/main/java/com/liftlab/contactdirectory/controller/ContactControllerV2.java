package com.liftlab.contactdirectory.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liftlab.contactdirectory.exception.ContactNotFoundException;
import com.liftlab.contactdirectory.exception.ContactServiceException;
import com.liftlab.contactdirectory.exception.ContactValidationException;
import com.liftlab.contactdirectory.model.Contact;
import com.liftlab.contactdirectory.service.ContactService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * @author hemanthjamili
 *
 */
@RestController
@RequestMapping("/api/v2")
@Api(value = "APIs in this controller responds back with plain contact object form")
public class ContactControllerV2 {
	
	private static Logger logger = LoggerFactory.getLogger(ContactControllerV1.class);
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/contact")
	@ApiOperation("Api to fetch all the contacts")
	public ResponseEntity<List<Contact>> getContacts() throws ContactServiceException {
		logger.info("Request recieved to get all the contacts");
		try {
			return new ResponseEntity<List<Contact>>(contactService.getAllContacts(), HttpStatus.OK);
		} catch (ContactServiceException e) {
			return new ResponseEntity<List<Contact>>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("Exception occurred while fetching all contacts");
			return new ResponseEntity<List<Contact>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/contact/{id}")
	@ApiOperation("Api to fetch contact by id")
	public ResponseEntity<Contact> getContactById(@PathVariable("id") Integer id) throws ContactServiceException {
		logger.info("Request recieved to get the contact of {} id", id);
		try {
			return new ResponseEntity<Contact>(contactService.getContactById(id), HttpStatus.OK);
		} catch (ContactNotFoundException e) {
			return new ResponseEntity<Contact>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("Exception occurred while fetching the contact of {} id", id);
			return new ResponseEntity<Contact>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 
	
	@PostMapping("/contact")
	@ApiOperation("Api to create a contact")
	public ResponseEntity<Contact> createContact(@RequestBody @Valid @NotNull @NotEmpty Contact contact) throws ContactServiceException {
		logger.info("Request recieved to create a contact");
		try {
			return new ResponseEntity<Contact>(contactService.createContact(contact), HttpStatus.OK);
		} catch (ContactValidationException e) {
			return new ResponseEntity<Contact>(HttpStatus.PRECONDITION_FAILED);
		} catch (Exception e) {
			logger.error("Exception occurred while creating a contact");
			return new ResponseEntity<Contact>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/contact")
	@ApiOperation("Api to update a contact")
	public ResponseEntity<Contact> updateContact(@RequestBody @Valid @NotNull @NotEmpty Contact contact) throws ContactServiceException {
		logger.info("Request recieved to update a contact");
		try {
			return new ResponseEntity<Contact>(contactService.updateContact(contact), HttpStatus.OK);
		} catch (ContactNotFoundException e) {
			return new ResponseEntity<Contact>(HttpStatus.NOT_FOUND);
		} catch (ContactValidationException e) {
			return new ResponseEntity<Contact>(HttpStatus.PRECONDITION_FAILED);
		} catch (Exception e) {
			logger.error("Exception occurred while updating a contact");
			return new ResponseEntity<Contact>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/contact/{id}")
	@ApiOperation("Api to delete a contact")
	public ResponseEntity<Contact> deleteContact(@PathVariable("id") Integer id) throws ContactServiceException {
		logger.info("Request recieved to delete a contact");
		try {
			return new ResponseEntity<Contact>(contactService.deleteContact(id), HttpStatus.OK);
		} catch (ContactNotFoundException e) {
			return new ResponseEntity<Contact>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("Exception occurred while updating a contact");
			return new ResponseEntity<Contact>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
