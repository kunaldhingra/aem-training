<%@include file="/apps/prodigious/components/global.jsp" %>
<c:set var="isEditMode" value="<%= (WCMMode.fromRequest(request) == WCMMode.EDIT || WCMMode.fromRequest(request) == WCMMode.DESIGN) %>" />
<c:choose>
	<c:when test="${not empty properties.type}">
		<c:choose>
			<c:when test="${properties.type == 'static'}">
				<h1>${properties.title}</h1>
			</c:when>
			<c:when test="${properties.type == 'dynamic'}">
				<h1>${currentPage.title}</h1>
			</c:when>
		</c:choose>
	</c:when>
	<c:otherwise>
		<c:if test="${isEditMode}">
			Please configure title component
		</c:if>
	</c:otherwise>
</c:choose>