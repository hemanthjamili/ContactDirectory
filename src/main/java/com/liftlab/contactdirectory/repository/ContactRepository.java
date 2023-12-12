package com.liftlab.contactdirectory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.liftlab.contactdirectory.model.Contact;
/**
 * @author hemanthjamili
 *
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
