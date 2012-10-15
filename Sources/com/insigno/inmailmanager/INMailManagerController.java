package com.insigno.inmailmanager;

import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import org.apache.log4j.Logger;

import sun.awt.im.InputMethodManager;

import com.insigno.inmailmanager.components.INMailWrapper;
import com.insigno.inmailmanager.model.INLocalizedMailTemplate;
import com.insigno.inmailmanager.model.INMailGroup;
import com.insigno.inmailmanager.model.INMailRecipient;
import com.insigno.inmailmanager.model.INMailTemplate;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOApplication;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORequest;
import com.webobjects.eoaccess.EOObjectNotAvailableException;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;

import er.extensions.eof.ERXEC;
import er.extensions.eof.ERXS;
import er.javamail.ERMailDeliveryHTML;
import er.javamail.ERMailUtils;

public class INMailManagerController {
	private static Logger log = Logger.getLogger(INMailManagerController.class);
	protected static INMailManagerController sharedInstance;
	
	
	public INMailManagerController() throws INMailManagerException {
		
		if (sharedInstance!=null) {
			throw new INMailManagerException("Only one instance of INMailManagerController is allowed, please use INMailManagerController.sharedInstance()");
		}
		
	}
	
	public static INMailManagerController sharedInstance() {
		if (sharedInstance==null) {
			try {
				sharedInstance = new INMailManagerController();
			} catch (INMailManagerException e) {
				e.printStackTrace();
			}
		}
		return sharedInstance;
	}
	
	public synchronized String wrappedEmailInTemplate(String htmlContent, String templateName, String language, WOContext context) throws INMailManagerException {
		
		EOEditingContext _ec = ERXEC.newEditingContext();
		
		if (context==null) {
			WORequest request = new WORequest("GET", "/fake", "HTTP/1.1", new NSMutableDictionary<String, List<String>>(), null, Collections.<String, Object>emptyMap());
			context = new WOContext(request);
		}
		
		INLocalizedMailTemplate mailTemplate = null;
		
		try {
			INMailTemplate t = INMailTemplate.fetchRequiredINMailTemplate(_ec, INMailTemplate.NAME_KEY, templateName);
			mailTemplate = t.getLocalizedTemplate(language);
			
			INMailWrapper emailPage =
					(INMailWrapper) WOApplication.application().pageWithName(INMailWrapper.class.getName(),
							(WOContext)context.clone()
					);
			
			emailPage.setMailTemplate(mailTemplate);
			emailPage.setHtmlContent(htmlContent);

			return emailPage.generateResponse().contentString();
		} catch (Exception e) {
			throw new INMailManagerException("Unable to wrap email in template");
		}
	}
	
	public NSArray<INMailGroup> allMailingGroups(EOEditingContext ec) {
		return INMailGroup.fetchAllINMailGroups(ec, ERXS.ascs(INMailGroup.NAME_KEY));
	}
	
	public INMailGroup createNewMailGroup(EOEditingContext ec, String name) {
		INMailGroup newGroup = (INMailGroup) EOUtilities.createAndInsertInstance(ec, INMailGroup.ENTITY_NAME);
		newGroup.setName(name);
		ec.saveChanges();
		return newGroup;
	}
	
