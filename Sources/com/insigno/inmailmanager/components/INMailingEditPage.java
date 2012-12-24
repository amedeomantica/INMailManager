package com.insigno.inmailmanager.components;

import com.insigno.inmailmanager.model.INMailing;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.appserver.ERXResponseRewriter;

public class INMailingEditPage extends INMailManagerCompoment {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5264620042005884352L;
	protected INMailing theMailing;
	
	private EOEditingContext _ec;
	
	private WOComponent previousPage;
	
    public INMailingEditPage(WOContext context) {
        super(context);
        previousPage = context().page();
    }
    
    @Override
    public void appendToResponse(WOResponse response, WOContext context) {
    	super.appendToResponse(response, context);
    	ERXResponseRewriter.addStylesheetResourceInHead(response, context, "INMailManager", "style/stylesheets/MailingEdit.css");
    }

    public WOActionResults saveMailing() {
    	_ec.saveChanges();
    	return previousPage();
    }
    
    public WOActionResults discard() {
    	_ec.revert();
    	return previousPage();
    }
        
    public WOComponent previousPage() {
    	previousPage.ensureAwakeInContext(context());
    	return previousPage;
    }
    
	public INMailing getTheMailing() {
		return theMailing;
	}

	public void setTheMailing(INMailing theMailing) {
		this.theMailing = theMailing;
		this._ec = theMailing.editingContext();
	}
}