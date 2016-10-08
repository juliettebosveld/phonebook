package phonebook.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import phonebook.domain.Contact;

/**
 * Data Access Object for the Contact Entity
 * @author Juliette Bosveld
 *
 */
public class ContactsDao {
	
	/**
	 * Entity Manager for DB access
	 */
	EntityManager em = Persistence.createEntityManagerFactory("phonebookPU").createEntityManager();
	
	/**
	 * Method for deleting a contact
	 * @param id id of the contact to delete
	 */
	public void deleteContact(String id) {
		Query query = em.createQuery("select c from Contact c where id =" + id);
		Contact contactEntity = (Contact) query.getSingleResult();
		em.getTransaction().begin();
		em.remove(contactEntity);
		em.getTransaction().commit();		
	}

	/**
	 * Method for editting a contact
	 * @param id of the contact to edit
	 * @param name (new) value of the name of the contact
	 * @param number (new) value of the number of the contact
	 */
	public void updateContact(String id, String name, String number) {
		Query query = em.createQuery("select c from Contact c where id =" + id);
		Contact contactEntity = (Contact) query.getSingleResult();
		contactEntity.setName(name);
		contactEntity.setNumber(number);
		em.getTransaction().begin();
		em.merge(contactEntity);
		em.getTransaction().commit();	
	}

	/**
	 * Method for creating a contact entity
	 * @param contact the contact to be created
	 */
	public void create(Contact contact) {
		em.getTransaction().begin();
		em.persist(contact);
		em.getTransaction().commit();
	}

	/**
	 * Method for retrieving all contacts from the database
	 * @return all contacts
	 */
	@SuppressWarnings("unchecked")
	public List<Contact> getAll() {
		Query query = em.createQuery("select c from Contact c");
		return query.getResultList();
	}

}
