package com.insigno.inmailmanager.components;

import com.insigno.inmailmanager.model.INLocalizedMailTemplate;
import com.webobjects.appserver.WOContext;
import er.extensions.components.ERXComponent;

public class INMailWrapper extends ERXComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6637137431168235158L;
	private INLocalizedMailTemplate mailTemplate;
	private String htmlContent;
	
    public INMailWrapper(WOContext context) {
        super(context);
    }
    /*
    @Override
    public boolean synchronizesVariablesWithBindings() {
    	return false;
    }
    
    @Override
    public boolean isStateless() {
    	return true;
    }
    
    @Override
    public void reset() {
    	super.reset();
    	mailTemplate = null;
    	htmlContent = null;
    }
    
    protected INLocalizedMailTemplate mailTemplate() {
    	if(mailTemplate==null) {
    		if(canGetValueForBinding("mailTemplate")) {
    			mailTemplate = (INLocalizedMailTemplate) valueForBinding("mailTemplate");
    		}
    	}
    	return mailTemplate;
    }
    
    public String htmlContent() {
    	if(htmlContent==null) {
    		if(canGetValueForBinding("htmlContent")) {
    			htmlContent = (String) valueForBinding("htmlContent");
    		}
    	}
    	return htmlContent;
    }
    */
    
    public String styleSheet() {
    	return "<style type=\"text/css\">\n" + getMailTemplate().stylesheet() +  "\n</style>";
    }
    
    public String topImage() {
    	return getMailTemplate().top();
    }
    
    public String splashImage() {
    	return getMailTemplate().splash();
    }
    
    public String bottomImage() {
    	return getMailTemplate().bottom();
    }
    
    public String bodyStyle() {
    	return "margin: 0; background-image: url('" + getMailTemplate().bg_pattern() + "')";
    }
    
    public String letterStyle() {
    	return "background-image: url('" + getMailTemplate().bg_letter() + "')";
    }

	public INLocalizedMailTemplate getMailTemplate() {
		return mailTemplate;
	}

	public void setMailTemplate(INLocalizedMailTemplate mailTemplate) {
		this.mailTemplate = mailTemplate;
	}

	public String getHtmlContent() {
		return htmlContent;
	}

	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}
    
}