package com.insigno.inmailmanager.components;

import com.ibm.icu.impl.duration.impl.DataRecord.EDecimalHandling;
import com.insigno.inmailmanager.model.INLocalizedMailTemplate;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.appserver.ERXResponseRewriter;

public class INLocalizedMailTemplateEditPage extends INMailManagerCompoment {
	
	protected INLocalizedMailTemplate theMailLocalizedTemplate;
	
	private EOEditingContext _ec;
	
	private WOComponent previousPage;
	
    public INLocalizedMailTemplateEditPage(WOContext context) {
        super(context);
        previousPage = context().page();
    }
    
    @Override
    public void appendToResponse(WOResponse response, WOContext context) {
    	super.appendToResponse(response, context);
    	ERXResponseRewriter.addStylesheetResourceInHead(response, context, "INMailManager", "style/stylesheets/LocalizedMailTemplateEdit.css");
    }

    
    public WOActionResults saveLocalizedTemplate() {
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
    
	public INLocalizedMailTemplate getTheMailLocalizedTemplate() {
		return theMailLocalizedTemplate;
	}

	public void setTheMailLocalizedTemplate(INLocalizedMailTemplate newMailLocalizedTemplate) {
		
		this.theMailLocalizedTemplate = newMailLocalizedTemplate;
		this._ec = theMailLocalizedTemplate.editingContext();
	}
}