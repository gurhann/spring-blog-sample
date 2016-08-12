<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<spring:message code="label.user.email" var="email" scope="page"></spring:message>
<spring:message code="label.user.password" var="password" scope="page"></spring:message>
<tiles:insertDefinition name="base.definition">
	<tiles:putAttribute name="title">
		<spring:message code="label.login.title"></spring:message>
	</tiles:putAttribute>
	<tiles:putAttribute name="content">
		<!-- Main Content -->
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<p>
						<spring:message code="label.login.title"></spring:message>
					</p>
					<form method="post" action="/blogsample/j_spring_security_check">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						<div class="row control-group">
							<div class="form-group col-xs-12 floating-label-form-group controls">
								<label>${email}</label> <input id="username" name="username" type="text"
									class="form-control" placeholder="${email}"></input>
							</div>
						</div>
						<div class="row control-group">
							<div class="form-group col-xs-12 floating-label-form-group controls">
								<label>${password}</label> <input id="password" name="password" type="password"
									class="form-control" placeholder="${password}"></input>
							</div>
						</div>
						<br />
						<div class="row">
							<div class="form-group col-xs-12">
								<button type="submit" class="btn btn-default">
									<spring:message code="label.form.login"></spring:message>
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>