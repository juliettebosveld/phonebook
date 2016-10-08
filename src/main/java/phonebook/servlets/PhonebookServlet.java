package phonebook.servlets;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import phonebook.dao.ContactsDao;
import phonebook.domain.Contact;

public class PhonebookServlet extends HttpServlet {
	
	ContactsDao dao = new ContactsDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		List<Contact> contacts = dao.getAll();
		 
		req.setAttribute("contacts", contacts);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/listResults.jsp");
		rd.forward(req, resp);
	}
	
	private EntityManager getEntityManager() {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("phonebookPU");
		return em.createEntityManager();
		}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		if (id == null || id.isEmpty()) {
			createNewContact(req.getParameter("name"), req.getParameter("number"));
		} else {
			updateContact(id, req.getParameter("name"), req.getParameter("number"));
		}
		doGet(req, res);
	}
	
	private void updateContact(String id, String name, String number) {
		if (name == null && number == null) {
			dao.deleteContact(id);
		} else {
			dao.updateContact(id, name, number);
		}	
	}

	private void createNewContact(String name, String number) {
		Contact contact = new Contact(name,number);
		dao.create(contact);
	}
}
