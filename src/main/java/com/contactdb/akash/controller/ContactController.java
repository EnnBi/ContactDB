package com.contactdb.akash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.contactdb.akash.entity.Contact;
import com.contactdb.akash.repo.ContactRepository;

@Controller
@RequestMapping({ "/contact", "/contacts" })
public class ContactController {

	@Autowired
	ContactRepository contactRepository;

	/**
	 * This API is for fetching all contacts in Database
	 * 
	 * */

	@GetMapping
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(contactRepository.findAll());
	}
	
	/**
	 * 
	 * This API is for retrieving one single contact on Id
	 * 
	 * */
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable long id) {
		return ResponseEntity.ok(contactRepository.findById(id));
	}

	/**
	 * 
	 * This API is saving contact in Database
	 * 
	 * */
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Contact contact){
		
		if(contactRepository.existsByNumber(contact.getNumber()))
			return new ResponseEntity<Contact>(contact,HttpStatus.CONFLICT);
		
		contact=contactRepository.save(contact);
		return new ResponseEntity<Contact>(contact,HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * This API is for deleting one single contact on Id
	 * 
	 * */
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		if(!contactRepository.existsById(id))
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
			contactRepository.deleteById(id);
			return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * 
	 * This API is for updating contact 
	 * 
	 * */
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Contact contact){
		contact = contactRepository.save(contact);
		return new ResponseEntity<Contact>(contact,HttpStatus.OK);
	}
	
	
	/**
	 * 
	 * This API is for fetching contacts on city name
	 * 
	 * */
	
	@GetMapping("/city/{name}")
	public ResponseEntity<?> contactsOfTown(@PathVariable String name){
		return ResponseEntity.ok(contactRepository.findByAddress_CityIgnoreCase(name));
	}
	
	
}
