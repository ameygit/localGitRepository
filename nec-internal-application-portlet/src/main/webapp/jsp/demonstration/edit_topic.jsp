<%@page import="com.nec.information.portal.service.DemoTopicLocalServiceUtil"%>
<%@page import="com.nec.information.portal.model.DemoTopic"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<%@ include file="../init.jsp"%>

<%
	DemoTopic l_topic = null;

    long topicId = ParamUtil.getLong(request, "topicId");
	
    if (topicId > 0) {
    	l_topic = DemoTopicLocalServiceUtil.getDemoTopic(topicId);
    }

    String redirect = ParamUtil.getString(request, "redirect");
%>




<aui:model-context bean="<%= l_topic %>" model="<%= DemoTopic.class %>" />
<portlet:renderURL var="viewTopicURL" />
<portlet:actionURL name='<%= l_topic == null ? "addTopic" : "updateTopic" %>' var="editTopicURL" windowState="normal" />

<!--  we print a header for our portlet, 
		either displaying the name of the existing topic 
		or displaying text to indicate that we’re populating a new topic’s fields-->

<liferay-ui:header
    backURL="<%= viewTopicURL %>"
    title='<%= (l_topic != null) ? l_topic.getTopic() : "New Topic" %>'
/>

<aui:form action="<%= editTopicURL %>" method="POST" name="fm">
    <aui:fieldset>
        <aui:input name="redirect" type="hidden" value="<%= redirect %>" />

        <aui:input name="topicId" type="hidden" value='<%= l_topic == null ? "" : l_topic.getTopicId() %>'/>

        <aui:input name="topic" label="Topic" required="true" />

        <aui:input name="description" label="Description"/>

        <aui:input name="estimatedTimeFrame" label="Estimated Time Frame" required="true"/>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" />
        <aui:button onClick="<%= viewTopicURL %>"  type="cancel" />
    </aui:button-row>
</aui:form>

<aui:script>

AUI().ready(
		  'aui-datepicker',
  function(A) {
    new A.DatePicker(
      {
        trigger: '#textInputDate',
        mask: '%d/%m/%y',        
        popover: {
          zIndex: 1
        },
        panes: 1
      }
    ).render('#divDateAndTime');
  }
);

</aui:script>