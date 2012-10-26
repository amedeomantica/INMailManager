package com.insigno.inmailmanager.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;

import er.extensions.appserver.ERXResponseRewriter;
import er.extensions.components.ERXComponent;
import er.extensions.web.ERStyleSheet;

public class INMailManagerCompoment extends ERXComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4115308549390471686L;
	
	protected String pageWrapperName;
	private NSArray<ERStyleSheet> _additionalStylesheets;
	
	public INMailManagerCompoment(WOContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void appendToResponse(WOResponse response, WOContext context) {
		
		if(_additionalStylesheets!=null) {
			for(ERStyleSheet stylesheet : _additionalStylesheets) {
				ERXResponseRewriter.addStylesheetResourceInHead(
						response,
						context,
						(String)stylesheet.frameworkName(),
						(String)stylesheet.fileName(),
						(String)stylesheet.mediaType()
						);
			}
		}
		
		super.appendToResponse(response, context);
	}

	
	
	
	
	public String getPageWrapperName() {
		if(pageWrapperName==null) {
			pageWrapperName = INMailManagerDefaultPageWrapper.class.getName();
		}
		return pageWrapperName;
	}

	public void setPageWrapperName(String pageWrapper) {
		this.pageWrapperName = pageWrapper;
	}


	public void setAdditionalStylesheets(
			NSArray<ERStyleSheet> additionalStylesheets) {
		this._additionalStylesheets = additionalStylesheets;
	}
	

}
