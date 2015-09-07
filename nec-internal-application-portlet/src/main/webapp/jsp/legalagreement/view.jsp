<%@page import="com.liferay.portal.model.RoleConstants"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="com.nec.information.portal.legal.controller.LegalAgreementActions"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.nec.information.portal.model.LegalAgreement"%>
<%@page import="com.nec.information.portal.service.LegalAgreementLocalServiceUtil"%>

<%@ include file="../init.jsp"%>
<%
String redirect = PortalUtil.getCurrentURL(renderRequest);
Set<String> userRoles =null;

userRoles = new HashSet<String>();
for(Role role : themeDisplay.getUser().getRoles()){
	   userRoles.add(role.getName());
}

	boolean addLegalAgreements = themeDisplay.getPermissionChecker().hasPermission(themeDisplay.getScopeGroupId(), "com.nec.information.portal.LegalAgreements", themeDisplay.getPortletDisplay().getResourcePK(), "ADD_LEGAL_AGREEMENT");
%>



<liferay-ui:header title="Legal Agreements Portal"/>

			
 		<!-- Add Legal Agreement Button  -->
			    <portlet:renderURL var="addLegalAgreementUrl">
			        <portlet:param name="mvcPath" value="/jsp/addLegalAgreement.jsp" />
			        <portlet:param name="redirect" value="<%= redirect %>" />
			    </portlet:renderURL>
			    <%
			    
			    if(addLegalAgreements){ %>
			    <aui:button onClick="<%= addLegalAgreementUrl.toString() %>" value="add_legal_agreement" />
			    <%} %>
	<legend>Agreements needed acceptance</legend>
	<!-- <div id="statusDataTable"></div> -->
	
	
	
	<liferay-ui:search-container emptyResultsMessage="no_list_to_display" >
	<liferay-ui:search-container-results 
		results="<%=LegalAgreementLocalServiceUtil.findByTargetUserIdAndagreementStatus(themeDisplay.getUser().getUserId(), LegalAgreementActions.NEW.toString())%>"
		total="<%= LegalAgreementLocalServiceUtil.findByTargetUserIdAndagreementStatus(themeDisplay.getUser().getUserId(), LegalAgreementActions.NEW.toString()).size()%>" />

	<liferay-ui:search-container-row
        className="com.nec.information.portal.model.LegalAgreement"
        keyProperty="agreementId"
        modelVar="agreement" escapedModel="<%= true %>">
	
	
		<%
			String fileUrl = agreement.getFileUrl() == null ? "" : agreement.getFileUrl();
		%>
		
		<liferay-ui:search-container-column-text  name="Download">
			<aui:a href="<%=fileUrl%>" target="_blank">Download</aui:a>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text  name="Agreement Name" value="<%= agreement.getName() %>"/>
		
		<liferay-ui:search-container-column-text  name="License Validity" value="<%= agreement.getDueDate().toLocaleString() %>"/>
		
		<liferay-ui:search-container-column-text  name="Description" value="<%= agreement.getDescription() %>"/>
		
		<liferay-ui:search-container-column-text  name="Accept Or Reject">
			<!-- Add Accept Button  -->
			    <portlet:actionURL var="acceptURL" name="acceptAgreement">
			        <portlet:param name="redirect" value="<%= redirect %>" />
			        <portlet:param name="agreementId" value="<%=Long.toString(agreement.getAgreementId())%>" />
			        <portlet:param name="agreementStatus" value="<%=LegalAgreementActions.ACCEPT%>" />
			        <portlet:param name="docAddedBy" value="<%=Long.toString(agreement.getCreatedBy())%>" />
			    </portlet:actionURL>
			
			    <aui:button onClick="<%= acceptURL.toString() %>" value="accept-agreement" />
			    
			    <!-- Add Accept Button  -->
			    <portlet:actionURL var="rejectURL" name="acceptAgreement">
			        <portlet:param name="redirect" value="<%= redirect %>" />
			        <portlet:param name="agreementId" value="<%=Long.toString(agreement.getAgreementId())%>" />
			        <portlet:param name="agreementStatus" value="<%=LegalAgreementActions.REJECT%>" />	
			        <portlet:param name="docAddedBy" value="<%=Long.toString(agreement.getCreatedBy())%>" />		        
			    </portlet:actionURL>
			
			    <aui:button onClick="<%= rejectURL.toString() %>" value="reject-agreement" />
			    
			    
		</liferay-ui:search-container-column-text>	
	
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
	
   </liferay-ui:search-container>
    
	
	
	<legend>Agreements you accepted already</legend>
	<!-- <div id="legalAgreementDataTable"></div> -->
	
	
	<liferay-ui:search-container emptyResultsMessage="no_list_to_display" >
	<liferay-ui:search-container-results
		results="<%=LegalAgreementLocalServiceUtil.findByTargetUserIdAndagreementStatus(user.getUserId(), LegalAgreementActions.ACCEPT.toString())%>"
		total="<%= LegalAgreementLocalServiceUtil.findByTargetUserIdAndagreementStatus(user.getUserId(), LegalAgreementActions.ACCEPT.toString()).size()%>" />

	<liferay-ui:search-container-row
        className="com.nec.information.portal.model.LegalAgreement"
        keyProperty="agreementId"
        modelVar="agreement" escapedModel="<%= true %>">
	
		
		<liferay-ui:search-container-column-text  name="Agreement Name" value="<%= agreement.getName() %>"/>
		
		<liferay-ui:search-container-column-text  name="License Validity" value="<%= agreement.getDueDate().toLocaleString() %>"/>
		
		<liferay-ui:search-container-column-text  name="Description" value="<%= agreement.getDescription() %>"/>
		
		<%
			String fileUrl = agreement.getFileUrl() == null ? "" : agreement.getFileUrl(); 
		%>
		<liferay-ui:search-container-column-text name="Download">
			<aui:a href="<%=fileUrl%>" target="_blank">Download</aui:a>
		</liferay-ui:search-container-column-text>
			
	
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
	
   </liferay-ui:search-container>
	