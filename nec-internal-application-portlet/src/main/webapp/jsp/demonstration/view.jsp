<%@page import="com.liferay.portal.util.PortalUtil"%>

<%@ include file="../init.jsp"%>

<%
    String redirect = PortalUtil.getCurrentURL(renderRequest);
 	boolean isPermissionAddTopic = themeDisplay.getPermissionChecker().hasPermission(themeDisplay.getScopeGroupId(), "com.nec.information.portal.DemoRequests",  themeDisplay.getPortletDisplay().getResourcePK(), "ADD_TOPIC");
 	boolean viewSubscriptions = themeDisplay.getPermissionChecker().hasPermission(themeDisplay.getScopeGroupId(), "com.nec.information.portal.DemoRequests",  themeDisplay.getPortletDisplay().getResourcePK(), "VIEW_SUBSCRIPTIONS");

%>

<liferay-ui:header    
    title='SMB Demonstration'/>
<table>
	<tr>
		<td>
			
			    <!-- Add Topic Button  -->
			    <portlet:renderURL var="addTopicURL">
			        <portlet:param name="mvcPath" value="/html/demo/edit_topic.jsp" />
			        <portlet:param name="redirect" value="<%= redirect %>" />
			    </portlet:renderURL>
				<%
				
				if(isPermissionAddTopic){ %>
			    <aui:button onClick="<%= addTopicURL.toString() %>" value="add-topic" />
			    <%} %>
		</td>
		<td>	    
			    <!-- Subscribe to SMB Demo -->
			    <portlet:renderURL var="subscribeDemoURL">
			        <portlet:param name="mvcPath" value="/html/demo/subscribeDemo.jsp" />
			        <portlet:param name="redirect" value="<%= redirect %>" />
			    </portlet:renderURL>
				<%if(viewSubscriptions){ %>
			    <aui:button onClick="<%= subscribeDemoURL.toString() %>" value="sub-demo" />
			    <%} %>	    
		</td>	
	</tr>
</table>