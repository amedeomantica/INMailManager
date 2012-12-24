package com.insigno.inmailmanager.components;

import com.insigno.inmailmanager.model.INLocalizedMailing;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;

public class INLocalizedMailingEditPage extends INMailManagerCompoment {
    
	private INLocalizedMailing theLocalizedMailing;
	private EOEditingContext _ec;
	
	private WOComponent previousPage;
	
	public INLocalizedMailingEditPage(WOContext context) {
        super(context);
        previousPage = context().page();
    }

	
	public WOActionResults saveLocalizedMailing() {
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
	
	
	public INLocalizedMailing getTheLocalizedMailing() {
		return theLocalizedMailing;
	}

	public void setTheLocalizedMailing(INLocalizedMailing theLocalizedMailing) {
		this.theLocalizedMailing = theLocalizedMailing;
		this._ec = theLocalizedMailing.editingContext();
	}
}