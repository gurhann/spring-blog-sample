<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="label.register.title"></spring:message></title>
</head>
<body>
	<h1>
		<spring:message code="label.register.title"></spring:message>
	</h1>
	<form:form modelAttribute="user" method="POST" enctype="utf8">
		<table>
			<tr>
				<td><label><spring:message code="label.user.firstName"></spring:message>
				</label></td>
				<td><form:input path="firstName" value="" /></td>
				<form:errors path="firstName" element="div" />
			</tr>
			<tr>
				<td><label><spring:message code="label.user.lastName"></spring:message>
				</label></td>
				<td><form:input path="lastName" value="" /></td>
				<form:errors path="lastName" element="div" />
			</tr>
			<tr>
				<td><label><spring:message code="label.user.email"></spring:message>
				</label></td>
				<td><form:input path="email" value="" /></td>
				<form:errors path="email" element="div" />
			</tr>
			<tr>
				<td><label><spring:message code="label.user.password"></spring:message>
				</label></td>
				<td><form:input path="password" value="" type="password" /></td>
				<form:errors path="password" element="div" />
			</tr>
			<tr>
				<td><label><spring:message
							code="label.user.confirmPass"></spring:message> </label></td>
				<td><form:input path="matchingPassword" value=""
						type="password" /></td>
				<form:errors element="div" />
			</tr>
			<tr>
				<td>
					<button type="submit">
						<spring:message code="label.form.register"></spring:message>
					</button>
				</td>
			</tr>
		</table>
	</form:form>

	</a>
</body>
</html>