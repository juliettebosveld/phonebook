package phonebook.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import phonebook.domain.Contact;

public class ContactsDao {
	
	EntityManager em = Persistence.createEntityManagerFactory("phonebookPU").createEntityManager();

	public void deleteContact(String id) {
		Query query = em.createQuery("select c from Contact c where id =" + id);
		Contact contactEntity = (Contact) query.getSingleResult();
		em.getTransaction().begin();
		em.remove(contactEntity);
		em.getTransaction().commit();		
	}

	public void updateContact(String id, String name, String number) {
		Query query = em.createQuery("select c from Contact c where id =" + id);
		Contact contactEntity = (Contact) query.getSingleResult();
		contactEntity.setName(name);
		contactEntity.setNumber(number);
		em.getTransaction().begin();
		em.merge(contactEntity);
		em.getTransaction().commit();
		
	}

	public void create(Contact contact) {
		em.getTransaction().begin();
		em.persist(contact);
		em.getTransaction().commit();
		
	}

	public List<Contact> getAll() {
		Query query = em.createQuery("select c from Contact c");
		return query.getResultList();
	}

}
