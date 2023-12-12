package com.liftlab.contactdirectory.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liftlab.contactdirectory.dto.ContactServiceResponseDto;
import com.liftlab.contactdirectory.exception.ContactServiceException;
import com.liftlab.contactdirectory.model.Contact;
import com.liftlab.contactdirectory.service.ContactService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * @author hemanthjamili
 *
 */
@RestController
@RequestMapping("/api/v1")
@Api(value = "Apis in this controller reponds back in the form of ContentServiceResponseDto by extending the baseController")
public class ContactControllerV1 extends BaseController {
	
	private static Logger logger = LoggerFactory.getLogger(ContactControllerV1.class);
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/contact")
	@ApiOperation("Api to fetch all the contacts")
	public ResponseEntity<ContactServiceResponseDto> getContacts() throws ContactServiceException {
		logger.info("Request recieved to get all the contacts");
		return handleResponse(contactService.getAllContacts());
	}
	
	@GetMapping("/contact/{id}")
	@ApiOperation("Api to fetch contact by id")
	public ResponseEntity<ContactServiceResponseDto> getContactById(@PathVariable("id") Integer id) throws ContactServiceException {
		logger.info("Request recieved to get the contact of {} id", id);
		return handleResponse(contactService.getContactById(id));
	} 
	
	@PostMapping("/contact")
	@ApiOperation("Api to create a contact")
	public ResponseEntity<ContactServiceResponseDto> createContact(@RequestBody @Valid @NotNull @NotEmpty Contact contact) throws ContactServiceException {
		logger.info("Request recieved to create a contact");
		return handleResponse(contactService.createContact(contact));
	}
	
	@PutMapping("/contact")
	@ApiOperation("Api to update a contact")
	public ResponseEntity<ContactServiceResponseDto> updateContact(@RequestBody @Valid @NotNull @NotEmpty Contact contact) throws ContactServiceException {
		logger.info("Request recieved to update a contact");
		return handleResponse(contactService.updateContact(contact));
	}
	
	@DeleteMapping("/contact/{id}")
	@ApiOperation("Api to delete a contact")
	public ResponseEntity<ContactServiceResponseDto> deleteContact(@PathVariable("id") Integer id) throws ContactServiceException {
		logger.info("Request recieved to delete a contact");
		return handleResponse(contactService.deleteContact(id));
	}
}
