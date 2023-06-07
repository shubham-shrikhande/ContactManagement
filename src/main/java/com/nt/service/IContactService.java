package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Contact;

public interface IContactService {

	public String upsertContact(Contact contact);
	public Optional<Contact> getContactById(Integer id);
	public String deleteContact(Integer id);
	public List<Contact> getAllContact();
	
}
