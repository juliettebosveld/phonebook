package phonebook.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import phonebook.dao.ContactsDao;
import phonebook.domain.Contact;

public class PhonebookBean {
	List<Contact> contacts;

	@Inject
	ContactsDao dao;
	
	@PostConstruct
	void init() {
		contacts = dao.getAll();

}
	
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
	public List<Contact> getContacts() {
		return this.contacts;
	}

}
