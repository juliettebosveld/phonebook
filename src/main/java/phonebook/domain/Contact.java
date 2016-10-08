package phonebook.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACTS")

/**
 * Contact entity
 * @author Juliette Bosveld
 *
 */
public class Contact {

	/**
	 * Id of the entity
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	/**
	 * name of the contact
	 */
	public String name; 

	/**
	 * number of the contact
	 */
	public String number;
	
	/**
	 * default constructor needed for Hibernate
	 */
	public Contact() {
	}

	/**
	 * Constructor for creating a contact
	 * @param name name of the contact
	 * @param number nuber of the contact
	 */
	public Contact(String name, String number) {
		this.name = name;
		this.number = number;
	}

	/**
	 * getter for the id of the contact
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Method for getting the name of the contact
	 * @return name of the contact
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method for setting the name of the contact
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method for getting the number of the contact
	 * @param number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Method for setting the number of a contact
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}
}
