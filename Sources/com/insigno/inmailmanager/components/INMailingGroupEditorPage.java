package com.insigno.inmailmanager.components;

import com.insigno.inmailmanager.INMailManagerController;
import com.insigno.inmailmanager.model.INMailGroup;
import com.insigno.inmailmanager.model.INMailRecipient;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.ajax.AjaxModalDialog;
import er.extensions.appserver.ERXResponseRewriter;
import er.extensions.eof.ERXEC;

public class INMailingGroupEditorPage extends INMailManagerCompoment {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1193908966581307738L;

	private EOEditingContext _ec;
	
	public INMailGroup aMailGroup, selectedMailGroup;
	public String newMailGroupName;
	
	public INMailRecipient aMailRecipient;
	public String newAddressesString, removingAddressesString;
	
	public INMailingGroupEditorPage(WOContext context) {
        super(context);
        _ec = ERXEC.newEditingContext();
        
        newMailGroupName = this.localizer().localizedStringForKey("New Group");
    }
	
	@Override
	public void appendToResponse(WOResponse response, WOContext context) {
		super.appendToResponse(response, context);
		ERXResponseRewriter.addStylesheetResourceInHead(response, context, "INMailManager", "style/stylesheets/MailGroupsEditor.css");
	}
    
    public NSArray<INMailGroup> mailGroups() {
    	return INMailManagerController.sharedInstance().allMailingGroups(_ec);
    }
    
    public WOActionResults selectMailGroup() {
    	selectedMailGroup = aMailGroup;
    	return context().page();
    }
    
    public String selectedClass() {
    	if(selectedMailGroup!=null) {
    		if(selectedMailGroup.equals(aMailGroup)) {
    			return "selected";
    		}
    	}
    	return "";
    }
    
    public String emailRowClass() {
    	return "";
    }
    
    public WOActionResults createMailGroup() {
    	selectedMailGroup = INMailManagerController.sharedInstance().createNewMailGroup(_ec, newMailGroupName);
    	return context().page();
    }
    
    public WOActionResults deleteMailGroup() {
    	INMailManagerController.sharedInstance().deleteMailGroup(_ec, selectedMailGroup);
    	selectedMailGroup = null;
    	closeDialog();
    	return null;
    }
    
    public WOActionResults updateMailGroup() {
    	_ec.saveChanges();
    	return null;
    }
    
    public WOActionResults addAddresses() {
    	INMailManagerController.sharedInstance().addAddressesToGroup(_ec, newAddressesString, selectedMailGroup);
    	newAddressesString = null;
    	return context().page();
    }
    
    public WOActionResults removeAddresses() {
    	INMailManagerController.sharedInstance().removeAddressesFromGroup(_ec, removingAddressesString, selectedMailGroup);
    	removingAddressesString = null;
    	return context().page();
    }
    
    public void closeDialog() {
    	AjaxModalDialog.close(this.context());
    }
    
    public boolean isMailGroupSelected() {
    	return selectedMailGroup != null;
    }
    
    public WOActionResults sendMail() {
    	return context().page();
    }
    
}