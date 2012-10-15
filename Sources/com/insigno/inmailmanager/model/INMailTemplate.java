package com.insigno.inmailmanager.model;

import org.apache.log4j.Logger;

import sun.security.action.GetLongAction;

import com.insigno.inmailmanager.INMailManagerException;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableSet;
import com.webobjects.foundation.NSSet;
import com.webobjects.foundation.NSTimestamp;

import er.extensions.eof.ERXQ;

public class INMailTemplate extends _INMailTemplate {
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(INMailTemplate.class);
	
	@Override
	protected void init(EOEditingContext ec) {
		super.init(ec);
		this.setCreationDate(new NSTimestamp());
		this.setModificationDate(new NSTimestamp());
	}
	
	
	public NSSet<String> availableLanguages() {
		NSMutableSet<String> set = new NSMutableSet<String>();
		for (INLocalizedMailTemplate e : this.localizedTemplates()) {
			set.add(e.language());
		}
		return set.immutableClone();
	}
	
	
	public INLocalizedMailTemplate getLocalizedTemplate(String language) throws INMailManagerException {
		if(this.availableLanguages().contains(language)) {
			INLocalizedMailTemplate lt = localizedTemplates(ERXQ.is(INLocalizedMailTemplate.LANGUAGE_KEY, language)).objectAtIndex(0);
			return lt;
		}
		throw new INMailManagerException("Error getting localizet template: '" + language + "' for templaten named: '" + this.name() + "'");
	}
 	
	
}