	public void deleteMailGroup(EOEditingContext ec, INMailGroup group) {
		
		NSArray<INMailRecipient> groupRecipients = group.recipients();
		Enumeration<INMailRecipient> e = groupRecipients.objectEnumerator();
		while (e.hasMoreElements()) {
			INMailRecipient r = e.nextElement();
			group.removeFromRecipients(r);
			if(r.groups() == null || r.groups().count() == 0) {
				ec.deleteObject(r);
			}
		}
		ec.deleteObject(group);
		ec.saveChanges();
	}
	
	
    public void addAddressesToGroup(EOEditingContext ec, String addressesString, INMailGroup group) {
    	NSArray<String> addresses = ERMailUtils.emailsFromBulkList(addressesString);
    	Enumeration<String> e = addresses.objectEnumerator();
    	
    	while(e.hasMoreElements()) {
    		String anAddress = e.nextElement();
    		
    		try {
				INMailRecipient existingMailRecipient = (INMailRecipient) EOUtilities.objectMatchingKeyAndValue(ec, INMailRecipient.ENTITY_NAME, INMailRecipient.EMAIL_KEY, anAddress);
				group.addToRecipients(existingMailRecipient);
			} catch (EOUtilities.MoreThanOneException e1) {
				log.error("Duplicate recipient in INMailGroup table! Please check");
			} catch (EOObjectNotAvailableException e2) {
				INMailRecipient newRecupient =  (INMailRecipient) EOUtilities.createAndInsertInstance(ec, INMailRecipient.ENTITY_NAME);
	    		newRecupient.setEmail(anAddress);
	    		group.addToRecipients(newRecupient);
			}
    	}
    	
    	ec.saveChanges();
    }
    
    public void removeAddressesFromGroup(EOEditingContext ec, String addressesString, INMailGroup group) {
    	NSArray<String> addresses = ERMailUtils.emailsFromBulkList(addressesString);
    	Enumeration<String> e = addresses.objectEnumerator();
    	
    	while(e.hasMoreElements()) {
    		String anAddress = e.nextElement();
    	
    		INMailRecipient existingMailRecipient;
			try {
				existingMailRecipient = (INMailRecipient) EOUtilities.objectMatchingKeyAndValue(ec, INMailRecipient.ENTITY_NAME, INMailRecipient.EMAIL_KEY, anAddress);
				group.removeFromRecipients(existingMailRecipient);
		    	
		    	if(existingMailRecipient.groups() == null || existingMailRecipient.groups().count() == 0) {
		    		ec.deleteObject(existingMailRecipient);
		    	}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
    		
    	}
    	ec.saveChanges();
    }
    
	
	/*
	public synchronized void sendEmail(
			String senderName,
			String senderEmail,
			String subject,
			String htmlContent,
			INMailManagerRecipient recipient,
			String templateName,
			WOContext context)
	{
		
		sendEmail(senderName, senderEmail, subject, htmlContent, recipient, templateName, null);
		
	}
	
	public synchronized void sendEmail(
			String senderName,
			String senderEmail,
			String subject,
			String htmlContent,
			INMailManagerRecipient recipient,
			String templateName,
			WOContext context,
			NSDictionary<String, String> additionalHeaders
			)
	{
		
		EOEditingContext _ec = ERXEC.newEditingContext();
		
		INLocalizedMailTemplate mailTemplate = null;
		
		try {
			INMailTemplate t = INMailTemplate.fetchRequiredINMailTemplate(_ec, INMailTemplate.NAME_KEY, templateName);
			mailTemplate = t.getLocalizedTemplate(recipient.language());
			
			INMailWrapper emailPage =
					(INMailWrapper) WOApplication.application().pageWithName(INMailWrapper.class.getName(),
							(WOContext)context.clone()
					);
			
			emailPage.setMailTemplate(mailTemplate);
			emailPage.setHtmlContent(htmlContent);

			String finalHtmlResponse = emailPage.generateResponse().contentString();
			
			ERMailDeliveryHTML emailTo = new ERMailDeliveryHTML();
			
	    	emailTo.newMail();
	    	emailTo.setHTMLContent(finalHtmlResponse);
	    	emailTo.setCharset("UTF8");
	    	emailTo.setFromAddress(senderEmail);
	    	emailTo.setReplyToAddress(senderEmail);
	    	emailTo.setSubject(subject);
	    	emailTo.setToAddresses(new NSArray<String> (recipient.emailAddress()));
	    	emailTo.setAdditionalHeader("X-INMAILMANAGER", "YES");
	    	
	    	Enumeration<String> e = additionalHeaders.keyEnumerator();
	    	while (e.hasMoreElements()) {
	    		String key = e.nextElement();
	    		emailTo.setAdditionalHeader(key, (String)additionalHeaders.valueForKey(key));
	    	}
	    	
	    	emailTo.sendMail();

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}*/
	
}
