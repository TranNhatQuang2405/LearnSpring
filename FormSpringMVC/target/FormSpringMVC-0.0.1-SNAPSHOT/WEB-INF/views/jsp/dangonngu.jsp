<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="?language=en">English</a>|
	<a href="?language=vi_VN">Viet Nam</a>|
	<a href="?language=ja_JP">Japanese</a>|
	<a href="?language=fr_FR">France</a>
	<p>${message}</p>
	<h2>Change: <spring:message code="hello" text="default text" /></h2>
</body>
</html>