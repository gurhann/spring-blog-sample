<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<header class="intro-header"
	style="background-image: url('${pageContext.request.contextPath}/resources/img/post-bg.jpg')">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<div class="post-heading">
					<h1>${user.firstName}${user.lastName}</h1>
					<!--  
					<span class="meta">Posted by <a
						href="${pageContext.request.contextPath}/user/${post.user.id}">${post.user.firstName}
							${post.user.lastName }</a> <fmt:formatDate value="${post.date}" pattern="dd/MM/yyyy" />
							-->
					</span>
				</div>
			</div>
		</div>
	</div>
</header>