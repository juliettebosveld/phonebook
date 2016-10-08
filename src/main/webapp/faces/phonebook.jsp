<html>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<head>
<title>Phonebook</title>
</head>
<body>

<p>phonebook</p>
<f:view>
    <h:form>
       <h:dataTable value ="#{phonebookBean.contacts}" var="contact">
       	<f:facet name="header">Contacten</f:facet>
       	<h:column>
       		<f:facet name="header">Naam</f:facet>
       		<h:outputText value="contact.name"/>
       	</h:column>
       	<h:column>
       		<f:facet name="header">Nummer</f:facet>
       		<h:outputText value="contact.number"/>
       	</h:column>
       </h:dataTable>
    </h:form>
</f:view>

</body>
</html>