<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<body>
	<h1>Spring MVC internationalization</h1>
	Language :
	<a href="?language=en">English</a>|
	<a href="?language=vi_VN">Viet Nam</a>|
	<a href="?language=fr_FR">France</a> |
	<a href="?language=ja_JP">Japan</a>
	<h2>
		hello :
		<spring:message code="hello" text="default text" />
	</h2>

	Current Locale : ${pageContext.response.locale}
</body>
</html>