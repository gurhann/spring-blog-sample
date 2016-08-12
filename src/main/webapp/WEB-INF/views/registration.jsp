<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<spring:url value="/user/registration" var="register"></spring:url>
<spring:message code="label.user.firstName" var="firstName"></spring:message>
<spring:message code="label.user.lastName" var="lastName"></spring:message>
<spring:message code="label.user.email" var="email"></spring:message>
<spring:message code="label.user.password" var="password"></spring:message>
<spring:message code="label.user.confirmPass" var="confirmPass"></spring:message>
<tiles:insertDefinition name="base.definition">

	<tiles:putAttribute name="title">
		<spring:message code="label.register.title"></spring:message>
	</tiles:putAttribute>
	<tiles:putAttribute name="content">
	
		<!-- Main Content -->
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<p>
						<spring:message code="label.register.title"></spring:message>
					</p>
					<form:form method="post" action="${register}" commandName="user">
						<div class="row control-group">
							<div class="form-group col-xs-12 floating-label-form-group controls">
								<label>${firstName}</label>
								<form:input path="firstName" name="firstName" value="" class="form-control"
									placeholder="${firstName}" />
							</div>
						</div>
						<div class="row control-group">
							<div class="form-group col-xs-12 floating-label-form-group controls">
								<label>${lastName}</label>
								<form:input path="lastName" id="sa" value="" class="form-control" placeholder="${lastName}" />
							</div>
						</div>
						<div class="row control-group">
							<div class="form-group col-xs-12 floating-label-form-group controls">
								<label>${email}</label>
								<form:input path="email" value="" class="form-control" placeholder="${email}" />
								<form:errors path="email" element="div" />
							</div>
						</div>
						<div class="row control-group">
							<div class="form-group col-xs-12 floating-label-form-group controls">
								<label>${password}</label>
								<form:input path="password" value="" type="password" class="form-control"
									placeholder="${password}" />
								<form:errors path="password" element="div" />
							</div>
						</div>
						<div class="row control-group">
							<div class="form-group col-xs-12 floating-label-form-group controls">
								<label>${confirmPass}</label>
								<form:input path="matchingPassword" value="" type="password" class="form-control"
									placeholder="${confirmPass}" />
								<form:errors element="div" />
							</div>
						</div>
						<br />
						<div class="row control-group">
							<div class="form-group col-xs-12">
								<button type="submit" class="btn btn-default">
									<spring:message code="label.form.register"></spring:message>
								</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
