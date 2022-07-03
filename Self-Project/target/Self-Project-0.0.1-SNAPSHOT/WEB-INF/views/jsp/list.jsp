<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="i" items="${list}">
         Animal Id <c:out value="${i.getId()}" />
		<p>
			Animal Name
			<c:out value="${i.getName()}" />
		<p>
			Animal Description
			<c:out value="${i.getDescription()}" />
		<p>
			<br />
	</c:forEach>
	<form:form method="POST" action="redirect">
		<br />
		<input type="submit" value="Redirect" />
	</form:form>
</body>
</html>