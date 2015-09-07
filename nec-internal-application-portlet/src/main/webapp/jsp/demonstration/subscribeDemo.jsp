<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="com.liferay.portal.SystemException"%>
<%@page import="com.liferay.portal.PortalException"%>
<%@page import="com.liferay.portal.service.UserGroupRoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.UserGroupRole"%>
<%@page import="com.liferay.portal.model.RoleConstants"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.nec.information.portal.model.DemoSubscriptionAdditionalInfo"%>
<%@page import="com.nec.information.portal.service.DemoSubscriptionAdditionalInfoLocalServiceUtil"%>
<%@page import="com.liferay.util.portlet.PortletRequestUtil"%>
<%@page import="com.nec.information.portal.model.DemoSubcriptionLineItems"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.service.ServiceContextFactory"%>
<%@page import="com.liferay.portal.service.ServiceContext"%>
<%@page import="com.nec.information.portal.model.DemoSubcriptionLineItemsModel"%>
<%@page import="com.nec.information.portal.service.DemoSubcriptionLineItemsLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.nec.information.portal.service.DemoTopicLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>

<%@ include file="../init.jsp"%>


<%  String redirect = PortalUtil.getCurrentURL(renderRequest);	
	String l_topicId="topicId";
	String l_lineItemId="lineItemId";
	String l_checkForYes="checkForYes";
	String l_expectationsAndQue = "expectationsAndQue";
	String blankNo = "0";
	SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
	
	boolean l_defaultCheckForYes = false;
	long l_subscriptionId = 0;
	String l_expectAndQue=null;
	String l_associateName=null;
	String l_prospectCompanyName=null;
	String l_prefferedTime=null;
	String l_prefferedDate=null;
	
	Set<String> userRoles =null;
	try {
		 userRoles = new HashSet<String>();
	   for(Role role : themeDisplay.getUser().getRoles()){		  
		   userRoles.add(role.getName());
	   }	  
	}catch (SystemException e) {  
	      e.printStackTrace();  
	}  
		
%>

<portlet:renderURL var="viewTopicURL" />
<portlet:actionURL name="subscribeToDemo" var="subscribeToDemoURL" windowState="normal" />

<liferay-ui:header    
    title='SMB Demonstration Selection'/>
    
<aui:form action="<%=subscribeToDemoURL%>" method="POST" name="fm">

