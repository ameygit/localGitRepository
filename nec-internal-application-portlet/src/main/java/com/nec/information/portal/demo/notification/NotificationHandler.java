package com.nec.information.portal.demo.notification;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.UserNotificationEvent;
import com.liferay.portal.service.ServiceContext;

public class NotificationHandler extends BaseUserNotificationHandler {

	public static final String PORTLET_ID = "DemoPorlet_WAR_DemoPorletportlet";
	
	public NotificationHandler() {
		setPortletId(PORTLET_ID);
	}
	
	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent,
			ServiceContext serviceContext) throws Exception {
		
		JSONObject jsonObject = JSONFactoryUtil
				.createJSONObject(userNotificationEvent.getPayload());
		
		String title = "<strong>Demo Request</strong>";
		String bodyText = jsonObject.getString("body");
		String body = StringUtil.replace(getBodyTemplate(), 
				new String[] { "[$TITLE$]", "[$BODY_TEXT$]" }, 
				new String[] { title, bodyText });
	
	return body;
	
	
	}
	
	protected String getBodyTemplate() throws Exception {
		StringBundler sb = new StringBundler(5);
		sb.append("<div class=\"title\">[$TITLE$]</div><div ");
		sb.append("class=\"body\">[$BODY_TEXT$]</div>");
		return sb.toString();
	}

}
