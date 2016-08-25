<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<spring:message var="title" code="label.post.title"></spring:message>
<spring:message var="text" code="label.post.text"></spring:message>
<tiles:insertDefinition name="base.definition">
	<tiles:putAttribute name="title">
		<spring:message code="label.title.create-post"></spring:message>
	</tiles:putAttribute>
	<c:choose>
		<c:when test="${operType == 'CREATE'}">
			<spring:url var="operTypeUrl" value="/secure/createPost"></spring:url>
		</c:when>
		<c:when test="${operType == 'UPDATE'}">
			<spring:url var="operTypeUrl" value="/secure/updatePost"></spring:url>

		</c:when>
	</c:choose>
	<tiles:putAttribute name="content">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<form:form method="post" action="${operTypeUrl}" commandName="post">
						<div class="row control-group">
							<div class="form-group col-xs-12 floating-label-form-group controls">
								<label>${title}</label>
								<form:input path="title" name="title" value="" class="form-control" placeholder="${title}" />
								<form:errors path="title" element="p" cssClass="text-danger" />
							</div>
						</div>
						<div class="row control-group">
							<div class="form-group col-xs-12 floating-label-form-group controls">
								<label>${text}</label>
								<div id="summernote" class="form-control"></div>
								<form:input id="postTextStr" type="hidden" path="text" name="text" value="" />
								<form:errors path="text" element="p" cssClass="text-danger" />
							</div>
						</div>
						<div class="row control-group">
							<div class="form-group col-xs-12">
								<button type="submit" class="btn btn-default" id="createPostButton">
									<spring:message code="label.form.save"></spring:message>
								</button>
							</div>
						</div>
						<c:if test="${operType == 'UPDATE'}">
							<form:hidden path="id" value="${post.id}" />
							<script type="text/javascript">
								$(document).ready(function() {
									var val = $("#postTextStr").val();
									$("#summernote").summernote("code", val);
								});
							</script>
						</c:if>
					</form:form>
				</div>
			</div>
		</div>


	</tiles:putAttribute>
</tiles:insertDefinition>

