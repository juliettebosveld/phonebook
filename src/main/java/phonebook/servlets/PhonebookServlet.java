package phonebook.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import phonebook.dao.ContactsDao;
import phonebook.domain.Contact;

/**
 * Phonebook Servlet
 * 
 * @author Juliette Bosveld
 *
 */
@SuppressWarnings("serial")
public class PhonebookServlet extends HttpServlet {
	
	/**
	 * Data access object for creating, deleting and editting contacts
	 */
	ContactsDao dao = new ContactsDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		returnAllContacts(req,resp);
		
	}

	/**
	 * Method for executing POST request. If the id parameter in the request is
	 * empty a new contact is created. If the id field field contains an id,
	 * the corresponding entity will be updated.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		if (id == null || id.isEmpty()) {
			createNewContact(req.getParameter("name"), req.getParameter("number"));
		} else {
			updateContact(id, req.getParameter("name"), req.getParameter("number"));
		}
		returnAllContacts(req, res);
	}
	
	/**
	 * Returns all contacts in the request. Used in the doGet (initialization) and/or doPost for refreshing data
	 * 
	 * @param req HttpServletRequest
	 * @param resp HttpServletResponse
	 * @throws ServletException
	 * @throws IOException
	 */
	private void returnAllContacts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Contact> contacts = dao.getAll();
		 
		req.setAttribute("contacts", contacts);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/phonebook.jsp");
		rd.forward(req, resp);		
	}
	
	/**
	 * Method for updating a contact. id both het name and number al NULL the
	 * contact will be deleted. Else the new name and of number wil be set.
	 * 
	 * @param id of the contact entity
	 * @param name (new) name of the contact
	 * @param number (new) number of the contact
	 */
	private void updateContact(String id, String name, String number) {
		if (name == null && number == null) {
			dao.deleteContact(id);
		} else {
			dao.updateContact(id, name, number);
		}	
	}

	/**
	 * Method for creating a new contact entity
	 * @param name name of the contact
	 * @param number of the contact
	 */
	private void createNewContact(String name, String number) {
		Contact contact = new Contact(name,number);
		dao.create(contact);
	}
}
