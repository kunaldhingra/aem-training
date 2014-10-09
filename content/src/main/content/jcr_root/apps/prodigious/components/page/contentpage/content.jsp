<%@include file="/apps/prodigious/components/global.jsp" %>

<c:set var="isEditMode" value="<%= (WCMMode.fromRequest(request) == WCMMode.EDIT || WCMMode.fromRequest(request) == WCMMode.DESIGN) %>" />

<c:if test="${!isEditMode}">
	<% IncludeOptions.getOptions(request, true).setDecorationTagName(StringUtils.EMPTY);  %>
</c:if>


		<div class="template article-template">
			<div class="container-fluid">
				<div class="span12">
					<c:if test="${!isEditMode}">
						<% IncludeOptions.getOptions(request, true).setDecorationTagName(StringUtils.EMPTY);  %>
					</c:if>
					<cq:include path="breadcrumb" resourceType="/apps/aetna/components/global/content/breadcrumb"/>
				</div>	
				
				<cq:include path="content" resourceType="/libs/foundation/components/parsys"/>
			</div><!--/.container-fluid-->
			
			<div class="container-fluid">
	<div class="row-fluid quicklinks">
		<div class="span10">
			<!--include member quick links-->
			<span class="quicklinks-title">Quick Links</span>
			<div class="visible-phone openClose">
				<div class="span2 seeAll"><div class="member-links"><a href="#" class="quicklinksAll">See All<span class="member-expand"></span></a> </div></div>
				<div class="span2 close"><div class="member-links"><a href="#" class="quicklinksAll">Close<span class="member-close"></span></a> </div></div>
			</div>
			<span class="quicklinks-explantion">Connecting you to what you need</span>

		</div> <!-- .span10 -->
	</div> <!-- .quicklinks -->
	<div class="row-fluid quicklinksExpand">
		<ul class="span3 borderRight">
			<li class="lock"><a href="https://member.aetna.com/appConfig/login/login.fcc?TYPE=33554433&REALMOID=06-36d8cb4d-4ac1-44c7-b12d-a80fba4b718e&GUID=&SMAUTHREASON=0&METHOD=GET&SMAGENTNAME=-SM-jRs63Nsa3LlO0w8DBRJePrGDb%2fSrW4lCcEp3BCF2N5CYudNJWAZ6IAjtTBQZYxKV&TARGET=-SM-HTTPS%3a%2f%2fmember%2eaetna%2ecom%2fMbrLanding%2fRoutingServlet%3fcreateSession%3dtrue%26navDeepLink%3dDOCFINDDEEPLINK">Find a Doctor, Pharmacy or Facility</a></li>
			<li class="lock"><a href="https://member.aetna.com/appConfig/login/login.fcc?TYPE=33554433&REALMOID=06-36d8cb4d-4ac1-44c7-b12d-a80fba4b718e&GUID=&SMAUTHREASON=0&METHOD=GET&SMAGENTNAME=-SM-jRs63Nsa3LlO0w8DBRJePrGDb%2fSrW4lCcEp3BCF2N5CYudNJWAZ6IAjtTBQZYxKV&TARGET=-SM-HTTPS%3a%2f%2fmember%2eaetna%2ecom%2fMbrLanding%2fRoutingServlet%3fcreateSession%3dtrue%26custNumSel%3dA%26serviceName%3dhome%26navDeepLink%3dviewClaimsLNK">View Claim Status</a></li>
		</ul>
		<ul class="span3 borderRight noTabletBorder">
			<li class="lock"><a href="https://member.aetna.com/appConfig/login/login.fcc?TYPE=33554433&REALMOID=06-36d8cb4d-4ac1-44c7-b12d-a80fba4b718e&GUID=&SMAUTHREASON=0&METHOD=GET&SMAGENTNAME=-SM-jRs63Nsa3LlO0w8DBRJePrGDb%2fSrW4lCcEp3BCF2N5CYudNJWAZ6IAjtTBQZYxKV&TARGET=-SM-HTTPS%3a%2f%2fmember%2eaetna%2ecom%2fMbrLanding%2fRoutingServlet%3fcreateSession%3dtrue%26custNumSel%3dA%26serviceName%3dhome%26navDeepLink%3dBENEFITSUMMARYLNK">View Coverage &amp; Benefits</a></li>
			<li class="lock"><a href="http://www.aetna.com/individuals-families-health-insurance/buy-insurance/myself-family/pay-premium.html">Pay a Premium with Easy Pay</a></li>
		</ul>
		<ul class="span3 borderRight">
			<li class="lock"><a href="https://member.aetna.com/appConfig/login/login.fcc?TYPE=33554433&REALMOID=06-36d8cb4d-4ac1-44c7-b12d-a80fba4b718e&GUID=&SMAUTHREASON=0&METHOD=GET&SMAGENTNAME=-SM-jRs63Nsa3LlO0w8DBRJePrGDb%2fSrW4lCcEp3BCF2N5CYudNJWAZ6IAjtTBQZYxKV&TARGET=-SM-HTTPS%3a%2f%2fmember%2eaetna%2ecom%2fMbrLanding%2fRoutingServlet%3fcreateSession%3dtrue%26custNumSel%3dA%26serviceName%3dhome%26navDeepLink%3didCardLNK">Get an ID Card</a></li>
			<li><a href="https://pbm.aetna.com/wps/portal/FRAMED_UNAUTH_MEDICATION_SEARCH_TOOL?businessSectorCode=CM">View Preferred Drug List</a></li>
		</ul>
		<ul class="span3">
			<li><a href="http://www.aetna.com/healthcare-professionals/policies-guidelines/clinical_policy_bulletins.html">Search Clinical Policy Bulletins</a></li>
			<li><a href="http://www.aetna.com/individuals-families-health-insurance/document-library/find-document-form.html">Find Forms</a></li>
		</ul>
	</div><!--/.quicklinksExpand-->
</div><!--/.container-fluid-->		

</div><!--end .template-->
