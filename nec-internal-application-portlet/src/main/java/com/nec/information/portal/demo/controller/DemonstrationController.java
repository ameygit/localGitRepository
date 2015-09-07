package com.nec.information.portal.demo.controller;



import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.mail.MailEngine;
import com.nec.information.portal.demo.notification.NotificationHandler;
import com.nec.information.portal.legal.controller.LegalAgreementsController;
import com.nec.information.portal.model.DemoSubcriptionLineItems;
import com.nec.information.portal.model.DemoSubscriptionAdditionalInfo;
import com.nec.information.portal.model.DemoTopic;
import com.nec.information.portal.service.DemoSubcriptionLineItemsLocalServiceUtil;
import com.nec.information.portal.service.DemoSubscriptionAdditionalInfoLocalServiceUtil;
import com.nec.information.portal.service.DemoTopicLocalServiceUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;


/// merged and test
@Controller
@RequestMapping("VIEW")
public class DemonstrationController {
	
	Date now = new Date();
	

	Log logger = LogFactoryUtil.getLog(DemonstrationController.class);
	
	
	@RenderMapping
	public String handleRenderAction(RenderRequest renderRequest, RenderResponse renderResponce){
		return "view";
	}

	
	@ActionMapping
	public void addTopic(ActionRequest request, ActionResponse response)
			throws Exception {

		_updateTopic(request);

		//sendRedirect(request, response);
	}
	
	@ActionMapping
	public void deleteTopic(ActionRequest request, ActionResponse response)
			throws Exception {

		long locationId = ParamUtil.getLong(request, "topicId");

		DemoTopicLocalServiceUtil.deleteDemoTopic(locationId);

		//sendRedirect(request, response);
	}
	
	@ActionMapping
	public void updateTopic(ActionRequest request, ActionResponse response)
			throws Exception {

		_updateTopic(request);

		//sendRedirect(request, response);
	}
	

	private DemoTopic _updateTopic(ActionRequest request)
			throws PortalException, SystemException {
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				DemoTopic.class.getName(), request);

		long l_topicId = ParamUtil.getLong(request, "topicId");
		String l_topicName = ParamUtil.getString(request, "topic");
		String l_description = ParamUtil.getString(request, "description");
		String l_estimatedTimeFrame = ParamUtil.getString(request,
				"estimatedTimeFrame");
		long l_userId = serviceContext.getUserId();

		DemoTopic l_topic = DemoTopicLocalServiceUtil.createDemoTopic(l_topicId);

		l_topic.setTopic(l_topicName);
		l_topic.setDescription(l_description);
		l_topic.setEstimatedTimeFrame(l_estimatedTimeFrame);
		l_topic.setCreatedBy(l_userId);
		l_topic.setLastModifiedBy(l_userId);
		l_topic.setCreatedDate(serviceContext.getCreateDate(now));
		l_topic.setModifiedDate(serviceContext.getModifiedDate(now));

		if (l_topicId <= 0) {
			l_topic = DemoTopicLocalServiceUtil.addTopic(l_topic);
		} else {
			l_topic = DemoTopicLocalServiceUtil.updateTopic(l_topic);
		}

