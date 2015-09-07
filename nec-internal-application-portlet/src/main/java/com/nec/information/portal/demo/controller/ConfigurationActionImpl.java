package com.nec.information.portal.demo.controller;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class ConfigurationActionImpl implements ConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponce) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("landed on ConfigurationActionImpl");
		//Fetching the action
				String cmd = ParamUtil.getString(actionRequest, Constants.CMD); 
				
				//If no action is made on configuration.jsp return
				//That is when you are clicking the configuration link it will show configuration.jsp
				//page
				if (!cmd.equals(Constants.UPDATE)) { 
					return; 
				} 
				
				boolean checkForYes101 = ParamUtil.getBoolean(actionRequest, "checkForYes101");
				System.out.println("ConfigurationActionImpl---" + checkForYes101 );
				//Getting the PortletResource
				String portletResource = ParamUtil.getString(actionRequest, "portletResource"); 

				//Creating the Reference for Portletpreferences Table
				PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource); 
				
				//Setting The Boolean Values in the PortletPreferences table
				prefs.setValue("checkForYes101", String.valueOf(checkForYes101)); 
				
				if (SessionErrors.isEmpty(actionRequest)) { 
					prefs.store(); 

					SessionMessages.add( 
						actionRequest, portletConfig.getPortletName() + ".doConfigure"); 
				} 

	}

	@Override
	public String render(PortletConfig arg0, RenderRequest arg1,
			RenderResponse arg2) throws Exception {
		// TODO Auto-generated method stub
		return "/html/demo/subscribeDemo.jsp"; 
	}

}
