<%@page import="com.sun.org.apache.xalan.internal.xsltc.compiler.sym"%>
<%@page import="com.nec.information.portal.model.DemoTopic"%>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<%@ include file="../init.jsp"%>

<%
    ResultRow row = (ResultRow) request
            .getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	DemoTopic l_topic = (DemoTopic) row.getObject();

	long l_topicID = l_topic.getTopicId();

    String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu>
    <portlet:renderURL var="editURL">
        <portlet:param name="mvcPath" value="/html/demo/edit_topic.jsp" />
        <portlet:param name="topicId" value="<%= String.valueOf(l_topicID) %>" />
        <portlet:param name="redirect" value="<%= redirect %>" />
    </portlet:renderURL>

    <liferay-ui:icon image="edit" url="<%= editURL.toString() %>" />

    <portlet:actionURL name="deleteTopic" var="deleteTopicURL">
        <portlet:param name="topicId" value="<%= String.valueOf(l_topicID) %>" />
        <portlet:param name="redirect" value="<%= redirect %>" />
    </portlet:actionURL>

    <liferay-ui:icon-delete url="<%= deleteTopicURL.toString() %>" />
</liferay-ui:icon-menu>