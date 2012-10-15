package com.insigno.inmailmanager.components;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXComponent;

public class INMailManagerCompoment extends ERXComponent {

	protected String pageWrapperName;
	
	public INMailManagerCompoment(WOContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4115308549390471686L;
	
	
	
	public String getPageWrapperName() {
		if(pageWrapperName==null) {
			pageWrapperName = INMailManagerDefaultPageWrapper.class.getName();
		}
		return pageWrapperName;
	}

	public void setPageWrapperName(String pageWrapper) {
		this.pageWrapperName = pageWrapper;
	}
	

}
