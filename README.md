## Phonebook web application

This phonebook web app shows a very simple CRUD operations for a Contact entity in a phonebook context.

## Used technology / frameworks

* JSP
* Servlet
* Hibernate
* Tomcat
* JUnit

## Setup and run 

1. git clone <this repo>
2. Create a database and configure it in src/main/resources/hibernate.cfg.xml
2. mvn clean install
3. Deploy war file (in target/phonebook-1.0.0.war)
4. Add contacts in http://localhost:8080/phonebook-1.0.0/phonebook (default Tomcat url)
5. Added contacts will be shown immediately. It also updating and deleting will enabled after adding contacts.  
