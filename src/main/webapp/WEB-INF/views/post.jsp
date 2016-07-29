<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="base.definition">
	<tiles:putAttribute name="title">${post.title}</tiles:putAttribute>
	<tiles:putAttribute name="header" value="/WEB-INF/views/post-header.jsp"></tiles:putAttribute>
	<tiles:putAttribute name="content">
		<article>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">${post.text}</div>
				</div>
			</div>
		</article>
		<hr />
	</tiles:putAttribute>
</tiles:insertDefinition>