<aui:fieldset>
<liferay-ui:search-container emptyResultsMessage="no-selection-list-to-display" >
    <liferay-ui:search-container-results
        results="<%= DemoTopicLocalServiceUtil.getDemoTopics(0, DemoTopicLocalServiceUtil.getDemoTopicsCount()) %>"
        total="<%= DemoTopicLocalServiceUtil.getDemoTopicsCount() %>"
    />
	
    <liferay-ui:search-container-row
        className="com.nec.information.portal.model.DemoTopic"
        keyProperty="topicId"
        modelVar="topic" escapedModel="<%= true %>">
      
      <!-- Checking if user has already subscribed for demo topic -->
      <%			
	 	List<DemoSubcriptionLineItems> lineItem =  DemoSubcriptionLineItemsLocalServiceUtil
	 		.findByuserIdTopicIdAndCompleted(user.getUserId(), topic.getTopicId(), "false"); 
    		  
    		  
    	if(lineItem != null && lineItem.size()>0){
    		
    		l_subscriptionId =  lineItem.get(0).getSubscriptionId();
    		l_defaultCheckForYes =  true;
    		l_expectAndQue = lineItem.get(0).getDemoExpectAndQue();
    	}else {
    		l_subscriptionId =  0;
    		l_defaultCheckForYes =  false;
    		l_expectAndQue = null;
    		
    	}
    	
    	
    	List<DemoSubscriptionAdditionalInfo> l_additionaInfoLineItems = DemoSubscriptionAdditionalInfoLocalServiceUtil.findBysubscriptionId(l_subscriptionId);
    	
		if(l_additionaInfoLineItems != null && l_additionaInfoLineItems.size()>0){
    		
			l_associateName =  l_additionaInfoLineItems.get(0).getAssociateName();
    		l_prospectCompanyName = l_additionaInfoLineItems.get(0).getProspectCompanyName();
    		
    		l_prefferedDate = sm.format( l_additionaInfoLineItems.get(0).getPrefferedDateAndTime());
    		
    	}
	  %>
	  	<!-- Hidden filed to identify submit action for save or update -->
        <aui:input type="hidden" name="subscriptionId"  value="<%=l_subscriptionId %>" />
        <aui:input type="hidden" name="<%=l_topicId + topic.getTopicId()%>"  value="<%=topic.getTopicId()%>"/>
        <aui:input type="hidden" name="<%=l_lineItemId + topic.getTopicId()%>"  value="<%=( lineItem != null && lineItem.size()>0) ? lineItem.get(0).getId() : blankNo%>"/>
      
      	<!-- Table lines display every topic -->  
        <liferay-ui:search-container-column-text  name="Topic" value="<%= topic.getTopic() %>"/>
            
       
        <liferay-ui:search-container-column-text name="Check For Yes">
        	
        	<%
        	l_checkForYes = "checkForYes";
        	l_checkForYes =  l_checkForYes + topic.getTopicId();
        	
        	%>
        	<aui:input type="checkbox" id="<%=l_checkForYes%>"  name="<%=l_checkForYes%>"  label="" checked="<%=l_defaultCheckForYes%>" />
        	<%-- <liferay-ui:input-checkbox param="<%=l_checkForYes + topic.getTopicId()%>" defaultValue="<%=l_defaultCheckForYes%>"></liferay-ui:input-checkbox> --%>       
        </liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text 
            name="Estimated Timeframe" value="<%= topic.getEstimatedTimeFrame() %>"
        />
        
        <liferay-ui:search-container-column-text name="Describe Demo Expectations and provide prepared questions">
        	<aui:input type="textarea" name="<%= l_expectationsAndQue + topic.getTopicId() %>" 
        	label="" value="<%=l_expectAndQue%>" placeholder="type-here"/>
        </liferay-ui:search-container-column-text>
        
    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />
</liferay-ui:search-container>

	<%-- hidden filed to keep current page url --%>
	<aui:input type="hidden" name="redirect"  value="<%= redirect %>" />
	
	<!-- Additional information field -->
	
	<aui:input name="associateName" label="Associate Name" placeholder="type-here" value="<%=l_associateName%>"/>
	<aui:input name="prospectCompanyName" label="Prospect Company Name" placeholder="type-here" value="<%=l_prospectCompanyName%>"/>
	<label class="control-label" for="_SMBdemonstrationselectionlist_WAR_necSMBdemonstrationselectionportlet_prefferedDateAndTime"> Preffered Date and time </label>
	<!-- <input type="datetime-local" name="prefferedDate" id="prefferedDate"  placeholder="dd/mm/yy" /> -->
	
	<input class="input-large" id="prefferedDate" name="<portlet:namespace/>prefferedDate" value="<%=l_prefferedDate==null ?  (sm.format(Calendar.getInstance().getTime())) :  l_prefferedDate %>" type="text"/>
	<%-- <input class="input-medium" id="prefferedTime" name="<portlet:namespace/>prefferedTime" type="text"/> --%>
	
</aui:fieldset>

<aui:button-row>
	<aui:button type="submit" />
	<aui:button onClick="<%=viewTopicURL%>"  type="cancel" />
	<%
		if(userRoles!=null && userRoles.contains(RoleConstants.ADMINISTRATOR) )
		{
	%>
		<!-- Add Topic Button  -->
			    <portlet:renderURL var="addTopicURL">
			        <portlet:param name="mvcPath" value="/html/demo/edit_topic.jsp" />
			        <portlet:param name="redirect" value="<%= redirect %>" />
			    </portlet:renderURL>
			
			    <aui:button onClick="<%= addTopicURL.toString() %>" value="add-topic" />
			    
		<!-- View Subscribed Button  -->
			    <portlet:renderURL var="viewSubDemoURL">
			        <portlet:param name="mvcPath" value="/html/demo/viewSubscribedDemos.jsp" />
			        <portlet:param name="redirect" value="/html/demo/edit_topic.jsp" />
			    </portlet:renderURL>
			
			    <aui:button onClick="<%= viewSubDemoURL.toString() %>" value="view-topic" />
	<% }%>
</aui:button-row>

</aui:form>

