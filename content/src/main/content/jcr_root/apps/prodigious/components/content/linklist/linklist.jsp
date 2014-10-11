<%@include file="/apps/prodigious/components/global.jsp" %>
<c:set var="isEditMode" value="<%= (WCMMode.fromRequest(request) == WCMMode.EDIT || WCMMode.fromRequest(request) == WCMMode.DESIGN) %>" />
<c:choose>
	<c:when test="${not empty properties.links}">
		<ul>
			<c:forEach var="link" items="${properties.links}">
				<li>${link}</li>	
			</c:forEach>
		</ul>
	</c:when>
	<c:otherwise>
		<c:if test="${isEditMode}">
			Please configure link list component
		</c:if>
	</c:otherwise>
</c:choose>