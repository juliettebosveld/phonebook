<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Phonebook</title>
</head>
<body>

	<h2>Phonebook</h2>
	
	<table cellspacing="10">
		<c:forEach var="contact" items="${requestScope.contacts}">
			<tr>
			<form action="phonebook?id=${contact.id}" method="POST">
			<td><input type="text" name="name" maxlength="50" value="${contact.name}"></td>
			<td><input type="text" name="number" maxlength="11" value="${contact.number}"/></td>
			<td><input type="submit" value="update"/></td>
			</form>
			<form action="phonebook?id=${contact.id}" method="POST">
			<td><input type="submit" value="delete"/></td>
			</form>
			</tr>
		</c:forEach>
	</table>
	
	<h3>Add new contact</h3>
	
    <form action="phonebook" method="POST">
	First Name: <input type="text" name="name">
	<br />
	Last Name: <input type="text" name="number" />
	<input type="submit" value="Submit" />
</form>
</body>
</html>