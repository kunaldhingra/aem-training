<%@include file="/apps/prodigious/components/global.jsp" %>
<c:set var="isEditMode" value="<%= (WCMMode.fromRequest(request) == WCMMode.EDIT || WCMMode.fromRequest(request) == WCMMode.DESIGN) %>" />
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>${currentPage.title}</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <cq:include script="/libs/wcm/core/components/init/init.jsp"/>
    <c:if test="${isEditMode}">
    	<cq:includeClientLib js="prodigious.customwidgets" />
    </c:if>
	<cq:includeClientLib css="prodigious.common" />
	<cq:includeClientLib js="prodigious.common" />
</head>