package com.insigno.inmailmanager.components;

import sun.awt.im.InputMethodManager;

import com.insigno.inmailmanager.model.INMailTemplate;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.appserver.ERXResponseRewriter;
import er.extensions.components.ERXComponent;

public class INMailTemplateEditPage extends INMailManagerCompoment {
    
	protected INMailTemplate theMailTemplate;
	private EOEditingContext _ec;
	protected WOComponent previousPage;
	
	public INMailTemplateEditPage(WOContext context) {
        super(context);
        previousPage = context().page();
    }
	
	@Override
	public void appendToResponse(WOResponse response, WOContext context) {
		super.appendToResponse(response, context);
		ERXResponseRewriter.addStylesheetResourceInHead(response, context, "INMailManager", "style/stylesheets/MailTemplateEdit.css");
	}
	
	public WOActionResults saveMailTemplate() {
		_ec.saveChanges();
		return previousPage();
	}
	
	public WOActionResults discard() {
		_ec.revert();
		return previousPage();
	}
	
	protected WOComponent previousPage() {
		previousPage.ensureAwakeInContext(context());
		return previousPage;
	}

	public INMailTemplate getTheMailTemplate() {
		return theMailTemplate;
	}

	public void setTheMailTemplate(INMailTemplate newMailTemplate) {
		this.theMailTemplate = newMailTemplate;
		this._ec = theMailTemplate.editingContext();
	}
	
}