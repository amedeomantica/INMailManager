package com.insigno.inmailmanager.components;


import com.insigno.inmailmanager.model.INLocalizedMailTemplate;
import com.insigno.inmailmanager.model.INMailTemplate;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.appserver.ERXDisplayGroup;
import er.extensions.appserver.ERXResponseRewriter;
import er.extensions.eof.ERXEC;

public class INMailTemplatesList extends INMailManagerCompoment {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5298438147449717908L;
	public INMailTemplate aTemplate;
	public ERXDisplayGroup<INMailTemplate> templatesDisplayGroup;
	
	public INLocalizedMailTemplate aLocalizedTemplate;
	
	private EOEditingContext _ec;
	
    public INMailTemplatesList(WOContext context) {
        super(context);
        
        templatesDisplayGroup = new ERXDisplayGroup<INMailTemplate>();
        templatesDisplayGroup.setNumberOfObjectsPerBatch(10);
    }
    
    @Override
    public void appendToResponse(WOResponse response, WOContext context) {
    	templatesDisplayGroup.setObjectArray(INMailTemplate.fetchAllINMailTemplates(ec()));
    	super.appendToResponse(response, context);
		ERXResponseRewriter.addStylesheetResourceInHead(response, context, "INMailManager", "style/stylesheets/MailTemplatesList.css");
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
    
	public WOActionResults createTemplate() {
		
		INMailTemplate newTemplate = (INMailTemplate) EOUtilities.createAndInsertInstance(ec(), INMailTemplate.ENTITY_NAME);
		
		INMailTemplateEditPage nextPage = pageWithName(INMailTemplateEditPage.class);
		nextPage.setTheMailTemplate(newTemplate);
		nextPage.setPageWrapperName(this.getPageWrapperName());
		
		return nextPage;
	}
	
	public WOActionResults editMailTemplate() {
				
		INMailTemplateEditPage nextPage = pageWithName(INMailTemplateEditPage.class);
		nextPage.setTheMailTemplate(aTemplate);
		nextPage.setPageWrapperName(this.getPageWrapperName());
		
		return nextPage;
	}
	
	public WOActionResults editLocalizedTemplate() {
		INLocalizedMailTemplateEditPage nextPage = pageWithName(INLocalizedMailTemplateEditPage.class);
		nextPage.setTheMailLocalizedTemplate(aLocalizedTemplate);
		nextPage.setPageWrapperName(this.getPageWrapperName());
		return nextPage;
	}
	
	public WOActionResults addLocalizedTemplate() {
		
		INLocalizedMailTemplate newLocalizedTemplate = aTemplate.createLocalizedTemplatesRelationship();
		
		INLocalizedMailTemplateEditPage nextPage = pageWithName(INLocalizedMailTemplateEditPage.class);
		nextPage.setTheMailLocalizedTemplate(newLocalizedTemplate);
		nextPage.setPageWrapperName(this.getPageWrapperName());
		return nextPage;
		
	}
	
    
}