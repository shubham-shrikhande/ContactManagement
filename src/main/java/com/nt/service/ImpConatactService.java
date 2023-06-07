package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Contact;
import com.nt.repo.ContactRepository;

@Service
public class ImpConatactService implements IContactService {

	@Autowired
	private ContactRepository repo;

	@Override
	public String upsertContact(Contact contact) {
		repo.save(contact);
		return contact.getId()+" contact is saved successfully!!";
	}

	@Override
	public Optional<Contact> getContactById(Integer id) {
		Optional<Contact> contact = repo.findById(id);
		if (contact.isPresent()) {
			return contact;
		}
		return null;
	}

	@Override
	public String deleteContact(Integer id) {
		Optional<Contact> contact = repo.findById(id);
		if (contact.isPresent()) {
			repo.deleteById(id);
			return id + " contact deleted successfully!!!";
		}
		return id + " contact not found!!";
	}
	@Override
	public List<Contact> getAllContact() {
		return repo.findAll();
	}

}
