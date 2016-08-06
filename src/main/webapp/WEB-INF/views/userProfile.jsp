<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<tiles:insertDefinition name="base.definition">
	<spring:url var="nextPage" value="/user/${user.id}/${currentPage+1}"></spring:url>
	<spring:url var="previousPage" value="/user/${user.id}//${currentPage-1}"></spring:url>
	<tiles:putAttribute name="header" value="/WEB-INF/views/user-header.jsp"></tiles:putAttribute>
	<tiles:putAttribute name="title">
		<spring:message code="label.title.posts"></spring:message>
	</tiles:putAttribute>
	<tiles:putAttribute name="content">
		<!-- Main Content -->
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">

					<c:forEach var="post" items="${userPosts}">
						<div class="post-preview">
							<a href="${pageContext.request.contextPath}/post/${post.id}">
								<h2 class="post-title">${post.title}</h2>
								<h3 class="post-subtitle">${post.text}</h3>
							</a>
							<p class="post-meta">
								Posted by <a href="${pageContext.request.contextPath}/user/${post.user.id}">${post.user.firstName}
									${post.user.lastName}</a>
								<fmt:formatDate value="${post.date}" pattern="dd/MM/yyyy" />
							</p>
						</div>
						<hr>
					</c:forEach>
					<!-- Pager -->
					<ul class="pager">
						<c:if test="${currentPage != 1}">
							<li class="previous"><a href="${previousPage}">&larr; Newest Posts</a></li>
						</c:if>
						<c:if test="${!isLastPage}">
							<li class="next"><a href="${nextPage}">Older Posts &rarr;</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>

		<hr>
	</tiles:putAttribute>
</tiles:insertDefinition>