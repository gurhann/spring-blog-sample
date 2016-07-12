<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="label.login.title"></spring:message></title>
</head>
<body>
	<h1>
		<spring:message code="label.login.title"></spring:message>
	</h1>
	<form:form method="post" action="/blogsample/j_spring_security_check">
		<table>
			<tr>
				<td><label><spring:message code="label.user.email"></spring:message></label></td>
				<td><input id="username" name="username" type="text"></<input></td>
			</tr>
			<tr>
				<td><label><spring:message code="label.user.password"></spring:message></label></td>
				<td><input id="password" name="password" type="password"></input></td>
			</tr>
			<tr>
				<td>
					<button type="submit">
						<spring:message code="label.form.login"></spring:message>
					</button>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>