<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<spring:message var="title" code="label.post.title"></spring:message>
<spring:message var="text" code="label.post.text"></spring:message>
<spring:message var="postUpdateTitle" code="label.post.update"></spring:message>
<spring:message var="commentText" code="label.comment.text"></spring:message>
<spring:url value="/secure/updatePost" var="updatePost"></spring:url>
<spring:url value="/secure/createComment" var="createComment"></spring:url>
<sec:authorize access="hasRole('ROLE_USER')" var="isUserLogin"></sec:authorize>
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

				<div class="row">
					<c:if test="${isOwnUser}">
						<div class="col-lg-4 col-lg-offset-2 col-md-5">
							<button type="button" id="postUpdateButton" class="btn btn-info" data-toggle="modal"
								data-target="#postUpdateModal">Open Modal</button>
						</div>
					</c:if>
					<c:if test="${isUserLogin}">
						<div class="col-lg-4 col-lg-offset-2 col-md-5">
							<button type="button" id="showCreateCommentButton" class="btn btn-info">Yorum Yap</button>
						</div>
					</c:if>
				</div>
				<c:if test="${isUserLogin}">
					<br />
					<div class="row" style="display: none" id="createCommentRow">
						<div class="col-lg10 col-lg-offset-2 col-md-10 col-md-offset-1">
							<form:form method="post" action="${createComment}" commandName="comment">
								<div class="row control-group">
									<div class="form-group col-lg-8 floating-label-form-group controls">
										<label>${commentText}</label>
										<form:textarea path="text" name="text" value="" class="form-control"
											placeholder="${commentText}" rows="4" />
										<form:input type="hidden" path="post.id" name="post.id" value="${post.id}"></form:input>
									</div>
								</div>
								<div class="row control-group">
									<div class="form-group col-lg-8">
										<button type="submit" class="btn btn-default">
											<spring:message code="label.form.save"></spring:message>
										</button>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</c:if>
				<br />
				<c:forEach items="${comments}" var="comment">
					<div class="row">
						<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
							<div class="panel panel-default">
								<div class="panel-heading">
									<strong>${comment.user.firstName} ${comment.user.lastName}</strong> <span
										class="text-muted"><fmt:formatDate value="${comment.date}" pattern="dd/MM/yyyy" /></span>
								</div>
								<div class="panel-body">${comment.text}</div>
								<!-- /panel-body -->
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div id="postUpdateModal" class="modal fade" role="dialog">
				<div class="modal-dialog modal-lg">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">${postUpdateTitle}</h4>
						</div>
						<div class="modal-body">
							<form:form method="post" action="${updatePost}" commandName="post">
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
								<form:input type="hidden" path="id" value="${post.id}"></form:input>
								<div class="row control-group">
									<div class="form-group col-xs-12">
										<button type="submit" class="btn btn-default" id="updatePostButton">
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