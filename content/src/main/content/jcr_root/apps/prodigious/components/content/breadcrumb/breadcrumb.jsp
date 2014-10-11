<%@include file="/apps/prodigious/components/global.jsp" %>
<jsp:useBean id="breadcrumbController" class="cr.prodigious.aem.breadcrumb.controller.BreadcrumbController"></jsp:useBean>
<c:set var="links" value="<%= breadcrumbController.getBreadcrumb(currentPage) %>" />
<ul>
	<c:forEach var="link" items="${links}">
		<li>
			<a href="${link.link}.html">${link.title}</a>
		</li>	
	</c:forEach>
</ul>