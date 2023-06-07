package com.nt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Contact;
import com.nt.service.ImpConatactService;

@RestController
public class ContactController {

	@Autowired
	private ImpConatactService service;

	@PostMapping("/save")
	public ResponseEntity<String> saveContact(@RequestBody Contact contact) {
		String msg = service.upsertContact(contact);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<Contact> getAllContacts() {
		List<Contact> list = service.getAllContact();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@GetMapping("/edit/{id}")
	public ResponseEntity<?> editContact(@PathVariable Integer id) {
		Optional<Contact> contact = service.getContactById(id);
		if (contact.isPresent()) {
			return new ResponseEntity<Contact>(contact.get(), HttpStatus.OK);
		}
		return new ResponseEntity<String>(id + " contact is not present", HttpStatus.NO_CONTENT);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateContact(@RequestBody Contact contact) {
		String msg = service.upsertContact(contact);

		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteContact(@PathVariable Integer id){
		String msg=service.deleteContact(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
