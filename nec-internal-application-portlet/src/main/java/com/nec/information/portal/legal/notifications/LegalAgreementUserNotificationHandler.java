package com.nec.information.portal.legal.notifications;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.UserNotificationEvent;
import com.liferay.portal.service.ServiceContext;

public class LegalAgreementUserNotificationHandler extends BaseUserNotificationHandler {
	public static final String PORTLET_ID = "legalagreements_WAR_legalagreementsportlet";

	public LegalAgreementUserNotificationHandler() {

		setPortletId(LegalAgreementUserNotificationHandler.PORTLET_ID);

	}
	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent,
			ServiceContext serviceContext) throws Exception {
		JSONObject jsonObject = JSONFactoryUtil
				.createJSONObject(userNotificationEvent.getPayload());
		//long userId = jsonObject.getLong("userId");
		String notificationText=jsonObject.getString("notificationText");
		String title = "<strong>Legal agreement waiting for approval</strong>";
		String body = StringUtil.replace(getBodyTemplate(), new String[] {
				"[$TITLE$]", "[$BODY_TEXT$]" },
				new String[] { title, notificationText });
		
		return body;
	}
	protected String getBodyTemplate() throws Exception {
		StringBundler sb = new StringBundler(5);
		sb.append("<div class=\"title\">[$TITLE$]</div><div ");
		sb.append("class=\"body\">[$BODY_TEXT$]</div>");
		return sb.toString();
	}
}