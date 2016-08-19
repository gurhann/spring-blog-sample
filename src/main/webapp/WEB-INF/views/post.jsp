<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:message var="title" code="label.post.title" ></spring:message>
<spring:message var="text" code="label.post.text"></spring:message>
<spring:message var ="postUpdateTitle" code="label.post.update"></spring:message>
<tiles:insertDefinition name="base.definition">
	<spring:message var="title" code="label.post.title"></spring:message>
	<spring:message var="text" code="label.post.text"></spring:message>
	<tiles:putAttribute name="title">${post.title}</tiles:putAttribute>
	<tiles:putAttribute name="header" value="/WEB-INF/views/post-header.jsp"></tiles:putAttribute>
	<tiles:putAttribute name="content">
		<article>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">${post.text}</div>
				</div>
				<br />
				<c:if test="${isOwnUser}">
					<div class="row">
						<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
							<button type="button" id="postUpdateButton" class="btn btn-info" data-toggle="modal" data-target="#postUpdateModal">Open
								Modal</button>


						</div>
					</div>
				</c:if>
			</div>

			<div id="postUpdateModal" class="modal fade" role="dialog">
				<div class="modal-dialog modal-lg"">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">${postUpdateTitle}</h4>
						</div>
						<div class="modal-body">
							<form:form method="post" action="#" commandName="post">
								<div class="row control-group">
									<div class="form-group col-xs-12 floating-label-form-group controls">
										<label>${title}</label>
										<form:input path="title" name="title" value="${post.title}" class="form-control" />
									</div>
								</div>
								<div class="row control-group">
									<div class="form-group col-xs-12 floating-label-form-group controls">
										<label>${text}</label>
										<div id="summernotePostUpdate" class="form-control"></div>
										<form:input id="updatePostTextStr" type="hidden" path="text" name="text"
											value="${post.text}" />

									</div>
								</div>
								<div class="row control-group">
									<div class="form-group col-xs-12">
										<button type="submit" class="btn btn-default" id="createPostUpdateButton">
											<spring:message code="label.form.save"></spring:message>
										</button>
									</div>
								</div>
							</form:form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						</div>
					</div>

				</div>
			</div>
		</article>
		<hr />
	</tiles:putAttribute>
</tiles:insertDefinition>