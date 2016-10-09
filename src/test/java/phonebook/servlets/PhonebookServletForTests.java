package phonebook.servlets;

import javax.servlet.ServletContext;

/**
 * class extention of the PhonebookServlet for testing. overrides the
 * getServletContext method so a mock can be injected
 * 
 * @author Juliette Bosveld
 *
 */
public class PhonebookServletForTests extends PhonebookServlet {
	
	ServletContext servletContextMock;
	
	@Override
	public ServletContext getServletContext() {
		return servletContextMock;
	}
}
