package com.insigno.inmailmanager.model;

import java.util.Locale;

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
	
	
	public NSSet<Locale> availableLanguages() {
		NSMutableSet<Locale> set = new NSMutableSet<Locale>();
		for (INLocalizedMailTemplate e : this.localizedTemplates()) {
			set.add( Locale.forLanguageTag(e.language()) );
		}
		return set.immutableClone();
	}
	
	
	public INLocalizedMailTemplate getLocalizedTemplate(Locale locale) throws INMailManagerException {
		if(this.availableLanguages().contains(locale)) {
			INLocalizedMailTemplate localizedTemplate = localizedTemplates(ERXQ.is(INLocalizedMailTemplate.LANGUAGE_KEY, locale.toLanguageTag())).objectAtIndex(0);
			return localizedTemplate;
		}
		throw new INMailManagerException("Error getting localized template: '" + locale.getDisplayLanguage() + "' for template named: '" + this.name() + "'");
	}
 	
	
}
