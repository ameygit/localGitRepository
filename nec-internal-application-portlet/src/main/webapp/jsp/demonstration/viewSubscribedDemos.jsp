<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.nec.information.portal.model.DemoTopic"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.nec.information.portal.model.DemoSubscriptionAdditionalInfo"%>
<%@page import="com.nec.information.portal.service.DemoSubscriptionAdditionalInfoLocalServiceUtil"%>
<%@page import="com.nec.information.portal.service.DemoTopicLocalServiceUtil"%>
<%@page import="com.nec.information.portal.service.DemoSubcriptionLineItemsLocalServiceUtil"%>
<%@page import="com.nec.information.portal.service.DemoSubcriptionLineItemsServiceUtil"%>

<%@ include file="../init.jsp"%>

<portlet:renderURL var="viewTopicURL" />

<liferay-ui:header
    backURL="<%= viewTopicURL %>"
    title="Subscribed demo list"/>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	String l_blank="";
%>

<liferay-ui:search-container emptyResultsMessage="no-subscription-for-demo" delta="10" iteratorURL="<%=portletURL%>"> 
	<liferay-ui:search-container-results 
	 	results="<%=DemoSubcriptionLineItemsLocalServiceUtil.
	 				getDemoSubcriptionLineItemses(0, 
	 												DemoSubcriptionLineItemsLocalServiceUtil.getDemoSubcriptionLineItemsesCount()
	 											)%>"
	 	total="<%=DemoSubcriptionLineItemsLocalServiceUtil.getDemoSubcriptionLineItemsesCount()%>" 
	/>
	
	<liferay-ui:search-container-row 
	className="com.nec.information.portal.model.DemoSubcriptionLineItems"
	escapedModel="<%= true %>"
	modelVar="lineItem"
	keyProperty="id"
	>	
		<%
		
		/* 
			Fetching User info from id
		*/
		User l_user = UserLocalServiceUtil.getUserById(lineItem.getUserId());
		/*
			Fetching Topic info form topic id		
		*/		
		DemoTopic l_topic = DemoTopicLocalServiceUtil.fetchDemoTopic(lineItem.getTopicId());
				
		/*  
			Fetching additional info
		*/
		
		java.util.List<com.nec.information.portal.model.DemoSubscriptionAdditionalInfo> l_additonalInfoList =  DemoSubscriptionAdditionalInfoLocalServiceUtil.findBysubscriptionId(lineItem.getSubscriptionId());
		DemoSubscriptionAdditionalInfo l_additionalInfo = null;
		if(l_additonalInfoList!=null && l_additonalInfoList.size()>0){
			
			l_additionalInfo = l_additonalInfoList.get(0);
		}
		
		/*
			Sorting Code
		*/
		
		
		%>
		
		<liferay-ui:search-container-column-text name="User" value="<%=l_user==null ? l_blank : l_user.getFullName()%>"/>
		<liferay-ui:search-container-column-text name="Email" value="<%=l_user==null ? l_blank : l_user.getEmailAddress()%>"/>
		<liferay-ui:search-container-column-text name="Topic" value="<%=l_topic==null ? l_blank : l_topic.getTopic() %>"/>
		<liferay-ui:search-container-column-text property="demoExpectAndQue" name= "Describe Demo Expectations and provide prepared questions" />
		<liferay-ui:search-container-column-text property="createdDate" name="Created Date" />
		
		
		<liferay-ui:search-container-column-text name="Associate Name" value="<%=l_additionalInfo==null ? l_blank : l_additionalInfo.getAssociateName()%>" />
		<liferay-ui:search-container-column-text name="Prospect Comany Name" value="<%=l_additionalInfo==null ? l_blank : l_additionalInfo.getProspectCompanyName()%>" />
		<liferay-ui:search-container-column-text name="Preffered Date And Time" value="<%=l_additionalInfo==null ? l_blank : l_additionalInfo.getPrefferedDateAndTime().toLocaleString()%>" />
					
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>