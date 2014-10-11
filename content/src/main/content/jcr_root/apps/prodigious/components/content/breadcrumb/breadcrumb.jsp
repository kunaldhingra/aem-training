<%@include file="/apps/prodigious/components/global.jsp" %>
<%@page import="cr.prodigious.aem.HelloService" %>
<jsp:useBean id="breadcrumbController" class="cr.prodigious.aem.breadcrumb.controller.BreadcrumbController">
	<jsp:setProperty name="breadcrumbController" property="helloService" value="<%= sling.getService(HelloService.class) %>" />
</jsp:useBean>
<c:set var="links" value="<%= breadcrumbController.getBreadcrumb(currentPage) %>" />
<h2>Current repository: ${breadcrumbController.actualRepository}</h2>
<ul>
	<c:forEach var="link" items="${links}">
		<li>
			<a href="${link.link}.html">${link.title}</a>
		</li>	
	</c:forEach>
</ul>