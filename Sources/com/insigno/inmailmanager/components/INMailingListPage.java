package com.insigno.inmailmanager.components;

import com.insigno.inmailmanager.model.INLocalizedMailTemplate;
import com.insigno.inmailmanager.model.INLocalizedMailing;
import com.insigno.inmailmanager.model.INMailing;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.appserver.ERXDisplayGroup;
import er.extensions.appserver.ERXResponseRewriter;
import er.extensions.eof.ERXEC;

public class INMailingListPage extends INMailManagerCompoment {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -7877735834614072101L;
	
	private EOEditingContext _ec;
	
	public ERXDisplayGroup<INMailing> mailingDisplayGroup;
	public INMailing aMailing;
	public INLocalizedMailing aLocalizedMailing;
	
	public INMailingListPage(WOContext context) {
        super(context);
        
        mailingDisplayGroup = new ERXDisplayGroup<INMailing>();
        mailingDisplayGroup.setNumberOfObjectsPerBatch(10);
    }
	
    @Override
    public void appendToResponse(WOResponse response, WOContext context) {
    	mailingDisplayGroup.setObjectArray(INMailing.fetchAllINMailings(ec()));
    	super.appendToResponse(response, context);
		ERXResponseRewriter.addStylesheetResourceInHead(response, context, "INMailManager", "style/stylesheets/MailingList.css");
    }

    public WOActionResults createMailing() {
		
    	INMailing newMailing = (INMailing) EOUtilities.createAndInsertInstance(ec(), INMailing.ENTITY_NAME);
		
		INMailingEditPage nextPage = pageWithName(INMailingEditPage.class);
		nextPage.setTheMailing(newMailing);
		nextPage.setPageWrapperName(this.getPageWrapperName());
		
		return nextPage;
	}
	
	public WOActionResults editMailTemplate() {
				
		INMailingEditPage nextPage = pageWithName(INMailingEditPage.class);
		nextPage.setTheMailing(aMailing);
		nextPage.setPageWrapperName(this.getPageWrapperName());
		
		return nextPage;
	}
	
	public WOActionResults editLocalizedMailing() {
		INLocalizedMailingEditPage nextPage = pageWithName(INLocalizedMailingEditPage.class);
		nextPage.setTheLocalizedMailing(aLocalizedMailing);
		nextPage.setPageWrapperName(this.getPageWrapperName());
		return nextPage;
	}
	
	public WOActionResults addLocalizedMailing() {
		
		INLocalizedMailing newLocalizedMailing = aMailing.createLocalizedMailingsRelationship();
		
		INLocalizedMailingEditPage nextPage = pageWithName(INLocalizedMailingEditPage.class);
		nextPage.setTheLocalizedMailing(newLocalizedMailing);
		nextPage.setPageWrapperName(this.getPageWrapperName());
		return nextPage;
		
	}
    
    public EOEditingContext ec() {
		if(_ec == null) {
			_ec = ERXEC.newEditingContext();
		}
		return _ec;
	}

	public void setEditingContext(EOEditingContext _ec) {
		this._ec = _ec;
	}
    
    
}