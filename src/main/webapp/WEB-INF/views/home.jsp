<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.home.title"></spring:message></title>
</head>
<body>
	<h1>
		<spring:message code="label.home.welcome"></spring:message>
	</h1>
	<a href="${pageContext.request.contextPath}/user/registration"><spring:message
			code="click.register"></spring:message></a>
	<a href="${pageContext.request.contextPath}/user/login"><spring:message
			code="click.login"></spring:message></a>

</body>
</html>
