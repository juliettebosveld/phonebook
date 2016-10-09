package phonebook.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import phonebook.dao.ContactsDao;
import phonebook.domain.Contact;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PhonebookServletTest {
	
	@Mock (name="dao")
	ContactsDao dao;
	
	@Mock
	ServletContext servletContextMock;
	
	@Mock
	RequestDispatcher dispatcherMock;
	
	@Mock
	HttpServletRequest req;
	
	@Mock
	HttpServletResponse resp;
	
	@InjectMocks
	PhonebookServletForTests servlet;
	
	
	/**
     * Set data and mock before each test 
     */
    @Before
    public final void setUp() {
        when(servletContextMock.getRequestDispatcher("/phonebook.jsp")).thenReturn(dispatcherMock);
    }
	
    /**
     * Test for testing the doGet method
     * @throws ServletException
     * @throws IOException
     */
	@Test
	public void testdoGet() throws ServletException, IOException {
		
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(new Contact("contact1", "1"));
		when(dao.getAll()).thenReturn(contacts);
		
		servlet.doGet(req, resp);

		verify(req , times(1)).setAttribute("contacts", contacts);
	}
	
	/**
	 * Test for adding a new contact
	 * @throws ServletException
	 * @throws IOException
	 */
	@Test
	public void testdoPostNoId() throws ServletException, IOException {
		when(req.getParameter("id")).thenReturn(null);
		when(req.getParameter("name")).thenReturn("contact2");
		when(req.getParameter("number")).thenReturn("2");
		
		servlet.doPost(req, resp);
		
		verify(dao , times(1)).create(any(Contact.class));
	}

	/**
	 * Test for updating a contact
	 * @throws ServletException
	 * @throws IOException
	 */
	@Test
	public void testdoPostWithId() throws ServletException, IOException {
		when(req.getParameter("id")).thenReturn("1");
		when(req.getParameter("name")).thenReturn("contact");
		when(req.getParameter("number")).thenReturn("3");
		
		servlet.doPost(req, resp);
		
		verify(dao , times(1)).updateContact("1", "contact", "3");
	}
	
	/**
	 * Test for deleting a contact
	 * @throws ServletException
	 * @throws IOException
	 */
	@Test
	public void testdoPostNoNameAndNumber() throws ServletException, IOException {
		when(req.getParameter("id")).thenReturn("1");
		when(req.getParameter("name")).thenReturn(null);
		when(req.getParameter("number")).thenReturn(null);
		
		servlet.doPost(req, resp);
		
		verify(dao , times(1)).deleteContact("1");
	}
	
	/**
	 * Test for adding a new contact with empty name en number
	 * @throws ServletException
	 * @throws IOException
	 */
	@Test
	public void testdoPostEmptyNameAndNumber() throws ServletException, IOException {
		when(req.getParameter("id")).thenReturn("1");
		when(req.getParameter("name")).thenReturn("");
		when(req.getParameter("number")).thenReturn("");
		
		servlet.doPost(req, resp);
		
		verify(dao , times(1)).updateContact("1", "", "");
	}


}
