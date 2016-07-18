<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<spring:url value="/user/registration" var="registration"></spring:url>
<spring:url value="/index" var="index"></spring:url>
<spring:url value="/user/login" var="login"></spring:url>
<spring:url value="/user/secure/logout" var="logout"></spring:url>
<!-- Navigation -->
<nav class="navbar navbar-default navbar-custom navbar-fixed-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header page-scroll">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> Menu <i
					class="fa fa-bars"></i>
			</button>
			<a class="navbar-brand" href="index.html">Start Bootstrap</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${index}"><spring:message
							code="label.title.posts"></spring:message></a></li>
				<sec:authorize access="!hasRole('ROLE_USER')">
					<li><a href="${registration}"><spring:message
								code="label.register.title"></spring:message></a></li>
					<li><a href="${login}"><spring:message
								code="label.login.title"></spring:message></a></li>
				</sec:authorize>
				<li><a href="contact.html">Contact</a></li>
				<sec:authorize access="hasRole('ROLE_USER')">
					<li><a href="#"
						onclick="document.forms['navigation.logout.form'].submit(); return false;">
							<spring:message code="label.pages.logout"></spring:message>
					</a>
						<form action="${logout}" method="POST"
							name="navigation.logout.form">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />

						</form></li>
				</sec:authorize>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>