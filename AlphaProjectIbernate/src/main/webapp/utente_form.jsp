<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form action="inserisciUtente" cssClass="form-horizontal"
		method="post" modelAttribute="utente">

		<label for="nome"> nome:</label>
		<input type="text" name="nome">
		<br>
		<label for="cognome"> cognome:</label>
		<input type="text" name="cognome">
		<br>
		<label for="email"> email:</label>
		<input type="text" name="email">
		<br>

		<input type="submit" value="inserisci" name="inserisci">
		<input type="reset" value="cancella" name="cancella">


	</form:form>
</body>


</html>