		return l_topic;
	}

	/*
	 * SMB demostration subscription methods
	 */
	@ActionMapping
	public void subscribeToDemo(ActionRequest request, ActionResponse response)
			throws Exception {

		long lf_subscriptionId = ParamUtil.getLong(request, "subscriptionId");
		String lf_associateName = ParamUtil.getString(request, "associateName");
		String lf_prospectCompanyName = ParamUtil.getString(request,"prospectCompanyName");
		String lf_prefferedDate = ParamUtil.getString(request,"prefferedDate");
		/*String lf_prefferedTime = ParamUtil.getString(request,"prefferedTime");*/
		
		
		boolean atLeastOneIsSelected = false;
		
		if (lf_subscriptionId <= 0) {
			lf_subscriptionId = DemoSubcriptionLineItemsLocalServiceUtil
					.genereateSubscriptionId();
		}

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				DemonstrationController.class.getName(), request);

		List<DemoTopic> l_topicList = DemoTopicLocalServiceUtil.getDemoTopics(
				0, DemoTopicLocalServiceUtil.getDemoTopicsCount());

		if (l_topicList != null)

			for (Iterator<DemoTopic> iterator = l_topicList.iterator(); iterator
					.hasNext();) {
				DemoTopic l_demoTopic = (DemoTopic) iterator.next();

				/*
				 * Delete existing line items from table
				 */

				long lf_lineItemId = ParamUtil.getLong(request, "lineItemId"
						+ l_demoTopic.getTopicId());

				if (lf_lineItemId > 0) {
					DemoSubcriptionLineItemsLocalServiceUtil
							.deleteDemoSubcriptionLineItems(lf_lineItemId);
				}

				
				  /*Map <String , String[]> paramMap = request.getParameterMap();
				  
				 for (Map.Entry<String , String[]> entry :
				  paramMap.entrySet()) { String key = entry.getKey(); String
				  value[] = entry.getValue(); System.out.println("Key:		" + key
				  + "		Value:		" + value[0]); }*/
				 

				String lf_checkForYes = ParamUtil.getString(request,
						"checkForYes" + l_demoTopic.getTopicId());

				/* System.out.println("lf_checkForYes " + lf_checkForYes); */
				//System.out.println("prefferedDate " + ParamUtil.getString(request, "prefferedDate")); 
				
				if (lf_checkForYes.equals("true")) {
					atLeastOneIsSelected = true;
					DemoSubcriptionLineItems l_lineItem = new DemoSubcriptionLineItemsLocalServiceUtil().createDemoSubcriptionLineItems(DemoSubcriptionLineItemsLocalServiceUtil
							.genereateLineItemId());
					//l_lineItem.setId(DemoSubcriptionLineItemsLocalServiceUtil.genereateLineItemId());
					l_lineItem.setSubscriptionId(lf_subscriptionId);
					l_lineItem.setUserId(serviceContext.getUserId());
					l_lineItem.setTopicId(ParamUtil.getLong(request, "topicId"
							+ l_demoTopic.getTopicId()));
					l_lineItem.setDemoExpectAndQue(ParamUtil.getString(request,
							"expectationsAndQue" + l_demoTopic.getTopicId()));
					l_lineItem.setCreatedDate(serviceContext.getCreateDate(now));
					l_lineItem
							.setModifiedDate(serviceContext.getModifiedDate(now));
					l_lineItem.setCompleted(Boolean.toString(false));

					DemoSubcriptionLineItemsLocalServiceUtil
							.addLineItem(l_lineItem);
				}

			}

		/*
		 * First Delete demo subscription additonal information from Table
		 */

		DemoSubscriptionAdditionalInfoLocalServiceUtil
				.deleteInfo(lf_subscriptionId);

		/*
		 * insert new demo subscription additonal information into Table
		 */
		if(atLeastOneIsSelected)
		{
			DemoSubscriptionAdditionalInfo l_additionalInfo = DemoSubscriptionAdditionalInfoLocalServiceUtil.createDemoSubscriptionAdditionalInfo(DemoSubscriptionAdditionalInfoLocalServiceUtil
					.genereateLineItemId());
		
			l_additionalInfo.setSubscriptionId(lf_subscriptionId);
			l_additionalInfo.setAssociateName(lf_associateName);
			l_additionalInfo.setProspectCompanyName(lf_prospectCompanyName);
			SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
			l_additionalInfo.setPrefferedDateAndTime(sm.parse(lf_prefferedDate));
			DemoSubscriptionAdditionalInfoLocalServiceUtil.addInfo(l_additionalInfo);
			
			/*
			 * Send notification to Admin
			 */
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Role roleAdmin=RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.ADMINISTRATOR);
			System.out.println("Role ID " + roleAdmin.getRoleId());
			
			List<User> adminUserList = UserLocalServiceUtil.getRoleUsers(roleAdmin.getRoleId());
			
			for (Iterator iterator = adminUserList.iterator(); iterator.hasNext();) {
				
				User administrator = (User) iterator.next();
				
				JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
				payloadJSON.put("title", "Demo Request");
				payloadJSON.put("body", "User has subscribed for demonstration topics.");				
			    payloadJSON.put("additionalData", "Line items");
			    		
			    UserNotificationEventLocalServiceUtil.addUserNotificationEvent(administrator.getUserId(), 
			    		NotificationHandler.PORTLET_ID, 
					(new Date()).getTime(),
					themeDisplay.getUserId(),
					payloadJSON.toString(),
					false, serviceContext);	
			    /*
			     * Email
			     */
			    
			    
			    MailEngine.send("administrator@necam.com" ,
			    				administrator.getEmailAddress(), 
			    				"NEC Informations Portal Demo Request", 
			    				"User has subscribed for demonstration topics.");
			    
			    	
			}
			
			
			
				
		}
		
		//sendRedirect(request, response);
	}

	private static Log _log = LogFactoryUtil.getLog(DemonstrationController.class);


}
