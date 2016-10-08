package phonebook.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CONTACTS")

public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	public String name; 

	public String number;
	
	public Contact() {
		
	}

	public Contact(String name, String number) {
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


}
