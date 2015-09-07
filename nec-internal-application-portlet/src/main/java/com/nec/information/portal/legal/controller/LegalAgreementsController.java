package com.nec.information.portal.legal.controller;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderServiceUtil;
import com.liferay.util.mail.MailEngine;
import com.liferay.util.mail.MailEngineException;
import com.nec.information.portal.legal.notifications.LegalAgreementUserNotificationHandler;
import com.nec.information.portal.model.LegalAgreement;
import com.nec.information.portal.service.LegalAgreementLocalServiceUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;


@Controller
@RequestMapping("VIEW")
public class LegalAgreementsController {
	
	
	Date now = new Date();
	
	Log logger = LogFactoryUtil.getLog(LegalAgreementsController.class);
	
	
	@RenderMapping
	public String handleRenderAction(RenderRequest renderRequest, RenderResponse renderResponce){
		return "view";
	}
	
	
	
	@ActionMapping
	public void addLegalAgreement(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException, ParseException {
		try {
	           logger.info("Strating to upload");
	           ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	           ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
	           	UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
	           	String name = uploadRequest.getParameter("inputName");
				String description = uploadRequest.getParameter("inputDescription");
				String agreementFile = uploadRequest.getParameter("inputAgreementFile");
				String dueDate = uploadRequest.getParameter("dueDate");
	           
	          

	       if (uploadRequest.getSize("fileName")==0) {
	           SessionErrors.add(actionRequest, "error");
	       }   
	           	// Adding file into Document and Library folder - LIFERAY_AGREEMENT
	       	   String sourceFileName = uploadRequest.getFileName("fileName");
	       	   sourceFileName = sourceFileName + Calendar.getInstance().getTimeInMillis(); 
	       	   File file =  uploadRequest.getFile("fileName");
	           String contentType = MimeTypesUtil.getContentType(file);
	           InputStream inputStream  = new FileInputStream(file);
	           DLFolder dlFolder = DLFolderServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, "LEGAL_AGREEMENT");
	           long folderId = dlFolder.getFolderId();
	           long repositoryId = dlFolder.getRepositoryId();
	           
	           FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), 
                       repositoryId, 
                       folderId, 
                       file.getName(), 
                       contentType, 
                       name, 
                       sourceFileName, 
                       "changeLog", 
                       inputStream, 
                       file.length(), 
                       serviceContext);
	           if(fileEntry!=null){
	        	   String fileEntryUrl = "/documents/"+themeDisplay.getScopeGroupId()+"/"+fileEntry.getFolderId()+"/"+fileEntry.getTitle()+"/"+fileEntry.getUuid();
					
					String notificationText = ParamUtil.getString(actionRequest,"notifciationText","sample");

					
					/*
					 * send legal agreement to all users belong to CHANNEL_PARTNER_USER_GROUP
					 */
					
					
					long group_id =  UserGroupLocalServiceUtil.fetchUserGroup(themeDisplay.getCompanyId(), "CHANNEL_PARTNER_USER_GROUP").getUserGroupId();
					List<User> channelPartnerUsers =  UserLocalServiceUtil.getUserGroupUsers(group_id);			
					//logger.info("themeDisplay.getCompanyId()" + themeDisplay.getCompanyId() +  " CHANNEL_PARTNER_USER_GROUP " + group_id);
					
					if(group_id>0){
						 for (Iterator iterator = channelPartnerUsers.iterator(); iterator.hasNext();) 
						 {							 
							User channelPartner = (User) iterator.next();
					
							LegalAgreement legalAgreement = LegalAgreementLocalServiceUtil.createLegalAgreement(CounterLocalServiceUtil.increment(LegalAgreement.class.getName()));
							legalAgreement.setName(name);
							legalAgreement.setDescription(description);
							
							legalAgreement.setAttachmentDocumentId(Long.toString(fileEntry.getFileEntryId()));
							legalAgreement.setFileUrl(fileEntryUrl);
							legalAgreement.setCreatedBy(serviceContext.getUserId());
							legalAgreement.setLastModifiedBy(serviceContext.getUserId());
							
							
							legalAgreement.setCreatedDate(serviceContext.getCreateDate(now));
							legalAgreement.setModifiedDate(serviceContext.getCreateDate(now));
							
							SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
						    //Converting the String back to java.util.Date
						    legalAgreement.setDueDate(sm.parse(dueDate));
							
							legalAgreement.setTargetUserId(channelPartner.getUserId());
							legalAgreement.setAgreementStatus(LegalAgreementActions.NEW.toString());
							
							LegalAgreementLocalServiceUtil.updateLegalAgreement(legalAgreement);
							
							//logger.info("saved details"+name+dueDate);
							/*
							 *Send notification from admin to  Targer user group 	
							 */	
									JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
									payloadJSON.put("userId", channelPartner.getUserId());
									payloadJSON.put("notificationText", "Legal agreement document " + legalAgreement.getName()  +"("+ legalAgreement.getDescription()+") is assigned to you, please review it.");
									UserNotificationEventLocalServiceUtil.addUserNotificationEvent(
											channelPartner.getUserId(),
											LegalAgreementUserNotificationHandler.PORTLET_ID,
											(new Date()).getTime(), themeDisplay.getUserId(),
											payloadJSON.toString(), false, serviceContext);
							
							
						}
					}
	           }
	           
	           

	       }catch (FileNotFoundException e) {
	    	   logger.error("File Not Found.",e);
	           
	           SessionMessages.add(actionRequest, "error");
	       }catch (NullPointerException e) {
	    	   logger.error("Null pointer exception",e);
	           e.printStackTrace();
	           SessionMessages.add(actionRequest, "error");
	       }catch (IOException e1) {
	    	   logger.error("Error Reading The File.",e1);
	           SessionMessages.add(actionRequest, "error");
	           
	       }catch (SystemException e){
	    	    logger.error(e);
	       }catch (PortalException e){
				logger.error(e);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}				
		
	}
	@ActionMapping
	public void acceptAgreement(ActionRequest p_actionRequest,
			ActionResponse p_actionResponse) throws IOException, PortletException, PortalException, SystemException {
	
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(p_actionRequest);
		
		String l_agreementStatus =  uploadRequest.getParameter("agreementStatus");
		updateAgreementStatus(p_actionRequest, l_agreementStatus);			
		
	}
	
	
	
	
	public void updateAgreementStatus(ActionRequest p_actionRequest,
			String p_action) throws IOException, PortletException, PortalException, SystemException {
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(p_actionRequest);
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(p_actionRequest);
		
		 long l_agreementId = new Long(uploadRequest.getParameter("agreementId")).longValue();
		 LegalAgreement l_agreement = LegalAgreementLocalServiceUtil.getLegalAgreement(l_agreementId);
		 l_agreement.setAgreementStatus(p_action);
		 
		 l_agreement.setModifiedDate(serviceContext.getModifiedDate(now));
		 
		 /*
			 *Send notification from admin to  Targer user 	
			 */
		 
		 	ThemeDisplay themeDisplay = (ThemeDisplay) p_actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	        long docAddedBy = new Long(uploadRequest.getParameter("docAddedBy"));
	        
	        User currentUser = themeDisplay.getUser();
	        
			JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
			payloadJSON.put("userId", docAddedBy);
			payloadJSON.put("notificationText", "Legal agreement document is "+ p_action +"d by " + currentUser.getFullName());
			UserNotificationEventLocalServiceUtil.addUserNotificationEvent(
					docAddedBy,
					LegalAgreementUserNotificationHandler.PORTLET_ID,
					(new Date()).getTime(), themeDisplay.getUserId(),
					payloadJSON.toString(), false, serviceContext);
			
			/*
		     * Email
		     */
		    
			User emailDocAddedBy =   UserLocalServiceUtil.getUser(docAddedBy);
		    
		    try {
				MailEngine.send(currentUser.getEmailAddress() ,
								emailDocAddedBy.getEmailAddress(), 
								"NEC Informations Portal Legal agreement ", 
								"Legal agreement document is "+ p_action +"d by " + currentUser.getFullName());
			} catch (MailEngineException e) {
				e.printStackTrace();
			}
		    
		 LegalAgreementLocalServiceUtil.updateLegalAgreement(l_agreement);
		
	}
	
	
	

}
