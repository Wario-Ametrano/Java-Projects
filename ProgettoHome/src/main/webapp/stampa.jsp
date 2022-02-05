<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String nomeRicerca =(String) request.getAttribute("nomeRicerca");
	
	%>
	<h1>Il prodotto è ${nomeProdotto}</h1>
</body>
</html>