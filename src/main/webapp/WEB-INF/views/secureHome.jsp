<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.pages.secure.title"></spring:message></title>
</head>
<body>
	<spring:message code="label.pages.secure.title"></spring:message>
	<form:form action="/blogsample/user/secure/logout" method="POST">
		<button type="submit"><spring:message code="label.pages.logout"></spring:message></button>
	</form:form>
</body>
</html>